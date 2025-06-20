package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForegroundLinearLayout extends LinearLayoutCompat {
    private int A3;
    protected boolean B3;
    boolean C3;
    @Nullable
    private Drawable x3;
    private final Rect y3;
    private final Rect z3;

    public ForegroundLinearLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.x3;
        if (drawable != null) {
            if (this.C3) {
                this.C3 = false;
                Rect rect = this.y3;
                Rect rect2 = this.z3;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.B3) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.A3, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @RequiresApi(21)
    @TargetApi(21)
    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.x3;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.x3;
        if (drawable != null && drawable.isStateful()) {
            this.x3.setState(getDrawableState());
        }
    }

    @Nullable
    public Drawable getForeground() {
        return this.x3;
    }

    public int getForegroundGravity() {
        return this.A3;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.x3;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.C3 = z | this.C3;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.C3 = true;
    }

    public void setForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.x3;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.x3);
            }
            this.x3 = drawable;
            this.C3 = true;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.A3 == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i2) {
        if (this.A3 != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= GravityCompat.f6387b;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.A3 = i2;
            if (i2 == 119 && this.x3 != null) {
                this.x3.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.x3;
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.y3 = new Rect();
        this.z3 = new Rect();
        this.A3 = 119;
        this.B3 = true;
        this.C3 = false;
        TypedArray k2 = ThemeEnforcement.k(context, attributeSet, R.styleable.bh, i2, 0, new int[0]);
        this.A3 = k2.getInt(R.styleable.dh, this.A3);
        Drawable drawable = k2.getDrawable(R.styleable.ch);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.B3 = k2.getBoolean(R.styleable.eh, true);
        k2.recycle();
    }
}
