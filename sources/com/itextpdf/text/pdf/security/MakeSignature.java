package com.itextpdf.text.pdf.security;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.io.RASInputStream;
import com.itextpdf.text.io.RandomAccessSource;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfDeveloperExtension;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignature;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfString;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MakeSignature {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f27301a = LoggerFactory.b(MakeSignature.class);

    public enum CryptoStandard {
        CMS,
        CADES
    }

    public static Collection<byte[]> a(Certificate certificate, Collection<CrlClient> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CrlClient next : collection) {
            if (next != null) {
                Logger logger = f27301a;
                logger.f("Processing " + next.getClass().getName());
                Collection<byte[]> a2 = next.a((X509Certificate) certificate, (String) null);
                if (a2 != null) {
                    arrayList.addAll(a2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static void b(PdfReader pdfReader, String str, OutputStream outputStream, ExternalSignatureContainer externalSignatureContainer) throws DocumentException, IOException, GeneralSecurityException {
        String str2 = str;
        AcroFields C = pdfReader.C();
        PdfDictionary D = C.D(str2);
        if (D == null) {
            throw new DocumentException("No field");
        } else if (C.l0(str2)) {
            PdfArray e0 = D.e0(PdfName.J4);
            long[] m0 = e0.m0();
            if (e0.size() == 4) {
                if (m0[0] == 0) {
                    RandomAccessSource a2 = pdfReader.B0().a();
                    byte[] b2 = externalSignatureContainer.b(new RASInputStream(new RandomAccessSourceFactory().f(a2, m0)));
                    long j2 = m0[2];
                    long j3 = m0[1];
                    int i2 = ((int) (j2 - j3)) - 2;
                    if ((i2 & 1) == 0) {
                        int i3 = i2 / 2;
                        if (i3 >= b2.length) {
                            StreamUtil.a(a2, 0, j3 + 1, outputStream);
                            ByteBuffer byteBuffer = new ByteBuffer(i3 * 2);
                            for (byte q : b2) {
                                byteBuffer.q(q);
                            }
                            int length = (i3 - b2.length) * 2;
                            for (int i4 = 0; i4 < length; i4++) {
                                byteBuffer.b(ByteBuffer.X2);
                            }
                            byteBuffer.H(outputStream);
                            StreamUtil.a(a2, m0[2] - 1, m0[3] + 1, outputStream);
                            return;
                        }
                        throw new DocumentException("Not enough space");
                    }
                    throw new DocumentException("Gap is not a multiple of 2");
                }
            }
            throw new DocumentException("Single exclusion space supported");
        } else {
            throw new DocumentException("Not the last signature");
        }
    }

    public static void c(PdfSignatureAppearance pdfSignatureAppearance, ExternalDigest externalDigest, ExternalSignature externalSignature, Certificate[] certificateArr, Collection<CrlClient> collection, OcspClient ocspClient, TSAClient tSAClient, int i2, CryptoStandard cryptoStandard) throws IOException, DocumentException, GeneralSecurityException {
        int i3;
        byte[] bArr;
        byte[] bArr2;
        PdfSignatureAppearance pdfSignatureAppearance2 = pdfSignatureAppearance;
        Certificate[] certificateArr2 = certificateArr;
        OcspClient ocspClient2 = ocspClient;
        CryptoStandard cryptoStandard2 = cryptoStandard;
        int i4 = 0;
        Collection<byte[]> collection2 = null;
        while (collection2 == null && i4 < certificateArr2.length) {
            collection2 = a(certificateArr2[i4], collection);
            i4++;
        }
        if (i2 == 0) {
            int i5 = 8192;
            if (collection2 != null) {
                for (byte[] length : collection2) {
                    i5 += length.length + 10;
                }
            }
            if (ocspClient2 != null) {
                i5 += 4192;
            }
            if (tSAClient != null) {
                i5 += 4192;
            }
            i3 = i5;
        } else {
            i3 = i2;
        }
        pdfSignatureAppearance2.Q(certificateArr2[0]);
        CryptoStandard cryptoStandard3 = CryptoStandard.CADES;
        if (cryptoStandard2 == cryptoStandard3) {
            pdfSignatureAppearance2.a(PdfDeveloperExtension.f26176e);
        }
        PdfSignature pdfSignature = new PdfSignature(PdfName.z3, cryptoStandard2 == cryptoStandard3 ? PdfName.v7 : PdfName.u3);
        pdfSignature.v1(pdfSignatureAppearance.y());
        pdfSignature.q1(pdfSignatureAppearance.s());
        pdfSignature.w1(pdfSignatureAppearance.D());
        pdfSignature.n1(pdfSignatureAppearance.i());
        pdfSignature.p1(new PdfDate(pdfSignatureAppearance.C()));
        pdfSignatureAppearance2.T(pdfSignature);
        HashMap hashMap = new HashMap();
        PdfName pdfName = PdfName.N5;
        hashMap.put(pdfName, new Integer((i3 * 2) + 2));
        pdfSignatureAppearance2.O(hashMap);
        String b2 = externalSignature.b();
        PdfPKCS7 pdfPKCS7 = r1;
        PdfPKCS7 pdfPKCS72 = new PdfPKCS7((PrivateKey) null, certificateArr, b2, (String) null, externalDigest, false);
        byte[] b3 = DigestAlgorithms.b(pdfSignatureAppearance.x(), externalDigest.a(b2));
        if (certificateArr2.length < 2 || ocspClient2 == null) {
            bArr = null;
            bArr2 = null;
        } else {
            bArr = null;
            bArr2 = ocspClient2.a((X509Certificate) certificateArr2[0], (X509Certificate) certificateArr2[1], (String) null);
        }
        PdfPKCS7 pdfPKCS73 = pdfPKCS7;
        pdfPKCS73.G(externalSignature.c(pdfPKCS73.d(b3, bArr2, collection2, cryptoStandard2)), bArr, externalSignature.a());
        byte[] n2 = pdfPKCS73.n(b3, tSAClient, bArr2, collection2, cryptoStandard);
        if (i3 >= n2.length) {
            byte[] bArr3 = new byte[i3];
            System.arraycopy(n2, 0, bArr3, 0, n2.length);
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.V0(pdfName, new PdfString(bArr3).i0(true));
            pdfSignatureAppearance2.d(pdfDictionary);
            return;
        }
        throw new IOException("Not enough space");
    }

    public static void d(PdfSignatureAppearance pdfSignatureAppearance, ExternalSignatureContainer externalSignatureContainer, int i2) throws GeneralSecurityException, IOException, DocumentException {
        PdfSignature pdfSignature = new PdfSignature((PdfName) null, (PdfName) null);
        pdfSignature.v1(pdfSignatureAppearance.y());
        pdfSignature.q1(pdfSignatureAppearance.s());
        pdfSignature.w1(pdfSignatureAppearance.D());
        pdfSignature.n1(pdfSignatureAppearance.i());
        pdfSignature.p1(new PdfDate(pdfSignatureAppearance.C()));
        externalSignatureContainer.a(pdfSignature);
        pdfSignatureAppearance.T(pdfSignature);
        HashMap hashMap = new HashMap();
        PdfName pdfName = PdfName.N5;
        hashMap.put(pdfName, new Integer((i2 * 2) + 2));
        pdfSignatureAppearance.O(hashMap);
        byte[] b2 = externalSignatureContainer.b(pdfSignatureAppearance.x());
        if (i2 >= b2.length) {
            byte[] bArr = new byte[i2];
            System.arraycopy(b2, 0, bArr, 0, b2.length);
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.V0(pdfName, new PdfString(bArr).i0(true));
            pdfSignatureAppearance.d(pdfDictionary);
            return;
        }
        throw new IOException("Not enough space");
    }
}
