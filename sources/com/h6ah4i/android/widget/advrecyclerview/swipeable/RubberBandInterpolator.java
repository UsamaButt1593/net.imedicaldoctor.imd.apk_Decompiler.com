package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.animation.Interpolator;

class RubberBandInterpolator implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float f25520a;

    public RubberBandInterpolator(float f2) {
        this.f25520a = f2;
    }

    public float getInterpolation(float f2) {
        float f3 = 1.0f - f2;
        return this.f25520a * (1.0f - (f3 * f3));
    }
}
