package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class SignedBytes {

    /* renamed from: a  reason: collision with root package name */
    public static final byte f22967a = 64;

    private enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        /* renamed from: b */
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int b2 = SignedBytes.b(bArr[i2], bArr2[i2]);
                if (b2 != 0) {
                    return b2;
                }
            }
            return bArr.length - bArr2.length;
        }

        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }

    private SignedBytes() {
    }

    public static byte a(long j2) {
        byte b2 = (byte) ((int) j2);
        Preconditions.p(((long) b2) == j2, "Out of range: %s", j2);
        return b2;
    }

    public static int b(byte b2, byte b3) {
        return b2 - b3;
    }

    public static String c(String str, byte... bArr) {
        Preconditions.E(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 5);
        sb.append(bArr[0]);
        for (int i2 = 1; i2 < bArr.length; i2++) {
            sb.append(str);
            sb.append(bArr[i2]);
        }
        return sb.toString();
    }

    public static Comparator<byte[]> d() {
        return LexicographicalComparator.INSTANCE;
    }

    public static byte e(byte... bArr) {
        Preconditions.d(bArr.length > 0);
        byte b2 = bArr[0];
        for (int i2 = 1; i2 < bArr.length; i2++) {
            byte b3 = bArr[i2];
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    public static byte f(byte... bArr) {
        Preconditions.d(bArr.length > 0);
        byte b2 = bArr[0];
        for (int i2 = 1; i2 < bArr.length; i2++) {
            byte b3 = bArr[i2];
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    public static byte g(long j2) {
        if (j2 > 127) {
            return Byte.MAX_VALUE;
        }
        if (j2 < -128) {
            return Byte.MIN_VALUE;
        }
        return (byte) ((int) j2);
    }

    public static void h(byte[] bArr) {
        Preconditions.E(bArr);
        i(bArr, 0, bArr.length);
    }

    public static void i(byte[] bArr, int i2, int i3) {
        Preconditions.E(bArr);
        Preconditions.f0(i2, i3, bArr.length);
        Arrays.sort(bArr, i2, i3);
        Bytes.n(bArr, i2, i3);
    }
}
