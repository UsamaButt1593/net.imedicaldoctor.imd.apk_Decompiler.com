package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeIsEmpty<T> extends AbstractMaybeWithUpstream<T, Boolean> {

    static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        Disposable X;
        final MaybeObserver<? super Boolean> s;

        IsEmptyMaybeObserver(MaybeObserver<? super Boolean> maybeObserver) {
            this.s = maybeObserver;
        }

        public void a(T t) {
            this.s.a(Boolean.FALSE);
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
            this.X.m();
        }

        public void onComplete() {
            this.s.a(Boolean.TRUE);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public MaybeIsEmpty(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super Boolean> maybeObserver) {
        this.s.d(new IsEmptyMaybeObserver(maybeObserver));
    }
}
