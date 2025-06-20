package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.xml.XMLUtil;
import java.util.ArrayList;
import java.util.Iterator;

@Deprecated
public class XmpArray extends ArrayList<String> {
    private static final long X = 5722854116328732742L;
    public static final String X2 = "rdf:Alt";
    public static final String Y = "rdf:Bag";
    public static final String Z = "rdf:Seq";
    protected String s;

    public XmpArray(String str) {
        this.s = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("<");
        stringBuffer.append(this.s);
        stringBuffer.append('>');
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            stringBuffer.append("<rdf:li>");
            stringBuffer.append(XMLUtil.a((String) it2.next(), false));
            stringBuffer.append("</rdf:li>");
        }
        stringBuffer.append("</");
        stringBuffer.append(this.s);
        stringBuffer.append('>');
        return stringBuffer.toString();
    }
}
