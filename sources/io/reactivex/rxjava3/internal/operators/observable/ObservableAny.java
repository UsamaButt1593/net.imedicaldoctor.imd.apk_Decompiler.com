package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableAny<T> extends AbstractObservableWithUpstream<T, Boolean> {
    final Predicate<? super T> X;

    static final class AnyObserver<T> implements Observer<T>, Disposable {
        final Predicate<? super T> X;
        Disposable Y;
        boolean Z;
        final Observer<? super Boolean> s;

        AnyObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.s = observer;
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
                this.s.onNext(Boolean.FALSE);
                this.s.onComplete();
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
                    if (this.X.test(t)) {
                        this.Z = true;
                        this.Y.m();
                        this.s.onNext(Boolean.TRUE);
                        this.s.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Y.m();
                    onError(th);
                }
            }
        }
    }

    public ObservableAny(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.X = predicate;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super Boolean> observer) {
        this.s.a(new AnyObserver(observer, this.X));
    }
}
