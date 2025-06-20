package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {
    final BiFunction<T, T, T> X;

    static final class ScanObserver<T> implements Observer<T>, Disposable {
        final BiFunction<T, T, T> X;
        boolean X2;
        Disposable Y;
        T Z;
        final Observer<? super T> s;

        ScanObserver(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.s = observer;
            this.X = biFunction;
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
                Observer<? super T> observer = this.s;
                T t2 = this.Z;
                if (t2 != null) {
                    try {
                        t = this.X.apply(t2, t);
                        Objects.requireNonNull(t, "The value returned by the accumulator is null");
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.Y.m();
                        onError(th);
                        return;
                    }
                }
                this.Z = t;
                observer.onNext(t);
            }
        }
    }

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.X = biFunction;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new ScanObserver(observer, this.X));
    }
}
