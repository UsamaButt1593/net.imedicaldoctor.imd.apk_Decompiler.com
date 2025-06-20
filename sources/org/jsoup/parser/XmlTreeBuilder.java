package org.jsoup.parser;

import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Token;

public class XmlTreeBuilder extends TreeBuilder {

    /* renamed from: org.jsoup.parser.XmlTreeBuilder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31718a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jsoup.parser.Token$TokenType[] r0 = org.jsoup.parser.Token.TokenType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31718a = r0
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.StartTag     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31718a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EndTag     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31718a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Comment     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31718a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Character     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31718a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Doctype     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31718a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EOF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.XmlTreeBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    private void n(Node node) {
        a().F0(node);
    }

    private void q(Token.EndTag endTag) {
        Element element;
        String A = endTag.A();
        int size = this.f31711d.size() - 1;
        while (true) {
            if (size < 0) {
                element = null;
                break;
            }
            element = this.f31711d.get(size);
            if (element.F().equals(A)) {
                break;
            }
            size--;
        }
        if (element != null) {
            int size2 = this.f31711d.size() - 1;
            while (size2 >= 0) {
                Element element2 = this.f31711d.get(size2);
                this.f31711d.remove(size2);
                if (element2 != element) {
                    size2--;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ParseSettings b() {
        return ParseSettings.f31651d;
    }

    /* access modifiers changed from: protected */
    public void c(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        super.c(str, str2, parseErrorList, parseSettings);
        this.f31711d.add(this.f31710c);
        this.f31710c.z3().q(Document.OutputSettings.Syntax.X);
    }

    /* access modifiers changed from: protected */
    public boolean e(Token token) {
        switch (AnonymousClass1.f31718a[token.f31673a.ordinal()]) {
            case 1:
                j(token.e());
                return true;
            case 2:
                q(token.d());
                return true;
            case 3:
                l(token.b());
                return true;
            case 4:
                k(token.a());
                return true;
            case 5:
                m(token.c());
                return true;
            case 6:
                return true;
            default:
                Validate.a("Unexpected token type: " + token.f31673a);
                return true;
        }
    }

    public /* bridge */ /* synthetic */ boolean h(String str, Attributes attributes) {
        return super.h(str, attributes);
    }

    /* access modifiers changed from: package-private */
    public Element j(Token.StartTag startTag) {
        Tag q = Tag.q(startTag.A(), this.f31715h);
        Element element = new Element(q, this.f31712e, this.f31715h.b(startTag.f31690j));
        n(element);
        if (startTag.z()) {
            this.f31709b.a();
            if (!q.j()) {
                q.o();
            }
        } else {
            this.f31711d.add(element);
        }
        return element;
    }

    /* access modifiers changed from: package-private */
    public void k(Token.Character character) {
        n(new TextNode(character.p(), this.f31712e));
    }

    /* JADX WARNING: type inference failed for: r3v4, types: [org.jsoup.nodes.Node, org.jsoup.nodes.XmlDeclaration] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(org.jsoup.parser.Token.Comment r7) {
        /*
            r6 = this;
            org.jsoup.nodes.Comment r0 = new org.jsoup.nodes.Comment
            java.lang.String r1 = r7.o()
            java.lang.String r2 = r6.f31712e
            r0.<init>(r1, r2)
            boolean r7 = r7.f31676c
            if (r7 == 0) goto L_0x007b
            java.lang.String r7 = r0.v0()
            int r1 = r7.length()
            r2 = 1
            if (r1 <= r2) goto L_0x007b
            java.lang.String r1 = "!"
            boolean r3 = r7.startsWith(r1)
            if (r3 != 0) goto L_0x002a
            java.lang.String r3 = "?"
            boolean r3 = r7.startsWith(r3)
            if (r3 == 0) goto L_0x007b
        L_0x002a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<"
            r3.append(r4)
            int r4 = r7.length()
            int r4 = r4 - r2
            java.lang.String r2 = r7.substring(r2, r4)
            r3.append(r2)
            java.lang.String r2 = ">"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = r6.f31712e
            org.jsoup.parser.Parser r4 = org.jsoup.parser.Parser.q()
            org.jsoup.nodes.Document r2 = org.jsoup.Jsoup.l(r2, r3, r4)
            r3 = 0
            org.jsoup.nodes.Element r2 = r2.W0(r3)
            org.jsoup.nodes.XmlDeclaration r3 = new org.jsoup.nodes.XmlDeclaration
            org.jsoup.parser.ParseSettings r4 = r6.f31715h
            java.lang.String r5 = r2.d3()
            java.lang.String r4 = r4.c(r5)
            java.lang.String r0 = r0.l()
            boolean r7 = r7.startsWith(r1)
            r3.<init>(r4, r0, r7)
            org.jsoup.nodes.Attributes r7 = r3.i()
            org.jsoup.nodes.Attributes r0 = r2.i()
            r7.g(r0)
            r0 = r3
        L_0x007b:
            r6.n(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.XmlTreeBuilder.l(org.jsoup.parser.Token$Comment):void");
    }

    /* access modifiers changed from: package-private */
    public void m(Token.Doctype doctype) {
        n(new DocumentType(this.f31715h.c(doctype.o()), doctype.p(), doctype.q(), doctype.r(), this.f31712e));
    }

    /* access modifiers changed from: package-private */
    public Document o(String str, String str2) {
        return d(str, str2, ParseErrorList.d(), ParseSettings.f31651d);
    }

    /* access modifiers changed from: package-private */
    public List<Node> p(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        c(str, str2, parseErrorList, parseSettings);
        i();
        return this.f31710c.q();
    }
}
