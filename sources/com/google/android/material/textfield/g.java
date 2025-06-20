package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DropdownMenuEndIconDelegate s;

    public /* synthetic */ g(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.s = dropdownMenuEndIconDelegate;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.I(valueAnimator);
    }
}
