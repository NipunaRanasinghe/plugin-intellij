/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.ballerina.plugins.idea.runconfig.test;

import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProvider;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.runners.ExecutionEnvironmentBuilder;
import com.intellij.openapi.editor.markup.GutterIconRenderer;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import io.ballerina.plugins.idea.BallerinaIcons;
import io.ballerina.plugins.idea.project.BallerinaProjectUtils;
import io.ballerina.plugins.idea.psi.BallerinaPsiUtil;
import io.ballerina.plugins.idea.sdk.BallerinaSdkService;
import io.ballerina.plugins.idea.sdk.BallerinaSdkUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.Cursor;
import java.nio.file.Paths;
import java.util.Optional;

import static io.ballerina.plugins.idea.BallerinaConstants.BAL_EXTENSION;
import static io.ballerina.plugins.idea.BallerinaConstants.EMPTY_STRING;

/**
 * Provides gutter icons for test functions.
 *
 * @since 2.0.0
 */
public class BallerinaTestLineMarkerProvider implements LineMarkerProvider {

    @Nullable
    @Override
    public LineMarkerInfo getLineMarkerInfo(@NotNull PsiElement element) {
        String version = BallerinaSdkService.getInstance().getBallerinaVersion(element.getProject());
        if (version != null && BallerinaPsiUtil.isTestFunction(element)
                && (BallerinaProjectUtils.isPackageTest(element) || BallerinaProjectUtils.isModuleTest(element))) {
            return createTestLineMarkerInfo(element);
        }
        return null;
    }

    private LineMarkerInfo createTestLineMarkerInfo(@NotNull PsiElement element) {
        PsiFile containingFile = element.getContainingFile();
        VirtualFile virtualFile = containingFile != null ? containingFile.getVirtualFile() : null;
        String packageName;
        if (virtualFile != null) {
            String path = virtualFile.getPath();
            Optional<String> packagePath = BallerinaProjectUtils.findBallerinaPackage(path);
            packageName = packagePath.map(s -> Paths.get(s).normalize().getFileName().toString()).orElse(EMPTY_STRING);
        } else {
            packageName = EMPTY_STRING;
        }

        String moduleName;
        if (virtualFile != null) {
            if (BallerinaProjectUtils.isModuleTest(element)) {
                Optional<String> module = BallerinaProjectUtils.getModuleName(element);
                moduleName = module.orElse(EMPTY_STRING);
            } else {
                moduleName = EMPTY_STRING;
            }
        } else {
            moduleName = EMPTY_STRING;
        }

        return new LineMarkerInfo<>(element, element.getTextRange(), BallerinaIcons.TEST,
                psiElement -> "Test " + "\"" + BallerinaPsiUtil.getFunctionName(element) + "\"",
                (e, elt) -> {
                    e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                    Project project = elt.getProject();
                    VirtualFile file = elt.getContainingFile().getVirtualFile();

                    if (file != null && file.getName().endsWith(BAL_EXTENSION)) {

                        RunManager runManager = RunManager.getInstance(project);
                        String configName = !packageName.isEmpty() ? packageName : "finalFileName";
                        String temp = configName.endsWith(BAL_EXTENSION)
                                ? configName.substring(0, configName.length() - BAL_EXTENSION.length()) : configName;
                        RunnerAndConfigurationSettings settings =
                                runManager.createConfiguration(temp, BallerinaTestConfigurationType.class);
                        BallerinaTestConfiguration testConfiguration =
                                (BallerinaTestConfiguration) settings.getConfiguration();
                        String script = BallerinaSdkUtils.getNormalizedPath(file.getPath());
                        Optional<String> ballerinaPackage = BallerinaProjectUtils.findBallerinaPackage(script);
                        if (ballerinaPackage.isPresent()) {
                            script = ballerinaPackage.get();
                        }
                        testConfiguration.setSourcePath(script);
                        if (BallerinaProjectUtils.isModuleTest(element)) {
                            testConfiguration.addCommand("--tests");
                            String source = packageName + "." + moduleName + ":"
                                    + BallerinaPsiUtil.getFunctionName(element);
                            testConfiguration.setSource(source);
                        } else {
                            testConfiguration.addCommand("--tests");
                            String source = BallerinaPsiUtil.getFunctionName(element);
                            testConfiguration.setSource(source);

                        }

                        try {
                            ExecutionEnvironmentBuilder.create(project, DefaultRunExecutor.getRunExecutorInstance(),
                                    testConfiguration).buildAndExecute();
                        } catch (ExecutionException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }, GutterIconRenderer.Alignment.CENTER, () ->
                        "Test " + "\"" + BallerinaPsiUtil.getFunctionName(element) + "\""
        );
    }
}
