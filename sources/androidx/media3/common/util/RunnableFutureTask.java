package androidx.media3.common.util;

import androidx.annotation.Nullable;
import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@UnstableApi
public abstract class RunnableFutureTask<R, E extends Exception> implements RunnableFuture<R> {
    private final ConditionVariable X = new ConditionVariable();
    @Nullable
    private R X2;
    private final Object Y = new Object();
    @Nullable
    private Thread Y2;
    @Nullable
    private Exception Z;
    private boolean Z2;
    private final ConditionVariable s = new ConditionVariable();

    protected RunnableFutureTask() {
    }

    @UnknownNull
    private R e() throws ExecutionException {
        if (this.Z2) {
            throw new CancellationException();
        } else if (this.Z == null) {
            return this.X2;
        } else {
            throw new ExecutionException(this.Z);
        }
    }

    public final void a() {
        this.X.c();
    }

    public final void b() {
        this.s.c();
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.Y
            monitor-enter(r0)
            boolean r1 = r3.Z2     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x002e
            androidx.media3.common.util.ConditionVariable r1 = r3.X     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.e()     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0010
            goto L_0x002e
        L_0x0010:
            r1 = 1
            r3.Z2 = r1     // Catch:{ all -> 0x0020 }
            r3.c()     // Catch:{ all -> 0x0020 }
            java.lang.Thread r2 = r3.Y2     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x0022
            if (r4 == 0) goto L_0x002c
            r2.interrupt()     // Catch:{ all -> 0x0020 }
            goto L_0x002c
        L_0x0020:
            r4 = move-exception
            goto L_0x0031
        L_0x0022:
            androidx.media3.common.util.ConditionVariable r4 = r3.s     // Catch:{ all -> 0x0020 }
            r4.f()     // Catch:{ all -> 0x0020 }
            androidx.media3.common.util.ConditionVariable r4 = r3.X     // Catch:{ all -> 0x0020 }
            r4.f()     // Catch:{ all -> 0x0020 }
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return r1
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            r4 = 0
            return r4
        L_0x0031:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.RunnableFutureTask.cancel(boolean):boolean");
    }

    /* access modifiers changed from: protected */
    @UnknownNull
    public abstract R d() throws Exception;

    @UnknownNull
    public final R get() throws ExecutionException, InterruptedException {
        this.X.a();
        return e();
    }

    public final boolean isCancelled() {
        return this.Z2;
    }

    public final boolean isDone() {
        return this.X.e();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.Y
            monitor-enter(r0)
            boolean r1 = r4.Z2     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            return
        L_0x0009:
            r1 = move-exception
            goto L_0x0059
        L_0x000b:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0009 }
            r4.Y2 = r1     // Catch:{ all -> 0x0009 }
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            androidx.media3.common.util.ConditionVariable r0 = r4.s
            r0.f()
            r0 = 0
            java.lang.Object r1 = r4.d()     // Catch:{ Exception -> 0x0032 }
            r4.X2 = r1     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r1 = r4.Y
            monitor-enter(r1)
            androidx.media3.common.util.ConditionVariable r2 = r4.X     // Catch:{ all -> 0x002d }
            r2.f()     // Catch:{ all -> 0x002d }
            r4.Y2 = r0     // Catch:{ all -> 0x002d }
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x002d }
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            goto L_0x0043
        L_0x002d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            throw r0
        L_0x0030:
            r1 = move-exception
            goto L_0x0047
        L_0x0032:
            r1 = move-exception
            r4.Z = r1     // Catch:{ all -> 0x0030 }
            java.lang.Object r1 = r4.Y
            monitor-enter(r1)
            androidx.media3.common.util.ConditionVariable r2 = r4.X     // Catch:{ all -> 0x0044 }
            r2.f()     // Catch:{ all -> 0x0044 }
            r4.Y2 = r0     // Catch:{ all -> 0x0044 }
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0044 }
            monitor-exit(r1)     // Catch:{ all -> 0x0044 }
        L_0x0043:
            return
        L_0x0044:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0044 }
            throw r0
        L_0x0047:
            java.lang.Object r2 = r4.Y
            monitor-enter(r2)
            androidx.media3.common.util.ConditionVariable r3 = r4.X     // Catch:{ all -> 0x0056 }
            r3.f()     // Catch:{ all -> 0x0056 }
            r4.Y2 = r0     // Catch:{ all -> 0x0056 }
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x0056 }
            monitor-exit(r2)     // Catch:{ all -> 0x0056 }
            throw r1
        L_0x0056:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0056 }
            throw r0
        L_0x0059:
            monitor-exit(r0)     // Catch:{ all -> 0x0009 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.RunnableFutureTask.run():void");
    }

    @UnknownNull
    public final R get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.X.b(TimeUnit.MILLISECONDS.convert(j2, timeUnit))) {
            return e();
        }
        throw new TimeoutException();
    }
}
