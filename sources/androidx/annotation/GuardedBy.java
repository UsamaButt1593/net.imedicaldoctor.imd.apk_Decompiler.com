package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;

@Target({ElementType.FIELD, ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.X2, AnnotationTarget.b3, AnnotationTarget.c3, AnnotationTarget.d3})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/annotation/GuardedBy;", "", "value", "", "()Ljava/lang/String;", "annotation"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Retention(AnnotationRetention.X)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
public @interface GuardedBy {
    String value();
}
