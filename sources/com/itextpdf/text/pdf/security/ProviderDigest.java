package com.itextpdf.text.pdf.security;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public class ProviderDigest implements ExternalDigest {

    /* renamed from: a  reason: collision with root package name */
    private String f27325a;

    public ProviderDigest(String str) {
        this.f27325a = str;
    }

    public MessageDigest a(String str) throws GeneralSecurityException {
        return DigestAlgorithms.e(str, this.f27325a);
    }
}
