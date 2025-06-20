package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableInterval extends Flowable<Long> {
    final Scheduler X;
    final TimeUnit X2;
    final long Y;
    final long Z;

    static final class IntervalSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long Z = -2809475196591179431L;
        long X;
        final AtomicReference<Disposable> Y = new AtomicReference<>();
        final Subscriber<? super Long> s;

        IntervalSubscriber(Subscriber<? super Long> subscriber) {
            this.s = subscriber;
        }

        public void a(Disposable disposable) {
            DisposableHelper.h(this.Y, disposable);
        }

        public void cancel() {
            DisposableHelper.a(this.Y);
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this, j2);
            }
        }

        public void run() {
            if (this.Y.get() != DisposableHelper.DISPOSED) {
                int i2 = (get() > 0 ? 1 : (get() == 0 ? 0 : -1));
                Subscriber<? super Long> subscriber = this.s;
                if (i2 != 0) {
                    long j2 = this.X;
                    this.X = j2 + 1;
                    subscriber.onNext(Long.valueOf(j2));
                    BackpressureHelper.e(this, 1);
                    return;
                }
                subscriber.onError(new MissingBackpressureException("Can't deliver value " + this.X + " due to lack of requests"));
                DisposableHelper.a(this.Y);
            }
        }
    }

    public FlowableInterval(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        this.Y = j2;
        this.Z = j3;
        this.X2 = timeUnit;
        this.X = scheduler;
    }

    public void K6(Subscriber<? super Long> subscriber) {
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(subscriber);
        subscriber.h(intervalSubscriber);
        Scheduler scheduler = this.X;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker d2 = scheduler.d();
            intervalSubscriber.a(d2);
            d2.d(intervalSubscriber, this.Y, this.Z, this.X2);
            return;
        }
        intervalSubscriber.a(scheduler.i(intervalSubscriber, this.Y, this.Z, this.X2));
    }
}
