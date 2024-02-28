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

public class BallerinaXmlStepExtendImpl extends ASTWrapperPsiElement implements BallerinaXmlStepExtend {

  public BallerinaXmlStepExtendImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BallerinaVisitor visitor) {
    visitor.visitXmlStepExtend(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BallerinaVisitor) accept((BallerinaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BallerinaArgList getArgList() {
    return findChildByClass(BallerinaArgList.class);
  }

  @Override
  @Nullable
  public BallerinaExpression getExpression() {
    return findChildByClass(BallerinaExpression.class);
  }

  @Override
  @Nullable
  public BallerinaSpecialMethodName getSpecialMethodName() {
    return findChildByClass(BallerinaSpecialMethodName.class);
  }

  @Override
  @Nullable
  public BallerinaXmlNamePattern getXmlNamePattern() {
    return findChildByClass(BallerinaXmlNamePattern.class);
  }

}
