package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTakeUntilMaybe<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final MaybeSource<U> X;

    static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long Y = -2187421758664251153L;
        final TakeUntilOtherMaybeObserver<U> X = new TakeUntilOtherMaybeObserver<>(this);
        final MaybeObserver<? super T> s;

        static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long X = -1266041316834525931L;
            final TakeUntilMainMaybeObserver<?, U> s;

            TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
                this.s = takeUntilMainMaybeObserver;
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

        TakeUntilMainMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
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

        /* access modifiers changed from: package-private */
        public void c() {
            if (DisposableHelper.a(this)) {
                this.s.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
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

    public MaybeTakeUntilMaybe(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2) {
        super(maybeSource);
        this.X = maybeSource2;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(maybeObserver);
        maybeObserver.b(takeUntilMainMaybeObserver);
        this.X.d(takeUntilMainMaybeObserver.X);
        this.s.d(takeUntilMainMaybeObserver);
    }
}
