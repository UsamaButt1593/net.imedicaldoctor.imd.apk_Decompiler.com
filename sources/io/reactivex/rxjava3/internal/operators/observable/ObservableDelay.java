package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;
    final boolean X2;
    final TimeUnit Y;
    final Scheduler Z;

    static final class DelayObserver<T> implements Observer<T>, Disposable {
        final long X;
        final boolean X2;
        final TimeUnit Y;
        Disposable Y2;
        final Scheduler.Worker Z;
        final Observer<? super T> s;

        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                try {
                    DelayObserver.this.s.onComplete();
                } finally {
                    DelayObserver.this.Z.m();
                }
            }
        }

        final class OnError implements Runnable {
            private final Throwable s;

            OnError(Throwable th) {
                this.s = th;
            }

            public void run() {
                try {
                    DelayObserver.this.s.onError(this.s);
                } finally {
                    DelayObserver.this.Z.m();
                }
            }
        }

        final class OnNext implements Runnable {
            private final T s;

            OnNext(T t) {
                this.s = t;
            }

            public void run() {
                DelayObserver.this.s.onNext(this.s);
            }
        }

        DelayObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.s = observer;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = worker;
            this.X2 = z;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y2, disposable)) {
                this.Y2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z.g();
        }

        public void m() {
            this.Y2.m();
            this.Z.m();
        }

        public void onComplete() {
            this.Z.c(new OnComplete(), this.X, this.Y);
        }

        public void onError(Throwable th) {
            this.Z.c(new OnError(th), this.X2 ? this.X : 0, this.Y);
        }

        public void onNext(T t) {
            this.Z.c(new OnNext(t), this.X, this.Y);
        }
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
        this.X2 = z;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new DelayObserver(this.X2 ? observer : new SerializedObserver(observer), this.X, this.Y, this.Z.d(), this.X2));
    }
}
