package com.google.android.material.timepicker;

import android.animation.ValueAnimator;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ClockHandView s;

    public /* synthetic */ b(ClockHandView clockHandView) {
        this.s = clockHandView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.m(valueAnimator);
    }
}
