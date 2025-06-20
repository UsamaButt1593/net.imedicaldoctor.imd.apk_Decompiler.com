package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    private static final boolean H4 = false;
    private static final int[] I4 = {16842910};
    private static final String J4 = "http://schemas.android.com/apk/res-auto";
    private static final int K4 = 24;
    private static final ShapeDrawable L4 = new ShapeDrawable(new OvalShape());
    private float A3 = -1.0f;
    private boolean A4;
    @Nullable
    private ColorStateList B3;
    @Nullable
    private ColorStateList B4;
    private float C3;
    @NonNull
    private WeakReference<Delegate> C4 = new WeakReference<>((Object) null);
    @Nullable
    private ColorStateList D3;
    private TextUtils.TruncateAt D4;
    @Nullable
    private CharSequence E3;
    private boolean E4;
    private boolean F3;
    private int F4;
    @Nullable
    private Drawable G3;
    private boolean G4;
    @Nullable
    private ColorStateList H3;
    private float I3;
    private boolean J3;
    private boolean K3;
    @Nullable
    private Drawable L3;
    @Nullable
    private Drawable M3;
    @Nullable
    private ColorStateList N3;
    private float O3;
    @Nullable
    private CharSequence P3;
    private boolean Q3;
    private boolean R3;
    @Nullable
    private Drawable S3;
    @Nullable
    private ColorStateList T3;
    @Nullable
    private MotionSpec U3;
    @Nullable
    private MotionSpec V3;
    private float W3;
    private float X3;
    private float Y3;
    private float Z3;
    private float a4;
    private float b4;
    private float c4;
    private float d4;
    @NonNull
    private final Context e4;
    private final Paint f4 = new Paint(1);
    @Nullable
    private final Paint g4;
    private final Paint.FontMetrics h4 = new Paint.FontMetrics();
    private final RectF i4 = new RectF();
    private final PointF j4 = new PointF();
    private final Path k4 = new Path();
    @NonNull
    private final TextDrawableHelper l4;
    @ColorInt
    private int m4;
    @ColorInt
    private int n4;
    @ColorInt
    private int o4;
    @ColorInt
    private int p4;
    @ColorInt
    private int q4;
    @ColorInt
    private int r4;
    private boolean s4;
    @ColorInt
    private int t4;
    private int u4 = 255;
    @Nullable
    private ColorFilter v4;
    @Nullable
    private PorterDuffColorFilter w4;
    @Nullable
    private ColorStateList x3;
    @Nullable
    private ColorStateList x4;
    @Nullable
    private ColorStateList y3;
    @Nullable
    private PorterDuff.Mode y4 = PorterDuff.Mode.SRC_IN;
    private float z3;
    private int[] z4;

    public interface Delegate {
        void a();
    }

    private ChipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        a0(context);
        this.e4 = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.l4 = textDrawableHelper;
        this.E3 = "";
        textDrawableHelper.g().density = context.getResources().getDisplayMetrics().density;
        this.g4 = null;
        int[] iArr = I4;
        setState(iArr);
        g3(iArr);
        this.E4 = true;
        if (RippleUtils.f21729a) {
            L4.setTint(-1);
        }
    }

    private float H1() {
        Drawable drawable = this.s4 ? this.S3 : this.G3;
        float f2 = this.I3;
        if (f2 <= 0.0f && drawable != null) {
            f2 = (float) Math.ceil((double) ViewUtils.i(this.e4, 24));
            if (((float) drawable.getIntrinsicHeight()) <= f2) {
                return (float) drawable.getIntrinsicHeight();
            }
        }
        return f2;
    }

    private float I1() {
        Drawable drawable = this.s4 ? this.S3 : this.G3;
        float f2 = this.I3;
        return (f2 > 0.0f || drawable == null) ? f2 : (float) drawable.getIntrinsicWidth();
    }

    private boolean M3() {
        return this.R3 && this.S3 != null && this.s4;
    }

    private boolean N3() {
        return this.F3 && this.G3 != null;
    }

    private boolean O3() {
        return this.K3 && this.L3 != null;
    }

    private void P3(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    private void Q0(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            DrawableCompat.m(drawable, DrawableCompat.f(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.L3) {
                if (drawable.isStateful()) {
                    drawable.setState(E1());
                }
                DrawableCompat.o(drawable, this.N3);
                return;
            }
            Drawable drawable2 = this.G3;
            if (drawable == drawable2 && this.J3) {
                DrawableCompat.o(drawable2, this.H3);
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    private void Q3() {
        this.B4 = this.A4 ? RippleUtils.e(this.D3) : null;
    }

    private void R0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (N3() || M3()) {
            float f2 = this.W3 + this.X3;
            float I1 = I1();
            if (DrawableCompat.f(this) == 0) {
                float f3 = ((float) rect.left) + f2;
                rectF.left = f3;
                rectF.right = f3 + I1;
            } else {
                float f5 = ((float) rect.right) - f2;
                rectF.right = f5;
                rectF.left = f5 - I1;
            }
            float H1 = H1();
            float exactCenterY = rect.exactCenterY() - (H1 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + H1;
        }
    }

    @TargetApi(21)
    private void R3() {
        this.M3 = new RippleDrawable(RippleUtils.e(O1()), this.L3, L4);
    }

    private void T0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (O3()) {
            float f2 = this.d4 + this.c4 + this.O3 + this.b4 + this.a4;
            if (DrawableCompat.f(this) == 0) {
                rectF.right = ((float) rect.right) - f2;
            } else {
                rectF.left = ((float) rect.left) + f2;
            }
        }
    }

    private void U0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (O3()) {
            float f2 = this.d4 + this.c4;
            if (DrawableCompat.f(this) == 0) {
                float f3 = ((float) rect.right) - f2;
                rectF.right = f3;
                rectF.left = f3 - this.O3;
            } else {
                float f5 = ((float) rect.left) + f2;
                rectF.left = f5;
                rectF.right = f5 + this.O3;
            }
            float exactCenterY = rect.exactCenterY();
            float f6 = this.O3;
            float f7 = exactCenterY - (f6 / 2.0f);
            rectF.top = f7;
            rectF.bottom = f7 + f6;
        }
    }

    @Nullable
    private ColorFilter U1() {
        ColorFilter colorFilter = this.v4;
        return colorFilter != null ? colorFilter : this.w4;
    }

    private void U2(@Nullable ColorStateList colorStateList) {
        if (this.x3 != colorStateList) {
            this.x3 = colorStateList;
            onStateChange(getState());
        }
    }

    private void V0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (O3()) {
            float f2 = this.d4 + this.c4 + this.O3 + this.b4 + this.a4;
            if (DrawableCompat.f(this) == 0) {
                float f3 = (float) rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i2 = rect.left;
                rectF.left = (float) i2;
                rectF.right = ((float) i2) + f2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private static boolean W1(@Nullable int[] iArr, @AttrRes int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private void X0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.E3 != null) {
            float S0 = this.W3 + S0() + this.Z3;
            float W0 = this.d4 + W0() + this.a4;
            if (DrawableCompat.f(this) == 0) {
                rectF.left = ((float) rect.left) + S0;
                rectF.right = ((float) rect.right) - W0;
            } else {
                rectF.left = ((float) rect.left) + W0;
                rectF.right = ((float) rect.right) - S0;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private float Y0() {
        this.l4.g().getFontMetrics(this.h4);
        Paint.FontMetrics fontMetrics = this.h4;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean a1() {
        return this.R3 && this.S3 != null && this.Q3;
    }

    @NonNull
    public static ChipDrawable b1(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        ChipDrawable chipDrawable = new ChipDrawable(context, attributeSet, i2, i3);
        chipDrawable.j2(attributeSet, i2, i3);
        return chipDrawable;
    }

    @NonNull
    public static ChipDrawable c1(@NonNull Context context, @XmlRes int i2) {
        AttributeSet k2 = DrawableUtils.k(context, i2, "chip");
        int styleAttribute = k2.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = R.style.Xi;
        }
        return b1(context, k2, R.attr.E2, styleAttribute);
    }

    private void d1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (M3()) {
            R0(rect, this.i4);
            RectF rectF = this.i4;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.S3.setBounds(0, 0, (int) this.i4.width(), (int) this.i4.height());
            this.S3.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void e1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.G4) {
            this.f4.setColor(this.n4);
            this.f4.setStyle(Paint.Style.FILL);
            this.f4.setColorFilter(U1());
            this.i4.set(rect);
            canvas.drawRoundRect(this.i4, p1(), p1(), this.f4);
        }
    }

    private void f1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (N3()) {
            R0(rect, this.i4);
            RectF rectF = this.i4;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.G3.setBounds(0, 0, (int) this.i4.width(), (int) this.i4.height());
            this.G3.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void g1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.C3 > 0.0f && !this.G4) {
            this.f4.setColor(this.p4);
            this.f4.setStyle(Paint.Style.STROKE);
            if (!this.G4) {
                this.f4.setColorFilter(U1());
            }
            RectF rectF = this.i4;
            float f2 = this.C3;
            rectF.set(((float) rect.left) + (f2 / 2.0f), ((float) rect.top) + (f2 / 2.0f), ((float) rect.right) - (f2 / 2.0f), ((float) rect.bottom) - (f2 / 2.0f));
            float f3 = this.A3 - (this.C3 / 2.0f);
            canvas.drawRoundRect(this.i4, f3, f3, this.f4);
        }
    }

    private static boolean g2(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private void h1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.G4) {
            this.f4.setColor(this.m4);
            this.f4.setStyle(Paint.Style.FILL);
            this.i4.set(rect);
            canvas.drawRoundRect(this.i4, p1(), p1(), this.f4);
        }
    }

    private static boolean h2(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private void i1(@NonNull Canvas canvas, @NonNull Rect rect) {
        Drawable drawable;
        if (O3()) {
            U0(rect, this.i4);
            RectF rectF = this.i4;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.L3.setBounds(0, 0, (int) this.i4.width(), (int) this.i4.height());
            if (RippleUtils.f21729a) {
                this.M3.setBounds(this.L3.getBounds());
                this.M3.jumpToCurrentState();
                drawable = this.M3;
            } else {
                drawable = this.L3;
            }
            drawable.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private static boolean i2(@Nullable TextAppearance textAppearance) {
        return (textAppearance == null || textAppearance.i() == null || !textAppearance.i().isStateful()) ? false : true;
    }

    private void j1(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.f4.setColor(this.q4);
        this.f4.setStyle(Paint.Style.FILL);
        this.i4.set(rect);
        if (!this.G4) {
            canvas.drawRoundRect(this.i4, p1(), p1(), this.f4);
            return;
        }
        h(new RectF(rect), this.k4);
        super.r(canvas, this.f4, this.k4, w());
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j2(@androidx.annotation.Nullable android.util.AttributeSet r8, @androidx.annotation.AttrRes int r9, @androidx.annotation.StyleRes int r10) {
        /*
            r7 = this;
            android.content.Context r0 = r7.e4
            int[] r2 = com.google.android.material.R.styleable.s6
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r8
            r3 = r9
            r4 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.e7
            boolean r10 = r9.hasValue(r10)
            r7.G4 = r10
            android.content.Context r10 = r7.e4
            int r0 = com.google.android.material.R.styleable.R6
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.a(r10, r9, r0)
            r7.U2(r10)
            android.content.Context r10 = r7.e4
            int r0 = com.google.android.material.R.styleable.E6
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.a(r10, r9, r0)
            r7.w2(r10)
            int r10 = com.google.android.material.R.styleable.M6
            r0 = 0
            float r10 = r9.getDimension(r10, r0)
            r7.M2(r10)
            int r10 = com.google.android.material.R.styleable.F6
            boolean r1 = r9.hasValue(r10)
            if (r1 == 0) goto L_0x0045
            float r10 = r9.getDimension(r10, r0)
            r7.y2(r10)
        L_0x0045:
            android.content.Context r10 = r7.e4
            int r1 = com.google.android.material.R.styleable.P6
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.a(r10, r9, r1)
            r7.Q2(r10)
            int r10 = com.google.android.material.R.styleable.Q6
            float r10 = r9.getDimension(r10, r0)
            r7.S2(r10)
            android.content.Context r10 = r7.e4
            int r1 = com.google.android.material.R.styleable.d7
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.a(r10, r9, r1)
            r7.u3(r10)
            int r10 = com.google.android.material.R.styleable.y6
            java.lang.CharSequence r10 = r9.getText(r10)
            r7.z3(r10)
            android.content.Context r10 = r7.e4
            int r1 = com.google.android.material.R.styleable.t6
            com.google.android.material.resources.TextAppearance r10 = com.google.android.material.resources.MaterialResources.h(r10, r9, r1)
            int r1 = com.google.android.material.R.styleable.u6
            float r2 = r10.j()
            float r1 = r9.getDimension(r1, r2)
            r10.l(r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 >= r2) goto L_0x0093
            android.content.Context r1 = r7.e4
            int r2 = com.google.android.material.R.styleable.v6
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.a(r1, r9, r2)
            r10.k(r1)
        L_0x0093:
            r7.A3(r10)
            int r10 = com.google.android.material.R.styleable.w6
            int r10 = r9.getInt(r10, r6)
            r1 = 1
            if (r10 == r1) goto L_0x00af
            r1 = 2
            if (r10 == r1) goto L_0x00ac
            r1 = 3
            if (r10 == r1) goto L_0x00a6
            goto L_0x00b2
        L_0x00a6:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.END
        L_0x00a8:
            r7.m3(r10)
            goto L_0x00b2
        L_0x00ac:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.MIDDLE
            goto L_0x00a8
        L_0x00af:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.START
            goto L_0x00a8
        L_0x00b2:
            int r10 = com.google.android.material.R.styleable.L6
            boolean r10 = r9.getBoolean(r10, r6)
            r7.L2(r10)
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            if (r8 == 0) goto L_0x00d8
            java.lang.String r1 = "chipIconEnabled"
            java.lang.String r1 = r8.getAttributeValue(r10, r1)
            if (r1 == 0) goto L_0x00d8
            java.lang.String r1 = "chipIconVisible"
            java.lang.String r1 = r8.getAttributeValue(r10, r1)
            if (r1 != 0) goto L_0x00d8
            int r1 = com.google.android.material.R.styleable.I6
            boolean r1 = r9.getBoolean(r1, r6)
            r7.L2(r1)
        L_0x00d8:
            android.content.Context r1 = r7.e4
            int r2 = com.google.android.material.R.styleable.H6
            android.graphics.drawable.Drawable r1 = com.google.android.material.resources.MaterialResources.e(r1, r9, r2)
            r7.C2(r1)
            int r1 = com.google.android.material.R.styleable.K6
            boolean r2 = r9.hasValue(r1)
            if (r2 == 0) goto L_0x00f4
            android.content.Context r2 = r7.e4
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.a(r2, r9, r1)
            r7.I2(r1)
        L_0x00f4:
            int r1 = com.google.android.material.R.styleable.J6
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r1 = r9.getDimension(r1, r2)
            r7.G2(r1)
            int r1 = com.google.android.material.R.styleable.Y6
            boolean r1 = r9.getBoolean(r1, r6)
            r7.k3(r1)
            if (r8 == 0) goto L_0x0123
            java.lang.String r1 = "closeIconEnabled"
            java.lang.String r1 = r8.getAttributeValue(r10, r1)
            if (r1 == 0) goto L_0x0123
            java.lang.String r1 = "closeIconVisible"
            java.lang.String r1 = r8.getAttributeValue(r10, r1)
            if (r1 != 0) goto L_0x0123
            int r1 = com.google.android.material.R.styleable.T6
            boolean r1 = r9.getBoolean(r1, r6)
            r7.k3(r1)
        L_0x0123:
            android.content.Context r1 = r7.e4
            int r2 = com.google.android.material.R.styleable.S6
            android.graphics.drawable.Drawable r1 = com.google.android.material.resources.MaterialResources.e(r1, r9, r2)
            r7.V2(r1)
            android.content.Context r1 = r7.e4
            int r2 = com.google.android.material.R.styleable.X6
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.a(r1, r9, r2)
            r7.h3(r1)
            int r1 = com.google.android.material.R.styleable.V6
            float r1 = r9.getDimension(r1, r0)
            r7.c3(r1)
            int r1 = com.google.android.material.R.styleable.z6
            boolean r1 = r9.getBoolean(r1, r6)
            r7.m2(r1)
            int r1 = com.google.android.material.R.styleable.D6
            boolean r1 = r9.getBoolean(r1, r6)
            r7.v2(r1)
            if (r8 == 0) goto L_0x016f
            java.lang.String r1 = "checkedIconEnabled"
            java.lang.String r1 = r8.getAttributeValue(r10, r1)
            if (r1 == 0) goto L_0x016f
            java.lang.String r1 = "checkedIconVisible"
            java.lang.String r8 = r8.getAttributeValue(r10, r1)
            if (r8 != 0) goto L_0x016f
            int r8 = com.google.android.material.R.styleable.B6
            boolean r8 = r9.getBoolean(r8, r6)
            r7.v2(r8)
        L_0x016f:
            android.content.Context r8 = r7.e4
            int r10 = com.google.android.material.R.styleable.A6
            android.graphics.drawable.Drawable r8 = com.google.android.material.resources.MaterialResources.e(r8, r9, r10)
            r7.o2(r8)
            int r8 = com.google.android.material.R.styleable.C6
            boolean r10 = r9.hasValue(r8)
            if (r10 == 0) goto L_0x018b
            android.content.Context r10 = r7.e4
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.a(r10, r9, r8)
            r7.s2(r8)
        L_0x018b:
            android.content.Context r8 = r7.e4
            int r10 = com.google.android.material.R.styleable.g7
            com.google.android.material.animation.MotionSpec r8 = com.google.android.material.animation.MotionSpec.c(r8, r9, r10)
            r7.x3(r8)
            android.content.Context r8 = r7.e4
            int r10 = com.google.android.material.R.styleable.a7
            com.google.android.material.animation.MotionSpec r8 = com.google.android.material.animation.MotionSpec.c(r8, r9, r10)
            r7.n3(r8)
            int r8 = com.google.android.material.R.styleable.O6
            float r8 = r9.getDimension(r8, r0)
            r7.O2(r8)
            int r8 = com.google.android.material.R.styleable.c7
            float r8 = r9.getDimension(r8, r0)
            r7.r3(r8)
            int r8 = com.google.android.material.R.styleable.b7
            float r8 = r9.getDimension(r8, r0)
            r7.p3(r8)
            int r8 = com.google.android.material.R.styleable.i7
            float r8 = r9.getDimension(r8, r0)
            r7.I3(r8)
            int r8 = com.google.android.material.R.styleable.h7
            float r8 = r9.getDimension(r8, r0)
            r7.E3(r8)
            int r8 = com.google.android.material.R.styleable.W6
            float r8 = r9.getDimension(r8, r0)
            r7.e3(r8)
            int r8 = com.google.android.material.R.styleable.U6
            float r8 = r9.getDimension(r8, r0)
            r7.Z2(r8)
            int r8 = com.google.android.material.R.styleable.G6
            float r8 = r9.getDimension(r8, r0)
            r7.A2(r8)
            int r8 = com.google.android.material.R.styleable.x6
            r10 = 2147483647(0x7fffffff, float:NaN)
            int r8 = r9.getDimensionPixelSize(r8, r10)
            r7.t3(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.j2(android.util.AttributeSet, int, int):void");
    }

    private void k1(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.g4;
        if (paint != null) {
            paint.setColor(ColorUtils.D(ViewCompat.y, WorkQueueKt.f29430c));
            canvas.drawRect(rect, this.g4);
            if (N3() || M3()) {
                R0(rect, this.i4);
                canvas.drawRect(this.i4, this.g4);
            }
            if (this.E3 != null) {
                canvas.drawLine((float) rect.left, rect.exactCenterY(), (float) rect.right, rect.exactCenterY(), this.g4);
            }
            if (O3()) {
                U0(rect, this.i4);
                canvas.drawRect(this.i4, this.g4);
            }
            this.g4.setColor(ColorUtils.D(SupportMenu.f5941c, WorkQueueKt.f29430c));
            T0(rect, this.i4);
            canvas.drawRect(this.i4, this.g4);
            this.g4.setColor(ColorUtils.D(-16711936, WorkQueueKt.f29430c));
            V0(rect, this.i4);
            canvas.drawRect(this.i4, this.g4);
        }
    }

    private void l1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.E3 != null) {
            Paint.Align Z0 = Z0(rect, this.j4);
            X0(rect, this.i4);
            if (this.l4.e() != null) {
                this.l4.g().drawableState = getState();
                this.l4.o(this.e4);
            }
            this.l4.g().setTextAlign(Z0);
            int i2 = 0;
            boolean z = Math.round(this.l4.h(Q1().toString())) > Math.round(this.i4.width());
            if (z) {
                i2 = canvas.save();
                canvas.clipRect(this.i4);
            }
            CharSequence charSequence = this.E3;
            if (z && this.D4 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.l4.g(), this.i4.width(), this.D4);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.j4;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.l4.g());
            if (z) {
                canvas.restoreToCount(i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0156  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean l2(@androidx.annotation.NonNull int[] r7, @androidx.annotation.NonNull int[] r8) {
        /*
            r6 = this;
            boolean r0 = super.onStateChange(r7)
            android.content.res.ColorStateList r1 = r6.x3
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r6.m4
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            int r1 = r6.l(r1)
            int r3 = r6.m4
            r4 = 1
            if (r3 == r1) goto L_0x001d
            r6.m4 = r1
            r0 = 1
        L_0x001d:
            android.content.res.ColorStateList r3 = r6.y3
            if (r3 == 0) goto L_0x0028
            int r5 = r6.n4
            int r3 = r3.getColorForState(r7, r5)
            goto L_0x0029
        L_0x0028:
            r3 = 0
        L_0x0029:
            int r3 = r6.l(r3)
            int r5 = r6.n4
            if (r5 == r3) goto L_0x0034
            r6.n4 = r3
            r0 = 1
        L_0x0034:
            int r1 = com.google.android.material.color.MaterialColors.s(r1, r3)
            int r3 = r6.o4
            if (r3 == r1) goto L_0x003e
            r3 = 1
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            android.content.res.ColorStateList r5 = r6.z()
            if (r5 != 0) goto L_0x0047
            r5 = 1
            goto L_0x0048
        L_0x0047:
            r5 = 0
        L_0x0048:
            r3 = r3 | r5
            if (r3 == 0) goto L_0x0055
            r6.o4 = r1
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r1)
            r6.p0(r0)
            r0 = 1
        L_0x0055:
            android.content.res.ColorStateList r1 = r6.B3
            if (r1 == 0) goto L_0x0060
            int r3 = r6.p4
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            int r3 = r6.p4
            if (r3 == r1) goto L_0x0068
            r6.p4 = r1
            r0 = 1
        L_0x0068:
            android.content.res.ColorStateList r1 = r6.B4
            if (r1 == 0) goto L_0x007b
            boolean r1 = com.google.android.material.ripple.RippleUtils.f(r7)
            if (r1 == 0) goto L_0x007b
            android.content.res.ColorStateList r1 = r6.B4
            int r3 = r6.q4
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x007c
        L_0x007b:
            r1 = 0
        L_0x007c:
            int r3 = r6.q4
            if (r3 == r1) goto L_0x0087
            r6.q4 = r1
            boolean r1 = r6.A4
            if (r1 == 0) goto L_0x0087
            r0 = 1
        L_0x0087:
            com.google.android.material.internal.TextDrawableHelper r1 = r6.l4
            com.google.android.material.resources.TextAppearance r1 = r1.e()
            if (r1 == 0) goto L_0x00ac
            com.google.android.material.internal.TextDrawableHelper r1 = r6.l4
            com.google.android.material.resources.TextAppearance r1 = r1.e()
            android.content.res.ColorStateList r1 = r1.i()
            if (r1 == 0) goto L_0x00ac
            com.google.android.material.internal.TextDrawableHelper r1 = r6.l4
            com.google.android.material.resources.TextAppearance r1 = r1.e()
            android.content.res.ColorStateList r1 = r1.i()
            int r3 = r6.r4
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x00ad
        L_0x00ac:
            r1 = 0
        L_0x00ad:
            int r3 = r6.r4
            if (r3 == r1) goto L_0x00b4
            r6.r4 = r1
            r0 = 1
        L_0x00b4:
            int[] r1 = r6.getState()
            r3 = 16842912(0x10100a0, float:2.3694006E-38)
            boolean r1 = W1(r1, r3)
            if (r1 == 0) goto L_0x00c7
            boolean r1 = r6.Q3
            if (r1 == 0) goto L_0x00c7
            r1 = 1
            goto L_0x00c8
        L_0x00c7:
            r1 = 0
        L_0x00c8:
            boolean r3 = r6.s4
            if (r3 == r1) goto L_0x00e2
            android.graphics.drawable.Drawable r3 = r6.S3
            if (r3 == 0) goto L_0x00e2
            float r0 = r6.S0()
            r6.s4 = r1
            float r1 = r6.S0()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00e1
            r0 = 1
            r1 = 1
            goto L_0x00e3
        L_0x00e1:
            r0 = 1
        L_0x00e2:
            r1 = 0
        L_0x00e3:
            android.content.res.ColorStateList r3 = r6.x4
            if (r3 == 0) goto L_0x00ee
            int r5 = r6.t4
            int r3 = r3.getColorForState(r7, r5)
            goto L_0x00ef
        L_0x00ee:
            r3 = 0
        L_0x00ef:
            int r5 = r6.t4
            if (r5 == r3) goto L_0x0100
            r6.t4 = r3
            android.content.res.ColorStateList r0 = r6.x4
            android.graphics.PorterDuff$Mode r3 = r6.y4
            android.graphics.PorterDuffColorFilter r0 = com.google.android.material.drawable.DrawableUtils.o(r6, r0, r3)
            r6.w4 = r0
            goto L_0x0101
        L_0x0100:
            r4 = r0
        L_0x0101:
            android.graphics.drawable.Drawable r0 = r6.G3
            boolean r0 = h2(r0)
            if (r0 == 0) goto L_0x0110
            android.graphics.drawable.Drawable r0 = r6.G3
            boolean r0 = r0.setState(r7)
            r4 = r4 | r0
        L_0x0110:
            android.graphics.drawable.Drawable r0 = r6.S3
            boolean r0 = h2(r0)
            if (r0 == 0) goto L_0x011f
            android.graphics.drawable.Drawable r0 = r6.S3
            boolean r0 = r0.setState(r7)
            r4 = r4 | r0
        L_0x011f:
            android.graphics.drawable.Drawable r0 = r6.L3
            boolean r0 = h2(r0)
            if (r0 == 0) goto L_0x013c
            int r0 = r7.length
            int r3 = r8.length
            int r0 = r0 + r3
            int[] r0 = new int[r0]
            int r3 = r7.length
            java.lang.System.arraycopy(r7, r2, r0, r2, r3)
            int r7 = r7.length
            int r3 = r8.length
            java.lang.System.arraycopy(r8, r2, r0, r7, r3)
            android.graphics.drawable.Drawable r7 = r6.L3
            boolean r7 = r7.setState(r0)
            r4 = r4 | r7
        L_0x013c:
            boolean r7 = com.google.android.material.ripple.RippleUtils.f21729a
            if (r7 == 0) goto L_0x014f
            android.graphics.drawable.Drawable r7 = r6.M3
            boolean r7 = h2(r7)
            if (r7 == 0) goto L_0x014f
            android.graphics.drawable.Drawable r7 = r6.M3
            boolean r7 = r7.setState(r8)
            r4 = r4 | r7
        L_0x014f:
            if (r4 == 0) goto L_0x0154
            r6.invalidateSelf()
        L_0x0154:
            if (r1 == 0) goto L_0x0159
            r6.k2()
        L_0x0159:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.l2(int[], int[]):boolean");
    }

    @Nullable
    public CharSequence A1() {
        return this.P3;
    }

    public void A2(float f2) {
        if (this.d4 != f2) {
            this.d4 = f2;
            invalidateSelf();
            k2();
        }
    }

    public void A3(@Nullable TextAppearance textAppearance) {
        this.l4.l(textAppearance, this.e4);
    }

    public float B1() {
        return this.c4;
    }

    public void B2(@DimenRes int i2) {
        A2(this.e4.getResources().getDimension(i2));
    }

    public void B3(@StyleRes int i2) {
        A3(new TextAppearance(this.e4, i2));
    }

    public float C1() {
        return this.O3;
    }

    public void C2(@Nullable Drawable drawable) {
        Drawable r1 = r1();
        if (r1 != drawable) {
            float S0 = S0();
            this.G3 = drawable != null ? DrawableCompat.r(drawable).mutate() : null;
            float S02 = S0();
            P3(r1);
            if (N3()) {
                Q0(this.G3);
            }
            invalidateSelf();
            if (S0 != S02) {
                k2();
            }
        }
    }

    public void C3(@ColorInt int i2) {
        D3(ColorStateList.valueOf(i2));
    }

    public float D1() {
        return this.b4;
    }

    @Deprecated
    public void D2(boolean z) {
        L2(z);
    }

    public void D3(@Nullable ColorStateList colorStateList) {
        TextAppearance R1 = R1();
        if (R1 != null) {
            R1.k(colorStateList);
            invalidateSelf();
        }
    }

    @NonNull
    public int[] E1() {
        return this.z4;
    }

    @Deprecated
    public void E2(@BoolRes int i2) {
        K2(i2);
    }

    public void E3(float f2) {
        if (this.a4 != f2) {
            this.a4 = f2;
            invalidateSelf();
            k2();
        }
    }

    @Nullable
    public ColorStateList F1() {
        return this.N3;
    }

    public void F2(@DrawableRes int i2) {
        C2(AppCompatResources.b(this.e4, i2));
    }

    public void F3(@DimenRes int i2) {
        E3(this.e4.getResources().getDimension(i2));
    }

    public void G1(@NonNull RectF rectF) {
        V0(getBounds(), rectF);
    }

    public void G2(float f2) {
        if (this.I3 != f2) {
            float S0 = S0();
            this.I3 = f2;
            float S02 = S0();
            invalidateSelf();
            if (S0 != S02) {
                k2();
            }
        }
    }

    public void G3(@StringRes int i2) {
        z3(this.e4.getResources().getString(i2));
    }

    public void H2(@DimenRes int i2) {
        G2(this.e4.getResources().getDimension(i2));
    }

    public void H3(@Dimension float f2) {
        TextAppearance R1 = R1();
        if (R1 != null) {
            R1.l(f2);
            this.l4.g().setTextSize(f2);
            a();
        }
    }

    public void I2(@Nullable ColorStateList colorStateList) {
        this.J3 = true;
        if (this.H3 != colorStateList) {
            this.H3 = colorStateList;
            if (N3()) {
                DrawableCompat.o(this.G3, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void I3(float f2) {
        if (this.Z3 != f2) {
            this.Z3 = f2;
            invalidateSelf();
            k2();
        }
    }

    public TextUtils.TruncateAt J1() {
        return this.D4;
    }

    public void J2(@ColorRes int i2) {
        I2(AppCompatResources.a(this.e4, i2));
    }

    public void J3(@DimenRes int i2) {
        I3(this.e4.getResources().getDimension(i2));
    }

    @Nullable
    public MotionSpec K1() {
        return this.V3;
    }

    public void K2(@BoolRes int i2) {
        L2(this.e4.getResources().getBoolean(i2));
    }

    public void K3(boolean z) {
        if (this.A4 != z) {
            this.A4 = z;
            Q3();
            onStateChange(getState());
        }
    }

    public float L1() {
        return this.Y3;
    }

    public void L2(boolean z) {
        if (this.F3 != z) {
            boolean N32 = N3();
            this.F3 = z;
            boolean N33 = N3();
            if (N32 != N33) {
                if (N33) {
                    Q0(this.G3);
                } else {
                    P3(this.G3);
                }
                invalidateSelf();
                k2();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean L3() {
        return this.E4;
    }

    public float M1() {
        return this.X3;
    }

    public void M2(float f2) {
        if (this.z3 != f2) {
            this.z3 = f2;
            invalidateSelf();
            k2();
        }
    }

    @Px
    public int N1() {
        return this.F4;
    }

    public void N2(@DimenRes int i2) {
        M2(this.e4.getResources().getDimension(i2));
    }

    @Nullable
    public ColorStateList O1() {
        return this.D3;
    }

    public void O2(float f2) {
        if (this.W3 != f2) {
            this.W3 = f2;
            invalidateSelf();
            k2();
        }
    }

    @Nullable
    public MotionSpec P1() {
        return this.U3;
    }

    public void P2(@DimenRes int i2) {
        O2(this.e4.getResources().getDimension(i2));
    }

    @Nullable
    public CharSequence Q1() {
        return this.E3;
    }

    public void Q2(@Nullable ColorStateList colorStateList) {
        if (this.B3 != colorStateList) {
            this.B3 = colorStateList;
            if (this.G4) {
                G0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Nullable
    public TextAppearance R1() {
        return this.l4.e();
    }

    public void R2(@ColorRes int i2) {
        Q2(AppCompatResources.a(this.e4, i2));
    }

    /* access modifiers changed from: package-private */
    public float S0() {
        if (N3() || M3()) {
            return this.X3 + I1() + this.Y3;
        }
        return 0.0f;
    }

    public float S1() {
        return this.a4;
    }

    public void S2(float f2) {
        if (this.C3 != f2) {
            this.C3 = f2;
            this.f4.setStrokeWidth(f2);
            if (this.G4) {
                super.J0(f2);
            }
            invalidateSelf();
        }
    }

    public float T1() {
        return this.Z3;
    }

    public void T2(@DimenRes int i2) {
        S2(this.e4.getResources().getDimension(i2));
    }

    public boolean V1() {
        return this.A4;
    }

    public void V2(@Nullable Drawable drawable) {
        Drawable z1 = z1();
        if (z1 != drawable) {
            float W0 = W0();
            this.L3 = drawable != null ? DrawableCompat.r(drawable).mutate() : null;
            if (RippleUtils.f21729a) {
                R3();
            }
            float W02 = W0();
            P3(z1);
            if (O3()) {
                Q0(this.L3);
            }
            invalidateSelf();
            if (W0 != W02) {
                k2();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public float W0() {
        if (O3()) {
            return this.b4 + this.O3 + this.c4;
        }
        return 0.0f;
    }

    public void W2(@Nullable CharSequence charSequence) {
        if (this.P3 != charSequence) {
            this.P3 = BidiFormatter.c().m(charSequence);
            invalidateSelf();
        }
    }

    public boolean X1() {
        return this.Q3;
    }

    @Deprecated
    public void X2(boolean z) {
        k3(z);
    }

    @Deprecated
    public boolean Y1() {
        return Z1();
    }

    @Deprecated
    public void Y2(@BoolRes int i2) {
        j3(i2);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Paint.Align Z0(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.E3 != null) {
            float S0 = this.W3 + S0() + this.Z3;
            if (DrawableCompat.f(this) == 0) {
                pointF.x = ((float) rect.left) + S0;
            } else {
                pointF.x = ((float) rect.right) - S0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = ((float) rect.centerY()) - Y0();
        }
        return align;
    }

    public boolean Z1() {
        return this.R3;
    }

    public void Z2(float f2) {
        if (this.c4 != f2) {
            this.c4 = f2;
            invalidateSelf();
            if (O3()) {
                k2();
            }
        }
    }

    public void a() {
        k2();
        invalidateSelf();
    }

    @Deprecated
    public boolean a2() {
        return b2();
    }

    public void a3(@DimenRes int i2) {
        Z2(this.e4.getResources().getDimension(i2));
    }

    public boolean b2() {
        return this.F3;
    }

    public void b3(@DrawableRes int i2) {
        V2(AppCompatResources.b(this.e4, i2));
    }

    @Deprecated
    public boolean c2() {
        return e2();
    }

    public void c3(float f2) {
        if (this.O3 != f2) {
            this.O3 = f2;
            invalidateSelf();
            if (O3()) {
                k2();
            }
        }
    }

    public boolean d2() {
        return h2(this.L3);
    }

    public void d3(@DimenRes int i2) {
        c3(this.e4.getResources().getDimension(i2));
    }

    public void draw(@NonNull Canvas canvas) {
        int i2;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i3 = this.u4;
            if (i3 < 255) {
                i2 = CanvasCompat.a(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i3);
            } else {
                i2 = 0;
            }
            h1(canvas, bounds);
            e1(canvas, bounds);
            if (this.G4) {
                super.draw(canvas);
            }
            g1(canvas, bounds);
            j1(canvas, bounds);
            f1(canvas, bounds);
            d1(canvas, bounds);
            if (this.E4) {
                l1(canvas, bounds);
            }
            i1(canvas, bounds);
            k1(canvas, bounds);
            if (this.u4 < 255) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public boolean e2() {
        return this.K3;
    }

    public void e3(float f2) {
        if (this.b4 != f2) {
            this.b4 = f2;
            invalidateSelf();
            if (O3()) {
                k2();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f2() {
        return this.G4;
    }

    public void f3(@DimenRes int i2) {
        e3(this.e4.getResources().getDimension(i2));
    }

    public boolean g3(@NonNull int[] iArr) {
        if (Arrays.equals(this.z4, iArr)) {
            return false;
        }
        this.z4 = iArr;
        if (O3()) {
            return l2(getState(), iArr);
        }
        return false;
    }

    public int getAlpha() {
        return this.u4;
    }

    @Nullable
    public ColorFilter getColorFilter() {
        return this.v4;
    }

    public int getIntrinsicHeight() {
        return (int) this.z3;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.W3 + S0() + this.Z3 + this.l4.h(Q1().toString()) + this.a4 + W0() + this.d4), this.F4);
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.G4) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.A3);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.A3);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public void h3(@Nullable ColorStateList colorStateList) {
        if (this.N3 != colorStateList) {
            this.N3 = colorStateList;
            if (O3()) {
                DrawableCompat.o(this.L3, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void i3(@ColorRes int i2) {
        h3(AppCompatResources.a(this.e4, i2));
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isStateful() {
        return g2(this.x3) || g2(this.y3) || g2(this.B3) || (this.A4 && g2(this.B4)) || i2(this.l4.e()) || a1() || h2(this.G3) || h2(this.S3) || g2(this.x4);
    }

    public void j3(@BoolRes int i2) {
        k3(this.e4.getResources().getBoolean(i2));
    }

    /* access modifiers changed from: protected */
    public void k2() {
        Delegate delegate = this.C4.get();
        if (delegate != null) {
            delegate.a();
        }
    }

    public void k3(boolean z) {
        if (this.K3 != z) {
            boolean O32 = O3();
            this.K3 = z;
            boolean O33 = O3();
            if (O32 != O33) {
                if (O33) {
                    Q0(this.L3);
                } else {
                    P3(this.L3);
                }
                invalidateSelf();
                k2();
            }
        }
    }

    public void l3(@Nullable Delegate delegate) {
        this.C4 = new WeakReference<>(delegate);
    }

    @Nullable
    public Drawable m1() {
        return this.S3;
    }

    public void m2(boolean z) {
        if (this.Q3 != z) {
            this.Q3 = z;
            float S0 = S0();
            if (!z && this.s4) {
                this.s4 = false;
            }
            float S02 = S0();
            invalidateSelf();
            if (S0 != S02) {
                k2();
            }
        }
    }

    public void m3(@Nullable TextUtils.TruncateAt truncateAt) {
        this.D4 = truncateAt;
    }

    @Nullable
    public ColorStateList n1() {
        return this.T3;
    }

    public void n2(@BoolRes int i2) {
        m2(this.e4.getResources().getBoolean(i2));
    }

    public void n3(@Nullable MotionSpec motionSpec) {
        this.V3 = motionSpec;
    }

    @Nullable
    public ColorStateList o1() {
        return this.y3;
    }

    public void o2(@Nullable Drawable drawable) {
        if (this.S3 != drawable) {
            float S0 = S0();
            this.S3 = drawable;
            float S02 = S0();
            P3(this.S3);
            Q0(this.S3);
            invalidateSelf();
            if (S0 != S02) {
                k2();
            }
        }
    }

    public void o3(@AnimatorRes int i2) {
        n3(MotionSpec.d(this.e4, i2));
    }

    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (N3()) {
            onLayoutDirectionChanged |= DrawableCompat.m(this.G3, i2);
        }
        if (M3()) {
            onLayoutDirectionChanged |= DrawableCompat.m(this.S3, i2);
        }
        if (O3()) {
            onLayoutDirectionChanged |= DrawableCompat.m(this.L3, i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (N3()) {
            onLevelChange |= this.G3.setLevel(i2);
        }
        if (M3()) {
            onLevelChange |= this.S3.setLevel(i2);
        }
        if (O3()) {
            onLevelChange |= this.L3.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.G4) {
            super.onStateChange(iArr);
        }
        return l2(iArr, E1());
    }

    public float p1() {
        return this.G4 ? T() : this.A3;
    }

    @Deprecated
    public void p2(boolean z) {
        v2(z);
    }

    public void p3(float f2) {
        if (this.Y3 != f2) {
            float S0 = S0();
            this.Y3 = f2;
            float S02 = S0();
            invalidateSelf();
            if (S0 != S02) {
                k2();
            }
        }
    }

    public float q1() {
        return this.d4;
    }

    @Deprecated
    public void q2(@BoolRes int i2) {
        v2(this.e4.getResources().getBoolean(i2));
    }

    public void q3(@DimenRes int i2) {
        p3(this.e4.getResources().getDimension(i2));
    }

    @Nullable
    public Drawable r1() {
        Drawable drawable = this.G3;
        if (drawable != null) {
            return DrawableCompat.q(drawable);
        }
        return null;
    }

    public void r2(@DrawableRes int i2) {
        o2(AppCompatResources.b(this.e4, i2));
    }

    public void r3(float f2) {
        if (this.X3 != f2) {
            float S0 = S0();
            this.X3 = f2;
            float S02 = S0();
            invalidateSelf();
            if (S0 != S02) {
                k2();
            }
        }
    }

    public float s1() {
        return this.I3;
    }

    public void s2(@Nullable ColorStateList colorStateList) {
        if (this.T3 != colorStateList) {
            this.T3 = colorStateList;
            if (a1()) {
                DrawableCompat.o(this.S3, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void s3(@DimenRes int i2) {
        r3(this.e4.getResources().getDimension(i2));
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (this.u4 != i2) {
            this.u4 = i2;
            invalidateSelf();
        }
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.v4 != colorFilter) {
            this.v4 = colorFilter;
            invalidateSelf();
        }
    }

    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.x4 != colorStateList) {
            this.x4 = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.y4 != mode) {
            this.y4 = mode;
            this.w4 = DrawableUtils.o(this, this.x4, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (N3()) {
            visible |= this.G3.setVisible(z, z2);
        }
        if (M3()) {
            visible |= this.S3.setVisible(z, z2);
        }
        if (O3()) {
            visible |= this.L3.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Nullable
    public ColorStateList t1() {
        return this.H3;
    }

    public void t2(@ColorRes int i2) {
        s2(AppCompatResources.a(this.e4, i2));
    }

    public void t3(@Px int i2) {
        this.F4 = i2;
    }

    public float u1() {
        return this.z3;
    }

    public void u2(@BoolRes int i2) {
        v2(this.e4.getResources().getBoolean(i2));
    }

    public void u3(@Nullable ColorStateList colorStateList) {
        if (this.D3 != colorStateList) {
            this.D3 = colorStateList;
            Q3();
            onStateChange(getState());
        }
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public float v1() {
        return this.W3;
    }

    public void v2(boolean z) {
        if (this.R3 != z) {
            boolean M32 = M3();
            this.R3 = z;
            boolean M33 = M3();
            if (M32 != M33) {
                if (M33) {
                    Q0(this.S3);
                } else {
                    P3(this.S3);
                }
                invalidateSelf();
                k2();
            }
        }
    }

    public void v3(@ColorRes int i2) {
        u3(AppCompatResources.a(this.e4, i2));
    }

    @Nullable
    public ColorStateList w1() {
        return this.B3;
    }

    public void w2(@Nullable ColorStateList colorStateList) {
        if (this.y3 != colorStateList) {
            this.y3 = colorStateList;
            onStateChange(getState());
        }
    }

    /* access modifiers changed from: package-private */
    public void w3(boolean z) {
        this.E4 = z;
    }

    public float x1() {
        return this.C3;
    }

    public void x2(@ColorRes int i2) {
        w2(AppCompatResources.a(this.e4, i2));
    }

    public void x3(@Nullable MotionSpec motionSpec) {
        this.U3 = motionSpec;
    }

    public void y1(@NonNull RectF rectF) {
        T0(getBounds(), rectF);
    }

    @Deprecated
    public void y2(float f2) {
        if (this.A3 != f2) {
            this.A3 = f2;
            setShapeAppearanceModel(getShapeAppearanceModel().w(f2));
        }
    }

    public void y3(@AnimatorRes int i2) {
        x3(MotionSpec.d(this.e4, i2));
    }

    @Nullable
    public Drawable z1() {
        Drawable drawable = this.L3;
        if (drawable != null) {
            return DrawableCompat.q(drawable);
        }
        return null;
    }

    @Deprecated
    public void z2(@DimenRes int i2) {
        y2(this.e4.getResources().getDimension(i2));
    }

    public void z3(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.E3, charSequence)) {
            this.E3 = charSequence;
            this.l4.n(true);
            invalidateSelf();
            k2();
        }
    }
}
