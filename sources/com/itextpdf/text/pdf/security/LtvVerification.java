package com.itextpdf.text.pdf.security;

import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDeveloperExtension;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfStream;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.ocsp.OCSPObjectIdentifiers;

public class LtvVerification {

    /* renamed from: a  reason: collision with root package name */
    private Logger f27281a = LoggerFactory.b(LtvVerification.class);

    /* renamed from: b  reason: collision with root package name */
    private PdfStamper f27282b;

    /* renamed from: c  reason: collision with root package name */
    private PdfWriter f27283c;

    /* renamed from: d  reason: collision with root package name */
    private PdfReader f27284d;

    /* renamed from: e  reason: collision with root package name */
    private AcroFields f27285e;

    /* renamed from: f  reason: collision with root package name */
    private Map<PdfName, ValidationData> f27286f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private boolean f27287g = false;

    public enum CertificateInclusion {
        YES,
        NO
    }

    public enum CertificateOption {
        SIGNING_CERTIFICATE,
        WHOLE_CHAIN
    }

    public enum Level {
        OCSP,
        CRL,
        OCSP_CRL,
        OCSP_OPTIONAL_CRL
    }

    private static class ValidationData {

        /* renamed from: a  reason: collision with root package name */
        public List<byte[]> f27288a;

        /* renamed from: b  reason: collision with root package name */
        public List<byte[]> f27289b;

        /* renamed from: c  reason: collision with root package name */
        public List<byte[]> f27290c;

        private ValidationData() {
            this.f27288a = new ArrayList();
            this.f27289b = new ArrayList();
            this.f27290c = new ArrayList();
        }
    }

    public LtvVerification(PdfStamper pdfStamper) {
        this.f27282b = pdfStamper;
        this.f27283c = pdfStamper.C();
        this.f27284d = pdfStamper.z();
        this.f27285e = pdfStamper.s();
    }

