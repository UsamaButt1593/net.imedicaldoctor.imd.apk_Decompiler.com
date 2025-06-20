package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

public class NoTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    static final NoTransition<?> f18504a = new NoTransition<>();

    /* renamed from: b  reason: collision with root package name */
    private static final TransitionFactory<?> f18505b = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
        public Transition<R> a(DataSource dataSource, boolean z) {
            return NoTransition.f18504a;
        }
    }

    public static <R> Transition<R> b() {
        return f18504a;
    }

    public static <R> TransitionFactory<R> c() {
        return f18505b;
    }

    public boolean a(Object obj, Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
