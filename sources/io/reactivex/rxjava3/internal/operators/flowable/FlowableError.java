package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import org.reactivestreams.Subscriber;

public final class FlowableError<T> extends Flowable<T> {
    final Supplier<? extends Throwable> X;

    public FlowableError(Supplier<? extends Throwable> supplier) {
        this.X = supplier;
    }

    public void K6(Subscriber<? super T> subscriber) {
        try {
            th = (Throwable) ExceptionHelper.d(this.X.get(), "Callable returned a null Throwable.");
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        EmptySubscription.b(th, subscriber);
    }
}
