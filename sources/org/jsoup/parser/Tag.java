package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.html.HTML;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;

public class Tag {

    /* renamed from: j  reason: collision with root package name */
    private static final Map<String, Tag> f31659j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f31660k;

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f31661l = {HTML.Tag.G0, "base", "font", "tt", "i", "b", "u", HTML.Tag.T0, "small", "em", "strong", HTML.Tag.j0, HTML.Tag.g0, HTML.Tag.D0, HTML.Tag.y0, HTML.Tag.R0, HTML.Tag.l0, HTML.Tag.b0, HTML.Tag.P0, "acronym", HTML.Tag.A0, "ruby", "rt", "rp", "a", "img", "br", HTML.Tag.O0, HTML.Tag.t0, HTML.Tag.C0, "sub", "sup", HTML.Tag.d0, HTML.Tag.p0, HTML.Tag.k0, "span", HTML.Tag.q0, HTML.Tag.L0, HTML.Tag.Q0, "label", HTML.Tag.e0, "optgroup", "option", "legend", HTML.Tag.i0, HTML.Tag.u0, HTML.Tag.U, "progress", HTML.Tag.v0, "area", "param", "source", "track", "summary", HTML.Tag.Y, "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s"};

    /* renamed from: m  reason: collision with root package name */
    private static final String[] f31662m = {HTML.Tag.D, HTML.Tag.C, "base", TypedValues.AttributesType.L, "img", "br", HTML.Tag.O0, HTML.Tag.k0, "hr", HTML.Tag.q0, HTML.Tag.u0, "col", HTML.Tag.Y, "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};

    /* renamed from: n  reason: collision with root package name */
    private static final String[] f31663n = {"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", HTML.Tag.F, "li", "th", "td", HTML.Tag.A, "style", HTML.Tag.s0, HTML.Tag.h0, "s"};
    private static final String[] o = {"pre", "plaintext", "title", HTML.Tag.Q0};
    private static final String[] p = {HTML.Tag.e0, HTML.Tag.L, HTML.Tag.q0, HTML.Tag.u0, HTML.Tag.G0, HTML.Tag.U, HTML.Tag.L0, HTML.Tag.Q0};
    private static final String[] q = {HTML.Tag.q0, HTML.Tag.u0, HTML.Tag.G0, HTML.Tag.L0, HTML.Tag.Q0};

    /* renamed from: a  reason: collision with root package name */
    private String f31664a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31665b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31666c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31667d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31668e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31669f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31670g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f31671h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31672i = false;

    static {
        String[] strArr = {HTML.Tag.y, "head", "body", "frameset", HTML.Tag.A, HTML.Tag.T, "style", HTML.Tag.D, HTML.Tag.C, "title", TypedValues.AttributesType.L, "noframes", HTML.Tag.V, HTML.Tag.x0, HTML.Tag.H, HTML.Tag.S, HTML.Tag.R, HTML.Tag.O, "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", HTML.Tag.F, HTML.Tag.N, HTML.Tag.M, HTML.Tag.Q, HTML.Tag.L, HTML.Tag.s0, HTML.Tag.h0, "dl", HTML.Tag.u, HTML.Tag.t, "li", "table", HTML.Tag.f27619g, HTML.Tag.f27614b, HTML.Tag.f27616d, HTML.Tag.f27615c, "colgroup", "col", "tr", "th", "td", "video", "audio", HTML.Tag.K, HTML.Tag.f0, HTML.Tag.w0, "plaintext", "template", HTML.Tag.G, "main", HTML.Tag.N0, HTML.Tag.z0};
        f31660k = strArr;
        for (String tag : strArr) {
            n(new Tag(tag));
        }
        for (String tag2 : f31661l) {
            Tag tag3 = new Tag(tag2);
            tag3.f31665b = false;
            tag3.f31666c = false;
            n(tag3);
        }
        for (String str : f31662m) {
            Tag tag4 = f31659j.get(str);
            Validate.j(tag4);
            tag4.f31667d = false;
            tag4.f31668e = true;
        }
        for (String str2 : f31663n) {
            Tag tag5 = f31659j.get(str2);
            Validate.j(tag5);
            tag5.f31666c = false;
        }
        for (String str3 : o) {
            Tag tag6 = f31659j.get(str3);
            Validate.j(tag6);
            tag6.f31670g = true;
        }
        for (String str4 : p) {
            Tag tag7 = f31659j.get(str4);
            Validate.j(tag7);
            tag7.f31671h = true;
        }
        for (String str5 : q) {
            Tag tag8 = f31659j.get(str5);
            Validate.j(tag8);
            tag8.f31672i = true;
        }
    }

    private Tag(String str) {
        this.f31664a = str;
    }

    public static boolean k(String str) {
        return f31659j.containsKey(str);
    }

    private static void n(Tag tag) {
        f31659j.put(tag.f31664a, tag);
    }

    public static Tag p(String str) {
        return q(str, ParseSettings.f31651d);
    }

    public static Tag q(String str, ParseSettings parseSettings) {
        Validate.j(str);
        Map<String, Tag> map = f31659j;
        Tag tag = map.get(str);
        if (tag != null) {
            return tag;
        }
        String c2 = parseSettings.c(str);
        Validate.h(c2);
        Tag tag2 = map.get(c2);
        if (tag2 != null) {
            return tag2;
        }
        Tag tag3 = new Tag(c2);
        tag3.f31665b = false;
        return tag3;
    }

    public boolean a() {
        return this.f31665b;
    }

    public boolean b() {
        return this.f31666c;
    }

    public String c() {
        return this.f31664a;
    }

    public boolean d() {
        return this.f31665b;
    }

    public boolean e() {
        return !this.f31667d && !f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        return this.f31664a.equals(tag.f31664a) && this.f31667d == tag.f31667d && this.f31668e == tag.f31668e && this.f31666c == tag.f31666c && this.f31665b == tag.f31665b && this.f31670g == tag.f31670g && this.f31669f == tag.f31669f && this.f31671h == tag.f31671h && this.f31672i == tag.f31672i;
    }

    public boolean f() {
        return this.f31668e;
    }

    public boolean g() {
        return this.f31671h;
    }

    public boolean h() {
        return this.f31672i;
    }

    public int hashCode() {
        return (((((((((((((((this.f31664a.hashCode() * 31) + (this.f31665b ? 1 : 0)) * 31) + (this.f31666c ? 1 : 0)) * 31) + (this.f31667d ? 1 : 0)) * 31) + (this.f31668e ? 1 : 0)) * 31) + (this.f31669f ? 1 : 0)) * 31) + (this.f31670g ? 1 : 0)) * 31) + (this.f31671h ? 1 : 0)) * 31) + (this.f31672i ? 1 : 0);
    }

    public boolean i() {
        return !this.f31665b;
    }

    public boolean j() {
        return f31659j.containsKey(this.f31664a);
    }

    public boolean l() {
        return this.f31668e || this.f31669f;
    }

    public boolean m() {
        return this.f31670g;
    }

    /* access modifiers changed from: package-private */
    public Tag o() {
        this.f31669f = true;
        return this;
    }

    public String toString() {
        return this.f31664a;
    }
}
