package com.itextpdf.text.pdf;

import java.io.IOException;

public class PdfRendition extends PdfDictionary {
    PdfRendition(String str, PdfFileSpecification pdfFileSpecification, String str2) throws IOException {
        V0(PdfName.Ce, new PdfName("MR"));
        PdfName pdfName = PdfName.kb;
        V0(pdfName, new PdfString("Rendition for " + str));
        V0(PdfName.K4, new PdfMediaClipData(str, pdfFileSpecification, str2));
    }
}
