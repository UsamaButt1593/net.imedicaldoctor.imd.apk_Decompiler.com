package com.google.android.material.materialswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;

public class MaterialSwitch extends SwitchCompat {
    private static final int l4 = R.style.ig;
    private static final int[] m4 = {R.attr.hh};
    @Nullable
    private Drawable Y3;
    @Nullable
    private Drawable Z3;
    @Px
    private int a4;
    @Nullable
    private Drawable b4;
    @Nullable
    private Drawable c4;
    @Nullable
    private ColorStateList d4;
    @Nullable
    private ColorStateList e4;
    @NonNull
    private PorterDuff.Mode f4;
    @Nullable
    private ColorStateList g4;
    @Nullable
    private ColorStateList h4;
    @NonNull
    private PorterDuff.Mode i4;
    private int[] j4;
    private int[] k4;

    public MaterialSwitch(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void s() {
        this.Y3 = DrawableUtils.c(this.Y3, this.d4, getThumbTintMode());
        this.Z3 = DrawableUtils.c(this.Z3, this.e4, this.f4);
        v();
        Drawable drawable = this.Y3;
        Drawable drawable2 = this.Z3;
        int i2 = this.a4;
        super.setThumbDrawable(DrawableUtils.b(drawable, drawable2, i2, i2));
        refreshDrawableState();
    }

    private void t() {
        this.b4 = DrawableUtils.c(this.b4, this.g4, getTrackTintMode());
        this.c4 = DrawableUtils.c(this.c4, this.h4, this.i4);
        v();
        Drawable drawable = this.b4;
        if (drawable != null && this.c4 != null) {
            drawable = new LayerDrawable(new Drawable[]{this.b4, this.c4});
        } else if (drawable == null) {
            drawable = this.c4;
        }
        if (drawable != null) {
            setSwitchMinWidth(drawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(drawable);
    }

    private static void u(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @NonNull int[] iArr, @NonNull int[] iArr2, float f2) {
        if (drawable != null && colorStateList != null) {
            DrawableCompat.n(drawable, ColorUtils.j(colorStateList.getColorForState(iArr, 0), colorStateList.getColorForState(iArr2, 0), f2));
        }
    }

    private void v() {
        if (this.d4 != null || this.e4 != null || this.g4 != null || this.h4 != null) {
            float thumbPosition = getThumbPosition();
            ColorStateList colorStateList = this.d4;
            if (colorStateList != null) {
                u(this.Y3, colorStateList, this.j4, this.k4, thumbPosition);
            }
            ColorStateList colorStateList2 = this.e4;
            if (colorStateList2 != null) {
                u(this.Z3, colorStateList2, this.j4, this.k4, thumbPosition);
            }
            ColorStateList colorStateList3 = this.g4;
            if (colorStateList3 != null) {
                u(this.b4, colorStateList3, this.j4, this.k4, thumbPosition);
            }
            ColorStateList colorStateList4 = this.h4;
            if (colorStateList4 != null) {
                u(this.c4, colorStateList4, this.j4, this.k4, thumbPosition);
            }
        }
    }

    @Nullable
    public Drawable getThumbDrawable() {
        return this.Y3;
    }

    @Nullable
    public Drawable getThumbIconDrawable() {
        return this.Z3;
    }

    @Px
    public int getThumbIconSize() {
        return this.a4;
    }

    @Nullable
    public ColorStateList getThumbIconTintList() {
        return this.e4;
    }

    @NonNull
    public PorterDuff.Mode getThumbIconTintMode() {
        return this.f4;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.d4;
    }

    @Nullable
    public Drawable getTrackDecorationDrawable() {
        return this.c4;
    }

    @Nullable
    public ColorStateList getTrackDecorationTintList() {
        return this.h4;
    }

    @NonNull
    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.i4;
    }

    @Nullable
    public Drawable getTrackDrawable() {
        return this.b4;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.g4;
    }

    public void invalidate() {
        v();
        super.invalidate();
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (this.Z3 != null) {
            View.mergeDrawableStates(onCreateDrawableState, m4);
        }
        this.j4 = DrawableUtils.j(onCreateDrawableState);
        this.k4 = DrawableUtils.f(onCreateDrawableState);
        return onCreateDrawableState;
    }

    public void setThumbDrawable(@Nullable Drawable drawable) {
        this.Y3 = drawable;
        s();
    }

    public void setThumbIconDrawable(@Nullable Drawable drawable) {
        this.Z3 = drawable;
        s();
    }

    public void setThumbIconResource(@DrawableRes int i2) {
        setThumbIconDrawable(AppCompatResources.b(getContext(), i2));
    }

    public void setThumbIconSize(@Px int i2) {
        if (this.a4 != i2) {
            this.a4 = i2;
            s();
        }
    }

    public void setThumbIconTintList(@Nullable ColorStateList colorStateList) {
        this.e4 = colorStateList;
        s();
    }

    public void setThumbIconTintMode(@NonNull PorterDuff.Mode mode) {
        this.f4 = mode;
        s();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.d4 = colorStateList;
        s();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        s();
    }

    public void setTrackDecorationDrawable(@Nullable Drawable drawable) {
        this.c4 = drawable;
        t();
    }

    public void setTrackDecorationResource(@DrawableRes int i2) {
        setTrackDecorationDrawable(AppCompatResources.b(getContext(), i2));
    }

    public void setTrackDecorationTintList(@Nullable ColorStateList colorStateList) {
        this.h4 = colorStateList;
        t();
    }

    public void setTrackDecorationTintMode(@NonNull PorterDuff.Mode mode) {
        this.i4 = mode;
        t();
    }

    public void setTrackDrawable(@Nullable Drawable drawable) {
        this.b4 = drawable;
        t();
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.g4 = colorStateList;
        t();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        t();
    }

    public MaterialSwitch(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Vc);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialSwitch(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = l4
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            r8 = -1
            r7.a4 = r8
            android.content.Context r0 = r7.getContext()
            android.graphics.drawable.Drawable r1 = super.getThumbDrawable()
            r7.Y3 = r1
            android.content.res.ColorStateList r1 = super.getThumbTintList()
            r7.d4 = r1
            r1 = 0
            super.setThumbTintList(r1)
            android.graphics.drawable.Drawable r2 = super.getTrackDrawable()
            r7.b4 = r2
            android.content.res.ColorStateList r2 = super.getTrackTintList()
            r7.g4 = r2
            super.setTrackTintList(r1)
            int[] r2 = com.google.android.material.R.styleable.Rn
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            androidx.appcompat.widget.TintTypedArray r9 = com.google.android.material.internal.ThemeEnforcement.l(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.Sn
            android.graphics.drawable.Drawable r10 = r9.h(r10)
            r7.Z3 = r10
            int r10 = com.google.android.material.R.styleable.Tn
            int r10 = r9.g(r10, r8)
            r7.a4 = r10
            int r10 = com.google.android.material.R.styleable.Un
            android.content.res.ColorStateList r10 = r9.d(r10)
            r7.e4 = r10
            int r10 = com.google.android.material.R.styleable.Vn
            int r10 = r9.o(r10, r8)
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r10 = com.google.android.material.internal.ViewUtils.u(r10, r0)
            r7.f4 = r10
            int r10 = com.google.android.material.R.styleable.Wn
            android.graphics.drawable.Drawable r10 = r9.h(r10)
            r7.c4 = r10
            int r10 = com.google.android.material.R.styleable.Xn
            android.content.res.ColorStateList r10 = r9.d(r10)
            r7.h4 = r10
            int r10 = com.google.android.material.R.styleable.Yn
            int r8 = r9.o(r10, r8)
            android.graphics.PorterDuff$Mode r8 = com.google.android.material.internal.ViewUtils.u(r8, r0)
            r7.i4 = r8
            r9.I()
            r7.setEnforceSwitchWidth(r6)
            r7.s()
            r7.t()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.materialswitch.MaterialSwitch.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
