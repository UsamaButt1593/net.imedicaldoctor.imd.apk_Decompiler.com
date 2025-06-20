package org.jsoup.helper;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class W3CDom {

    /* renamed from: a  reason: collision with root package name */
    protected DocumentBuilderFactory f31604a = DocumentBuilderFactory.newInstance();

    protected static class W3CBuilder implements NodeVisitor {

        /* renamed from: d  reason: collision with root package name */
        private static final String f31605d = "xmlns";

        /* renamed from: e  reason: collision with root package name */
        private static final String f31606e = "xmlns:";

        /* renamed from: a  reason: collision with root package name */
        private final Document f31607a;

        /* renamed from: b  reason: collision with root package name */
        private final HashMap<String, String> f31608b = new HashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private Element f31609c;

        public W3CBuilder(Document document) {
            this.f31607a = document;
        }

        private void c(Node node, Element element) {
            Iterator<Attribute> it2 = node.i().iterator();
            while (it2.hasNext()) {
                Attribute next = it2.next();
                String replaceAll = next.getKey().replaceAll("[^-a-zA-Z0-9_:.]", "");
                if (replaceAll.matches("[a-zA-Z_:]{1}[-a-zA-Z0-9_:.]*")) {
                    element.setAttribute(replaceAll, next.getValue());
                }
            }
        }

        private String d(org.jsoup.nodes.Element element) {
            String str;
            Iterator<Attribute> it2 = element.i().iterator();
            while (true) {
                str = "";
                if (!it2.hasNext()) {
                    break;
                }
                Attribute next = it2.next();
                String c2 = next.getKey();
                if (!c2.equals("xmlns")) {
                    if (c2.startsWith(f31606e)) {
                        str = c2.substring(6);
                    }
                }
                this.f31608b.put(str, next.getValue());
            }
            int indexOf = element.d3().indexOf(":");
            return indexOf > 0 ? element.d3().substring(0, indexOf) : str;
        }

        public void a(Node node, int i2) {
            Document document;
            String w0;
            org.w3c.dom.Node createComment;
            if (node instanceof org.jsoup.nodes.Element) {
                org.jsoup.nodes.Element element = (org.jsoup.nodes.Element) node;
                String d2 = d(element);
                Element createElementNS = this.f31607a.createElementNS(this.f31608b.get(d2), element.d3());
                c(element, createElementNS);
                org.w3c.dom.Node node2 = this.f31609c;
                if (node2 == null) {
                    node2 = this.f31607a;
                }
                node2.appendChild(createElementNS);
                this.f31609c = createElementNS;
                return;
            }
            if (node instanceof TextNode) {
                document = this.f31607a;
                w0 = ((TextNode) node).y0();
            } else if (node instanceof Comment) {
                createComment = this.f31607a.createComment(((Comment) node).v0());
                this.f31609c.appendChild(createComment);
            } else if (node instanceof DataNode) {
                document = this.f31607a;
                w0 = ((DataNode) node).w0();
            } else {
                return;
            }
            createComment = document.createTextNode(w0);
            this.f31609c.appendChild(createComment);
        }

        public void b(Node node, int i2) {
            if ((node instanceof org.jsoup.nodes.Element) && (this.f31609c.getParentNode() instanceof Element)) {
                this.f31609c = (Element) this.f31609c.getParentNode();
            }
        }
    }

    public String a(Document document) {
        try {
            DOMSource dOMSource = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(dOMSource, new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (TransformerException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void b(org.jsoup.nodes.Document document, Document document2) {
        if (!StringUtil.d(document.v3())) {
            document2.setDocumentURI(document.v3());
        }
        new NodeTraversor(new W3CBuilder(document2)).a(document.W0(0));
    }

    public Document c(org.jsoup.nodes.Document document) {
        Validate.j(document);
        try {
            this.f31604a.setNamespaceAware(true);
            Document newDocument = this.f31604a.newDocumentBuilder().newDocument();
            b(document, newDocument);
            return newDocument;
        } catch (ParserConfigurationException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
