package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeFlatMapPublisher<T, R> extends Flowable<R> {
    final MaybeSource<T> X;
    final Function<? super T, ? extends Publisher<? extends R>> Y;

    static final class FlatMapPublisherSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, MaybeObserver<T>, Subscription {
        private static final long X2 = -8948264376121066672L;
        final Function<? super T, ? extends Publisher<? extends R>> X;
        Disposable Y;
        final AtomicLong Z = new AtomicLong();
        final Subscriber<? super R> s;

        FlatMapPublisherSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.s = subscriber;
            this.X = function;
        }

        public void a(T t) {
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                if (get() != SubscriptionHelper.CANCELLED) {
                    publisher.e(this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.h(this);
            }
        }

        public void cancel() {
            this.Y.m();
            SubscriptionHelper.a(this);
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this, this.Z, subscription);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(R r) {
            this.s.onNext(r);
        }

        public void request(long j2) {
            SubscriptionHelper.b(this, this.Z, j2);
        }
    }

    public MaybeFlatMapPublisher(MaybeSource<T> maybeSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.X = maybeSource;
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.d(new FlatMapPublisherSubscriber(subscriber, this.Y));
    }
}
