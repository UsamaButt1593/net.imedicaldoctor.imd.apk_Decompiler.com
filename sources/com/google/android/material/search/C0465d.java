package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.google.android.material.search.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0465d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View s;

    public /* synthetic */ C0465d(View view) {
        this.s = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.setAlpha(0.0f);
    }
}
