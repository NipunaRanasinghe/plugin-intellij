// This is a generated file. Not intended for manual editing.
package io.ballerina.plugins.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BallerinaRemoteMethodQuals extends PsiElement {

  @Nullable
  BallerinaFunctionQuals getFunctionQuals();

  @Nullable
  BallerinaIsolatedQual getIsolatedQual();

  @NotNull
  BallerinaRemoteQual getRemoteQual();

  @Nullable
  BallerinaTransactionalQual getTransactionalQual();

}
