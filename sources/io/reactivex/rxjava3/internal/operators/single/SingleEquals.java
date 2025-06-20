package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleEquals<T> extends Single<Boolean> {
    final SingleSource<? extends T> X;
    final SingleSource<? extends T> s;

    static class InnerObserver<T> implements SingleObserver<T> {
        final CompositeDisposable X;
        final AtomicInteger X2;
        final Object[] Y;
        final SingleObserver<? super Boolean> Z;
        final int s;

        InnerObserver(int i2, CompositeDisposable compositeDisposable, Object[] objArr, SingleObserver<? super Boolean> singleObserver, AtomicInteger atomicInteger) {
            this.s = i2;
            this.X = compositeDisposable;
            this.Y = objArr;
            this.Z = singleObserver;
            this.X2 = atomicInteger;
        }

        public void a(T t) {
            this.Y[this.s] = t;
            if (this.X2.incrementAndGet() == 2) {
                SingleObserver<? super Boolean> singleObserver = this.Z;
                Object[] objArr = this.Y;
                singleObserver.a(Boolean.valueOf(Objects.equals(objArr[0], objArr[1])));
            }
        }

        public void b(Disposable disposable) {
            this.X.b(disposable);
        }

        public void onError(Throwable th) {
            int andSet = this.X2.getAndSet(-1);
            if (andSet == 0 || andSet == 1) {
                this.X.m();
                this.Z.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }
    }

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.s = singleSource;
        this.X = singleSource2;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.b(compositeDisposable);
        CompositeDisposable compositeDisposable2 = compositeDisposable;
        Object[] objArr = {null, null};
        SingleObserver<? super Boolean> singleObserver2 = singleObserver;
        AtomicInteger atomicInteger2 = atomicInteger;
        this.s.e(new InnerObserver(0, compositeDisposable2, objArr, singleObserver2, atomicInteger2));
        this.X.e(new InnerObserver(1, compositeDisposable2, objArr, singleObserver2, atomicInteger2));
    }
}
