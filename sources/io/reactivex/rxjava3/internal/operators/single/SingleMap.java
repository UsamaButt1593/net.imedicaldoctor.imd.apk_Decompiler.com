package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;

public final class SingleMap<T, R> extends Single<R> {
    final Function<? super T, ? extends R> X;
    final SingleSource<? extends T> s;

    static final class MapSingleObserver<T, R> implements SingleObserver<T> {
        final Function<? super T, ? extends R> X;
        final SingleObserver<? super R> s;

        MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.s = singleObserver;
            this.X = function;
        }

        public void a(T t) {
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                this.s.a(apply);
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(th);
            }
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.s = singleSource;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super R> singleObserver) {
        this.s.e(new MapSingleObserver(singleObserver, this.X));
    }
}
