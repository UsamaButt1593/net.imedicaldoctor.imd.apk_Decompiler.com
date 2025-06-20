package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
abstract class WrappingScheduledExecutorService extends WrappingExecutorService implements ScheduledExecutorService {
    final ScheduledExecutorService X;

    protected WrappingScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.X = scheduledExecutorService;
    }

    public final ScheduledFuture<?> schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.X.schedule(c(runnable), j2, timeUnit);
    }

    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.X.scheduleAtFixedRate(c(runnable), j2, j3, timeUnit);
    }

    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.X.scheduleWithFixedDelay(c(runnable), j2, j3, timeUnit);
    }

    public final <V> ScheduledFuture<V> schedule(Callable<V> callable, long j2, TimeUnit timeUnit) {
        return this.X.schedule(d(callable), j2, timeUnit);
    }
}
