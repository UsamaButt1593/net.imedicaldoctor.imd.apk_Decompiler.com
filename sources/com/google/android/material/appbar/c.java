package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MaterialShapeDrawable X;
    public final /* synthetic */ AppBarLayout s;

    public /* synthetic */ c(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable) {
        this.s = appBarLayout;
        this.X = materialShapeDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.w(this.X, valueAnimator);
    }
}
