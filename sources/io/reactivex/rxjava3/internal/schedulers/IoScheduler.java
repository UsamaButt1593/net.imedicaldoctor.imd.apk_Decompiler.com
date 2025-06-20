package io.reactivex.rxjava3.internal.schedulers;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class IoScheduler extends Scheduler {
    static final RxThreadFactory X2;
    private static final String Y2 = "RxCachedWorkerPoolEvictor";
    private static final String Z = "RxCachedThreadScheduler";
    static final RxThreadFactory Z2;
    private static final String a3 = "rx3.io-keep-alive-time";
    public static final long b3 = 60;
    private static final long c3 = Long.getLong(a3, 60).longValue();
    private static final TimeUnit d3 = TimeUnit.SECONDS;
    static final ThreadWorker e3;
    private static final String f3 = "rx3.io-priority";
    static final CachedWorkerPool g3;
    final ThreadFactory X;
    final AtomicReference<CachedWorkerPool> Y;

    static final class CachedWorkerPool implements Runnable {
        private final ConcurrentLinkedQueue<ThreadWorker> X;
        private final Future<?> X2;
        final CompositeDisposable Y;
        private final ThreadFactory Y2;
        private final ScheduledExecutorService Z;
        private final long s;

        CachedWorkerPool(long j2, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            long nanos = timeUnit != null ? timeUnit.toNanos(j2) : 0;
            this.s = nanos;
            this.X = new ConcurrentLinkedQueue<>();
            this.Y = new CompositeDisposable();
            this.Y2 = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.Z2);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.Z = scheduledExecutorService;
            this.X2 = scheduledFuture;
        }

        static void a(ConcurrentLinkedQueue<ThreadWorker> concurrentLinkedQueue, CompositeDisposable compositeDisposable) {
            if (!concurrentLinkedQueue.isEmpty()) {
                long c2 = c();
                Iterator<ThreadWorker> it2 = concurrentLinkedQueue.iterator();
                while (it2.hasNext()) {
                    ThreadWorker next = it2.next();
                    if (next.j() > c2) {
                        return;
                    }
                    if (concurrentLinkedQueue.remove(next)) {
                        compositeDisposable.a(next);
                    }
                }
            }
        }

        static long c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: package-private */
        public ThreadWorker b() {
            if (this.Y.g()) {
                return IoScheduler.e3;
            }
            while (!this.X.isEmpty()) {
                ThreadWorker poll = this.X.poll();
                if (poll != null) {
                    return poll;
                }
            }
            ThreadWorker threadWorker = new ThreadWorker(this.Y2);
            this.Y.b(threadWorker);
            return threadWorker;
        }

        /* access modifiers changed from: package-private */
        public void d(ThreadWorker threadWorker) {
            threadWorker.k(c() + this.s);
            this.X.offer(threadWorker);
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.Y.m();
            Future<?> future = this.X2;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.Z;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        public void run() {
            a(this.X, this.Y);
        }
    }

    static final class EventLoopWorker extends Scheduler.Worker {
        private final CachedWorkerPool X;
        private final ThreadWorker Y;
        final AtomicBoolean Z = new AtomicBoolean();
        private final CompositeDisposable s;

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.X = cachedWorkerPool;
            this.s = new CompositeDisposable();
            this.Y = cachedWorkerPool.b();
        }

        @NonNull
        public Disposable c(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
            if (this.s.g()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.Y.e(runnable, j2, timeUnit, this.s);
        }

        public boolean g() {
            return this.Z.get();
        }

        public void m() {
            if (this.Z.compareAndSet(false, true)) {
                this.s.m();
                this.X.d(this.Y);
            }
        }
    }

    static final class ThreadWorker extends NewThreadWorker {
        long Y = 0;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long j() {
            return this.Y;
        }

        public void k(long j2) {
            this.Y = j2;
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        e3 = threadWorker;
        threadWorker.m();
        int max = Math.max(1, Math.min(10, Integer.getInteger(f3, 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory(Z, max);
        X2 = rxThreadFactory;
        Z2 = new RxThreadFactory(Y2, max);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0, (TimeUnit) null, rxThreadFactory);
        g3 = cachedWorkerPool;
        cachedWorkerPool.e();
    }

    public IoScheduler() {
        this(X2);
    }

    @NonNull
    public Scheduler.Worker d() {
        return new EventLoopWorker(this.Y.get());
    }

    public void j() {
        AtomicReference<CachedWorkerPool> atomicReference = this.Y;
        CachedWorkerPool cachedWorkerPool = g3;
        CachedWorkerPool andSet = atomicReference.getAndSet(cachedWorkerPool);
        if (andSet != cachedWorkerPool) {
            andSet.e();
        }
    }

    public void k() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(c3, d3, this.X);
        if (!g.a(this.Y, g3, cachedWorkerPool)) {
            cachedWorkerPool.e();
        }
    }

    public int n() {
        return this.Y.get().Y.h();
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.X = threadFactory;
        this.Y = new AtomicReference<>(g3);
        k();
    }
}
