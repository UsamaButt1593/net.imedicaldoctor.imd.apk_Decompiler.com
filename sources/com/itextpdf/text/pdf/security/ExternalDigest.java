package com.itextpdf.text.pdf.security;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public interface ExternalDigest {
    MessageDigest a(String str) throws GeneralSecurityException;
}
