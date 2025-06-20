package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class ExecutionList {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f23165c = Logger.getLogger(ExecutionList.class.getName());
    @CheckForNull
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private RunnableExecutorPair f23166a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private boolean f23167b;

    private static final class RunnableExecutorPair {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f23168a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f23169b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        RunnableExecutorPair f23170c;

        RunnableExecutorPair(Runnable runnable, Executor executor, @CheckForNull RunnableExecutorPair runnableExecutorPair) {
            this.f23168a = runnable;
            this.f23169b = executor;
            this.f23170c = runnableExecutorPair;
        }
    }

    private static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f23165c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        Preconditions.F(runnable, "Runnable was null.");
        Preconditions.F(executor, "Executor was null.");
        synchronized (this) {
            try {
                if (!this.f23167b) {
                    this.f23166a = new RunnableExecutorPair(runnable, executor, this.f23166a);
                } else {
                    c(runnable, executor);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        if (r0 == null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        r2 = r0.f23170c;
        r0.f23170c = r1;
        r1 = r0;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        if (r1 == null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        c(r1.f23168a, r1.f23169b);
        r1 = r1.f23170c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f23167b     // Catch:{ all -> 0x0007 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
            return
        L_0x0007:
            r0 = move-exception
            goto L_0x0028
        L_0x0009:
            r0 = 1
            r3.f23167b = r0     // Catch:{ all -> 0x0007 }
            com.google.common.util.concurrent.ExecutionList$RunnableExecutorPair r0 = r3.f23166a     // Catch:{ all -> 0x0007 }
            r1 = 0
            r3.f23166a = r1     // Catch:{ all -> 0x0007 }
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
        L_0x0012:
            if (r0 == 0) goto L_0x001b
            com.google.common.util.concurrent.ExecutionList$RunnableExecutorPair r2 = r0.f23170c
            r0.f23170c = r1
            r1 = r0
            r0 = r2
            goto L_0x0012
        L_0x001b:
            if (r1 == 0) goto L_0x0027
            java.lang.Runnable r0 = r1.f23168a
            java.util.concurrent.Executor r2 = r1.f23169b
            c(r0, r2)
            com.google.common.util.concurrent.ExecutionList$RunnableExecutorPair r1 = r1.f23170c
            goto L_0x001b
        L_0x0027:
            return
        L_0x0028:
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ExecutionList.b():void");
    }
}
