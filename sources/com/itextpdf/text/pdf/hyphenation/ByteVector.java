package com.itextpdf.text.pdf.hyphenation;

import java.io.Serializable;

public class ByteVector implements Serializable {
    private static final int X2 = 2048;
    private static final long Z = -1096301185375029343L;
    private byte[] X;
    private int Y;
    private int s;

    public ByteVector() {
        this(2048);
    }

    public int a(int i2) {
        int i3 = this.Y;
        byte[] bArr = this.X;
        int length = bArr.length;
        if (i3 + i2 >= length) {
            byte[] bArr2 = new byte[(this.s + length)];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            this.X = bArr2;
        }
        this.Y += i2;
        return i3;
    }

    public int b() {
        return this.X.length;
    }

    public byte c(int i2) {
        return this.X[i2];
    }

    public byte[] d() {
        return this.X;
    }

    public int e() {
        return this.Y;
    }

    public void f(int i2, byte b2) {
        this.X[i2] = b2;
    }

    public void g() {
        int i2 = this.Y;
        byte[] bArr = this.X;
        if (i2 < bArr.length) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.X = bArr2;
        }
    }

    public ByteVector(int i2) {
        this.s = i2 <= 0 ? 2048 : i2;
        this.X = new byte[this.s];
        this.Y = 0;
    }

    public ByteVector(byte[] bArr) {
        this.s = 2048;
        this.X = bArr;
        this.Y = 0;
    }

    public ByteVector(byte[] bArr, int i2) {
        this.s = i2 <= 0 ? 2048 : i2;
        this.X = bArr;
        this.Y = 0;
    }
}
