package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.xml.xmp.XmpBasicSchema;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Token;
import org.jsoup.select.Elements;

public class HtmlTreeBuilder extends TreeBuilder {
    private static final String[] A = {HTML.Tag.y, "table"};
    private static final String[] B = {"optgroup", "option"};
    private static final String[] C = {HTML.Tag.t, HTML.Tag.u, "li", "option", "optgroup", "p", "rp", "rt"};
    private static final String[] D = {HTML.Tag.F, "applet", "area", HTML.Tag.G, HTML.Tag.H, "base", "basefont", "bgsound", "blockquote", "body", "br", HTML.Tag.e0, HTML.Tag.f27619g, "center", "col", "colgroup", HTML.Tag.Y, HTML.Tag.t, HTML.Tag.f0, HTML.Attribute.u, "div", "dl", HTML.Tag.u, HTML.Tag.k0, HTML.Tag.L, HTML.Tag.M, HTML.Tag.N, HTML.Tag.O, HTML.Tag.Q, TypedValues.AttributesType.L, "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", HTML.Tag.R, HTML.Tag.S, "hr", HTML.Tag.y, HTML.Tag.p0, "img", HTML.Tag.q0, "isindex", "li", HTML.Tag.C, "listing", "marquee", HTML.Tag.w0, HTML.Tag.D, HTML.Tag.x0, "noembed", "noframes", HTML.Tag.T, HTML.Tag.G0, "ol", "p", "param", "plaintext", "pre", HTML.Tag.A, HTML.Tag.V, HTML.Tag.L0, "style", "summary", "table", HTML.Tag.f27615c, "td", HTML.Tag.Q0, HTML.Tag.f27616d, "th", HTML.Tag.f27614b, "title", "tr", "ul", HTML.Tag.O0, XmpBasicSchema.Z};
    static final /* synthetic */ boolean E = false;
    public static final String[] x = {"applet", HTML.Tag.f27619g, HTML.Tag.y, "table", "td", "th", "marquee", HTML.Tag.G0};
    private static final String[] y = {"ol", "ul"};
    private static final String[] z = {HTML.Tag.e0};

    /* renamed from: k  reason: collision with root package name */
    private HtmlTreeBuilderState f31629k;

    /* renamed from: l  reason: collision with root package name */
    private HtmlTreeBuilderState f31630l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f31631m = false;

    /* renamed from: n  reason: collision with root package name */
    private Element f31632n;
    private FormElement o;
    private Element p;
    private ArrayList<Element> q = new ArrayList<>();
    private List<String> r = new ArrayList();
    private Token.EndTag s = new Token.EndTag();
    private boolean t = true;
    private boolean u = false;
    private boolean v = false;
    private String[] w = {null};

    HtmlTreeBuilder() {
    }

    private boolean I(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.w;
        strArr3[0] = str;
        return J(strArr3, strArr, strArr2);
    }

