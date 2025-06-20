package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;

public class MaterialDivider extends View {
    private static final int b3 = R.style.Lj;
    private int X2;
    @ColorInt
    private int Y2;
    private int Z2;
    private int a3;
    @NonNull
    private final MaterialShapeDrawable s;

    public MaterialDivider(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public int getDividerColor() {
        return this.Y2;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.a3;
    }

    @Px
    public int getDividerInsetStart() {
        return this.Z2;
    }

    public int getDividerThickness() {
        return this.X2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        int width;
        int i2;
        super.onDraw(canvas);
        boolean z = true;
        if (ViewCompat.c0(this) != 1) {
            z = false;
        }
        int i3 = z ? this.a3 : this.Z2;
        if (z) {
            width = getWidth();
            i2 = this.Z2;
        } else {
            width = getWidth();
            i2 = this.a3;
        }
        this.s.setBounds(i3, 0, width - i2, getBottom() - getTop());
        this.s.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i4 = this.X2;
            if (i4 > 0 && measuredHeight != i4) {
                measuredHeight = i4;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@ColorInt int i2) {
        if (this.Y2 != i2) {
            this.Y2 = i2;
            this.s.p0(ColorStateList.valueOf(i2));
            invalidate();
        }
    }

    public void setDividerColorResource(@ColorRes int i2) {
        setDividerColor(ContextCompat.g(getContext(), i2));
    }

    public void setDividerInsetEnd(@Px int i2) {
        this.a3 = i2;
    }

    public void setDividerInsetEndResource(@DimenRes int i2) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i2));
    }

    public void setDividerInsetStart(@Px int i2) {
        this.Z2 = i2;
    }

    public void setDividerInsetStartResource(@DimenRes int i2) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i2));
    }

    public void setDividerThickness(@Px int i2) {
        if (this.X2 != i2) {
            this.X2 = i2;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@DimenRes int i2) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i2));
    }

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Lc);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialDivider(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = b3
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            com.google.android.material.shape.MaterialShapeDrawable r0 = new com.google.android.material.shape.MaterialShapeDrawable
            r0.<init>()
            r7.s = r0
            int[] r2 = com.google.android.material.R.styleable.Fn
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.Jn
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.R.dimen.Q9
            int r0 = r0.getDimensionPixelSize(r1)
            int r10 = r9.getDimensionPixelSize(r10, r0)
            r7.X2 = r10
            int r10 = com.google.android.material.R.styleable.In
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.Z2 = r10
            int r10 = com.google.android.material.R.styleable.Hn
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            r7.a3 = r10
            int r10 = com.google.android.material.R.styleable.Gn
            android.content.res.ColorStateList r8 = com.google.android.material.resources.MaterialResources.a(r8, r9, r10)
            int r8 = r8.getDefaultColor()
            r7.setDividerColor(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.divider.MaterialDivider.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
