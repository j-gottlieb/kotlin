/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir

import org.jetbrains.kotlin.KtSourceFile
import org.jetbrains.kotlin.builtins.DefaultBuiltIns
import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.diagnostics.DiagnosticReporterFactory
import org.jetbrains.kotlin.diagnostics.KtDiagnostic
import org.jetbrains.kotlin.fir.backend.*
import org.jetbrains.kotlin.fir.backend.jvm.FirJvmVisibilityConverter
import org.jetbrains.kotlin.fir.declarations.FirFile
import org.jetbrains.kotlin.fir.pipeline.*
import org.jetbrains.kotlin.fir.resolve.ScopeSession
import org.jetbrains.kotlin.ir.backend.jvm.serialization.JvmIrMangler
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.test.FirParser

abstract class AbstractFirAnalyzerFacade {
    abstract val scopeSession: ScopeSession
    abstract fun runCheckers(): Map<FirFile, List<KtDiagnostic>>

    abstract fun runResolution(): List<FirFile>

    abstract fun convertToIr(
        fir2IrExtensions: Fir2IrExtensions,
        commonMemberStorage: Fir2IrCommonMemberStorage,
        irBuiltIns: IrBuiltInsOverFir?
    ): Fir2IrResult
}

class FirAnalyzerFacade(
    val session: FirSession,
    val fir2IrConfiguration: Fir2IrConfiguration,
    val ktFiles: Collection<KtFile> = emptyList(), // may be empty if light tree mode enabled
    val lightTreeFiles: Collection<KtSourceFile> = emptyList(), // may be empty if light tree mode disabled
    val parser: FirParser,
    val diagnosticReporterForLightTree: DiagnosticReporter? = null
) : AbstractFirAnalyzerFacade() {
    private var firFiles: List<FirFile>? = null
    private var _scopeSession: ScopeSession? = null
    override val scopeSession: ScopeSession
        get() = _scopeSession!!

    private var collectedDiagnostics: Map<FirFile, List<KtDiagnostic>>? = null

    private fun buildRawFir() {
        if (firFiles != null) return
        firFiles = when (parser) {
            FirParser.LightTree -> session.buildFirViaLightTree(lightTreeFiles, diagnosticReporterForLightTree)
            FirParser.Psi -> session.buildFirFromKtFiles(ktFiles)
        }
    }

    override fun runResolution(): List<FirFile> {
        if (firFiles == null) buildRawFir()
        if (_scopeSession != null) return firFiles!!
        _scopeSession = session.runResolution(firFiles!!).first
        return firFiles!!
    }

    override fun runCheckers(): Map<FirFile, List<KtDiagnostic>> {
        if (_scopeSession == null) runResolution()
        if (collectedDiagnostics != null) return collectedDiagnostics!!
        collectedDiagnostics = session.runCheckers(scopeSession, firFiles!!, DiagnosticReporterFactory.createPendingReporter())
        return collectedDiagnostics!!
    }

    override fun convertToIr(
        fir2IrExtensions: Fir2IrExtensions,
        commonMemberStorage: Fir2IrCommonMemberStorage,
        irBuiltIns: IrBuiltInsOverFir?
    ): Fir2IrResult {
        if (_scopeSession == null) runResolution()

        return ModuleCompilerAnalyzedOutput(this.session, this.scopeSession, firFiles!!.toList()).convertToIr(
            fir2IrExtensions,
            fir2IrConfiguration,
            commonMemberStorage,
            irBuiltIns,
            JvmIrMangler,
            FirJvmVisibilityConverter,
            DefaultBuiltIns.Instance
        )
    }
}
