package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ClearTextEndIconDelegate s;

    public /* synthetic */ e(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.s = clearTextEndIconDelegate;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.F(valueAnimator);
    }
}
