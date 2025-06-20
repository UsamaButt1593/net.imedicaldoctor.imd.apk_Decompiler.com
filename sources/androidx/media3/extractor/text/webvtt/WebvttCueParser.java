package androidx.media3.extractor.text.webvtt;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.RubySpan;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.tool.xml.css.CSS;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
public final class WebvttCueParser {
    private static final int A = 2;
    static final float B = 0.5f;
    private static final String C = "WebvttCueParser";
    private static final Map<String, Integer> D;
    private static final Map<String, Integer> E;

    /* renamed from: a  reason: collision with root package name */
    private static final int f14122a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static final int f14123b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final int f14124c = 3;

    /* renamed from: d  reason: collision with root package name */
    private static final int f14125d = 4;

    /* renamed from: e  reason: collision with root package name */
    private static final int f14126e = 5;

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f14127f = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f14128g = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: h  reason: collision with root package name */
    private static final char f14129h = '<';

    /* renamed from: i  reason: collision with root package name */
    private static final char f14130i = '>';

    /* renamed from: j  reason: collision with root package name */
    private static final char f14131j = '/';

    /* renamed from: k  reason: collision with root package name */
    private static final char f14132k = '&';

    /* renamed from: l  reason: collision with root package name */
    private static final char f14133l = ';';

    /* renamed from: m  reason: collision with root package name */
    private static final char f14134m = ' ';

    /* renamed from: n  reason: collision with root package name */
    private static final String f14135n = "lt";
    private static final String o = "gt";
    private static final String p = "amp";
    private static final String q = "nbsp";
    private static final String r = "b";
    private static final String s = "c";
    private static final String t = "i";
    private static final String u = "lang";
    private static final String v = "ruby";
    private static final String w = "rt";
    private static final String x = "u";
    private static final String y = "v";
    private static final int z = 1;

    private static class Element {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final Comparator<Element> f14136c = new a();
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final StartTag f14137a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f14138b;

        private Element(StartTag startTag, int i2) {
            this.f14137a = startTag;
            this.f14138b = i2;
        }
    }

    private static final class StartTag {

        /* renamed from: a  reason: collision with root package name */
        public final String f14139a;

        /* renamed from: b  reason: collision with root package name */
        public final int f14140b;

        /* renamed from: c  reason: collision with root package name */
        public final String f14141c;

        /* renamed from: d  reason: collision with root package name */
        public final Set<String> f14142d;

        private StartTag(String str, int i2, String str2, Set<String> set) {
            this.f14140b = i2;
            this.f14139a = str;
            this.f14141c = str2;
            this.f14142d = set;
        }

        public static StartTag a(String str, int i2) {
            String str2;
            String trim = str.trim();
            Assertions.a(!trim.isEmpty());
            int indexOf = trim.indexOf(StringUtils.SPACE);
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] p2 = Util.p2(trim, "\\.");
            String str3 = p2[0];
            HashSet hashSet = new HashSet();
            for (int i3 = 1; i3 < p2.length; i3++) {
                hashSet.add(p2[i3]);
            }
            return new StartTag(str3, i2, str2, hashSet);
        }

