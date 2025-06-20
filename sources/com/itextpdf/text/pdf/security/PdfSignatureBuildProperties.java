package com.itextpdf.text.pdf.security;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;

public class PdfSignatureBuildProperties extends PdfDictionary {
    private PdfSignatureAppDictionary f1() {
        PdfName pdfName = PdfName.T3;
        PdfSignatureAppDictionary pdfSignatureAppDictionary = (PdfSignatureAppDictionary) j0(pdfName);
        if (pdfSignatureAppDictionary != null) {
            return pdfSignatureAppDictionary;
        }
        PdfSignatureAppDictionary pdfSignatureAppDictionary2 = new PdfSignatureAppDictionary();
        V0(pdfName, pdfSignatureAppDictionary2);
        return pdfSignatureAppDictionary2;
    }

    public void i1(String str) {
        f1().f1(str);
    }
}
