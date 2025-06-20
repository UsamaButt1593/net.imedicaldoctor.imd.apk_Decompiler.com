package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class ObservableLastSingle<T> extends Single<T> {
    final T X;
    final ObservableSource<T> s;

    static final class LastObserver<T> implements Observer<T>, Disposable {
        final T X;
        Disposable Y;
        T Z;
        final SingleObserver<? super T> s;

        LastObserver(SingleObserver<? super T> singleObserver, T t) {
            this.s = singleObserver;
            this.X = t;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Y == DisposableHelper.DISPOSED;
        }

        public void m() {
            this.Y.m();
            this.Y = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.Y = DisposableHelper.DISPOSED;
            T t = this.Z;
            if (t != null) {
                this.Z = null;
            } else {
                t = this.X;
                if (t == null) {
                    this.s.onError(new NoSuchElementException());
                    return;
                }
            }
            this.s.a(t);
        }

        public void onError(Throwable th) {
            this.Y = DisposableHelper.DISPOSED;
            this.Z = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.Z = t;
        }
    }

    public ObservableLastSingle(ObservableSource<T> observableSource, T t) {
        this.s = observableSource;
        this.X = t;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.a(new LastObserver(singleObserver, this.X));
    }
}
