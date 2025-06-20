package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {
    @StyleRes
    private static final int P3 = R.style.Gk;
    @AttrRes
    private static final int Q3 = R.attr.lk;
    @NonNull
    private final TextDrawableHelper A3;
    @NonNull
    private final View.OnLayoutChangeListener B3;
    @NonNull
    private final Rect C3;
    private int D3;
    private int E3;
    private int F3;
    private int G3;
    private boolean H3;
    private int I3;
    private int J3;
    private float K3;
    private float L3;
    private final float M3;
    private float N3;
    private float O3;
    @Nullable
    private CharSequence x3;
    @NonNull
    private final Context y3;
    @Nullable
    private final Paint.FontMetrics z3 = new Paint.FontMetrics();

    private TooltipDrawable(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.A3 = textDrawableHelper;
        this.B3 = new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                TooltipDrawable.this.s1(view);
            }
        };
        this.C3 = new Rect();
        this.K3 = 1.0f;
        this.L3 = 1.0f;
        this.M3 = 0.5f;
        this.N3 = 0.5f;
        this.O3 = 1.0f;
        this.y3 = context;
        textDrawableHelper.g().density = context.getResources().getDisplayMetrics().density;
        textDrawableHelper.g().setTextAlign(Paint.Align.CENTER);
    }

    private float R0() {
        int i2;
        if (((this.C3.right - getBounds().right) - this.J3) - this.G3 < 0) {
            i2 = ((this.C3.right - getBounds().right) - this.J3) - this.G3;
        } else if (((this.C3.left - getBounds().left) - this.J3) + this.G3 <= 0) {
            return 0.0f;
        } else {
            i2 = ((this.C3.left - getBounds().left) - this.J3) + this.G3;
        }
        return (float) i2;
    }

    private float S0() {
        this.A3.g().getFontMetrics(this.z3);
        Paint.FontMetrics fontMetrics = this.z3;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float T0(@NonNull Rect rect) {
        return ((float) rect.centerY()) - S0();
    }

    @NonNull
    public static TooltipDrawable U0(@NonNull Context context) {
        return W0(context, (AttributeSet) null, Q3, P3);
    }

    @NonNull
    public static TooltipDrawable V0(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        return W0(context, attributeSet, Q3, P3);
    }

    @NonNull
    public static TooltipDrawable W0(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TooltipDrawable tooltipDrawable = new TooltipDrawable(context, attributeSet, i2, i3);
        tooltipDrawable.h1(attributeSet, i2, i3);
        return tooltipDrawable;
    }

    private EdgeTreatment X0() {
        float width = ((float) (((double) getBounds().width()) - (((double) this.I3) * Math.sqrt(2.0d)))) / 2.0f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment((float) this.I3), Math.min(Math.max(-R0(), -width), width));
    }

    private void Z0(@NonNull Canvas canvas) {
        if (this.x3 != null) {
            Rect bounds = getBounds();
            int T0 = (int) T0(bounds);
            if (this.A3.e() != null) {
                this.A3.g().drawableState = getState();
                this.A3.o(this.y3);
                this.A3.g().setAlpha((int) (this.O3 * 255.0f));
            }
            CharSequence charSequence = this.x3;
            canvas.drawText(charSequence, 0, charSequence.length(), (float) bounds.centerX(), (float) T0, this.A3.g());
        }
    }

    private float g1() {
        CharSequence charSequence = this.x3;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.A3.h(charSequence.toString());
    }

    private void h1(@Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray k2 = ThemeEnforcement.k(this.y3, attributeSet, R.styleable.zy, i2, i3, new int[0]);
        this.I3 = this.y3.getResources().getDimensionPixelSize(R.dimen.Ud);
        boolean z = k2.getBoolean(R.styleable.Iy, true);
        this.H3 = z;
        if (z) {
            setShapeAppearanceModel(getShapeAppearanceModel().v().t(X0()).m());
        } else {
            this.I3 = 0;
        }
        n1(k2.getText(R.styleable.Gy));
        TextAppearance h2 = MaterialResources.h(this.y3, k2, R.styleable.Ay);
        if (h2 != null) {
            int i4 = R.styleable.By;
            if (k2.hasValue(i4)) {
                h2.k(MaterialResources.a(this.y3, k2, i4));
            }
        }
        o1(h2);
        Class<TooltipDrawable> cls = TooltipDrawable.class;
        p0(ColorStateList.valueOf(k2.getColor(R.styleable.Hy, MaterialColors.s(ColorUtils.D(MaterialColors.c(this.y3, 16842801, cls.getCanonicalName()), 229), ColorUtils.D(MaterialColors.c(this.y3, R.attr.u3, cls.getCanonicalName()), 153)))));
        G0(ColorStateList.valueOf(MaterialColors.c(this.y3, R.attr.e4, cls.getCanonicalName())));
        this.D3 = k2.getDimensionPixelSize(R.styleable.Cy, 0);
        this.E3 = k2.getDimensionPixelSize(R.styleable.Ey, 0);
        this.F3 = k2.getDimensionPixelSize(R.styleable.Fy, 0);
        this.G3 = k2.getDimensionPixelSize(R.styleable.Dy, 0);
        k2.recycle();
    }

    /* access modifiers changed from: private */
    public void s1(@NonNull View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.J3 = iArr[0];
        view.getWindowVisibleDisplayFrame(this.C3);
    }

    public void Y0(@Nullable View view) {
        if (view != null) {
            view.removeOnLayoutChangeListener(this.B3);
        }
    }

    public void a() {
        invalidateSelf();
    }

    public int a1() {
        return this.G3;
    }

    public int b1() {
        return this.F3;
    }

    public int c1() {
        return this.E3;
    }

    @Nullable
    public CharSequence d1() {
        return this.x3;
    }

    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.scale(this.K3, this.L3, ((float) getBounds().left) + (((float) getBounds().width()) * 0.5f), ((float) getBounds().top) + (((float) getBounds().height()) * this.N3));
        canvas.translate(R0(), (float) (-((((double) this.I3) * Math.sqrt(2.0d)) - ((double) this.I3))));
        super.draw(canvas);
        Z0(canvas);
        canvas.restore();
    }

    @Nullable
    public TextAppearance e1() {
        return this.A3.e();
    }

    public int f1() {
        return this.D3;
    }

    public int getIntrinsicHeight() {
        return (int) Math.max(this.A3.g().getTextSize(), (float) this.F3);
    }

    public int getIntrinsicWidth() {
        return (int) Math.max(((float) (this.D3 * 2)) + g1(), (float) this.E3);
    }

    public void i1(@Px int i2) {
        this.G3 = i2;
        invalidateSelf();
    }

    public void j1(@Px int i2) {
        this.F3 = i2;
        invalidateSelf();
    }

    public void k1(@Px int i2) {
        this.E3 = i2;
        invalidateSelf();
    }

    public void l1(@Nullable View view) {
        if (view != null) {
            s1(view);
            view.addOnLayoutChangeListener(this.B3);
        }
    }

    public void m1(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.N3 = 1.2f;
        this.K3 = f2;
        this.L3 = f2;
        this.O3 = AnimationUtils.b(0.0f, 1.0f, 0.19f, 1.0f, f2);
        invalidateSelf();
    }

    public void n1(@Nullable CharSequence charSequence) {
        if (!TextUtils.equals(this.x3, charSequence)) {
            this.x3 = charSequence;
            this.A3.n(true);
            invalidateSelf();
        }
    }

    public void o1(@Nullable TextAppearance textAppearance) {
        this.A3.l(textAppearance, this.y3);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.H3) {
            setShapeAppearanceModel(getShapeAppearanceModel().v().t(X0()).m());
        }
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void p1(@StyleRes int i2) {
        o1(new TextAppearance(this.y3, i2));
    }

    public void q1(@Px int i2) {
        this.D3 = i2;
        invalidateSelf();
    }

    public void r1(@StringRes int i2) {
        n1(this.y3.getResources().getString(i2));
    }
}
