package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.xml.XmlDomWriter;
import com.itextpdf.xmp.XMPConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Deprecated
public class XmpReader {

    /* renamed from: b  reason: collision with root package name */
    public static final String f27434b = "                                                                                                   \n";

    /* renamed from: c  reason: collision with root package name */
    public static final String f27435c = "<?xpacket begin=\"﻿\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>\n";

    /* renamed from: d  reason: collision with root package name */
    public static final String f27436d = "<?xpacket end=\"w\"?>";

    /* renamed from: a  reason: collision with root package name */
    private Document f27437a;

    public XmpReader(byte[] bArr) throws SAXException, IOException {
        try {
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            this.f27437a = newInstance.newDocumentBuilder().parse(new ByteArrayInputStream(bArr));
        } catch (ParserConfigurationException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean a(String str, String str2, String str3, String str4) {
        NodeList elementsByTagName = this.f27437a.getElementsByTagName(str);
        if (elementsByTagName.getLength() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
            Node item = elementsByTagName.item(i2);
            NamedNodeMap attributes = item.getAttributes();
            for (int i3 = 0; i3 < attributes.getLength(); i3++) {
                Node item2 = attributes.item(i3);
                if (str2.equals(item2.getNodeValue())) {
                    String localName = item2.getLocalName();
                    Element createElementNS = this.f27437a.createElementNS(str2, str3);
                    createElementNS.setPrefix(localName);
                    createElementNS.appendChild(this.f27437a.createTextNode(str4));
                    item.appendChild(createElementNS);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean b(String str, String str2, String str3) {
        NodeList elementsByTagNameNS = this.f27437a.getElementsByTagNameNS(XMPConst.g1, "Description");
        if (elementsByTagNameNS.getLength() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < elementsByTagNameNS.getLength(); i2++) {
            Node namedItemNS = elementsByTagNameNS.item(i2).getAttributes().getNamedItemNS(str, str2);
            if (namedItemNS != null) {
                namedItemNS.setNodeValue(str3);
                return true;
            }
        }
        return false;
    }

    public boolean c(String str, String str2, String str3) {
        NodeList elementsByTagNameNS = this.f27437a.getElementsByTagNameNS(str, str2);
        if (elementsByTagNameNS.getLength() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < elementsByTagNameNS.getLength(); i2++) {
            e(this.f27437a, elementsByTagNameNS.item(i2), str3);
        }
        return true;
    }

    public byte[] d() throws IOException {
        XmlDomWriter xmlDomWriter = new XmlDomWriter();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlDomWriter.d(byteArrayOutputStream, (String) null);
        byteArrayOutputStream.write(f27435c.getBytes("UTF-8"));
        byteArrayOutputStream.flush();
        xmlDomWriter.g(this.f27437a.getElementsByTagName("x:xmpmeta").item(0));
        byteArrayOutputStream.flush();
        for (int i2 = 0; i2 < 20; i2++) {
            byteArrayOutputStream.write(f27434b.getBytes());
        }
        byteArrayOutputStream.write(f27436d.getBytes());
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public boolean e(Document document, Node node, String str) {
        if (node == null) {
            return false;
        }
        while (true) {
            Node firstChild = node.getFirstChild();
            if (firstChild != null) {
                node.removeChild(firstChild);
            } else {
                node.appendChild(document.createTextNode(str));
                return true;
            }
        }
    }
}
