package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryBiPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    final BiPredicate<? super Integer, ? super Throwable> X;

    static final class RetryBiObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long Y2 = -7098360935104053232L;
        final SequentialDisposable X;
        int X2;
        final ObservableSource<? extends T> Y;
        final BiPredicate<? super Integer, ? super Throwable> Z;
        final Observer<? super T> s;

        RetryBiObserver(Observer<? super T> observer, BiPredicate<? super Integer, ? super Throwable> biPredicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.s = observer;
            this.X = sequentialDisposable;
            this.Y = observableSource;
            this.Z = biPredicate;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.X.g()) {
                    this.Y.a(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public void b(Disposable disposable) {
            this.X.a(disposable);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            try {
                BiPredicate<? super Integer, ? super Throwable> biPredicate = this.Z;
                int i2 = this.X2 + 1;
                this.X2 = i2;
                if (!biPredicate.a(Integer.valueOf(i2), th)) {
                    this.s.onError(th);
                } else {
                    a();
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

    public ObservableRetryBiPredicate(Observable<T> observable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(observable);
        this.X = biPredicate;
    }

    public void g6(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.b(sequentialDisposable);
        new RetryBiObserver(observer, this.X, sequentialDisposable, this.s).a();
    }
}
