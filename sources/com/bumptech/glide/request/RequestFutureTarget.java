package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {
    private static final Waiter d3 = new Waiter();
    private final int X;
    @GuardedBy("this")
    @Nullable
    private R X2;
    private final boolean Y;
    @GuardedBy("this")
    @Nullable
    private Request Y2;
    private final Waiter Z;
    @GuardedBy("this")
    private boolean Z2;
    @GuardedBy("this")
    private boolean a3;
    @GuardedBy("this")
    private boolean b3;
    @GuardedBy("this")
    @Nullable
    private GlideException c3;
    private final int s;

    @VisibleForTesting
    static class Waiter {
        Waiter() {
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            obj.notifyAll();
        }

        /* access modifiers changed from: package-private */
        public void b(Object obj, long j2) throws InterruptedException {
            obj.wait(j2);
        }
    }

    public RequestFutureTarget(int i2, int i3) {
        this(i2, i3, true, d3);
    }

    private synchronized R h(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        try {
            if (this.Y && !isDone()) {
                Util.a();
            }
            if (this.Z2) {
                throw new CancellationException();
            } else if (this.b3) {
                throw new ExecutionException(this.c3);
            } else if (this.a3) {
                return this.X2;
            } else {
                if (l2 == null) {
                    this.Z.b(this, 0);
                } else if (l2.longValue() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = l2.longValue() + currentTimeMillis;
                    while (!isDone() && currentTimeMillis < longValue) {
                        this.Z.b(this, longValue - currentTimeMillis);
                        currentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                } else if (this.b3) {
                    throw new ExecutionException(this.c3);
                } else if (this.Z2) {
                    throw new CancellationException();
                } else if (this.a3) {
                    return this.X2;
                } else {
                    throw new TimeoutException();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a() {
    }

    public void b() {
    }

    public void c(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r1 == null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isDone()     // Catch:{ all -> 0x000a }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            r3 = 0
            return r3
        L_0x000a:
            r3 = move-exception
            goto L_0x0023
        L_0x000c:
            r0 = 1
            r2.Z2 = r0     // Catch:{ all -> 0x000a }
            com.bumptech.glide.request.RequestFutureTarget$Waiter r1 = r2.Z     // Catch:{ all -> 0x000a }
            r1.a(r2)     // Catch:{ all -> 0x000a }
            r1 = 0
            if (r3 == 0) goto L_0x001c
            com.bumptech.glide.request.Request r3 = r2.Y2     // Catch:{ all -> 0x000a }
            r2.Y2 = r1     // Catch:{ all -> 0x000a }
            r1 = r3
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            if (r1 == 0) goto L_0x0022
            r1.clear()
        L_0x0022:
            return r0
        L_0x0023:
            monitor-exit(r2)     // Catch:{ all -> 0x000a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestFutureTarget.cancel(boolean):boolean");
    }

    public void d() {
    }

    public synchronized void e(@NonNull R r, @Nullable Transition<? super R> transition) {
    }

    public synchronized boolean f(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z) {
        this.b3 = true;
        this.c3 = glideException;
        this.Z.a(this);
        return false;
    }

    public synchronized boolean g(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        this.a3 = true;
        this.X2 = r;
        this.Z.a(this);
        return false;
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return h((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    public synchronized boolean isCancelled() {
        return this.Z2;
    }

    public synchronized boolean isDone() {
        return this.Z2 || this.a3 || this.b3;
    }

    public synchronized void j(@Nullable Request request) {
        this.Y2 = request;
    }

    public synchronized void k(@Nullable Drawable drawable) {
    }

    public void p(@Nullable Drawable drawable) {
    }

    @Nullable
    public synchronized Request q() {
        return this.Y2;
    }

    public void r(@Nullable Drawable drawable) {
    }

    public void s(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.e(this.s, this.X);
    }

    RequestFutureTarget(int i2, int i3, boolean z, Waiter waiter) {
        this.s = i2;
        this.X = i3;
        this.Y = z;
        this.Z = waiter;
    }

    public R get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return h(Long.valueOf(timeUnit.toMillis(j2)));
    }
}
