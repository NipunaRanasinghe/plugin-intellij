/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

// This is a generated file. Not intended for manual editing.
package io.ballerina.plugins.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.ballerina.plugins.idea.psi.BallerinaTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.ballerina.plugins.idea.psi.*;

public class BallerinaDefinitionImpl extends ASTWrapperPsiElement implements BallerinaDefinition {

  public BallerinaDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BallerinaVisitor visitor) {
    visitor.visitDefinition(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BallerinaVisitor) accept((BallerinaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BallerinaAnnotationDefinition getAnnotationDefinition() {
    return findChildByClass(BallerinaAnnotationDefinition.class);
  }

  @Override
  @Nullable
  public BallerinaConstantDefinition getConstantDefinition() {
    return findChildByClass(BallerinaConstantDefinition.class);
  }

  @Override
  @Nullable
  public BallerinaEnumDefinition getEnumDefinition() {
    return findChildByClass(BallerinaEnumDefinition.class);
  }

  @Override
  @Nullable
  public BallerinaFunctionDefinition getFunctionDefinition() {
    return findChildByClass(BallerinaFunctionDefinition.class);
  }

  @Override
  @Nullable
  public BallerinaGlobalVariableDefinition getGlobalVariableDefinition() {
    return findChildByClass(BallerinaGlobalVariableDefinition.class);
  }

  @Override
  @Nullable
  public BallerinaServiceDefinition getServiceDefinition() {
    return findChildByClass(BallerinaServiceDefinition.class);
  }

  @Override
  @Nullable
  public BallerinaTypeDefinition getTypeDefinition() {
    return findChildByClass(BallerinaTypeDefinition.class);
  }

}
