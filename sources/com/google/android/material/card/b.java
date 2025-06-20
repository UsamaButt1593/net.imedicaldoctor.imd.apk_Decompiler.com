package com.google.android.material.card;

import android.animation.ValueAnimator;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MaterialCardViewHelper s;

    public /* synthetic */ b(MaterialCardViewHelper materialCardViewHelper) {
        this.s = materialCardViewHelper;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.I(valueAnimator);
    }
}
