package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable, SchedulerRunnableIntrospection {
    protected static final FutureTask<Void> X2;
    private static final long Y = 1811839108042568751L;
    protected static final FutureTask<Void> Z;
    protected Thread X;
    protected final Runnable s;

    static {
        Runnable runnable = Functions.f28373b;
        Z = new FutureTask<>(runnable, (Object) null);
        X2 = new FutureTask<>(runnable, (Object) null);
    }

    AbstractDirectTask(Runnable runnable) {
        this.s = runnable;
    }

    public Runnable a() {
        return this.s;
    }

    public final void b(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 != Z) {
                if (future2 == X2) {
                    future.cancel(this.X != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    public final boolean g() {
        Future future = (Future) get();
        return future == Z || future == X2;
    }

    public final void m() {
        FutureTask<Void> futureTask;
        Future future = (Future) get();
        if (future != Z && future != (futureTask = X2) && compareAndSet(future, futureTask) && future != null) {
            future.cancel(this.X != Thread.currentThread());
        }
    }
}
