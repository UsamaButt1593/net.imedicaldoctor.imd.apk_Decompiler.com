package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeDetach<T> extends AbstractMaybeWithUpstream<T, T> {

    static final class DetachMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        Disposable X;
        MaybeObserver<? super T> s;

        DetachMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
        }

        public void a(T t) {
            this.X = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.s;
            if (maybeObserver != null) {
                this.s = null;
                maybeObserver.a(t);
            }
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
            this.s = null;
            this.X.m();
            this.X = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.X = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.s;
            if (maybeObserver != null) {
                this.s = null;
                maybeObserver.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.X = DisposableHelper.DISPOSED;
            MaybeObserver<? super T> maybeObserver = this.s;
            if (maybeObserver != null) {
                this.s = null;
                maybeObserver.onError(th);
            }
        }
    }

    public MaybeDetach(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new DetachMaybeObserver(maybeObserver));
    }
}
