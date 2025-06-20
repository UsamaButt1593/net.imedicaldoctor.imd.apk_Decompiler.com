package com.itextpdf.text.pdf.security;

import com.google.common.net.HttpHeaders;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfEncryption;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.cert.jcajce.JcaX509CertificateHolder;
import org.spongycastle.cert.ocsp.BasicOCSPResp;
import org.spongycastle.cert.ocsp.CertificateID;
import org.spongycastle.cert.ocsp.CertificateStatus;
import org.spongycastle.cert.ocsp.OCSPException;
import org.spongycastle.cert.ocsp.OCSPReq;
import org.spongycastle.cert.ocsp.OCSPReqBuilder;
import org.spongycastle.cert.ocsp.OCSPResp;
import org.spongycastle.cert.ocsp.SingleResp;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.ocsp.RevokedStatus;
import org.spongycastle.operator.OperatorException;
import org.spongycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

public class OcspClientBouncyCastle implements OcspClient {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f27305b = LoggerFactory.b(OcspClientBouncyCastle.class);

    /* renamed from: a  reason: collision with root package name */
    private final OCSPVerifier f27306a;

    @Deprecated
    public OcspClientBouncyCastle() {
        this.f27306a = null;
    }

    private static OCSPReq b(X509Certificate x509Certificate, BigInteger bigInteger) throws OCSPException, IOException, OperatorException, CertificateEncodingException {
        Security.addProvider(new BouncyCastleProvider());
        CertificateID certificateID = new CertificateID(new JcaDigestCalculatorProviderBuilder().build().get(CertificateID.HASH_SHA1), new JcaX509CertificateHolder(x509Certificate), bigInteger);
        OCSPReqBuilder oCSPReqBuilder = new OCSPReqBuilder();
        oCSPReqBuilder.addRequest(certificateID);
        oCSPReqBuilder.setRequestExtensions(new Extensions(new Extension[]{new Extension(OCSPObjectIdentifiers.id_pkix_ocsp_nonce, false, new DEROctetString(new DEROctetString(PdfEncryption.f()).getEncoded()))}));
        return oCSPReqBuilder.build();
    }

    private OCSPResp d(X509Certificate x509Certificate, X509Certificate x509Certificate2, String str) throws GeneralSecurityException, OCSPException, IOException, OperatorException {
        if (x509Certificate == null || x509Certificate2 == null) {
            return null;
        }
        if (str == null) {
            str = CertificateUtil.e(x509Certificate);
        }
        if (str == null) {
            return null;
        }
        Logger logger = f27305b;
        logger.f("Getting OCSP from " + str);
        byte[] encoded = b(x509Certificate2, x509Certificate.getSerialNumber()).getEncoded();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestProperty(HttpHeaders.f22875c, "application/ocsp-request");
        httpURLConnection.setRequestProperty(HttpHeaders.f22880h, "application/ocsp-response");
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
        dataOutputStream.write(encoded);
        dataOutputStream.flush();
        dataOutputStream.close();
        if (httpURLConnection.getResponseCode() / 100 == 2) {
            return new OCSPResp(StreamUtil.d((InputStream) httpURLConnection.getContent()));
        }
        throw new IOException(MessageLocalization.a("invalid.http.response.1", httpURLConnection.getResponseCode()));
    }

    public byte[] a(X509Certificate x509Certificate, X509Certificate x509Certificate2, String str) {
        try {
            BasicOCSPResp c2 = c(x509Certificate, x509Certificate2, str);
            if (c2 == null) {
                return null;
            }
            SingleResp[] responses = c2.getResponses();
            if (responses.length != 1) {
                return null;
            }
            CertificateStatus certStatus = responses[0].getCertStatus();
            if (certStatus == CertificateStatus.GOOD) {
                return c2.getEncoded();
            }
            if (certStatus instanceof RevokedStatus) {
                throw new IOException(MessageLocalization.b("ocsp.status.is.revoked", new Object[0]));
            }
            throw new IOException(MessageLocalization.b("ocsp.status.is.unknown", new Object[0]));
        } catch (Exception e2) {
            Logger logger = f27305b;
            if (!logger.b(Level.ERROR)) {
                return null;
            }
            logger.c(e2.getMessage());
            return null;
        }
    }

    public BasicOCSPResp c(X509Certificate x509Certificate, X509Certificate x509Certificate2, String str) {
        try {
            OCSPResp d2 = d(x509Certificate, x509Certificate2, str);
            if (d2 == null || d2.getStatus() != 0) {
                return null;
            }
            BasicOCSPResp basicOCSPResp = (BasicOCSPResp) d2.getResponseObject();
            OCSPVerifier oCSPVerifier = this.f27306a;
            if (oCSPVerifier != null) {
                oCSPVerifier.f(basicOCSPResp, x509Certificate2);
            }
            return basicOCSPResp;
        } catch (Exception e2) {
            Logger logger = f27305b;
            if (logger.b(Level.ERROR)) {
                logger.c(e2.getMessage());
            }
            return null;
        }
    }

    public OcspClientBouncyCastle(OCSPVerifier oCSPVerifier) {
        this.f27306a = oCSPVerifier;
    }
}
