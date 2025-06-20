package io.reactivex.rxjava3.internal.schedulers;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleScheduler extends Scheduler {
    private static final String X2 = "RxSingleScheduler";
    static final RxThreadFactory Y2 = new RxThreadFactory(X2, Math.max(1, Math.min(10, Integer.getInteger(Z, 5).intValue())), true);
    private static final String Z = "rx3.single-priority";
    static final ScheduledExecutorService Z2;
    final ThreadFactory X;
    final AtomicReference<ScheduledExecutorService> Y;

    static final class ScheduledWorker extends Scheduler.Worker {
        final CompositeDisposable X = new CompositeDisposable();
        volatile boolean Y;
        final ScheduledExecutorService s;

        ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.s = scheduledExecutorService;
        }

        @NonNull
        public Disposable c(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
            Future future;
            if (this.Y) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.b0(runnable), this.X);
            this.X.b(scheduledRunnable);
            if (j2 <= 0) {
                try {
                    future = this.s.submit(scheduledRunnable);
                } catch (RejectedExecutionException e2) {
                    m();
                    RxJavaPlugins.Y(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.s.schedule(scheduledRunnable, j2, timeUnit);
            }
            scheduledRunnable.a(future);
            return scheduledRunnable;
        }

        public boolean g() {
            return this.Y;
        }

        public void m() {
            if (!this.Y) {
                this.Y = true;
                this.X.m();
            }
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        Z2 = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public SingleScheduler() {
        this(Y2);
    }

    static ScheduledExecutorService n(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.a(threadFactory);
    }

    @NonNull
    public Scheduler.Worker d() {
        return new ScheduledWorker(this.Y.get());
    }

    @NonNull
    public Disposable h(@NonNull Runnable runnable, long j2, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.b0(runnable));
        if (j2 <= 0) {
            try {
                future = this.Y.get().submit(scheduledDirectTask);
            } catch (RejectedExecutionException e2) {
                RxJavaPlugins.Y(e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.Y.get().schedule(scheduledDirectTask, j2, timeUnit);
        }
        scheduledDirectTask.b(future);
        return scheduledDirectTask;
    }

    @NonNull
    public Disposable i(@NonNull Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future future;
        Runnable b0 = RxJavaPlugins.b0(runnable);
        if (j3 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.Y.get();
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(b0, scheduledExecutorService);
            if (j2 <= 0) {
                try {
                    future = scheduledExecutorService.submit(instantPeriodicTask);
                } catch (RejectedExecutionException e2) {
                    RxJavaPlugins.Y(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(instantPeriodicTask, j2, timeUnit);
            }
            instantPeriodicTask.b(future);
            return instantPeriodicTask;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(b0);
        scheduledDirectPeriodicTask.b(this.Y.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j2, j3, timeUnit));
        return scheduledDirectPeriodicTask;
    }

    public void j() {
        AtomicReference<ScheduledExecutorService> atomicReference = this.Y;
        ScheduledExecutorService scheduledExecutorService = Z2;
        ScheduledExecutorService andSet = atomicReference.getAndSet(scheduledExecutorService);
        if (andSet != scheduledExecutorService) {
            andSet.shutdownNow();
        }
    }

    public void k() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.Y.get();
            if (scheduledExecutorService != Z2) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = n(this.X);
            }
        } while (!g.a(this.Y, scheduledExecutorService, scheduledExecutorService2));
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.Y = atomicReference;
        this.X = threadFactory;
        atomicReference.lazySet(n(threadFactory));
    }
}
