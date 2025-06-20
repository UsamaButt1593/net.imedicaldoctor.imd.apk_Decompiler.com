package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamSingleSource;

public final class MaybeFromSingle<T> extends Maybe<T> implements HasUpstreamSingleSource<T> {
    final SingleSource<T> s;

    static final class FromSingleObserver<T> implements SingleObserver<T>, Disposable {
        Disposable X;
        final MaybeObserver<? super T> s;

        FromSingleObserver(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
        }

        public void a(T t) {
            this.X = DisposableHelper.DISPOSED;
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
            this.X.m();
            this.X = DisposableHelper.DISPOSED;
        }

        public void onError(Throwable th) {
            this.X = DisposableHelper.DISPOSED;
            this.s.onError(th);
        }
    }

    public MaybeFromSingle(SingleSource<T> singleSource) {
        this.s = singleSource;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.e(new FromSingleObserver(maybeObserver));
    }

    public SingleSource<T> source() {
        return this.s;
    }
}
