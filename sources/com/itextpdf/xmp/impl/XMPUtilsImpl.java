package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.XMPMetaFactory;
import com.itextpdf.xmp.impl.xpath.XMPPath;
import com.itextpdf.xmp.impl.xpath.XMPPathParser;
import com.itextpdf.xmp.options.PropertyOptions;
import com.itextpdf.xmp.properties.XMPAliasInfo;
import java.util.Iterator;
import kotlin.text.Typography;

public class XMPUtilsImpl implements XMPConst {
    private static final int X = 1;
    private static final int X2 = 4;
    private static final int Y = 2;
    private static final int Y2 = 5;
    private static final int Z = 3;
    private static final String Z2 = " 　〿";
    private static final String a3 = ",，､﹐﹑、،՝";
    private static final String b3 = ";；﹔؛;";
    private static final String c3 = "\"«»〝〞〟―‹›";
    private static final String d3 = "  ";
    static final /* synthetic */ boolean e3 = false;
    private static final int s = 0;

    private XMPUtilsImpl() {
    }

    public static void a(XMPMeta xMPMeta, XMPMeta xMPMeta2, boolean z, boolean z2, boolean z3) throws XMPException {
        ParameterAsserts.b(xMPMeta);
        ParameterAsserts.b(xMPMeta2);
        XMPMetaImpl xMPMetaImpl = (XMPMetaImpl) xMPMeta2;
        Iterator J = ((XMPMetaImpl) xMPMeta).e().J();
        while (J.hasNext()) {
            XMPNode xMPNode = (XMPNode) J.next();
            boolean z4 = false;
            XMPNode j2 = XMPNodeUtils.j(xMPMetaImpl.e(), xMPNode.u(), false);
            if (j2 == null) {
                j2 = new XMPNode(xMPNode.u(), xMPNode.C(), new PropertyOptions().N(true));
                xMPMetaImpl.e().b(j2);
                z4 = true;
            }
            Iterator J2 = xMPNode.J();
            while (J2.hasNext()) {
                XMPNode xMPNode2 = (XMPNode) J2.next();
                if (z || !Utils.e(xMPNode.u(), xMPNode2.u())) {
                    b(xMPMetaImpl, xMPNode2, j2, z2, z3);
                }
            }
            if (!j2.D() && (z4 || z3)) {
                xMPMetaImpl.e().N(j2);
            }
        }
    }

