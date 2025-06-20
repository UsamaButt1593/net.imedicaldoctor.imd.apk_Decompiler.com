package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler X2;
    final long Y;
    final boolean Y2;
    final TimeUnit Z;

    static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final long X;
        final boolean X2;
        final TimeUnit Y;
        Subscription Y2;
        final Scheduler.Worker Z;
        final Subscriber<? super T> s;

        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                try {
                    DelaySubscriber.this.s.onComplete();
                } finally {
                    DelaySubscriber.this.Z.m();
                }
            }
        }

        final class OnError implements Runnable {
            private final Throwable s;

            OnError(Throwable th) {
                this.s = th;
            }

            public void run() {
                try {
                    DelaySubscriber.this.s.onError(this.s);
                } finally {
                    DelaySubscriber.this.Z.m();
                }
            }
        }

        final class OnNext implements Runnable {
            private final T s;

            OnNext(T t) {
                this.s = t;
            }

            public void run() {
                DelaySubscriber.this.s.onNext(this.s);
            }
        }

        DelaySubscriber(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.s = subscriber;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = worker;
            this.X2 = z;
        }

        public void cancel() {
            this.Y2.cancel();
            this.Z.m();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y2, subscription)) {
                this.Y2 = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            this.Z.c(new OnComplete(), this.X, this.Y);
        }

        public void onError(Throwable th) {
            this.Z.c(new OnError(th), this.X2 ? this.X : 0, this.Y);
        }

        public void onNext(T t) {
            this.Z.c(new OnNext(t), this.X, this.Y);
        }

        public void request(long j2) {
            this.Y2.request(j2);
        }
    }

    public FlowableDelay(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.Y = j2;
        this.Z = timeUnit;
        this.X2 = scheduler;
        this.Y2 = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new DelaySubscriber(this.Y2 ? subscriber : new SerializedSubscriber(subscriber), this.Y, this.Z, this.X2.d(), this.Y2));
    }
}
