/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com)
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

package io.ballerina.plugins.idea.psi;

import com.intellij.psi.tree.IElementType;
import io.ballerina.plugins.idea.BallerinaLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a Ballerina-specific element type within the PSI tree, providing a foundation for language constructs
 * in Ballerina files.
 *
 * @since 2.0.0
 */
public class BallerinaElementType extends IElementType {

    public BallerinaElementType(@NotNull @NonNls String debugName) {

        super(debugName, BallerinaLanguage.INSTANCE);
    }
}
