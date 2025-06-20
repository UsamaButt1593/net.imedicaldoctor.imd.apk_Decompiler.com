package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFrom<T, U, R> extends AbstractFlowableWithUpstream<T, R> {
    final BiFunction<? super T, ? super U, ? extends R> Y;
    final Publisher<? extends U> Z;

    final class FlowableWithLatestSubscriber implements FlowableSubscriber<U> {
        private final WithLatestFromSubscriber<T, U, R> s;

        FlowableWithLatestSubscriber(WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber) {
            this.s = withLatestFromSubscriber;
        }

        public void h(Subscription subscription) {
            if (this.s.b(subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            this.s.a(th);
        }

        public void onNext(U u) {
            this.s.lazySet(u);
        }
    }

    static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
        private static final long Y2 = -312246233408980075L;
        final BiFunction<? super T, ? super U, ? extends R> X;
        final AtomicReference<Subscription> X2 = new AtomicReference<>();
        final AtomicReference<Subscription> Y = new AtomicReference<>();
        final AtomicLong Z = new AtomicLong();
        final Subscriber<? super R> s;

        WithLatestFromSubscriber(Subscriber<? super R> subscriber, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.s = subscriber;
            this.X = biFunction;
        }

        public void a(Throwable th) {
            SubscriptionHelper.a(this.Y);
            this.s.onError(th);
        }

        public boolean b(Subscription subscription) {
            return SubscriptionHelper.i(this.X2, subscription);
        }

        public void cancel() {
            SubscriptionHelper.a(this.Y);
            SubscriptionHelper.a(this.X2);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this.Y, this.Z, subscription);
        }

        public boolean o(T t) {
            Object obj = get();
            if (obj != null) {
                try {
                    Object apply = this.X.apply(t, obj);
                    Objects.requireNonNull(apply, "The combiner returned a null value");
                    this.s.onNext(apply);
                    return true;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    this.s.onError(th);
                }
            }
            return false;
        }

        public void onComplete() {
            SubscriptionHelper.a(this.X2);
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            SubscriptionHelper.a(this.X2);
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!o(t)) {
                this.Y.get().request(1);
            }
        }

        public void request(long j2) {
            SubscriptionHelper.b(this.Y, this.Z, j2);
        }
    }

    public FlowableWithLatestFrom(Flowable<T> flowable, BiFunction<? super T, ? super U, ? extends R> biFunction, Publisher<? extends U> publisher) {
        super(flowable);
        this.Y = biFunction;
        this.Z = publisher;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(serializedSubscriber, this.Y);
        serializedSubscriber.h(withLatestFromSubscriber);
        this.Z.e(new FlowableWithLatestSubscriber(withLatestFromSubscriber));
        this.X.J6(withLatestFromSubscriber);
    }
}
