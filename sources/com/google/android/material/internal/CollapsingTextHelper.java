package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TypefaceUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper {
    private static final boolean u0 = false;
    private static final String v0 = "CollapsingTextHelper";
    private static final String w0 = "…";
    private static final float x0 = 0.5f;
    private static final boolean y0 = false;
    @NonNull
    private static final Paint z0 = null;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private CancelableFontCallback D;
    private CancelableFontCallback E;
    private TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    @Nullable
    private CharSequence G;
    @Nullable
    private CharSequence H;
    private boolean I;
    private boolean J = true;
    private boolean K;
    @Nullable
    private Bitmap L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int[] T;
    private boolean U;
    @NonNull
    private final TextPaint V;
    @NonNull
    private final TextPaint W;
    private TimeInterpolator X;
    private TimeInterpolator Y;
    private float Z;

    /* renamed from: a  reason: collision with root package name */
    private final View f21489a;
    private float a0;

    /* renamed from: b  reason: collision with root package name */
    private float f21490b;
    private float b0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21491c;
    private ColorStateList c0;

    /* renamed from: d  reason: collision with root package name */
    private float f21492d;
    private float d0;

    /* renamed from: e  reason: collision with root package name */
    private float f21493e;
    private float e0;

    /* renamed from: f  reason: collision with root package name */
    private int f21494f;
    private float f0;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final Rect f21495g;
    private ColorStateList g0;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final Rect f21496h;
    private float h0;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final RectF f21497i;
    private float i0;

    /* renamed from: j  reason: collision with root package name */
    private int f21498j = 16;
    private float j0;

    /* renamed from: k  reason: collision with root package name */
    private int f21499k = 16;
    private StaticLayout k0;

    /* renamed from: l  reason: collision with root package name */
    private float f21500l = 15.0f;
    private float l0;

    /* renamed from: m  reason: collision with root package name */
    private float f21501m = 15.0f;
    private float m0;

    /* renamed from: n  reason: collision with root package name */
    private ColorStateList f21502n;
    private float n0;
    private ColorStateList o;
    private CharSequence o0;
    private int p;
    private int p0 = 1;
    private float q;
    private float q0 = 0.0f;
    private float r;
    private float r0 = 1.0f;
    private float s;
    private int s0 = StaticLayoutBuilderCompat.o;
    private float t;
    @Nullable
    private StaticLayoutBuilderConfigurer t0;
    private float u;
    private float v;
    private Typeface w;
    private Typeface x;
    private Typeface y;
    private Typeface z;

    public CollapsingTextHelper(View view) {
        this.f21489a = view;
        TextPaint textPaint = new TextPaint(TsExtractor.J);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.f21496h = new Rect();
        this.f21495g = new Rect();
        this.f21497i = new RectF();
        this.f21493e = e();
        a0(view.getContext().getResources().getConfiguration());
    }

    private void E0(float f2) {
        h(f2);
        boolean z2 = u0 && this.N != 1.0f;
        this.K = z2;
        if (z2) {
            n();
        }
        ViewCompat.t1(this.f21489a);
    }

    private Layout.Alignment N() {
        int d2 = GravityCompat.d(this.f21498j, this.I ? 1 : 0) & 7;
        if (d2 != 1) {
            return d2 != 5 ? this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private void Q(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f21501m);
        textPaint.setTypeface(this.w);
        textPaint.setLetterSpacing(this.h0);
    }

    private boolean Q0() {
        return this.p0 > 1 && (!this.I || this.f21491c) && !this.K;
    }

    private void R(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f21500l);
        textPaint.setTypeface(this.z);
        textPaint.setLetterSpacing(this.i0);
    }

    private void T(float f2) {
        if (this.f21491c) {
            this.f21497i.set(f2 < this.f21493e ? this.f21495g : this.f21496h);
            return;
        }
        this.f21497i.left = Z((float) this.f21495g.left, (float) this.f21496h.left, f2, this.X);
        this.f21497i.top = Z(this.q, this.r, f2, this.X);
        this.f21497i.right = Z((float) this.f21495g.right, (float) this.f21496h.right, f2, this.X);
        this.f21497i.bottom = Z((float) this.f21495g.bottom, (float) this.f21496h.bottom, f2, this.X);
    }

    private static boolean U(float f2, float f3) {
        return Math.abs(f2 - f3) < 1.0E-5f;
    }

    private boolean V() {
        return ViewCompat.c0(this.f21489a) == 1;
    }

    private boolean Y(@NonNull CharSequence charSequence, boolean z2) {
        return (z2 ? TextDirectionHeuristicsCompat.f6206d : TextDirectionHeuristicsCompat.f6205c).b(charSequence, 0, charSequence.length());
    }

    private static float Z(float f2, float f3, float f4, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return AnimationUtils.a(f2, f3, f4);
    }

    @ColorInt
    private static int a(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        float f3 = 1.0f - f2;
        return Color.argb(Math.round((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), Math.round((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), Math.round((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), Math.round((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(boolean r10) {
        /*
            r9 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r9.i(r0, r10)
            java.lang.CharSequence r0 = r9.H
            if (r0 == 0) goto L_0x001c
            android.text.StaticLayout r1 = r9.k0
            if (r1 == 0) goto L_0x001c
            android.text.TextPaint r2 = r9.V
            int r1 = r1.getWidth()
            float r1 = (float) r1
            android.text.TextUtils$TruncateAt r3 = r9.F
            java.lang.CharSequence r0 = android.text.TextUtils.ellipsize(r0, r2, r1, r3)
            r9.o0 = r0
        L_0x001c:
            java.lang.CharSequence r0 = r9.o0
            r1 = 0
            if (r0 == 0) goto L_0x002a
            android.text.TextPaint r2 = r9.V
            float r0 = r9.b0(r2, r0)
            r9.l0 = r0
            goto L_0x002c
        L_0x002a:
            r9.l0 = r1
        L_0x002c:
            int r0 = r9.f21499k
            boolean r2 = r9.I
            int r0 = androidx.core.view.GravityCompat.d(r0, r2)
            r2 = r0 & 112(0x70, float:1.57E-43)
            r3 = 80
            r4 = 48
            r5 = 1073741824(0x40000000, float:2.0)
            if (r2 == r4) goto L_0x0068
            if (r2 == r3) goto L_0x0059
            android.text.TextPaint r2 = r9.V
            float r2 = r2.descent()
            android.text.TextPaint r6 = r9.V
            float r6 = r6.ascent()
            float r2 = r2 - r6
            float r2 = r2 / r5
            android.graphics.Rect r6 = r9.f21496h
            int r6 = r6.centerY()
            float r6 = (float) r6
            float r6 = r6 - r2
            r9.r = r6
            goto L_0x006e
        L_0x0059:
            android.graphics.Rect r2 = r9.f21496h
            int r2 = r2.bottom
            float r2 = (float) r2
            android.text.TextPaint r6 = r9.V
            float r6 = r6.ascent()
            float r2 = r2 + r6
        L_0x0065:
            r9.r = r2
            goto L_0x006e
        L_0x0068:
            android.graphics.Rect r2 = r9.f21496h
            int r2 = r2.top
            float r2 = (float) r2
            goto L_0x0065
        L_0x006e:
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r0 = r0 & r2
            r6 = 5
            r7 = 1
            if (r0 == r7) goto L_0x0089
            if (r0 == r6) goto L_0x0080
            android.graphics.Rect r0 = r9.f21496h
            int r0 = r0.left
            float r0 = (float) r0
        L_0x007d:
            r9.t = r0
            goto L_0x0094
        L_0x0080:
            android.graphics.Rect r0 = r9.f21496h
            int r0 = r0.right
            float r0 = (float) r0
            float r8 = r9.l0
        L_0x0087:
            float r0 = r0 - r8
            goto L_0x007d
        L_0x0089:
            android.graphics.Rect r0 = r9.f21496h
            int r0 = r0.centerX()
            float r0 = (float) r0
            float r8 = r9.l0
            float r8 = r8 / r5
            goto L_0x0087
        L_0x0094:
            r9.i(r1, r10)
            android.text.StaticLayout r10 = r9.k0
            if (r10 == 0) goto L_0x00a1
            int r10 = r10.getHeight()
            float r10 = (float) r10
            goto L_0x00a2
        L_0x00a1:
            r10 = 0
        L_0x00a2:
            android.text.StaticLayout r0 = r9.k0
            if (r0 == 0) goto L_0x00b0
            int r8 = r9.p0
            if (r8 <= r7) goto L_0x00b0
            int r0 = r0.getWidth()
            float r1 = (float) r0
            goto L_0x00ba
        L_0x00b0:
            java.lang.CharSequence r0 = r9.H
            if (r0 == 0) goto L_0x00ba
            android.text.TextPaint r1 = r9.V
            float r1 = r9.b0(r1, r0)
        L_0x00ba:
            android.text.StaticLayout r0 = r9.k0
            if (r0 == 0) goto L_0x00c3
            int r0 = r0.getLineCount()
            goto L_0x00c4
        L_0x00c3:
            r0 = 0
        L_0x00c4:
            r9.p = r0
            int r0 = r9.f21498j
            boolean r8 = r9.I
            int r0 = androidx.core.view.GravityCompat.d(r0, r8)
            r8 = r0 & 112(0x70, float:1.57E-43)
            if (r8 == r4) goto L_0x00ee
            if (r8 == r3) goto L_0x00e0
            float r10 = r10 / r5
            android.graphics.Rect r3 = r9.f21495g
            int r3 = r3.centerY()
            float r3 = (float) r3
            float r3 = r3 - r10
        L_0x00dd:
            r9.q = r3
            goto L_0x00f5
        L_0x00e0:
            android.graphics.Rect r3 = r9.f21495g
            int r3 = r3.bottom
            float r3 = (float) r3
            float r3 = r3 - r10
            android.text.TextPaint r10 = r9.V
            float r10 = r10.descent()
            float r3 = r3 + r10
            goto L_0x00dd
        L_0x00ee:
            android.graphics.Rect r10 = r9.f21495g
            int r10 = r10.top
            float r10 = (float) r10
            r9.q = r10
        L_0x00f5:
            r10 = r0 & r2
            if (r10 == r7) goto L_0x010a
            if (r10 == r6) goto L_0x0103
            android.graphics.Rect r10 = r9.f21495g
            int r10 = r10.left
            float r10 = (float) r10
        L_0x0100:
            r9.s = r10
            goto L_0x0113
        L_0x0103:
            android.graphics.Rect r10 = r9.f21495g
            int r10 = r10.right
            float r10 = (float) r10
        L_0x0108:
            float r10 = r10 - r1
            goto L_0x0100
        L_0x010a:
            android.graphics.Rect r10 = r9.f21495g
            int r10 = r10.centerX()
            float r10 = (float) r10
            float r1 = r1 / r5
            goto L_0x0108
        L_0x0113:
            r9.j()
            float r10 = r9.f21490b
            r9.E0(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.CollapsingTextHelper.b(boolean):void");
    }

    private float b0(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private void c() {
        g(this.f21490b);
    }

    private float d(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        float f3 = this.f21493e;
        return f2 <= f3 ? AnimationUtils.b(1.0f, 0.0f, this.f21492d, f3, f2) : AnimationUtils.b(0.0f, 1.0f, f3, 1.0f, f2);
    }

    private float e() {
        float f2 = this.f21492d;
        return f2 + ((1.0f - f2) * 0.5f);
    }

    private static boolean e0(@NonNull Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    private boolean f(@NonNull CharSequence charSequence) {
        boolean V2 = V();
        return this.J ? Y(charSequence, V2) : V2;
    }

    private void g(float f2) {
        float f3;
        T(f2);
        if (!this.f21491c) {
            this.u = Z(this.s, this.t, f2, this.X);
            this.v = Z(this.q, this.r, f2, this.X);
            E0(f2);
            f3 = f2;
        } else if (f2 < this.f21493e) {
            this.u = this.s;
            this.v = this.q;
            E0(0.0f);
            f3 = 0.0f;
        } else {
            this.u = this.t;
            this.v = this.r - ((float) Math.max(0, this.f21494f));
            E0(1.0f);
            f3 = 1.0f;
        }
        TimeInterpolator timeInterpolator = AnimationUtils.f20767b;
        j0(1.0f - Z(0.0f, 1.0f, 1.0f - f2, timeInterpolator));
        u0(Z(1.0f, 0.0f, f2, timeInterpolator));
        if (this.o != this.f21502n) {
            this.V.setColor(a(y(), w(), f3));
        } else {
            this.V.setColor(w());
        }
        int i2 = Build.VERSION.SDK_INT;
        float f4 = this.h0;
        float f5 = this.i0;
        if (f4 != f5) {
            this.V.setLetterSpacing(Z(f5, f4, f2, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f4);
        }
        this.P = Z(this.d0, this.Z, f2, (TimeInterpolator) null);
        this.Q = Z(this.e0, this.a0, f2, (TimeInterpolator) null);
        this.R = Z(this.f0, this.b0, f2, (TimeInterpolator) null);
        int a2 = a(x(this.g0), x(this.c0), f2);
        this.S = a2;
        this.V.setShadowLayer(this.P, this.Q, this.R, a2);
        if (this.f21491c) {
            int alpha = this.V.getAlpha();
            this.V.setAlpha((int) (d(f2) * ((float) alpha)));
            if (i2 >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, MaterialColors.a(this.S, textPaint.getAlpha()));
            }
        }
        ViewCompat.t1(this.f21489a);
    }

    private void h(float f2) {
        i(f2, false);
    }

    private void i(float f2, boolean z2) {
        float f3;
        float f4;
        Typeface typeface;
        if (this.G != null) {
            float width = (float) this.f21496h.width();
            float width2 = (float) this.f21495g.width();
            if (U(f2, 1.0f)) {
                f4 = this.f21501m;
                f3 = this.h0;
                this.N = 1.0f;
                typeface = this.w;
            } else {
                float f5 = this.f21500l;
                float f6 = this.i0;
                Typeface typeface2 = this.z;
                if (U(f2, 0.0f)) {
                    this.N = 1.0f;
                } else {
                    this.N = Z(this.f21500l, this.f21501m, f2, this.Y) / this.f21500l;
                }
                float f7 = this.f21501m / this.f21500l;
                width = (z2 || this.f21491c || width2 * f7 <= width) ? width2 : Math.min(width / f7, width2);
                f4 = f5;
                f3 = f6;
                typeface = typeface2;
            }
            int i2 = 1;
            boolean z3 = false;
            if (width > 0.0f) {
                boolean z4 = this.O != f4;
                boolean z5 = this.j0 != f3;
                boolean z6 = this.C != typeface;
                StaticLayout staticLayout = this.k0;
                boolean z7 = z4 || z5 || (staticLayout != null && (width > ((float) staticLayout.getWidth()) ? 1 : (width == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z6 || this.U;
                this.O = f4;
                this.j0 = f3;
                this.C = typeface;
                this.U = false;
                TextPaint textPaint = this.V;
                if (this.N != 1.0f) {
                    z3 = true;
                }
                textPaint.setLinearText(z3);
                z3 = z7;
            }
            if (this.H == null || z3) {
                this.V.setTextSize(this.O);
                this.V.setTypeface(this.C);
                this.V.setLetterSpacing(this.j0);
                this.I = f(this.G);
                if (Q0()) {
                    i2 = this.p0;
                }
                StaticLayout k2 = k(i2, width, this.I);
                this.k0 = k2;
                this.H = k2.getText();
            }
        }
    }

    private void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    private void j0(float f2) {
        this.m0 = f2;
        ViewCompat.t1(this.f21489a);
    }

    private StaticLayout k(int i2, float f2, boolean z2) {
        StaticLayout staticLayout;
        Layout.Alignment alignment;
        if (i2 == 1) {
            try {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e2) {
                Log.e(v0, e2.getCause().getMessage(), e2);
                staticLayout = null;
            }
        } else {
            alignment = N();
        }
        staticLayout = StaticLayoutBuilderCompat.c(this.G, this.V, (int) f2).e(this.F).i(z2).d(alignment).h(false).k(i2).j(this.q0, this.r0).g(this.s0).m(this.t0).a();
        return (StaticLayout) Preconditions.l(staticLayout);
    }

    private void m(@NonNull Canvas canvas, float f2, float f3) {
        int alpha = this.V.getAlpha();
        canvas.translate(f2, f3);
        if (!this.f21491c) {
            this.V.setAlpha((int) (this.n0 * ((float) alpha)));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, MaterialColors.a(this.S, textPaint.getAlpha()));
            }
            Canvas canvas2 = canvas;
            this.k0.draw(canvas);
        } else {
            Canvas canvas3 = canvas;
        }
        if (!this.f21491c) {
            this.V.setAlpha((int) (this.m0 * ((float) alpha)));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, MaterialColors.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.k0.getLineBaseline(0);
        CharSequence charSequence = this.o0;
        float f4 = (float) lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f4, this.V);
        if (i2 >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (!this.f21491c) {
            String trim = this.o0.toString().trim();
            if (trim.endsWith(w0)) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.V.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.k0.getLineEnd(0), str.length()), 0.0f, f4, this.V);
        }
    }

    private void n() {
        if (this.L == null && !this.f21495g.isEmpty() && !TextUtils.isEmpty(this.H)) {
            g(0.0f);
            int width = this.k0.getWidth();
            int height = this.k0.getHeight();
            if (width > 0 && height > 0) {
                this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.k0.draw(new Canvas(this.L));
                if (this.M == null) {
                    this.M = new Paint(3);
                }
            }
        }
    }

    private boolean o0(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.E;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        if (this.y == typeface) {
            return false;
        }
        this.y = typeface;
        Typeface b2 = TypefaceUtils.b(this.f21489a.getContext().getResources().getConfiguration(), typeface);
        this.x = b2;
        if (b2 == null) {
            b2 = this.y;
        }
        this.w = b2;
        return true;
    }

    private float s(int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (((float) i2) / 2.0f) - (this.l0 / 2.0f);
        }
        return ((i3 & GravityCompat.f6388c) == 8388613 || (i3 & 5) == 5) ? this.I ? (float) this.f21496h.left : ((float) this.f21496h.right) - this.l0 : this.I ? ((float) this.f21496h.right) - this.l0 : (float) this.f21496h.left;
    }

    private float t(@NonNull RectF rectF, int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (((float) i2) / 2.0f) + (this.l0 / 2.0f);
        }
        return ((i3 & GravityCompat.f6388c) == 8388613 || (i3 & 5) == 5) ? this.I ? rectF.left + this.l0 : (float) this.f21496h.right : this.I ? (float) this.f21496h.right : rectF.left + this.l0;
    }

    private void u0(float f2) {
        this.n0 = f2;
        ViewCompat.t1(this.f21489a);
    }

    @ColorInt
    private int x(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    @ColorInt
    private int y() {
        return x(this.f21502n);
    }

    private boolean z0(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.D;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface b2 = TypefaceUtils.b(this.f21489a.getContext().getResources().getConfiguration(), typeface);
        this.A = b2;
        if (b2 == null) {
            b2 = this.B;
        }
        this.z = b2;
        return true;
    }

    public ColorStateList A() {
        return this.f21502n;
    }

    public void A0(float f2) {
        float d2 = MathUtils.d(f2, 0.0f, 1.0f);
        if (d2 != this.f21490b) {
            this.f21490b = d2;
            c();
        }
    }

    public float B() {
        R(this.W);
        return (-this.W.ascent()) + this.W.descent();
    }

    public void B0(boolean z2) {
        this.f21491c = z2;
    }

    public int C() {
        return this.f21498j;
    }

    public void C0(float f2) {
        this.f21492d = f2;
        this.f21493e = e();
    }

    public float D() {
        R(this.W);
        return -this.W.ascent();
    }

    @RequiresApi(23)
    public void D0(int i2) {
        this.s0 = i2;
    }

    public float E() {
        return this.f21500l;
    }

    public Typeface F() {
        Typeface typeface = this.z;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @RequiresApi(23)
    public void F0(float f2) {
        this.q0 = f2;
    }

    public float G() {
        return this.f21490b;
    }

    @RequiresApi(23)
    public void G0(@FloatRange(from = 0.0d) float f2) {
        this.r0 = f2;
    }

    public float H() {
        return this.f21493e;
    }

    public void H0(int i2) {
        if (i2 != this.p0) {
            this.p0 = i2;
            j();
            c0();
        }
    }

    @RequiresApi(23)
    public int I() {
        return this.s0;
    }

    public void I0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        c0();
    }

    public int J() {
        StaticLayout staticLayout = this.k0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public void J0(boolean z2) {
        this.J = z2;
    }

    @RequiresApi(23)
    public float K() {
        return this.k0.getSpacingAdd();
    }

    public final boolean K0(int[] iArr) {
        this.T = iArr;
        if (!X()) {
            return false;
        }
        c0();
        return true;
    }

    @RequiresApi(23)
    public float L() {
        return this.k0.getSpacingMultiplier();
    }

    @RequiresApi(23)
    public void L0(@Nullable StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        if (this.t0 != staticLayoutBuilderConfigurer) {
            this.t0 = staticLayoutBuilderConfigurer;
            d0(true);
        }
    }

    public int M() {
        return this.p0;
    }

    public void M0(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            c0();
        }
    }

    public void N0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        c0();
    }

    @Nullable
    public TimeInterpolator O() {
        return this.X;
    }

    public void O0(@NonNull TextUtils.TruncateAt truncateAt) {
        this.F = truncateAt;
        c0();
    }

    @Nullable
    public CharSequence P() {
        return this.G;
    }

    public void P0(Typeface typeface) {
        boolean o02 = o0(typeface);
        boolean z02 = z0(typeface);
        if (o02 || z02) {
            c0();
        }
    }

    @NonNull
    public TextUtils.TruncateAt S() {
        return this.F;
    }

    public boolean W() {
        return this.J;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f21502n;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean X() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.o
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f21502n
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.CollapsingTextHelper.X():boolean");
    }

    public void a0(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.y;
            if (typeface != null) {
                this.x = TypefaceUtils.b(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = TypefaceUtils.b(configuration, typeface2);
            }
            Typeface typeface3 = this.x;
            if (typeface3 == null) {
                typeface3 = this.y;
            }
            this.w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.z = typeface4;
            d0(true);
        }
    }

    public void c0() {
        d0(false);
    }

    public void d0(boolean z2) {
        if ((this.f21489a.getHeight() > 0 && this.f21489a.getWidth() > 0) || z2) {
            b(z2);
            c();
        }
    }

    public void f0(@Nullable ColorStateList colorStateList) {
        if (this.o != colorStateList || this.f21502n != colorStateList) {
            this.o = colorStateList;
            this.f21502n = colorStateList;
            c0();
        }
    }

    public void g0(int i2, int i3, int i4, int i5) {
        if (!e0(this.f21496h, i2, i3, i4, i5)) {
            this.f21496h.set(i2, i3, i4, i5);
            this.U = true;
        }
    }

    public void h0(@NonNull Rect rect) {
        g0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void i0(int i2) {
        TextAppearance textAppearance = new TextAppearance(this.f21489a.getContext(), i2);
        if (textAppearance.i() != null) {
            this.o = textAppearance.i();
        }
        if (textAppearance.j() != 0.0f) {
            this.f21501m = textAppearance.j();
        }
        ColorStateList colorStateList = textAppearance.f21708c;
        if (colorStateList != null) {
            this.c0 = colorStateList;
        }
        this.a0 = textAppearance.f21713h;
        this.b0 = textAppearance.f21714i;
        this.Z = textAppearance.f21715j;
        this.h0 = textAppearance.f21717l;
        CancelableFontCallback cancelableFontCallback = this.E;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        this.E = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() {
            public void a(Typeface typeface) {
                CollapsingTextHelper.this.n0(typeface);
            }
        }, textAppearance.e());
        textAppearance.h(this.f21489a.getContext(), this.E);
        c0();
    }

    public void k0(ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            c0();
        }
    }

    public void l(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (this.H != null && this.f21497i.width() > 0.0f && this.f21497i.height() > 0.0f) {
            this.V.setTextSize(this.O);
            float f2 = this.u;
            float f3 = this.v;
            boolean z2 = this.K && this.L != null;
            float f4 = this.N;
            if (f4 != 1.0f && !this.f21491c) {
                canvas.scale(f4, f4, f2, f3);
            }
            if (z2) {
                canvas.drawBitmap(this.L, f2, f3, this.M);
                canvas.restoreToCount(save);
                return;
            }
            if (!Q0() || (this.f21491c && this.f21490b <= this.f21493e)) {
                canvas.translate(f2, f3);
                this.k0.draw(canvas);
            } else {
                m(canvas, this.u - ((float) this.k0.getLineStart(0)), f3);
            }
            canvas.restoreToCount(save);
        }
    }

    public void l0(int i2) {
        if (this.f21499k != i2) {
            this.f21499k = i2;
            c0();
        }
    }

    public void m0(float f2) {
        if (this.f21501m != f2) {
            this.f21501m = f2;
            c0();
        }
    }

    public void n0(Typeface typeface) {
        if (o0(typeface)) {
            c0();
        }
    }

    public void o(@NonNull RectF rectF, int i2, int i3) {
        this.I = f(this.G);
        rectF.left = Math.max(s(i2, i3), (float) this.f21496h.left);
        rectF.top = (float) this.f21496h.top;
        rectF.right = Math.min(t(rectF, i2, i3), (float) this.f21496h.right);
        rectF.bottom = ((float) this.f21496h.top) + r();
    }

    public ColorStateList p() {
        return this.o;
    }

    public void p0(int i2) {
        this.f21494f = i2;
    }

    public int q() {
        return this.f21499k;
    }

    public void q0(int i2, int i3, int i4, int i5) {
        if (!e0(this.f21495g, i2, i3, i4, i5)) {
            this.f21495g.set(i2, i3, i4, i5);
            this.U = true;
        }
    }

    public float r() {
        Q(this.W);
        return -this.W.ascent();
    }

    public void r0(@NonNull Rect rect) {
        q0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void s0(float f2) {
        if (this.i0 != f2) {
            this.i0 = f2;
            c0();
        }
    }

    public void t0(int i2) {
        TextAppearance textAppearance = new TextAppearance(this.f21489a.getContext(), i2);
        if (textAppearance.i() != null) {
            this.f21502n = textAppearance.i();
        }
        if (textAppearance.j() != 0.0f) {
            this.f21500l = textAppearance.j();
        }
        ColorStateList colorStateList = textAppearance.f21708c;
        if (colorStateList != null) {
            this.g0 = colorStateList;
        }
        this.e0 = textAppearance.f21713h;
        this.f0 = textAppearance.f21714i;
        this.d0 = textAppearance.f21715j;
        this.i0 = textAppearance.f21717l;
        CancelableFontCallback cancelableFontCallback = this.D;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.c();
        }
        this.D = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() {
            public void a(Typeface typeface) {
                CollapsingTextHelper.this.y0(typeface);
            }
        }, textAppearance.e());
        textAppearance.h(this.f21489a.getContext(), this.D);
        c0();
    }

    public float u() {
        return this.f21501m;
    }

    public Typeface v() {
        Typeface typeface = this.w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void v0(ColorStateList colorStateList) {
        if (this.f21502n != colorStateList) {
            this.f21502n = colorStateList;
            c0();
        }
    }

    @ColorInt
    public int w() {
        return x(this.o);
    }

    public void w0(int i2) {
        if (this.f21498j != i2) {
            this.f21498j = i2;
            c0();
        }
    }

    public void x0(float f2) {
        if (this.f21500l != f2) {
            this.f21500l = f2;
            c0();
        }
    }

    public void y0(Typeface typeface) {
        if (z0(typeface)) {
            c0();
        }
    }

    public int z() {
        return this.p;
    }
}
