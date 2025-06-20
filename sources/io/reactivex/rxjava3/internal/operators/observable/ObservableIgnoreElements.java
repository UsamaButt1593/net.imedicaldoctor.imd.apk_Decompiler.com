package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public final class ObservableIgnoreElements<T> extends AbstractObservableWithUpstream<T, T> {

    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        Disposable X;
        final Observer<? super T> s;

        IgnoreObservable(Observer<? super T> observer) {
            this.s = observer;
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

    public ObservableIgnoreElements(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new IgnoreObservable(observer));
    }
}
