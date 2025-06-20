package com.itextpdf.text.pdf.qrcode;

public final class BitVector {

    /* renamed from: c  reason: collision with root package name */
    private static final int f27163c = 32;

    /* renamed from: a  reason: collision with root package name */
    private int f27164a = 0;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f27165b = new byte[32];

    private void d(int i2) {
        int i3 = this.f27164a >> 3;
        byte[] bArr = this.f27165b;
        if (i3 == bArr.length) {
            byte[] bArr2 = new byte[(bArr.length << 1)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f27165b = bArr2;
        }
        byte[] bArr3 = this.f27165b;
        int i4 = this.f27164a;
        bArr3[i4 >> 3] = (byte) i2;
        this.f27164a = i4 + 8;
    }

    public void a(int i2) {
        if (i2 == 0 || i2 == 1) {
            int i3 = this.f27164a & 7;
            if (i3 == 0) {
                d(0);
                this.f27164a -= 8;
            }
            byte[] bArr = this.f27165b;
            int i4 = this.f27164a;
            int i5 = i4 >> 3;
            bArr[i5] = (byte) ((i2 << (7 - i3)) | bArr[i5]);
            this.f27164a = i4 + 1;
            return;
        }
        throw new IllegalArgumentException("Bad bit");
    }

    public void b(BitVector bitVector) {
        int g2 = bitVector.g();
        for (int i2 = 0; i2 < g2; i2++) {
            a(bitVector.e(i2));
        }
    }

    public void c(int i2, int i3) {
        if (i3 < 0 || i3 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        while (i3 > 0) {
            if ((this.f27164a & 7) != 0 || i3 < 8) {
                a((i2 >> (i3 - 1)) & 1);
                i3--;
            } else {
                d((i2 >> (i3 - 8)) & 255);
                i3 -= 8;
            }
        }
    }

    public int e(int i2) {
        if (i2 >= 0 && i2 < this.f27164a) {
            return ((this.f27165b[i2 >> 3] & 255) >> (7 - (i2 & 7))) & 1;
        }
        throw new IllegalArgumentException("Bad index: " + i2);
    }

    public byte[] f() {
        return this.f27165b;
    }

    public int g() {
        return this.f27164a;
    }

    public int h() {
        return (this.f27164a + 7) >> 3;
    }

    public void i(BitVector bitVector) {
        if (this.f27164a == bitVector.g()) {
            int i2 = (this.f27164a + 7) >> 3;
            for (int i3 = 0; i3 < i2; i3++) {
                byte[] bArr = this.f27165b;
                bArr[i3] = (byte) (bArr[i3] ^ bitVector.f27165b[i3]);
            }
            return;
        }
        throw new IllegalArgumentException("BitVector sizes don't match");
    }

    public String toString() {
        char c2;
        StringBuffer stringBuffer = new StringBuffer(this.f27164a);
        for (int i2 = 0; i2 < this.f27164a; i2++) {
            if (e(i2) == 0) {
                c2 = '0';
            } else if (e(i2) == 1) {
                c2 = '1';
            } else {
                throw new IllegalArgumentException("Byte isn't 0 or 1");
            }
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }
}
