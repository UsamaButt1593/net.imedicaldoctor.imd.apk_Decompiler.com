package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;

public interface IPdfStructureElement {
    PdfObject b(PdfName pdfName);

    void h(PdfName pdfName, PdfObject pdfObject);
}
