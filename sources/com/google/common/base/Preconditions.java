package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Preconditions {
    private Preconditions() {
    }

    public static void A(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, obj, obj2, obj3, obj4));
        }
    }

    public static void A0(boolean z, String str, @CheckForNull Object obj, long j2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, obj, Long.valueOf(j2)));
        }
    }

    public static void B(boolean z, String str, @CheckForNull Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, objArr));
        }
    }

    public static void B0(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, obj, obj2));
        }
    }

    @CanIgnoreReturnValue
    public static int C(int i2, int i3) {
        return D(i2, i3, "index");
    }

    public static void C0(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, obj, obj2, obj3));
        }
    }

    @CanIgnoreReturnValue
    public static int D(int i2, int i3, String str) {
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(a(i2, i3, str));
    }

    public static void D0(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, obj, obj2, obj3, obj4));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T E(@CheckForNull T t) {
        t.getClass();
        return t;
    }

    public static void E0(boolean z, @CheckForNull String str, @CheckForNull Object... objArr) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T F(@CheckForNull T t, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    public static <T> T G(@CheckForNull T t, String str, char c2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Character.valueOf(c2)));
    }

    @CanIgnoreReturnValue
    public static <T> T H(@CheckForNull T t, String str, char c2, char c3) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Character.valueOf(c2), Character.valueOf(c3)));
    }

    @CanIgnoreReturnValue
    public static <T> T I(@CheckForNull T t, String str, char c2, int i2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Character.valueOf(c2), Integer.valueOf(i2)));
    }

    @CanIgnoreReturnValue
    public static <T> T J(@CheckForNull T t, String str, char c2, long j2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Character.valueOf(c2), Long.valueOf(j2)));
    }

    @CanIgnoreReturnValue
    public static <T> T K(@CheckForNull T t, String str, char c2, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Character.valueOf(c2), obj));
    }

    @CanIgnoreReturnValue
    public static <T> T L(@CheckForNull T t, String str, int i2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Integer.valueOf(i2)));
    }

    @CanIgnoreReturnValue
    public static <T> T M(@CheckForNull T t, String str, int i2, char c2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Integer.valueOf(i2), Character.valueOf(c2)));
    }

    @CanIgnoreReturnValue
    public static <T> T N(@CheckForNull T t, String str, int i2, int i3) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    @CanIgnoreReturnValue
    public static <T> T O(@CheckForNull T t, String str, int i2, long j2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Integer.valueOf(i2), Long.valueOf(j2)));
    }

    @CanIgnoreReturnValue
    public static <T> T P(@CheckForNull T t, String str, int i2, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Integer.valueOf(i2), obj));
    }

    @CanIgnoreReturnValue
    public static <T> T Q(@CheckForNull T t, String str, long j2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Long.valueOf(j2)));
    }

    @CanIgnoreReturnValue
    public static <T> T R(@CheckForNull T t, String str, long j2, char c2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Long.valueOf(j2), Character.valueOf(c2)));
    }

    @CanIgnoreReturnValue
    public static <T> T S(@CheckForNull T t, String str, long j2, int i2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Long.valueOf(j2), Integer.valueOf(i2)));
    }

    @CanIgnoreReturnValue
    public static <T> T T(@CheckForNull T t, String str, long j2, long j3) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Long.valueOf(j2), Long.valueOf(j3)));
    }

    @CanIgnoreReturnValue
    public static <T> T U(@CheckForNull T t, String str, long j2, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, Long.valueOf(j2), obj));
    }

    @CanIgnoreReturnValue
    public static <T> T V(@CheckForNull T t, String str, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, obj));
    }

    @CanIgnoreReturnValue
    public static <T> T W(@CheckForNull T t, String str, @CheckForNull Object obj, char c2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, obj, Character.valueOf(c2)));
    }

    @CanIgnoreReturnValue
    public static <T> T X(@CheckForNull T t, String str, @CheckForNull Object obj, int i2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, obj, Integer.valueOf(i2)));
    }

    @CanIgnoreReturnValue
    public static <T> T Y(@CheckForNull T t, String str, @CheckForNull Object obj, long j2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, obj, Long.valueOf(j2)));
    }

    @CanIgnoreReturnValue
    public static <T> T Z(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, obj, obj2));
    }

    private static String a(int i2, int i3, String str) {
        if (i2 < 0) {
            return Strings.e("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return Strings.e("%s (%s) must be less than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException("negative size: " + i3);
        }
    }

    @CanIgnoreReturnValue
    public static <T> T a0(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, obj, obj2, obj3));
    }

    private static String b(int i2, int i3, String str) {
        if (i2 < 0) {
            return Strings.e("%s (%s) must not be negative", str, Integer.valueOf(i2));
        } else if (i3 >= 0) {
            return Strings.e("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            throw new IllegalArgumentException("negative size: " + i3);
        }
    }

    @CanIgnoreReturnValue
    public static <T> T b0(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, obj, obj2, obj3, obj4));
    }

    private static String c(int i2, int i3, int i4) {
        if (i2 < 0 || i2 > i4) {
            return b(i2, i4, "start index");
        }
        if (i3 < 0 || i3 > i4) {
            return b(i3, i4, "end index");
        }
        return Strings.e("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
    }

    @CanIgnoreReturnValue
    public static <T> T c0(@CheckForNull T t, String str, @CheckForNull Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.e(str, objArr));
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    @CanIgnoreReturnValue
    public static int d0(int i2, int i3) {
        return e0(i2, i3, "index");
    }

    public static void e(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @CanIgnoreReturnValue
    public static int e0(int i2, int i3, String str) {
        if (i2 >= 0 && i2 <= i3) {
            return i2;
        }
        throw new IndexOutOfBoundsException(b(i2, i3, str));
    }

    public static void f(boolean z, String str, char c2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Character.valueOf(c2)));
        }
    }

    public static void f0(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException(c(i2, i3, i4));
        }
    }

    public static void g(boolean z, String str, char c2, char c3) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Character.valueOf(c2), Character.valueOf(c3)));
        }
    }

    public static void g0(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void h(boolean z, String str, char c2, int i2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Character.valueOf(c2), Integer.valueOf(i2)));
        }
    }

    public static void h0(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void i(boolean z, String str, char c2, long j2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Character.valueOf(c2), Long.valueOf(j2)));
        }
    }

    public static void i0(boolean z, String str, char c2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Character.valueOf(c2)));
        }
    }

    public static void j(boolean z, String str, char c2, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Character.valueOf(c2), obj));
        }
    }

    public static void j0(boolean z, String str, char c2, char c3) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Character.valueOf(c2), Character.valueOf(c3)));
        }
    }

    public static void k(boolean z, String str, int i2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Integer.valueOf(i2)));
        }
    }

    public static void k0(boolean z, String str, char c2, int i2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Character.valueOf(c2), Integer.valueOf(i2)));
        }
    }

    public static void l(boolean z, String str, int i2, char c2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Integer.valueOf(i2), Character.valueOf(c2)));
        }
    }

    public static void l0(boolean z, String str, char c2, long j2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Character.valueOf(c2), Long.valueOf(j2)));
        }
    }

    public static void m(boolean z, String str, int i2, int i3) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public static void m0(boolean z, String str, char c2, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Character.valueOf(c2), obj));
        }
    }

    public static void n(boolean z, String str, int i2, long j2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Integer.valueOf(i2), Long.valueOf(j2)));
        }
    }

    public static void n0(boolean z, String str, int i2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Integer.valueOf(i2)));
        }
    }

    public static void o(boolean z, String str, int i2, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Integer.valueOf(i2), obj));
        }
    }

    public static void o0(boolean z, String str, int i2, char c2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Integer.valueOf(i2), Character.valueOf(c2)));
        }
    }

    public static void p(boolean z, String str, long j2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Long.valueOf(j2)));
        }
    }

    public static void p0(boolean z, String str, int i2, int i3) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public static void q(boolean z, String str, long j2, char c2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Long.valueOf(j2), Character.valueOf(c2)));
        }
    }

    public static void q0(boolean z, String str, int i2, long j2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Integer.valueOf(i2), Long.valueOf(j2)));
        }
    }

    public static void r(boolean z, String str, long j2, int i2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Long.valueOf(j2), Integer.valueOf(i2)));
        }
    }

    public static void r0(boolean z, String str, int i2, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Integer.valueOf(i2), obj));
        }
    }

    public static void s(boolean z, String str, long j2, long j3) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static void s0(boolean z, String str, long j2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Long.valueOf(j2)));
        }
    }

    public static void t(boolean z, String str, long j2, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, Long.valueOf(j2), obj));
        }
    }

    public static void t0(boolean z, String str, long j2, char c2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Long.valueOf(j2), Character.valueOf(c2)));
        }
    }

    public static void u(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, obj));
        }
    }

    public static void u0(boolean z, String str, long j2, int i2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Long.valueOf(j2), Integer.valueOf(i2)));
        }
    }

    public static void v(boolean z, String str, @CheckForNull Object obj, char c2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, obj, Character.valueOf(c2)));
        }
    }

    public static void v0(boolean z, String str, long j2, long j3) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static void w(boolean z, String str, @CheckForNull Object obj, int i2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, obj, Integer.valueOf(i2)));
        }
    }

    public static void w0(boolean z, String str, long j2, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, Long.valueOf(j2), obj));
        }
    }

    public static void x(boolean z, String str, @CheckForNull Object obj, long j2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, obj, Long.valueOf(j2)));
        }
    }

    public static void x0(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, obj));
        }
    }

    public static void y(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, obj, obj2));
        }
    }

    public static void y0(boolean z, String str, @CheckForNull Object obj, char c2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, obj, Character.valueOf(c2)));
        }
    }

    public static void z(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new IllegalArgumentException(Strings.e(str, obj, obj2, obj3));
        }
    }

    public static void z0(boolean z, String str, @CheckForNull Object obj, int i2) {
        if (!z) {
            throw new IllegalStateException(Strings.e(str, obj, Integer.valueOf(i2)));
        }
    }
}
