package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long Y2 = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    public /* bridge */ /* synthetic */ Runnable a() {
        return super.a();
    }

    /* renamed from: c */
    public Void call() {
        this.X = Thread.currentThread();
        try {
            this.s.run();
            lazySet(AbstractDirectTask.Z);
            this.X = null;
            return null;
        } catch (Throwable th) {
            RxJavaPlugins.Y(th);
            throw th;
        }
    }
}
