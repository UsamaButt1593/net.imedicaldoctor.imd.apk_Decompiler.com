package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class MaybeDoFinally<T> extends AbstractMaybeWithUpstream<T, T> {
    final Action X;

    static final class DoFinallyObserver<T> extends AtomicInteger implements MaybeObserver<T>, Disposable {
        private static final long Z = 4109457741734051389L;
        final Action X;
        Disposable Y;
        final MaybeObserver<? super T> s;

        DoFinallyObserver(MaybeObserver<? super T> maybeObserver, Action action) {
            this.s = maybeObserver;
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

        public void onComplete() {
            this.s.onComplete();
            c();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
            c();
        }
    }

    public MaybeDoFinally(MaybeSource<T> maybeSource, Action action) {
        super(maybeSource);
        this.X = action;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new DoFinallyObserver(maybeObserver, this.X));
    }
}
