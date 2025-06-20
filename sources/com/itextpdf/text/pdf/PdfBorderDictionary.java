package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;

public class PdfBorderDictionary extends PdfDictionary {
    public static final int p3 = 0;
    public static final int q3 = 1;
    public static final int r3 = 2;
    public static final int s3 = 3;
    public static final int t3 = 4;

    public PdfBorderDictionary(float f2, int i2) {
        this(f2, i2, (PdfDashPattern) null);
    }

    public PdfBorderDictionary(float f2, int i2, PdfDashPattern pdfDashPattern) {
        PdfName pdfName;
        PdfName pdfName2;
        V0(PdfName.Dh, new PdfNumber(f2));
        if (i2 != 0) {
            if (i2 == 1) {
                if (pdfDashPattern != null) {
                    V0(PdfName.f6, pdfDashPattern);
                }
                pdfName = PdfName.Ce;
                pdfName2 = PdfName.f6;
            } else if (i2 == 2) {
                pdfName = PdfName.Ce;
                pdfName2 = PdfName.h4;
            } else if (i2 == 3) {
                pdfName = PdfName.Ce;
                pdfName2 = PdfName.x9;
            } else if (i2 == 4) {
                pdfName = PdfName.Ce;
                pdfName2 = PdfName.Og;
            } else {
                throw new IllegalArgumentException(MessageLocalization.b("invalid.border.style", new Object[0]));
            }
            V0(pdfName, pdfName2);
            return;
        }
        PdfName pdfName3 = PdfName.Ce;
        V0(pdfName3, pdfName3);
    }
}
