package com.itextpdf.xmp.impl;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.security.SecurityConstants;
import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPError;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMetaFactory;
import com.itextpdf.xmp.XMPSchemaRegistry;
import com.itextpdf.xmp.options.PropertyOptions;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ParseRDF implements XMPError, XMPConst {
    public static final int X = 1;
    public static final int X2 = 4;
    public static final int Y = 2;
    public static final int Y2 = 5;
    public static final int Z = 3;
    public static final int Z2 = 6;
    public static final int a3 = 7;
    public static final int b3 = 8;
    public static final int c3 = 9;
    public static final int d3 = 10;
    public static final int e3 = 11;
    public static final int f3 = 12;
    public static final int g3 = 1;
    public static final int h3 = 7;
    public static final int i3 = 1;
    public static final int j3 = 9;
    public static final int k3 = 10;
    public static final int l3 = 12;
    public static final String m3 = "_dflt";
    static final /* synthetic */ boolean n3 = false;
    public static final int s = 0;

    private static XMPNode a(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, String str, boolean z) throws XMPException {
        XMPSchemaRegistry c2 = XMPMetaFactory.c();
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI != null) {
            if (XMPConst.Y1.equals(namespaceURI)) {
                namespaceURI = "http://purl.org/dc/elements/1.1/";
            }
            String b2 = c2.b(namespaceURI);
            if (b2 == null) {
                b2 = c2.g(namespaceURI, node.getPrefix() != null ? node.getPrefix() : m3);
            }
            String str2 = b2 + node.getLocalName();
            PropertyOptions propertyOptions = new PropertyOptions();
            boolean z2 = false;
            if (z) {
                xMPNode = XMPNodeUtils.i(xMPMetaImpl.e(), namespaceURI, m3, true);
                xMPNode.W(false);
                if (c2.h(str2) != null) {
                    xMPMetaImpl.e().T(true);
                    xMPNode.T(true);
                    z2 = true;
                }
            }
            boolean equals = "rdf:li".equals(str2);
            boolean equals2 = "rdf:value".equals(str2);
            XMPNode xMPNode2 = new XMPNode(str2, str, propertyOptions);
            xMPNode2.S(z2);
            if (!equals2) {
                xMPNode.b(xMPNode2);
            } else {
                xMPNode.a(1, xMPNode2);
            }
            if (equals2) {
                if (z || !xMPNode.v().C()) {
                    throw new XMPException("Misplaced rdf:value element", 202);
                }
                xMPNode.U(true);
            }
            if (equals) {
                if (xMPNode.v().t()) {
                    xMPNode2.Z(XMPConst.o2);
                } else {
                    throw new XMPException("Misplaced rdf:li element", 202);
                }
            }
            return xMPNode2;
        }
        throw new XMPException("XML namespace required for all elements and attributes", 202);
    }

    private static XMPNode b(XMPNode xMPNode, String str, String str2) throws XMPException {
        if (XMPConst.q2.equals(str)) {
            str2 = Utils.j(str2);
        }
        XMPNode xMPNode2 = new XMPNode(str, str2, (PropertyOptions) null);
        xMPNode.c(xMPNode2);
        return xMPNode2;
    }

    private static void c(XMPNode xMPNode) throws XMPException {
        XMPNode o = xMPNode.o(1);
        if (o.v().q()) {
            if (!xMPNode.v().q()) {
                XMPNode x = o.x(1);
                o.P(x);
                xMPNode.c(x);
            } else {
                throw new XMPException("Redundant xml:lang for rdf:value element", 203);
            }
        }
        for (int i2 = 1; i2 <= o.z(); i2++) {
            xMPNode.c(o.x(i2));
        }
        for (int i4 = 2; i4 <= xMPNode.q(); i4++) {
            xMPNode.c(xMPNode.o(i4));
        }
        xMPNode.U(false);
        xMPNode.v().O(false);
        xMPNode.v().E(o.v());
        xMPNode.d0(o.C());
        xMPNode.O();
        Iterator J = o.J();
        while (J.hasNext()) {
            xMPNode.b((XMPNode) J.next());
        }
    }

    private static int d(Node node) {
        String localName = node.getLocalName();
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI == null && (("about".equals(localName) || "ID".equals(localName)) && (node instanceof Attr) && XMPConst.g1.equals(((Attr) node).getOwnerElement().getNamespaceURI()))) {
            namespaceURI = XMPConst.g1;
        }
        if (!XMPConst.g1.equals(namespaceURI)) {
            return 0;
        }
        if ("li".equals(localName)) {
            return 9;
        }
        if ("parseType".equals(localName)) {
            return 4;
        }
        if ("Description".equals(localName)) {
            return 8;
        }
        if ("about".equals(localName)) {
            return 3;
        }
        if ("resource".equals(localName)) {
            return 5;
        }
        if ("RDF".equals(localName)) {
            return 1;
        }
        if ("ID".equals(localName)) {
            return 2;
        }
        if ("nodeID".equals(localName)) {
            return 6;
        }
        if ("datatype".equals(localName)) {
            return 7;
        }
        if ("aboutEach".equals(localName)) {
            return 10;
        }
        if ("aboutEachPrefix".equals(localName)) {
            return 11;
        }
        return "bagID".equals(localName) ? 12 : 0;
    }

    private static boolean e(int i2) {
        return 1 <= i2 && i2 <= 7;
    }

    private static boolean f(int i2) {
        return 10 <= i2 && i2 <= 12;
    }

    private static boolean g(int i2) {
        if (i2 == 8 || f(i2)) {
            return false;
        }
        return !e(i2);
    }

    private static boolean h(Node node) {
        if (node.getNodeType() != 3) {
            return false;
        }
        String nodeValue = node.getNodeValue();
        for (int i2 = 0; i2 < nodeValue.length(); i2++) {
            if (!Character.isWhitespace(nodeValue.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    static XMPMetaImpl i(Node node) throws XMPException {
        XMPMetaImpl xMPMetaImpl = new XMPMetaImpl();
        u(xMPMetaImpl, node);
        return xMPMetaImpl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void j(com.itextpdf.xmp.impl.XMPMetaImpl r16, com.itextpdf.xmp.impl.XMPNode r17, org.w3c.dom.Node r18, boolean r19) throws com.itextpdf.xmp.XMPException {
        /*
            r0 = r16
            boolean r1 = r18.hasChildNodes()
            r2 = 202(0xca, float:2.83E-43)
            if (r1 != 0) goto L_0x0152
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0010:
            org.w3c.dom.NamedNodeMap r9 = r18.getAttributes()
            int r9 = r9.getLength()
            java.lang.String r10 = "Unrecognized attribute of empty property element"
            r11 = 6
            r12 = 5
            r13 = 2
            java.lang.String r14 = "xml:lang"
            java.lang.String r15 = "xmlns"
            if (r4 >= r9) goto L_0x00b2
            org.w3c.dom.NamedNodeMap r9 = r18.getAttributes()
            org.w3c.dom.Node r9 = r9.item(r4)
            java.lang.String r1 = r9.getPrefix()
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x00ae
            java.lang.String r1 = r9.getPrefix()
            if (r1 != 0) goto L_0x0047
            java.lang.String r1 = r9.getNodeName()
            boolean r1 = r15.equals(r1)
            if (r1 == 0) goto L_0x0047
            goto L_0x00ae
        L_0x0047:
            int r1 = d(r9)
            java.lang.String r15 = "Empty property element can't have both rdf:value and rdf:resource"
            if (r1 == 0) goto L_0x007e
            if (r1 == r13) goto L_0x00ae
            java.lang.String r13 = "Empty property element can't have both rdf:resource and rdf:nodeID"
            if (r1 == r12) goto L_0x0067
            if (r1 != r11) goto L_0x0061
            if (r6 != 0) goto L_0x005b
            r8 = 1
            goto L_0x00ae
        L_0x005b:
            com.itextpdf.xmp.XMPException r0 = new com.itextpdf.xmp.XMPException
            r0.<init>(r13, r2)
            throw r0
        L_0x0061:
            com.itextpdf.xmp.XMPException r0 = new com.itextpdf.xmp.XMPException
            r0.<init>(r10, r2)
            throw r0
        L_0x0067:
            if (r8 != 0) goto L_0x0078
            if (r5 != 0) goto L_0x0070
            if (r5 != 0) goto L_0x006e
            r3 = r9
        L_0x006e:
            r6 = 1
            goto L_0x00ae
        L_0x0070:
            com.itextpdf.xmp.XMPException r0 = new com.itextpdf.xmp.XMPException
            r1 = 203(0xcb, float:2.84E-43)
            r0.<init>(r15, r1)
            throw r0
        L_0x0078:
            com.itextpdf.xmp.XMPException r0 = new com.itextpdf.xmp.XMPException
            r0.<init>(r13, r2)
            throw r0
        L_0x007e:
            java.lang.String r1 = "value"
            java.lang.String r10 = r9.getLocalName()
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x00a3
            java.lang.String r1 = "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
            java.lang.String r10 = r9.getNamespaceURI()
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x00a3
            if (r6 != 0) goto L_0x009b
            r3 = r9
            r5 = 1
            goto L_0x00ae
        L_0x009b:
            com.itextpdf.xmp.XMPException r0 = new com.itextpdf.xmp.XMPException
            r1 = 203(0xcb, float:2.84E-43)
            r0.<init>(r15, r1)
            throw r0
        L_0x00a3:
            java.lang.String r1 = r9.getNodeName()
            boolean r1 = r14.equals(r1)
            if (r1 != 0) goto L_0x00ae
            r7 = 1
        L_0x00ae:
            int r4 = r4 + 1
            goto L_0x0010
        L_0x00b2:
            java.lang.String r1 = ""
            r4 = r17
            r8 = r18
            r9 = r19
            com.itextpdf.xmp.impl.XMPNode r4 = a(r0, r4, r8, r1, r9)
            if (r5 != 0) goto L_0x00c2
            if (r6 == 0) goto L_0x00c4
        L_0x00c2:
            r6 = 1
            goto L_0x00d0
        L_0x00c4:
            if (r7 == 0) goto L_0x00e2
            com.itextpdf.xmp.options.PropertyOptions r1 = r4.v()
            r6 = 1
            r1.O(r6)
            r1 = 1
            goto L_0x00e3
        L_0x00d0:
            if (r3 == 0) goto L_0x00d6
            java.lang.String r1 = r3.getNodeValue()
        L_0x00d6:
            r4.d0(r1)
            if (r5 != 0) goto L_0x00e2
            com.itextpdf.xmp.options.PropertyOptions r1 = r4.v()
            r1.P(r6)
        L_0x00e2:
            r1 = 0
        L_0x00e3:
            r5 = 0
        L_0x00e4:
            org.w3c.dom.NamedNodeMap r6 = r18.getAttributes()
            int r6 = r6.getLength()
            if (r5 >= r6) goto L_0x0151
            org.w3c.dom.NamedNodeMap r6 = r18.getAttributes()
            org.w3c.dom.Node r6 = r6.item(r5)
            if (r6 == r3) goto L_0x0112
            java.lang.String r7 = r6.getPrefix()
            boolean r7 = r15.equals(r7)
            if (r7 != 0) goto L_0x0112
            java.lang.String r7 = r6.getPrefix()
            if (r7 != 0) goto L_0x0114
            java.lang.String r7 = r6.getNodeName()
            boolean r7 = r15.equals(r7)
            if (r7 == 0) goto L_0x0114
        L_0x0112:
            r9 = 0
            goto L_0x014e
        L_0x0114:
            int r7 = d(r6)
            if (r7 == 0) goto L_0x0131
            if (r7 == r13) goto L_0x0112
            if (r7 == r12) goto L_0x0127
            if (r7 != r11) goto L_0x0121
            goto L_0x0112
        L_0x0121:
            com.itextpdf.xmp.XMPException r0 = new com.itextpdf.xmp.XMPException
            r0.<init>(r10, r2)
            throw r0
        L_0x0127:
            java.lang.String r7 = "rdf:resource"
        L_0x0129:
            java.lang.String r6 = r6.getNodeValue()
            b(r4, r7, r6)
            goto L_0x0112
        L_0x0131:
            java.lang.String r7 = r6.getNodeName()
            if (r1 != 0) goto L_0x0138
            goto L_0x0129
        L_0x0138:
            boolean r7 = r14.equals(r7)
            if (r7 == 0) goto L_0x0146
            java.lang.String r6 = r6.getNodeValue()
            b(r4, r14, r6)
            goto L_0x0112
        L_0x0146:
            java.lang.String r7 = r6.getNodeValue()
            r9 = 0
            a(r0, r4, r6, r7, r9)
        L_0x014e:
            int r5 = r5 + 1
            goto L_0x00e4
        L_0x0151:
            return
        L_0x0152:
            com.itextpdf.xmp.XMPException r0 = new com.itextpdf.xmp.XMPException
            java.lang.String r1 = "Nested content not allowed with rdf:resource or property attributes"
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.ParseRDF.j(com.itextpdf.xmp.impl.XMPMetaImpl, com.itextpdf.xmp.impl.XMPNode, org.w3c.dom.Node, boolean):void");
    }

    private static void k(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        XMPNode a2 = a(xMPMetaImpl, xMPNode, node, (String) null, z);
        int i2 = 0;
        for (int i4 = 0; i4 < node.getAttributes().getLength(); i4++) {
            Node item = node.getAttributes().item(i4);
            if (!SecurityConstants.f27328a.equals(item.getPrefix()) && (item.getPrefix() != null || !SecurityConstants.f27328a.equals(item.getNodeName()))) {
                String namespaceURI = item.getNamespaceURI();
                String localName = item.getLocalName();
                if (XMPConst.q2.equals(item.getNodeName())) {
                    b(a2, XMPConst.q2, item.getNodeValue());
                } else if (!XMPConst.g1.equals(namespaceURI) || (!"ID".equals(localName) && !"datatype".equals(localName))) {
                    throw new XMPException("Invalid attribute for literal property element", 202);
                }
            }
        }
        String str = "";
        while (i2 < node.getChildNodes().getLength()) {
            Node item2 = node.getChildNodes().item(i2);
            if (item2.getNodeType() == 3) {
                str = str + item2.getNodeValue();
                i2++;
            } else {
                throw new XMPException("Invalid child of literal property element", 202);
            }
        }
        a2.d0(str);
    }

    private static void l(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        int d2 = d(node);
        if (d2 != 8 && d2 != 0) {
            throw new XMPException("Node element must be rdf:Description or typed node", 202);
        } else if (!z || d2 != 0) {
            m(xMPMetaImpl, xMPNode, node, z);
            t(xMPMetaImpl, xMPNode, node, z);
        } else {
            throw new XMPException("Top level typed node not allowed", 203);
        }
    }

    private static void m(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        int i2 = 0;
        for (int i4 = 0; i4 < node.getAttributes().getLength(); i4++) {
            Node item = node.getAttributes().item(i4);
            if (!SecurityConstants.f27328a.equals(item.getPrefix()) && (item.getPrefix() != null || !SecurityConstants.f27328a.equals(item.getNodeName()))) {
                int d2 = d(item);
                if (d2 == 0) {
                    a(xMPMetaImpl, xMPNode, item, item.getNodeValue(), z);
                } else if (d2 != 6 && d2 != 2 && d2 != 3) {
                    throw new XMPException("Invalid nodeElement attribute", 202);
                } else if (i2 <= 0) {
                    i2++;
                    if (z && d2 == 3) {
                        if (xMPNode.u() == null || xMPNode.u().length() <= 0) {
                            xMPNode.Z(item.getNodeValue());
                        } else if (!xMPNode.u().equals(item.getNodeValue())) {
                            throw new XMPException("Mismatched top level rdf:about values", 203);
                        }
                    }
                } else {
                    throw new XMPException("Mutally exclusive about, ID, nodeID attributes", 202);
                }
            }
        }
    }

    private static void n(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node) throws XMPException {
        for (int i2 = 0; i2 < node.getChildNodes().getLength(); i2++) {
            Node item = node.getChildNodes().item(i2);
            if (!h(item)) {
                l(xMPMetaImpl, xMPNode, item, true);
            }
        }
    }

    private static void o() throws XMPException {
        throw new XMPException("ParseTypeCollection property element not allowed", 203);
    }

    private static void p() throws XMPException {
        throw new XMPException("ParseTypeLiteral property element not allowed", 203);
    }

    private static void q() throws XMPException {
        throw new XMPException("ParseTypeOther property element not allowed", 203);
    }

    private static void r(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        XMPNode a2 = a(xMPMetaImpl, xMPNode, node, "", z);
        a2.v().O(true);
        for (int i2 = 0; i2 < node.getAttributes().getLength(); i2++) {
            Node item = node.getAttributes().item(i2);
            if (!SecurityConstants.f27328a.equals(item.getPrefix()) && (item.getPrefix() != null || !SecurityConstants.f27328a.equals(item.getNodeName()))) {
                String localName = item.getLocalName();
                String namespaceURI = item.getNamespaceURI();
                if (XMPConst.q2.equals(item.getNodeName())) {
                    b(a2, XMPConst.q2, item.getNodeValue());
                } else if (!XMPConst.g1.equals(namespaceURI) || (!"ID".equals(localName) && !"parseType".equals(localName))) {
                    throw new XMPException("Invalid attribute for ParseTypeResource property element", 202);
                }
            }
        }
        t(xMPMetaImpl, a2, node, false);
        if (a2.s()) {
            c(a2);
        }
    }

    private static void s(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        if (g(d(node))) {
            NamedNodeMap attributes = node.getAttributes();
            ArrayList<String> arrayList = null;
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                Node item = attributes.item(i2);
                if (SecurityConstants.f27328a.equals(item.getPrefix()) || (item.getPrefix() == null && SecurityConstants.f27328a.equals(item.getNodeName()))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(item.getNodeName());
                }
            }
            if (arrayList != null) {
                for (String removeNamedItem : arrayList) {
                    attributes.removeNamedItem(removeNamedItem);
                }
            }
            if (attributes.getLength() <= 3) {
                int i4 = 0;
                while (i4 < attributes.getLength()) {
                    Node item2 = attributes.item(i4);
                    String localName = item2.getLocalName();
                    String namespaceURI = item2.getNamespaceURI();
                    String nodeValue = item2.getNodeValue();
                    if (XMPConst.q2.equals(item2.getNodeName()) && (!"ID".equals(localName) || !XMPConst.g1.equals(namespaceURI))) {
                        i4++;
                    } else if ("datatype".equals(localName) && XMPConst.g1.equals(namespaceURI)) {
                        k(xMPMetaImpl, xMPNode, node, z);
                        return;
                    } else if (!"parseType".equals(localName) || !XMPConst.g1.equals(namespaceURI)) {
                        j(xMPMetaImpl, xMPNode, node, z);
                        return;
                    } else if ("Literal".equals(nodeValue)) {
                        p();
                        return;
                    } else if ("Resource".equals(nodeValue)) {
                        r(xMPMetaImpl, xMPNode, node, z);
                        return;
                    } else if ("Collection".equals(nodeValue)) {
                        o();
                        return;
                    } else {
                        q();
                        return;
                    }
                }
                if (node.hasChildNodes()) {
                    for (int i5 = 0; i5 < node.getChildNodes().getLength(); i5++) {
                        if (node.getChildNodes().item(i5).getNodeType() != 3) {
                            v(xMPMetaImpl, xMPNode, node, z);
                            return;
                        }
                    }
                    k(xMPMetaImpl, xMPNode, node, z);
                    return;
                }
            }
            j(xMPMetaImpl, xMPNode, node, z);
            return;
        }
        throw new XMPException("Invalid property element name", 202);
    }

    private static void t(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        for (int i2 = 0; i2 < node.getChildNodes().getLength(); i2++) {
            Node item = node.getChildNodes().item(i2);
            if (!h(item)) {
                if (item.getNodeType() == 1) {
                    s(xMPMetaImpl, xMPNode, item, z);
                } else {
                    throw new XMPException("Expected property element node not found", 202);
                }
            }
        }
    }

    static void u(XMPMetaImpl xMPMetaImpl, Node node) throws XMPException {
        if (node.hasAttributes()) {
            n(xMPMetaImpl, xMPMetaImpl.e(), node);
            return;
        }
        throw new XMPException("Invalid attributes of rdf:RDF element", 202);
    }

    private static void v(XMPMetaImpl xMPMetaImpl, XMPNode xMPNode, Node node, boolean z) throws XMPException {
        XMPException xMPException;
        if (!z || !"iX:changes".equals(node.getNodeName())) {
            XMPNode a2 = a(xMPMetaImpl, xMPNode, node, "", z);
            for (int i2 = 0; i2 < node.getAttributes().getLength(); i2++) {
                Node item = node.getAttributes().item(i2);
                if (!SecurityConstants.f27328a.equals(item.getPrefix()) && (item.getPrefix() != null || !SecurityConstants.f27328a.equals(item.getNodeName()))) {
                    String localName = item.getLocalName();
                    String namespaceURI = item.getNamespaceURI();
                    if (XMPConst.q2.equals(item.getNodeName())) {
                        b(a2, XMPConst.q2, item.getNodeValue());
                    } else if (!"ID".equals(localName) || !XMPConst.g1.equals(namespaceURI)) {
                        throw new XMPException("Invalid attribute for resource property element", 202);
                    }
                }
            }
            boolean z2 = false;
            for (int i4 = 0; i4 < node.getChildNodes().getLength(); i4++) {
                Node item2 = node.getChildNodes().item(i4);
                if (!h(item2)) {
                    if (item2.getNodeType() == 1 && !z2) {
                        boolean equals = XMPConst.g1.equals(item2.getNamespaceURI());
                        String localName2 = item2.getLocalName();
                        if (equals && "Bag".equals(localName2)) {
                            a2.v().F(true);
                        } else if (equals && "Seq".equals(localName2)) {
                            a2.v().F(true).I(true);
                        } else if (!equals || !"Alt".equals(localName2)) {
                            a2.v().O(true);
                            if (!equals && !"Description".equals(localName2)) {
                                String namespaceURI2 = item2.getNamespaceURI();
                                if (namespaceURI2 != null) {
                                    b(a2, XMPConst.r2, namespaceURI2 + ASCIIPropertyListParser.A + localName2);
                                } else {
                                    throw new XMPException("All XML elements must be in a namespace", 203);
                                }
                            }
                        } else {
                            a2.v().F(true).I(true).H(true);
                        }
                        l(xMPMetaImpl, a2, item2, false);
                        if (a2.s()) {
                            c(a2);
                        } else if (a2.v().v()) {
                            XMPNodeUtils.d(a2);
                        }
                        z2 = true;
                    } else if (z2) {
                        throw xMPException;
                    } else {
                        xMPException = new XMPException("Children of resource property element must be XML elements", 202);
                        throw xMPException;
                    }
                }
            }
            if (!z2) {
                throw new XMPException("Missing child of resource property element", 202);
            }
        }
    }
}
