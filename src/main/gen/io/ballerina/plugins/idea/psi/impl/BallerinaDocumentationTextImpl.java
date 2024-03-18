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

public class BallerinaDocumentationTextImpl extends ASTWrapperPsiElement implements BallerinaDocumentationText {

  public BallerinaDocumentationTextImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BallerinaVisitor visitor) {
    visitor.visitDocumentationText(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BallerinaVisitor) accept((BallerinaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<BallerinaBacktickedBlock> getBacktickedBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BallerinaBacktickedBlock.class);
  }

  @Override
  @NotNull
  public List<BallerinaDocumentationReference> getDocumentationReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BallerinaDocumentationReference.class);
  }

  @Override
  @NotNull
  public List<BallerinaDocumentationTextContent> getDocumentationTextContentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BallerinaDocumentationTextContent.class);
  }

  @Override
  @NotNull
  public List<BallerinaReferenceType> getReferenceTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BallerinaReferenceType.class);
  }

}
