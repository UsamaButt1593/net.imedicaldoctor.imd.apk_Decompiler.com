package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArray extends Completable {
    final CompletableSource[] s;

    static final class InnerCompletableObserver extends AtomicInteger implements CompletableObserver, Disposable {
        private static final long Z = -8360547806504310570L;
        final AtomicBoolean X;
        final CompositeDisposable Y;
        final CompletableObserver s;

        InnerCompletableObserver(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, int i2) {
            this.s = completableObserver;
            this.X = atomicBoolean;
            this.Y = compositeDisposable;
            lazySet(i2);
        }

        public void b(Disposable disposable) {
            this.Y.b(disposable);
        }

        public boolean g() {
            return this.Y.g();
        }

        public void m() {
            this.Y.m();
            this.X.set(true);
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.Y.m();
            if (this.X.compareAndSet(false, true)) {
                this.s.onError(th);
            } else {
                RxJavaPlugins.Y(th);
            }
        }
    }

    public CompletableMergeArray(CompletableSource[] completableSourceArr) {
        this.s = completableSourceArr;
    }

    public void Z0(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(completableObserver, new AtomicBoolean(), compositeDisposable, this.s.length + 1);
        completableObserver.b(innerCompletableObserver);
        CompletableSource[] completableSourceArr = this.s;
        int length = completableSourceArr.length;
        int i2 = 0;
        while (i2 < length) {
            CompletableSource completableSource = completableSourceArr[i2];
            if (!compositeDisposable.g()) {
                if (completableSource == null) {
                    compositeDisposable.m();
                    innerCompletableObserver.onError(new NullPointerException("A completable source is null"));
                    return;
                }
                completableSource.a(innerCompletableObserver);
                i2++;
            } else {
                return;
            }
        }
        innerCompletableObserver.onComplete();
    }
}
