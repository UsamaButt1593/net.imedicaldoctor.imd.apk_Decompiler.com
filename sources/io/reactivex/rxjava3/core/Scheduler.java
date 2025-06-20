package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.schedulers.NewThreadWorker;
import io.reactivex.rxjava3.internal.schedulers.SchedulerWhen;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {
    static final long s = c(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        @NonNull
        final Worker X;
        @Nullable
        Thread Y;
        @NonNull
        final Runnable s;

        DisposeTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.s = runnable;
            this.X = worker;
        }

        public Runnable a() {
            return this.s;
        }

        public boolean g() {
            return this.X.g();
        }

        public void m() {
            if (this.Y == Thread.currentThread()) {
                Worker worker = this.X;
                if (worker instanceof NewThreadWorker) {
                    ((NewThreadWorker) worker).i();
                    return;
                }
            }
            this.X.m();
        }

        public void run() {
            this.Y = Thread.currentThread();
            try {
                this.s.run();
                m();
                this.Y = null;
            } catch (Throwable th) {
                m();
                this.Y = null;
                throw th;
            }
        }
    }

    static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        @NonNull
        final Worker X;
        volatile boolean Y;
        @NonNull
        final Runnable s;

        PeriodicDirectTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.s = runnable;
            this.X = worker;
        }

        public Runnable a() {
            return this.s;
        }

        public boolean g() {
            return this.Y;
        }

        public void m() {
            this.Y = true;
            this.X.m();
        }

        public void run() {
            if (!this.Y) {
                try {
                    this.s.run();
                } catch (Throwable th) {
                    m();
                    RxJavaPlugins.Y(th);
                    throw th;
                }
            }
        }
    }

    public static abstract class Worker implements Disposable {

        final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            @NonNull
            final SequentialDisposable X;
            long X2;
            final long Y;
            long Y2;
            long Z;
            @NonNull
            final Runnable s;

            PeriodicTask(long j2, @NonNull Runnable runnable, long j3, @NonNull SequentialDisposable sequentialDisposable, long j4) {
                this.s = runnable;
                this.X = sequentialDisposable;
                this.Y = j4;
                this.X2 = j3;
                this.Y2 = j2;
            }

            public Runnable a() {
                return this.s;
            }

            public void run() {
                long j2;
                this.s.run();
                if (!this.X.g()) {
                    Worker worker = Worker.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long a2 = worker.a(timeUnit);
                    long j3 = Scheduler.s;
                    long j4 = this.X2;
                    if (a2 + j3 >= j4) {
                        long j5 = this.Y;
                        if (a2 < j4 + j5 + j3) {
                            long j6 = this.Y2;
                            long j7 = this.Z + 1;
                            this.Z = j7;
                            j2 = j6 + (j7 * j5);
                            this.X2 = a2;
                            this.X.a(Worker.this.c(this, j2 - a2, timeUnit));
                        }
                    }
                    long j8 = this.Y;
                    long j9 = a2 + j8;
                    long j10 = this.Z + 1;
                    this.Z = j10;
                    this.Y2 = j9 - (j8 * j10);
                    j2 = j9;
                    this.X2 = a2;
                    this.X.a(Worker.this.c(this, j2 - a2, timeUnit));
                }
            }
        }

        public long a(@NonNull TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @NonNull
        public Disposable b(@NonNull Runnable runnable) {
            return c(runnable, 0, TimeUnit.NANOSECONDS);
        }

        @NonNull
        public abstract Disposable c(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit);

        @NonNull
        public Disposable d(@NonNull Runnable runnable, long j2, long j3, @NonNull TimeUnit timeUnit) {
            long j4 = j2;
            TimeUnit timeUnit2 = timeUnit;
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable b0 = RxJavaPlugins.b0(runnable);
            long nanos = timeUnit2.toNanos(j3);
            long a2 = a(TimeUnit.NANOSECONDS);
            SequentialDisposable sequentialDisposable3 = sequentialDisposable;
            PeriodicTask periodicTask = r0;
            PeriodicTask periodicTask2 = new PeriodicTask(a2 + timeUnit2.toNanos(j4), b0, a2, sequentialDisposable2, nanos);
            Disposable c2 = c(periodicTask, j4, timeUnit2);
            if (c2 == EmptyDisposable.INSTANCE) {
                return c2;
            }
            sequentialDisposable3.a(c2);
            return sequentialDisposable2;
        }
    }

    public static long b() {
        return s;
    }

    static long c(long j2, String str) {
        return ("seconds".equalsIgnoreCase(str) ? TimeUnit.SECONDS : "milliseconds".equalsIgnoreCase(str) ? TimeUnit.MILLISECONDS : TimeUnit.MINUTES).toNanos(j2);
    }

    @NonNull
    public abstract Worker d();

    public long e(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @NonNull
    public Disposable f(@NonNull Runnable runnable) {
        return h(runnable, 0, TimeUnit.NANOSECONDS);
    }

    @NonNull
    public Disposable h(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
        Worker d2 = d();
        DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.b0(runnable), d2);
        d2.c(disposeTask, j2, timeUnit);
        return disposeTask;
    }

    @NonNull
    public Disposable i(@NonNull Runnable runnable, long j2, long j3, @NonNull TimeUnit timeUnit) {
        Worker d2 = d();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.b0(runnable), d2);
        Disposable d3 = d2.d(periodicDirectTask, j2, j3, timeUnit);
        return d3 == EmptyDisposable.INSTANCE ? d3 : periodicDirectTask;
    }

    public void j() {
    }

    public void k() {
    }

    @NonNull
    public <S extends Scheduler & Disposable> S l(@NonNull Function<Flowable<Flowable<Completable>>, Completable> function) {
        Objects.requireNonNull(function, "combine is null");
        return new SchedulerWhen(function, this);
    }
}
