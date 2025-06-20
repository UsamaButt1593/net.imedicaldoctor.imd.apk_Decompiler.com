package com.itextpdf.text.pdf.qrcode;

public final class BitMatrix {

    /* renamed from: a  reason: collision with root package name */
    public final int f27159a;

    /* renamed from: b  reason: collision with root package name */
    public final int f27160b;

    /* renamed from: c  reason: collision with root package name */
    public final int f27161c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f27162d;

    public BitMatrix(int i2) {
        this(i2, i2);
    }

    public void a() {
        int length = this.f27162d.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f27162d[i2] = 0;
        }
    }

    public void b(int i2, int i3) {
        int i4 = (i3 * this.f27161c) + (i2 >> 5);
        int[] iArr = this.f27162d;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public boolean c(int i2, int i3) {
        return ((this.f27162d[(i3 * this.f27161c) + (i2 >> 5)] >>> (i2 & 31)) & 1) != 0;
    }

    public int d() {
        int i2 = this.f27159a;
        if (i2 == this.f27160b) {
            return i2;
        }
        throw new RuntimeException("Can't call getDimension() on a non-square matrix");
    }

    public int e() {
        return this.f27160b;
    }

    public BitArray f(int i2, BitArray bitArray) {
        if (bitArray == null || bitArray.e() < this.f27159a) {
            bitArray = new BitArray(this.f27159a);
        }
        int i3 = i2 * this.f27161c;
        for (int i4 = 0; i4 < this.f27161c; i4++) {
            bitArray.j(i4 << 5, this.f27162d[i3 + i4]);
        }
        return bitArray;
    }

    public int g() {
        return this.f27159a;
    }

    public void h(int i2, int i3) {
        int i4 = (i3 * this.f27161c) + (i2 >> 5);
        int[] iArr = this.f27162d;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void i(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i5 < 1 || i4 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i6 = i4 + i2;
            int i7 = i5 + i3;
            if (i7 > this.f27160b || i6 > this.f27159a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i3 < i7) {
                int i8 = this.f27161c * i3;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.f27162d;
                    int i10 = (i9 >> 5) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.f27160b * (this.f27159a + 1));
        for (int i2 = 0; i2 < this.f27160b; i2++) {
            for (int i3 = 0; i3 < this.f27159a; i3++) {
                stringBuffer.append(c(i3, i2) ? "X " : "  ");
            }
            stringBuffer.append(10);
        }
        return stringBuffer.toString();
    }

    public BitMatrix(int i2, int i3) {
        if (i2 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f27159a = i2;
        this.f27160b = i3;
        int i4 = i2 >> 5;
        i4 = (i2 & 31) != 0 ? i4 + 1 : i4;
        this.f27161c = i4;
        this.f27162d = new int[(i4 * i3)];
    }
}
