package kotlinx.coroutines.internal;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007j\u0002`\b2\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR:\u0010\u0012\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007j\u0002`\b0\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/WeakMapCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "<init>", "()V", "Ljava/lang/Class;", "", "key", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "a", "(Ljava/lang/Class;)Lkotlin/jvm/functions/Function1;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "b", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "cacheLock", "Ljava/util/WeakHashMap;", "c", "Ljava/util/WeakHashMap;", "exceptionCtors", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class WeakMapCtorCache extends CtorCache {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final WeakMapCtorCache f29408a = new WeakMapCtorCache();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final ReentrantReadWriteLock f29409b = new ReentrantReadWriteLock();
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> f29410c = new WeakHashMap<>();

    private WeakMapCtorCache() {
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @org.jetbrains.annotations.NotNull
    public kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable> a(@org.jetbrains.annotations.NotNull java.lang.Class<? extends java.lang.Throwable> r7) {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f29409b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            r1.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r2 = f29410c     // Catch:{ all -> 0x006e }
            java.lang.Object r2 = r2.get(r7)     // Catch:{ all -> 0x006e }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ all -> 0x006e }
            r1.unlock()
            if (r2 == 0) goto L_0x0017
            return r2
        L_0x0017:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0027
            int r2 = r0.getReadHoldCount()
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            r4 = 0
        L_0x0029:
            if (r4 >= r2) goto L_0x0031
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0029
        L_0x0031:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r4 = f29410c     // Catch:{ all -> 0x0061 }
            java.lang.Object r5 = r4.get(r7)     // Catch:{ all -> 0x0061 }
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x004e
        L_0x0042:
            if (r3 >= r2) goto L_0x004a
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0042
        L_0x004a:
            r0.unlock()
            return r5
        L_0x004e:
            kotlin.jvm.functions.Function1 r5 = kotlinx.coroutines.internal.ExceptionsConstructorKt.b(r7)     // Catch:{ all -> 0x0061 }
            r4.put(r7, r5)     // Catch:{ all -> 0x0061 }
        L_0x0055:
            if (r3 >= r2) goto L_0x005d
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0055
        L_0x005d:
            r0.unlock()
            return r5
        L_0x0061:
            r7 = move-exception
        L_0x0062:
            if (r3 >= r2) goto L_0x006a
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0062
        L_0x006a:
            r0.unlock()
            throw r7
        L_0x006e:
            r7 = move-exception
            r1.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.WeakMapCtorCache.a(java.lang.Class):kotlin.jvm.functions.Function1");
    }
}
