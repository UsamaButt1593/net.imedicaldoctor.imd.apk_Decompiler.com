package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class MathPreconditions {
    private MathPreconditions() {
    }

    static void a(boolean z, double d2, RoundingMode roundingMode) {
        if (!z) {
            throw new ArithmeticException("rounded value is out of range for input " + d2 + " and rounding mode " + roundingMode);
        }
    }

    static void b(boolean z, String str, int i2, int i3) {
        if (!z) {
            throw new ArithmeticException("overflow: " + str + "(" + i2 + ", " + i3 + ")");
        }
    }

    static void c(boolean z, String str, long j2, long j3) {
        if (!z) {
            throw new ArithmeticException("overflow: " + str + "(" + j2 + ", " + j3 + ")");
        }
    }

    @CanIgnoreReturnValue
    static double d(String str, double d2) {
        if (d2 >= 0.0d) {
            return d2;
        }
        throw new IllegalArgumentException(str + " (" + d2 + ") must be >= 0");
    }

    @CanIgnoreReturnValue
    static int e(String str, int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " (" + i2 + ") must be >= 0");
    }

    @CanIgnoreReturnValue
    static long f(String str, long j2) {
        if (j2 >= 0) {
            return j2;
        }
        throw new IllegalArgumentException(str + " (" + j2 + ") must be >= 0");
    }

    @CanIgnoreReturnValue
    static BigInteger g(String str, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be >= 0");
    }

    @CanIgnoreReturnValue
    static int h(String str, int i2) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " (" + i2 + ") must be > 0");
    }

    @CanIgnoreReturnValue
    static long i(String str, long j2) {
        if (j2 > 0) {
            return j2;
        }
        throw new IllegalArgumentException(str + " (" + j2 + ") must be > 0");
    }

    @CanIgnoreReturnValue
    static BigInteger j(String str, BigInteger bigInteger) {
        if (bigInteger.signum() > 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be > 0");
    }

    static void k(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
