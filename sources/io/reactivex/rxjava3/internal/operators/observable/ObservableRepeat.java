package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeat<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;

    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long X2 = -7098360935104053232L;
        final SequentialDisposable X;
        final ObservableSource<? extends T> Y;
        long Z;
        final Observer<? super T> s;

        RepeatObserver(Observer<? super T> observer, long j2, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.s = observer;
            this.X = sequentialDisposable;
            this.Y = observableSource;
            this.Z = j2;
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
            long j2 = this.Z;
            if (j2 != Long.MAX_VALUE) {
                this.Z = j2 - 1;
            }
            if (j2 != 0) {
                a();
            } else {
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    public ObservableRepeat(Observable<T> observable, long j2) {
        super(observable);
        this.X = j2;
    }

    public void g6(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.b(sequentialDisposable);
        long j2 = this.X;
        long j3 = Long.MAX_VALUE;
        if (j2 != Long.MAX_VALUE) {
            j3 = j2 - 1;
        }
        new RepeatObserver(observer, j3, sequentialDisposable, this.s).a();
    }
}
