package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.ThreadFactory;

public final class NewThreadScheduler extends Scheduler {
    private static final String X2 = "rx3.newthread-priority";
    private static final String Y = "RxNewThreadScheduler";
    private static final RxThreadFactory Z = new RxThreadFactory(Y, Math.max(1, Math.min(10, Integer.getInteger(X2, 5).intValue())));
    final ThreadFactory X;

    public NewThreadScheduler() {
        this(Z);
    }

    @NonNull
    public Scheduler.Worker d() {
        return new NewThreadWorker(this.X);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.X = threadFactory;
    }
}
