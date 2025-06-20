package org.jsoup.parser;

import java.util.ArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Token;

abstract class TreeBuilder {

    /* renamed from: a  reason: collision with root package name */
    CharacterReader f31708a;

    /* renamed from: b  reason: collision with root package name */
    Tokeniser f31709b;

    /* renamed from: c  reason: collision with root package name */
    protected Document f31710c;

    /* renamed from: d  reason: collision with root package name */
    protected ArrayList<Element> f31711d;

    /* renamed from: e  reason: collision with root package name */
    protected String f31712e;

    /* renamed from: f  reason: collision with root package name */
    protected Token f31713f;

    /* renamed from: g  reason: collision with root package name */
    protected ParseErrorList f31714g;

    /* renamed from: h  reason: collision with root package name */
    protected ParseSettings f31715h;

    /* renamed from: i  reason: collision with root package name */
    private Token.StartTag f31716i = new Token.StartTag();

    /* renamed from: j  reason: collision with root package name */
    private Token.EndTag f31717j = new Token.EndTag();

    TreeBuilder() {
    }

    /* access modifiers changed from: protected */
    public Element a() {
        int size = this.f31711d.size();
        if (size > 0) {
            return this.f31711d.get(size - 1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract ParseSettings b();

    /* access modifiers changed from: protected */
    public void c(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        Validate.k(str, "String input must not be null");
        Validate.k(str2, "BaseURI must not be null");
        this.f31710c = new Document(str2);
        this.f31715h = parseSettings;
        this.f31708a = new CharacterReader(str);
        this.f31714g = parseErrorList;
        this.f31709b = new Tokeniser(this.f31708a, parseErrorList);
        this.f31711d = new ArrayList<>(32);
        this.f31712e = str2;
    }

    /* access modifiers changed from: package-private */
    public Document d(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        c(str, str2, parseErrorList, parseSettings);
        i();
        return this.f31710c;
    }

    /* access modifiers changed from: protected */
    public abstract boolean e(Token token);

    /* access modifiers changed from: protected */
    public boolean f(String str) {
        Token token = this.f31713f;
        Token.EndTag endTag = this.f31717j;
        return e((token == endTag ? new Token.EndTag() : endTag.l()).B(str));
    }

    /* access modifiers changed from: protected */
    public boolean g(String str) {
        Token token = this.f31713f;
        Token.StartTag startTag = this.f31716i;
        return e((token == startTag ? new Token.StartTag() : startTag.l()).B(str));
    }

    public boolean h(String str, Attributes attributes) {
        Token.StartTag startTag;
        Token token = this.f31713f;
        Token.StartTag startTag2 = this.f31716i;
        if (token == startTag2) {
            startTag = new Token.StartTag().G(str, attributes);
        } else {
            startTag2.l();
            this.f31716i.G(str, attributes);
            startTag = this.f31716i;
        }
        return e(startTag);
    }

    /* access modifiers changed from: protected */
    public void i() {
        Token x;
        do {
            x = this.f31709b.x();
            e(x);
            x.l();
        } while (x.f31673a != Token.TokenType.EOF);
    }
}
