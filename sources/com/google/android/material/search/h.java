package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;

public final /* synthetic */ class h implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View X;
    public final /* synthetic */ MaterialShapeDrawable s;

    public /* synthetic */ h(MaterialShapeDrawable materialShapeDrawable, View view) {
        this.s = materialShapeDrawable;
        this.X = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchBarAnimationHelper.A(this.s, this.X, valueAnimator);
    }
}
