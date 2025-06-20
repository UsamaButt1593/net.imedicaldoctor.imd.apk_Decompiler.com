package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FadeThroughDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f21516a;

    /* renamed from: b  reason: collision with root package name */
    private final Drawable f21517b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f21518c = new float[2];

    /* renamed from: d  reason: collision with root package name */
    private float f21519d;

    public FadeThroughDrawable(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        this.f21516a = drawable.getConstantState().newDrawable().mutate();
        Drawable mutate = drawable2.getConstantState().newDrawable().mutate();
        this.f21517b = mutate;
        mutate.setAlpha(0);
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f21519d != f2) {
            this.f21519d = f2;
            FadeThroughUtils.a(f2, this.f21518c);
            this.f21516a.setAlpha((int) (this.f21518c[0] * 255.0f));
            this.f21517b.setAlpha((int) (this.f21518c[1] * 255.0f));
            invalidateSelf();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        this.f21516a.draw(canvas);
        this.f21517b.draw(canvas);
    }

    public int getIntrinsicHeight() {
        return Math.max(this.f21516a.getIntrinsicHeight(), this.f21517b.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.f21516a.getIntrinsicWidth(), this.f21517b.getIntrinsicWidth());
    }

    public int getMinimumHeight() {
        return Math.max(this.f21516a.getMinimumHeight(), this.f21517b.getMinimumHeight());
    }

    public int getMinimumWidth() {
        return Math.max(this.f21516a.getMinimumWidth(), this.f21517b.getMinimumWidth());
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        return this.f21516a.isStateful() || this.f21517b.isStateful();
    }

    public void setAlpha(int i2) {
        if (this.f21519d <= 0.5f) {
            this.f21516a.setAlpha(i2);
            this.f21517b.setAlpha(0);
        } else {
            this.f21516a.setAlpha(0);
            this.f21517b.setAlpha(i2);
        }
        invalidateSelf();
    }

    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        this.f21516a.setBounds(i2, i3, i4, i5);
        this.f21517b.setBounds(i2, i3, i4, i5);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f21516a.setColorFilter(colorFilter);
        this.f21517b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public boolean setState(int[] iArr) {
        return this.f21516a.setState(iArr) || this.f21517b.setState(iArr);
    }
}
