package com.google.android.material.sidesheet;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ViewGroup.MarginLayoutParams X;
    public final /* synthetic */ int Y;
    public final /* synthetic */ View Z;
    public final /* synthetic */ SideSheetBehavior s;

    public /* synthetic */ d(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i2, View view) {
        this.s = sideSheetBehavior;
        this.X = marginLayoutParams;
        this.Y = i2;
        this.Z = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.L0(this.X, this.Y, this.Z, valueAnimator);
    }
}
