package com.itextpdf.text.pdf.draw;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfContentByte;

public class LineSeparator extends VerticalPositionMark {
    protected BaseColor X2;
    protected float Y;
    protected int Y2;
    protected float Z;

    public LineSeparator() {
        this.Y = 1.0f;
        this.Z = 100.0f;
        this.Y2 = 6;
    }

    public void a(PdfContentByte pdfContentByte, float f2, float f3, float f4, float f5, float f6) {
        pdfContentByte.a2();
        h(pdfContentByte, f2, f4, f6);
        pdfContentByte.U1();
    }

    public void h(PdfContentByte pdfContentByte, float f2, float f3, float f4) {
        float f5 = 0.0f;
        float l2 = l() < 0.0f ? -l() : ((f3 - f2) * l()) / 100.0f;
        int i2 = i();
        if (i2 != 0) {
            float f6 = f3 - f2;
            f5 = i2 != 2 ? (f6 - l2) / 2.0f : f6 - l2;
        }
        pdfContentByte.J2(k());
        if (j() != null) {
            pdfContentByte.l2(j());
        }
        pdfContentByte.w1(f5 + f2, this.X + f4);
        pdfContentByte.q1(f5 + l2 + f2, f4 + this.X);
        pdfContentByte.v3();
    }

    public int i() {
        return this.Y2;
    }

    public BaseColor j() {
        return this.X2;
    }

    public float k() {
        return this.Y;
    }

    public float l() {
        return this.Z;
    }

    public void m(int i2) {
        this.Y2 = i2;
    }

    public void n(BaseColor baseColor) {
        this.X2 = baseColor;
    }

    public void o(float f2) {
        this.Y = f2;
    }

    public void p(float f2) {
        this.Z = f2;
    }

    public LineSeparator(float f2, float f3, BaseColor baseColor, int i2, float f4) {
        this.Y = f2;
        this.Z = f3;
        this.X2 = baseColor;
        this.Y2 = i2;
        this.X = f4;
    }

    public LineSeparator(Font font) {
        this.Y = 1.0f;
        this.Z = 100.0f;
        this.Y2 = 6;
        this.Y = font.m() * 0.06666667f;
        this.X = font.m() * -0.33333334f;
        this.Z = 100.0f;
        this.X2 = font.i();
    }
}
