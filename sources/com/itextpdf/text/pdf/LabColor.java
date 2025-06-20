package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;

public class LabColor extends ExtendedColor {
    private float A;
    private float B;
    private float C;
    PdfLabColor z;

    public LabColor(PdfLabColor pdfLabColor, float f2, float f3, float f4) {
        super(7);
        this.z = pdfLabColor;
        this.A = f2;
        this.B = f3;
        this.C = f4;
        BaseColor d2 = pdfLabColor.d(f2, f3, f4);
        h(d2.g(), d2.e(), d2.d(), 255);
    }

    public float m() {
        return this.B;
    }

    public float n() {
        return this.C;
    }

    public float o() {
        return this.A;
    }

    public PdfLabColor p() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public CMYKColor q() {
        return this.z.c(this.A, this.B, this.C);
    }

    public BaseColor r() {
        return this.z.d(this.A, this.B, this.C);
    }
}
