package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;

public final class SingleOnErrorReturn<T> extends Single<T> {
    final Function<? super Throwable, ? extends T> X;
    final T Y;
    final SingleSource<? extends T> s;

    final class OnErrorReturn implements SingleObserver<T> {
        private final SingleObserver<? super T> s;

        OnErrorReturn(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        public void a(T t) {
            this.s.a(t);
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public void onError(Throwable th) {
            T t;
            SingleOnErrorReturn singleOnErrorReturn = SingleOnErrorReturn.this;
            Function<? super Throwable, ? extends T> function = singleOnErrorReturn.X;
            if (function != null) {
                try {
                    t = function.apply(th);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.s.onError(new CompositeException(th, th2));
                    return;
                }
            } else {
                t = singleOnErrorReturn.Y;
            }
            if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.s.onError(nullPointerException);
                return;
            }
            this.s.a(t);
        }
    }

    public SingleOnErrorReturn(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t) {
        this.s = singleSource;
        this.X = function;
        this.Y = t;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new OnErrorReturn(singleObserver));
    }
}
