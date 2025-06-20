package com.itextpdf.text.pdf.qrcode;

public final class ByteArray {

    /* renamed from: c  reason: collision with root package name */
    private static final int f27168c = 32;

    /* renamed from: a  reason: collision with root package name */
    private byte[] f27169a;

    /* renamed from: b  reason: collision with root package name */
    private int f27170b;

    public ByteArray() {
        this.f27169a = null;
        this.f27170b = 0;
    }

    public void a(int i2) {
        int i3 = this.f27170b;
        if (i3 == 0 || i3 >= this.f27169a.length) {
            d(Math.max(32, i3 << 1));
        }
        byte[] bArr = this.f27169a;
        int i4 = this.f27170b;
        bArr[i4] = (byte) i2;
        this.f27170b = i4 + 1;
    }

    public int b(int i2) {
        return this.f27169a[i2] & 255;
    }

    public boolean c() {
        return this.f27170b == 0;
    }

    public void d(int i2) {
        byte[] bArr = this.f27169a;
        if (bArr == null || bArr.length < i2) {
            byte[] bArr2 = new byte[i2];
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            }
            this.f27169a = bArr2;
        }
    }

    public void e(int i2, int i3) {
        this.f27169a[i2] = (byte) i3;
    }

    public void f(byte[] bArr, int i2, int i3) {
        this.f27169a = new byte[i3];
        this.f27170b = i3;
        for (int i4 = 0; i4 < i3; i4++) {
            this.f27169a[i4] = bArr[i2 + i4];
        }
    }

    public int g() {
        return this.f27170b;
    }

    public ByteArray(int i2) {
        this.f27169a = new byte[i2];
        this.f27170b = i2;
    }

    public ByteArray(byte[] bArr) {
        this.f27169a = bArr;
        this.f27170b = bArr.length;
    }
}
