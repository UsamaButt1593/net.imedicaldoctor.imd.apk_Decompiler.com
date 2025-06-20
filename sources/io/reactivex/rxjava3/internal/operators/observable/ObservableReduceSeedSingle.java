package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableReduceSeedSingle<T, R> extends Single<R> {
    final R X;
    final BiFunction<R, ? super T, R> Y;
    final ObservableSource<T> s;

    static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {
        final BiFunction<R, ? super T, R> X;
        R Y;
        Disposable Z;
        final SingleObserver<? super R> s;

        ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r) {
            this.s = singleObserver;
            this.Y = r;
            this.X = biFunction;
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
            R r = this.Y;
            if (r != null) {
                this.Y = null;
                this.s.a(r);
            }
        }

        public void onError(Throwable th) {
            if (this.Y != null) {
                this.Y = null;
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            R r = this.Y;
            if (r != null) {
                try {
                    R apply = this.X.apply(r, t);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.Y = apply;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Z.m();
                    onError(th);
                }
            }
        }
    }

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r, BiFunction<R, ? super T, R> biFunction) {
        this.s = observableSource;
        this.X = r;
        this.Y = biFunction;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super R> singleObserver) {
        this.s.a(new ReduceSeedObserver(singleObserver, this.Y, this.X));
    }
}
