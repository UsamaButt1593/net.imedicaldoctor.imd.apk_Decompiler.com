package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableFromFuture<T> extends Flowable<T> {
    final Future<? extends T> X;
    final long Y;
    final TimeUnit Z;

    public FlowableFromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.X = future;
        this.Y = j2;
        this.Z = timeUnit;
    }

    public void K6(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.h(deferredScalarSubscription);
        try {
            TimeUnit timeUnit = this.Z;
            Object obj = timeUnit != null ? this.X.get(this.Y, timeUnit) : this.X.get();
            if (obj == null) {
                subscriber.onError(ExceptionHelper.b("The future returned a null value."));
            } else {
                deferredScalarSubscription.f(obj);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            if (!deferredScalarSubscription.g()) {
                subscriber.onError(th);
            }
        }
    }
}
