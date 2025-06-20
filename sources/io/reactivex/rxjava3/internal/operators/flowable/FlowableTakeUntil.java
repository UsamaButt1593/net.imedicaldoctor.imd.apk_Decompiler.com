package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends U> Y;

    static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long Y2 = -4945480365982832967L;
        final AtomicLong X = new AtomicLong();
        final TakeUntilMainSubscriber<T>.OtherSubscriber X2 = new OtherSubscriber();
        final AtomicReference<Subscription> Y = new AtomicReference<>();
        final AtomicThrowable Z = new AtomicThrowable();
        final Subscriber<? super T> s;

        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long X = -3592821756711087922L;

            OtherSubscriber() {
            }

            public void h(Subscription subscription) {
                SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
            }

            public void onComplete() {
                SubscriptionHelper.a(TakeUntilMainSubscriber.this.Y);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                HalfSerializer.b(takeUntilMainSubscriber.s, takeUntilMainSubscriber, takeUntilMainSubscriber.Z);
            }

            public void onError(Throwable th) {
                SubscriptionHelper.a(TakeUntilMainSubscriber.this.Y);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                HalfSerializer.d(takeUntilMainSubscriber.s, th, takeUntilMainSubscriber, takeUntilMainSubscriber.Z);
            }

            public void onNext(Object obj) {
                SubscriptionHelper.a(this);
                onComplete();
            }
        }

        TakeUntilMainSubscriber(Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        public void cancel() {
            SubscriptionHelper.a(this.Y);
            SubscriptionHelper.a(this.X2);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this.Y, this.X, subscription);
        }

        public void onComplete() {
            SubscriptionHelper.a(this.X2);
            HalfSerializer.b(this.s, this, this.Z);
        }

        public void onError(Throwable th) {
            SubscriptionHelper.a(this.X2);
            HalfSerializer.d(this.s, th, this, this.Z);
        }

        public void onNext(T t) {
            HalfSerializer.f(this.s, t, this, this.Z);
        }

        public void request(long j2) {
            SubscriptionHelper.b(this.Y, this.X, j2);
        }
    }

    public FlowableTakeUntil(Flowable<T> flowable, Publisher<? extends U> publisher) {
        super(flowable);
        this.Y = publisher;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(subscriber);
        subscriber.h(takeUntilMainSubscriber);
        this.Y.e(takeUntilMainSubscriber.X2);
        this.X.J6(takeUntilMainSubscriber);
    }
}
