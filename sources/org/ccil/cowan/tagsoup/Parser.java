package org.ccil.cowan.tagsoup;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import okio.Utf8;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

public class Parser extends DefaultHandler implements ScanHandler, XMLReader, LexicalHandler {
    private static boolean F = true;
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = true;
    private static boolean J = true;
    private static boolean K = false;
    private static boolean L = true;
    private static boolean M = false;
    private static boolean N = true;
    public static final String O = "http://xml.org/sax/features/namespaces";
    public static final String P = "http://xml.org/sax/features/namespace-prefixes";
    public static final String Q = "http://xml.org/sax/features/external-general-entities";
    public static final String R = "http://xml.org/sax/features/external-parameter-entities";
    public static final String S = "http://xml.org/sax/features/is-standalone";
    public static final String T = "http://xml.org/sax/features/lexical-handler/parameter-entities";
    public static final String U = "http://xml.org/sax/features/resolve-dtd-uris";
    public static final String V = "http://xml.org/sax/features/string-interning";
    public static final String W = "http://xml.org/sax/features/use-attributes2";
    public static final String X = "http://xml.org/sax/features/use-locator2";
    public static final String Y = "http://xml.org/sax/features/use-entity-resolver2";
    public static final String Z = "http://xml.org/sax/features/validation";
    public static final String a0 = "http://xml.org/sax/features/unicode-normalization-checking";
    public static final String b0 = "http://xml.org/sax/features/xmlns-uris";
    public static final String c0 = "http://xml.org/sax/features/xml-1.1";
    public static final String d0 = "http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons";
    public static final String e0 = "http://www.ccil.org/~cowan/tagsoup/features/bogons-empty";
    public static final String f0 = "http://www.ccil.org/~cowan/tagsoup/features/root-bogons";
    public static final String g0 = "http://www.ccil.org/~cowan/tagsoup/features/default-attributes";
    public static final String h0 = "http://www.ccil.org/~cowan/tagsoup/features/translate-colons";
    public static final String i0 = "http://www.ccil.org/~cowan/tagsoup/features/restart-elements";
    public static final String j0 = "http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace";
    public static final String k0 = "http://www.ccil.org/~cowan/tagsoup/features/cdata-elements";
    public static final String l0 = "http://xml.org/sax/properties/lexical-handler";
    public static final String m0 = "http://www.ccil.org/~cowan/tagsoup/properties/scanner";
    public static final String n0 = "http://www.ccil.org/~cowan/tagsoup/properties/schema";
    public static final String o0 = "http://www.ccil.org/~cowan/tagsoup/properties/auto-detector";
    private static char[] p0 = {'<', '/', '>'};
    private static String q0 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-'()+,./:=?;!*#@$_%";
    private Element A;
    private Element B;
    private int C;
    private boolean D;
    private char[] E;

    /* renamed from: a  reason: collision with root package name */
    private ContentHandler f31513a = this;

    /* renamed from: b  reason: collision with root package name */
    private LexicalHandler f31514b = this;

    /* renamed from: c  reason: collision with root package name */
    private DTDHandler f31515c = this;

    /* renamed from: d  reason: collision with root package name */
    private ErrorHandler f31516d = this;

    /* renamed from: e  reason: collision with root package name */
    private EntityResolver f31517e = this;

    /* renamed from: f  reason: collision with root package name */
    private Schema f31518f;

    /* renamed from: g  reason: collision with root package name */
    private Scanner f31519g;

    /* renamed from: h  reason: collision with root package name */
    private AutoDetector f31520h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31521i = F;

    /* renamed from: j  reason: collision with root package name */
    private boolean f31522j = G;

    /* renamed from: k  reason: collision with root package name */
    private boolean f31523k = H;

    /* renamed from: l  reason: collision with root package name */
    private boolean f31524l = I;

    /* renamed from: m  reason: collision with root package name */
    private boolean f31525m = J;

    /* renamed from: n  reason: collision with root package name */
    private boolean f31526n = K;
    private boolean o = L;
    private boolean p = M;
    private boolean q = N;
    private HashMap r;
    private Element s;
    private String t;
    private boolean u;
    private String v;
    private String w;
    private String x;
    private String y;
    private Element z;

