package org.intellij.lang.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.jetbrains.annotations.NonNls;

@Documented
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface Flow {
    @NonNls
    public static final String T = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";
    @NonNls
    public static final String U = "this";
    @NonNls
    public static final String V = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";
    @NonNls
    public static final String W = "The return value of this method";
    @NonNls
    public static final String X = "this";

    String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    boolean sourceIsContainer() default false;

    String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    boolean targetIsContainer() default false;
}
