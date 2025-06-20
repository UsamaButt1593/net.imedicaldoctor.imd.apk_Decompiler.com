package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class CompletableDetach extends Completable {
    final CompletableSource s;

    static final class DetachCompletableObserver implements CompletableObserver, Disposable {
        Disposable X;
        CompletableObserver s;

        DetachCompletableObserver(CompletableObserver completableObserver) {
            this.s = completableObserver;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X, disposable)) {
                this.X = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.X.g();
        }

        public void m() {
            this.s = null;
            this.X.m();
            this.X = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.X = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.s;
            if (completableObserver != null) {
                this.s = null;
                completableObserver.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.X = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.s;
            if (completableObserver != null) {
                this.s = null;
                completableObserver.onError(th);
            }
        }
    }

    public CompletableDetach(CompletableSource completableSource) {
        this.s = completableSource;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.a(new DetachCompletableObserver(completableObserver));
    }
}
