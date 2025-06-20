package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableScanSeed<T, R> extends AbstractObservableWithUpstream<T, R> {
    final BiFunction<R, ? super T, R> X;
    final Supplier<R> Y;

    static final class ScanSeedObserver<T, R> implements Observer<T>, Disposable {
        final BiFunction<R, ? super T, R> X;
        boolean X2;
        R Y;
        Disposable Z;
        final Observer<? super R> s;

        ScanSeedObserver(Observer<? super R> observer, BiFunction<R, ? super T, R> biFunction, R r) {
            this.s = observer;
            this.X = biFunction;
            this.Y = r;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.s.b(this);
                this.s.onNext(this.Y);
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
                    R apply = this.X.apply(this.Y, t);
                    Objects.requireNonNull(apply, "The accumulator returned a null value");
                    this.Y = apply;
                    this.s.onNext(apply);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Z.m();
                    onError(th);
                }
            }
        }
    }

    public ObservableScanSeed(ObservableSource<T> observableSource, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.X = biFunction;
        this.Y = supplier;
    }

    public void g6(Observer<? super R> observer) {
        try {
            R r = this.Y.get();
            Objects.requireNonNull(r, "The seed supplied is null");
            this.s.a(new ScanSeedObserver(observer, this.X, r));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
