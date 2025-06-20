package com.itextpdf.text.pdf.qrcode;

import com.itextpdf.text.pdf.codec.TIFFConstants;

public final class GF256 {

    /* renamed from: e  reason: collision with root package name */
    public static final GF256 f27194e = new GF256(TIFFConstants.B0);

    /* renamed from: f  reason: collision with root package name */
    public static final GF256 f27195f = new GF256(301);

    /* renamed from: a  reason: collision with root package name */
    private final int[] f27196a = new int[256];

    /* renamed from: b  reason: collision with root package name */
    private final int[] f27197b = new int[256];

    /* renamed from: c  reason: collision with root package name */
    private final GF256Poly f27198c;

    /* renamed from: d  reason: collision with root package name */
    private final GF256Poly f27199d;

    private GF256(int i2) {
        int i3 = 1;
        for (int i4 = 0; i4 < 256; i4++) {
            this.f27196a[i4] = i3;
            i3 <<= 1;
            if (i3 >= 256) {
                i3 ^= i2;
            }
        }
        for (int i5 = 0; i5 < 255; i5++) {
            this.f27197b[this.f27196a[i5]] = i5;
        }
        this.f27198c = new GF256Poly(this, new int[]{0});
        this.f27199d = new GF256Poly(this, new int[]{1});
    }

    static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    /* access modifiers changed from: package-private */
    public GF256Poly b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.f27198c;
        } else {
            int[] iArr = new int[(i2 + 1)];
            iArr[0] = i3;
            return new GF256Poly(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i2) {
        return this.f27196a[i2];
    }

    /* access modifiers changed from: package-private */
    public GF256Poly d() {
        return this.f27199d;
    }

    /* access modifiers changed from: package-private */
    public GF256Poly e() {
        return this.f27198c;
    }

    /* access modifiers changed from: package-private */
    public int f(int i2) {
        if (i2 != 0) {
            return this.f27196a[255 - this.f27197b[i2]];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public int g(int i2) {
        if (i2 != 0) {
            return this.f27197b[i2];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int h(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return i3;
        }
        if (i3 == 1) {
            return i2;
        }
        int[] iArr = this.f27196a;
        int[] iArr2 = this.f27197b;
        return iArr[(iArr2[i2] + iArr2[i3]) % 255];
    }
}
