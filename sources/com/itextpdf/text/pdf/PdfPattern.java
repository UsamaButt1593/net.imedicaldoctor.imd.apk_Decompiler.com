package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;

public class PdfPattern extends PdfStream {
    PdfPattern(PdfPatternPainter pdfPatternPainter) {
        this(pdfPatternPainter, -1);
    }

    PdfPattern(PdfPatternPainter pdfPatternPainter, int i2) {
        PdfNumber pdfNumber = new PdfNumber(1);
        PdfArray L3 = pdfPatternPainter.L3();
        if (L3 != null) {
            V0(PdfName.Qa, L3);
        }
        V0(PdfName.Kg, PdfName.Ic);
        V0(PdfName.n4, new PdfRectangle(pdfPatternPainter.F3()));
        V0(PdfName.Wd, pdfPatternPainter.N3());
        V0(PdfName.dg, pdfNumber);
        V0(PdfName.Jc, pdfNumber);
        if (pdfPatternPainter.g4()) {
            V0(PdfName.Ac, new PdfNumber(2));
        } else {
            V0(PdfName.Ac, pdfNumber);
        }
        V0(PdfName.ei, new PdfNumber(pdfPatternPainter.e4()));
        V0(PdfName.gi, new PdfNumber(pdfPatternPainter.f4()));
        byte[] w3 = pdfPatternPainter.w3((PdfWriter) null);
        this.s = w3;
        V0(PdfName.va, new PdfNumber(w3.length));
        try {
            i1(i2);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }
}
