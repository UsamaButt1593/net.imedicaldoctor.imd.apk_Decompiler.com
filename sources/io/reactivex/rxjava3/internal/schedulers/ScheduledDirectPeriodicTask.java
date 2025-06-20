package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long Y2 = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    public /* bridge */ /* synthetic */ Runnable a() {
        return super.a();
    }

    public void run() {
        this.X = Thread.currentThread();
        try {
            this.s.run();
            this.X = null;
        } catch (Throwable th) {
            this.X = null;
            m();
            RxJavaPlugins.Y(th);
            throw th;
        }
    }
}
