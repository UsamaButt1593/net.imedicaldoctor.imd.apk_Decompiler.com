package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;

public final class MaybeCount<T> extends Single<Long> implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> s;

    static final class CountMaybeObserver implements MaybeObserver<Object>, Disposable {
        Disposable X;
        final SingleObserver<? super Long> s;

        CountMaybeObserver(SingleObserver<? super Long> singleObserver) {
            this.s = singleObserver;
        }

        public void a(Object obj) {
            this.X = DisposableHelper.DISPOSED;
            this.s.a(1L);
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
            this.X = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.X = DisposableHelper.DISPOSED;
            this.s.a(0L);
        }

        public void onError(Throwable th) {
            this.X = DisposableHelper.DISPOSED;
            this.s.onError(th);
        }
    }

    public MaybeCount(MaybeSource<T> maybeSource) {
        this.s = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Long> singleObserver) {
        this.s.d(new CountMaybeObserver(singleObserver));
    }

    public MaybeSource<T> source() {
        return this.s;
    }
}
