package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {
    /* access modifiers changed from: private */
    @CheckForNull
    public ListenableFuture<V> b3;
    /* access modifiers changed from: private */
    @CheckForNull
    public ScheduledFuture<?> c3;

    private static final class Fire<V> implements Runnable {
        @CheckForNull
        TimeoutFuture<V> s;

        Fire(TimeoutFuture<V> timeoutFuture) {
            this.s = timeoutFuture;
        }

        public void run() {
            ListenableFuture N;
            String str;
            TimeoutFuture<V> timeoutFuture = this.s;
            if (timeoutFuture != null && (N = timeoutFuture.b3) != null) {
                this.s = null;
                if (N.isDone()) {
                    timeoutFuture.D(N);
                    return;
                }
                try {
                    ScheduledFuture O = timeoutFuture.c3;
                    ScheduledFuture unused = timeoutFuture.c3 = null;
                    str = "Timed out";
                    if (O != null) {
                        long abs = Math.abs(O.getDelay(TimeUnit.MILLISECONDS));
                        if (abs > 10) {
                            str = str + " (timeout delayed by " + abs + " ms after scheduled time)";
                        }
                    }
                    timeoutFuture.C(new TimeoutFutureException(str + ": " + N));
                    N.cancel(true);
                } catch (Throwable th) {
                    N.cancel(true);
                    throw th;
                }
            }
        }
    }

    private static final class TimeoutFutureException extends TimeoutException {
        private TimeoutFutureException(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }

    private TimeoutFuture(ListenableFuture<V> listenableFuture) {
        this.b3 = (ListenableFuture) Preconditions.E(listenableFuture);
    }

    static <V> ListenableFuture<V> Q(ListenableFuture<V> listenableFuture, long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(listenableFuture);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.c3 = scheduledExecutorService.schedule(fire, j2, timeUnit);
        listenableFuture.a0(fire, MoreExecutors.c());
        return timeoutFuture;
    }

    /* access modifiers changed from: protected */
    public void m() {
        x(this.b3);
        ScheduledFuture<?> scheduledFuture = this.c3;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.b3 = null;
        this.c3 = null;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public String y() {
        ListenableFuture<V> listenableFuture = this.b3;
        ScheduledFuture<?> scheduledFuture = this.c3;
        if (listenableFuture == null) {
            return null;
        }
        String str = "inputFuture=[" + listenableFuture + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
