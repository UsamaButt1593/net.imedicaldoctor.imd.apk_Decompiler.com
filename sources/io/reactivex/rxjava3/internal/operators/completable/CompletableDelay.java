package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableDelay extends Completable {
    final long X;
    final boolean X2;
    final TimeUnit Y;
    final Scheduler Z;
    final CompletableSource s;

    static final class Delay extends AtomicReference<Disposable> implements CompletableObserver, Runnable, Disposable {
        private static final long Z2 = 465972761105851022L;
        final long X;
        final boolean X2;
        final TimeUnit Y;
        Throwable Y2;
        final Scheduler Z;
        final CompletableObserver s;

        Delay(CompletableObserver completableObserver, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.s = completableObserver;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = scheduler;
            this.X2 = z;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable)) {
                this.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            DisposableHelper.c(this, this.Z.h(this, this.X, this.Y));
        }

        public void onError(Throwable th) {
            this.Y2 = th;
            DisposableHelper.c(this, this.Z.h(this, this.X2 ? this.X : 0, this.Y));
        }

        public void run() {
            Throwable th = this.Y2;
            this.Y2 = null;
            if (th != null) {
                this.s.onError(th);
            } else {
                this.s.onComplete();
            }
        }
    }

    public CompletableDelay(CompletableSource completableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        this.s = completableSource;
        this.X = j2;
        this.Y = timeUnit;
        this.Z = scheduler;
        this.X2 = z;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.a(new Delay(completableObserver, this.X, this.Y, this.Z, this.X2));
    }
}
