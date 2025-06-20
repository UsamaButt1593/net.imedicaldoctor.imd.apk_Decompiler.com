package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import net.lingala.zip4j.util.InternalZipConstants;

@ElementTypesAreNonnullByDefault
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    private static final long X = -4348849565147123417L;
    private static final long Y = -5435081209227447693L;
    private static final long Z = -7286425919675154353L;
    static final HashFunction s = new FarmHashFingerprint64();

    FarmHashFingerprint64() {
    }

    @VisibleForTesting
    static long l(byte[] bArr, int i2, int i3) {
        return i3 <= 32 ? i3 <= 16 ? m(bArr, i2, i3) : o(bArr, i2, i3) : i3 <= 64 ? p(bArr, i2, i3) : q(bArr, i2, i3);
    }

    private static long m(byte[] bArr, int i2, int i3) {
        if (i3 >= 8) {
            long j2 = (((long) i3) * 2) + Z;
            long b2 = LittleEndianByteArray.b(bArr, i2) + Z;
            long b3 = LittleEndianByteArray.b(bArr, (i2 + i3) - 8);
            return n((Long.rotateRight(b3, 37) * j2) + b2, (Long.rotateRight(b2, 25) + b3) * j2, j2);
        } else if (i3 >= 4) {
            return n(((long) i3) + ((((long) LittleEndianByteArray.a(bArr, i2)) & InternalZipConstants.f30717k) << 3), ((long) LittleEndianByteArray.a(bArr, (i2 + i3) - 4)) & InternalZipConstants.f30717k, ((long) (i3 * 2)) + Z);
        } else if (i3 <= 0) {
            return Z;
        } else {
            return r((((long) ((bArr[i2] & 255) + ((bArr[(i3 >> 1) + i2] & 255) << 8))) * Z) ^ (((long) (i3 + ((bArr[i2 + (i3 - 1)] & 255) << 2))) * X)) * Z;
        }
    }

    private static long n(long j2, long j3, long j4) {
        long j5 = (j2 ^ j3) * j4;
        long j6 = ((j5 ^ (j5 >>> 47)) ^ j3) * j4;
        return (j6 ^ (j6 >>> 47)) * j4;
    }

    private static long o(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = bArr;
        int i4 = i3;
        long j2 = (((long) i4) * 2) + Z;
        long b2 = LittleEndianByteArray.b(bArr, i2) * Y;
        long b3 = LittleEndianByteArray.b(bArr2, i2 + 8);
        int i5 = i2 + i4;
        long b4 = LittleEndianByteArray.b(bArr2, i5 - 8) * j2;
        return n((LittleEndianByteArray.b(bArr2, i5 - 16) * Z) + Long.rotateRight(b2 + b3, 43) + Long.rotateRight(b4, 30), b4 + b2 + Long.rotateRight(b3 + Z, 18), j2);
    }

    private static long p(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = bArr;
        int i4 = i3;
        long j2 = (((long) i4) * 2) + Z;
        long b2 = LittleEndianByteArray.b(bArr, i2) * Z;
        long b3 = LittleEndianByteArray.b(bArr2, i2 + 8);
        int i5 = i2 + i4;
        long b4 = LittleEndianByteArray.b(bArr2, i5 - 8) * j2;
        long rotateRight = Long.rotateRight(b2 + b3, 43) + Long.rotateRight(b4, 30) + (LittleEndianByteArray.b(bArr2, i5 - 16) * Z);
        long n2 = n(rotateRight, b4 + Long.rotateRight(b3 + Z, 18) + b2, j2);
        long b5 = LittleEndianByteArray.b(bArr2, i2 + 16) * j2;
        long b6 = LittleEndianByteArray.b(bArr2, i2 + 24);
        long b7 = (rotateRight + LittleEndianByteArray.b(bArr2, i5 - 32)) * j2;
        return n(((n2 + LittleEndianByteArray.b(bArr2, i5 - 24)) * j2) + Long.rotateRight(b5 + b6, 43) + Long.rotateRight(b7, 30), b5 + Long.rotateRight(b6 + b2, 18) + b7, j2);
    }

    private static long q(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = bArr;
        long j2 = (long) 81;
        long j3 = (j2 * Y) + 113;
        long r = r((j3 * Z) + 113) * Z;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long b2 = (j2 * Z) + LittleEndianByteArray.b(bArr, i2);
        int i4 = i3 - 1;
        int i5 = i2 + ((i4 / 64) * 64);
        int i6 = i4 & 63;
        int i7 = i5 + i6;
        int i8 = i7 - 63;
        int i9 = i2;
        while (true) {
            long rotateRight = Long.rotateRight(b2 + j3 + jArr[0] + LittleEndianByteArray.b(bArr2, i9 + 8), 37) * Y;
            long rotateRight2 = Long.rotateRight(j3 + jArr[1] + LittleEndianByteArray.b(bArr2, i9 + 48), 42) * Y;
            long j4 = rotateRight ^ jArr2[1];
            long b3 = rotateRight2 + jArr[0] + LittleEndianByteArray.b(bArr2, i9 + 40);
            long rotateRight3 = Long.rotateRight(r + jArr2[0], 33) * Y;
            s(bArr, i9, jArr[1] * Y, j4 + jArr2[0], jArr);
            s(bArr, i9 + 32, rotateRight3 + jArr2[1], b3 + LittleEndianByteArray.b(bArr2, i9 + 16), jArr2);
            int i10 = i9 + 64;
            if (i10 == i5) {
                long j5 = Y + ((j4 & 255) << 1);
                long j6 = jArr2[0] + ((long) i6);
                jArr2[0] = j6;
                long j7 = jArr[0] + j6;
                jArr[0] = j7;
                jArr2[0] = jArr2[0] + j7;
                long rotateRight4 = (Long.rotateRight(((rotateRight3 + b3) + jArr[0]) + LittleEndianByteArray.b(bArr2, i7 - 55), 37) * j5) ^ (jArr2[1] * 9);
                long rotateRight5 = (Long.rotateRight(b3 + jArr[1] + LittleEndianByteArray.b(bArr2, i7 - 15), 42) * j5) + (jArr[0] * 9) + LittleEndianByteArray.b(bArr2, i7 - 23);
                long rotateRight6 = Long.rotateRight(j4 + jArr2[0], 33) * j5;
                byte[] bArr3 = bArr;
                s(bArr3, i8, jArr[1] * j5, rotateRight4 + jArr2[0], jArr);
                s(bArr3, i7 - 31, rotateRight6 + jArr2[1], rotateRight5 + LittleEndianByteArray.b(bArr2, i7 - 47), jArr2);
                long j8 = j5;
                return n(n(jArr[0], jArr2[0], j8) + (r(rotateRight5) * X) + rotateRight4, n(jArr[1], jArr2[1], j8) + rotateRight6, j8);
            }
            i9 = i10;
            r = j4;
            j3 = b3;
            b2 = rotateRight3;
        }
    }

    private static long r(long j2) {
        return j2 ^ (j2 >>> 47);
    }

    private static void s(byte[] bArr, int i2, long j2, long j3, long[] jArr) {
        long b2 = LittleEndianByteArray.b(bArr, i2);
        long b3 = LittleEndianByteArray.b(bArr, i2 + 8);
        long b4 = LittleEndianByteArray.b(bArr, i2 + 16);
        long b5 = LittleEndianByteArray.b(bArr, i2 + 24);
        long j4 = j2 + b2;
        long j5 = b3 + j4 + b4;
        jArr[0] = j5 + b5;
        jArr[1] = Long.rotateRight(j3 + j4 + b5, 21) + Long.rotateRight(j5, 44) + j4;
    }

    public int h() {
        return 64;
    }

    public HashCode j(byte[] bArr, int i2, int i3) {
        Preconditions.f0(i2, i2 + i3, bArr.length);
        return HashCode.j(l(bArr, i2, i3));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
