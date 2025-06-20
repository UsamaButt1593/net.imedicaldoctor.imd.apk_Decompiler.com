package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.graphics.Rect;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Rect X;
    public final /* synthetic */ ExpandCollapseAnimationHelper s;

    public /* synthetic */ a(ExpandCollapseAnimationHelper expandCollapseAnimationHelper, Rect rect) {
        this.s = expandCollapseAnimationHelper;
        this.X = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.m(this.X, valueAnimator);
    }
}
