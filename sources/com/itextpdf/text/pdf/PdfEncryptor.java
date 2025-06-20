package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.util.HashMap;
import org.spongycastle.cms.CMSException;
import org.spongycastle.cms.RecipientInformation;
import org.spongycastle.cms.jcajce.JceKeyTransEnvelopedRecipient;

public final class PdfEncryptor {
    private PdfEncryptor() {
    }

    public static void a(PdfReader pdfReader, OutputStream outputStream, int i2, String str, String str2, int i3) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.Q(i2, str, str2, i3);
        pdfStamper.j();
    }

    public static void b(PdfReader pdfReader, OutputStream outputStream, int i2, String str, String str2, int i3, HashMap<String, String> hashMap) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.Q(i2, str, str2, i3);
        pdfStamper.W(hashMap);
        pdfStamper.j();
    }

    public static void c(PdfReader pdfReader, OutputStream outputStream, boolean z, String str, String str2, int i2) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.R(z, str, str2, i2);
        pdfStamper.j();
    }

    public static void d(PdfReader pdfReader, OutputStream outputStream, boolean z, String str, String str2, int i2, HashMap<String, String> hashMap) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.R(z, str, str2, i2);
        pdfStamper.W(hashMap);
        pdfStamper.j();
    }

    public static void e(PdfReader pdfReader, OutputStream outputStream, byte[] bArr, byte[] bArr2, int i2, boolean z) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.S(bArr, bArr2, i2, z);
        pdfStamper.j();
    }

    public static void f(PdfReader pdfReader, OutputStream outputStream, byte[] bArr, byte[] bArr2, int i2, boolean z, HashMap<String, String> hashMap) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.S(bArr, bArr2, i2, z);
        pdfStamper.W(hashMap);
        pdfStamper.j();
    }

    public static byte[] g(RecipientInformation recipientInformation, PrivateKey privateKey, String str) throws CMSException {
        return recipientInformation.getContent(new JceKeyTransEnvelopedRecipient(privateKey).setProvider(str));
    }

    public static String h(int i2) {
        StringBuffer stringBuffer = new StringBuffer("Allowed:");
        if ((i2 & 2052) == 2052) {
            stringBuffer.append(" Printing");
        }
        if ((i2 & 8) == 8) {
            stringBuffer.append(" Modify contents");
        }
        if ((i2 & 16) == 16) {
            stringBuffer.append(" Copy");
        }
        if ((i2 & 32) == 32) {
            stringBuffer.append(" Modify annotations");
        }
        if ((i2 & 256) == 256) {
            stringBuffer.append(" Fill in");
        }
        if ((i2 & 512) == 512) {
            stringBuffer.append(" Screen readers");
        }
        if ((i2 & 1024) == 1024) {
            stringBuffer.append(" Assembly");
        }
        if ((i2 & 4) == 4) {
            stringBuffer.append(" Degraded printing");
        }
        return stringBuffer.toString();
    }

    public static boolean i(int i2) {
        return (i2 & 1024) == 1024;
    }

    public static boolean j(int i2) {
        return (i2 & 16) == 16;
    }

    public static boolean k(int i2) {
        return (i2 & 4) == 4;
    }

    public static boolean l(int i2) {
        return (i2 & 256) == 256;
    }

    public static boolean m(int i2) {
        return (i2 & 32) == 32;
    }

    public static boolean n(int i2) {
        return (i2 & 8) == 8;
    }

    public static boolean o(int i2) {
        return (i2 & 2052) == 2052;
    }

    public static boolean p(int i2) {
        return (i2 & 512) == 512;
    }
}
