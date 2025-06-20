package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import java.util.Objects;

public final class MaybeContains<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T> {
    final Object X;
    final MaybeSource<T> s;

    static final class ContainsMaybeObserver implements MaybeObserver<Object>, Disposable {
        final Object X;
        Disposable Y;
        final SingleObserver<? super Boolean> s;

        ContainsMaybeObserver(SingleObserver<? super Boolean> singleObserver, Object obj) {
            this.s = singleObserver;
            this.X = obj;
        }

        public void a(Object obj) {
            this.Y = DisposableHelper.DISPOSED;
            this.s.a(Boolean.valueOf(Objects.equals(obj, this.X)));
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
            this.Y = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.Y = DisposableHelper.DISPOSED;
            this.s.a(Boolean.FALSE);
        }

        public void onError(Throwable th) {
            this.Y = DisposableHelper.DISPOSED;
            this.s.onError(th);
        }
    }

    public MaybeContains(MaybeSource<T> maybeSource, Object obj) {
        this.s = maybeSource;
        this.X = obj;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Boolean> singleObserver) {
        this.s.d(new ContainsMaybeObserver(singleObserver, this.X));
    }

    public MaybeSource<T> source() {
        return this.s;
    }
}
