package com.itextpdf.text.xml.xmp;

@Deprecated
public class XmpBasicSchema extends XmpSchema {
    public static final String X2 = "http://ns.adobe.com/xap/1.0/";
    private static final long Y = -2416613941622479298L;
    public static final String Y2 = "xmp:Advisory";
    public static final String Z = "xmp";
    public static final String Z2 = "xmp:BaseURL";
    public static final String a3 = "xmp:CreateDate";
    public static final String b3 = "xmp:CreatorTool";
    public static final String c3 = "xmp:Identifier";
    public static final String d3 = "xmp:MetadataDate";
    public static final String e3 = "xmp:ModifyDate";
    public static final String f3 = "xmp:Nickname";
    public static final String g3 = "xmp:Thumbnails";

    public XmpBasicSchema() {
        super("xmlns:xmp=\"http://ns.adobe.com/xap/1.0/\"");
    }

    public void g(String str) {
        setProperty(a3, str);
    }

    public void h(String str) {
        setProperty(b3, str);
    }

    public void i(String[] strArr) {
        XmpArray xmpArray = new XmpArray(XmpArray.Y);
        for (String add : strArr) {
            xmpArray.add(add);
        }
        f(c3, xmpArray);
    }

    public void l(String str) {
        setProperty(d3, str);
    }

    public void m(String str) {
        setProperty(e3, str);
    }

    public void n(String str) {
        setProperty(f3, str);
    }
}
