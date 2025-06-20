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

public final class FlowableIntervalRange extends Flowable<Long> {
    final Scheduler X;
    final long X2;
    final long Y;
    final long Y2;
    final long Z;
    final TimeUnit Z2;

    static final class IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long X2 = -2809475196591179431L;
        final long X;
        long Y;
        final AtomicReference<Disposable> Z = new AtomicReference<>();
        final Subscriber<? super Long> s;

        IntervalRangeSubscriber(Subscriber<? super Long> subscriber, long j2, long j3) {
            this.s = subscriber;
            this.Y = j2;
            this.X = j3;
        }

        public void a(Disposable disposable) {
            DisposableHelper.h(this.Z, disposable);
        }

        public void cancel() {
            DisposableHelper.a(this.Z);
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this, j2);
            }
        }

        public void run() {
            Disposable disposable = this.Z.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                long j2 = get();
                if (j2 != 0) {
                    long j3 = this.Y;
                    this.s.onNext(Long.valueOf(j3));
                    if (j3 == this.X) {
                        if (this.Z.get() != disposableHelper) {
                            this.s.onComplete();
                        }
                        DisposableHelper.a(this.Z);
                        return;
                    }
                    this.Y = j3 + 1;
                    if (j2 != Long.MAX_VALUE) {
                        decrementAndGet();
                        return;
                    }
                    return;
                }
                Subscriber<? super Long> subscriber = this.s;
                subscriber.onError(new MissingBackpressureException("Can't deliver value " + this.Y + " due to lack of requests"));
                DisposableHelper.a(this.Z);
            }
        }
    }

    public FlowableIntervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit, Scheduler scheduler) {
        this.X2 = j4;
        this.Y2 = j5;
        this.Z2 = timeUnit;
        this.X = scheduler;
        this.Y = j2;
        this.Z = j3;
    }

    public void K6(Subscriber<? super Long> subscriber) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(subscriber, this.Y, this.Z);
        subscriber.h(intervalRangeSubscriber);
        Scheduler scheduler = this.X;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker d2 = scheduler.d();
            intervalRangeSubscriber.a(d2);
            d2.d(intervalRangeSubscriber, this.X2, this.Y2, this.Z2);
            return;
        }
        intervalRangeSubscriber.a(scheduler.i(intervalRangeSubscriber, this.X2, this.Y2, this.Z2));
    }
}
