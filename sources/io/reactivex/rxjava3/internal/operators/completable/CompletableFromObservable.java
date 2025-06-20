package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public final class CompletableFromObservable<T> extends Completable {
    final ObservableSource<T> s;

    static final class CompletableFromObservableObserver<T> implements Observer<T> {
        final CompletableObserver s;

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.s = completableObserver;
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
        }
    }

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.s = observableSource;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.a(new CompletableFromObservableObserver(completableObserver));
    }
}
