package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
@ElementTypesAreNonnullByDefault
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable X = new DoNothingRunnable();
    private static final int Y = 1000;
    private static final Runnable s = new DoNothingRunnable();

    @VisibleForTesting
    static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {
        private final InterruptibleTask<?> s;

        private Blocker(InterruptibleTask<?> interruptibleTask) {
            this.s = interruptibleTask;
        }

        /* access modifiers changed from: private */
        public void c(Thread thread) {
            super.setExclusiveOwnerThread(thread);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        @VisibleForTesting
        public Thread b() {
            return super.getExclusiveOwnerThread();
        }

        public void run() {
        }

        public String toString() {
            return this.s.toString();
        }
    }

    private static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        public void run() {
        }
    }

    InterruptibleTask() {
    }

    private void g(Thread thread) {
        Runnable runnable = (Runnable) get();
        Blocker blocker = null;
        boolean z = false;
        int i2 = 0;
        while (true) {
            boolean z2 = runnable instanceof Blocker;
            if (!z2 && runnable != X) {
                break;
            }
            if (z2) {
                blocker = (Blocker) runnable;
            }
            i2++;
            if (i2 > 1000) {
                Runnable runnable2 = X;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(blocker);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Throwable th);

    /* access modifiers changed from: package-private */
    public abstract void b(@ParametricNullness T t);

    /* access modifiers changed from: package-private */
    public final void c() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            Blocker blocker = new Blocker();
            blocker.c(Thread.currentThread());
            if (compareAndSet(runnable, blocker)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (((Runnable) getAndSet(s)) == X) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean d();

    /* access modifiers changed from: package-private */
    @ParametricNullness
    public abstract T e() throws Exception;

    /* access modifiers changed from: package-private */
    public abstract String f();

    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet((Object) null, currentThread)) {
            boolean z = !d();
            if (z) {
                try {
                    obj = e();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, s)) {
                        g(currentThread);
                    }
                    if (z) {
                        b(NullnessCasts.a(null));
                    }
                    throw th;
                }
            }
            if (!compareAndSet(currentThread, s)) {
                g(currentThread);
            }
            if (z) {
                b(NullnessCasts.a(obj));
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == s) {
            str = "running=[DONE]";
        } else if (runnable instanceof Blocker) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + f();
    }
}
