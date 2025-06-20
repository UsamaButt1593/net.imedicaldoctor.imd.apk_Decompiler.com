package com.dd;

import android.graphics.drawable.GradientDrawable;

public class StrokeGradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    private int f18588a;

    /* renamed from: b  reason: collision with root package name */
    private int f18589b;

    /* renamed from: c  reason: collision with root package name */
    private final GradientDrawable f18590c;

    public StrokeGradientDrawable(GradientDrawable gradientDrawable) {
        this.f18590c = gradientDrawable;
    }

    public GradientDrawable a() {
        return this.f18590c;
    }

    public int b() {
        return this.f18589b;
    }

    public int c() {
        return this.f18588a;
    }

    public void d(int i2) {
        this.f18589b = i2;
        this.f18590c.setStroke(c(), i2);
    }

    public void e(int i2) {
        this.f18588a = i2;
        this.f18590c.setStroke(i2, b());
    }
}
