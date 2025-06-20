package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;

public final class ObservableZipIterable<T, U, V> extends Observable<V> {
    final Iterable<U> X;
    final BiFunction<? super T, ? super U, ? extends V> Y;
    final Observable<? extends T> s;

    static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {
        final Iterator<U> X;
        boolean X2;
        final BiFunction<? super T, ? super U, ? extends V> Y;
        Disposable Z;
        final Observer<? super V> s;

        ZipIterableObserver(Observer<? super V> observer, Iterator<U> it2, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.s = observer;
            this.X = it2;
            this.Y = biFunction;
        }

        /* access modifiers changed from: package-private */
        public void a(Throwable th) {
            this.X2 = true;
            this.Z.m();
            this.s.onError(th);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z.g();
        }

        public void m() {
            this.Z.m();
        }

        public void onComplete() {
            if (!this.X2) {
                this.X2 = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.X2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X2 = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.X2) {
                try {
                    U next = this.X.next();
                    Objects.requireNonNull(next, "The iterator returned a null value");
                    Object apply = this.Y.apply(t, next);
                    Objects.requireNonNull(apply, "The zipper function returned a null value");
                    this.s.onNext(apply);
                    if (!this.X.hasNext()) {
                        this.X2 = true;
                        this.Z.m();
                        this.s.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    a(th);
                }
            }
        }
    }

    public ObservableZipIterable(Observable<? extends T> observable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.s = observable;
        this.X = iterable;
        this.Y = biFunction;
    }

    public void g6(Observer<? super V> observer) {
        try {
            Iterator<U> it2 = this.X.iterator();
            Objects.requireNonNull(it2, "The iterator returned by other is null");
            Iterator it3 = it2;
            try {
                if (!it3.hasNext()) {
                    EmptyDisposable.c(observer);
                } else {
                    this.s.a(new ZipIterableObserver(observer, it3, this.Y));
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptyDisposable.h(th2, observer);
        }
    }
}
