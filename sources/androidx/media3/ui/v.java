package androidx.media3.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class v implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ PlayerControlViewLayoutManager s;

    public /* synthetic */ v(PlayerControlViewLayoutManager playerControlViewLayoutManager) {
        this.s = playerControlViewLayoutManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.N(valueAnimator);
    }
}
