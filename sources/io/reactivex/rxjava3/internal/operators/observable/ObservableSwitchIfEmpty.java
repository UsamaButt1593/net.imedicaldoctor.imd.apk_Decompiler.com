package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;

public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends T> X;

    static final class SwitchIfEmptyObserver<T> implements Observer<T> {
        final ObservableSource<? extends T> X;
        final SequentialDisposable Y = new SequentialDisposable();
        boolean Z = true;
        final Observer<? super T> s;

        SwitchIfEmptyObserver(Observer<? super T> observer, ObservableSource<? extends T> observableSource) {
            this.s = observer;
            this.X = observableSource;
        }

        public void b(Disposable disposable) {
            this.Y.b(disposable);
        }

        public void onComplete() {
            if (this.Z) {
                this.Z = false;
                this.X.a(this);
                return;
            }
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (this.Z) {
                this.Z = false;
            }
            this.s.onNext(t);
        }
    }

    public ObservableSwitchIfEmpty(ObservableSource<T> observableSource, ObservableSource<? extends T> observableSource2) {
        super(observableSource);
        this.X = observableSource2;
    }

    public void g6(Observer<? super T> observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.X);
        observer.b(switchIfEmptyObserver.Y);
        this.s.a(switchIfEmptyObserver);
    }
}
