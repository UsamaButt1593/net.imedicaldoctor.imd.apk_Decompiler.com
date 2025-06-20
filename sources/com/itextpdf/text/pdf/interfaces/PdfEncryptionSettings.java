package com.itextpdf.text.pdf.interfaces;

import com.itextpdf.text.DocumentException;
import java.security.cert.Certificate;

public interface PdfEncryptionSettings {
    void m(Certificate[] certificateArr, int[] iArr, int i2) throws DocumentException;

    void r(byte[] bArr, byte[] bArr2, int i2, int i3) throws DocumentException;
}
