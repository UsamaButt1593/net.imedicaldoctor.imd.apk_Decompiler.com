package com.itextpdf.text.xml.xmp;

@Deprecated
public class DublinCoreSchema extends XmpSchema {
    public static final String X2 = "http://purl.org/dc/elements/1.1/";
    private static final long Y = -4551741356374797330L;
    public static final String Y2 = "dc:contributor";
    public static final String Z = "dc";
    public static final String Z2 = "dc:coverage";
    public static final String a3 = "dc:creator";
    public static final String b3 = "dc:date";
    public static final String c3 = "dc:description";
    public static final String d3 = "dc:format";
    public static final String e3 = "dc:identifier";
    public static final String f3 = "dc:language";
    public static final String g3 = "dc:publisher";
    public static final String h3 = "dc:relation";
    public static final String i3 = "dc:rights";
    public static final String j3 = "dc:source";
    public static final String k3 = "dc:subject";
    public static final String l3 = "dc:title";
    public static final String m3 = "dc:type";

    public DublinCoreSchema() {
        super("xmlns:dc=\"http://purl.org/dc/elements/1.1/\"");
        setProperty(d3, "application/pdf");
    }

    public void g(String str) {
        XmpArray xmpArray = new XmpArray(XmpArray.Z);
        xmpArray.add(str);
        f(a3, xmpArray);
    }

    public void h(String[] strArr) {
        XmpArray xmpArray = new XmpArray(XmpArray.Z);
        for (String add : strArr) {
            xmpArray.add(add);
        }
        f(a3, xmpArray);
    }

    public void i(LangAlt langAlt) {
        e(c3, langAlt);
    }

    public void l(String str) {
        XmpArray xmpArray = new XmpArray(XmpArray.X2);
        xmpArray.add(str);
        f(c3, xmpArray);
    }

    public void m(String str) {
        XmpArray xmpArray = new XmpArray(XmpArray.Z);
        xmpArray.add(str);
        f(g3, xmpArray);
    }

    public void n(String[] strArr) {
        XmpArray xmpArray = new XmpArray(XmpArray.Z);
        for (String add : strArr) {
            xmpArray.add(add);
        }
        f(g3, xmpArray);
    }

    public void o(String str) {
        XmpArray xmpArray = new XmpArray(XmpArray.Y);
        xmpArray.add(str);
        f(k3, xmpArray);
    }

    public void p(String[] strArr) {
        XmpArray xmpArray = new XmpArray(XmpArray.Y);
        for (String add : strArr) {
            xmpArray.add(add);
        }
        f(k3, xmpArray);
    }

    public void s(LangAlt langAlt) {
        e(l3, langAlt);
    }

    public void t(String str) {
        XmpArray xmpArray = new XmpArray(XmpArray.X2);
        xmpArray.add(str);
        f(l3, xmpArray);
    }
}
