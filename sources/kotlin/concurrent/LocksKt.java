package kotlin.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nLocks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Locks.kt\nkotlin/concurrent/LocksKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n"})
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0007\u0010\b\u001a8\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\t\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\n"}, d2 = {"T", "Ljava/util/concurrent/locks/Lock;", "Lkotlin/Function0;", "action", "b", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "a", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "c", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "LocksKt")
public final class LocksKt {
    @InlineOnly
    private static final <T> T a(ReentrantReadWriteLock reentrantReadWriteLock, Function0<? extends T> function0) {
        Intrinsics.p(reentrantReadWriteLock, "<this>");
        Intrinsics.p(function0, "action");
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            return function0.o();
        } finally {
            InlineMarker.d(1);
            readLock.unlock();
            InlineMarker.c(1);
        }
    }

    @InlineOnly
    private static final <T> T b(Lock lock, Function0<? extends T> function0) {
        Intrinsics.p(lock, "<this>");
        Intrinsics.p(function0, "action");
        lock.lock();
        try {
            return function0.o();
        } finally {
            InlineMarker.d(1);
            lock.unlock();
            InlineMarker.c(1);
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @kotlin.internal.InlineOnly
    private static final <T> T c(java.util.concurrent.locks.ReentrantReadWriteLock r4, kotlin.jvm.functions.Function0<? extends T> r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.p(r5, r0)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r4.readLock()
            int r1 = r4.getWriteHoldCount()
            r2 = 0
            if (r1 != 0) goto L_0x001a
            int r1 = r4.getReadHoldCount()
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            r3 = 0
        L_0x001c:
            if (r3 >= r1) goto L_0x0024
            r0.unlock()
            int r3 = r3 + 1
            goto L_0x001c
        L_0x0024:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r4 = r4.writeLock()
            r4.lock()
            r3 = 1
            java.lang.Object r5 = r5.o()     // Catch:{ all -> 0x0042 }
            kotlin.jvm.internal.InlineMarker.d(r3)
        L_0x0033:
            if (r2 >= r1) goto L_0x003b
            r0.lock()
            int r2 = r2 + 1
            goto L_0x0033
        L_0x003b:
            r4.unlock()
            kotlin.jvm.internal.InlineMarker.c(r3)
            return r5
        L_0x0042:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r3)
        L_0x0046:
            if (r2 >= r1) goto L_0x004e
            r0.lock()
            int r2 = r2 + 1
            goto L_0x0046
        L_0x004e:
            r4.unlock()
            kotlin.jvm.internal.InlineMarker.c(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.concurrent.LocksKt.c(java.util.concurrent.locks.ReentrantReadWriteLock, kotlin.jvm.functions.Function0):java.lang.Object");
    }
}
