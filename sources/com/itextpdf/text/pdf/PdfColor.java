package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;

class PdfColor extends PdfArray {
    PdfColor(int i2, int i3, int i4) {
        super((PdfObject) new PdfNumber(((double) (i2 & 255)) / 255.0d));
        a0(new PdfNumber(((double) (i3 & 255)) / 255.0d));
        a0(new PdfNumber(((double) (i4 & 255)) / 255.0d));
    }

    PdfColor(BaseColor baseColor) {
        this(baseColor.g(), baseColor.e(), baseColor.d());
    }
}
