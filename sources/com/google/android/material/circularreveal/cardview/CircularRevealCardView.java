package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;

public class CircularRevealCardView extends MaterialCardView implements CircularRevealWidget {
    @NonNull
    private final CircularRevealHelper u3;

    public CircularRevealCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a() {
        this.u3.a();
    }

    public void b() {
        this.u3.b();
    }

    public void c(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean d() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.u3;
        if (circularRevealHelper != null) {
            circularRevealHelper.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.u3.g();
    }

    public int getCircularRevealScrimColor() {
        return this.u3.h();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        return this.u3.j();
    }

    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.u3;
        return circularRevealHelper != null ? circularRevealHelper.l() : super.isOpaque();
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.u3.m(drawable);
    }

    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.u3.n(i2);
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo) {
        this.u3.o(revealInfo);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.u3 = new CircularRevealHelper(this);
    }
}
