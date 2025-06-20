package com.itextpdf.text.pdf;

public interface ICachedColorSpace {
    PdfObject b(PdfWriter pdfWriter);

    boolean equals(Object obj);

    int hashCode();
}
