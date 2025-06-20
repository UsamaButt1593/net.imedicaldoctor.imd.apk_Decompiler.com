package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableIntervalRange extends Observable<Long> {
    final long X;
    final long X2;
    final long Y;
    final TimeUnit Y2;
    final long Z;
    final Scheduler s;

    static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long Z = 1891866368734007884L;
        final long X;
        long Y;
        final Observer<? super Long> s;

        IntervalRangeObserver(Observer<? super Long> observer, long j2, long j3) {
            this.s = observer;
            this.Y = j2;
            this.X = j3;
        }

        public void a(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public boolean g() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void run() {
            if (!g()) {
                long j2 = this.Y;
                this.s.onNext(Long.valueOf(j2));
                if (j2 == this.X) {
                    if (!g()) {
                        this.s.onComplete();
                    }
                    DisposableHelper.a(this);
                    return;
                }
                this.Y = j2 + 1;
            }
        }
    }

    public ObservableIntervalRange(long j2, long j3, long j4, long j5, TimeUnit timeUnit, Scheduler scheduler) {
        this.Z = j4;
        this.X2 = j5;
        this.Y2 = timeUnit;
        this.s = scheduler;
        this.X = j2;
        this.Y = j3;
    }

    public void g6(Observer<? super Long> observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.X, this.Y);
        observer.b(intervalRangeObserver);
        Scheduler scheduler = this.s;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker d2 = scheduler.d();
            intervalRangeObserver.a(d2);
            d2.d(intervalRangeObserver, this.Z, this.X2, this.Y2);
            return;
        }
        intervalRangeObserver.a(scheduler.i(intervalRangeObserver, this.Z, this.X2, this.Y2));
    }
}
