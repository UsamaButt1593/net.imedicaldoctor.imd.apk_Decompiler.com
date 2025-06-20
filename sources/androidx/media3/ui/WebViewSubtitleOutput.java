package androidx.media3.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Util;
import androidx.media3.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class WebViewSubtitleOutput extends FrameLayout implements SubtitleView.Output {
    private static final float d3 = 1.2f;
    private static final String e3 = "default_bg";
    private final WebView X2;
    private List<Cue> Y2;
    private CaptionStyleCompat Z2;
    private float a3;
    private int b3;
    private float c3;
    private final CanvasSubtitleOutput s;

    /* renamed from: androidx.media3.ui.WebViewSubtitleOutput$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14862a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                android.text.Layout$Alignment[] r0 = android.text.Layout.Alignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14862a = r0
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14862a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14862a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.WebViewSubtitleOutput.AnonymousClass2.<clinit>():void");
        }
    }

    public WebViewSubtitleOutput(Context context) {
        this(context, (AttributeSet) null);
    }

    private static int b(int i2) {
        if (i2 != 1) {
            return i2 != 2 ? 0 : -100;
        }
        return -50;
    }

    private static String c(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i2 = AnonymousClass2.f14862a[alignment.ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? "center" : TtmlNode.p0;
        }
        return "start";
    }

    private static String d(CaptionStyleCompat captionStyleCompat) {
        int i2 = captionStyleCompat.f14622d;
        if (i2 == 1) {
            return Util.S("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", HtmlUtils.b(captionStyleCompat.f14623e));
        } else if (i2 == 2) {
            return Util.S("0.1em 0.12em 0.15em %s", HtmlUtils.b(captionStyleCompat.f14623e));
        } else if (i2 == 3) {
            return Util.S("0.06em 0.08em 0.15em %s", HtmlUtils.b(captionStyleCompat.f14623e));
        } else if (i2 != 4) {
            return "unset";
        } else {
            return Util.S("-0.05em -0.05em 0.15em %s", HtmlUtils.b(captionStyleCompat.f14623e));
        }
    }

    private String e(int i2, float f2) {
        float h2 = SubtitleViewUtils.h(i2, f2, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (h2 == -3.4028235E38f) {
            return "unset";
        }
        return Util.S("%.2fpx", Float.valueOf(h2 / getContext().getResources().getDisplayMetrics().density));
    }

    private static String f(int i2) {
        if (i2 != 1) {
            return i2 != 2 ? "horizontal-tb" : "vertical-lr";
        }
        return "vertical-rl";
    }

    private static String h(Cue cue) {
        float f2 = cue.j3;
        if (f2 == 0.0f) {
            return "";
        }
        int i2 = cue.i3;
        return Util.S("%s(%.2fdeg)", (i2 == 2 || i2 == 1) ? "skewY" : "skewX", Float.valueOf(f2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x014c, code lost:
        if (r13 != false) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x014f, code lost:
        r21 = "left";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0152, code lost:
        if (r13 != false) goto L_0x014f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0242  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() {
        /*
            r26 = this;
            r0 = r26
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            androidx.media3.ui.CaptionStyleCompat r2 = r0.Z2
            int r2 = r2.f14619a
            java.lang.String r2 = androidx.media3.ui.HtmlUtils.b(r2)
            int r3 = r0.b3
            float r4 = r0.a3
            java.lang.String r3 = r0.e(r3, r4)
            r4 = 1067030938(0x3f99999a, float:1.2)
            java.lang.Float r5 = java.lang.Float.valueOf(r4)
            androidx.media3.ui.CaptionStyleCompat r6 = r0.Z2
            java.lang.String r6 = d(r6)
            r7 = 4
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r9 = 0
            r8[r9] = r2
            r2 = 1
            r8[r2] = r3
            r3 = 2
            r8[r3] = r5
            r5 = 3
            r8[r5] = r6
            java.lang.String r6 = "<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>"
            java.lang.String r6 = androidx.media3.common.util.Util.S(r6, r8)
            r1.append(r6)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r8 = "default_bg"
            java.lang.String r10 = androidx.media3.ui.HtmlUtils.a(r8)
            androidx.media3.ui.CaptionStyleCompat r11 = r0.Z2
            int r11 = r11.f14620b
            java.lang.String r11 = androidx.media3.ui.HtmlUtils.b(r11)
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r12[r9] = r11
            java.lang.String r11 = "background-color:%s;"
            java.lang.String r11 = androidx.media3.common.util.Util.S(r11, r12)
            r6.put(r10, r11)
            r10 = 0
        L_0x005d:
            java.util.List<androidx.media3.common.text.Cue> r11 = r0.Y2
            int r11 = r11.size()
            if (r10 >= r11) goto L_0x0260
            java.util.List<androidx.media3.common.text.Cue> r11 = r0.Y2
            java.lang.Object r11 = r11.get(r10)
            androidx.media3.common.text.Cue r11 = (androidx.media3.common.text.Cue) r11
            float r12 = r11.a3
            r13 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r14 = 1120403456(0x42c80000, float:100.0)
            int r15 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x007b
            float r12 = r12 * r14
            goto L_0x007d
        L_0x007b:
            r12 = 1112014848(0x42480000, float:50.0)
        L_0x007d:
            int r15 = r11.b3
            int r15 = b(r15)
            float r7 = r11.X2
            r17 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r5 = "%.2f%%"
            int r18 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r18 == 0) goto L_0x00de
            int r3 = r11.Y2
            if (r3 == r2) goto L_0x00b3
            float r7 = r7 * r14
            java.lang.Float r3 = java.lang.Float.valueOf(r7)
            java.lang.Object[] r7 = new java.lang.Object[r2]
            r7[r9] = r3
            java.lang.String r3 = androidx.media3.common.util.Util.S(r5, r7)
            int r7 = r11.i3
            if (r7 != r2) goto L_0x00ab
            int r7 = r11.Z2
            int r7 = b(r7)
            int r7 = -r7
            goto L_0x00b1
        L_0x00ab:
            int r7 = r11.Z2
            int r7 = b(r7)
        L_0x00b1:
            r13 = 0
            goto L_0x00f3
        L_0x00b3:
            r3 = 0
            java.lang.String r13 = "%.2fem"
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x00ca
            float r7 = r7 * r4
            java.lang.Float r3 = java.lang.Float.valueOf(r7)
            java.lang.Object[] r7 = new java.lang.Object[r2]
            r7[r9] = r3
            java.lang.String r3 = androidx.media3.common.util.Util.S(r13, r7)
            r7 = 0
            goto L_0x00b1
        L_0x00ca:
            float r3 = -r7
            float r3 = r3 - r17
            float r3 = r3 * r4
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            java.lang.Object[] r7 = new java.lang.Object[r2]
            r7[r9] = r3
            java.lang.String r3 = androidx.media3.common.util.Util.S(r13, r7)
            r7 = 0
            r13 = 1
            goto L_0x00f3
        L_0x00de:
            float r3 = r0.c3
            float r17 = r17 - r3
            float r17 = r17 * r14
            java.lang.Float r3 = java.lang.Float.valueOf(r17)
            java.lang.Object[] r7 = new java.lang.Object[r2]
            r7[r9] = r3
            java.lang.String r3 = androidx.media3.common.util.Util.S(r5, r7)
            r7 = -100
            goto L_0x00b1
        L_0x00f3:
            float r4 = r11.c3
            r19 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r19 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r19 == 0) goto L_0x010b
            float r4 = r4 * r14
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.Object[] r14 = new java.lang.Object[r2]
            r14[r9] = r4
            java.lang.String r4 = androidx.media3.common.util.Util.S(r5, r14)
            goto L_0x010d
        L_0x010b:
            java.lang.String r4 = "fit-content"
        L_0x010d:
            android.text.Layout$Alignment r5 = r11.X
            java.lang.String r5 = c(r5)
            int r14 = r11.i3
            java.lang.String r14 = f(r14)
            int r9 = r11.g3
            float r2 = r11.h3
            java.lang.String r2 = r0.e(r9, r2)
            boolean r9 = r11.e3
            if (r9 == 0) goto L_0x0128
            int r9 = r11.f3
            goto L_0x012c
        L_0x0128:
            androidx.media3.ui.CaptionStyleCompat r9 = r0.Z2
            int r9 = r9.f14621c
        L_0x012c:
            java.lang.String r9 = androidx.media3.ui.HtmlUtils.b(r9)
            r20 = r7
            int r7 = r11.i3
            java.lang.String r21 = "right"
            java.lang.String r22 = "top"
            java.lang.String r23 = "left"
            r24 = r15
            r15 = 1
            if (r7 == r15) goto L_0x0152
            r15 = 2
            if (r7 == r15) goto L_0x014c
            if (r13 == 0) goto L_0x0146
            java.lang.String r22 = "bottom"
        L_0x0146:
            r21 = r22
            r22 = r23
        L_0x014a:
            r13 = 2
            goto L_0x0155
        L_0x014c:
            if (r13 == 0) goto L_0x014f
            goto L_0x014a
        L_0x014f:
            r21 = r23
            goto L_0x014a
        L_0x0152:
            if (r13 == 0) goto L_0x014a
            goto L_0x014f
        L_0x0155:
            if (r7 == r13) goto L_0x0160
            r13 = 1
            if (r7 != r13) goto L_0x015b
            goto L_0x0160
        L_0x015b:
            java.lang.String r7 = "width"
            r15 = r24
            goto L_0x0166
        L_0x0160:
            java.lang.String r7 = "height"
            r15 = r20
            r20 = r24
        L_0x0166:
            java.lang.CharSequence r13 = r11.s
            android.content.Context r23 = r26.getContext()
            android.content.res.Resources r23 = r23.getResources()
            android.util.DisplayMetrics r0 = r23.getDisplayMetrics()
            float r0 = r0.density
            androidx.media3.ui.SpannedToHtmlConverter$HtmlAndCss r0 = androidx.media3.ui.SpannedToHtmlConverter.a(r13, r0)
            java.util.Set r13 = r6.keySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x0182:
            boolean r23 = r13.hasNext()
            if (r23 == 0) goto L_0x01ba
            java.lang.Object r23 = r13.next()
            r24 = r13
            r13 = r23
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r23 = r6.get(r13)
            r25 = r0
            r0 = r23
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r6.put(r13, r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x01b1
            java.lang.Object r13 = r6.get(r13)
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x01af
            goto L_0x01b1
        L_0x01af:
            r0 = 0
            goto L_0x01b2
        L_0x01b1:
            r0 = 1
        L_0x01b2:
            androidx.media3.common.util.Assertions.i(r0)
            r13 = r24
            r0 = r25
            goto L_0x0182
        L_0x01ba:
            r25 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r20)
            java.lang.String r20 = h(r11)
            r23 = r6
            r6 = 14
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r19 = 0
            r6[r19] = r0
            r0 = 1
            r6[r0] = r22
            r0 = 2
            r6[r0] = r12
            r12 = 3
            r6[r12] = r21
            r16 = 4
            r6[r16] = r3
            r3 = 5
            r6[r3] = r7
            r3 = 6
            r6[r3] = r4
            r3 = 7
            r6[r3] = r5
            r3 = 8
            r6[r3] = r14
            r3 = 9
            r6[r3] = r2
            r2 = 10
            r6[r2] = r9
            r2 = 11
            r6[r2] = r13
            r2 = 12
            r6[r2] = r15
            r2 = 13
            r6[r2] = r20
            java.lang.String r2 = "<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>"
            java.lang.String r2 = androidx.media3.common.util.Util.S(r2, r6)
            r1.append(r2)
            java.lang.String r2 = "<span class='%s'>"
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r5 = 0
            r4[r5] = r8
            java.lang.String r2 = androidx.media3.common.util.Util.S(r2, r4)
            r1.append(r2)
            android.text.Layout$Alignment r2 = r11.Y
            java.lang.String r4 = "</span>"
            if (r2 == 0) goto L_0x0242
            java.lang.String r2 = c(r2)
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r5] = r2
            java.lang.String r2 = "<span style='display:inline-block; text-align:%s;'>"
            java.lang.String r2 = androidx.media3.common.util.Util.S(r2, r6)
            r1.append(r2)
            r2 = r25
            java.lang.String r2 = r2.f14824a
            r1.append(r2)
            r1.append(r4)
            goto L_0x0249
        L_0x0242:
            r2 = r25
            java.lang.String r2 = r2.f14824a
            r1.append(r2)
        L_0x0249:
            r1.append(r4)
            java.lang.String r2 = "</div>"
            r1.append(r2)
            r2 = 1
            int r10 = r10 + r2
            r3 = 2
            r4 = 1067030938(0x3f99999a, float:1.2)
            r5 = 3
            r7 = 4
            r9 = 0
            r0 = r26
            r6 = r23
            goto L_0x005d
        L_0x0260:
            r23 = r6
            java.lang.String r0 = "</div></body></html>"
            r1.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "<html><head><style>"
            r0.append(r2)
            java.util.Set r2 = r23.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0279:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x029e
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            r0.append(r3)
            java.lang.String r4 = "{"
            r0.append(r4)
            r4 = r23
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0.append(r3)
            java.lang.String r3 = "}"
            r0.append(r3)
            goto L_0x0279
        L_0x029e:
            java.lang.String r2 = "</style></head>"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 0
            r1.insert(r2, r0)
            r0 = r26
            android.webkit.WebView r2 = r0.X2
            java.lang.String r1 = r1.toString()
            java.nio.charset.Charset r3 = com.google.common.base.Charsets.f22255c
            byte[] r1 = r1.getBytes(r3)
            r3 = 1
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r3)
            java.lang.String r3 = "text/html"
            java.lang.String r4 = "base64"
            r2.loadData(r1, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.WebViewSubtitleOutput.i():void");
    }

    public void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f2, int i2, float f3) {
        this.Z2 = captionStyleCompat;
        this.a3 = f2;
        this.b3 = i2;
        this.c3 = f3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            Cue cue = list.get(i3);
            if (cue.Z != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.Y2.isEmpty() || !arrayList2.isEmpty()) {
            this.Y2 = arrayList2;
            i();
        }
        this.s.a(arrayList, captionStyleCompat, f2, i2, f3);
        invalidate();
    }

    public void g() {
        this.X2.destroy();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z && !this.Y2.isEmpty()) {
            i();
        }
    }

    public WebViewSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Y2 = Collections.emptyList();
        this.Z2 = CaptionStyleCompat.f14618m;
        this.a3 = 0.0533f;
        this.b3 = 0;
        this.c3 = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        this.s = canvasSubtitleOutput;
        AnonymousClass1 r2 = new WebView(context, attributeSet) {
            public boolean onTouchEvent(MotionEvent motionEvent) {
                super.onTouchEvent(motionEvent);
                return false;
            }

            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        this.X2 = r2;
        r2.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(r2);
    }
}
