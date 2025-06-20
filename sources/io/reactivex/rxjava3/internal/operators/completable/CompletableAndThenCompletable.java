package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenCompletable extends Completable {
    final CompletableSource X;
    final CompletableSource s;

    static final class NextObserver implements CompletableObserver {
        final CompletableObserver X;
        final AtomicReference<Disposable> s;

        NextObserver(AtomicReference<Disposable> atomicReference, CompletableObserver completableObserver) {
            this.s = atomicReference;
            this.X = completableObserver;
        }

        public void b(Disposable disposable) {
            DisposableHelper.c(this.s, disposable);
        }

        public void onComplete() {
            this.X.onComplete();
        }

        public void onError(Throwable th) {
            this.X.onError(th);
        }
    }

    static final class SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long Y = -4101678820158072998L;
        final CompletableSource X;
        final CompletableObserver s;

        SourceObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.s = completableObserver;
            this.X = completableSource;
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
            this.X.a(new NextObserver(this, this.s));
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public CompletableAndThenCompletable(CompletableSource completableSource, CompletableSource completableSource2) {
        this.s = completableSource;
        this.X = completableSource2;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.a(new SourceObserver(completableObserver, this.X));
    }
}
