package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimer extends Maybe<Long> {
    final TimeUnit X;
    final Scheduler Y;
    final long s;

    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long X = 2875964065294031672L;
        final MaybeObserver<? super Long> s;

        TimerDisposable(MaybeObserver<? super Long> maybeObserver) {
            this.s = maybeObserver;
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

    public MaybeTimer(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.s = j2;
        this.X = timeUnit;
        this.Y = scheduler;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super Long> maybeObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(maybeObserver);
        maybeObserver.b(timerDisposable);
        timerDisposable.a(this.Y.h(timerDisposable, this.s, this.X));
    }
}
