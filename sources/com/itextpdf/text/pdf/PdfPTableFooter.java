package com.itextpdf.text.pdf;

public class PdfPTableFooter extends PdfPTableBody {
    protected PdfName X2 = PdfName.Wf;

    public PdfName L() {
        return this.X2;
    }

    public void o(PdfName pdfName) {
        this.X2 = pdfName;
    }
}
