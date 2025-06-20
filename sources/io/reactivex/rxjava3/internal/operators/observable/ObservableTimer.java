package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimer extends Observable<Long> {
    final long X;
    final TimeUnit Y;
    final Scheduler s;

    static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long X = -2809475196591179431L;
        final Observer<? super Long> s;

        TimerObserver(Observer<? super Long> observer) {
            this.s = observer;
        }

        public void a(Disposable disposable) {
            DisposableHelper.i(this, disposable);
        }

        public boolean g() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void run() {
            if (!g()) {
                this.s.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.s.onComplete();
            }
        }
    }

    public ObservableTimer(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.X = j2;
        this.Y = timeUnit;
        this.s = scheduler;
    }

    public void g6(Observer<? super Long> observer) {
        TimerObserver timerObserver = new TimerObserver(observer);
        observer.b(timerObserver);
        timerObserver.a(this.s.h(timerObserver, this.X, this.Y));
    }
}
