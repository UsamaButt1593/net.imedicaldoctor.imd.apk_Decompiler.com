package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {

    static final class MaterializeObserver<T> implements Observer<T>, Disposable {
        Disposable X;
        final Observer<? super Notification<T>> s;

        MaterializeObserver(Observer<? super Notification<T>> observer) {
            this.s = observer;
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
            this.X.m();
        }

        public void onComplete() {
            this.s.onNext(Notification.a());
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onNext(Notification.b(th));
            this.s.onComplete();
        }

        public void onNext(T t) {
            this.s.onNext(Notification.c(t));
        }
    }

    public ObservableMaterialize(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void g6(Observer<? super Notification<T>> observer) {
        this.s.a(new MaterializeObserver(observer));
    }
}
