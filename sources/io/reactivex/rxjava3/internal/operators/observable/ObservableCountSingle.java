package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {
    final ObservableSource<T> s;

    static final class CountObserver implements Observer<Object>, Disposable {
        Disposable X;
        long Y;
        final SingleObserver<? super Long> s;

        CountObserver(SingleObserver<? super Long> singleObserver) {
            this.s = singleObserver;
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
            this.X.m();
            this.X = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.X = DisposableHelper.DISPOSED;
            this.s.a(Long.valueOf(this.Y));
        }

        public void onError(Throwable th) {
            this.X = DisposableHelper.DISPOSED;
            this.s.onError(th);
        }

        public void onNext(Object obj) {
            this.Y++;
        }
    }

    public ObservableCountSingle(ObservableSource<T> observableSource) {
        this.s = observableSource;
    }

    public void O1(SingleObserver<? super Long> singleObserver) {
        this.s.a(new CountObserver(singleObserver));
    }

    public Observable<Long> c() {
        return RxJavaPlugins.R(new ObservableCount(this.s));
    }
}
