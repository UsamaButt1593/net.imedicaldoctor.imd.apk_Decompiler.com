package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {
    private static final long X = -6505348102511208375L;
    private static final long X2 = -4132994306676758123L;
    private static final long Y = -8261664234251669945L;
    private static final long Z = -4288712594273399085L;
    static final HashFunction s = new Fingerprint2011();

    Fingerprint2011() {
    }

    @VisibleForTesting
    static long l(byte[] bArr, int i2, int i3) {
        long p = i3 <= 32 ? p(bArr, i2, i3, -1397348546323613475L) : i3 <= 64 ? o(bArr, i2, i3) : m(bArr, i2, i3);
        long j2 = X;
        long b2 = i3 >= 8 ? LittleEndianByteArray.b(bArr, i2) : -6505348102511208375L;
        if (i3 >= 9) {
            j2 = LittleEndianByteArray.b(bArr, (i2 + i3) - 8);
        }
        long n2 = n(p + j2, b2);
        return (n2 == 0 || n2 == 1) ? n2 - 2 : n2;
    }

    private static long m(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = bArr;
        int i4 = i3;
        long b2 = LittleEndianByteArray.b(bArr, i2);
        int i5 = i2 + i4;
        long b3 = LittleEndianByteArray.b(bArr2, i5 - 16) ^ Y;
        long b4 = LittleEndianByteArray.b(bArr2, i5 - 56) ^ X;
        long[] jArr = new long[2];
        long j2 = (long) i4;
        byte[] bArr3 = bArr;
        long[] jArr2 = new long[2];
        long[] jArr3 = jArr;
        r(bArr3, i5 - 64, j2, b3, jArr);
        r(bArr3, i5 - 32, j2 * Y, X, jArr2);
        long q = b4 + (q(jArr3[1]) * Y);
        long rotateRight = Long.rotateRight(q + b2, 39) * Y;
        long rotateRight2 = Long.rotateRight(b3, 33) * Y;
        int i6 = i2;
        int i7 = (i4 - 1) & -64;
        while (true) {
            long rotateRight3 = Long.rotateRight(rotateRight + rotateRight2 + jArr3[0] + LittleEndianByteArray.b(bArr2, i6 + 16), 37) * Y;
            long rotateRight4 = Long.rotateRight(rotateRight2 + jArr3[1] + LittleEndianByteArray.b(bArr2, i6 + 48), 42) * Y;
            long j3 = rotateRight3 ^ jArr2[1];
            long j4 = rotateRight4 ^ jArr3[0];
            long rotateRight5 = Long.rotateRight(q ^ jArr2[0], 33);
            byte[] bArr4 = bArr;
            r(bArr4, i6, jArr3[1] * Y, j3 + jArr2[0], jArr3);
            r(bArr4, i6 + 32, jArr2[1] + rotateRight5, j4, jArr2);
            i6 += 64;
            i7 -= 64;
            if (i7 == 0) {
                return n(n(jArr3[0], jArr2[0]) + (q(j4) * Y) + j3, n(jArr3[1], jArr2[1]) + rotateRight5);
            }
            rotateRight = rotateRight5;
            q = j3;
            rotateRight2 = j4;
        }
    }

    @VisibleForTesting
    static long n(long j2, long j3) {
        long j4 = (j3 ^ j2) * X2;
        long j5 = (j2 ^ (j4 ^ (j4 >>> 47))) * X2;
        return (j5 ^ (j5 >>> 47)) * X2;
    }

    private static long o(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = bArr;
        int i4 = i3;
        long b2 = LittleEndianByteArray.b(bArr2, i2 + 24);
        long j2 = (long) i4;
        int i5 = i2 + i4;
        int i6 = i5 - 16;
        long b3 = LittleEndianByteArray.b(bArr, i2) + ((j2 + LittleEndianByteArray.b(bArr2, i6)) * X);
        long rotateRight = Long.rotateRight(b3 + b2, 52);
        long rotateRight2 = Long.rotateRight(b3, 37);
        long b4 = b3 + LittleEndianByteArray.b(bArr2, i2 + 8);
        int i7 = i2 + 16;
        long b5 = b4 + LittleEndianByteArray.b(bArr2, i7);
        long j3 = b2 + b5;
        long rotateRight3 = rotateRight + Long.rotateRight(b5, 31) + rotateRight2 + Long.rotateRight(b4, 7);
        long b6 = LittleEndianByteArray.b(bArr2, i7) + LittleEndianByteArray.b(bArr2, i5 - 32);
        long b7 = LittleEndianByteArray.b(bArr2, i5 - 8);
        long j4 = rotateRight3;
        long rotateRight4 = Long.rotateRight(b6 + b7, 52);
        long rotateRight5 = Long.rotateRight(b6, 37);
        long b8 = b6 + LittleEndianByteArray.b(bArr2, i5 - 24);
        long b9 = b8 + LittleEndianByteArray.b(bArr2, i6);
        long rotateRight6 = rotateRight4 + Long.rotateRight(b9, 31);
        long j5 = j4;
        return q((q(((j3 + rotateRight6 + rotateRight5 + Long.rotateRight(b8, 7)) * Z) + ((b7 + b9 + j5) * X)) * X) + j5) * Z;
    }

    @VisibleForTesting
    static long p(byte[] bArr, int i2, int i3, long j2) {
        int i4 = i3 & -8;
        int i5 = i3 & 7;
        long j3 = j2 ^ (((long) i3) * X2);
        for (int i6 = 0; i6 < i4; i6 += 8) {
            j3 = (j3 ^ (q(LittleEndianByteArray.b(bArr, i2 + i6) * X2) * X2)) * X2;
        }
        if (i5 != 0) {
            j3 = (LittleEndianByteArray.c(bArr, i2 + i4, i5) ^ j3) * X2;
        }
        return q(q(j3) * X2);
    }

    private static long q(long j2) {
        return j2 ^ (j2 >>> 47);
    }

    private static void r(byte[] bArr, int i2, long j2, long j3, long[] jArr) {
        long b2 = LittleEndianByteArray.b(bArr, i2);
        long b3 = LittleEndianByteArray.b(bArr, i2 + 8);
        long b4 = LittleEndianByteArray.b(bArr, i2 + 16);
        long b5 = LittleEndianByteArray.b(bArr, i2 + 24);
        long j4 = j2 + b2;
        long j5 = b3 + j4 + b4;
        jArr[0] = j5 + b5;
        jArr[1] = Long.rotateRight(j3 + j4 + b5, 51) + Long.rotateRight(j5, 23) + j4;
    }

    public int h() {
        return 64;
    }

    public HashCode j(byte[] bArr, int i2, int i3) {
        Preconditions.f0(i2, i2 + i3, bArr.length);
        return HashCode.j(l(bArr, i2, i3));
    }

    public String toString() {
        return "Hashing.fingerprint2011()";
    }
}
