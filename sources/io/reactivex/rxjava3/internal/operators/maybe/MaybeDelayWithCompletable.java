package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelayWithCompletable<T> extends Maybe<T> {
    final CompletableSource X;
    final MaybeSource<T> s;

    static final class DelayWithMainObserver<T> implements MaybeObserver<T> {
        final MaybeObserver<? super T> X;
        final AtomicReference<Disposable> s;

        DelayWithMainObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super T> maybeObserver) {
            this.s = atomicReference;
            this.X = maybeObserver;
        }

        public void a(T t) {
            this.X.a(t);
        }

        public void b(Disposable disposable) {
            DisposableHelper.c(this.s, disposable);
        }

        public void onComplete() {
            this.X.onComplete();
        }

        public void onError(Throwable th) {
            this.X.onError(th);
        }
    }

    static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long Y = 703409937383992161L;
        final MaybeSource<T> X;
        final MaybeObserver<? super T> s;

        OtherObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.s = maybeObserver;
            this.X = maybeSource;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable)) {
                this.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.X.d(new DelayWithMainObserver(this, this.s));
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public MaybeDelayWithCompletable(MaybeSource<T> maybeSource, CompletableSource completableSource) {
        this.s = maybeSource;
        this.X = completableSource;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.X.a(new OtherObserver(maybeObserver, this.s));
    }
}
