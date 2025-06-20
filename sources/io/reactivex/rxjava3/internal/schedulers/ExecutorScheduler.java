package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler extends Scheduler {
    static final Scheduler X2 = Schedulers.h();
    final boolean X;
    final boolean Y;
    @NonNull
    final Executor Z;

    final class DelayedDispose implements Runnable {
        private final DelayedRunnable s;

        DelayedDispose(DelayedRunnable delayedRunnable) {
            this.s = delayedRunnable;
        }

        public void run() {
            DelayedRunnable delayedRunnable = this.s;
            delayedRunnable.X.a(ExecutorScheduler.this.f(delayedRunnable));
        }
    }

    static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
        private static final long Y = -4101336210206799084L;
        final SequentialDisposable X = new SequentialDisposable();
        final SequentialDisposable s = new SequentialDisposable();

        DelayedRunnable(Runnable runnable) {
            super(runnable);
        }

        public Runnable a() {
            Runnable runnable = (Runnable) get();
            return runnable != null ? runnable : Functions.f28373b;
        }

        public boolean g() {
            return get() == null;
        }

        public void m() {
            if (getAndSet((Object) null) != null) {
                this.s.m();
                this.X.m();
            }
        }

        public void run() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet((Object) null);
                    SequentialDisposable sequentialDisposable = this.s;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.X.lazySet(disposableHelper);
                } catch (Throwable th) {
                    RxJavaPlugins.Y(th);
                    throw th;
                }
            }
        }
    }

    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        final boolean X;
        volatile boolean X2;
        final Executor Y;
        final AtomicInteger Y2 = new AtomicInteger();
        final MpscLinkedQueue<Runnable> Z;
        final CompositeDisposable Z2 = new CompositeDisposable();
        final boolean s;

        static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            private static final long X = -2421395018820541164L;
            final Runnable s;

            BooleanRunnable(Runnable runnable) {
                this.s = runnable;
            }

            public boolean g() {
                return get();
            }

            public void m() {
                lazySet(true);
            }

            public void run() {
                if (!get()) {
                    try {
                        this.s.run();
                        lazySet(true);
                    } catch (Throwable th) {
                        lazySet(true);
                        throw th;
                    }
                }
            }
        }

        static final class InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
            static final int X2 = 0;
            static final int Y2 = 1;
            private static final long Z = -3603436687413320876L;
            static final int Z2 = 2;
            static final int a3 = 3;
            static final int b3 = 4;
            final DisposableContainer X;
            volatile Thread Y;
            final Runnable s;

            InterruptibleRunnable(Runnable runnable, DisposableContainer disposableContainer) {
                this.s = runnable;
                this.X = disposableContainer;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableContainer disposableContainer = this.X;
                if (disposableContainer != null) {
                    disposableContainer.c(this);
                }
            }

            public boolean g() {
                return get() >= 2;
            }

            public void m() {
                while (true) {
                    int i2 = get();
                    if (i2 < 2) {
                        if (i2 == 0) {
                            if (compareAndSet(0, 4)) {
                                break;
                            }
                        } else if (compareAndSet(1, 3)) {
                            Thread thread = this.Y;
                            if (thread != null) {
                                thread.interrupt();
                                this.Y = null;
                            }
                            set(4);
                        }
                    } else {
                        return;
                    }
                }
                a();
            }

            public void run() {
                if (get() == 0) {
                    this.Y = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.s.run();
                            this.Y = null;
                            if (compareAndSet(1, 2)) {
                                a();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } catch (Throwable th) {
                            this.Y = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                a();
                            }
                            throw th;
                        }
                    } else {
                        this.Y = null;
                    }
                }
            }
        }

        final class SequentialDispose implements Runnable {
            private final Runnable X;
            private final SequentialDisposable s;

            SequentialDispose(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.s = sequentialDisposable;
                this.X = runnable;
            }

            public void run() {
                this.s.a(ExecutorWorker.this.b(this.X));
            }
        }

        public ExecutorWorker(Executor executor, boolean z, boolean z2) {
            this.Y = executor;
            this.Z = new MpscLinkedQueue<>();
            this.s = z;
            this.X = z2;
        }

        @NonNull
        public Disposable b(@NonNull Runnable runnable) {
            Disposable disposable;
            if (this.X2) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable b0 = RxJavaPlugins.b0(runnable);
            if (this.s) {
                disposable = new InterruptibleRunnable(b0, this.Z2);
                this.Z2.b(disposable);
            } else {
                disposable = new BooleanRunnable(b0);
            }
            this.Z.offer(disposable);
            if (this.Y2.getAndIncrement() == 0) {
                try {
                    this.Y.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.X2 = true;
                    this.Z.clear();
                    RxJavaPlugins.Y(e2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return disposable;
        }

        @NonNull
        public Disposable c(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
            if (j2 <= 0) {
                return b(runnable);
            }
            if (this.X2) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, RxJavaPlugins.b0(runnable)), this.Z2);
            this.Z2.b(scheduledRunnable);
            Executor executor = this.Y;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.a(((ScheduledExecutorService) executor).schedule(scheduledRunnable, j2, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.X2 = true;
                    RxJavaPlugins.Y(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.a(new DisposeOnCancel(ExecutorScheduler.X2.h(scheduledRunnable, j2, timeUnit)));
            }
            sequentialDisposable.a(scheduledRunnable);
            return sequentialDisposable2;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r1 = r3.Y2.addAndGet(-r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            if (r1 != 0) goto L_0x0003;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r3.X2 == false) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0.clear();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e() {
            /*
                r3 = this;
                io.reactivex.rxjava3.internal.queue.MpscLinkedQueue<java.lang.Runnable> r0 = r3.Z
                r1 = 1
            L_0x0003:
                boolean r2 = r3.X2
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            L_0x000b:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L_0x0025
                boolean r2 = r3.X2
                if (r2 == 0) goto L_0x001b
                r0.clear()
                return
            L_0x001b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.Y2
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L_0x0003
                return
            L_0x0025:
                r2.run()
                boolean r2 = r3.X2
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler.ExecutorWorker.e():void");
        }

        /* access modifiers changed from: package-private */
        public void f() {
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.Z;
            if (this.X2) {
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.poll().run();
            if (this.X2) {
                mpscLinkedQueue.clear();
            } else if (this.Y2.decrementAndGet() != 0) {
                this.Y.execute(this);
            }
        }

        public boolean g() {
            return this.X2;
        }

        public void m() {
            if (!this.X2) {
                this.X2 = true;
                this.Z2.m();
                if (this.Y2.getAndIncrement() == 0) {
                    this.Z.clear();
                }
            }
        }

        public void run() {
            if (this.X) {
                f();
            } else {
                e();
            }
        }
    }

    public ExecutorScheduler(@NonNull Executor executor, boolean z, boolean z2) {
        this.Z = executor;
        this.X = z;
        this.Y = z2;
    }

    @NonNull
    public Scheduler.Worker d() {
        return new ExecutorWorker(this.Z, this.X, this.Y);
    }

    @NonNull
    public Disposable f(@NonNull Runnable runnable) {
        Runnable b0 = RxJavaPlugins.b0(runnable);
        try {
            if (this.Z instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(b0);
                scheduledDirectTask.b(((ExecutorService) this.Z).submit(scheduledDirectTask));
                return scheduledDirectTask;
            } else if (this.X) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(b0, (DisposableContainer) null);
                this.Z.execute(interruptibleRunnable);
                return interruptibleRunnable;
            } else {
                ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(b0);
                this.Z.execute(booleanRunnable);
                return booleanRunnable;
            }
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.Y(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @NonNull
    public Disposable h(@NonNull Runnable runnable, long j2, TimeUnit timeUnit) {
        Runnable b0 = RxJavaPlugins.b0(runnable);
        if (this.Z instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(b0);
                scheduledDirectTask.b(((ScheduledExecutorService) this.Z).schedule(scheduledDirectTask, j2, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e2) {
                RxJavaPlugins.Y(e2);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            DelayedRunnable delayedRunnable = new DelayedRunnable(b0);
            delayedRunnable.s.a(X2.h(new DelayedDispose(delayedRunnable), j2, timeUnit));
            return delayedRunnable;
        }
    }

    @NonNull
    public Disposable i(@NonNull Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        if (!(this.Z instanceof ScheduledExecutorService)) {
            return super.i(runnable, j2, j3, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.b0(runnable));
            scheduledDirectPeriodicTask.b(((ScheduledExecutorService) this.Z).scheduleAtFixedRate(scheduledDirectPeriodicTask, j2, j3, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.Y(e2);
            return EmptyDisposable.INSTANCE;
        }
    }
}
