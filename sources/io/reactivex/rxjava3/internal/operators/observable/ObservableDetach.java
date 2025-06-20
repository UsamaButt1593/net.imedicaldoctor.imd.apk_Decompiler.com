package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;

public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {

    static final class DetachObserver<T> implements Observer<T>, Disposable {
        Disposable X;
        Observer<? super T> s;

        DetachObserver(Observer<? super T> observer) {
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
            Disposable disposable = this.X;
            this.X = EmptyComponent.INSTANCE;
            this.s = EmptyComponent.c();
            disposable.m();
        }

        public void onComplete() {
            Observer<? super T> observer = this.s;
            this.X = EmptyComponent.INSTANCE;
            this.s = EmptyComponent.c();
            observer.onComplete();
        }

        public void onError(Throwable th) {
            Observer<? super T> observer = this.s;
            this.X = EmptyComponent.INSTANCE;
            this.s = EmptyComponent.c();
            observer.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    public ObservableDetach(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new DetachObserver(observer));
    }
}
