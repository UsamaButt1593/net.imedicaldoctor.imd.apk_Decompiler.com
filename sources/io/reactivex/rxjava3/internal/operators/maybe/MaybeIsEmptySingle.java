package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToMaybe;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeIsEmptySingle<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T>, FuseToMaybe<Boolean> {
    final MaybeSource<T> s;

    static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        Disposable X;
        final SingleObserver<? super Boolean> s;

        IsEmptyMaybeObserver(SingleObserver<? super Boolean> singleObserver) {
            this.s = singleObserver;
        }

        public void a(T t) {
            this.X = DisposableHelper.DISPOSED;
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
            this.X = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.X = DisposableHelper.DISPOSED;
            this.s.a(Boolean.TRUE);
        }

        public void onError(Throwable th) {
            this.X = DisposableHelper.DISPOSED;
            this.s.onError(th);
        }
    }

    public MaybeIsEmptySingle(MaybeSource<T> maybeSource) {
        this.s = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Boolean> singleObserver) {
        this.s.d(new IsEmptyMaybeObserver(singleObserver));
    }

    public Maybe<Boolean> d() {
        return RxJavaPlugins.Q(new MaybeIsEmpty(this.s));
    }

    public MaybeSource<T> source() {
        return this.s;
    }
}
