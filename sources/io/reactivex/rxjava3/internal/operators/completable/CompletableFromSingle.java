package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;

public final class CompletableFromSingle<T> extends Completable {
    final SingleSource<T> s;

    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {
        final CompletableObserver s;

        CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.s = completableObserver;
        }

        public void a(T t) {
            this.s.onComplete();
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.s = singleSource;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.e(new CompletableFromSingleObserver(completableObserver));
    }
}
