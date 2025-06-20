package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;

public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements CircularRevealWidget {
    @NonNull
    private final CircularRevealHelper B3;

    public CircularRevealCoordinatorLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void a() {
        this.B3.a();
    }

    public void b() {
        this.B3.b();
    }

    public void c(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean d() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.B3;
        if (circularRevealHelper != null) {
            circularRevealHelper.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.B3.g();
    }

    public int getCircularRevealScrimColor() {
        return this.B3.h();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        return this.B3.j();
    }

    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.B3;
        return circularRevealHelper != null ? circularRevealHelper.l() : super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.B3.m(drawable);
    }

    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.B3.n(i2);
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo) {
        this.B3.o(revealInfo);
    }

    public CircularRevealCoordinatorLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B3 = new CircularRevealHelper(this);
    }
}
