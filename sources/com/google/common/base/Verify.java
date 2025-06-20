package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Verify {
    private Verify() {
    }

    public static void a(boolean z) {
        if (!z) {
            throw new VerifyException();
        }
    }

    public static void b(boolean z, String str, char c2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Character.valueOf(c2)));
        }
    }

    public static void c(boolean z, String str, char c2, char c3) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Character.valueOf(c2), Character.valueOf(c3)));
        }
    }

    public static void d(boolean z, String str, char c2, int i2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Character.valueOf(c2), Integer.valueOf(i2)));
        }
    }

    public static void e(boolean z, String str, char c2, long j2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Character.valueOf(c2), Long.valueOf(j2)));
        }
    }

    public static void f(boolean z, String str, char c2, @CheckForNull Object obj) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Character.valueOf(c2), obj));
        }
    }

    public static void g(boolean z, String str, int i2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Integer.valueOf(i2)));
        }
    }

    public static void h(boolean z, String str, int i2, char c2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Integer.valueOf(i2), Character.valueOf(c2)));
        }
    }

    public static void i(boolean z, String str, int i2, int i3) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public static void j(boolean z, String str, int i2, long j2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Integer.valueOf(i2), Long.valueOf(j2)));
        }
    }

    public static void k(boolean z, String str, int i2, @CheckForNull Object obj) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Integer.valueOf(i2), obj));
        }
    }

    public static void l(boolean z, String str, long j2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Long.valueOf(j2)));
        }
    }

    public static void m(boolean z, String str, long j2, char c2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Long.valueOf(j2), Character.valueOf(c2)));
        }
    }

    public static void n(boolean z, String str, long j2, int i2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Long.valueOf(j2), Integer.valueOf(i2)));
        }
    }

    public static void o(boolean z, String str, long j2, long j3) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static void p(boolean z, String str, long j2, @CheckForNull Object obj) {
        if (!z) {
            throw new VerifyException(Strings.e(str, Long.valueOf(j2), obj));
        }
    }

    public static void q(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new VerifyException(Strings.e(str, obj));
        }
    }

    public static void r(boolean z, String str, @CheckForNull Object obj, char c2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, obj, Character.valueOf(c2)));
        }
    }

    public static void s(boolean z, String str, @CheckForNull Object obj, int i2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, obj, Integer.valueOf(i2)));
        }
    }

    public static void t(boolean z, String str, @CheckForNull Object obj, long j2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, obj, Long.valueOf(j2)));
        }
    }

    public static void u(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z) {
            throw new VerifyException(Strings.e(str, obj, obj2));
        }
    }

    public static void v(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new VerifyException(Strings.e(str, obj, obj2, obj3));
        }
    }

    public static void w(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z) {
            throw new VerifyException(Strings.e(str, obj, obj2, obj3, obj4));
        }
    }

    public static void x(boolean z, String str, @CheckForNull Object... objArr) {
        if (!z) {
            throw new VerifyException(Strings.e(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T y(@CheckForNull T t) {
        return z(t, "expected a non-null reference", new Object[0]);
    }

    @CanIgnoreReturnValue
    public static <T> T z(@CheckForNull T t, String str, @CheckForNull Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new VerifyException(Strings.e(str, objArr));
    }
}
