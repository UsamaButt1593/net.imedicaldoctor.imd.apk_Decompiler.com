package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class SingleDefer<T> extends Single<T> {
    final Supplier<? extends SingleSource<? extends T>> s;

    public SingleDefer(Supplier<? extends SingleSource<? extends T>> supplier) {
        this.s = supplier;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        try {
            Object obj = this.s.get();
            Objects.requireNonNull(obj, "The singleSupplier returned a null SingleSource");
            ((SingleSource) obj).e(singleObserver);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, singleObserver);
        }
    }
}
