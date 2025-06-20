package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmptySingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {
    final SingleSource<? extends T> X;
    final MaybeSource<T> s;

    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long Y = 4603919676453758899L;
        final SingleSource<? extends T> X;
        final SingleObserver<? super T> s;

        static final class OtherSingleObserver<T> implements SingleObserver<T> {
            final AtomicReference<Disposable> X;
            final SingleObserver<? super T> s;

            OtherSingleObserver(SingleObserver<? super T> singleObserver, AtomicReference<Disposable> atomicReference) {
                this.s = singleObserver;
                this.X = atomicReference;
            }

            public void a(T t) {
                this.s.a(t);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this.X, disposable);
            }

            public void onError(Throwable th) {
                this.s.onError(th);
            }
        }

        SwitchIfEmptyMaybeObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.s = singleObserver;
            this.X = singleSource;
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
                this.X.e(new OtherSingleObserver(this.s, this));
            }
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public MaybeSwitchIfEmptySingle(MaybeSource<T> maybeSource, SingleSource<? extends T> singleSource) {
        this.s = maybeSource;
        this.X = singleSource;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.d(new SwitchIfEmptyMaybeObserver(singleObserver, this.X));
    }

    public MaybeSource<T> source() {
        return this.s;
    }
}
