package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;

public final class SingleContains<T> extends Single<Boolean> {
    final Object X;
    final BiPredicate<Object, Object> Y;
    final SingleSource<T> s;

    final class ContainsSingleObserver implements SingleObserver<T> {
        private final SingleObserver<? super Boolean> s;

        ContainsSingleObserver(SingleObserver<? super Boolean> singleObserver) {
            this.s = singleObserver;
        }

        public void a(T t) {
            try {
                SingleContains singleContains = SingleContains.this;
                this.s.a(Boolean.valueOf(singleContains.Y.a(t, singleContains.X)));
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

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.s = singleSource;
        this.X = obj;
        this.Y = biPredicate;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Boolean> singleObserver) {
        this.s.e(new ContainsSingleObserver(singleObserver));
    }
}
