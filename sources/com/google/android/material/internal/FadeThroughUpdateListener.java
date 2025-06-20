package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FadeThroughUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    @Nullable
    private final View X;
    private final float[] Y = new float[2];
    @Nullable
    private final View s;

    public FadeThroughUpdateListener(@Nullable View view, @Nullable View view2) {
        this.s = view;
        this.X = view2;
    }

    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        FadeThroughUtils.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.Y);
        View view = this.s;
        if (view != null) {
            view.setAlpha(this.Y[0]);
        }
        View view2 = this.X;
        if (view2 != null) {
            view2.setAlpha(this.Y[1]);
        }
    }
}
