package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import javax.annotation.CheckForNull;
import net.lingala.zip4j.util.InternalZipConstants;

@ElementTypesAreNonnullByDefault
@Immutable
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction X2 = new Murmur3_32HashFunction(Hashing.f22675a, true);
    static final HashFunction Y = new Murmur3_32HashFunction(0, false);
    private static final int Y2 = 4;
    static final HashFunction Z = new Murmur3_32HashFunction(0, true);
    private static final int Z2 = -862048943;
    private static final int a3 = 461845907;
    private static final long b3 = 0;
    private final boolean X;
    private final int s;

    private static final class Murmur3_32Hasher extends AbstractHasher {

        /* renamed from: a  reason: collision with root package name */
        private int f22696a;

        /* renamed from: b  reason: collision with root package name */
        private long f22697b;

        /* renamed from: c  reason: collision with root package name */
        private int f22698c;

        /* renamed from: d  reason: collision with root package name */
        private int f22699d = 0;

        /* renamed from: e  reason: collision with root package name */
        private boolean f22700e = false;

        Murmur3_32Hasher(int i2) {
            this.f22696a = i2;
        }

        private void p(int i2, long j2) {
            long j3 = this.f22697b;
            long j4 = j2 & InternalZipConstants.f30717k;
            int i3 = this.f22698c;
            long j5 = (j4 << i3) | j3;
            this.f22697b = j5;
            int i4 = i3 + (i2 * 8);
            this.f22698c = i4;
            this.f22699d += i2;
            if (i4 >= 32) {
                this.f22696a = Murmur3_32HashFunction.x(this.f22696a, Murmur3_32HashFunction.y((int) j5));
                this.f22697b >>>= 32;
                this.f22698c -= 32;
            }
        }

        @CanIgnoreReturnValue
        public Hasher e(int i2) {
            p(4, (long) i2);
            return this;
        }

        @CanIgnoreReturnValue
        public Hasher f(long j2) {
            p(4, (long) ((int) j2));
            p(4, j2 >>> 32);
            return this;
        }

        @CanIgnoreReturnValue
        public Hasher h(byte b2) {
            p(1, (long) (b2 & 255));
            return this;
        }

        @CanIgnoreReturnValue
        public Hasher j(byte[] bArr, int i2, int i3) {
            Preconditions.f0(i2, i2 + i3, bArr.length);
            int i4 = 0;
            while (true) {
                int i5 = i4 + 4;
                if (i5 > i3) {
                    break;
                }
                p(4, (long) Murmur3_32HashFunction.w(bArr, i4 + i2));
                i4 = i5;
            }
            while (i4 < i3) {
                h(bArr[i2 + i4]);
                i4++;
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Hasher k(char c2) {
            p(2, (long) c2);
            return this;
        }

        @CanIgnoreReturnValue
        public Hasher l(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                e(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                h(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }

        @CanIgnoreReturnValue
        public Hasher m(CharSequence charSequence, Charset charset) {
            long p;
            int i2;
            if (!Charsets.f22255c.equals(charset)) {
                return super.m(charSequence, charset);
            }
            int length = charSequence.length();
            int i3 = 0;
            while (true) {
                int i4 = i3 + 4;
                if (i4 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i3);
                char charAt2 = charSequence.charAt(i3 + 1);
                char charAt3 = charSequence.charAt(i3 + 2);
                char charAt4 = charSequence.charAt(i3 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                p(4, (long) ((charAt2 << 8) | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i3 = i4;
            }
            while (i3 < length) {
                char charAt5 = charSequence.charAt(i3);
                if (charAt5 < 128) {
                    p(1, (long) charAt5);
                } else {
                    if (charAt5 < 2048) {
                        p = Murmur3_32HashFunction.t(charAt5);
                        i2 = 2;
                    } else if (charAt5 < 55296 || charAt5 > 57343) {
                        p = Murmur3_32HashFunction.s(charAt5);
                        i2 = 3;
                    } else {
                        int codePointAt = Character.codePointAt(charSequence, i3);
                        if (codePointAt == charAt5) {
                            g(charSequence.subSequence(i3, length).toString().getBytes(charset));
                            return this;
                        }
                        i3++;
                        p(4, Murmur3_32HashFunction.u(codePointAt));
                    }
                    p(i2, p);
                }
                i3++;
            }
            return this;
        }

        public HashCode o() {
            Preconditions.g0(!this.f22700e);
            this.f22700e = true;
            int l2 = this.f22696a ^ Murmur3_32HashFunction.y((int) this.f22697b);
            this.f22696a = l2;
            return Murmur3_32HashFunction.v(l2, this.f22699d);
        }
    }

    Murmur3_32HashFunction(int i2, boolean z) {
        this.s = i2;
        this.X = z;
    }

    /* access modifiers changed from: private */
    public static long s(char c2) {
        return ((long) (c2 >>> 12)) | 224 | ((long) ((((c2 >>> 6) & 63) | 128) << 8)) | ((long) (((c2 & '?') | 128) << 16));
    }

    /* access modifiers changed from: private */
    public static long t(char c2) {
        return ((long) (c2 >>> 6)) | 192 | ((long) (((c2 & '?') | 128) << 8));
    }

    /* access modifiers changed from: private */
    public static long u(int i2) {
        return ((long) (i2 >>> 18)) | 240 | ((((long) ((i2 >>> 12) & 63)) | 128) << 8) | ((((long) ((i2 >>> 6) & 63)) | 128) << 16) | ((((long) (i2 & 63)) | 128) << 24);
    }

    /* access modifiers changed from: private */
    public static HashCode v(int i2, int i3) {
        int i4 = i2 ^ i3;
        int i5 = (i4 ^ (i4 >>> 16)) * -2048144789;
        int i6 = (i5 ^ (i5 >>> 13)) * -1028477387;
        return HashCode.i(i6 ^ (i6 >>> 16));
    }

    /* access modifiers changed from: private */
    public static int w(byte[] bArr, int i2) {
        return Ints.k(bArr[i2 + 3], bArr[i2 + 2], bArr[i2 + 1], bArr[i2]);
    }

    /* access modifiers changed from: private */
    public static int x(int i2, int i3) {
        return (Integer.rotateLeft(i2 ^ i3, 13) * 5) - 430675100;
    }

    /* access modifiers changed from: private */
    public static int y(int i2) {
        return Integer.rotateLeft(i2 * Z2, 15) * a3;
    }

    public Hasher b() {
        return new Murmur3_32Hasher(this.s);
    }

    public HashCode c(int i2) {
        return v(x(this.s, y(i2)), 4);
    }

    public HashCode e(CharSequence charSequence, Charset charset) {
        int i2;
        if (!Charsets.f22255c.equals(charset)) {
            return a(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int i3 = this.s;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i5 + 4;
            if (i7 > length) {
                break;
            }
            char charAt = charSequence.charAt(i5);
            char charAt2 = charSequence.charAt(i5 + 1);
            char charAt3 = charSequence.charAt(i5 + 2);
            char charAt4 = charSequence.charAt(i5 + 3);
            if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                break;
            }
            i3 = x(i3, y((charAt2 << 8) | charAt | (charAt3 << 16) | (charAt4 << 24)));
            i6 = i2 + 4;
            i5 = i7;
        }
        long j2 = 0;
        while (i5 < length) {
            char charAt5 = charSequence.charAt(i5);
            if (charAt5 < 128) {
                j2 |= ((long) charAt5) << i4;
                i4 += 8;
                i2++;
            } else if (charAt5 < 2048) {
                j2 |= t(charAt5) << i4;
                i4 += 16;
                i2 += 2;
            } else if (charAt5 < 55296 || charAt5 > 57343) {
                j2 |= s(charAt5) << i4;
                i4 += 24;
                i2 += 3;
            } else {
                int codePointAt = Character.codePointAt(charSequence, i5);
                if (codePointAt == charAt5) {
                    return a(charSequence.toString().getBytes(charset));
                }
                i5++;
                j2 |= u(codePointAt) << i4;
                if (this.X) {
                    i4 += 32;
                }
                i2 += 4;
            }
            if (i4 >= 32) {
                i3 = x(i3, y((int) j2));
                j2 >>>= 32;
                i4 -= 32;
            }
            i5++;
        }
        return v(y((int) j2) ^ i3, i2);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Murmur3_32HashFunction)) {
            return false;
        }
        Murmur3_32HashFunction murmur3_32HashFunction = (Murmur3_32HashFunction) obj;
        return this.s == murmur3_32HashFunction.s && this.X == murmur3_32HashFunction.X;
    }

    public HashCode g(CharSequence charSequence) {
        int i2 = this.s;
        for (int i3 = 1; i3 < charSequence.length(); i3 += 2) {
            i2 = x(i2, y(charSequence.charAt(i3 - 1) | (charSequence.charAt(i3) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i2 ^= y(charSequence.charAt(charSequence.length() - 1));
        }
        return v(i2, charSequence.length() * 2);
    }

    public int h() {
        return 32;
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.s;
    }

    public HashCode i(long j2) {
        int i2 = (int) (j2 >>> 32);
        return v(x(x(this.s, y((int) j2)), y(i2)), 8);
    }

    public HashCode j(byte[] bArr, int i2, int i3) {
        Preconditions.f0(i2, i2 + i3, bArr.length);
        int i4 = this.s;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6 + 4;
            if (i7 > i3) {
                break;
            }
            i4 = x(i4, y(w(bArr, i6 + i2)));
            i6 = i7;
        }
        int i8 = i6;
        int i9 = 0;
        while (i8 < i3) {
            i5 ^= UnsignedBytes.p(bArr[i2 + i8]) << i9;
            i8++;
            i9 += 8;
        }
        return v(y(i5) ^ i4, i3);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.s + ")";
    }
}
