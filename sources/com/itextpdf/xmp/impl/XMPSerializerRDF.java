package com.itextpdf.xmp.impl;

import com.itextpdf.text.xml.xmp.XmpBasicProperties;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.XMPMetaFactory;
import com.itextpdf.xmp.XMPSchemaRegistry;
import com.itextpdf.xmp.options.SerializeOptions;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class XMPSerializerRDF {

    /* renamed from: g  reason: collision with root package name */
    private static final int f27770g = 2048;

    /* renamed from: h  reason: collision with root package name */
    private static final String f27771h = "<?xpacket begin=\"﻿\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>";

    /* renamed from: i  reason: collision with root package name */
    private static final String f27772i = "<?xpacket end=\"";

    /* renamed from: j  reason: collision with root package name */
    private static final String f27773j = "\"?>";

    /* renamed from: k  reason: collision with root package name */
    private static final String f27774k = "<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"";

    /* renamed from: l  reason: collision with root package name */
    private static final String f27775l = "</x:xmpmeta>";

    /* renamed from: m  reason: collision with root package name */
    private static final String f27776m = "<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">";

    /* renamed from: n  reason: collision with root package name */
    private static final String f27777n = "</rdf:RDF>";
    private static final String o = "<rdf:Description rdf:about=";
    private static final String p = "</rdf:Description>";
    private static final String q = "<rdf:Description";
    private static final String r = "</rdf:Description>";
    private static final String s = "<rdf:Description/>";
    static final Set t = new HashSet(Arrays.asList(new String[]{XMPConst.q2, "rdf:resource", "rdf:ID", "rdf:bagID", "rdf:nodeID"}));

    /* renamed from: a  reason: collision with root package name */
    private XMPMetaImpl f27778a;

    /* renamed from: b  reason: collision with root package name */
    private CountOutputStream f27779b;

    /* renamed from: c  reason: collision with root package name */
    private OutputStreamWriter f27780c;

    /* renamed from: d  reason: collision with root package name */
    private SerializeOptions f27781d;

    /* renamed from: e  reason: collision with root package name */
    private int f27782e = 1;

    /* renamed from: f  reason: collision with root package name */
    private int f27783f;

    private void A() throws IOException {
        v(34);
        String u = this.f27778a.e().u();
        if (u != null) {
            b(u, true);
        }
        v(34);
    }

    private void a(int i2) throws XMPException, IOException {
        if (this.f27781d.t()) {
            int b2 = this.f27779b.b() + (i2 * this.f27782e);
            int i3 = this.f27783f;
            if (b2 <= i3) {
                this.f27783f = i3 - b2;
            } else {
                throw new XMPException("Can't fit into specified packet size", 107);
            }
        }
        this.f27783f /= this.f27782e;
        int length = this.f27781d.w().length();
        int i4 = this.f27783f;
        if (i4 >= length) {
            int i5 = i4 - length;
            while (true) {
                this.f27783f = i5;
                int i6 = this.f27783f;
                int i7 = length + 100;
                if (i6 >= i7) {
                    x(100, ' ');
                    z();
                    i5 = this.f27783f - i7;
                } else {
                    x(i6, ' ');
                    z();
                    return;
                }
            }
        } else {
            x(i4, ' ');
        }
    }

    private void b(String str, boolean z) throws IOException {
        if (str == null) {
            str = "";
        }
        w(Utils.b(str, z, true));
    }

    private boolean c(XMPNode xMPNode) {
        return !xMPNode.E() && !xMPNode.v().D() && !xMPNode.v().x() && !xMPNode.v().e(1073741824) && !XMPConst.o2.equals(xMPNode.u());
    }

    private void e(String str, String str2, Set set, int i2) throws IOException {
        if (str2 == null) {
            QName qName = new QName(str);
            if (qName.c()) {
                str = qName.b();
                XMPSchemaRegistry c2 = XMPMetaFactory.c();
                str2 = c2.c(str + ":");
                e(str, str2, set, i2);
            } else {
                return;
            }
        }
        if (!set.contains(str)) {
            z();
            y(i2);
            w("xmlns:");
            w(str);
            w("=\"");
            w(str2);
            v(34);
            set.add(str);
        }
    }

    private void f(XMPNode xMPNode, Set set, int i2) throws IOException {
        if (xMPNode.v().A()) {
            e(xMPNode.C().substring(0, xMPNode.C().length() - 1), xMPNode.u(), set, i2);
        } else if (xMPNode.v().C()) {
            Iterator J = xMPNode.J();
            while (J.hasNext()) {
                e(((XMPNode) J.next()).u(), (String) null, set, i2);
            }
        }
        Iterator J2 = xMPNode.J();
        while (J2.hasNext()) {
            f((XMPNode) J2.next(), set, i2);
        }
        Iterator K = xMPNode.K();
        while (K.hasNext()) {
            XMPNode xMPNode2 = (XMPNode) K.next();
            e(xMPNode2.u(), (String) null, set, i2);
            f(xMPNode2, set, i2);
        }
    }

    private void g(XMPNode xMPNode, boolean z, int i2) throws IOException {
        if (z || xMPNode.D()) {
            y(i2);
            w(z ? "<rdf:" : "</rdf:");
            w(xMPNode.v().v() ? "Alt" : xMPNode.v().w() ? "Seq" : "Bag");
            w((!z || xMPNode.D()) ? ">" : "/>");
            z();
        }
    }

    private void h(int i2) throws IOException {
        y(i2 + 1);
        w("</rdf:Description>");
        z();
    }

    private String j() throws IOException, XMPException {
        int i2 = 0;
        if (!this.f27781d.x()) {
            y(0);
            w(f27771h);
            z();
        }
        if (!this.f27781d.z()) {
            y(0);
            w(f27774k);
            if (!this.f27781d.y()) {
                w(XMPMetaFactory.d().b());
            }
            w("\">");
            z();
            i2 = 1;
        }
        y(i2);
        w(f27776m);
        z();
        if (this.f27781d.D()) {
            m(i2);
        } else {
            r(i2);
        }
        y(i2);
        w(f27777n);
        z();
        if (!this.f27781d.z()) {
            y(i2 - 1);
            w(f27775l);
            z();
        }
        String str = "";
        if (this.f27781d.x()) {
            return str;
        }
        for (int p2 = this.f27781d.p(); p2 > 0; p2--) {
            str = str + this.f27781d.v();
        }
        String str2 = str + f27772i;
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(this.f27781d.B() ? 'r' : 'w');
        return sb.toString() + f27773j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c3, code lost:
        if (r2 != false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01bb, code lost:
        if (r2 != false) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(com.itextpdf.xmp.impl.XMPNode r17, boolean r18, boolean r19, int r20) throws java.io.IOException, com.itextpdf.xmp.XMPException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r20
            java.lang.String r4 = r17.u()
            if (r19 == 0) goto L_0x0011
            java.lang.String r4 = "rdf:value"
            goto L_0x001b
        L_0x0011:
            java.lang.String r5 = "[]"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x001b
            java.lang.String r4 = "rdf:li"
        L_0x001b:
            r0.y(r3)
            r5 = 60
            r0.v(r5)
            r0.w(r4)
            java.util.Iterator r5 = r17.K()
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x002d:
            boolean r9 = r5.hasNext()
            r10 = 34
            java.lang.String r11 = "=\""
            r12 = 32
            r13 = 1
            if (r9 == 0) goto L_0x0072
            java.lang.Object r9 = r5.next()
            com.itextpdf.xmp.impl.XMPNode r9 = (com.itextpdf.xmp.impl.XMPNode) r9
            java.util.Set r14 = t
            java.lang.String r15 = r9.u()
            boolean r14 = r14.contains(r15)
            if (r14 != 0) goto L_0x004e
            r7 = 1
            goto L_0x002d
        L_0x004e:
            java.lang.String r8 = "rdf:resource"
            java.lang.String r14 = r9.u()
            boolean r8 = r8.equals(r14)
            if (r19 != 0) goto L_0x002d
            r0.v(r12)
            java.lang.String r12 = r9.u()
            r0.w(r12)
            r0.w(r11)
            java.lang.String r9 = r9.C()
            r0.b(r9, r13)
            r0.v(r10)
            goto L_0x002d
        L_0x0072:
            java.lang.String r5 = "</rdf:Description>"
            java.lang.String r9 = " rdf:parseType=\"Resource\">"
            java.lang.String r14 = "<rdf:Description"
            r15 = 202(0xca, float:2.83E-43)
            r10 = 62
            java.lang.String r12 = ">"
            if (r7 == 0) goto L_0x00dc
            if (r19 != 0) goto L_0x00dc
            if (r8 != 0) goto L_0x00d4
            if (r2 == 0) goto L_0x0098
            r0.w(r12)
            r16.z()
            int r3 = r3 + 1
            r0.y(r3)
            r0.w(r14)
            r0.w(r12)
            goto L_0x009b
        L_0x0098:
            r0.w(r9)
        L_0x009b:
            r16.z()
            int r7 = r3 + 1
            r0.k(r1, r2, r13, r7)
            java.util.Iterator r1 = r17.K()
        L_0x00a7:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x00c3
            java.lang.Object r8 = r1.next()
            com.itextpdf.xmp.impl.XMPNode r8 = (com.itextpdf.xmp.impl.XMPNode) r8
            java.util.Set r9 = t
            java.lang.String r11 = r8.u()
            boolean r9 = r9.contains(r11)
            if (r9 != 0) goto L_0x00a7
            r0.k(r8, r2, r6, r7)
            goto L_0x00a7
        L_0x00c3:
            if (r2 == 0) goto L_0x00d1
        L_0x00c5:
            r0.y(r3)
            r0.w(r5)
            r16.z()
            int r1 = r3 + -1
            r3 = r1
        L_0x00d1:
            r6 = 1
            goto L_0x0203
        L_0x00d4:
            com.itextpdf.xmp.XMPException r1 = new com.itextpdf.xmp.XMPException
            java.lang.String r2 = "Can't mix rdf:resource and general qualifiers"
            r1.<init>(r2, r15)
            throw r1
        L_0x00dc:
            com.itextpdf.xmp.options.PropertyOptions r7 = r17.v()
            boolean r7 = r7.x()
            java.lang.String r15 = "/>"
            if (r7 != 0) goto L_0x012d
            com.itextpdf.xmp.options.PropertyOptions r2 = r17.v()
            boolean r2 = r2.D()
            if (r2 == 0) goto L_0x0108
            java.lang.String r2 = " rdf:resource=\""
            r0.w(r2)
            java.lang.String r1 = r17.C()
            r0.b(r1, r13)
            java.lang.String r1 = "\"/>"
        L_0x0100:
            r0.w(r1)
        L_0x0103:
            r16.z()
            goto L_0x0203
        L_0x0108:
            java.lang.String r2 = r17.C()
            if (r2 == 0) goto L_0x0129
            java.lang.String r2 = ""
            java.lang.String r5 = r17.C()
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x011b
            goto L_0x0129
        L_0x011b:
            r0.v(r10)
            java.lang.String r1 = r17.C()
            r0.b(r1, r6)
            r6 = 1
            r13 = 0
            goto L_0x0203
        L_0x0129:
            r0.w(r15)
            goto L_0x0103
        L_0x012d:
            com.itextpdf.xmp.options.PropertyOptions r7 = r17.v()
            boolean r7 = r7.t()
            if (r7 == 0) goto L_0x016a
            r0.v(r10)
            r16.z()
            int r5 = r3 + 1
            r0.g(r1, r13, r5)
            com.itextpdf.xmp.options.PropertyOptions r7 = r17.v()
            boolean r7 = r7.u()
            if (r7 == 0) goto L_0x014f
            com.itextpdf.xmp.impl.XMPNodeUtils.o(r17)
        L_0x014f:
            java.util.Iterator r7 = r17.J()
        L_0x0153:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0165
            java.lang.Object r8 = r7.next()
            com.itextpdf.xmp.impl.XMPNode r8 = (com.itextpdf.xmp.impl.XMPNode) r8
            int r9 = r3 + 2
            r0.k(r8, r2, r6, r9)
            goto L_0x0153
        L_0x0165:
            r0.g(r1, r6, r5)
            goto L_0x00d1
        L_0x016a:
            if (r8 != 0) goto L_0x01bf
            boolean r7 = r17.D()
            if (r7 != 0) goto L_0x018b
            if (r2 == 0) goto L_0x0187
            r0.w(r12)
            r16.z()
            int r1 = r3 + 1
            r0.y(r1)
            java.lang.String r1 = "<rdf:Description/>"
            r0.w(r1)
            r6 = 1
            goto L_0x0103
        L_0x0187:
            java.lang.String r1 = " rdf:parseType=\"Resource\"/>"
            goto L_0x0100
        L_0x018b:
            if (r2 == 0) goto L_0x019f
            r0.w(r12)
            r16.z()
            int r3 = r3 + 1
            r0.y(r3)
            r0.w(r14)
            r0.w(r12)
            goto L_0x01a2
        L_0x019f:
            r0.w(r9)
        L_0x01a2:
            r16.z()
            java.util.Iterator r1 = r17.J()
        L_0x01a9:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x01bb
            java.lang.Object r7 = r1.next()
            com.itextpdf.xmp.impl.XMPNode r7 = (com.itextpdf.xmp.impl.XMPNode) r7
            int r8 = r3 + 1
            r0.k(r7, r2, r6, r8)
            goto L_0x01a9
        L_0x01bb:
            if (r2 == 0) goto L_0x00d1
            goto L_0x00c5
        L_0x01bf:
            java.util.Iterator r1 = r17.J()
        L_0x01c3:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0129
            java.lang.Object r2 = r1.next()
            com.itextpdf.xmp.impl.XMPNode r2 = (com.itextpdf.xmp.impl.XMPNode) r2
            boolean r5 = r0.c(r2)
            if (r5 == 0) goto L_0x01f9
            r16.z()
            int r5 = r3 + 1
            r0.y(r5)
            r5 = 32
            r0.v(r5)
            java.lang.String r7 = r2.u()
            r0.w(r7)
            r0.w(r11)
            java.lang.String r2 = r2.C()
            r0.b(r2, r13)
            r2 = 34
            r0.v(r2)
            goto L_0x01c3
        L_0x01f9:
            com.itextpdf.xmp.XMPException r1 = new com.itextpdf.xmp.XMPException
            java.lang.String r2 = "Can't mix rdf:resource and complex fields"
            r3 = 202(0xca, float:2.83E-43)
            r1.<init>(r2, r3)
            throw r1
        L_0x0203:
            if (r6 == 0) goto L_0x0218
            if (r13 == 0) goto L_0x020a
            r0.y(r3)
        L_0x020a:
            java.lang.String r1 = "</"
            r0.w(r1)
            r0.w(r4)
            r0.v(r10)
            r16.z()
        L_0x0218:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.XMPSerializerRDF.k(com.itextpdf.xmp.impl.XMPNode, boolean, boolean, int):void");
    }

    private void l(XMPNode xMPNode, int i2) throws IOException, XMPException {
        Iterator J = xMPNode.J();
        while (J.hasNext()) {
            k((XMPNode) J.next(), this.f27781d.D(), false, i2 + 2);
        }
    }

    private void m(int i2) throws IOException, XMPException {
        if (this.f27778a.e().q() > 0) {
            u(this.f27778a.e(), i2);
            Iterator J = this.f27778a.e().J();
            while (J.hasNext()) {
                l((XMPNode) J.next(), i2);
            }
            h(i2);
            return;
        }
        y(i2 + 1);
        w(o);
        A();
        w("/>");
        z();
    }

    private void n(XMPNode xMPNode, int i2) throws IOException, XMPException {
        v(62);
        z();
        int i3 = i2 + 1;
        g(xMPNode, true, i3);
        if (xMPNode.v().u()) {
            XMPNodeUtils.o(xMPNode);
        }
        p(xMPNode, i2 + 2);
        g(xMPNode, false, i3);
    }

    private boolean o(XMPNode xMPNode, int i2) throws IOException {
        Iterator J = xMPNode.J();
        boolean z = true;
        while (J.hasNext()) {
            XMPNode xMPNode2 = (XMPNode) J.next();
            if (c(xMPNode2)) {
                z();
                y(i2);
                w(xMPNode2.u());
                w("=\"");
                b(xMPNode2.C(), true);
                v(34);
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0004 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void p(com.itextpdf.xmp.impl.XMPNode r11, int r12) throws java.io.IOException, com.itextpdf.xmp.XMPException {
        /*
            r10 = this;
            java.util.Iterator r11 = r11.J()
        L_0x0004:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00cf
            java.lang.Object r0 = r11.next()
            com.itextpdf.xmp.impl.XMPNode r0 = (com.itextpdf.xmp.impl.XMPNode) r0
            boolean r1 = r10.c(r0)
            if (r1 == 0) goto L_0x0017
            goto L_0x0004
        L_0x0017:
            java.lang.String r1 = r0.u()
            java.lang.String r2 = "[]"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x0025
            java.lang.String r1 = "rdf:li"
        L_0x0025:
            r10.y(r12)
            r2 = 60
            r10.v(r2)
            r10.w(r1)
            java.util.Iterator r2 = r0.K()
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0037:
            boolean r6 = r2.hasNext()
            r7 = 1
            if (r6 == 0) goto L_0x007a
            java.lang.Object r6 = r2.next()
            com.itextpdf.xmp.impl.XMPNode r6 = (com.itextpdf.xmp.impl.XMPNode) r6
            java.util.Set r8 = t
            java.lang.String r9 = r6.u()
            boolean r8 = r8.contains(r9)
            if (r8 != 0) goto L_0x0052
            r4 = 1
            goto L_0x0037
        L_0x0052:
            java.lang.String r5 = "rdf:resource"
            java.lang.String r8 = r6.u()
            boolean r5 = r5.equals(r8)
            r8 = 32
            r10.v(r8)
            java.lang.String r8 = r6.u()
            r10.w(r8)
            java.lang.String r8 = "=\""
            r10.w(r8)
            java.lang.String r6 = r6.C()
            r10.b(r6, r7)
            r6 = 34
            r10.v(r6)
            goto L_0x0037
        L_0x007a:
            if (r4 == 0) goto L_0x0080
            r10.q(r12, r0)
            goto L_0x00ae
        L_0x0080:
            com.itextpdf.xmp.options.PropertyOptions r2 = r0.v()
            boolean r2 = r2.x()
            if (r2 != 0) goto L_0x00a1
            java.lang.Object[] r0 = r10.s(r0)
            r2 = r0[r3]
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r0 = r0[r7]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r7 = r0.booleanValue()
            r0 = r7
            r7 = r2
            goto L_0x00b6
        L_0x00a1:
            com.itextpdf.xmp.options.PropertyOptions r2 = r0.v()
            boolean r2 = r2.t()
            if (r2 == 0) goto L_0x00b0
            r10.n(r0, r12)
        L_0x00ae:
            r0 = 1
            goto L_0x00b6
        L_0x00b0:
            boolean r0 = r10.t(r0, r12, r5)
            r7 = r0
            goto L_0x00ae
        L_0x00b6:
            if (r7 == 0) goto L_0x0004
            if (r0 == 0) goto L_0x00bd
            r10.y(r12)
        L_0x00bd:
            java.lang.String r0 = "</"
            r10.w(r0)
            r10.w(r1)
            r0 = 62
            r10.v(r0)
            r10.z()
            goto L_0x0004
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.XMPSerializerRDF.p(com.itextpdf.xmp.impl.XMPNode, int):void");
    }

    private void q(int i2, XMPNode xMPNode) throws IOException, XMPException {
        w(" rdf:parseType=\"Resource\">");
        z();
        int i3 = i2 + 1;
        k(xMPNode, false, true, i3);
        Iterator K = xMPNode.K();
        while (K.hasNext()) {
            k((XMPNode) K.next(), false, false, i3);
        }
    }

    private void r(int i2) throws IOException, XMPException {
        String str;
        int i3 = i2 + 1;
        y(i3);
        w(o);
        A();
        HashSet hashSet = new HashSet();
        hashSet.add(HTML.Tag.f27613a);
        hashSet.add("rdf");
        Iterator J = this.f27778a.e().J();
        while (J.hasNext()) {
            f((XMPNode) J.next(), hashSet, i2 + 3);
        }
        Iterator J2 = this.f27778a.e().J();
        boolean z = true;
        while (J2.hasNext()) {
            z &= o((XMPNode) J2.next(), i2 + 2);
        }
        if (!z) {
            v(62);
            z();
            Iterator J3 = this.f27778a.e().J();
            while (J3.hasNext()) {
                p((XMPNode) J3.next(), i2 + 2);
            }
            y(i3);
            str = "</rdf:Description>";
        } else {
            str = "/>";
        }
        w(str);
        z();
    }

    private Object[] s(XMPNode xMPNode) throws IOException {
        Boolean bool;
        String str;
        Boolean bool2 = Boolean.TRUE;
        if (xMPNode.v().D()) {
            w(" rdf:resource=\"");
            b(xMPNode.C(), true);
            str = "\"/>";
        } else if (xMPNode.C() == null || xMPNode.C().length() == 0) {
            str = "/>";
        } else {
            v(62);
            b(xMPNode.C(), false);
            bool = Boolean.FALSE;
            return new Object[]{bool2, bool};
        }
        w(str);
        z();
        Boolean bool3 = bool2;
        bool2 = Boolean.FALSE;
        bool = bool3;
        return new Object[]{bool2, bool};
    }

    private boolean t(XMPNode xMPNode, int i2, boolean z) throws XMPException, IOException {
        String str;
        Iterator J = xMPNode.J();
        boolean z2 = false;
        boolean z3 = false;
        while (J.hasNext()) {
            if (c((XMPNode) J.next())) {
                z2 = true;
            } else {
                z3 = true;
            }
            if (z2 && z3) {
                break;
            }
        }
        if (!z || !z3) {
            if (!xMPNode.D()) {
                str = " rdf:parseType=\"Resource\"/>";
            } else if (!z3) {
                o(xMPNode, i2 + 1);
                str = "/>";
            } else {
                if (!z2) {
                    w(" rdf:parseType=\"Resource\">");
                    z();
                    p(xMPNode, i2 + 1);
                } else {
                    v(62);
                    z();
                    int i3 = i2 + 1;
                    y(i3);
                    w(q);
                    o(xMPNode, i2 + 2);
                    w(">");
                    z();
                    p(xMPNode, i3);
                    y(i3);
                    w("</rdf:Description>");
                    z();
                }
                return true;
            }
            w(str);
            z();
            return false;
        }
        throw new XMPException("Can't mix rdf:resource qualifier and element fields", 202);
    }

    private void u(XMPNode xMPNode, int i2) throws IOException {
        y(i2 + 1);
        w(o);
        A();
        HashSet hashSet = new HashSet();
        hashSet.add(HTML.Tag.f27613a);
        hashSet.add("rdf");
        f(xMPNode, hashSet, i2 + 3);
        v(62);
        z();
    }

    private void v(int i2) throws IOException {
        this.f27780c.write(i2);
    }

    private void w(String str) throws IOException {
        this.f27780c.write(str);
    }

    private void x(int i2, char c2) throws IOException {
        while (i2 > 0) {
            this.f27780c.write(c2);
            i2--;
        }
    }

    private void y(int i2) throws IOException {
        for (int p2 = this.f27781d.p() + i2; p2 > 0; p2--) {
            this.f27780c.write(this.f27781d.v());
        }
    }

    private void z() throws IOException {
        this.f27780c.write(this.f27781d.w());
    }

    /* access modifiers changed from: protected */
    public void d() throws XMPException {
        if (this.f27781d.q() || this.f27781d.r()) {
            this.f27782e = 2;
        }
        if (!this.f27781d.t()) {
            if (this.f27781d.B()) {
                if (this.f27781d.x() || this.f27781d.u()) {
                    throw new XMPException("Inconsistent options for read-only packet", 103);
                }
            } else if (!this.f27781d.x()) {
                if (this.f27783f == 0) {
                    this.f27783f = this.f27782e * 2048;
                }
                if (this.f27781d.u() && !this.f27778a.V0("http://ns.adobe.com/xap/1.0/", XmpBasicProperties.f27421i)) {
                    this.f27783f += this.f27782e * 10000;
                    return;
                }
                return;
            } else if (this.f27781d.u()) {
                throw new XMPException("Inconsistent options for non-packet serialize", 103);
            }
            this.f27783f = 0;
        } else if (this.f27781d.x() || this.f27781d.u()) {
            throw new XMPException("Inconsistent options for exact size serialize", 103);
        } else if ((this.f27781d.A() & (this.f27782e - 1)) != 0) {
            throw new XMPException("Exact size must be a multiple of the Unicode element", 103);
        }
    }

    public void i(XMPMeta xMPMeta, OutputStream outputStream, SerializeOptions serializeOptions) throws XMPException {
        try {
            this.f27779b = new CountOutputStream(outputStream);
            this.f27780c = new OutputStreamWriter(this.f27779b, serializeOptions.s());
            this.f27778a = (XMPMetaImpl) xMPMeta;
            this.f27781d = serializeOptions;
            this.f27783f = serializeOptions.A();
            this.f27780c = new OutputStreamWriter(this.f27779b, serializeOptions.s());
            d();
            String j2 = j();
            this.f27780c.flush();
            a(j2.length());
            w(j2);
            this.f27780c.flush();
            this.f27779b.close();
        } catch (IOException unused) {
            throw new XMPException("Error writing to the OutputStream", 0);
        }
    }
}
