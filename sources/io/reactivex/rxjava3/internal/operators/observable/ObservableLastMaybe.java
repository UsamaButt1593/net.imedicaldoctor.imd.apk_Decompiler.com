package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableLastMaybe<T> extends Maybe<T> {
    final ObservableSource<T> s;

    static final class LastObserver<T> implements Observer<T>, Disposable {
        Disposable X;
        T Y;
        final MaybeObserver<? super T> s;

        LastObserver(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X, disposable)) {
                this.X = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.X == DisposableHelper.DISPOSED;
        }

        public void m() {
            this.X.m();
            this.X = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.X = DisposableHelper.DISPOSED;
            T t = this.Y;
            if (t != null) {
                this.Y = null;
                this.s.a(t);
                return;
            }
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.X = DisposableHelper.DISPOSED;
            this.Y = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.Y = t;
        }
    }

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.s = observableSource;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.a(new LastObserver(maybeObserver));
    }
}
