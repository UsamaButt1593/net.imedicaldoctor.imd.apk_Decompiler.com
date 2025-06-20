package com.bumptech.glide.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface GlideOption {

    /* renamed from: j  reason: collision with root package name */
    public static final int f17741j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static final int f17742k = 1;

    /* renamed from: l  reason: collision with root package name */
    public static final int f17743l = 2;

    boolean memoizeStaticMethod() default false;

    int override() default 0;

    boolean skipStaticMethod() default false;

    String staticMethodName() default "";
}
