package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> X;

    static final class SkipWhileObserver<T> implements Observer<T>, Disposable {
        final Predicate<? super T> X;
        Disposable Y;
        boolean Z;
        final Observer<? super T> s;

        SkipWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate) {
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
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z) {
                try {
                    if (!this.X.test(t)) {
                        this.Z = true;
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Y.m();
                    this.s.onError(th);
                    return;
                }
            }
            this.s.onNext(t);
        }
    }

    public ObservableSkipWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.X = predicate;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new SkipWhileObserver(observer, this.X));
    }
}
