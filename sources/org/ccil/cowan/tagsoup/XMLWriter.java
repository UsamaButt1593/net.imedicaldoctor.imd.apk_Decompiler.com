package org.ccil.cowan.tagsoup;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.NamespaceSupport;
import org.xml.sax.helpers.XMLFilterImpl;

public class XMLWriter extends XMLFilterImpl implements LexicalHandler {
    public static final String A = "method";
    public static final String B = "omit-xml-declaration";
    public static final String C = "standalone";
    public static final String D = "version";
    public static final String u = "cdata-section-elements";
    public static final String v = "doctype-public";
    public static final String w = "doctype-system";
    public static final String x = "encoding";
    public static final String y = "indent";
    public static final String z = "media-type";

    /* renamed from: a  reason: collision with root package name */
    private String[] f31528a = {"checked", "compact", "declare", "defer", "disabled", "ismap", "multiple", "nohref", "noresize", "noshade", "nowrap", "readonly", "selected"};

    /* renamed from: b  reason: collision with root package name */
    private final Attributes f31529b = new AttributesImpl();

    /* renamed from: c  reason: collision with root package name */
    private Hashtable f31530c;

    /* renamed from: d  reason: collision with root package name */
    private Hashtable f31531d;

    /* renamed from: e  reason: collision with root package name */
    private Hashtable f31532e;

    /* renamed from: f  reason: collision with root package name */
    private int f31533f = 0;

    /* renamed from: g  reason: collision with root package name */
    private Writer f31534g;

    /* renamed from: h  reason: collision with root package name */
    private NamespaceSupport f31535h;

    /* renamed from: i  reason: collision with root package name */
    private int f31536i = 0;

    /* renamed from: j  reason: collision with root package name */
    private Properties f31537j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f31538k = false;

    /* renamed from: l  reason: collision with root package name */
    private String f31539l = "";

    /* renamed from: m  reason: collision with root package name */
    private boolean f31540m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f31541n = false;
    private boolean o = false;
    private String p = null;
    private String q = null;
    private String r = null;
    private String s = null;
    private boolean t = false;

    public XMLWriter() {
        r((Writer) null);
    }

    private void A(Attributes attributes) throws SAXException {
        int length = attributes.getLength();
        int i2 = 0;
        while (i2 < length) {
            char[] charArray = attributes.getValue(i2).toCharArray();
            y(' ');
            D(attributes.getURI(i2), attributes.getLocalName(i2), attributes.getQName(i2), false);
            if (!this.f31540m || !a(attributes.getLocalName(i2), attributes.getQName(i2), attributes.getValue(i2))) {
                z("=\"");
                B(charArray, 0, charArray.length, true);
                y('\"');
                i2++;
            } else {
                return;
            }
        }
    }

