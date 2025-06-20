package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

public class Finalizer implements Runnable {
    private static final String X2 = "com.google.common.base.FinalizableReference";
    @CheckForNull
    private static final Constructor<Thread> Y2;
    private static final Logger Z = Logger.getLogger(Finalizer.class.getName());
    @CheckForNull
    private static final Field Z2;
    private final PhantomReference<Object> X;
    private final ReferenceQueue<Object> Y;
    private final WeakReference<Class<?>> s;

    static {
        Constructor<Thread> c2 = c();
        Y2 = c2;
        Z2 = c2 == null ? e() : null;
    }

    private Finalizer(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        this.Y = referenceQueue;
        this.s = new WeakReference<>(cls);
        this.X = phantomReference;
    }

    private boolean a(Reference<?> reference) {
        Reference<? extends Object> poll;
        Method d2 = d();
        if (d2 == null || !b(reference, d2)) {
            return false;
        }
        do {
            poll = this.Y.poll();
            if (poll == null) {
                return true;
            }
        } while (b(poll, d2));
        return false;
    }

    private boolean b(Reference<?> reference, Method method) {
        reference.clear();
        if (reference == this.X) {
            return false;
        }
        try {
            method.invoke(reference, (Object[]) null);
            return true;
        } catch (Throwable th) {
            Z.log(Level.SEVERE, "Error cleaning up after reference.", th);
            return true;
        }
    }

    @CheckForNull
    private static Constructor<Thread> c() {
        try {
            return Thread.class.getConstructor(new Class[]{ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE});
        } catch (Throwable unused) {
            return null;
        }
    }

    @CheckForNull
    private Method d() {
        Class cls = this.s.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", (Class[]) null);
        } catch (NoSuchMethodException e2) {
            throw new AssertionError(e2);
        }
    }

    @CheckForNull
    private static Field e() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            Z.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056 A[Catch:{ all -> 0x005a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f(java.lang.Class<?> r5, java.lang.ref.ReferenceQueue<java.lang.Object> r6, java.lang.ref.PhantomReference<java.lang.Object> r7) {
        /*
            r0 = 1
            java.lang.String r1 = r5.getName()
            java.lang.String r2 = "com.google.common.base.FinalizableReference"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0068
            com.google.common.base.internal.Finalizer r1 = new com.google.common.base.internal.Finalizer
            r1.<init>(r5, r6, r7)
            java.lang.Class<com.google.common.base.internal.Finalizer> r5 = com.google.common.base.internal.Finalizer.class
            java.lang.String r5 = r5.getName()
            java.lang.reflect.Constructor<java.lang.Thread> r6 = Y2
            r7 = 0
            if (r6 == 0) goto L_0x0047
            r2 = 0
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x003d }
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x003d }
            r4 = 0
            r3[r4] = r7     // Catch:{ all -> 0x003d }
            r3[r0] = r1     // Catch:{ all -> 0x003d }
            r4 = 2
            r3[r4] = r5     // Catch:{ all -> 0x003d }
            r4 = 3
            r3[r4] = r2     // Catch:{ all -> 0x003d }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x003d }
            r4 = 4
            r3[r4] = r2     // Catch:{ all -> 0x003d }
            java.lang.Object r6 = r6.newInstance(r3)     // Catch:{ all -> 0x003d }
            java.lang.Thread r6 = (java.lang.Thread) r6     // Catch:{ all -> 0x003d }
            goto L_0x0048
        L_0x003d:
            r6 = move-exception
            java.util.logging.Logger r2 = Z
            java.util.logging.Level r3 = java.util.logging.Level.INFO
            java.lang.String r4 = "Failed to create a thread without inherited thread-local values"
            r2.log(r3, r4, r6)
        L_0x0047:
            r6 = r7
        L_0x0048:
            if (r6 != 0) goto L_0x004f
            java.lang.Thread r6 = new java.lang.Thread
            r6.<init>(r7, r1, r5)
        L_0x004f:
            r6.setDaemon(r0)
            java.lang.reflect.Field r5 = Z2     // Catch:{ all -> 0x005a }
            if (r5 == 0) goto L_0x0064
            r5.set(r6, r7)     // Catch:{ all -> 0x005a }
            goto L_0x0064
        L_0x005a:
            r5 = move-exception
            java.util.logging.Logger r7 = Z
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.String r1 = "Failed to clear thread local values inherited by reference finalizer thread."
            r7.log(r0, r1, r5)
        L_0x0064:
            r6.start()
            return
        L_0x0068:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Expected com.google.common.base.FinalizableReference."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.internal.Finalizer.f(java.lang.Class, java.lang.ref.ReferenceQueue, java.lang.ref.PhantomReference):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:0|1) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:2:0x000a, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.ref.ReferenceQueue<java.lang.Object> r0 = r1.Y     // Catch:{ InterruptedException -> 0x0000 }
            java.lang.ref.Reference r0 = r0.remove()     // Catch:{ InterruptedException -> 0x0000 }
            boolean r0 = r1.a(r0)     // Catch:{ InterruptedException -> 0x0000 }
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.internal.Finalizer.run():void");
    }
}
