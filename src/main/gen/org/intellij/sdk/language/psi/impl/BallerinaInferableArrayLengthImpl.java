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

public class BallerinaInferableArrayLengthImpl extends ASTWrapperPsiElement implements BallerinaInferableArrayLength {

  public BallerinaInferableArrayLengthImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BallerinaVisitor visitor) {
    visitor.visitInferableArrayLength(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BallerinaVisitor) accept((BallerinaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BallerinaArrayLength getArrayLength() {
    return findChildByClass(BallerinaArrayLength.class);
  }

  @Override
  @Nullable
  public BallerinaInferredArrayLength getInferredArrayLength() {
    return findChildByClass(BallerinaInferredArrayLength.class);
  }

}
