package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableSkipLast<T> extends AbstractObservableWithUpstream<T, T> {
    final int X;

    static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long Z = -3807491841935125653L;
        final int X;
        Disposable Y;
        final Observer<? super T> s;

        SkipLastObserver(Observer<? super T> observer, int i2) {
            super(i2);
            this.s = observer;
            this.X = i2;
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
            if (this.X == size()) {
                this.s.onNext(poll());
            }
            offer(t);
        }
    }

    public ObservableSkipLast(ObservableSource<T> observableSource, int i2) {
        super(observableSource);
        this.X = i2;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new SkipLastObserver(observer, this.X));
    }
}
