package io.reactivex.rxjava3.internal.schedulers;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {
    private static final String X2 = "RxComputationThreadPool";
    static final RxThreadFactory Y2;
    static final FixedSchedulerPool Z;
    static final String Z2 = "rx3.computation-threads";
    static final int a3 = n(Runtime.getRuntime().availableProcessors(), Integer.getInteger(Z2, 0).intValue());
    static final PoolWorker b3;
    private static final String c3 = "rx3.computation-priority";
    final ThreadFactory X;
    final AtomicReference<FixedSchedulerPool> Y;

    static final class EventLoopWorker extends Scheduler.Worker {
        private final CompositeDisposable X;
        volatile boolean X2;
        private final ListCompositeDisposable Y;
        private final PoolWorker Z;
        private final ListCompositeDisposable s;

        EventLoopWorker(PoolWorker poolWorker) {
            this.Z = poolWorker;
            ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
            this.s = listCompositeDisposable;
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            this.X = compositeDisposable;
            ListCompositeDisposable listCompositeDisposable2 = new ListCompositeDisposable();
            this.Y = listCompositeDisposable2;
            listCompositeDisposable2.b(listCompositeDisposable);
            listCompositeDisposable2.b(compositeDisposable);
        }

        @NonNull
        public Disposable b(@NonNull Runnable runnable) {
            if (this.X2) {
                return EmptyDisposable.INSTANCE;
            }
            return this.Z.e(runnable, 0, TimeUnit.MILLISECONDS, this.s);
        }

        @NonNull
        public Disposable c(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
            if (this.X2) {
                return EmptyDisposable.INSTANCE;
            }
            return this.Z.e(runnable, j2, timeUnit, this.X);
        }

        public boolean g() {
            return this.X2;
        }

        public void m() {
            if (!this.X2) {
                this.X2 = true;
                this.Y.m();
            }
        }
    }

    static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {
        final PoolWorker[] X;
        long Y;
        final int s;

        FixedSchedulerPool(int i2, ThreadFactory threadFactory) {
            this.s = i2;
            this.X = new PoolWorker[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.X[i3] = new PoolWorker(threadFactory);
            }
        }

        public void a(int i2, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            int i3 = this.s;
            if (i3 == 0) {
                for (int i4 = 0; i4 < i2; i4++) {
                    workerCallback.a(i4, ComputationScheduler.b3);
                }
                return;
            }
            int i5 = ((int) this.Y) % i3;
            for (int i6 = 0; i6 < i2; i6++) {
                workerCallback.a(i6, new EventLoopWorker(this.X[i5]));
                i5++;
                if (i5 == i3) {
                    i5 = 0;
                }
            }
            this.Y = (long) i5;
        }

        public PoolWorker b() {
            int i2 = this.s;
            if (i2 == 0) {
                return ComputationScheduler.b3;
            }
            PoolWorker[] poolWorkerArr = this.X;
            long j2 = this.Y;
            this.Y = 1 + j2;
            return poolWorkerArr[(int) (j2 % ((long) i2))];
        }

        public void c() {
            for (PoolWorker m2 : this.X) {
                m2.m();
            }
        }
    }

    static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        b3 = poolWorker;
        poolWorker.m();
        RxThreadFactory rxThreadFactory = new RxThreadFactory(X2, Math.max(1, Math.min(10, Integer.getInteger(c3, 5).intValue())), true);
        Y2 = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        Z = fixedSchedulerPool;
        fixedSchedulerPool.c();
    }

    public ComputationScheduler() {
        this(Y2);
    }

    static int n(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    public void a(int i2, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.b(i2, "number > 0 required");
        this.Y.get().a(i2, workerCallback);
    }

    @NonNull
    public Scheduler.Worker d() {
        return new EventLoopWorker(this.Y.get().b());
    }

    @NonNull
    public Disposable h(@NonNull Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.Y.get().b().f(runnable, j2, timeUnit);
    }

    @NonNull
    public Disposable i(@NonNull Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        return this.Y.get().b().h(runnable, j2, j3, timeUnit);
    }

    public void j() {
        AtomicReference<FixedSchedulerPool> atomicReference = this.Y;
        FixedSchedulerPool fixedSchedulerPool = Z;
        FixedSchedulerPool andSet = atomicReference.getAndSet(fixedSchedulerPool);
        if (andSet != fixedSchedulerPool) {
            andSet.c();
        }
    }

    public void k() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(a3, this.X);
        if (!g.a(this.Y, Z, fixedSchedulerPool)) {
            fixedSchedulerPool.c();
        }
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.X = threadFactory;
        this.Y = new AtomicReference<>(Z);
        k();
    }
}
