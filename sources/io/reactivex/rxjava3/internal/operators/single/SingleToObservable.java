package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;

public final class SingleToObservable<T> extends Observable<T> {
    final SingleSource<? extends T> s;

    static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements SingleObserver<T> {
        private static final long d3 = 3786543492451018833L;
        Disposable c3;

        SingleToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        public void a(T t) {
            d(t);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.c3, disposable)) {
                this.c3 = disposable;
                this.X.b(this);
            }
        }

        public void m() {
            super.m();
            this.c3.m();
        }

        public void onError(Throwable th) {
            e(th);
        }
    }

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.s = singleSource;
    }

    public static <T> SingleObserver<T> D8(Observer<? super T> observer) {
        return new SingleToObservableObserver(observer);
    }

    public void g6(Observer<? super T> observer) {
        this.s.e(D8(observer));
    }
}
