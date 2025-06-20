package androidx.media3.common.util;

import androidx.core.view.MotionEventCompat;
import com.google.common.base.Charsets;
import com.google.errorprone.annotations.CheckReturnValue;
import java.nio.charset.Charset;

@UnstableApi
@CheckReturnValue
public final class ParsableBitArray {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f9607a;

    /* renamed from: b  reason: collision with root package name */
    private int f9608b;

    /* renamed from: c  reason: collision with root package name */
    private int f9609c;

    /* renamed from: d  reason: collision with root package name */
    private int f9610d;

    public ParsableBitArray() {
        this.f9607a = Util.f9651f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f9610d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r2 = this;
            int r0 = r2.f9608b
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f9610d
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f9609c
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            androidx.media3.common.util.Assertions.i(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.ParsableBitArray.a():void");
    }

    public int b() {
        return ((this.f9610d - this.f9608b) * 8) - this.f9609c;
    }

    public void c() {
        if (this.f9609c != 0) {
            this.f9609c = 0;
            this.f9608b++;
            a();
        }
    }

    public int d() {
        Assertions.i(this.f9609c == 0);
        return this.f9608b;
    }

    public int e() {
        return (this.f9608b * 8) + this.f9609c;
    }

    public void f(int i2, int i3) {
        if (i3 < 32) {
            i2 &= (1 << i3) - 1;
        }
        int min = Math.min(8 - this.f9609c, i3);
        int i4 = this.f9609c;
        int i5 = (8 - i4) - min;
        byte b2 = (MotionEventCompat.f6446f >> i4) | ((1 << i5) - 1);
        byte[] bArr = this.f9607a;
        int i6 = this.f9608b;
        byte b3 = (byte) (b2 & bArr[i6]);
        bArr[i6] = b3;
        int i7 = i3 - min;
        bArr[i6] = (byte) (b3 | ((i2 >>> i7) << i5));
        int i8 = i6 + 1;
        while (i7 > 8) {
            this.f9607a[i8] = (byte) (i2 >>> (i7 - 8));
            i7 -= 8;
            i8++;
        }
        int i9 = 8 - i7;
        byte[] bArr2 = this.f9607a;
        byte b4 = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = b4;
        bArr2[i8] = (byte) (((i2 & ((1 << i7) - 1)) << i9) | b4);
        s(i3);
        a();
    }

    public boolean g() {
        boolean z = (this.f9607a[this.f9608b] & (128 >> this.f9609c)) != 0;
        r();
        return z;
    }

    public int h(int i2) {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        this.f9609c += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f9609c;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f9609c = i5;
            byte[] bArr = this.f9607a;
            int i6 = this.f9608b;
            this.f9608b = i6 + 1;
            i4 |= (bArr[i6] & 255) << i5;
        }
        byte[] bArr2 = this.f9607a;
        int i7 = this.f9608b;
        int i8 = (-1 >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f9609c = 0;
            this.f9608b = i7 + 1;
        }
        a();
        return i8;
    }

    public void i(byte[] bArr, int i2, int i3) {
        int i4 = (i3 >> 3) + i2;
        while (i2 < i4) {
            byte[] bArr2 = this.f9607a;
            int i5 = this.f9608b;
            int i6 = i5 + 1;
            this.f9608b = i6;
            byte b2 = bArr2[i5];
            int i7 = this.f9609c;
            byte b3 = (byte) (b2 << i7);
            bArr[i2] = b3;
            bArr[i2] = (byte) (((255 & bArr2[i6]) >> (8 - i7)) | b3);
            i2++;
        }
        int i8 = i3 & 7;
        if (i8 != 0) {
            byte b4 = (byte) (bArr[i4] & (255 >> i8));
            bArr[i4] = b4;
            int i9 = this.f9609c;
            if (i9 + i8 > 8) {
                byte[] bArr3 = this.f9607a;
                int i10 = this.f9608b;
                this.f9608b = i10 + 1;
                bArr[i4] = (byte) (b4 | ((bArr3[i10] & 255) << i9));
                this.f9609c = i9 - 8;
            }
            int i11 = this.f9609c + i8;
            this.f9609c = i11;
            byte[] bArr4 = this.f9607a;
            int i12 = this.f9608b;
            bArr[i4] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i8))) | bArr[i4]);
            if (i11 == 8) {
                this.f9609c = 0;
                this.f9608b = i12 + 1;
            }
            a();
        }
    }

    public long j(int i2) {
        return i2 <= 32 ? Util.E2(h(i2)) : Util.D2(h(i2 - 32), h(32));
    }

    public void k(byte[] bArr, int i2, int i3) {
        Assertions.i(this.f9609c == 0);
        System.arraycopy(this.f9607a, this.f9608b, bArr, i2, i3);
        this.f9608b += i3;
        a();
    }

    public String l(int i2) {
        return m(i2, Charsets.f22255c);
    }

    public String m(int i2, Charset charset) {
        byte[] bArr = new byte[i2];
        k(bArr, 0, i2);
        return new String(bArr, charset);
    }

    public void n(ParsableByteArray parsableByteArray) {
        p(parsableByteArray.e(), parsableByteArray.g());
        q(parsableByteArray.f() * 8);
    }

    public void o(byte[] bArr) {
        p(bArr, bArr.length);
    }

    public void p(byte[] bArr, int i2) {
        this.f9607a = bArr;
        this.f9608b = 0;
        this.f9609c = 0;
        this.f9610d = i2;
    }

    public void q(int i2) {
        int i3 = i2 / 8;
        this.f9608b = i3;
        this.f9609c = i2 - (i3 * 8);
        a();
    }

    public void r() {
        int i2 = this.f9609c + 1;
        this.f9609c = i2;
        if (i2 == 8) {
            this.f9609c = 0;
            this.f9608b++;
        }
        a();
    }

    public void s(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f9608b + i3;
        this.f9608b = i4;
        int i5 = this.f9609c + (i2 - (i3 * 8));
        this.f9609c = i5;
        if (i5 > 7) {
            this.f9608b = i4 + 1;
            this.f9609c = i5 - 8;
        }
        a();
    }

    public void t(int i2) {
        Assertions.i(this.f9609c == 0);
        this.f9608b += i2;
        a();
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray(byte[] bArr, int i2) {
        this.f9607a = bArr;
        this.f9610d = i2;
    }
}
