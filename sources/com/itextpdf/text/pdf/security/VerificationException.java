package com.itextpdf.text.pdf.security;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public class VerificationException extends GeneralSecurityException {
    private static final long s = 2978604513926438256L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerificationException(Certificate certificate, String str) {
        super(String.format("Certificate %s failed: %s", new Object[]{certificate == null ? "Unknown" : ((X509Certificate) certificate).getSubjectDN().getName(), str}));
    }
}
