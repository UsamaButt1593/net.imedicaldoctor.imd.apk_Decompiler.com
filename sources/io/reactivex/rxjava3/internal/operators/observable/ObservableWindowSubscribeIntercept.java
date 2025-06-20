package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.atomic.AtomicBoolean;

final class ObservableWindowSubscribeIntercept<T> extends Observable<T> {
    final AtomicBoolean X = new AtomicBoolean();
    final Subject<T> s;

    ObservableWindowSubscribeIntercept(Subject<T> subject) {
        this.s = subject;
    }

    /* access modifiers changed from: package-private */
    public boolean D8() {
        return !this.X.get() && this.X.compareAndSet(false, true);
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(observer);
        this.X.set(true);
    }
}
