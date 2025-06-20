package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUsing<T, D> extends Flowable<T> {
    final Supplier<? extends D> X;
    final boolean X2;
    final Function<? super D, ? extends Publisher<? extends T>> Y;
    final Consumer<? super D> Z;

    static final class UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long Y2 = 5904473792286235046L;
        final D X;
        Subscription X2;
        final Consumer<? super D> Y;
        final boolean Z;
        final Subscriber<? super T> s;

        UsingSubscriber(Subscriber<? super T> subscriber, D d2, Consumer<? super D> consumer, boolean z) {
            this.s = subscriber;
            this.X = d2;
            this.Y = consumer;
            this.Z = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.Y.accept(this.X);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
            }
        }

        public void cancel() {
            if (this.Z) {
                a();
                this.X2.cancel();
                this.X2 = SubscriptionHelper.CANCELLED;
                return;
            }
            this.X2.cancel();
            this.X2 = SubscriptionHelper.CANCELLED;
            a();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X2, subscription)) {
                this.X2 = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            if (this.Z) {
                if (compareAndSet(false, true)) {
                    try {
                        this.Y.accept(this.X);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.s.onError(th);
                        return;
                    }
                }
                this.X2.cancel();
                this.s.onComplete();
                return;
            }
            this.s.onComplete();
            this.X2.cancel();
            a();
        }

        public void onError(Throwable th) {
            Throwable th2;
            if (this.Z) {
                if (compareAndSet(false, true)) {
                    try {
                        this.Y.accept(this.X);
                    } catch (Throwable th3) {
                        th2 = th3;
                        Exceptions.b(th2);
                    }
                }
                th2 = null;
                this.X2.cancel();
                if (th2 != null) {
                    this.s.onError(new CompositeException(th, th2));
                    return;
                }
                this.s.onError(th);
                return;
            }
            this.s.onError(th);
            this.X2.cancel();
            a();
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }

        public void request(long j2) {
            this.X2.request(j2);
        }
    }

    public FlowableUsing(Supplier<? extends D> supplier, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.X = supplier;
        this.Y = function;
        this.Z = consumer;
        this.X2 = z;
    }

    public void K6(Subscriber<? super T> subscriber) {
        try {
            Object obj = this.X.get();
            try {
                Object apply = this.Y.apply(obj);
                Objects.requireNonNull(apply, "The sourceSupplier returned a null Publisher");
                ((Publisher) apply).e(new UsingSubscriber(subscriber, obj, this.Z, this.X2));
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptySubscription.b(new CompositeException(th, th), subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptySubscription.b(th2, subscriber);
        }
    }
}
