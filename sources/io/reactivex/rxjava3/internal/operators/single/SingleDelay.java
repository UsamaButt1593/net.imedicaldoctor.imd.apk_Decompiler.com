package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

public final class SingleDelay<T> extends Single<T> {
    final long X;
    final boolean X2;
    final TimeUnit Y;
    final Scheduler Z;
    final SingleSource<? extends T> s;

    final class Delay implements SingleObserver<T> {
        final SingleObserver<? super T> X;
        private final SequentialDisposable s;

        final class OnError implements Runnable {
            private final Throwable s;

            OnError(Throwable th) {
                this.s = th;
            }

            public void run() {
                Delay.this.X.onError(this.s);
            }
        }

        final class OnSuccess implements Runnable {
            private final T s;

            OnSuccess(T t) {
                this.s = t;
            }

            public void run() {
                Delay.this.X.a(this.s);
            }
        }

        Delay(SequentialDisposable sequentialDisposable, SingleObserver<? super T> singleObserver) {
            this.s = sequentialDisposable;
            this.X = singleObserver;
        }

        public void a(T t) {
            SequentialDisposable sequentialDisposable = this.s;
            Scheduler scheduler = SingleDelay.this.Z;
            OnSuccess onSuccess = new OnSuccess(t);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.a(scheduler.h(onSuccess, singleDelay.X, singleDelay.Y));
        }

        public void b(Disposable disposable) {
            this.s.a(disposable);
        }

        public void onError(Throwable th) {
            SequentialDisposable sequentialDisposable = this.s;
            Scheduler scheduler = SingleDelay.this.Z;
            OnError onError = new OnError(th);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.a(scheduler.h(onError, singleDelay.X2 ? singleDelay.X : 0, singleDelay.Y));
        }
    }

    public SingleDelay(SingleSource<? extends T> singleSource, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.s = singleSource;
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
        this.X2 = z;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.b(sequentialDisposable);
        this.s.e(new Delay(sequentialDisposable, singleObserver));
    }
}
