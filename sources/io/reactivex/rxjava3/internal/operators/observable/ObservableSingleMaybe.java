package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableSingleMaybe<T> extends Maybe<T> {
    final ObservableSource<T> s;

    static final class SingleElementObserver<T> implements Observer<T>, Disposable {
        Disposable X;
        T Y;
        boolean Z;
        final MaybeObserver<? super T> s;

        SingleElementObserver(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
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
            if (!this.Z) {
                this.Z = true;
                T t = this.Y;
                this.Y = null;
                if (t == null) {
                    this.s.onComplete();
                } else {
                    this.s.a(t);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.Y != null) {
                    this.Z = true;
                    this.X.m();
                    this.s.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.Y = t;
            }
        }
    }

    public ObservableSingleMaybe(ObservableSource<T> observableSource) {
        this.s = observableSource;
    }

    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.a(new SingleElementObserver(maybeObserver));
    }
}
