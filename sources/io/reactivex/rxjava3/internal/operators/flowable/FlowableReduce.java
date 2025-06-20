package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReduce<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiFunction<T, T, T> Y;

    static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long h3 = -4663883003264602070L;
        final BiFunction<T, T, T> f3;
        Subscription g3;

        ReduceSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.f3 = biFunction;
        }

        public void cancel() {
            super.cancel();
            this.g3.cancel();
            this.g3 = SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.g3, subscription)) {
                this.g3 = subscription;
                this.X.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            Subscription subscription = this.g3;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.g3 = subscriptionHelper;
                T t = this.Y;
                if (t != null) {
                    f(t);
                } else {
                    this.X.onComplete();
                }
            }
        }

        public void onError(Throwable th) {
            Subscription subscription = this.g3;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.g3 = subscriptionHelper;
            this.X.onError(th);
        }

        public void onNext(T t) {
            if (this.g3 != SubscriptionHelper.CANCELLED) {
                T t2 = this.Y;
                if (t2 == null) {
                    this.Y = t;
                    return;
                }
                try {
                    T apply = this.f3.apply(t2, t);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.Y = apply;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.g3.cancel();
                    onError(th);
                }
            }
        }
    }

    public FlowableReduce(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.Y = biFunction;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new ReduceSubscriber(subscriber, this.Y));
    }
}
