// This is a generated file. Not intended for manual editing.
package io.ballerina.plugins.idea.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BallerinaStructuralConstructorExpr extends BallerinaExpression {

  @Nullable
  BallerinaListConstructorExpr getListConstructorExpr();

  @Nullable
  BallerinaMappingConstructorExpr getMappingConstructorExpr();

  @Nullable
  BallerinaTableConstructorExpr getTableConstructorExpr();

}
