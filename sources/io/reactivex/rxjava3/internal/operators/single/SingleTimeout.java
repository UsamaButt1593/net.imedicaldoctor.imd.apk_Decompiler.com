package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimeout<T> extends Single<T> {
    final long X;
    final SingleSource<? extends T> X2;
    final TimeUnit Y;
    final Scheduler Z;
    final SingleSource<T> s;

    static final class TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {
        private static final long Z2 = 37497744973048446L;
        final AtomicReference<Disposable> X = new AtomicReference<>();
        final long X2;
        final TimeoutFallbackObserver<T> Y;
        final TimeUnit Y2;
        SingleSource<? extends T> Z;
        final SingleObserver<? super T> s;

        static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long X = 2071387740092105509L;
            final SingleObserver<? super T> s;

            TimeoutFallbackObserver(SingleObserver<? super T> singleObserver) {
                this.s = singleObserver;
            }

            public void a(T t) {
                this.s.a(t);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public void onError(Throwable th) {
                this.s.onError(th);
            }
        }

        TimeoutMainObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource, long j2, TimeUnit timeUnit) {
            this.s = singleObserver;
            this.Z = singleSource;
            this.X2 = j2;
            this.Y2 = timeUnit;
            if (singleSource != null) {
                this.Y = new TimeoutFallbackObserver<>(singleObserver);
            } else {
                this.Y = null;
            }
        }

        public void a(T t) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                DisposableHelper.a(this.X);
                this.s.a(t);
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
            DisposableHelper.a(this.X);
            TimeoutFallbackObserver<T> timeoutFallbackObserver = this.Y;
            if (timeoutFallbackObserver != null) {
                DisposableHelper.a(timeoutFallbackObserver);
            }
        }

        public void onError(Throwable th) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || !compareAndSet(disposable, disposableHelper)) {
                RxJavaPlugins.Y(th);
                return;
            }
            DisposableHelper.a(this.X);
            this.s.onError(th);
        }

        public void run() {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                if (disposable != null) {
                    disposable.m();
                }
                SingleSource<? extends T> singleSource = this.Z;
                if (singleSource == null) {
                    this.s.onError(new TimeoutException(ExceptionHelper.h(this.X2, this.Y2)));
                    return;
                }
                this.Z = null;
                singleSource.e(this.Y);
            }
        }
    }

    public SingleTimeout(SingleSource<T> singleSource, long j2, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource2) {
        this.s = singleSource;
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
        this.X2 = singleSource2;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(singleObserver, this.X2, this.X, this.Y);
        singleObserver.b(timeoutMainObserver);
        DisposableHelper.c(timeoutMainObserver.X, this.Z.h(timeoutMainObserver, this.X, this.Y));
        this.s.e(timeoutMainObserver);
    }
}
