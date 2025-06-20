package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimedSemaphore {
    public static final int NO_LIMIT = 0;
    private static final int THREAD_POOL_SIZE = 1;
    private int acquireCount;
    private final ScheduledExecutorService executorService;
    private int lastCallsPerPeriod;
    private int limit;
    private final boolean ownExecutor;
    private final long period;
    private long periodCount;
    private boolean shutdown;
    private ScheduledFuture<?> task;
    private long totalAcquireCount;
    private final TimeUnit unit;

    public TimedSemaphore(long j2, TimeUnit timeUnit, int i2) {
        this((ScheduledExecutorService) null, j2, timeUnit, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029 A[Catch:{ all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d A[Catch:{ all -> 0x0012 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void acquire() throws java.lang.InterruptedException {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.isShutdown()     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0036
            java.util.concurrent.ScheduledFuture<?> r0 = r3.task     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0014
            java.util.concurrent.ScheduledFuture r0 = r3.startTimer()     // Catch:{ all -> 0x0012 }
            r3.task = r0     // Catch:{ all -> 0x0012 }
            goto L_0x0014
        L_0x0012:
            r0 = move-exception
            goto L_0x003e
        L_0x0014:
            int r0 = r3.getLimit()     // Catch:{ all -> 0x0012 }
            r1 = 1
            if (r0 <= 0) goto L_0x0026
            int r0 = r3.acquireCount     // Catch:{ all -> 0x0012 }
            int r2 = r3.getLimit()     // Catch:{ all -> 0x0012 }
            if (r0 >= r2) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r0 = 0
            goto L_0x0027
        L_0x0026:
            r0 = 1
        L_0x0027:
            if (r0 != 0) goto L_0x002d
            r3.wait()     // Catch:{ all -> 0x0012 }
            goto L_0x0032
        L_0x002d:
            int r2 = r3.acquireCount     // Catch:{ all -> 0x0012 }
            int r2 = r2 + r1
            r3.acquireCount = r2     // Catch:{ all -> 0x0012 }
        L_0x0032:
            if (r0 == 0) goto L_0x0014
            monitor-exit(r3)
            return
        L_0x0036:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0012 }
            java.lang.String r1 = "TimedSemaphore is shut down!"
            r0.<init>(r1)     // Catch:{ all -> 0x0012 }
            throw r0     // Catch:{ all -> 0x0012 }
        L_0x003e:
            monitor-exit(r3)     // Catch:{ all -> 0x0012 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.concurrent.TimedSemaphore.acquire():void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void endOfPeriod() {
        int i2 = this.acquireCount;
        this.lastCallsPerPeriod = i2;
        this.totalAcquireCount += (long) i2;
        this.periodCount++;
        this.acquireCount = 0;
        notifyAll();
    }

    public synchronized int getAcquireCount() {
        return this.acquireCount;
    }

    public synchronized int getAvailablePermits() {
        return getLimit() - getAcquireCount();
    }

    public synchronized double getAverageCallsPerPeriod() {
        long j2;
        j2 = this.periodCount;
        return j2 == 0 ? 0.0d : ((double) this.totalAcquireCount) / ((double) j2);
    }

    /* access modifiers changed from: protected */
    public ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    public synchronized int getLastAcquiresPerPeriod() {
        return this.lastCallsPerPeriod;
    }

    public final synchronized int getLimit() {
        return this.limit;
    }

    public long getPeriod() {
        return this.period;
    }

    public TimeUnit getUnit() {
        return this.unit;
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    public final synchronized void setLimit(int i2) {
        this.limit = i2;
    }

    public synchronized void shutdown() {
        try {
            if (!this.shutdown) {
                if (this.ownExecutor) {
                    getExecutorService().shutdownNow();
                }
                ScheduledFuture<?> scheduledFuture = this.task;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.shutdown = true;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public ScheduledFuture<?> startTimer() {
        return getExecutorService().scheduleAtFixedRate(new Runnable() {
            public void run() {
                TimedSemaphore.this.endOfPeriod();
            }
        }, getPeriod(), getPeriod(), getUnit());
    }

    public TimedSemaphore(ScheduledExecutorService scheduledExecutorService, long j2, TimeUnit timeUnit, int i2) {
        if (j2 > 0) {
            this.period = j2;
            this.unit = timeUnit;
            if (scheduledExecutorService != null) {
                this.executorService = scheduledExecutorService;
                this.ownExecutor = false;
            } else {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
                scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
                this.executorService = scheduledThreadPoolExecutor;
                this.ownExecutor = true;
            }
            setLimit(i2);
            return;
        }
        throw new IllegalArgumentException("Time period must be greater 0!");
    }
}
