package com.itextpdf.text.pdf.security;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cert.ocsp.BasicOCSPResp;
import org.spongycastle.cert.ocsp.CertificateStatus;
import org.spongycastle.cert.ocsp.OCSPException;
import org.spongycastle.cert.ocsp.SingleResp;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.operator.bc.BcDigestCalculatorProvider;
import org.spongycastle.operator.jcajce.JcaContentVerifierProviderBuilder;

public class OCSPVerifier extends RootStoreVerifier {

    /* renamed from: f  reason: collision with root package name */
    protected static final Logger f27302f = LoggerFactory.b(OCSPVerifier.class);

    /* renamed from: g  reason: collision with root package name */
    protected static final String f27303g = "1.3.6.1.5.5.7.3.9";

    /* renamed from: e  reason: collision with root package name */
    protected List<BasicOCSPResp> f27304e;

    public OCSPVerifier(CertificateVerifier certificateVerifier, List<BasicOCSPResp> list) {
        super(certificateVerifier);
        this.f27304e = list;
    }

    public List<VerificationOK> b(X509Certificate x509Certificate, X509Certificate x509Certificate2, Date date) throws GeneralSecurityException, IOException {
        int i2;
        ArrayList arrayList = new ArrayList();
        List<BasicOCSPResp> list = this.f27304e;
        boolean z = false;
        if (list != null) {
            i2 = 0;
            for (BasicOCSPResp g2 : list) {
                if (g(g2, x509Certificate, x509Certificate2, date)) {
                    i2++;
                }
            }
        } else {
            i2 = 0;
        }
        if (this.f27267b && i2 == 0 && g(d(x509Certificate, x509Certificate2), x509Certificate, x509Certificate2, date)) {
            i2++;
            z = true;
        }
        Logger logger = f27302f;
        logger.f("Valid OCSPs found: " + i2);
        if (i2 > 0) {
            Class<?> cls = getClass();
            StringBuilder sb = new StringBuilder();
            sb.append("Valid OCSPs Found: ");
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

    public BasicOCSPResp d(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        BasicOCSPResp c2;
        if ((x509Certificate == null && x509Certificate2 == null) || (c2 = new OcspClientBouncyCastle().c(x509Certificate, x509Certificate2, (String) null)) == null) {
            return null;
        }
        SingleResp[] responses = c2.getResponses();
        for (SingleResp certStatus : responses) {
            if (certStatus.getCertStatus() == CertificateStatus.GOOD) {
                return c2;
            }
        }
        return null;
    }

    public boolean e(BasicOCSPResp basicOCSPResp, Certificate certificate) {
        try {
            return basicOCSPResp.isSignatureValid(new JcaContentVerifierProviderBuilder().setProvider("BC").build(certificate.getPublicKey()));
        } catch (OCSPException | OperatorCreationException unused) {
            return false;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(org.spongycastle.cert.ocsp.BasicOCSPResp r10, java.security.cert.X509Certificate r11) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r9 = this;
            boolean r0 = r9.e(r10, r11)
            r1 = 0
            if (r0 == 0) goto L_0x0009
            r0 = r11
            goto L_0x000a
        L_0x0009:
            r0 = r1
        L_0x000a:
            if (r0 != 0) goto L_0x0081
            org.spongycastle.cert.X509CertificateHolder[] r2 = r10.getCerts()
            java.lang.String r3 = "OCSP response could not be verified"
            if (r2 == 0) goto L_0x0049
            org.spongycastle.cert.X509CertificateHolder[] r2 = r10.getCerts()
            int r4 = r2.length
            r5 = 0
        L_0x001a:
            if (r5 >= r4) goto L_0x0040
            r6 = r2[r5]
            org.spongycastle.cert.jcajce.JcaX509CertificateConverter r7 = new org.spongycastle.cert.jcajce.JcaX509CertificateConverter     // Catch:{ Exception -> 0x003d }
            r7.<init>()     // Catch:{ Exception -> 0x003d }
            java.security.cert.X509Certificate r6 = r7.getCertificate(r6)     // Catch:{ Exception -> 0x003d }
            java.util.List r7 = r6.getExtendedKeyUsage()     // Catch:{  }
            if (r7 == 0) goto L_0x003d
            java.lang.String r8 = "1.3.6.1.5.5.7.3.9"
            boolean r7 = r7.contains(r8)     // Catch:{  }
            if (r7 == 0) goto L_0x003d
            boolean r7 = r9.e(r10, r6)     // Catch:{  }
            if (r7 == 0) goto L_0x003d
            r0 = r6
            goto L_0x0040
        L_0x003d:
            int r5 = r5 + 1
            goto L_0x001a
        L_0x0040:
            if (r0 == 0) goto L_0x0043
            goto L_0x0081
        L_0x0043:
            com.itextpdf.text.pdf.security.VerificationException r10 = new com.itextpdf.text.pdf.security.VerificationException
            r10.<init>(r11, r3)
            throw r10
        L_0x0049:
            java.security.KeyStore r2 = r9.f27327c
            if (r2 == 0) goto L_0x0078
            java.util.Enumeration r2 = r2.aliases()     // Catch:{ KeyStoreException -> 0x0076 }
        L_0x0051:
            boolean r4 = r2.hasMoreElements()     // Catch:{ KeyStoreException -> 0x0076 }
            if (r4 == 0) goto L_0x0078
            java.lang.Object r4 = r2.nextElement()     // Catch:{ KeyStoreException -> 0x0076 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ KeyStoreException -> 0x0076 }
            java.security.KeyStore r5 = r9.f27327c     // Catch:{ GeneralSecurityException -> 0x0051 }
            boolean r5 = r5.isCertificateEntry(r4)     // Catch:{ GeneralSecurityException -> 0x0051 }
            if (r5 != 0) goto L_0x0066
            goto L_0x0051
        L_0x0066:
            java.security.KeyStore r5 = r9.f27327c     // Catch:{ GeneralSecurityException -> 0x0051 }
            java.security.cert.Certificate r4 = r5.getCertificate(r4)     // Catch:{ GeneralSecurityException -> 0x0051 }
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4     // Catch:{ GeneralSecurityException -> 0x0051 }
            boolean r5 = r9.e(r10, r4)     // Catch:{ GeneralSecurityException -> 0x0051 }
            if (r5 == 0) goto L_0x0051
            r0 = r4
            goto L_0x0078
        L_0x0076:
            r0 = r1
        L_0x0078:
            if (r0 == 0) goto L_0x007b
            goto L_0x0081
        L_0x007b:
            com.itextpdf.text.pdf.security.VerificationException r10 = new com.itextpdf.text.pdf.security.VerificationException
            r10.<init>(r11, r3)
            throw r10
        L_0x0081:
            java.security.PublicKey r10 = r11.getPublicKey()
            r0.verify(r10)
            org.spongycastle.asn1.ASN1ObjectIdentifier r10 = org.spongycastle.asn1.ocsp.OCSPObjectIdentifiers.id_pkix_ocsp_nocheck
            java.lang.String r10 = r10.getId()
            byte[] r10 = r0.getExtensionValue(r10)
            if (r10 != 0) goto L_0x00bb
            java.security.cert.CRL r10 = com.itextpdf.text.pdf.security.CertificateUtil.b(r0)     // Catch:{ Exception -> 0x0099 }
            goto L_0x009b
        L_0x0099:
            r10 = r1
        L_0x009b:
            if (r10 == 0) goto L_0x00bb
            boolean r2 = r10 instanceof java.security.cert.X509CRL
            if (r2 == 0) goto L_0x00bb
            com.itextpdf.text.pdf.security.CRLVerifier r2 = new com.itextpdf.text.pdf.security.CRLVerifier
            r2.<init>(r1, r1)
            java.security.KeyStore r1 = r9.f27327c
            r2.c(r1)
            boolean r1 = r9.f27267b
            r2.a(r1)
            java.security.cert.X509CRL r10 = (java.security.cert.X509CRL) r10
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            r2.f(r10, r0, r11, r1)
            return
        L_0x00bb:
            r0.checkValidity()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.security.OCSPVerifier.f(org.spongycastle.cert.ocsp.BasicOCSPResp, java.security.cert.X509Certificate):void");
    }

    public boolean g(BasicOCSPResp basicOCSPResp, X509Certificate x509Certificate, X509Certificate x509Certificate2, Date date) throws GeneralSecurityException, IOException {
        if (basicOCSPResp == null) {
            return false;
        }
        SingleResp[] responses = basicOCSPResp.getResponses();
        for (int i2 = 0; i2 < responses.length; i2++) {
            if (x509Certificate.getSerialNumber().equals(responses[i2].getCertID().getSerialNumber())) {
                if (x509Certificate2 == null) {
                    x509Certificate2 = x509Certificate;
                }
                try {
                    if (!responses[i2].getCertID().matchesIssuer(new X509CertificateHolder(x509Certificate2.getEncoded()), new BcDigestCalculatorProvider())) {
                        f27302f.f("OCSP: Issuers doesn't match.");
                    } else {
                        Date nextUpdate = responses[i2].getNextUpdate();
                        if (nextUpdate == null) {
                            nextUpdate = new Date(responses[i2].getThisUpdate().getTime() + 180000);
                            f27302f.f(String.format("No 'next update' for OCSP Response; assuming %s", new Object[]{nextUpdate}));
                        }
                        if (date.after(nextUpdate)) {
                            f27302f.f(String.format("OCSP no longer valid: %s after %s", new Object[]{date, nextUpdate}));
                        } else if (responses[i2].getCertStatus() == CertificateStatus.GOOD) {
                            f(basicOCSPResp, x509Certificate2);
                            return true;
                        }
                    }
                } catch (OCSPException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    @Deprecated
    public boolean h(BasicOCSPResp basicOCSPResp, X509Certificate x509Certificate) {
        try {
            f(basicOCSPResp, x509Certificate);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