    private static void b(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, XMPNode xMPNode2, boolean z, boolean z2) throws XMPException {
        XMPNode e2 = XMPNodeUtils.e(xMPNode2, xMPNode.u(), false);
        boolean z3 = z2 && (!xMPNode.v().B() ? !xMPNode.D() : xMPNode.C() == null || xMPNode.C().length() == 0);
        if (!z2 || !z3) {
            if (e2 != null) {
                if (z) {
                    xMPMetaImpl.f(e2, xMPNode.C(), xMPNode.v(), true);
                    xMPNode2.N(e2);
                } else {
                    PropertyOptions v = xMPNode.v();
                    if (v == e2.v()) {
                        if (v.C()) {
                            Iterator J = xMPNode.J();
                            while (J.hasNext()) {
                                b(xMPMetaImpl, (XMPNode) J.next(), e2, z, z2);
                                if (z2 && !e2.D()) {
                                    xMPNode2.N(e2);
                                }
                            }
                            return;
                        } else if (v.u()) {
                            Iterator J2 = xMPNode.J();
                            while (J2.hasNext()) {
                                XMPNode xMPNode3 = (XMPNode) J2.next();
                                if (xMPNode3.E() && XMPConst.q2.equals(xMPNode3.x(1).u())) {
                                    int m2 = XMPNodeUtils.m(e2, xMPNode3.x(1).C());
                                    if (!z2 || !(xMPNode3.C() == null || xMPNode3.C().length() == 0)) {
                                        if (m2 == -1) {
                                            if (!"x-default".equals(xMPNode3.x(1).C()) || !e2.D()) {
                                                xMPNode3.i(e2);
                                            } else {
                                                XMPNode xMPNode4 = new XMPNode(xMPNode3.u(), xMPNode3.C(), xMPNode3.v());
                                                xMPNode3.i(xMPNode4);
                                                e2.a(1, xMPNode4);
                                            }
                                        }
                                    } else if (m2 != -1) {
                                        e2.L(m2);
                                        if (!e2.D()) {
                                            xMPNode2.N(e2);
                                        }
                                    }
                                }
                            }
                            return;
                        } else if (v.t()) {
                            Iterator J3 = xMPNode.J();
                            while (J3.hasNext()) {
                                XMPNode xMPNode5 = (XMPNode) J3.next();
                                Iterator J4 = e2.J();
                                boolean z4 = false;
                                while (J4.hasNext()) {
                                    if (k(xMPNode5, (XMPNode) J4.next())) {
                                        z4 = true;
                                    }
                                }
                                if (!z4) {
                                    XMPNode xMPNode6 = (XMPNode) xMPNode5.clone();
                                    xMPNode2.b(xMPNode6);
                                    e2 = xMPNode6;
                                }
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            xMPNode2.b((XMPNode) xMPNode.clone());
        } else if (e2 != null) {
            xMPNode2.N(e2);
        }
    }

    private static String c(String str, char c2, char c4, boolean z) {
        if (str == null) {
            str = "";
        }
        int i2 = 0;
        boolean z2 = false;
        while (i2 < str.length()) {
            int g2 = g(str.charAt(i2));
            if (i2 == 0 && g2 == 4) {
                break;
            }
            if (g2 != 1) {
                if (g2 == 3 || g2 == 5 || (g2 == 2 && !z)) {
                    break;
                }
                z2 = false;
            } else if (z2) {
                break;
            } else {
                z2 = true;
            }
            i2++;
        }
        if (i2 >= str.length()) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 2);
        int i3 = 0;
        while (i3 <= i2 && g(str.charAt(i2)) != 4) {
            i3++;
        }
        stringBuffer.append(c2);
        stringBuffer.append(str.substring(0, i3));
        while (i3 < str.length()) {
            stringBuffer.append(str.charAt(i3));
            if (g(str.charAt(i3)) == 4 && j(str.charAt(i3), c2, c4)) {
                stringBuffer.append(str.charAt(i3));
            }
            i3++;
        }
        stringBuffer.append(c4);
        return stringBuffer.toString();
    }

    public static String d(XMPMeta xMPMeta, String str, String str2, String str3, String str4, boolean z) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.a(str2);
        ParameterAsserts.b(xMPMeta);
        if (str3 == null || str3.length() == 0) {
            str3 = "; ";
        }
        if (str4 == null || str4.length() == 0) {
            str4 = "\"";
        }
        XMPNode g2 = XMPNodeUtils.g(((XMPMetaImpl) xMPMeta).e(), XMPPathParser.a(str, str2), false, (PropertyOptions) null);
        if (g2 == null) {
            return "";
        }
        if (!g2.v().t() || g2.v().v()) {
            throw new XMPException("Named property must be non-alternate array", 4);
        }
        f(str3);
        char charAt = str4.charAt(0);
        char e2 = e(str4, charAt);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator J = g2.J();
        while (J.hasNext()) {
            XMPNode xMPNode = (XMPNode) J.next();
            if (!xMPNode.v().x()) {
                stringBuffer.append(c(xMPNode.C(), charAt, e2, z));
                if (J.hasNext()) {
                    stringBuffer.append(str3);
                }
            } else {
                throw new XMPException("Array items must be simple", 4);
            }
        }
        return stringBuffer.toString();
    }

    private static char e(String str, char c2) throws XMPException {
        char c4;
        if (g(c2) == 4) {
            if (str.length() == 1) {
                c4 = c2;
            } else {
                c4 = str.charAt(1);
                if (g(c4) != 4) {
                    throw new XMPException("Invalid quoting character", 4);
                }
            }
            if (c4 == h(c2)) {
                return c4;
            }
            throw new XMPException("Mismatched quote pair", 4);
        }
        throw new XMPException("Invalid quoting character", 4);
    }

    private static void f(String str) throws XMPException {
        boolean z = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int g2 = g(str.charAt(i2));
            if (g2 == 3) {
                if (!z) {
                    z = true;
                } else {
                    throw new XMPException("Separator can have only one semicolon", 4);
                }
            } else if (g2 != 1) {
                throw new XMPException("Separator can have only spaces and one semicolon", 4);
            }
        }
        if (!z) {
            throw new XMPException("Separator must have one semicolon", 4);
        }
    }

    private static int g(char c2) {
        if (Z2.indexOf(c2) >= 0) {
            return 1;
        }
        if (8192 <= c2 && c2 <= 8203) {
            return 1;
        }
        if (a3.indexOf(c2) >= 0) {
            return 2;
        }
        if (b3.indexOf(c2) >= 0) {
            return 3;
        }
        if (c3.indexOf(c2) >= 0) {
            return 4;
        }
        if (12296 <= c2 && c2 <= 12303) {
            return 4;
        }
        if (8216 > c2 || c2 > 8223) {
            return (c2 < ' ' || d3.indexOf(c2) >= 0) ? 5 : 0;
        }
        return 4;
    }

    private static char h(char c2) {
        switch (c2) {
            case '\"':
                return '\"';
            case 171:
                return 187;
            case 187:
                return 171;
            case 8213:
                return 8213;
            case 8216:
                return Typography.x;
            case 8218:
                return 8219;
            case 8220:
                return Typography.A;
            case 8222:
                return 8223;
            case 8249:
                return 8250;
            case 8250:
                return 8249;
            case 12296:
                return 12297;
            case 12298:
                return 12299;
            case 12300:
                return 12301;
            case 12302:
                return 12303;
            case 12317:
                return 12319;
            default:
                return 0;
        }
    }

    private static boolean i(char c2, char c4, char c5) {
        return c2 == c5 || (c4 == 12317 && c2 == 12318) || c2 == 12319;
    }

    private static boolean j(char c2, char c4, char c5) {
        return c2 == c4 || i(c2, c4, c5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean k(com.itextpdf.xmp.impl.XMPNode r5, com.itextpdf.xmp.impl.XMPNode r6) throws com.itextpdf.xmp.XMPException {
        /*
            com.itextpdf.xmp.options.PropertyOptions r0 = r5.v()
            com.itextpdf.xmp.options.PropertyOptions r1 = r6.v()
            boolean r1 = r0.equals(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0010
            return r2
        L_0x0010:
            int r1 = r0.i()
            r3 = 1
            if (r1 != 0) goto L_0x005a
            java.lang.String r0 = r5.C()
            java.lang.String r1 = r6.C()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0026
            return r2
        L_0x0026:
            com.itextpdf.xmp.options.PropertyOptions r0 = r5.v()
            boolean r0 = r0.q()
            com.itextpdf.xmp.options.PropertyOptions r1 = r6.v()
            boolean r1 = r1.q()
            if (r0 == r1) goto L_0x0039
            return r2
        L_0x0039:
            com.itextpdf.xmp.options.PropertyOptions r0 = r5.v()
            boolean r0 = r0.q()
            if (r0 == 0) goto L_0x00b4
            com.itextpdf.xmp.impl.XMPNode r5 = r5.x(r3)
            java.lang.String r5 = r5.C()
            com.itextpdf.xmp.impl.XMPNode r6 = r6.x(r3)
            java.lang.String r6 = r6.C()
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00b4
            return r2
        L_0x005a:
            boolean r0 = r0.C()
            if (r0 == 0) goto L_0x008c
            int r0 = r5.q()
            int r1 = r6.q()
            if (r0 == r1) goto L_0x006b
            return r2
        L_0x006b:
            java.util.Iterator r5 = r5.J()
        L_0x006f:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00b4
            java.lang.Object r0 = r5.next()
            com.itextpdf.xmp.impl.XMPNode r0 = (com.itextpdf.xmp.impl.XMPNode) r0
            java.lang.String r1 = r0.u()
            com.itextpdf.xmp.impl.XMPNode r1 = com.itextpdf.xmp.impl.XMPNodeUtils.e(r6, r1, r2)
            if (r1 == 0) goto L_0x008b
            boolean r0 = k(r0, r1)
            if (r0 != 0) goto L_0x006f
        L_0x008b:
            return r2
        L_0x008c:
            java.util.Iterator r5 = r5.J()
        L_0x0090:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00b4
            java.lang.Object r0 = r5.next()
            com.itextpdf.xmp.impl.XMPNode r0 = (com.itextpdf.xmp.impl.XMPNode) r0
            java.util.Iterator r1 = r6.J()
        L_0x00a0:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00b3
            java.lang.Object r4 = r1.next()
            com.itextpdf.xmp.impl.XMPNode r4 = (com.itextpdf.xmp.impl.XMPNode) r4
            boolean r4 = k(r0, r4)
            if (r4 == 0) goto L_0x00a0
            goto L_0x0090
        L_0x00b3:
            return r2
        L_0x00b4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.XMPUtilsImpl.k(com.itextpdf.xmp.impl.XMPNode, com.itextpdf.xmp.impl.XMPNode):boolean");
    }

    public static void l(XMPMeta xMPMeta, String str, String str2, boolean z, boolean z2) throws XMPException {
        ParameterAsserts.b(xMPMeta);
        XMPMetaImpl xMPMetaImpl = (XMPMetaImpl) xMPMeta;
        if (str2 == null || str2.length() <= 0) {
            if (str == null || str.length() <= 0) {
                Iterator J = xMPMetaImpl.e().J();
                while (J.hasNext()) {
                    if (m((XMPNode) J.next(), z)) {
                        J.remove();
                    }
                }
                return;
            }
            XMPNode j2 = XMPNodeUtils.j(xMPMetaImpl.e(), str, false);
            if (j2 != null && m(j2, z)) {
                xMPMetaImpl.e().N(j2);
            }
            if (z2) {
                XMPAliasInfo[] i2 = XMPMetaFactory.c().i(str);
                for (XMPAliasInfo xMPAliasInfo : i2) {
                    XMPNode g2 = XMPNodeUtils.g(xMPMetaImpl.e(), XMPPathParser.a(xMPAliasInfo.a(), xMPAliasInfo.c()), false, (PropertyOptions) null);
                    if (g2 != null) {
                        g2.w().N(g2);
                    }
                }
            }
        } else if (str == null || str.length() == 0) {
            throw new XMPException("Property name requires schema namespace", 4);
        } else {
            XMPPath a2 = XMPPathParser.a(str, str2);
            XMPNode g3 = XMPNodeUtils.g(xMPMetaImpl.e(), a2, false, (PropertyOptions) null);
            if (g3 == null) {
                return;
            }
            if (z || !Utils.e(a2.b(0).c(), a2.b(1).c())) {
                XMPNode w = g3.w();
                w.N(g3);
                if (w.v().A() && !w.D()) {
                    w.w().N(w);
                }
            }
        }
    }

    private static boolean m(XMPNode xMPNode, boolean z) {
        Iterator J = xMPNode.J();
        while (J.hasNext()) {
            XMPNode xMPNode2 = (XMPNode) J.next();
            if (z || !Utils.e(xMPNode.u(), xMPNode2.u())) {
                J.remove();
            }
        }
        return !xMPNode.D();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        r1 = r11.charAt(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void n(com.itextpdf.xmp.XMPMeta r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, com.itextpdf.xmp.options.PropertyOptions r12, boolean r13) throws com.itextpdf.xmp.XMPException {
        /*
            com.itextpdf.xmp.impl.ParameterAsserts.f(r9)
            com.itextpdf.xmp.impl.ParameterAsserts.a(r10)
            r0 = 4
            if (r11 == 0) goto L_0x00f6
            com.itextpdf.xmp.impl.ParameterAsserts.b(r8)
            com.itextpdf.xmp.impl.XMPMetaImpl r8 = (com.itextpdf.xmp.impl.XMPMetaImpl) r8
            com.itextpdf.xmp.impl.XMPNode r8 = o(r9, r10, r12, r8)
            int r9 = r11.length()
            r10 = 0
            r12 = 0
            r1 = 0
        L_0x0019:
            if (r10 >= r9) goto L_0x00f5
        L_0x001b:
            if (r10 >= r9) goto L_0x002d
            char r1 = r11.charAt(r10)
            int r12 = g(r1)
            if (r12 == 0) goto L_0x002d
            if (r12 != r0) goto L_0x002a
            goto L_0x002d
        L_0x002a:
            int r10 = r10 + 1
            goto L_0x001b
        L_0x002d:
            if (r10 < r9) goto L_0x0031
            goto L_0x00f5
        L_0x0031:
            r2 = 1
            if (r12 == r0) goto L_0x0069
            r3 = r10
        L_0x0035:
            if (r3 >= r9) goto L_0x0063
            char r1 = r11.charAt(r3)
            int r12 = g(r1)
            if (r12 == 0) goto L_0x0060
            if (r12 == r0) goto L_0x0060
            r4 = 2
            if (r12 != r4) goto L_0x0049
            if (r13 == 0) goto L_0x0049
            goto L_0x0060
        L_0x0049:
            if (r12 == r2) goto L_0x004c
            goto L_0x0063
        L_0x004c:
            int r5 = r3 + 1
            if (r5 >= r9) goto L_0x0063
            char r1 = r11.charAt(r5)
            int r5 = g(r1)
            if (r5 == 0) goto L_0x0060
            if (r5 == r0) goto L_0x0060
            if (r5 != r4) goto L_0x0063
            if (r13 == 0) goto L_0x0063
        L_0x0060:
            int r3 = r3 + 1
            goto L_0x0035
        L_0x0063:
            java.lang.String r10 = r11.substring(r10, r3)
            goto L_0x00cc
        L_0x0069:
            char r3 = h(r1)
            int r10 = r10 + 1
            java.lang.String r4 = ""
            r5 = r1
        L_0x0072:
            if (r10 >= r9) goto L_0x00c9
            char r5 = r11.charAt(r10)
            int r12 = g(r5)
            if (r12 != r0) goto L_0x00c1
            boolean r6 = j(r5, r1, r3)
            if (r6 != 0) goto L_0x0085
            goto L_0x00c1
        L_0x0085:
            int r6 = r10 + 1
            if (r6 >= r9) goto L_0x0091
            char r7 = r11.charAt(r6)
            g(r7)
            goto L_0x0093
        L_0x0091:
            r7 = 59
        L_0x0093:
            if (r5 != r7) goto L_0x00a7
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r5)
            java.lang.String r10 = r10.toString()
            r4 = r10
            r10 = r6
            goto L_0x00c7
        L_0x00a7:
            boolean r7 = i(r5, r1, r3)
            if (r7 != 0) goto L_0x00bd
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
        L_0x00b2:
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            goto L_0x00c7
        L_0x00bd:
            r10 = r4
            r1 = r5
            r3 = r6
            goto L_0x00cc
        L_0x00c1:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            goto L_0x00b2
        L_0x00c7:
            int r10 = r10 + r2
            goto L_0x0072
        L_0x00c9:
            r3 = r10
            r10 = r4
            r1 = r5
        L_0x00cc:
            int r4 = r8.q()
            if (r2 > r4) goto L_0x00e4
            com.itextpdf.xmp.impl.XMPNode r4 = r8.o(r2)
            java.lang.String r4 = r4.C()
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x00e1
            goto L_0x00e5
        L_0x00e1:
            int r2 = r2 + 1
            goto L_0x00cc
        L_0x00e4:
            r2 = -1
        L_0x00e5:
            if (r2 >= 0) goto L_0x00f2
            com.itextpdf.xmp.impl.XMPNode r2 = new com.itextpdf.xmp.impl.XMPNode
            java.lang.String r4 = "[]"
            r5 = 0
            r2.<init>(r4, r10, r5)
            r8.b(r2)
        L_0x00f2:
            r10 = r3
            goto L_0x0019
        L_0x00f5:
            return
        L_0x00f6:
            com.itextpdf.xmp.XMPException r8 = new com.itextpdf.xmp.XMPException
            java.lang.String r9 = "Parameter must not be null"
            r8.<init>(r9, r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.XMPUtilsImpl.n(com.itextpdf.xmp.XMPMeta, java.lang.String, java.lang.String, java.lang.String, com.itextpdf.xmp.options.PropertyOptions, boolean):void");
    }

    private static XMPNode o(String str, String str2, PropertyOptions propertyOptions, XMPMetaImpl xMPMetaImpl) throws XMPException {
        PropertyOptions r = XMPNodeUtils.r(propertyOptions, (Object) null);
        if (r.y()) {
            XMPPath a2 = XMPPathParser.a(str, str2);
            XMPNode g2 = XMPNodeUtils.g(xMPMetaImpl.e(), a2, false, (PropertyOptions) null);
            if (g2 != null) {
                PropertyOptions v = g2.v();
                if (!v.t() || v.v()) {
                    throw new XMPException("Named property must be non-alternate array", 102);
                } else if (r.p(v)) {
                    throw new XMPException("Mismatch of specified and existing array form", 102);
                }
            } else {
                g2 = XMPNodeUtils.g(xMPMetaImpl.e(), a2, true, r.F(true));
                if (g2 == null) {
                    throw new XMPException("Failed to create named array", 102);
                }
            }
            return g2;
        }
        throw new XMPException("Options can only provide array form", 103);
    }
}
