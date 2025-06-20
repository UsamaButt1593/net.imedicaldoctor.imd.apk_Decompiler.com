package androidx.core.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TypedValueCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final float f6323a = 0.013888889f;

    /* renamed from: b  reason: collision with root package name */
    private static final float f6324b = 0.03937008f;

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static float a(int i2, float f2, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i2, f2, displayMetrics);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float a(int i2, float f2, @NonNull DisplayMetrics displayMetrics) {
        float f3;
        float f4;
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.a(i2, f2, displayMetrics);
        }
        if (i2 == 0) {
            return f2;
        }
        if (i2 == 1) {
            float f5 = displayMetrics.density;
            if (f5 == 0.0f) {
                return 0.0f;
            }
            return f2 / f5;
        } else if (i2 != 2) {
            if (i2 == 3) {
                float f6 = displayMetrics.xdpi;
                if (f6 == 0.0f) {
                    return 0.0f;
                }
                f3 = f2 / f6;
                f4 = f6323a;
            } else if (i2 == 4) {
                float f7 = displayMetrics.xdpi;
                if (f7 == 0.0f) {
                    return 0.0f;
                }
                return f2 / f7;
            } else if (i2 == 5) {
                float f8 = displayMetrics.xdpi;
                if (f8 == 0.0f) {
                    return 0.0f;
                }
                f3 = f2 / f8;
                f4 = f6324b;
            } else {
                throw new IllegalArgumentException("Invalid unitToConvertTo " + i2);
            }
            return f3 / f4;
        } else {
            float f9 = displayMetrics.scaledDensity;
            if (f9 == 0.0f) {
                return 0.0f;
            }
            return f2 / f9;
        }
    }

    public static float b(float f2, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f2, displayMetrics);
    }

    @SuppressLint({"WrongConstant"})
    public static int c(int i2) {
        return i2 & 15;
    }

    public static float d(float f2, @NonNull DisplayMetrics displayMetrics) {
        return a(1, f2, displayMetrics);
    }

    public static float e(float f2, @NonNull DisplayMetrics displayMetrics) {
        return a(2, f2, displayMetrics);
    }

    public static float f(float f2, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f2, displayMetrics);
    }
}
