package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class SubtitlePainter {
    private static final String K = "SubtitlePainter";
    private static final float L = 0.125f;
    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;

    /* renamed from: a  reason: collision with root package name */
    private final float f14834a;

    /* renamed from: b  reason: collision with root package name */
    private final float f14835b;

    /* renamed from: c  reason: collision with root package name */
    private final float f14836c;

    /* renamed from: d  reason: collision with root package name */
    private final float f14837d;

    /* renamed from: e  reason: collision with root package name */
    private final float f14838e;

    /* renamed from: f  reason: collision with root package name */
    private final TextPaint f14839f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f14840g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f14841h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f14842i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Layout.Alignment f14843j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f14844k;

    /* renamed from: l  reason: collision with root package name */
    private float f14845l;

    /* renamed from: m  reason: collision with root package name */
    private int f14846m;

    /* renamed from: n  reason: collision with root package name */
    private int f14847n;
    private float o;
    private int p;
    private float q;
    private float r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private float x;
    private float y;
    private float z;

    public SubtitlePainter(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{16843287, 16843288}, 0, 0);
        this.f14838e = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f14837d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = (float) Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * 2.0f) / 160.0f);
        this.f14834a = round;
        this.f14835b = round;
        this.f14836c = round;
        TextPaint textPaint = new TextPaint();
        this.f14839f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f14840g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f14841h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    private static boolean a(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    @RequiresNonNull({"cueBitmap", "bitmapRect"})
    private void c(Canvas canvas) {
        canvas.drawBitmap(this.f14844k, (Rect) null, this.J, this.f14841h);
    }

    private void d(Canvas canvas, boolean z2) {
        if (z2) {
            e(canvas);
            return;
        }
        Assertions.g(this.J);
        Assertions.g(this.f14844k);
        c(canvas);
    }

    private void e(Canvas canvas) {
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout != null && staticLayout2 != null) {
            int save = canvas.save();
            canvas.translate((float) this.G, (float) this.H);
            if (Color.alpha(this.u) > 0) {
                this.f14840g.setColor(this.u);
                canvas.drawRect((float) (-this.I), 0.0f, (float) (staticLayout.getWidth() + this.I), (float) staticLayout.getHeight(), this.f14840g);
            }
            int i2 = this.w;
            boolean z2 = true;
            if (i2 == 1) {
                this.f14839f.setStrokeJoin(Paint.Join.ROUND);
                this.f14839f.setStrokeWidth(this.f14834a);
                this.f14839f.setColor(this.v);
                this.f14839f.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout2.draw(canvas);
            } else if (i2 == 2) {
                TextPaint textPaint = this.f14839f;
                float f2 = this.f14835b;
                float f3 = this.f14836c;
                textPaint.setShadowLayer(f2, f3, f3, this.v);
            } else if (i2 == 3 || i2 == 4) {
                if (i2 != 3) {
                    z2 = false;
                }
                int i3 = -1;
                int i4 = z2 ? -1 : this.v;
                if (z2) {
                    i3 = this.v;
                }
                float f4 = this.f14835b / 2.0f;
                this.f14839f.setColor(this.s);
                this.f14839f.setStyle(Paint.Style.FILL);
                float f5 = -f4;
                this.f14839f.setShadowLayer(this.f14835b, f5, f5, i4);
                staticLayout2.draw(canvas);
                this.f14839f.setShadowLayer(this.f14835b, f4, f4, i3);
            }
            this.f14839f.setColor(this.s);
            this.f14839f.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.f14839f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueBitmap"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.f14844k
            int r1 = r7.C
            int r2 = r7.A
            int r1 = r1 - r2
            int r3 = r7.D
            int r4 = r7.B
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f14845l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.r
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0032
        L_0x002b:
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            goto L_0x003f
        L_0x0032:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            goto L_0x002b
        L_0x003f:
            int r3 = r7.p
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L_0x0048
            float r3 = (float) r1
        L_0x0046:
            float r2 = r2 - r3
            goto L_0x004e
        L_0x0048:
            if (r3 != r5) goto L_0x004e
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L_0x0046
        L_0x004e:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.f14847n
            if (r3 != r6) goto L_0x0059
            float r3 = (float) r0
        L_0x0057:
            float r4 = r4 - r3
            goto L_0x005f
        L_0x0059:
            if (r3 != r5) goto L_0x005f
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L_0x0057
        L_0x005f:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.J = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.SubtitlePainter.f():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a8  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueText"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r26 = this;
            r0 = r26
            java.lang.CharSequence r1 = r0.f14842i
            boolean r2 = r1 instanceof android.text.SpannableStringBuilder
            if (r2 == 0) goto L_0x000b
            android.text.SpannableStringBuilder r1 = (android.text.SpannableStringBuilder) r1
            goto L_0x0012
        L_0x000b:
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
            java.lang.CharSequence r2 = r0.f14842i
            r1.<init>(r2)
        L_0x0012:
            int r2 = r0.C
            int r3 = r0.A
            int r2 = r2 - r3
            int r3 = r0.D
            int r4 = r0.B
            int r11 = r3 - r4
            android.text.TextPaint r3 = r0.f14839f
            float r4 = r0.x
            r3.setTextSize(r4)
            float r3 = r0.x
            r4 = 1040187392(0x3e000000, float:0.125)
            float r3 = r3 * r4
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r4
            int r12 = (int) r3
            int r13 = r12 * 2
            int r3 = r2 - r13
            float r4 = r0.q
            r14 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r5 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x003f
            float r3 = (float) r3
            float r3 = r3 * r4
            int r3 = (int) r3
        L_0x003f:
            r15 = r3
            java.lang.String r10 = "SubtitlePainter"
            if (r15 > 0) goto L_0x004a
            java.lang.String r1 = "Skipped drawing subtitle cue (insufficient space)"
            androidx.media3.common.util.Log.n(r10, r1)
            return
        L_0x004a:
            float r3 = r0.y
            r16 = 0
            r4 = 16711680(0xff0000, float:2.3418052E-38)
            r9 = 0
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 <= 0) goto L_0x0064
            android.text.style.AbsoluteSizeSpan r3 = new android.text.style.AbsoluteSizeSpan
            float r5 = r0.y
            int r5 = (int) r5
            r3.<init>(r5)
            int r5 = r1.length()
            r1.setSpan(r3, r9, r5, r4)
        L_0x0064:
            android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
            r8.<init>(r1)
            int r3 = r0.w
            r7 = 1
            if (r3 != r7) goto L_0x0087
            int r3 = r8.length()
            java.lang.Class<android.text.style.ForegroundColorSpan> r5 = android.text.style.ForegroundColorSpan.class
            java.lang.Object[] r3 = r8.getSpans(r9, r3, r5)
            android.text.style.ForegroundColorSpan[] r3 = (android.text.style.ForegroundColorSpan[]) r3
            int r5 = r3.length
            r6 = 0
        L_0x007c:
            if (r6 >= r5) goto L_0x0087
            r7 = r3[r6]
            r8.removeSpan(r7)
            int r6 = r6 + 1
            r7 = 1
            goto L_0x007c
        L_0x0087:
            int r3 = r0.t
            int r3 = android.graphics.Color.alpha(r3)
            r7 = 2
            if (r3 <= 0) goto L_0x00b4
            int r3 = r0.w
            if (r3 == 0) goto L_0x00a6
            if (r3 != r7) goto L_0x0097
            goto L_0x00a6
        L_0x0097:
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            int r5 = r0.t
            r3.<init>(r5)
            int r5 = r8.length()
            r8.setSpan(r3, r9, r5, r4)
            goto L_0x00b4
        L_0x00a6:
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            int r5 = r0.t
            r3.<init>(r5)
            int r5 = r1.length()
            r1.setSpan(r3, r9, r5, r4)
        L_0x00b4:
            android.text.Layout$Alignment r3 = r0.f14843j
            if (r3 != 0) goto L_0x00ba
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_CENTER
        L_0x00ba:
            r21 = r3
            android.text.StaticLayout r6 = new android.text.StaticLayout
            android.text.TextPaint r5 = r0.f14839f
            float r4 = r0.f14837d
            float r3 = r0.f14838e
            r18 = 1
            r19 = r3
            r3 = r6
            r20 = r4
            r4 = r1
            r14 = r6
            r6 = r15
            r7 = r21
            r23 = r8
            r8 = r20
            r25 = r12
            r12 = 0
            r9 = r19
            r12 = r10
            r10 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r0.E = r14
            int r3 = r14.getHeight()
            android.text.StaticLayout r4 = r0.E
            int r4 = r4.getLineCount()
            r5 = 0
            r9 = 0
        L_0x00ed:
            if (r9 >= r4) goto L_0x0102
            android.text.StaticLayout r6 = r0.E
            float r6 = r6.getLineWidth(r9)
            double r6 = (double) r6
            double r6 = java.lang.Math.ceil(r6)
            int r6 = (int) r6
            int r5 = java.lang.Math.max(r6, r5)
            int r9 = r9 + 1
            goto L_0x00ed
        L_0x0102:
            float r4 = r0.q
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x010e
            if (r5 >= r15) goto L_0x010e
            goto L_0x010f
        L_0x010e:
            r15 = r5
        L_0x010f:
            int r15 = r15 + r13
            float r4 = r0.o
            int r5 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x013b
            float r2 = (float) r2
            float r2 = r2 * r4
            int r2 = java.lang.Math.round(r2)
            int r4 = r0.A
            int r2 = r2 + r4
            int r5 = r0.p
            r6 = 1
            r7 = 2
            if (r5 == r6) goto L_0x012b
            if (r5 == r7) goto L_0x0129
            goto L_0x012f
        L_0x0129:
            int r2 = r2 - r15
            goto L_0x012f
        L_0x012b:
            int r2 = r2 * 2
            int r2 = r2 - r15
            int r2 = r2 / r7
        L_0x012f:
            int r2 = java.lang.Math.max(r2, r4)
            int r15 = r15 + r2
            int r4 = r0.C
            int r4 = java.lang.Math.min(r15, r4)
            goto L_0x0144
        L_0x013b:
            r6 = 1
            r7 = 2
            int r2 = r2 - r15
            int r2 = r2 / r7
            int r4 = r0.A
            int r2 = r2 + r4
            int r4 = r2 + r15
        L_0x0144:
            int r20 = r4 - r2
            if (r20 > 0) goto L_0x014e
            java.lang.String r1 = "Skipped drawing subtitle cue (invalid horizontal positioning)"
            androidx.media3.common.util.Log.n(r12, r1)
            return
        L_0x014e:
            float r4 = r0.f14845l
            r5 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x01ae
            int r5 = r0.f14846m
            if (r5 != 0) goto L_0x0171
            float r5 = (float) r11
            float r5 = r5 * r4
            int r4 = java.lang.Math.round(r5)
            int r5 = r0.B
            int r4 = r4 + r5
            int r5 = r0.f14847n
            if (r5 != r7) goto L_0x016a
            goto L_0x019d
        L_0x016a:
            if (r5 != r6) goto L_0x019e
            int r4 = r4 * 2
            int r4 = r4 - r3
            int r4 = r4 / r7
            goto L_0x019e
        L_0x0171:
            android.text.StaticLayout r4 = r0.E
            r5 = 0
            int r4 = r4.getLineBottom(r5)
            android.text.StaticLayout r6 = r0.E
            int r5 = r6.getLineTop(r5)
            int r4 = r4 - r5
            float r5 = r0.f14845l
            int r6 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r6 < 0) goto L_0x0190
            float r4 = (float) r4
            float r5 = r5 * r4
            int r4 = java.lang.Math.round(r5)
            int r5 = r0.B
            int r4 = r4 + r5
            goto L_0x019e
        L_0x0190:
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r5 + r6
            float r4 = (float) r4
            float r5 = r5 * r4
            int r4 = java.lang.Math.round(r5)
            int r5 = r0.D
            int r4 = r4 + r5
        L_0x019d:
            int r4 = r4 - r3
        L_0x019e:
            int r5 = r4 + r3
            int r6 = r0.D
            if (r5 <= r6) goto L_0x01a8
            int r4 = r6 - r3
        L_0x01a6:
            r11 = r4
            goto L_0x01b9
        L_0x01a8:
            int r3 = r0.B
            if (r4 >= r3) goto L_0x01a6
            r11 = r3
            goto L_0x01b9
        L_0x01ae:
            int r4 = r0.D
            int r4 = r4 - r3
            float r3 = (float) r11
            float r5 = r0.z
            float r3 = r3 * r5
            int r3 = (int) r3
            int r4 = r4 - r3
            goto L_0x01a6
        L_0x01b9:
            android.text.StaticLayout r12 = new android.text.StaticLayout
            android.text.TextPaint r5 = r0.f14839f
            float r8 = r0.f14837d
            float r9 = r0.f14838e
            r10 = 1
            r3 = r12
            r4 = r1
            r6 = r20
            r7 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r0.E = r12
            android.text.StaticLayout r1 = new android.text.StaticLayout
            android.text.TextPaint r3 = r0.f14839f
            float r4 = r0.f14837d
            float r5 = r0.f14838e
            r24 = 1
            r17 = r1
            r18 = r23
            r19 = r3
            r22 = r4
            r23 = r5
            r17.<init>(r18, r19, r20, r21, r22, r23, r24)
            r0.F = r1
            r0.G = r2
            r0.H = r11
            r1 = r25
            r0.I = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.SubtitlePainter.g():void");
    }

    public void b(Cue cue, CaptionStyleCompat captionStyleCompat, float f2, float f3, float f4, Canvas canvas, int i2, int i3, int i4, int i5) {
        int i6;
        boolean z2 = cue.Z == null;
        if (!z2) {
            i6 = ViewCompat.y;
        } else if (!TextUtils.isEmpty(cue.s)) {
            i6 = cue.e3 ? cue.f3 : captionStyleCompat.f14621c;
        } else {
            return;
        }
        if (a(this.f14842i, cue.s) && Util.g(this.f14843j, cue.X) && this.f14844k == cue.Z && this.f14845l == cue.X2 && this.f14846m == cue.Y2 && Util.g(Integer.valueOf(this.f14847n), Integer.valueOf(cue.Z2)) && this.o == cue.a3 && Util.g(Integer.valueOf(this.p), Integer.valueOf(cue.b3)) && this.q == cue.c3 && this.r == cue.d3 && this.s == captionStyleCompat.f14619a && this.t == captionStyleCompat.f14620b && this.u == i6 && this.w == captionStyleCompat.f14622d && this.v == captionStyleCompat.f14623e && Util.g(this.f14839f.getTypeface(), captionStyleCompat.f14624f) && this.x == f2 && this.y == f3 && this.z == f4 && this.A == i2 && this.B == i3 && this.C == i4 && this.D == i5) {
            d(canvas, z2);
            return;
        }
        this.f14842i = cue.s;
        this.f14843j = cue.X;
        this.f14844k = cue.Z;
        this.f14845l = cue.X2;
        this.f14846m = cue.Y2;
        this.f14847n = cue.Z2;
        this.o = cue.a3;
        this.p = cue.b3;
        this.q = cue.c3;
        this.r = cue.d3;
        this.s = captionStyleCompat.f14619a;
        this.t = captionStyleCompat.f14620b;
        this.u = i6;
        this.w = captionStyleCompat.f14622d;
        this.v = captionStyleCompat.f14623e;
        this.f14839f.setTypeface(captionStyleCompat.f14624f);
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.A = i2;
        this.B = i3;
        this.C = i4;
        this.D = i5;
        if (z2) {
            Assertions.g(this.f14842i);
            g();
        } else {
            Assertions.g(this.f14844k);
            f();
        }
        d(canvas, z2);
    }
}
