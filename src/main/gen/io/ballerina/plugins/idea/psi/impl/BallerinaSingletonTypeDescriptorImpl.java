// This is a generated file. Not intended for manual editing.
package io.ballerina.plugins.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.ballerina.plugins.idea.psi.BallerinaTypes.*;
import io.ballerina.plugins.idea.psi.*;

public class BallerinaSingletonTypeDescriptorImpl extends BallerinaTypeDescriptorImpl implements BallerinaSingletonTypeDescriptor {

  public BallerinaSingletonTypeDescriptorImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull BallerinaVisitor visitor) {
    visitor.visitSingletonTypeDescriptor(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BallerinaVisitor) accept((BallerinaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public BallerinaSimpleConstExpr getSimpleConstExpr() {
    return findNotNullChildByClass(BallerinaSimpleConstExpr.class);
  }

}
