package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfName;

public interface PdfDocumentActions {
    void i(PdfAction pdfAction);

    void l(String str);

    void p(PdfName pdfName, PdfAction pdfAction) throws DocumentException;
}
