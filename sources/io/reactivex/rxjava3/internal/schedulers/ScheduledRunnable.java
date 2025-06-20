package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    private static final long X = -6120223772001106981L;
    static final Object X2 = new Object();
    static final Object Y = new Object();
    static final Object Y2 = new Object();
    static final Object Z = new Object();
    static final int Z2 = 0;
    static final int a3 = 1;
    static final int b3 = 2;
    final Runnable s;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.s = runnable;
        lazySet(0, disposableContainer);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != Y2) {
                if (obj == Z) {
                    future.cancel(false);
                    return;
                } else if (obj == X2) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    public Object call() {
        run();
        return null;
    }

    public boolean g() {
        Object obj = get(0);
        return obj == Y || obj == Y2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m() {
        /*
            r7 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r7.get(r0)
            java.lang.Object r2 = Y2
            r3 = 0
            if (r1 == r2) goto L_0x0031
            java.lang.Object r2 = Z
            if (r1 == r2) goto L_0x0031
            java.lang.Object r4 = X2
            if (r1 != r4) goto L_0x0013
            goto L_0x0031
        L_0x0013:
            r5 = 2
            java.lang.Object r5 = r7.get(r5)
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            if (r5 == r6) goto L_0x0020
            r5 = 1
            goto L_0x0021
        L_0x0020:
            r5 = 0
        L_0x0021:
            if (r5 == 0) goto L_0x0024
            r2 = r4
        L_0x0024:
            boolean r0 = r7.compareAndSet(r0, r1, r2)
            if (r0 == 0) goto L_0x0000
            if (r1 == 0) goto L_0x0031
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1
            r1.cancel(r5)
        L_0x0031:
            java.lang.Object r0 = r7.get(r3)
            java.lang.Object r1 = Y2
            if (r0 == r1) goto L_0x004b
            java.lang.Object r1 = Y
            if (r0 == r1) goto L_0x004b
            if (r0 != 0) goto L_0x0040
            goto L_0x004b
        L_0x0040:
            boolean r1 = r7.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0031
            io.reactivex.rxjava3.disposables.DisposableContainer r0 = (io.reactivex.rxjava3.disposables.DisposableContainer) r0
            r0.c(r7)
        L_0x004b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.schedulers.ScheduledRunnable.m():void");
    }

    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.s.run();
            lazySet(2, (Object) null);
            Object obj3 = get(0);
            if (!(obj3 == Y || !compareAndSet(0, obj3, Y2) || obj3 == null)) {
                ((DisposableContainer) obj3).c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == Z || obj2 == X2 || compareAndSet(1, obj2, Y2)) {
                }
                obj2 = get(1);
                return;
            } while (compareAndSet(1, obj2, Y2));
        } catch (Throwable th) {
            lazySet(2, (Object) null);
            Object obj4 = get(0);
            if (!(obj4 == Y || !compareAndSet(0, obj4, Y2) || obj4 == null)) {
                ((DisposableContainer) obj4).c(this);
            }
            do {
                obj = get(1);
                if (obj == Z || obj == X2 || compareAndSet(1, obj, Y2)) {
                    throw th;
                }
                obj = get(1);
                break;
            } while (compareAndSet(1, obj, Y2));
            throw th;
        }
    }
}
