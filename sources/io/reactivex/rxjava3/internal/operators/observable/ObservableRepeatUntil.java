package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeatUntil<T> extends AbstractObservableWithUpstream<T, T> {
    final BooleanSupplier X;

    static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long X2 = -7098360935104053232L;
        final SequentialDisposable X;
        final ObservableSource<? extends T> Y;
        final BooleanSupplier Z;
        final Observer<? super T> s;

        RepeatUntilObserver(Observer<? super T> observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.s = observer;
            this.X = sequentialDisposable;
            this.Y = observableSource;
            this.Z = booleanSupplier;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    this.Y.a(this);
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public void b(Disposable disposable) {
            this.X.a(disposable);
        }

        public void onComplete() {
            try {
                if (this.Z.a()) {
                    this.s.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    public ObservableRepeatUntil(Observable<T> observable, BooleanSupplier booleanSupplier) {
        super(observable);
        this.X = booleanSupplier;
    }

    public void g6(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.b(sequentialDisposable);
        new RepeatUntilObserver(observer, this.X, sequentialDisposable, this.s).a();
    }
}
