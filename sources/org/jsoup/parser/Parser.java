package org.jsoup.parser;

import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class Parser {

    /* renamed from: e  reason: collision with root package name */
    private static final int f31654e = 0;

    /* renamed from: a  reason: collision with root package name */
    private TreeBuilder f31655a;

    /* renamed from: b  reason: collision with root package name */
    private int f31656b = 0;

    /* renamed from: c  reason: collision with root package name */
    private ParseErrorList f31657c;

    /* renamed from: d  reason: collision with root package name */
    private ParseSettings f31658d;

    public Parser(TreeBuilder treeBuilder) {
        this.f31655a = treeBuilder;
        this.f31658d = treeBuilder.b();
    }

    public static Parser c() {
        return new Parser(new HtmlTreeBuilder());
    }

    public static Document e(String str, String str2) {
        HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
        return htmlTreeBuilder.d(str, str2, ParseErrorList.d(), htmlTreeBuilder.b());
    }

    public static Document f(String str, String str2) {
        Document r3 = Document.r3(str2);
        Element m3 = r3.m3();
        List<Node> h2 = h(str, m3, str2);
        Node[] nodeArr = (Node[]) h2.toArray(new Node[h2.size()]);
        for (int length = nodeArr.length - 1; length > 0; length--) {
            nodeArr[length].Y();
        }
        for (Node F0 : nodeArr) {
            m3.F0(F0);
        }
        return r3;
    }

    public static Document g(String str, String str2) {
        return e(str, str2);
    }

    public static List<Node> h(String str, Element element, String str2) {
        HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
        return htmlTreeBuilder.i0(str, element, str2, ParseErrorList.d(), htmlTreeBuilder.b());
    }

    public static List<Node> i(String str, Element element, String str2, ParseErrorList parseErrorList) {
        HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
        return htmlTreeBuilder.i0(str, element, str2, parseErrorList, htmlTreeBuilder.b());
    }

    public static List<Node> k(String str, String str2) {
        XmlTreeBuilder xmlTreeBuilder = new XmlTreeBuilder();
        return xmlTreeBuilder.p(str, str2, ParseErrorList.d(), xmlTreeBuilder.b());
    }

    public static String p(String str, boolean z) {
        return new Tokeniser(new CharacterReader(str), ParseErrorList.d()).z(z);
    }

    public static Parser q() {
        return new Parser(new XmlTreeBuilder());
    }

    public List<ParseError> a() {
        return this.f31657c;
    }

    public TreeBuilder b() {
        return this.f31655a;
    }

    public boolean d() {
        return this.f31656b > 0;
    }

    public Document j(String str, String str2) {
        ParseErrorList g2 = d() ? ParseErrorList.g(this.f31656b) : ParseErrorList.d();
        this.f31657c = g2;
        return this.f31655a.d(str, str2, g2, this.f31658d);
    }

    public Parser l(int i2) {
        this.f31656b = i2;
        return this;
    }

    public Parser m(TreeBuilder treeBuilder) {
        this.f31655a = treeBuilder;
        return this;
    }

    public ParseSettings n() {
        return this.f31658d;
    }

    public Parser o(ParseSettings parseSettings) {
        this.f31658d = parseSettings;
        return this;
    }
}
