package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeatUntil<T> extends AbstractFlowableWithUpstream<T, T> {
    final BooleanSupplier Y;

    static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long Y2 = -7098360935104053232L;
        final SubscriptionArbiter X;
        long X2;
        final Publisher<? extends T> Y;
        final BooleanSupplier Z;
        final Subscriber<? super T> s;

        RepeatSubscriber(Subscriber<? super T> subscriber, BooleanSupplier booleanSupplier, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.s = subscriber;
            this.X = subscriptionArbiter;
            this.Y = publisher;
            this.Z = booleanSupplier;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.X.e()) {
                    long j2 = this.X2;
                    if (j2 != 0) {
                        this.X2 = 0;
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
            try {
                if (this.Z.a()) {
                    this.s.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.X2++;
            this.s.onNext(t);
        }
    }

    public FlowableRepeatUntil(Flowable<T> flowable, BooleanSupplier booleanSupplier) {
        super(flowable);
        this.Y = booleanSupplier;
    }

    public void K6(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.h(subscriptionArbiter);
        new RepeatSubscriber(subscriber, this.Y, subscriptionArbiter, this.X).a();
    }
}
