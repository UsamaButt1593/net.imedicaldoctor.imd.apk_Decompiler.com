package org.checkerframework.checker.nullness.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultFor;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.LiteralKind;
import org.checkerframework.framework.qual.QualifierForLiterals;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TypeKind;
import org.checkerframework.framework.qual.TypeUseLocation;
import org.checkerframework.framework.qual.UpperBoundFor;

@DefaultFor({TypeUseLocation.Z})
@UpperBoundFor(typeKinds = {TypeKind.j3, TypeKind.Z, TypeKind.s, TypeKind.Y2, TypeKind.a3, TypeKind.Z2, TypeKind.X2, TypeKind.Y, TypeKind.X})
@SubtypeOf({MonotonicNonNull.class})
@Documented
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@DefaultQualifierInHierarchy
@Retention(RetentionPolicy.RUNTIME)
@QualifierForLiterals({LiteralKind.a3})
public @interface NonNull {
}
