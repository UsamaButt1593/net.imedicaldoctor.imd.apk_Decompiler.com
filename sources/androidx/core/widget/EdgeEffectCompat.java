package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class EdgeEffectCompat {

    /* renamed from: a  reason: collision with root package name */
    private final EdgeEffect f6754a;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void a(EdgeEffect edgeEffect, float f2, float f3) {
            edgeEffect.onPull(f2, f3);
        }
    }

    @RequiresApi(31)
    private static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        @DoNotInline
        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        @DoNotInline
        public static float c(EdgeEffect edgeEffect, float f2, float f3) {
            try {
                return edgeEffect.onPullDistance(f2, f3);
            } catch (Throwable unused) {
                edgeEffect.onPull(f2, f3);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.f6754a = new EdgeEffect(context);
    }

    @NonNull
    public static EdgeEffect a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.a(context, attributeSet) : new EdgeEffect(context);
    }

    public static float d(@NonNull EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.b(edgeEffect);
        }
        return 0.0f;
    }

    public static void g(@NonNull EdgeEffect edgeEffect, float f2, float f3) {
        Api21Impl.a(edgeEffect, f2, f3);
    }

    public static float j(@NonNull EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.c(edgeEffect, f2, f3);
        }
        g(edgeEffect, f2, f3);
        return f2;
    }

    @Deprecated
    public boolean b(Canvas canvas) {
        return this.f6754a.draw(canvas);
    }

    @Deprecated
    public void c() {
        this.f6754a.finish();
    }

    @Deprecated
    public boolean e() {
        return this.f6754a.isFinished();
    }

    @Deprecated
    public boolean f(int i2) {
        this.f6754a.onAbsorb(i2);
        return true;
    }

    @Deprecated
    public boolean h(float f2) {
        this.f6754a.onPull(f2);
        return true;
    }

    @Deprecated
    public boolean i(float f2, float f3) {
        g(this.f6754a, f2, f3);
        return true;
    }

    @Deprecated
    public boolean k() {
        this.f6754a.onRelease();
        return this.f6754a.isFinished();
    }

    @Deprecated
    public void l(int i2, int i3) {
        this.f6754a.setSize(i2, i3);
    }
}
