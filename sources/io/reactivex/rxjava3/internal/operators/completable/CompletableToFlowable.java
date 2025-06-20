package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromCompletable;
import org.reactivestreams.Subscriber;

public final class CompletableToFlowable<T> extends Flowable<T> {
    final CompletableSource X;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.X = completableSource;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.a(new FlowableFromCompletable.FromCompletableObserver(subscriber));
    }
}
