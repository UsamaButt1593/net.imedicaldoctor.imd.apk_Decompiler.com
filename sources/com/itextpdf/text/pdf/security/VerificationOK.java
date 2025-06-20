package com.itextpdf.text.pdf.security;

import java.security.cert.X509Certificate;

public class VerificationOK {

    /* renamed from: a  reason: collision with root package name */
    protected X509Certificate f27371a;

    /* renamed from: b  reason: collision with root package name */
    protected Class<? extends CertificateVerifier> f27372b;

    /* renamed from: c  reason: collision with root package name */
    protected String f27373c;

    public VerificationOK(X509Certificate x509Certificate, Class<? extends CertificateVerifier> cls, String str) {
        this.f27371a = x509Certificate;
        this.f27372b = cls;
        this.f27373c = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        X509Certificate x509Certificate = this.f27371a;
        if (x509Certificate != null) {
            sb.append(x509Certificate.getSubjectDN().getName());
            sb.append(" verified with ");
        }
        sb.append(this.f27372b.getName());
        sb.append(": ");
        sb.append(this.f27373c);
        return sb.toString();
    }
}
