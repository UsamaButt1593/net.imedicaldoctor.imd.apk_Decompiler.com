package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> X;

    static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {
        final Function<? super T, ? extends Iterable<? extends R>> X;
        Disposable Y;
        final Observer<? super R> s;

        FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
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
            this.Y = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            Disposable disposable = this.Y;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.Y = disposableHelper;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            Disposable disposable = this.Y;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y = disposableHelper;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (this.Y != DisposableHelper.DISPOSED) {
                try {
                    Observer<? super R> observer = this.s;
                    for (Object next : (Iterable) this.X.apply(t)) {
                        Objects.requireNonNull(next, "The iterator returned a null value");
                        observer.onNext(next);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Y.m();
                    onError(th);
                }
            }
        }
    }

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        this.s.a(new FlattenIterableObserver(observer, this.X));
    }
}
