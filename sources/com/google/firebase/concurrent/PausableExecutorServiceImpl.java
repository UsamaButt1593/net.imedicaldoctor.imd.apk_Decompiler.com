package com.google.firebase.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class PausableExecutorServiceImpl implements PausableExecutorService {
    private final PausableExecutor X;
    private final ExecutorService s;

    PausableExecutorServiceImpl(boolean z, ExecutorService executorService) {
        this.s = executorService;
        this.X = new PausableExecutorImpl(z, executorService);
    }

    public boolean A0() {
        return this.X.A0();
    }

    public void P() {
        this.X.P();
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.s.awaitTermination(j2, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.X.execute(runnable);
    }

    public void h() {
        this.X.h();
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.s.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return this.s.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.s.isShutdown();
    }

    public boolean isTerminated() {
        return this.s.isTerminated();
    }

    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public Future<?> submit(Runnable runnable) {
        return submit(new A(runnable));
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.s.invokeAll(collection, j2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.s.invokeAny(collection, j2, timeUnit);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return submit(new B(runnable, t));
    }

    public <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }
}
