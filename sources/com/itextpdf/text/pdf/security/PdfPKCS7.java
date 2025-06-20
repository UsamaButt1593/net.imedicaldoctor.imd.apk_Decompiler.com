package com.itextpdf.text.pdf.security;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.security.MakeSignature;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRL;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.ocsp.BasicOCSPResponse;
import org.spongycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.spongycastle.asn1.tsp.MessageImprint;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.cert.jcajce.JcaX509CertificateHolder;
import org.spongycastle.cert.ocsp.BasicOCSPResp;
import org.spongycastle.cert.ocsp.CertificateID;
import org.spongycastle.jce.provider.X509CertParser;
import org.spongycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.spongycastle.tsp.TimeStampToken;
import org.spongycastle.tsp.TimeStampTokenInfo;

public class PdfPKCS7 {
    private X509Certificate A;
    private Collection<CRL> B;
    private BasicOCSPResp C;
    private boolean D;
    private boolean E;
    private TimeStampToken F;

    /* renamed from: a  reason: collision with root package name */
    private String f27307a;

    /* renamed from: b  reason: collision with root package name */
    private String f27308b;

    /* renamed from: c  reason: collision with root package name */
    private String f27309c;

    /* renamed from: d  reason: collision with root package name */
    private String f27310d;

    /* renamed from: e  reason: collision with root package name */
    private Calendar f27311e;

    /* renamed from: f  reason: collision with root package name */
    private int f27312f = 1;

    /* renamed from: g  reason: collision with root package name */
    private int f27313g = 1;

    /* renamed from: h  reason: collision with root package name */
    private String f27314h;

    /* renamed from: i  reason: collision with root package name */
    private MessageDigest f27315i;

    /* renamed from: j  reason: collision with root package name */
    private Set<String> f27316j;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f27317k;

    /* renamed from: l  reason: collision with root package name */
    private PdfName f27318l;

    /* renamed from: m  reason: collision with root package name */
    private String f27319m;

    /* renamed from: n  reason: collision with root package name */
    private ExternalDigest f27320n;
    private byte[] o;
    private byte[] p;
    private Signature q;
    private byte[] r;
    private byte[] s;
    private byte[] t;
    private byte[] u;
    private MessageDigest v;
    private boolean w;
    private boolean x;
    private Collection<Certificate> y;
    private Collection<Certificate> z;

    public PdfPKCS7(PrivateKey privateKey, Certificate[] certificateArr, String str, String str2, ExternalDigest externalDigest, boolean z2) throws InvalidKeyException, NoSuchProviderException, NoSuchAlgorithmException {
        String str3;
        this.f27307a = str2;
        this.f27320n = externalDigest;
        String c2 = DigestAlgorithms.c(str);
        this.f27314h = c2;
        if (c2 != null) {
            this.A = certificateArr[0];
            this.y = new ArrayList();
            for (Certificate add : certificateArr) {
                this.y.add(add);
            }
            HashSet hashSet = new HashSet();
            this.f27316j = hashSet;
            hashSet.add(this.f27314h);
            if (privateKey != null) {
                String algorithm = privateKey.getAlgorithm();
                this.f27319m = algorithm;
                if (algorithm.equals(SecurityConstants.f27341n)) {
                    str3 = SecurityIDs.f27344c;
                } else if (this.f27319m.equals(SecurityConstants.f27340m)) {
                    str3 = SecurityIDs.f27345d;
                } else {
                    throw new NoSuchAlgorithmException(MessageLocalization.b("unknown.key.algorithm.1", this.f27319m));
                }
                this.f27319m = str3;
            }
            if (z2) {
                this.s = new byte[0];
                this.f27315i = DigestAlgorithms.e(q(), str2);
            }
            if (privateKey != null) {
                this.q = C(privateKey);
                return;
            }
            return;
        }
        throw new NoSuchAlgorithmException(MessageLocalization.b("unknown.hash.algorithm.1", str));
    }

    private Signature C(PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        Signature instance = this.f27307a == null ? Signature.getInstance(h()) : Signature.getInstance(h(), this.f27307a);
        instance.initSign(privateKey);
        return instance;
    }

