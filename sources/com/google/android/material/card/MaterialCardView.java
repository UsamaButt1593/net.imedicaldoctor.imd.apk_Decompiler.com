package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MaterialCardView extends CardView implements Checkable, Shapeable {
    private static final int[] k3 = {16842911};
    private static final int[] l3 = {16842912};
    private static final int[] m3 = {R.attr.ch};
    private static final int n3 = R.style.Si;
    private static final String o3 = "MaterialCardView";
    private static final String p3 = "androidx.cardview.widget.CardView";
    public static final int q3 = 8388659;
    public static final int r3 = 8388691;
    public static final int s3 = 8388661;
    public static final int t3 = 8388693;
    @NonNull
    private final MaterialCardViewHelper f3;
    private boolean g3;
    private boolean h3;
    private boolean i3;
    private OnCheckedChangeListener j3;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckedIconGravity {
    }

    public interface OnCheckedChangeListener {
        void a(MaterialCardView materialCardView, boolean z);
    }

    public MaterialCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f3.l().getBounds());
        return rectF;
    }

    private void j() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f3.k();
        }
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f3.m();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f3.n();
    }

    /* access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.f3.o();
    }

    public int getCheckedIconGravity() {
        return this.f3.p();
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.f3.q();
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.f3.r();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.f3.s();
    }

    public int getContentPaddingBottom() {
        return this.f3.C().bottom;
    }

    public int getContentPaddingLeft() {
        return this.f3.C().left;
    }

    public int getContentPaddingRight() {
        return this.f3.C().right;
    }

    public int getContentPaddingTop() {
        return this.f3.C().top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f3.w();
    }

    public float getRadius() {
        return this.f3.u();
    }

    public ColorStateList getRippleColor() {
        return this.f3.x();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f3.y();
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        return this.f3.z();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.f3.A();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.f3.B();
    }

    public void h(int i2, int i4, int i5, int i6) {
        this.f3.c0(i2, i4, i5, i6);
    }

    public boolean isChecked() {
        return this.h3;
    }

    public boolean k() {
        MaterialCardViewHelper materialCardViewHelper = this.f3;
        return materialCardViewHelper != null && materialCardViewHelper.F();
    }

    public boolean l() {
        return this.i3;
    }

    /* access modifiers changed from: package-private */
    public void m(int i2, int i4, int i5, int i6) {
        super.h(i2, i4, i5, i6);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3.g0();
        MaterialShapeUtils.f(this, this.f3.l());
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (k()) {
            View.mergeDrawableStates(onCreateDrawableState, k3);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, l3);
        }
        if (l()) {
            View.mergeDrawableStates(onCreateDrawableState, m3);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(p3);
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(p3);
        accessibilityNodeInfo.setCheckable(k());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        this.f3.K(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.g3) {
            if (!this.f3.E()) {
                Log.i(o3, "Setting a custom background is not supported.");
                this.f3.L(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setCardBackgroundColor(@ColorInt int i2) {
        this.f3.M(ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.f3.i0();
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        this.f3.N(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f3.O(z);
    }

    public void setChecked(boolean z) {
        if (this.h3 != z) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.f3.R(drawable);
    }

    public void setCheckedIconGravity(int i2) {
        if (this.f3.p() != i2) {
            this.f3.S(i2);
        }
    }

    public void setCheckedIconMargin(@Dimension int i2) {
        this.f3.T(i2);
    }

    public void setCheckedIconMarginResource(@DimenRes int i2) {
        if (i2 != -1) {
            this.f3.T(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        this.f3.R(AppCompatResources.b(getContext(), i2));
    }

    public void setCheckedIconSize(@Dimension int i2) {
        this.f3.U(i2);
    }

    public void setCheckedIconSizeResource(@DimenRes int i2) {
        if (i2 != 0) {
            this.f3.U(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.f3.V(colorStateList);
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        MaterialCardViewHelper materialCardViewHelper = this.f3;
        if (materialCardViewHelper != null) {
            materialCardViewHelper.g0();
        }
    }

    public void setDragged(boolean z) {
        if (this.i3 != z) {
            this.i3 = z;
            refreshDrawableState();
            j();
            invalidate();
        }
    }

    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f3.k0();
    }

    public void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener) {
        this.j3 = onCheckedChangeListener;
    }

    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f3.k0();
        this.f3.h0();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f3.X(f2);
    }

    public void setRadius(float f2) {
        super.setRadius(f2);
        this.f3.W(f2);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.f3.Y(colorStateList);
    }

    public void setRippleColorResource(@ColorRes int i2) {
        this.f3.Y(AppCompatResources.a(getContext(), i2));
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        setClipToOutline(shapeAppearanceModel.u(getBoundsAsRectF()));
        this.f3.Z(shapeAppearanceModel);
    }

    public void setStrokeColor(@ColorInt int i2) {
        setStrokeColor(ColorStateList.valueOf(i2));
    }

    public void setStrokeWidth(@Dimension int i2) {
        this.f3.b0(i2);
        invalidate();
    }

    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f3.k0();
        this.f3.h0();
    }

    public void toggle() {
        if (k() && isEnabled()) {
            this.h3 = !this.h3;
            refreshDrawableState();
            j();
            this.f3.Q(this.h3, true);
            OnCheckedChangeListener onCheckedChangeListener = this.j3;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.a(this, this.h3);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Gc);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.f3.M(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f3.a0(colorStateList);
        invalidate();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r6 = n3
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r8, r9, r10, r6)
            r7.<init>(r8, r9, r10)
            r8 = 0
            r7.h3 = r8
            r7.i3 = r8
            r0 = 1
            r7.g3 = r0
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.cn
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            r4 = r6
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            com.google.android.material.card.MaterialCardViewHelper r0 = new com.google.android.material.card.MaterialCardViewHelper
            r0.<init>(r7, r9, r10, r6)
            r7.f3 = r0
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r0.M(r9)
            int r9 = super.getContentPaddingLeft()
            int r10 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r2 = super.getContentPaddingBottom()
            r0.c0(r9, r10, r1, r2)
            r0.J(r8)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
