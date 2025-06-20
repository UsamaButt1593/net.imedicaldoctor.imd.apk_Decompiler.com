package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ObservableFromFuture<T> extends Observable<T> {
    final long X;
    final TimeUnit Y;
    final Future<? extends T> s;

    public ObservableFromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.s = future;
        this.X = j2;
        this.Y = timeUnit;
    }

    public void g6(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.b(deferredScalarDisposable);
        if (!deferredScalarDisposable.g()) {
            try {
                TimeUnit timeUnit = this.Y;
                deferredScalarDisposable.d(ExceptionHelper.d(timeUnit != null ? this.s.get(this.X, timeUnit) : this.s.get(), "Future returned a null value."));
            } catch (Throwable th) {
                Exceptions.b(th);
                if (!deferredScalarDisposable.g()) {
                    observer.onError(th);
                }
            }
        }
    }
}
