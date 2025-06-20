package com.itextpdf.xmp;

import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.xmp.impl.Base64;
import com.itextpdf.xmp.impl.ISO8601Converter;
import com.itextpdf.xmp.impl.XMPUtilsImpl;
import com.itextpdf.xmp.options.PropertyOptions;
import kotlinx.coroutines.DebugKt;

public class XMPUtils {
    private XMPUtils() {
    }

    public static void a(XMPMeta xMPMeta, XMPMeta xMPMeta2, boolean z, boolean z2) throws XMPException {
        b(xMPMeta, xMPMeta2, z, z2, false);
    }

    public static void b(XMPMeta xMPMeta, XMPMeta xMPMeta2, boolean z, boolean z2, boolean z3) throws XMPException {
        XMPUtilsImpl.a(xMPMeta, xMPMeta2, z, z2, z3);
    }

    public static String c(XMPMeta xMPMeta, String str, String str2, String str3, String str4, boolean z) throws XMPException {
        return XMPUtilsImpl.d(xMPMeta, str, str2, str3, str4, z);
    }

    public static String d(boolean z) {
        return z ? XMPConst.l2 : XMPConst.m2;
    }

    public static String e(XMPDateTime xMPDateTime) {
        return ISO8601Converter.c(xMPDateTime);
    }

    public static String f(double d2) {
        return String.valueOf(d2);
    }

    public static String g(int i2) {
        return String.valueOf(i2);
    }

    public static String h(long j2) {
        return String.valueOf(j2);
    }

    public static boolean i(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty convert-string", 5);
        }
        String lowerCase = str.toLowerCase();
        try {
            return Integer.parseInt(lowerCase) != 0;
        } catch (NumberFormatException unused) {
            return PdfBoolean.l3.equals(lowerCase) || "t".equals(lowerCase) || DebugKt.f29173d.equals(lowerCase) || "yes".equals(lowerCase);
        }
    }

    public static XMPDateTime j(String str) throws XMPException {
        if (str != null && str.length() != 0) {
            return ISO8601Converter.a(str);
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static double k(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return Double.parseDouble(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid double string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static int l(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return str.startsWith("0x") ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid integer string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static long m(String str) throws XMPException {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return str.startsWith("0x") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
                }
            } catch (NumberFormatException unused) {
                throw new XMPException("Invalid long string", 5);
            }
        }
        throw new XMPException("Empty convert-string", 5);
    }

    public static byte[] n(String str) throws XMPException {
        try {
            return Base64.b(str.getBytes());
        } catch (Throwable th) {
            throw new XMPException("Invalid base64 string", 5, th);
        }
    }

    public static String o(byte[] bArr) {
        return new String(Base64.d(bArr));
    }

    public static void p(XMPMeta xMPMeta, String str, String str2, boolean z, boolean z2) throws XMPException {
        XMPUtilsImpl.l(xMPMeta, str, str2, z, z2);
    }

    public static void q(XMPMeta xMPMeta, String str, String str2, String str3, PropertyOptions propertyOptions, boolean z) throws XMPException {
        XMPUtilsImpl.n(xMPMeta, str, str2, str3, propertyOptions, z);
    }
}
