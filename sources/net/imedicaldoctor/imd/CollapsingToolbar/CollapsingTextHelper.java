package net.imedicaldoctor.imd.CollapsingToolbar;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.ColorInt;
import androidx.appcompat.R;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.ts.TsExtractor;

final class CollapsingTextHelper {
    private static final boolean Y = false;
    private static final boolean Z = false;
    private static final Paint a0 = null;
    private Paint A;
    private float B;
    private float C;
    private int[] D;
    private boolean E;
    private final TextPaint F;
    private Interpolator G;
    private Interpolator H;
    private float I;
    private float J;
    private float K;
    private int L;
    private float M;
    private float N;
    private float O;
    private int P;
    private CharSequence Q;
    private Bitmap R;
    private Bitmap S;
    private StaticLayout T;
    private float U;
    private float V;
    private float W;
    private int X = 3;

    /* renamed from: a  reason: collision with root package name */
    private final View f29485a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f29486b;

    /* renamed from: c  reason: collision with root package name */
    private float f29487c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f29488d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f29489e;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f29490f;

    /* renamed from: g  reason: collision with root package name */
    private int f29491g = 16;

    /* renamed from: h  reason: collision with root package name */
    private int f29492h = 16;

    /* renamed from: i  reason: collision with root package name */
    private float f29493i = 8.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f29494j = 8.0f;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f29495k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f29496l;

    /* renamed from: m  reason: collision with root package name */
    private float f29497m;

    /* renamed from: n  reason: collision with root package name */
    private float f29498n;
    private float o;
    private float p;
    private float q;
    private float r;
    private Typeface s;
    private Typeface t;
    private Typeface u;
    private CharSequence v;
    private CharSequence w;
    private boolean x;
    private boolean y;
    private Bitmap z;

    public CollapsingTextHelper(View view) {
        this.f29485a = view;
        this.F = new TextPaint(TsExtractor.J);
        this.f29489e = new Rect();
        this.f29488d = new Rect();
        this.f29490f = new RectF();
    }

    private static float B(float f2, float f3, float f4, Interpolator interpolator) {
        if (interpolator != null) {
            f4 = interpolator.getInterpolation(f4);
        }
        return AnimationUtils.a(f2, f3, f4);
    }

