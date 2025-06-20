package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableFromSupplier<T> extends Flowable<T> implements Supplier<T> {
    final Supplier<? extends T> X;

    public FlowableFromSupplier(Supplier<? extends T> supplier) {
        this.X = supplier;
    }

    public void K6(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.h(deferredScalarSubscription);
        try {
            Object obj = this.X.get();
            Objects.requireNonNull(obj, "The supplier returned a null value");
            deferredScalarSubscription.f(obj);
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
        T t = this.X.get();
        Objects.requireNonNull(t, "The supplier returned a null value");
        return t;
    }
}
