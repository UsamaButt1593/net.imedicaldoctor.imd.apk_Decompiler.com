package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPDateTime;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPIterator;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.XMPPathFactory;
import com.itextpdf.xmp.XMPUtils;
import com.itextpdf.xmp.impl.xpath.XMPPath;
import com.itextpdf.xmp.impl.xpath.XMPPathParser;
import com.itextpdf.xmp.options.IteratorOptions;
import com.itextpdf.xmp.options.ParseOptions;
import com.itextpdf.xmp.options.PropertyOptions;
import com.itextpdf.xmp.properties.XMPProperty;
import java.util.Calendar;

public class XMPMetaImpl implements XMPMeta, XMPConst {
    private static final int X2 = 2;
    private static final int Y = 0;
    private static final int Y2 = 3;
    private static final int Z = 1;
    private static final int Z2 = 4;
    private static final int a3 = 5;
    private static final int b3 = 6;
    private static final int c3 = 7;
    static final /* synthetic */ boolean d3 = false;
    private String X;
    private XMPNode s;

    public XMPMetaImpl() {
        this.X = null;
        this.s = new XMPNode((String) null, (String) null, (PropertyOptions) null);
    }

    private void a(XMPNode xMPNode, int i2, String str, PropertyOptions propertyOptions, boolean z) throws XMPException {
        XMPNode xMPNode2 = new XMPNode(XMPConst.o2, (PropertyOptions) null);
        PropertyOptions r = XMPNodeUtils.r(propertyOptions, str);
        int q = xMPNode.q();
        if (z) {
            q++;
        }
        if (i2 == -1) {
            i2 = q;
        }
        if (1 > i2 || i2 > q) {
            throw new XMPException("Array index out of bounds", 104);
        }
        if (!z) {
            xMPNode.L(i2);
        }
        xMPNode.a(i2, xMPNode2);
        f(xMPNode2, str, r, false);
    }

    private Object b(int i2, XMPNode xMPNode) throws XMPException {
        Object bool;
        String C = xMPNode.C();
        switch (i2) {
            case 1:
                bool = new Boolean(XMPUtils.i(C));
                break;
            case 2:
                bool = new Integer(XMPUtils.l(C));
                break;
            case 3:
                bool = new Long(XMPUtils.m(C));
                break;
            case 4:
                bool = new Double(XMPUtils.k(C));
                break;
            case 5:
                return XMPUtils.j(C);
            case 6:
                return XMPUtils.j(C).o0();
            case 7:
                return XMPUtils.n(C);
            default:
                return (C != null || xMPNode.v().x()) ? C : "";
        }
        return bool;
    }

    public void A0(String str, String str2, Calendar calendar, PropertyOptions propertyOptions) throws XMPException {
        X0(str, str2, calendar, propertyOptions);
    }

    public void B0(String str, String str2, Calendar calendar) throws XMPException {
        X0(str, str2, calendar, (PropertyOptions) null);
    }

    public Boolean B1(String str, String str2) throws XMPException {
        return (Boolean) d(str, str2, 1);
    }

    public void C(String str, String str2, String str3, String str4, String str5, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.e(str2);
        if (V0(str, str2)) {
            X0(str, str2 + XMPPathFactory.h(str3, str4), str5, propertyOptions);
            return;
        }
        throw new XMPException("Specified property does not exist!", 102);
    }

    public void D2(String str, String str2, byte[] bArr, PropertyOptions propertyOptions) throws XMPException {
        X0(str, str2, bArr, propertyOptions);
    }

    public void E1(String str, String str2, int i2, PropertyOptions propertyOptions) throws XMPException {
        X0(str, str2, new Integer(i2), propertyOptions);
    }

