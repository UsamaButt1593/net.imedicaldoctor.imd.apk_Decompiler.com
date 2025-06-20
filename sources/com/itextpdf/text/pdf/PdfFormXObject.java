package com.itextpdf.text.pdf;

public class PdfFormXObject extends PdfStream {
    public static final PdfNumber E3 = new PdfNumber(0);
    public static final PdfNumber F3 = new PdfNumber(1);
    public static final PdfLiteral G3 = new PdfLiteral("[1 0 0 1 0 0]");

    PdfFormXObject(PdfTemplate pdfTemplate, int i2) {
        V0(PdfName.Kg, PdfName.ai);
        V0(PdfName.Cf, PdfName.w8);
        V0(PdfName.Wd, pdfTemplate.N3());
        V0(PdfName.n4, new PdfRectangle(pdfTemplate.F3()));
        V0(PdfName.x8, F3);
        if (pdfTemplate.K3() != null) {
            V0(PdfName.Pb, pdfTemplate.K3().g());
        }
        if (pdfTemplate.H3() != null) {
            V0(PdfName.S8, pdfTemplate.H3());
        }
        PdfArray L3 = pdfTemplate.L3();
        if (L3 == null) {
            V0(PdfName.Qa, G3);
        } else {
            V0(PdfName.Qa, L3);
        }
        byte[] w3 = pdfTemplate.w3((PdfWriter) null);
        this.s = w3;
        V0(PdfName.va, new PdfNumber(w3.length));
        if (pdfTemplate.E3() != null) {
            X0(pdfTemplate.E3());
        }
        i1(i2);
    }
}
