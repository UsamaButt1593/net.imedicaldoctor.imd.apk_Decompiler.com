package io.reactivex.rxjava3.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SchedulerSupport {
    public static final String M = "none";
    public static final String N = "custom";
    public static final String O = "io.reactivex:computation";
    public static final String P = "io.reactivex:io";
    public static final String Q = "io.reactivex:new-thread";
    public static final String R = "io.reactivex:trampoline";
    public static final String S = "io.reactivex:single";

    String value();
}
