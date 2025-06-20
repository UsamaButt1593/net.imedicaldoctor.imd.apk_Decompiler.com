package com.itextpdf.text.pdf.qrcode;

import java.lang.reflect.Array;

public final class ByteMatrix {

    /* renamed from: a  reason: collision with root package name */
    private final byte[][] f27171a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27172b;

    /* renamed from: c  reason: collision with root package name */
    private final int f27173c;

    public ByteMatrix(int i2, int i3) {
        int[] iArr = new int[2];
        iArr[1] = i2;
        iArr[0] = i3;
        this.f27171a = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        this.f27172b = i2;
        this.f27173c = i3;
    }

    public void a(byte b2) {
        for (int i2 = 0; i2 < this.f27173c; i2++) {
            for (int i3 = 0; i3 < this.f27172b; i3++) {
                this.f27171a[i2][i3] = b2;
            }
        }
    }

    public byte b(int i2, int i3) {
        return this.f27171a[i3][i2];
    }

    public byte[][] c() {
        return this.f27171a;
    }

    public int d() {
        return this.f27173c;
    }

    public int e() {
        return this.f27172b;
    }

    public void f(int i2, int i3, byte b2) {
        this.f27171a[i3][i2] = b2;
    }

    public void g(int i2, int i3, int i4) {
        this.f27171a[i3][i2] = (byte) i4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.f27172b * 2 * this.f27173c) + 2);
        for (int i2 = 0; i2 < this.f27173c; i2++) {
            for (int i3 = 0; i3 < this.f27172b; i3++) {
                byte b2 = this.f27171a[i2][i3];
                stringBuffer.append(b2 != 0 ? b2 != 1 ? "  " : " 1" : " 0");
            }
            stringBuffer.append(10);
        }
        return stringBuffer.toString();
    }
}
