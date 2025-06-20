package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.single.SingleMap;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleZipArray<T, R> extends Single<R> {
    final Function<? super Object[], ? extends R> X;
    final SingleSource<? extends T>[] s;

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public R apply(T t) throws Throwable {
            R apply = SingleZipArray.this.X.apply(new Object[]{t});
            Objects.requireNonNull(apply, "The zipper returned a null value");
            return apply;
        }
    }

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long X2 = -5556924161382950569L;
        final Function<? super Object[], ? extends R> X;
        final ZipSingleObserver<T>[] Y;
        final Object[] Z;
        final SingleObserver<? super R> s;

        ZipCoordinator(SingleObserver<? super R> singleObserver, int i2, Function<? super Object[], ? extends R> function) {
            super(i2);
            this.s = singleObserver;
            this.X = function;
            ZipSingleObserver<T>[] zipSingleObserverArr = new ZipSingleObserver[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                zipSingleObserverArr[i3] = new ZipSingleObserver<>(this, i3);
            }
            this.Y = zipSingleObserverArr;
            this.Z = new Object[i2];
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            ZipSingleObserver<T>[] zipSingleObserverArr = this.Y;
            int length = zipSingleObserverArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                zipSingleObserverArr[i3].c();
            }
            while (true) {
                i2++;
                if (i2 < length) {
                    zipSingleObserverArr[i2].c();
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Throwable th, int i2) {
            if (getAndSet(0) > 0) {
                a(i2);
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        /* access modifiers changed from: package-private */
        public void c(T t, int i2) {
            this.Z[i2] = t;
            if (decrementAndGet() == 0) {
                try {
                    Object apply = this.X.apply(this.Z);
                    Objects.requireNonNull(apply, "The zipper returned a null value");
                    this.s.a(apply);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.s.onError(th);
                }
            }
        }

        public boolean g() {
            return get() <= 0;
        }

        public void m() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver<T> c2 : this.Y) {
                    c2.c();
                }
            }
        }
    }

    static final class ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        private static final long Y = 3323743579927613702L;
        final int X;
        final ZipCoordinator<T, ?> s;

        ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i2) {
            this.s = zipCoordinator;
            this.X = i2;
        }

        public void a(T t) {
            this.s.c(t, this.X);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void c() {
            DisposableHelper.a(this);
        }

        public void onError(Throwable th) {
            this.s.b(th, this.X);
        }
    }

    public SingleZipArray(SingleSource<? extends T>[] singleSourceArr, Function<? super Object[], ? extends R> function) {
        this.s = singleSourceArr;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super R> singleObserver) {
        SingleSource<? extends T>[] singleSourceArr = this.s;
        int length = singleSourceArr.length;
        int i2 = 0;
        if (length == 1) {
            singleSourceArr[0].e(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(singleObserver, length, this.X);
        singleObserver.b(zipCoordinator);
        while (i2 < length && !zipCoordinator.g()) {
            SingleSource<? extends T> singleSource = singleSourceArr[i2];
            if (singleSource == null) {
                zipCoordinator.b(new NullPointerException("One of the sources is null"), i2);
                return;
            } else {
                singleSource.e(zipCoordinator.Y[i2]);
                i2++;
            }
        }
    }
}
