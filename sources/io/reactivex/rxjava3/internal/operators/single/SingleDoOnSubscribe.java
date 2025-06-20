package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SingleDoOnSubscribe<T> extends Single<T> {
    final Consumer<? super Disposable> X;
    final SingleSource<T> s;

    static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {
        final Consumer<? super Disposable> X;
        boolean Y;
        final SingleObserver<? super T> s;

        DoOnSubscribeSingleObserver(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer) {
            this.s = singleObserver;
            this.X = consumer;
        }

        public void a(T t) {
            if (!this.Y) {
                this.s.a(t);
            }
        }

        public void b(Disposable disposable) {
            try {
                this.X.accept(disposable);
                this.s.b(disposable);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.Y = true;
                disposable.m();
                EmptyDisposable.i(th, this.s);
            }
        }

        public void onError(Throwable th) {
            if (this.Y) {
                RxJavaPlugins.Y(th);
            } else {
                this.s.onError(th);
            }
        }
    }

    public SingleDoOnSubscribe(SingleSource<T> singleSource, Consumer<? super Disposable> consumer) {
        this.s = singleSource;
        this.X = consumer;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new DoOnSubscribeSingleObserver(singleObserver, this.X));
    }
}
