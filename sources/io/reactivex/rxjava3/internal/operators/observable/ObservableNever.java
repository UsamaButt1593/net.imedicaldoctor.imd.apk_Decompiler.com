package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

public final class ObservableNever extends Observable<Object> {
    public static final Observable<Object> s = new ObservableNever();

    private ObservableNever() {
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super Object> observer) {
        observer.b(EmptyDisposable.NEVER);
    }
}
