package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler Y;
    final boolean Z;

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long Z2 = 8094547886072529208L;
        final Scheduler.Worker X;
        final boolean X2;
        final AtomicReference<Subscription> Y = new AtomicReference<>();
        Publisher<T> Y2;
        final AtomicLong Z = new AtomicLong();
        final Subscriber<? super T> s;

        static final class Request implements Runnable {
            final long X;
            final Subscription s;

            Request(Subscription subscription, long j2) {
                this.s = subscription;
                this.X = j2;
            }

            public void run() {
                this.s.request(this.X);
            }
        }

        SubscribeOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, Publisher<T> publisher, boolean z) {
            this.s = subscriber;
            this.X = worker;
            this.Y2 = publisher;
            this.X2 = !z;
        }

        /* access modifiers changed from: package-private */
        public void a(long j2, Subscription subscription) {
            if (this.X2 || Thread.currentThread() == get()) {
                subscription.request(j2);
            } else {
                this.X.b(new Request(subscription, j2));
            }
        }

        public void cancel() {
            SubscriptionHelper.a(this.Y);
            this.X.m();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.i(this.Y, subscription)) {
                long andSet = this.Z.getAndSet(0);
                if (andSet != 0) {
                    a(andSet, subscription);
                }
            }
        }

        public void onComplete() {
            this.s.onComplete();
            this.X.m();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
            this.X.m();
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                Subscription subscription = this.Y.get();
                if (subscription != null) {
                    a(j2, subscription);
                    return;
                }
                BackpressureHelper.a(this.Z, j2);
                Subscription subscription2 = this.Y.get();
                if (subscription2 != null) {
                    long andSet = this.Z.getAndSet(0);
                    if (andSet != 0) {
                        a(andSet, subscription2);
                    }
                }
            }
        }

        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> publisher = this.Y2;
            this.Y2 = null;
            publisher.e(this);
        }
    }

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z) {
        super(flowable);
        this.Y = scheduler;
        this.Z = z;
    }

    public void K6(Subscriber<? super T> subscriber) {
        Scheduler.Worker d2 = this.Y.d();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, d2, this.X, this.Z);
        subscriber.h(subscribeOnSubscriber);
        d2.b(subscribeOnSubscriber);
    }
}
