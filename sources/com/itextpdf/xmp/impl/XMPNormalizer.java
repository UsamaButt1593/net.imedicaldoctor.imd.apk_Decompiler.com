package com.itextpdf.xmp.impl;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.text.xml.xmp.DublinCoreSchema;
import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPDateTime;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.XMPMetaFactory;
import com.itextpdf.xmp.XMPUtils;
import com.itextpdf.xmp.impl.xpath.XMPPathParser;
import com.itextpdf.xmp.options.ParseOptions;
import com.itextpdf.xmp.options.PropertyOptions;
import com.itextpdf.xmp.properties.XMPAliasInfo;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class XMPNormalizer {

    /* renamed from: a  reason: collision with root package name */
    private static Map f27764a;

    static {
        d();
    }

    private XMPNormalizer() {
    }

    private static void a(XMPNode xMPNode, XMPNode xMPNode2, boolean z) throws XMPException {
        if (!xMPNode.C().equals(xMPNode2.C()) || xMPNode.q() != xMPNode2.q()) {
            throw new XMPException("Mismatch between alias and base nodes", 203);
        } else if (z || (xMPNode.u().equals(xMPNode2.u()) && xMPNode.v().equals(xMPNode2.v()) && xMPNode.z() == xMPNode2.z())) {
            Iterator J = xMPNode.J();
            Iterator J2 = xMPNode2.J();
            while (J.hasNext() && J2.hasNext()) {
                a((XMPNode) J.next(), (XMPNode) J2.next(), false);
            }
            Iterator K = xMPNode.K();
            Iterator K2 = xMPNode2.K();
            while (K.hasNext() && K2.hasNext()) {
                a((XMPNode) K.next(), (XMPNode) K2.next(), false);
            }
        } else {
            throw new XMPException("Mismatch between alias and base nodes", 203);
        }
    }

    private static void b(XMPNode xMPNode) {
        Iterator J = xMPNode.J();
        while (J.hasNext()) {
            if (!((XMPNode) J.next()).D()) {
                J.remove();
            }
        }
    }

    private static void c(XMPNode xMPNode) throws XMPException {
        XMPNode e2 = XMPNodeUtils.e(xMPNode, "exif:GPSTimeStamp", false);
        if (e2 != null) {
            try {
                XMPDateTime j2 = XMPUtils.j(e2.C());
                if (j2.M0() != 0 || j2.W0() != 0) {
                    return;
                }
                if (j2.g1() == 0) {
                    XMPNode e3 = XMPNodeUtils.e(xMPNode, "exif:DateTimeOriginal", false);
                    if (e3 == null) {
                        e3 = XMPNodeUtils.e(xMPNode, "exif:DateTimeDigitized", false);
                    }
                    XMPDateTime j3 = XMPUtils.j(e3.C());
                    Calendar o0 = j2.o0();
                    o0.set(1, j3.M0());
                    o0.set(2, j3.W0());
                    o0.set(5, j3.g1());
                    e2.d0(XMPUtils.e(new XMPDateTimeImpl(o0)));
                }
            } catch (XMPException unused) {
            }
        }
    }

    private static void d() {
        f27764a = new HashMap();
        PropertyOptions propertyOptions = new PropertyOptions();
        propertyOptions.F(true);
        f27764a.put(DublinCoreSchema.Y2, propertyOptions);
        f27764a.put(DublinCoreSchema.f3, propertyOptions);
        f27764a.put(DublinCoreSchema.g3, propertyOptions);
        f27764a.put(DublinCoreSchema.h3, propertyOptions);
        f27764a.put(DublinCoreSchema.k3, propertyOptions);
        f27764a.put(DublinCoreSchema.m3, propertyOptions);
        PropertyOptions propertyOptions2 = new PropertyOptions();
        propertyOptions2.F(true);
        propertyOptions2.I(true);
        f27764a.put(DublinCoreSchema.a3, propertyOptions2);
        f27764a.put(DublinCoreSchema.b3, propertyOptions2);
        PropertyOptions propertyOptions3 = new PropertyOptions();
        propertyOptions3.F(true);
        propertyOptions3.I(true);
        propertyOptions3.H(true);
        propertyOptions3.G(true);
        f27764a.put(DublinCoreSchema.c3, propertyOptions3);
        f27764a.put(DublinCoreSchema.i3, propertyOptions3);
        f27764a.put(DublinCoreSchema.l3, propertyOptions3);
    }

    private static void e(XMPMeta xMPMeta, XMPNode xMPNode) {
        String str;
        try {
            XMPNode j2 = XMPNodeUtils.j(((XMPMetaImpl) xMPMeta).e(), "http://purl.org/dc/elements/1.1/", true);
            String C = xMPNode.C();
            XMPNode e2 = XMPNodeUtils.e(j2, DublinCoreSchema.i3, false);
            if (e2 != null) {
                if (e2.D()) {
                    int m2 = XMPNodeUtils.m(e2, "x-default");
                    if (m2 < 0) {
                        xMPMeta.P0("http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27405k, "", "x-default", e2.o(1).C(), (PropertyOptions) null);
                        m2 = XMPNodeUtils.m(e2, "x-default");
                    }
                    XMPNode o = e2.o(m2);
                    String C2 = o.C();
                    int indexOf = C2.indexOf("\n\n");
                    if (indexOf < 0) {
                        if (!C.equals(C2)) {
                            str = C2 + "\n\n" + C;
                        }
                        xMPNode.w().N(xMPNode);
                    }
                    int i2 = indexOf + 2;
                    if (!C2.substring(i2).equals(C)) {
                        str = C2.substring(0, i2) + C;
                    }
                    xMPNode.w().N(xMPNode);
                    o.d0(str);
                    xMPNode.w().N(xMPNode);
                }
            }
            xMPMeta.P0("http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27405k, "", "x-default", "\n\n" + C, (PropertyOptions) null);
            xMPNode.w().N(xMPNode);
        } catch (XMPException unused) {
        }
    }

    private static void f(XMPNode xMPNode, ParseOptions parseOptions) throws XMPException {
        if (xMPNode.r()) {
            xMPNode.T(false);
            boolean t = parseOptions.t();
            for (XMPNode xMPNode2 : xMPNode.A()) {
                if (xMPNode2.r()) {
                    Iterator J = xMPNode2.J();
                    while (J.hasNext()) {
                        XMPNode xMPNode3 = (XMPNode) J.next();
                        if (xMPNode3.F()) {
                            xMPNode3.S(false);
                            XMPAliasInfo h2 = XMPMetaFactory.c().h(xMPNode3.u());
                            if (h2 != null) {
                                XMPNode xMPNode4 = null;
                                XMPNode i2 = XMPNodeUtils.i(xMPNode, h2.a(), (String) null, true);
                                i2.W(false);
                                XMPNode e2 = XMPNodeUtils.e(i2, h2.b() + h2.c(), false);
                                if (e2 == null) {
                                    if (h2.d().t()) {
                                        xMPNode3.Z(h2.b() + h2.c());
                                        i2.b(xMPNode3);
                                    } else {
                                        XMPNode xMPNode5 = new XMPNode(h2.b() + h2.c(), h2.d().y());
                                        i2.b(xMPNode5);
                                        k(J, xMPNode3, xMPNode5);
                                    }
                                } else if (!h2.d().t()) {
                                    if (h2.d().q()) {
                                        int m2 = XMPNodeUtils.m(e2, "x-default");
                                        if (m2 != -1) {
                                            xMPNode4 = e2.o(m2);
                                        }
                                    } else if (e2.D()) {
                                        xMPNode4 = e2.o(1);
                                    }
                                    if (xMPNode4 == null) {
                                        k(J, xMPNode3, e2);
                                    } else if (t) {
                                        a(xMPNode3, xMPNode4, true);
                                    }
                                } else if (t) {
                                    a(xMPNode3, e2, true);
                                }
                                J.remove();
                            }
                        }
                    }
                    xMPNode2.T(false);
                }
            }
        }
    }

    private static void g(XMPNode xMPNode) throws XMPException {
        for (int i2 = 1; i2 <= xMPNode.q(); i2++) {
            XMPNode o = xMPNode.o(i2);
            PropertyOptions propertyOptions = (PropertyOptions) f27764a.get(o.u());
            if (propertyOptions != null) {
                if (o.v().B()) {
                    XMPNode xMPNode2 = new XMPNode(o.u(), propertyOptions);
                    o.Z(XMPConst.o2);
                    xMPNode2.b(o);
                    xMPNode.R(i2, xMPNode2);
                    if (propertyOptions.u() && !o.v().q()) {
                        o.c(new XMPNode(XMPConst.q2, "x-default", (PropertyOptions) null));
                    }
                } else {
                    o.v().n(7680, false);
                    o.v().E(propertyOptions);
                    if (propertyOptions.u()) {
                        i(o);
                    }
                }
            }
        }
    }

    static XMPMeta h(XMPMetaImpl xMPMetaImpl, ParseOptions parseOptions) throws XMPException {
        XMPNode e2 = xMPMetaImpl.e();
        j(xMPMetaImpl);
        f(e2, parseOptions);
        l(e2);
        b(e2);
        return xMPMetaImpl;
    }

    private static void i(XMPNode xMPNode) throws XMPException {
        if (xMPNode != null && xMPNode.v().t()) {
            xMPNode.v().I(true).H(true).G(true);
            Iterator J = xMPNode.J();
            while (J.hasNext()) {
                XMPNode xMPNode2 = (XMPNode) J.next();
                if (!xMPNode2.v().x()) {
                    if (!xMPNode2.v().q()) {
                        String C = xMPNode2.C();
                        if (!(C == null || C.length() == 0)) {
                            xMPNode2.c(new XMPNode(XMPConst.q2, "x-repair", (PropertyOptions) null));
                        }
                    }
                }
                J.remove();
            }
        }
    }

    private static void j(XMPMetaImpl xMPMetaImpl) throws XMPException {
        XMPNode e2;
        XMPNodeUtils.j(xMPMetaImpl.e(), "http://purl.org/dc/elements/1.1/", true);
        Iterator J = xMPMetaImpl.e().J();
        while (J.hasNext()) {
            XMPNode xMPNode = (XMPNode) J.next();
            if ("http://purl.org/dc/elements/1.1/".equals(xMPNode.u())) {
                g(xMPNode);
            } else {
                if (XMPConst.F1.equals(xMPNode.u())) {
                    c(xMPNode);
                    e2 = XMPNodeUtils.e(xMPNode, "exif:UserComment", false);
                    if (e2 == null) {
                    }
                } else if (XMPConst.W1.equals(xMPNode.u())) {
                    XMPNode e3 = XMPNodeUtils.e(xMPNode, "xmpDM:copyright", false);
                    if (e3 != null) {
                        e(xMPMetaImpl, e3);
                    }
                } else if (XMPConst.p1.equals(xMPNode.u())) {
                    e2 = XMPNodeUtils.e(xMPNode, "xmpRights:UsageTerms", false);
                    if (e2 == null) {
                    }
                }
                i(e2);
            }
        }
    }

    private static void k(Iterator it2, XMPNode xMPNode, XMPNode xMPNode2) throws XMPException {
        if (xMPNode2.v().u()) {
            if (!xMPNode.v().q()) {
                xMPNode.c(new XMPNode(XMPConst.q2, "x-default", (PropertyOptions) null));
            } else {
                throw new XMPException("Alias to x-default already has a language qualifier", 203);
            }
        }
        it2.remove();
        xMPNode.Z(XMPConst.o2);
        xMPNode2.b(xMPNode);
    }

    private static void l(XMPNode xMPNode) throws XMPException {
        if (xMPNode.u() != null && xMPNode.u().length() >= 36) {
            String lowerCase = xMPNode.u().toLowerCase();
            if (lowerCase.startsWith("uuid:")) {
                lowerCase = lowerCase.substring(5);
            }
            if (Utils.a(lowerCase)) {
                XMPNode g2 = XMPNodeUtils.g(xMPNode, XMPPathParser.a("http://ns.adobe.com/xap/1.0/mm/", "InstanceID"), true, (PropertyOptions) null);
                if (g2 != null) {
                    g2.a0((PropertyOptions) null);
                    g2.d0("uuid:" + lowerCase);
                    g2.O();
                    g2.Q();
                    xMPNode.Z((String) null);
                    return;
                }
                throw new XMPException("Failure creating xmpMM:InstanceID", 9);
            }
        }
    }
}
