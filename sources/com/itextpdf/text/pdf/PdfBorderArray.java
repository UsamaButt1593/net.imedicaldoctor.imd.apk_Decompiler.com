package com.itextpdf.text.pdf;

public class PdfBorderArray extends PdfArray {
    public PdfBorderArray(float f2, float f3, float f4) {
        this(f2, f3, f4, (PdfDashPattern) null);
    }

    public PdfBorderArray(float f2, float f3, float f4, PdfDashPattern pdfDashPattern) {
        super((PdfObject) new PdfNumber(f2));
        a0(new PdfNumber(f3));
        a0(new PdfNumber(f4));
        if (pdfDashPattern != null) {
            a0(pdfDashPattern);
        }
    }
}
