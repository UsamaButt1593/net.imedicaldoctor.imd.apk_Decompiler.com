package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableTakeLast<T> extends AbstractObservableWithUpstream<T, T> {
    final int X;

    static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long X2 = 7240042530241604978L;
        final int X;
        Disposable Y;
        volatile boolean Z;
        final Observer<? super T> s;

        TakeLastObserver(Observer<? super T> observer, int i2) {
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
            return this.Z;
        }

        public void m() {
            if (!this.Z) {
                this.Z = true;
                this.Y.m();
            }
        }

        public void onComplete() {
            Observer<? super T> observer = this.s;
            while (!this.Z) {
                Object poll = poll();
                if (poll == null) {
                    observer.onComplete();
                    return;
                }
                observer.onNext(poll);
            }
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (this.X == size()) {
                poll();
            }
            offer(t);
        }
    }

    public ObservableTakeLast(ObservableSource<T> observableSource, int i2) {
        super(observableSource);
        this.X = i2;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new TakeLastObserver(observer, this.X));
    }
}
