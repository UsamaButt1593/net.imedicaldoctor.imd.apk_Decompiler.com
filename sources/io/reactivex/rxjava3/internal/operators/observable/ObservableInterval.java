package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableInterval extends Observable<Long> {
    final long X;
    final long Y;
    final TimeUnit Z;
    final Scheduler s;

    static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long Y = 346773832286157679L;
        long X;
        final Observer<? super Long> s;

        IntervalObserver(Observer<? super Long> observer) {
            this.s = observer;
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
            if (get() != DisposableHelper.DISPOSED) {
                Observer<? super Long> observer = this.s;
                long j2 = this.X;
                this.X = 1 + j2;
                observer.onNext(Long.valueOf(j2));
            }
        }
    }

    public ObservableInterval(long j2, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        this.X = j2;
        this.Y = j3;
        this.Z = timeUnit;
        this.s = scheduler;
    }

    public void g6(Observer<? super Long> observer) {
        IntervalObserver intervalObserver = new IntervalObserver(observer);
        observer.b(intervalObserver);
        Scheduler scheduler = this.s;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker d2 = scheduler.d();
            intervalObserver.a(d2);
            d2.d(intervalObserver, this.X, this.Y, this.Z);
            return;
        }
        intervalObserver.a(scheduler.i(intervalObserver, this.X, this.Y, this.Z));
    }
}
