package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryPredicate<T> extends AbstractFlowableWithUpstream<T, T> {
    final Predicate<? super Throwable> Y;
    final long Z;

    static final class RetrySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long Z2 = -7098360935104053232L;
        final SubscriptionArbiter X;
        long X2;
        final Publisher<? extends T> Y;
        long Y2;
        final Predicate<? super Throwable> Z;
        final Subscriber<? super T> s;

        RetrySubscriber(Subscriber<? super T> subscriber, long j2, Predicate<? super Throwable> predicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.s = subscriber;
            this.X = subscriptionArbiter;
            this.Y = publisher;
            this.Z = predicate;
            this.X2 = j2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.X.e()) {
                    long j2 = this.Y2;
                    if (j2 != 0) {
                        this.Y2 = 0;
                        this.X.g(j2);
                    }
                    this.Y.e(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public void h(Subscription subscription) {
            this.X.i(subscription);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            long j2 = this.X2;
            if (j2 != Long.MAX_VALUE) {
                this.X2 = j2 - 1;
            }
            if (j2 == 0) {
                this.s.onError(th);
                return;
            }
            try {
                if (!this.Z.test(th)) {
                    this.s.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }

        public void onNext(T t) {
            this.Y2++;
            this.s.onNext(t);
        }
    }

    public FlowableRetryPredicate(Flowable<T> flowable, long j2, Predicate<? super Throwable> predicate) {
        super(flowable);
        this.Y = predicate;
        this.Z = j2;
    }

    public void K6(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.h(subscriptionArbiter);
        new RetrySubscriber(subscriber, this.Z, this.Y, subscriptionArbiter, this.X).a();
    }
}
