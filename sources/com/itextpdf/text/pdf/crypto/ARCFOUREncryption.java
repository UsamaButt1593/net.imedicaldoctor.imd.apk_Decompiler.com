package com.itextpdf.text.pdf.crypto;

public class ARCFOUREncryption {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f26776a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    private int f26777b;

    /* renamed from: c  reason: collision with root package name */
    private int f26778c;

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length, bArr, 0);
    }

    public void b(byte[] bArr, int i2, int i3) {
        c(bArr, i2, i3, bArr, i2);
    }

    public void c(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        int i5 = i3 + i2;
        for (int i6 = i2; i6 < i5; i6++) {
            int i7 = (this.f26777b + 1) & 255;
            this.f26777b = i7;
            byte[] bArr3 = this.f26776a;
            byte b2 = bArr3[i7];
            int i8 = (this.f26778c + b2) & 255;
            this.f26778c = i8;
            bArr3[i7] = bArr3[i8];
            bArr3[i8] = b2;
            bArr2[(i6 - i2) + i4] = (byte) (bArr3[(bArr3[i7] + b2) & 255] ^ bArr[i6]);
        }
    }

    public void d(byte[] bArr, byte[] bArr2) {
        c(bArr, 0, bArr.length, bArr2, 0);
    }

    public void e(byte[] bArr) {
        f(bArr, 0, bArr.length);
    }

    public void f(byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < 256; i4++) {
            this.f26776a[i4] = (byte) i4;
        }
        this.f26777b = 0;
        this.f26778c = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < 256; i7++) {
            byte b2 = bArr[i5 + i2];
            byte[] bArr2 = this.f26776a;
            byte b3 = bArr2[i7];
            i6 = (b2 + b3 + i6) & 255;
            bArr2[i7] = bArr2[i6];
            bArr2[i6] = b3;
            i5 = (i5 + 1) % i3;
        }
    }
}
