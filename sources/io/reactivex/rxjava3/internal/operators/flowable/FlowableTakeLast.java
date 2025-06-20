package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLast<T> extends AbstractFlowableWithUpstream<T, T> {
    final int Y;

    static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long a3 = 7240042530241604978L;
        final int X;
        volatile boolean X2;
        Subscription Y;
        final AtomicLong Y2 = new AtomicLong();
        volatile boolean Z;
        final AtomicInteger Z2 = new AtomicInteger();
        final Subscriber<? super T> s;

        TakeLastSubscriber(Subscriber<? super T> subscriber, int i2) {
            this.s = subscriber;
            this.X = i2;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.Z2.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.s;
                long j2 = this.Y2.get();
                while (!this.X2) {
                    if (this.Z) {
                        long j3 = 0;
                        while (j3 != j2) {
                            if (!this.X2) {
                                Object poll = poll();
                                if (poll == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onNext(poll);
                                    j3++;
                                }
                            } else {
                                return;
                            }
                        }
                        if (isEmpty()) {
                            subscriber.onComplete();
                            return;
                        } else if (j3 != 0) {
                            j2 = BackpressureHelper.e(this.Y2, j3);
                        }
                    }
                    if (this.Z2.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void cancel() {
            this.X2 = true;
            this.Y.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                this.s.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.Z = true;
            b();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (this.X == size()) {
                poll();
            }
            offer(t);
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Y2, j2);
                b();
            }
        }
    }

    public FlowableTakeLast(Flowable<T> flowable, int i2) {
        super(flowable);
        this.Y = i2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new TakeLastSubscriber(subscriber, this.Y));
    }
}
