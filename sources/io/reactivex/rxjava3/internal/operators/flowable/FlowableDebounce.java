package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, ? extends Publisher<U>> Y;

    static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long Z2 = 6725975399620862591L;
        final Function<? super T, ? extends Publisher<U>> X;
        volatile long X2;
        Subscription Y;
        boolean Y2;
        final AtomicReference<Disposable> Z = new AtomicReference<>();
        final Subscriber<? super T> s;

        static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {
            final DebounceSubscriber<T, U> X;
            boolean X2;
            final long Y;
            final AtomicBoolean Y2 = new AtomicBoolean();
            final T Z;

            DebounceInnerSubscriber(DebounceSubscriber<T, U> debounceSubscriber, long j2, T t) {
                this.X = debounceSubscriber;
                this.Y = j2;
                this.Z = t;
            }

            /* access modifiers changed from: package-private */
            public void d() {
                if (this.Y2.compareAndSet(false, true)) {
                    this.X.a(this.Y, this.Z);
                }
            }

            public void onComplete() {
                if (!this.X2) {
                    this.X2 = true;
                    d();
                }
            }

            public void onError(Throwable th) {
                if (this.X2) {
                    RxJavaPlugins.Y(th);
                    return;
                }
                this.X2 = true;
                this.X.onError(th);
            }

            public void onNext(U u) {
                if (!this.X2) {
                    this.X2 = true;
                    a();
                    d();
                }
            }
        }

        DebounceSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<U>> function) {
            this.s = subscriber;
            this.X = function;
        }

        /* access modifiers changed from: package-private */
        public void a(long j2, T t) {
            if (j2 != this.X2) {
                return;
            }
            if (get() != 0) {
                this.s.onNext(t);
                BackpressureHelper.e(this, 1);
                return;
            }
            cancel();
            this.s.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }

        public void cancel() {
            this.Y.cancel();
            DisposableHelper.a(this.Z);
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                this.s.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            if (!this.Y2) {
                this.Y2 = true;
                Disposable disposable = this.Z.get();
                if (!DisposableHelper.b(disposable)) {
                    DebounceInnerSubscriber debounceInnerSubscriber = (DebounceInnerSubscriber) disposable;
                    if (debounceInnerSubscriber != null) {
                        debounceInnerSubscriber.d();
                    }
                    DisposableHelper.a(this.Z);
                    this.s.onComplete();
                }
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.Z);
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Y2) {
                long j2 = this.X2 + 1;
                this.X2 = j2;
                Disposable disposable = this.Z.get();
                if (disposable != null) {
                    disposable.m();
                }
                try {
                    Object apply = this.X.apply(t);
                    Objects.requireNonNull(apply, "The publisher supplied is null");
                    Publisher publisher = (Publisher) apply;
                    DebounceInnerSubscriber debounceInnerSubscriber = new DebounceInnerSubscriber(this, j2, t);
                    if (g.a(this.Z, disposable, debounceInnerSubscriber)) {
                        publisher.e(debounceInnerSubscriber);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    this.s.onError(th);
                }
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this, j2);
            }
        }
    }

    public FlowableDebounce(Flowable<T> flowable, Function<? super T, ? extends Publisher<U>> function) {
        super(flowable);
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new DebounceSubscriber(new SerializedSubscriber(subscriber), this.Y));
    }
}
