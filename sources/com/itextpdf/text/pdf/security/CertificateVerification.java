package com.itextpdf.text.pdf.security;

import java.security.KeyStore;
import java.security.cert.CRL;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import org.spongycastle.cert.ocsp.BasicOCSPResp;
import org.spongycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.spongycastle.operator.jcajce.JcaContentVerifierProviderBuilder;
import org.spongycastle.tsp.TimeStampToken;

public class CertificateVerification {
    public static String a(X509Certificate x509Certificate, Collection<CRL> collection, Calendar calendar) {
        if (calendar == null) {
            calendar = new GregorianCalendar();
        }
        if (x509Certificate.hasUnsupportedCriticalExtension()) {
            for (String next : x509Certificate.getCriticalExtensionOIDs()) {
                if (!"2.5.29.15".equals(next) || !x509Certificate.getKeyUsage()[0]) {
                    try {
                        if (!"2.5.29.37".equals(next) || !x509Certificate.getExtendedKeyUsage().contains("1.3.6.1.5.5.7.3.8")) {
                            return "Has unsupported critical extension";
                        }
                    } catch (CertificateParsingException unused) {
                        return "Has unsupported critical extension";
                    }
                }
            }
        }
        try {
            x509Certificate.checkValidity(calendar.getTime());
            if (collection == null) {
                return null;
            }
            for (CRL isRevoked : collection) {
                if (isRevoked.isRevoked(x509Certificate)) {
                    return "Certificate revoked";
                }
            }
            return null;
        } catch (Exception e2) {
            return e2.getMessage();
        }
    }

    public static List<VerificationException> b(Certificate[] certificateArr, KeyStore keyStore, Calendar calendar) {
        return c(certificateArr, keyStore, (Collection<CRL>) null, calendar);
    }

    public static List<VerificationException> c(Certificate[] certificateArr, KeyStore keyStore, Collection<CRL> collection, Calendar calendar) {
        ArrayList arrayList = new ArrayList();
        if (calendar == null) {
            calendar = new GregorianCalendar();
        }
        for (int i2 = 0; i2 < certificateArr.length; i2++) {
            X509Certificate x509Certificate = certificateArr[i2];
            String a2 = a(x509Certificate, collection, calendar);
            if (a2 != null) {
                arrayList.add(new VerificationException(x509Certificate, a2));
            }
            try {
                Enumeration<String> aliases = keyStore.aliases();
                while (aliases.hasMoreElements()) {
                    try {
                        String nextElement = aliases.nextElement();
                        if (keyStore.isCertificateEntry(nextElement)) {
                            X509Certificate x509Certificate2 = (X509Certificate) keyStore.getCertificate(nextElement);
                            if (a(x509Certificate2, collection, calendar) == null) {
                                x509Certificate.verify(x509Certificate2.getPublicKey());
                                return arrayList;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
            }
            int i3 = 0;
            while (i3 < certificateArr.length) {
                if (i3 != i2) {
                    try {
                        x509Certificate.verify(certificateArr[i3].getPublicKey());
                        break;
                    } catch (Exception unused3) {
                        continue;
                    }
                }
                i3++;
            }
            if (i3 == certificateArr.length) {
                arrayList.add(new VerificationException(x509Certificate, "Cannot be verified against the KeyStore or the certificate chain"));
            }
        }
        if (arrayList.size() == 0) {
            arrayList.add(new VerificationException((Certificate) null, "Invalid state. Possible circular certificate chain"));
        }
        return arrayList;
    }

    public static boolean d(BasicOCSPResp basicOCSPResp, KeyStore keyStore, String str) {
        if (str == null) {
            str = "BC";
        }
        try {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                try {
                    String nextElement = aliases.nextElement();
                    if (keyStore.isCertificateEntry(nextElement)) {
                        if (basicOCSPResp.isSignatureValid(new JcaContentVerifierProviderBuilder().setProvider(str).build(((X509Certificate) keyStore.getCertificate(nextElement)).getPublicKey()))) {
                            return true;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean e(TimeStampToken timeStampToken, KeyStore keyStore, String str) {
        if (str == null) {
            str = "BC";
        }
        try {
            Enumeration<String> aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                try {
                    String nextElement = aliases.nextElement();
                    if (keyStore.isCertificateEntry(nextElement)) {
                        timeStampToken.isSignatureValid(new JcaSimpleSignerInfoVerifierBuilder().setProvider(str).build((X509Certificate) keyStore.getCertificate(nextElement)));
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }
}
