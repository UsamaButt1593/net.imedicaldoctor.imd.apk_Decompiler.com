package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableFromCallable<T> extends Observable<T> implements Supplier<T> {
    final Callable<? extends T> s;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.s = callable;
    }

    public void g6(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.b(deferredScalarDisposable);
        if (!deferredScalarDisposable.g()) {
            try {
                deferredScalarDisposable.d(ExceptionHelper.d(this.s.call(), "Callable returned a null value."));
            } catch (Throwable th) {
                Exceptions.b(th);
                if (!deferredScalarDisposable.g()) {
                    observer.onError(th);
                } else {
                    RxJavaPlugins.Y(th);
                }
            }
        }
    }

    public T get() throws Throwable {
        return ExceptionHelper.d(this.s.call(), "The Callable returned a null value.");
    }
}
