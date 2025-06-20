package com.itextpdf.tool.xml.css;

import java.util.HashMap;
import java.util.Map;

public final class CSS {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Integer> f27456a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f27457b = "default";

    public static final class Property {
        public static final String A = "border-top-width";
        public static final String A0 = "repeat-footer";
        public static final String B = "border-bottom-width";
        public static final String B0 = "left";
        public static final String C = "border-left-width";
        public static final String C0 = "display";
        public static final String D = "border-right-width";
        public static final String D0 = "min-width";
        public static final String E = "border-top-color";
        public static final String E0 = "max-width";
        public static final String F = "border-bottom-color";
        public static final String F0 = "min-height";
        public static final String G = "border-left-color";
        public static final String G0 = "max-height";
        public static final String H = "border-right-color";
        public static final String H0 = "right";
        public static final String I = "border-top-style";
        public static final String I0 = "bottom";
        public static final String J = "border-bottom-style";
        public static final String J0 = "float";
        public static final String K = "border-left-style";
        public static final String K0 = "direction";
        public static final String L = "border-right-style";
        public static final String M = "padding";
        public static final String N = "padding-top";
        public static final String O = "padding-bottom";
        public static final String P = "padding-left";
        public static final String Q = "padding-right";
        public static final String R = "font";
        public static final String S = "font-weight";
        public static final String T = "font-size";
        public static final String U = "font-style";
        public static final String V = "font-family";
        public static final String W = "text-decoration";
        public static final String X = "color";
        public static final String Y = "tab-interval";
        public static final String Z = "xfa-tab-count";

        /* renamed from: a  reason: collision with root package name */
        public static final String f27458a = "background";
        public static final String a0 = "xfa-font-horizontal-scale";

        /* renamed from: b  reason: collision with root package name */
        public static final String f27459b = "background-image";
        public static final String b0 = "xfa-font-vertical-scale";

        /* renamed from: c  reason: collision with root package name */
        public static final String f27460c = "background-repeat";
        public static final String c0 = "before";

        /* renamed from: d  reason: collision with root package name */
        public static final String f27461d = "background-attachment";
        public static final String d0 = "after";

        /* renamed from: e  reason: collision with root package name */
        public static final String f27462e = "background-position";
        public static final String e0 = "height";

        /* renamed from: f  reason: collision with root package name */
        public static final String f27463f = "background-color";
        public static final String f0 = "width";

        /* renamed from: g  reason: collision with root package name */
        public static final String f27464g = "list-style";
        public static final String g0 = "letter-spacing";

        /* renamed from: h  reason: collision with root package name */
        public static final String f27465h = "list-style-type";
        public static final String h0 = "vertical-align";

        /* renamed from: i  reason: collision with root package name */
        public static final String f27466i = "list-style-position";
        public static final String i0 = "line-height";

        /* renamed from: j  reason: collision with root package name */
        public static final String f27467j = "list-style-image";
        public static final String j0 = "text-align";

        /* renamed from: k  reason: collision with root package name */
        public static final String f27468k = "margin";
        public static final String k0 = "text-valign";

        /* renamed from: l  reason: collision with root package name */
        public static final String f27469l = "top";
        public static final String l0 = "text-indent";

        /* renamed from: m  reason: collision with root package name */
        public static final String f27470m = "margin-left";
        public static final String m0 = "position";

        /* renamed from: n  reason: collision with root package name */
        public static final String f27471n = "margin-right";
        public static final String n0 = "empty-cells";
        public static final String o = "margin-top";
        public static final String o0 = "cellpadding";
        public static final String p = "margin-bottom";
        public static final String p0 = "cellpadding-left";
        public static final String q = "border";
        public static final String q0 = "cellpadding-top";
        public static final String r = "border-left";
        public static final String r0 = "cellpadding-right";
        public static final String s = "border-top";
        public static final String s0 = "cellpadding-bottom";
        public static final String t = "border-right";
        public static final String t0 = "caption-side";
        public static final String u = "border-bottom";
        public static final String u0 = "tab-stops";
        public static final String v = "border-width";
        public static final String v0 = "xfa-tab-stops";
        public static final String w = "border-style";
        public static final String w0 = "page-break-before";
        public static final String x = "border-color";
        public static final String x0 = "page-break-inside";
        public static final String y = "border-collapse";
        public static final String y0 = "page-break-after";
        public static final String z = "border-spacing";
        public static final String z0 = "repeat-header";

        private Property() {
        }
    }

