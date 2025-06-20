package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewPropertyTransition.Animator f18510a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPropertyTransition<R> f18511b;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator animator) {
        this.f18510a = animator;
    }

    public Transition<R> a(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.b();
        }
        if (this.f18511b == null) {
            this.f18511b = new ViewPropertyTransition<>(this.f18510a);
        }
        return this.f18511b;
    }
}
