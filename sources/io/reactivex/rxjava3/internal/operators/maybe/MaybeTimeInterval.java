package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class MaybeTimeInterval<T> extends Maybe<Timed<T>> {
    final TimeUnit X;
    final Scheduler Y;
    final boolean Z;
    final MaybeSource<T> s;

    static final class TimeIntervalMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final TimeUnit X;
        Disposable X2;
        final Scheduler Y;
        final long Z;
        final MaybeObserver<? super Timed<T>> s;

        TimeIntervalMaybeObserver(MaybeObserver<? super Timed<T>> maybeObserver, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.s = maybeObserver;
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

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(@NonNull Throwable th) {
            this.s.onError(th);
        }
    }

    public MaybeTimeInterval(MaybeSource<T> maybeSource, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.s = maybeSource;
        this.X = timeUnit;
        this.Y = scheduler;
        this.Z = z;
    }

    /* access modifiers changed from: protected */
    public void W1(@NonNull MaybeObserver<? super Timed<T>> maybeObserver) {
        this.s.d(new TimeIntervalMaybeObserver(maybeObserver, this.X, this.Y, this.Z));
    }
}
