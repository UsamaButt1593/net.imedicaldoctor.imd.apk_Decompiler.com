package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimeoutMaybe<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final MaybeSource<U> X;
    final MaybeSource<? extends T> Y;

    static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long X = 8663801314800248617L;
        final MaybeObserver<? super T> s;

        TimeoutFallbackMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
        }

        public void a(T t) {
            this.s.a(t);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long X2 = -5955289211445418871L;
        final TimeoutOtherMaybeObserver<T, U> X = new TimeoutOtherMaybeObserver<>(this);
        final MaybeSource<? extends T> Y;
        final TimeoutFallbackMaybeObserver<T> Z;
        final MaybeObserver<? super T> s;

        TimeoutMainMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
            this.s = maybeObserver;
            this.Y = maybeSource;
            this.Z = maybeSource != null ? new TimeoutFallbackMaybeObserver<>(maybeObserver) : null;
        }

        public void a(T t) {
            DisposableHelper.a(this.X);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.s.a(t);
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void c() {
            if (DisposableHelper.a(this)) {
                MaybeSource<? extends T> maybeSource = this.Y;
                if (maybeSource == null) {
                    this.s.onError(new TimeoutException());
                } else {
                    maybeSource.d(this.Z);
                }
            }
        }

        public void d(Throwable th) {
            if (DisposableHelper.a(this)) {
                this.s.onError(th);
            } else {
                RxJavaPlugins.Y(th);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
            DisposableHelper.a(this.X);
            TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver = this.Z;
            if (timeoutFallbackMaybeObserver != null) {
                DisposableHelper.a(timeoutFallbackMaybeObserver);
            }
        }

        public void onComplete() {
            DisposableHelper.a(this.X);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.X);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.s.onError(th);
            } else {
                RxJavaPlugins.Y(th);
            }
        }
    }

    static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<Object> {
        private static final long X = 8663801314800248617L;
        final TimeoutMainMaybeObserver<T, U> s;

        TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
            this.s = timeoutMainMaybeObserver;
        }

        public void a(Object obj) {
            this.s.c();
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void onComplete() {
            this.s.c();
        }

        public void onError(Throwable th) {
            this.s.d(th);
        }
    }

    public MaybeTimeoutMaybe(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        super(maybeSource);
        this.X = maybeSource2;
        this.Y = maybeSource3;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.Y);
        maybeObserver.b(timeoutMainMaybeObserver);
        this.X.d(timeoutMainMaybeObserver.X);
        this.s.d(timeoutMainMaybeObserver);
    }
}
