package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends Publisher<? extends T>> Y;

    static final class OnErrorNextSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long h3 = 4063763155303814625L;
        final Subscriber<? super T> c3;
        final Function<? super Throwable, ? extends Publisher<? extends T>> d3;
        boolean e3;
        boolean f3;
        long g3;

        OnErrorNextSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> function) {
            super(false);
            this.c3 = subscriber;
            this.d3 = function;
        }

        public void h(Subscription subscription) {
            i(subscription);
        }

        public void onComplete() {
            if (!this.f3) {
                this.f3 = true;
                this.e3 = true;
                this.c3.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (!this.e3) {
                this.e3 = true;
                try {
                    Object apply = this.d3.apply(th);
                    Objects.requireNonNull(apply, "The nextSupplier returned a null Publisher");
                    Publisher publisher = (Publisher) apply;
                    long j2 = this.g3;
                    if (j2 != 0) {
                        g(j2);
                    }
                    publisher.e(this);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.c3.onError(new CompositeException(th, th2));
                }
            } else if (this.f3) {
                RxJavaPlugins.Y(th);
            } else {
                this.c3.onError(th);
            }
        }

        public void onNext(T t) {
            if (!this.f3) {
                if (!this.e3) {
                    this.g3++;
                }
                this.c3.onNext(t);
            }
        }
    }

    public FlowableOnErrorNext(Flowable<T> flowable, Function<? super Throwable, ? extends Publisher<? extends T>> function) {
        super(flowable);
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(subscriber, this.Y);
        subscriber.h(onErrorNextSubscriber);
        this.X.J6(onErrorNextSubscriber);
    }
}
