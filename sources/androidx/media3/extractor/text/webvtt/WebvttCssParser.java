package androidx.media3.extractor.text.webvtt;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ColorParser;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;
import com.itextpdf.tool.xml.css.CSS;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class WebvttCssParser {

    /* renamed from: c  reason: collision with root package name */
    private static final String f14091c = "WebvttCssParser";

    /* renamed from: d  reason: collision with root package name */
    private static final String f14092d = "{";

    /* renamed from: e  reason: collision with root package name */
    private static final String f14093e = "}";

    /* renamed from: f  reason: collision with root package name */
    private static final String f14094f = "color";

    /* renamed from: g  reason: collision with root package name */
    private static final String f14095g = "background-color";

    /* renamed from: h  reason: collision with root package name */
    private static final String f14096h = "font-family";

    /* renamed from: i  reason: collision with root package name */
    private static final String f14097i = "font-weight";

    /* renamed from: j  reason: collision with root package name */
    private static final String f14098j = "font-size";

    /* renamed from: k  reason: collision with root package name */
    private static final String f14099k = "ruby-position";

    /* renamed from: l  reason: collision with root package name */
    private static final String f14100l = "over";

    /* renamed from: m  reason: collision with root package name */
    private static final String f14101m = "under";

    /* renamed from: n  reason: collision with root package name */
    private static final String f14102n = "text-combine-upright";
    private static final String o = "all";
    private static final String p = "digits";
    private static final String q = "text-decoration";
    private static final String r = "bold";
    private static final String s = "underline";
    private static final String t = "font-style";
    private static final String u = "italic";
    private static final Pattern v = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern w = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f14103a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f14104b = new StringBuilder();

    private void a(WebvttCssStyle webvttCssStyle, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = v.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    webvttCssStyle.A((String) Assertions.g(matcher.group(1)));
                }
                str = str.substring(0, indexOf);
            }
            String[] p2 = Util.p2(str, "\\.");
            String str2 = p2[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                webvttCssStyle.z(str2.substring(0, indexOf2));
                webvttCssStyle.y(str2.substring(indexOf2 + 1));
            } else {
                webvttCssStyle.z(str2);
            }
            if (p2.length > 1) {
                webvttCssStyle.x((String[]) Util.P1(p2, 1, p2.length));
            }
        }
    }

    private static boolean b(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        byte[] e2 = parsableByteArray.e();
        if (f2 + 2 > g2) {
            return false;
        }
        int i2 = f2 + 1;
        if (e2[f2] != 47) {
            return false;
        }
        int i3 = f2 + 2;
        if (e2[i2] != 42) {
            return false;
        }
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= g2) {
                parsableByteArray.Z(g2 - parsableByteArray.f());
                return true;
            } else if (((char) e2[i3]) == '*' && ((char) e2[i4]) == '/') {
                i3 += 2;
                g2 = i3;
            } else {
                i3 = i4;
            }
        }
    }

    private static boolean c(ParsableByteArray parsableByteArray) {
        char k2 = k(parsableByteArray, parsableByteArray.f());
        if (k2 != 9 && k2 != 10 && k2 != 12 && k2 != 13 && k2 != ' ') {
            return false;
        }
        parsableByteArray.Z(1);
        return true;
    }

    private static void e(String str, WebvttCssStyle webvttCssStyle) {
        Matcher matcher = w.matcher(Ascii.g(str));
        if (!matcher.matches()) {
            Log.n(f14091c, "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) Assertions.g(matcher.group(2));
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 37:
                if (str2.equals(CSS.Value.n0)) {
                    c2 = 0;
                    break;
                }
                break;
            case 3240:
                if (str2.equals("em")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3592:
                if (str2.equals(CSS.Value.h0)) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                webvttCssStyle.t(3);
                break;
            case 1:
                webvttCssStyle.t(2);
                break;
            case 2:
                webvttCssStyle.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        webvttCssStyle.s(Float.parseFloat((String) Assertions.g(matcher.group(1))));
    }

    private static String f(ParsableByteArray parsableByteArray, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        while (f2 < g2 && !z) {
            char c2 = (char) parsableByteArray.e()[f2];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                f2++;
                sb.append(c2);
            }
        }
        parsableByteArray.Z(f2 - parsableByteArray.f());
        return sb.toString();
    }

    @Nullable
    static String g(ParsableByteArray parsableByteArray, StringBuilder sb) {
        n(parsableByteArray);
        if (parsableByteArray.a() == 0) {
            return null;
        }
        String f2 = f(parsableByteArray, sb);
        if (!"".equals(f2)) {
            return f2;
        }
        return "" + ((char) parsableByteArray.L());
    }

    @Nullable
    private static String h(ParsableByteArray parsableByteArray, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int f2 = parsableByteArray.f();
            String g2 = g(parsableByteArray, sb);
            if (g2 == null) {
                return null;
            }
            if (f14093e.equals(g2) || ";".equals(g2)) {
                parsableByteArray.Y(f2);
                z = true;
            } else {
                sb2.append(g2);
            }
        }
        return sb2.toString();
    }

    @Nullable
    private static String i(ParsableByteArray parsableByteArray, StringBuilder sb) {
        n(parsableByteArray);
        if (parsableByteArray.a() < 5 || !"::cue".equals(parsableByteArray.I(5))) {
            return null;
        }
        int f2 = parsableByteArray.f();
        String g2 = g(parsableByteArray, sb);
        if (g2 == null) {
            return null;
        }
        if (f14092d.equals(g2)) {
            parsableByteArray.Y(f2);
            return "";
        }
        String l2 = "(".equals(g2) ? l(parsableByteArray) : null;
        if (!")".equals(g(parsableByteArray, sb))) {
            return null;
        }
        return l2;
    }

    private static void j(ParsableByteArray parsableByteArray, WebvttCssStyle webvttCssStyle, StringBuilder sb) {
        n(parsableByteArray);
        String f2 = f(parsableByteArray, sb);
        if (!"".equals(f2) && ":".equals(g(parsableByteArray, sb))) {
            n(parsableByteArray);
            String h2 = h(parsableByteArray, sb);
            if (h2 != null && !"".equals(h2)) {
                int f3 = parsableByteArray.f();
                String g2 = g(parsableByteArray, sb);
                if (!";".equals(g2)) {
                    if (f14093e.equals(g2)) {
                        parsableByteArray.Y(f3);
                    } else {
                        return;
                    }
                }
                if ("color".equals(f2)) {
                    webvttCssStyle.q(ColorParser.b(h2));
                } else if ("background-color".equals(f2)) {
                    webvttCssStyle.n(ColorParser.b(h2));
                } else {
                    boolean z = true;
                    if (f14099k.equals(f2)) {
                        if (f14100l.equals(h2)) {
                            webvttCssStyle.w(1);
                        } else if (f14101m.equals(h2)) {
                            webvttCssStyle.w(2);
                        }
                    } else if (f14102n.equals(f2)) {
                        if (!"all".equals(h2) && !h2.startsWith(p)) {
                            z = false;
                        }
                        webvttCssStyle.p(z);
                    } else if ("text-decoration".equals(f2)) {
                        if ("underline".equals(h2)) {
                            webvttCssStyle.B(true);
                        }
                    } else if ("font-family".equals(f2)) {
                        webvttCssStyle.r(h2);
                    } else if ("font-weight".equals(f2)) {
                        if ("bold".equals(h2)) {
                            webvttCssStyle.o(true);
                        }
                    } else if ("font-style".equals(f2)) {
                        if ("italic".equals(h2)) {
                            webvttCssStyle.u(true);
                        }
                    } else if ("font-size".equals(f2)) {
                        e(h2, webvttCssStyle);
                    }
                }
            }
        }
    }

    private static char k(ParsableByteArray parsableByteArray, int i2) {
        return (char) parsableByteArray.e()[i2];
    }

    private static String l(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        boolean z = false;
        while (f2 < g2 && !z) {
            int i2 = f2 + 1;
            z = ((char) parsableByteArray.e()[f2]) == ')';
            f2 = i2;
        }
        return parsableByteArray.I((f2 - 1) - parsableByteArray.f()).trim();
    }

    static void m(ParsableByteArray parsableByteArray) {
        do {
        } while (!TextUtils.isEmpty(parsableByteArray.u()));
    }

    static void n(ParsableByteArray parsableByteArray) {
        while (true) {
            boolean z = true;
            while (parsableByteArray.a() > 0 && z) {
                if (!c(parsableByteArray) && !b(parsableByteArray)) {
                    z = false;
                }
            }
            return;
        }
    }

    public List<WebvttCssStyle> d(ParsableByteArray parsableByteArray) {
        this.f14104b.setLength(0);
        int f2 = parsableByteArray.f();
        m(parsableByteArray);
        this.f14103a.W(parsableByteArray.e(), parsableByteArray.f());
        this.f14103a.Y(f2);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String i2 = i(this.f14103a, this.f14104b);
            if (i2 == null || !f14092d.equals(g(this.f14103a, this.f14104b))) {
                return arrayList;
            }
            WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
            a(webvttCssStyle, i2);
            String str = null;
            boolean z = false;
            while (!z) {
                int f3 = this.f14103a.f();
                String g2 = g(this.f14103a, this.f14104b);
                boolean z2 = g2 == null || f14093e.equals(g2);
                if (!z2) {
                    this.f14103a.Y(f3);
                    j(this.f14103a, webvttCssStyle, this.f14104b);
                }
                str = g2;
                z = z2;
            }
            if (f14093e.equals(str)) {
                arrayList.add(webvttCssStyle);
            }
        }
    }
}
