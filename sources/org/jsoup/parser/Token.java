package org.jsoup.parser;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.BooleanAttribute;

abstract class Token {

    /* renamed from: a  reason: collision with root package name */
    TokenType f31673a;

    static final class Character extends Token {

        /* renamed from: b  reason: collision with root package name */
        private String f31674b;

        Character() {
            super();
            this.f31673a = TokenType.Character;
        }

        /* access modifiers changed from: package-private */
        public Token l() {
            this.f31674b = null;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Character o(String str) {
            this.f31674b = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public String p() {
            return this.f31674b;
        }

        public String toString() {
            return p();
        }
    }

    static final class Comment extends Token {

        /* renamed from: b  reason: collision with root package name */
        final StringBuilder f31675b = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        boolean f31676c = false;

        Comment() {
            super();
            this.f31673a = TokenType.Comment;
        }

        /* access modifiers changed from: package-private */
        public Token l() {
            Token.m(this.f31675b);
            this.f31676c = false;
            return this;
        }

        /* access modifiers changed from: package-private */
        public String o() {
            return this.f31675b.toString();
        }

        public String toString() {
            return "<!--" + o() + "-->";
        }
    }

    static final class Doctype extends Token {

        /* renamed from: b  reason: collision with root package name */
        final StringBuilder f31677b = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        String f31678c = null;

        /* renamed from: d  reason: collision with root package name */
        final StringBuilder f31679d = new StringBuilder();

        /* renamed from: e  reason: collision with root package name */
        final StringBuilder f31680e = new StringBuilder();

        /* renamed from: f  reason: collision with root package name */
        boolean f31681f = false;

        Doctype() {
            super();
            this.f31673a = TokenType.Doctype;
        }

        /* access modifiers changed from: package-private */
        public Token l() {
            Token.m(this.f31677b);
            this.f31678c = null;
            Token.m(this.f31679d);
            Token.m(this.f31680e);
            this.f31681f = false;
            return this;
        }

        /* access modifiers changed from: package-private */
        public String o() {
            return this.f31677b.toString();
        }

        /* access modifiers changed from: package-private */
        public String p() {
            return this.f31678c;
        }

        /* access modifiers changed from: package-private */
        public String q() {
            return this.f31679d.toString();
        }

        public String r() {
            return this.f31680e.toString();
        }

        public boolean s() {
            return this.f31681f;
        }
    }

    static final class EOF extends Token {
        EOF() {
            super();
            this.f31673a = TokenType.EOF;
        }

        /* access modifiers changed from: package-private */
        public Token l() {
            return this;
        }
    }

    static final class EndTag extends Tag {
        EndTag() {
            this.f31673a = TokenType.EndTag;
        }

        public String toString() {
            return "</" + A() + ">";
        }
    }

    static final class StartTag extends Tag {
        StartTag() {
            this.f31690j = new Attributes();
            this.f31673a = TokenType.StartTag;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: E */
        public Tag l() {
            super.l();
            this.f31690j = new Attributes();
            return this;
        }

        /* access modifiers changed from: package-private */
        public StartTag G(String str, Attributes attributes) {
            this.f31682b = str;
            this.f31690j = attributes;
            this.f31683c = Normalizer.a(str);
            return this;
        }

        public String toString() {
            StringBuilder sb;
            String A;
            Attributes attributes = this.f31690j;
            if (attributes == null || attributes.size() <= 0) {
                sb = new StringBuilder();
                sb.append("<");
                A = A();
            } else {
                sb = new StringBuilder();
                sb.append("<");
                sb.append(A());
                sb.append(StringUtils.SPACE);
                A = this.f31690j.toString();
            }
            sb.append(A);
            sb.append(">");
            return sb.toString();
        }
    }

    static abstract class Tag extends Token {

        /* renamed from: b  reason: collision with root package name */
        protected String f31682b;

        /* renamed from: c  reason: collision with root package name */
        protected String f31683c;

        /* renamed from: d  reason: collision with root package name */
        private String f31684d;

        /* renamed from: e  reason: collision with root package name */
        private StringBuilder f31685e = new StringBuilder();

        /* renamed from: f  reason: collision with root package name */
        private String f31686f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f31687g = false;

        /* renamed from: h  reason: collision with root package name */
        private boolean f31688h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f31689i = false;

        /* renamed from: j  reason: collision with root package name */
        Attributes f31690j;

        Tag() {
            super();
        }

        private void w() {
            this.f31688h = true;
            String str = this.f31686f;
            if (str != null) {
                this.f31685e.append(str);
                this.f31686f = null;
            }
        }

        /* access modifiers changed from: package-private */
        public final String A() {
            String str = this.f31682b;
            Validate.b(str == null || str.length() == 0);
            return this.f31682b;
        }

        /* access modifiers changed from: package-private */
        public final Tag B(String str) {
            this.f31682b = str;
            this.f31683c = Normalizer.a(str);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void C() {
            Attribute attribute;
            if (this.f31690j == null) {
                this.f31690j = new Attributes();
            }
            String str = this.f31684d;
            if (str != null) {
                String trim = str.trim();
                this.f31684d = trim;
                if (trim.length() > 0) {
                    if (this.f31688h) {
                        attribute = new Attribute(this.f31684d, this.f31685e.length() > 0 ? this.f31685e.toString() : this.f31686f);
                    } else {
                        attribute = this.f31687g ? new Attribute(this.f31684d, "") : new BooleanAttribute(this.f31684d);
                    }
                    this.f31690j.G(attribute);
                }
            }
            this.f31684d = null;
            this.f31687g = false;
            this.f31688h = false;
            Token.m(this.f31685e);
            this.f31686f = null;
        }

        /* access modifiers changed from: package-private */
        public final String D() {
            return this.f31683c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: E */
        public Tag l() {
            this.f31682b = null;
            this.f31683c = null;
            this.f31684d = null;
            Token.m(this.f31685e);
            this.f31686f = null;
            this.f31687g = false;
            this.f31688h = false;
            this.f31689i = false;
            this.f31690j = null;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void F() {
            this.f31687g = true;
        }

        /* access modifiers changed from: package-private */
        public final void o(char c2) {
            p(String.valueOf(c2));
        }

        /* access modifiers changed from: package-private */
        public final void p(String str) {
            String str2 = this.f31684d;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f31684d = str;
        }

        /* access modifiers changed from: package-private */
        public final void q(char c2) {
            w();
            this.f31685e.append(c2);
        }

        /* access modifiers changed from: package-private */
        public final void r(String str) {
            w();
            if (this.f31685e.length() == 0) {
                this.f31686f = str;
            } else {
                this.f31685e.append(str);
            }
        }

        /* access modifiers changed from: package-private */
        public final void s(char[] cArr) {
            w();
            this.f31685e.append(cArr);
        }

        /* access modifiers changed from: package-private */
        public final void t(int[] iArr) {
            w();
            for (int appendCodePoint : iArr) {
                this.f31685e.appendCodePoint(appendCodePoint);
            }
        }

        /* access modifiers changed from: package-private */
        public final void u(char c2) {
            v(String.valueOf(c2));
        }

        /* access modifiers changed from: package-private */
        public final void v(String str) {
            String str2 = this.f31682b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f31682b = str;
            this.f31683c = Normalizer.a(str);
        }

        /* access modifiers changed from: package-private */
        public final void x() {
            if (this.f31684d != null) {
                C();
            }
        }

        /* access modifiers changed from: package-private */
        public final Attributes y() {
            return this.f31690j;
        }

        /* access modifiers changed from: package-private */
        public final boolean z() {
            return this.f31689i;
        }
    }

    enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    private Token() {
    }

    static void m(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    /* access modifiers changed from: package-private */
    public final Character a() {
        return (Character) this;
    }

    /* access modifiers changed from: package-private */
    public final Comment b() {
        return (Comment) this;
    }

    /* access modifiers changed from: package-private */
    public final Doctype c() {
        return (Doctype) this;
    }

    /* access modifiers changed from: package-private */
    public final EndTag d() {
        return (EndTag) this;
    }

    /* access modifiers changed from: package-private */
    public final StartTag e() {
        return (StartTag) this;
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return this.f31673a == TokenType.Character;
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        return this.f31673a == TokenType.Comment;
    }

    /* access modifiers changed from: package-private */
    public final boolean h() {
        return this.f31673a == TokenType.Doctype;
    }

    /* access modifiers changed from: package-private */
    public final boolean i() {
        return this.f31673a == TokenType.EOF;
    }

    /* access modifiers changed from: package-private */
    public final boolean j() {
        return this.f31673a == TokenType.EndTag;
    }

    /* access modifiers changed from: package-private */
    public final boolean k() {
        return this.f31673a == TokenType.StartTag;
    }

    /* access modifiers changed from: package-private */
    public abstract Token l();

    /* access modifiers changed from: package-private */
    public String n() {
        return getClass().getSimpleName();
    }
}
