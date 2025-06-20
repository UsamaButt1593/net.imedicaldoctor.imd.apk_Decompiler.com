package com.itextpdf.text.pdf.security;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CertificateVerifier {

    /* renamed from: a  reason: collision with root package name */
    protected CertificateVerifier f27266a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f27267b = true;

    public CertificateVerifier(CertificateVerifier certificateVerifier) {
        this.f27266a = certificateVerifier;
    }

    public void a(boolean z) {
        this.f27267b = z;
    }

    public List<VerificationOK> b(X509Certificate x509Certificate, X509Certificate x509Certificate2, Date date) throws GeneralSecurityException, IOException {
        if (date != null) {
            x509Certificate.checkValidity(date);
        }
        x509Certificate.verify(x509Certificate2 != null ? x509Certificate2.getPublicKey() : x509Certificate.getPublicKey());
        ArrayList arrayList = new ArrayList();
        CertificateVerifier certificateVerifier = this.f27266a;
        if (certificateVerifier != null) {
            arrayList.addAll(certificateVerifier.b(x509Certificate, x509Certificate2, date));
        }
        return arrayList;
    }
}
