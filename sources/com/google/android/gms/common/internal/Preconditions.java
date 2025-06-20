package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.zzb;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.FormatMethod;
import com.google.errorprone.annotations.FormatString;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@KeepForSdk
public final class Preconditions {
    private Preconditions() {
        throw new AssertionError("Uninstantiable");
    }

    static String A(String str, Object... objArr) {
        int indexOf;
        StringBuilder sb = new StringBuilder(str.length() + 48);
        int i2 = 0;
        int i3 = 0;
        while (i2 < 3 && (indexOf = str.indexOf("%s", i3)) != -1) {
            sb.append(str.substring(i3, indexOf));
            sb.append(objArr[i2]);
            int i4 = i2 + 1;
            i3 = indexOf + 2;
            i2 = i4;
        }
        sb.append(str.substring(i3));
        if (i2 < 3) {
            sb.append(" [");
            sb.append(objArr[i2]);
            for (int i5 = i2 + 1; i5 < 3; i5++) {
                sb.append(", ");
                sb.append(objArr[i5]);
            }
            sb.append("]");
        }
        return sb.toString();
    }

    @KeepForSdk
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    @KeepForSdk
    public static void b(boolean z, @NonNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void c(boolean z, @NonNull String str, @NonNull Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @KeepForSdk
    public static double d(double d2, double d3, double d4, @NonNull String str) {
        if (d2 < d3) {
            throw new IllegalArgumentException(A("%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d3), Double.valueOf(d4)));
        } else if (d2 <= d4) {
            return d2;
        } else {
            throw new IllegalArgumentException(A("%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d3), Double.valueOf(d4)));
        }
    }

    @KeepForSdk
    public static float e(float f2, float f3, float f4, @NonNull String str) {
        if (f2 < f3) {
            throw new IllegalArgumentException(A("%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f3), Float.valueOf(f4)));
        } else if (f2 <= f4) {
            return f2;
        } else {
            throw new IllegalArgumentException(A("%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f3), Float.valueOf(f4)));
        }
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static int f(int i2, int i3, int i4, @NonNull String str) {
        if (i2 < i3) {
            throw new IllegalArgumentException(A("%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i3), Integer.valueOf(i4)));
        } else if (i2 <= i4) {
            return i2;
        } else {
            throw new IllegalArgumentException(A("%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
    }

    @KeepForSdk
    public static long g(long j2, long j3, long j4, @NonNull String str) {
        if (j2 < j3) {
            throw new IllegalArgumentException(A("%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j3), Long.valueOf(j4)));
        } else if (j2 <= j4) {
            return j2;
        } else {
            throw new IllegalArgumentException(A("%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j3), Long.valueOf(j4)));
        }
    }

    @KeepForSdk
    public static void h(@NonNull Handler handler) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            throw new IllegalStateException("Must be called on " + name2 + " thread, but got " + name + ".");
        }
    }

    @KeepForSdk
    public static void i(@NonNull Handler handler, @NonNull String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    public static void j() {
        k("Must be called on the main application thread");
    }

    @KeepForSdk
    public static void k(@NonNull String str) {
        if (!zzb.a()) {
            throw new IllegalStateException(str);
        }
    }

    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    @NonNull
    @KeepForSdk
    public static String l(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    @NonNull
    @KeepForSdk
    public static String m(@Nullable String str, @NonNull Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    public static void n() {
        o("Must not be called on GoogleApiHandler thread.");
    }

    @KeepForSdk
    public static void o(@NonNull String str) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            String name = myLooper.getThread().getName();
            if (name == "GoogleApiHandler" || (name != null && name.equals("GoogleApiHandler"))) {
                throw new IllegalStateException(str);
            }
        }
    }

    @KeepForSdk
    public static void p() {
        q("Must not be called on the main application thread");
    }

    @KeepForSdk
    public static void q(@NonNull String str) {
        if (zzb.a()) {
            throw new IllegalStateException(str);
        }
    }

    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    @NonNull
    @KeepForSdk
    public static <T> T r(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    @CanIgnoreReturnValue
    @EnsuresNonNull({"#1"})
    @NonNull
    @KeepForSdk
    public static <T> T s(@NonNull T t, @NonNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static int t(int i2) {
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static int u(int i2, @NonNull Object obj) {
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static long v(long j2) {
        if (j2 != 0) {
            return j2;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    @KeepForSdk
    @CanIgnoreReturnValue
    public static long w(long j2, @NonNull Object obj) {
        if (j2 != 0) {
            return j2;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @KeepForSdk
    public static void x(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    @KeepForSdk
    public static void y(boolean z, @NonNull Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @FormatMethod
    @KeepForSdk
    public static void z(boolean z, @FormatString @NonNull String str, @NonNull Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }
}
