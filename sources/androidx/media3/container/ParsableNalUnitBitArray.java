package androidx.media3.container;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class ParsableNalUnitBitArray {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f9711a;

    /* renamed from: b  reason: collision with root package name */
    private int f9712b;

    /* renamed from: c  reason: collision with root package name */
    private int f9713c;

    /* renamed from: d  reason: collision with root package name */
    private int f9714d;

    public ParsableNalUnitBitArray(byte[] bArr, int i2, int i3) {
        i(bArr, i2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f9712b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r2 = this;
            int r0 = r2.f9713c
            if (r0 < 0) goto L_0x0010
            int r1 = r2.f9712b
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.f9714d
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.ParsableNalUnitBitArray.a():void");
    }

    private int f() {
        int i2 = 0;
        int i3 = 0;
        while (!d()) {
            i3++;
        }
        int i4 = (1 << i3) - 1;
        if (i3 > 0) {
            i2 = e(i3);
        }
        return i4 + i2;
    }

    private boolean j(int i2) {
        if (2 <= i2 && i2 < this.f9712b) {
            byte[] bArr = this.f9711a;
            return bArr[i2] == 3 && bArr[i2 + -2] == 0 && bArr[i2 - 1] == 0;
        }
    }

    public boolean b(int i2) {
        int i3 = this.f9713c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        int i6 = (this.f9714d + i2) - (i4 * 8);
        if (i6 > 7) {
            i5++;
            i6 -= 8;
        }
        while (true) {
            i3++;
            if (i3 > i5 || i5 >= this.f9712b) {
                int i7 = this.f9712b;
            } else if (j(i3)) {
                i5++;
                i3 += 2;
            }
        }
        int i72 = this.f9712b;
        if (i5 >= i72) {
            return i5 == i72 && i6 == 0;
        }
        return true;
    }

    public boolean c() {
        int i2 = this.f9713c;
        int i3 = this.f9714d;
        int i4 = 0;
        while (this.f9713c < this.f9712b && !d()) {
            i4++;
        }
        boolean z = this.f9713c == this.f9712b;
        this.f9713c = i2;
        this.f9714d = i3;
        return !z && b((i4 * 2) + 1);
    }

    public boolean d() {
        boolean z = (this.f9711a[this.f9713c] & (128 >> this.f9714d)) != 0;
        k();
        return z;
    }

    public int e(int i2) {
        int i3;
        int i4;
        this.f9714d += i2;
        int i5 = 0;
        while (true) {
            i3 = this.f9714d;
            i4 = 2;
            if (i3 <= 8) {
                break;
            }
            int i6 = i3 - 8;
            this.f9714d = i6;
            byte[] bArr = this.f9711a;
            int i7 = this.f9713c;
            i5 |= (bArr[i7] & 255) << i6;
            if (!j(i7 + 1)) {
                i4 = 1;
            }
            this.f9713c = i7 + i4;
        }
        byte[] bArr2 = this.f9711a;
        int i8 = this.f9713c;
        int i9 = (-1 >>> (32 - i2)) & (i5 | ((bArr2[i8] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f9714d = 0;
            if (!j(i8 + 1)) {
                i4 = 1;
            }
            this.f9713c = i8 + i4;
        }
        a();
        return i9;
    }

    public int g() {
        int f2 = f();
        return (f2 % 2 == 0 ? -1 : 1) * ((f2 + 1) / 2);
    }

    public int h() {
        return f();
    }

    public void i(byte[] bArr, int i2, int i3) {
        this.f9711a = bArr;
        this.f9713c = i2;
        this.f9712b = i3;
        this.f9714d = 0;
        a();
    }

    public void k() {
        int i2 = 1;
        int i3 = this.f9714d + 1;
        this.f9714d = i3;
        if (i3 == 8) {
            this.f9714d = 0;
            int i4 = this.f9713c;
            if (j(i4 + 1)) {
                i2 = 2;
            }
            this.f9713c = i4 + i2;
        }
        a();
    }

    public void l(int i2) {
        int i3 = this.f9713c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.f9713c = i5;
        int i6 = this.f9714d + (i2 - (i4 * 8));
        this.f9714d = i6;
        if (i6 > 7) {
            this.f9713c = i5 + 1;
            this.f9714d = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 > this.f9713c) {
                a();
                return;
            } else if (j(i3)) {
                this.f9713c++;
                i3 += 2;
            }
        }
    }
}
