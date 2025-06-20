package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ForwardingObject;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public abstract class ForwardingExecutorService extends ForwardingObject implements ExecutorService {
    protected ForwardingExecutorService() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public abstract ExecutorService Z0();

    @CheckReturnValue
    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return Z0().awaitTermination(j2, timeUnit);
    }

    public void execute(Runnable runnable) {
        Z0().execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return Z0().invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return Z0().invokeAny(collection);
    }

    public boolean isShutdown() {
        return Z0().isShutdown();
    }

    public boolean isTerminated() {
        return Z0().isTerminated();
    }

    public void shutdown() {
        Z0().shutdown();
    }

    @CanIgnoreReturnValue
    public List<Runnable> shutdownNow() {
        return Z0().shutdownNow();
    }

    public Future<?> submit(Runnable runnable) {
        return Z0().submit(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return Z0().invokeAll(collection, j2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return Z0().invokeAny(collection, j2, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, @ParametricNullness T t) {
        return Z0().submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return Z0().submit(callable);
    }
}
