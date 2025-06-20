package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatArray extends Completable {
    final CompletableSource[] s;

    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long X2 = -7965400327305809232L;
        final CompletableSource[] X;
        int Y;
        final SequentialDisposable Z = new SequentialDisposable();
        final CompletableObserver s;

        ConcatInnerObserver(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
            this.s = completableObserver;
            this.X = completableSourceArr;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.Z.g() && getAndIncrement() == 0) {
                CompletableSource[] completableSourceArr = this.X;
                while (!this.Z.g()) {
                    int i2 = this.Y;
                    this.Y = i2 + 1;
                    if (i2 == completableSourceArr.length) {
                        this.s.onComplete();
                        return;
                    }
                    completableSourceArr[i2].a(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void b(Disposable disposable) {
            this.Z.a(disposable);
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public CompletableConcatArray(CompletableSource[] completableSourceArr) {
        this.s = completableSourceArr;
    }

    public void Z0(CompletableObserver completableObserver) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, this.s);
        completableObserver.b(concatInnerObserver.Z);
        concatInnerObserver.a();
    }
}
