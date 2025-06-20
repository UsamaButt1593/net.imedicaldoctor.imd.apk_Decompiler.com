package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import io.reactivex.rxjava3.internal.operators.observable.ObservableScalarXMap;

public final class ObservableJust<T> extends Observable<T> implements ScalarSupplier<T> {
    private final T s;

    public ObservableJust(T t) {
        this.s = t;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.s);
        observer.b(scalarDisposable);
        scalarDisposable.run();
    }

    public T get() {
        return this.s;
    }
}
