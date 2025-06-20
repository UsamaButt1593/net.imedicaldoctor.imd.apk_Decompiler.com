package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.single.SingleMap;
import io.reactivex.rxjava3.internal.operators.single.SingleZipArray;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class SingleZipIterable<T, R> extends Single<R> {
    final Function<? super Object[], ? extends R> X;
    final Iterable<? extends SingleSource<? extends T>> s;

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public R apply(T t) throws Throwable {
            R apply = SingleZipIterable.this.X.apply(new Object[]{t});
            Objects.requireNonNull(apply, "The zipper returned a null value");
            return apply;
        }
    }

    public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        this.s = iterable;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super R> singleObserver) {
        SingleSource[] singleSourceArr = new SingleSource[8];
        try {
            int i2 = 0;
            for (SingleSource singleSource : this.s) {
                if (singleSource == null) {
                    EmptyDisposable.i(new NullPointerException("One of the sources is null"), singleObserver);
                    return;
                }
                if (i2 == singleSourceArr.length) {
                    singleSourceArr = (SingleSource[]) Arrays.copyOf(singleSourceArr, (i2 >> 2) + i2);
                }
                int i3 = i2 + 1;
                singleSourceArr[i2] = singleSource;
                i2 = i3;
            }
            if (i2 == 0) {
                EmptyDisposable.i(new NoSuchElementException(), singleObserver);
            } else if (i2 == 1) {
                singleSourceArr[0].e(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
            } else {
                SingleZipArray.ZipCoordinator zipCoordinator = new SingleZipArray.ZipCoordinator(singleObserver, i2, this.X);
                singleObserver.b(zipCoordinator);
                for (int i4 = 0; i4 < i2 && !zipCoordinator.g(); i4++) {
                    singleSourceArr[i4].e(zipCoordinator.Y[i4]);
                }
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, singleObserver);
        }
    }
}
