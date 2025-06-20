package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableTimeout extends Completable {
    final long X;
    final CompletableSource X2;
    final TimeUnit Y;
    final Scheduler Z;
    final CompletableSource s;

    final class DisposeTask implements Runnable {
        final CompositeDisposable X;
        final CompletableObserver Y;
        private final AtomicBoolean s;

        final class DisposeObserver implements CompletableObserver {
            DisposeObserver() {
            }

            public void b(Disposable disposable) {
                DisposeTask.this.X.b(disposable);
            }

            public void onComplete() {
                DisposeTask.this.X.m();
                DisposeTask.this.Y.onComplete();
            }

            public void onError(Throwable th) {
                DisposeTask.this.X.m();
                DisposeTask.this.Y.onError(th);
            }
        }

        DisposeTask(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.s = atomicBoolean;
            this.X = compositeDisposable;
            this.Y = completableObserver;
        }

        public void run() {
            if (this.s.compareAndSet(false, true)) {
                this.X.e();
                CompletableSource completableSource = CompletableTimeout.this.X2;
                if (completableSource == null) {
                    CompletableObserver completableObserver = this.Y;
                    CompletableTimeout completableTimeout = CompletableTimeout.this;
                    completableObserver.onError(new TimeoutException(ExceptionHelper.h(completableTimeout.X, completableTimeout.Y)));
                    return;
                }
                completableSource.a(new DisposeObserver());
            }
        }
    }

    static final class TimeOutObserver implements CompletableObserver {
        private final AtomicBoolean X;
        private final CompletableObserver Y;
        private final CompositeDisposable s;

        TimeOutObserver(CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
            this.s = compositeDisposable;
            this.X = atomicBoolean;
            this.Y = completableObserver;
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public void onComplete() {
            if (this.X.compareAndSet(false, true)) {
                this.s.m();
                this.Y.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.X.compareAndSet(false, true)) {
                this.s.m();
                this.Y.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }
    }

    public CompletableTimeout(CompletableSource completableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource2) {
        this.s = completableSource;
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
        this.X2 = completableSource2;
    }

    public void Z0(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.b(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.b(this.Z.h(new DisposeTask(atomicBoolean, compositeDisposable, completableObserver), this.X, this.Y));
        this.s.a(new TimeOutObserver(compositeDisposable, atomicBoolean, completableObserver));
    }
}
