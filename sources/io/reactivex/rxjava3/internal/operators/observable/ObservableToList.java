package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Collection;

public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Supplier<U> X;

    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        Disposable X;
        U Y;
        final Observer<? super U> s;

        ToListObserver(Observer<? super U> observer, U u) {
            this.s = observer;
            this.Y = u;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X, disposable)) {
                this.X = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.X.g();
        }

        public void m() {
            this.X.m();
        }

        public void onComplete() {
            U u = this.Y;
            this.Y = null;
            this.s.onNext(u);
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.Y = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.Y.add(t);
        }
    }

    public ObservableToList(ObservableSource<T> observableSource, Supplier<U> supplier) {
        super(observableSource);
        this.X = supplier;
    }

    public void g6(Observer<? super U> observer) {
        try {
            this.s.a(new ToListObserver(observer, (Collection) ExceptionHelper.d(this.X.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
