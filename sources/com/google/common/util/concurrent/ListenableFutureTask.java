package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {
    private final ExecutionList s = new ExecutionList();

    ListenableFutureTask(Runnable runnable, @ParametricNullness V v) {
        super(runnable, v);
    }

    public static <V> ListenableFutureTask<V> a(Runnable runnable, @ParametricNullness V v) {
        return new ListenableFutureTask<>(runnable, v);
    }

    public static <V> ListenableFutureTask<V> b(Callable<V> callable) {
        return new ListenableFutureTask<>(callable);
    }

    public void a0(Runnable runnable, Executor executor) {
        this.s.a(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void done() {
        this.s.b();
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public V get(long j2, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        long nanos = timeUnit.toNanos(j2);
        return nanos <= 2147483647999999999L ? super.get(j2, timeUnit) : super.get(Math.min(nanos, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }

    ListenableFutureTask(Callable<V> callable) {
        super(callable);
    }
}
