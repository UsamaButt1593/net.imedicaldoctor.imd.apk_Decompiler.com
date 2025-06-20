package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Immutable
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction X = new Murmur3_128HashFunction(0);
    static final HashFunction Y = new Murmur3_128HashFunction(Hashing.f22675a);
    private static final long Z = 0;
    private final int s;

    private static final class Murmur3_128Hasher extends AbstractStreamingHasher {

        /* renamed from: g  reason: collision with root package name */
        private static final int f22690g = 16;

        /* renamed from: h  reason: collision with root package name */
        private static final long f22691h = -8663945395140668459L;

        /* renamed from: i  reason: collision with root package name */
        private static final long f22692i = 5545529020109919103L;

        /* renamed from: d  reason: collision with root package name */
        private long f22693d;

        /* renamed from: e  reason: collision with root package name */
        private long f22694e;

        /* renamed from: f  reason: collision with root package name */
        private int f22695f = 0;

        Murmur3_128Hasher(int i2) {
            super(16);
            long j2 = (long) i2;
            this.f22693d = j2;
            this.f22694e = j2;
        }

        private void v(long j2, long j3) {
            long x = x(j2) ^ this.f22693d;
            this.f22693d = x;
            long rotateLeft = Long.rotateLeft(x, 27);
            long j4 = this.f22694e;
            this.f22693d = ((rotateLeft + j4) * 5) + 1390208809;
            long y = y(j3) ^ j4;
            this.f22694e = y;
            this.f22694e = ((Long.rotateLeft(y, 31) + this.f22693d) * 5) + 944331445;
        }

        private static long w(long j2) {
            long j3 = (j2 ^ (j2 >>> 33)) * -49064778989728563L;
            long j4 = (j3 ^ (j3 >>> 33)) * -4265267296055464877L;
            return j4 ^ (j4 >>> 33);
        }

        private static long x(long j2) {
            return Long.rotateLeft(j2 * f22691h, 31) * f22692i;
        }

        private static long y(long j2) {
            return Long.rotateLeft(j2 * f22692i, 33) * f22691h;
        }

        /* access modifiers changed from: protected */
        public HashCode p() {
            long j2 = this.f22693d;
            int i2 = this.f22695f;
            long j3 = j2 ^ ((long) i2);
            long j4 = this.f22694e ^ ((long) i2);
            long j5 = j3 + j4;
            this.f22693d = j5;
            this.f22694e = j4 + j5;
            this.f22693d = w(j5);
            long w = w(this.f22694e);
            long j6 = this.f22693d + w;
            this.f22693d = j6;
            this.f22694e = w + j6;
            return HashCode.h(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f22693d).putLong(this.f22694e).array());
        }

        /* access modifiers changed from: protected */
        public void s(ByteBuffer byteBuffer) {
            v(byteBuffer.getLong(), byteBuffer.getLong());
            this.f22695f += 16;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0077, code lost:
            r7 = r7 ^ ((long) com.google.common.primitives.UnsignedBytes.p(r14.get(8)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0081, code lost:
            r0 = r14.getLong();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0093, code lost:
            r4 = (((long) com.google.common.primitives.UnsignedBytes.p(r14.get(5))) << 40) ^ r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a2, code lost:
            r3 = r4 ^ (((long) com.google.common.primitives.UnsignedBytes.p(r14.get(4))) << 32);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b1, code lost:
            r2 = r3 ^ (((long) com.google.common.primitives.UnsignedBytes.p(r14.get(3))) << 24);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c0, code lost:
            r0 = (((long) com.google.common.primitives.UnsignedBytes.p(r14.get(2))) << 16) ^ r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00cf, code lost:
            r0 = r0 ^ (((long) com.google.common.primitives.UnsignedBytes.p(r14.get(1))) << 8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00dd, code lost:
            r0 = r0 ^ ((long) com.google.common.primitives.UnsignedBytes.p(r14.get(0)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e8, code lost:
            r13.f22693d = x(r0) ^ r13.f22693d;
            r13.f22694e ^= y(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00fa, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0032, code lost:
            r7 = r7 ^ (((long) com.google.common.primitives.UnsignedBytes.p(r14.get(13))) << 40);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0040, code lost:
            r7 = r7 ^ (((long) com.google.common.primitives.UnsignedBytes.p(r14.get(12))) << 32);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x004e, code lost:
            r7 = r7 ^ (((long) com.google.common.primitives.UnsignedBytes.p(r14.get(11))) << 24);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x005c, code lost:
            r7 = r7 ^ (((long) com.google.common.primitives.UnsignedBytes.p(r14.get(10))) << 16);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x006a, code lost:
            r7 = r7 ^ (((long) com.google.common.primitives.UnsignedBytes.p(r14.get(9))) << 8);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void t(java.nio.ByteBuffer r14) {
            /*
                r13 = this;
                int r0 = r13.f22695f
                int r1 = r14.remaining()
                int r0 = r0 + r1
                r13.f22695f = r0
                int r0 = r14.remaining()
                r1 = 16
                r2 = 24
                r3 = 32
                r4 = 40
                r5 = 48
                r6 = 8
                r7 = 0
                switch(r0) {
                    case 1: goto L_0x00dc;
                    case 2: goto L_0x00ce;
                    case 3: goto L_0x00bf;
                    case 4: goto L_0x00b0;
                    case 5: goto L_0x00a1;
                    case 6: goto L_0x0092;
                    case 7: goto L_0x0086;
                    case 8: goto L_0x0081;
                    case 9: goto L_0x0077;
                    case 10: goto L_0x006a;
                    case 11: goto L_0x005c;
                    case 12: goto L_0x004e;
                    case 13: goto L_0x0040;
                    case 14: goto L_0x0032;
                    case 15: goto L_0x0026;
                    default: goto L_0x001e;
                }
            L_0x001e:
                java.lang.AssertionError r14 = new java.lang.AssertionError
                java.lang.String r0 = "Should never get here."
                r14.<init>(r0)
                throw r14
            L_0x0026:
                r0 = 14
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r7 = (long) r0
                long r7 = r7 << r5
            L_0x0032:
                r0 = 13
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r9 = (long) r0
                long r4 = r9 << r4
                long r7 = r7 ^ r4
            L_0x0040:
                r0 = 12
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r4 = (long) r0
                long r3 = r4 << r3
                long r7 = r7 ^ r3
            L_0x004e:
                r0 = 11
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r3 = (long) r0
                long r2 = r3 << r2
                long r7 = r7 ^ r2
            L_0x005c:
                r0 = 10
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r2 = (long) r0
                long r0 = r2 << r1
                long r7 = r7 ^ r0
            L_0x006a:
                r0 = 9
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r0 = (long) r0
                long r0 = r0 << r6
                long r7 = r7 ^ r0
            L_0x0077:
                byte r0 = r14.get(r6)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r0 = (long) r0
                long r7 = r7 ^ r0
            L_0x0081:
                long r0 = r14.getLong()
                goto L_0x00e8
            L_0x0086:
                r0 = 6
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r9 = (long) r0
                long r9 = r9 << r5
                goto L_0x0093
            L_0x0092:
                r9 = r7
            L_0x0093:
                r0 = 5
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r11 = (long) r0
                long r4 = r11 << r4
                long r4 = r4 ^ r9
                goto L_0x00a2
            L_0x00a1:
                r4 = r7
            L_0x00a2:
                r0 = 4
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r9 = (long) r0
                long r9 = r9 << r3
                long r3 = r4 ^ r9
                goto L_0x00b1
            L_0x00b0:
                r3 = r7
            L_0x00b1:
                r0 = 3
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r9 = (long) r0
                long r9 = r9 << r2
                long r2 = r3 ^ r9
                goto L_0x00c0
            L_0x00bf:
                r2 = r7
            L_0x00c0:
                r0 = 2
                byte r0 = r14.get(r0)
                int r0 = com.google.common.primitives.UnsignedBytes.p(r0)
                long r4 = (long) r0
                long r0 = r4 << r1
                long r0 = r0 ^ r2
                goto L_0x00cf
            L_0x00ce:
                r0 = r7
            L_0x00cf:
                r2 = 1
                byte r2 = r14.get(r2)
                int r2 = com.google.common.primitives.UnsignedBytes.p(r2)
                long r2 = (long) r2
                long r2 = r2 << r6
                long r0 = r0 ^ r2
                goto L_0x00dd
            L_0x00dc:
                r0 = r7
            L_0x00dd:
                r2 = 0
                byte r14 = r14.get(r2)
                int r14 = com.google.common.primitives.UnsignedBytes.p(r14)
                long r2 = (long) r14
                long r0 = r0 ^ r2
            L_0x00e8:
                long r2 = r13.f22693d
                long r0 = x(r0)
                long r0 = r0 ^ r2
                r13.f22693d = r0
                long r0 = r13.f22694e
                long r2 = y(r7)
                long r0 = r0 ^ r2
                r13.f22694e = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Murmur3_128HashFunction.Murmur3_128Hasher.t(java.nio.ByteBuffer):void");
        }
    }

    Murmur3_128HashFunction(int i2) {
        this.s = i2;
    }

    public Hasher b() {
        return new Murmur3_128Hasher(this.s);
    }

    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.s == ((Murmur3_128HashFunction) obj).s;
    }

    public int h() {
        return 128;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.s;
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.s + ")";
    }
}
