package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import java.util.HashMap;

public interface IAccessibleElement {
    void D(AccessibleElementId accessibleElementId);

    PdfName L();

    void U(PdfName pdfName, PdfObject pdfObject);

    AccessibleElementId getId();

    HashMap<PdfName, PdfObject> k0();

    boolean n();

    void o(PdfName pdfName);

    PdfObject r(PdfName pdfName);
}
