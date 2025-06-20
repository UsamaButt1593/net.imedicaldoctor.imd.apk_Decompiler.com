package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class SingleHide<T> extends Single<T> {
    final SingleSource<? extends T> s;

    static final class HideSingleObserver<T> implements SingleObserver<T>, Disposable {
        Disposable X;
        final SingleObserver<? super T> s;

        HideSingleObserver(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        public void a(T t) {
            this.s.a(t);
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
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public SingleHide(SingleSource<? extends T> singleSource) {
        this.s = singleSource;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new HideSingleObserver(singleObserver));
    }
}
