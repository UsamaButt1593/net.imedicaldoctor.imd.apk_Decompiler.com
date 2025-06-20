package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.graphics.Rect;

public final /* synthetic */ class y implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float X;
    public final /* synthetic */ float Y;
    public final /* synthetic */ Rect Z;
    public final /* synthetic */ SearchViewAnimationHelper s;

    public /* synthetic */ y(SearchViewAnimationHelper searchViewAnimationHelper, float f2, float f3, Rect rect) {
        this.s = searchViewAnimationHelper;
        this.X = f2;
        this.Y = f3;
        this.Z = rect;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.P(this.X, this.Y, this.Z, valueAnimator);
    }
}
