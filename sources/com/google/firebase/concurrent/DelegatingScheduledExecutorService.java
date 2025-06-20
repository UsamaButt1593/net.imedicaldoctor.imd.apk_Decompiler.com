package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class DelegatingScheduledExecutorService implements ScheduledExecutorService {
    private final ScheduledExecutorService X;
    private final ExecutorService s;

    DelegatingScheduledExecutorService(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.s = executorService;
        this.X = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void n(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
            completer.set(null);
        } catch (Exception e2) {
            completer.a(e2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.s.execute(new h(runnable, completer));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture p(Runnable runnable, long j2, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.X.schedule(new f(this, runnable, completer), j2, timeUnit);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void q(Callable callable, DelegatingScheduledFuture.Completer completer) {
        try {
            completer.set(callable.call());
        } catch (Exception e2) {
            completer.a(e2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Future r(Callable callable, DelegatingScheduledFuture.Completer completer) throws Exception {
        return this.s.submit(new k(callable, completer));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture s(Callable callable, long j2, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.X.schedule(new l(this, callable, completer), j2, timeUnit);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void t(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
        } catch (Exception e2) {
            completer.a(e2);
            throw e2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.s.execute(new m(runnable, completer));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture v(Runnable runnable, long j2, long j3, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.X.scheduleAtFixedRate(new e(this, runnable, completer), j2, j3, timeUnit);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.s.execute(new c(runnable, completer));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture x(Runnable runnable, long j2, long j3, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.X.scheduleWithFixedDelay(new d(this, runnable, completer), j2, j3, timeUnit);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void y(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
        } catch (Exception e2) {
            completer.a(e2);
        }
    }

    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.s.awaitTermination(j2, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.s.execute(runnable);
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

    public ScheduledFuture<?> schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new C0484b(this, runnable, j2, timeUnit));
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new g(this, runnable, j2, j3, timeUnit));
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new i(this, runnable, j2, j3, timeUnit));
    }

    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public Future<?> submit(Runnable runnable) {
        return this.s.submit(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.s.invokeAll(collection, j2, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.s.invokeAny(collection, j2, timeUnit);
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j2, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new j(this, callable, j2, timeUnit));
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.s.submit(runnable, t);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.s.submit(callable);
    }
}
