package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapBiSelector<T, U, R> extends Single<R> {
    final Function<? super T, ? extends SingleSource<? extends U>> X;
    final BiFunction<? super T, ? super U, ? extends R> Y;
    final SingleSource<T> s;

    static final class FlatMapBiMainObserver<T, U, R> implements SingleObserver<T>, Disposable {
        final InnerObserver<T, U, R> X;
        final Function<? super T, ? extends SingleSource<? extends U>> s;

        static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements SingleObserver<U> {
            private static final long Z = -2897979525538174559L;
            final BiFunction<? super T, ? super U, ? extends R> X;
            T Y;
            final SingleObserver<? super R> s;

            InnerObserver(SingleObserver<? super R> singleObserver, BiFunction<? super T, ? super U, ? extends R> biFunction) {
                this.s = singleObserver;
                this.X = biFunction;
            }

            public void a(U u) {
                T t = this.Y;
                this.Y = null;
                try {
                    Object apply = this.X.apply(t, u);
                    Objects.requireNonNull(apply, "The resultSelector returned a null value");
                    this.s.a(apply);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.s.onError(th);
                }
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public void onError(Throwable th) {
                this.s.onError(th);
            }
        }

        FlatMapBiMainObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.X = new InnerObserver<>(singleObserver, biFunction);
            this.s = function;
        }

        public void a(T t) {
            try {
                Object apply = this.s.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                SingleSource singleSource = (SingleSource) apply;
                if (DisposableHelper.c(this.X, (Disposable) null)) {
                    InnerObserver<T, U, R> innerObserver = this.X;
                    innerObserver.Y = t;
                    singleSource.e(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.X.s.onError(th);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this.X, disposable)) {
                this.X.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) this.X.get());
        }

        public void m() {
            DisposableHelper.a(this.X);
        }

        public void onError(Throwable th) {
            this.X.s.onError(th);
        }
    }

    public SingleFlatMapBiSelector(SingleSource<T> singleSource, Function<? super T, ? extends SingleSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        this.s = singleSource;
        this.X = function;
        this.Y = biFunction;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super R> singleObserver) {
        this.s.e(new FlatMapBiMainObserver(singleObserver, this.X, this.Y));
    }
}
