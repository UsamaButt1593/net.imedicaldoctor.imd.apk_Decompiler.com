package com.itextpdf.text.pdf.security;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfDeveloperExtension;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfSignature;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfString;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.HashMap;

public class LtvTimestamp {
    public static void a(PdfSignatureAppearance pdfSignatureAppearance, TSAClient tSAClient, String str) throws IOException, DocumentException, GeneralSecurityException {
        int a2 = tSAClient.a();
        pdfSignatureAppearance.a(PdfDeveloperExtension.f26177f);
        pdfSignatureAppearance.p0(new Rectangle(0.0f, 0.0f, 0.0f, 0.0f), 1, str);
        PdfSignature pdfSignature = new PdfSignature(PdfName.z3, PdfName.w7);
        pdfSignature.V0(PdfName.Kg, PdfName.O6);
        pdfSignatureAppearance.T(pdfSignature);
        HashMap hashMap = new HashMap();
        hashMap.put(PdfName.N5, new Integer((a2 * 2) + 2));
        pdfSignatureAppearance.O(hashMap);
        InputStream x = pdfSignatureAppearance.x();
        MessageDigest c2 = tSAClient.c();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = x.read(bArr);
            if (read <= 0) {
                break;
            }
            c2.update(bArr, 0, read);
        }
        try {
            byte[] b2 = tSAClient.b(c2.digest());
            if (a2 + 2 >= b2.length) {
                byte[] bArr2 = new byte[a2];
                System.arraycopy(b2, 0, bArr2, 0, b2.length);
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.V0(PdfName.N5, new PdfString(bArr2).i0(true));
                pdfSignatureAppearance.d(pdfDictionary);
                return;
            }
            throw new IOException("Not enough space");
        } catch (Exception e2) {
            throw new GeneralSecurityException(e2);
        }
    }
}
