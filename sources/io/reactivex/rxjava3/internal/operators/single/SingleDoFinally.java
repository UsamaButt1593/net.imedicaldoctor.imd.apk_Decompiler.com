package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleDoFinally<T> extends Single<T> {
    final Action X;
    final SingleSource<T> s;

    static final class DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {
        private static final long Z = 4109457741734051389L;
        final Action X;
        Disposable Y;
        final SingleObserver<? super T> s;

        DoFinallyObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.s = singleObserver;
            this.X = action;
        }

        public void a(T t) {
            this.s.a(t);
            c();
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (compareAndSet(0, 1)) {
                try {
                    this.X.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
            }
        }

        public boolean g() {
            return this.Y.g();
        }

        public void m() {
            this.Y.m();
            c();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
            c();
        }
    }

    public SingleDoFinally(SingleSource<T> singleSource, Action action) {
        this.s = singleSource;
        this.X = action;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new DoFinallyObserver(singleObserver, this.X));
    }
}
