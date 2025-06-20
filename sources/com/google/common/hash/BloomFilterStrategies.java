package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 {
        public <T> boolean G(@ParametricNullness T t, Funnel<? super T> funnel, int i2, LockFreeBitArray lockFreeBitArray) {
            long b2 = lockFreeBitArray.b();
            long c2 = Hashing.x().d(t, funnel).c();
            int i3 = (int) c2;
            int i4 = (int) (c2 >>> 32);
            for (int i5 = 1; i5 <= i2; i5++) {
                int i6 = (i5 * i4) + i3;
                if (i6 < 0) {
                    i6 = ~i6;
                }
                if (!lockFreeBitArray.e(((long) i6) % b2)) {
                    return false;
                }
            }
            return true;
        }

        public <T> boolean g0(@ParametricNullness T t, Funnel<? super T> funnel, int i2, LockFreeBitArray lockFreeBitArray) {
            long b2 = lockFreeBitArray.b();
            long c2 = Hashing.x().d(t, funnel).c();
            int i3 = (int) c2;
            int i4 = (int) (c2 >>> 32);
            boolean z = false;
            for (int i5 = 1; i5 <= i2; i5++) {
                int i6 = (i5 * i4) + i3;
                if (i6 < 0) {
                    i6 = ~i6;
                }
                z |= lockFreeBitArray.h(((long) i6) % b2);
            }
            return z;
        }
    },
    MURMUR128_MITZ_64 {
        private long b(byte[] bArr) {
            return Longs.k(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long c(byte[] bArr) {
            return Longs.k(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        public <T> boolean G(@ParametricNullness T t, Funnel<? super T> funnel, int i2, LockFreeBitArray lockFreeBitArray) {
            long b2 = lockFreeBitArray.b();
            byte[] l2 = Hashing.x().d(t, funnel).l();
            long b3 = b(l2);
            long c2 = c(l2);
            for (int i3 = 0; i3 < i2; i3++) {
                if (!lockFreeBitArray.e((Long.MAX_VALUE & b3) % b2)) {
                    return false;
                }
                b3 += c2;
            }
            return true;
        }

        public <T> boolean g0(@ParametricNullness T t, Funnel<? super T> funnel, int i2, LockFreeBitArray lockFreeBitArray) {
            long b2 = lockFreeBitArray.b();
            byte[] l2 = Hashing.x().d(t, funnel).l();
            long b3 = b(l2);
            long c2 = c(l2);
            boolean z = false;
            for (int i3 = 0; i3 < i2; i3++) {
                z |= lockFreeBitArray.h((Long.MAX_VALUE & b3) % b2);
                b3 += c2;
            }
            return z;
        }
    };

    static final class LockFreeBitArray {

        /* renamed from: c  reason: collision with root package name */
        private static final int f22661c = 6;

        /* renamed from: a  reason: collision with root package name */
        final AtomicLongArray f22662a;

        /* renamed from: b  reason: collision with root package name */
        private final LongAddable f22663b;

        LockFreeBitArray(long j2) {
            Preconditions.e(j2 > 0, "data length is zero!");
            this.f22662a = new AtomicLongArray(Ints.d(LongMath.g(j2, 64, RoundingMode.CEILING)));
            this.f22663b = LongAddables.a();
        }

        public static long[] i(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr[i2] = atomicLongArray.get(i2);
            }
            return jArr;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.f22663b.c();
        }

        /* access modifiers changed from: package-private */
        public long b() {
            return ((long) this.f22662a.length()) * 64;
        }

        /* access modifiers changed from: package-private */
        public LockFreeBitArray c() {
            return new LockFreeBitArray(i(this.f22662a));
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return this.f22662a.length();
        }

        /* access modifiers changed from: package-private */
        public boolean e(long j2) {
            return ((1 << ((int) j2)) & this.f22662a.get((int) (j2 >>> 6))) != 0;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof LockFreeBitArray) {
                return Arrays.equals(i(this.f22662a), i(((LockFreeBitArray) obj).f22662a));
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void f(LockFreeBitArray lockFreeBitArray) {
            Preconditions.m(this.f22662a.length() == lockFreeBitArray.f22662a.length(), "BitArrays must be of equal length (%s != %s)", this.f22662a.length(), lockFreeBitArray.f22662a.length());
            for (int i2 = 0; i2 < this.f22662a.length(); i2++) {
                g(i2, lockFreeBitArray.f22662a.get(i2));
            }
        }

        /* access modifiers changed from: package-private */
        public void g(int i2, long j2) {
            long j3;
            long j4;
            do {
                j3 = this.f22662a.get(i2);
                j4 = j3 | j2;
                if (j3 == j4) {
                    return;
                }
            } while (!this.f22662a.compareAndSet(i2, j3, j4));
            this.f22663b.a((long) (Long.bitCount(j4) - Long.bitCount(j3)));
        }

        /* access modifiers changed from: package-private */
        public boolean h(long j2) {
            long j3;
            long j4;
            if (e(j2)) {
                return false;
            }
            int i2 = (int) (j2 >>> 6);
            long j5 = 1 << ((int) j2);
            do {
                j3 = this.f22662a.get(i2);
                j4 = j3 | j5;
                if (j3 == j4) {
                    return false;
                }
            } while (!this.f22662a.compareAndSet(i2, j3, j4));
            this.f22663b.b();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(i(this.f22662a));
        }

        LockFreeBitArray(long[] jArr) {
            Preconditions.e(jArr.length > 0, "data length is zero!");
            this.f22662a = new AtomicLongArray(jArr);
            this.f22663b = LongAddables.a();
            long j2 = 0;
            for (long bitCount : jArr) {
                j2 += (long) Long.bitCount(bitCount);
            }
            this.f22663b.a(j2);
        }
    }
}