    private boolean J(String[] strArr, String[] strArr2, String[] strArr3) {
        for (int size = this.f31711d.size() - 1; size >= 0; size--) {
            String F = this.f31711d.get(size).F();
            if (StringUtil.b(F, strArr)) {
                return true;
            }
            if (StringUtil.b(F, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.b(F, strArr3)) {
                return false;
            }
        }
        Validate.a("Should not be reachable");
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void T(org.jsoup.nodes.Node r2) {
        /*
            r1 = this;
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r1.f31711d
            int r0 = r0.size()
            if (r0 != 0) goto L_0x000e
            org.jsoup.nodes.Document r0 = r1.f31710c
        L_0x000a:
            r0.F0(r2)
            goto L_0x001d
        L_0x000e:
            boolean r0 = r1.X()
            if (r0 == 0) goto L_0x0018
            r1.R(r2)
            goto L_0x001d
        L_0x0018:
            org.jsoup.nodes.Element r0 = r1.a()
            goto L_0x000a
        L_0x001d:
            boolean r0 = r2 instanceof org.jsoup.nodes.Element
            if (r0 == 0) goto L_0x0034
            org.jsoup.nodes.Element r2 = (org.jsoup.nodes.Element) r2
            org.jsoup.parser.Tag r0 = r2.c3()
            boolean r0 = r0.g()
            if (r0 == 0) goto L_0x0034
            org.jsoup.nodes.FormElement r0 = r1.o
            if (r0 == 0) goto L_0x0034
            r0.m3(r2)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.T(org.jsoup.nodes.Node):void");
    }

    private boolean W(ArrayList<Element> arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == element) {
                return true;
            }
        }
        return false;
    }

    private boolean a0(Element element, Element element2) {
        return element.F().equals(element2.F()) && element.i().equals(element2.i());
    }

    private void l(String... strArr) {
        int size = this.f31711d.size() - 1;
        while (size >= 0) {
            Element element = this.f31711d.get(size);
            if (!StringUtil.b(element.F(), strArr) && !element.F().equals(HTML.Tag.y)) {
                this.f31711d.remove(size);
                size--;
            } else {
                return;
            }
        }
    }

    private void v0(ArrayList<Element> arrayList, Element element, Element element2) {
        int lastIndexOf = arrayList.lastIndexOf(element);
        Validate.d(lastIndexOf != -1);
        arrayList.set(lastIndexOf, element2);
    }

    /* access modifiers changed from: package-private */
    public List<String> A() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public void A0(Element element) {
        this.f31632n = element;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Element> B() {
        return this.f31711d;
    }

    /* access modifiers changed from: package-private */
    public void B0(List<String> list) {
        this.r = list;
    }

    /* access modifiers changed from: package-private */
    public boolean C(String str) {
        return F(str, z);
    }

    /* access modifiers changed from: package-private */
    public HtmlTreeBuilderState C0() {
        return this.f31629k;
    }

    /* access modifiers changed from: package-private */
    public boolean D(String str) {
        return F(str, y);
    }

    /* access modifiers changed from: package-private */
    public void D0(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.f31629k = htmlTreeBuilderState;
    }

    /* access modifiers changed from: package-private */
    public boolean E(String str) {
        return F(str, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean F(String str, String[] strArr) {
        return I(str, x, strArr);
    }

    /* access modifiers changed from: package-private */
    public boolean G(String[] strArr) {
        return J(strArr, x, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean H(String str) {
        for (int size = this.f31711d.size() - 1; size >= 0; size--) {
            String F = this.f31711d.get(size).F();
            if (F.equals(str)) {
                return true;
            }
            if (!StringUtil.b(F, B)) {
                return false;
            }
        }
        Validate.a("Should not be reachable");
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean K(String str) {
        return I(str, A, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public Element L(Token.StartTag startTag) {
        if (startTag.z()) {
            Element P = P(startTag);
            this.f31711d.add(P);
            this.f31709b.y(TokeniserState.Data);
            this.f31709b.m(this.s.l().B(P.d3()));
            return P;
        }
        Element element = new Element(Tag.q(startTag.A(), this.f31715h), this.f31712e, this.f31715h.b(startTag.f31690j));
        M(element);
        return element;
    }

    /* access modifiers changed from: package-private */
    public void M(Element element) {
        T(element);
        this.f31711d.add(element);
    }

    /* access modifiers changed from: package-private */
    public void N(Token.Character character) {
        String d3 = a().d3();
        a().F0((d3.equals(HTML.Tag.A) || d3.equals("style")) ? new DataNode(character.p(), this.f31712e) : new TextNode(character.p(), this.f31712e));
    }

    /* access modifiers changed from: package-private */
    public void O(Token.Comment comment) {
        T(new Comment(comment.o(), this.f31712e));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0026, code lost:
        if (r0.l() != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jsoup.nodes.Element P(org.jsoup.parser.Token.StartTag r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.A()
            org.jsoup.parser.ParseSettings r1 = r4.f31715h
            org.jsoup.parser.Tag r0 = org.jsoup.parser.Tag.q(r0, r1)
            org.jsoup.nodes.Element r1 = new org.jsoup.nodes.Element
            java.lang.String r2 = r4.f31712e
            org.jsoup.nodes.Attributes r3 = r5.f31690j
            r1.<init>(r0, r2, r3)
            r4.T(r1)
            boolean r5 = r5.z()
            if (r5 == 0) goto L_0x0032
            boolean r5 = r0.j()
            if (r5 == 0) goto L_0x002e
            boolean r5 = r0.l()
            if (r5 == 0) goto L_0x0032
        L_0x0028:
            org.jsoup.parser.Tokeniser r5 = r4.f31709b
            r5.a()
            goto L_0x0032
        L_0x002e:
            r0.o()
            goto L_0x0028
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.P(org.jsoup.parser.Token$StartTag):org.jsoup.nodes.Element");
    }

    /* access modifiers changed from: package-private */
    public FormElement Q(Token.StartTag startTag, boolean z2) {
        FormElement formElement = new FormElement(Tag.q(startTag.A(), this.f31715h), this.f31712e, startTag.f31690j);
        y0(formElement);
        T(formElement);
        if (z2) {
            this.f31711d.add(formElement);
        }
        return formElement;
    }

    /* access modifiers changed from: package-private */
    public void R(Node node) {
        Element element;
        Element y2 = y("table");
        boolean z2 = false;
        if (y2 == null) {
            element = this.f31711d.get(0);
        } else if (y2.S() != null) {
            element = y2.S();
            z2 = true;
        } else {
            element = j(y2);
        }
        if (z2) {
            Validate.j(y2);
            y2.n(node);
            return;
        }
        element.F0(node);
    }

    /* access modifiers changed from: package-private */
    public void S() {
        this.q.add((Object) null);
    }

    /* access modifiers changed from: package-private */
    public void U(Element element, Element element2) {
        int lastIndexOf = this.f31711d.lastIndexOf(element);
        Validate.d(lastIndexOf != -1);
        this.f31711d.add(lastIndexOf + 1, element2);
    }

    /* access modifiers changed from: package-private */
    public Element V(String str) {
        Element element = new Element(Tag.q(str, this.f31715h), this.f31712e);
        M(element);
        return element;
    }

    /* access modifiers changed from: package-private */
    public boolean X() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public boolean Y() {
        return this.v;
    }

    /* access modifiers changed from: package-private */
    public boolean Z(Element element) {
        return W(this.q, element);
    }

    /* access modifiers changed from: package-private */
    public ParseSettings b() {
        return ParseSettings.f31650c;
    }

    /* access modifiers changed from: package-private */
    public boolean b0(Element element) {
        return StringUtil.b(element.F(), D);
    }

    /* access modifiers changed from: package-private */
    public Element c0() {
        if (this.q.size() <= 0) {
            return null;
        }
        ArrayList<Element> arrayList = this.q;
        return arrayList.get(arrayList.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public Document d(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        this.f31629k = HtmlTreeBuilderState.Initial;
        this.f31631m = false;
        return super.d(str, str2, parseErrorList, parseSettings);
    }

    /* access modifiers changed from: package-private */
    public void d0() {
        this.f31630l = this.f31629k;
    }

    /* access modifiers changed from: protected */
    public boolean e(Token token) {
        this.f31713f = token;
        return this.f31629k.k(token, this);
    }

    /* access modifiers changed from: package-private */
    public void e0(Element element) {
        if (!this.f31631m) {
            String a2 = element.a("href");
            if (a2.length() != 0) {
                this.f31712e = a2;
                this.f31631m = true;
                this.f31710c.l0(a2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f0() {
        this.r = new ArrayList();
    }

    /* access modifiers changed from: package-private */
    public boolean g0(Element element) {
        return W(this.f31711d, element);
    }

    public /* bridge */ /* synthetic */ boolean h(String str, Attributes attributes) {
        return super.h(str, attributes);
    }

    /* access modifiers changed from: package-private */
    public HtmlTreeBuilderState h0() {
        return this.f31630l;
    }

    /* access modifiers changed from: package-private */
    public List<Node> i0(String str, Element element, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        Element element2;
        Tokeniser tokeniser;
        TokeniserState tokeniserState;
        this.f31629k = HtmlTreeBuilderState.Initial;
        c(str, str2, parseErrorList, parseSettings);
        this.p = element;
        this.v = true;
        if (element != null) {
            if (element.Q() != null) {
                this.f31710c.C3(element.Q().B3());
            }
            String d3 = element.d3();
            if (StringUtil.b(d3, "title", HTML.Tag.Q0)) {
                tokeniser = this.f31709b;
                tokeniserState = TokeniserState.Rcdata;
            } else if (StringUtil.b(d3, HTML.Tag.p0, "noembed", "noframes", "style", XmpBasicSchema.Z)) {
                tokeniser = this.f31709b;
                tokeniserState = TokeniserState.Rawtext;
            } else if (d3.equals(HTML.Tag.A)) {
                tokeniser = this.f31709b;
                tokeniserState = TokeniserState.ScriptData;
            } else {
                if (!d3.equals(HTML.Tag.T)) {
                    boolean equals = d3.equals("plaintext");
                }
                tokeniser = this.f31709b;
                tokeniserState = TokeniserState.Data;
            }
            tokeniser.y(tokeniserState);
            element2 = new Element(Tag.q(HTML.Tag.y, parseSettings), str2);
            this.f31710c.F0(element2);
            this.f31711d.add(element2);
            x0();
            Elements S2 = element.S2();
            S2.add(0, element);
            Iterator it2 = S2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Element element3 = (Element) it2.next();
                if (element3 instanceof FormElement) {
                    this.o = (FormElement) element3;
                    break;
                }
            }
        } else {
            element2 = null;
        }
        i();
        return (element == null || element2 == null) ? this.f31710c.q() : element2.q();
    }

    /* access modifiers changed from: package-private */
    public Element j(Element element) {
        for (int size = this.f31711d.size() - 1; size >= 0; size--) {
            if (this.f31711d.get(size) == element) {
                return this.f31711d.get(size - 1);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Element j0() {
        return this.f31711d.remove(this.f31711d.size() - 1);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000c, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k() {
        /*
            r1 = this;
        L_0x0000:
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r1.q
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x000e
            org.jsoup.nodes.Element r0 = r1.t0()
            if (r0 != 0) goto L_0x0000
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.k():void");
    }

    /* access modifiers changed from: package-private */
    public void k0(String str) {
        int size = this.f31711d.size() - 1;
        while (size >= 0 && !this.f31711d.get(size).F().equals(str)) {
            this.f31711d.remove(size);
            size--;
        }
    }

    /* access modifiers changed from: package-private */
    public void l0(String str) {
        int size = this.f31711d.size() - 1;
        while (size >= 0) {
            this.f31711d.remove(size);
            if (!this.f31711d.get(size).F().equals(str)) {
                size--;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        l(HTML.Tag.f27615c, HTML.Tag.f27616d, HTML.Tag.f27614b);
    }

    /* access modifiers changed from: package-private */
    public void m0(String... strArr) {
        int size = this.f31711d.size() - 1;
        while (size >= 0) {
            this.f31711d.remove(size);
            if (!StringUtil.b(this.f31711d.get(size).F(), strArr)) {
                size--;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        l("table");
    }

    /* access modifiers changed from: package-private */
    public boolean n0(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.f31713f = token;
        return htmlTreeBuilderState.k(token, this);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        l("tr");
    }

    /* access modifiers changed from: package-private */
    public void o0(Element element) {
        this.f31711d.add(element);
    }

    /* access modifiers changed from: package-private */
    public void p(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.f31714g.b()) {
            this.f31714g.add(new ParseError(this.f31708a.E(), "Unexpected token [%s] when in state [%s]", this.f31713f.n(), htmlTreeBuilderState));
        }
    }

    /* access modifiers changed from: package-private */
    public void p0(Element element) {
        int size = this.q.size() - 1;
        int i2 = 0;
        while (true) {
            if (size >= 0) {
                Element element2 = this.q.get(size);
                if (element2 == null) {
                    break;
                }
                if (a0(element, element2)) {
                    i2++;
                }
                if (i2 == 3) {
                    this.q.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.q.add(element);
    }

    /* access modifiers changed from: package-private */
    public void q(boolean z2) {
        this.t = z2;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    void q0() {
        /*
            r7 = this;
            org.jsoup.nodes.Element r0 = r7.c0()
            if (r0 == 0) goto L_0x0056
            boolean r1 = r7.g0(r0)
            if (r1 == 0) goto L_0x000d
            goto L_0x0056
        L_0x000d:
            java.util.ArrayList<org.jsoup.nodes.Element> r1 = r7.q
            int r1 = r1.size()
            r2 = 1
            int r1 = r1 - r2
            r3 = r1
        L_0x0016:
            r4 = 0
            if (r3 != 0) goto L_0x001a
            goto L_0x002d
        L_0x001a:
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r7.q
            int r3 = r3 + -1
            java.lang.Object r0 = r0.get(r3)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            if (r0 == 0) goto L_0x002c
            boolean r5 = r7.g0(r0)
            if (r5 == 0) goto L_0x0016
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r2 != 0) goto L_0x0039
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r7.q
            int r3 = r3 + 1
            java.lang.Object r0 = r0.get(r3)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
        L_0x0039:
            org.jsoup.helper.Validate.j(r0)
            java.lang.String r2 = r0.F()
            org.jsoup.nodes.Element r2 = r7.V(r2)
            org.jsoup.nodes.Attributes r5 = r2.i()
            org.jsoup.nodes.Attributes r6 = r0.i()
            r5.g(r6)
            java.util.ArrayList<org.jsoup.nodes.Element> r5 = r7.q
            r5.set(r3, r2)
            if (r3 != r1) goto L_0x002c
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.q0():void");
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public void r0(Element element) {
        for (int size = this.q.size() - 1; size >= 0; size--) {
            if (this.q.get(size) == element) {
                this.q.remove(size);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        t((String) null);
    }

    /* access modifiers changed from: package-private */
    public boolean s0(Element element) {
        for (int size = this.f31711d.size() - 1; size >= 0; size--) {
            if (this.f31711d.get(size) == element) {
                this.f31711d.remove(size);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void t(String str) {
        while (str != null && !a().F().equals(str) && StringUtil.b(a().F(), C)) {
            j0();
        }
    }

    /* access modifiers changed from: package-private */
    public Element t0() {
        int size = this.q.size();
        if (size > 0) {
            return this.q.remove(size - 1);
        }
        return null;
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.f31713f + ", state=" + this.f31629k + ", currentElement=" + a() + ASCIIPropertyListParser.f18653k;
    }

    /* access modifiers changed from: package-private */
    public Element u(String str) {
        for (int size = this.q.size() - 1; size >= 0; size--) {
            Element element = this.q.get(size);
            if (element == null) {
                return null;
            }
            if (element.F().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void u0(Element element, Element element2) {
        v0(this.q, element, element2);
    }

    /* access modifiers changed from: package-private */
    public String v() {
        return this.f31712e;
    }

    /* access modifiers changed from: package-private */
    public Document w() {
        return this.f31710c;
    }

    /* access modifiers changed from: package-private */
    public void w0(Element element, Element element2) {
        v0(this.f31711d, element, element2);
    }

    /* access modifiers changed from: package-private */
    public FormElement x() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public void x0() {
        HtmlTreeBuilderState htmlTreeBuilderState;
        int size = this.f31711d.size() - 1;
        boolean z2 = false;
        while (size >= 0) {
            Element element = this.f31711d.get(size);
            if (size == 0) {
                element = this.p;
                z2 = true;
            }
            String F = element.F();
            if (HTML.Tag.L0.equals(F)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InSelect;
            } else if ("td".equals(F) || ("th".equals(F) && !z2)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InCell;
            } else if ("tr".equals(F)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InRow;
            } else if (HTML.Tag.f27615c.equals(F) || HTML.Tag.f27614b.equals(F) || HTML.Tag.f27616d.equals(F)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InTableBody;
            } else if (HTML.Tag.f27619g.equals(F)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InCaption;
            } else if ("colgroup".equals(F)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InColumnGroup;
            } else if ("table".equals(F)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InTable;
            } else {
                if (!"head".equals(F) && !"body".equals(F)) {
                    if ("frameset".equals(F)) {
                        htmlTreeBuilderState = HtmlTreeBuilderState.InFrameset;
                    } else if (HTML.Tag.y.equals(F)) {
                        htmlTreeBuilderState = HtmlTreeBuilderState.BeforeHead;
                    } else if (!z2) {
                        size--;
                    }
                }
                htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
            }
            D0(htmlTreeBuilderState);
            return;
        }
    }

    /* access modifiers changed from: package-private */
    public Element y(String str) {
        for (int size = this.f31711d.size() - 1; size >= 0; size--) {
            Element element = this.f31711d.get(size);
            if (element.F().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void y0(FormElement formElement) {
        this.o = formElement;
    }

    /* access modifiers changed from: package-private */
    public Element z() {
        return this.f31632n;
    }

    /* access modifiers changed from: package-private */
    public void z0(boolean z2) {
        this.u = z2;
    }
}
