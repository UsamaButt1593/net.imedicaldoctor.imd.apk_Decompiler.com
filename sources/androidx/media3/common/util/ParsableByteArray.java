package androidx.media3.common.util;

import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Chars;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CheckReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

@UnstableApi
@CheckReturnValue
public final class ParsableByteArray {

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f9611d = {13, 10};

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f9612e = {10};

    /* renamed from: f  reason: collision with root package name */
    private static final ImmutableSet<Charset> f9613f = ImmutableSet.P(Charsets.f22253a, Charsets.f22255c, Charsets.f22258f, Charsets.f22256d, Charsets.f22257e);

    /* renamed from: a  reason: collision with root package name */
    private byte[] f9614a;

    /* renamed from: b  reason: collision with root package name */
    private int f9615b;

    /* renamed from: c  reason: collision with root package name */
    private int f9616c;

    public ParsableByteArray() {
        this.f9614a = Util.f9651f;
    }

    private void a0(Charset charset) {
        if (o(charset, f9611d) == 13) {
            o(charset, f9612e);
        }
    }

    private int d(Charset charset) {
        int i2;
        if (charset.equals(Charsets.f22255c) || charset.equals(Charsets.f22253a)) {
            i2 = 1;
        } else if (charset.equals(Charsets.f22258f) || charset.equals(Charsets.f22257e) || charset.equals(Charsets.f22256d)) {
            i2 = 2;
        } else {
            throw new IllegalArgumentException("Unsupported charset: " + charset);
        }
        int i3 = this.f9615b;
        while (true) {
            int i4 = this.f9616c;
            if (i3 >= i4 - (i2 - 1)) {
                return i4;
            }
            if ((charset.equals(Charsets.f22255c) || charset.equals(Charsets.f22253a)) && Util.k1(this.f9614a[i3])) {
                return i3;
            }
            if (charset.equals(Charsets.f22258f) || charset.equals(Charsets.f22256d)) {
                byte[] bArr = this.f9614a;
                if (bArr[i3] == 0 && Util.k1(bArr[i3 + 1])) {
                    return i3;
                }
            }
            if (charset.equals(Charsets.f22257e)) {
                byte[] bArr2 = this.f9614a;
                if (bArr2[i3 + 1] == 0 && Util.k1(bArr2[i3])) {
                    return i3;
                }
            }
            i3 += i2;
        }
    }

    private int j(Charset charset) {
        byte b2;
        char k2;
        int i2 = 1;
        if ((charset.equals(Charsets.f22255c) || charset.equals(Charsets.f22253a)) && a() >= 1) {
            b2 = (byte) Chars.d((long) UnsignedBytes.p(this.f9614a[this.f9615b]));
        } else {
            if ((charset.equals(Charsets.f22258f) || charset.equals(Charsets.f22256d)) && a() >= 2) {
                byte[] bArr = this.f9614a;
                int i3 = this.f9615b;
                k2 = Chars.k(bArr[i3], bArr[i3 + 1]);
            } else if (!charset.equals(Charsets.f22257e) || a() < 2) {
                return 0;
            } else {
                byte[] bArr2 = this.f9614a;
                int i4 = this.f9615b;
                k2 = Chars.k(bArr2[i4 + 1], bArr2[i4]);
            }
            b2 = (byte) k2;
            i2 = 2;
        }
        return (Chars.d((long) b2) << 16) + i2;
    }

    private char o(Charset charset, char[] cArr) {
        int j2 = j(charset);
        if (j2 == 0) {
            return 0;
        }
        char c2 = (char) (j2 >> 16);
        if (!Chars.h(cArr, c2)) {
            return 0;
        }
        this.f9615b += j2 & 65535;
        return c2;
    }

