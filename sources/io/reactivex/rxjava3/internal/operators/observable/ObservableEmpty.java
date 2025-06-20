package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;

public final class ObservableEmpty extends Observable<Object> implements ScalarSupplier<Object> {
    public static final Observable<Object> s = new ObservableEmpty();

    private ObservableEmpty() {
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super Object> observer) {
        EmptyDisposable.c(observer);
    }

    public Object get() {
        return null;
    }
}
