package org.checkerframework.checker.lock.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultFor;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.JavaExpression;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TypeKind;
import org.checkerframework.framework.qual.TypeUseLocation;
import org.checkerframework.framework.qual.UpperBoundFor;

@DefaultFor(typeKinds = {TypeKind.s, TypeKind.X, TypeKind.Y2, TypeKind.a3, TypeKind.Z2, TypeKind.Z, TypeKind.X2, TypeKind.Y}, types = {String.class, Void.class}, value = {TypeUseLocation.Z, TypeUseLocation.e3})
@UpperBoundFor(typeKinds = {TypeKind.s, TypeKind.X, TypeKind.Y2, TypeKind.a3, TypeKind.Z2, TypeKind.Z, TypeKind.X2, TypeKind.Y}, types = {String.class})
@SubtypeOf({GuardedByUnknown.class})
@Documented
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@DefaultQualifierInHierarchy
@Retention(RetentionPolicy.RUNTIME)
public @interface GuardedBy {
    @JavaExpression
    String[] value() default {};
}
