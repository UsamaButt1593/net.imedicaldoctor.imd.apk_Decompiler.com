package com.itextpdf.text.pdf;

import androidx.media3.extractor.ts.PsExtractor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DEROutputStream;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.cms.EncryptedContentInfo;
import org.spongycastle.asn1.cms.EnvelopedData;
import org.spongycastle.asn1.cms.IssuerAndSerialNumber;
import org.spongycastle.asn1.cms.KeyTransRecipientInfo;
import org.spongycastle.asn1.cms.OriginatorInfo;
import org.spongycastle.asn1.cms.RecipientIdentifier;
import org.spongycastle.asn1.cms.RecipientInfo;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.TBSCertificateStructure;

public class PdfPublicKeySecurityHandler {

    /* renamed from: c  reason: collision with root package name */
    static final int f26282c = 20;

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<PdfPublicKeyRecipient> f26283a = null;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f26284b = new byte[20];

    public PdfPublicKeySecurityHandler() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(PsExtractor.x, new SecureRandom());
            System.arraycopy(instance.generateKey().getEncoded(), 0, this.f26284b, 0, 20);
        } catch (NoSuchAlgorithmException unused) {
            this.f26284b = SecureRandom.getSeed(20);
        }
        this.f26283a = new ArrayList<>();
    }

    private KeyTransRecipientInfo b(X509Certificate x509Certificate, byte[] bArr) throws GeneralSecurityException, IOException {
        TBSCertificateStructure instance = TBSCertificateStructure.getInstance(new ASN1InputStream(new ByteArrayInputStream(x509Certificate.getTBSCertificate())).readObject());
        AlgorithmIdentifier algorithm = instance.getSubjectPublicKeyInfo().getAlgorithm();
        IssuerAndSerialNumber issuerAndSerialNumber = new IssuerAndSerialNumber(instance.getIssuer(), instance.getSerialNumber().getValue());
        Cipher instance2 = Cipher.getInstance(algorithm.getAlgorithm().getId());
        try {
            instance2.init(1, x509Certificate);
        } catch (InvalidKeyException unused) {
            instance2.init(1, x509Certificate.getPublicKey());
        }
        return new KeyTransRecipientInfo(new RecipientIdentifier(issuerAndSerialNumber), algorithm, new DEROctetString(instance2.doFinal(bArr)));
    }

    private ASN1Primitive c(byte[] bArr, X509Certificate x509Certificate) throws IOException, GeneralSecurityException {
        AlgorithmParameters generateParameters = AlgorithmParameterGenerator.getInstance("1.2.840.113549.3.2").generateParameters();
        ASN1Primitive readObject = new ASN1InputStream(new ByteArrayInputStream(generateParameters.getEncoded("ASN.1"))).readObject();
        KeyGenerator instance = KeyGenerator.getInstance("1.2.840.113549.3.2");
        instance.init(128);
        SecretKey generateKey = instance.generateKey();
        Cipher instance2 = Cipher.getInstance("1.2.840.113549.3.2");
        instance2.init(1, generateKey, generateParameters);
        DEROctetString dEROctetString = new DEROctetString(instance2.doFinal(bArr));
        return new ContentInfo(PKCSObjectIdentifiers.envelopedData, new EnvelopedData((OriginatorInfo) null, new DERSet(new RecipientInfo(b(x509Certificate, generateKey.getEncoded()))), new EncryptedContentInfo(PKCSObjectIdentifiers.data, new AlgorithmIdentifier(new ASN1ObjectIdentifier("1.2.840.113549.3.2"), readObject), dEROctetString), (ASN1Set) null)).toASN1Primitive();
    }

    public void a(PdfPublicKeyRecipient pdfPublicKeyRecipient) {
        this.f26283a.add(pdfPublicKeyRecipient);
    }

    public byte[] d(int i2) throws IOException, GeneralSecurityException {
        PdfPublicKeyRecipient pdfPublicKeyRecipient = this.f26283a.get(i2);
        byte[] b2 = pdfPublicKeyRecipient.b();
        if (b2 != null) {
            return b2;
        }
        Certificate a2 = pdfPublicKeyRecipient.a();
        int c2 = ((pdfPublicKeyRecipient.c() | -3904) & -4) + 1;
        byte[] bArr = new byte[24];
        System.arraycopy(this.f26284b, 0, bArr, 0, 20);
        bArr[20] = (byte) (c2 >> 24);
        bArr[21] = (byte) (c2 >> 16);
        bArr[22] = (byte) (c2 >> 8);
        bArr[23] = (byte) c2;
        ASN1Primitive c3 = c(bArr, (X509Certificate) a2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DEROutputStream(byteArrayOutputStream).writeObject(c3);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        pdfPublicKeyRecipient.d(byteArray);
        return byteArray;
    }

    public PdfArray e() throws IOException, GeneralSecurityException {
        PdfArray pdfArray = new PdfArray();
        for (int i2 = 0; i2 < this.f26283a.size(); i2++) {
            try {
                pdfArray.a0(new PdfLiteral(StringUtils.c(d(i2))));
            } catch (IOException | GeneralSecurityException unused) {
                pdfArray = null;
            }
        }
        return pdfArray;
    }

    public int f() {
        return this.f26283a.size();
    }

    /* access modifiers changed from: protected */
    public byte[] g() {
        return (byte[]) this.f26284b.clone();
    }
}
