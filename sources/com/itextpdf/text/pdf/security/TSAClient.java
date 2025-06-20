package com.itextpdf.text.pdf.security;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public interface TSAClient {
    int a();

    byte[] b(byte[] bArr) throws Exception;

    MessageDigest c() throws GeneralSecurityException;
}
