package androidx.media3.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.text.HorizontalTextInVerticalContextSpan;
import androidx.media3.common.text.RubySpan;
import androidx.media3.common.text.TextEmphasisSpan;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

final class SpannedToHtmlConverter {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f14823a = Pattern.compile("(&#13;)?&#10;");

    public static class HtmlAndCss {

        /* renamed from: a  reason: collision with root package name */
        public final String f14824a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, String> f14825b;

        private HtmlAndCss(String str, Map<String, String> map) {
            this.f14824a = str;
            this.f14825b = map;
        }
    }

    private static final class SpanInfo {
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public static final Comparator<SpanInfo> f14826e = new G();
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public static final Comparator<SpanInfo> f14827f = new H();

        /* renamed from: a  reason: collision with root package name */
        public final int f14828a;

        /* renamed from: b  reason: collision with root package name */
        public final int f14829b;

        /* renamed from: c  reason: collision with root package name */
        public final String f14830c;

        /* renamed from: d  reason: collision with root package name */
        public final String f14831d;

        private SpanInfo(int i2, int i3, String str, String str2) {
            this.f14828a = i2;
            this.f14829b = i3;
            this.f14830c = str;
            this.f14831d = str2;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ int e(SpanInfo spanInfo, SpanInfo spanInfo2) {
            int compare = Integer.compare(spanInfo2.f14829b, spanInfo.f14829b);
            if (compare != 0) {
                return compare;
            }
            int compareTo = spanInfo.f14830c.compareTo(spanInfo2.f14830c);
            return compareTo != 0 ? compareTo : spanInfo.f14831d.compareTo(spanInfo2.f14831d);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ int f(SpanInfo spanInfo, SpanInfo spanInfo2) {
            int compare = Integer.compare(spanInfo2.f14828a, spanInfo.f14828a);
            if (compare != 0) {
                return compare;
            }
            int compareTo = spanInfo2.f14830c.compareTo(spanInfo.f14830c);
            return compareTo != 0 ? compareTo : spanInfo2.f14831d.compareTo(spanInfo.f14831d);
        }
    }

    private static final class Transition {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<SpanInfo> f14832a = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final List<SpanInfo> f14833b = new ArrayList();
    }

    private SpannedToHtmlConverter() {
    }

    public static HtmlAndCss a(@Nullable CharSequence charSequence, float f2) {
        int i2 = 0;
        if (charSequence == null) {
            return new HtmlAndCss("", ImmutableMap.s());
        }
        if (!(charSequence instanceof Spanned)) {
            return new HtmlAndCss(b(charSequence), ImmutableMap.s());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet<Integer> hashSet = new HashSet<>();
        for (BackgroundColorSpan backgroundColor : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColor.getBackgroundColor()));
        }
        HashMap hashMap = new HashMap();
        for (Integer intValue : hashSet) {
            int intValue2 = intValue.intValue();
            hashMap.put(HtmlUtils.a("bg_" + intValue2), Util.S("background-color:%s;", HtmlUtils.b(intValue2)));
        }
        SparseArray<Transition> c2 = c(spanned, f2);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i3 = 0;
        while (i2 < c2.size()) {
            int keyAt = c2.keyAt(i2);
            sb.append(b(spanned.subSequence(i3, keyAt)));
            Transition transition = c2.get(keyAt);
            Collections.sort(transition.f14833b, SpanInfo.f14827f);
            for (SpanInfo spanInfo : transition.f14833b) {
                sb.append(spanInfo.f14831d);
            }
            Collections.sort(transition.f14832a, SpanInfo.f14826e);
            for (SpanInfo spanInfo2 : transition.f14832a) {
                sb.append(spanInfo2.f14830c);
            }
            i2++;
            i3 = keyAt;
        }
        sb.append(b(spanned.subSequence(i3, spanned.length())));
        return new HtmlAndCss(sb.toString(), hashMap);
    }

    private static String b(CharSequence charSequence) {
        return f14823a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static SparseArray<Transition> c(Spanned spanned, float f2) {
        SparseArray<Transition> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String e2 = e(obj, f2);
            String d2 = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (e2 != null) {
                Assertions.g(d2);
                SpanInfo spanInfo = new SpanInfo(spanStart, spanEnd, e2, d2);
                f(sparseArray, spanStart).f14832a.add(spanInfo);
                f(sparseArray, spanEnd).f14833b.add(spanInfo);
            }
        }
        return sparseArray;
    }