    private Typeface D(int i2) {
        TypedArray obtainStyledAttributes = this.f29485a.getContext().obtainStyledAttributes(i2, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static boolean F(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    private void I(float f2) {
        this.U = f2;
        ViewCompat.t1(this.f29485a);
    }

    private void P(float f2) {
        this.V = f2;
        ViewCompat.t1(this.f29485a);
    }

    private void V(float f2) {
        f(f2);
        boolean z2 = Y && this.B != 1.0f;
        this.y = z2;
        if (z2) {
            k();
            i();
            j();
        }
        ViewCompat.t1(this.f29485a);
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r11 = this;
            float r0 = r11.C
            float r1 = r11.f29494j
            r11.f(r1)
            java.lang.CharSequence r1 = r11.w
            r11.Q = r1
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x001a
            android.text.TextPaint r4 = r11.F
            int r5 = r1.length()
            float r1 = r4.measureText(r1, r2, r5)
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            int r4 = r11.f29492h
            boolean r5 = r11.x
            int r4 = androidx.core.view.GravityCompat.d(r4, r5)
            android.text.StaticLayout r5 = r11.T
            if (r5 == 0) goto L_0x002d
            int r5 = r5.getHeight()
            float r5 = (float) r5
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            r6 = r4 & 112(0x70, float:1.57E-43)
            r7 = 80
            r8 = 48
            r9 = 1073741824(0x40000000, float:2.0)
            if (r6 == r8) goto L_0x004b
            if (r6 == r7) goto L_0x0046
            float r5 = r5 / r9
            android.graphics.Rect r6 = r11.f29489e
            int r6 = r6.centerY()
        L_0x0041:
            float r6 = (float) r6
            float r6 = r6 - r5
            r11.f29498n = r6
            goto L_0x0052
        L_0x0046:
            android.graphics.Rect r6 = r11.f29489e
            int r6 = r6.bottom
            goto L_0x0041
        L_0x004b:
            android.graphics.Rect r5 = r11.f29489e
            int r5 = r5.top
            float r5 = (float) r5
            r11.f29498n = r5
        L_0x0052:
            r5 = 8388615(0x800007, float:1.1754953E-38)
            r4 = r4 & r5
            r6 = 5
            r10 = 1
            if (r4 == r10) goto L_0x006d
            if (r4 == r6) goto L_0x0064
            android.graphics.Rect r1 = r11.f29489e
            int r1 = r1.left
            float r1 = (float) r1
            r11.p = r1
            goto L_0x0076
        L_0x0064:
            android.graphics.Rect r4 = r11.f29489e
            int r4 = r4.right
            float r4 = (float) r4
        L_0x0069:
            float r4 = r4 - r1
            r11.p = r4
            goto L_0x0076
        L_0x006d:
            android.graphics.Rect r4 = r11.f29489e
            int r4 = r4.centerX()
            float r4 = (float) r4
            float r1 = r1 / r9
            goto L_0x0069
        L_0x0076:
            float r1 = r11.f29493i
            r11.f(r1)
            android.text.StaticLayout r1 = r11.T
            if (r1 == 0) goto L_0x0084
            float r1 = r1.getLineWidth(r2)
            goto L_0x0085
        L_0x0084:
            r1 = 0
        L_0x0085:
            android.text.StaticLayout r4 = r11.T
            if (r4 == 0) goto L_0x008e
            float r2 = r4.getLineLeft(r2)
            goto L_0x008f
        L_0x008e:
            r2 = 0
        L_0x008f:
            r11.W = r2
            int r2 = r11.f29491g
            boolean r4 = r11.x
            int r2 = androidx.core.view.GravityCompat.d(r2, r4)
            android.text.StaticLayout r4 = r11.T
            if (r4 == 0) goto L_0x00a2
            int r3 = r4.getHeight()
            float r3 = (float) r3
        L_0x00a2:
            r4 = r2 & 112(0x70, float:1.57E-43)
            if (r4 == r8) goto L_0x00b9
            if (r4 == r7) goto L_0x00b4
            float r3 = r3 / r9
            android.graphics.Rect r4 = r11.f29488d
            int r4 = r4.centerY()
        L_0x00af:
            float r4 = (float) r4
            float r4 = r4 - r3
            r11.f29497m = r4
            goto L_0x00c0
        L_0x00b4:
            android.graphics.Rect r4 = r11.f29488d
            int r4 = r4.bottom
            goto L_0x00af
        L_0x00b9:
            android.graphics.Rect r3 = r11.f29488d
            int r3 = r3.top
            float r3 = (float) r3
            r11.f29497m = r3
        L_0x00c0:
            r2 = r2 & r5
            if (r2 == r10) goto L_0x00d6
            if (r2 == r6) goto L_0x00cd
            android.graphics.Rect r1 = r11.f29488d
            int r1 = r1.left
            float r1 = (float) r1
            r11.o = r1
            goto L_0x00df
        L_0x00cd:
            android.graphics.Rect r2 = r11.f29488d
            int r2 = r2.right
            float r2 = (float) r2
        L_0x00d2:
            float r2 = r2 - r1
            r11.o = r2
            goto L_0x00df
        L_0x00d6:
            android.graphics.Rect r2 = r11.f29488d
            int r2 = r2.centerX()
            float r2 = (float) r2
            float r1 = r1 / r9
            goto L_0x00d2
        L_0x00df:
            r11.g()
            r11.V(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.CollapsingToolbar.CollapsingTextHelper.b():void");
    }

    private void c() {
        e(this.f29487c);
    }

    private boolean d(CharSequence charSequence) {
        return (ViewCompat.c0(this.f29485a) == 1 ? TextDirectionHeuristicsCompat.f6206d : TextDirectionHeuristicsCompat.f6205c).b(charSequence, 0, charSequence.length());
    }

    private void e(float f2) {
        TextPaint textPaint;
        int p2;
        y(f2);
        this.q = B(this.o, this.p, f2, this.G);
        this.r = B(this.f29497m, this.f29498n, f2, this.G);
        V(B(this.f29493i, this.f29494j, f2, this.H));
        Interpolator interpolator = AnimationUtils.f29481b;
        I(1.0f - B(0.0f, 1.0f, 1.0f - f2, interpolator));
        P(B(1.0f, 0.0f, f2, interpolator));
        if (this.f29496l != this.f29495k) {
            textPaint = this.F;
            p2 = a(q(), p(), f2);
        } else {
            textPaint = this.F;
            p2 = p();
        }
        textPaint.setColor(p2);
        this.F.setShadowLayer(B(this.M, this.I, f2, (Interpolator) null), B(this.N, this.J, f2, (Interpolator) null), B(this.O, this.K, f2, (Interpolator) null), a(this.P, this.L, f2));
        ViewCompat.t1(this.f29485a);
    }

    private void f(float f2) {
        boolean z2;
        int i2;
        float f3;
        CharSequence charSequence;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        boolean z3;
        float f4 = f2;
        if (this.v != null) {
            float width = (float) this.f29489e.width();
            float width2 = (float) this.f29488d.width();
            if (z(f4, this.f29494j)) {
                f3 = (this.f29494j / 3.0f) * 2.0f;
                this.B = 1.0f;
                Typeface typeface = this.u;
                Typeface typeface2 = this.s;
                if (typeface != typeface2) {
                    this.u = typeface2;
                    z3 = true;
                } else {
                    z3 = false;
                }
                z2 = z3;
                width2 = width;
                i2 = 1;
            } else {
                float f5 = this.f29494j;
                Typeface typeface3 = this.u;
                Typeface typeface4 = this.t;
                if (typeface3 != typeface4) {
                    this.u = typeface4;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z(f4, this.f29493i)) {
                    this.B = 1.0f;
                } else {
                    this.B = f4 / this.f29493i;
                }
                float f6 = f5;
                i2 = this.X;
                f3 = f6;
            }
            if (width2 > 0.0f) {
                z2 = this.C != f3 || this.E || z2;
                this.C = f3;
                this.E = false;
            }
            if (this.w == null || z2) {
                this.F.setTextSize(this.C);
                this.F.setTypeface(this.u);
                CharSequence charSequence2 = this.v;
                TextPaint textPaint = this.F;
                int i3 = (int) width2;
                Layout.Alignment alignment3 = Layout.Alignment.ALIGN_NORMAL;
                StaticLayout staticLayout = new StaticLayout(charSequence2, textPaint, i3, alignment3, 1.0f, 0.0f, false);
                if (staticLayout.getLineCount() > i2) {
                    int i4 = i2 - 1;
                    CharSequence charSequence3 = "";
                    CharSequence subSequence = i4 > 0 ? this.v.subSequence(0, staticLayout.getLineEnd(i2 - 2)) : charSequence3;
                    CharSequence subSequence2 = this.v.subSequence(staticLayout.getLineStart(i4), staticLayout.getLineEnd(i4));
                    if (subSequence2.charAt(subSequence2.length() - 1) == ' ') {
                        charSequence3 = subSequence2.subSequence(subSequence2.length() - 1, subSequence2.length());
                        subSequence2 = subSequence2.subSequence(0, subSequence2.length() - 1);
                    }
                    charSequence = TextUtils.concat(new CharSequence[]{subSequence, TextUtils.ellipsize(TextUtils.concat(new CharSequence[]{subSequence2, "…", charSequence3}), this.F, width2, TextUtils.TruncateAt.END)});
                } else {
                    charSequence = this.v;
                }
                if (!TextUtils.equals(charSequence, this.w)) {
                    this.w = charSequence;
                    this.x = d(charSequence);
                }
                int i5 = this.f29491g & GravityCompat.f6389d;
                if (i5 == 1) {
                    alignment2 = Layout.Alignment.ALIGN_CENTER;
                } else if (i5 == 5 || i5 == 8388613) {
                    alignment2 = Layout.Alignment.ALIGN_OPPOSITE;
                } else {
                    alignment = alignment3;
                    this.T = new StaticLayout(this.w, this.F, i3, alignment, 1.0f, 0.0f, false);
                }
                alignment = alignment2;
                this.T = new StaticLayout(this.w, this.F, i3, alignment, 1.0f, 0.0f, false);
            }
        }
    }

    private void g() {
        Bitmap bitmap = this.z;
        if (bitmap != null) {
            bitmap.recycle();
            this.z = null;
        }
        Bitmap bitmap2 = this.R;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.R = null;
        }
        Bitmap bitmap3 = this.S;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.S = null;
        }
    }

    private void i() {
        if (this.R == null && !this.f29489e.isEmpty() && !TextUtils.isEmpty(this.w)) {
            e(0.0f);
            TextPaint textPaint = this.F;
            CharSequence charSequence = this.w;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.F.descent() - this.F.ascent());
            if (round > 0 || round2 > 0) {
                this.R = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.R);
                CharSequence charSequence2 = this.Q;
                canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, (-this.F.ascent()) / this.B, this.F);
                if (this.A == null) {
                    this.A = new Paint(3);
                }
            }
        }
    }

    private void j() {
        if (this.S == null && !this.f29489e.isEmpty() && !TextUtils.isEmpty(this.w)) {
            e(0.0f);
            int round = Math.round(this.F.measureText(this.w, this.T.getLineStart(0), this.T.getLineEnd(0)));
            int round2 = Math.round(this.F.descent() - this.F.ascent());
            if (round > 0 || round2 > 0) {
                this.S = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                new Canvas(this.S).drawText(this.w, this.T.getLineStart(0), this.T.getLineEnd(0), 0.0f, (-this.F.ascent()) / this.B, this.F);
                if (this.A == null) {
                    this.A = new Paint(3);
                }
            }
        }
    }

    private void k() {
        if (this.z == null && !this.f29488d.isEmpty() && !TextUtils.isEmpty(this.w)) {
            e(0.0f);
            int width = this.T.getWidth();
            int height = this.T.getHeight();
            if (width > 0 && height > 0) {
                this.z = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.T.draw(new Canvas(this.z));
                if (this.A == null) {
                    this.A = new Paint(3);
                }
            }
        }
    }

    @ColorInt
    private int p() {
        int[] iArr = this.D;
        return iArr != null ? this.f29496l.getColorForState(iArr, 0) : this.f29496l.getDefaultColor();
    }

    @ColorInt
    private int q() {
        int[] iArr = this.D;
        return iArr != null ? this.f29495k.getColorForState(iArr, 0) : this.f29495k.getDefaultColor();
    }

    private void y(float f2) {
        this.f29490f.left = B((float) this.f29488d.left, (float) this.f29489e.left, f2, this.G);
        this.f29490f.top = B(this.f29497m, this.f29498n, f2, this.G);
        this.f29490f.right = B((float) this.f29488d.right, (float) this.f29489e.right, f2, this.G);
        this.f29490f.bottom = B((float) this.f29488d.bottom, (float) this.f29489e.bottom, f2, this.G);
    }

    private static boolean z(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f29495k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean A() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f29496l
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f29495k
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
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.CollapsingToolbar.CollapsingTextHelper.A():boolean");
    }

    /* access modifiers changed from: package-private */
    public void C() {
        this.f29486b = this.f29489e.width() > 0 && this.f29489e.height() > 0 && this.f29488d.width() > 0 && this.f29488d.height() > 0;
    }

    public void E() {
        if (this.f29485a.getHeight() > 0 && this.f29485a.getWidth() > 0) {
            b();
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void G(int i2, int i3, int i4, int i5) {
        if (!F(this.f29489e, i2, i3, i4, i5)) {
            this.f29489e.set(i2, i3, i4, i5);
            this.E = true;
            C();
        }
    }

    /* access modifiers changed from: package-private */
    public void H(int i2) {
        TypedArray obtainStyledAttributes = this.f29485a.getContext().obtainStyledAttributes(i2, R.styleable.a6);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f29496l = obtainStyledAttributes.getColorStateList(3);
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f29494j = (float) obtainStyledAttributes.getDimensionPixelSize(0, (int) this.f29494j);
        }
        this.L = obtainStyledAttributes.getInt(6, 0);
        this.J = obtainStyledAttributes.getFloat(7, 0.0f);
        this.K = obtainStyledAttributes.getFloat(8, 0.0f);
        this.I = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        this.s = D(i2);
        E();
    }

    /* access modifiers changed from: package-private */
    public void J(ColorStateList colorStateList) {
        if (this.f29496l != colorStateList) {
            this.f29496l = colorStateList;
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public void K(int i2) {
        if (this.f29492h != i2) {
            this.f29492h = i2;
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public void L(float f2) {
        if (this.f29494j != f2) {
            this.f29494j = f2;
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public void M(Typeface typeface) {
        if (this.s != typeface) {
            this.s = typeface;
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public void N(int i2, int i3, int i4, int i5) {
        if (!F(this.f29488d, i2, i3, i4, i5)) {
            this.f29488d.set(i2, i3, i4, i5);
            this.E = true;
            C();
        }
    }

    /* access modifiers changed from: package-private */
    public void O(int i2) {
        TypedArray obtainStyledAttributes = this.f29485a.getContext().obtainStyledAttributes(i2, R.styleable.a6);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f29495k = obtainStyledAttributes.getColorStateList(3);
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f29493i = (float) obtainStyledAttributes.getDimensionPixelSize(0, (int) this.f29493i);
        }
        this.P = obtainStyledAttributes.getInt(6, 0);
        this.N = obtainStyledAttributes.getFloat(7, 0.0f);
        this.O = obtainStyledAttributes.getFloat(8, 0.0f);
        this.M = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        this.t = D(i2);
        E();
    }

    /* access modifiers changed from: package-private */
    public void Q(ColorStateList colorStateList) {
        if (this.f29495k != colorStateList) {
            this.f29495k = colorStateList;
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public void R(int i2) {
        if (this.f29491g != i2) {
            this.f29491g = i2;
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public void S(float f2) {
        if (this.f29493i != f2) {
            this.f29493i = f2;
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public void T(Typeface typeface) {
        if (this.t != typeface) {
            this.t = typeface;
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public void U(float f2) {
        float a2 = MathUtils.a(f2, 0.0f, 1.0f);
        if (a2 != this.f29487c) {
            this.f29487c = a2;
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void W(int i2) {
        if (i2 != this.X) {
            this.X = i2;
            g();
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public void X(Interpolator interpolator) {
        this.G = interpolator;
        E();
    }

    /* access modifiers changed from: package-private */
    public boolean Y(int[] iArr) {
        this.D = iArr;
        if (!A()) {
            return false;
        }
        E();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void Z(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.v)) {
            this.v = charSequence;
            this.w = null;
            g();
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(Interpolator interpolator) {
        this.H = interpolator;
        E();
    }

    /* access modifiers changed from: package-private */
    public void b0(Typeface typeface) {
        this.t = typeface;
        this.s = typeface;
        E();
    }

    public void h(Canvas canvas) {
        int save = canvas.save();
        if (this.w != null && this.f29486b) {
            float f2 = this.q;
            float f3 = this.r;
            boolean z2 = this.y && this.z != null;
            this.F.setTextSize(this.C);
            float ascent = z2 ? 0.0f : this.F.ascent() * this.B;
            float f4 = this.B;
            if (f4 != 1.0f) {
                canvas.scale(f4, f4, f2, f3);
            }
            float lineLeft = (this.q + this.T.getLineLeft(0)) - (this.W * 2.0f);
            if (z2) {
                this.A.setAlpha((int) (this.V * 255.0f));
                canvas.drawBitmap(this.z, lineLeft, f3, this.A);
                this.A.setAlpha((int) (this.U * 255.0f));
                canvas.drawBitmap(this.R, f2, f3, this.A);
                this.A.setAlpha(255);
                canvas.drawBitmap(this.S, f2, f3, this.A);
            } else {
                canvas.translate(lineLeft, f3);
                this.F.setAlpha((int) (this.V * 255.0f));
                this.T.draw(canvas);
                canvas.translate(f2 - lineLeft, 0.0f);
                this.F.setAlpha((int) (this.U * 255.0f));
                CharSequence charSequence = this.Q;
                float f5 = -ascent;
                canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5 / this.B, this.F);
                this.F.setAlpha(255);
                canvas.drawText(this.w, this.T.getLineStart(0), this.T.getLineEnd(0), 0.0f, f5 / this.B, this.F);
            }
        }
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f29496l;
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return this.f29492h;
    }

    /* access modifiers changed from: package-private */
    public float n() {
        return this.f29494j;
    }

    /* access modifiers changed from: package-private */
    public Typeface o() {
        Typeface typeface = this.s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList r() {
        return this.f29495k;
    }

    /* access modifiers changed from: package-private */
    public int s() {
        return this.f29491g;
    }

    /* access modifiers changed from: package-private */
    public float t() {
        return this.f29493i;
    }

    /* access modifiers changed from: package-private */
    public Typeface u() {
        Typeface typeface = this.t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    /* access modifiers changed from: package-private */
    public float v() {
        return this.f29487c;
    }

    /* access modifiers changed from: package-private */
    public int w() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public CharSequence x() {
        return this.v;
    }
}
