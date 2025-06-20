package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SingleDoAfterSuccess<T> extends Single<T> {
    final Consumer<? super T> X;
    final SingleSource<T> s;

    static final class DoAfterObserver<T> implements SingleObserver<T>, Disposable {
        final Consumer<? super T> X;
        Disposable Y;
        final SingleObserver<? super T> s;

        DoAfterObserver(SingleObserver<? super T> singleObserver, Consumer<? super T> consumer) {
            this.s = singleObserver;
            this.X = consumer;
        }

        public void a(T t) {
            this.s.a(t);
            try {
                this.X.accept(t);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
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
        }
    }

    public SingleDoAfterSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.s = singleSource;
        this.X = consumer;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new DoAfterObserver(singleObserver, this.X));
    }
}
