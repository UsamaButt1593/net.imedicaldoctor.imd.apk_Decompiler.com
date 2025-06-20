package com.itextpdf.tool.xml;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface Experimental {
    String value() default "";
}
