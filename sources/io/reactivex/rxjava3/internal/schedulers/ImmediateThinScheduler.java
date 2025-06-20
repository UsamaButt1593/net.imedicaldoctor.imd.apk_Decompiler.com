package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.TimeUnit;

public final class ImmediateThinScheduler extends Scheduler {
    public static final Scheduler X = new ImmediateThinScheduler();
    static final Scheduler.Worker Y = new ImmediateThinWorker();
    static final Disposable Z;

    static final class ImmediateThinWorker extends Scheduler.Worker {
        ImmediateThinWorker() {
        }

        @NonNull
        public Disposable b(@NonNull Runnable runnable) {
            runnable.run();
            return ImmediateThinScheduler.Z;
        }

        @NonNull
        public Disposable c(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @NonNull
        public Disposable d(@NonNull Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }

        public boolean g() {
            return false;
        }

        public void m() {
        }
    }

    static {
        Disposable b2 = b.b();
        Z = b2;
        b2.m();
    }

    private ImmediateThinScheduler() {
    }

    @NonNull
    public Scheduler.Worker d() {
        return Y;
    }

    @NonNull
    public Disposable f(@NonNull Runnable runnable) {
        runnable.run();
        return Z;
    }

    @NonNull
    public Disposable h(@NonNull Runnable runnable, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @NonNull
    public Disposable i(@NonNull Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }
}
