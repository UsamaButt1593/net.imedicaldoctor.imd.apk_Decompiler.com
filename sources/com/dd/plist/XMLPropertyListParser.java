package com.dd.plist;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

public class XMLPropertyListParser {

    /* renamed from: a  reason: collision with root package name */
    private static DocumentBuilderFactory f18692a;

    protected XMLPropertyListParser() {
    }

    private static List<Node> a(NodeList nodeList) {
        ArrayList arrayList = new ArrayList(nodeList.getLength());
        for (int i2 = 0; i2 < nodeList.getLength(); i2++) {
            if (nodeList.item(i2).getNodeType() == 1) {
                arrayList.add(nodeList.item(i2));
            }
        }
        return arrayList;
    }

    private static synchronized DocumentBuilder b() throws ParserConfigurationException {
        DocumentBuilder newDocumentBuilder;
        synchronized (XMLPropertyListParser.class) {
            try {
                if (f18692a == null) {
                    d();
                }
                newDocumentBuilder = f18692a.newDocumentBuilder();
                newDocumentBuilder.setEntityResolver(new EntityResolver() {
                    public InputSource resolveEntity(String str, String str2) {
                        if ("-//Apple Computer//DTD PLIST 1.0//EN".equals(str) || "-//Apple//DTD PLIST 1.0//EN".equals(str)) {
                            return new InputSource(new ByteArrayInputStream(new byte[0]));
                        }
                        return null;
                    }
                });
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return newDocumentBuilder;
    }

    private static String c(Node node) {
        if (node.getNodeType() == 3 || node.getNodeType() == 4) {
            String wholeText = ((Text) node).getWholeText();
            return wholeText == null ? "" : wholeText;
        }
        if (node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                Node item = childNodes.item(i2);
                if (item.getNodeType() == 3 || item.getNodeType() == 4) {
                    String wholeText2 = ((Text) item).getWholeText();
                    return wholeText2 == null ? "" : wholeText2;
                }
            }
        }
        return "";
    }

    private static synchronized void d() throws ParserConfigurationException {
        synchronized (XMLPropertyListParser.class) {
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            f18692a = newInstance;
            newInstance.setIgnoringComments(true);
            f18692a.setCoalescing(true);
        }
    }

    public static NSObject e(File file) throws Exception {
        return h(b().parse(file));
    }

    public static NSObject f(InputStream inputStream) throws Exception {
        return h(b().parse(inputStream));
    }

    public static NSObject g(byte[] bArr) throws Exception {
        return f(new ByteArrayInputStream(bArr));
    }

    private static NSObject h(Document document) throws Exception {
        DocumentType doctype = document.getDoctype();
        if (doctype == null) {
            if (!document.getDocumentElement().getNodeName().equals("plist")) {
                throw new UnsupportedOperationException("The given XML document is not a property list.");
            }
        } else if (!doctype.getName().equals("plist")) {
            throw new UnsupportedOperationException("The given XML document is not a property list.");
        }
        boolean equals = document.getDocumentElement().getNodeName().equals("plist");
        Node documentElement = document.getDocumentElement();
        if (equals) {
            List<Node> a2 = a(documentElement.getChildNodes());
            if (a2.isEmpty()) {
                throw new Exception("The given property list has no root element!");
            } else if (a2.size() == 1) {
                documentElement = a2.get(0);
            } else {
                throw new Exception("The given property list has more than one root element!");
            }
        }
        return i(documentElement);
    }

    private static NSObject i(Node node) throws Exception {
        String nodeName = node.getNodeName();
        int i2 = 0;
        if (nodeName.equals("dict")) {
            NSDictionary nSDictionary = new NSDictionary();
            List<Node> a2 = a(node.getChildNodes());
            while (i2 < a2.size()) {
                nSDictionary.put(c(a2.get(i2)), i(a2.get(i2 + 1)));
                i2 += 2;
            }
            return nSDictionary;
        } else if (nodeName.equals("array")) {
            List<Node> a3 = a(node.getChildNodes());
            NSArray nSArray = new NSArray(a3.size());
            while (i2 < a3.size()) {
                nSArray.I(i2, i(a3.get(i2)));
                i2++;
            }
            return nSArray;
        } else if (nodeName.equals(PdfBoolean.l3)) {
            return new NSNumber(true);
        } else {
            if (nodeName.equals("false")) {
                return new NSNumber(false);
            }
            if (nodeName.equals(TypedValues.Custom.f3949b)) {
                return new NSNumber(c(node));
            }
            if (nodeName.equals("real")) {
                return new NSNumber(c(node));
            }
            if (nodeName.equals(TypedValues.Custom.f3952e)) {
                return new NSString(c(node));
            }
            if (nodeName.equals("data")) {
                return new NSData(c(node));
            }
            if (nodeName.equals(DublinCoreProperties.f27398d)) {
                return new NSDate(c(node));
            }
            return null;
        }
    }
}
