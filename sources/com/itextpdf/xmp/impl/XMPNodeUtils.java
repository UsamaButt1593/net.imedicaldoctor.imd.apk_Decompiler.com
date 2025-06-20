package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPDateTime;
import com.itextpdf.xmp.XMPDateTimeFactory;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMetaFactory;
import com.itextpdf.xmp.XMPUtils;
import com.itextpdf.xmp.impl.xpath.XMPPath;
import com.itextpdf.xmp.impl.xpath.XMPPathSegment;
import com.itextpdf.xmp.options.PropertyOptions;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class XMPNodeUtils implements XMPConst {
    static final int X = 1;
    static final int X2 = 4;
    static final int Y = 2;
    static final int Y2 = 5;
    static final int Z = 3;
    static final /* synthetic */ boolean Z2 = false;
    static final int s = 0;

    private XMPNodeUtils() {
    }

    static void a(XMPNode xMPNode, String str, String str2) throws XMPException {
        XMPNode xMPNode2 = new XMPNode(XMPConst.o2, str2, (PropertyOptions) null);
        XMPNode xMPNode3 = new XMPNode(XMPConst.q2, str, (PropertyOptions) null);
        xMPNode2.c(xMPNode3);
        if (!"x-default".equals(xMPNode3.C())) {
            xMPNode.b(xMPNode2);
        } else {
            xMPNode.a(1, xMPNode2);
        }
    }

    static Object[] b(XMPNode xMPNode, String str, String str2) throws XMPException {
        if (xMPNode.v().u()) {
            XMPNode xMPNode2 = null;
            if (!xMPNode.D()) {
                return new Object[]{new Integer(0), null};
            }
            Iterator J = xMPNode.J();
            XMPNode xMPNode3 = null;
            int i2 = 0;
            while (J.hasNext()) {
                XMPNode xMPNode4 = (XMPNode) J.next();
                if (xMPNode4.v().x()) {
                    throw new XMPException("Alt-text array item is not simple", 102);
                } else if (!xMPNode4.E() || !XMPConst.q2.equals(xMPNode4.x(1).u())) {
                    throw new XMPException("Alt-text array item has no language qualifier", 102);
                } else {
                    String C = xMPNode4.x(1).C();
                    if (str2.equals(C)) {
                        return new Object[]{new Integer(1), xMPNode4};
                    } else if (str != null && C.startsWith(str)) {
                        if (xMPNode2 == null) {
                            xMPNode2 = xMPNode4;
                        }
                        i2++;
                    } else if ("x-default".equals(C)) {
                        xMPNode3 = xMPNode4;
                    }
                }
            }
            if (i2 == 1) {
                return new Object[]{new Integer(2), xMPNode2};
            } else if (i2 > 1) {
                return new Object[]{new Integer(3), xMPNode2};
            } else if (xMPNode3 != null) {
                return new Object[]{new Integer(4), xMPNode3};
            } else {
                return new Object[]{new Integer(5), xMPNode.o(1)};
            }
        } else {
            throw new XMPException("Localized text array is not alt-text", 102);
        }
    }

    static void c(XMPNode xMPNode) {
        XMPNode w = xMPNode.w();
        if (xMPNode.v().z()) {
            w.P(xMPNode);
        } else {
            w.N(xMPNode);
        }
        if (!w.D() && w.v().A()) {
            w.w().N(w);
        }
    }

    static void d(XMPNode xMPNode) {
        if (xMPNode.v().v() && xMPNode.D()) {
            Iterator J = xMPNode.J();
            while (J.hasNext()) {
                if (((XMPNode) J.next()).v().q()) {
                    xMPNode.v().G(true);
                    o(xMPNode);
                    return;
                }
            }
        }
    }

    static XMPNode e(XMPNode xMPNode, String str, boolean z) throws XMPException {
        if (!xMPNode.v().A() && !xMPNode.v().C()) {
            if (!xMPNode.G()) {
                throw new XMPException("Named children only allowed for schemas and structs", 102);
            } else if (xMPNode.v().t()) {
                throw new XMPException("Named children not allowed for arrays", 102);
            } else if (z) {
                xMPNode.v().O(true);
            }
        }
        XMPNode m2 = xMPNode.m(str);
        if (m2 != null || !z) {
            return m2;
        }
        XMPNode xMPNode2 = new XMPNode(str, new PropertyOptions());
        xMPNode2.W(true);
        xMPNode.b(xMPNode2);
        return xMPNode2;
    }

    private static int f(XMPNode xMPNode, String str, boolean z) throws XMPException {
        try {
            int parseInt = Integer.parseInt(str.substring(1, str.length() - 1));
            if (parseInt >= 1) {
                if (z && parseInt == xMPNode.q() + 1) {
                    XMPNode xMPNode2 = new XMPNode(XMPConst.o2, (PropertyOptions) null);
                    xMPNode2.W(true);
                    xMPNode.b(xMPNode2);
                }
                return parseInt;
            }
            throw new XMPException("Array index must be larger than zero", 102);
        } catch (NumberFormatException unused) {
            throw new XMPException("Array index not digits.", 102);
        }
    }

    static XMPNode g(XMPNode xMPNode, XMPPath xMPPath, boolean z, PropertyOptions propertyOptions) throws XMPException {
        XMPNode xMPNode2;
        if (xMPPath == null || xMPPath.c() == 0) {
            throw new XMPException("Empty XMPPath", 102);
        }
        XMPNode j2 = j(xMPNode, xMPPath.b(0).c(), z);
        if (j2 == null) {
            return null;
        }
        if (j2.G()) {
            j2.W(false);
            xMPNode2 = j2;
        } else {
            xMPNode2 = null;
        }
        int i2 = 1;
        while (i2 < xMPPath.c()) {
            try {
                j2 = k(j2, xMPPath.b(i2), z);
                if (j2 == null) {
                    if (z) {
                        c(xMPNode2);
                    }
                    return null;
                }
                if (j2.G()) {
                    j2.W(false);
                    if (i2 == 1 && xMPPath.b(i2).d() && xMPPath.b(i2).a() != 0) {
                        j2.v().n(xMPPath.b(i2).a(), true);
                    } else if (i2 < xMPPath.c() - 1 && xMPPath.b(i2).b() == 1 && !j2.v().x()) {
                        j2.v().O(true);
                    }
                    if (xMPNode2 == null) {
                        xMPNode2 = j2;
                    }
                }
                i2++;
            } catch (XMPException e2) {
                if (xMPNode2 != null) {
                    c(xMPNode2);
                }
                throw e2;
            }
        }
        if (xMPNode2 != null) {
            j2.v().E(propertyOptions);
            j2.a0(j2.v());
        }
        return j2;
    }

    private static XMPNode h(XMPNode xMPNode, String str, boolean z) throws XMPException {
        XMPNode n2 = xMPNode.n(str);
        if (n2 != null || !z) {
            return n2;
        }
        XMPNode xMPNode2 = new XMPNode(str, (PropertyOptions) null);
        xMPNode2.W(true);
        xMPNode.c(xMPNode2);
        return xMPNode2;
    }

    static XMPNode i(XMPNode xMPNode, String str, String str2, boolean z) throws XMPException {
        XMPNode m2 = xMPNode.m(str);
        if (m2 == null && z) {
            m2 = new XMPNode(str, new PropertyOptions().N(true));
            m2.W(true);
            String b2 = XMPMetaFactory.c().b(str);
            if (b2 == null) {
                if (str2 == null || str2.length() == 0) {
                    throw new XMPException("Unregistered schema namespace URI", 101);
                }
                b2 = XMPMetaFactory.c().g(str, str2);
            }
            m2.d0(b2);
            xMPNode.b(m2);
        }
        return m2;
    }

    static XMPNode j(XMPNode xMPNode, String str, boolean z) throws XMPException {
        return i(xMPNode, str, (String) null, z);
    }

    private static XMPNode k(XMPNode xMPNode, XMPPathSegment xMPPathSegment, boolean z) throws XMPException {
        int i2;
        int b2 = xMPPathSegment.b();
        if (b2 == 1) {
            return e(xMPNode, xMPPathSegment.c(), z);
        }
        if (b2 == 2) {
            return h(xMPNode, xMPPathSegment.c().substring(1), z);
        }
        if (xMPNode.v().t()) {
            if (b2 == 3) {
                i2 = f(xMPNode, xMPPathSegment.c(), z);
            } else if (b2 == 4) {
                i2 = xMPNode.q();
            } else if (b2 == 6) {
                String[] l2 = Utils.l(xMPPathSegment.c());
                i2 = l(xMPNode, l2[0], l2[1]);
            } else if (b2 == 5) {
                String[] l3 = Utils.l(xMPPathSegment.c());
                i2 = n(xMPNode, l3[0], l3[1], xMPPathSegment.a());
            } else {
                throw new XMPException("Unknown array indexing step in FollowXPathStep", 9);
            }
            if (1 > i2 || i2 > xMPNode.q()) {
                return null;
            }
            return xMPNode.o(i2);
        }
        throw new XMPException("Indexing applied to non-array", 102);
    }

    private static int l(XMPNode xMPNode, String str, String str2) throws XMPException {
        int i2 = -1;
        int i3 = 1;
        while (i3 <= xMPNode.q() && i2 < 0) {
            XMPNode o = xMPNode.o(i3);
            if (o.v().C()) {
                int i4 = 1;
                while (true) {
                    if (i4 > o.q()) {
                        break;
                    }
                    XMPNode o2 = o.o(i4);
                    if (str.equals(o2.u()) && str2.equals(o2.C())) {
                        i2 = i3;
                        break;
                    }
                    i4++;
                }
                i3++;
            } else {
                throw new XMPException("Field selector must be used on array of struct", 102);
            }
        }
        return i2;
    }

    static int m(XMPNode xMPNode, String str) throws XMPException {
        if (xMPNode.v().t()) {
            for (int i2 = 1; i2 <= xMPNode.q(); i2++) {
                XMPNode o = xMPNode.o(i2);
                if (o.E() && XMPConst.q2.equals(o.x(1).u()) && str.equals(o.x(1).C())) {
                    return i2;
                }
            }
            return -1;
        }
        throw new XMPException("Language item must be used on array", 102);
    }

    private static int n(XMPNode xMPNode, String str, String str2, int i2) throws XMPException {
        if (XMPConst.q2.equals(str)) {
            int m2 = m(xMPNode, Utils.j(str2));
            if (m2 >= 0 || (i2 & 4096) <= 0) {
                return m2;
            }
            XMPNode xMPNode2 = new XMPNode(XMPConst.o2, (PropertyOptions) null);
            xMPNode2.c(new XMPNode(XMPConst.q2, "x-default", (PropertyOptions) null));
            xMPNode.a(1, xMPNode2);
            return 1;
        }
        for (int i3 = 1; i3 < xMPNode.q(); i3++) {
            Iterator K = xMPNode.o(i3).K();
            while (K.hasNext()) {
                XMPNode xMPNode3 = (XMPNode) K.next();
                if (str.equals(xMPNode3.u()) && str2.equals(xMPNode3.C())) {
                    return i3;
                }
            }
        }
        return -1;
    }

    static void o(XMPNode xMPNode) {
        if (xMPNode.v().u()) {
            int i2 = 2;
            while (i2 <= xMPNode.q()) {
                XMPNode o = xMPNode.o(i2);
                if (!o.E() || !"x-default".equals(o.x(1).C())) {
                    i2++;
                } else {
                    try {
                        xMPNode.L(i2);
                        xMPNode.a(1, o);
                    } catch (XMPException unused) {
                    }
                    if (i2 == 2) {
                        xMPNode.o(2).d0(o.C());
                        return;
                    }
                    return;
                }
            }
        }
    }

    static String p(Object obj) {
        String str;
        XMPDateTime f2;
        if (obj == null) {
            str = null;
        } else if (obj instanceof Boolean) {
            str = XMPUtils.d(((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            str = XMPUtils.g(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            str = XMPUtils.h(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            str = XMPUtils.f(((Double) obj).doubleValue());
        } else {
            if (obj instanceof XMPDateTime) {
                f2 = (XMPDateTime) obj;
            } else if (obj instanceof GregorianCalendar) {
                f2 = XMPDateTimeFactory.f((GregorianCalendar) obj);
            } else {
                str = obj instanceof byte[] ? XMPUtils.o((byte[]) obj) : obj.toString();
            }
            str = XMPUtils.e(f2);
        }
        if (str != null) {
            return Utils.k(str);
        }
        return null;
    }

    static void q(XMPNode xMPNode, Object obj) {
        String p = p(obj);
        if (xMPNode.v().z() && XMPConst.q2.equals(xMPNode.u())) {
            p = Utils.j(p);
        }
        xMPNode.d0(p);
    }

    static PropertyOptions r(PropertyOptions propertyOptions, Object obj) throws XMPException {
        if (propertyOptions == null) {
            propertyOptions = new PropertyOptions();
        }
        if (propertyOptions.u()) {
            propertyOptions.H(true);
        }
        if (propertyOptions.v()) {
            propertyOptions.I(true);
        }
        if (propertyOptions.w()) {
            propertyOptions.F(true);
        }
        if (!propertyOptions.x() || obj == null || obj.toString().length() <= 0) {
            propertyOptions.a(propertyOptions.i());
            return propertyOptions;
        }
        throw new XMPException("Structs and arrays can't have values", 103);
    }
}
