package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<U> Y;

    static final class SkipUntilMainSubscriber<T> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long Z2 = -6270983465606289181L;
        final AtomicReference<Subscription> X = new AtomicReference<>();
        final AtomicThrowable X2 = new AtomicThrowable();
        final AtomicLong Y = new AtomicLong();
        volatile boolean Y2;
        final SkipUntilMainSubscriber<T>.OtherSubscriber Z = new OtherSubscriber();
        final Subscriber<? super T> s;

        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long X = -5592042965931999169L;

            OtherSubscriber() {
            }

            public void h(Subscription subscription) {
                SubscriptionHelper.j(this, subscription, Long.MAX_VALUE);
            }

            public void onComplete() {
                SkipUntilMainSubscriber.this.Y2 = true;
            }

            public void onError(Throwable th) {
                SubscriptionHelper.a(SkipUntilMainSubscriber.this.X);
                SkipUntilMainSubscriber skipUntilMainSubscriber = SkipUntilMainSubscriber.this;
                HalfSerializer.d(skipUntilMainSubscriber.s, th, skipUntilMainSubscriber, skipUntilMainSubscriber.X2);
            }

            public void onNext(Object obj) {
                SkipUntilMainSubscriber.this.Y2 = true;
                ((Subscription) get()).cancel();
            }
        }

        SkipUntilMainSubscriber(Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        public void cancel() {
            SubscriptionHelper.a(this.X);
            SubscriptionHelper.a(this.Z);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this.X, this.Y, subscription);
        }

        public boolean o(T t) {
            if (!this.Y2) {
                return false;
            }
            HalfSerializer.f(this.s, t, this, this.X2);
            return true;
        }

        public void onComplete() {
            SubscriptionHelper.a(this.Z);
            HalfSerializer.b(this.s, this, this.X2);
        }

        public void onError(Throwable th) {
            SubscriptionHelper.a(this.Z);
            HalfSerializer.d(this.s, th, this, this.X2);
        }

        public void onNext(T t) {
            if (!o(t)) {
                this.X.get().request(1);
            }
        }

        public void request(long j2) {
            SubscriptionHelper.b(this.X, this.Y, j2);
        }
    }

    public FlowableSkipUntil(Flowable<T> flowable, Publisher<U> publisher) {
        super(flowable);
        this.Y = publisher;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        SkipUntilMainSubscriber skipUntilMainSubscriber = new SkipUntilMainSubscriber(subscriber);
        subscriber.h(skipUntilMainSubscriber);
        this.Y.e(skipUntilMainSubscriber.Z);
        this.X.J6(skipUntilMainSubscriber);
    }
}
