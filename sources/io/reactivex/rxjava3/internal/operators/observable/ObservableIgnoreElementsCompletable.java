package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {
    final ObservableSource<T> s;

    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        Disposable X;
        final CompletableObserver s;

        IgnoreObservable(CompletableObserver completableObserver) {
            this.s = completableObserver;
        }

        public void b(Disposable disposable) {
            this.X = disposable;
            this.s.b(this);
        }

        public boolean g() {
            return this.X.g();
        }

        public void m() {
            this.X.m();
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

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.s = observableSource;
    }

    public void Z0(CompletableObserver completableObserver) {
        this.s.a(new IgnoreObservable(completableObserver));
    }

    public Observable<T> c() {
        return RxJavaPlugins.R(new ObservableIgnoreElements(this.s));
    }
}
