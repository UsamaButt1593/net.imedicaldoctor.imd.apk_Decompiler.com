package com.itextpdf.text.pdf;

public class PdfPTableHeader extends PdfPTableBody {
    protected PdfName X2 = PdfName.Yf;

    public PdfName L() {
        return this.X2;
    }

    public void o(PdfName pdfName) {
        this.X2 = pdfName;
    }
}
