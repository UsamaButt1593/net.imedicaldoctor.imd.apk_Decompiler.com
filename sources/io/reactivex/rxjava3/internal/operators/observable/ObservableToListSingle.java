package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;

public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {
    final Supplier<U> X;
    final ObservableSource<T> s;

    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        U X;
        Disposable Y;
        final SingleObserver<? super U> s;

        ToListObserver(SingleObserver<? super U> singleObserver, U u) {
            this.s = singleObserver;
            this.X = u;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Y.g();
        }

        public void m() {
            this.Y.m();
        }

        public void onComplete() {
            U u = this.X;
            this.X = null;
            this.s.a(u);
        }

        public void onError(Throwable th) {
            this.X = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.X.add(t);
        }
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, int i2) {
        this.s = observableSource;
        this.X = Functions.f(i2);
    }

    public void O1(SingleObserver<? super U> singleObserver) {
        try {
            this.s.a(new ToListObserver(singleObserver, (Collection) ExceptionHelper.d(this.X.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, singleObserver);
        }
    }

    public Observable<U> c() {
        return RxJavaPlugins.R(new ObservableToList(this.s, this.X));
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, Supplier<U> supplier) {
        this.s = observableSource;
        this.X = supplier;
    }
}
