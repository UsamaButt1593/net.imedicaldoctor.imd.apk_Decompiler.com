package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
abstract class WrappingExecutorService implements ExecutorService {
    private final ExecutorService s;

    protected WrappingExecutorService(ExecutorService executorService) {
        this.s = (ExecutorService) Preconditions.E(executorService);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(Callable callable) {
        try {
            callable.call();
        } catch (Exception e2) {
            Platform.b(e2);
            Throwables.w(e2);
            throw new RuntimeException(e2);
        }
    }

    private <T> ImmutableList<Callable<T>> e(Collection<? extends Callable<T>> collection) {
        ImmutableList.Builder r = ImmutableList.r();
        for (Callable d2 : collection) {
            r.g(d(d2));
        }
        return r.e();
    }

    public final boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.s.awaitTermination(j2, timeUnit);
    }

    /* access modifiers changed from: protected */
    public Runnable c(Runnable runnable) {
        return new J(d(Executors.callable(runnable, (Object) null)));
    }

    /* access modifiers changed from: protected */
    public abstract <T> Callable<T> d(Callable<T> callable);

    public final void execute(Runnable runnable) {
        this.s.execute(c(runnable));
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.s.invokeAll(e(collection));
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.s.invokeAny(e(collection));
    }

    public final boolean isShutdown() {
        return this.s.isShutdown();
    }

    public final boolean isTerminated() {
        return this.s.isTerminated();
    }

    public final void shutdown() {
        this.s.shutdown();
    }

    @CanIgnoreReturnValue
    public final List<Runnable> shutdownNow() {
        return this.s.shutdownNow();
    }

    public final Future<?> submit(Runnable runnable) {
        return this.s.submit(c(runnable));
    }

    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.s.invokeAll(e(collection), j2, timeUnit);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.s.invokeAny(e(collection), j2, timeUnit);
    }

    public final <T> Future<T> submit(Runnable runnable, @ParametricNullness T t) {
        return this.s.submit(c(runnable), t);
    }

    public final <T> Future<T> submit(Callable<T> callable) {
        return this.s.submit(d((Callable) Preconditions.E(callable)));
    }
}
