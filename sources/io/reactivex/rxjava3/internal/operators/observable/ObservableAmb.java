package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableAmb<T> extends Observable<T> {
    final Iterable<? extends ObservableSource<? extends T>> X;
    final ObservableSource<? extends T>[] s;

    static final class AmbCoordinator<T> implements Disposable {
        final AmbInnerObserver<T>[] X;
        final AtomicInteger Y = new AtomicInteger();
        final Observer<? super T> s;

        AmbCoordinator(Observer<? super T> observer, int i2) {
            this.s = observer;
            this.X = new AmbInnerObserver[i2];
        }

        public void a(ObservableSource<? extends T>[] observableSourceArr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.X;
            int length = ambInnerObserverArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                ambInnerObserverArr[i2] = new AmbInnerObserver<>(this, i3, this.s);
                i2 = i3;
            }
            this.Y.lazySet(0);
            this.s.b(this);
            for (int i4 = 0; i4 < length && this.Y.get() == 0; i4++) {
                observableSourceArr[i4].a(ambInnerObserverArr[i4]);
            }
        }

        public boolean b(int i2) {
            int i3 = 0;
            if (this.Y.get() != 0 || !this.Y.compareAndSet(0, i2)) {
                return false;
            }
            AmbInnerObserver<T>[] ambInnerObserverArr = this.X;
            int length = ambInnerObserverArr.length;
            while (i3 < length) {
                int i4 = i3 + 1;
                if (i4 != i2) {
                    ambInnerObserverArr[i3].a();
                }
                i3 = i4;
            }
            return true;
        }

        public boolean g() {
            return this.Y.get() == -1;
        }

        public void m() {
            if (this.Y.get() != -1) {
                this.Y.lazySet(-1);
                for (AmbInnerObserver<T> a2 : this.X) {
                    a2.a();
                }
            }
        }
    }

    static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long X2 = -1185974347409665484L;
        final int X;
        final Observer<? super T> Y;
        boolean Z;
        final AmbCoordinator<T> s;

        AmbInnerObserver(AmbCoordinator<T> ambCoordinator, int i2, Observer<? super T> observer) {
            this.s = ambCoordinator;
            this.X = i2;
            this.Y = observer;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void onComplete() {
            if (!this.Z) {
                if (this.s.b(this.X)) {
                    this.Z = true;
                } else {
                    return;
                }
            }
            this.Y.onComplete();
        }

        public void onError(Throwable th) {
            if (!this.Z) {
                if (this.s.b(this.X)) {
                    this.Z = true;
                } else {
                    RxJavaPlugins.Y(th);
                    return;
                }
            }
            this.Y.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.s.b(this.X)) {
                    this.Z = true;
                } else {
                    ((Disposable) get()).m();
                    return;
                }
            }
            this.Y.onNext(t);
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.s = observableSourceArr;
        this.X = iterable;
    }

    public void g6(Observer<? super T> observer) {
        int i2;
        ObservableSource<? extends T>[] observableSourceArr = this.s;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i2 = 0;
                for (ObservableSource<? extends T> observableSource : this.X) {
                    if (observableSource == null) {
                        EmptyDisposable.h(new NullPointerException("One of the sources is null"), observer);
                        return;
                    }
                    if (i2 == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i2 >> 2) + i2)];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i2);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i3 = i2 + 1;
                    observableSourceArr[i2] = observableSource;
                    i2 = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
                return;
            }
        } else {
            i2 = observableSourceArr.length;
        }
        if (i2 == 0) {
            EmptyDisposable.c(observer);
        } else if (i2 == 1) {
            observableSourceArr[0].a(observer);
        } else {
            new AmbCoordinator(observer, i2).a(observableSourceArr);
        }
    }
}
