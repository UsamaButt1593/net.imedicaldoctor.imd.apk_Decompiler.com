package com.itextpdf.xmp;

import com.itextpdf.xmp.impl.Utils;
import com.itextpdf.xmp.impl.xpath.XMPPath;
import com.itextpdf.xmp.impl.xpath.XMPPathParser;

public final class XMPPathFactory {
    private XMPPathFactory() {
    }

    private static void a(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty field namespace URI", 101);
        }
    }

    private static void b(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty f name", 102);
        }
    }

    private static void c(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty qualifier namespace URI", 101);
        }
    }

    private static void d(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty qualifier name", 102);
        }
    }

    public static String e(String str, int i2) throws XMPException {
        if (i2 > 0) {
            return str + '[' + i2 + ']';
        } else if (i2 == -1) {
            return str + "[last()]";
        } else {
            throw new XMPException("Array index must be larger than zero", 104);
        }
    }

    public static String f(String str, String str2, String str3, String str4) throws XMPException {
        XMPPath a2 = XMPPathParser.a(str2, str3);
        if (a2.c() == 2) {
            return str + '[' + a2.b(1).c() + "=\"" + str4 + "\"]";
        }
        throw new XMPException("The fieldName name must be simple", 102);
    }

    public static String g(String str, String str2) {
        return str + "[?xml:lang=\"" + Utils.j(str2) + "\"]";
    }

    public static String h(String str, String str2) throws XMPException {
        c(str);
        d(str2);
        XMPPath a2 = XMPPathParser.a(str, str2);
        if (a2.c() == 2) {
            return "/?" + a2.b(1).c();
        }
        throw new XMPException("The qualifier name must be simple", 102);
    }

    public static String i(String str, String str2) throws XMPException {
        a(str);
        b(str2);
        XMPPath a2 = XMPPathParser.a(str, str2);
        if (a2.c() == 2) {
            return '/' + a2.b(1).c();
        }
        throw new XMPException("The field name must be simple", 102);
    }
}
