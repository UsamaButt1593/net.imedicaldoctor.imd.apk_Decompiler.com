package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

public final class PdfPatternPainter extends PdfTemplate {
    float O3;
    float P3;
    boolean Q3 = false;
    BaseColor R3;

    private PdfPatternPainter() {
        this.y3 = 3;
    }

    public void N1() {
        a4();
        super.N1();
    }

    public void O1() {
        a4();
        super.O1();
    }

    public void P1() {
        a4();
        super.P1();
    }

    public void Q1() {
        a4();
        super.Q1();
    }

    public void R1() {
        a4();
        super.R1();
    }

    public void R2(PdfPatternPainter pdfPatternPainter) {
        a4();
        super.R2(pdfPatternPainter);
    }

    public void S1() {
        a4();
        super.S1();
    }

    public void T2(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f2) {
        a4();
        super.T2(pdfPatternPainter, baseColor, f2);
    }

    public PdfContentByte U0() {
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter();
        pdfPatternPainter.Y = this.Y;
        pdfPatternPainter.Z = this.Z;
        pdfPatternPainter.z3 = this.z3;
        pdfPatternPainter.A3 = this.A3;
        pdfPatternPainter.B3 = new Rectangle(this.B3);
        pdfPatternPainter.O3 = this.O3;
        pdfPatternPainter.P3 = this.P3;
        pdfPatternPainter.C3 = this.C3;
        pdfPatternPainter.Q3 = this.Q3;
        pdfPatternPainter.R3 = this.R3;
        return pdfPatternPainter;
    }

    public void U2(PdfPatternPainter pdfPatternPainter) {
        a4();
        super.U2(pdfPatternPainter);
    }

    public void W2(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f2) {
        a4();
        super.W2(pdfPatternPainter, baseColor, f2);
    }

    public void X2(int i2, int i3, int i4) {
        a4();
        super.X2(i2, i3, i4);
    }

    public void Y2(float f2, float f3, float f4) {
        a4();
        super.Y2(f2, f3, f4);
    }

    public void Z2(int i2, int i3, int i4) {
        a4();
        super.Z2(i2, i3, i4);
    }

    public void a3(float f2, float f3, float f4) {
        a4();
        super.a3(f2, f3, f4);
    }

    /* access modifiers changed from: package-private */
    public void a4() {
        if (this.Q3) {
            throw new RuntimeException(MessageLocalization.b("colors.are.not.allowed.in.uncolored.tile.patterns", new Object[0]));
        }
    }

    public BaseColor b4() {
        return this.R3;
    }

    public void c2(int i2, int i3, int i4, int i5) {
        a4();
        super.c2(i2, i3, i4, i5);
    }

    public PdfPattern c4() {
        return new PdfPattern(this);
    }

    public void d2(float f2, float f3, float f4, float f5) {
        a4();
        super.d2(f2, f3, f4, f5);
    }

    public PdfPattern d4(int i2) {
        return new PdfPattern(this, i2);
    }

    public void e2(int i2, int i3, int i4, int i5) {
        a4();
        super.e2(i2, i3, i4, i5);
    }

    public float e4() {
        return this.O3;
    }

    public void f2(float f2, float f3, float f4, float f5) {
        a4();
        super.f2(f2, f3, f4, f5);
    }

    public float f4() {
        return this.P3;
    }

    public boolean g4() {
        return this.Q3;
    }

    public void h2(BaseColor baseColor) {
        a4();
        super.h2(baseColor);
    }

    public void h4(float f2, float f3, float f4, float f5, float f6, float f7) {
        X3(f2, f3, f4, f5, f6, f7);
    }

    public void i4(float f2) {
        this.O3 = f2;
    }

    public void j4(float f2) {
        this.P3 = f2;
    }

    public void k2(PdfSpotColor pdfSpotColor, float f2) {
        a4();
        super.k2(pdfSpotColor, f2);
    }

    public void l(Image image, float f2, float f3, float f4, float f5, float f6, float f7) throws DocumentException {
        if (this.Q3 && !image.F1()) {
            a4();
        }
        super.l(image, f2, f3, f4, f5, f6, f7);
    }

    public void l2(BaseColor baseColor) {
        a4();
        super.l2(baseColor);
    }

    public void o2(PdfSpotColor pdfSpotColor, float f2) {
        a4();
        super.o2(pdfSpotColor, f2);
    }

    public void u2(float f2) {
        a4();
        super.u2(f2);
    }

    public void v2(float f2) {
        a4();
        super.v2(f2);
    }

    PdfPatternPainter(PdfWriter pdfWriter) {
        super(pdfWriter);
        this.y3 = 3;
    }

    PdfPatternPainter(PdfWriter pdfWriter, BaseColor baseColor) {
        this(pdfWriter);
        if (baseColor == null) {
            this.R3 = BaseColor.f25675d;
        } else {
            this.R3 = baseColor;
        }
    }
}
