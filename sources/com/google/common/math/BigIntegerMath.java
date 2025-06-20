package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class BigIntegerMath {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final int f22808a = 256;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    static final BigInteger f22809b = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);

    /* renamed from: c  reason: collision with root package name */
    private static final double f22810c = Math.log(10.0d);

    /* renamed from: d  reason: collision with root package name */
    private static final double f22811d = Math.log(2.0d);

    /* renamed from: com.google.common.math.BigIntegerMath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22812a;

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
                f22812a = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22812a     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22812a     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22812a     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f22812a     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f22812a     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f22812a     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f22812a     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.BigIntegerMath.AnonymousClass1.<clinit>():void");
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static class BigIntegerToDoubleRounder extends ToDoubleRounder<BigInteger> {

        /* renamed from: a  reason: collision with root package name */
        static final BigIntegerToDoubleRounder f22813a = new BigIntegerToDoubleRounder();

        private BigIntegerToDoubleRounder() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public BigInteger a(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger.subtract(bigInteger2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public double c(BigInteger bigInteger) {
            return DoubleUtils.a(bigInteger);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public int d(BigInteger bigInteger) {
            return bigInteger.signum();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public BigInteger e(double d2, RoundingMode roundingMode) {
            return DoubleMath.o(d2, roundingMode);
        }
    }

    private BigIntegerMath() {
    }

    public static BigInteger a(int i2, int i3) {
        MathPreconditions.e("n", i2);
        MathPreconditions.e("k", i3);
        int i4 = 1;
        Preconditions.m(i3 <= i2, "k (%s) > n (%s)", i3, i2);
        if (i3 > (i2 >> 1)) {
            i3 = i2 - i3;
        }
        int[] iArr = LongMath.f22853h;
        if (i3 < iArr.length && i2 <= iArr[i3]) {
            return BigInteger.valueOf(LongMath.a(i2, i3));
        }
        BigInteger bigInteger = BigInteger.ONE;
        long j2 = (long) i2;
        int q = LongMath.q(j2, RoundingMode.CEILING);
        long j3 = 1;
        while (true) {
            int i5 = q;
            while (i4 < i3) {
                int i6 = i2 - i4;
                i4++;
                i5 += q;
                if (i5 >= 63) {
                    bigInteger = bigInteger.multiply(BigInteger.valueOf(j2)).divide(BigInteger.valueOf(j3));
                    j2 = (long) i6;
                    j3 = (long) i4;
                } else {
                    j2 *= (long) i6;
                    j3 *= (long) i4;
                }
            }
            return bigInteger.multiply(BigInteger.valueOf(j2)).divide(BigInteger.valueOf(j3));
        }
    }

    public static BigInteger b(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(k(bigInteger, RoundingMode.CEILING));
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static BigInteger c(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger d(int i2) {
        int i3 = i2;
        MathPreconditions.e("n", i3);
        long[] jArr = LongMath.f22852g;
        if (i3 < jArr.length) {
            return BigInteger.valueOf(jArr[i3]);
        }
        RoundingMode roundingMode = RoundingMode.CEILING;
        ArrayList arrayList = new ArrayList(IntMath.g(IntMath.p(i3, roundingMode) * i3, 64, roundingMode));
        int length = jArr.length;
        long j2 = jArr[length - 1];
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j2);
        long j3 = j2 >> numberOfTrailingZeros;
        RoundingMode roundingMode2 = RoundingMode.FLOOR;
        int q = LongMath.q(j3, roundingMode2) + 1;
        long j4 = (long) length;
        int q2 = LongMath.q(j4, roundingMode2);
        int i4 = q2 + 1;
        int i5 = 1 << q2;
        while (j4 <= ((long) i3)) {
            if ((((long) i5) & j4) != 0) {
                i5 <<= 1;
                i4++;
            }
            int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j4);
            long j5 = j4 >> numberOfTrailingZeros2;
            numberOfTrailingZeros += numberOfTrailingZeros2;
            if ((i4 - numberOfTrailingZeros2) + q >= 64) {
                arrayList.add(BigInteger.valueOf(j3));
                j3 = 1;
            }
            j3 *= j5;
            q = LongMath.q(j3, RoundingMode.FLOOR) + 1;
            j4++;
        }
        if (j3 > 1) {
            arrayList.add(BigInteger.valueOf(j3));
        }
        return h(arrayList).shiftLeft(numberOfTrailingZeros);
    }

    @GwtIncompatible
    @J2ktIncompatible
    static boolean e(BigInteger bigInteger) {
        return bigInteger.bitLength() <= 63;
    }

    public static BigInteger f(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(k(bigInteger, RoundingMode.FLOOR));
    }

    public static boolean g(BigInteger bigInteger) {
        Preconditions.E(bigInteger);
        return bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1;
    }

    static BigInteger h(List<BigInteger> list) {
        return i(list, 0, list.size());
    }

    static BigInteger i(List<BigInteger> list, int i2, int i3) {
        int i4 = i3 - i2;
        if (i4 == 0) {
            return BigInteger.ONE;
        }
        if (i4 == 1) {
            return list.get(i2);
        }
        if (i4 == 2) {
            return list.get(i2).multiply(list.get(i2 + 1));
        }
        if (i4 == 3) {
            return list.get(i2).multiply(list.get(i2 + 1)).multiply(list.get(i2 + 2));
        }
        int i5 = (i3 + i2) >>> 1;
        return i(list, i2, i5).multiply(i(list, i5, i3));
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static int j(BigInteger bigInteger, RoundingMode roundingMode) {
        int i2;
        MathPreconditions.j("x", bigInteger);
        if (e(bigInteger)) {
            return LongMath.o(bigInteger.longValue(), roundingMode);
        }
        int k2 = (int) ((((double) k(bigInteger, RoundingMode.FLOOR)) * f22811d) / f22810c);
        BigInteger bigInteger2 = BigInteger.TEN;
        BigInteger pow = bigInteger2.pow(k2);
        int compareTo = pow.compareTo(bigInteger);
        if (compareTo > 0) {
            do {
                k2--;
                pow = pow.divide(BigInteger.TEN);
                i2 = pow.compareTo(bigInteger);
            } while (i2 > 0);
        } else {
            BigInteger multiply = bigInteger2.multiply(pow);
            int i3 = compareTo;
            int compareTo2 = multiply.compareTo(bigInteger);
            while (compareTo2 <= 0) {
                k2++;
                BigInteger multiply2 = BigInteger.TEN.multiply(multiply);
                int compareTo3 = multiply2.compareTo(bigInteger);
                BigInteger bigInteger3 = multiply2;
                pow = multiply;
                multiply = bigInteger3;
                int i4 = compareTo3;
                i3 = compareTo2;
                compareTo2 = i4;
            }
            i2 = i3;
        }
        switch (AnonymousClass1.f22812a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(i2 == 0);
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return pow.equals(bigInteger) ? k2 : k2 + 1;
            case 6:
            case 7:
            case 8:
                return bigInteger.pow(2).compareTo(pow.pow(2).multiply(BigInteger.TEN)) <= 0 ? k2 : k2 + 1;
            default:
                throw new AssertionError();
        }
        return k2;
    }

    public static int k(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.j("x", (BigInteger) Preconditions.E(bigInteger));
        int bitLength = bigInteger.bitLength();
        int i2 = bitLength - 1;
        switch (AnonymousClass1.f22812a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(g(bigInteger));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return g(bigInteger) ? i2 : bitLength;
            case 6:
            case 7:
            case 8:
                return i2 < 256 ? bigInteger.compareTo(f22809b.shiftRight(256 - i2)) <= 0 ? i2 : bitLength : bigInteger.pow(2).bitLength() + -1 < (i2 * 2) + 1 ? i2 : bitLength;
            default:
                throw new AssertionError();
        }
        return i2;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static double l(BigInteger bigInteger, RoundingMode roundingMode) {
        return BigIntegerToDoubleRounder.f22813a.b(bigInteger, roundingMode);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static BigInteger m(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.g("x", bigInteger);
        if (e(bigInteger)) {
            return BigInteger.valueOf(LongMath.B(bigInteger.longValue(), roundingMode));
        }
        BigInteger o = o(bigInteger);
        switch (AnonymousClass1.f22812a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(o.pow(2).equals(bigInteger));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                int intValue = o.intValue();
                return (intValue * intValue != bigInteger.intValue() || !o.pow(2).equals(bigInteger)) ? o.add(BigInteger.ONE) : o;
            case 6:
            case 7:
            case 8:
                return o.pow(2).add(o).compareTo(bigInteger) >= 0 ? o : o.add(BigInteger.ONE);
            default:
                throw new AssertionError();
        }
        return o;
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static BigInteger n(BigInteger bigInteger) {
        return DoubleMath.o(Math.sqrt(DoubleUtils.a(bigInteger)), RoundingMode.HALF_EVEN);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static BigInteger o(BigInteger bigInteger) {
        BigInteger bigInteger2;
        int k2 = k(bigInteger, RoundingMode.FLOOR);
        if (k2 < 1023) {
            bigInteger2 = n(bigInteger);
        } else {
            int i2 = (k2 - 52) & -2;
            bigInteger2 = n(bigInteger.shiftRight(i2)).shiftLeft(i2 >> 1);
        }
        BigInteger shiftRight = bigInteger2.add(bigInteger.divide(bigInteger2)).shiftRight(1);
        if (bigInteger2.equals(shiftRight)) {
            return bigInteger2;
        }
        while (true) {
            BigInteger shiftRight2 = shiftRight.add(bigInteger.divide(shiftRight)).shiftRight(1);
            if (shiftRight2.compareTo(shiftRight) >= 0) {
                return shiftRight;
            }
            shiftRight = shiftRight2;
        }
    }
}
