package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableElementAtMaybe;
import org.reactivestreams.Publisher;

public final class FlowableElementAtMaybePublisher<T> extends Maybe<T> {
    final long X;
    final Publisher<T> s;

    public FlowableElementAtMaybePublisher(Publisher<T> publisher, long j2) {
        this.s = publisher;
        this.X = j2;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.e(new FlowableElementAtMaybe.ElementAtSubscriber(maybeObserver, this.X));
    }
}
