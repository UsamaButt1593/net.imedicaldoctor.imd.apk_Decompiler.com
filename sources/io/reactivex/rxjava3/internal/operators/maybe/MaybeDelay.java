package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelay<T> extends AbstractMaybeWithUpstream<T, T> {
    final long X;
    final boolean X2;
    final TimeUnit Y;
    final Scheduler Z;

    static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long a3 = 5566860102500855068L;
        final long X;
        final boolean X2;
        final TimeUnit Y;
        T Y2;
        final Scheduler Z;
        Throwable Z2;
        final MaybeObserver<? super T> s;

        DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.s = maybeObserver;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = scheduler;
            this.X2 = z;
        }

        public void a(T t) {
            this.Y2 = t;
            c(this.X);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable)) {
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(long j2) {
            DisposableHelper.c(this, this.Z.h(this, j2, this.Y));
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            c(this.X);
        }

        public void onError(Throwable th) {
            this.Z2 = th;
            c(this.X2 ? this.X : 0);
        }

        public void run() {
            Throwable th = this.Z2;
            if (th != null) {
                this.s.onError(th);
                return;
            }
            T t = this.Y2;
            if (t != null) {
                this.s.a(t);
            } else {
                this.s.onComplete();
            }
        }
    }

    public MaybeDelay(MaybeSource<T> maybeSource, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(maybeSource);
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
        this.X2 = z;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new DelayMaybeObserver(maybeObserver, this.X, this.Y, this.Z, this.X2));
    }
}
