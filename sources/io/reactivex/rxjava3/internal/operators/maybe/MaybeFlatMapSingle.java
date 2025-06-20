package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapSingle<T, R> extends Maybe<R> {
    final Function<? super T, ? extends SingleSource<? extends R>> X;
    final MaybeSource<T> s;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long Y = 4827726964688405508L;
        final Function<? super T, ? extends SingleSource<? extends R>> X;
        final MaybeObserver<? super R> s;

        FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.s = maybeObserver;
            this.X = function;
        }

        public void a(T t) {
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                if (!g()) {
                    singleSource.e(new FlatMapSingleObserver(this, this.s));
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(th);
            }
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
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
        final MaybeObserver<? super R> X;
        final AtomicReference<Disposable> s;

        FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
            this.s = atomicReference;
            this.X = maybeObserver;
        }

        public void a(R r) {
            this.X.a(r);
        }

        public void b(Disposable disposable) {
            DisposableHelper.c(this.s, disposable);
        }

        public void onError(Throwable th) {
            this.X.onError(th);
        }
    }

    public MaybeFlatMapSingle(MaybeSource<T> maybeSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.s = maybeSource;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super R> maybeObserver) {
        this.s.d(new FlatMapMaybeObserver(maybeObserver, this.X));
    }
}
