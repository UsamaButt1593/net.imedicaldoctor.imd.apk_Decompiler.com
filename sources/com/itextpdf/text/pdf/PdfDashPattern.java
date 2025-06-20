package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;

public class PdfDashPattern extends PdfArray {
    private float j3;
    private float k3;
    private float l3;

    public PdfDashPattern() {
        this.j3 = -1.0f;
        this.k3 = -1.0f;
        this.l3 = -1.0f;
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        outputStream.write(91);
        float f2 = this.j3;
        if (f2 >= 0.0f) {
            new PdfNumber(f2).T(pdfWriter, outputStream);
            if (this.k3 >= 0.0f) {
                outputStream.write(32);
                new PdfNumber(this.k3).T(pdfWriter, outputStream);
            }
        }
        outputStream.write(93);
        if (this.l3 >= 0.0f) {
            outputStream.write(32);
            new PdfNumber(this.l3).T(pdfWriter, outputStream);
        }
    }

    public void X0(float f2) {
        a0(new PdfNumber(f2));
    }

    public PdfDashPattern(float f2) {
        super((PdfObject) new PdfNumber(f2));
        this.k3 = -1.0f;
        this.l3 = -1.0f;
        this.j3 = f2;
    }

    public PdfDashPattern(float f2, float f3) {
        super((PdfObject) new PdfNumber(f2));
        this.j3 = -1.0f;
        this.k3 = -1.0f;
        this.l3 = -1.0f;
        a0(new PdfNumber(f3));
        this.j3 = f2;
        this.k3 = f3;
    }

    public PdfDashPattern(float f2, float f3, float f4) {
        super((PdfObject) new PdfNumber(f2));
        this.j3 = -1.0f;
        this.k3 = -1.0f;
        this.l3 = -1.0f;
        a0(new PdfNumber(f3));
        this.j3 = f2;
        this.k3 = f3;
        this.l3 = f4;
    }
}