    public static final class Value {
        public static final String A = "square";
        public static final String A0 = "inline-block";
        public static final String B = "circle";
        public static final String B0 = "inline-table";
        public static final String C = "decimal";
        public static final String C0 = "list-item";
        public static final String D = "lower-roman";
        public static final String D0 = "run-in";
        public static final String E = "upper-roman";
        public static final String E0 = "table";
        public static final String F = "lower-greek";
        public static final String F0 = "table-caption";
        public static final String G = "upper-greek";
        public static final String G0 = "table-cell";
        public static final String H = "lower-alpha";
        public static final String H0 = "table-column-group";
        public static final String I = "upper-alpha";
        public static final String I0 = "table-column";
        public static final String J = "lower-latin";
        public static final String J0 = "table-footer-group";
        public static final String K = "upper-latin";
        public static final String K0 = "table-header-group";
        public static final String L = "inside";
        public static final String L0 = "table-row";
        public static final String M = "outside";
        public static final String M0 = "table-row-group";
        public static final String N = "inherit";
        public static final String O = "underline";
        public static final String P = "bold";
        public static final String Q = "italic";
        public static final String R = "oblique";
        public static final String S = "super";
        public static final String T = "sub";
        public static final String U = "text-top";
        public static final String V = "text-bottom";
        public static final String W = "line-through";
        public static final String X = "relative";
        public static final String Y = "hide";
        public static final String Z = "xx-small";

        /* renamed from: a  reason: collision with root package name */
        public static final String f27472a = "thin";
        public static final String a0 = "x-small";

        /* renamed from: b  reason: collision with root package name */
        public static final String f27473b = "medium";
        public static final String b0 = "small";

        /* renamed from: c  reason: collision with root package name */
        public static final String f27474c = "thick";
        public static final String c0 = "large";

        /* renamed from: d  reason: collision with root package name */
        public static final String f27475d = "none";
        public static final String d0 = "x-large";

        /* renamed from: e  reason: collision with root package name */
        public static final String f27476e = "hidden";
        public static final String e0 = "xx-large";

        /* renamed from: f  reason: collision with root package name */
        public static final String f27477f = "dotted";
        public static final String f0 = "smaller";

        /* renamed from: g  reason: collision with root package name */
        public static final String f27478g = "dashed";
        public static final String g0 = "larger";

        /* renamed from: h  reason: collision with root package name */
        public static final String f27479h = "solid";
        public static final String h0 = "px";

        /* renamed from: i  reason: collision with root package name */
        public static final String f27480i = "double";
        public static final String i0 = "in";

        /* renamed from: j  reason: collision with root package name */
        public static final String f27481j = "groove";
        public static final String j0 = "cm";

        /* renamed from: k  reason: collision with root package name */
        public static final String f27482k = "ridge";
        public static final String k0 = "mm";

        /* renamed from: l  reason: collision with root package name */
        public static final String f27483l = "inset";
        public static final String l0 = "pt";

        /* renamed from: m  reason: collision with root package name */
        public static final String f27484m = "outset";
        public static final String m0 = "pc";

        /* renamed from: n  reason: collision with root package name */
        public static final String f27485n = "left";
        public static final String n0 = "%";
        public static final String o = "center";
        public static final String o0 = "em";
        public static final String p = "justify";
        public static final String p0 = "ex";
        public static final String q = "bottom";
        public static final String q0 = "always";
        public static final String r = "top";
        public static final String r0 = "avoid";
        public static final String s = "right";
        public static final String s0 = "absolute";
        public static final String t = "repeat";
        public static final String t0 = "auto";
        public static final String u = "no-repeat";
        public static final String u0 = "inline";
        public static final String v = "repeat-x";
        public static final String v0 = "block";
        public static final String w = "repeat-y";
        public static final String w0 = "separate";
        public static final String x = "fixed";
        public static final String x0 = "collapse";
        public static final String y = "scroll";
        public static final String y0 = "rtl";
        public static final String z = "disc";
        public static final String z0 = "ltr";

        private Value() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f27456a = hashMap;
        hashMap.put("left".toLowerCase(), 0);
        hashMap.put("center".toLowerCase(), 1);
        hashMap.put("right".toLowerCase(), 2);
        hashMap.put("justify".toLowerCase(), 3);
        hashMap.put("default".toLowerCase(), -1);
    }

    private CSS() {
    }

    public static final int a(String str) {
        String lowerCase = str.toLowerCase();
        Map<String, Integer> map = f27456a;
        if (!map.containsKey(lowerCase)) {
            lowerCase = "default";
        }
        return map.get(lowerCase).intValue();
    }
}
