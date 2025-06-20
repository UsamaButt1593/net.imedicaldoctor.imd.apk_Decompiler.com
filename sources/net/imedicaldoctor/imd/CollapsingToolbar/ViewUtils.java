package net.imedicaldoctor.imd.CollapsingToolbar;

import android.graphics.PorterDuff;
import java.util.Objects;
import net.imedicaldoctor.imd.CollapsingToolbar.ValueAnimatorCompat;

class ViewUtils {

    /* renamed from: a  reason: collision with root package name */
    static final ValueAnimatorCompat.Creator f29536a = new ValueAnimatorCompat.Creator() {
        public ValueAnimatorCompat c() {
            return new ValueAnimatorCompat(new ValueAnimatorCompatImplHoneycombMr1());
        }
    };

    ViewUtils() {
    }

    static ValueAnimatorCompat a() {
        return f29536a.c();
    }

    static boolean b(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    static PorterDuff.Mode c(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (i2 != 14) {
            return i2 != 15 ? mode : PorterDuff.Mode.SCREEN;
        }
        return PorterDuff.Mode.MULTIPLY;
    }
}
