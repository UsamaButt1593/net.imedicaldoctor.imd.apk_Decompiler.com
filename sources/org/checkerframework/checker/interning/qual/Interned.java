package org.checkerframework.checker.interning.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultFor;
import org.checkerframework.framework.qual.LiteralKind;
import org.checkerframework.framework.qual.QualifierForLiterals;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TypeKind;

@DefaultFor(typeKinds = {TypeKind.s, TypeKind.X, TypeKind.Y2, TypeKind.a3, TypeKind.Z2, TypeKind.Z, TypeKind.X2, TypeKind.Y})
@SubtypeOf({UnknownInterned.class})
@Documented
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@QualifierForLiterals({LiteralKind.c3, LiteralKind.a3})
public @interface Interned {
}
