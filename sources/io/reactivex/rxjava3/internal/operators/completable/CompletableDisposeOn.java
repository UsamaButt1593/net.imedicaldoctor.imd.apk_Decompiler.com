package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class CompletableDisposeOn extends Completable {
    final Scheduler X;
    final CompletableSource s;

    static final class DisposeOnObserver implements CompletableObserver, Disposable, Runnable {
        final Scheduler X;
        Disposable Y;
        volatile boolean Z;
        final CompletableObserver s;

        DisposeOnObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.s = completableObserver;
            this.X = scheduler;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z;
        }

        public void m() {
            this.Z = true;
            this.X.f(this);
        }

        public void onComplete() {
            if (!this.Z) {
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
            } else {
                this.s.onError(th);
            }
        }

        public void run() {
            this.Y.m();
            this.Y = DisposableHelper.DISPOSED;
        }
    }

    public CompletableDisposeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.s = completableSource;
        this.X = scheduler;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.a(new DisposeOnObserver(completableObserver, this.X));
    }
}
