package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;

public final class MaybeToObservable<T> extends Observable<T> implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> s;

    static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
        private static final long d3 = 7603343402964826922L;
        Disposable c3;

        MaybeToObservableObserver(Observer<? super T> observer) {
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

        public void onComplete() {
            c();
        }

        public void onError(Throwable th) {
            e(th);
        }
    }

    public MaybeToObservable(MaybeSource<T> maybeSource) {
        this.s = maybeSource;
    }

    public static <T> MaybeObserver<T> D8(Observer<? super T> observer) {
        return new MaybeToObservableObserver(observer);
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.d(D8(observer));
    }

    public MaybeSource<T> source() {
        return this.s;
    }
}
