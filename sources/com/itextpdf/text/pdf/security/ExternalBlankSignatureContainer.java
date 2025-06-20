package com.itextpdf.text.pdf.security;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import java.io.InputStream;
import java.security.GeneralSecurityException;

public class ExternalBlankSignatureContainer implements ExternalSignatureContainer {

    /* renamed from: a  reason: collision with root package name */
    private PdfDictionary f27280a;

    public ExternalBlankSignatureContainer(PdfDictionary pdfDictionary) {
        this.f27280a = pdfDictionary;
    }

    public void a(PdfDictionary pdfDictionary) {
        pdfDictionary.X0(this.f27280a);
    }

    public byte[] b(InputStream inputStream) throws GeneralSecurityException {
        return new byte[0];
    }

    public ExternalBlankSignatureContainer(PdfName pdfName, PdfName pdfName2) {
        PdfDictionary pdfDictionary = new PdfDictionary();
        this.f27280a = pdfDictionary;
        pdfDictionary.V0(PdfName.T7, pdfName);
        this.f27280a.V0(PdfName.zf, pdfName2);
    }
}
