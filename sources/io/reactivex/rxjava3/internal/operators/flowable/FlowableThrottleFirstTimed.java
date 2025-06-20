package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableThrottleFirstTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler X2;
    final long Y;
    final TimeUnit Z;

    static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long b3 = -9102637559663639004L;
        final long X;
        Subscription X2;
        final TimeUnit Y;
        final SequentialDisposable Y2 = new SequentialDisposable();
        final Scheduler.Worker Z;
        volatile boolean Z2;
        boolean a3;
        final Subscriber<? super T> s;

        DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.s = subscriber;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = worker;
        }

        public void cancel() {
            this.X2.cancel();
            this.Z.m();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X2, subscription)) {
                this.X2 = subscription;
                this.s.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            if (!this.a3) {
                this.a3 = true;
                this.s.onComplete();
                this.Z.m();
            }
        }

        public void onError(Throwable th) {
            if (this.a3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.a3 = true;
            this.s.onError(th);
            this.Z.m();
        }

        public void onNext(T t) {
            if (!this.a3 && !this.Z2) {
                this.Z2 = true;
                if (get() != 0) {
                    this.s.onNext(t);
                    BackpressureHelper.e(this, 1);
                    Disposable disposable = (Disposable) this.Y2.get();
                    if (disposable != null) {
                        disposable.m();
                    }
                    this.Y2.a(this.Z.c(this, this.X, this.Y));
                    return;
                }
                this.a3 = true;
                cancel();
                this.s.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this, j2);
            }
        }

        public void run() {
            this.Z2 = false;
        }
    }

    public FlowableThrottleFirstTimed(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.Y = j2;
        this.Z = timeUnit;
        this.X2 = scheduler;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.Y, this.Z, this.X2.d()));
    }
}
