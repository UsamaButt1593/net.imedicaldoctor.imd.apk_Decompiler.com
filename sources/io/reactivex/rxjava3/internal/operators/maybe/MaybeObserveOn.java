package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeObserveOn<T> extends AbstractMaybeWithUpstream<T, T> {
    final Scheduler X;

    static final class ObserveOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long X2 = 8571289934935992137L;
        final Scheduler X;
        T Y;
        Throwable Z;
        final MaybeObserver<? super T> s;

        ObserveOnMaybeObserver(MaybeObserver<? super T> maybeObserver, Scheduler scheduler) {
            this.s = maybeObserver;
            this.X = scheduler;
        }

        public void a(T t) {
            this.Y = t;
            DisposableHelper.c(this, this.X.f(this));
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable)) {
                this.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            DisposableHelper.c(this, this.X.f(this));
        }

        public void onError(Throwable th) {
            this.Z = th;
            DisposableHelper.c(this, this.X.f(this));
        }

        public void run() {
            Throwable th = this.Z;
            if (th != null) {
                this.Z = null;
                this.s.onError(th);
                return;
            }
            T t = this.Y;
            if (t != null) {
                this.Y = null;
                this.s.a(t);
                return;
            }
            this.s.onComplete();
        }
    }

    public MaybeObserveOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.X = scheduler;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new ObserveOnMaybeObserver(maybeObserver, this.X));
    }
}
