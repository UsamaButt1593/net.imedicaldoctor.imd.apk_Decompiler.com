package com.google.common.math;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigInteger;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class DoubleUtils {

    /* renamed from: a  reason: collision with root package name */
    static final long f22822a = 4503599627370495L;

    /* renamed from: b  reason: collision with root package name */
    static final long f22823b = 9218868437227405312L;

    /* renamed from: c  reason: collision with root package name */
    static final long f22824c = Long.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    static final int f22825d = 52;

    /* renamed from: e  reason: collision with root package name */
    static final int f22826e = 1023;

    /* renamed from: f  reason: collision with root package name */
    static final long f22827f = 4503599627370496L;
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    static final long f22828g = 4607182418800017408L;

    private DoubleUtils() {
    }

    static double a(BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        int bitLength = abs.bitLength();
        int i2 = bitLength - 1;
        if (i2 < 63) {
            return (double) bigInteger.longValue();
        }
        if (i2 > 1023) {
            return ((double) bigInteger.signum()) * Double.POSITIVE_INFINITY;
        }
        int i3 = bitLength - 54;
        long longValue = abs.shiftRight(i3).longValue();
        long j2 = longValue >> 1;
        long j3 = f22822a & j2;
        if ((longValue & 1) != 0 && ((j2 & 1) != 0 || abs.getLowestSetBit() < i3)) {
            j3++;
        }
        return Double.longBitsToDouble(((((long) (bitLength + AnalyticsListener.b0)) << 52) + j3) | (((long) bigInteger.signum()) & Long.MIN_VALUE));
    }

    static double b(double d2) {
        Preconditions.d(!Double.isNaN(d2));
        return Math.max(d2, 0.0d);
    }

    static long c(double d2) {
        Preconditions.e(d(d2), "not a normal value");
        int exponent = Math.getExponent(d2);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d2) & f22822a;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | f22827f;
    }

    static boolean d(double d2) {
        return Math.getExponent(d2) <= 1023;
    }

    static boolean e(double d2) {
        return Math.getExponent(d2) >= -1022;
    }

    static double f(double d2) {
        return -Math.nextUp(-d2);
    }

    static double g(double d2) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d2) & f22822a) | f22828g);
    }
}
