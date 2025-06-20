package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;

abstract class AbstractMaybeWithUpstream<T, R> extends Maybe<R> implements HasUpstreamMaybeSource<T> {
    protected final MaybeSource<T> s;

    AbstractMaybeWithUpstream(MaybeSource<T> maybeSource) {
        this.s = maybeSource;
    }

    public final MaybeSource<T> source() {
        return this.s;
    }
}
