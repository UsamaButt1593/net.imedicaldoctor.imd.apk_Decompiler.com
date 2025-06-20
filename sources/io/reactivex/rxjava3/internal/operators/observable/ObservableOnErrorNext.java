package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> X;

    static final class OnErrorNextObserver<T> implements Observer<T> {
        final Function<? super Throwable, ? extends ObservableSource<? extends T>> X;
        boolean X2;
        final SequentialDisposable Y = new SequentialDisposable();
        boolean Z;
        final Observer<? super T> s;

        OnErrorNextObserver(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
            this.s = observer;
            this.X = function;
        }

        public void b(Disposable disposable) {
            this.Y.a(disposable);
        }

        public void onComplete() {
            if (!this.X2) {
                this.X2 = true;
                this.Z = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (!this.Z) {
                this.Z = true;
                try {
                    ObservableSource observableSource = (ObservableSource) this.X.apply(th);
                    if (observableSource == null) {
                        NullPointerException nullPointerException = new NullPointerException("Observable is null");
                        nullPointerException.initCause(th);
                        this.s.onError(nullPointerException);
                        return;
                    }
                    observableSource.a(this);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.s.onError(new CompositeException(th, th2));
                }
            } else if (this.X2) {
                RxJavaPlugins.Y(th);
            } else {
                this.s.onError(th);
            }
        }

        public void onNext(T t) {
            if (!this.X2) {
                this.s.onNext(t);
            }
        }
    }

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        super(observableSource);
        this.X = function;
    }

    public void g6(Observer<? super T> observer) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(observer, this.X);
        observer.b(onErrorNextObserver.Y);
        this.s.a(onErrorNextObserver);
    }
}
