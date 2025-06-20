package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableOnErrorComplete<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super Throwable> X;

    public static final class OnErrorCompleteObserver<T> implements Observer<T>, Disposable {
        final Predicate<? super Throwable> X;
        Disposable Y;
        final Observer<? super T> s;

        public OnErrorCompleteObserver(Observer<? super T> observer, Predicate<? super Throwable> predicate) {
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
            try {
                if (this.X.test(th)) {
                    this.s.onComplete();
                } else {
                    this.s.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    public ObservableOnErrorComplete(ObservableSource<T> observableSource, Predicate<? super Throwable> predicate) {
        super(observableSource);
        this.X = predicate;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.s.a(new OnErrorCompleteObserver(observer, this.X));
    }
}
