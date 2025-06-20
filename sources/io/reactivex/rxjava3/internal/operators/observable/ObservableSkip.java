package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;

    static final class SkipObserver<T> implements Observer<T>, Disposable {
        long X;
        Disposable Y;
        final Observer<? super T> s;

        SkipObserver(Observer<? super T> observer, long j2) {
            this.s = observer;
            this.X = j2;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Y.g();
        }

        public void m() {
            this.Y.m();
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            long j2 = this.X;
            if (j2 != 0) {
                this.X = j2 - 1;
            } else {
                this.s.onNext(t);
            }
        }
    }

    public ObservableSkip(ObservableSource<T> observableSource, long j2) {
        super(observableSource);
        this.X = j2;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new SkipObserver(observer, this.X));
    }
}
