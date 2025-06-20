package com.google.android.material.search;

import android.animation.ValueAnimator;
import com.google.android.material.internal.FadeThroughDrawable;

public final /* synthetic */ class B implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FadeThroughDrawable s;

    public /* synthetic */ B(FadeThroughDrawable fadeThroughDrawable) {
        this.s = fadeThroughDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
