package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class ObservableDefer<T> extends Observable<T> {
    final Supplier<? extends ObservableSource<? extends T>> s;

    public ObservableDefer(Supplier<? extends ObservableSource<? extends T>> supplier) {
        this.s = supplier;
    }

    public void g6(Observer<? super T> observer) {
        try {
            Object obj = this.s.get();
            Objects.requireNonNull(obj, "The supplier returned a null ObservableSource");
            ((ObservableSource) obj).a(observer);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
