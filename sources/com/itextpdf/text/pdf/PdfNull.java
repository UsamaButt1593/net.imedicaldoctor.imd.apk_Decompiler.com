package com.itextpdf.text.pdf;

public class PdfNull extends PdfObject {
    public static final PdfNull i3 = new PdfNull();
    private static final String j3 = "null";

    public PdfNull() {
        super(8, j3);
    }

    public String toString() {
        return j3;
    }
}
