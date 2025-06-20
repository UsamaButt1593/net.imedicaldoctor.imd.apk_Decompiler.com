package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;

class PdfFont implements Comparable<PdfFont> {
    private float X;
    protected float Y = 1.0f;
    private BaseFont s;

    PdfFont(BaseFont baseFont, float f2) {
        this.X = f2;
        this.s = baseFont;
    }

    static PdfFont b() {
        try {
            return new PdfFont(BaseFont.j("Helvetica", "Cp1252", false), 12.0f);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* renamed from: a */
    public int compareTo(PdfFont pdfFont) {
        if (pdfFont == null) {
            return -1;
        }
        try {
            if (this.s != pdfFont.s) {
                return 1;
            }
            return g() != pdfFont.g() ? 2 : 0;
        } catch (ClassCastException unused) {
            return -2;
        }
    }

    /* access modifiers changed from: package-private */
    public BaseFont c() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    public void f(float f2) {
        this.Y = f2;
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public float h() {
        return i(32);
    }

    /* access modifiers changed from: package-private */
    public float i(int i2) {
        return this.s.Y(i2, this.X) * this.Y;
    }

    /* access modifiers changed from: package-private */
    public float j(String str) {
        return this.s.Z(str, this.X) * this.Y;
    }
}
