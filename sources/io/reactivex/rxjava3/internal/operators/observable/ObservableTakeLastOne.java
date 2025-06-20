package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableTakeLastOne<T> extends AbstractObservableWithUpstream<T, T> {

    static final class TakeLastOneObserver<T> implements Observer<T>, Disposable {
        Disposable X;
        T Y;
        final Observer<? super T> s;

        TakeLastOneObserver(Observer<? super T> observer) {
            this.s = observer;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            T t = this.Y;
            if (t != null) {
                this.Y = null;
                this.s.onNext(t);
            }
            this.s.onComplete();
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
            this.Y = null;
            this.X.m();
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th) {
            this.Y = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.Y = t;
        }
    }

    public ObservableTakeLastOne(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new TakeLastOneObserver(observer));
    }
}
