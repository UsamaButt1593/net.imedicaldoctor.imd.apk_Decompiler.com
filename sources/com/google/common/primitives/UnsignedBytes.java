package com.google.common.primitives;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class UnsignedBytes {

    /* renamed from: a  reason: collision with root package name */
    public static final byte f22968a = Byte.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public static final byte f22969b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f22970c = 255;

    @VisibleForTesting
    static class LexicographicalComparatorHolder {

        /* renamed from: a  reason: collision with root package name */
        static final String f22971a = (LexicographicalComparatorHolder.class.getName() + "$UnsafeComparator");

        /* renamed from: b  reason: collision with root package name */
        static final Comparator<byte[]> f22972b = a();

        enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            /* renamed from: b */
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                for (int i2 = 0; i2 < min; i2++) {
                    int b2 = UnsignedBytes.b(bArr[i2], bArr2[i2]);
                    if (b2 != 0) {
                        return b2;
                    }
                }
                return bArr.length - bArr2.length;
            }

            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }
        }

        @VisibleForTesting
        enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;
            
            static final boolean X = false;
            static final Unsafe Y = null;
            static final int Z = 0;

            static {
                X = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
                Unsafe c2 = c();
                Y = c2;
                Class<byte[]> cls = byte[].class;
                int arrayBaseOffset = c2.arrayBaseOffset(cls);
                Z = arrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || arrayBaseOffset % 8 != 0 || c2.arrayIndexScale(cls) != 1) {
                    throw new Error();
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
                return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.AnonymousClass1());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
                throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static sun.misc.Unsafe c() {
                /*
                    sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
                    return r0
                L_0x0005:
                    com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1 r0 = new com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1     // Catch:{ PrivilegedActionException -> 0x0011 }
                    r0.<init>()     // Catch:{ PrivilegedActionException -> 0x0011 }
                    java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x0011 }
                    sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x0011 }
                    return r0
                L_0x0011:
                    r0 = move-exception
                    java.lang.RuntimeException r1 = new java.lang.RuntimeException
                    java.lang.String r2 = "Could not initialize intrinsics"
                    java.lang.Throwable r0 = r0.getCause()
                    r1.<init>(r2, r0)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.c():sun.misc.Unsafe");
            }

            /* renamed from: b */
            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                int i2 = min & -8;
                int i3 = 0;
                while (i3 < i2) {
                    Unsafe unsafe = Y;
                    int i4 = Z;
                    long j2 = (long) i3;
                    long j3 = unsafe.getLong(bArr, ((long) i4) + j2);
                    long j4 = unsafe.getLong(bArr2, ((long) i4) + j2);
                    if (j3 == j4) {
                        i3 += 8;
                    } else if (X) {
                        return UnsignedLongs.a(j3, j4);
                    } else {
                        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j3 ^ j4) & -8;
                        return ((int) ((j3 >>> numberOfTrailingZeros) & 255)) - ((int) ((j4 >>> numberOfTrailingZeros) & 255));
                    }
                }
                while (i3 < min) {
                    int b2 = UnsignedBytes.b(bArr[i3], bArr2[i3]);
                    if (b2 != 0) {
                        return b2;
                    }
                    i3++;
                }
                return bArr.length - bArr2.length;
            }

            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }
        }

        LexicographicalComparatorHolder() {
        }

        static Comparator<byte[]> a() {
            try {
                Object[] enumConstants = Class.forName(f22971a).getEnumConstants();
                Objects.requireNonNull(enumConstants);
                return (Comparator) enumConstants[0];
            } catch (Throwable unused) {
                return UnsignedBytes.f();
            }
        }
    }

    private UnsignedBytes() {
    }

    @CanIgnoreReturnValue
    public static byte a(long j2) {
        Preconditions.p((j2 >> 8) == 0, "out of range: %s", j2);
        return (byte) ((int) j2);
    }

    public static int b(byte b2, byte b3) {
        return p(b2) - p(b3);
    }

    private static byte c(byte b2) {
        return (byte) (b2 ^ 128);
    }

    public static String d(String str, byte... bArr) {
        Preconditions.E(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * (str.length() + 3));
        sb.append(p(bArr[0]));
        for (int i2 = 1; i2 < bArr.length; i2++) {
            sb.append(str);
            sb.append(q(bArr[i2]));
        }
        return sb.toString();
    }

    public static Comparator<byte[]> e() {
        return LexicographicalComparatorHolder.f22972b;
    }

    @VisibleForTesting
    static Comparator<byte[]> f() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    public static byte g(byte... bArr) {
        Preconditions.d(bArr.length > 0);
        int p = p(bArr[0]);
        for (int i2 = 1; i2 < bArr.length; i2++) {
            int p2 = p(bArr[i2]);
            if (p2 > p) {
                p = p2;
            }
        }
        return (byte) p;
    }

    public static byte h(byte... bArr) {
        Preconditions.d(bArr.length > 0);
        int p = p(bArr[0]);
        for (int i2 = 1; i2 < bArr.length; i2++) {
            int p2 = p(bArr[i2]);
            if (p2 < p) {
                p = p2;
            }
        }
        return (byte) p;
    }

    @CanIgnoreReturnValue
    public static byte i(String str) {
        return j(str, 10);
    }

    @CanIgnoreReturnValue
    public static byte j(String str, int i2) {
        int parseInt = Integer.parseInt((String) Preconditions.E(str), i2);
        if ((parseInt >> 8) == 0) {
            return (byte) parseInt;
        }
        throw new NumberFormatException("out of range: " + parseInt);
    }

    public static byte k(long j2) {
        if (j2 > ((long) p((byte) -1))) {
            return -1;
        }
        if (j2 < 0) {
            return 0;
        }
        return (byte) ((int) j2);
    }

    public static void l(byte[] bArr) {
        Preconditions.E(bArr);
        m(bArr, 0, bArr.length);
    }

    public static void m(byte[] bArr, int i2, int i3) {
        Preconditions.E(bArr);
        Preconditions.f0(i2, i3, bArr.length);
        for (int i4 = i2; i4 < i3; i4++) {
            bArr[i4] = c(bArr[i4]);
        }
        Arrays.sort(bArr, i2, i3);
        while (i2 < i3) {
            bArr[i2] = c(bArr[i2]);
            i2++;
        }
    }

    public static void n(byte[] bArr) {
        Preconditions.E(bArr);
        o(bArr, 0, bArr.length);
    }

    public static void o(byte[] bArr, int i2, int i3) {
        Preconditions.E(bArr);
        Preconditions.f0(i2, i3, bArr.length);
        for (int i4 = i2; i4 < i3; i4++) {
            bArr[i4] = (byte) (bArr[i4] ^ Byte.MAX_VALUE);
        }
        Arrays.sort(bArr, i2, i3);
        while (i2 < i3) {
            bArr[i2] = (byte) (bArr[i2] ^ Byte.MAX_VALUE);
            i2++;
        }
    }

    public static int p(byte b2) {
        return b2 & 255;
    }

    public static String q(byte b2) {
        return r(b2, 10);
    }

    public static String r(byte b2, int i2) {
        Preconditions.k(i2 >= 2 && i2 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i2);
        return Integer.toString(p(b2), i2);
    }
}