    public long A() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        int i4 = i2 + 2;
        this.f9615b = i4;
        int i5 = i2 + 3;
        this.f9615b = i5;
        this.f9615b = i2 + 4;
        return ((((long) bArr[i5]) & 255) << 24) | (((long) bArr[i2]) & 255) | ((((long) bArr[i3]) & 255) << 8) | ((((long) bArr[i4]) & 255) << 16);
    }

    public int B() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        int i4 = i2 + 2;
        this.f9615b = i4;
        int i5 = (bArr[i3] & 255) << 8;
        this.f9615b = i2 + 3;
        return ((bArr[i4] & 255) << 16) | i5 | (bArr[i2] & 255);
    }

    public int C() {
        int w = w();
        if (w >= 0) {
            return w;
        }
        throw new IllegalStateException("Top bit not zero: " + w);
    }

    public int D() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        this.f9615b = i2 + 2;
        return ((bArr[i3] & 255) << 8) | (bArr[i2] & 255);
    }

    public long E() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        int i4 = i2 + 2;
        this.f9615b = i4;
        int i5 = i2 + 3;
        this.f9615b = i5;
        long j2 = ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40);
        int i6 = i2 + 4;
        this.f9615b = i6;
        int i7 = i2 + 5;
        this.f9615b = i7;
        long j3 = j2 | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24);
        int i8 = i2 + 6;
        this.f9615b = i8;
        int i9 = i2 + 7;
        this.f9615b = i9;
        this.f9615b = i2 + 8;
        return (((long) bArr[i9]) & 255) | j3 | ((((long) bArr[i7]) & 255) << 16) | ((((long) bArr[i8]) & 255) << 8);
    }

    @Nullable
    public String F() {
        return p(0);
    }

    public String G(int i2) {
        if (i2 == 0) {
            return "";
        }
        int i3 = this.f9615b;
        int i4 = (i3 + i2) - 1;
        String U = Util.U(this.f9614a, i3, (i4 >= this.f9616c || this.f9614a[i4] != 0) ? i2 : i2 - 1);
        this.f9615b += i2;
        return U;
    }

    public short H() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        this.f9615b = i2 + 2;
        return (short) ((bArr[i3] & 255) | ((bArr[i2] & 255) << 8));
    }

    public String I(int i2) {
        return J(i2, Charsets.f22255c);
    }

    public String J(int i2, Charset charset) {
        String str = new String(this.f9614a, this.f9615b, i2, charset);
        this.f9615b += i2;
        return str;
    }

    public int K() {
        return (L() << 21) | (L() << 14) | (L() << 7) | L();
    }

    public int L() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        this.f9615b = i2 + 1;
        return bArr[i2] & 255;
    }

    public int M() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        this.f9615b = i2 + 2;
        byte b2 = (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
        this.f9615b = i2 + 4;
        return b2;
    }

    public long N() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        int i4 = i2 + 2;
        this.f9615b = i4;
        int i5 = i2 + 3;
        this.f9615b = i5;
        this.f9615b = i2 + 4;
        return (((long) bArr[i5]) & 255) | ((((long) bArr[i2]) & 255) << 24) | ((((long) bArr[i3]) & 255) << 16) | ((((long) bArr[i4]) & 255) << 8);
    }

    public int O() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        int i4 = i2 + 2;
        this.f9615b = i4;
        int i5 = (bArr[i3] & 255) << 8;
        this.f9615b = i2 + 3;
        return (bArr[i4] & 255) | i5 | ((bArr[i2] & 255) << 16);
    }

    public int P() {
        int s = s();
        if (s >= 0) {
            return s;
        }
        throw new IllegalStateException("Top bit not zero: " + s);
    }

    public long Q() {
        long E = E();
        if (E >= 0) {
            return E;
        }
        throw new IllegalStateException("Top bit not zero: " + E);
    }

    public int R() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        this.f9615b = i2 + 2;
        return (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
    }

    public long S() {
        int i2;
        int i3;
        long j2 = (long) this.f9614a[this.f9615b];
        int i4 = 7;
        while (true) {
            i2 = 1;
            if (i4 < 0) {
                break;
            }
            int i5 = 1 << i4;
            if ((((long) i5) & j2) != 0) {
                i4--;
            } else if (i4 < 6) {
                j2 &= (long) (i5 - 1);
                i3 = 7 - i4;
            } else if (i4 == 7) {
                i3 = 1;
            }
        }
        i3 = 0;
        if (i3 != 0) {
            while (i2 < i3) {
                byte b2 = this.f9614a[this.f9615b + i2];
                if ((b2 & 192) == 128) {
                    j2 = (j2 << 6) | ((long) (b2 & Utf8.f31404a));
                    i2++;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j2);
                }
            }
            this.f9615b += i3;
            return j2;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j2);
    }

    @Nullable
    public Charset T() {
        if (a() >= 3) {
            byte[] bArr = this.f9614a;
            int i2 = this.f9615b;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.f9615b = i2 + 3;
                return Charsets.f22255c;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f9614a;
        int i3 = this.f9615b;
        byte b2 = bArr2[i3];
        if (b2 == -2 && bArr2[i3 + 1] == -1) {
            this.f9615b = i3 + 2;
            return Charsets.f22256d;
        } else if (b2 != -1 || bArr2[i3 + 1] != -2) {
            return null;
        } else {
            this.f9615b = i3 + 2;
            return Charsets.f22257e;
        }
    }

    public void U(int i2) {
        W(b() < i2 ? new byte[i2] : this.f9614a, i2);
    }

    public void V(byte[] bArr) {
        W(bArr, bArr.length);
    }

    public void W(byte[] bArr, int i2) {
        this.f9614a = bArr;
        this.f9616c = i2;
        this.f9615b = 0;
    }

    public void X(int i2) {
        Assertions.a(i2 >= 0 && i2 <= this.f9614a.length);
        this.f9616c = i2;
    }

    public void Y(int i2) {
        Assertions.a(i2 >= 0 && i2 <= this.f9616c);
        this.f9615b = i2;
    }

    public void Z(int i2) {
        Y(this.f9615b + i2);
    }

    public int a() {
        return this.f9616c - this.f9615b;
    }

    public int b() {
        return this.f9614a.length;
    }

    public void c(int i2) {
        if (i2 > b()) {
            this.f9614a = Arrays.copyOf(this.f9614a, i2);
        }
    }

    public byte[] e() {
        return this.f9614a;
    }

    public int f() {
        return this.f9615b;
    }

    public int g() {
        return this.f9616c;
    }

    public char h() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        return (char) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    public char i(Charset charset) {
        boolean contains = f9613f.contains(charset);
        Assertions.b(contains, "Unsupported charset: " + charset);
        return (char) (j(charset) >> 16);
    }

    public int k() {
        return this.f9614a[this.f9615b] & 255;
    }

    public void l(ParsableBitArray parsableBitArray, int i2) {
        n(parsableBitArray.f9607a, 0, i2);
        parsableBitArray.q(0);
    }

    public void m(ByteBuffer byteBuffer, int i2) {
        byteBuffer.put(this.f9614a, this.f9615b, i2);
        this.f9615b += i2;
    }

    public void n(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.f9614a, this.f9615b, bArr, i2, i3);
        this.f9615b += i3;
    }

    @Nullable
    public String p(char c2) {
        if (a() == 0) {
            return null;
        }
        int i2 = this.f9615b;
        while (i2 < this.f9616c && this.f9614a[i2] != c2) {
            i2++;
        }
        byte[] bArr = this.f9614a;
        int i3 = this.f9615b;
        String U = Util.U(bArr, i3, i2 - i3);
        this.f9615b = i2;
        if (i2 < this.f9616c) {
            this.f9615b = i2 + 1;
        }
        return U;
    }

    public double q() {
        return Double.longBitsToDouble(E());
    }

    public float r() {
        return Float.intBitsToFloat(s());
    }

    public int s() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        int i4 = (bArr[i2] & 255) << Ascii.B;
        int i5 = i2 + 2;
        this.f9615b = i5;
        byte b2 = ((bArr[i3] & 255) << 16) | i4;
        int i6 = i2 + 3;
        this.f9615b = i6;
        this.f9615b = i2 + 4;
        return (bArr[i6] & 255) | b2 | ((bArr[i5] & 255) << 8);
    }

    public int t() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        int i4 = i2 + 2;
        this.f9615b = i4;
        int i5 = (bArr[i3] & 255) << 8;
        this.f9615b = i2 + 3;
        return (bArr[i4] & 255) | i5 | (((bArr[i2] & 255) << Ascii.B) >> 8);
    }

    @Nullable
    public String u() {
        return v(Charsets.f22255c);
    }

    @Nullable
    public String v(Charset charset) {
        boolean contains = f9613f.contains(charset);
        Assertions.b(contains, "Unsupported charset: " + charset);
        if (a() == 0) {
            return null;
        }
        if (!charset.equals(Charsets.f22253a)) {
            T();
        }
        String J = J(d(charset) - this.f9615b, charset);
        if (this.f9615b == this.f9616c) {
            return J;
        }
        a0(charset);
        return J;
    }

    public int w() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        int i4 = i2 + 2;
        this.f9615b = i4;
        byte b2 = ((bArr[i3] & 255) << 8) | (bArr[i2] & 255);
        int i5 = i2 + 3;
        this.f9615b = i5;
        this.f9615b = i2 + 4;
        return ((bArr[i5] & 255) << Ascii.B) | b2 | ((bArr[i4] & 255) << 16);
    }

    public int x() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        int i4 = i2 + 2;
        this.f9615b = i4;
        int i5 = (bArr[i3] & 255) << 8;
        this.f9615b = i2 + 3;
        return ((bArr[i4] & 255) << 16) | i5 | (bArr[i2] & 255);
    }

    public long y() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        int i4 = i2 + 2;
        this.f9615b = i4;
        long j2 = (((long) bArr[i2]) & 255) | ((((long) bArr[i3]) & 255) << 8);
        int i5 = i2 + 3;
        this.f9615b = i5;
        int i6 = i2 + 4;
        this.f9615b = i6;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 16) | ((((long) bArr[i5]) & 255) << 24);
        int i7 = i2 + 5;
        this.f9615b = i7;
        int i8 = i2 + 6;
        this.f9615b = i8;
        long j4 = j3 | ((((long) bArr[i6]) & 255) << 32) | ((((long) bArr[i7]) & 255) << 40);
        int i9 = i2 + 7;
        this.f9615b = i9;
        this.f9615b = i2 + 8;
        return ((((long) bArr[i9]) & 255) << 56) | j4 | ((((long) bArr[i8]) & 255) << 48);
    }

    public short z() {
        byte[] bArr = this.f9614a;
        int i2 = this.f9615b;
        int i3 = i2 + 1;
        this.f9615b = i3;
        this.f9615b = i2 + 2;
        return (short) (((bArr[i3] & 255) << 8) | (bArr[i2] & 255));
    }

    public ParsableByteArray(int i2) {
        this.f9614a = new byte[i2];
        this.f9616c = i2;
    }

    public ParsableByteArray(byte[] bArr) {
        this.f9614a = bArr;
        this.f9616c = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i2) {
        this.f9614a = bArr;
        this.f9616c = i2;
    }
}
