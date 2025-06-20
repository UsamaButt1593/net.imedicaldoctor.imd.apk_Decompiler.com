package androidx.annotation;

import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/annotation/VisibleForTesting;", "", "", "otherwise", "<init>", "(I)V", "()I", "e", "Companion", "annotation"}, k = 1, mv = {1, 8, 0})
@Retention(AnnotationRetention.X)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
public @interface VisibleForTesting {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f2527e = Companion.f2532a;

    /* renamed from: f  reason: collision with root package name */
    public static final int f2528f = 2;

    /* renamed from: g  reason: collision with root package name */
    public static final int f2529g = 3;

    /* renamed from: h  reason: collision with root package name */
    public static final int f2530h = 4;

    /* renamed from: i  reason: collision with root package name */
    public static final int f2531i = 5;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0006¨\u0006\u000e"}, d2 = {"Landroidx/annotation/VisibleForTesting$Companion;", "", "<init>", "()V", "", "b", "I", "PRIVATE", "c", "PACKAGE_PRIVATE", "d", "PROTECTED", "e", "NONE", "annotation"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f2532a = new Companion();

        /* renamed from: b  reason: collision with root package name */
        public static final int f2533b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f2534c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f2535d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f2536e = 5;

        private Companion() {
        }
    }

    int otherwise() default 2;
}
