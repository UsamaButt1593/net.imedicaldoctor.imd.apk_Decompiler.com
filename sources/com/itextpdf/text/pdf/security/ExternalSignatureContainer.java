package com.itextpdf.text.pdf.security;

import com.itextpdf.text.pdf.PdfDictionary;
import java.io.InputStream;
import java.security.GeneralSecurityException;

public interface ExternalSignatureContainer {
    void a(PdfDictionary pdfDictionary);

    byte[] b(InputStream inputStream) throws GeneralSecurityException;
}
