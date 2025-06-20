package org.ccil.cowan.tagsoup;

import com.itextpdf.text.pdf.security.SecurityConstants;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.xmp.XMPConst;

public class ElementType {

    /* renamed from: a  reason: collision with root package name */
    private String f31473a;

    /* renamed from: b  reason: collision with root package name */
    private String f31474b;

    /* renamed from: c  reason: collision with root package name */
    private String f31475c;

    /* renamed from: d  reason: collision with root package name */
    private int f31476d;

    /* renamed from: e  reason: collision with root package name */
    private int f31477e;

    /* renamed from: f  reason: collision with root package name */
    private int f31478f;

    /* renamed from: g  reason: collision with root package name */
    private AttributesImpl f31479g = new AttributesImpl();

    /* renamed from: h  reason: collision with root package name */
    private ElementType f31480h;

    /* renamed from: i  reason: collision with root package name */
    private Schema f31481i;

    public ElementType(String str, int i2, int i3, int i4, Schema schema) {
        this.f31473a = str;
        this.f31476d = i2;
        this.f31477e = i3;
        this.f31478f = i4;
        this.f31481i = schema;
        this.f31474b = j(str, false);
        this.f31475c = e(str);
    }

    public static String k(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        if (trim.indexOf("  ") == -1) {
            return trim;
        }
        int length = trim.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = trim.charAt(i2);
            if (charAt == ' ') {
                if (!z) {
                    stringBuffer.append(charAt);
                }
                z = true;
            } else {
                stringBuffer.append(charAt);
                z = false;
            }
        }
        return stringBuffer.toString();
    }

    public AttributesImpl a() {
        return this.f31479g;
    }

    public boolean b(ElementType elementType) {
        return (elementType.f31477e & this.f31476d) != 0;
    }

    public int c() {
        return this.f31478f;
    }

    public String d() {
        return this.f31475c;
    }

    public String e(String str) {
        int indexOf = str.indexOf(58);
        return indexOf == -1 ? str : str.substring(indexOf + 1).intern();
    }

    public int f() {
        return this.f31477e;
    }

    public int g() {
        return this.f31476d;
    }

    public String h() {
        return this.f31473a;
    }

    public String i() {
        return this.f31474b;
    }

    public String j(String str, boolean z) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            return z ? "" : this.f31481i.g();
        }
        String substring = str.substring(0, indexOf);
        if (substring.equals(HTML.Tag.f27613a)) {
            return XMPConst.f1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("urn:x-prefix:");
        stringBuffer.append(substring);
        return stringBuffer.toString().intern();
    }

    public ElementType l() {
        return this.f31480h;
    }

    public Schema m() {
        return this.f31481i;
    }

    public void n(String str, String str2, String str3) {
        o(this.f31479g, str, str2, str3);
    }

    public void o(AttributesImpl attributesImpl, String str, String str2, String str3) {
        if (!str.equals(SecurityConstants.f27328a) && !str.startsWith("xmlns:")) {
            String j2 = j(str, true);
            String e2 = e(str);
            int index = attributesImpl.getIndex(str);
            if (index == -1) {
                String intern = str.intern();
                String str4 = str2 == null ? "CDATA" : str2;
                if (!str4.equals("CDATA")) {
                    str3 = k(str3);
                }
                attributesImpl.a(j2, e2, intern, str4, str3);
                return;
            }
            if (str2 == null) {
                str2 = attributesImpl.getType(index);
            }
            String str5 = str2;
            if (!str5.equals("CDATA")) {
                str3 = k(str3);
            }
            attributesImpl.f(index, j2, e2, str, str5, str3);
        }
    }

    public void p(int i2) {
        this.f31478f = i2;
    }

    public void q(int i2) {
        this.f31477e = i2;
    }

    public void r(int i2) {
        this.f31476d = i2;
    }

    public void s(ElementType elementType) {
        this.f31480h = elementType;
    }
}
