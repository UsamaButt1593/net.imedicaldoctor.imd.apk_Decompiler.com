package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScan<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiFunction<T, T, T> Y;

    static final class ScanSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final BiFunction<T, T, T> X;
        boolean X2;
        Subscription Y;
        T Z;
        final Subscriber<? super T> s;

        ScanSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            this.s = subscriber;
            this.X = biFunction;
        }

        public void cancel() {
            this.Y.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
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
                Subscriber<? super T> subscriber = this.s;
                T t2 = this.Z;
                if (t2 != null) {
                    try {
                        t = this.X.apply(t2, t);
                        Objects.requireNonNull(t, "The value returned by the accumulator is null");
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.Y.cancel();
                        onError(th);
                        return;
                    }
                }
                this.Z = t;
                subscriber.onNext(t);
            }
        }

        public void request(long j2) {
            this.Y.request(j2);
        }
    }

    public FlowableScan(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.Y = biFunction;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new ScanSubscriber(subscriber, this.Y));
    }
}
