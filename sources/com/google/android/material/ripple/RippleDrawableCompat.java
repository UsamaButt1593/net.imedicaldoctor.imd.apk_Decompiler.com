package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleDrawableCompat extends Drawable implements Shapeable, TintAwareDrawable {
    private RippleDrawableCompatState s;

    static final class RippleDrawableCompatState extends Drawable.ConstantState {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        MaterialShapeDrawable f21727a;

        /* renamed from: b  reason: collision with root package name */
        boolean f21728b;

        public RippleDrawableCompatState(@NonNull RippleDrawableCompatState rippleDrawableCompatState) {
            this.f21727a = (MaterialShapeDrawable) rippleDrawableCompatState.f21727a.getConstantState().newDrawable();
            this.f21728b = rippleDrawableCompatState.f21728b;
        }

        @NonNull
        /* renamed from: a */
        public RippleDrawableCompat newDrawable() {
            return new RippleDrawableCompat(new RippleDrawableCompatState(this));
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public RippleDrawableCompatState(MaterialShapeDrawable materialShapeDrawable) {
            this.f21727a = materialShapeDrawable;
            this.f21728b = false;
        }
    }

    private RippleDrawableCompat(RippleDrawableCompatState rippleDrawableCompatState) {
        this.s = rippleDrawableCompatState;
    }

    @NonNull
    /* renamed from: a */
    public RippleDrawableCompat mutate() {
        this.s = new RippleDrawableCompatState(this.s);
        return this;
    }

    public void draw(Canvas canvas) {
        RippleDrawableCompatState rippleDrawableCompatState = this.s;
        if (rippleDrawableCompatState.f21728b) {
            rippleDrawableCompatState.f21727a.draw(canvas);
        }
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.s;
    }

    public int getOpacity() {
        return this.s.f21727a.getOpacity();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.s.f21727a.getShapeAppearanceModel();
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.s.f21727a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.s.f21727a.setState(iArr)) {
            onStateChange = true;
        }
        boolean f2 = RippleUtils.f(iArr);
        RippleDrawableCompatState rippleDrawableCompatState = this.s;
        if (rippleDrawableCompatState.f21728b == f2) {
            return onStateChange;
        }
        rippleDrawableCompatState.f21728b = f2;
        return true;
    }

    public void setAlpha(int i2) {
        this.s.f21727a.setAlpha(i2);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.s.f21727a.setColorFilter(colorFilter);
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.s.f21727a.setShapeAppearanceModel(shapeAppearanceModel);
    }

    public void setTint(@ColorInt int i2) {
        this.s.f21727a.setTint(i2);
    }

    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.s.f21727a.setTintList(colorStateList);
    }

    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.s.f21727a.setTintMode(mode);
    }

    public RippleDrawableCompat(ShapeAppearanceModel shapeAppearanceModel) {
        this(new RippleDrawableCompatState(new MaterialShapeDrawable(shapeAppearanceModel)));
    }
}
