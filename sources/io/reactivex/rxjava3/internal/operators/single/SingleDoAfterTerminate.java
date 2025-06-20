package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SingleDoAfterTerminate<T> extends Single<T> {
    final Action X;
    final SingleSource<T> s;

    static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {
        final Action X;
        Disposable Y;
        final SingleObserver<? super T> s;

        DoAfterTerminateObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.s = singleObserver;
            this.X = action;
        }

        private void c() {
            try {
                this.X.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }

        public void a(T t) {
            this.s.a(t);
            c();
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

        public void onError(Throwable th) {
            this.s.onError(th);
            c();
        }
    }

    public SingleDoAfterTerminate(SingleSource<T> singleSource, Action action) {
        this.s = singleSource;
        this.X = action;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new DoAfterTerminateObserver(singleObserver, this.X));
    }
}
