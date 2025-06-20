package com.itextpdf.tool.xml.html;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class HTML {

    public static final class Attribute {

        /* renamed from: a  reason: collision with root package name */
        public static final String f27590a = "alt";

        /* renamed from: b  reason: collision with root package name */
        public static final String f27591b = "cellpadding";

        /* renamed from: c  reason: collision with root package name */
        public static final String f27592c = "cellspacing";

        /* renamed from: d  reason: collision with root package name */
        public static final String f27593d = "style";

        /* renamed from: e  reason: collision with root package name */
        public static final String f27594e = "class";

        /* renamed from: f  reason: collision with root package name */
        public static final String f27595f = "id";

        /* renamed from: g  reason: collision with root package name */
        public static final String f27596g = "href";

        /* renamed from: h  reason: collision with root package name */
        public static final String f27597h = "name";

        /* renamed from: i  reason: collision with root package name */
        public static final String f27598i = "src";

        /* renamed from: j  reason: collision with root package name */
        public static final String f27599j = "width";

        /* renamed from: k  reason: collision with root package name */
        public static final String f27600k = "height";

        /* renamed from: l  reason: collision with root package name */
        public static final String f27601l = "type";

        /* renamed from: m  reason: collision with root package name */
        public static final String f27602m = "colspan";

        /* renamed from: n  reason: collision with root package name */
        public static final String f27603n = "rowspan";
        public static final String o = "valign";
        public static final String p = "align";
        public static final String q = "face";
        public static final String r = "size";
        public static final String s = "color";
        public static final String t = "start";
        public static final String u = "dir";

        public static final class Value {

            /* renamed from: a  reason: collision with root package name */
            public static final String f27604a = "text/css";

            private Value() {
            }
        }

        private Attribute() {
        }
    }

    public static final class Category {

        /* renamed from: a  reason: collision with root package name */
        public static final Set<String> f27605a = new HashSet(Arrays.asList(new String[]{Tag.y, "head", Tag.D, Tag.A, Tag.C, "style", "title"}));

        /* renamed from: b  reason: collision with root package name */
        public static final Set<String> f27606b = new HashSet(Arrays.asList(new String[]{Tag.F, Tag.G, Tag.H, "audio", "blockquote", Tag.K, Tag.t, "div", Tag.L, Tag.M, Tag.N, Tag.O, Tag.Q, "h1", "h2", "h3", "h4", "h5", "h6", Tag.R, Tag.S, "hr", Tag.T, "ol", Tag.U, "p", "pre", Tag.V, "table", "ul", "video"}));

        /* renamed from: c  reason: collision with root package name */
        public static final Set<String> f27607c = new HashSet(Arrays.asList(new String[]{"base", Tag.Y, Tag.C, Tag.D, Tag.T, "style", "title"}));

        /* renamed from: d  reason: collision with root package name */
        public static final Set<String> f27608d = new HashSet(Arrays.asList(new String[]{"a", Tag.b0, Tag.F, Tag.G, Tag.H, "audio", "b", Tag.d0, "blockquote", "br", Tag.e0, Tag.K, Tag.l0, Tag.g0, Tag.Y, Tag.i0, Tag.h0, Tag.f0, Tag.j0, "div", "dl", "em", Tag.k0, Tag.L, Tag.N, Tag.O, Tag.Q, "h1", "h2", "h3", "h4", "h5", "h6", Tag.R, Tag.S, "hr", "i", Tag.p0, "img", Tag.q0, Tag.s0, Tag.y0, Tag.u0, "label", Tag.t0, Tag.A0, Tag.z0, Tag.w0, Tag.v0, Tag.x0, Tag.T, Tag.G0, "ol", Tag.U, "p", "pre", "progress", Tag.C0, "ruby", Tag.D0, Tag.A, Tag.V, Tag.L0, "small", "span", "font", "strong", "sub", "sup", Tag.N0, "table", Tag.Q0, Tag.P0, "ul", Tag.R0, "video", Tag.O0}));

        /* renamed from: e  reason: collision with root package name */
        public static final Set<String> f27609e = new HashSet(Arrays.asList(new String[]{Tag.G, Tag.H, Tag.x0, Tag.V}));

        /* renamed from: f  reason: collision with root package name */
        public static final Set<String> f27610f = new HashSet(Arrays.asList(new String[]{"h1", "h2", "h3", "h4", "h5", "h6", Tag.S}));

        /* renamed from: g  reason: collision with root package name */
        public static final Set<String> f27611g = new HashSet(Arrays.asList(new String[]{Tag.b0, "audio", "b", Tag.d0, "br", Tag.e0, Tag.K, Tag.l0, Tag.g0, Tag.Y, Tag.i0, Tag.j0, "em", Tag.k0, "i", Tag.p0, "img", Tag.q0, Tag.y0, Tag.u0, "label", Tag.A0, Tag.z0, Tag.v0, Tag.T, Tag.G0, Tag.U, "progress", Tag.C0, "ruby", Tag.D0, Tag.A, Tag.L0, "small", "span", "font", "strong", "sub", "sup", Tag.N0, Tag.Q0, Tag.P0, Tag.R0, "video", Tag.O0}));

        /* renamed from: h  reason: collision with root package name */
        public static final Set<String> f27612h = new HashSet(Arrays.asList(new String[]{"audio", Tag.K, Tag.k0, Tag.p0, "img", Tag.z0, Tag.G0, Tag.N0, "video"}));

        private Category() {
        }
    }

    public static final class Tag {
        public static final String A = "script";
        public static final String A0 = "mark";
        public static final String B = "head";
        public static final String B0 = "label";
        public static final String C = "link";
        public static final String C0 = "q";
        public static final String D = "meta";
        public static final String D0 = "samp";
        public static final String E = "style";
        public static final String E0 = "progress";
        public static final String F = "address";
        public static final String F0 = "ruby";
        public static final String G = "article";
        public static final String G0 = "object";
        public static final String H = "aside";
        public static final String H0 = "small";
        public static final String I = "audio";
        public static final String I0 = "sub";
        public static final String J = "blockquote";
        public static final String J0 = "sup";
        public static final String K = "canvas";
        public static final String K0 = "strong";
        public static final String L = "fieldset";
        public static final String L0 = "select";
        public static final String M = "figcaption";
        public static final String M0 = "span";
        public static final String N = "figure";
        public static final String N0 = "svg";
        public static final String O = "footer";
        public static final String O0 = "wbr";
        public static final String P = "font";
        public static final String P0 = "time";
        public static final String Q = "form";
        public static final String Q0 = "textarea";
        public static final String R = "header";
        public static final String R0 = "var";
        public static final String S = "hgroup";
        public static final String S0 = "tr";
        public static final String T = "noscript";
        public static final String T0 = "big";
        public static final String U = "output";
        public static final String U0 = "s";
        public static final String V = "section";
        public static final String V0 = "strike";
        public static final String W = "video";
        public static final String W0 = "tt";
        public static final String X = "base";
        public static final String X0 = "u";
        public static final String Y = "command";
        public static final String Z = "title";

        /* renamed from: a  reason: collision with root package name */
        public static final String f27613a = "xml";
        public static final String a0 = "a";

        /* renamed from: b  reason: collision with root package name */
        public static final String f27614b = "thead";
        public static final String b0 = "abbr";

        /* renamed from: c  reason: collision with root package name */
        public static final String f27615c = "tbody";
        public static final String c0 = "b";

        /* renamed from: d  reason: collision with root package name */
        public static final String f27616d = "tfoot";
        public static final String d0 = "bdo";

        /* renamed from: e  reason: collision with root package name */
        public static final String f27617e = "ol";
        public static final String e0 = "button";

        /* renamed from: f  reason: collision with root package name */
        public static final String f27618f = "ul";
        public static final String f0 = "details";

        /* renamed from: g  reason: collision with root package name */
        public static final String f27619g = "caption";
        public static final String g0 = "code";

        /* renamed from: h  reason: collision with root package name */
        public static final String f27620h = "pre";
        public static final String h0 = "del";

        /* renamed from: i  reason: collision with root package name */
        public static final String f27621i = "p";
        public static final String i0 = "datalist";

        /* renamed from: j  reason: collision with root package name */
        public static final String f27622j = "div";
        public static final String j0 = "dfn";

        /* renamed from: k  reason: collision with root package name */
        public static final String f27623k = "h1";
        public static final String k0 = "embed";

        /* renamed from: l  reason: collision with root package name */
        public static final String f27624l = "h2";
        public static final String l0 = "cite";

        /* renamed from: m  reason: collision with root package name */
        public static final String f27625m = "h3";
        public static final String m0 = "dl";

        /* renamed from: n  reason: collision with root package name */
        public static final String f27626n = "h4";
        public static final String n0 = "em";
        public static final String o = "h5";
        public static final String o0 = "i";
        public static final String p = "h6";
        public static final String p0 = "iframe";
        public static final String q = "td";
        public static final String q0 = "input";
        public static final String r = "br";
        public static final String r0 = "img";
        public static final String s = "li";
        public static final String s0 = "ins";
        public static final String t = "dd";
        public static final String t0 = "map";
        public static final String u = "dt";
        public static final String u0 = "keygen";
        public static final String v = "th";
        public static final String v0 = "meter";
        public static final String w = "hr";
        public static final String w0 = "menu";
        public static final String x = "body";
        public static final String x0 = "nav";
        public static final String y = "html";
        public static final String y0 = "kbd";
        public static final String z = "table";
        public static final String z0 = "math";

        private Tag() {
        }
    }

    private HTML() {
    }
}
