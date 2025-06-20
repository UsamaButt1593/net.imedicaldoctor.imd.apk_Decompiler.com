package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;

public final class CompletableToSingle<T> extends Single<T> {
    final Supplier<? extends T> X;
    final T Y;
    final CompletableSource s;

    final class ToSingle implements CompletableObserver {
        private final SingleObserver<? super T> s;

        ToSingle(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public void onComplete() {
            T t;
            CompletableToSingle completableToSingle = CompletableToSingle.this;
            Supplier<? extends T> supplier = completableToSingle.X;
            if (supplier != null) {
                try {
                    t = supplier.get();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.s.onError(th);
                    return;
                }
            } else {
                t = completableToSingle.Y;
            }
            if (t == null) {
                this.s.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.s.a(t);
            }
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public CompletableToSingle(CompletableSource completableSource, Supplier<? extends T> supplier, T t) {
        this.s = completableSource;
        this.Y = t;
        this.X = supplier;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.a(new ToSingle(singleObserver));
    }
}
