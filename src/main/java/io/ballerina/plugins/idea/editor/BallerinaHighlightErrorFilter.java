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

package io.ballerina.plugins.idea.editor;

import com.intellij.codeInsight.highlighting.HighlightErrorFilter;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiFile;
import io.ballerina.plugins.idea.BallerinaLanguage;
import org.jetbrains.annotations.NotNull;

/**
 * Error highlighting filter implementation to ignore syntax error added by the plugin parser (Since both syntax and
 * semantic errors are already provided by the ballerina language server).
 *
 * @since 2.0.0
 */
public class BallerinaHighlightErrorFilter extends HighlightErrorFilter {

    private static final Logger LOG = Logger.getInstance(BallerinaHighlightErrorFilter.class);

    @Override
    public boolean shouldHighlightErrorElement(@NotNull PsiErrorElement element) {
        try {
            final PsiFile containingFile = element.getContainingFile();
            final String extension = containingFile.getVirtualFile().getExtension();
            return containingFile.getLanguage() != BallerinaLanguage.INSTANCE
                    && (extension == null || !extension.equals("bal"));
        } catch (Exception e) {
            LOG.warn("Error occurred when trying to filter plugin error highlighting.");
            return true;
        }
    }
}
