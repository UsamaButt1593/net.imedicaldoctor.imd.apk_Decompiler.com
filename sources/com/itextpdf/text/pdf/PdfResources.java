package com.itextpdf.text.pdf;

class PdfResources extends PdfDictionary {
    PdfResources() {
    }

    /* access modifiers changed from: package-private */
    public void f1(PdfName pdfName, PdfDictionary pdfDictionary) {
        if (pdfDictionary.size() != 0) {
            PdfDictionary j0 = j0(pdfName);
            if (j0 == null) {
                V0(pdfName, pdfDictionary);
            } else {
                j0.X0(pdfDictionary);
            }
        }
    }
}
