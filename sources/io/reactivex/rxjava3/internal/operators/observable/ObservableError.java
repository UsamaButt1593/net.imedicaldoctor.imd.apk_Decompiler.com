package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

public final class ObservableError<T> extends Observable<T> {
    final Supplier<? extends Throwable> s;

    public ObservableError(Supplier<? extends Throwable> supplier) {
        this.s = supplier;
    }

    public void g6(Observer<? super T> observer) {
        try {
            th = (Throwable) ExceptionHelper.d(this.s.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        EmptyDisposable.h(th, observer);
    }
}
