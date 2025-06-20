package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableAllSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    final Predicate<? super T> X;
    final ObservableSource<T> s;

    static final class AllObserver<T> implements Observer<T>, Disposable {
        final Predicate<? super T> X;
        Disposable Y;
        boolean Z;
        final SingleObserver<? super Boolean> s;

        AllObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.s = singleObserver;
            this.X = predicate;
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
            if (!this.Z) {
                this.Z = true;
                this.s.a(Boolean.TRUE);
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
                try {
                    if (!this.X.test(t)) {
                        this.Z = true;
                        this.Y.m();
                        this.s.a(Boolean.FALSE);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Y.m();
                    onError(th);
                }
            }
        }
    }

    public ObservableAllSingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.s = observableSource;
        this.X = predicate;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Boolean> singleObserver) {
        this.s.a(new AllObserver(singleObserver, this.X));
    }

    public Observable<Boolean> c() {
        return RxJavaPlugins.R(new ObservableAll(this.s, this.X));
    }
}