    private void B(char[] cArr, int i2, int i3, boolean z2) throws SAXException {
        String str;
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            char c2 = cArr[i4];
            if (c2 != '\"') {
                if (c2 == '&') {
                    str = "&amp;";
                } else if (c2 == '<') {
                    str = "&lt;";
                } else if (c2 != '>') {
                    if (!this.f31538k && c2 > 127) {
                        z("&#");
                        z(Integer.toString(cArr[i4]));
                        c2 = ASCIIPropertyListParser.f18655m;
                    }
                    y(c2);
                } else {
                    str = "&gt;";
                }
            } else if (z2) {
                str = "&quot;";
            } else {
                y('\"');
            }
            z(str);
        }
    }

    private void C() throws SAXException {
        String str;
        Enumeration declaredPrefixes = this.f31535h.getDeclaredPrefixes();
        while (declaredPrefixes.hasMoreElements()) {
            String str2 = (String) declaredPrefixes.nextElement();
            String uri = this.f31535h.getURI(str2);
            if (uri == null) {
                uri = "";
            }
            char[] charArray = uri.toCharArray();
            y(' ');
            if ("".equals(str2)) {
                str = "xmlns=\"";
            } else {
                z("xmlns:");
                z(str2);
                str = "=\"";
            }
            z(str);
            B(charArray, 0, charArray.length, true);
            y('\"');
        }
    }

    private void D(String str, String str2, String str3, boolean z2) throws SAXException {
        String f2 = f(str, str3, z2);
        if (f2 != null && !"".equals(f2)) {
            z(f2);
            y(ASCIIPropertyListParser.A);
        }
        if (str2 == null || "".equals(str2)) {
            z(str3.substring(str3.indexOf(58) + 1, str3.length()));
        } else {
            z(str2);
        }
    }

    private boolean a(String str, String str2, String str3) {
        int indexOf;
        if (str == null && (indexOf = str2.indexOf(58)) != -1) {
            str = str2.substring(indexOf + 1, str2.length());
        }
        if (!str.equals(str3)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = this.f31528a;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str.equals(strArr[i2])) {
                return true;
            }
            i2++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0080, code lost:
        if (r0 == null) goto L_0x008a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a0 A[LOOP:0: B:43:0x008a->B:48:0x00a0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0095 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String f(java.lang.String r6, java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            org.xml.sax.helpers.NamespaceSupport r0 = r5.f31535h
            java.lang.String r1 = ""
            java.lang.String r0 = r0.getURI(r1)
            boolean r2 = r1.equals(r6)
            r3 = 0
            if (r2 == 0) goto L_0x0019
            if (r8 == 0) goto L_0x0018
            if (r0 == 0) goto L_0x0018
            org.xml.sax.helpers.NamespaceSupport r6 = r5.f31535h
            r6.declarePrefix(r1, r1)
        L_0x0018:
            return r3
        L_0x0019:
            if (r8 == 0) goto L_0x0025
            if (r0 == 0) goto L_0x0025
            boolean r2 = r6.equals(r0)
            if (r2 == 0) goto L_0x0025
            r2 = r1
            goto L_0x002b
        L_0x0025:
            org.xml.sax.helpers.NamespaceSupport r2 = r5.f31535h
            java.lang.String r2 = r2.getPrefix(r6)
        L_0x002b:
            if (r2 == 0) goto L_0x002e
            return r2
        L_0x002e:
            java.util.Hashtable r2 = r5.f31532e
            java.lang.Object r2 = r2.get(r6)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x004b
            if (r8 == 0) goto L_0x003c
            if (r0 == 0) goto L_0x0042
        L_0x003c:
            boolean r4 = r1.equals(r2)
            if (r4 != 0) goto L_0x004a
        L_0x0042:
            org.xml.sax.helpers.NamespaceSupport r4 = r5.f31535h
            java.lang.String r4 = r4.getURI(r2)
            if (r4 == 0) goto L_0x004b
        L_0x004a:
            r2 = r3
        L_0x004b:
            if (r2 != 0) goto L_0x006a
            java.util.Hashtable r2 = r5.f31530c
            java.lang.Object r2 = r2.get(r6)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x006a
            if (r8 == 0) goto L_0x005b
            if (r0 == 0) goto L_0x0061
        L_0x005b:
            boolean r4 = r1.equals(r2)
            if (r4 != 0) goto L_0x006b
        L_0x0061:
            org.xml.sax.helpers.NamespaceSupport r4 = r5.f31535h
            java.lang.String r4 = r4.getURI(r2)
            if (r4 == 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r3 = r2
        L_0x006b:
            if (r3 != 0) goto L_0x0089
            if (r7 == 0) goto L_0x0089
            boolean r2 = r1.equals(r7)
            if (r2 != 0) goto L_0x0089
            r2 = 58
            int r2 = r7.indexOf(r2)
            r4 = -1
            if (r2 != r4) goto L_0x0083
            if (r8 == 0) goto L_0x0089
            if (r0 != 0) goto L_0x0089
            goto L_0x008a
        L_0x0083:
            r8 = 0
            java.lang.String r1 = r7.substring(r8, r2)
            goto L_0x008a
        L_0x0089:
            r1 = r3
        L_0x008a:
            if (r1 == 0) goto L_0x00a0
            org.xml.sax.helpers.NamespaceSupport r7 = r5.f31535h
            java.lang.String r7 = r7.getURI(r1)
            if (r7 == 0) goto L_0x0095
            goto L_0x00a0
        L_0x0095:
            org.xml.sax.helpers.NamespaceSupport r7 = r5.f31535h
            r7.declarePrefix(r1, r6)
            java.util.Hashtable r7 = r5.f31532e
            r7.put(r6, r1)
            return r1
        L_0x00a0:
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            r7.<init>()
            java.lang.String r8 = "__NS"
            r7.append(r8)
            int r8 = r5.f31536i
            int r8 = r8 + 1
            r5.f31536i = r8
            r7.append(r8)
            java.lang.String r1 = r7.toString()
            goto L_0x008a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.XMLWriter.f(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    private void o() {
        Enumeration keys = this.f31531d.keys();
        while (keys.hasMoreElements()) {
            f((String) keys.nextElement(), (String) null, true);
        }
    }

    private void r(Writer writer) {
        t(writer);
        this.f31535h = new NamespaceSupport();
        this.f31530c = new Hashtable();
        this.f31531d = new Hashtable();
        this.f31532e = new Hashtable();
        this.f31537j = new Properties();
    }

    private void y(char c2) throws SAXException {
        try {
            this.f31534g.write(c2);
        } catch (IOException e2) {
            throw new SAXException(e2);
        }
    }

    private void z(String str) throws SAXException {
        try {
            this.f31534g.write(str);
        } catch (IOException e2) {
            throw new SAXException(e2);
        }
    }

    public void b(String str) throws SAXException {
        char[] charArray = str.toCharArray();
        characters(charArray, 0, charArray.length);
    }

    public void c(String str, String str2) throws SAXException {
        e("", str, "", this.f31529b, str2);
    }

    public void characters(char[] cArr, int i2, int i3) throws SAXException {
        if (!this.t) {
            B(cArr, i2, i3, false);
        } else {
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                y(cArr[i4]);
            }
        }
        super.characters(cArr, i2, i3);
    }

    public void comment(char[] cArr, int i2, int i3) throws SAXException {
        int i4;
        z("<!--");
        int i5 = i2;
        while (true) {
            int i6 = i2 + i3;
            if (i5 < i6) {
                y(cArr[i5]);
                if (cArr[i5] == '-' && (i4 = i5 + 1) <= i6 && cArr[i4] == '-') {
                    y(' ');
                }
                i5++;
            } else {
                z("-->");
                return;
            }
        }
    }

    public void d(String str, String str2, String str3) throws SAXException {
        e(str, str2, "", this.f31529b, str3);
    }

    public void e(String str, String str2, String str3, Attributes attributes, String str4) throws SAXException {
        startElement(str, str2, str3, attributes);
        b(str4);
        endElement(str, str2, str3);
    }

    public void endCDATA() throws SAXException {
    }

    public void endDTD() throws SAXException {
    }

    public void endDocument() throws SAXException {
        y(10);
        super.endDocument();
        try {
            l();
        } catch (IOException e2) {
            throw new SAXException(e2);
        }
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
        if (!this.f31540m || ((!str.equals("http://www.w3.org/1999/xhtml") && !str.equals("")) || (!str3.equals("area") && !str3.equals("base") && !str3.equals("basefont") && !str3.equals("br") && !str3.equals("col") && !str3.equals(TypedValues.AttributesType.L) && !str3.equals("hr") && !str3.equals("img") && !str3.equals(HTML.Tag.q0) && !str3.equals("isindex") && !str3.equals(HTML.Tag.C) && !str3.equals(HTML.Tag.D) && !str3.equals("param")))) {
            z("</");
            D(str, str2, str3, true);
            y('>');
        }
        this.t = false;
        super.endElement(str, str2, str3);
        this.f31535h.popContext();
        this.f31533f--;
    }

    public void endEntity(String str) throws SAXException {
    }

    public void g(String str) throws SAXException {
        i("", str, "", this.f31529b);
    }

    public void h(String str, String str2) throws SAXException {
        i(str, str2, "", this.f31529b);
    }

    public void i(String str, String str2, String str3, Attributes attributes) throws SAXException {
        this.f31535h.pushContext();
        y('<');
        D(str, str2, str3, true);
        A(attributes);
        if (this.f31533f == 1) {
            o();
        }
        C();
        z("/>");
        super.startElement(str, str2, str3, attributes);
        super.endElement(str, str2, str3);
    }

    public void ignorableWhitespace(char[] cArr, int i2, int i3) throws SAXException {
        B(cArr, i2, i3, false);
        super.ignorableWhitespace(cArr, i2, i3);
    }

    public void j(String str) throws SAXException {
        endElement("", str, "");
    }

    public void k(String str, String str2) throws SAXException {
        endElement(str, str2, "");
    }

    public void l() throws IOException {
        this.f31534g.flush();
    }

    public void m(String str) {
        this.f31531d.put(str, Boolean.TRUE);
    }

    public void n(String str, String str2) {
        v(str, str2);
        m(str);
    }

    public String p(String str) {
        return this.f31537j.getProperty(str);
    }

    public void processingInstruction(String str, String str2) throws SAXException {
        z("<?");
        z(str);
        y(' ');
        z(str2);
        z("?>");
        if (this.f31533f < 1) {
            y(10);
        }
        super.processingInstruction(str, str2);
    }

    public String q(String str) {
        return (String) this.f31530c.get(str);
    }

    public void s() {
        this.f31533f = 0;
        this.f31536i = 0;
        this.f31535h.reset();
    }

    public void startCDATA() throws SAXException {
    }

    public void startDTD(String str, String str2, String str3) throws SAXException {
        if (str != null && !this.o) {
            this.o = true;
            z("<!DOCTYPE ");
            z(str);
            if (str3 == null) {
                str3 = "";
            }
            String str4 = this.q;
            if (str4 != null) {
                str3 = str4;
            }
            char c2 = '\"';
            char c3 = str3.indexOf(34) != -1 ? '\'' : '\"';
            String str5 = this.p;
            if (str5 != null) {
                str2 = str5;
            }
            if (str2 == null || "".equals(str2)) {
                z(" SYSTEM ");
            } else {
                if (str2.indexOf(34) != -1) {
                    c2 = '\'';
                }
                z(" PUBLIC ");
                y(c2);
                z(str2);
                y(c2);
                y(' ');
            }
            y(c3);
            z(str3);
            y(c3);
            z(">\n");
        }
    }

    public void startDocument() throws SAXException {
        s();
        if (!"yes".equals(this.f31537j.getProperty(B, "no"))) {
            z("<?xml");
            if (this.r == null) {
                z(" version=\"1.0\"");
            } else {
                z(" version=\"");
                z(this.r);
                z("\"");
            }
            String str = this.f31539l;
            if (!(str == null || str == "")) {
                z(" encoding=\"");
                z(this.f31539l);
                z("\"");
            }
            if (this.s == null) {
                z(" standalone=\"yes\"?>\n");
            } else {
                z(" standalone=\"");
                z(this.s);
                z("\"");
            }
        }
        super.startDocument();
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        this.f31533f++;
        this.f31535h.pushContext();
        if (this.f31541n && !this.o) {
            startDTD(str2 == null ? str3 : str2, "", "");
        }
        y('<');
        D(str, str2, str3, true);
        A(attributes);
        if (this.f31533f == 1) {
            o();
        }
        C();
        y('>');
        if (this.f31540m && (str3.equals(HTML.Tag.A) || str3.equals("style"))) {
            this.t = true;
        }
        super.startElement(str, str2, str3, attributes);
    }

    public void startEntity(String str) throws SAXException {
    }

    public void t(Writer writer) {
        if (writer == null) {
            writer = new OutputStreamWriter(System.out);
        }
        this.f31534g = writer;
    }

    public void u(String str, String str2) {
        this.f31537j.setProperty(str, str2);
        if (str.equals("encoding")) {
            this.f31539l = str2;
            this.f31538k = str2.substring(0, 3).equalsIgnoreCase("utf");
        } else if (str.equals(A)) {
            this.f31540m = str2.equals(HTML.Tag.y);
        } else {
            if (str.equals(v)) {
                this.p = str2;
            } else if (str.equals(w)) {
                this.q = str2;
            } else if (str.equals("version")) {
                this.r = str2;
                return;
            } else if (str.equals(C)) {
                this.s = str2;
                return;
            } else {
                return;
            }
            this.f31541n = true;
        }
    }

    public void v(String str, String str2) {
        this.f31530c.put(str, str2);
    }

    public void w(String str) throws SAXException {
        startElement("", str, "", this.f31529b);
    }

    public void x(String str, String str2) throws SAXException {
        startElement(str, str2, "", this.f31529b);
    }

    public XMLWriter(Writer writer) {
        r(writer);
    }

    public XMLWriter(XMLReader xMLReader) {
        super(xMLReader);
        r((Writer) null);
    }

    public XMLWriter(XMLReader xMLReader, Writer writer) {
        super(xMLReader);
        r(writer);
    }
}
