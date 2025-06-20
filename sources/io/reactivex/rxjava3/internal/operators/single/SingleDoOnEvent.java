package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;

public final class SingleDoOnEvent<T> extends Single<T> {
    final BiConsumer<? super T, ? super Throwable> X;
    final SingleSource<T> s;

    final class DoOnEvent implements SingleObserver<T> {
        private final SingleObserver<? super T> s;

        DoOnEvent(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        public void a(T t) {
            try {
                SingleDoOnEvent.this.X.accept(t, null);
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
            try {
                SingleDoOnEvent.this.X.accept(null, th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.s.onError(th);
        }
    }

    public SingleDoOnEvent(SingleSource<T> singleSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.s = singleSource;
        this.X = biConsumer;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new DoOnEvent(singleObserver));
    }
}
