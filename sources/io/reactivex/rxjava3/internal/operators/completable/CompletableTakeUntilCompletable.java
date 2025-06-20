package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTakeUntilCompletable extends Completable {
    final CompletableSource X;
    final Completable s;

    static final class TakeUntilMainObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long Z = 3533011714830024923L;
        final OtherObserver X = new OtherObserver(this);
        final AtomicBoolean Y = new AtomicBoolean();
        final CompletableObserver s;

        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long X = 5176264485428790318L;
            final TakeUntilMainObserver s;

            OtherObserver(TakeUntilMainObserver takeUntilMainObserver) {
                this.s = takeUntilMainObserver;
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public void onComplete() {
                this.s.a();
            }

            public void onError(Throwable th) {
                this.s.c(th);
            }
        }

        TakeUntilMainObserver(CompletableObserver completableObserver) {
            this.s = completableObserver;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.Y.compareAndSet(false, true)) {
                DisposableHelper.a(this);
                this.s.onComplete();
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            if (this.Y.compareAndSet(false, true)) {
                DisposableHelper.a(this);
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public boolean g() {
            return this.Y.get();
        }

        public void m() {
            if (this.Y.compareAndSet(false, true)) {
                DisposableHelper.a(this);
                DisposableHelper.a(this.X);
            }
        }

        public void onComplete() {
            if (this.Y.compareAndSet(false, true)) {
                DisposableHelper.a(this.X);
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Y.compareAndSet(false, true)) {
                DisposableHelper.a(this.X);
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }
    }

    public CompletableTakeUntilCompletable(Completable completable, CompletableSource completableSource) {
        this.s = completable;
        this.X = completableSource;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(completableObserver);
        completableObserver.b(takeUntilMainObserver);
        this.X.a(takeUntilMainObserver.X);
        this.s.a(takeUntilMainObserver);
    }
}
