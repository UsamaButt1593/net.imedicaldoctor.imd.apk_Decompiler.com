package androidx.core.util;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class Preconditions {
    private Preconditions() {
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z, @NonNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void c(boolean z, @NonNull String str, @NonNull Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static float d(float f2, @NonNull String str) {
        if (Float.isNaN(f2)) {
            throw new IllegalArgumentException(str + " must not be NaN");
        } else if (!Float.isInfinite(f2)) {
            return f2;
        } else {
            throw new IllegalArgumentException(str + " must not be infinite");
        }
    }

    public static double e(double d2, double d3, double d4, @NonNull String str) {
        if (d2 < d3) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{str, Double.valueOf(d3), Double.valueOf(d4)}));
        } else if (d2 <= d4) {
            return d2;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{str, Double.valueOf(d3), Double.valueOf(d4)}));
        }
    }

    public static float f(float f2, float f3, float f4, @NonNull String str) {
        if (f2 < f3) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{str, Float.valueOf(f3), Float.valueOf(f4)}));
        } else if (f2 <= f4) {
            return f2;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{str, Float.valueOf(f3), Float.valueOf(f4)}));
        }
    }

    public static int g(int i2, int i3, int i4, @NonNull String str) {
        if (i2 < i3) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i4)}));
        } else if (i2 <= i4) {
            return i2;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i4)}));
        }
    }

    public static long h(long j2, long j3, long j4, @NonNull String str) {
        if (j2 < j3) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Long.valueOf(j3), Long.valueOf(j4)}));
        } else if (j2 <= j4) {
            return j2;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Long.valueOf(j3), Long.valueOf(j4)}));
        }
    }

    @IntRange(from = 0)
    public static int i(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    @IntRange(from = 0)
    public static int j(int i2, @Nullable String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str);
    }

    public static int k(int i2, int i3) {
        if ((i2 & i3) == i2) {
            return i2;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(i3) + " are allowed");
    }

    @NonNull
    public static <T> T l(@Nullable T t) {
        t.getClass();
        return t;
    }

    @NonNull
    public static <T> T m(@Nullable T t, @NonNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void n(boolean z) {
        o(z, (String) null);
    }

    public static void o(boolean z, @Nullable String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    public static <T extends CharSequence> T p(@Nullable T t) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T extends CharSequence> T q(@Nullable T t, @NonNull Object obj) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @NonNull
    public static <T extends CharSequence> T r(@Nullable T t, @NonNull String str, @NonNull Object... objArr) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }
}
