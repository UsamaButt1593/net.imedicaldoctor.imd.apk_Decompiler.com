package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDoOnDispose<T> extends Single<T> {
    final Action X;
    final SingleSource<T> s;

    static final class DoOnDisposeObserver<T> extends AtomicReference<Action> implements SingleObserver<T>, Disposable {
        private static final long Y = -8583764624474935784L;
        Disposable X;
        final SingleObserver<? super T> s;

        DoOnDisposeObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.s = singleObserver;
            lazySet(action);
        }

        public void a(T t) {
            this.s.a(t);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X, disposable)) {
                this.X = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.X.g();
        }

        public void m() {
            Action action = (Action) getAndSet((Object) null);
            if (action != null) {
                try {
                    action.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
                this.X.m();
            }
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public SingleDoOnDispose(SingleSource<T> singleSource, Action action) {
        this.s = singleSource;
        this.X = action;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new DoOnDisposeObserver(singleObserver, this.X));
    }
}
