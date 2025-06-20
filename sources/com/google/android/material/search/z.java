package com.google.android.material.search;

import android.animation.ValueAnimator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

public final /* synthetic */ class z implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DrawerArrowDrawable s;

    public /* synthetic */ z(DrawerArrowDrawable drawerArrowDrawable) {
        this.s = drawerArrowDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.s(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
