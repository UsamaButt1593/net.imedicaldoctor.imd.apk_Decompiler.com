package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SingleFlatMapPublisher<T, R> extends Flowable<R> {
    final SingleSource<T> X;
    final Function<? super T, ? extends Publisher<? extends R>> Y;

    static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements SingleObserver<S>, FlowableSubscriber<T>, Subscription {
        private static final long X2 = 7759721921468635667L;
        final Function<? super S, ? extends Publisher<? extends T>> X;
        final AtomicReference<Subscription> Y = new AtomicReference<>();
        Disposable Z;
        final Subscriber<? super T> s;

        SingleFlatMapPublisherObserver(Subscriber<? super T> subscriber, Function<? super S, ? extends Publisher<? extends T>> function) {
            this.s = subscriber;
            this.X = function;
        }

        public void a(S s2) {
            try {
                Object apply = this.X.apply(s2);
                Objects.requireNonNull(apply, "the mapper returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                if (this.Y.get() != SubscriptionHelper.CANCELLED) {
                    publisher.e(this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void b(Disposable disposable) {
            this.Z = disposable;
            this.s.h(this);
        }

        public void cancel() {
            this.Z.m();
            SubscriptionHelper.a(this.Y);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this.Y, this, subscription);
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
            SubscriptionHelper.b(this.Y, this, j2);
        }
    }

    public SingleFlatMapPublisher(SingleSource<T> singleSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.X = singleSource;
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.e(new SingleFlatMapPublisherObserver(subscriber, this.Y));
    }
}
