package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.s, AnnotationTarget.X, AnnotationTarget.Z, AnnotationTarget.X2, AnnotationTarget.Y2, AnnotationTarget.Z2, AnnotationTarget.a3, AnnotationTarget.b3, AnnotationTarget.c3, AnnotationTarget.d3, AnnotationTarget.h3})
@RequiresOptIn
@Retention(AnnotationRetention.X)
@Documented
@java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lkotlin/ExperimentalMultiplatform;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
public @interface ExperimentalMultiplatform {
}
