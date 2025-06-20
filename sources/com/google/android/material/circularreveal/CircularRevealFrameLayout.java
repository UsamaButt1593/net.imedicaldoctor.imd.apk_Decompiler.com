package com.google.android.material.circularreveal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.CircularRevealWidget;

public class CircularRevealFrameLayout extends FrameLayout implements CircularRevealWidget {
    @NonNull
    private final CircularRevealHelper s;

    public CircularRevealFrameLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void a() {
        this.s.a();
    }

    public void b() {
        this.s.b();
    }

    public void c(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean d() {
        return super.isOpaque();
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(@NonNull Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.s;
        if (circularRevealHelper != null) {
            circularRevealHelper.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.s.g();
    }

    public int getCircularRevealScrimColor() {
        return this.s.h();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        return this.s.j();
    }

    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.s;
        return circularRevealHelper != null ? circularRevealHelper.l() : super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.s.m(drawable);
    }

    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.s.n(i2);
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo) {
        this.s.o(revealInfo);
    }

    public CircularRevealFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = new CircularRevealHelper(this);
    }
}
