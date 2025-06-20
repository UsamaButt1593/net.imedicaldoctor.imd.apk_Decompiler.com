package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public final class FadeThroughProvider implements VisibilityAnimatorProvider {

    /* renamed from: b  reason: collision with root package name */
    static final float f22164b = 0.35f;

    /* renamed from: a  reason: collision with root package name */
    private float f22165a = f22164b;

    private static Animator c(final View view, float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, final float f6) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        final View view2 = view;
        final float f7 = f2;
        final float f8 = f3;
        final float f9 = f4;
        final float f10 = f5;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view2.setAlpha(TransitionUtils.n(f7, f8, f9, f10, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setAlpha(f6);
            }
        });
        return ofFloat;
    }

    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, 0.0f, alpha, this.f22165a, 1.0f, alpha);
    }

    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, alpha, 0.0f, 0.0f, this.f22165a, alpha);
    }

    public float d() {
        return this.f22165a;
    }

    public void e(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f22165a = f2;
    }
}
