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

package io.ballerina.plugins.idea.widget;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.StatusBarWidget;
import com.intellij.openapi.wm.StatusBarWidgetFactory;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory for creating Ballerina detection widget.
 *
 * @since 2.0.0
 */
public class BallerinaDetectionWidgetFactory implements StatusBarWidgetFactory {

    private static final Map<Project, BallerinaDetectionWidget> widgetForProject = new HashMap<>();

    public static BallerinaDetectionWidget getWidget(Project project) {
        return widgetForProject.get(project);
    }

    @Override
    public @NonNls @NotNull String getId() {
        return "BallerinaDetectionWidget";
    }

    @Override
    public @Nls @NotNull String getDisplayName() {
        return "Ballerina Detection Widget";
    }

    @Override
    public boolean isAvailable(@NotNull Project project) {
        return true;
    }

    @Override
    public @NotNull StatusBarWidget createWidget(@NotNull Project project) {
        return widgetForProject.computeIfAbsent(project, (k) -> new BallerinaDetectionWidget(project));
    }

    @Override
    public void disposeWidget(@NotNull StatusBarWidget statusBarWidget) {
        if (statusBarWidget instanceof BallerinaDetectionWidget) {
            widgetForProject.remove(((BallerinaDetectionWidget) statusBarWidget).getProject());
        }
    }

    @Override
    public boolean canBeEnabledOn(@NotNull StatusBar statusBar) {
        return true;
    }
}
