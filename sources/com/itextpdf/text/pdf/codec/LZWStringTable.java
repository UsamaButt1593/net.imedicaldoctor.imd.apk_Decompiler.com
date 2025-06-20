package com.itextpdf.text.pdf.codec;

import java.io.PrintStream;
import kotlin.UShort;

public class LZWStringTable {

    /* renamed from: f  reason: collision with root package name */
    private static final int f26614f = 2;

    /* renamed from: g  reason: collision with root package name */
    private static final short f26615g = -1;

    /* renamed from: h  reason: collision with root package name */
    private static final short f26616h = -1;

    /* renamed from: i  reason: collision with root package name */
    private static final int f26617i = 12;

    /* renamed from: j  reason: collision with root package name */
    private static final int f26618j = 4096;

    /* renamed from: k  reason: collision with root package name */
    private static final short f26619k = 9973;

    /* renamed from: l  reason: collision with root package name */
    private static final short f26620l = 2039;

    /* renamed from: a  reason: collision with root package name */
    byte[] f26621a = new byte[4096];

    /* renamed from: b  reason: collision with root package name */
    short[] f26622b = new short[4096];

    /* renamed from: c  reason: collision with root package name */
    short[] f26623c = new short[9973];

    /* renamed from: d  reason: collision with root package name */
    short f26624d;

    /* renamed from: e  reason: collision with root package name */
    int[] f26625e = new int[4096];

    public static int d(short s, byte b2) {
        return ((s ^ ((short) (b2 << 8))) & UShort.Z) % f26619k;
    }

    public int a(short s, byte b2) {
        short[] sArr;
        if (this.f26624d >= 4096) {
            return 65535;
        }
        int d2 = d(s, b2);
        while (true) {
            sArr = this.f26623c;
            if (sArr[d2] == -1) {
                break;
            }
            d2 = (d2 + 2039) % 9973;
        }
        short s2 = this.f26624d;
        sArr[d2] = s2;
        this.f26621a[s2] = b2;
        if (s == -1) {
            this.f26622b[s2] = -1;
            this.f26625e[s2] = 1;
        } else {
            this.f26622b[s2] = s;
            int[] iArr = this.f26625e;
            iArr[s2] = iArr[s] + 1;
        }
        this.f26624d = (short) (s2 + 1);
        return s2;
    }

    public void b(int i2) {
        this.f26624d = 0;
        for (int i3 = 0; i3 < 9973; i3++) {
            this.f26623c[i3] = -1;
        }
        int i4 = (1 << i2) + 2;
        for (int i5 = 0; i5 < i4; i5++) {
            a(-1, (byte) i5);
        }
    }

    public short c(short s, byte b2) {
        if (s == -1) {
            return (short) (b2 & 255);
        }
        int d2 = d(s, b2);
        while (true) {
            short s2 = this.f26623c[d2];
            if (s2 == -1) {
                return -1;
            }
            if (this.f26622b[s2] == s && this.f26621a[s2] == b2) {
                return (short) s2;
            }
            d2 = (d2 + 2039) % 9973;
        }
    }

    public void e(PrintStream printStream) {
        for (int i2 = 258; i2 < this.f26624d; i2++) {
            printStream.println(" strNxt_[" + i2 + "] = " + this.f26622b[i2] + " strChr_ " + Integer.toHexString(this.f26621a[i2] & 255) + " strLen_ " + Integer.toHexString(this.f26625e[i2]));
        }
    }

    public int f(byte[] bArr, int i2, short s, int i3) {
        int i4;
        if (i2 == -2 && i3 == 1) {
            i3 = 0;
        }
        if (s == -1 || i3 == (i4 = this.f26625e[s])) {
            return 0;
        }
        int i5 = i4 - i3;
        int length = bArr.length - i2;
        if (length > i5) {
            length = i5;
        }
        int i6 = i5 - length;
        int i7 = i2 + length;
        while (i7 > i2 && s != -1) {
            i6--;
            if (i6 < 0) {
                i7--;
                bArr[i7] = this.f26621a[s];
            }
            s = this.f26622b[s];
        }
        return i5 > length ? -length : length;
    }
}
