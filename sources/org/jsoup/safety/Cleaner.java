package org.jsoup.safety;

import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.ParseErrorList;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public class Cleaner {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Whitelist f31719a;

    private final class CleaningVisitor implements NodeVisitor {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f31720a;

        /* renamed from: b  reason: collision with root package name */
        private final Element f31721b;

        /* renamed from: c  reason: collision with root package name */
        private Element f31722c;

        private CleaningVisitor(Element element, Element element2) {
            this.f31720a = 0;
            this.f31721b = element;
            this.f31722c = element2;
        }

        public void a(Node node, int i2) {
            Node dataNode;
            if (node instanceof Element) {
                Element element = (Element) node;
                if (Cleaner.this.f31719a.i(element.d3())) {
                    ElementMeta b2 = Cleaner.this.e(element);
                    Element element2 = b2.f31724a;
                    this.f31722c.F0(element2);
                    this.f31720a += b2.f31725b;
                    this.f31722c = element2;
                    return;
                } else if (node == this.f31721b) {
                    return;
                }
            } else {
                if (node instanceof TextNode) {
                    dataNode = new TextNode(((TextNode) node).y0(), node.l());
                } else if ((node instanceof DataNode) && Cleaner.this.f31719a.i(node.S().F())) {
                    dataNode = new DataNode(((DataNode) node).w0(), node.l());
                }
                this.f31722c.F0(dataNode);
                return;
            }
            this.f31720a++;
        }

        public void b(Node node, int i2) {
            if ((node instanceof Element) && Cleaner.this.f31719a.i(node.F())) {
                this.f31722c = this.f31722c.S();
            }
        }
    }

    private static class ElementMeta {

        /* renamed from: a  reason: collision with root package name */
        Element f31724a;

        /* renamed from: b  reason: collision with root package name */
        int f31725b;

        ElementMeta(Element element, int i2) {
            this.f31724a = element;
            this.f31725b = i2;
        }
    }

    public Cleaner(Whitelist whitelist) {
        Validate.j(whitelist);
        this.f31719a = whitelist;
    }

    private int d(Element element, Element element2) {
        CleaningVisitor cleaningVisitor = new CleaningVisitor(element, element2);
        new NodeTraversor(cleaningVisitor).a(element);
        return cleaningVisitor.f31720a;
    }

    /* access modifiers changed from: private */
    public ElementMeta e(Element element) {
        String d3 = element.d3();
        Attributes attributes = new Attributes();
        Element element2 = new Element(Tag.p(d3), element.l(), attributes);
        Iterator<Attribute> it2 = element.i().iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            Attribute next = it2.next();
            if (this.f31719a.h(d3, element, next)) {
                attributes.G(next);
            } else {
                i2++;
            }
        }
        attributes.g(this.f31719a.g(d3));
        return new ElementMeta(element2, i2);
    }

    public Document c(Document document) {
        Validate.j(document);
        Document r3 = Document.r3(document.l());
        if (document.m3() != null) {
            d(document.m3(), r3.m3());
        }
        return r3;
    }

    public boolean f(Document document) {
        Validate.j(document);
        return d(document.m3(), Document.r3(document.l()).m3()) == 0 && document.u3().q().size() == 0;
    }

    public boolean g(String str) {
        Document r3 = Document.r3("");
        Document r32 = Document.r3("");
        ParseErrorList g2 = ParseErrorList.g(1);
        r32.m3().C2(0, Parser.i(str, r32.m3(), "", g2));
        return d(r32.m3(), r3.m3()) == 0 && g2.size() == 0;
    }
}
