package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableObserveOn extends Completable {
    final Scheduler X;
    final CompletableSource s;

    static final class ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long Z = 8571289934935992137L;
        final Scheduler X;
        Throwable Y;
        final CompletableObserver s;

        ObserveOnCompletableObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.s = completableObserver;
            this.X = scheduler;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable)) {
                this.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            DisposableHelper.c(this, this.X.f(this));
        }

        public void onError(Throwable th) {
            this.Y = th;
            DisposableHelper.c(this, this.X.f(this));
        }

        public void run() {
            Throwable th = this.Y;
            if (th != null) {
                this.Y = null;
                this.s.onError(th);
                return;
            }
            this.s.onComplete();
        }
    }

    public CompletableObserveOn(CompletableSource completableSource, Scheduler scheduler) {
        this.s = completableSource;
        this.X = scheduler;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.a(new ObserveOnCompletableObserver(completableObserver, this.X));
    }
}
