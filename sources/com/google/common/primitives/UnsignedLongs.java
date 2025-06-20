package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class UnsignedLongs {

    /* renamed from: a  reason: collision with root package name */
    public static final long f22974a = -1;

    enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        /* renamed from: b */
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                long j2 = jArr[i2];
                long j3 = jArr2[i2];
                if (j2 != j3) {
                    return UnsignedLongs.a(j2, j3);
                }
            }
            return jArr.length - jArr2.length;
        }

        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    private static final class ParseOverflowDetection {

        /* renamed from: a  reason: collision with root package name */
        static final long[] f22975a = new long[37];

        /* renamed from: b  reason: collision with root package name */
        static final int[] f22976b = new int[37];

        /* renamed from: c  reason: collision with root package name */
        static final int[] f22977c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i2 = 2; i2 <= 36; i2++) {
                long j2 = (long) i2;
                f22975a[i2] = UnsignedLongs.c(-1, j2);
                f22976b[i2] = (int) UnsignedLongs.k(-1, j2);
                f22977c[i2] = bigInteger.toString(i2).length() - 1;
            }
        }

        private ParseOverflowDetection() {
        }

        static boolean a(long j2, int i2, int i3) {
            if (j2 < 0) {
                return true;
            }
            long j3 = f22975a[i3];
            if (j2 < j3) {
                return false;
            }
            return j2 > j3 || i2 > f22976b[i3];
        }
    }

    private UnsignedLongs() {
    }

    public static int a(long j2, long j3) {
        return Longs.e(d(j2), d(j3));
    }

    @CanIgnoreReturnValue
    public static long b(String str) {
        ParseRequest a2 = ParseRequest.a(str);
        try {
            return j(a2.f22961a, a2.f22962b);
        } catch (NumberFormatException e2) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e2);
            throw numberFormatException;
        }
    }

    public static long c(long j2, long j3) {
        if (j3 < 0) {
            return a(j2, j3) < 0 ? 0 : 1;
        }
        if (j2 >= 0) {
            return j2 / j3;
        }
        int i2 = 1;
        long j4 = ((j2 >>> 1) / j3) << 1;
        if (a(j2 - (j4 * j3), j3) < 0) {
            i2 = 0;
        }
        return j4 + ((long) i2);
    }

    private static long d(long j2) {
        return j2 ^ Long.MIN_VALUE;
    }

    public static String e(String str, long... jArr) {
        Preconditions.E(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(p(jArr[0]));
        for (int i2 = 1; i2 < jArr.length; i2++) {
            sb.append(str);
            sb.append(p(jArr[i2]));
        }
        return sb.toString();
    }

    public static Comparator<long[]> f() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long g(long... jArr) {
        Preconditions.d(jArr.length > 0);
        long d2 = d(jArr[0]);
        for (int i2 = 1; i2 < jArr.length; i2++) {
            long d3 = d(jArr[i2]);
            if (d3 > d2) {
                d2 = d3;
            }
        }
        return d(d2);
    }

    public static long h(long... jArr) {
        Preconditions.d(jArr.length > 0);
        long d2 = d(jArr[0]);
        for (int i2 = 1; i2 < jArr.length; i2++) {
            long d3 = d(jArr[i2]);
            if (d3 < d2) {
                d2 = d3;
            }
        }
        return d(d2);
    }

    @CanIgnoreReturnValue
    public static long i(String str) {
        return j(str, 10);
    }

    @CanIgnoreReturnValue
    public static long j(String str, int i2) {
        Preconditions.E(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        } else if (i2 < 2 || i2 > 36) {
            throw new NumberFormatException("illegal radix: " + i2);
        } else {
            int i3 = ParseOverflowDetection.f22977c[i2] - 1;
            long j2 = 0;
            int i4 = 0;
            while (i4 < str.length()) {
                int digit = Character.digit(str.charAt(i4), i2);
                if (digit == -1) {
                    throw new NumberFormatException(str);
                } else if (i4 <= i3 || !ParseOverflowDetection.a(j2, digit, i2)) {
                    j2 = (j2 * ((long) i2)) + ((long) digit);
                    i4++;
                } else {
                    throw new NumberFormatException("Too large for unsigned long: " + str);
                }
            }
            return j2;
        }
    }

    public static long k(long j2, long j3) {
        if (j3 < 0) {
            return a(j2, j3) < 0 ? j2 : j2 - j3;
        }
        if (j2 >= 0) {
            return j2 % j3;
        }
        long j4 = j2 - ((((j2 >>> 1) / j3) << 1) * j3);
        if (a(j4, j3) < 0) {
            j3 = 0;
        }
        return j4 - j3;
    }

    public static void l(long[] jArr) {
        Preconditions.E(jArr);
        m(jArr, 0, jArr.length);
    }

    public static void m(long[] jArr, int i2, int i3) {
        Preconditions.E(jArr);
        Preconditions.f0(i2, i3, jArr.length);
        for (int i4 = i2; i4 < i3; i4++) {
            jArr[i4] = d(jArr[i4]);
        }
        Arrays.sort(jArr, i2, i3);
        while (i2 < i3) {
            jArr[i2] = d(jArr[i2]);
            i2++;
        }
    }

    public static void n(long[] jArr) {
        Preconditions.E(jArr);
        o(jArr, 0, jArr.length);
    }

    public static void o(long[] jArr, int i2, int i3) {
        Preconditions.E(jArr);
        Preconditions.f0(i2, i3, jArr.length);
        for (int i4 = i2; i4 < i3; i4++) {
            jArr[i4] = Long.MAX_VALUE ^ jArr[i4];
        }
        Arrays.sort(jArr, i2, i3);
        while (i2 < i3) {
            jArr[i2] = jArr[i2] ^ Long.MAX_VALUE;
            i2++;
        }
    }

    public static String p(long j2) {
        return q(j2, 10);
    }

    public static String q(long j2, int i2) {
        Preconditions.k(i2 >= 2 && i2 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i2);
        int i3 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i3 == 0) {
            return "0";
        }
        if (i3 > 0) {
            return Long.toString(j2, i2);
        }
        int i4 = 64;
        char[] cArr = new char[64];
        int i5 = i2 - 1;
        if ((i2 & i5) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i2);
            do {
                i4--;
                cArr[i4] = Character.forDigit(((int) j2) & i5, i2);
                j2 >>>= numberOfTrailingZeros;
            } while (j2 != 0);
        } else {
            long c2 = (i2 & 1) == 0 ? (j2 >>> 1) / ((long) (i2 >>> 1)) : c(j2, (long) i2);
            long j3 = (long) i2;
            int i6 = 63;
            cArr[63] = Character.forDigit((int) (j2 - (c2 * j3)), i2);
            while (c2 > 0) {
                i6--;
                cArr[i6] = Character.forDigit((int) (c2 % j3), i2);
                c2 /= j3;
            }
            i4 = i6;
        }
        return new String(cArr, i4, 64 - i4);
    }
}
