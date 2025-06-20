package com.itextpdf.text.pdf.security;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class RootStoreVerifier extends CertificateVerifier {

    /* renamed from: d  reason: collision with root package name */
    protected static final Logger f27326d = LoggerFactory.b(RootStoreVerifier.class);

    /* renamed from: c  reason: collision with root package name */
    protected KeyStore f27327c = null;

    public RootStoreVerifier(CertificateVerifier certificateVerifier) {
        super(certificateVerifier);
    }

    public List<VerificationOK> b(X509Certificate x509Certificate, X509Certificate x509Certificate2, Date date) throws GeneralSecurityException, IOException {
        Logger logger = f27326d;
        logger.f("Root store verification: " + x509Certificate.getSubjectDN().getName());
        if (this.f27327c == null) {
            return super.b(x509Certificate, x509Certificate2, date);
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration<String> aliases = this.f27327c.aliases();
            while (aliases.hasMoreElements()) {
                String nextElement = aliases.nextElement();
                try {
                    if (this.f27327c.isCertificateEntry(nextElement)) {
                        x509Certificate.verify(((X509Certificate) this.f27327c.getCertificate(nextElement)).getPublicKey());
                        f27326d.f("Certificate verified against root store");
                        arrayList.add(new VerificationOK(x509Certificate, getClass(), "Certificate verified against root store."));
                        arrayList.addAll(super.b(x509Certificate, x509Certificate2, date));
                        return arrayList;
                    }
                } catch (GeneralSecurityException unused) {
                }
            }
            arrayList.addAll(super.b(x509Certificate, x509Certificate2, date));
            return arrayList;
        } catch (GeneralSecurityException unused2) {
            return super.b(x509Certificate, x509Certificate2, date);
        }
    }

    public void c(KeyStore keyStore) {
        this.f27327c = keyStore;
    }
}
