package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {
    final Consumer<? super T> X;
    final Action X2;
    final Consumer<? super Throwable> Y;
    final Action Z;

    static final class DoOnEachObserver<T> implements Observer<T>, Disposable {
        final Consumer<? super T> X;
        final Action X2;
        final Consumer<? super Throwable> Y;
        Disposable Y2;
        final Action Z;
        boolean Z2;
        final Observer<? super T> s;

        DoOnEachObserver(Observer<? super T> observer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            this.s = observer;
            this.X = consumer;
            this.Y = consumer2;
            this.Z = action;
            this.X2 = action2;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y2, disposable)) {
                this.Y2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Y2.g();
        }

        public void m() {
            this.Y2.m();
        }

        public void onComplete() {
            if (!this.Z2) {
                try {
                    this.Z.run();
                    this.Z2 = true;
                    this.s.onComplete();
                    try {
                        this.X2.run();
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        RxJavaPlugins.Y(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    onError(th2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Z2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z2 = true;
            try {
                this.Y.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.s.onError(th);
            try {
                this.X2.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.Y(th3);
            }
        }

        public void onNext(T t) {
            if (!this.Z2) {
                try {
                    this.X.accept(t);
                    this.s.onNext(t);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Y2.m();
                    onError(th);
                }
            }
        }
    }

    public ObservableDoOnEach(ObservableSource<T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(observableSource);
        this.X = consumer;
        this.Y = consumer2;
        this.Z = action;
        this.X2 = action2;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new DoOnEachObserver(observer, this.X, this.Y, this.Z, this.X2));
    }
}
