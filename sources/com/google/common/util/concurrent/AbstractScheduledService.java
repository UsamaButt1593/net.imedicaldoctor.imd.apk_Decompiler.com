package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import org.apache.commons.lang3.StringUtils;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class AbstractScheduledService implements Service {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f23057b = Logger.getLogger(AbstractScheduledService.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final AbstractService f23058a = new ServiceDelegate();

    interface Cancellable {
        void cancel(boolean z);

        boolean isCancelled();
    }

    public static abstract class CustomScheduler extends Scheduler {

        private final class ReschedulableCallable implements Callable<Void> {
            private final ScheduledExecutorService X;
            @CheckForNull
            @GuardedBy("lock")
            private SupplantableFuture X2;
            private final AbstractService Y;
            private final ReentrantLock Z = new ReentrantLock();
            private final Runnable s;

            ReschedulableCallable(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.s = runnable;
                this.X = scheduledExecutorService;
                this.Y = abstractService;
            }

            @GuardedBy("lock")
            private Cancellable b(Schedule schedule) {
                SupplantableFuture supplantableFuture = this.X2;
                if (supplantableFuture == null) {
                    SupplantableFuture supplantableFuture2 = new SupplantableFuture(this.Z, d(schedule));
                    this.X2 = supplantableFuture2;
                    return supplantableFuture2;
                }
                if (!supplantableFuture.f23063b.isCancelled()) {
                    Future unused = this.X2.f23063b = d(schedule);
                }
                return this.X2;
            }

            private ScheduledFuture<Void> d(Schedule schedule) {
                return this.X.schedule(this, schedule.f23060a, schedule.f23061b);
            }

            @CheckForNull
            /* renamed from: a */
            public Void call() throws Exception {
                this.s.run();
                c();
                return null;
            }

            @CanIgnoreReturnValue
            public Cancellable c() {
                Throwable th;
                Cancellable cancellable;
                try {
                    Schedule d2 = CustomScheduler.this.d();
                    this.Z.lock();
                    try {
                        cancellable = b(d2);
                        this.Z.unlock();
                        th = null;
                    } catch (Error | RuntimeException e2) {
                        th = e2;
                        cancellable = new FutureAsCancellable(Futures.m());
                        this.Z.unlock();
                    } catch (Throwable th2) {
                        this.Z.unlock();
                        throw th2;
                    }
                    if (th != null) {
                        this.Y.u(th);
                    }
                    return cancellable;
                } catch (Throwable th3) {
                    Platform.b(th3);
                    this.Y.u(th3);
                    return new FutureAsCancellable(Futures.m());
                }
            }
        }

        protected static final class Schedule {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public final long f23060a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public final TimeUnit f23061b;

            public Schedule(long j2, TimeUnit timeUnit) {
                this.f23060a = j2;
                this.f23061b = (TimeUnit) Preconditions.E(timeUnit);
            }
        }

        private static final class SupplantableFuture implements Cancellable {

            /* renamed from: a  reason: collision with root package name */
            private final ReentrantLock f23062a;
            /* access modifiers changed from: private */
            @GuardedBy("lock")

            /* renamed from: b  reason: collision with root package name */
            public Future<Void> f23063b;

            SupplantableFuture(ReentrantLock reentrantLock, Future<Void> future) {
                this.f23062a = reentrantLock;
                this.f23063b = future;
            }

            public void cancel(boolean z) {
                this.f23062a.lock();
                try {
                    this.f23063b.cancel(z);
                } finally {
                    this.f23062a.unlock();
                }
            }

            public boolean isCancelled() {
                this.f23062a.lock();
                try {
                    return this.f23063b.isCancelled();
                } finally {
                    this.f23062a.unlock();
                }
            }
        }

        public CustomScheduler() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final Cancellable c(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            return new ReschedulableCallable(abstractService, scheduledExecutorService, runnable).c();
        }

        /* access modifiers changed from: protected */
        public abstract Schedule d() throws Exception;
    }

    private static final class FutureAsCancellable implements Cancellable {

        /* renamed from: a  reason: collision with root package name */
        private final Future<?> f23064a;

        FutureAsCancellable(Future<?> future) {
            this.f23064a = future;
        }

        public void cancel(boolean z) {
            this.f23064a.cancel(z);
        }

        public boolean isCancelled() {
            return this.f23064a.isCancelled();
        }
    }

    public static abstract class Scheduler {
        private Scheduler() {
        }

        public static Scheduler a(long j2, long j3, TimeUnit timeUnit) {
            Preconditions.E(timeUnit);
            Preconditions.p(j3 > 0, "delay must be > 0, found %s", j3);
            final long j4 = j2;
            final long j5 = j3;
            final TimeUnit timeUnit2 = timeUnit;
            return new Scheduler() {
                public Cancellable c(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return new FutureAsCancellable(scheduledExecutorService.scheduleWithFixedDelay(runnable, j4, j5, timeUnit2));
                }
            };
        }

        public static Scheduler b(long j2, long j3, TimeUnit timeUnit) {
            Preconditions.E(timeUnit);
            Preconditions.p(j3 > 0, "period must be > 0, found %s", j3);
            final long j4 = j2;
            final long j5 = j3;
            final TimeUnit timeUnit2 = timeUnit;
            return new Scheduler() {
                public Cancellable c(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return new FutureAsCancellable(scheduledExecutorService.scheduleAtFixedRate(runnable, j4, j5, timeUnit2));
                }
            };
        }

        /* access modifiers changed from: package-private */
        public abstract Cancellable c(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);
    }

    private final class ServiceDelegate extends AbstractService {
        /* access modifiers changed from: private */
        @CheckForNull
        public volatile Cancellable p;
        @CheckForNull
        private volatile ScheduledExecutorService q;
        /* access modifiers changed from: private */
        public final ReentrantLock r;
        private final Runnable s;

        class Task implements Runnable {
            Task() {
            }

            public void run() {
                ServiceDelegate.this.r.lock();
                try {
                    Cancellable D = ServiceDelegate.this.p;
                    Objects.requireNonNull(D);
                    if (D.isCancelled()) {
                        ServiceDelegate.this.r.unlock();
                        return;
                    }
                    AbstractScheduledService.this.m();
                    ServiceDelegate.this.r.unlock();
                } catch (Throwable th) {
                    ServiceDelegate.this.r.unlock();
                    throw th;
                }
            }
        }

        private ServiceDelegate() {
            this.r = new ReentrantLock();
            this.s = new Task();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String E() {
            return AbstractScheduledService.this.o() + StringUtils.SPACE + c();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void F() {
            this.r.lock();
            try {
                AbstractScheduledService.this.q();
                Objects.requireNonNull(this.q);
                this.p = AbstractScheduledService.this.n().c(AbstractScheduledService.this.f23058a, this.q, this.s);
                v();
            } catch (Throwable th) {
                this.r.unlock();
                throw th;
            }
            this.r.unlock();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void G() {
            try {
                this.r.lock();
                if (c() != Service.State.STOPPING) {
                    this.r.unlock();
                    return;
                }
                AbstractScheduledService.this.p();
                this.r.unlock();
                w();
            } catch (Throwable th) {
                Platform.b(th);
                u(th);
            }
        }

        /* access modifiers changed from: protected */
        public final void n() {
            this.q = MoreExecutors.s(AbstractScheduledService.this.l(), new C0479h(this));
            this.q.execute(new C0480i(this));
        }

        /* access modifiers changed from: protected */
        public final void o() {
            Objects.requireNonNull(this.p);
            Objects.requireNonNull(this.q);
            this.p.cancel(false);
            this.q.execute(new C0481j(this));
        }

        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    protected AbstractScheduledService() {
    }

    public final void a(Service.Listener listener, Executor executor) {
        this.f23058a.a(listener, executor);
    }

    public final void b(long j2, TimeUnit timeUnit) throws TimeoutException {
        this.f23058a.b(j2, timeUnit);
    }

    public final Service.State c() {
        return this.f23058a.c();
    }

    public final void d() {
        this.f23058a.d();
    }

    public final Throwable e() {
        return this.f23058a.e();
    }

    public final void f(long j2, TimeUnit timeUnit) throws TimeoutException {
        this.f23058a.f(j2, timeUnit);
    }

    @CanIgnoreReturnValue
    public final Service g() {
        this.f23058a.g();
        return this;
    }

    public final void h() {
        this.f23058a.h();
    }

    @CanIgnoreReturnValue
    public final Service i() {
        this.f23058a.i();
        return this;
    }

    public final boolean isRunning() {
        return this.f23058a.isRunning();
    }

    /* access modifiers changed from: protected */
    public ScheduledExecutorService l() {
        final ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return MoreExecutors.n(AbstractScheduledService.this.o(), runnable);
            }
        });
        a(new Service.Listener(this) {
            public void a(Service.State state, Throwable th) {
                newSingleThreadScheduledExecutor.shutdown();
            }

            public void e(Service.State state) {
                newSingleThreadScheduledExecutor.shutdown();
            }
        }, MoreExecutors.c());
        return newSingleThreadScheduledExecutor;
    }

    /* access modifiers changed from: protected */
    public abstract void m() throws Exception;

    /* access modifiers changed from: protected */
    public abstract Scheduler n();

    /* access modifiers changed from: protected */
    public String o() {
        return getClass().getSimpleName();
    }

    /* access modifiers changed from: protected */
    public void p() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void q() throws Exception {
    }

    public String toString() {
        return o() + " [" + c() + "]";
    }
}
