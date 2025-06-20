package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOperator;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class SingleLift<T, R> extends Single<R> {
    final SingleOperator<? extends R, ? super T> X;
    final SingleSource<T> s;

    public SingleLift(SingleSource<T> singleSource, SingleOperator<? extends R, ? super T> singleOperator) {
        this.s = singleSource;
        this.X = singleOperator;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super R> singleObserver) {
        try {
            SingleObserver<? super Object> a2 = this.X.a(singleObserver);
            Objects.requireNonNull(a2, "The onLift returned a null SingleObserver");
            this.s.e(a2);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, singleObserver);
        }
    }
}
