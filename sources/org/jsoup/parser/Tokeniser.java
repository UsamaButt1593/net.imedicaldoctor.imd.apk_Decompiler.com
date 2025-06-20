package org.jsoup.parser;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.Arrays;
import kotlin.text.Typography;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;

final class Tokeniser {
    static final char s = '�';
    private static final char[] t;

    /* renamed from: a  reason: collision with root package name */
    private final CharacterReader f31694a;

    /* renamed from: b  reason: collision with root package name */
    private final ParseErrorList f31695b;

    /* renamed from: c  reason: collision with root package name */
    private TokeniserState f31696c = TokeniserState.Data;

    /* renamed from: d  reason: collision with root package name */
    private Token f31697d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31698e = false;

    /* renamed from: f  reason: collision with root package name */
    private String f31699f = null;

    /* renamed from: g  reason: collision with root package name */
    private StringBuilder f31700g = new StringBuilder(1024);

    /* renamed from: h  reason: collision with root package name */
    StringBuilder f31701h = new StringBuilder(1024);

    /* renamed from: i  reason: collision with root package name */
    Token.Tag f31702i;

    /* renamed from: j  reason: collision with root package name */
    Token.StartTag f31703j = new Token.StartTag();

    /* renamed from: k  reason: collision with root package name */
    Token.EndTag f31704k = new Token.EndTag();

    /* renamed from: l  reason: collision with root package name */
    Token.Character f31705l = new Token.Character();

    /* renamed from: m  reason: collision with root package name */
    Token.Doctype f31706m = new Token.Doctype();

    /* renamed from: n  reason: collision with root package name */
    Token.Comment f31707n = new Token.Comment();
    private String o;
    private boolean p = true;
    private final int[] q = new int[1];
    private final int[] r = new int[2];

