package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.dd.plist.ASCIIPropertyListParser;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \r2\u00020\u0001:\u0002\u001a\u001bB+\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0016\u0010\u0019¨\u0006\u001c"}, d2 = {"Landroidx/activity/BackEventCompat;", "", "", "touchX", "touchY", "progress", "", "swipeEdge", "<init>", "(FFFI)V", "Landroid/window/BackEvent;", "backEvent", "(Landroid/window/BackEvent;)V", "e", "()Landroid/window/BackEvent;", "", "toString", "()Ljava/lang/String;", "a", "F", "c", "()F", "b", "d", "I", "()I", "Companion", "SwipeEdge", "activity_release"}, k = 1, mv = {1, 8, 0})
public final class BackEventCompat {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f2413e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    public static final int f2414f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f2415g = 1;

    /* renamed from: a  reason: collision with root package name */
    private final float f2416a;

    /* renamed from: b  reason: collision with root package name */
    private final float f2417b;

    /* renamed from: c  reason: collision with root package name */
    private final float f2418c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2419d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/activity/BackEventCompat$Companion;", "", "()V", "EDGE_LEFT", "", "EDGE_RIGHT", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @RestrictTo({RestrictTo.Scope.s})
    @Target(allowedTargets = {AnnotationTarget.e3})
    @Retention(AnnotationRetention.s)
    @java.lang.annotation.Target({ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/activity/BackEventCompat$SwipeEdge;", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface SwipeEdge {
    }

    @VisibleForTesting
    public BackEventCompat(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, int i2) {
        this.f2416a = f2;
        this.f2417b = f3;
        this.f2418c = f4;
        this.f2419d = i2;
    }

    public final float a() {
        return this.f2418c;
    }

    public final int b() {
        return this.f2419d;
    }

    public final float c() {
        return this.f2416a;
    }

    public final float d() {
        return this.f2417b;
    }

    @RequiresApi(34)
    @NotNull
    public final BackEvent e() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.f2412a.a(this.f2416a, this.f2417b, this.f2418c, this.f2419d);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 34+");
    }

    @NotNull
    public String toString() {
        return "BackEventCompat{touchX=" + this.f2416a + ", touchY=" + this.f2417b + ", progress=" + this.f2418c + ", swipeEdge=" + this.f2419d + ASCIIPropertyListParser.f18653k;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RequiresApi(34)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BackEventCompat(@org.jetbrains.annotations.NotNull android.window.BackEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "backEvent"
            kotlin.jvm.internal.Intrinsics.p(r5, r0)
            androidx.activity.Api34Impl r0 = androidx.activity.Api34Impl.f2412a
            float r1 = r0.d(r5)
            float r2 = r0.e(r5)
            float r3 = r0.b(r5)
            int r5 = r0.c(r5)
            r4.<init>(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.BackEventCompat.<init>(android.window.BackEvent):void");
    }
}
