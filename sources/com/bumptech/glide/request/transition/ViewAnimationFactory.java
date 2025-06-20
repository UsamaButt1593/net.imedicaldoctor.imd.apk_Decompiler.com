package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;

public class ViewAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewTransition.ViewTransitionAnimationFactory f18506a;

    /* renamed from: b  reason: collision with root package name */
    private Transition<R> f18507b;

    private static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {

        /* renamed from: a  reason: collision with root package name */
        private final Animation f18508a;

        ConcreteViewTransitionAnimationFactory(Animation animation) {
            this.f18508a = animation;
        }

        public Animation a(Context context) {
            return this.f18508a;
        }
    }

    private static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {

        /* renamed from: a  reason: collision with root package name */
        private final int f18509a;

        ResourceViewTransitionAnimationFactory(int i2) {
            this.f18509a = i2;
        }

        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f18509a);
        }
    }

    public ViewAnimationFactory(int i2) {
        this((ViewTransition.ViewTransitionAnimationFactory) new ResourceViewTransitionAnimationFactory(i2));
    }

    public Transition<R> a(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.b();
        }
        if (this.f18507b == null) {
            this.f18507b = new ViewTransition(this.f18506a);
        }
        return this.f18507b;
    }

    public ViewAnimationFactory(Animation animation) {
        this((ViewTransition.ViewTransitionAnimationFactory) new ConcreteViewTransitionAnimationFactory(animation));
    }

    ViewAnimationFactory(ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.f18506a = viewTransitionAnimationFactory;
    }
}
