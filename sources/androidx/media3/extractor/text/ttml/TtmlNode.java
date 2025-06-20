package androidx.media3.extractor.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

final class TtmlNode {
    public static final String A = "data";
    public static final String A0 = "filled";
    public static final String B = "information";
    public static final String B0 = "open";
    public static final String C = "";
    public static final String D = "id";
    public static final String E = "origin";
    public static final String F = "extent";
    public static final String G = "displayAlign";
    public static final String H = "backgroundColor";
    public static final String I = "fontStyle";
    public static final String J = "fontSize";
    public static final String K = "fontFamily";
    public static final String L = "fontWeight";
    public static final String M = "color";
    public static final String N = "ruby";
    public static final String O = "rubyPosition";
    public static final String P = "textDecoration";
    public static final String Q = "textAlign";
    public static final String R = "textCombine";
    public static final String S = "textEmphasis";
    public static final String T = "writingMode";
    public static final String U = "shear";
    public static final String V = "multiRowAlign";
    public static final String W = "container";
    public static final String X = "base";
    public static final String Y = "baseContainer";
    public static final String Z = "text";
    public static final String a0 = "textContainer";
    public static final String b0 = "delimiter";
    public static final String c0 = "before";
    public static final String d0 = "after";
    public static final String e0 = "outside";
    public static final String f0 = "linethrough";
    public static final String g0 = "nolinethrough";
    public static final String h0 = "underline";
    public static final String i0 = "nounderline";
    public static final String j0 = "italic";
    public static final String k0 = "bold";
    public static final String l0 = "left";
    public static final String m0 = "center";

    /* renamed from: n  reason: collision with root package name */
    public static final String f14013n = "tt";
    public static final String n0 = "right";
    public static final String o = "head";
    public static final String o0 = "start";
    public static final String p = "body";
    public static final String p0 = "end";
    public static final String q = "div";
    public static final String q0 = "none";
    public static final String r = "p";
    public static final String r0 = "all";
    public static final String s = "span";
    public static final String s0 = "tb";
    public static final String t = "br";
    public static final String t0 = "tblr";
    public static final String u = "style";
    public static final String u0 = "tbrl";
    public static final String v = "styling";
    public static final String v0 = "none";
    public static final String w = "layout";
    public static final String w0 = "auto";
    public static final String x = "region";
    public static final String x0 = "dot";
    public static final String y = "metadata";
    public static final String y0 = "sesame";
    public static final String z = "image";
    public static final String z0 = "circle";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f14014a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f14015b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f14016c;

    /* renamed from: d  reason: collision with root package name */
    public final long f14017d;

    /* renamed from: e  reason: collision with root package name */
    public final long f14018e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final TtmlStyle f14019f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final String[] f14020g;

    /* renamed from: h  reason: collision with root package name */
    public final String f14021h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final String f14022i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final TtmlNode f14023j;

    /* renamed from: k  reason: collision with root package name */
    private final HashMap<String, Integer> f14024k;

    /* renamed from: l  reason: collision with root package name */
    private final HashMap<String, Integer> f14025l;

    /* renamed from: m  reason: collision with root package name */
    private List<TtmlNode> f14026m;

    private TtmlNode(@Nullable String str, @Nullable String str2, long j2, long j3, @Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable TtmlNode ttmlNode) {
        this.f14014a = str;
        this.f14015b = str2;
        this.f14022i = str4;
        this.f14019f = ttmlStyle;
        this.f14020g = strArr;
        this.f14016c = str2 != null;
        this.f14017d = j2;
        this.f14018e = j3;
        this.f14021h = (String) Assertions.g(str3);
        this.f14023j = ttmlNode;
        this.f14024k = new HashMap<>();
        this.f14025l = new HashMap<>();
    }

