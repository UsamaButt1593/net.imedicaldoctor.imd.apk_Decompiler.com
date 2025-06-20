package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        static final int X2 = 1;
        private static final long Y = 3880992722410194083L;
        static final int Y2 = 2;
        static final int Z = 0;
        static final int Z2 = 3;
        final T X;
        final Observer<? super T> s;

        public ScalarDisposable(Observer<? super T> observer, T t) {
            this.s = observer;
            this.X = t;
        }

        public void clear() {
            lazySet(3);
        }

        public boolean g() {
            return get() == 3;
        }

        public boolean isEmpty() {
            return get() != 1;
        }

        public void m() {
            set(3);
        }

        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Nullable
        public T poll() {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.X;
        }

        public boolean q(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public int r(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.s.onNext(this.X);
                if (get() == 2) {
                    lazySet(3);
                    this.s.onComplete();
                }
            }
        }
    }

    static final class ScalarXMapObservable<T, R> extends Observable<R> {
        final Function<? super T, ? extends ObservableSource<? extends R>> X;
        final T s;

        ScalarXMapObservable(T t, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.s = t;
            this.X = function;
        }

        public void g6(Observer<? super R> observer) {
            try {
                Object apply = this.X.apply(this.s);
                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                ObservableSource observableSource = (ObservableSource) apply;
                if (observableSource instanceof Supplier) {
                    Object obj = ((Supplier) observableSource).get();
                    if (obj == null) {
                        EmptyDisposable.c(observer);
                        return;
                    }
                    ScalarDisposable scalarDisposable = new ScalarDisposable(observer, obj);
                    observer.b(scalarDisposable);
                    scalarDisposable.run();
                    return;
                }
                observableSource.a(observer);
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
            }
        }
    }

    private ObservableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Observable<U> a(T t, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return RxJavaPlugins.R(new ScalarXMapObservable(t, function));
    }

    public static <T, R> boolean b(ObservableSource<T> observableSource, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (!(observableSource instanceof Supplier)) {
            return false;
        }
        try {
            Object obj = ((Supplier) observableSource).get();
            if (obj == null) {
                EmptyDisposable.c(observer);
                return true;
            }
            Object apply = function.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
            ObservableSource observableSource2 = (ObservableSource) apply;
            if (observableSource2 instanceof Supplier) {
                Object obj2 = ((Supplier) observableSource2).get();
                if (obj2 == null) {
                    EmptyDisposable.c(observer);
                    return true;
                }
                ScalarDisposable scalarDisposable = new ScalarDisposable(observer, obj2);
                observer.b(scalarDisposable);
                scalarDisposable.run();
            } else {
                observableSource2.a(observer);
            }
            return true;
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
            return true;
        }
    }
}
