package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Immutable
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction X2 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long Y2 = 0;
    private final int X;
    private final long Y;
    private final long Z;
    private final int s;

    private static final class SipHasher extends AbstractStreamingHasher {

        /* renamed from: l  reason: collision with root package name */
        private static final int f22701l = 8;

        /* renamed from: d  reason: collision with root package name */
        private final int f22702d;

        /* renamed from: e  reason: collision with root package name */
        private final int f22703e;

        /* renamed from: f  reason: collision with root package name */
        private long f22704f;

        /* renamed from: g  reason: collision with root package name */
        private long f22705g;

        /* renamed from: h  reason: collision with root package name */
        private long f22706h;

        /* renamed from: i  reason: collision with root package name */
        private long f22707i;

        /* renamed from: j  reason: collision with root package name */
        private long f22708j = 0;

        /* renamed from: k  reason: collision with root package name */
        private long f22709k = 0;

        SipHasher(int i2, int i3, long j2, long j3) {
            super(8);
            this.f22702d = i2;
            this.f22703e = i3;
            this.f22704f = 8317987319222330741L ^ j2;
            this.f22705g = 7237128888997146477L ^ j3;
            this.f22706h = 7816392313619706465L ^ j2;
            this.f22707i = 8387220255154660723L ^ j3;
        }

        private void v(long j2) {
            this.f22707i ^= j2;
            w(this.f22702d);
            this.f22704f = j2 ^ this.f22704f;
        }

        private void w(int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = this.f22704f;
                long j3 = this.f22705g;
                this.f22704f = j2 + j3;
                this.f22706h += this.f22707i;
                this.f22705g = Long.rotateLeft(j3, 13);
                long rotateLeft = Long.rotateLeft(this.f22707i, 16);
                long j4 = this.f22705g;
                long j5 = this.f22704f;
                this.f22705g = j4 ^ j5;
                this.f22707i = rotateLeft ^ this.f22706h;
                long rotateLeft2 = Long.rotateLeft(j5, 32);
                long j6 = this.f22706h;
                long j7 = this.f22705g;
                this.f22706h = j6 + j7;
                this.f22704f = rotateLeft2 + this.f22707i;
                this.f22705g = Long.rotateLeft(j7, 17);
                long rotateLeft3 = Long.rotateLeft(this.f22707i, 21);
                long j8 = this.f22705g;
                long j9 = this.f22706h;
                this.f22705g = j8 ^ j9;
                this.f22707i = rotateLeft3 ^ this.f22704f;
                this.f22706h = Long.rotateLeft(j9, 32);
            }
        }

        /* access modifiers changed from: protected */
        public HashCode p() {
            long j2 = this.f22709k ^ (this.f22708j << 56);
            this.f22709k = j2;
            v(j2);
            this.f22706h ^= 255;
            w(this.f22703e);
            return HashCode.j(((this.f22704f ^ this.f22705g) ^ this.f22706h) ^ this.f22707i);
        }

        /* access modifiers changed from: protected */
        public void s(ByteBuffer byteBuffer) {
            this.f22708j += 8;
            v(byteBuffer.getLong());
        }

        /* access modifiers changed from: protected */
        public void t(ByteBuffer byteBuffer) {
            this.f22708j += (long) byteBuffer.remaining();
            int i2 = 0;
            while (byteBuffer.hasRemaining()) {
                this.f22709k ^= (((long) byteBuffer.get()) & 255) << i2;
                i2 += 8;
            }
        }
    }

    SipHashFunction(int i2, int i3, long j2, long j3) {
        boolean z = false;
        Preconditions.k(i2 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i2);
        Preconditions.k(i3 > 0 ? true : z, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i3);
        this.s = i2;
        this.X = i3;
        this.Y = j2;
        this.Z = j3;
    }

    public Hasher b() {
        return new SipHasher(this.s, this.X, this.Y, this.Z);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        return this.s == sipHashFunction.s && this.X == sipHashFunction.X && this.Y == sipHashFunction.Y && this.Z == sipHashFunction.Z;
    }

    public int h() {
        return 64;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.s) ^ this.X)) ^ this.Y) ^ this.Z);
    }

    public String toString() {
        return "Hashing.sipHash" + this.s + "" + this.X + "(" + this.Y + ", " + this.Z + ")";
    }
}
