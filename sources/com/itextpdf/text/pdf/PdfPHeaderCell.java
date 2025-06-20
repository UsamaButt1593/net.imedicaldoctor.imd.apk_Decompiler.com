package com.itextpdf.text.pdf;

public class PdfPHeaderCell extends PdfPCell {
    public static final int S3 = 0;
    public static final int T3 = 1;
    public static final int U3 = 2;
    public static final int V3 = 3;
    protected int Q3 = 0;
    protected String R3 = null;

    public PdfPHeaderCell() {
        this.M3 = PdfName.Xf;
    }

    public PdfName L() {
        return this.M3;
    }

    public String V1() {
        return this.R3;
    }

    public int W1() {
        return this.Q3;
    }

    public void X1(String str) {
        this.R3 = str;
    }

    public void Y1(int i2) {
        this.Q3 = i2;
    }

    public void o(PdfName pdfName) {
        this.M3 = pdfName;
    }

    public PdfPHeaderCell(PdfPHeaderCell pdfPHeaderCell) {
        super((PdfPCell) pdfPHeaderCell);
        this.M3 = pdfPHeaderCell.M3;
        this.Q3 = pdfPHeaderCell.Q3;
        this.R3 = pdfPHeaderCell.V1();
    }
}
