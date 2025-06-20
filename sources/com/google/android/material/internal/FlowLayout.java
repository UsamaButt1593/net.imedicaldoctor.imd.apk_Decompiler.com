package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FlowLayout extends ViewGroup {
    private int X2;
    private boolean Y2;
    private int Z2;
    private int s;

    public FlowLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static int a(int i2, int i3, int i4) {
        if (i3 != Integer.MIN_VALUE) {
            return i3 != 1073741824 ? i4 : i2;
        }
        return Math.min(i4, i2);
    }

    private void d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.Fg, 0, 0);
        this.s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Hg, 0);
        this.X2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Gg, 0);
        obtainStyledAttributes.recycle();
    }

    public int b(@NonNull View view) {
        Object tag = view.getTag(R.id.H4);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    public boolean c() {
        return this.Y2;
    }

    /* access modifiers changed from: protected */
    public int getItemSpacing() {
        return this.X2;
    }

    /* access modifiers changed from: protected */
    public int getLineSpacing() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    public int getRowCount() {
        return this.Z2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (getChildCount() == 0) {
            this.Z2 = 0;
            return;
        }
        this.Z2 = 1;
        boolean z2 = ViewCompat.c0(this) == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i8 = (i4 - i2) - paddingLeft;
        int i9 = paddingRight;
        int i10 = paddingTop;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.H4, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i6 = MarginLayoutParamsCompat.c(marginLayoutParams);
                    i7 = MarginLayoutParamsCompat.b(marginLayoutParams);
                } else {
                    i7 = 0;
                    i6 = 0;
                }
                int measuredWidth = i9 + i6 + childAt.getMeasuredWidth();
                if (!this.Y2 && measuredWidth > i8) {
                    i10 = this.s + paddingTop;
                    this.Z2++;
                    i9 = paddingRight;
                }
                childAt.setTag(R.id.H4, Integer.valueOf(this.Z2 - 1));
                int i12 = i9 + i6;
                int measuredWidth2 = childAt.getMeasuredWidth() + i12;
                int measuredHeight = childAt.getMeasuredHeight() + i10;
                if (z2) {
                    i12 = i8 - measuredWidth2;
                    measuredWidth2 = (i8 - i9) - i6;
                }
                childAt.layout(i12, i10, measuredWidth2, measuredHeight);
                i9 += i6 + i7 + childAt.getMeasuredWidth() + this.X2;
                paddingTop = measuredHeight;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i7 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i7 - getPaddingRight();
        int i8 = paddingTop;
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                int i11 = i2;
                int i12 = i3;
            } else {
                measureChild(childAt, i2, i3);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i5 = marginLayoutParams.leftMargin;
                    i4 = marginLayoutParams.rightMargin;
                } else {
                    i5 = 0;
                    i4 = 0;
                }
                int i13 = paddingLeft;
                if (paddingLeft + i5 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    i6 = i13;
                } else {
                    i6 = getPaddingLeft();
                    i8 = this.s + paddingTop;
                }
                int measuredWidth = i6 + i5 + childAt.getMeasuredWidth();
                int measuredHeight = i8 + childAt.getMeasuredHeight();
                if (measuredWidth > i9) {
                    i9 = measuredWidth;
                }
                paddingLeft = i6 + i5 + i4 + childAt.getMeasuredWidth() + this.X2;
                if (i10 == getChildCount() - 1) {
                    i9 += i4;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i9 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    /* access modifiers changed from: protected */
    public void setItemSpacing(int i2) {
        this.X2 = i2;
    }

    /* access modifiers changed from: protected */
    public void setLineSpacing(int i2) {
        this.s = i2;
    }

    public void setSingleLine(boolean z) {
        this.Y2 = z;
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Y2 = false;
        d(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.Y2 = false;
        d(context, attributeSet);
    }
}
