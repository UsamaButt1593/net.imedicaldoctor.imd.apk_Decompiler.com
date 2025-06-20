package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {
    final Scheduler X;
    final TimeUnit Y;

    static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {
        final TimeUnit X;
        Disposable X2;
        final Scheduler Y;
        long Z;
        final Observer<? super Timed<T>> s;

        TimeIntervalObserver(Observer<? super Timed<T>> observer, TimeUnit timeUnit, Scheduler scheduler) {
            this.s = observer;
            this.Y = scheduler;
            this.X = timeUnit;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.Z = this.Y.e(this.X);
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.X2.g();
        }

        public void m() {
            this.X2.m();
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            long e2 = this.Y.e(this.X);
            long j2 = this.Z;
            this.Z = e2;
            this.s.onNext(new Timed(t, e2 - j2, this.X));
        }
    }

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.X = scheduler;
        this.Y = timeUnit;
    }

    public void g6(Observer<? super Timed<T>> observer) {
        this.s.a(new TimeIntervalObserver(observer, this.Y, this.X));
    }
}
