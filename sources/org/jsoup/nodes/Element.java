package org.jsoup.nodes;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Document;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.QueryParser;
import org.jsoup.select.Selector;

public class Element extends Node {
    private static final Pattern b3 = Pattern.compile("\\s+");
    /* access modifiers changed from: private */
    public Tag Z2;
    private WeakReference<List<Element>> a3;

    public Element(String str) {
        this(Tag.p(str), "", new Attributes());
    }

    private static <E extends Element> int B2(Element element, List<E> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2) == element) {
                return i2;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static void H0(StringBuilder sb, TextNode textNode) {
        String y0 = textNode.y0();
        if (X2(textNode.s)) {
            sb.append(y0);
        } else {
            StringUtil.a(sb, y0, TextNode.C0(sb));
        }
    }

    private static void L0(Element element, StringBuilder sb) {
        if (element.Z2.c().equals("br") && !TextNode.C0(sb)) {
            sb.append(StringUtils.SPACE);
        }
    }

    private void P2(StringBuilder sb) {
        for (Node next : this.X) {
            if (next instanceof TextNode) {
                H0(sb, (TextNode) next);
            } else if (next instanceof Element) {
                L0((Element) next, sb);
            }
        }
    }

    static boolean X2(Node node) {
        if (node == null || !(node instanceof Element)) {
            return false;
        }
        Element element = (Element) node;
        return element.Z2.m() || (element.S() != null && element.S().Z2.m());
    }

    private List<Element> Y0() {
        List<Element> list;
        WeakReference<List<Element>> weakReference = this.a3;
        if (weakReference != null && (list = weakReference.get()) != null) {
            return list;
        }
        int size = this.X.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            Node node = this.X.get(i2);
            if (node instanceof Element) {
                arrayList.add((Element) node);
            }
        }
        this.a3 = new WeakReference<>(arrayList);
        return arrayList;
    }

    private void u2(StringBuilder sb) {
        for (Node K : this.X) {
            K.K(sb);
        }
    }

    private static void y0(Element element, Elements elements) {
        Element Q2 = element.S();
        if (Q2 != null && !Q2.d3().equals("#root")) {
            elements.add(Q2);
            y0(Q2, elements);
        }
    }

    public Elements A1(String str) {
        Validate.h(str);
        return Collector.a(new Evaluator.AttributeStarting(str.trim()), this);
    }

    public <T extends Appendable> T B(T t) {
        for (Node K : this.X) {
            K.K(t);
        }
        return t;
    }

    /* renamed from: C0 */
    public Element e(String str) {
        return (Element) super.e(str);
    }

    public Elements C1(String str, String str2) {
        return Collector.a(new Evaluator.AttributeWithValue(str, str2), this);
    }

    public Element C2(int i2, Collection<? extends Node> collection) {
        Validate.k(collection, "Children collection to be inserted must not be null.");
        int p = p();
        if (i2 < 0) {
            i2 += p + 1;
        }
        Validate.e(i2 >= 0 && i2 <= p, "Insert position out of bounds.");
        ArrayList arrayList = new ArrayList(collection);
        b(i2, (Node[]) arrayList.toArray(new Node[arrayList.size()]));
        return this;
    }

    /* renamed from: D0 */
    public Element f(Node node) {
        return (Element) super.f(node);
    }

    public Elements D1(String str, String str2) {
        return Collector.a(new Evaluator.AttributeWithValueContaining(str, str2), this);
    }

    public Element E0(String str) {
        Validate.j(str);
        List<Node> h2 = Parser.h(str, this, l());
        c((Node[]) h2.toArray(new Node[h2.size()]));
        return this;
    }

    public Element E2(int i2, Node... nodeArr) {
        Validate.k(nodeArr, "Children collection to be inserted must not be null.");
        int p = p();
        if (i2 < 0) {
            i2 += p + 1;
        }
        Validate.e(i2 >= 0 && i2 <= p, "Insert position out of bounds.");
        b(i2, nodeArr);
        return this;
    }

    public String F() {
        return this.Z2.c();
    }

    public Element F0(Node node) {
        Validate.j(node);
        f0(node);
        w();
        this.X.add(node);
        node.o0(this.X.size() - 1);
        return this;
    }

    public Elements F1(String str, String str2) {
        return Collector.a(new Evaluator.AttributeWithValueEnding(str, str2), this);
    }

    /* access modifiers changed from: package-private */
    public void G() {
        super.G();
        this.a3 = null;
    }

    public Element G0(String str) {
        Element element = new Element(Tag.p(str), l());
        F0(element);
        return element;
    }

    public boolean G2(String str) {
        return I2(QueryParser.t(str));
    }

    public Elements H1(String str, String str2) {
        try {
            return O1(str, Pattern.compile(str2));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException("Pattern syntax error: " + str2, e2);
        }
    }

    public boolean I2(Evaluator evaluator) {
        return evaluator.a((Element) k0(), this);
    }

    public boolean J2() {
        return this.Z2.d();
    }

    public Element K0(String str) {
        Validate.j(str);
        F0(new TextNode(str, l()));
        return this;
    }

    /* access modifiers changed from: package-private */
    public void L(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        String str;
        if (outputSettings.o() && ((this.Z2.b() || ((S() != null && S().c3().b()) || outputSettings.m())) && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0))) {
            D(appendable, i2, outputSettings);
        }
        appendable.append("<").append(d3());
        this.Y.B(appendable, outputSettings);
        if (!this.X.isEmpty() || !this.Z2.l()) {
            str = ">";
        } else if (outputSettings.p() != Document.OutputSettings.Syntax.s || !this.Z2.f()) {
            str = " />";
        } else {
            appendable.append('>');
            return;
        }
        appendable.append(str);
    }

    public Element L2() {
        List<Element> Y0 = S().Y0();
        if (Y0.size() > 1) {
            return Y0.get(Y0.size() - 1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void M(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (!this.X.isEmpty() || !this.Z2.l()) {
            if (outputSettings.o() && !this.X.isEmpty() && (this.Z2.b() || (outputSettings.m() && (this.X.size() > 1 || (this.X.size() == 1 && !(this.X.get(0) instanceof TextNode)))))) {
                D(appendable, i2, outputSettings);
            }
            appendable.append("</").append(d3()).append(">");
        }
    }

    /* renamed from: M0 */
    public Element h(String str, String str2) {
        super.h(str, str2);
        return this;
    }

    public Element M2() {
        if (this.s == null) {
            return null;
        }
        List<Element> Y0 = S().Y0();
        int B2 = B2(this, Y0);
        Validate.j(Integer.valueOf(B2));
        int i2 = B2 + 1;
        if (Y0.size() > i2) {
            return Y0.get(i2);
        }
        return null;
    }

    public String N2() {
        StringBuilder sb = new StringBuilder();
        P2(sb);
        return sb.toString().trim();
    }

    public Element O0(String str, boolean z) {
        this.Y.E(str, z);
        return this;
    }

    public Elements O1(String str, Pattern pattern) {
        return Collector.a(new Evaluator.AttributeWithValueMatching(str, pattern), this);
    }

    /* renamed from: Q2 */
    public final Element S() {
        return (Element) this.s;
    }

    /* renamed from: R0 */
    public Element m(String str) {
        return (Element) super.m(str);
    }

    public Elements R1(String str, String str2) {
        return Collector.a(new Evaluator.AttributeWithValueNot(str, str2), this);
    }

    /* renamed from: S0 */
    public Element n(Node node) {
        return (Element) super.n(node);
    }

    public Elements S1(String str, String str2) {
        return Collector.a(new Evaluator.AttributeWithValueStarting(str, str2), this);
    }

    public Elements S2() {
        Elements elements = new Elements();
        y0(this, elements);
        return elements;
    }

    public Elements T1(String str) {
        Validate.h(str);
        return Collector.a(new Evaluator.Class(str), this);
    }

    public Element T2(String str) {
        Validate.j(str);
        List<Node> h2 = Parser.h(str, this, l());
        b(0, (Node[]) h2.toArray(new Node[h2.size()]));
        return this;
    }

    public Elements U1(int i2) {
        return Collector.a(new Evaluator.IndexEquals(i2), this);
    }

    public Element U2(Node node) {
        Validate.j(node);
        b(0, node);
        return this;
    }

    public Element V2(String str) {
        Element element = new Element(Tag.p(str), l());
        U2(element);
        return element;
    }

    public Element W0(int i2) {
        return Y0().get(i2);
    }

    public Element W2(String str) {
        Validate.j(str);
        U2(new TextNode(str, l()));
        return this;
    }

    public Element Y2() {
        if (this.s == null) {
            return null;
        }
        List<Element> Y0 = S().Y0();
        int B2 = B2(this, Y0);
        Validate.j(Integer.valueOf(B2));
        if (B2 > 0) {
            return Y0.get(B2 - 1);
        }
        return null;
    }

    public Element Z2(String str) {
        Validate.j(str);
        Set<String> d1 = d1();
        d1.remove(str);
        e1(d1);
        return this;
    }

    public Elements a2(int i2) {
        return Collector.a(new Evaluator.IndexGreaterThan(i2), this);
    }

    public Elements a3(String str) {
        return Selector.d(str, this);
    }

    public Elements b1() {
        return new Elements(Y0());
    }

    public Elements b2(int i2) {
        return Collector.a(new Evaluator.IndexLessThan(i2), this);
    }

    public Elements b3() {
        if (this.s == null) {
            return new Elements(0);
        }
        List<Element> Y0 = S().Y0();
        Elements elements = new Elements(Y0.size() - 1);
        for (Element next : Y0) {
            if (next != this) {
                elements.add(next);
            }
        }
        return elements;
    }

    public String c1() {
        return g("class").trim();
    }

    public Tag c3() {
        return this.Z2;
    }

    public Set<String> d1() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(b3.split(c1())));
        linkedHashSet.remove("");
        return linkedHashSet;
    }

    public Elements d2(String str) {
        Validate.h(str);
        return Collector.a(new Evaluator.Tag(Normalizer.b(str)), this);
    }

    public String d3() {
        return this.Z2.c();
    }

    public Element e1(Set<String> set) {
        Validate.j(set);
        this.Y.D("class", StringUtil.g(set, StringUtils.SPACE));
        return this;
    }

    public Elements e2(String str) {
        return Collector.a(new Evaluator.ContainsOwnText(str), this);
    }

    public Element e3(String str) {
        Validate.i(str, "Tag name must not be empty.");
        this.Z2 = Tag.q(str, ParseSettings.f31651d);
        return this;
    }

    public Elements f2(String str) {
        return Collector.a(new Evaluator.ContainsText(str), this);
    }

    public String f3() {
        final StringBuilder sb = new StringBuilder();
        new NodeTraversor(new NodeVisitor() {
            public void a(Node node, int i2) {
                if (node instanceof TextNode) {
                    Element.H0(sb, (TextNode) node);
                } else if (node instanceof Element) {
                    Element element = (Element) node;
                    if (sb.length() <= 0) {
                        return;
                    }
                    if ((element.J2() || element.Z2.c().equals("br")) && !TextNode.C0(sb)) {
                        sb.append(StringUtils.SPACE);
                    }
                }
            }

            public void b(Node node, int i2) {
            }
        }).a(this);
        return sb.toString().trim();
    }

    /* renamed from: g1 */
    public Element u() {
        return (Element) super.clone();
    }

    public Elements g2(String str) {
        try {
            return i2(Pattern.compile(str));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException("Pattern syntax error: " + str, e2);
        }
    }

    public Element g3(String str) {
        Validate.j(str);
        t1();
        F0(new TextNode(str, this.Z));
        return this;
    }

    public String h1() {
        StringBuilder sb;
        String sb2;
        if (w2().length() > 0) {
            sb = new StringBuilder();
            sb.append("#");
            sb2 = w2();
        } else {
            StringBuilder sb3 = new StringBuilder(d3().replace(ASCIIPropertyListParser.A, '|'));
            String g2 = StringUtil.g(d1(), ".");
            if (g2.length() > 0) {
                sb3.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                sb3.append(g2);
            }
            if (S() == null || (S() instanceof Document)) {
                return sb3.toString();
            }
            sb3.insert(0, " > ");
            if (S().a3(sb3.toString()).size() > 1) {
                sb3.append(String.format(":nth-child(%d)", new Object[]{Integer.valueOf(r1() + 1)}));
            }
            sb = new StringBuilder();
            sb.append(S().h1());
            sb2 = sb3.toString();
        }
        sb.append(sb2);
        return sb.toString();
    }

    public List<TextNode> h3() {
        ArrayList arrayList = new ArrayList();
        for (Node next : this.X) {
            if (next instanceof TextNode) {
                arrayList.add((TextNode) next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Elements i2(Pattern pattern) {
        return Collector.a(new Evaluator.MatchesOwn(pattern), this);
    }

    public Element i3(String str) {
        Validate.j(str);
        Set<String> d1 = d1();
        if (d1.contains(str)) {
            d1.remove(str);
        } else {
            d1.add(str);
        }
        e1(d1);
        return this;
    }

    public String j1() {
        String j1;
        StringBuilder sb = new StringBuilder();
        for (Node next : this.X) {
            if (next instanceof DataNode) {
                j1 = ((DataNode) next).w0();
            } else if (next instanceof Comment) {
                j1 = ((Comment) next).v0();
            } else if (next instanceof Element) {
                j1 = ((Element) next).j1();
            }
            sb.append(j1);
        }
        return sb.toString();
    }

    public Elements j2(String str) {
        try {
            return m2(Pattern.compile(str));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException("Pattern syntax error: " + str, e2);
        }
    }

    public String j3() {
        return d3().equals(HTML.Tag.Q0) ? f3() : g("value");
    }

    public List<DataNode> k1() {
        ArrayList arrayList = new ArrayList();
        for (Node next : this.X) {
            if (next instanceof DataNode) {
                arrayList.add((DataNode) next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Element k3(String str) {
        if (d3().equals(HTML.Tag.Q0)) {
            g3(str);
        } else {
            h("value", str);
        }
        return this;
    }

    public Map<String, String> l1() {
        return this.Y.o();
    }

    /* renamed from: l3 */
    public Element u0(String str) {
        return (Element) super.u0(str);
    }

    public Elements m2(Pattern pattern) {
        return Collector.a(new Evaluator.Matches(pattern), this);
    }

    public boolean n2(String str) {
        String r = this.Y.r("class");
        int length = r.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(r);
            }
            boolean z = false;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (Character.isWhitespace(r.charAt(i3))) {
                    if (!z) {
                        continue;
                    } else if (i3 - i2 == length2 && r.regionMatches(true, i2, str, 0, length2)) {
                        return true;
                    } else {
                        z = false;
                    }
                } else if (!z) {
                    i2 = i3;
                    z = true;
                }
            }
            if (z && length - i2 == length2) {
                return r.regionMatches(true, i2, str, 0, length2);
            }
        }
        return false;
    }

    public boolean p2() {
        for (Node next : this.X) {
            if (next instanceof TextNode) {
                if (!((TextNode) next).z0()) {
                    return true;
                }
            } else if ((next instanceof Element) && ((Element) next).p2()) {
                return true;
            }
        }
        return false;
    }

    public String q2() {
        StringBuilder sb = new StringBuilder();
        u2(sb);
        boolean o = y().o();
        String sb2 = sb.toString();
        return o ? sb2.trim() : sb2;
    }

    public int r1() {
        if (S() == null) {
            return 0;
        }
        return B2(this, S().Y0());
    }

    public Element r2(String str) {
        t1();
        E0(str);
        return this;
    }

    public Element t1() {
        this.X.clear();
        return this;
    }

    public String toString() {
        return J();
    }

    public Element u1() {
        List<Element> Y0 = S().Y0();
        if (Y0.size() > 1) {
            return Y0.get(0);
        }
        return null;
    }

    public Elements w1() {
        return Collector.a(new Evaluator.AllElements(), this);
    }

    public String w2() {
        return this.Y.r("id");
    }

    public Element y1(String str) {
        Validate.h(str);
        Elements a2 = Collector.a(new Evaluator.Id(str), this);
        if (a2.size() > 0) {
            return (Element) a2.get(0);
        }
        return null;
    }

    public Element z0(String str) {
        Validate.j(str);
        Set<String> d1 = d1();
        d1.add(str);
        e1(d1);
        return this;
    }

    public Elements z1(String str) {
        Validate.h(str);
        return Collector.a(new Evaluator.Attribute(str.trim()), this);
    }

    public Element(Tag tag, String str) {
        this(tag, str, new Attributes());
    }

    public Element(Tag tag, String str, Attributes attributes) {
        super(str, attributes);
        Validate.j(tag);
        this.Z2 = tag;
    }
}
