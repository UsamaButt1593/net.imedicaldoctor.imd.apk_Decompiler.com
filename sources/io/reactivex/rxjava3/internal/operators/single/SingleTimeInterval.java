package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class SingleTimeInterval<T> extends Single<Timed<T>> {
    final TimeUnit X;
    final Scheduler Y;
    final boolean Z;
    final SingleSource<T> s;

    static final class TimeIntervalSingleObserver<T> implements SingleObserver<T>, Disposable {
        final TimeUnit X;
        Disposable X2;
        final Scheduler Y;
        final long Z;
        final SingleObserver<? super Timed<T>> s;

        TimeIntervalSingleObserver(SingleObserver<? super Timed<T>> singleObserver, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.s = singleObserver;
            this.X = timeUnit;
            this.Y = scheduler;
            this.Z = z ? scheduler.e(timeUnit) : 0;
        }

        public void a(@NonNull T t) {
            this.s.a(new Timed(t, this.Y.e(this.X) - this.Z, this.X));
        }

        public void b(@NonNull Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.X2.g();
        }

        public void m() {
            this.X2.m();
        }

        public void onError(@NonNull Throwable th) {
            this.s.onError(th);
        }
    }

    public SingleTimeInterval(SingleSource<T> singleSource, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.s = singleSource;
        this.X = timeUnit;
        this.Y = scheduler;
        this.Z = z;
    }

    /* access modifiers changed from: protected */
    public void O1(@NonNull SingleObserver<? super Timed<T>> singleObserver) {
        this.s.e(new TimeIntervalSingleObserver(singleObserver, this.X, this.Y, this.Z));
    }
}
