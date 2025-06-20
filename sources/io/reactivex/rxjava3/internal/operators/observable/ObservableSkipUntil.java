package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;

public final class ObservableSkipUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<U> X;

    final class SkipUntil implements Observer<U> {
        final SkipUntilObserver<T> X;
        final SerializedObserver<T> Y;
        Disposable Z;
        final ArrayCompositeDisposable s;

        SkipUntil(ArrayCompositeDisposable arrayCompositeDisposable, SkipUntilObserver<T> skipUntilObserver, SerializedObserver<T> serializedObserver) {
            this.s = arrayCompositeDisposable;
            this.X = skipUntilObserver;
            this.Y = serializedObserver;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.s.b(1, disposable);
            }
        }

        public void onComplete() {
            this.X.Z = true;
        }

        public void onError(Throwable th) {
            this.s.m();
            this.Y.onError(th);
        }

        public void onNext(U u) {
            this.Z.m();
            this.X.Z = true;
        }
    }

    static final class SkipUntilObserver<T> implements Observer<T> {
        final ArrayCompositeDisposable X;
        boolean X2;
        Disposable Y;
        volatile boolean Z;
        final Observer<? super T> s;

        SkipUntilObserver(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.s = observer;
            this.X = arrayCompositeDisposable;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.X.b(0, disposable);
            }
        }

        public void onComplete() {
            this.X.m();
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.X.m();
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.X2) {
                if (this.Z) {
                    this.X2 = true;
                } else {
                    return;
                }
            }
            this.s.onNext(t);
        }
    }

    public ObservableSkipUntil(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.X = observableSource2;
    }

    public void g6(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        serializedObserver.b(arrayCompositeDisposable);
        SkipUntilObserver skipUntilObserver = new SkipUntilObserver(serializedObserver, arrayCompositeDisposable);
        this.X.a(new SkipUntil(arrayCompositeDisposable, skipUntilObserver, serializedObserver));
        this.s.a(skipUntilObserver);
    }
}
