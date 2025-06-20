package com.airbnb.lottie.utils;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class BaseLottieAnimator extends ValueAnimator {
    private final Set<Animator.AnimatorListener> X = new CopyOnWriteArraySet();
    private final Set<ValueAnimator.AnimatorUpdateListener> s = new CopyOnWriteArraySet();

    /* access modifiers changed from: package-private */
    public void a() {
        for (Animator.AnimatorListener onAnimationCancel : this.X) {
            onAnimationCancel.onAnimationCancel(this);
        }
    }

    public void addListener(Animator.AnimatorListener animatorListener) {
        this.X.add(animatorListener);
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.s.add(animatorUpdateListener);
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        for (Animator.AnimatorListener next : this.X) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationEnd(this, z);
            } else {
                next.onAnimationEnd(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        for (Animator.AnimatorListener onAnimationRepeat : this.X) {
            onAnimationRepeat.onAnimationRepeat(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(boolean z) {
        for (Animator.AnimatorListener next : this.X) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationStart(this, z);
            } else {
                next.onAnimationStart(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        for (ValueAnimator.AnimatorUpdateListener onAnimationUpdate : this.s) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void removeAllListeners() {
        this.X.clear();
    }

    public void removeAllUpdateListeners() {
        this.s.clear();
    }

    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.X.remove(animatorListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.s.remove(animatorUpdateListener);
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void setStartDelay(long j2) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long j2) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
