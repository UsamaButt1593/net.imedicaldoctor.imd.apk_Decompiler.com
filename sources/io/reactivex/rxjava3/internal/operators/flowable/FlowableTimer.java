package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimer extends Flowable<Long> {
    final Scheduler X;
    final long Y;
    final TimeUnit Z;

    static final class TimerSubscriber extends AtomicReference<Disposable> implements Subscription, Runnable {
        private static final long Y = -2809475196591179431L;
        volatile boolean X;
        final Subscriber<? super Long> s;

        TimerSubscriber(Subscriber<? super Long> subscriber) {
            this.s = subscriber;
        }

        public void a(Disposable disposable) {
            DisposableHelper.i(this, disposable);
        }

        public void cancel() {
            DisposableHelper.a(this);
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                this.X = true;
            }
        }

        public void run() {
            if (get() == DisposableHelper.DISPOSED) {
                return;
            }
            if (this.X) {
                this.s.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.s.onComplete();
                return;
            }
            lazySet(EmptyDisposable.INSTANCE);
            this.s.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }
    }

    public FlowableTimer(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.Y = j2;
        this.Z = timeUnit;
        this.X = scheduler;
    }

    public void K6(Subscriber<? super Long> subscriber) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(subscriber);
        subscriber.h(timerSubscriber);
        timerSubscriber.a(this.X.h(timerSubscriber, this.Y, this.Z));
    }
}
