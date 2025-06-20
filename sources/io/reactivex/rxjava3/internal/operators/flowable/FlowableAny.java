package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAny<T> extends AbstractFlowableWithUpstream<T, Boolean> {
    final Predicate<? super T> Y;

    static final class AnySubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
        private static final long i3 = -2311252482644620661L;
        final Predicate<? super T> f3;
        Subscription g3;
        boolean h3;

        AnySubscriber(Subscriber<? super Boolean> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f3 = predicate;
        }

        public void cancel() {
            super.cancel();
            this.g3.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.g3, subscription)) {
                this.g3 = subscription;
                this.X.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            if (!this.h3) {
                this.h3 = true;
                f(Boolean.FALSE);
            }
        }

        public void onError(Throwable th) {
            if (this.h3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.h3 = true;
            this.X.onError(th);
        }

        public void onNext(T t) {
            if (!this.h3) {
                try {
                    if (this.f3.test(t)) {
                        this.h3 = true;
                        this.g3.cancel();
                        f(Boolean.TRUE);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.g3.cancel();
                    onError(th);
                }
            }
        }
    }

    public FlowableAny(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.Y = predicate;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super Boolean> subscriber) {
        this.X.J6(new AnySubscriber(subscriber, this.Y));
    }
}
