package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;

class ParameterAsserts implements XMPConst {
    private ParameterAsserts() {
    }

    public static void a(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty array name", 4);
        }
    }

    public static void b(XMPMeta xMPMeta) throws XMPException {
        if (xMPMeta == null) {
            throw new XMPException("Parameter must not be null", 4);
        } else if (!(xMPMeta instanceof XMPMetaImpl)) {
            throw new XMPException("The XMPMeta-object is not compatible with this implementation", 4);
        }
    }

    public static void c(Object obj) throws XMPException {
        if (obj == null) {
            throw new XMPException("Parameter must not be null", 4);
        } else if ((obj instanceof String) && ((String) obj).length() == 0) {
            throw new XMPException("Parameter must not be null or empty", 4);
        }
    }

    public static void d(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty prefix", 4);
        }
    }

    public static void e(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty property name", 4);
        }
    }

    public static void f(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty schema namespace URI", 4);
        }
    }

    public static void g(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty specific language", 4);
        }
    }

    public static void h(String str) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Empty array name", 4);
        }
    }
}
