package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.view.animation.Interpolator;

public class BasicSwapTargetTranslationInterpolator implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float f25383a;

    /* renamed from: b  reason: collision with root package name */
    private final float f25384b;

    /* renamed from: c  reason: collision with root package name */
    private final float f25385c;

    public BasicSwapTargetTranslationInterpolator() {
        this(0.3f);
    }

    public float getInterpolation(float f2) {
        return Math.abs(f2 - 0.5f) < this.f25384b ? (f2 - this.f25383a) * this.f25385c : f2 < 0.5f ? 0.0f : 1.0f;
    }

    public BasicSwapTargetTranslationInterpolator(float f2) {
        if (f2 < 0.0f || f2 >= 0.5f) {
            throw new IllegalArgumentException("Invalid threshold range: " + f2);
        }
        float f3 = 1.0f - (2.0f * f2);
        this.f25383a = f2;
        this.f25384b = 0.5f * f3;
        this.f25385c = 1.0f / f3;
    }
}
