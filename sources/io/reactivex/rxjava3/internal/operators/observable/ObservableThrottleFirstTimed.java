package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableThrottleFirstTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long X;
    final TimeUnit Y;
    final Scheduler Z;

    static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {
        private static final long Z2 = 786994795061867455L;
        final long X;
        Disposable X2;
        final TimeUnit Y;
        volatile boolean Y2;
        final Scheduler.Worker Z;
        final Observer<? super T> s;

        DebounceTimedObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.s = observer;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = worker;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z.g();
        }

        public void m() {
            this.X2.m();
            this.Z.m();
        }

        public void onComplete() {
            this.s.onComplete();
            this.Z.m();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
            this.Z.m();
        }

        public void onNext(T t) {
            if (!this.Y2) {
                this.Y2 = true;
                this.s.onNext(t);
                Disposable disposable = (Disposable) get();
                if (disposable != null) {
                    disposable.m();
                }
                DisposableHelper.c(this, this.Z.c(this, this.X, this.Y));
            }
        }

        public void run() {
            this.Y2 = false;
        }
    }

    public ObservableThrottleFirstTimed(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
    }

    public void g6(Observer<? super T> observer) {
        this.s.a(new DebounceTimedObserver(new SerializedObserver(observer), this.X, this.Y, this.Z.d()));
    }
}
