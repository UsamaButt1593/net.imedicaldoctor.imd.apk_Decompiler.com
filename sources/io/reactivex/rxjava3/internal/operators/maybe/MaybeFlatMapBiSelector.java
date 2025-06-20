package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapBiSelector<T, U, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends U>> X;
    final BiFunction<? super T, ? super U, ? extends R> Y;

    static final class FlatMapBiMainObserver<T, U, R> implements MaybeObserver<T>, Disposable {
        final InnerObserver<T, U, R> X;
        final Function<? super T, ? extends MaybeSource<? extends U>> s;

        static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long Z = -2897979525538174559L;
            final BiFunction<? super T, ? super U, ? extends R> X;
            T Y;
            final MaybeObserver<? super R> s;

            InnerObserver(MaybeObserver<? super R> maybeObserver, BiFunction<? super T, ? super U, ? extends R> biFunction) {
                this.s = maybeObserver;
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

            public void onComplete() {
                this.s.onComplete();
            }

            public void onError(Throwable th) {
                this.s.onError(th);
            }
        }

        FlatMapBiMainObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.X = new InnerObserver<>(maybeObserver, biFunction);
            this.s = function;
        }

        public void a(T t) {
            try {
                Object apply = this.s.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                if (DisposableHelper.c(this.X, (Disposable) null)) {
                    InnerObserver<T, U, R> innerObserver = this.X;
                    innerObserver.Y = t;
                    maybeSource.d(innerObserver);
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

        public void onComplete() {
            this.X.s.onComplete();
        }

        public void onError(Throwable th) {
            this.X.s.onError(th);
        }
    }

    public MaybeFlatMapBiSelector(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        super(maybeSource);
        this.X = function;
        this.Y = biFunction;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super R> maybeObserver) {
        this.s.d(new FlatMapBiMainObserver(maybeObserver, this.X, this.Y));
    }
}
