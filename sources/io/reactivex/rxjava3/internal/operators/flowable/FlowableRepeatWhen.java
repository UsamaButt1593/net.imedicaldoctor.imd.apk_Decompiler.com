package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeatWhen<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Flowable<Object>, ? extends Publisher<?>> Y;

    static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long h3 = -2680129890138081029L;

        RepeatWhenSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<Object> flowableProcessor, Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        public void onComplete() {
            j(0);
        }

        public void onError(Throwable th) {
            this.e3.cancel();
            this.c3.onError(th);
        }
    }

    static final class WhenReceiver<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {
        private static final long X2 = 2827772011130406689L;
        final AtomicReference<Subscription> X = new AtomicReference<>();
        final AtomicLong Y = new AtomicLong();
        WhenSourceSubscriber<T, U> Z;
        final Publisher<T> s;

        WhenReceiver(Publisher<T> publisher) {
            this.s = publisher;
        }

        public void cancel() {
            SubscriptionHelper.a(this.X);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this.X, this.Y, subscription);
        }

        public void onComplete() {
            this.Z.cancel();
            this.Z.c3.onComplete();
        }

        public void onError(Throwable th) {
            this.Z.cancel();
            this.Z.c3.onError(th);
        }

        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (this.X.get() != SubscriptionHelper.CANCELLED) {
                    this.s.e(this.Z);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void request(long j2) {
            SubscriptionHelper.b(this.X, this.Y, j2);
        }
    }

    static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long g3 = -5604623027276966720L;
        protected final Subscriber<? super T> c3;
        protected final FlowableProcessor<U> d3;
        protected final Subscription e3;
        private long f3;

        WhenSourceSubscriber(Subscriber<? super T> subscriber, FlowableProcessor<U> flowableProcessor, Subscription subscription) {
            super(false);
            this.c3 = subscriber;
            this.d3 = flowableProcessor;
            this.e3 = subscription;
        }

        public final void cancel() {
            super.cancel();
            this.e3.cancel();
        }

        public final void h(Subscription subscription) {
            i(subscription);
        }

        /* access modifiers changed from: protected */
        public final void j(U u) {
            i(EmptySubscription.INSTANCE);
            long j2 = this.f3;
            if (j2 != 0) {
                this.f3 = 0;
                g(j2);
            }
            this.e3.request(1);
            this.d3.onNext(u);
        }

        public final void onNext(T t) {
            this.f3++;
            this.c3.onNext(t);
        }
    }

    public FlowableRepeatWhen(Flowable<T> flowable, Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        super(flowable);
        this.Y = function;
    }

    public void K6(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor n9 = UnicastProcessor.q9(8).n9();
        try {
            Object apply = this.Y.apply(n9);
            Objects.requireNonNull(apply, "handler returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            WhenReceiver whenReceiver = new WhenReceiver(this.X);
            RepeatWhenSubscriber repeatWhenSubscriber = new RepeatWhenSubscriber(serializedSubscriber, n9, whenReceiver);
            whenReceiver.Z = repeatWhenSubscriber;
            subscriber.h(repeatWhenSubscriber);
            publisher.e(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
