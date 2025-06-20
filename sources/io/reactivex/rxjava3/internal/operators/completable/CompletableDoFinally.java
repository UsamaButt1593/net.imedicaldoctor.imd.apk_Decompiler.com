package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableDoFinally extends Completable {
    final Action X;
    final CompletableSource s;

    static final class DoFinallyObserver extends AtomicInteger implements CompletableObserver, Disposable {
        private static final long Z = 4109457741734051389L;
        final Action X;
        Disposable Y;
        final CompletableObserver s;

        DoFinallyObserver(CompletableObserver completableObserver, Action action) {
            this.s = completableObserver;
            this.X = action;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.X.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Y.g();
        }

        public void m() {
            this.Y.m();
            a();
        }

        public void onComplete() {
            this.s.onComplete();
            a();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
            a();
        }
    }

    public CompletableDoFinally(CompletableSource completableSource, Action action) {
        this.s = completableSource;
        this.X = action;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.a(new DoFinallyObserver(completableObserver, this.X));
    }
}
