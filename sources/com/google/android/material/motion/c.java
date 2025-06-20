package com.google.android.material.motion;

import android.animation.ValueAnimator;
import com.google.android.material.internal.ClippableRoundedCornerLayout;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ClippableRoundedCornerLayout s;

    public /* synthetic */ c(ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        this.s = clippableRoundedCornerLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
