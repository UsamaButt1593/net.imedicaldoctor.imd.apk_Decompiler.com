package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class ForwardingFluentFuture<V> extends FluentFuture<V> {
    private final ListenableFuture<V> b3;

    ForwardingFluentFuture(ListenableFuture<V> listenableFuture) {
        this.b3 = (ListenableFuture) Preconditions.E(listenableFuture);
    }

    public void a0(Runnable runnable, Executor executor) {
        this.b3.a0(runnable, executor);
    }

    public boolean cancel(boolean z) {
        return this.b3.cancel(z);
    }

    @ParametricNullness
    public V get() throws InterruptedException, ExecutionException {
        return this.b3.get();
    }

    public boolean isCancelled() {
        return this.b3.isCancelled();
    }

    public boolean isDone() {
        return this.b3.isDone();
    }

    public String toString() {
        return this.b3.toString();
    }

    @ParametricNullness
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.b3.get(j2, timeUnit);
    }
}
