package androidx.media3.extractor.text.ttml;

import android.text.SpannableStringBuilder;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

final class TtmlRenderUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14056a = "TtmlRenderUtil";

    private TtmlRenderUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.text.Spannable r8, int r9, int r10, androidx.media3.extractor.text.ttml.TtmlStyle r11, @androidx.annotation.Nullable androidx.media3.extractor.text.ttml.TtmlNode r12, java.util.Map<java.lang.String, androidx.media3.extractor.text.ttml.TtmlStyle> r13, int r14) {
        /*
            int r0 = r11.l()
            r1 = 33
            r2 = -1
            if (r0 == r2) goto L_0x0015
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            int r3 = r11.l()
            r0.<init>(r3)
            r8.setSpan(r0, r9, r10, r1)
        L_0x0015:
            boolean r0 = r11.t()
            if (r0 == 0) goto L_0x0023
            android.text.style.StrikethroughSpan r0 = new android.text.style.StrikethroughSpan
            r0.<init>()
            r8.setSpan(r0, r9, r10, r1)
        L_0x0023:
            boolean r0 = r11.u()
            if (r0 == 0) goto L_0x0031
            android.text.style.UnderlineSpan r0 = new android.text.style.UnderlineSpan
            r0.<init>()
            r8.setSpan(r0, r9, r10, r1)
        L_0x0031:
            boolean r0 = r11.q()
            if (r0 == 0) goto L_0x0043
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan
            int r3 = r11.c()
            r0.<init>(r3)
            androidx.media3.common.text.SpanUtil.a(r8, r0, r9, r10, r1)
        L_0x0043:
            boolean r0 = r11.p()
            if (r0 == 0) goto L_0x0055
            android.text.style.BackgroundColorSpan r0 = new android.text.style.BackgroundColorSpan
            int r3 = r11.b()
            r0.<init>(r3)
            androidx.media3.common.text.SpanUtil.a(r8, r0, r9, r10, r1)
        L_0x0055:
            java.lang.String r0 = r11.d()
            if (r0 == 0) goto L_0x0067
            android.text.style.TypefaceSpan r0 = new android.text.style.TypefaceSpan
            java.lang.String r3 = r11.d()
            r0.<init>(r3)
            androidx.media3.common.text.SpanUtil.a(r8, r0, r9, r10, r1)
        L_0x0067:
            androidx.media3.extractor.text.ttml.TextEmphasis r0 = r11.o()
            r3 = 3
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L_0x0098
            androidx.media3.extractor.text.ttml.TextEmphasis r0 = r11.o()
            java.lang.Object r0 = androidx.media3.common.util.Assertions.g(r0)
            androidx.media3.extractor.text.ttml.TextEmphasis r0 = (androidx.media3.extractor.text.ttml.TextEmphasis) r0
            int r6 = r0.f14010a
            if (r6 != r2) goto L_0x0088
            if (r14 == r4) goto L_0x0085
            if (r14 != r5) goto L_0x0083
            goto L_0x0085
        L_0x0083:
            r6 = 1
            goto L_0x0086
        L_0x0085:
            r6 = 3
        L_0x0086:
            r14 = 1
            goto L_0x008a
        L_0x0088:
            int r14 = r0.f14011b
        L_0x008a:
            int r0 = r0.f14012c
            r7 = -2
            if (r0 != r7) goto L_0x0090
            r0 = 1
        L_0x0090:
            androidx.media3.common.text.TextEmphasisSpan r7 = new androidx.media3.common.text.TextEmphasisSpan
            r7.<init>(r6, r14, r0)
            androidx.media3.common.text.SpanUtil.a(r8, r7, r9, r10, r1)
        L_0x0098:
            int r14 = r11.j()
            if (r14 == r4) goto L_0x00ad
            if (r14 == r3) goto L_0x00a4
            r12 = 4
            if (r14 == r12) goto L_0x00a4
            goto L_0x0107
        L_0x00a4:
            androidx.media3.extractor.text.ttml.DeleteTextSpan r12 = new androidx.media3.extractor.text.ttml.DeleteTextSpan
            r12.<init>()
        L_0x00a9:
            r8.setSpan(r12, r9, r10, r1)
            goto L_0x0107
        L_0x00ad:
            androidx.media3.extractor.text.ttml.TtmlNode r12 = d(r12, r13)
            if (r12 != 0) goto L_0x00b4
            goto L_0x0107
        L_0x00b4:
            androidx.media3.extractor.text.ttml.TtmlNode r14 = e(r12, r13)
            if (r14 != 0) goto L_0x00bb
            goto L_0x0107
        L_0x00bb:
            int r0 = r14.g()
            if (r0 != r5) goto L_0x0100
            r0 = 0
            androidx.media3.extractor.text.ttml.TtmlNode r6 = r14.f(r0)
            java.lang.String r6 = r6.f14015b
            if (r6 == 0) goto L_0x0100
            androidx.media3.extractor.text.ttml.TtmlNode r0 = r14.f(r0)
            java.lang.String r0 = r0.f14015b
            java.lang.Object r0 = androidx.media3.common.util.Util.o(r0)
            java.lang.String r0 = (java.lang.String) r0
            androidx.media3.extractor.text.ttml.TtmlStyle r6 = r14.f14019f
            java.lang.String[] r14 = r14.l()
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = f(r6, r14, r13)
            if (r14 == 0) goto L_0x00e7
            int r14 = r14.i()
            goto L_0x00e8
        L_0x00e7:
            r14 = -1
        L_0x00e8:
            if (r14 != r2) goto L_0x00fa
            androidx.media3.extractor.text.ttml.TtmlStyle r2 = r12.f14019f
            java.lang.String[] r12 = r12.l()
            androidx.media3.extractor.text.ttml.TtmlStyle r12 = f(r2, r12, r13)
            if (r12 == 0) goto L_0x00fa
            int r14 = r12.i()
        L_0x00fa:
            androidx.media3.common.text.RubySpan r12 = new androidx.media3.common.text.RubySpan
            r12.<init>(r0, r14)
            goto L_0x00a9
        L_0x0100:
            java.lang.String r12 = "TtmlRenderUtil"
            java.lang.String r13 = "Skipping rubyText node without exactly one text child."
            androidx.media3.common.util.Log.h(r12, r13)
        L_0x0107:
            boolean r12 = r11.n()
            if (r12 == 0) goto L_0x0115
            androidx.media3.common.text.HorizontalTextInVerticalContextSpan r12 = new androidx.media3.common.text.HorizontalTextInVerticalContextSpan
            r12.<init>()
            androidx.media3.common.text.SpanUtil.a(r8, r12, r9, r10, r1)
        L_0x0115:
            int r12 = r11.f()
            if (r12 == r5) goto L_0x013a
            if (r12 == r4) goto L_0x0130
            if (r12 == r3) goto L_0x0120
            goto L_0x0145
        L_0x0120:
            android.text.style.RelativeSizeSpan r12 = new android.text.style.RelativeSizeSpan
            float r11 = r11.e()
            r13 = 1120403456(0x42c80000, float:100.0)
            float r11 = r11 / r13
            r12.<init>(r11)
        L_0x012c:
            androidx.media3.common.text.SpanUtil.a(r8, r12, r9, r10, r1)
            goto L_0x0145
        L_0x0130:
            android.text.style.RelativeSizeSpan r12 = new android.text.style.RelativeSizeSpan
            float r11 = r11.e()
            r12.<init>(r11)
            goto L_0x012c
        L_0x013a:
            android.text.style.AbsoluteSizeSpan r12 = new android.text.style.AbsoluteSizeSpan
            float r11 = r11.e()
            int r11 = (int) r11
            r12.<init>(r11, r5)
            goto L_0x012c
        L_0x0145:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlRenderUtil.a(android.text.Spannable, int, int, androidx.media3.extractor.text.ttml.TtmlStyle, androidx.media3.extractor.text.ttml.TtmlNode, java.util.Map, int):void");
    }

    static String b(String str) {
        return str.replaceAll("\r\n", StringUtils.LF).replaceAll(" *\n *", StringUtils.LF).replaceAll(StringUtils.LF, StringUtils.SPACE).replaceAll("[ \t\\x0B\f\r]+", StringUtils.SPACE);
    }

    static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != 10) {
            spannableStringBuilder.append(10);
        }
    }

    @Nullable
    private static TtmlNode d(@Nullable TtmlNode ttmlNode, Map<String, TtmlStyle> map) {
        while (ttmlNode != null) {
            TtmlStyle f2 = f(ttmlNode.f14019f, ttmlNode.l(), map);
            if (f2 != null && f2.j() == 1) {
                return ttmlNode;
            }
            ttmlNode = ttmlNode.f14023j;
        }
        return null;
    }

    @Nullable
    private static TtmlNode e(TtmlNode ttmlNode, Map<String, TtmlStyle> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(ttmlNode);
        while (!arrayDeque.isEmpty()) {
            TtmlNode ttmlNode2 = (TtmlNode) arrayDeque.pop();
            TtmlStyle f2 = f(ttmlNode2.f14019f, ttmlNode2.l(), map);
            if (f2 != null && f2.j() == 3) {
                return ttmlNode2;
            }
            for (int g2 = ttmlNode2.g() - 1; g2 >= 0; g2--) {
                arrayDeque.push(ttmlNode2.f(g2));
            }
        }
        return null;
    }

    @Nullable
    public static TtmlStyle f(@Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, Map<String, TtmlStyle> map) {
        int i2 = 0;
        if (ttmlStyle == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                TtmlStyle ttmlStyle2 = new TtmlStyle();
                int length = strArr.length;
                while (i2 < length) {
                    ttmlStyle2.a(map.get(strArr[i2]));
                    i2++;
                }
                return ttmlStyle2;
            }
        } else if (strArr != null && strArr.length == 1) {
            return ttmlStyle.a(map.get(strArr[0]));
        } else {
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i2 < length2) {
                    ttmlStyle.a(map.get(strArr[i2]));
                    i2++;
                }
            }
        }
        return ttmlStyle;
    }
}
