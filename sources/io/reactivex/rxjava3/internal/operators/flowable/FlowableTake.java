package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {
    final long Y;

    static final class TakeSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long Z = 2288246011222124525L;
        long X;
        Subscription Y;
        final Subscriber<? super T> s;

        TakeSubscriber(Subscriber<? super T> subscriber, long j2) {
            this.s = subscriber;
            this.X = j2;
            lazySet(j2);
        }

        public void cancel() {
            this.Y.cancel();
        }

        public void h(Subscription subscription) {
            if (!SubscriptionHelper.l(this.Y, subscription)) {
                return;
            }
            if (this.X == 0) {
                subscription.cancel();
                EmptySubscription.a(this.s);
                return;
            }
            this.Y = subscription;
            this.s.h(this);
        }

        public void onComplete() {
            if (this.X > 0) {
                this.X = 0;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.X > 0) {
                this.X = 0;
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            long j2 = this.X;
            if (j2 > 0) {
                long j3 = j2 - 1;
                this.X = j3;
                this.s.onNext(t);
                if (j3 == 0) {
                    this.Y.cancel();
                    this.s.onComplete();
                }
            }
        }

        public void request(long j2) {
            long j3;
            long min;
            if (SubscriptionHelper.k(j2)) {
                do {
                    j3 = get();
                    if (j3 != 0) {
                        min = Math.min(j3, j2);
                    } else {
                        return;
                    }
                } while (!compareAndSet(j3, j3 - min));
                this.Y.request(min);
            }
        }
    }

    public FlowableTake(Flowable<T> flowable, long j2) {
        super(flowable);
        this.Y = j2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new TakeSubscriber(subscriber, this.Y));
    }
}
