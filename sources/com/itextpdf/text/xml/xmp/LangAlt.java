package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.xml.XMLUtil;
import java.util.Enumeration;
import java.util.Properties;

@Deprecated
public class LangAlt extends Properties {
    public static final String X = "x-default";
    private static final long s = 4396971487200843099L;

    public LangAlt() {
    }

    public void a(String str, String str2) {
        setProperty(str, XMLUtil.a(str2, false));
    }

    /* access modifiers changed from: protected */
    public void b(StringBuffer stringBuffer, Object obj) {
        stringBuffer.append("<rdf:li xml:lang=\"");
        stringBuffer.append(obj);
        stringBuffer.append("\" >");
        stringBuffer.append(get(obj));
        stringBuffer.append("</rdf:li>");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<rdf:Alt>");
        Enumeration<?> propertyNames = propertyNames();
        while (propertyNames.hasMoreElements()) {
            b(stringBuffer, propertyNames.nextElement());
        }
        stringBuffer.append("</rdf:Alt>");
        return stringBuffer.toString();
    }

    public LangAlt(String str) {
        a("x-default", str);
    }
}
