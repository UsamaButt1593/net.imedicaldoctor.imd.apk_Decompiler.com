package io.reactivex.rxjava3.internal.operators.single;

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

public final class SingleFlatMapMaybe<T, R> extends Maybe<R> {
    final Function<? super T, ? extends MaybeSource<? extends R>> X;
    final SingleSource<? extends T> s;

    static final class FlatMapMaybeObserver<R> implements MaybeObserver<R> {
        final MaybeObserver<? super R> X;
        final AtomicReference<Disposable> s;

        FlatMapMaybeObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
            this.s = atomicReference;
            this.X = maybeObserver;
        }

        public void a(R r) {
            this.X.a(r);
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

    static final class FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long Y = -5843758257109742742L;
        final Function<? super T, ? extends MaybeSource<? extends R>> X;
        final MaybeObserver<? super R> s;

        FlatMapSingleObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
            this.s = maybeObserver;
            this.X = function;
        }

        public void a(T t) {
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                if (!g()) {
                    maybeSource.d(new FlatMapMaybeObserver(this, this.s));
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

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public SingleFlatMapMaybe(SingleSource<? extends T> singleSource, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        this.X = function;
        this.s = singleSource;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super R> maybeObserver) {
        this.s.e(new FlatMapSingleObserver(maybeObserver, this.X));
    }
}
