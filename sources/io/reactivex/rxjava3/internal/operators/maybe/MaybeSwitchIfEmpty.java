package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmpty<T> extends AbstractMaybeWithUpstream<T, T> {
    final MaybeSource<? extends T> X;

    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long Y = -2223459372976438024L;
        final MaybeSource<? extends T> X;
        final MaybeObserver<? super T> s;

        static final class OtherMaybeObserver<T> implements MaybeObserver<T> {
            final AtomicReference<Disposable> X;
            final MaybeObserver<? super T> s;

            OtherMaybeObserver(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
                this.s = maybeObserver;
                this.X = atomicReference;
            }

            public void a(T t) {
                this.s.a(t);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this.X, disposable);
            }

            public void onComplete() {
                this.s.onComplete();
            }

            public void onError(Throwable th) {
                this.s.onError(th);
            }
        }

        SwitchIfEmptyMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
            this.s = maybeObserver;
            this.X = maybeSource;
        }

        public void a(T t) {
            this.s.a(t);
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
            Disposable disposable = (Disposable) get();
            if (disposable != DisposableHelper.DISPOSED && compareAndSet(disposable, (Object) null)) {
                this.X.d(new OtherMaybeObserver(this.s, this));
            }
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public MaybeSwitchIfEmpty(MaybeSource<T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        super(maybeSource);
        this.X = maybeSource2;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        this.s.d(new SwitchIfEmptyMaybeObserver(maybeObserver, this.X));
    }
}