    public Parser() {
        HashMap hashMap = new HashMap();
        this.r = hashMap;
        hashMap.put(O, I(F));
        HashMap hashMap2 = this.r;
        Boolean bool = Boolean.FALSE;
        hashMap2.put(P, bool);
        this.r.put(Q, bool);
        this.r.put(R, bool);
        this.r.put(S, bool);
        this.r.put(T, bool);
        HashMap hashMap3 = this.r;
        Boolean bool2 = Boolean.TRUE;
        hashMap3.put(U, bool2);
        this.r.put(V, bool2);
        this.r.put(W, bool);
        this.r.put(X, bool);
        this.r.put(Y, bool);
        this.r.put(Z, bool);
        this.r.put(b0, bool);
        this.r.put(b0, bool);
        this.r.put(c0, bool);
        this.r.put(d0, I(G));
        this.r.put(e0, I(H));
        this.r.put(f0, I(I));
        this.r.put(g0, I(J));
        this.r.put(h0, I(K));
        this.r.put(i0, I(L));
        this.r.put(j0, I(M));
        this.r.put(k0, I(N));
        this.s = null;
        this.t = null;
        this.u = false;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = 0;
        this.D = true;
        this.E = new char[2000];
    }

    private String A(String str) {
        int indexOf = str.indexOf(58);
        return indexOf != -1 ? str.substring(0, indexOf) : "";
    }

