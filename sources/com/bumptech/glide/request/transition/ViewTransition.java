package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.Transition;

public class ViewTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewTransitionAnimationFactory f18513a;

    interface ViewTransitionAnimationFactory {
        Animation a(Context context);
    }

    ViewTransition(ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.f18513a = viewTransitionAnimationFactory;
    }

    public boolean a(R r, Transition.ViewAdapter viewAdapter) {
        View g2 = viewAdapter.g();
        if (g2 == null) {
            return false;
        }
        g2.clearAnimation();
        g2.startAnimation(this.f18513a.a(g2.getContext()));
        return false;
    }
}
