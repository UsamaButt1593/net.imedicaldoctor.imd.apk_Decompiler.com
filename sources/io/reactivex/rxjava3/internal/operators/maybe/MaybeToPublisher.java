package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import org.reactivestreams.Publisher;

public enum MaybeToPublisher implements Function<MaybeSource<Object>, Publisher<Object>> {
    INSTANCE;

    public static <T> Function<MaybeSource<T>, Publisher<T>> b() {
        return INSTANCE;
    }

    /* renamed from: a */
    public Publisher<Object> apply(MaybeSource<Object> maybeSource) {
        return new MaybeToFlowable(maybeSource);
    }
}
