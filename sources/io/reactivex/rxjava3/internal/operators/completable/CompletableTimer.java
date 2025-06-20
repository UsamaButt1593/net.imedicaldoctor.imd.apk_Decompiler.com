package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTimer extends Completable {
    final TimeUnit X;
    final Scheduler Y;
    final long s;

    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long X = 3167244060586201109L;
        final CompletableObserver s;

        TimerDisposable(CompletableObserver completableObserver) {
            this.s = completableObserver;
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
            this.s.onComplete();
        }
    }

    public CompletableTimer(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.s = j2;
        this.X = timeUnit;
        this.Y = scheduler;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.b(timerDisposable);
        timerDisposable.a(this.Y.h(timerDisposable, this.s, this.X));
    }
}
