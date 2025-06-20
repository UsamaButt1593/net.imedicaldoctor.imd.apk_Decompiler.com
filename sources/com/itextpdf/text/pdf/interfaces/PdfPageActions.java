package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfTransition;

public interface PdfPageActions {
    void A(PdfTransition pdfTransition);

    void y(int i2);

    void z(PdfName pdfName, PdfAction pdfAction) throws DocumentException;
}
