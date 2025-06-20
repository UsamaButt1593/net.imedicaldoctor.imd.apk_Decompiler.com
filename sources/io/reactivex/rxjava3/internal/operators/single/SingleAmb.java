package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SingleAmb<T> extends Single<T> {
    private final Iterable<? extends SingleSource<? extends T>> X;
    private final SingleSource<? extends T>[] s;

    static final class AmbSingleObserver<T> implements SingleObserver<T> {
        final SingleObserver<? super T> X;
        final AtomicBoolean Y;
        Disposable Z;
        final CompositeDisposable s;

        AmbSingleObserver(SingleObserver<? super T> singleObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
            this.X = singleObserver;
            this.s = compositeDisposable;
            this.Y = atomicBoolean;
        }

        public void a(T t) {
            if (this.Y.compareAndSet(false, true)) {
                this.s.c(this.Z);
                this.s.m();
                this.X.a(t);
            }
        }

        public void b(Disposable disposable) {
            this.Z = disposable;
            this.s.b(disposable);
        }

        public void onError(Throwable th) {
            if (this.Y.compareAndSet(false, true)) {
                this.s.c(this.Z);
                this.s.m();
                this.X.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }
    }

    public SingleAmb(SingleSource<? extends T>[] singleSourceArr, Iterable<? extends SingleSource<? extends T>> iterable) {
        this.s = singleSourceArr;
        this.X = iterable;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        int i2;
        SingleSource<? extends T>[] singleSourceArr = this.s;
        if (singleSourceArr == null) {
            singleSourceArr = new SingleSource[8];
            try {
                i2 = 0;
                for (SingleSource<? extends T> singleSource : this.X) {
                    if (singleSource == null) {
                        EmptyDisposable.i(new NullPointerException("One of the sources is null"), singleObserver);
                        return;
                    }
                    if (i2 == singleSourceArr.length) {
                        SingleSource<? extends T>[] singleSourceArr2 = new SingleSource[((i2 >> 2) + i2)];
                        System.arraycopy(singleSourceArr, 0, singleSourceArr2, 0, i2);
                        singleSourceArr = singleSourceArr2;
                    }
                    int i3 = i2 + 1;
                    singleSourceArr[i2] = singleSource;
                    i2 = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.i(th, singleObserver);
                return;
            }
        } else {
            i2 = singleSourceArr.length;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.b(compositeDisposable);
        int i4 = 0;
        while (i4 < i2) {
            SingleSource<? extends T> singleSource2 = singleSourceArr[i4];
            if (!compositeDisposable.g()) {
                if (singleSource2 == null) {
                    compositeDisposable.m();
                    NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        singleObserver.onError(nullPointerException);
                        return;
                    } else {
                        RxJavaPlugins.Y(nullPointerException);
                        return;
                    }
                } else {
                    singleSource2.e(new AmbSingleObserver(singleObserver, compositeDisposable, atomicBoolean));
                    i4++;
                }
            } else {
                return;
            }
        }
    }
}