    private static byte[] c(byte[] bArr) throws IOException {
        DEROctetString dEROctetString = new DEROctetString(bArr);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(OCSPObjectIdentifiers.id_pkix_ocsp_basic);
        aSN1EncodableVector.add(dEROctetString);
        ASN1Enumerated aSN1Enumerated = new ASN1Enumerated(0);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(aSN1Enumerated);
        aSN1EncodableVector2.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector)));
        return new DERSequence(aSN1EncodableVector2).getEncoded();
    }

    private void d() throws IOException {
        j(new PdfDictionary(), new PdfDictionary(), new PdfArray(), new PdfArray(), new PdfArray());
    }

    private static void e(PdfArray pdfArray, PdfArray pdfArray2) {
        if (pdfArray != null && pdfArray2 != null) {
            Iterator<PdfObject> it2 = pdfArray2.iterator();
            while (it2.hasNext()) {
                PdfObject next = it2.next();
                if (next.C()) {
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) next;
                    int i2 = 0;
                    while (i2 < pdfArray.size()) {
                        PdfObject T0 = pdfArray.T0(i2);
                        if (T0.C() && pRIndirectReference.d() == ((PRIndirectReference) T0).d()) {
                            pdfArray.U0(i2);
                            i2--;
                        }
                        i2++;
                    }
                }
            }
        }
    }

    private X509Certificate f(X509Certificate x509Certificate, Certificate[] certificateArr) {
        for (X509Certificate x509Certificate2 : certificateArr) {
            if (x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return null;
    }

    private PdfName g(String str) throws NoSuchAlgorithmException, IOException {
        PdfDictionary D = this.f27285e.D(str);
        byte[] d0 = D.A0(PdfName.N5).d0();
        if (PdfName.w7.equals(PdfReader.t0(D.d0(PdfName.zf)))) {
            d0 = new ASN1InputStream(new ByteArrayInputStream(d0)).readObject().getEncoded();
        }
        return new PdfName(Utilities.d(h(d0)));
    }

    private static byte[] h(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(SecurityConstants.o).digest(bArr);
    }

    private void j(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfArray pdfArray, PdfArray pdfArray2, PdfArray pdfArray3) throws IOException {
        PdfDictionary pdfDictionary3 = pdfDictionary;
        PdfDictionary pdfDictionary4 = pdfDictionary2;
        PdfArray pdfArray4 = pdfArray;
        PdfArray pdfArray5 = pdfArray2;
        PdfArray pdfArray6 = pdfArray3;
        this.f27283c.w(PdfDeveloperExtension.f26177f);
        PdfDictionary F = this.f27284d.F();
        this.f27282b.K(F);
        Iterator<PdfName> it2 = this.f27286f.keySet().iterator();
        while (it2.hasNext()) {
            PdfName next = it2.next();
            PdfArray pdfArray7 = new PdfArray();
            PdfArray pdfArray8 = new PdfArray();
            PdfArray pdfArray9 = new PdfArray();
            PdfDictionary pdfDictionary5 = new PdfDictionary();
            for (byte[] pdfStream : this.f27286f.get(next).f27288a) {
                PdfStream pdfStream2 = new PdfStream(pdfStream);
                pdfStream2.f1();
                Iterator<PdfName> it3 = it2;
                PdfIndirectReference a2 = this.f27283c.A0(pdfStream2, false).a();
                pdfArray8.a0(a2);
                pdfArray5.a0(a2);
                it2 = it3;
            }
            Iterator<PdfName> it4 = it2;
            for (byte[] pdfStream3 : this.f27286f.get(next).f27289b) {
                PdfStream pdfStream4 = new PdfStream(pdfStream3);
                pdfStream4.f1();
                PdfIndirectReference a3 = this.f27283c.A0(pdfStream4, false).a();
                pdfArray7.a0(a3);
                pdfArray4.a0(a3);
            }
            for (byte[] pdfStream5 : this.f27286f.get(next).f27290c) {
                PdfStream pdfStream6 = new PdfStream(pdfStream5);
                pdfStream6.f1();
                PdfIndirectReference a4 = this.f27283c.A0(pdfStream6, false).a();
                pdfArray9.a0(a4);
                pdfArray6.a0(a4);
            }
            if (pdfArray7.size() > 0) {
                pdfDictionary5.V0(PdfName.Ub, this.f27283c.A0(pdfArray7, false).a());
            }
            if (pdfArray8.size() > 0) {
                pdfDictionary5.V0(PdfName.X5, this.f27283c.A0(pdfArray8, false).a());
            }
            if (pdfArray9.size() > 0) {
                pdfDictionary5.V0(PdfName.a5, this.f27283c.A0(pdfArray9, false).a());
            }
            pdfDictionary4.V0(next, this.f27283c.A0(pdfDictionary5, false).a());
            it2 = it4;
        }
        pdfDictionary3.V0(PdfName.Ch, this.f27283c.A0(pdfDictionary4, false).a());
        if (pdfArray.size() > 0) {
            pdfDictionary3.V0(PdfName.Vb, this.f27283c.A0(pdfArray4, false).a());
        }
        if (pdfArray2.size() > 0) {
            pdfDictionary3.V0(PdfName.Y5, this.f27283c.A0(pdfArray5, false).a());
        }
        if (pdfArray3.size() > 0) {
            pdfDictionary3.V0(PdfName.b5, this.f27283c.A0(pdfArray6, false).a());
        }
        F.V0(PdfName.V6, this.f27283c.A0(pdfDictionary3, false).a());
    }

    private void k() throws IOException {
        PdfDictionary j0;
        PdfDictionary F = this.f27284d.F();
        this.f27282b.K(F);
        PdfDictionary j02 = F.j0(PdfName.V6);
        PdfName pdfName = PdfName.Vb;
        PdfArray e0 = j02.e0(pdfName);
        PdfName pdfName2 = PdfName.Y5;
        PdfArray e02 = j02.e0(pdfName2);
        PdfName pdfName3 = PdfName.b5;
        PdfArray e03 = j02.e0(pdfName3);
        j02.a1(pdfName);
        j02.a1(pdfName2);
        j02.a1(pdfName3);
        PdfDictionary j03 = j02.j0(PdfName.Ch);
        if (j03 != null) {
            for (PdfName next : j03.G0()) {
                if (this.f27286f.containsKey(next) && (j0 = j03.j0(next)) != null) {
                    e(e0, j0.e0(PdfName.Ub));
                    e(e02, j0.e0(PdfName.X5));
                    e(e03, j0.e0(PdfName.a5));
                }
            }
        }
        if (e0 == null) {
            e0 = new PdfArray();
        }
        j(j02, j03, e0, e02 == null ? new PdfArray() : e02, e03 == null ? new PdfArray() : e03);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r18, com.itextpdf.text.pdf.security.OcspClient r19, com.itextpdf.text.pdf.security.CrlClient r20, com.itextpdf.text.pdf.security.LtvVerification.CertificateOption r21, com.itextpdf.text.pdf.security.LtvVerification.Level r22, com.itextpdf.text.pdf.security.LtvVerification.CertificateInclusion r23) throws java.io.IOException, java.security.GeneralSecurityException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r22
            boolean r5 = r0.f27287g
            r6 = 0
            if (r5 != 0) goto L_0x010e
            com.itextpdf.text.pdf.AcroFields r5 = r0.f27285e
            com.itextpdf.text.pdf.security.PdfPKCS7 r5 = r5.o0(r1)
            com.itextpdf.text.log.Logger r7 = r0.f27281a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Adding verification for "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r7.f(r8)
            java.security.cert.Certificate[] r7 = r5.g()
            java.security.cert.X509Certificate r5 = r5.x()
            com.itextpdf.text.pdf.security.LtvVerification$ValidationData r8 = new com.itextpdf.text.pdf.security.LtvVerification$ValidationData
            r9 = 0
            r8.<init>()
            r10 = 0
        L_0x003a:
            int r11 = r7.length
            if (r10 >= r11) goto L_0x00f2
            r11 = r7[r10]
            java.security.cert.X509Certificate r11 = (java.security.cert.X509Certificate) r11
            com.itextpdf.text.log.Logger r12 = r0.f27281a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Certificate: "
            r13.append(r14)
            java.security.Principal r14 = r11.getSubjectDN()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.f(r13)
            com.itextpdf.text.pdf.security.LtvVerification$CertificateOption r12 = com.itextpdf.text.pdf.security.LtvVerification.CertificateOption.SIGNING_CERTIFICATE
            r13 = r21
            if (r13 != r12) goto L_0x006b
            boolean r12 = r11.equals(r5)
            if (r12 != 0) goto L_0x006b
            r12 = r23
            goto L_0x00ed
        L_0x006b:
            if (r2 == 0) goto L_0x008c
            com.itextpdf.text.pdf.security.LtvVerification$Level r12 = com.itextpdf.text.pdf.security.LtvVerification.Level.CRL
            if (r4 == r12) goto L_0x008c
            java.security.cert.X509Certificate r12 = r0.f(r11, r7)
            byte[] r12 = r2.a(r11, r12, r9)
            if (r12 == 0) goto L_0x008d
            java.util.List<byte[]> r14 = r8.f27289b
            byte[] r15 = c(r12)
            r14.add(r15)
            com.itextpdf.text.log.Logger r14 = r0.f27281a
            java.lang.String r15 = "OCSP added"
            r14.f(r15)
            goto L_0x008d
        L_0x008c:
            r12 = r9
        L_0x008d:
            if (r3 == 0) goto L_0x00de
            com.itextpdf.text.pdf.security.LtvVerification$Level r14 = com.itextpdf.text.pdf.security.LtvVerification.Level.CRL
            if (r4 == r14) goto L_0x009d
            com.itextpdf.text.pdf.security.LtvVerification$Level r14 = com.itextpdf.text.pdf.security.LtvVerification.Level.OCSP_CRL
            if (r4 == r14) goto L_0x009d
            com.itextpdf.text.pdf.security.LtvVerification$Level r14 = com.itextpdf.text.pdf.security.LtvVerification.Level.OCSP_OPTIONAL_CRL
            if (r4 != r14) goto L_0x00de
            if (r12 != 0) goto L_0x00de
        L_0x009d:
            java.util.Collection r12 = r3.a(r11, r9)
            if (r12 == 0) goto L_0x00de
            java.util.Iterator r12 = r12.iterator()
        L_0x00a7:
            boolean r14 = r12.hasNext()
            if (r14 == 0) goto L_0x00de
            java.lang.Object r14 = r12.next()
            byte[] r14 = (byte[]) r14
            java.util.List<byte[]> r15 = r8.f27288a
            java.util.Iterator r15 = r15.iterator()
        L_0x00b9:
            boolean r16 = r15.hasNext()
            if (r16 == 0) goto L_0x00d0
            java.lang.Object r16 = r15.next()
            r9 = r16
            byte[] r9 = (byte[]) r9
            boolean r9 = java.util.Arrays.equals(r9, r14)
            if (r9 == 0) goto L_0x00ce
            goto L_0x00dc
        L_0x00ce:
            r9 = 0
            goto L_0x00b9
        L_0x00d0:
            java.util.List<byte[]> r9 = r8.f27288a
            r9.add(r14)
            com.itextpdf.text.log.Logger r9 = r0.f27281a
            java.lang.String r14 = "CRL added"
            r9.f(r14)
        L_0x00dc:
            r9 = 0
            goto L_0x00a7
        L_0x00de:
            com.itextpdf.text.pdf.security.LtvVerification$CertificateInclusion r9 = com.itextpdf.text.pdf.security.LtvVerification.CertificateInclusion.YES
            r12 = r23
            if (r12 != r9) goto L_0x00ed
            java.util.List<byte[]> r9 = r8.f27290c
            byte[] r11 = r11.getEncoded()
            r9.add(r11)
        L_0x00ed:
            int r10 = r10 + 1
            r9 = 0
            goto L_0x003a
        L_0x00f2:
            java.util.List<byte[]> r2 = r8.f27288a
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0103
            java.util.List<byte[]> r2 = r8.f27289b
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0103
            return r6
        L_0x0103:
            java.util.Map<com.itextpdf.text.pdf.PdfName, com.itextpdf.text.pdf.security.LtvVerification$ValidationData> r2 = r0.f27286f
            com.itextpdf.text.pdf.PdfName r1 = r17.g(r18)
            r2.put(r1, r8)
            r1 = 1
            return r1
        L_0x010e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "verification.already.output"
            java.lang.Object[] r3 = new java.lang.Object[r6]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.security.LtvVerification.a(java.lang.String, com.itextpdf.text.pdf.security.OcspClient, com.itextpdf.text.pdf.security.CrlClient, com.itextpdf.text.pdf.security.LtvVerification$CertificateOption, com.itextpdf.text.pdf.security.LtvVerification$Level, com.itextpdf.text.pdf.security.LtvVerification$CertificateInclusion):boolean");
    }

    public boolean b(String str, Collection<byte[]> collection, Collection<byte[]> collection2, Collection<byte[]> collection3) throws IOException, GeneralSecurityException {
        if (!this.f27287g) {
            ValidationData validationData = new ValidationData();
            if (collection != null) {
                for (byte[] c2 : collection) {
                    validationData.f27289b.add(c(c2));
                }
            }
            if (collection2 != null) {
                for (byte[] add : collection2) {
                    validationData.f27288a.add(add);
                }
            }
            if (collection3 != null) {
                for (byte[] add2 : collection3) {
                    validationData.f27290c.add(add2);
                }
            }
            this.f27286f.put(g(str), validationData);
            return true;
        }
        throw new IllegalStateException(MessageLocalization.b("verification.already.output", new Object[0]));
    }

    public void i() throws IOException {
        if (!this.f27287g && !this.f27286f.isEmpty()) {
            this.f27287g = true;
            if (this.f27284d.F().d0(PdfName.V6) == null) {
                d();
            } else {
                k();
            }
        }
    }
}
