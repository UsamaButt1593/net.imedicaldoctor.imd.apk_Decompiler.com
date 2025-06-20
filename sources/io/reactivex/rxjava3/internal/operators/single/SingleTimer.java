package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimer extends Single<Long> {
    final TimeUnit X;
    final Scheduler Y;
    final long s;

    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long X = 8465401857522493082L;
        final SingleObserver<? super Long> s;

        TimerDisposable(SingleObserver<? super Long> singleObserver) {
            this.s = singleObserver;
        }

        /* access modifiers changed from: package-private */
        public void a(Disposable disposable) {
            DisposableHelper.c(this, disposable);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void run() {
            this.s.a(0L);
        }
    }

    public SingleTimer(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.s = j2;
        this.X = timeUnit;
        this.Y = scheduler;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Long> singleObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(singleObserver);
        singleObserver.b(timerDisposable);
        timerDisposable.a(this.Y.h(timerDisposable, this.s, this.X));
    }
}
