package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {
    final long X;
    final T Y;
    final ObservableSource<T> s;

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final long X;
        long X2;
        final T Y;
        boolean Y2;
        Disposable Z;
        final SingleObserver<? super T> s;

        ElementAtObserver(SingleObserver<? super T> singleObserver, long j2, T t) {
            this.s = singleObserver;
            this.X = j2;
            this.Y = t;
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
            if (!this.Y2) {
                this.Y2 = true;
                T t = this.Y;
                if (t != null) {
                    this.s.a(t);
                } else {
                    this.s.onError(new NoSuchElementException());
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Y2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y2 = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Y2) {
                long j2 = this.X2;
                if (j2 == this.X) {
                    this.Y2 = true;
                    this.Z.m();
                    this.s.a(t);
                    return;
                }
                this.X2 = j2 + 1;
            }
        }
    }

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long j2, T t) {
        this.s = observableSource;
        this.X = j2;
        this.Y = t;
    }

    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.a(new ElementAtObserver(singleObserver, this.X, this.Y));
    }

    public Observable<T> c() {
        return RxJavaPlugins.R(new ObservableElementAt(this.s, this.X, this.Y, true));
    }
}
