package com.itextpdf.text.pdf;

public class PdfTransparencyGroup extends PdfDictionary {
    public PdfTransparencyGroup() {
        V0(PdfName.Ce, PdfName.vg);
    }

    public void f1(boolean z) {
        if (z) {
            V0(PdfName.x9, PdfBoolean.j3);
        } else {
            a1(PdfName.x9);
        }
    }

    public void i1(boolean z) {
        if (z) {
            V0(PdfName.ga, PdfBoolean.j3);
        } else {
            a1(PdfName.ga);
        }
    }
}
