package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleObserveOn<T> extends Single<T> {
    final Scheduler X;
    final SingleSource<T> s;

    static final class ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long X2 = 3528003840217436037L;
        final Scheduler X;
        T Y;
        Throwable Z;
        final SingleObserver<? super T> s;

        ObserveOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.s = singleObserver;
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

        public void onError(Throwable th) {
            this.Z = th;
            DisposableHelper.c(this, this.X.f(this));
        }

        public void run() {
            Throwable th = this.Z;
            if (th != null) {
                this.s.onError(th);
            } else {
                this.s.a(this.Y);
            }
        }
    }

    public SingleObserveOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.s = singleSource;
        this.X = scheduler;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new ObserveOnSingleObserver(singleObserver, this.X));
    }
}
