package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.options.ParseOptions;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.ccil.cowan.tagsoup.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMPMetaParser {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f27762a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static DocumentBuilderFactory f27763b = a();

    private XMPMetaParser() {
    }

    private static DocumentBuilderFactory a() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        newInstance.setIgnoringComments(true);
        try {
            newInstance.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            newInstance.setFeature(Parser.Q, false);
            newInstance.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
            newInstance.setXIncludeAware(false);
            newInstance.setExpandEntityReferences(false);
        } catch (Exception unused) {
        }
        return newInstance;
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [java.lang.Object[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object[] b(org.w3c.dom.Node r7, boolean r8, java.lang.Object[] r9) {
        /*
            org.w3c.dom.NodeList r7 = r7.getChildNodes()
            r0 = 0
            r1 = 0
        L_0x0006:
            int r2 = r7.getLength()
            if (r1 >= r2) goto L_0x0089
            org.w3c.dom.Node r2 = r7.item(r1)
            short r3 = r2.getNodeType()
            r4 = 7
            if (r4 != r3) goto L_0x0030
            r3 = r2
            org.w3c.dom.ProcessingInstruction r3 = (org.w3c.dom.ProcessingInstruction) r3
            java.lang.String r5 = r3.getTarget()
            java.lang.String r6 = "xpacket"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0030
            if (r9 == 0) goto L_0x0085
            r2 = 2
            java.lang.String r3 = r3.getData()
            r9[r2] = r3
            goto L_0x0085
        L_0x0030:
            r3 = 3
            short r5 = r2.getNodeType()
            if (r3 == r5) goto L_0x0085
            short r3 = r2.getNodeType()
            if (r4 == r3) goto L_0x0085
            java.lang.String r3 = r2.getNamespaceURI()
            java.lang.String r4 = r2.getLocalName()
            java.lang.String r5 = "xmpmeta"
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0055
            java.lang.String r5 = "xapmeta"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x0062
        L_0x0055:
            java.lang.String r5 = "adobe:ns:meta/"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0062
            java.lang.Object[] r7 = b(r2, r0, r9)
            return r7
        L_0x0062:
            if (r8 != 0) goto L_0x007e
            java.lang.String r5 = "RDF"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x007e
            java.lang.String r4 = "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x007e
            if (r9 == 0) goto L_0x007d
            r9[r0] = r2
            java.lang.Object r7 = f27762a
            r8 = 1
            r9[r8] = r7
        L_0x007d:
            return r9
        L_0x007e:
            java.lang.Object[] r2 = b(r2, r8, r9)
            if (r2 == 0) goto L_0x0085
            return r2
        L_0x0085:
            int r1 = r1 + 1
            goto L_0x0006
        L_0x0089:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.XMPMetaParser.b(org.w3c.dom.Node, boolean, java.lang.Object[]):java.lang.Object[]");
    }

    public static XMPMeta c(Object obj, ParseOptions parseOptions) throws XMPException {
        ParameterAsserts.c(obj);
        if (parseOptions == null) {
            parseOptions = new ParseOptions();
        }
        Object[] b2 = b(e(obj, parseOptions), parseOptions.s(), new Object[3]);
        if (b2 == null || b2[1] != f27762a) {
            return new XMPMetaImpl();
        }
        XMPMetaImpl i2 = ParseRDF.i((Node) b2[0]);
        i2.g((String) b2[2]);
        return !parseOptions.r() ? XMPNormalizer.h(i2, parseOptions) : i2;
    }

    private static Document d(InputSource inputSource) throws XMPException {
        try {
            DocumentBuilder newDocumentBuilder = f27763b.newDocumentBuilder();
            newDocumentBuilder.setErrorHandler((ErrorHandler) null);
            return newDocumentBuilder.parse(inputSource);
        } catch (SAXException e2) {
            throw new XMPException("XML parsing failure", 201, e2);
        } catch (ParserConfigurationException e3) {
            throw new XMPException("XML Parser not correctly configured", 0, e3);
        } catch (IOException e4) {
            throw new XMPException("Error reading the XML-file", 204, e4);
        }
    }

    private static Document e(Object obj, ParseOptions parseOptions) throws XMPException {
        if (obj instanceof InputStream) {
            return g((InputStream) obj, parseOptions);
        }
        return obj instanceof byte[] ? f(new ByteBuffer((byte[]) obj), parseOptions) : h((String) obj, parseOptions);
    }

    private static Document f(ByteBuffer byteBuffer, ParseOptions parseOptions) throws XMPException {
        try {
            return d(new InputSource(byteBuffer.h()));
        } catch (XMPException e2) {
            if (e2.a() == 201 || e2.a() == 204) {
                if (parseOptions.p()) {
                    byteBuffer = Latin1Converter.a(byteBuffer);
                }
                if (!parseOptions.q()) {
                    return d(new InputSource(byteBuffer.h()));
                }
                try {
                    return d(new InputSource(new FixASCIIControlsReader(new InputStreamReader(byteBuffer.h(), byteBuffer.i()))));
                } catch (UnsupportedEncodingException unused) {
                    throw new XMPException("Unsupported Encoding", 9, e2);
                }
            } else {
                throw e2;
            }
        }
    }

    private static Document g(InputStream inputStream, ParseOptions parseOptions) throws XMPException {
        if (!parseOptions.p() && !parseOptions.q()) {
            return d(new InputSource(inputStream));
        }
        try {
            return f(new ByteBuffer(inputStream), parseOptions);
        } catch (IOException e2) {
            throw new XMPException("Error reading the XML-file", 204, e2);
        }
    }

    private static Document h(String str, ParseOptions parseOptions) throws XMPException {
        try {
            return d(new InputSource(new StringReader(str)));
        } catch (XMPException e2) {
            if (e2.a() == 201 && parseOptions.q()) {
                return d(new InputSource(new FixASCIIControlsReader(new StringReader(str))));
            }
            throw e2;
        }
    }
}
