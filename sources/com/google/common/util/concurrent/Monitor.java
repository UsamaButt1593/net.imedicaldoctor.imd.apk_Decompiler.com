package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class Monitor {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f23191a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ReentrantLock f23192b;
    @CheckForNull
    @GuardedBy("lock")

    /* renamed from: c  reason: collision with root package name */
    private Guard f23193c;

    public static abstract class Guard {
        @Weak

        /* renamed from: a  reason: collision with root package name */
        final Monitor f23194a;

        /* renamed from: b  reason: collision with root package name */
        final Condition f23195b;
        @GuardedBy("monitor.lock")

        /* renamed from: c  reason: collision with root package name */
        int f23196c = 0;
        @CheckForNull
        @GuardedBy("monitor.lock")

        /* renamed from: d  reason: collision with root package name */
        Guard f23197d;

        protected Guard(Monitor monitor) {
            this.f23194a = (Monitor) Preconditions.F(monitor, "monitor");
            this.f23195b = monitor.f23192b.newCondition();
        }

        public abstract boolean a();
    }

    public Monitor() {
        this(false);
    }

    @GuardedBy("lock")
    private boolean C(Guard guard) {
        try {
            return guard.a();
        } catch (Error | RuntimeException e2) {
            F();
            throw e2;
        }
    }

    private static long E(long j2, long j3) {
        if (j3 <= 0) {
            return 0;
        }
        return j3 - (System.nanoTime() - j2);
    }

    @GuardedBy("lock")
    private void F() {
        for (Guard guard = this.f23193c; guard != null; guard = guard.f23197d) {
            guard.f23195b.signalAll();
        }
    }

    @GuardedBy("lock")
    private void G() {
        for (Guard guard = this.f23193c; guard != null; guard = guard.f23197d) {
            if (C(guard)) {
                guard.f23195b.signal();
                return;
            }
        }
    }

    private static long H(long j2, TimeUnit timeUnit) {
        return Longs.g(timeUnit.toNanos(j2), 0, 6917529027641081853L);
    }

    @GuardedBy("lock")
    private void b(Guard guard, boolean z) throws InterruptedException {
        if (z) {
            G();
        }
        e(guard);
        do {
            try {
                guard.f23195b.await();
            } finally {
                f(guard);
            }
        } while (!guard.a());
    }

    @GuardedBy("lock")
    private boolean c(Guard guard, long j2, boolean z) throws InterruptedException {
        boolean z2 = true;
        while (j2 > 0) {
            if (z2) {
                if (z) {
                    try {
                        G();
                    } catch (Throwable th) {
                        if (!z2) {
                            f(guard);
                        }
                        throw th;
                    }
                }
                e(guard);
                z2 = false;
            }
            j2 = guard.f23195b.awaitNanos(j2);
            if (guard.a()) {
                if (!z2) {
                    f(guard);
                }
                return true;
            }
        }
        if (!z2) {
            f(guard);
        }
        return false;
    }

    @GuardedBy("lock")
    private void d(Guard guard, boolean z) {
        if (z) {
            G();
        }
        e(guard);
        do {
            try {
                guard.f23195b.awaitUninterruptibly();
            } finally {
                f(guard);
            }
        } while (!guard.a());
    }

    @GuardedBy("lock")
    private void e(Guard guard) {
        int i2 = guard.f23196c;
        guard.f23196c = i2 + 1;
        if (i2 == 0) {
            guard.f23197d = this.f23193c;
            this.f23193c = guard;
        }
    }

    @GuardedBy("lock")
    private void f(Guard guard) {
        int i2 = guard.f23196c - 1;
        guard.f23196c = i2;
        if (i2 == 0) {
            Guard guard2 = this.f23193c;
            Guard guard3 = null;
            while (guard2 != guard) {
                guard3 = guard2;
                guard2 = guard2.f23197d;
            }
            Guard guard4 = guard2.f23197d;
            if (guard3 == null) {
                this.f23193c = guard4;
            } else {
                guard3.f23197d = guard4;
            }
            guard2.f23197d = null;
        }
    }

    private static long y(long j2) {
        if (j2 <= 0) {
            return 0;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime == 0) {
            return 1;
        }
        return nanoTime;
    }

    public boolean A() {
        return this.f23192b.isLocked();
    }

    public boolean B() {
        return this.f23192b.isHeldByCurrentThread();
    }

    public void D() {
        ReentrantLock reentrantLock = this.f23192b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                G();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean I() {
        return this.f23192b.tryLock();
    }

    public boolean J(Guard guard) {
        if (guard.f23194a == this) {
            ReentrantLock reentrantLock = this.f23192b;
            if (!reentrantLock.tryLock()) {
                return false;
            }
            try {
                boolean a2 = guard.a();
                if (!a2) {
                }
                return a2;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void K(Guard guard) throws InterruptedException {
        if (guard.f23194a != this || !this.f23192b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.a()) {
            b(guard, true);
        }
    }

    public boolean L(Guard guard, long j2, TimeUnit timeUnit) throws InterruptedException {
        long H = H(j2, timeUnit);
        if (guard.f23194a != this || !this.f23192b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (guard.a()) {
            return true;
        } else {
            if (!Thread.interrupted()) {
                return c(guard, H, true);
            }
            throw new InterruptedException();
        }
    }

    public void M(Guard guard) {
        if (guard.f23194a != this || !this.f23192b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        } else if (!guard.a()) {
            d(guard, true);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean N(com.google.common.util.concurrent.Monitor.Guard r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r6 = this;
            long r8 = H(r8, r10)
            com.google.common.util.concurrent.Monitor r10 = r7.f23194a
            if (r10 != r6) goto L_0x0053
            java.util.concurrent.locks.ReentrantLock r10 = r6.f23192b
            boolean r10 = r10.isHeldByCurrentThread()
            if (r10 == 0) goto L_0x0053
            boolean r10 = r7.a()
            r0 = 1
            if (r10 == 0) goto L_0x0018
            return r0
        L_0x0018:
            long r1 = y(r8)
            boolean r10 = java.lang.Thread.interrupted()
            r3 = r8
            r5 = 1
        L_0x0022:
            boolean r7 = r6.c(r7, r3, r5)     // Catch:{ InterruptedException -> 0x0033, all -> 0x0030 }
            if (r10 == 0) goto L_0x002f
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            r8.interrupt()
        L_0x002f:
            return r7
        L_0x0030:
            r7 = move-exception
            r0 = r10
            goto L_0x0049
        L_0x0033:
            boolean r10 = r7.a()     // Catch:{ all -> 0x0048 }
            if (r10 == 0) goto L_0x0041
            java.lang.Thread r7 = java.lang.Thread.currentThread()
            r7.interrupt()
            return r0
        L_0x0041:
            long r3 = E(r1, r8)     // Catch:{ all -> 0x0048 }
            r5 = 0
            r10 = 1
            goto L_0x0022
        L_0x0048:
            r7 = move-exception
        L_0x0049:
            if (r0 == 0) goto L_0x0052
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            r8.interrupt()
        L_0x0052:
            throw r7
        L_0x0053:
            java.lang.IllegalMonitorStateException r7 = new java.lang.IllegalMonitorStateException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.N(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public void g() {
        this.f23192b.lock();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4 = E(java.lang.System.nanoTime(), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r7 = this;
            long r8 = H(r8, r10)
            java.util.concurrent.locks.ReentrantLock r10 = r7.f23192b
            boolean r0 = r7.f23191a
            r1 = 1
            if (r0 != 0) goto L_0x0012
            boolean r0 = r10.tryLock()
            if (r0 == 0) goto L_0x0012
            return r1
        L_0x0012:
            boolean r0 = java.lang.Thread.interrupted()
            long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x002b }
            r4 = r8
        L_0x001b:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x002e }
            boolean r8 = r10.tryLock(r4, r6)     // Catch:{ InterruptedException -> 0x002e }
            if (r0 == 0) goto L_0x002a
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x002a:
            return r8
        L_0x002b:
            r8 = move-exception
            r1 = r0
            goto L_0x0035
        L_0x002e:
            long r4 = E(r2, r8)     // Catch:{ all -> 0x0034 }
            r0 = 1
            goto L_0x001b
        L_0x0034:
            r8 = move-exception
        L_0x0035:
            if (r1 == 0) goto L_0x003e
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
        L_0x003e:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.h(long, java.util.concurrent.TimeUnit):boolean");
    }

    public boolean i(Guard guard) {
        if (guard.f23194a == this) {
            ReentrantLock reentrantLock = this.f23192b;
            reentrantLock.lock();
            try {
                boolean a2 = guard.a();
                if (!a2) {
                }
                return a2;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean j(Guard guard, long j2, TimeUnit timeUnit) {
        if (guard.f23194a != this) {
            throw new IllegalMonitorStateException();
        } else if (!h(j2, timeUnit)) {
            return false;
        } else {
            try {
                boolean a2 = guard.a();
                if (!a2) {
                }
                return a2;
            } finally {
                this.f23192b.unlock();
            }
        }
    }

    public boolean k(Guard guard) throws InterruptedException {
        if (guard.f23194a == this) {
            ReentrantLock reentrantLock = this.f23192b;
            reentrantLock.lockInterruptibly();
            try {
                boolean a2 = guard.a();
                if (!a2) {
                }
                return a2;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean l(Guard guard, long j2, TimeUnit timeUnit) throws InterruptedException {
        if (guard.f23194a == this) {
            ReentrantLock reentrantLock = this.f23192b;
            if (!reentrantLock.tryLock(j2, timeUnit)) {
                return false;
            }
            try {
                boolean a2 = guard.a();
                if (!a2) {
                }
                return a2;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public void m() throws InterruptedException {
        this.f23192b.lockInterruptibly();
    }

    public boolean n(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f23192b.tryLock(j2, timeUnit);
    }

    public void o(Guard guard) throws InterruptedException {
        if (guard.f23194a == this) {
            ReentrantLock reentrantLock = this.f23192b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lockInterruptibly();
            try {
                if (!guard.a()) {
                    b(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th) {
                D();
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (c(r11, r0, r3) != false) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[Catch:{ all -> 0x004a, all -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean p(com.google.common.util.concurrent.Monitor.Guard r11, long r12, java.util.concurrent.TimeUnit r14) throws java.lang.InterruptedException {
        /*
            r10 = this;
            long r0 = H(r12, r14)
            com.google.common.util.concurrent.Monitor r2 = r11.f23194a
            if (r2 != r10) goto L_0x0062
            java.util.concurrent.locks.ReentrantLock r2 = r10.f23192b
            boolean r3 = r2.isHeldByCurrentThread()
            boolean r4 = r10.f23191a
            r5 = 0
            r6 = 0
            if (r4 != 0) goto L_0x0029
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x0023
            boolean r4 = r2.tryLock()
            if (r4 == 0) goto L_0x0029
            r8 = r6
            goto L_0x0034
        L_0x0023:
            java.lang.InterruptedException r11 = new java.lang.InterruptedException
            r11.<init>()
            throw r11
        L_0x0029:
            long r8 = y(r0)
            boolean r12 = r2.tryLock(r12, r14)
            if (r12 != 0) goto L_0x0034
            return r5
        L_0x0034:
            boolean r12 = r11.a()     // Catch:{ all -> 0x004a }
            if (r12 != 0) goto L_0x004c
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x003f
            goto L_0x0043
        L_0x003f:
            long r0 = E(r8, r0)     // Catch:{ all -> 0x004a }
        L_0x0043:
            boolean r11 = r10.c(r11, r0, r3)     // Catch:{ all -> 0x004a }
            if (r11 == 0) goto L_0x004d
            goto L_0x004c
        L_0x004a:
            r11 = move-exception
            goto L_0x0053
        L_0x004c:
            r5 = 1
        L_0x004d:
            if (r5 != 0) goto L_0x0052
            r2.unlock()
        L_0x0052:
            return r5
        L_0x0053:
            if (r3 != 0) goto L_0x005e
            r10.G()     // Catch:{ all -> 0x0059 }
            goto L_0x005e
        L_0x0059:
            r11 = move-exception
            r2.unlock()
            throw r11
        L_0x005e:
            r2.unlock()
            throw r11
        L_0x0062:
            java.lang.IllegalMonitorStateException r11 = new java.lang.IllegalMonitorStateException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.p(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public void q(Guard guard) {
        if (guard.f23194a == this) {
            ReentrantLock reentrantLock = this.f23192b;
            boolean isHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
            reentrantLock.lock();
            try {
                if (!guard.a()) {
                    d(guard, isHeldByCurrentThread);
                }
            } catch (Throwable th) {
                D();
                throw th;
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:42|43|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r9 = E(r7, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0073, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0074, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0077, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x006d */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0038 A[Catch:{ InterruptedException -> 0x0060, all -> 0x0043, all -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039 A[Catch:{ InterruptedException -> 0x0060, all -> 0x0043, all -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004f A[SYNTHETIC, Splitter:B:29:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean r(com.google.common.util.concurrent.Monitor.Guard r12, long r13, java.util.concurrent.TimeUnit r15) {
        /*
            r11 = this;
            long r13 = H(r13, r15)
            com.google.common.util.concurrent.Monitor r15 = r12.f23194a
            if (r15 != r11) goto L_0x007f
            java.util.concurrent.locks.ReentrantLock r15 = r11.f23192b
            boolean r0 = r15.isHeldByCurrentThread()
            boolean r1 = java.lang.Thread.interrupted()
            boolean r2 = r11.f23191a     // Catch:{ all -> 0x0023 }
            r3 = 0
            r4 = 0
            r6 = 1
            if (r2 != 0) goto L_0x0025
            boolean r2 = r15.tryLock()     // Catch:{ all -> 0x0023 }
            if (r2 != 0) goto L_0x0021
            goto L_0x0025
        L_0x0021:
            r7 = r4
            goto L_0x0032
        L_0x0023:
            r12 = move-exception
            goto L_0x0075
        L_0x0025:
            long r7 = y(r13)     // Catch:{ all -> 0x0023 }
            r9 = r13
        L_0x002a:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x006d }
            boolean r2 = r15.tryLock(r9, r2)     // Catch:{ InterruptedException -> 0x006d }
            if (r2 == 0) goto L_0x0063
        L_0x0032:
            boolean r2 = r12.a()     // Catch:{ InterruptedException -> 0x0060, all -> 0x0043 }
            if (r2 == 0) goto L_0x0039
            goto L_0x004d
        L_0x0039:
            int r2 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0045
            long r7 = y(r13)     // Catch:{ InterruptedException -> 0x0060, all -> 0x0043 }
            r9 = r13
            goto L_0x0049
        L_0x0043:
            r12 = move-exception
            goto L_0x005c
        L_0x0045:
            long r9 = E(r7, r13)     // Catch:{ InterruptedException -> 0x0060, all -> 0x0043 }
        L_0x0049:
            boolean r6 = r11.c(r12, r9, r0)     // Catch:{ InterruptedException -> 0x0060, all -> 0x0043 }
        L_0x004d:
            if (r6 != 0) goto L_0x0052
            r15.unlock()     // Catch:{ all -> 0x0023 }
        L_0x0052:
            if (r1 == 0) goto L_0x005b
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L_0x005b:
            return r6
        L_0x005c:
            r15.unlock()     // Catch:{ all -> 0x0023 }
            throw r12     // Catch:{ all -> 0x0023 }
        L_0x0060:
            r0 = 0
            r1 = 1
            goto L_0x0032
        L_0x0063:
            if (r1 == 0) goto L_0x006c
            java.lang.Thread r12 = java.lang.Thread.currentThread()
            r12.interrupt()
        L_0x006c:
            return r3
        L_0x006d:
            long r9 = E(r7, r13)     // Catch:{ all -> 0x0073 }
            r1 = 1
            goto L_0x002a
        L_0x0073:
            r12 = move-exception
            r1 = 1
        L_0x0075:
            if (r1 == 0) goto L_0x007e
            java.lang.Thread r13 = java.lang.Thread.currentThread()
            r13.interrupt()
        L_0x007e:
            throw r12
        L_0x007f:
            java.lang.IllegalMonitorStateException r12 = new java.lang.IllegalMonitorStateException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Monitor.r(com.google.common.util.concurrent.Monitor$Guard, long, java.util.concurrent.TimeUnit):boolean");
    }

    public int s() {
        return this.f23192b.getHoldCount();
    }

    public int t() {
        return this.f23192b.getQueueLength();
    }

    public int u(Guard guard) {
        if (guard.f23194a == this) {
            this.f23192b.lock();
            try {
                return guard.f23196c;
            } finally {
                this.f23192b.unlock();
            }
        } else {
            throw new IllegalMonitorStateException();
        }
    }

    public boolean v(Thread thread) {
        return this.f23192b.hasQueuedThread(thread);
    }

    public boolean w() {
        return this.f23192b.hasQueuedThreads();
    }

    public boolean x(Guard guard) {
        return u(guard) > 0;
    }

    public boolean z() {
        return this.f23191a;
    }

    public Monitor(boolean z) {
        this.f23193c = null;
        this.f23191a = z;
        this.f23192b = new ReentrantLock(z);
    }
}