    @Nullable
    private static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof HorizontalTextInVerticalContextSpan) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof TextEmphasisSpan)) {
            return "</span>";
        }
        if (!(obj instanceof TypefaceSpan)) {
            if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    return "</b>";
                }
                if (style == 2) {
                    return "</i>";
                }
                if (style != 3) {
                    return null;
                }
                return "</i></b>";
            } else if (obj instanceof RubySpan) {
                return "<rt>" + b(((RubySpan) obj).f9478a) + "</rt></ruby>";
            } else if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
            return null;
        } else if (((TypefaceSpan) obj).getFamily() != null) {
            return "</span>";
        } else {
            return null;
        }
    }

    @Nullable
    private static String e(Object obj, float f2) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return Util.S("<span style='color:%s;'>", HtmlUtils.b(((ForegroundColorSpan) obj).getForegroundColor()));
        } else if (obj instanceof BackgroundColorSpan) {
            return Util.S("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        } else if (obj instanceof HorizontalTextInVerticalContextSpan) {
            return "<span style='text-combine-upright:all;'>";
        } else {
            if (obj instanceof AbsoluteSizeSpan) {
                AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
                boolean dip = absoluteSizeSpan.getDip();
                float size = (float) absoluteSizeSpan.getSize();
                if (!dip) {
                    size /= f2;
                }
                return Util.S("<span style='font-size:%.2fpx;'>", Float.valueOf(size));
            } else if (obj instanceof RelativeSizeSpan) {
                return Util.S("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
            } else if (obj instanceof TypefaceSpan) {
                String family = ((TypefaceSpan) obj).getFamily();
                if (family == null) {
                    return null;
                }
                return Util.S("<span style='font-family:\"%s\";'>", family);
            } else if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    return "<b>";
                }
                if (style == 2) {
                    return "<i>";
                }
                if (style != 3) {
                    return null;
                }
                return "<b><i>";
            } else if (obj instanceof RubySpan) {
                int i2 = ((RubySpan) obj).f9479b;
                if (i2 == -1) {
                    return "<ruby style='ruby-position:unset;'>";
                }
                if (i2 == 1) {
                    return "<ruby style='ruby-position:over;'>";
                }
                if (i2 != 2) {
                    return null;
                }
                return "<ruby style='ruby-position:under;'>";
            } else if (obj instanceof UnderlineSpan) {
                return "<u>";
            } else {
                if (!(obj instanceof TextEmphasisSpan)) {
                    return null;
                }
                TextEmphasisSpan textEmphasisSpan = (TextEmphasisSpan) obj;
                return Util.S("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(textEmphasisSpan.f9493a, textEmphasisSpan.f9494b), g(textEmphasisSpan.f9495c));
            }
        }
    }

    private static Transition f(SparseArray<Transition> sparseArray, int i2) {
        Transition transition = sparseArray.get(i2);
        if (transition != null) {
            return transition;
        }
        Transition transition2 = new Transition();
        sparseArray.put(i2, transition2);
        return transition2;
    }

    private static String g(int i2) {
        return i2 != 2 ? "over right" : "under left";
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String h(int r3, int r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 2
            r2 = 1
            if (r4 == r2) goto L_0x0012
            if (r4 == r1) goto L_0x000c
            goto L_0x0015
        L_0x000c:
            java.lang.String r4 = "open "
        L_0x000e:
            r0.append(r4)
            goto L_0x0015
        L_0x0012:
            java.lang.String r4 = "filled "
            goto L_0x000e
        L_0x0015:
            if (r3 == 0) goto L_0x002d
            if (r3 == r2) goto L_0x002a
            if (r3 == r1) goto L_0x0027
            r4 = 3
            if (r3 == r4) goto L_0x0024
            java.lang.String r3 = "unset"
        L_0x0020:
            r0.append(r3)
            goto L_0x0030
        L_0x0024:
            java.lang.String r3 = "sesame"
            goto L_0x0020
        L_0x0027:
            java.lang.String r3 = "dot"
            goto L_0x0020
        L_0x002a:
            java.lang.String r3 = "circle"
            goto L_0x0020
        L_0x002d:
            java.lang.String r3 = "none"
            goto L_0x0020
        L_0x0030:
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.SpannedToHtmlConverter.h(int, int):java.lang.String");
    }
}
