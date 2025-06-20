package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class NewThreadWorker extends Scheduler.Worker implements Disposable {
    volatile boolean X;
    private final ScheduledExecutorService s;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.s = SchedulerPoolFactory.a(threadFactory);
    }

    @NonNull
    public Disposable b(@NonNull Runnable runnable) {
        return c(runnable, 0, (TimeUnit) null);
    }

    @NonNull
    public Disposable c(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
        return this.X ? EmptyDisposable.INSTANCE : e(runnable, j2, timeUnit, (DisposableContainer) null);
    }

    @NonNull
    public ScheduledRunnable e(Runnable runnable, long j2, @NonNull TimeUnit timeUnit, @Nullable DisposableContainer disposableContainer) {
        Future future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.b0(runnable), disposableContainer);
        if (disposableContainer != null && !disposableContainer.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        if (j2 <= 0) {
            try {
                future = this.s.submit(scheduledRunnable);
            } catch (RejectedExecutionException e2) {
                if (disposableContainer != null) {
                    disposableContainer.a(scheduledRunnable);
                }
                RxJavaPlugins.Y(e2);
            }
        } else {
            future = this.s.schedule(scheduledRunnable, j2, timeUnit);
        }
        scheduledRunnable.a(future);
        return scheduledRunnable;
    }

    public Disposable f(Runnable runnable, long j2, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.b0(runnable));
        if (j2 <= 0) {
            try {
                future = this.s.submit(scheduledDirectTask);
            } catch (RejectedExecutionException e2) {
                RxJavaPlugins.Y(e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.s.schedule(scheduledDirectTask, j2, timeUnit);
        }
        scheduledDirectTask.b(future);
        return scheduledDirectTask;
    }

    public boolean g() {
        return this.X;
    }

    public Disposable h(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        Future future;
        Runnable b0 = RxJavaPlugins.b0(runnable);
        if (j3 <= 0) {
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(b0, this.s);
            if (j2 <= 0) {
                try {
                    future = this.s.submit(instantPeriodicTask);
                } catch (RejectedExecutionException e2) {
                    RxJavaPlugins.Y(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.s.schedule(instantPeriodicTask, j2, timeUnit);
            }
            instantPeriodicTask.b(future);
            return instantPeriodicTask;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(b0);
        scheduledDirectPeriodicTask.b(this.s.scheduleAtFixedRate(scheduledDirectPeriodicTask, j2, j3, timeUnit));
        return scheduledDirectPeriodicTask;
    }

    public void i() {
        if (!this.X) {
            this.X = true;
            this.s.shutdown();
        }
    }

    public void m() {
        if (!this.X) {
            this.X = true;
            this.s.shutdownNow();
        }
    }
}
