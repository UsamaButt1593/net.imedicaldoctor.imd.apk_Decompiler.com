package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;

public class PdfCollectionSchema extends PdfDictionary {
    public PdfCollectionSchema() {
        super(PdfName.B5);
    }

    public void f1(String str, PdfCollectionField pdfCollectionField) {
        V0(new PdfName(str), pdfCollectionField);
    }
}
