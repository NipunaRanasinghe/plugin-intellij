// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BallerinaFunctionDefn extends PsiElement {

  @Nullable
  BallerinaFunctionDefnBody getFunctionDefnBody();

  @Nullable
  BallerinaFunctionQuals getFunctionQuals();

  @Nullable
  BallerinaFunctionSignature getFunctionSignature();

  @Nullable
  BallerinaFunctionTypeDescriptor getFunctionTypeDescriptor();

  @NotNull
  BallerinaMetadata getMetadata();

}
