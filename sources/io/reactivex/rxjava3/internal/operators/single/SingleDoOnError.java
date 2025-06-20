package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;

public final class SingleDoOnError<T> extends Single<T> {
    final Consumer<? super Throwable> X;
    final SingleSource<T> s;

    final class DoOnError implements SingleObserver<T> {
        private final SingleObserver<? super T> s;

        DoOnError(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        public void a(T t) {
            this.s.a(t);
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public void onError(Throwable th) {
            try {
                SingleDoOnError.this.X.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.s.onError(th);
        }
    }

    public SingleDoOnError(SingleSource<T> singleSource, Consumer<? super Throwable> consumer) {
        this.s = singleSource;
        this.X = consumer;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new DoOnError(singleObserver));
    }
}
