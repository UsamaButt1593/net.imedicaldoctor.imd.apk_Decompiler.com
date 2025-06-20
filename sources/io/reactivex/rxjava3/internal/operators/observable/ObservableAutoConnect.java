package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableAutoConnect<T> extends Observable<T> {
    final int X;
    final Consumer<? super Disposable> Y;
    final AtomicInteger Z = new AtomicInteger();
    final ConnectableObservable<? extends T> s;

    public ObservableAutoConnect(ConnectableObservable<? extends T> connectableObservable, int i2, Consumer<? super Disposable> consumer) {
        this.s = connectableObservable;
        this.X = i2;
        this.Y = consumer;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(observer);
        if (this.Z.incrementAndGet() == this.X) {
            this.s.H8(this.Y);
        }
    }
}
