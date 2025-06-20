package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMap<T, R> extends Single<R> {
    final Function<? super T, ? extends SingleSource<? extends R>> X;
    final SingleSource<? extends T> s;

    static final class SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long Y = 3258103020495908596L;
        final Function<? super T, ? extends SingleSource<? extends R>> X;
        final SingleObserver<? super R> s;

        static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
            final SingleObserver<? super R> X;
            final AtomicReference<Disposable> s;

            FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
                this.s = atomicReference;
                this.X = singleObserver;
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

        SingleFlatMapCallback(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.s = singleObserver;
            this.X = function;
        }

        public void a(T t) {
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The single returned by the mapper is null");
                SingleSource singleSource = (SingleSource) apply;
                if (!g()) {
                    singleSource.e(new FlatMapSingleObserver(this, this.s));
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
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

    public SingleFlatMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.X = function;
        this.s = singleSource;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super R> singleObserver) {
        this.s.e(new SingleFlatMapCallback(singleObserver, this.X));
    }
}
