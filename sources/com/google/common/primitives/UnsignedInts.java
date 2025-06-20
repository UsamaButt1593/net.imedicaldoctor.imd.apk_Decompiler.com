package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class UnsignedInts {

    /* renamed from: a  reason: collision with root package name */
    static final long f22973a = 4294967295L;

    enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        /* renamed from: b */
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                if (i3 != i4) {
                    return UnsignedInts.b(i3, i4);
                }
            }
            return iArr.length - iArr2.length;
        }

        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }
    }

    private UnsignedInts() {
    }

    public static int a(long j2) {
        Preconditions.p((j2 >> 32) == 0, "out of range: %s", j2);
        return (int) j2;
    }

    public static int b(int i2, int i3) {
        return Ints.e(e(i2), e(i3));
    }

    @CanIgnoreReturnValue
    public static int c(String str) {
        ParseRequest a2 = ParseRequest.a(str);
        try {
            return k(a2.f22961a, a2.f22962b);
        } catch (NumberFormatException e2) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e2);
            throw numberFormatException;
        }
    }

    public static int d(int i2, int i3) {
        return (int) (r(i2) / r(i3));
    }

    static int e(int i2) {
        return i2 ^ Integer.MIN_VALUE;
    }

    public static String f(String str, int... iArr) {
        Preconditions.E(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(s(iArr[0]));
        for (int i2 = 1; i2 < iArr.length; i2++) {
            sb.append(str);
            sb.append(s(iArr[i2]));
        }
        return sb.toString();
    }

    public static Comparator<int[]> g() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int h(int... iArr) {
        Preconditions.d(iArr.length > 0);
        int e2 = e(iArr[0]);
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int e3 = e(iArr[i2]);
            if (e3 > e2) {
                e2 = e3;
            }
        }
        return e(e2);
    }

    public static int i(int... iArr) {
        Preconditions.d(iArr.length > 0);
        int e2 = e(iArr[0]);
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int e3 = e(iArr[i2]);
            if (e3 < e2) {
                e2 = e3;
            }
        }
        return e(e2);
    }

    @CanIgnoreReturnValue
    public static int j(String str) {
        return k(str, 10);
    }

    @CanIgnoreReturnValue
    public static int k(String str, int i2) {
        Preconditions.E(str);
        long parseLong = Long.parseLong(str, i2);
        if ((4294967295L & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i2 + " is not in the range of an unsigned integer");
    }

    public static int l(int i2, int i3) {
        return (int) (r(i2) % r(i3));
    }

    public static int m(long j2) {
        if (j2 <= 0) {
            return 0;
        }
        if (j2 >= 4294967296L) {
            return -1;
        }
        return (int) j2;
    }

    public static void n(int[] iArr) {
        Preconditions.E(iArr);
        o(iArr, 0, iArr.length);
    }

    public static void o(int[] iArr, int i2, int i3) {
        Preconditions.E(iArr);
        Preconditions.f0(i2, i3, iArr.length);
        for (int i4 = i2; i4 < i3; i4++) {
            iArr[i4] = e(iArr[i4]);
        }
        Arrays.sort(iArr, i2, i3);
        while (i2 < i3) {
            iArr[i2] = e(iArr[i2]);
            i2++;
        }
    }

    public static void p(int[] iArr) {
        Preconditions.E(iArr);
        q(iArr, 0, iArr.length);
    }

    public static void q(int[] iArr, int i2, int i3) {
        Preconditions.E(iArr);
        Preconditions.f0(i2, i3, iArr.length);
        for (int i4 = i2; i4 < i3; i4++) {
            iArr[i4] = Integer.MAX_VALUE ^ iArr[i4];
        }
        Arrays.sort(iArr, i2, i3);
        while (i2 < i3) {
            iArr[i2] = iArr[i2] ^ Integer.MAX_VALUE;
            i2++;
        }
    }

    public static long r(int i2) {
        return ((long) i2) & 4294967295L;
    }

    public static String s(int i2) {
        return t(i2, 10);
    }

    public static String t(int i2, int i3) {
        return Long.toString(((long) i2) & 4294967295L, i3);
    }
}
