// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.BallerinaTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.sdk.language.psi.*;

public class BallerinaIncludedRecordParamImpl extends ASTWrapperPsiElement implements BallerinaIncludedRecordParam {

  public BallerinaIncludedRecordParamImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BallerinaVisitor visitor) {
    visitor.visitIncludedRecordParam(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BallerinaVisitor) accept((BallerinaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BallerinaAnnots getAnnots() {
    return findChildByClass(BallerinaAnnots.class);
  }

  @Override
  @Nullable
  public BallerinaParamName getParamName() {
    return findChildByClass(BallerinaParamName.class);
  }

  @Override
  @NotNull
  public BallerinaTypeReference getTypeReference() {
    return findNotNullChildByClass(BallerinaTypeReference.class);
  }

}
