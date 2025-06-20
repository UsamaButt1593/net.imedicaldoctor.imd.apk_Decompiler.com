package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class M implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View X;
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener s;

    public /* synthetic */ M(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.s = viewPropertyAnimatorUpdateListener;
        this.X = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.s.a(this.X);
    }
}
