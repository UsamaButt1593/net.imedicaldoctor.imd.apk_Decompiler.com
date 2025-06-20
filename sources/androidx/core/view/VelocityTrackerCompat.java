package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class VelocityTrackerCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Map<VelocityTracker, VelocityTrackerFallback> f6480a = Collections.synchronizedMap(new WeakHashMap());

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static float a(VelocityTracker velocityTracker, int i2) {
            return velocityTracker.getAxisVelocity(i2);
        }

        @DoNotInline
        static float b(VelocityTracker velocityTracker, int i2, int i3) {
            return velocityTracker.getAxisVelocity(i2, i3);
        }

        @DoNotInline
        static boolean c(VelocityTracker velocityTracker, int i2) {
            return velocityTracker.isAxisSupported(i2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface VelocityTrackableMotionEventAxis {
    }

    private VelocityTrackerCompat() {
    }

    public static void a(@NonNull VelocityTracker velocityTracker, @NonNull MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!f6480a.containsKey(velocityTracker)) {
                f6480a.put(velocityTracker, new VelocityTrackerFallback());
            }
            f6480a.get(velocityTracker).a(motionEvent);
        }
    }

    public static void b(@NonNull VelocityTracker velocityTracker) {
        velocityTracker.clear();
        l(velocityTracker);
    }

    public static void c(@NonNull VelocityTracker velocityTracker, int i2) {
        d(velocityTracker, i2, Float.MAX_VALUE);
    }

    public static void d(@NonNull VelocityTracker velocityTracker, int i2, float f2) {
        velocityTracker.computeCurrentVelocity(i2, f2);
        VelocityTrackerFallback g2 = g(velocityTracker);
        if (g2 != null) {
            g2.d(i2, f2);
        }
    }

    public static float e(@NonNull VelocityTracker velocityTracker, int i2) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.a(velocityTracker, i2);
        }
        if (i2 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i2 == 1) {
            return velocityTracker.getYVelocity();
        }
        VelocityTrackerFallback g2 = g(velocityTracker);
        if (g2 != null) {
            return g2.e(i2);
        }
        return 0.0f;
    }

    public static float f(@NonNull VelocityTracker velocityTracker, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.b(velocityTracker, i2, i3);
        }
        if (i2 == 0) {
            return velocityTracker.getXVelocity(i3);
        }
        if (i2 == 1) {
            return velocityTracker.getYVelocity(i3);
        }
        return 0.0f;
    }

    @Nullable
    private static VelocityTrackerFallback g(VelocityTracker velocityTracker) {
        return f6480a.get(velocityTracker);
    }

    @Deprecated
    public static float h(VelocityTracker velocityTracker, int i2) {
        return velocityTracker.getXVelocity(i2);
    }

    @Deprecated
    public static float i(VelocityTracker velocityTracker, int i2) {
        return velocityTracker.getYVelocity(i2);
    }

    public static boolean j(@NonNull VelocityTracker velocityTracker, int i2) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.c(velocityTracker, i2);
        }
        return i2 == 26 || i2 == 0 || i2 == 1;
    }

    public static void k(@NonNull VelocityTracker velocityTracker) {
        velocityTracker.recycle();
        l(velocityTracker);
    }

    private static void l(VelocityTracker velocityTracker) {
        f6480a.remove(velocityTracker);
    }
}
