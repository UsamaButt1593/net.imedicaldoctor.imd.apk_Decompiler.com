package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;
import com.google.android.material.circularreveal.CircularRevealWidget;

public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    @NonNull
    public static Animator a(@NonNull CircularRevealWidget circularRevealWidget, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, CircularRevealWidget.CircularRevealProperty.f21007a, CircularRevealWidget.CircularRevealEvaluator.f21005b, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f2, f3, f4)});
        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f2, (int) f3, revealInfo.f21012c, f4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    @NonNull
    public static Animator b(CircularRevealWidget circularRevealWidget, float f2, float f3, float f4, float f5) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(circularRevealWidget, CircularRevealWidget.CircularRevealProperty.f21007a, CircularRevealWidget.CircularRevealEvaluator.f21005b, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(f2, f3, f4), new CircularRevealWidget.RevealInfo(f2, f3, f5)});
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) circularRevealWidget, (int) f2, (int) f3, f4, f5);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
        return animatorSet;
    }

    @NonNull
    public static Animator.AnimatorListener c(@NonNull final CircularRevealWidget circularRevealWidget) {
        return new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                CircularRevealWidget.this.b();
            }

            public void onAnimationStart(Animator animator) {
                CircularRevealWidget.this.a();
            }
        };
    }
}
