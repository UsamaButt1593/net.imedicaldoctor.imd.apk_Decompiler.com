package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleUnsubscribeOn<T> extends Single<T> {
    final Scheduler X;
    final SingleSource<T> s;

    static final class UnsubscribeOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long Z = 3256698449646456986L;
        final Scheduler X;
        Disposable Y;
        final SingleObserver<? super T> s;

        UnsubscribeOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.s = singleObserver;
            this.X = scheduler;
        }

        public void a(T t) {
            this.s.a(t);
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
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable disposable = (Disposable) getAndSet(disposableHelper);
            if (disposable != disposableHelper) {
                this.Y = disposable;
                this.X.f(this);
            }
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void run() {
            this.Y.m();
        }
    }

    public SingleUnsubscribeOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.s = singleSource;
        this.X = scheduler;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new UnsubscribeOnSingleObserver(singleObserver, this.X));
    }
}
