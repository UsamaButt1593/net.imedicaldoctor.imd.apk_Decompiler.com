package com.itextpdf.text.pdf.security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;

public class CertificateUtil {
    public static CRL a(String str) throws IOException, CertificateException, CRLException {
        if (str == null) {
            return null;
        }
        return CertificateFactory.getInstance("X.509").generateCRL(new URL(str).openStream());
    }

    public static CRL b(X509Certificate x509Certificate) throws CertificateException, CRLException, IOException {
        return a(c(x509Certificate));
    }

    public static String c(X509Certificate x509Certificate) throws CertificateParsingException {
        ASN1Primitive aSN1Primitive;
        try {
            aSN1Primitive = d(x509Certificate, Extension.cRLDistributionPoints.getId());
        } catch (IOException unused) {
            aSN1Primitive = null;
        }
        if (aSN1Primitive == null) {
            return null;
        }
        for (DistributionPoint distributionPoint : CRLDistPoint.getInstance(aSN1Primitive).getDistributionPoints()) {
            DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
            if (distributionPoint2.getType() == 0) {
                for (GeneralName generalName : distributionPoint2.getName().getNames()) {
                    if (generalName.getTagNo() == 6) {
                        return DERIA5String.getInstance(generalName.toASN1Primitive(), false).getString();
                    }
                }
                continue;
            }
        }
        return null;
    }

    private static ASN1Primitive d(X509Certificate x509Certificate, String str) throws IOException {
        byte[] extensionValue = x509Certificate.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        return new ASN1InputStream(new ByteArrayInputStream(new ASN1InputStream(new ByteArrayInputStream(extensionValue)).readObject().getOctets())).readObject();
    }

    public static String e(X509Certificate x509Certificate) {
        try {
            ASN1Sequence d2 = d(x509Certificate, Extension.authorityInfoAccess.getId());
            if (d2 == null) {
                return null;
            }
            ASN1Sequence aSN1Sequence = d2;
            for (int i2 = 0; i2 < aSN1Sequence.size(); i2++) {
                ASN1Sequence objectAt = aSN1Sequence.getObjectAt(i2);
                if (objectAt.size() == 2) {
                    if ((objectAt.getObjectAt(0) instanceof ASN1ObjectIdentifier) && SecurityIDs.f27352k.equals(objectAt.getObjectAt(0).getId())) {
                        String f2 = f(objectAt.getObjectAt(1));
                        return f2 == null ? "" : f2;
                    }
                }
            }
            return null;
        } catch (IOException unused) {
        }
    }

    private static String f(ASN1Primitive aSN1Primitive) throws IOException {
        return new String(ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Primitive, false).getOctets(), "ISO-8859-1");
    }

    public static String g(X509Certificate x509Certificate) {
        byte[] extensionValue = x509Certificate.getExtensionValue(SecurityIDs.f27351j);
        if (extensionValue == null) {
            return null;
        }
        try {
            return f(ASN1Sequence.getInstance(ASN1Primitive.fromByteArray(ASN1Primitive.fromByteArray(extensionValue).getOctets())).getObjectAt(1).toASN1Primitive());
        } catch (IOException unused) {
            return null;
        }
    }
}
