package com.itextpdf.text.pdf.security;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CrlClientOnline implements CrlClient {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f27269b = LoggerFactory.b(CrlClientOnline.class);

    /* renamed from: a  reason: collision with root package name */
    protected List<URL> f27270a;

    public CrlClientOnline() {
        this.f27270a = new ArrayList();
    }

    public Collection<byte[]> a(X509Certificate x509Certificate, String str) {
        if (x509Certificate == null) {
            return null;
        }
        ArrayList<URL> arrayList = new ArrayList<>(this.f27270a);
        if (arrayList.size() == 0) {
            Logger logger = f27269b;
            logger.f("Looking for CRL for certificate " + x509Certificate.getSubjectDN());
            if (str == null) {
                try {
                    str = CertificateUtil.c(x509Certificate);
                } catch (Exception e2) {
                    Logger logger2 = f27269b;
                    logger2.f("Skipped CRL url: " + e2.getMessage());
                }
            }
            if (str != null) {
                arrayList.add(new URL(str));
                logger.f("Found CRL url: " + str);
            } else {
                throw new NullPointerException();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (URL url : arrayList) {
            try {
                Logger logger3 = f27269b;
                logger3.f("Checking CRL: " + url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection.getResponseCode() / 100 == 2) {
                    InputStream inputStream = (InputStream) httpURLConnection.getContent();
                    byte[] bArr = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = inputStream.read(bArr, 0, 1024);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    inputStream.close();
                    arrayList2.add(byteArrayOutputStream.toByteArray());
                    Logger logger4 = f27269b;
                    logger4.f("Added CRL found at: " + url);
                } else {
                    throw new IOException(MessageLocalization.a("invalid.http.response.1", httpURLConnection.getResponseCode()));
                }
            } catch (Exception e3) {
                Logger logger5 = f27269b;
                logger5.f("Skipped CRL: " + e3.getMessage() + " for " + url);
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: protected */
    public void b(String str) {
        try {
            c(new URL(str));
        } catch (MalformedURLException unused) {
            Logger logger = f27269b;
            logger.f("Skipped CRL url (malformed): " + str);
        }
    }

    /* access modifiers changed from: protected */
    public void c(URL url) {
        Logger logger;
        StringBuilder sb;
        String str;
        if (this.f27270a.contains(url)) {
            logger = f27269b;
            sb = new StringBuilder();
            str = "Skipped CRL url (duplicate): ";
        } else {
            this.f27270a.add(url);
            logger = f27269b;
            sb = new StringBuilder();
            str = "Added CRL url: ";
        }
        sb.append(str);
        sb.append(url);
        logger.f(sb.toString());
    }

    public CrlClientOnline(String... strArr) {
        this.f27270a = new ArrayList();
        for (String b2 : strArr) {
            b(b2);
        }
    }

    public CrlClientOnline(URL... urlArr) {
        ArrayList<URL> arrayList = new ArrayList<>();
        this.f27270a = arrayList;
        for (URL c2 : arrayList) {
            c(c2);
        }
    }

    public CrlClientOnline(Certificate[] certificateArr) {
        this.f27270a = new ArrayList();
        for (X509Certificate x509Certificate : certificateArr) {
            f27269b.f("Checking certificate: " + x509Certificate.getSubjectDN());
            try {
                b(CertificateUtil.c(x509Certificate));
            } catch (CertificateParsingException unused) {
                f27269b.f("Skipped CRL url (certificate could not be parsed)");
            }
        }
    }
}
