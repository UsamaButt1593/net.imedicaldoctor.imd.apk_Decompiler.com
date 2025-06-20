package com.google.errorprone.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD})
@IncompatibleModifiers(modifier = {Modifier.s, Modifier.Y, Modifier.Y2, Modifier.Z2})
@Retention(RetentionPolicy.CLASS)
public @interface ForOverride {
}
