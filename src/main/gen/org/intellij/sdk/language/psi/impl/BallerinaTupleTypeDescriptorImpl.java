// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.BallerinaTypes.*;
import org.intellij.sdk.language.psi.*;

public class BallerinaTupleTypeDescriptorImpl extends BallerinaTypeDescriptorImpl implements BallerinaTupleTypeDescriptor {

  public BallerinaTupleTypeDescriptorImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull BallerinaVisitor visitor) {
    visitor.visitTupleTypeDescriptor(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BallerinaVisitor) accept((BallerinaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public BallerinaTupleMemberTypeDescriptors getTupleMemberTypeDescriptors() {
    return findNotNullChildByClass(BallerinaTupleMemberTypeDescriptors.class);
  }

}
