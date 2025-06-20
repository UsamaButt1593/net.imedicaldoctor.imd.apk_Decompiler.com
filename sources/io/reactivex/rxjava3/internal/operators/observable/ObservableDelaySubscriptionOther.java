package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {
    final ObservableSource<U> X;
    final ObservableSource<? extends T> s;

    final class DelayObserver implements Observer<U> {
        final Observer<? super T> X;
        boolean Y;
        final SequentialDisposable s;

        final class OnComplete implements Observer<T> {
            OnComplete() {
            }

            public void b(Disposable disposable) {
                DelayObserver.this.s.b(disposable);
            }

            public void onComplete() {
                DelayObserver.this.X.onComplete();
            }

            public void onError(Throwable th) {
                DelayObserver.this.X.onError(th);
            }

            public void onNext(T t) {
                DelayObserver.this.X.onNext(t);
            }
        }

        DelayObserver(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.s = sequentialDisposable;
            this.X = observer;
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public void onComplete() {
            if (!this.Y) {
                this.Y = true;
                ObservableDelaySubscriptionOther.this.s.a(new OnComplete());
            }
        }

        public void onError(Throwable th) {
            if (this.Y) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y = true;
            this.X.onError(th);
        }

        public void onNext(U u) {
            onComplete();
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.s = observableSource;
        this.X = observableSource2;
    }

    public void g6(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.b(sequentialDisposable);
        this.X.a(new DelayObserver(sequentialDisposable, observer));
    }
}
