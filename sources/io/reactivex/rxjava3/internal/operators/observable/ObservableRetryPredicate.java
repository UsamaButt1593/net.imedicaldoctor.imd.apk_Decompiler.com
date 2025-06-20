package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryPredicate<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super Throwable> X;
    final long Y;

    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long Y2 = -7098360935104053232L;
        final SequentialDisposable X;
        long X2;
        final ObservableSource<? extends T> Y;
        final Predicate<? super Throwable> Z;
        final Observer<? super T> s;

        RepeatObserver(Observer<? super T> observer, long j2, Predicate<? super Throwable> predicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.s = observer;
            this.X = sequentialDisposable;
            this.Y = observableSource;
            this.Z = predicate;
            this.X2 = j2;
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
            long j2 = this.X2;
            if (j2 != Long.MAX_VALUE) {
                this.X2 = j2 - 1;
            }
            if (j2 == 0) {
                this.s.onError(th);
                return;
            }
            try {
                if (!this.Z.test(th)) {
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

    public ObservableRetryPredicate(Observable<T> observable, long j2, Predicate<? super Throwable> predicate) {
        super(observable);
        this.X = predicate;
        this.Y = j2;
    }

    public void g6(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.b(sequentialDisposable);
        new RepeatObserver(observer, this.Y, this.X, sequentialDisposable, this.s).a();
    }
}