    public XMPProperty G1(String str, String str2, String str3, String str4) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.e(str2);
        return h2(str, str2 + XMPPathFactory.h(str3, str4));
    }

    public XMPProperty H(String str, String str2, String str3, String str4) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.a(str2);
        ParameterAsserts.g(str4);
        String j2 = str3 != null ? Utils.j(str3) : null;
        String j3 = Utils.j(str4);
        XMPNode g2 = XMPNodeUtils.g(this.s, XMPPathParser.a(str, str2), false, (PropertyOptions) null);
        if (g2 == null) {
            return null;
        }
        Object[] b2 = XMPNodeUtils.b(g2, j2, j3);
        int intValue = ((Integer) b2[0]).intValue();
        final XMPNode xMPNode = (XMPNode) b2[1];
        if (intValue != 0) {
            return new XMPProperty() {
                public PropertyOptions b() {
                    return xMPNode.v();
                }

                public String c() {
                    return xMPNode.x(1).C();
                }

                public String getValue() {
                    return xMPNode.C();
                }

                public String toString() {
                    return xMPNode.C().toString();
                }
            };
        }
        return null;
    }

    public String H2() {
        return this.X;
    }

    public XMPProperty I(String str, String str2, int i2) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.a(str2);
        return h2(str, XMPPathFactory.e(str2, i2));
    }

    public void I0(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.f(str);
            ParameterAsserts.h(str2);
            n1(str, str2 + XMPPathFactory.i(str3, str4));
        } catch (XMPException unused) {
        }
    }

    public void I1(String str, String str2, long j2) throws XMPException {
        X0(str, str2, new Long(j2), (PropertyOptions) null);
    }

    public void J0(String str, String str2, byte[] bArr) throws XMPException {
        X0(str, str2, bArr, (PropertyOptions) null);
    }

    public void J1(String str, String str2, int i2) throws XMPException {
        X0(str, str2, new Integer(i2), (PropertyOptions) null);
    }

    public void K1(String str) {
        this.s.Z(str);
    }

    public void K2(String str, String str2, long j2, PropertyOptions propertyOptions) throws XMPException {
        X0(str, str2, new Long(j2), propertyOptions);
    }

    public int L1(String str, String str2) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.a(str2);
        XMPNode g2 = XMPNodeUtils.g(this.s, XMPPathParser.a(str, str2), false, (PropertyOptions) null);
        if (g2 == null) {
            return 0;
        }
        if (g2.v().t()) {
            return g2.q();
        }
        throw new XMPException("The named property is not an array", 102);
    }

    public void N(String str, String str2, String str3) throws XMPException {
        U0(str, str2, (PropertyOptions) null, str3, (PropertyOptions) null);
    }

    public byte[] N1(String str, String str2) throws XMPException {
        return (byte[]) d(str, str2, 7);
    }

    public void O(String str, String str2, double d2) throws XMPException {
        X0(str, str2, new Double(d2), (PropertyOptions) null);
    }

    public void O2(String str, String str2, boolean z) throws XMPException {
        X0(str, str2, z ? XMPConst.l2 : XMPConst.m2, (PropertyOptions) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        if (r2 == null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009f, code lost:
        if (r8.q() <= 1) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
        r8.N(r2);
        r8.a(1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a7, code lost:
        r10 = com.itextpdf.xmp.impl.XMPNodeUtils.b(r8, r10, r11);
        r0 = ((java.lang.Integer) r10[0]).intValue();
        r10 = (com.itextpdf.xmp.impl.XMPNode) r10[1];
        r3 = "x-default".equals(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bb, code lost:
        if (r0 == 0) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bd, code lost:
        if (r0 == 1) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c0, code lost:
        if (r0 == 2) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c3, code lost:
        if (r0 == 3) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c6, code lost:
        if (r0 == 4) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c9, code lost:
        if (r0 != 5) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cb, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ce, code lost:
        if (r3 == false) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d0, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00dc, code lost:
        throw new com.itextpdf.xmp.XMPException("Unexpected result from ChooseLocalizedText", 9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00dd, code lost:
        if (r2 == null) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e3, code lost:
        if (r8.q() != 1) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e5, code lost:
        r2.d0(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e8, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ed, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f0, code lost:
        if (r3 == false) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f3, code lost:
        if (r9 == false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f5, code lost:
        if (r2 == r10) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f7, code lost:
        if (r2 == null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0105, code lost:
        if (r2.C().equals(r10.C()) == false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0107, code lost:
        r2.d0(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010a, code lost:
        r10.d0(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010e, code lost:
        if (r3 != false) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0110, code lost:
        if (r9 == false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0112, code lost:
        if (r2 == r10) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0114, code lost:
        if (r2 == null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0122, code lost:
        if (r2.C().equals(r10.C()) == false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0125, code lost:
        r10 = r8.J();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x012d, code lost:
        if (r10.hasNext() == false) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x012f, code lost:
        r11 = (com.itextpdf.xmp.impl.XMPNode) r10.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0135, code lost:
        if (r11 == r2) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0137, code lost:
        r0 = r11.C();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013b, code lost:
        if (r2 == null) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013d, code lost:
        r3 = r2.C();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0142, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0147, code lost:
        if (r0.equals(r3) != false) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x014a, code lost:
        r11.d0(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x014e, code lost:
        if (r2 == null) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0150, code lost:
        r2.d0(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0154, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, "x-default", r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (r3 != false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0159, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x015e, code lost:
        if (r9 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0164, code lost:
        if (r8.q() != 1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0166, code lost:
        com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, "x-default", r12);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void P0(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, com.itextpdf.xmp.options.PropertyOptions r13) throws com.itextpdf.xmp.XMPException {
        /*
            r7 = this;
            com.itextpdf.xmp.impl.ParameterAsserts.f(r8)
            com.itextpdf.xmp.impl.ParameterAsserts.a(r9)
            com.itextpdf.xmp.impl.ParameterAsserts.g(r11)
            r13 = 0
            if (r10 == 0) goto L_0x0011
            java.lang.String r10 = com.itextpdf.xmp.impl.Utils.j(r10)
            goto L_0x0012
        L_0x0011:
            r10 = r13
        L_0x0012:
            java.lang.String r11 = com.itextpdf.xmp.impl.Utils.j(r11)
            com.itextpdf.xmp.impl.xpath.XMPPath r8 = com.itextpdf.xmp.impl.xpath.XMPPathParser.a(r8, r9)
            com.itextpdf.xmp.impl.XMPNode r9 = r7.s
            com.itextpdf.xmp.options.PropertyOptions r0 = new com.itextpdf.xmp.options.PropertyOptions
            r1 = 7680(0x1e00, float:1.0762E-41)
            r0.<init>(r1)
            r1 = 1
            com.itextpdf.xmp.impl.XMPNode r8 = com.itextpdf.xmp.impl.XMPNodeUtils.g(r9, r8, r1, r0)
            r9 = 102(0x66, float:1.43E-43)
            if (r8 == 0) goto L_0x016a
            com.itextpdf.xmp.options.PropertyOptions r0 = r8.v()
            boolean r0 = r0.u()
            if (r0 != 0) goto L_0x0056
            boolean r0 = r8.D()
            if (r0 != 0) goto L_0x004e
            com.itextpdf.xmp.options.PropertyOptions r0 = r8.v()
            boolean r0 = r0.v()
            if (r0 == 0) goto L_0x004e
            com.itextpdf.xmp.options.PropertyOptions r0 = r8.v()
            r0.G(r1)
            goto L_0x0056
        L_0x004e:
            com.itextpdf.xmp.XMPException r8 = new com.itextpdf.xmp.XMPException
            java.lang.String r10 = "Specified property is no alt-text array"
            r8.<init>(r10, r9)
            throw r8
        L_0x0056:
            java.util.Iterator r0 = r8.J()
        L_0x005a:
            boolean r2 = r0.hasNext()
            r3 = 0
            java.lang.String r4 = "x-default"
            if (r2 == 0) goto L_0x0097
            java.lang.Object r2 = r0.next()
            com.itextpdf.xmp.impl.XMPNode r2 = (com.itextpdf.xmp.impl.XMPNode) r2
            boolean r5 = r2.E()
            if (r5 == 0) goto L_0x008f
            com.itextpdf.xmp.impl.XMPNode r5 = r2.x(r1)
            java.lang.String r5 = r5.u()
            java.lang.String r6 = "xml:lang"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x008f
            com.itextpdf.xmp.impl.XMPNode r5 = r2.x(r1)
            java.lang.String r5 = r5.C()
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x005a
            r9 = 1
            goto L_0x0099
        L_0x008f:
            com.itextpdf.xmp.XMPException r8 = new com.itextpdf.xmp.XMPException
            java.lang.String r10 = "Language qualifier must be first"
            r8.<init>(r10, r9)
            throw r8
        L_0x0097:
            r2 = r13
            r9 = 0
        L_0x0099:
            if (r2 == 0) goto L_0x00a7
            int r0 = r8.q()
            if (r0 <= r1) goto L_0x00a7
            r8.N(r2)
            r8.a(r1, r2)
        L_0x00a7:
            java.lang.Object[] r10 = com.itextpdf.xmp.impl.XMPNodeUtils.b(r8, r10, r11)
            r0 = r10[r3]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r10 = r10[r1]
            com.itextpdf.xmp.impl.XMPNode r10 = (com.itextpdf.xmp.impl.XMPNode) r10
            boolean r3 = r4.equals(r11)
            if (r0 == 0) goto L_0x0154
            if (r0 == r1) goto L_0x010e
            r13 = 2
            if (r0 == r13) goto L_0x00f3
            r10 = 3
            if (r0 == r10) goto L_0x00ed
            r10 = 4
            if (r0 == r10) goto L_0x00dd
            r10 = 5
            if (r0 != r10) goto L_0x00d3
            com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, r11, r12)
            if (r3 == 0) goto L_0x015e
        L_0x00d0:
            r9 = 1
            goto L_0x015e
        L_0x00d3:
            com.itextpdf.xmp.XMPException r8 = new com.itextpdf.xmp.XMPException
            java.lang.String r9 = "Unexpected result from ChooseLocalizedText"
            r10 = 9
            r8.<init>(r9, r10)
            throw r8
        L_0x00dd:
            if (r2 == 0) goto L_0x00e8
            int r10 = r8.q()
            if (r10 != r1) goto L_0x00e8
            r2.d0(r12)
        L_0x00e8:
            com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, r11, r12)
            goto L_0x015e
        L_0x00ed:
            com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, r11, r12)
            if (r3 == 0) goto L_0x015e
            goto L_0x00d0
        L_0x00f3:
            if (r9 == 0) goto L_0x010a
            if (r2 == r10) goto L_0x010a
            if (r2 == 0) goto L_0x010a
            java.lang.String r11 = r2.C()
            java.lang.String r13 = r10.C()
            boolean r11 = r11.equals(r13)
            if (r11 == 0) goto L_0x010a
        L_0x0107:
            r2.d0(r12)
        L_0x010a:
            r10.d0(r12)
            goto L_0x015e
        L_0x010e:
            if (r3 != 0) goto L_0x0125
            if (r9 == 0) goto L_0x010a
            if (r2 == r10) goto L_0x010a
            if (r2 == 0) goto L_0x010a
            java.lang.String r11 = r2.C()
            java.lang.String r13 = r10.C()
            boolean r11 = r11.equals(r13)
            if (r11 == 0) goto L_0x010a
            goto L_0x0107
        L_0x0125:
            java.util.Iterator r10 = r8.J()
        L_0x0129:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x014e
            java.lang.Object r11 = r10.next()
            com.itextpdf.xmp.impl.XMPNode r11 = (com.itextpdf.xmp.impl.XMPNode) r11
            if (r11 == r2) goto L_0x0129
            java.lang.String r0 = r11.C()
            if (r2 == 0) goto L_0x0142
            java.lang.String r3 = r2.C()
            goto L_0x0143
        L_0x0142:
            r3 = r13
        L_0x0143:
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x014a
            goto L_0x0129
        L_0x014a:
            r11.d0(r12)
            goto L_0x0129
        L_0x014e:
            if (r2 == 0) goto L_0x015e
            r2.d0(r12)
            goto L_0x015e
        L_0x0154:
            com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, r4, r12)
            if (r3 != 0) goto L_0x00d0
            com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, r11, r12)
            goto L_0x00d0
        L_0x015e:
            if (r9 != 0) goto L_0x0169
            int r9 = r8.q()
            if (r9 != r1) goto L_0x0169
            com.itextpdf.xmp.impl.XMPNodeUtils.a(r8, r4, r12)
        L_0x0169:
            return
        L_0x016a:
            com.itextpdf.xmp.XMPException r8 = new com.itextpdf.xmp.XMPException
            java.lang.String r10 = "Failed to find or create array node"
            r8.<init>(r10, r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.XMPMetaImpl.P0(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.itextpdf.xmp.options.PropertyOptions):void");
    }

    public Calendar P1(String str, String str2) throws XMPException {
        return (Calendar) d(str, str2, 6);
    }

    public XMPIterator Q0(String str, String str2, IteratorOptions iteratorOptions) throws XMPException {
        return new XMPIteratorImpl(this, str, str2, iteratorOptions);
    }

    public void R(String str, String str2, int i2, String str3, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.a(str2);
        XMPNode g2 = XMPNodeUtils.g(this.s, XMPPathParser.a(str, str2), false, (PropertyOptions) null);
        if (g2 != null) {
            a(g2, i2, str3, propertyOptions, false);
            return;
        }
        throw new XMPException("Specified array does not exist", 102);
    }

    public void R2(String str, String str2, Object obj) throws XMPException {
        X0(str, str2, obj, (PropertyOptions) null);
    }

    public void T(String str, String str2, String str3, String str4, String str5, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.h(str2);
        X0(str, str2 + XMPPathFactory.i(str3, str4), str5, propertyOptions);
    }

    public void U0(String str, String str2, PropertyOptions propertyOptions, String str3, PropertyOptions propertyOptions2) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.a(str2);
        if (propertyOptions == null) {
            propertyOptions = new PropertyOptions();
        }
        if (propertyOptions.y()) {
            PropertyOptions r = XMPNodeUtils.r(propertyOptions, (Object) null);
            XMPPath a2 = XMPPathParser.a(str, str2);
            XMPNode g2 = XMPNodeUtils.g(this.s, a2, false, (PropertyOptions) null);
            if (g2 != null) {
                if (!g2.v().t()) {
                    throw new XMPException("The named property is not an array", 102);
                }
            } else if (r.t()) {
                g2 = XMPNodeUtils.g(this.s, a2, true, r);
                if (g2 == null) {
                    throw new XMPException("Failure creating array node", 102);
                }
            } else {
                throw new XMPException("Explicit arrayOptions required to create new array", 103);
            }
            a(g2, -1, str3, propertyOptions2, true);
            return;
        }
        throw new XMPException("Only array form flags allowed for arrayOptions", 103);
    }

    public boolean V0(String str, String str2) {
        try {
            ParameterAsserts.f(str);
            ParameterAsserts.e(str2);
            return XMPNodeUtils.g(this.s, XMPPathParser.a(str, str2), false, (PropertyOptions) null) != null;
        } catch (XMPException unused) {
            return false;
        }
    }

    public Integer V1(String str, String str2) throws XMPException {
        return (Integer) d(str, str2, 2);
    }

    public Double W(String str, String str2) throws XMPException {
        return (Double) d(str, str2, 4);
    }

    public boolean W1(String str, String str2, int i2) {
        try {
            ParameterAsserts.f(str);
            ParameterAsserts.a(str2);
            return V0(str, XMPPathFactory.e(str2, i2));
        } catch (XMPException unused) {
            return false;
        }
    }

    public void X0(String str, String str2, Object obj, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.e(str2);
        PropertyOptions r = XMPNodeUtils.r(propertyOptions, obj);
        XMPNode g2 = XMPNodeUtils.g(this.s, XMPPathParser.a(str, str2), true, r);
        if (g2 != null) {
            f(g2, obj, r, false);
            return;
        }
        throw new XMPException("Specified property does not exist", 102);
    }

    public void X1(String str, String str2, int i2, String str3) throws XMPException {
        R(str, str2, i2, str3, (PropertyOptions) null);
    }

    public void Y1(String str, String str2, XMPDateTime xMPDateTime, PropertyOptions propertyOptions) throws XMPException {
        X0(str, str2, xMPDateTime, propertyOptions);
    }

    public XMPProperty Z1(String str, String str2, String str3, String str4) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.h(str2);
        return h2(str, str2 + XMPPathFactory.i(str3, str4));
    }

    public void a1(String str, String str2, String str3, String str4, String str5) throws XMPException {
        T(str, str2, str3, str4, str5, (PropertyOptions) null);
    }

    /* access modifiers changed from: protected */
    public XMPProperty c(String str, String str2, int i2) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.e(str2);
        final XMPNode g2 = XMPNodeUtils.g(this.s, XMPPathParser.a(str, str2), false, (PropertyOptions) null);
        if (g2 == null) {
            return null;
        }
        if (i2 == 0 || !g2.v().x()) {
            final Object b2 = b(i2, g2);
            return new XMPProperty() {
                public PropertyOptions b() {
                    return g2.v();
                }

                public String c() {
                    return null;
                }

                public String getValue() {
                    Object obj = b2;
                    if (obj != null) {
                        return obj.toString();
                    }
                    return null;
                }

                public String toString() {
                    return b2.toString();
                }
            };
        }
        throw new XMPException("Property must be simple when a value type is requested", 102);
    }

    public XMPIterator c2(IteratorOptions iteratorOptions) throws XMPException {
        return Q0((String) null, (String) null, iteratorOptions);
    }

    public Object clone() {
        return new XMPMetaImpl((XMPNode) this.s.clone());
    }

    /* access modifiers changed from: protected */
    public Object d(String str, String str2, int i2) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.e(str2);
        XMPNode g2 = XMPNodeUtils.g(this.s, XMPPathParser.a(str, str2), false, (PropertyOptions) null);
        if (g2 == null) {
            return null;
        }
        if (i2 == 0 || !g2.v().x()) {
            return b(i2, g2);
        }
        throw new XMPException("Property must be simple when a value type is requested", 102);
    }

    public void d0(String str, String str2, String str3, String str4, String str5) throws XMPException {
        P0(str, str2, str3, str4, str5, (PropertyOptions) null);
    }

    public XMPNode e() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public void f(XMPNode xMPNode, Object obj, PropertyOptions propertyOptions, boolean z) throws XMPException {
        if (z) {
            xMPNode.h();
        }
        xMPNode.v().E(propertyOptions);
        if (!xMPNode.v().x()) {
            XMPNodeUtils.q(xMPNode, obj);
        } else if (obj == null || obj.toString().length() <= 0) {
            xMPNode.O();
        } else {
            throw new XMPException("Composite nodes can't have values", 102);
        }
    }

    public String f1() {
        return e().j(true);
    }

    public void g(String str) {
        this.X = str;
    }

    public XMPProperty h2(String str, String str2) throws XMPException {
        return c(str, str2, 0);
    }

    public void i0(String str, String str2, XMPDateTime xMPDateTime) throws XMPException {
        X0(str, str2, xMPDateTime, (PropertyOptions) null);
    }

    public XMPIterator iterator() throws XMPException {
        return Q0((String) null, (String) null, (IteratorOptions) null);
    }

    public void j0(String str, String str2, String str3, String str4, String str5) throws XMPException {
        C(str, str2, str3, str4, str5, (PropertyOptions) null);
    }

    public void l2(String str, String str2, int i2) {
        try {
            ParameterAsserts.f(str);
            ParameterAsserts.a(str2);
            n1(str, XMPPathFactory.e(str2, i2));
        } catch (XMPException unused) {
        }
    }

    public void m1(String str, String str2, boolean z, PropertyOptions propertyOptions) throws XMPException {
        X0(str, str2, z ? XMPConst.l2 : XMPConst.m2, propertyOptions);
    }

    public void n1(String str, String str2) {
        try {
            ParameterAsserts.f(str);
            ParameterAsserts.e(str2);
            XMPNode g2 = XMPNodeUtils.g(this.s, XMPPathParser.a(str, str2), false, (PropertyOptions) null);
            if (g2 != null) {
                XMPNodeUtils.c(g2);
            }
        } catch (XMPException unused) {
        }
    }

    public void o1(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.f(str);
            ParameterAsserts.e(str2);
            n1(str, str2 + XMPPathFactory.h(str3, str4));
        } catch (XMPException unused) {
        }
    }

    public void o2(ParseOptions parseOptions) throws XMPException {
        if (parseOptions == null) {
            parseOptions = new ParseOptions();
        }
        XMPNormalizer.h(this, parseOptions);
    }

    public String p1() {
        return this.s.u() != null ? this.s.u() : "";
    }

    public boolean q1(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.f(str);
            ParameterAsserts.h(str2);
            String i2 = XMPPathFactory.i(str3, str4);
            return V0(str, str2 + i2);
        } catch (XMPException unused) {
            return false;
        }
    }

    public void s1(String str, String str2, int i2, String str3) throws XMPException {
        x0(str, str2, i2, str3, (PropertyOptions) null);
    }

    public void s2(String str, String str2, double d2, PropertyOptions propertyOptions) throws XMPException {
        X0(str, str2, new Double(d2), propertyOptions);
    }

    public XMPDateTime v1(String str, String str2) throws XMPException {
        return (XMPDateTime) d(str, str2, 5);
    }

    public void v2() {
        this.s.e0();
    }

    public void x0(String str, String str2, int i2, String str3, PropertyOptions propertyOptions) throws XMPException {
        ParameterAsserts.f(str);
        ParameterAsserts.a(str2);
        XMPNode g2 = XMPNodeUtils.g(this.s, XMPPathParser.a(str, str2), false, (PropertyOptions) null);
        if (g2 != null) {
            a(g2, i2, str3, propertyOptions, true);
            return;
        }
        throw new XMPException("Specified array does not exist", 102);
    }

    public boolean x1(String str, String str2, String str3, String str4) {
        try {
            ParameterAsserts.f(str);
            ParameterAsserts.e(str2);
            String h2 = XMPPathFactory.h(str3, str4);
            return V0(str, str2 + h2);
        } catch (XMPException unused) {
            return false;
        }
    }

    public String y2(String str, String str2) throws XMPException {
        return (String) d(str, str2, 0);
    }

    public Long z2(String str, String str2) throws XMPException {
        return (Long) d(str, str2, 3);
    }

    public XMPMetaImpl(XMPNode xMPNode) {
        this.X = null;
        this.s = xMPNode;
    }
}
