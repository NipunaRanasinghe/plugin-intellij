// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BallerinaObjectField extends PsiElement {

  @Nullable
  BallerinaFieldInitializer getFieldInitializer();

  @NotNull
  BallerinaFieldName getFieldName();

  @NotNull
  BallerinaMetadata getMetadata();

  @Nullable
  BallerinaObjectVisibilityQual getObjectVisibilityQual();

  @NotNull
  BallerinaTypeDescriptor getTypeDescriptor();

}
