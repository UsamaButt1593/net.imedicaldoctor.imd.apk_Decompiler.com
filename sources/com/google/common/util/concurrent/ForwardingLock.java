package com.google.common.util.concurrent;

import com.google.common.annotations.J2ktIncompatible;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
abstract class ForwardingLock implements Lock {
    ForwardingLock() {
    }

    /* access modifiers changed from: package-private */
    public abstract Lock a();

    public void lock() {
        a().lock();
    }

    public void lockInterruptibly() throws InterruptedException {
        a().lockInterruptibly();
    }

    public Condition newCondition() {
        return a().newCondition();
    }

    public boolean tryLock() {
        return a().tryLock();
    }

    public void unlock() {
        a().unlock();
    }

    public boolean tryLock(long j2, TimeUnit timeUnit) throws InterruptedException {
        return a().tryLock(j2, timeUnit);
    }
}
