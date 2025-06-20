package com.itextpdf.text.pdf.security;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class CRLVerifier extends RootStoreVerifier {

    /* renamed from: f  reason: collision with root package name */
    protected static final Logger f27247f = LoggerFactory.b(CRLVerifier.class);

    /* renamed from: e  reason: collision with root package name */
    List<X509CRL> f27248e;

    public CRLVerifier(CertificateVerifier certificateVerifier, List<X509CRL> list) {
        super(certificateVerifier);
        this.f27248e = list;
    }

    public List<VerificationOK> b(X509Certificate x509Certificate, X509Certificate x509Certificate2, Date date) throws GeneralSecurityException, IOException {
        int i2;
        ArrayList arrayList = new ArrayList();
        List<X509CRL> list = this.f27248e;
        boolean z = false;
        if (list != null) {
            i2 = 0;
            for (X509CRL f2 : list) {
                if (f(f2, x509Certificate, x509Certificate2, date)) {
                    i2++;
                }
            }
        } else {
            i2 = 0;
        }
        if (this.f27267b && i2 == 0 && f(d(x509Certificate, x509Certificate2), x509Certificate, x509Certificate2, date)) {
            i2++;
            z = true;
        }
        Logger logger = f27247f;
        logger.f("Valid CRLs found: " + i2);
        if (i2 > 0) {
            Class<?> cls = getClass();
            StringBuilder sb = new StringBuilder();
            sb.append("Valid CRLs found: ");
            sb.append(i2);
            sb.append(z ? " (online)" : "");
            arrayList.add(new VerificationOK(x509Certificate, cls, sb.toString()));
        }
        CertificateVerifier certificateVerifier = this.f27266a;
        if (certificateVerifier != null) {
            arrayList.addAll(certificateVerifier.b(x509Certificate, x509Certificate2, date));
        }
        return arrayList;
    }

    public X509CRL d(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            String c2 = CertificateUtil.c(x509Certificate);
            if (c2 == null) {
                return null;
            }
            Logger logger = f27247f;
            logger.f("Getting CRL from " + c2);
            return (X509CRL) CertificateFactory.getInstance("X.509").generateCRL(new URL(c2).openStream());
        } catch (IOException | GeneralSecurityException unused) {
            return null;
        }
    }

    public boolean e(X509CRL x509crl, X509Certificate x509Certificate) {
        if (x509Certificate != null) {
            try {
                x509crl.verify(x509Certificate.getPublicKey());
                return true;
            } catch (GeneralSecurityException unused) {
                f27247f.g("CRL not issued by the same authority as the certificate that is being checked");
            }
        }
        KeyStore keyStore = this.f27327c;
        if (keyStore == null) {
            return false;
        }
        try {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                String nextElement = aliases.nextElement();
                try {
                    if (this.f27327c.isCertificateEntry(nextElement)) {
                        x509crl.verify(((X509Certificate) this.f27327c.getCertificate(nextElement)).getPublicKey());
                        return true;
                    }
                } catch (GeneralSecurityException unused2) {
                }
            }
        } catch (GeneralSecurityException unused3) {
        }
        return false;
    }

    public boolean f(X509CRL x509crl, X509Certificate x509Certificate, X509Certificate x509Certificate2, Date date) throws GeneralSecurityException {
        if (x509crl == null || date == null || !x509crl.getIssuerX500Principal().equals(x509Certificate.getIssuerX500Principal()) || !date.after(x509crl.getThisUpdate()) || !date.before(x509crl.getNextUpdate())) {
            return false;
        }
        if (!e(x509crl, x509Certificate2) || !x509crl.isRevoked(x509Certificate)) {
            return true;
        }
        throw new VerificationException(x509Certificate, "The certificate has been revoked.");
    }
}
