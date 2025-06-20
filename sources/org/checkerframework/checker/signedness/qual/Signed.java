package org.checkerframework.checker.signedness.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultFor;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TypeKind;
import org.checkerframework.framework.qual.TypeUseLocation;
import org.checkerframework.framework.qual.UpperBoundFor;

@DefaultFor(typeKinds = {TypeKind.X, TypeKind.Z, TypeKind.X2, TypeKind.Y, TypeKind.Z2, TypeKind.a3}, types = {Byte.class, Integer.class, Long.class, Short.class, Float.class, Double.class}, value = {TypeUseLocation.Z})
@UpperBoundFor(typeKinds = {TypeKind.Z2, TypeKind.a3}, types = {Float.class, Double.class})
@SubtypeOf({UnknownSignedness.class})
@Documented
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@DefaultQualifierInHierarchy
@Retention(RetentionPolicy.RUNTIME)
public @interface Signed {
}
