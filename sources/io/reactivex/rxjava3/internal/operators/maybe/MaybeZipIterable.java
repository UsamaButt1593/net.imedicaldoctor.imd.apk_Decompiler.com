package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeMap;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeZipArray;
import java.util.Arrays;
import java.util.Objects;

public final class MaybeZipIterable<T, R> extends Maybe<R> {
    final Function<? super Object[], ? extends R> X;
    final Iterable<? extends MaybeSource<? extends T>> s;

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public R apply(T t) throws Throwable {
            R apply = MaybeZipIterable.this.X.apply(new Object[]{t});
            Objects.requireNonNull(apply, "The zipper returned a null value");
            return apply;
        }
    }

    public MaybeZipIterable(Iterable<? extends MaybeSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.s = iterable;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super R> maybeObserver) {
        MaybeSource[] maybeSourceArr = new MaybeSource[8];
        try {
            int i2 = 0;
            for (MaybeSource maybeSource : this.s) {
                if (maybeSource == null) {
                    EmptyDisposable.f(new NullPointerException("One of the sources is null"), maybeObserver);
                    return;
                }
                if (i2 == maybeSourceArr.length) {
                    maybeSourceArr = (MaybeSource[]) Arrays.copyOf(maybeSourceArr, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                maybeSourceArr[i2] = maybeSource;
                i2 = i3;
            }
            if (i2 == 0) {
                EmptyDisposable.b(maybeObserver);
            } else if (i2 == 1) {
                maybeSourceArr[0].d(new MaybeMap.MapMaybeObserver(maybeObserver, new SingletonArrayFunc()));
            } else {
                MaybeZipArray.ZipCoordinator zipCoordinator = new MaybeZipArray.ZipCoordinator(maybeObserver, i2, this.X);
                maybeObserver.b(zipCoordinator);
                for (int i4 = 0; i4 < i2 && !zipCoordinator.g(); i4++) {
                    maybeSourceArr[i4].d(zipCoordinator.Y[i4]);
                }
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.f(th, maybeObserver);
        }
    }
}
