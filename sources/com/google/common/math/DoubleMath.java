package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class DoubleMath {

    /* renamed from: a  reason: collision with root package name */
    private static final double f22814a = -2.147483648E9d;

    /* renamed from: b  reason: collision with root package name */
    private static final double f22815b = 2.147483647E9d;

    /* renamed from: c  reason: collision with root package name */
    private static final double f22816c = -9.223372036854776E18d;

    /* renamed from: d  reason: collision with root package name */
    private static final double f22817d = 9.223372036854776E18d;

    /* renamed from: e  reason: collision with root package name */
    private static final double f22818e = Math.log(2.0d);
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    static final int f22819f = 170;
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    static final double[] f22820g = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* renamed from: com.google.common.math.DoubleMath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22821a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22821a = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22821a     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22821a     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22821a     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f22821a     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f22821a     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f22821a     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f22821a     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleMath.AnonymousClass1.<clinit>():void");
        }
    }

    private DoubleMath() {
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @J2ktIncompatible
    private static double a(double d2) {
        Preconditions.d(DoubleUtils.d(d2));
        return d2;
    }

    public static double b(int i2) {
        MathPreconditions.e("n", i2);
        if (i2 > f22819f) {
            return Double.POSITIVE_INFINITY;
        }
        double d2 = 1.0d;
        for (int i3 = (i2 & -16) + 1; i3 <= i2; i3++) {
            d2 *= (double) i3;
        }
        return d2 * f22820g[i2 >> 4];
    }

    public static int c(double d2, double d3, double d4) {
        if (d(d2, d3, d4)) {
            return 0;
        }
        if (d2 < d3) {
            return -1;
        }
        if (d2 > d3) {
            return 1;
        }
        return Booleans.d(Double.isNaN(d2), Double.isNaN(d3));
    }

    public static boolean d(double d2, double d3, double d4) {
        MathPreconditions.d("tolerance", d4);
        return Math.copySign(d2 - d3, 1.0d) <= d4 || d2 == d3 || (Double.isNaN(d2) && Double.isNaN(d3));
    }

    @GwtIncompatible
    public static boolean e(double d2) {
        return DoubleUtils.d(d2) && (d2 == f22818e || 52 - Long.numberOfTrailingZeros(DoubleUtils.c(d2)) <= Math.getExponent(d2));
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static boolean f(double d2) {
        if (d2 <= f22818e || !DoubleUtils.d(d2)) {
            return false;
        }
        long c2 = DoubleUtils.c(d2);
        return (c2 & (c2 - 1)) == 0;
    }

    public static double g(double d2) {
        return Math.log(d2) / f22818e;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static int h(double d2, RoundingMode roundingMode) {
        boolean z = false;
        Preconditions.e(d2 > f22818e && DoubleUtils.d(d2), "x must be positive and finite");
        int exponent = Math.getExponent(d2);
        if (!DoubleUtils.e(d2)) {
            return h(d2 * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (AnonymousClass1.f22821a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(f(d2));
                break;
            case 2:
                break;
            case 3:
                z = !f(d2);
                break;
            case 4:
                if (exponent < 0) {
                    z = true;
                    break;
                }
                break;
            case 5:
                if (exponent >= 0) {
                    z = true;
                    break;
                }
                break;
            case 6:
            case 7:
            case 8:
                double g2 = DoubleUtils.g(d2);
                if (g2 * g2 > 2.0d) {
                    z = true;
                    break;
                }
                break;
            default:
                throw new AssertionError();
        }
        z &= !f(d2);
        return z ? exponent + 1 : exponent;
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static double i(Iterable<? extends Number> iterable) {
        return j(iterable.iterator());
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static double j(Iterator<? extends Number> it2) {
        Preconditions.e(it2.hasNext(), "Cannot take mean of 0 values");
        double a2 = a(((Number) it2.next()).doubleValue());
        long j2 = 1;
        while (it2.hasNext()) {
            j2++;
            a2 += (a(((Number) it2.next()).doubleValue()) - a2) / ((double) j2);
        }
        return a2;
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static double k(double... dArr) {
        Preconditions.e(dArr.length > 0, "Cannot take mean of 0 values");
        double a2 = a(dArr[0]);
        long j2 = 1;
        for (int i2 = 1; i2 < dArr.length; i2++) {
            a(dArr[i2]);
            j2++;
            a2 += (dArr[i2] - a2) / ((double) j2);
        }
        return a2;
    }

    @Deprecated
    public static double l(int... iArr) {
        Preconditions.e(iArr.length > 0, "Cannot take mean of 0 values");
        long j2 = 0;
        for (int i2 : iArr) {
            j2 += (long) i2;
        }
        return ((double) j2) / ((double) iArr.length);
    }

    @Deprecated
    public static double m(long... jArr) {
        Preconditions.e(jArr.length > 0, "Cannot take mean of 0 values");
        double d2 = (double) jArr[0];
        long j2 = 1;
        for (int i2 = 1; i2 < jArr.length; i2++) {
            j2++;
            d2 += (((double) jArr[i2]) - d2) / ((double) j2);
        }
        return d2;
    }

    @GwtIncompatible
    @J2ktIncompatible
    static double n(double d2, RoundingMode roundingMode) {
        if (DoubleUtils.d(d2)) {
            switch (AnonymousClass1.f22821a[roundingMode.ordinal()]) {
                case 1:
                    MathPreconditions.k(e(d2));
                    return d2;
                case 2:
                    return (d2 >= f22818e || e(d2)) ? d2 : (double) (((long) d2) - 1);
                case 3:
                    return (d2 <= f22818e || e(d2)) ? d2 : (double) (((long) d2) + 1);
                case 4:
                    return d2;
                case 5:
                    if (e(d2)) {
                        return d2;
                    }
                    return (double) (((long) d2) + ((long) (d2 > f22818e ? 1 : -1)));
                case 6:
                    return Math.rint(d2);
                case 7:
                    double rint = Math.rint(d2);
                    return Math.abs(d2 - rint) == 0.5d ? d2 + Math.copySign(0.5d, d2) : rint;
                case 8:
                    double rint2 = Math.rint(d2);
                    return Math.abs(d2 - rint2) == 0.5d ? d2 : rint2;
                default:
                    throw new AssertionError();
            }
        } else {
            throw new ArithmeticException("input is infinite or NaN");
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static BigInteger o(double d2, RoundingMode roundingMode) {
        double n2 = n(d2, roundingMode);
        boolean z = false;
        boolean z2 = f22816c - n2 < 1.0d;
        if (n2 < f22817d) {
            z = true;
        }
        if (z && z2) {
            return BigInteger.valueOf((long) n2);
        }
        BigInteger shiftLeft = BigInteger.valueOf(DoubleUtils.c(n2)).shiftLeft(Math.getExponent(n2) - 52);
        return n2 < f22818e ? shiftLeft.negate() : shiftLeft;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static int p(double d2, RoundingMode roundingMode) {
        double n2 = n(d2, roundingMode);
        boolean z = false;
        boolean z2 = n2 > -2.147483649E9d;
        if (n2 < 2.147483648E9d) {
            z = true;
        }
        MathPreconditions.a(z2 & z, d2, roundingMode);
        return (int) n2;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long q(double d2, RoundingMode roundingMode) {
        double n2 = n(d2, roundingMode);
        boolean z = false;
        boolean z2 = f22816c - n2 < 1.0d;
        if (n2 < f22817d) {
            z = true;
        }
        MathPreconditions.a(z2 & z, d2, roundingMode);
        return (long) n2;
    }
}
