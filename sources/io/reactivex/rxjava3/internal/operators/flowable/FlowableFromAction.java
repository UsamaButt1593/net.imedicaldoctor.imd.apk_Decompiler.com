package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.CancellableQueueFuseable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableFromAction<T> extends Flowable<T> implements Supplier<T> {
    final Action X;

    public FlowableFromAction(Action action) {
        this.X = action;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        CancellableQueueFuseable cancellableQueueFuseable = new CancellableQueueFuseable();
        subscriber.h(cancellableQueueFuseable);
        if (!cancellableQueueFuseable.g()) {
            try {
                this.X.run();
                if (!cancellableQueueFuseable.g()) {
                    subscriber.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                if (!cancellableQueueFuseable.g()) {
                    subscriber.onError(th);
                } else {
                    RxJavaPlugins.Y(th);
                }
            }
        }
    }

    public T get() throws Throwable {
        this.X.run();
        return null;
    }
}
