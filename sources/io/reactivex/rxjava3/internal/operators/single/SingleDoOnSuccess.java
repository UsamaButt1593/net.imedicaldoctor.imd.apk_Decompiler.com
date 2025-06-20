package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;

public final class SingleDoOnSuccess<T> extends Single<T> {
    final Consumer<? super T> X;
    final SingleSource<T> s;

    final class DoOnSuccess implements SingleObserver<T> {
        final SingleObserver<? super T> s;

        DoOnSuccess(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        public void a(T t) {
            try {
                SingleDoOnSuccess.this.X.accept(t);
                this.s.a(t);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.s = singleSource;
        this.X = consumer;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new DoOnSuccess(singleObserver));
    }
}
