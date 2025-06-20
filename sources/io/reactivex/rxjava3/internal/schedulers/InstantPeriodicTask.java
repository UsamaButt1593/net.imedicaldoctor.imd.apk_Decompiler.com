package io.reactivex.rxjava3.internal.schedulers;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class InstantPeriodicTask implements Callable<Void>, Disposable {
    static final FutureTask<Void> Y2 = new FutureTask<>(Functions.f28373b, (Object) null);
    final AtomicReference<Future<?>> X = new AtomicReference<>();
    Thread X2;
    final AtomicReference<Future<?>> Y = new AtomicReference<>();
    final ExecutorService Z;
    final Runnable s;

    InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.s = runnable;
        this.Z = executorService;
    }

    /* renamed from: a */
    public Void call() {
        this.X2 = Thread.currentThread();
        try {
            this.s.run();
            this.X2 = null;
            c(this.Z.submit(this));
            return null;
        } catch (Throwable th) {
            this.X2 = null;
            RxJavaPlugins.Y(th);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Future<?> future) {
        Future future2;
        do {
            future2 = this.Y.get();
            if (future2 == Y2) {
                future.cancel(this.X2 != Thread.currentThread());
                return;
            }
        } while (!g.a(this.Y, future2, future));
    }

    /* access modifiers changed from: package-private */
    public void c(Future<?> future) {
        Future future2;
        do {
            future2 = this.X.get();
            if (future2 == Y2) {
                future.cancel(this.X2 != Thread.currentThread());
                return;
            }
        } while (!g.a(this.X, future2, future));
    }

    public boolean g() {
        return this.Y.get() == Y2;
    }

    public void m() {
        AtomicReference<Future<?>> atomicReference = this.Y;
        Future future = Y2;
        Future andSet = atomicReference.getAndSet(future);
        boolean z = false;
        if (!(andSet == null || andSet == future)) {
            andSet.cancel(this.X2 != Thread.currentThread());
        }
        Future andSet2 = this.X.getAndSet(future);
        if (andSet2 != null && andSet2 != future) {
            if (this.X2 != Thread.currentThread()) {
                z = true;
            }
            andSet2.cancel(z);
        }
    }
}
