package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableReduceMaybe<T> extends Maybe<T> {
    final BiFunction<T, T, T> X;
    final ObservableSource<T> s;

    static final class ReduceObserver<T> implements Observer<T>, Disposable {
        final BiFunction<T, T, T> X;
        Disposable X2;
        boolean Y;
        T Z;
        final MaybeObserver<? super T> s;

        ReduceObserver(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.s = maybeObserver;
            this.X = biFunction;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.X2.g();
        }

        public void m() {
            this.X2.m();
        }

        public void onComplete() {
            if (!this.Y) {
                this.Y = true;
                T t = this.Z;
                this.Z = null;
                if (t != null) {
                    this.s.a(t);
                } else {
                    this.s.onComplete();
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Y) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y = true;
            this.Z = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Y) {
                T t2 = this.Z;
                if (t2 == null) {
                    this.Z = t;
                    return;
                }
                try {
                    T apply = this.X.apply(t2, t);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.Z = apply;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.X2.m();
                    onError(th);
                }
            }
        }
    }

    public ObservableReduceMaybe(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        this.s = observableSource;
        this.X = biFunction;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.a(new ReduceObserver(maybeObserver, this.X));
    }
}
