package org.checkerframework.common.subtyping.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TargetLocations;
import org.checkerframework.framework.qual.TypeUseLocation;

@SubtypeOf({})
@Documented
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@TargetLocations({TypeUseLocation.c3, TypeUseLocation.f3})
public @interface Bottom {
}
