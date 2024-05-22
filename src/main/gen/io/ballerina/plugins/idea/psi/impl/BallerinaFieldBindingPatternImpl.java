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

public class BallerinaFieldBindingPatternImpl extends ASTWrapperPsiElement implements BallerinaFieldBindingPattern {

  public BallerinaFieldBindingPatternImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BallerinaVisitor visitor) {
    visitor.visitFieldBindingPattern(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BallerinaVisitor) accept((BallerinaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BallerinaBindingPattern getBindingPattern() {
    return findChildByClass(BallerinaBindingPattern.class);
  }

  @Override
  @Nullable
  public BallerinaFieldName getFieldName() {
    return findChildByClass(BallerinaFieldName.class);
  }

  @Override
  @Nullable
  public BallerinaVariableName getVariableName() {
    return findChildByClass(BallerinaVariableName.class);
  }

}
