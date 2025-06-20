package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class SingleDetach<T> extends Single<T> {
    final SingleSource<T> s;

    static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {
        Disposable X;
        SingleObserver<? super T> s;

        DetachSingleObserver(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        public void a(T t) {
            this.X = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.s;
            if (singleObserver != null) {
                this.s = null;
                singleObserver.a(t);
            }
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
            this.s = null;
            this.X.m();
            this.X = DisposableHelper.DISPOSED;
        }

        public void onError(Throwable th) {
            this.X = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.s;
            if (singleObserver != null) {
                this.s = null;
                singleObserver.onError(th);
            }
        }
    }

    public SingleDetach(SingleSource<T> singleSource) {
        this.s = singleSource;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new DetachSingleObserver(singleObserver));
    }
}
