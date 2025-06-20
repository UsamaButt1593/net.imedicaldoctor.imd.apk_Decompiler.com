package androidx.core.math;

public class MathUtils {
    private MathUtils() {
    }

    public static int a(int i2, int i3) {
        int i4 = i2 + i3;
        boolean z = false;
        if ((i2 >= 0) == (i3 >= 0)) {
            boolean z2 = i2 >= 0;
            if (i4 >= 0) {
                z = true;
            }
            if (z2 != z) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i4;
    }

    public static long b(long j2, long j3) {
        long j4 = j2 + j3;
        boolean z = false;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if ((i2 >= 0) == (j3 >= 0)) {
            boolean z2 = i2 >= 0;
            if (j4 >= 0) {
                z = true;
            }
            if (z2 != z) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j4;
    }

    public static double c(double d2, double d3, double d4) {
        if (d2 < d3) {
            return d3;
        }
        return d2 > d4 ? d4 : d2;
    }

    public static float d(float f2, float f3, float f4) {
        if (f2 < f3) {
            return f3;
        }
        return f2 > f4 ? f4 : f2;
    }

    public static int e(int i2, int i3, int i4) {
        if (i2 < i3) {
            return i3;
        }
        return i2 > i4 ? i4 : i2;
    }

    public static long f(long j2, long j3, long j4) {
        if (j2 < j3) {
            return j3;
        }
        return j2 > j4 ? j4 : j2;
    }

    public static int g(int i2) {
        if (i2 != Integer.MIN_VALUE) {
            return i2 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long h(long j2) {
        if (j2 != Long.MIN_VALUE) {
            return j2 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int i(int i2) {
        if (i2 != Integer.MAX_VALUE) {
            return i2 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long j(long j2) {
        if (j2 != Long.MAX_VALUE) {
            return j2 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int k(int i2, int i3) {
        int i4 = i2 * i3;
        if (i2 == 0 || i3 == 0 || (i4 / i2 == i3 && i4 / i3 == i2)) {
            return i4;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long l(long j2, long j3) {
        long j4 = j2 * j3;
        if (j2 == 0 || j3 == 0 || (j4 / j2 == j3 && j4 / j3 == j2)) {
            return j4;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int m(int i2) {
        if (i2 != Integer.MIN_VALUE) {
            return -i2;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long n(long j2) {
        if (j2 != Long.MIN_VALUE) {
            return -j2;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int o(int i2, int i3) {
        int i4 = i2 - i3;
        boolean z = false;
        if ((i2 < 0) != (i3 < 0)) {
            boolean z2 = i2 < 0;
            if (i4 < 0) {
                z = true;
            }
            if (z2 != z) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i4;
    }

    public static long p(long j2, long j3) {
        long j4 = j2 - j3;
        boolean z = false;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if ((i2 < 0) != (j3 < 0)) {
            boolean z2 = i2 < 0;
            if (j4 < 0) {
                z = true;
            }
            if (z2 != z) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j4;
    }

    public static int q(long j2) {
        if (j2 <= 2147483647L && j2 >= -2147483648L) {
            return (int) j2;
        }
        throw new ArithmeticException("integer overflow");
    }
}
