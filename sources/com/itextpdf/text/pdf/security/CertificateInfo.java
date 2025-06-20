package com.itextpdf.text.pdf.security;

import androidx.exifinterface.media.ExifInterface;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;

public class CertificateInfo {

    public static class X500Name {

        /* renamed from: b  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27249b;

        /* renamed from: c  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27250c;

        /* renamed from: d  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27251d;

        /* renamed from: e  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27252e;

        /* renamed from: f  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27253f;

        /* renamed from: g  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27254g;

        /* renamed from: h  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27255h;

        /* renamed from: i  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27256i;

        /* renamed from: j  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27257j;

        /* renamed from: k  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27258k;

        /* renamed from: l  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27259l;

        /* renamed from: m  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27260m;

        /* renamed from: n  reason: collision with root package name */
        public static final ASN1ObjectIdentifier f27261n = new ASN1ObjectIdentifier("2.5.4.45");
        public static final ASN1ObjectIdentifier o;
        public static final ASN1ObjectIdentifier p;
        public static final ASN1ObjectIdentifier q;
        public static final ASN1ObjectIdentifier r;
        public static final Map<ASN1ObjectIdentifier, String> s;

        /* renamed from: a  reason: collision with root package name */
        public Map<String, ArrayList<String>> f27262a = new HashMap();

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.5.4.6");
            f27249b = aSN1ObjectIdentifier;
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.5.4.10");
            f27250c = aSN1ObjectIdentifier2;
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("2.5.4.11");
            f27251d = aSN1ObjectIdentifier3;
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("2.5.4.12");
            f27252e = aSN1ObjectIdentifier4;
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("2.5.4.3");
            f27253f = aSN1ObjectIdentifier5;
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("2.5.4.5");
            f27254g = aSN1ObjectIdentifier6;
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier("2.5.4.7");
            f27255h = aSN1ObjectIdentifier7;
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("2.5.4.8");
            f27256i = aSN1ObjectIdentifier8;
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("2.5.4.4");
            f27257j = aSN1ObjectIdentifier9;
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("2.5.4.42");
            f27258k = aSN1ObjectIdentifier10;
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier("2.5.4.43");
            f27259l = aSN1ObjectIdentifier11;
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier("2.5.4.44");
            f27260m = aSN1ObjectIdentifier12;
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.1");
            o = aSN1ObjectIdentifier13;
            p = aSN1ObjectIdentifier13;
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
            q = aSN1ObjectIdentifier14;
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
            r = aSN1ObjectIdentifier15;
            HashMap hashMap = new HashMap();
            s = hashMap;
            hashMap.put(aSN1ObjectIdentifier, "C");
            hashMap.put(aSN1ObjectIdentifier2, "O");
            hashMap.put(aSN1ObjectIdentifier4, ExifInterface.d5);
            hashMap.put(aSN1ObjectIdentifier3, "OU");
            hashMap.put(aSN1ObjectIdentifier5, "CN");
            hashMap.put(aSN1ObjectIdentifier7, "L");
            hashMap.put(aSN1ObjectIdentifier8, "ST");
            hashMap.put(aSN1ObjectIdentifier6, "SN");
            hashMap.put(aSN1ObjectIdentifier13, ExifInterface.S4);
            hashMap.put(aSN1ObjectIdentifier14, "DC");
            hashMap.put(aSN1ObjectIdentifier15, "UID");
            hashMap.put(aSN1ObjectIdentifier9, "SURNAME");
            hashMap.put(aSN1ObjectIdentifier10, "GIVENNAME");
            hashMap.put(aSN1ObjectIdentifier11, "INITIALS");
            hashMap.put(aSN1ObjectIdentifier12, "GENERATION");
        }

        public X500Name(String str) {
            X509NameTokenizer x509NameTokenizer = new X509NameTokenizer(str);
            while (x509NameTokenizer.a()) {
                String b2 = x509NameTokenizer.b();
                int indexOf = b2.indexOf(61);
                if (indexOf != -1) {
                    String upperCase = b2.substring(0, indexOf).toUpperCase();
                    String substring = b2.substring(indexOf + 1);
                    ArrayList arrayList = this.f27262a.get(upperCase);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        this.f27262a.put(upperCase, arrayList);
                    }
                    arrayList.add(substring);
                } else {
                    throw new IllegalArgumentException(MessageLocalization.b("badly.formated.directory.string", new Object[0]));
                }
            }
        }

        public String a(String str) {
            List list = this.f27262a.get(str);
            if (list == null) {
                return null;
            }
            return (String) list.get(0);
        }

        public List<String> b(String str) {
            return this.f27262a.get(str);
        }

        public Map<String, ArrayList<String>> c() {
            return this.f27262a;
        }

        public String toString() {
            return this.f27262a.toString();
        }

        public X500Name(ASN1Sequence aSN1Sequence) {
            Enumeration objects = aSN1Sequence.getObjects();
            while (objects.hasMoreElements()) {
                ASN1Set aSN1Set = (ASN1Set) objects.nextElement();
                for (int i2 = 0; i2 < aSN1Set.size(); i2++) {
                    ASN1Sequence objectAt = aSN1Set.getObjectAt(i2);
                    String str = s.get(objectAt.getObjectAt(0));
                    if (str != null) {
                        ArrayList arrayList = this.f27262a.get(str);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            this.f27262a.put(str, arrayList);
                        }
                        arrayList.add(objectAt.getObjectAt(1).getString());
                    }
                }
            }
        }
    }

    public static class X509NameTokenizer {

        /* renamed from: a  reason: collision with root package name */
        private String f27263a;

        /* renamed from: b  reason: collision with root package name */
        private int f27264b;

        /* renamed from: c  reason: collision with root package name */
        private StringBuffer f27265c = new StringBuffer();

        public X509NameTokenizer(String str) {
            this.f27263a = str;
            this.f27264b = -1;
        }

        public boolean a() {
            return this.f27264b != this.f27263a.length();
        }

        public String b() {
            if (this.f27264b == this.f27263a.length()) {
                return null;
            }
            int i2 = this.f27264b + 1;
            this.f27265c.setLength(0);
            boolean z = false;
            boolean z2 = false;
            while (i2 != this.f27263a.length()) {
                char charAt = this.f27263a.charAt(i2);
                if (charAt == '\"') {
                    if (!z) {
                        z2 = !z2;
                    }
                    this.f27265c.append(charAt);
                } else {
                    if (!z && !z2) {
                        if (charAt == '\\') {
                            z = true;
                        } else if (charAt == ',') {
                            break;
                        } else {
                            this.f27265c.append(charAt);
                        }
                        i2++;
                    }
                    this.f27265c.append(charAt);
                }
                z = false;
                i2++;
            }
            this.f27264b = i2;
            return this.f27265c.toString().trim();
        }
    }

    public static ASN1Primitive a(byte[] bArr) {
        try {
            ASN1Sequence readObject = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject();
            return readObject.getObjectAt(readObject.getObjectAt(0) instanceof ASN1TaggedObject ? 3 : 2);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static X500Name b(X509Certificate x509Certificate) {
        try {
            return new X500Name(a(x509Certificate.getTBSCertificate()));
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static ASN1Primitive c(byte[] bArr) {
        try {
            ASN1Sequence readObject = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject();
            return readObject.getObjectAt(readObject.getObjectAt(0) instanceof ASN1TaggedObject ? 5 : 4);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static X500Name d(X509Certificate x509Certificate) {
        if (x509Certificate == null) {
            return null;
        }
        try {
            return new X500Name(c(x509Certificate.getTBSCertificate()));
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }
}