    static {
        char[] cArr = {9, 10, 13, 12, ' ', '<', Typography.f29117d};
        t = cArr;
        Arrays.sort(cArr);
    }

    Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.f31694a = characterReader;
        this.f31695b = parseErrorList;
    }

    private void d(String str) {
        if (this.f31695b.b()) {
            this.f31695b.add(new ParseError(this.f31694a.E(), "Invalid character reference: %s", str));
        }
    }

    private void t(String str) {
        if (this.f31695b.b()) {
            this.f31695b.add(new ParseError(this.f31694a.E(), str));
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.p = true;
    }

    /* access modifiers changed from: package-private */
    public void b(TokeniserState tokeniserState) {
        this.f31694a.a();
        this.f31696c = tokeniserState;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        String str = this.o;
        if (str == null) {
            return null;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public int[] e(Character ch, boolean z) {
        int i2;
        if (this.f31694a.r()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.f31694a.q()) || this.f31694a.y(t)) {
            return null;
        }
        int[] iArr = this.q;
        this.f31694a.s();
        if (this.f31694a.t("#")) {
            boolean u = this.f31694a.u("X");
            CharacterReader characterReader = this.f31694a;
            String g2 = u ? characterReader.g() : characterReader.f();
            if (g2.length() == 0) {
                d("numeric reference with no numerals");
            } else {
                if (!this.f31694a.t(";")) {
                    d("missing semicolon");
                }
                try {
                    i2 = Integer.valueOf(g2, u ? 16 : 10).intValue();
                } catch (NumberFormatException unused) {
                    i2 = -1;
                }
                if (i2 == -1 || ((i2 >= 55296 && i2 <= 57343) || i2 > 1114111)) {
                    d("character outside of valid range");
                    iArr[0] = 65533;
                    return iArr;
                }
                iArr[0] = i2;
                return iArr;
            }
        } else {
            String i3 = this.f31694a.i();
            boolean v = this.f31694a.v(ASCIIPropertyListParser.f18655m);
            if (!Entities.i(i3) && (!Entities.j(i3) || !v)) {
                this.f31694a.G();
                if (v) {
                    d(String.format("invalid named referenece '%s'", new Object[]{i3}));
                }
                return null;
            } else if (!z || (!this.f31694a.B() && !this.f31694a.z() && !this.f31694a.x(ASCIIPropertyListParser.f18654l, '-', '_'))) {
                if (!this.f31694a.t(";")) {
                    d("missing semicolon");
                }
                int d2 = Entities.d(i3, this.r);
                if (d2 == 1) {
                    iArr[0] = this.r[0];
                    return iArr;
                } else if (d2 == 2) {
                    return this.r;
                } else {
                    Validate.a("Unexpected characters returned for " + i3);
                    return this.r;
                }
            }
        }
        this.f31694a.G();
        return null;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f31707n.l();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.f31706m.l();
    }

    /* access modifiers changed from: package-private */
    public Token.Tag h(boolean z) {
        Token.Tag E = z ? this.f31703j.l() : this.f31704k.l();
        this.f31702i = E;
        return E;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Token.m(this.f31701h);
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void k(char c2) {
        l(String.valueOf(c2));
    }

    /* access modifiers changed from: package-private */
    public void l(String str) {
        if (this.f31699f == null) {
            this.f31699f = str;
            return;
        }
        if (this.f31700g.length() == 0) {
            this.f31700g.append(this.f31699f);
        }
        this.f31700g.append(str);
    }

    /* access modifiers changed from: package-private */
    public void m(Token token) {
        Validate.c(this.f31698e, "There is an unread token pending!");
        this.f31697d = token;
        this.f31698e = true;
        Token.TokenType tokenType = token.f31673a;
        if (tokenType == Token.TokenType.StartTag) {
            Token.StartTag startTag = (Token.StartTag) token;
            this.o = startTag.f31682b;
            if (startTag.f31689i) {
                this.p = false;
            }
        } else if (tokenType == Token.TokenType.EndTag && ((Token.EndTag) token).f31690j != null) {
            t("Attributes incorrectly present on end tag");
        }
    }

    /* access modifiers changed from: package-private */
    public void n(char[] cArr) {
        l(String.valueOf(cArr));
    }

    /* access modifiers changed from: package-private */
    public void o(int[] iArr) {
        l(new String(iArr, 0, iArr.length));
    }

    /* access modifiers changed from: package-private */
    public void p() {
        m(this.f31707n);
    }

    /* access modifiers changed from: package-private */
    public void q() {
        m(this.f31706m);
    }

    /* access modifiers changed from: package-private */
    public void r() {
        this.f31702i.x();
        m(this.f31702i);
    }

    /* access modifiers changed from: package-private */
    public void s(TokeniserState tokeniserState) {
        if (this.f31695b.b()) {
            this.f31695b.add(new ParseError(this.f31694a.E(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    /* access modifiers changed from: package-private */
    public void u(TokeniserState tokeniserState) {
        if (this.f31695b.b()) {
            this.f31695b.add(new ParseError(this.f31694a.E(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f31694a.q()), tokeniserState));
        }
    }

    /* access modifiers changed from: package-private */
    public TokeniserState v() {
        return this.f31696c;
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        return this.o != null && this.f31702i.A().equalsIgnoreCase(this.o);
    }

    /* access modifiers changed from: package-private */
    public Token x() {
        if (!this.p) {
            t("Self closing flag not acknowledged");
            this.p = true;
        }
        while (!this.f31698e) {
            this.f31696c.n(this, this.f31694a);
        }
        if (this.f31700g.length() > 0) {
            String sb = this.f31700g.toString();
            StringBuilder sb2 = this.f31700g;
            sb2.delete(0, sb2.length());
            this.f31699f = null;
            return this.f31705l.o(sb);
        }
        String str = this.f31699f;
        if (str != null) {
            Token.Character o2 = this.f31705l.o(str);
            this.f31699f = null;
            return o2;
        }
        this.f31698e = false;
        return this.f31697d;
    }

    /* access modifiers changed from: package-private */
    public void y(TokeniserState tokeniserState) {
        this.f31696c = tokeniserState;
    }

    /* access modifiers changed from: package-private */
    public String z(boolean z) {
        StringBuilder sb = new StringBuilder();
        while (!this.f31694a.r()) {
            sb.append(this.f31694a.k(Typography.f29117d));
            if (this.f31694a.v(Typography.f29117d)) {
                this.f31694a.c();
                int[] e2 = e((Character) null, z);
                if (e2 == null || e2.length == 0) {
                    sb.append(Typography.f29117d);
                } else {
                    sb.appendCodePoint(e2[0]);
                    if (e2.length == 2) {
                        sb.appendCodePoint(e2[1]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
