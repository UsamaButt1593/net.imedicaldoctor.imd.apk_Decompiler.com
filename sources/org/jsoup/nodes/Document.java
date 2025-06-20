package org.jsoup.nodes;

import com.itextpdf.tool.xml.html.HTML;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class Document extends Element {
    private OutputSettings c3 = new OutputSettings();
    private QuirksMode d3 = QuirksMode.noQuirks;
    private String e3;
    private boolean f3 = false;

    public static class OutputSettings implements Cloneable {
        private Charset X = Charset.forName("UTF-8");
        private int X2 = 1;
        private boolean Y = true;
        private Syntax Y2 = Syntax.s;
        private boolean Z = false;
        private Entities.EscapeMode s = Entities.EscapeMode.base;

        public enum Syntax {
            s,
            X
        }

        public Charset a() {
            return this.X;
        }

        public OutputSettings b(String str) {
            c(Charset.forName(str));
            return this;
        }

        public OutputSettings c(Charset charset) {
            this.X = charset;
            return this;
        }

        /* renamed from: d */
        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.b(this.X.name());
                outputSettings.s = Entities.EscapeMode.valueOf(this.s.name());
                return outputSettings;
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }

        /* access modifiers changed from: package-private */
        public CharsetEncoder e() {
            return this.X.newEncoder();
        }

        public OutputSettings f(Entities.EscapeMode escapeMode) {
            this.s = escapeMode;
            return this;
        }

        public Entities.EscapeMode g() {
            return this.s;
        }

        public int h() {
            return this.X2;
        }

        public OutputSettings i(int i2) {
            Validate.d(i2 >= 0);
            this.X2 = i2;
            return this;
        }

        public OutputSettings l(boolean z) {
            this.Z = z;
            return this;
        }

        public boolean m() {
            return this.Z;
        }

        public OutputSettings n(boolean z) {
            this.Y = z;
            return this;
        }

        public boolean o() {
            return this.Y;
        }

        public Syntax p() {
            return this.Y2;
        }

        public OutputSettings q(Syntax syntax) {
            this.Y2 = syntax;
            return this;
        }
    }

    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(Tag.q("#root", ParseSettings.f31650c), str);
        this.e3 = str;
    }

    public static Document r3(String str) {
        Validate.j(str);
        Document document = new Document(str);
        Element G0 = document.G0(HTML.Tag.y);
        G0.G0("head");
        G0.G0("body");
        return document;
    }

    private void s3() {
        XmlDeclaration xmlDeclaration;
        if (this.f3) {
            OutputSettings.Syntax p = z3().p();
            if (p == OutputSettings.Syntax.s) {
                Element x = a3("meta[charset]").x();
                if (x == null) {
                    Element u3 = u3();
                    if (u3 != null) {
                        x = u3.G0(HTML.Tag.D);
                    }
                    a3("meta[name=charset]").w0();
                }
                x.h("charset", n3().displayName());
                a3("meta[name=charset]").w0();
            } else if (p == OutputSettings.Syntax.X) {
                Node node = q().get(0);
                if (node instanceof XmlDeclaration) {
                    XmlDeclaration xmlDeclaration2 = (XmlDeclaration) node;
                    if (xmlDeclaration2.w0().equals(HTML.Tag.f27613a)) {
                        xmlDeclaration2.h("encoding", n3().displayName());
                        if (xmlDeclaration2.g("version") != null) {
                            xmlDeclaration2.h("version", "1.0");
                            return;
                        }
                        return;
                    }
                    xmlDeclaration = new XmlDeclaration(HTML.Tag.f27613a, this.Z, false);
                } else {
                    xmlDeclaration = new XmlDeclaration(HTML.Tag.f27613a, this.Z, false);
                }
                xmlDeclaration.h("version", "1.0");
                xmlDeclaration.h("encoding", n3().displayName());
                U2(xmlDeclaration);
            }
        }
    }

    private Element t3(String str, Node node) {
        if (node.F().equals(str)) {
            return (Element) node;
        }
        for (Node t3 : node.X) {
            Element t32 = t3(str, t3);
            if (t32 != null) {
                return t32;
            }
        }
        return null;
    }

    private void x3(String str, Element element) {
        Elements d2 = d2(str);
        Element x = d2.x();
        if (d2.size() > 1) {
            ArrayList<Node> arrayList = new ArrayList<>();
            for (int i2 = 1; i2 < d2.size(); i2++) {
                Node node = (Node) d2.get(i2);
                for (Node add : node.X) {
                    arrayList.add(add);
                }
                node.Y();
            }
            for (Node F0 : arrayList) {
                x.F0(F0);
            }
        }
        if (!x.S().equals(element)) {
            element.F0(x);
        }
    }

    private void y3(Element element) {
        ArrayList arrayList = new ArrayList();
        for (Node next : element.X) {
            if (next instanceof TextNode) {
                TextNode textNode = (TextNode) next;
                if (!textNode.z0()) {
                    arrayList.add(textNode);
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Node node = (Node) arrayList.get(size);
            element.c0(node);
            m3().U2(new TextNode(StringUtils.SPACE, ""));
            m3().U2(node);
        }
    }

    public Document A3(OutputSettings outputSettings) {
        Validate.j(outputSettings);
        this.c3 = outputSettings;
        return this;
    }

    public QuirksMode B3() {
        return this.d3;
    }

    public Document C3(QuirksMode quirksMode) {
        this.d3 = quirksMode;
        return this;
    }

    public String D3() {
        Element x = d2("title").x();
        return x != null ? StringUtil.i(x.f3()).trim() : "";
    }

    public void E3(String str) {
        Validate.j(str);
        Element x = d2("title").x();
        if (x == null) {
            u3().G0("title").g3(str);
        } else {
            x.g3(str);
        }
    }

    public String F() {
        return "#document";
    }

    public void F3(boolean z) {
        this.f3 = z;
    }

    public boolean G3() {
        return this.f3;
    }

    public String J() {
        return super.q2();
    }

    public Element g3(String str) {
        m3().g3(str);
        return this;
    }

    public Element m3() {
        return t3("body", this);
    }

    public Charset n3() {
        return this.c3.a();
    }

    public void o3(Charset charset) {
        F3(true);
        this.c3.c(charset);
        s3();
    }

    /* renamed from: p3 */
    public Document u() {
        Document document = (Document) super.u();
        document.c3 = this.c3.clone();
        return document;
    }

    public Element q3(String str) {
        return new Element(Tag.q(str, ParseSettings.f31651d), l());
    }

    public Element u3() {
        return t3("head", this);
    }

    public String v3() {
        return this.e3;
    }

    public Document w3() {
        Element t3 = t3(HTML.Tag.y, this);
        if (t3 == null) {
            t3 = G0(HTML.Tag.y);
        }
        if (u3() == null) {
            t3.V2("head");
        }
        if (m3() == null) {
            t3.G0("body");
        }
        y3(u3());
        y3(t3);
        y3(this);
        x3("head", t3);
        x3("body", t3);
        s3();
        return this;
    }

    public OutputSettings z3() {
        return this.c3;
    }
}
