package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableAmb extends Completable {
    private final Iterable<? extends CompletableSource> X;
    private final CompletableSource[] s;

    static final class Amb implements CompletableObserver {
        final CompositeDisposable X;
        final CompletableObserver Y;
        Disposable Z;
        final AtomicBoolean s;

        Amb(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.s = atomicBoolean;
            this.X = compositeDisposable;
            this.Y = completableObserver;
        }

        public void b(Disposable disposable) {
            this.Z = disposable;
            this.X.b(disposable);
        }

        public void onComplete() {
            if (this.s.compareAndSet(false, true)) {
                this.X.c(this.Z);
                this.X.m();
                this.Y.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.s.compareAndSet(false, true)) {
                this.X.c(this.Z);
                this.X.m();
                this.Y.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }
    }

    public CompletableAmb(CompletableSource[] completableSourceArr, Iterable<? extends CompletableSource> iterable) {
        this.s = completableSourceArr;
        this.X = iterable;
    }

    public void Z0(CompletableObserver completableObserver) {
        int i2;
        CompletableSource[] completableSourceArr = this.s;
        if (completableSourceArr == null) {
            completableSourceArr = new CompletableSource[8];
            try {
                i2 = 0;
                for (CompletableSource completableSource : this.X) {
                    if (completableSource == null) {
                        EmptyDisposable.e(new NullPointerException("One of the sources is null"), completableObserver);
                        return;
                    }
                    if (i2 == completableSourceArr.length) {
                        CompletableSource[] completableSourceArr2 = new CompletableSource[((i2 >> 2) + i2)];
                        System.arraycopy(completableSourceArr, 0, completableSourceArr2, 0, i2);
                        completableSourceArr = completableSourceArr2;
                    }
                    int i3 = i2 + 1;
                    completableSourceArr[i2] = completableSource;
                    i2 = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.e(th, completableObserver);
                return;
            }
        } else {
            i2 = completableSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.b(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        int i4 = 0;
        while (i4 < i2) {
            CompletableSource completableSource2 = completableSourceArr[i4];
            if (!compositeDisposable.g()) {
                if (completableSource2 == null) {
                    NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        compositeDisposable.m();
                        completableObserver.onError(nullPointerException);
                        return;
                    }
                    RxJavaPlugins.Y(nullPointerException);
                    return;
                }
                completableSource2.a(new Amb(atomicBoolean, compositeDisposable, completableObserver));
                i4++;
            } else {
                return;
            }
        }
        if (i2 == 0) {
            completableObserver.onComplete();
        }
    }
}
