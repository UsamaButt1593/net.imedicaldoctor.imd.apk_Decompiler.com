package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import org.jetbrains.annotations.NotNull;

@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.b3, AnnotationTarget.c3, AnnotationTarget.d3, AnnotationTarget.Z2, AnnotationTarget.X2, AnnotationTarget.Y2, AnnotationTarget.X})
@Retention(AnnotationRetention.X)
@Documented
@java.lang.annotation.Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/annotation/Dimension;", "", "", "unit", "<init>", "(I)V", "()I", "a", "Companion", "annotation"}, k = 1, mv = {1, 8, 0})
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
public @interface Dimension {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f2519a = Companion.f2523a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2520b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2521c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f2522d = 2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0006¨\u0006\f"}, d2 = {"Landroidx/annotation/Dimension$Companion;", "", "<init>", "()V", "", "b", "I", "DP", "c", "PX", "d", "SP", "annotation"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f2523a = new Companion();

        /* renamed from: b  reason: collision with root package name */
        public static final int f2524b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static final int f2525c = 1;

        /* renamed from: d  reason: collision with root package name */
        public static final int f2526d = 2;

        private Companion() {
        }
    }

    int unit() default 1;
}
