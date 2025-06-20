package com.itextpdf.tool.xml.css;

import com.itextpdf.text.html.WebColors;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.apply.MarginMemory;
import com.itextpdf.tool.xml.exceptions.NoDataException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class CssUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f27495a = "-color";

    /* renamed from: b  reason: collision with root package name */
    private static final String f27496b = "-style";

    /* renamed from: c  reason: collision with root package name */
    private static final String f27497c = "-width";

    /* renamed from: d  reason: collision with root package name */
    private static final String f27498d = "border-";

    /* renamed from: e  reason: collision with root package name */
    private static final String f27499e = "{0}left{1}";

    /* renamed from: f  reason: collision with root package name */
    private static final String f27500f = "{0}right{1}";

    /* renamed from: g  reason: collision with root package name */
    private static final String f27501g = "{0}bottom{1}";

    /* renamed from: h  reason: collision with root package name */
    private static final String f27502h = "{0}top{1}";

    /* renamed from: i  reason: collision with root package name */
    private static CssUtils f27503i = new CssUtils();

    /* renamed from: j  reason: collision with root package name */
    public static final int f27504j = 12;

    /* renamed from: k  reason: collision with root package name */
    private static final Set<String> f27505k = new HashSet(Arrays.asList(new String[]{CSS.Value.f27472a, "medium", CSS.Value.f27474c}));

    /* renamed from: l  reason: collision with root package name */
    private static final Set<String> f27506l = new HashSet(Arrays.asList(new String[]{"none", CSS.Value.f27476e, CSS.Value.f27477f, CSS.Value.f27478g, CSS.Value.f27479h, CSS.Value.f27480i, CSS.Value.f27481j, CSS.Value.f27482k, CSS.Value.f27483l, CSS.Value.f27484m}));

    /* renamed from: m  reason: collision with root package name */
    private static final Set<String> f27507m = new HashSet(Arrays.asList(new String[]{"left", "center", "bottom", "top", "right"}));

    private CssUtils() {
    }

    public static CssUtils g() {
        return f27503i;
    }

    public float A(Map<String, String> map, float f2) {
        CssUtils cssUtils;
        String str = CSS.Property.F0;
        if (map.get(str) == null || f2 >= new CssUtils().p(map.get(str))) {
            str = CSS.Property.G0;
            if (map.get(str) == null || f2 <= new CssUtils().p(map.get(str))) {
                return f2;
            }
            cssUtils = new CssUtils();
        } else {
            cssUtils = new CssUtils();
        }
        return cssUtils.p(map.get(str));
    }

    public float a(float f2, MarginMemory marginMemory) {
        try {
            float floatValue = marginMemory.c().floatValue();
            if (f2 > floatValue) {
                return f2 - floatValue;
            }
            return 0.0f;
        } catch (NoDataException unused) {
            return f2;
        }
    }

    public float b(String str, float f2, MarginMemory marginMemory) {
        return a(s(str, f2), marginMemory);
    }

    public float c(Tag tag, String str) {
        Float d2 = d(tag.g(), str);
        if (d2 != null) {
            return d2.floatValue();
        }
        return 0.0f;
    }

    public Float d(Map<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 == null) {
            return null;
        }
        if (i(str2) || j(str2)) {
            return Float.valueOf(p(str2));
        }
        return null;
    }

    public int e(String str) {
        if (str == null) {
            return 0;
        }
        boolean z = true;
        int i2 = 0;
        while (z && i2 < str.length()) {
            switch (str.charAt(i2)) {
                case '+':
                case '-':
                case '.':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i2++;
                    break;
                default:
                    z = false;
                    break;
            }
        }
        return i2;
    }

    public String f(String str) {
        int indexOf;
        int lastIndexOf;
        if (!str.startsWith("url")) {
            return str;
        }
        String trim = str.substring(3).trim().replace("(", "").replace(")", "").trim();
        if (trim.startsWith("'") && trim.endsWith("'")) {
            indexOf = trim.indexOf("'") + 1;
            lastIndexOf = trim.lastIndexOf("'");
        } else if (!trim.startsWith("\"") || !trim.endsWith("\"")) {
            return trim;
        } else {
            indexOf = trim.indexOf(34) + 1;
            lastIndexOf = trim.lastIndexOf(34);
        }
        return trim.substring(indexOf, lastIndexOf);
    }

    public float h(Tag tag, float f2) {
        String str = tag.g().get(CSS.Property.f27470m);
        float f3 = 0.0f;
        if (str != null) {
            f3 = 0.0f + s(str, f2);
        }
        String str2 = tag.g().get(CSS.Property.f27471n);
        return str2 != null ? f3 + s(str2, f2) : f3;
    }

    public boolean i(String str) {
        return str.contains(CSS.Value.h0) || str.contains(CSS.Value.i0) || str.contains(CSS.Value.j0) || str.contains(CSS.Value.k0) || str.contains(CSS.Value.m0) || str.contains(CSS.Value.l0);
    }

    public boolean j(String str) {
        return str.matches("^-?\\d\\d*\\.\\d*$") || str.matches("^-?\\d\\d*$") || str.matches("^-?\\.\\d\\d*$");
    }

    public boolean k(String str) {
        return str.contains(CSS.Value.n0) || str.contains("em") || str.contains(CSS.Value.p0);
    }

    public Map<String, String> l(String str) {
        return m(str, (String) null);
    }

    public Map<String, String> m(String str, String str2) {
        Map<String, String> o;
        HashMap hashMap = new HashMap(0);
        String[] w = w(str);
        if (r2 == 1) {
            hashMap.putAll((f27505k.contains(w[0]) || j(w[0]) || i(w[0])) ? o(w[0], f27498d, f27497c, str2) : o(w[0], f27498d, f27496b, str2));
        } else {
            for (String str3 : w) {
                if (f27505k.contains(str3) || j(str3) || i(str3)) {
                    o = o(str3, f27498d, f27497c, str2);
                } else if (f27506l.contains(str3)) {
                    o = o(str3, f27498d, f27496b, str2);
                } else if (str3.contains("rgb(") || str3.contains("#") || WebColors.X.containsKey(str3.toLowerCase())) {
                    o = o(str3, f27498d, f27495a, str2);
                }
                hashMap.putAll(o);
            }
        }
        return hashMap;
    }

    public Map<String, String> n(String str, String str2, String str3) {
        return o(str, str2, str3, (String) null);
    }

    public Map<String, String> o(String str, String str2, String str3, String str4) {
        String format;
        String str5;
        String format2;
        String str6 = str4;
        String str7 = str;
        String[] split = str.split(StringUtils.SPACE);
        int length = split.length;
        LinkedHashMap linkedHashMap = new LinkedHashMap(4);
        if (length == 1) {
            String str8 = split[0];
            if (str6 == null) {
                linkedHashMap.put(MessageFormat.format(f27502h, new Object[]{str2, str3}), str8);
                linkedHashMap.put(MessageFormat.format(f27501g, new Object[]{str2, str3}), str8);
                linkedHashMap.put(MessageFormat.format(f27500f, new Object[]{str2, str3}), str8);
                format2 = MessageFormat.format(f27499e, new Object[]{str2, str3});
            } else {
                format2 = MessageFormat.format(str6 + "{0}", new Object[]{str3});
            }
            linkedHashMap.put(format2, str8);
        } else {
            if (length == 2) {
                if (str6 == null) {
                    linkedHashMap.put(MessageFormat.format(f27502h, new Object[]{str2, str3}), split[0]);
                    linkedHashMap.put(MessageFormat.format(f27501g, new Object[]{str2, str3}), split[0]);
                    linkedHashMap.put(MessageFormat.format(f27500f, new Object[]{str2, str3}), split[1]);
                    format = MessageFormat.format(f27499e, new Object[]{str2, str3});
                    str5 = split[1];
                } else {
                    format = MessageFormat.format(str6 + "{0}", new Object[]{str3});
                    str5 = split[0];
                }
            } else if (length == 3) {
                if (str6 == null) {
                    linkedHashMap.put(MessageFormat.format(f27502h, new Object[]{str2, str3}), split[0]);
                    linkedHashMap.put(MessageFormat.format(f27501g, new Object[]{str2, str3}), split[2]);
                    linkedHashMap.put(MessageFormat.format(f27500f, new Object[]{str2, str3}), split[1]);
                    format = MessageFormat.format(f27499e, new Object[]{str2, str3});
                    str5 = split[1];
                } else {
                    format = MessageFormat.format(str6 + "{0}", new Object[]{str3});
                    str5 = split[0];
                }
            } else if (length == 4) {
                if (str6 == null) {
                    linkedHashMap.put(MessageFormat.format(f27502h, new Object[]{str2, str3}), split[0]);
                    linkedHashMap.put(MessageFormat.format(f27501g, new Object[]{str2, str3}), split[2]);
                    linkedHashMap.put(MessageFormat.format(f27500f, new Object[]{str2, str3}), split[1]);
                    format = MessageFormat.format(f27499e, new Object[]{str2, str3});
                    str5 = split[3];
                } else {
                    format = MessageFormat.format(str6 + "{0}", new Object[]{str3});
                    str5 = split[0];
                }
            }
            linkedHashMap.put(format, str5);
        }
        return linkedHashMap;
    }

    public float p(String str) {
        return q(str, CSS.Value.h0);
    }

    public float q(String str, String str2) {
        float f2;
        float f3;
        int e2 = e(str);
        if (e2 == 0) {
            return 0.0f;
        }
        float parseFloat = Float.parseFloat(str.substring(0, e2) + "f");
        String substring = str.substring(e2);
        if (!substring.startsWith(CSS.Value.i0) && (!substring.equals("") || !str2.equals(CSS.Value.i0))) {
            if (substring.startsWith(CSS.Value.j0) || (substring.equals("") && str2.equals(CSS.Value.j0))) {
                f2 = 2.54f;
            } else if (substring.startsWith(CSS.Value.k0) || (substring.equals("") && str2.equals(CSS.Value.k0))) {
                f2 = 25.4f;
            } else {
                if (substring.startsWith(CSS.Value.m0) || (substring.equals("") && str2.equals(CSS.Value.m0))) {
                    f3 = 12.0f;
                } else if (!substring.startsWith(CSS.Value.h0) && (!substring.equals("") || !str2.equals(CSS.Value.h0))) {
                    return parseFloat;
                } else {
                    f3 = 0.75f;
                }
                return parseFloat * f3;
            }
            parseFloat /= f2;
        }
        return parseFloat * 72.0f;
    }

    public float r(String str, float f2) {
        float f3;
        float f4;
        int e2 = e(str);
        if (e2 == 0) {
            return 0.0f;
        }
        float parseFloat = Float.parseFloat(str.substring(0, e2) + "f");
        String substring = str.substring(e2);
        if (substring.startsWith(CSS.Value.n0)) {
            f3 = f2 * parseFloat;
            f4 = 100.0f;
        } else if (substring.startsWith("em")) {
            return parseFloat * f2;
        } else {
            if (!substring.contains(CSS.Value.p0)) {
                return parseFloat;
            }
            f3 = f2 * parseFloat;
            f4 = 2.0f;
        }
        return f3 / f4;
    }

    public float s(String str, float f2) {
        if (i(str) || j(str)) {
            return p(str);
        }
        if (k(str)) {
            return r(str, f2);
        }
        return 0.0f;
    }

    public Map<String, String> t(String str) {
        String str2;
        StringBuilder sb;
        HashMap hashMap = new HashMap();
        for (String str3 : w(str)) {
            if (str3.contains("url(")) {
                str2 = CSS.Property.f27459b;
            } else if (str3.equalsIgnoreCase(CSS.Value.t) || str3.equalsIgnoreCase(CSS.Value.u) || str3.equalsIgnoreCase(CSS.Value.v) || str3.equalsIgnoreCase(CSS.Value.w)) {
                str2 = CSS.Property.f27460c;
            } else if (str3.equalsIgnoreCase(CSS.Value.x) || str3.equalsIgnoreCase(CSS.Value.y)) {
                str2 = CSS.Property.f27461d;
            } else {
                if (f27507m.contains(str3)) {
                    if (hashMap.get(CSS.Property.f27462e) != null) {
                        sb = new StringBuilder();
                        sb.append(StringUtils.SPACE);
                        sb.append((String) hashMap.get(CSS.Property.f27462e));
                        str3 = str3.concat(sb.toString());
                    }
                } else if (j(str3) || i(str3) || k(str3)) {
                    if (hashMap.get(CSS.Property.f27462e) != null) {
                        sb = new StringBuilder();
                        sb.append(StringUtils.SPACE);
                        sb.append((String) hashMap.get(CSS.Property.f27462e));
                        str3 = str3.concat(sb.toString());
                    }
                } else if (str3.contains("rgb(") || str3.contains("rgba(") || str3.contains("#") || WebColors.X.containsKey(str3.toLowerCase())) {
                    str2 = CSS.Property.f27463f;
                }
                hashMap.put(CSS.Property.f27462e, str3);
            }
            hashMap.put(str2, str3);
        }
        return hashMap;
    }

    public Map<String, String> u(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        String[] split = str.split("\\s");
        for (int i2 = 0; i2 < split.length; i2++) {
            String str3 = split[i2];
            if (str3.equalsIgnoreCase("italic") || str3.equalsIgnoreCase("oblique")) {
                str2 = "font-style";
            } else if (str3.equalsIgnoreCase("small-caps")) {
                str2 = "font-variant";
            } else if (str3.equalsIgnoreCase("bold")) {
                str2 = "font-weight";
            } else if (i(str3) || j(str3)) {
                if (str3.contains("/")) {
                    String[] split2 = str3.split("/");
                    String str4 = split2[0];
                    hashMap.put("line-height", split2[1]);
                    str3 = str4;
                }
                hashMap.put("font-size", str3);
                if (i2 != split.length - 1) {
                    str3 = split[i2 + 1].replaceAll("\"", "").replaceAll("'", "");
                    str2 = "font-family";
                }
            }
            hashMap.put(str2, str3);
        }
        return hashMap;
    }

    public Map<String, String> v(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        for (String str3 : w(str)) {
            if (str3.equalsIgnoreCase(CSS.Value.z) || str3.equalsIgnoreCase(CSS.Value.A) || str3.equalsIgnoreCase("circle") || str3.equalsIgnoreCase(CSS.Value.D) || str3.equalsIgnoreCase(CSS.Value.E) || str3.equalsIgnoreCase(CSS.Value.F) || str3.equalsIgnoreCase(CSS.Value.G) || str3.equalsIgnoreCase(CSS.Value.H) || str3.equalsIgnoreCase(CSS.Value.I) || str3.equalsIgnoreCase(CSS.Value.J) || str3.equalsIgnoreCase(CSS.Value.K)) {
                str2 = CSS.Property.f27465h;
            } else if (str3.equalsIgnoreCase(CSS.Value.L) || str3.equalsIgnoreCase("outside")) {
                str2 = CSS.Property.f27466i;
            } else if (str3.contains("url(")) {
                str2 = CSS.Property.f27467j;
            }
            hashMap.put(str2, str3);
        }
        return hashMap;
    }

    public String[] w(String str) {
        return str.replaceAll("\\s*,\\s*", ",").split("\\s");
    }

    public String x(String str) {
        String valueOf;
        char[] charArray = str.toCharArray();
        if (str.contains("  ")) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < charArray.length; i2++) {
                char c2 = charArray[i2];
                if (c2 != ' ') {
                    sb.append(c2);
                } else {
                    int i3 = i2 + 1;
                    if (i3 < charArray.length && charArray[i3] != ' ') {
                        sb.append(' ');
                    }
                }
            }
            valueOf = sb.toString();
        } else {
            valueOf = String.valueOf(charArray);
        }
        return valueOf.trim();
    }

    public String y(String str) {
        return x(str).toLowerCase();
    }

    public String z(String str) {
        String trim = str.trim();
        return (((trim.startsWith("\"") || trim.startsWith("'")) && trim.endsWith("\"")) || trim.endsWith("'")) ? trim.substring(1, trim.length() - 1) : trim;
    }
}
