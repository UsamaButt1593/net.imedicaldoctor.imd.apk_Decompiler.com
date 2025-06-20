package com.itextpdf.text.pdf.security;

import java.security.GeneralSecurityException;

public interface ExternalSignature {
    String a();

    String b();

    byte[] c(byte[] bArr) throws GeneralSecurityException;
}
