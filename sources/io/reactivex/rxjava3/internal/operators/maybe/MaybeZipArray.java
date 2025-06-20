package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeMap;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeZipArray<T, R> extends Maybe<R> {
    final Function<? super Object[], ? extends R> X;
    final MaybeSource<? extends T>[] s;

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public R apply(T t) throws Throwable {
            R apply = MaybeZipArray.this.X.apply(new Object[]{t});
            Objects.requireNonNull(apply, "The zipper returned a null value");
            return apply;
        }
    }

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long X2 = -5556924161382950569L;
        final Function<? super Object[], ? extends R> X;
        final ZipMaybeObserver<T>[] Y;
        final Object[] Z;
        final MaybeObserver<? super R> s;

        ZipCoordinator(MaybeObserver<? super R> maybeObserver, int i2, Function<? super Object[], ? extends R> function) {
            super(i2);
            this.s = maybeObserver;
            this.X = function;
            ZipMaybeObserver<T>[] zipMaybeObserverArr = new ZipMaybeObserver[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                zipMaybeObserverArr[i3] = new ZipMaybeObserver<>(this, i3);
            }
            this.Y = zipMaybeObserverArr;
            this.Z = new Object[i2];
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            ZipMaybeObserver<T>[] zipMaybeObserverArr = this.Y;
            int length = zipMaybeObserverArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                zipMaybeObserverArr[i3].c();
            }
            while (true) {
                i2++;
                if (i2 < length) {
                    zipMaybeObserverArr[i2].c();
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            if (getAndSet(0) > 0) {
                a(i2);
                this.s.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th, int i2) {
            if (getAndSet(0) > 0) {
                a(i2);
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        /* access modifiers changed from: package-private */
        public void d(T t, int i2) {
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
                for (ZipMaybeObserver<T> c2 : this.Y) {
                    c2.c();
                }
            }
        }
    }

    static final class ZipMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long Y = 3323743579927613702L;
        final int X;
        final ZipCoordinator<T, ?> s;

        ZipMaybeObserver(ZipCoordinator<T, ?> zipCoordinator, int i2) {
            this.s = zipCoordinator;
            this.X = i2;
        }

        public void a(T t) {
            this.s.d(t, this.X);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void c() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.s.b(this.X);
        }

        public void onError(Throwable th) {
            this.s.c(th, this.X);
        }
    }

    public MaybeZipArray(MaybeSource<? extends T>[] maybeSourceArr, Function<? super Object[], ? extends R> function) {
        this.s = maybeSourceArr;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super R> maybeObserver) {
        MaybeSource<? extends T>[] maybeSourceArr = this.s;
        int length = maybeSourceArr.length;
        int i2 = 0;
        if (length == 1) {
            maybeSourceArr[0].d(new MaybeMap.MapMaybeObserver(maybeObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(maybeObserver, length, this.X);
        maybeObserver.b(zipCoordinator);
        while (i2 < length && !zipCoordinator.g()) {
            MaybeSource<? extends T> maybeSource = maybeSourceArr[i2];
            if (maybeSource == null) {
                zipCoordinator.c(new NullPointerException("One of the sources is null"), i2);
                return;
            } else {
                maybeSource.d(zipCoordinator.Y[i2]);
                i2++;
            }
        }
    }
}
