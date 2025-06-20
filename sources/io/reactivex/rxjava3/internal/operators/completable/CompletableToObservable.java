package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromCompletable;

public final class CompletableToObservable<T> extends Observable<T> {
    final CompletableSource s;

    public CompletableToObservable(CompletableSource completableSource) {
        this.s = completableSource;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new ObservableFromCompletable.FromCompletableObserver(observer));
    }
}
