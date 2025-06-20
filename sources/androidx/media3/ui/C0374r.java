package androidx.media3.ui;

import android.animation.ValueAnimator;

/* renamed from: androidx.media3.ui.r  reason: case insensitive filesystem */
public final /* synthetic */ class C0374r implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PlayerControlViewLayoutManager s;

    public /* synthetic */ C0374r(PlayerControlViewLayoutManager playerControlViewLayoutManager) {
        this.s = playerControlViewLayoutManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.L(valueAnimator);
    }
}
