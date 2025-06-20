package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableFromSupplier<T> extends Observable<T> implements Supplier<T> {
    final Supplier<? extends T> s;

    public ObservableFromSupplier(Supplier<? extends T> supplier) {
        this.s = supplier;
    }

    public void g6(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.b(deferredScalarDisposable);
        if (!deferredScalarDisposable.g()) {
            try {
                deferredScalarDisposable.d(ExceptionHelper.d(this.s.get(), "Supplier returned a null value."));
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
        return ExceptionHelper.d(this.s.get(), "The supplier returned a null value.");
    }
}
