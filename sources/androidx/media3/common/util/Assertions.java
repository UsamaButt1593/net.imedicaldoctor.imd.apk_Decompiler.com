package androidx.media3.common.util;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

@UnstableApi
public final class Assertions {
    private Assertions() {
    }

    @Pure
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    @Pure
    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @Pure
    public static int c(int i2, int i3, int i4) {
        if (i2 >= i3 && i2 < i4) {
            return i2;
        }
        throw new IndexOutOfBoundsException();
    }

    @Pure
    public static void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Not in applications main thread");
        }
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static String e(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static String f(@Nullable String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T g(@Nullable T t) {
        t.getClass();
        return t;
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T h(@Nullable T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @Pure
    public static void i(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    @Pure
    public static void j(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T k(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T l(@Nullable T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }
}
