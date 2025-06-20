package com.itextpdf.text.pdf;

import java.io.IOException;

public class PdfMediaClipData extends PdfDictionary {
    PdfMediaClipData(String str, PdfFileSpecification pdfFileSpecification, String str2) throws IOException {
        V0(PdfName.Kg, new PdfName("MediaClip"));
        V0(PdfName.Ce, new PdfName("MCD"));
        PdfName pdfName = PdfName.kb;
        V0(pdfName, new PdfString("Media clip for " + str));
        V0(new PdfName("CT"), new PdfString(str2));
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(new PdfName("TF"), new PdfString("TEMPACCESS"));
        V0(new PdfName("P"), pdfDictionary);
        V0(PdfName.f6, pdfFileSpecification.v1());
    }
}
