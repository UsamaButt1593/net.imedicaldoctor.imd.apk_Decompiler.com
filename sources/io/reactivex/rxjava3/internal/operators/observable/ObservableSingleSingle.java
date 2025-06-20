package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableSingleSingle<T> extends Single<T> {
    final T X;
    final ObservableSource<? extends T> s;

    static final class SingleElementObserver<T> implements Observer<T>, Disposable {
        final T X;
        boolean X2;
        Disposable Y;
        T Z;
        final SingleObserver<? super T> s;

        SingleElementObserver(SingleObserver<? super T> singleObserver, T t) {
            this.s = singleObserver;
            this.X = t;
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
                T t = this.Z;
                this.Z = null;
                if (t == null) {
                    t = this.X;
                }
                if (t != null) {
                    this.s.a(t);
                } else {
                    this.s.onError(new NoSuchElementException());
                }
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
                if (this.Z != null) {
                    this.X2 = true;
                    this.Y.m();
                    this.s.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.Z = t;
            }
        }
    }

    public ObservableSingleSingle(ObservableSource<? extends T> observableSource, T t) {
        this.s = observableSource;
        this.X = t;
    }

    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.a(new SingleElementObserver(singleObserver, this.X));
    }
}
