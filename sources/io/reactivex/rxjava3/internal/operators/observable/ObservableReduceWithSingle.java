package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableReduceSeedSingle;
import java.util.Objects;

public final class ObservableReduceWithSingle<T, R> extends Single<R> {
    final Supplier<R> X;
    final BiFunction<R, ? super T, R> Y;
    final ObservableSource<T> s;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        this.s = observableSource;
        this.X = supplier;
        this.Y = biFunction;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super R> singleObserver) {
        try {
            R r = this.X.get();
            Objects.requireNonNull(r, "The seedSupplier returned a null value");
            this.s.a(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.Y, r));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, singleObserver);
        }
    }
}
