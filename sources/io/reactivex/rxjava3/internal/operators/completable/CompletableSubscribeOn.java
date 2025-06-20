package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubscribeOn extends Completable {
    final Scheduler X;
    final CompletableSource s;

    static final class SubscribeOnObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long Z = 7000911171163930287L;
        final SequentialDisposable X = new SequentialDisposable();
        final CompletableSource Y;
        final CompletableObserver s;

        SubscribeOnObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.s = completableObserver;
            this.Y = completableSource;
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
            this.X.m();
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void run() {
            this.Y.a(this);
        }
    }

    public CompletableSubscribeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.s = completableSource;
        this.X = scheduler;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(completableObserver, this.s);
        completableObserver.b(subscribeOnObserver);
        subscribeOnObserver.X.a(this.X.f(subscribeOnObserver));
    }
}
