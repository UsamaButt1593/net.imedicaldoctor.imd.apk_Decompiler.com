package com.google.common.util.concurrent;

import androidx.concurrent.futures.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import org.apache.commons.lang3.StringUtils;
import sun.misc.Unsafe;

@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
@ElementTypesAreNonnullByDefault
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {
    private static final Logger X2;
    private static final long Y2 = 1000;
    static final boolean Z;
    /* access modifiers changed from: private */
    public static final AtomicHelper Z2;
    private static final Object a3 = new Object();
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Listener X;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Waiter Y;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Object s;

    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2);

        /* access modifiers changed from: package-private */
        public abstract boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean c(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2);

        /* access modifiers changed from: package-private */
        public abstract Listener d(AbstractFuture<?> abstractFuture, Listener listener);

        /* access modifiers changed from: package-private */
        public abstract Waiter e(AbstractFuture<?> abstractFuture, Waiter waiter);

        /* access modifiers changed from: package-private */
        public abstract void f(Waiter waiter, @CheckForNull Waiter waiter2);

        /* access modifiers changed from: package-private */
        public abstract void g(Waiter waiter, Thread thread);
    }

    private static final class Cancellation {
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        static final Cancellation f23031c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        static final Cancellation f23032d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f23033a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        final Throwable f23034b;

        static {
            if (AbstractFuture.Z) {
                f23032d = null;
                f23031c = null;
                return;
            }
            f23032d = new Cancellation(false, (Throwable) null);
            f23031c = new Cancellation(true, (Throwable) null);
        }

        Cancellation(boolean z, @CheckForNull Throwable th) {
            this.f23033a = z;
            this.f23034b = th;
        }
    }

    private static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        static final Failure f23035b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        final Throwable f23036a;

        Failure(Throwable th) {
            this.f23036a = (Throwable) Preconditions.E(th);
        }
    }

    private static final class Listener {

        /* renamed from: d  reason: collision with root package name */
        static final Listener f23037d = new Listener();
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        final Runnable f23038a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        final Executor f23039b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Listener f23040c;

        Listener() {
            this.f23038a = null;
            this.f23039b = null;
        }

        Listener(Runnable runnable, Executor executor) {
            this.f23038a = runnable;
            this.f23039b = executor;
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Thread> f23041a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Waiter> f23042b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> f23043c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> f23044d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f23045e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f23041a = atomicReferenceFieldUpdater;
            this.f23042b = atomicReferenceFieldUpdater2;
            this.f23043c = atomicReferenceFieldUpdater3;
            this.f23044d = atomicReferenceFieldUpdater4;
            this.f23045e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2) {
            return a.a(this.f23044d, abstractFuture, listener, listener2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            return a.a(this.f23045e, abstractFuture, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2) {
            return a.a(this.f23043c, abstractFuture, waiter, waiter2);
        }

        /* access modifiers changed from: package-private */
        public Listener d(AbstractFuture<?> abstractFuture, Listener listener) {
            return this.f23044d.getAndSet(abstractFuture, listener);
        }

        /* access modifiers changed from: package-private */
        public Waiter e(AbstractFuture<?> abstractFuture, Waiter waiter) {
            return this.f23043c.getAndSet(abstractFuture, waiter);
        }

        /* access modifiers changed from: package-private */
        public void f(Waiter waiter, @CheckForNull Waiter waiter2) {
            this.f23042b.lazySet(waiter, waiter2);
        }

        /* access modifiers changed from: package-private */
        public void g(Waiter waiter, Thread thread) {
            this.f23041a.lazySet(waiter, thread);
        }
    }

    private static final class SetFuture<V> implements Runnable {
        final ListenableFuture<? extends V> X;
        final AbstractFuture<V> s;

        SetFuture(AbstractFuture<V> abstractFuture, ListenableFuture<? extends V> listenableFuture) {
            this.s = abstractFuture;
            this.X = listenableFuture;
        }

        public void run() {
            if (this.s.s == this) {
                if (AbstractFuture.Z2.b(this.s, this, AbstractFuture.u(this.X))) {
                    AbstractFuture.r(this.s, false);
                }
            }
        }
    }

    private static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.X != listener) {
                        return false;
                    }
                    Listener unused = abstractFuture.X = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.s != obj) {
                        return false;
                    }
                    Object unused = abstractFuture.s = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.Y != waiter) {
                        return false;
                    }
                    Waiter unused = abstractFuture.Y = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public Listener d(AbstractFuture<?> abstractFuture, Listener listener) {
            Listener g2;
            synchronized (abstractFuture) {
                try {
                    g2 = abstractFuture.X;
                    if (g2 != listener) {
                        Listener unused = abstractFuture.X = listener;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return g2;
        }

        /* access modifiers changed from: package-private */
        public Waiter e(AbstractFuture<?> abstractFuture, Waiter waiter) {
            Waiter i2;
            synchronized (abstractFuture) {
                try {
                    i2 = abstractFuture.Y;
                    if (i2 != waiter) {
                        Waiter unused = abstractFuture.Y = waiter;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public void f(Waiter waiter, @CheckForNull Waiter waiter2) {
            waiter.f23054b = waiter2;
        }

        /* access modifiers changed from: package-private */
        public void g(Waiter waiter, Thread thread) {
            waiter.f23053a = thread;
        }
    }

    interface Trusted<V> extends ListenableFuture<V> {
    }

    static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        TrustedFuture() {
        }

        public void a0(Runnable runnable, Executor executor) {
            AbstractFuture.super.a0(runnable, executor);
        }

        @CanIgnoreReturnValue
        public boolean cancel(boolean z) {
            return AbstractFuture.super.cancel(z);
        }

        @CanIgnoreReturnValue
        @ParametricNullness
        public V get() throws InterruptedException, ExecutionException {
            return AbstractFuture.super.get();
        }

        public boolean isCancelled() {
            return AbstractFuture.super.isCancelled();
        }

        public final boolean isDone() {
            return AbstractFuture.super.isDone();
        }

        @CanIgnoreReturnValue
        @ParametricNullness
        public final V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return AbstractFuture.super.get(j2, timeUnit);
        }
    }

    private static final class UnsafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        static final Unsafe f23046a;

        /* renamed from: b  reason: collision with root package name */
        static final long f23047b;

        /* renamed from: c  reason: collision with root package name */
        static final long f23048c;

        /* renamed from: d  reason: collision with root package name */
        static final long f23049d;

        /* renamed from: e  reason: collision with root package name */
        static final long f23050e;

        /* renamed from: f  reason: collision with root package name */
        static final long f23051f;

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x005e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x006a, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.AnonymousClass1());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.common.util.concurrent.AbstractFuture$Waiter> r0 = com.google.common.util.concurrent.AbstractFuture.Waiter.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1 r1 = new com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1     // Catch:{ PrivilegedActionException -> 0x005e }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005e }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005e }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005e }
            L_0x0012:
                java.lang.Class<com.google.common.util.concurrent.AbstractFuture> r2 = com.google.common.util.concurrent.AbstractFuture.class
                java.lang.String r3 = "Y"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                f23048c = r3     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r3 = "X"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                f23047b = r3     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r3 = "s"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                f23049d = r2     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r2 = "a"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                f23050e = r2     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r2 = "b"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                f23051f = r2     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                f23046a = r1     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                goto L_0x0057
            L_0x0055:
                r0 = move-exception
                goto L_0x0058
            L_0x0057:
                throw r0
            L_0x0058:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005e:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.String r2 = "Could not initialize intrinsics"
                java.lang.Throwable r0 = r0.getCause()
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.<clinit>():void");
        }

        private UnsafeAtomicHelper() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractFuture<?> abstractFuture, @CheckForNull Listener listener, Listener listener2) {
            return C0475d.a(f23046a, abstractFuture, f23047b, listener, listener2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractFuture<?> abstractFuture, @CheckForNull Object obj, Object obj2) {
            return C0475d.a(f23046a, abstractFuture, f23049d, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractFuture<?> abstractFuture, @CheckForNull Waiter waiter, @CheckForNull Waiter waiter2) {
            return C0475d.a(f23046a, abstractFuture, f23048c, waiter, waiter2);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        com.google.common.util.concurrent.AbstractFuture.Listener d(com.google.common.util.concurrent.AbstractFuture<?> r3, com.google.common.util.concurrent.AbstractFuture.Listener r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.common.util.concurrent.AbstractFuture$Listener r0 = r3.X
                if (r4 != r0) goto L_0x0007
                return r0
            L_0x0007:
                boolean r1 = r2.a(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.d(com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.AbstractFuture$Listener):com.google.common.util.concurrent.AbstractFuture$Listener");
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        com.google.common.util.concurrent.AbstractFuture.Waiter e(com.google.common.util.concurrent.AbstractFuture<?> r3, com.google.common.util.concurrent.AbstractFuture.Waiter r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.common.util.concurrent.AbstractFuture$Waiter r0 = r3.Y
                if (r4 != r0) goto L_0x0007
                return r0
            L_0x0007:
                boolean r1 = r2.c(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.e(com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.AbstractFuture$Waiter):com.google.common.util.concurrent.AbstractFuture$Waiter");
        }

        /* access modifiers changed from: package-private */
        public void f(Waiter waiter, @CheckForNull Waiter waiter2) {
            f23046a.putObject(waiter, f23051f, waiter2);
        }

        /* access modifiers changed from: package-private */
        public void g(Waiter waiter, Thread thread) {
            f23046a.putObject(waiter, f23050e, thread);
        }
    }

    private static final class Waiter {

        /* renamed from: c  reason: collision with root package name */
        static final Waiter f23052c = new Waiter(false);
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f23053a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        volatile Waiter f23054b;

        Waiter() {
            AbstractFuture.Z2.g(this, Thread.currentThread());
        }

        /* access modifiers changed from: package-private */
        public void a(@CheckForNull Waiter waiter) {
            AbstractFuture.Z2.f(this, waiter);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Thread thread = this.f23053a;
            if (thread != null) {
                this.f23053a = null;
                LockSupport.unpark(thread);
            }
        }

        Waiter(boolean z) {
        }
    }

    static {
        boolean z;
        AtomicHelper atomicHelper;
        Class<Waiter> cls = Waiter.class;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        Z = z;
        Class<AbstractFuture> cls2 = AbstractFuture.class;
        X2 = Logger.getLogger(cls2.getName());
        Throwable th = null;
        try {
            atomicHelper = new UnsafeAtomicHelper();
            e = null;
        } catch (Error | RuntimeException e2) {
            e = e2;
            try {
                atomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(cls, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(cls, cls, "b"), AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "Y"), AtomicReferenceFieldUpdater.newUpdater(cls2, Listener.class, "X"), AtomicReferenceFieldUpdater.newUpdater(cls2, Object.class, "s"));
            } catch (Error | RuntimeException e3) {
                atomicHelper = new SynchronizedHelper();
                th = e3;
            }
        }
        Z2 = atomicHelper;
        if (th != null) {
            Logger logger = X2;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", e);
            logger.log(level, "SafeAtomicHelper is broken!", th);
        }
    }

    protected AbstractFuture() {
    }

    private void A(Waiter waiter) {
        waiter.f23053a = null;
        while (true) {
            Waiter waiter2 = this.Y;
            if (waiter2 != Waiter.f23052c) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.f23054b;
                    if (waiter2.f23053a != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.f23054b = waiter4;
                        if (waiter3.f23053a == null) {
                        }
                    } else if (!Z2.c(this, waiter2, waiter4)) {
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    private void k(StringBuilder sb) {
        String str = "]";
        try {
            Object v = v(this);
            sb.append("SUCCESS, result=[");
            n(sb, v);
            sb.append(str);
            return;
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
        } catch (CancellationException unused) {
            str = "CANCELLED";
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            str = " thrown from get()]";
        }
        sb.append(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l(java.lang.StringBuilder r6) {
        /*
            r5 = this;
            int r0 = r6.length()
            java.lang.String r1 = "PENDING"
            r6.append(r1)
            java.lang.Object r1 = r5.s
            boolean r2 = r1 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            java.lang.String r3 = "]"
            if (r2 == 0) goto L_0x0021
            java.lang.String r2 = ", setFuture=["
            r6.append(r2)
            com.google.common.util.concurrent.AbstractFuture$SetFuture r1 = (com.google.common.util.concurrent.AbstractFuture.SetFuture) r1
            com.google.common.util.concurrent.ListenableFuture<? extends V> r1 = r1.X
            r5.o(r6, r1)
        L_0x001d:
            r6.append(r3)
            goto L_0x004d
        L_0x0021:
            java.lang.String r1 = r5.y()     // Catch:{ RuntimeException -> 0x002c, StackOverflowError -> 0x002a }
            java.lang.String r1 = com.google.common.base.Strings.c(r1)     // Catch:{ RuntimeException -> 0x002c, StackOverflowError -> 0x002a }
            goto L_0x0042
        L_0x002a:
            r1 = move-exception
            goto L_0x002d
        L_0x002c:
            r1 = move-exception
        L_0x002d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Exception thrown from implementation: "
            r2.append(r4)
            java.lang.Class r1 = r1.getClass()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
        L_0x0042:
            if (r1 == 0) goto L_0x004d
            java.lang.String r2 = ", info=["
            r6.append(r2)
            r6.append(r1)
            goto L_0x001d
        L_0x004d:
            boolean r1 = r5.isDone()
            if (r1 == 0) goto L_0x005d
            int r1 = r6.length()
            r6.delete(r0, r1)
            r5.k(r6)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.l(java.lang.StringBuilder):void");
    }

    private void n(StringBuilder sb, @CheckForNull Object obj) {
        String hexString;
        if (obj == null) {
            hexString = "null";
        } else if (obj == this) {
            hexString = "this future";
        } else {
            sb.append(obj.getClass().getName());
            sb.append("@");
            hexString = Integer.toHexString(System.identityHashCode(obj));
        }
        sb.append(hexString);
    }

    private void o(StringBuilder sb, @CheckForNull Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException e2) {
                e = e2;
                sb.append("Exception thrown from implementation: ");
                sb.append(e.getClass());
            } catch (StackOverflowError e3) {
                e = e3;
                sb.append("Exception thrown from implementation: ");
                sb.append(e.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    private static CancellationException p(String str, @CheckForNull Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @CheckForNull
    private Listener q(@CheckForNull Listener listener) {
        Listener listener2 = listener;
        Listener d2 = Z2.d(this, Listener.f23037d);
        while (d2 != null) {
            Listener listener3 = d2.f23040c;
            d2.f23040c = listener2;
            listener2 = d2;
            d2 = listener3;
        }
        return listener2;
    }

    /* access modifiers changed from: private */
    public static void r(AbstractFuture<?> abstractFuture, boolean z) {
        Listener listener = null;
        AbstractFuture<V> abstractFuture2 = abstractFuture;
        while (true) {
            abstractFuture2.z();
            if (z) {
                abstractFuture2.w();
                z = false;
            }
            abstractFuture2.m();
            Listener q = abstractFuture2.q(listener);
            while (true) {
                if (q != null) {
                    listener = q.f23040c;
                    Runnable runnable = q.f23038a;
                    Objects.requireNonNull(runnable);
                    Runnable runnable2 = runnable;
                    if (runnable2 instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable2;
                        AbstractFuture<V> abstractFuture3 = setFuture.s;
                        if (abstractFuture3.s == setFuture) {
                            if (Z2.b(abstractFuture3, setFuture, u(setFuture.X))) {
                                abstractFuture2 = abstractFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Executor executor = q.f23039b;
                        Objects.requireNonNull(executor);
                        s(runnable2, executor);
                    }
                    q = listener;
                } else {
                    return;
                }
            }
        }
    }

    private static void s(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = X2;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    @ParametricNullness
    private V t(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw p("Task was cancelled.", ((Cancellation) obj).f23034b);
        } else if (!(obj instanceof Failure)) {
            return obj == a3 ? NullnessCasts.b() : obj;
        } else {
            throw new ExecutionException(((Failure) obj).f23036a);
        }
    }

    /* access modifiers changed from: private */
    public static Object u(ListenableFuture<?> listenableFuture) {
        Throwable a2;
        if (listenableFuture instanceof Trusted) {
            Object obj = ((AbstractFuture) listenableFuture).s;
            if (obj instanceof Cancellation) {
                Cancellation cancellation = (Cancellation) obj;
                if (cancellation.f23033a) {
                    obj = cancellation.f23034b != null ? new Cancellation(false, cancellation.f23034b) : Cancellation.f23032d;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        } else if ((listenableFuture instanceof InternalFutureFailureAccess) && (a2 = InternalFutures.a((InternalFutureFailureAccess) listenableFuture)) != null) {
            return new Failure(a2);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!Z) && isCancelled) {
                Cancellation cancellation2 = Cancellation.f23032d;
                Objects.requireNonNull(cancellation2);
                return cancellation2;
            }
            try {
                Object v = v(listenableFuture);
                if (!isCancelled) {
                    return v == null ? a3 : v;
                }
                return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
            } catch (ExecutionException e2) {
                if (!isCancelled) {
                    return new Failure(e2.getCause());
                }
                return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e2));
            } catch (CancellationException e3) {
                if (isCancelled) {
                    return new Cancellation(false, e3);
                }
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
            } catch (RuntimeException e4) {
                e = e4;
                return new Failure(e);
            } catch (Error e5) {
                e = e5;
                return new Failure(e);
            }
        }
    }

    @ParametricNullness
    private static <V> V v(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private void z() {
        for (Waiter e2 = Z2.e(this, Waiter.f23052c); e2 != null; e2 = e2.f23054b) {
            e2.b();
        }
    }

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean B(@ParametricNullness V v) {
        if (v == null) {
            v = a3;
        }
        if (!Z2.b(this, (Object) null, v)) {
            return false;
        }
        r(this, false);
        return true;
    }

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean C(Throwable th) {
        if (!Z2.b(this, (Object) null, new Failure((Throwable) Preconditions.E(th)))) {
            return false;
        }
        r(this, false);
        return true;
    }

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean D(ListenableFuture<? extends V> listenableFuture) {
        Failure failure;
        Preconditions.E(listenableFuture);
        Object obj = this.s;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!Z2.b(this, (Object) null, u(listenableFuture))) {
                    return false;
                }
                r(this, false);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, listenableFuture);
            if (Z2.b(this, (Object) null, setFuture)) {
                try {
                    listenableFuture.a0(setFuture, DirectExecutor.INSTANCE);
                } catch (Error | RuntimeException e2) {
                    try {
                        failure = new Failure(e2);
                    } catch (Error | RuntimeException unused) {
                        failure = Failure.f23035b;
                    }
                    Z2.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.s;
        }
        if (obj instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) obj).f23033a);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean E() {
        Object obj = this.s;
        return (obj instanceof Cancellation) && ((Cancellation) obj).f23033a;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final Throwable a() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object obj = this.s;
        if (obj instanceof Failure) {
            return ((Failure) obj).f23036a;
        }
        return null;
    }

    public void a0(Runnable runnable, Executor executor) {
        Listener listener;
        Preconditions.F(runnable, "Runnable was null.");
        Preconditions.F(executor, "Executor was null.");
        if (isDone() || (listener = this.X) == Listener.f23037d) {
            s(runnable, executor);
        }
        Listener listener2 = new Listener(runnable, executor);
        do {
            listener2.f23040c = listener;
            if (!Z2.a(this, listener, listener2)) {
                listener = this.X;
            } else {
                return;
            }
        } while (listener != Listener.f23037d);
        s(runnable, executor);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.s
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            r3 = r3 | r4
            if (r3 == 0) goto L_0x005f
            boolean r3 = Z
            if (r3 == 0) goto L_0x001f
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = new com.google.common.util.concurrent.AbstractFuture$Cancellation
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0029
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = com.google.common.util.concurrent.AbstractFuture.Cancellation.f23031c
            goto L_0x0026
        L_0x0024:
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = com.google.common.util.concurrent.AbstractFuture.Cancellation.f23032d
        L_0x0026:
            java.util.Objects.requireNonNull(r3)
        L_0x0029:
            r5 = 0
            r4 = r7
        L_0x002b:
            com.google.common.util.concurrent.AbstractFuture$AtomicHelper r6 = Z2
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0057
            r(r4, r8)
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            if (r4 == 0) goto L_0x0060
            com.google.common.util.concurrent.AbstractFuture$SetFuture r0 = (com.google.common.util.concurrent.AbstractFuture.SetFuture) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.X
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.Trusted
            if (r4 == 0) goto L_0x0053
            r4 = r0
            com.google.common.util.concurrent.AbstractFuture r4 = (com.google.common.util.concurrent.AbstractFuture) r4
            java.lang.Object r0 = r4.s
            if (r0 != 0) goto L_0x004b
            r5 = 1
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            boolean r6 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0060
            r5 = 1
            goto L_0x002b
        L_0x0053:
            r0.cancel(r8)
            goto L_0x0060
        L_0x0057:
            java.lang.Object r0 = r4.s
            boolean r6 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            if (r6 != 0) goto L_0x002b
            r1 = r5
            goto L_0x0060
        L_0x005f:
            r1 = 0
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.cancel(boolean):boolean");
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.s;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return t(obj2);
            }
            Waiter waiter = this.Y;
            if (waiter != Waiter.f23052c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (Z2.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.s;
                            } else {
                                A(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return t(obj);
                    }
                    waiter = this.Y;
                } while (waiter != Waiter.f23052c);
            }
            Object obj3 = this.s;
            Objects.requireNonNull(obj3);
            return t(obj3);
        }
        throw new InterruptedException();
    }

    public boolean isCancelled() {
        return this.s instanceof Cancellation;
    }

    public boolean isDone() {
        Object obj = this.s;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public void m() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName().startsWith("com.google.common.util.concurrent.") ? getClass().getSimpleName() : getClass().getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            k(sb);
        } else {
            l(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void w() {
    }

    /* access modifiers changed from: package-private */
    public final void x(@CheckForNull Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(E());
        }
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public String y() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j3 = j2;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j3);
        if (!Thread.interrupted()) {
            Object obj = this.s;
            if ((obj != null) && (!(obj instanceof SetFuture))) {
                return t(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                Waiter waiter = this.Y;
                if (waiter != Waiter.f23052c) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.a(waiter);
                        if (Z2.c(this, waiter, waiter2)) {
                            do {
                                OverflowAvoidingLockSupport.a(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.s;
                                    if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                        return t(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    A(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            A(waiter2);
                        } else {
                            waiter = this.Y;
                        }
                    } while (waiter != Waiter.f23052c);
                }
                Object obj3 = this.s;
                Objects.requireNonNull(obj3);
                return t(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.s;
                if ((obj4 != null) && (!(obj4 instanceof SetFuture))) {
                    return t(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String obj5 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj5.toLowerCase(locale);
            String str = "Waited " + j3 + StringUtils.SPACE + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j4 = -nanos;
                long convert = timeUnit2.convert(j4, TimeUnit.NANOSECONDS);
                long nanos2 = j4 - timeUnit2.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String str3 = str2 + convert + StringUtils.SPACE + lowerCase;
                    if (z) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + StringUtils.SPACE;
                }
                if (z) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }
}
