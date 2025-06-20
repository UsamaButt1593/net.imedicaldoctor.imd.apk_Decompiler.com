package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorComplete;

public final class SingleOnErrorComplete<T> extends Maybe<T> {
    final Predicate<? super Throwable> X;
    final Single<T> s;

    public SingleOnErrorComplete(Single<T> single, Predicate<? super Throwable> predicate) {
        this.s = single;
        this.X = predicate;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.e(new MaybeOnErrorComplete.OnErrorCompleteMultiObserver(maybeObserver, this.X));
    }
}
