package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableOnErrorReturn<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends T> Y;

    static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long b3 = -3740826063558713822L;
        final Function<? super Throwable, ? extends T> a3;

        OnErrorReturnSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends T> function) {
            super(subscriber);
            this.a3 = function;
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.a3.apply(th);
                Objects.requireNonNull(apply, "The valueSupplier returned a null value");
                c(apply);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }

        public void onNext(T t) {
            this.Z++;
            this.s.onNext(t);
        }
    }

    public FlowableOnErrorReturn(Flowable<T> flowable, Function<? super Throwable, ? extends T> function) {
        super(flowable);
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new OnErrorReturnSubscriber(subscriber, this.Y));
    }
}
