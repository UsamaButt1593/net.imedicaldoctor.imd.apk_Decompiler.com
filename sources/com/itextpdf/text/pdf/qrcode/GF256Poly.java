package com.itextpdf.text.pdf.qrcode;

final class GF256Poly {

    /* renamed from: a  reason: collision with root package name */
    private final GF256 f27200a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f27201b;

    GF256Poly(GF256 gf256, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f27200a = gf256;
        int length = iArr.length;
        int i2 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f27201b = iArr;
            return;
        }
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f27201b = gf256.e().f27201b;
            return;
        }
        int[] iArr2 = new int[(length - i2)];
        this.f27201b = iArr2;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    /* access modifiers changed from: package-private */
    public GF256Poly a(GF256Poly gF256Poly) {
        if (!this.f27200a.equals(gF256Poly.f27200a)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        } else if (g()) {
            return gF256Poly;
        } else {
            if (gF256Poly.g()) {
                return this;
            }
            int[] iArr = this.f27201b;
            int[] iArr2 = gF256Poly.f27201b;
            if (iArr.length <= iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr4, 0, length);
            for (int i2 = length; i2 < iArr.length; i2++) {
                iArr4[i2] = GF256.a(iArr2[i2 - length], iArr[i2]);
            }
            return new GF256Poly(this.f27200a, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    public GF256Poly[] b(GF256Poly gF256Poly) {
        if (!this.f27200a.equals(gF256Poly.f27200a)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        } else if (!gF256Poly.g()) {
            GF256Poly e2 = this.f27200a.e();
            int f2 = this.f27200a.f(gF256Poly.d(gF256Poly.f()));
            GF256Poly gF256Poly2 = this;
            while (gF256Poly2.f() >= gF256Poly.f() && !gF256Poly2.g()) {
                int f3 = gF256Poly2.f() - gF256Poly.f();
                int h2 = this.f27200a.h(gF256Poly2.d(gF256Poly2.f()), f2);
                GF256Poly j2 = gF256Poly.j(f3, h2);
                e2 = e2.a(this.f27200a.b(f3, h2));
                gF256Poly2 = gF256Poly2.a(j2);
            }
            return new GF256Poly[]{e2, gF256Poly2};
        } else {
            throw new IllegalArgumentException("Divide by 0");
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i2) {
        if (i2 == 0) {
            return d(0);
        }
        int[] iArr = this.f27201b;
        int length = iArr.length;
        if (i2 == 1) {
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                i3 = GF256.a(i3, this.f27201b[i4]);
            }
            return i3;
        }
        int i5 = iArr[0];
        for (int i6 = 1; i6 < length; i6++) {
            i5 = GF256.a(this.f27200a.h(i2, i5), this.f27201b[i6]);
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public int d(int i2) {
        int[] iArr = this.f27201b;
        return iArr[(iArr.length - 1) - i2];
    }

    /* access modifiers changed from: package-private */
    public int[] e() {
        return this.f27201b;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f27201b.length - 1;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.f27201b[0] == 0;
    }

    /* access modifiers changed from: package-private */
    public GF256Poly h(int i2) {
        if (i2 == 0) {
            return this.f27200a.e();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f27201b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f27200a.h(this.f27201b[i3], i2);
        }
        return new GF256Poly(this.f27200a, iArr);
    }

    /* access modifiers changed from: package-private */
    public GF256Poly i(GF256Poly gF256Poly) {
        if (!this.f27200a.equals(gF256Poly.f27200a)) {
            throw new IllegalArgumentException("GF256Polys do not have same GF256 field");
        } else if (g() || gF256Poly.g()) {
            return this.f27200a.e();
        } else {
            int[] iArr = this.f27201b;
            int length = iArr.length;
            int[] iArr2 = gF256Poly.f27201b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = iArr[i2];
                for (int i4 = 0; i4 < length2; i4++) {
                    int i5 = i2 + i4;
                    iArr3[i5] = GF256.a(iArr3[i5], this.f27200a.h(i3, iArr2[i4]));
                }
            }
            return new GF256Poly(this.f27200a, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public GF256Poly j(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (i3 == 0) {
            return this.f27200a.e();
        } else {
            int length = this.f27201b.length;
            int[] iArr = new int[(i2 + length)];
            for (int i4 = 0; i4 < length; i4++) {
                iArr[i4] = this.f27200a.h(this.f27201b[i4], i3);
            }
            return new GF256Poly(this.f27200a, iArr);
        }
    }

    public String toString() {
        char c2;
        StringBuffer stringBuffer = new StringBuffer(f() * 8);
        for (int f2 = f(); f2 >= 0; f2--) {
            int d2 = d(f2);
            if (d2 != 0) {
                if (d2 < 0) {
                    stringBuffer.append(" - ");
                    d2 = -d2;
                } else if (stringBuffer.length() > 0) {
                    stringBuffer.append(" + ");
                }
                if (f2 == 0 || d2 != 1) {
                    int g2 = this.f27200a.g(d2);
                    if (g2 == 0) {
                        c2 = '1';
                    } else if (g2 == 1) {
                        c2 = 'a';
                    } else {
                        stringBuffer.append("a^");
                        stringBuffer.append(g2);
                    }
                    stringBuffer.append(c2);
                }
                if (f2 != 0) {
                    if (f2 == 1) {
                        stringBuffer.append('x');
                    } else {
                        stringBuffer.append("x^");
                        stringBuffer.append(f2);
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}
