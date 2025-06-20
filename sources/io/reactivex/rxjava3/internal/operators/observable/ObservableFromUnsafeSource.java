package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;

public final class ObservableFromUnsafeSource<T> extends Observable<T> {
    final ObservableSource<T> s;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.s = observableSource;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(observer);
    }
}
