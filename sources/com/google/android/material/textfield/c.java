package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ClearTextEndIconDelegate s;

    public /* synthetic */ c(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.s = clearTextEndIconDelegate;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.E(valueAnimator);
    }
}
