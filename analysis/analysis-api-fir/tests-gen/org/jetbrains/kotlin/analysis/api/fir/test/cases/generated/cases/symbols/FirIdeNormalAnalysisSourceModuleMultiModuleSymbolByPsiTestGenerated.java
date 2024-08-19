/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.symbols;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.fir.test.configurators.AnalysisApiFirTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.symbols.AbstractMultiModuleSymbolByPsiTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisSourceModuleMultiModuleSymbolByPsiTestGenerated extends AbstractMultiModuleSymbolByPsiTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Ide
      )
    );
  }

  @Test
  @TestMetadata("actualAccessors.kt")
  public void testActualAccessors() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/actualAccessors.kt");
  }

  @Test
  @TestMetadata("actualDefaultAccessors.kt")
  public void testActualDefaultAccessors() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/actualDefaultAccessors.kt");
  }

  @Test
  @TestMetadata("actualPropertyAccessors.kt")
  public void testActualPropertyAccessors() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/actualPropertyAccessors.kt");
  }

  @Test
  @TestMetadata("actualPropertyDefaultAccessors.kt")
  public void testActualPropertyDefaultAccessors() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/actualPropertyDefaultAccessors.kt");
  }

  @Test
  @TestMetadata("actualPropertyExplicitDefaultAccessors.kt")
  public void testActualPropertyExplicitDefaultAccessors() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/actualPropertyExplicitDefaultAccessors.kt");
  }

  @Test
  public void testAllFilesPresentInMultiModuleSymbolByPsi() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("expectAccessors.kt")
  public void testExpectAccessors() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/expectAccessors.kt");
  }

  @Test
  @TestMetadata("expectActual.kt")
  public void testExpectActual() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/expectActual.kt");
  }

  @Test
  @TestMetadata("expectDefaultAccessors.kt")
  public void testExpectDefaultAccessors() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/expectDefaultAccessors.kt");
  }

  @Test
  @TestMetadata("expectPropertyAccessors.kt")
  public void testExpectPropertyAccessors() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/expectPropertyAccessors.kt");
  }

  @Test
  @TestMetadata("expectPropertyDefaultAccessors.kt")
  public void testExpectPropertyDefaultAccessors() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/expectPropertyDefaultAccessors.kt");
  }

  @Test
  @TestMetadata("expectPropertyExplicitDefaultAccessors.kt")
  public void testExpectPropertyExplicitDefaultAccessors() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/expectPropertyExplicitDefaultAccessors.kt");
  }

  @Test
  @TestMetadata("independentModulesWithGloballyDuplicateJavaLibrary.kt")
  public void testIndependentModulesWithGloballyDuplicateJavaLibrary() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/independentModulesWithGloballyDuplicateJavaLibrary.kt");
  }

  @Test
  @TestMetadata("independentModulesWithGloballyDuplicateLibrary.kt")
  public void testIndependentModulesWithGloballyDuplicateLibrary() {
    runTest("analysis/analysis-api/testData/symbols/multiModuleSymbolByPsi/independentModulesWithGloballyDuplicateLibrary.kt");
  }
}
