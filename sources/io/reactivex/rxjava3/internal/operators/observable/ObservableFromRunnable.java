package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.CancellableQueueFuseable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableFromRunnable<T> extends Observable<T> implements Supplier<T> {
    final Runnable s;

    public ObservableFromRunnable(Runnable runnable) {
        this.s = runnable;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        CancellableQueueFuseable cancellableQueueFuseable = new CancellableQueueFuseable();
        observer.b(cancellableQueueFuseable);
        if (!cancellableQueueFuseable.g()) {
            try {
                this.s.run();
                if (!cancellableQueueFuseable.g()) {
                    observer.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                if (!cancellableQueueFuseable.g()) {
                    observer.onError(th);
                } else {
                    RxJavaPlugins.Y(th);
                }
            }
        }
    }

    public T get() throws Throwable {
        this.s.run();
        return null;
    }
}