        public static StartTag b() {
            return new StartTag("", 0, "", Collections.emptySet());
        }
    }

    private static final class StyleMatch implements Comparable<StyleMatch> {
        public final WebvttCssStyle X;
        public final int s;

        public StyleMatch(int i2, WebvttCssStyle webvttCssStyle) {
            this.s = i2;
            this.X = webvttCssStyle;
        }

        /* renamed from: a */
        public int compareTo(StyleMatch styleMatch) {
            return Integer.compare(this.s, styleMatch.s);
        }
    }

    private static final class WebvttCueInfoBuilder {

        /* renamed from: a  reason: collision with root package name */
        public long f14143a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f14144b = 0;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f14145c;

        /* renamed from: d  reason: collision with root package name */
        public int f14146d = 2;

        /* renamed from: e  reason: collision with root package name */
        public float f14147e = -3.4028235E38f;

        /* renamed from: f  reason: collision with root package name */
        public int f14148f = 1;

        /* renamed from: g  reason: collision with root package name */
        public int f14149g = 0;

        /* renamed from: h  reason: collision with root package name */
        public float f14150h = -3.4028235E38f;

        /* renamed from: i  reason: collision with root package name */
        public int f14151i = Integer.MIN_VALUE;

        /* renamed from: j  reason: collision with root package name */
        public float f14152j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public int f14153k = Integer.MIN_VALUE;

        private static float b(float f2, int i2) {
            int i3 = (f2 > -3.4028235E38f ? 1 : (f2 == -3.4028235E38f ? 0 : -1));
            if (i3 != 0 && i2 == 0 && (f2 < 0.0f || f2 > 1.0f)) {
                return 1.0f;
            }
            if (i3 != 0) {
                return f2;
            }
            return i2 == 0 ? 1.0f : -3.4028235E38f;
        }

        @Nullable
        private static Layout.Alignment c(int i2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            Log.n(WebvttCueParser.C, "Unknown textAlignment: " + i2);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        private static float d(int i2, float f2) {
            if (i2 == 0) {
                return 1.0f - f2;
            }
            if (i2 == 1) {
                return f2 <= 0.5f ? f2 * 2.0f : (1.0f - f2) * 2.0f;
            }
            if (i2 == 2) {
                return f2;
            }
            throw new IllegalStateException(String.valueOf(i2));
        }

        private static float e(int i2) {
            if (i2 != 4) {
                return i2 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int f(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 3) {
                return 2;
            }
            if (i2 != 4) {
                return i2 != 5 ? 1 : 2;
            }
            return 0;
        }

        public WebvttCueInfo a() {
            return new WebvttCueInfo(g().a(), this.f14143a, this.f14144b);
        }

        public Cue.Builder g() {
            float f2 = this.f14150h;
            if (f2 == -3.4028235E38f) {
                f2 = e(this.f14146d);
            }
            int i2 = this.f14151i;
            if (i2 == Integer.MIN_VALUE) {
                i2 = f(this.f14146d);
            }
            Cue.Builder D = new Cue.Builder().B(c(this.f14146d)).t(b(this.f14147e, this.f14148f), this.f14148f).u(this.f14149g).w(f2).x(i2).z(Math.min(this.f14152j, d(i2, f2))).D(this.f14153k);
            CharSequence charSequence = this.f14145c;
            if (charSequence != null) {
                D.A(charSequence);
            }
            return D;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        D = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        E = Collections.unmodifiableMap(hashMap2);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i2, int i3) {
        Object backgroundColorSpan;
        for (String next : set) {
            Map<String, Integer> map = D;
            if (map.containsKey(next)) {
                backgroundColorSpan = new ForegroundColorSpan(map.get(next).intValue());
            } else {
                Map<String, Integer> map2 = E;
                if (map2.containsKey(next)) {
                    backgroundColorSpan = new BackgroundColorSpan(map2.get(next).intValue());
                }
            }
            spannableStringBuilder.setSpan(backgroundColorSpan, i2, i3, 33);
        }
    }

    private static void b(String str, SpannableStringBuilder spannableStringBuilder) {
        char c2;
        str.hashCode();
        char c3 = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals(o)) {
                    c3 = 0;
                    break;
                }
                break;
            case 3464:
                if (str.equals(f14135n)) {
                    c3 = 1;
                    break;
                }
                break;
            case 96708:
                if (str.equals(p)) {
                    c3 = 2;
                    break;
                }
                break;
            case 3374865:
                if (str.equals(q)) {
                    c3 = 3;
                    break;
                }
                break;
        }
        switch (c3) {
            case 0:
                c2 = '>';
                break;
            case 1:
                c2 = '<';
                break;
            case 2:
                c2 = '&';
                break;
            case 3:
                c2 = ' ';
                break;
            default:
                Log.n(C, "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
        spannableStringBuilder.append(c2);
    }

    private static void c(SpannableStringBuilder spannableStringBuilder, @Nullable String str, StartTag startTag, List<Element> list, List<WebvttCssStyle> list2) {
        int i2 = i(list2, str, startTag);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, Element.f14136c);
        int i3 = startTag.f14140b;
        int i4 = 0;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            if (w.equals(((Element) arrayList.get(i5)).f14137a.f14139a)) {
                Element element = (Element) arrayList.get(i5);
                int g2 = g(i(list2, str, element.f14137a), i2, 1);
                int i6 = element.f14137a.f14140b - i4;
                int d2 = element.f14138b - i4;
                CharSequence subSequence = spannableStringBuilder.subSequence(i6, d2);
                spannableStringBuilder.delete(i6, d2);
                spannableStringBuilder.setSpan(new RubySpan(subSequence.toString(), g2), i3, i6, 33);
                i4 += subSequence.length();
                i3 = i6;
            }
        }
    }

    private static void d(@Nullable String str, StartTag startTag, List<Element> list, SpannableStringBuilder spannableStringBuilder, List<WebvttCssStyle> list2) {
        Object styleSpan;
        int i2 = startTag.f14140b;
        int length = spannableStringBuilder.length();
        String str2 = startTag.f14139a;
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 0:
                if (str2.equals("")) {
                    c2 = 0;
                    break;
                }
                break;
            case 98:
                if (str2.equals("b")) {
                    c2 = 1;
                    break;
                }
                break;
            case 99:
                if (str2.equals(s)) {
                    c2 = 2;
                    break;
                }
                break;
            case 105:
                if (str2.equals("i")) {
                    c2 = 3;
                    break;
                }
                break;
            case 117:
                if (str2.equals("u")) {
                    c2 = 4;
                    break;
                }
                break;
            case 118:
                if (str2.equals("v")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str2.equals(u)) {
                    c2 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str2.equals("ruby")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 5:
            case 6:
                break;
            case 1:
                styleSpan = new StyleSpan(1);
                break;
            case 2:
                a(spannableStringBuilder, startTag.f14142d, i2, length);
                break;
            case 3:
                styleSpan = new StyleSpan(2);
                break;
            case 4:
                styleSpan = new UnderlineSpan();
                break;
            case 7:
                c(spannableStringBuilder, str, startTag, list, list2);
                break;
            default:
                return;
        }
        spannableStringBuilder.setSpan(styleSpan, i2, length, 33);
        List<StyleMatch> h2 = h(list2, str, startTag);
        for (int i3 = 0; i3 < h2.size(); i3++) {
            e(spannableStringBuilder, h2.get(i3).X, i2, length);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void e(android.text.SpannableStringBuilder r4, androidx.media3.extractor.text.webvtt.WebvttCssStyle r5, int r6, int r7) {
        /*
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r5.i()
            r1 = -1
            r2 = 33
            if (r0 == r1) goto L_0x0018
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            int r1 = r5.i()
            r0.<init>(r1)
            androidx.media3.common.text.SpanUtil.a(r4, r0, r6, r7, r2)
        L_0x0018:
            boolean r0 = r5.l()
            if (r0 == 0) goto L_0x0026
            android.text.style.StrikethroughSpan r0 = new android.text.style.StrikethroughSpan
            r0.<init>()
            r4.setSpan(r0, r6, r7, r2)
        L_0x0026:
            boolean r0 = r5.m()
            if (r0 == 0) goto L_0x0034
            android.text.style.UnderlineSpan r0 = new android.text.style.UnderlineSpan
            r0.<init>()
            r4.setSpan(r0, r6, r7, r2)
        L_0x0034:
            boolean r0 = r5.k()
            if (r0 == 0) goto L_0x0046
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            int r1 = r5.c()
            r0.<init>(r1)
            androidx.media3.common.text.SpanUtil.a(r4, r0, r6, r7, r2)
        L_0x0046:
            boolean r0 = r5.j()
            if (r0 == 0) goto L_0x0058
            android.text.style.BackgroundColorSpan r0 = new android.text.style.BackgroundColorSpan
            int r1 = r5.a()
            r0.<init>(r1)
            androidx.media3.common.text.SpanUtil.a(r4, r0, r6, r7, r2)
        L_0x0058:
            java.lang.String r0 = r5.d()
            if (r0 == 0) goto L_0x006a
            android.text.style.TypefaceSpan r0 = new android.text.style.TypefaceSpan
            java.lang.String r1 = r5.d()
            r0.<init>(r1)
            androidx.media3.common.text.SpanUtil.a(r4, r0, r6, r7, r2)
        L_0x006a:
            int r0 = r5.f()
            r1 = 1
            if (r0 == r1) goto L_0x0092
            r1 = 2
            if (r0 == r1) goto L_0x0088
            r1 = 3
            if (r0 == r1) goto L_0x0078
            goto L_0x009d
        L_0x0078:
            android.text.style.RelativeSizeSpan r0 = new android.text.style.RelativeSizeSpan
            float r1 = r5.e()
            r3 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r3
            r0.<init>(r1)
        L_0x0084:
            androidx.media3.common.text.SpanUtil.a(r4, r0, r6, r7, r2)
            goto L_0x009d
        L_0x0088:
            android.text.style.RelativeSizeSpan r0 = new android.text.style.RelativeSizeSpan
            float r1 = r5.e()
            r0.<init>(r1)
            goto L_0x0084
        L_0x0092:
            android.text.style.AbsoluteSizeSpan r0 = new android.text.style.AbsoluteSizeSpan
            float r3 = r5.e()
            int r3 = (int) r3
            r0.<init>(r3, r1)
            goto L_0x0084
        L_0x009d:
            boolean r5 = r5.b()
            if (r5 == 0) goto L_0x00ab
            androidx.media3.common.text.HorizontalTextInVerticalContextSpan r5 = new androidx.media3.common.text.HorizontalTextInVerticalContextSpan
            r5.<init>()
            r4.setSpan(r5, r6, r7, r2)
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.webvtt.WebvttCueParser.e(android.text.SpannableStringBuilder, androidx.media3.extractor.text.webvtt.WebvttCssStyle, int, int):void");
    }

    private static int f(String str, int i2) {
        int indexOf = str.indexOf(62, i2);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static int g(int i2, int i3, int i4) {
        if (i2 != -1) {
            return i2;
        }
        if (i3 != -1) {
            return i3;
        }
        if (i4 != -1) {
            return i4;
        }
        throw new IllegalArgumentException();
    }

    private static List<StyleMatch> h(List<WebvttCssStyle> list, @Nullable String str, StartTag startTag) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            WebvttCssStyle webvttCssStyle = list.get(i2);
            int h2 = webvttCssStyle.h(str, startTag.f14139a, startTag.f14142d, startTag.f14141c);
            if (h2 > 0) {
                arrayList.add(new StyleMatch(h2, webvttCssStyle));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static int i(List<WebvttCssStyle> list, @Nullable String str, StartTag startTag) {
        List<StyleMatch> h2 = h(list, str, startTag);
        for (int i2 = 0; i2 < h2.size(); i2++) {
            WebvttCssStyle webvttCssStyle = h2.get(i2).X;
            if (webvttCssStyle.g() != -1) {
                return webvttCssStyle.g();
            }
        }
        return -1;
    }

    private static String j(String str) {
        String trim = str.trim();
        Assertions.a(!trim.isEmpty());
        return Util.q2(trim, "[ \\.]")[0];
    }

    private static boolean k(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    c2 = 0;
                    break;
                }
                break;
            case 99:
                if (str.equals(s)) {
                    c2 = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    c2 = 2;
                    break;
                }
                break;
            case 117:
                if (str.equals("u")) {
                    c2 = 3;
                    break;
                }
                break;
            case 118:
                if (str.equals("v")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3650:
                if (str.equals(w)) {
                    c2 = 5;
                    break;
                }
                break;
            case 3314158:
                if (str.equals(u)) {
                    c2 = 6;
                    break;
                }
                break;
            case 3511770:
                if (str.equals("ruby")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    @VisibleForTesting(otherwise = 3)
    public static Cue l(CharSequence charSequence) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        webvttCueInfoBuilder.f14145c = charSequence;
        return webvttCueInfoBuilder.g().a();
    }

    @Nullable
    public static WebvttCueInfo m(ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        String u2 = parsableByteArray.u();
        if (u2 == null) {
            return null;
        }
        Pattern pattern = f14127f;
        Matcher matcher = pattern.matcher(u2);
        if (matcher.matches()) {
            return n((String) null, matcher, parsableByteArray, list);
        }
        String u3 = parsableByteArray.u();
        if (u3 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(u3);
        if (matcher2.matches()) {
            return n(u2.trim(), matcher2, parsableByteArray, list);
        }
        return null;
    }

    @Nullable
    private static WebvttCueInfo n(@Nullable String str, Matcher matcher, ParsableByteArray parsableByteArray, List<WebvttCssStyle> list) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        try {
            webvttCueInfoBuilder.f14143a = WebvttParserUtil.d((String) Assertions.g(matcher.group(1)));
            webvttCueInfoBuilder.f14144b = WebvttParserUtil.d((String) Assertions.g(matcher.group(2)));
            p((String) Assertions.g(matcher.group(3)), webvttCueInfoBuilder);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String u2 = parsableByteArray.u();
                if (!TextUtils.isEmpty(u2)) {
                    if (sb.length() > 0) {
                        sb.append(StringUtils.LF);
                    }
                    sb.append(u2.trim());
                } else {
                    webvttCueInfoBuilder.f14145c = q(str, sb.toString(), list);
                    return webvttCueInfoBuilder.a();
                }
            }
        } catch (NumberFormatException unused) {
            Log.n(C, "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    static Cue.Builder o(String str) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        p(str, webvttCueInfoBuilder);
        return webvttCueInfoBuilder.g();
    }

    private static void p(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        Matcher matcher = f14128g.matcher(str);
        while (matcher.find()) {
            String str2 = (String) Assertions.g(matcher.group(1));
            String str3 = (String) Assertions.g(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    s(str3, webvttCueInfoBuilder);
                } else if ("align".equals(str2)) {
                    webvttCueInfoBuilder.f14146d = v(str3);
                } else if (CSS.Property.m0.equals(str2)) {
                    u(str3, webvttCueInfoBuilder);
                } else if ("size".equals(str2)) {
                    webvttCueInfoBuilder.f14152j = WebvttParserUtil.c(str3);
                } else if ("vertical".equals(str2)) {
                    webvttCueInfoBuilder.f14153k = w(str3);
                } else {
                    Log.n(C, "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                Log.n(C, "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    static SpannedString q(@Nullable String str, String str2, List<WebvttCssStyle> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < str2.length()) {
            char charAt = str2.charAt(i2);
            if (charAt == '&') {
                i2++;
                int indexOf = str2.indexOf(59, i2);
                int indexOf2 = str2.indexOf(32, i2);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    b(str2.substring(i2, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(StringUtils.SPACE);
                    }
                    i2 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i2++;
            } else {
                int i3 = i2 + 1;
                if (i3 < str2.length()) {
                    int i4 = 1;
                    boolean z2 = str2.charAt(i3) == '/';
                    i3 = f(str2, i3);
                    int i5 = i3 - 2;
                    boolean z3 = str2.charAt(i5) == '/';
                    if (z2) {
                        i4 = 2;
                    }
                    int i6 = i2 + i4;
                    if (!z3) {
                        i5 = i3 - 1;
                    }
                    String substring = str2.substring(i6, i5);
                    if (!substring.trim().isEmpty()) {
                        String j2 = j(substring);
                        if (k(j2)) {
                            if (z2) {
                                while (!arrayDeque.isEmpty()) {
                                    StartTag startTag = (StartTag) arrayDeque.pop();
                                    d(str, startTag, arrayList, spannableStringBuilder, list);
                                    if (!arrayDeque.isEmpty()) {
                                        arrayList.add(new Element(startTag, spannableStringBuilder.length()));
                                    } else {
                                        arrayList.clear();
                                    }
                                    if (startTag.f14139a.equals(j2)) {
                                        break;
                                    }
                                }
                            } else if (!z3) {
                                arrayDeque.push(StartTag.a(substring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i2 = i3;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (StartTag) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, StartTag.b(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    private static int r(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals(HtmlTags.g0)) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals(TtmlNode.p0)) {
                    c2 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                Log.n(C, "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void s(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCueInfoBuilder.f14149g = r(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith(CSS.Value.n0)) {
            webvttCueInfoBuilder.f14147e = WebvttParserUtil.c(str);
            webvttCueInfoBuilder.f14148f = 0;
            return;
        }
        webvttCueInfoBuilder.f14147e = (float) Integer.parseInt(str);
        webvttCueInfoBuilder.f14148f = 1;
    }

    private static int t(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1842484672:
                if (str.equals("line-left")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1276788989:
                if (str.equals("line-right")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals(HtmlTags.g0)) {
                    c2 = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals(TtmlNode.p0)) {
                    c2 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 5:
                return 0;
            case 1:
            case 3:
                return 1;
            case 2:
            case 4:
                return 2;
            default:
                Log.n(C, "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void u(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            webvttCueInfoBuilder.f14151i = t(str.substring(indexOf + 1));
            str = str.substring(0, indexOf);
        }
        webvttCueInfoBuilder.f14150h = WebvttParserUtil.c(str);
    }

    private static int v(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals(HtmlTags.g0)) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals(TtmlNode.p0)) {
                    c2 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c2 = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c2 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 1;
            default:
                Log.n(C, "Invalid alignment value: " + str);
                return 2;
        }
    }

    private static int w(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        Log.n(C, "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }
}
