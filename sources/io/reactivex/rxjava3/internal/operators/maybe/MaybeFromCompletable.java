package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamCompletableSource;

public final class MaybeFromCompletable<T> extends Maybe<T> implements HasUpstreamCompletableSource {
    final CompletableSource s;

    static final class FromCompletableObserver<T> implements CompletableObserver, Disposable {
        Disposable X;
        final MaybeObserver<? super T> s;

        FromCompletableObserver(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
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
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.X = DisposableHelper.DISPOSED;
            this.s.onError(th);
        }
    }

    public MaybeFromCompletable(CompletableSource completableSource) {
        this.s = completableSource;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.a(new FromCompletableObserver(maybeObserver));
    }

    public CompletableSource source() {
        return this.s;
    }
}
