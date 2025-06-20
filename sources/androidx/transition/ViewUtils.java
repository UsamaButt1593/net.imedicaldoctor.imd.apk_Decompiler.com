package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class ViewUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewUtilsApi19 f16110a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f16111b = "ViewUtils";

    /* renamed from: c  reason: collision with root package name */
    static final Property<View, Float> f16112c = new Property<View, Float>(Float.class, "translationAlpha") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(ViewUtils.b(view));
        }

        /* renamed from: b */
        public void set(View view, Float f2) {
            ViewUtils.f(view, f2.floatValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    static final Property<View, Rect> f16113d = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* renamed from: a */
        public Rect get(View view) {
            return view.getClipBounds();
        }

        /* renamed from: b */
        public void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    };

    static {
        int i2 = Build.VERSION.SDK_INT;
        f16110a = i2 >= 29 ? new ViewUtilsApi29() : i2 >= 23 ? new ViewUtilsApi23() : i2 >= 22 ? new ViewUtilsApi22() : new ViewUtilsApi21();
    }

    private ViewUtils() {
    }

    static void a(@NonNull View view) {
        f16110a.a(view);
    }

    static float b(@NonNull View view) {
        return f16110a.c(view);
    }

    static void c(@NonNull View view) {
        f16110a.d(view);
    }

    static void d(@NonNull View view, @Nullable Matrix matrix) {
        f16110a.e(view, matrix);
    }

    static void e(@NonNull View view, int i2, int i3, int i4, int i5) {
        f16110a.f(view, i2, i3, i4, i5);
    }

    static void f(@NonNull View view, float f2) {
        f16110a.g(view, f2);
    }

    static void g(@NonNull View view, int i2) {
        f16110a.h(view, i2);
    }

    static void h(@NonNull View view, @NonNull Matrix matrix) {
        f16110a.i(view, matrix);
    }

    static void i(@NonNull View view, @NonNull Matrix matrix) {
        f16110a.j(view, matrix);
    }
}
