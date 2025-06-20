package androidx.media3.ui;

import android.animation.ValueAnimator;

/* renamed from: androidx.media3.ui.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0364d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DefaultTimeBar s;

    public /* synthetic */ C0364d(DefaultTimeBar defaultTimeBar) {
        this.s = defaultTimeBar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.m(valueAnimator);
    }
}
