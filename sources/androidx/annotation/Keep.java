package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;

@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.g3, AnnotationTarget.X, AnnotationTarget.s, AnnotationTarget.X, AnnotationTarget.a3, AnnotationTarget.b3, AnnotationTarget.c3, AnnotationTarget.d3, AnnotationTarget.X2})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/annotation/Keep;", "", "annotation"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Retention(AnnotationRetention.X)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
public @interface Keep {
}
