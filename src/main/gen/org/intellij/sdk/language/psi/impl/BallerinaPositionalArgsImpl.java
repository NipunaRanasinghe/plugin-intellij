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

public class BallerinaPositionalArgsImpl extends ASTWrapperPsiElement implements BallerinaPositionalArgs {

  public BallerinaPositionalArgsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BallerinaVisitor visitor) {
    visitor.visitPositionalArgs(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BallerinaVisitor) accept((BallerinaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<BallerinaNamedArg> getNamedArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BallerinaNamedArg.class);
  }

  @Override
  @NotNull
  public List<BallerinaPositionalArg> getPositionalArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BallerinaPositionalArg.class);
  }

}
