package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import java.util.NoSuchElementException;

public final class MaybeToSingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {
    final T X;
    final MaybeSource<T> s;

    static final class ToSingleMaybeSubscriber<T> implements MaybeObserver<T>, Disposable {
        final T X;
        Disposable Y;
        final SingleObserver<? super T> s;

        ToSingleMaybeSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.s = singleObserver;
            this.X = t;
        }

        public void a(T t) {
            this.Y = DisposableHelper.DISPOSED;
            this.s.a(t);
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
            T t = this.X;
            if (t != null) {
                this.s.a(t);
            } else {
                this.s.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }

        public void onError(Throwable th) {
            this.Y = DisposableHelper.DISPOSED;
            this.s.onError(th);
        }
    }

    public MaybeToSingle(MaybeSource<T> maybeSource, T t) {
        this.s = maybeSource;
        this.X = t;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.d(new ToSingleMaybeSubscriber(singleObserver, this.X));
    }

    public MaybeSource<T> source() {
        return this.s;
    }
}
