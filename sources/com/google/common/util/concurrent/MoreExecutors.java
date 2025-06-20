package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class MoreExecutors {

    @GwtIncompatible
    @VisibleForTesting
    @J2ktIncompatible
    static class Application {
        Application() {
        }

        /* access modifiers changed from: package-private */
        public final void a(ExecutorService executorService, long j2, TimeUnit timeUnit) {
            Preconditions.E(executorService);
            Preconditions.E(timeUnit);
            final ExecutorService executorService2 = executorService;
            final long j3 = j2;
            final TimeUnit timeUnit2 = timeUnit;
            b(MoreExecutors.n("DelayedShutdownHook-for-" + executorService, new Runnable(this) {
                public void run() {
                    try {
                        executorService2.shutdown();
                        executorService2.awaitTermination(j3, timeUnit2);
                    } catch (InterruptedException unused) {
                    }
                }
            }));
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public void b(Thread thread) {
            Runtime.getRuntime().addShutdownHook(thread);
        }

        /* access modifiers changed from: package-private */
        public final ExecutorService c(ThreadPoolExecutor threadPoolExecutor) {
            return d(threadPoolExecutor, 120, TimeUnit.SECONDS);
        }

        /* access modifiers changed from: package-private */
        public final ExecutorService d(ThreadPoolExecutor threadPoolExecutor, long j2, TimeUnit timeUnit) {
            MoreExecutors.v(threadPoolExecutor);
            ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
            a(threadPoolExecutor, j2, timeUnit);
            return unconfigurableExecutorService;
        }

        /* access modifiers changed from: package-private */
        public final ScheduledExecutorService e(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            return f(scheduledThreadPoolExecutor, 120, TimeUnit.SECONDS);
        }

        /* access modifiers changed from: package-private */
        public final ScheduledExecutorService f(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j2, TimeUnit timeUnit) {
            MoreExecutors.v(scheduledThreadPoolExecutor);
            ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
            a(scheduledThreadPoolExecutor, j2, timeUnit);
            return unconfigurableScheduledExecutorService;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static final class DirectExecutorService extends AbstractListeningExecutorService {
        @GuardedBy("lock")
        private int X;
        @GuardedBy("lock")
        private boolean Y;
        private final Object s;

        private DirectExecutorService() {
            this.s = new Object();
            this.X = 0;
            this.Y = false;
        }

        private void a() {
            synchronized (this.s) {
                try {
                    int i2 = this.X - 1;
                    this.X = i2;
                    if (i2 == 0) {
                        this.s.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private void b() {
            synchronized (this.s) {
                try {
                    if (!this.Y) {
                        this.X++;
                    } else {
                        throw new RejectedExecutionException("Executor already shutdown");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
            long nanos = timeUnit.toNanos(j2);
            synchronized (this.s) {
                while (true) {
                    try {
                        if (this.Y && this.X == 0) {
                            return true;
                        }
                        if (nanos <= 0) {
                            return false;
                        }
                        long nanoTime = System.nanoTime();
                        TimeUnit.NANOSECONDS.timedWait(this.s, nanos);
                        nanos -= System.nanoTime() - nanoTime;
                    } finally {
                    }
                }
            }
        }

        public void execute(Runnable runnable) {
            b();
            try {
                runnable.run();
            } finally {
                a();
            }
        }

        public boolean isShutdown() {
            boolean z;
            synchronized (this.s) {
                z = this.Y;
            }
            return z;
        }

        public boolean isTerminated() {
            boolean z;
            synchronized (this.s) {
                try {
                    z = this.Y && this.X == 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z;
        }

        public void shutdown() {
            synchronized (this.s) {
                try {
                    this.Y = true;
                    if (this.X == 0) {
                        this.s.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static class ListeningDecorator extends AbstractListeningExecutorService {
        private final ExecutorService s;

        ListeningDecorator(ExecutorService executorService) {
            this.s = (ExecutorService) Preconditions.E(executorService);
        }

        public final boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
            return this.s.awaitTermination(j2, timeUnit);
        }

        public final void execute(Runnable runnable) {
            this.s.execute(runnable);
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

        public final List<Runnable> shutdownNow() {
            return this.s.shutdownNow();
        }

        public final String toString() {
            return super.toString() + "[" + this.s + "]";
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
        final ScheduledExecutorService X;

        private static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
            private final ScheduledFuture<?> X;

            public ListenableScheduledTask(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                this.X = scheduledFuture;
            }

            public boolean cancel(boolean z) {
                boolean cancel = super.cancel(z);
                if (cancel) {
                    this.X.cancel(z);
                }
                return cancel;
            }

            public long getDelay(TimeUnit timeUnit) {
                return this.X.getDelay(timeUnit);
            }

            /* renamed from: i1 */
            public int compareTo(Delayed delayed) {
                return this.X.compareTo(delayed);
            }
        }

        @GwtIncompatible
        @J2ktIncompatible
        private static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
            private final Runnable b3;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                this.b3 = (Runnable) Preconditions.E(runnable);
            }

            public void run() {
                try {
                    this.b3.run();
                } catch (Error | RuntimeException e2) {
                    C(e2);
                    throw e2;
                }
            }

            /* access modifiers changed from: protected */
            public String y() {
                return "task=[" + this.b3 + "]";
            }
        }

        ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.X = (ScheduledExecutorService) Preconditions.E(scheduledExecutorService);
        }

        public ListenableScheduledFuture<?> schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
            TrustedListenableFutureTask O = TrustedListenableFutureTask.O(runnable, null);
            return new ListenableScheduledTask(O, this.X.schedule(O, j2, timeUnit));
        }

        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.X.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j2, j3, timeUnit));
        }

        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.X.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j2, j3, timeUnit));
        }

        public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j2, TimeUnit timeUnit) {
            TrustedListenableFutureTask<V> P = TrustedListenableFutureTask.P(callable);
            return new ListenableScheduledTask(P, this.X.schedule(P, j2, timeUnit));
        }
    }

    private MoreExecutors() {
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static void b(ExecutorService executorService, long j2, TimeUnit timeUnit) {
        new Application().a(executorService, j2, timeUnit);
    }

    public static Executor c() {
        return DirectExecutor.INSTANCE;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static ExecutorService d(ThreadPoolExecutor threadPoolExecutor) {
        return new Application().c(threadPoolExecutor);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static ExecutorService e(ThreadPoolExecutor threadPoolExecutor, long j2, TimeUnit timeUnit) {
        return new Application().d(threadPoolExecutor, j2, timeUnit);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static ScheduledExecutorService f(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new Application().e(scheduledThreadPoolExecutor);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static ScheduledExecutorService g(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j2, TimeUnit timeUnit) {
        return new Application().f(scheduledThreadPoolExecutor, j2, timeUnit);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b8 A[SYNTHETIC] */
    @com.google.common.annotations.GwtIncompatible
    @com.google.common.util.concurrent.ParametricNullness
    @com.google.common.annotations.J2ktIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> T h(com.google.common.util.concurrent.ListeningExecutorService r16, java.util.Collection<? extends java.util.concurrent.Callable<T>> r17, boolean r18, long r19, java.util.concurrent.TimeUnit r21) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            r1 = r16
            com.google.common.base.Preconditions.E(r16)
            com.google.common.base.Preconditions.E(r21)
            int r0 = r17.size()
            r2 = 1
            if (r0 <= 0) goto L_0x0011
            r3 = 1
            goto L_0x0012
        L_0x0011:
            r3 = 0
        L_0x0012:
            com.google.common.base.Preconditions.d(r3)
            java.util.ArrayList r3 = com.google.common.collect.Lists.u(r0)
            java.util.concurrent.LinkedBlockingQueue r4 = com.google.common.collect.Queues.k()
            r5 = r19
            r7 = r21
            long r5 = r7.toNanos(r5)
            if (r18 == 0) goto L_0x002f
            long r7 = java.lang.System.nanoTime()     // Catch:{ all -> 0x002c }
            goto L_0x0031
        L_0x002c:
            r0 = move-exception
            goto L_0x00bc
        L_0x002f:
            r7 = 0
        L_0x0031:
            java.util.Iterator r9 = r17.iterator()     // Catch:{ all -> 0x002c }
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x002c }
            java.util.concurrent.Callable r10 = (java.util.concurrent.Callable) r10     // Catch:{ all -> 0x002c }
            com.google.common.util.concurrent.ListenableFuture r10 = u(r1, r10, r4)     // Catch:{ all -> 0x002c }
            r3.add(r10)     // Catch:{ all -> 0x002c }
            int r0 = r0 + -1
            r10 = 0
            r12 = r10
            r11 = 1
        L_0x0047:
            java.lang.Object r13 = r4.poll()     // Catch:{ all -> 0x002c }
            java.util.concurrent.Future r13 = (java.util.concurrent.Future) r13     // Catch:{ all -> 0x002c }
            if (r13 != 0) goto L_0x0062
            if (r0 <= 0) goto L_0x0066
            int r0 = r0 + -1
            java.lang.Object r14 = r9.next()     // Catch:{ all -> 0x002c }
            java.util.concurrent.Callable r14 = (java.util.concurrent.Callable) r14     // Catch:{ all -> 0x002c }
            com.google.common.util.concurrent.ListenableFuture r14 = u(r1, r14, r4)     // Catch:{ all -> 0x002c }
            r3.add(r14)     // Catch:{ all -> 0x002c }
            int r11 = r11 + 1
        L_0x0062:
            r14 = r7
        L_0x0063:
            r6 = r5
            r5 = r0
            goto L_0x0091
        L_0x0066:
            if (r11 != 0) goto L_0x0070
            if (r12 != 0) goto L_0x006f
            java.util.concurrent.ExecutionException r12 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x002c }
            r12.<init>(r10)     // Catch:{ all -> 0x002c }
        L_0x006f:
            throw r12     // Catch:{ all -> 0x002c }
        L_0x0070:
            if (r18 == 0) goto L_0x008a
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x002c }
            java.lang.Object r13 = r4.poll(r5, r13)     // Catch:{ all -> 0x002c }
            java.util.concurrent.Future r13 = (java.util.concurrent.Future) r13     // Catch:{ all -> 0x002c }
            if (r13 == 0) goto L_0x0084
            long r14 = java.lang.System.nanoTime()     // Catch:{ all -> 0x002c }
            long r7 = r14 - r7
            long r5 = r5 - r7
            goto L_0x0063
        L_0x0084:
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x002c }
            r0.<init>()     // Catch:{ all -> 0x002c }
            throw r0     // Catch:{ all -> 0x002c }
        L_0x008a:
            java.lang.Object r13 = r4.take()     // Catch:{ all -> 0x002c }
            java.util.concurrent.Future r13 = (java.util.concurrent.Future) r13     // Catch:{ all -> 0x002c }
            goto L_0x0062
        L_0x0091:
            if (r13 == 0) goto L_0x00b8
            int r11 = r11 + -1
            java.lang.Object r0 = r13.get()     // Catch:{ ExecutionException -> 0x00b6, RuntimeException -> 0x00ae }
            java.util.Iterator r1 = r3.iterator()
        L_0x009d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00ad
            java.lang.Object r3 = r1.next()
            java.util.concurrent.Future r3 = (java.util.concurrent.Future) r3
            r3.cancel(r2)
            goto L_0x009d
        L_0x00ad:
            return r0
        L_0x00ae:
            r0 = move-exception
            r8 = r0
            java.util.concurrent.ExecutionException r12 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x002c }
            r12.<init>(r8)     // Catch:{ all -> 0x002c }
            goto L_0x00b8
        L_0x00b6:
            r0 = move-exception
            r12 = r0
        L_0x00b8:
            r0 = r5
            r5 = r6
            r7 = r14
            goto L_0x0047
        L_0x00bc:
            java.util.Iterator r1 = r3.iterator()
        L_0x00c0:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00d0
            java.lang.Object r3 = r1.next()
            java.util.concurrent.Future r3 = (java.util.concurrent.Future) r3
            r3.cancel(r2)
            goto L_0x00c0
        L_0x00d0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.MoreExecutors.h(com.google.common.util.concurrent.ListeningExecutorService, java.util.Collection, boolean, long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return false;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:11:? A[ExcHandler: ClassNotFoundException (unused java.lang.ClassNotFoundException), SYNTHETIC, Splitter:B:7:0x0011] */
    @com.google.common.annotations.GwtIncompatible
    @com.google.common.annotations.J2ktIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean i() {
        /*
            java.lang.String r0 = "com.google.appengine.runtime.environment"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.String r0 = "com.google.appengine.api.utils.SystemProperty"
            java.lang.Class.forName(r0)     // Catch:{  }
            java.lang.String r0 = "com.google.apphosting.api.ApiProxy"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023 }
            java.lang.String r2 = "getCurrentEnvironment"
            r3 = 0
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch:{ ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023 }
            java.lang.Object r0 = r0.invoke(r3, r3)     // Catch:{ ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023, ClassNotFoundException -> 0x0023 }
            if (r0 == 0) goto L_0x0023
            r1 = 1
        L_0x0023:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.MoreExecutors.i():boolean");
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static ListeningExecutorService j(ExecutorService executorService) {
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new ListeningDecorator(executorService);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static ListeningScheduledExecutorService k(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof ListeningScheduledExecutorService ? (ListeningScheduledExecutorService) scheduledExecutorService : new ScheduledListeningDecorator(scheduledExecutorService);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static ListeningExecutorService l() {
        return new DirectExecutorService();
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static Executor m(Executor executor) {
        return new SequentialExecutor(executor);
    }

    @GwtIncompatible
    @J2ktIncompatible
    static Thread n(String str, Runnable runnable) {
        Preconditions.E(str);
        Preconditions.E(runnable);
        Thread newThread = o().newThread(runnable);
        Objects.requireNonNull(newThread);
        try {
            newThread.setName(str);
        } catch (SecurityException unused) {
        }
        return newThread;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static ThreadFactory o() {
        if (!i()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e2);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e4);
        } catch (InvocationTargetException e5) {
            throw Throwables.q(e5.getCause());
        }
    }

    static Executor p(final Executor executor, final AbstractFuture<?> abstractFuture) {
        Preconditions.E(executor);
        Preconditions.E(abstractFuture);
        return executor == c() ? executor : new Executor() {
            public void execute(Runnable runnable) {
                try {
                    executor.execute(runnable);
                } catch (RejectedExecutionException e2) {
                    abstractFuture.C(e2);
                }
            }
        };
    }

    @GwtIncompatible
    @J2ktIncompatible
    static Executor q(final Executor executor, final Supplier<String> supplier) {
        Preconditions.E(executor);
        Preconditions.E(supplier);
        return new Executor() {
            public void execute(Runnable runnable) {
                executor.execute(Callables.k(runnable, supplier));
            }
        };
    }

    @GwtIncompatible
    @J2ktIncompatible
    static ExecutorService r(ExecutorService executorService, final Supplier<String> supplier) {
        Preconditions.E(executorService);
        Preconditions.E(supplier);
        return new WrappingExecutorService(executorService) {
            /* access modifiers changed from: protected */
            public Runnable c(Runnable runnable) {
                return Callables.k(runnable, supplier);
            }

            /* access modifiers changed from: protected */
            public <T> Callable<T> d(Callable<T> callable) {
                return Callables.l(callable, supplier);
            }
        };
    }

    @GwtIncompatible
    @J2ktIncompatible
    static ScheduledExecutorService s(ScheduledExecutorService scheduledExecutorService, final Supplier<String> supplier) {
        Preconditions.E(scheduledExecutorService);
        Preconditions.E(supplier);
        return new WrappingScheduledExecutorService(scheduledExecutorService) {
            /* access modifiers changed from: protected */
            public Runnable c(Runnable runnable) {
                return Callables.k(runnable, supplier);
            }

            /* access modifiers changed from: protected */
            public <T> Callable<T> d(Callable<T> callable) {
                return Callables.l(callable, supplier);
            }
        };
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @J2ktIncompatible
    public static boolean t(ExecutorService executorService, long j2, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j2) / 2;
        executorService.shutdown();
        try {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (!executorService.awaitTermination(nanos, timeUnit2)) {
                executorService.shutdownNow();
                executorService.awaitTermination(nanos, timeUnit2);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static <T> ListenableFuture<T> u(ListeningExecutorService listeningExecutorService, Callable<T> callable, final BlockingQueue<Future<T>> blockingQueue) {
        final ListenableFuture<T> submit = listeningExecutorService.submit(callable);
        submit.a0(new Runnable() {
            public void run() {
                blockingQueue.add(submit);
            }
        }, c());
        return submit;
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    @J2ktIncompatible
    public static void v(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().e(true).h(threadPoolExecutor.getThreadFactory()).b());
    }
}
