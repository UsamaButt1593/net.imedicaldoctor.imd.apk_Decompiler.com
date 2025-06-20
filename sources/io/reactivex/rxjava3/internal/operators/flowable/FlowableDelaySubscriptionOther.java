package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {
    final Publisher<? extends T> X;
    final Publisher<U> Y;

    static final class MainSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long X2 = 2259811067697317255L;
        final Publisher<? extends T> X;
        final MainSubscriber<T>.OtherSubscriber Y = new OtherSubscriber();
        final AtomicReference<Subscription> Z = new AtomicReference<>();
        final Subscriber<? super T> s;

        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long X = -3892798459447644106L;

            OtherSubscriber() {
            }

            public void h(Subscription subscription) {
                if (SubscriptionHelper.i(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }

            public void onComplete() {
                if (((Subscription) get()) != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.a();
                }
            }

            public void onError(Throwable th) {
                if (((Subscription) get()) != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.s.onError(th);
                } else {
                    RxJavaPlugins.Y(th);
                }
            }

            public void onNext(Object obj) {
                Subscription subscription = (Subscription) get();
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper) {
                    lazySet(subscriptionHelper);
                    subscription.cancel();
                    MainSubscriber.this.a();
                }
            }
        }

        MainSubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.s = subscriber;
            this.X = publisher;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.X.e(this);
        }

        public void cancel() {
            SubscriptionHelper.a(this.Y);
            SubscriptionHelper.a(this.Z);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this.Z, this, subscription);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                SubscriptionHelper.b(this.Z, this, j2);
            }
        }
    }

    public FlowableDelaySubscriptionOther(Publisher<? extends T> publisher, Publisher<U> publisher2) {
        this.X = publisher;
        this.Y = publisher2;
    }

    public void K6(Subscriber<? super T> subscriber) {
        MainSubscriber mainSubscriber = new MainSubscriber(subscriber, this.X);
        subscriber.h(mainSubscriber);
        this.Y.e(mainSubscriber.Y);
    }
}
