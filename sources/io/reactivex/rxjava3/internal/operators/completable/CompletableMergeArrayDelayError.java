package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArrayDelayError extends Completable {
    final CompletableSource[] s;

    static final class MergeInnerCompletableObserver implements CompletableObserver {
        final CompositeDisposable X;
        final AtomicThrowable Y;
        final AtomicInteger Z;
        final CompletableObserver s;

        MergeInnerCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
            this.s = completableObserver;
            this.X = compositeDisposable;
            this.Y = atomicThrowable;
            this.Z = atomicInteger;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.Z.decrementAndGet() == 0) {
                this.Y.f(this.s);
            }
        }

        public void b(Disposable disposable) {
            this.X.b(disposable);
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th) {
            if (this.Y.d(th)) {
                a();
            }
        }
    }

    static final class TryTerminateAndReportDisposable implements Disposable {
        final AtomicThrowable s;

        TryTerminateAndReportDisposable(AtomicThrowable atomicThrowable) {
            this.s = atomicThrowable;
        }

        public boolean g() {
            return this.s.a();
        }

        public void m() {
            this.s.e();
        }
    }

    public CompletableMergeArrayDelayError(CompletableSource[] completableSourceArr) {
        this.s = completableSourceArr;
    }

    public void Z0(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        AtomicInteger atomicInteger = new AtomicInteger(this.s.length + 1);
        AtomicThrowable atomicThrowable = new AtomicThrowable();
        compositeDisposable.b(new TryTerminateAndReportDisposable(atomicThrowable));
        completableObserver.b(compositeDisposable);
        CompletableSource[] completableSourceArr = this.s;
        int length = completableSourceArr.length;
        int i2 = 0;
        while (i2 < length) {
            CompletableSource completableSource = completableSourceArr[i2];
            if (!compositeDisposable.g()) {
                if (completableSource == null) {
                    atomicThrowable.d(new NullPointerException("A completable source is null"));
                    atomicInteger.decrementAndGet();
                } else {
                    completableSource.a(new MergeInnerCompletableObserver(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
                }
                i2++;
            } else {
                return;
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            atomicThrowable.f(completableObserver);
        }
    }
}
