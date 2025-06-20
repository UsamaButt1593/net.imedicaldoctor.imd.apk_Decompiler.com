package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableFromCallable<T> extends Flowable<T> implements Supplier<T> {
    final Callable<? extends T> X;

    public FlowableFromCallable(Callable<? extends T> callable) {
        this.X = callable;
    }

    public void K6(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.h(deferredScalarSubscription);
        try {
            Object call = this.X.call();
            Objects.requireNonNull(call, "The callable returned a null value");
            deferredScalarSubscription.f(call);
        } catch (Throwable th) {
            Exceptions.b(th);
            if (deferredScalarSubscription.g()) {
                RxJavaPlugins.Y(th);
            } else {
                subscriber.onError(th);
            }
        }
    }

    public T get() throws Throwable {
        T call = this.X.call();
        Objects.requireNonNull(call, "The callable returned a null value");
        return call;
    }
}
