package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZipIterable<T, U, V> extends AbstractFlowableWithUpstream<T, V> {
    final Iterable<U> Y;
    final BiFunction<? super T, ? super U, ? extends V> Z;

    static final class ZipIterableSubscriber<T, U, V> implements FlowableSubscriber<T>, Subscription {
        final Iterator<U> X;
        boolean X2;
        final BiFunction<? super T, ? super U, ? extends V> Y;
        Subscription Z;
        final Subscriber<? super V> s;

        ZipIterableSubscriber(Subscriber<? super V> subscriber, Iterator<U> it2, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.s = subscriber;
            this.X = it2;
            this.Y = biFunction;
        }

        /* access modifiers changed from: package-private */
        public void a(Throwable th) {
            Exceptions.b(th);
            this.X2 = true;
            this.Z.cancel();
            this.s.onError(th);
        }

        public void cancel() {
            this.Z.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z, subscription)) {
                this.Z = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            if (!this.X2) {
                this.X2 = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.X2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X2 = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.X2) {
                try {
                    U next = this.X.next();
                    Objects.requireNonNull(next, "The iterator returned a null value");
                    try {
                        Object apply = this.Y.apply(t, next);
                        Objects.requireNonNull(apply, "The zipper function returned a null value");
                        this.s.onNext(apply);
                        try {
                            if (!this.X.hasNext()) {
                                this.X2 = true;
                                this.Z.cancel();
                                this.s.onComplete();
                            }
                        } catch (Throwable th) {
                            a(th);
                        }
                    } catch (Throwable th2) {
                        a(th2);
                    }
                } catch (Throwable th3) {
                    a(th3);
                }
            }
        }

        public void request(long j2) {
            this.Z.request(j2);
        }
    }

    public FlowableZipIterable(Flowable<T> flowable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        super(flowable);
        this.Y = iterable;
        this.Z = biFunction;
    }

    public void K6(Subscriber<? super V> subscriber) {
        try {
            Iterator<U> it2 = this.Y.iterator();
            Objects.requireNonNull(it2, "The iterator returned by other is null");
            Iterator it3 = it2;
            try {
                if (!it3.hasNext()) {
                    EmptySubscription.a(subscriber);
                } else {
                    this.X.J6(new ZipIterableSubscriber(subscriber, it3, this.Z));
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptySubscription.b(th, subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptySubscription.b(th2, subscriber);
        }
    }
}