    private void b(Map<String, TtmlStyle> map, Cue.Builder builder, int i2, int i3, int i4) {
        TtmlStyle f2 = TtmlRenderUtil.f(this.f14019f, this.f14020g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) builder.k();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            builder.A(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (f2 != null) {
            TtmlRenderUtil.a(spannableStringBuilder2, i2, i3, f2, this.f14023j, map, i4);
            if ("p".equals(this.f14014a)) {
                if (f2.k() != Float.MAX_VALUE) {
                    builder.y((f2.k() * -90.0f) / 100.0f);
                }
                if (f2.m() != null) {
                    builder.B(f2.m());
                }
                if (f2.h() != null) {
                    builder.v(f2.h());
                }
            }
        }
    }

    public static TtmlNode c(@Nullable String str, long j2, long j3, @Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, String str2, @Nullable String str3, @Nullable TtmlNode ttmlNode) {
        return new TtmlNode(str, (String) null, j2, j3, ttmlStyle, strArr, str2, str3, ttmlNode);
    }

    public static TtmlNode d(String str) {
        return new TtmlNode((String) null, TtmlRenderUtil.b(str), C.f9084b, C.f9084b, (TtmlStyle) null, (String[]) null, "", (String) null, (TtmlNode) null);
    }

    private static void e(SpannableStringBuilder spannableStringBuilder) {
        for (DeleteTextSpan deleteTextSpan : (DeleteTextSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), DeleteTextSpan.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(deleteTextSpan), spannableStringBuilder.getSpanEnd(deleteTextSpan), "");
        }
        for (int i2 = 0; i2 < spannableStringBuilder.length(); i2++) {
            if (spannableStringBuilder.charAt(i2) == ' ') {
                int i3 = i2 + 1;
                int i4 = i3;
                while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                    i4++;
                }
                int i5 = i4 - i3;
                if (i5 > 0) {
                    spannableStringBuilder.delete(i2, i5 + i2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i6 = 0; i6 < spannableStringBuilder.length() - 1; i6++) {
            if (spannableStringBuilder.charAt(i6) == 10) {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i8 = 0; i8 < spannableStringBuilder.length() - 1; i8++) {
            if (spannableStringBuilder.charAt(i8) == ' ') {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i9) == 10) {
                    spannableStringBuilder.delete(i8, i9);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == 10) {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
    }

    private void i(TreeSet<Long> treeSet, boolean z2) {
        boolean equals = "p".equals(this.f14014a);
        boolean equals2 = "div".equals(this.f14014a);
        if (z2 || equals || (equals2 && this.f14022i != null)) {
            long j2 = this.f14017d;
            if (j2 != C.f9084b) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.f14018e;
            if (j3 != C.f9084b) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.f14026m != null) {
            for (int i2 = 0; i2 < this.f14026m.size(); i2++) {
                this.f14026m.get(i2).i(treeSet, z2 || equals);
            }
        }
    }

    private static SpannableStringBuilder k(String str, Map<String, Cue.Builder> map) {
        if (!map.containsKey(str)) {
            Cue.Builder builder = new Cue.Builder();
            builder.A(new SpannableStringBuilder());
            map.put(str, builder);
        }
        return (SpannableStringBuilder) Assertions.g(map.get(str).k());
    }

    private void n(long j2, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f14021h)) {
            str = this.f14021h;
        }
        if (!m(j2) || !"div".equals(this.f14014a) || this.f14022i == null) {
            for (int i2 = 0; i2 < g(); i2++) {
                f(i2).n(j2, str, list);
            }
            return;
        }
        list.add(new Pair(str, this.f14022i));
    }

    private void o(long j2, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, String str, Map<String, Cue.Builder> map3) {
        int i2;
        if (m(j2)) {
            String str2 = "".equals(this.f14021h) ? str : this.f14021h;
            Iterator<Map.Entry<String, Integer>> it2 = this.f14025l.entrySet().iterator();
            while (true) {
                i2 = 0;
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                String str3 = (String) next.getKey();
                int intValue = this.f14024k.containsKey(str3) ? this.f14024k.get(str3).intValue() : 0;
                int intValue2 = ((Integer) next.getValue()).intValue();
                if (intValue != intValue2) {
                    b(map, (Cue.Builder) Assertions.g(map3.get(str3)), intValue, intValue2, ((TtmlRegion) Assertions.g(map2.get(str2))).f14055j);
                } else {
                    Map<String, TtmlRegion> map4 = map2;
                    Map<String, Cue.Builder> map5 = map3;
                }
            }
            Map<String, TtmlRegion> map6 = map2;
            Map<String, Cue.Builder> map7 = map3;
            while (i2 < g()) {
                f(i2).o(j2, map, map2, str2, map3);
                i2++;
                Map<String, TtmlRegion> map8 = map2;
            }
        }
    }

    private void p(long j2, boolean z2, String str, Map<String, Cue.Builder> map) {
        this.f14024k.clear();
        this.f14025l.clear();
        if (!y.equals(this.f14014a)) {
            if (!"".equals(this.f14021h)) {
                str = this.f14021h;
            }
            if (this.f14016c && z2) {
                k(str, map).append((CharSequence) Assertions.g(this.f14015b));
            } else if ("br".equals(this.f14014a) && z2) {
                k(str, map).append(10);
            } else if (m(j2)) {
                for (Map.Entry next : map.entrySet()) {
                    this.f14024k.put((String) next.getKey(), Integer.valueOf(((CharSequence) Assertions.g(((Cue.Builder) next.getValue()).k())).length()));
                }
                boolean equals = "p".equals(this.f14014a);
                for (int i2 = 0; i2 < g(); i2++) {
                    f(i2).p(j2, z2 || equals, str, map);
                }
                if (equals) {
                    TtmlRenderUtil.c(k(str, map));
                }
                for (Map.Entry next2 : map.entrySet()) {
                    this.f14025l.put((String) next2.getKey(), Integer.valueOf(((CharSequence) Assertions.g(((Cue.Builder) next2.getValue()).k())).length()));
                }
            }
        }
    }

    public void a(TtmlNode ttmlNode) {
        if (this.f14026m == null) {
            this.f14026m = new ArrayList();
        }
        this.f14026m.add(ttmlNode);
    }

    public TtmlNode f(int i2) {
        List<TtmlNode> list = this.f14026m;
        if (list != null) {
            return list.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<TtmlNode> list = this.f14026m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<Cue> h(long j2, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        ArrayList<Pair> arrayList = new ArrayList<>();
        n(j2, this.f14021h, arrayList);
        TreeMap treeMap = new TreeMap();
        long j3 = j2;
        p(j3, false, this.f14021h, treeMap);
        o(j3, map, map2, this.f14021h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                TtmlRegion ttmlRegion = (TtmlRegion) Assertions.g(map2.get(pair.first));
                arrayList2.add(new Cue.Builder().r(decodeByteArray).w(ttmlRegion.f14047b).x(0).t(ttmlRegion.f14048c, 0).u(ttmlRegion.f14050e).z(ttmlRegion.f14051f).s(ttmlRegion.f14052g).D(ttmlRegion.f14055j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = (TtmlRegion) Assertions.g(map2.get(entry.getKey()));
            Cue.Builder builder = (Cue.Builder) entry.getValue();
            e((SpannableStringBuilder) Assertions.g(builder.k()));
            builder.t(ttmlRegion2.f14048c, ttmlRegion2.f14049d);
            builder.u(ttmlRegion2.f14050e);
            builder.w(ttmlRegion2.f14047b);
            builder.z(ttmlRegion2.f14051f);
            builder.C(ttmlRegion2.f14054i, ttmlRegion2.f14053h);
            builder.D(ttmlRegion2.f14055j);
            arrayList2.add(builder.a());
        }
        return arrayList2;
    }

    public long[] j() {
        TreeSet treeSet = new TreeSet();
        int i2 = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            jArr[i2] = ((Long) it2.next()).longValue();
            i2++;
        }
        return jArr;
    }

    @Nullable
    public String[] l() {
        return this.f14020g;
    }

    public boolean m(long j2) {
        long j3 = this.f14017d;
        return (j3 == C.f9084b && this.f14018e == C.f9084b) || (j3 <= j2 && this.f14018e == C.f9084b) || ((j3 == C.f9084b && j2 < this.f14018e) || (j3 <= j2 && j2 < this.f14018e));
    }
}
