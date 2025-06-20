package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubscribeOn<T> extends Single<T> {
    final Scheduler X;
    final SingleSource<? extends T> s;

    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long Z = 7000911171163930287L;
        final SequentialDisposable X = new SequentialDisposable();
        final SingleSource<? extends T> Y;
        final SingleObserver<? super T> s;

        SubscribeOnObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.s = singleObserver;
            this.Y = singleSource;
        }

        public void a(T t) {
            this.s.a(t);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
            this.X.m();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void run() {
            this.Y.e(this);
        }
    }

    public SingleSubscribeOn(SingleSource<? extends T> singleSource, Scheduler scheduler) {
        this.s = singleSource;
        this.X = scheduler;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(singleObserver, this.s);
        singleObserver.b(subscribeOnObserver);
        subscribeOnObserver.X.a(this.X.f(subscribeOnObserver));
    }
}
