package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class MaybeAmb<T> extends Maybe<T> {
    private final Iterable<? extends MaybeSource<? extends T>> X;
    private final MaybeSource<? extends T>[] s;

    static final class AmbMaybeObserver<T> implements MaybeObserver<T> {
        final AtomicBoolean X;
        final CompositeDisposable Y;
        Disposable Z;
        final MaybeObserver<? super T> s;

        AmbMaybeObserver(MaybeObserver<? super T> maybeObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
            this.s = maybeObserver;
            this.Y = compositeDisposable;
            this.X = atomicBoolean;
        }

        public void a(T t) {
            if (this.X.compareAndSet(false, true)) {
                this.Y.c(this.Z);
                this.Y.m();
                this.s.a(t);
            }
        }

        public void b(Disposable disposable) {
            this.Z = disposable;
            this.Y.b(disposable);
        }

        public void onComplete() {
            if (this.X.compareAndSet(false, true)) {
                this.Y.c(this.Z);
                this.Y.m();
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.X.compareAndSet(false, true)) {
                this.Y.c(this.Z);
                this.Y.m();
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }
    }

    public MaybeAmb(MaybeSource<? extends T>[] maybeSourceArr, Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.s = maybeSourceArr;
        this.X = iterable;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        int i2;
        MaybeSource<? extends T>[] maybeSourceArr = this.s;
        if (maybeSourceArr == null) {
            maybeSourceArr = new MaybeSource[8];
            try {
                i2 = 0;
                for (MaybeSource<? extends T> maybeSource : this.X) {
                    if (maybeSource == null) {
                        EmptyDisposable.f(new NullPointerException("One of the sources is null"), maybeObserver);
                        return;
                    }
                    if (i2 == maybeSourceArr.length) {
                        MaybeSource<? extends T>[] maybeSourceArr2 = new MaybeSource[((i2 >> 2) + i2)];
                        System.arraycopy(maybeSourceArr, 0, maybeSourceArr2, 0, i2);
                        maybeSourceArr = maybeSourceArr2;
                    }
                    int i3 = i2 + 1;
                    maybeSourceArr[i2] = maybeSource;
                    i2 = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.f(th, maybeObserver);
                return;
            }
        } else {
            i2 = maybeSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        maybeObserver.b(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        int i4 = 0;
        while (i4 < i2) {
            MaybeSource<? extends T> maybeSource2 = maybeSourceArr[i4];
            if (!compositeDisposable.g()) {
                if (maybeSource2 == null) {
                    compositeDisposable.m();
                    NullPointerException nullPointerException = new NullPointerException("One of the MaybeSources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        maybeObserver.onError(nullPointerException);
                        return;
                    } else {
                        RxJavaPlugins.Y(nullPointerException);
                        return;
                    }
                } else {
                    maybeSource2.d(new AmbMaybeObserver(maybeObserver, compositeDisposable, atomicBoolean));
                    i4++;
                }
            } else {
                return;
            }
        }
        if (i2 == 0) {
            maybeObserver.onComplete();
        }
    }
}