    private Signature D(PublicKey publicKey) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        String h2 = h();
        if (PdfName.y3.equals(p())) {
            h2 = "SHA1withRSA";
        }
        String str = this.f27307a;
        Signature instance = str == null ? Signature.getInstance(h2) : Signature.getInstance(h2, str);
        instance.initVerify(publicKey);
        return instance;
    }

    private void L() {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.A);
        ArrayList arrayList2 = new ArrayList(this.y);
        int i2 = 0;
        while (i2 < arrayList2.size()) {
            if (this.A.equals(arrayList2.get(i2))) {
                arrayList2.remove(i2);
                i2--;
            }
            i2++;
        }
        while (true) {
            boolean z3 = true;
            while (true) {
                if (z3) {
                    X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
                    int i3 = 0;
                    z2 = false;
                    while (true) {
                        if (i3 >= arrayList2.size()) {
                            break;
                        }
                        X509Certificate x509Certificate2 = (X509Certificate) arrayList2.get(i3);
                        try {
                            if (this.f27307a == null) {
                                x509Certificate.verify(x509Certificate2.getPublicKey());
                            } else {
                                x509Certificate.verify(x509Certificate2.getPublicKey(), this.f27307a);
                            }
                            try {
                                arrayList.add(arrayList2.get(i3));
                                arrayList2.remove(i3);
                            } catch (Exception unused) {
                                z2 = true;
                            }
                        } catch (Exception unused2) {
                        }
                        i3++;
                    }
                } else {
                    this.z = arrayList;
                    return;
                }
                z3 = z2;
            }
        }
    }

    private boolean O(byte[] bArr) throws GeneralSecurityException {
        Signature D2 = D(this.A.getPublicKey());
        D2.update(bArr);
        return D2.verify(this.r);
    }

    private ASN1EncodableVector a(byte[] bArr) throws IOException {
        if (bArr == null) {
            return null;
        }
        ASN1InputStream aSN1InputStream = new ASN1InputStream(new ByteArrayInputStream(bArr));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.2.14"));
        aSN1EncodableVector2.add(new DERSet(aSN1InputStream.readObject()));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        return aSN1EncodableVector;
    }

    private void b(ASN1Sequence aSN1Sequence) {
        try {
            this.B = new ArrayList();
            for (int i2 = 0; i2 < aSN1Sequence.size(); i2++) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(aSN1Sequence.getObjectAt(i2).toASN1Primitive().getEncoded("DER"));
                this.B.add((X509CRL) CertificateFactory.getInstance("X.509").generateCRL(byteArrayInputStream));
            }
        } catch (Exception unused) {
        }
    }

    private void c(ASN1Sequence aSN1Sequence) throws IOException {
        boolean z2;
        ASN1Primitive objectAt;
        this.C = null;
        do {
            z2 = false;
            if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).getId().equals(OCSPObjectIdentifiers.id_pkix_ocsp_basic.getId())) {
                int i2 = 0;
                while (i2 < aSN1Sequence.size()) {
                    if (aSN1Sequence.getObjectAt(i2) instanceof ASN1Sequence) {
                        objectAt = aSN1Sequence.getObjectAt(0);
                    } else if (aSN1Sequence.getObjectAt(i2) instanceof ASN1TaggedObject) {
                        ASN1TaggedObject objectAt2 = aSN1Sequence.getObjectAt(i2);
                        if (objectAt2.getObject() instanceof ASN1Sequence) {
                            objectAt = objectAt2.getObject();
                        } else {
                            return;
                        }
                    } else {
                        i2++;
                    }
                    aSN1Sequence = (ASN1Sequence) objectAt;
                    continue;
                }
                z2 = true;
                continue;
            } else {
                this.C = new BasicOCSPResp(BasicOCSPResponse.getInstance(new ASN1InputStream(aSN1Sequence.getObjectAt(1).getOctets()).readObject()));
                return;
            }
        } while (!z2);
    }

    private DERSet e(byte[] bArr, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        boolean z2;
        try {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(new ASN1ObjectIdentifier(SecurityIDs.f27347f));
            aSN1EncodableVector2.add(new DERSet(new ASN1ObjectIdentifier(SecurityIDs.f27342a)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(new ASN1ObjectIdentifier(SecurityIDs.f27348g));
            aSN1EncodableVector3.add(new DERSet(new DEROctetString(bArr)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
            if (collection != null) {
                Iterator<byte[]> it2 = collection.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next() != null) {
                            z2 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z2 = false;
            if (bArr2 != null || z2) {
                ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                aSN1EncodableVector4.add(new ASN1ObjectIdentifier(SecurityIDs.f27350i));
                ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                if (z2) {
                    ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
                    for (byte[] next : collection) {
                        if (next != null) {
                            aSN1EncodableVector6.add(new ASN1InputStream(new ByteArrayInputStream(next)).readObject());
                        }
                    }
                    aSN1EncodableVector5.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector6)));
                }
                if (bArr2 != null) {
                    DEROctetString dEROctetString = new DEROctetString(bArr2);
                    ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                    aSN1EncodableVector8.add(OCSPObjectIdentifiers.id_pkix_ocsp_basic);
                    aSN1EncodableVector8.add(dEROctetString);
                    ASN1Enumerated aSN1Enumerated = new ASN1Enumerated(0);
                    ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                    aSN1EncodableVector9.add(aSN1Enumerated);
                    aSN1EncodableVector9.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector8)));
                    aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector9));
                    aSN1EncodableVector5.add(new DERTaggedObject(true, 1, new DERSequence(aSN1EncodableVector7)));
                }
                aSN1EncodableVector4.add(new DERSet(new DERSequence(aSN1EncodableVector5)));
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
            }
            if (cryptoStandard == MakeSignature.CryptoStandard.CADES) {
                ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                aSN1EncodableVector10.add(new ASN1ObjectIdentifier(SecurityIDs.f27354m));
                ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
                if (!DigestAlgorithms.c("SHA-256").equals(this.f27314h)) {
                    aSN1EncodableVector11.add(new AlgorithmIdentifier(new ASN1ObjectIdentifier(this.f27314h)));
                }
                aSN1EncodableVector11.add(new DEROctetString(this.f27320n.a(q()).digest(this.A.getEncoded())));
                aSN1EncodableVector10.add(new DERSet(new DERSequence(new DERSequence(new DERSequence(aSN1EncodableVector11)))));
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector10));
            }
            return new DERSet(aSN1EncodableVector);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public TimeStampToken A() {
        return this.F;
    }

    public int B() {
        return this.f27312f;
    }

    public boolean E() {
        if (this.C == null || this.z.size() < 2) {
            return false;
        }
        try {
            CertificateID certID = this.C.getResponses()[0].getCertID();
            return new CertificateID(new JcaDigestCalculatorProviderBuilder().build().get(new AlgorithmIdentifier(certID.getHashAlgOID(), DERNull.INSTANCE)), new JcaX509CertificateHolder(((X509Certificate[]) u())[1]), x().getSerialNumber()).equals(certID);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean F() {
        return this.D;
    }

    public void G(byte[] bArr, byte[] bArr2, String str) {
        String str2;
        this.o = bArr;
        this.p = bArr2;
        if (str != null) {
            if (str.equals(SecurityConstants.f27341n)) {
                str2 = SecurityIDs.f27344c;
            } else if (str.equals(SecurityConstants.f27340m)) {
                str2 = SecurityIDs.f27345d;
            } else if (str.equals("ECDSA")) {
                str2 = SecurityIDs.f27346e;
            } else {
                throw new ExceptionConverter(new NoSuchAlgorithmException(MessageLocalization.b("unknown.key.algorithm.1", str)));
            }
            this.f27319m = str2;
        }
    }

    public void H(String str) {
        this.f27310d = str;
    }

    public void I(String str) {
        this.f27309c = str;
    }

    public void J(Calendar calendar) {
        this.f27311e = calendar;
    }

    public void K(String str) {
        this.f27308b = str;
    }

    public void M(byte[] bArr, int i2, int i3) throws SignatureException {
        if (this.s == null && this.f27317k == null && !this.D) {
            this.q.update(bArr, i2, i3);
        } else {
            this.f27315i.update(bArr, i2, i3);
        }
    }

    public boolean N() throws GeneralSecurityException {
        boolean z2;
        boolean z3;
        boolean verify;
        if (this.w) {
            return this.x;
        }
        if (this.D) {
            verify = Arrays.equals(this.f27315i.digest(), this.F.getTimeStampInfo().toASN1Structure().getMessageImprint().getHashedMessage());
        } else if (this.t == null && this.u == null) {
            if (this.s != null) {
                this.q.update(this.f27315i.digest());
            }
            verify = this.q.verify(this.r);
        } else {
            byte[] digest = this.f27315i.digest();
            byte[] bArr = this.s;
            boolean z4 = false;
            if (bArr != null) {
                z3 = Arrays.equals(digest, bArr);
                this.v.update(this.s);
                z2 = Arrays.equals(this.v.digest(), this.f27317k);
            } else {
                z3 = true;
                z2 = false;
            }
            boolean z5 = Arrays.equals(digest, this.f27317k) || z2;
            boolean z6 = O(this.t) || O(this.u);
            if (z5 && z6 && z3) {
                z4 = true;
            }
            this.x = z4;
            this.w = true;
            return this.x;
        }
        this.x = verify;
        this.w = true;
        return this.x;
    }

    public boolean P() throws GeneralSecurityException {
        TimeStampToken timeStampToken = this.F;
        if (timeStampToken == null) {
            return false;
        }
        TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
        MessageImprint messageImprint = timeStampInfo.toASN1Structure().getMessageImprint();
        return Arrays.equals(new BouncyCastleDigest().a(DigestAlgorithms.d(timeStampInfo.getMessageImprintAlgOID().getId())).digest(this.r), messageImprint.getHashedMessage());
    }

    public byte[] d(byte[] bArr, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        try {
            return e(bArr, bArr2, collection, cryptoStandard).getEncoded("DER");
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public Collection<CRL> f() {
        return this.B;
    }

    public Certificate[] g() {
        Collection<Certificate> collection = this.y;
        return (Certificate[]) collection.toArray(new X509Certificate[collection.size()]);
    }

    public String h() {
        return q() + "with" + o();
    }

    public String i() {
        return this.f27314h;
    }

    public String j() {
        return this.f27319m;
    }

    public byte[] k() {
        try {
            byte[] bArr = this.o;
            if (bArr != null) {
                this.r = bArr;
            } else {
                this.r = this.q.sign();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(new DEROctetString(this.r));
            aSN1OutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public byte[] l() {
        return n((byte[]) null, (TSAClient) null, (byte[]) null, (Collection<byte[]>) null, MakeSignature.CryptoStandard.CMS);
    }

    public byte[] m(byte[] bArr) {
        return n(bArr, (TSAClient) null, (byte[]) null, (Collection<byte[]>) null, MakeSignature.CryptoStandard.CMS);
    }

    public byte[] n(byte[] bArr, TSAClient tSAClient, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        byte[] b2;
        ASN1EncodableVector a2;
        try {
            byte[] bArr3 = this.o;
            if (bArr3 != null) {
                this.r = bArr3;
                if (this.s != null) {
                    this.s = this.p;
                }
            } else {
                byte[] bArr4 = this.p;
                if (bArr4 == null || this.s == null) {
                    if (this.s != null) {
                        byte[] digest = this.f27315i.digest();
                        this.s = digest;
                        this.q.update(digest);
                    }
                    this.r = this.q.sign();
                } else {
                    this.s = bArr4;
                    this.q.update(bArr4);
                    this.r = this.q.sign();
                }
            }
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (String next : this.f27316j) {
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                aSN1EncodableVector2.add(new ASN1ObjectIdentifier(next));
                aSN1EncodableVector2.add(DERNull.INSTANCE);
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            }
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(new ASN1ObjectIdentifier(SecurityIDs.f27342a));
            if (this.s != null) {
                aSN1EncodableVector3.add(new DERTaggedObject(0, new DEROctetString(this.s)));
            }
            DERSequence dERSequence = new DERSequence(aSN1EncodableVector3);
            ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
            Iterator<Certificate> it2 = this.y.iterator();
            while (it2.hasNext()) {
                aSN1EncodableVector4.add(new ASN1InputStream(new ByteArrayInputStream(((X509Certificate) it2.next()).getEncoded())).readObject());
            }
            DERSet dERSet = new DERSet(aSN1EncodableVector4);
            ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
            aSN1EncodableVector5.add(new ASN1Integer(this.f27313g));
            ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
            aSN1EncodableVector6.add(CertificateInfo.a(this.A.getTBSCertificate()));
            aSN1EncodableVector6.add(new ASN1Integer(this.A.getSerialNumber()));
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector6));
            ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
            aSN1EncodableVector7.add(new ASN1ObjectIdentifier(this.f27314h));
            aSN1EncodableVector7.add(new DERNull());
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector7));
            if (bArr != null) {
                aSN1EncodableVector5.add(new DERTaggedObject(false, 0, e(bArr, bArr2, collection, cryptoStandard)));
            }
            ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
            aSN1EncodableVector8.add(new ASN1ObjectIdentifier(this.f27319m));
            aSN1EncodableVector8.add(new DERNull());
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector8));
            aSN1EncodableVector5.add(new DEROctetString(this.r));
            if (!(tSAClient == null || (b2 = tSAClient.b(tSAClient.c().digest(this.r))) == null || (a2 = a(b2)) == null)) {
                aSN1EncodableVector5.add(new DERTaggedObject(false, 1, new DERSet(a2)));
            }
            ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
            aSN1EncodableVector9.add(new ASN1Integer(this.f27312f));
            aSN1EncodableVector9.add(new DERSet(aSN1EncodableVector));
            aSN1EncodableVector9.add(dERSequence);
            aSN1EncodableVector9.add(new DERTaggedObject(false, 0, dERSet));
            aSN1EncodableVector9.add(new DERSet(new DERSequence(aSN1EncodableVector5)));
            ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
            aSN1EncodableVector10.add(new ASN1ObjectIdentifier(SecurityIDs.f27343b));
            aSN1EncodableVector10.add(new DERTaggedObject(0, new DERSequence(aSN1EncodableVector9)));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(new DERSequence(aSN1EncodableVector10));
            aSN1OutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public String o() {
        String a2 = EncryptionAlgorithms.a(this.f27319m);
        return a2 == null ? this.f27319m : a2;
    }

    public PdfName p() {
        return this.f27318l;
    }

    public String q() {
        return DigestAlgorithms.d(this.f27314h);
    }

    public String r() {
        return this.f27310d;
    }

    public BasicOCSPResp s() {
        return this.C;
    }

    public String t() {
        return this.f27309c;
    }

    public Certificate[] u() {
        Collection<Certificate> collection = this.z;
        return (Certificate[]) collection.toArray(new X509Certificate[collection.size()]);
    }

    public Calendar v() {
        Calendar z2 = z();
        return z2 == null ? this.f27311e : z2;
    }

    public String w() {
        return this.f27308b;
    }

    public X509Certificate x() {
        return this.A;
    }

    public int y() {
        return this.f27313g;
    }

    public Calendar z() {
        if (this.F == null) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.F.getTimeStampInfo().getGenTime());
        return gregorianCalendar;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PdfPKCS7(byte[] r11, com.itextpdf.text.pdf.PdfName r12, java.lang.String r13) {
        /*
            r10 = this;
            r0 = 0
            r10.<init>()
            r1 = 1
            r10.f27312f = r1
            r10.f27313g = r1
            r10.f27318l = r12
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.w7
            boolean r2 = r2.equals(r12)
            r10.D = r2
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.v7
            boolean r12 = r2.equals(r12)
            r10.E = r12
            r10.f27307a = r13     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1InputStream r12 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ Exception -> 0x008c }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x008c }
            r2.<init>(r11)     // Catch:{ Exception -> 0x008c }
            r12.<init>(r2)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Primitive r12 = r12.readObject()     // Catch:{ IOException -> 0x03ce }
            boolean r2 = r12 instanceof org.spongycastle.asn1.ASN1Sequence     // Catch:{ Exception -> 0x008c }
            if (r2 == 0) goto L_0x03c0
            org.spongycastle.asn1.ASN1Sequence r12 = (org.spongycastle.asn1.ASN1Sequence) r12     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r2 = r12.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r2     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = "1.2.840.113549.1.7.2"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x008c }
            if (r2 == 0) goto L_0x03b2
            org.spongycastle.asn1.ASN1Encodable r2 = r12.getObjectAt(r1)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1TaggedObject r2 = (org.spongycastle.asn1.ASN1TaggedObject) r2     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Primitive r2 = r2.getObject()     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r2 = (org.spongycastle.asn1.ASN1Sequence) r2     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r3 = r2.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Integer r3 = (org.spongycastle.asn1.ASN1Integer) r3     // Catch:{ Exception -> 0x008c }
            java.math.BigInteger r3 = r3.getValue()     // Catch:{ Exception -> 0x008c }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x008c }
            r10.f27312f = r3     // Catch:{ Exception -> 0x008c }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ Exception -> 0x008c }
            r3.<init>()     // Catch:{ Exception -> 0x008c }
            r10.f27316j = r3     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r3 = r2.getObjectAt(r1)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Set r3 = (org.spongycastle.asn1.ASN1Set) r3     // Catch:{ Exception -> 0x008c }
            java.util.Enumeration r3 = r3.getObjects()     // Catch:{ Exception -> 0x008c }
        L_0x0070:
            boolean r4 = r3.hasMoreElements()     // Catch:{ Exception -> 0x008c }
            if (r4 == 0) goto L_0x008f
            java.lang.Object r4 = r3.nextElement()     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r4 = (org.spongycastle.asn1.ASN1Sequence) r4     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r4 = r4.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r4     // Catch:{ Exception -> 0x008c }
            java.util.Set<java.lang.String> r5 = r10.f27316j     // Catch:{ Exception -> 0x008c }
            java.lang.String r4 = r4.getId()     // Catch:{ Exception -> 0x008c }
            r5.add(r4)     // Catch:{ Exception -> 0x008c }
            goto L_0x0070
        L_0x008c:
            r11 = move-exception
            goto L_0x03dc
        L_0x008f:
            r3 = 2
            org.spongycastle.asn1.ASN1Encodable r4 = r2.getObjectAt(r3)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r4 = (org.spongycastle.asn1.ASN1Sequence) r4     // Catch:{ Exception -> 0x008c }
            int r5 = r4.size()     // Catch:{ Exception -> 0x008c }
            if (r5 <= r1) goto L_0x00ae
            org.spongycastle.asn1.ASN1Encodable r4 = r4.getObjectAt(r1)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1TaggedObject r4 = (org.spongycastle.asn1.ASN1TaggedObject) r4     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Primitive r4 = r4.getObject()     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1OctetString r4 = (org.spongycastle.asn1.ASN1OctetString) r4     // Catch:{ Exception -> 0x008c }
            byte[] r4 = r4.getOctets()     // Catch:{ Exception -> 0x008c }
            r10.s = r4     // Catch:{ Exception -> 0x008c }
        L_0x00ae:
            r4 = 3
            r5 = 3
        L_0x00b0:
            org.spongycastle.asn1.ASN1Encodable r6 = r2.getObjectAt(r5)     // Catch:{ Exception -> 0x008c }
            boolean r6 = r6 instanceof org.spongycastle.asn1.ASN1TaggedObject     // Catch:{ Exception -> 0x008c }
            if (r6 == 0) goto L_0x00ba
            int r5 = r5 + r1
            goto L_0x00b0
        L_0x00ba:
            org.spongycastle.jce.provider.X509CertParser r6 = new org.spongycastle.jce.provider.X509CertParser     // Catch:{ Exception -> 0x008c }
            r6.<init>()     // Catch:{ Exception -> 0x008c }
            java.io.ByteArrayInputStream r7 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x008c }
            r7.<init>(r11)     // Catch:{ Exception -> 0x008c }
            r6.engineInit(r7)     // Catch:{ Exception -> 0x008c }
            java.util.Collection r11 = r6.engineReadAll()     // Catch:{ Exception -> 0x008c }
            r10.y = r11     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r11 = r2.getObjectAt(r5)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Set r11 = (org.spongycastle.asn1.ASN1Set) r11     // Catch:{ Exception -> 0x008c }
            int r2 = r11.size()     // Catch:{ Exception -> 0x008c }
            if (r2 != r1) goto L_0x03a4
            org.spongycastle.asn1.ASN1Encodable r11 = r11.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r11 = (org.spongycastle.asn1.ASN1Sequence) r11     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r2 = r11.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Integer r2 = (org.spongycastle.asn1.ASN1Integer) r2     // Catch:{ Exception -> 0x008c }
            java.math.BigInteger r2 = r2.getValue()     // Catch:{ Exception -> 0x008c }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x008c }
            r10.f27313g = r2     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r2 = r11.getObjectAt(r1)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r2 = (org.spongycastle.asn1.ASN1Sequence) r2     // Catch:{ Exception -> 0x008c }
            org.spongycastle.jce.X509Principal r5 = new org.spongycastle.jce.X509Principal     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r6 = r2.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Primitive r6 = r6.toASN1Primitive()     // Catch:{ Exception -> 0x008c }
            byte[] r6 = r6.getEncoded()     // Catch:{ Exception -> 0x008c }
            r5.<init>(r6)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r2 = r2.getObjectAt(r1)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Integer r2 = (org.spongycastle.asn1.ASN1Integer) r2     // Catch:{ Exception -> 0x008c }
            java.math.BigInteger r2 = r2.getValue()     // Catch:{ Exception -> 0x008c }
            java.util.Collection<java.security.cert.Certificate> r6 = r10.y     // Catch:{ Exception -> 0x008c }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x008c }
        L_0x0116:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x008c }
            if (r7 == 0) goto L_0x0138
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x008c }
            java.security.cert.X509Certificate r7 = (java.security.cert.X509Certificate) r7     // Catch:{ Exception -> 0x008c }
            java.security.Principal r8 = r7.getIssuerDN()     // Catch:{ Exception -> 0x008c }
            boolean r8 = r8.equals(r5)     // Catch:{ Exception -> 0x008c }
            if (r8 == 0) goto L_0x0116
            java.math.BigInteger r8 = r7.getSerialNumber()     // Catch:{ Exception -> 0x008c }
            boolean r8 = r2.equals(r8)     // Catch:{ Exception -> 0x008c }
            if (r8 == 0) goto L_0x0116
            r10.A = r7     // Catch:{ Exception -> 0x008c }
        L_0x0138:
            java.security.cert.X509Certificate r6 = r10.A     // Catch:{ Exception -> 0x008c }
            if (r6 == 0) goto L_0x0376
            r10.L()     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r2 = r11.getObjectAt(r3)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r2 = (org.spongycastle.asn1.ASN1Sequence) r2     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r2 = r2.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r2     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x008c }
            r10.f27314h = r2     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r2 = r11.getObjectAt(r4)     // Catch:{ Exception -> 0x008c }
            boolean r2 = r2 instanceof org.spongycastle.asn1.ASN1TaggedObject     // Catch:{ Exception -> 0x008c }
            if (r2 == 0) goto L_0x029e
            org.spongycastle.asn1.ASN1Encodable r2 = r11.getObjectAt(r4)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1TaggedObject r2 = (org.spongycastle.asn1.ASN1TaggedObject) r2     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Set r2 = org.spongycastle.asn1.ASN1Set.getInstance(r2, r0)     // Catch:{ Exception -> 0x008c }
            byte[] r4 = r2.getEncoded()     // Catch:{ Exception -> 0x008c }
            r10.t = r4     // Catch:{ Exception -> 0x008c }
            java.lang.String r4 = "DER"
            byte[] r4 = r2.getEncoded(r4)     // Catch:{ Exception -> 0x008c }
            r10.u = r4     // Catch:{ Exception -> 0x008c }
            r4 = 0
            r5 = 0
        L_0x0173:
            int r6 = r2.size()     // Catch:{ Exception -> 0x008c }
            if (r4 >= r6) goto L_0x028a
            org.spongycastle.asn1.ASN1Encodable r6 = r2.getObjectAt(r4)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r6 = (org.spongycastle.asn1.ASN1Sequence) r6     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r7 = r6.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1ObjectIdentifier r7 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r7     // Catch:{ Exception -> 0x008c }
            java.lang.String r7 = r7.getId()     // Catch:{ Exception -> 0x008c }
            java.lang.String r8 = "1.2.840.113549.1.9.4"
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x008c }
            if (r8 == 0) goto L_0x01a5
            org.spongycastle.asn1.ASN1Encodable r6 = r6.getObjectAt(r1)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Set r6 = (org.spongycastle.asn1.ASN1Set) r6     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r6 = r6.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1OctetString r6 = (org.spongycastle.asn1.ASN1OctetString) r6     // Catch:{ Exception -> 0x008c }
            byte[] r6 = r6.getOctets()     // Catch:{ Exception -> 0x008c }
            r10.f27317k = r6     // Catch:{ Exception -> 0x008c }
            goto L_0x0287
        L_0x01a5:
            java.lang.String r8 = "1.2.840.113583.1.1.8"
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x008c }
            if (r8 == 0) goto L_0x01e6
            org.spongycastle.asn1.ASN1Encodable r6 = r6.getObjectAt(r1)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Set r6 = (org.spongycastle.asn1.ASN1Set) r6     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r6 = r6.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r6 = (org.spongycastle.asn1.ASN1Sequence) r6     // Catch:{ Exception -> 0x008c }
            r7 = 0
        L_0x01ba:
            int r8 = r6.size()     // Catch:{ Exception -> 0x008c }
            if (r7 >= r8) goto L_0x0287
            org.spongycastle.asn1.ASN1Encodable r8 = r6.getObjectAt(r7)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1TaggedObject r8 = (org.spongycastle.asn1.ASN1TaggedObject) r8     // Catch:{ Exception -> 0x008c }
            int r9 = r8.getTagNo()     // Catch:{ Exception -> 0x008c }
            if (r9 != 0) goto L_0x01d5
            org.spongycastle.asn1.ASN1Primitive r9 = r8.getObject()     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r9 = (org.spongycastle.asn1.ASN1Sequence) r9     // Catch:{ Exception -> 0x008c }
            r10.b(r9)     // Catch:{ Exception -> 0x008c }
        L_0x01d5:
            int r9 = r8.getTagNo()     // Catch:{ Exception -> 0x008c }
            if (r9 != r1) goto L_0x01e4
            org.spongycastle.asn1.ASN1Primitive r8 = r8.getObject()     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r8 = (org.spongycastle.asn1.ASN1Sequence) r8     // Catch:{ Exception -> 0x008c }
            r10.c(r8)     // Catch:{ Exception -> 0x008c }
        L_0x01e4:
            int r7 = r7 + r1
            goto L_0x01ba
        L_0x01e6:
            boolean r8 = r10.E     // Catch:{ Exception -> 0x008c }
            java.lang.String r9 = "Signing certificate doesn't match the ESS information."
            if (r8 == 0) goto L_0x0231
            java.lang.String r8 = "1.2.840.113549.1.9.16.2.12"
            boolean r8 = r7.equals(r8)     // Catch:{ Exception -> 0x008c }
            if (r8 == 0) goto L_0x0231
            org.spongycastle.asn1.ASN1Encodable r5 = r6.getObjectAt(r1)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Set r5 = (org.spongycastle.asn1.ASN1Set) r5     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r5 = r5.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r5 = (org.spongycastle.asn1.ASN1Sequence) r5     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ess.SigningCertificate r5 = org.spongycastle.asn1.ess.SigningCertificate.getInstance(r5)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ess.ESSCertID[] r5 = r5.getCerts()     // Catch:{ Exception -> 0x008c }
            r5 = r5[r0]     // Catch:{ Exception -> 0x008c }
            java.security.cert.X509Certificate r6 = r10.A     // Catch:{ Exception -> 0x008c }
            byte[] r6 = r6.getEncoded()     // Catch:{ Exception -> 0x008c }
            com.itextpdf.text.pdf.security.BouncyCastleDigest r7 = new com.itextpdf.text.pdf.security.BouncyCastleDigest     // Catch:{ Exception -> 0x008c }
            r7.<init>()     // Catch:{ Exception -> 0x008c }
            java.lang.String r8 = "SHA-1"
            java.security.MessageDigest r7 = r7.a(r8)     // Catch:{ Exception -> 0x008c }
            byte[] r6 = r7.digest(r6)     // Catch:{ Exception -> 0x008c }
            byte[] r5 = r5.getCertHash()     // Catch:{ Exception -> 0x008c }
            boolean r5 = java.util.Arrays.equals(r6, r5)     // Catch:{ Exception -> 0x008c }
            if (r5 == 0) goto L_0x022b
        L_0x0229:
            r5 = 1
            goto L_0x0287
        L_0x022b:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x008c }
            r11.<init>(r9)     // Catch:{ Exception -> 0x008c }
            throw r11     // Catch:{ Exception -> 0x008c }
        L_0x0231:
            boolean r8 = r10.E     // Catch:{ Exception -> 0x008c }
            if (r8 == 0) goto L_0x0287
            java.lang.String r8 = "1.2.840.113549.1.9.16.2.47"
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x008c }
            if (r7 == 0) goto L_0x0287
            org.spongycastle.asn1.ASN1Encodable r5 = r6.getObjectAt(r1)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Set r5 = (org.spongycastle.asn1.ASN1Set) r5     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r5 = r5.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r5 = (org.spongycastle.asn1.ASN1Sequence) r5     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ess.SigningCertificateV2 r5 = org.spongycastle.asn1.ess.SigningCertificateV2.getInstance(r5)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ess.ESSCertIDv2[] r5 = r5.getCerts()     // Catch:{ Exception -> 0x008c }
            r5 = r5[r0]     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r6 = r5.getHashAlgorithm()     // Catch:{ Exception -> 0x008c }
            java.security.cert.X509Certificate r7 = r10.A     // Catch:{ Exception -> 0x008c }
            byte[] r7 = r7.getEncoded()     // Catch:{ Exception -> 0x008c }
            com.itextpdf.text.pdf.security.BouncyCastleDigest r8 = new com.itextpdf.text.pdf.security.BouncyCastleDigest     // Catch:{ Exception -> 0x008c }
            r8.<init>()     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r6.getAlgorithm()     // Catch:{ Exception -> 0x008c }
            java.lang.String r6 = r6.getId()     // Catch:{ Exception -> 0x008c }
            java.lang.String r6 = com.itextpdf.text.pdf.security.DigestAlgorithms.d(r6)     // Catch:{ Exception -> 0x008c }
            java.security.MessageDigest r6 = r8.a(r6)     // Catch:{ Exception -> 0x008c }
            byte[] r6 = r6.digest(r7)     // Catch:{ Exception -> 0x008c }
            byte[] r5 = r5.getCertHash()     // Catch:{ Exception -> 0x008c }
            boolean r5 = java.util.Arrays.equals(r6, r5)     // Catch:{ Exception -> 0x008c }
            if (r5 == 0) goto L_0x0281
            goto L_0x0229
        L_0x0281:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x008c }
            r11.<init>(r9)     // Catch:{ Exception -> 0x008c }
            throw r11     // Catch:{ Exception -> 0x008c }
        L_0x0287:
            int r4 = r4 + r1
            goto L_0x0173
        L_0x028a:
            byte[] r2 = r10.f27317k     // Catch:{ Exception -> 0x008c }
            if (r2 == 0) goto L_0x0290
            r4 = 4
            goto L_0x029f
        L_0x0290:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = "authenticated.attribute.is.missing.the.digest"
            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = com.itextpdf.text.error_messages.MessageLocalization.b(r12, r13)     // Catch:{ Exception -> 0x008c }
            r11.<init>(r12)     // Catch:{ Exception -> 0x008c }
            throw r11     // Catch:{ Exception -> 0x008c }
        L_0x029e:
            r5 = 0
        L_0x029f:
            boolean r2 = r10.E     // Catch:{ Exception -> 0x008c }
            if (r2 == 0) goto L_0x02ae
            if (r5 == 0) goto L_0x02a6
            goto L_0x02ae
        L_0x02a6:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = "CAdES ESS information missing."
            r11.<init>(r12)     // Catch:{ Exception -> 0x008c }
            throw r11     // Catch:{ Exception -> 0x008c }
        L_0x02ae:
            int r1 = r1 + r4
            org.spongycastle.asn1.ASN1Encodable r2 = r11.getObjectAt(r4)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r2 = (org.spongycastle.asn1.ASN1Sequence) r2     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r2 = r2.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r2     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x008c }
            r10.f27319m = r2     // Catch:{ Exception -> 0x008c }
            int r4 = r4 + r3
            org.spongycastle.asn1.ASN1Encodable r1 = r11.getObjectAt(r1)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1OctetString r1 = (org.spongycastle.asn1.ASN1OctetString) r1     // Catch:{ Exception -> 0x008c }
            byte[] r1 = r1.getOctets()     // Catch:{ Exception -> 0x008c }
            r10.r = r1     // Catch:{ Exception -> 0x008c }
            int r1 = r11.size()     // Catch:{ Exception -> 0x008c }
            if (r4 >= r1) goto L_0x0315
            org.spongycastle.asn1.ASN1Encodable r1 = r11.getObjectAt(r4)     // Catch:{ Exception -> 0x008c }
            boolean r1 = r1 instanceof org.spongycastle.asn1.ASN1TaggedObject     // Catch:{ Exception -> 0x008c }
            if (r1 == 0) goto L_0x0315
            org.spongycastle.asn1.ASN1Encodable r11 = r11.getObjectAt(r4)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1TaggedObject r11 = (org.spongycastle.asn1.ASN1TaggedObject) r11     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Set r11 = org.spongycastle.asn1.ASN1Set.getInstance(r11, r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.cms.AttributeTable r1 = new org.spongycastle.asn1.cms.AttributeTable     // Catch:{ Exception -> 0x008c }
            r1.<init>(r11)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1ObjectIdentifier r11 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.id_aa_signatureTimeStampToken     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.cms.Attribute r11 = r1.get(r11)     // Catch:{ Exception -> 0x008c }
            if (r11 == 0) goto L_0x0315
            org.spongycastle.asn1.ASN1Set r1 = r11.getAttrValues()     // Catch:{ Exception -> 0x008c }
            int r1 = r1.size()     // Catch:{ Exception -> 0x008c }
            if (r1 <= 0) goto L_0x0315
            org.spongycastle.asn1.ASN1Set r11 = r11.getAttrValues()     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Encodable r11 = r11.getObjectAt(r0)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1Sequence r11 = org.spongycastle.asn1.ASN1Sequence.getInstance(r11)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.cms.ContentInfo r0 = new org.spongycastle.asn1.cms.ContentInfo     // Catch:{ Exception -> 0x008c }
            r0.<init>(r11)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.tsp.TimeStampToken r11 = new org.spongycastle.tsp.TimeStampToken     // Catch:{ Exception -> 0x008c }
            r11.<init>(r0)     // Catch:{ Exception -> 0x008c }
            r10.F = r11     // Catch:{ Exception -> 0x008c }
        L_0x0315:
            boolean r11 = r10.D     // Catch:{ Exception -> 0x008c }
            if (r11 == 0) goto L_0x0339
            org.spongycastle.asn1.cms.ContentInfo r11 = new org.spongycastle.asn1.cms.ContentInfo     // Catch:{ Exception -> 0x008c }
            r11.<init>(r12)     // Catch:{ Exception -> 0x008c }
            org.spongycastle.tsp.TimeStampToken r12 = new org.spongycastle.tsp.TimeStampToken     // Catch:{ Exception -> 0x008c }
            r12.<init>(r11)     // Catch:{ Exception -> 0x008c }
            r10.F = r12     // Catch:{ Exception -> 0x008c }
            org.spongycastle.tsp.TimeStampTokenInfo r11 = r12.getTimeStampInfo()     // Catch:{ Exception -> 0x008c }
            org.spongycastle.asn1.ASN1ObjectIdentifier r11 = r11.getMessageImprintAlgOID()     // Catch:{ Exception -> 0x008c }
            java.lang.String r11 = r11.getId()     // Catch:{ Exception -> 0x008c }
            r12 = 0
            java.security.MessageDigest r11 = com.itextpdf.text.pdf.security.DigestAlgorithms.f(r11, r12)     // Catch:{ Exception -> 0x008c }
            r10.f27315i = r11     // Catch:{ Exception -> 0x008c }
            goto L_0x0375
        L_0x0339:
            byte[] r11 = r10.s     // Catch:{ Exception -> 0x008c }
            if (r11 != 0) goto L_0x0341
            byte[] r11 = r10.f27317k     // Catch:{ Exception -> 0x008c }
            if (r11 == 0) goto L_0x0369
        L_0x0341:
            com.itextpdf.text.pdf.PdfName r11 = com.itextpdf.text.pdf.PdfName.x3     // Catch:{ Exception -> 0x008c }
            com.itextpdf.text.pdf.PdfName r12 = r10.p()     // Catch:{ Exception -> 0x008c }
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x008c }
            if (r11 == 0) goto L_0x0356
            java.lang.String r11 = "SHA1"
            java.security.MessageDigest r11 = com.itextpdf.text.pdf.security.DigestAlgorithms.e(r11, r13)     // Catch:{ Exception -> 0x008c }
        L_0x0353:
            r10.f27315i = r11     // Catch:{ Exception -> 0x008c }
            goto L_0x035f
        L_0x0356:
            java.lang.String r11 = r10.q()     // Catch:{ Exception -> 0x008c }
            java.security.MessageDigest r11 = com.itextpdf.text.pdf.security.DigestAlgorithms.e(r11, r13)     // Catch:{ Exception -> 0x008c }
            goto L_0x0353
        L_0x035f:
            java.lang.String r11 = r10.q()     // Catch:{ Exception -> 0x008c }
            java.security.MessageDigest r11 = com.itextpdf.text.pdf.security.DigestAlgorithms.e(r11, r13)     // Catch:{ Exception -> 0x008c }
            r10.v = r11     // Catch:{ Exception -> 0x008c }
        L_0x0369:
            java.security.cert.X509Certificate r11 = r10.A     // Catch:{ Exception -> 0x008c }
            java.security.PublicKey r11 = r11.getPublicKey()     // Catch:{ Exception -> 0x008c }
            java.security.Signature r11 = r10.D(r11)     // Catch:{ Exception -> 0x008c }
            r10.q = r11     // Catch:{ Exception -> 0x008c }
        L_0x0375:
            return
        L_0x0376:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = "can.t.find.signing.certificate.with.serial.1"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008c }
            r13.<init>()     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = r5.getName()     // Catch:{ Exception -> 0x008c }
            r13.append(r3)     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = " / "
            r13.append(r3)     // Catch:{ Exception -> 0x008c }
            r3 = 16
            java.lang.String r2 = r2.toString(r3)     // Catch:{ Exception -> 0x008c }
            r13.append(r2)     // Catch:{ Exception -> 0x008c }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x008c }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x008c }
            r1[r0] = r13     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = com.itextpdf.text.error_messages.MessageLocalization.b(r12, r1)     // Catch:{ Exception -> 0x008c }
            r11.<init>(r12)     // Catch:{ Exception -> 0x008c }
            throw r11     // Catch:{ Exception -> 0x008c }
        L_0x03a4:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = "this.pkcs.7.object.has.multiple.signerinfos.only.one.is.supported.at.this.time"
            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = com.itextpdf.text.error_messages.MessageLocalization.b(r12, r13)     // Catch:{ Exception -> 0x008c }
            r11.<init>(r12)     // Catch:{ Exception -> 0x008c }
            throw r11     // Catch:{ Exception -> 0x008c }
        L_0x03b2:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = "not.a.valid.pkcs.7.object.not.signed.data"
            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = com.itextpdf.text.error_messages.MessageLocalization.b(r12, r13)     // Catch:{ Exception -> 0x008c }
            r11.<init>(r12)     // Catch:{ Exception -> 0x008c }
            throw r11     // Catch:{ Exception -> 0x008c }
        L_0x03c0:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = "not.a.valid.pkcs.7.object.not.a.sequence"
            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = com.itextpdf.text.error_messages.MessageLocalization.b(r12, r13)     // Catch:{ Exception -> 0x008c }
            r11.<init>(r12)     // Catch:{ Exception -> 0x008c }
            throw r11     // Catch:{ Exception -> 0x008c }
        L_0x03ce:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = "can.t.decode.pkcs7signeddata.object"
            java.lang.Object[] r13 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x008c }
            java.lang.String r12 = com.itextpdf.text.error_messages.MessageLocalization.b(r12, r13)     // Catch:{ Exception -> 0x008c }
            r11.<init>(r12)     // Catch:{ Exception -> 0x008c }
            throw r11     // Catch:{ Exception -> 0x008c }
        L_0x03dc:
            com.itextpdf.text.ExceptionConverter r12 = new com.itextpdf.text.ExceptionConverter
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.security.PdfPKCS7.<init>(byte[], com.itextpdf.text.pdf.PdfName, java.lang.String):void");
    }

    public PdfPKCS7(byte[] bArr, byte[] bArr2, String str) {
        try {
            this.f27307a = str;
            X509CertParser x509CertParser = new X509CertParser();
            x509CertParser.engineInit(new ByteArrayInputStream(bArr2));
            Collection<Certificate> engineReadAll = x509CertParser.engineReadAll();
            this.y = engineReadAll;
            this.z = engineReadAll;
            this.A = (X509Certificate) engineReadAll.iterator().next();
            this.B = new ArrayList();
            this.r = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject().getOctets();
            this.q = str == null ? Signature.getInstance("SHA1withRSA") : Signature.getInstance("SHA1withRSA", str);
            this.q.initVerify(this.A.getPublicKey());
            this.f27314h = "1.2.840.10040.4.3";
            this.f27319m = "1.3.36.3.3.1.2";
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }
}
