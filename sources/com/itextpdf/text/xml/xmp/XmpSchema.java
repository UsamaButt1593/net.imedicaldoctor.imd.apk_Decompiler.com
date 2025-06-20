package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.xml.XMLUtil;
import java.util.Enumeration;
import java.util.Properties;

@Deprecated
public abstract class XmpSchema extends Properties {
    private static final long X = -176374295948945272L;
    protected String s;

    public XmpSchema(String str) {
        this.s = str;
    }

    public static String b(String str) {
        return XMLUtil.a(str, false);
    }

    public Object a(String str, String str2) {
        return setProperty(str, str2);
    }

    public String c() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    public void d(StringBuffer stringBuffer, Object obj) {
        stringBuffer.append('<');
        stringBuffer.append(obj);
        stringBuffer.append('>');
        stringBuffer.append(get(obj));
        stringBuffer.append("</");
        stringBuffer.append(obj);
        stringBuffer.append('>');
    }

    public Object e(String str, LangAlt langAlt) {
        return super.setProperty(str, langAlt.toString());
    }

    public Object f(String str, XmpArray xmpArray) {
        return super.setProperty(str, xmpArray.toString());
    }

    public Object setProperty(String str, String str2) {
        return super.setProperty(str, XMLUtil.a(str2, false));
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> propertyNames = propertyNames();
        while (propertyNames.hasMoreElements()) {
            d(stringBuffer, propertyNames.nextElement());
        }
        return stringBuffer.toString();
    }
}
