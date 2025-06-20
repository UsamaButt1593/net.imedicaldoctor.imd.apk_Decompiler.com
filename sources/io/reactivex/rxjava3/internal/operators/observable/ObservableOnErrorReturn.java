package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends T> X;

    static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {
        final Function<? super Throwable, ? extends T> X;
        Disposable Y;
        final Observer<? super T> s;

        OnErrorReturnObserver(Observer<? super T> observer, Function<? super Throwable, ? extends T> function) {
            this.s = observer;
            this.X = function;
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
            try {
                Object apply = this.X.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.s.onError(nullPointerException);
                    return;
                }
                this.s.onNext(apply);
                this.s.onComplete();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    public ObservableOnErrorReturn(ObservableSource<T> observableSource, Function<? super Throwable, ? extends T> function) {
        super(observableSource);
        this.X = function;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new OnErrorReturnObserver(observer, this.X));
    }
}
