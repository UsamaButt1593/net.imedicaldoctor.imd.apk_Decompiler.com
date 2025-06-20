package com.itextpdf.text.pdf.security;

import java.security.cert.X509Certificate;
import java.util.Collection;

public interface CrlClient {
    Collection<byte[]> a(X509Certificate x509Certificate, String str);
}
