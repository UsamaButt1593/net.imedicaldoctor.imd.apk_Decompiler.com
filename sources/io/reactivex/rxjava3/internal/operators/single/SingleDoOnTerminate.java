package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;

public final class SingleDoOnTerminate<T> extends Single<T> {
    final Action X;
    final SingleSource<T> s;

    final class DoOnTerminate implements SingleObserver<T> {
        final SingleObserver<? super T> s;

        DoOnTerminate(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        public void a(T t) {
            try {
                SingleDoOnTerminate.this.X.run();
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
                SingleDoOnTerminate.this.X.run();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.s.onError(th);
        }
    }

    public SingleDoOnTerminate(SingleSource<T> singleSource, Action action) {
        this.s = singleSource;
        this.X = action;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new DoOnTerminate(singleObserver));
    }
}
