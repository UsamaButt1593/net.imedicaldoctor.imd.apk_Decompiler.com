package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUnsubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler Y;

    static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long Z = 1015244841293359600L;
        final Scheduler X;
        Subscription Y;
        final Subscriber<? super T> s;

        final class Cancellation implements Runnable {
            Cancellation() {
            }

            public void run() {
                UnsubscribeSubscriber.this.Y.cancel();
            }
        }

        UnsubscribeSubscriber(Subscriber<? super T> subscriber, Scheduler scheduler) {
            this.s = subscriber;
            this.X = scheduler;
        }

        public void cancel() {
            if (compareAndSet(false, true)) {
                this.X.f(new Cancellation());
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            if (!get()) {
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.Y(th);
            } else {
                this.s.onError(th);
            }
        }

        public void onNext(T t) {
            if (!get()) {
                this.s.onNext(t);
            }
        }

        public void request(long j2) {
            this.Y.request(j2);
        }
    }

    public FlowableUnsubscribeOn(Flowable<T> flowable, Scheduler scheduler) {
        super(flowable);
        this.Y = scheduler;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new UnsubscribeSubscriber(subscriber, this.Y));
    }
}
