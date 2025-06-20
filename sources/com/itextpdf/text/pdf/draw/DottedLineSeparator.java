package com.itextpdf.text.pdf.draw;

import com.itextpdf.text.pdf.PdfContentByte;

public class DottedLineSeparator extends LineSeparator {
    protected float Z2 = 5.0f;

    public void a(PdfContentByte pdfContentByte, float f2, float f3, float f4, float f5, float f6) {
        pdfContentByte.a2();
        pdfContentByte.J2(this.Y);
        pdfContentByte.y2(1);
        float f7 = this.Z2;
        pdfContentByte.E2(0.0f, f7, f7 / 2.0f);
        h(pdfContentByte, f2, f4, f6);
        pdfContentByte.U1();
    }

    public float q() {
        return this.Z2;
    }

    public void r(float f2) {
        this.Z2 = f2;
    }
}