    private void B(Element element) throws SAXException {
        String j2 = element.j();
        String g2 = element.g();
        String k2 = element.k();
        String A2 = A(j2);
        element.d();
        if (!this.f31521i) {
            g2 = "";
            k2 = g2;
        }
        if (this.D && g2.equalsIgnoreCase(this.x)) {
            try {
                this.f31517e.resolveEntity(this.v, this.w);
            } catch (IOException unused) {
            }
        }
        if (u(A2, k2)) {
            this.f31513a.startPrefixMapping(A2, k2);
        }
        AttributesImpl b2 = element.b();
        int length = b2.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            String uri = b2.getURI(i2);
            String A3 = A(b2.getQName(i2));
            if (u(A3, uri)) {
                this.f31513a.startPrefixMapping(A3, uri);
            }
        }
        this.f31513a.startElement(k2, g2, j2, element.b());
        element.p(this.z);
        this.z = element;
        this.D = false;
        if (this.q && (element.e() & 2) != 0) {
            this.f31519g.startCDATA();
        }
    }

    private void C(Element element) throws SAXException {
        Element element2;
        ElementType m2;
        while (true) {
            element2 = this.z;
            while (element2 != null && !element2.c(element)) {
                element2 = element2.l();
            }
            if (element2 == null && (m2 = element.m()) != null) {
                Element element3 = new Element(m2, this.f31525m);
                element3.p(element);
                element = element3;
            }
        }
        if (element2 != null) {
            while (true) {
                Element element4 = this.z;
                if (element4 != element2 && element4 != null && element4.l() != null && this.z.l().l() != null) {
                    E();
                }
            }
            while (element != null) {
                Element l2 = element.l();
                if (!element.j().equals("<pcdata>")) {
                    B(element);
                }
                D(l2);
                element = l2;
            }
            this.s = null;
        }
    }

    private void D(Element element) throws SAXException {
        while (true) {
            Element element2 = this.A;
            if (element2 != null && this.z.c(element2)) {
                if (element == null || this.A.c(element)) {
                    Element l2 = this.A.l();
                    B(this.A);
                    this.A = l2;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void E() throws SAXException {
        Element element = this.z;
        z();
        if (this.o && (element.e() & 1) != 0) {
            element.a();
            element.p(this.A);
            this.A = element;
        }
    }

    private void F() {
        if (this.f31518f == null) {
            this.f31518f = new HTMLSchema();
        }
        if (this.f31519g == null) {
            this.f31519g = new HTMLScanner();
        }
        if (this.f31520h == null) {
            this.f31520h = new AutoDetector() {
                public Reader a(InputStream inputStream) {
                    return new InputStreamReader(inputStream);
                }
            };
        }
        this.z = new Element(this.f31518f.d("<root>"), this.f31525m);
        this.B = new Element(this.f31518f.d("<pcdata>"), this.f31525m);
        this.s = null;
        this.t = null;
        this.y = null;
        this.A = null;
        this.C = 0;
        this.D = true;
        this.w = null;
        this.v = null;
        this.x = null;
    }

    private static String[] G(String str) throws IllegalArgumentException {
        String trim = str.trim();
        if (trim.length() == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = trim.length();
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        char c2 = 0;
        boolean z3 = false;
        while (i2 < length) {
            char charAt = trim.charAt(i2);
            if (!z2 && charAt == '\'' && c2 != '\\') {
                z3 = !z3;
                if (i3 >= 0) {
                    i2++;
                    c2 = charAt;
                }
            } else if (z3 || charAt != '\"' || c2 == '\\') {
                if (!z3 && !z2) {
                    if (Character.isWhitespace(charAt)) {
                        if (i3 >= 0) {
                            arrayList.add(trim.substring(i3, i2));
                        }
                        i3 = -1;
                    } else if (i3 < 0) {
                        if (charAt == ' ') {
                        }
                    }
                }
                i2++;
                c2 = charAt;
            } else {
                z2 = !z2;
                if (i3 >= 0) {
                    i2++;
                    c2 = charAt;
                }
            }
            i3 = i2;
            i2++;
            c2 = charAt;
        }
        arrayList.add(trim.substring(i3, i2));
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static String H(String str) {
        int length;
        char charAt;
        if (str == null || (length = str.length()) == 0 || (charAt = str.charAt(0)) != str.charAt(length - 1)) {
            return str;
        }
        return (charAt == '\'' || charAt == '\"') ? str.substring(1, str.length() - 1) : str;
    }

    private static Boolean I(boolean z2) {
        return z2 ? Boolean.TRUE : Boolean.FALSE;
    }

    private String q(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        boolean z2 = true;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (q0.indexOf(charAt) != -1) {
                stringBuffer.append(charAt);
                z2 = false;
            } else if (!z2) {
                stringBuffer.append(' ');
                z2 = true;
            }
        }
        return stringBuffer.toString().trim();
    }

    private String t(String str) {
        int length = str.length();
        char[] cArr = new char[length];
        int i2 = 0;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            int i5 = i2 + 1;
            cArr[i2] = charAt;
            if (charAt == '&' && i3 == -1) {
                i2 = i5;
                i3 = i2;
            } else if (i3 != -1 && !Character.isLetter(charAt) && !Character.isDigit(charAt) && charAt != '#') {
                if (charAt == ';') {
                    int x2 = x(cArr, i3, (i5 - i3) - 1);
                    if (x2 > 65535) {
                        int i6 = x2 - 65536;
                        cArr[i3 - 1] = (char) ((i6 >> 10) + 55296);
                        cArr[i3] = (char) ((i6 & AnalyticsListener.c0) + Utf8.f31408e);
                        i3++;
                    } else if (x2 != 0) {
                        cArr[i3 - 1] = (char) x2;
                    } else {
                        i3 = i5;
                    }
                    i2 = i3;
                } else {
                    i2 = i5;
                }
                i3 = -1;
            } else {
                i2 = i5;
            }
        }
        return new String(cArr, 0, i2);
    }

    private boolean u(String str, String str2) {
        return !str.equals("") && !str2.equals("") && !str2.equals(this.f31518f.g());
    }

    private InputStream v(String str, String str2) throws IOException, SAXException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(System.getProperty("user.dir"));
        stringBuffer.append("/.");
        return new URL(new URL(Annotation.k3, "", stringBuffer.toString()), str2).openConnection().getInputStream();
    }

    private Reader w(InputSource inputSource) throws SAXException, IOException {
        Reader characterStream = inputSource.getCharacterStream();
        InputStream byteStream = inputSource.getByteStream();
        String encoding = inputSource.getEncoding();
        String publicId = inputSource.getPublicId();
        String systemId = inputSource.getSystemId();
        if (characterStream != null) {
            return characterStream;
        }
        if (byteStream == null) {
            byteStream = v(publicId, systemId);
        }
        if (encoding == null) {
            return this.f31520h.a(byteStream);
        }
        try {
            return new InputStreamReader(byteStream, encoding);
        } catch (UnsupportedEncodingException unused) {
            return new InputStreamReader(byteStream);
        }
    }

    private int x(char[] cArr, int i2, int i3) {
        char c2;
        if (i3 < 1) {
            return 0;
        }
        if (cArr[i2] != '#') {
            return this.f31518f.e(new String(cArr, i2, i3));
        }
        if (i3 <= 1 || !((c2 = cArr[i2 + 1]) == 'x' || c2 == 'X')) {
            try {
                return Integer.parseInt(new String(cArr, i2 + 1, i3 - 1), 10);
            } catch (NumberFormatException unused) {
                return 0;
            }
        } else {
            try {
                return Integer.parseInt(new String(cArr, i2 + 2, i3 - 2), 16);
            } catch (NumberFormatException unused2) {
                return 0;
            }
        }
    }

    private String y(char[] cArr, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer(i3 + 2);
        boolean z2 = true;
        boolean z3 = false;
        while (true) {
            int i4 = i3 - 1;
            char c2 = '_';
            if (i3 <= 0) {
                break;
            }
            char c3 = cArr[i2];
            if (!Character.isLetter(c3) && c3 != '_') {
                if (!Character.isDigit(c3) && c3 != '-' && c3 != '.') {
                    if (c3 == ':' && !z3) {
                        if (z2) {
                            stringBuffer.append('_');
                        }
                        if (!this.f31526n) {
                            c2 = c3;
                        }
                        stringBuffer.append(c2);
                        z2 = true;
                        z3 = true;
                    }
                    i2++;
                    i3 = i4;
                } else if (z2) {
                    stringBuffer.append('_');
                }
            }
            stringBuffer.append(c3);
            z2 = false;
            i2++;
            i3 = i4;
        }
        int length = stringBuffer.length();
        if (length == 0 || stringBuffer.charAt(length - 1) == ':') {
            stringBuffer.append('_');
        }
        return stringBuffer.toString().intern();
    }

    private void z() throws SAXException {
        Element element = this.z;
        if (element != null) {
            String j2 = element.j();
            String g2 = this.z.g();
            String k2 = this.z.k();
            String A2 = A(j2);
            if (!this.f31521i) {
                g2 = "";
                k2 = g2;
            }
            this.f31513a.endElement(k2, g2, j2);
            if (u(A2, k2)) {
                this.f31513a.endPrefixMapping(A2);
            }
            AttributesImpl b2 = this.z.b();
            for (int length = b2.getLength() - 1; length >= 0; length--) {
                String uri = b2.getURI(length);
                String A3 = A(b2.getQName(length));
                if (u(A3, uri)) {
                    this.f31513a.endPrefixMapping(A3);
                }
            }
            this.z = this.z.l();
        }
    }

    public void a(char[] cArr, int i2, int i3) throws SAXException {
        if (i3 != 0) {
            boolean z2 = true;
            for (int i4 = 0; i4 < i3; i4++) {
                if (!Character.isWhitespace(cArr[i2 + i4])) {
                    z2 = false;
                }
            }
            if (!z2 || this.z.c(this.B)) {
                C(this.B);
                this.f31513a.characters(cArr, i2, i3);
            } else if (this.p) {
                this.f31513a.ignorableWhitespace(cArr, i2, i3);
            }
        }
    }

    public void b(char[] cArr, int i2, int i3) throws SAXException {
        if (this.s == null) {
            this.y = y(cArr, i2, i3).replace(ASCIIPropertyListParser.A, '_');
        }
    }

    public int c() {
        return this.C;
    }

    public void comment(char[] cArr, int i2, int i3) throws SAXException {
    }

    public void d(char[] cArr, int i2, int i3) throws SAXException {
        Element element = this.s;
        if (element != null) {
            C(element);
            r(cArr, i2, i3);
        }
    }

    public void e(char[] cArr, int i2, int i3) throws SAXException {
        this.C = x(cArr, i2, i3);
    }

    public void endCDATA() throws SAXException {
    }

    public void endDTD() throws SAXException {
    }

    public void endEntity(String str) throws SAXException {
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(char[] r5, int r6, int r7) throws org.xml.sax.SAXException {
        /*
            r4 = this;
            java.lang.String r0 = new java.lang.String
            r0.<init>(r5, r6, r7)
            java.lang.String[] r5 = G(r0)
            int r6 = r5.length
            r7 = 0
            if (r6 <= 0) goto L_0x0052
            r6 = 0
            r6 = r5[r6]
            java.lang.String r0 = "DOCTYPE"
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0052
            boolean r6 = r4.u
            if (r6 == 0) goto L_0x001d
            return
        L_0x001d:
            r6 = 1
            r4.u = r6
            int r0 = r5.length
            if (r0 <= r6) goto L_0x0052
            r6 = r5[r6]
            int r0 = r5.length
            r1 = 2
            r2 = 3
            if (r0 <= r2) goto L_0x0037
            java.lang.String r0 = "SYSTEM"
            r3 = r5[r1]
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0037
            r5 = r5[r2]
            goto L_0x0054
        L_0x0037:
            int r0 = r5.length
            if (r0 <= r2) goto L_0x0050
            java.lang.String r0 = "PUBLIC"
            r1 = r5[r1]
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0050
            r7 = r5[r2]
            int r0 = r5.length
            r1 = 4
            if (r0 <= r1) goto L_0x004d
            r5 = r5[r1]
            goto L_0x0054
        L_0x004d:
            java.lang.String r5 = ""
            goto L_0x0054
        L_0x0050:
            r5 = r7
            goto L_0x0054
        L_0x0052:
            r5 = r7
            r6 = r5
        L_0x0054:
            java.lang.String r7 = H(r7)
            java.lang.String r5 = H(r5)
            if (r6 == 0) goto L_0x0090
            java.lang.String r7 = r4.q(r7)
            org.xml.sax.ext.LexicalHandler r0 = r4.f31514b
            r0.startDTD(r6, r7, r5)
            org.xml.sax.ext.LexicalHandler r0 = r4.f31514b
            r0.endDTD()
            r4.x = r6
            r4.v = r7
            org.ccil.cowan.tagsoup.Scanner r6 = r4.f31519g
            boolean r7 = r6 instanceof org.xml.sax.Locator
            if (r7 == 0) goto L_0x0090
            org.xml.sax.Locator r6 = (org.xml.sax.Locator) r6
            java.lang.String r6 = r6.getSystemId()
            r4.w = r6
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x0090 }
            java.net.URL r7 = new java.net.URL     // Catch:{ Exception -> 0x0090 }
            java.lang.String r0 = r4.w     // Catch:{ Exception -> 0x0090 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0090 }
            r6.<init>(r7, r5)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0090 }
            r4.w = r5     // Catch:{ Exception -> 0x0090 }
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.Parser.f(char[], int, int):void");
    }

    public void g(char[] cArr, int i2, int i3) throws SAXException {
        if (this.D) {
            C(this.B);
        }
        while (this.z.l() != null) {
            z();
        }
        if (!this.f31518f.g().equals("")) {
            this.f31513a.endPrefixMapping(this.f31518f.f());
        }
        this.f31513a.endDocument();
    }

    public ContentHandler getContentHandler() {
        ContentHandler contentHandler = this.f31513a;
        if (contentHandler == this) {
            return null;
        }
        return contentHandler;
    }

    public DTDHandler getDTDHandler() {
        DTDHandler dTDHandler = this.f31515c;
        if (dTDHandler == this) {
            return null;
        }
        return dTDHandler;
    }

    public EntityResolver getEntityResolver() {
        EntityResolver entityResolver = this.f31517e;
        if (entityResolver == this) {
            return null;
        }
        return entityResolver;
    }

    public ErrorHandler getErrorHandler() {
        ErrorHandler errorHandler = this.f31516d;
        if (errorHandler == this) {
            return null;
        }
        return errorHandler;
    }

    public boolean getFeature(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        Boolean bool = (Boolean) this.r.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unknown feature ");
        stringBuffer.append(str);
        throw new SAXNotRecognizedException(stringBuffer.toString());
    }

    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals(l0)) {
            LexicalHandler lexicalHandler = this.f31514b;
            if (lexicalHandler == this) {
                return null;
            }
            return lexicalHandler;
        } else if (str.equals(m0)) {
            return this.f31519g;
        } else {
            if (str.equals(n0)) {
                return this.f31518f;
            }
            if (str.equals(o0)) {
                return this.f31520h;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unknown property ");
            stringBuffer.append(str);
            throw new SAXNotRecognizedException(stringBuffer.toString());
        }
    }

    public void h(char[] cArr, int i2, int i3) throws SAXException {
        String str;
        if (this.s == null && (str = this.y) != null && !HTML.Tag.f27613a.equalsIgnoreCase(str)) {
            if (i3 > 0 && cArr[i3 - 1] == '?') {
                i3--;
            }
            this.f31513a.processingInstruction(this.y, new String(cArr, i2, i3));
            this.y = null;
        }
    }

    public void i(char[] cArr, int i2, int i3) throws SAXException {
        if (!s(cArr, i2, i3)) {
            r(cArr, i2, i3);
        }
    }

    public void j(char[] cArr, int i2, int i3) throws SAXException {
        this.f31514b.comment(cArr, i2, i3);
    }

    public void k(char[] cArr, int i2, int i3) throws SAXException {
        if (this.s != null) {
            this.t = y(cArr, i2, i3).toLowerCase();
        }
    }

    public void l(char[] cArr, int i2, int i3) throws SAXException {
        Element element = this.s;
        if (element != null) {
            C(element);
            if (this.z.i() == 0) {
                r(cArr, i2, i3);
            }
        }
    }

    public void m(char[] cArr, int i2, int i3) throws SAXException {
        this.f31514b.startCDATA();
        a(cArr, i2, i3);
        this.f31514b.endCDATA();
    }

    public void n(char[] cArr, int i2, int i3) throws SAXException {
        String str;
        Element element = this.s;
        if (element != null && (str = this.t) != null) {
            element.o(str, (String) null, str);
            this.t = null;
        }
    }

    public void o(char[] cArr, int i2, int i3) throws SAXException {
        if (this.s != null && this.t != null) {
            this.s.o(this.t, (String) null, t(new String(cArr, i2, i3)));
            this.t = null;
        }
    }

    public void p(char[] cArr, int i2, int i3) throws SAXException {
        String y2;
        if (this.s == null && (y2 = y(cArr, i2, i3)) != null) {
            ElementType d2 = this.f31518f.d(y2);
            if (d2 == null) {
                if (!this.f31522j) {
                    int i4 = -1;
                    int i5 = this.f31523k ? 0 : -1;
                    if (!this.f31524l) {
                        i4 = Integer.MAX_VALUE;
                    }
                    this.f31518f.b(y2, i5, i4, 0);
                    if (!this.f31524l) {
                        Schema schema = this.f31518f;
                        schema.h(y2, schema.i().h());
                    }
                    d2 = this.f31518f.d(y2);
                } else {
                    return;
                }
            }
            this.s = new Element(d2, this.f31525m);
        }
    }

    public void parse(String str) throws IOException, SAXException {
        parse(new InputSource(str));
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    public void r(char[] r3, int r4, int r5) throws org.xml.sax.SAXException {
        /*
            r2 = this;
            r0 = 0
            r2.s = r0
            if (r5 == 0) goto L_0x0017
            java.lang.String r3 = r2.y(r3, r4, r5)
            org.ccil.cowan.tagsoup.Schema r4 = r2.f31518f
            org.ccil.cowan.tagsoup.ElementType r3 = r4.d(r3)
            if (r3 != 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.String r3 = r3.h()
            goto L_0x001d
        L_0x0017:
            org.ccil.cowan.tagsoup.Element r3 = r2.z
            java.lang.String r3 = r3.j()
        L_0x001d:
            org.ccil.cowan.tagsoup.Element r4 = r2.z
            r5 = 0
        L_0x0020:
            if (r4 == 0) goto L_0x003b
            java.lang.String r1 = r4.j()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002d
            goto L_0x003b
        L_0x002d:
            int r1 = r4.e()
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0036
            r5 = 1
        L_0x0036:
            org.ccil.cowan.tagsoup.Element r4 = r4.l()
            goto L_0x0020
        L_0x003b:
            if (r4 != 0) goto L_0x003e
            return
        L_0x003e:
            org.ccil.cowan.tagsoup.Element r3 = r4.l()
            if (r3 == 0) goto L_0x006c
            org.ccil.cowan.tagsoup.Element r3 = r4.l()
            org.ccil.cowan.tagsoup.Element r3 = r3.l()
            if (r3 != 0) goto L_0x004f
            goto L_0x006c
        L_0x004f:
            if (r5 == 0) goto L_0x0055
            r4.n()
            goto L_0x0060
        L_0x0055:
            org.ccil.cowan.tagsoup.Element r3 = r2.z
            if (r3 == r4) goto L_0x005d
            r2.E()
            goto L_0x0055
        L_0x005d:
            r2.z()
        L_0x0060:
            org.ccil.cowan.tagsoup.Element r3 = r2.z
            boolean r3 = r3.f()
            if (r3 == 0) goto L_0x0069
            goto L_0x005d
        L_0x0069:
            r2.D(r0)
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.Parser.r(char[], int, int):void");
    }

    public boolean s(char[] cArr, int i2, int i3) throws SAXException {
        String j2 = this.z.j();
        if (this.q && (this.z.e() & 2) != 0) {
            boolean z2 = i3 == j2.length();
            if (z2) {
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        break;
                    } else if (Character.toLowerCase(cArr[i2 + i4]) != Character.toLowerCase(j2.charAt(i4))) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            if (!z2) {
                this.f31513a.characters(p0, 0, 2);
                this.f31513a.characters(cArr, i2, i3);
                this.f31513a.characters(p0, 2, 1);
                this.f31519g.startCDATA();
                return true;
            }
        }
        return false;
    }

    public void setContentHandler(ContentHandler contentHandler) {
        if (contentHandler == null) {
            contentHandler = this;
        }
        this.f31513a = contentHandler;
    }

    public void setDTDHandler(DTDHandler dTDHandler) {
        if (dTDHandler == null) {
            dTDHandler = this;
        }
        this.f31515c = dTDHandler;
    }

    public void setEntityResolver(EntityResolver entityResolver) {
        if (entityResolver == null) {
            entityResolver = this;
        }
        this.f31517e = entityResolver;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            errorHandler = this;
        }
        this.f31516d = errorHandler;
    }

    public void setFeature(String str, boolean z2) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (((Boolean) this.r.get(str)) != null) {
            this.r.put(str, z2 ? Boolean.TRUE : Boolean.FALSE);
            if (str.equals(O)) {
                this.f31521i = z2;
            } else if (str.equals(d0)) {
                this.f31522j = z2;
            } else if (str.equals(e0)) {
                this.f31523k = z2;
            } else if (str.equals(f0)) {
                this.f31524l = z2;
            } else if (str.equals(g0)) {
                this.f31525m = z2;
            } else if (str.equals(h0)) {
                this.f31526n = z2;
            } else if (str.equals(i0)) {
                this.o = z2;
            } else if (str.equals(j0)) {
                this.p = z2;
            } else if (str.equals(k0)) {
                this.q = z2;
            }
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unknown feature ");
            stringBuffer.append(str);
            throw new SAXNotRecognizedException(stringBuffer.toString());
        }
    }

    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (str.equals(l0)) {
            if (obj == null) {
                this.f31514b = this;
            } else if (obj instanceof LexicalHandler) {
                this.f31514b = (LexicalHandler) obj;
            } else {
                throw new SAXNotSupportedException("Your lexical handler is not a LexicalHandler");
            }
        } else if (str.equals(m0)) {
            if (obj instanceof Scanner) {
                this.f31519g = (Scanner) obj;
                return;
            }
            throw new SAXNotSupportedException("Your scanner is not a Scanner");
        } else if (str.equals(n0)) {
            if (obj instanceof Schema) {
                this.f31518f = (Schema) obj;
                return;
            }
            throw new SAXNotSupportedException("Your schema is not a Schema");
        } else if (!str.equals(o0)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unknown property ");
            stringBuffer.append(str);
            throw new SAXNotRecognizedException(stringBuffer.toString());
        } else if (obj instanceof AutoDetector) {
            this.f31520h = (AutoDetector) obj;
        } else {
            throw new SAXNotSupportedException("Your auto-detector is not an AutoDetector");
        }
    }

    public void startCDATA() throws SAXException {
    }

    public void startDTD(String str, String str2, String str3) throws SAXException {
    }

    public void startEntity(String str) throws SAXException {
    }

    public void parse(InputSource inputSource) throws IOException, SAXException {
        F();
        Reader w2 = w(inputSource);
        this.f31513a.startDocument();
        this.f31519g.b(inputSource.getPublicId(), inputSource.getSystemId());
        Scanner scanner = this.f31519g;
        if (scanner instanceof Locator) {
            this.f31513a.setDocumentLocator((Locator) scanner);
        }
        if (!this.f31518f.g().equals("")) {
            this.f31513a.startPrefixMapping(this.f31518f.f(), this.f31518f.g());
        }
        this.f31519g.a(w2, this);
    }
}
