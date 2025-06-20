package com.itextpdf.text.pdf.security;

import com.google.common.net.HttpHeaders;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.codec.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.tsp.TSPException;
import org.spongycastle.tsp.TimeStampRequest;
import org.spongycastle.tsp.TimeStampRequestGenerator;
import org.spongycastle.tsp.TimeStampResponse;
import org.spongycastle.tsp.TimeStampToken;
import org.spongycastle.tsp.TimeStampTokenInfo;

public class TSAClientBouncyCastle implements TSAClient {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f27362g = LoggerFactory.b(TSAClientBouncyCastle.class);

    /* renamed from: h  reason: collision with root package name */
    public static final int f27363h = 4096;

    /* renamed from: i  reason: collision with root package name */
    public static final String f27364i = "SHA-256";

    /* renamed from: a  reason: collision with root package name */
    protected String f27365a;

    /* renamed from: b  reason: collision with root package name */
    protected String f27366b;

    /* renamed from: c  reason: collision with root package name */
    protected String f27367c;

    /* renamed from: d  reason: collision with root package name */
    protected TSAInfoBouncyCastle f27368d;

    /* renamed from: e  reason: collision with root package name */
    protected int f27369e;

    /* renamed from: f  reason: collision with root package name */
    protected String f27370f;

    public TSAClientBouncyCastle(String str) {
        this(str, (String) null, (String) null, 4096, "SHA-256");
    }

    public int a() {
        return this.f27369e;
    }

    public byte[] b(byte[] bArr) throws IOException, TSPException {
        TimeStampRequestGenerator timeStampRequestGenerator = new TimeStampRequestGenerator();
        timeStampRequestGenerator.setCertReq(true);
        TimeStampRequest generate = timeStampRequestGenerator.generate(new ASN1ObjectIdentifier(DigestAlgorithms.c(this.f27370f)), bArr, BigInteger.valueOf(System.currentTimeMillis()));
        TimeStampResponse timeStampResponse = new TimeStampResponse(d(generate.getEncoded()));
        timeStampResponse.validate(generate);
        PKIFailureInfo failInfo = timeStampResponse.getFailInfo();
        int intValue = failInfo == null ? 0 : failInfo.intValue();
        if (intValue == 0) {
            TimeStampToken timeStampToken = timeStampResponse.getTimeStampToken();
            if (timeStampToken != null) {
                TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
                byte[] encoded = timeStampToken.getEncoded();
                Logger logger = f27362g;
                logger.f("Timestamp generated: " + timeStampInfo.getGenTime());
                TSAInfoBouncyCastle tSAInfoBouncyCastle = this.f27368d;
                if (tSAInfoBouncyCastle != null) {
                    tSAInfoBouncyCastle.a(timeStampInfo);
                }
                this.f27369e = encoded.length + 32;
                return encoded;
            }
            throw new IOException(MessageLocalization.b("tsa.1.failed.to.return.time.stamp.token.2", this.f27365a, timeStampResponse.getStatusString()));
        }
        throw new IOException(MessageLocalization.b("invalid.tsa.1.response.code.2", this.f27365a, String.valueOf(intValue)));
    }

    public MessageDigest c() throws GeneralSecurityException {
        return new BouncyCastleDigest().a(this.f27370f);
    }

    /* access modifiers changed from: protected */
    public byte[] d(byte[] bArr) throws IOException {
        try {
            URLConnection openConnection = new URL(this.f27365a).openConnection();
            openConnection.setDoInput(true);
            openConnection.setDoOutput(true);
            openConnection.setUseCaches(false);
            openConnection.setRequestProperty(HttpHeaders.f22875c, "application/timestamp-query");
            openConnection.setRequestProperty("Content-Transfer-Encoding", FilePart.DEFAULT_TRANSFER_ENCODING);
            String str = this.f27366b;
            if (str != null && !str.equals("")) {
                String str2 = this.f27366b + ":" + this.f27367c;
                openConnection.setRequestProperty("Authorization", "Basic " + Base64.q(str2.getBytes(), 8));
            }
            OutputStream outputStream = openConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
            InputStream inputStream = openConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr2, 0, 1024);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String contentEncoding = openConnection.getContentEncoding();
            return (contentEncoding == null || !contentEncoding.equalsIgnoreCase("base64")) ? byteArray : Base64.f(new String(byteArray));
        } catch (IOException unused) {
            throw new IOException(MessageLocalization.b("failed.to.get.tsa.response.from.1", this.f27365a));
        }
    }

    public void e(TSAInfoBouncyCastle tSAInfoBouncyCastle) {
        this.f27368d = tSAInfoBouncyCastle;
    }

    public TSAClientBouncyCastle(String str, String str2, String str3) {
        this(str, str2, str3, 4096, "SHA-256");
    }

    public TSAClientBouncyCastle(String str, String str2, String str3, int i2, String str4) {
        this.f27365a = str;
        this.f27366b = str2;
        this.f27367c = str3;
        this.f27369e = i2;
        this.f27370f = str4;
    }
}
