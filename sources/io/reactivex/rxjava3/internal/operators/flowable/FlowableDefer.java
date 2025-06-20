package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableDefer<T> extends Flowable<T> {
    final Supplier<? extends Publisher<? extends T>> X;

    public FlowableDefer(Supplier<? extends Publisher<? extends T>> supplier) {
        this.X = supplier;
    }

    public void K6(Subscriber<? super T> subscriber) {
        try {
            Object obj = this.X.get();
            Objects.requireNonNull(obj, "The publisher supplied is null");
            ((Publisher) obj).e(subscriber);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
