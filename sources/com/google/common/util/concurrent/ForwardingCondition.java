package com.google.common.util.concurrent;

import com.google.common.annotations.J2ktIncompatible;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
abstract class ForwardingCondition implements Condition {
    ForwardingCondition() {
    }

    /* access modifiers changed from: package-private */
    public abstract Condition a();

    public void await() throws InterruptedException {
        a().await();
    }

    public long awaitNanos(long j2) throws InterruptedException {
        return a().awaitNanos(j2);
    }

    public void awaitUninterruptibly() {
        a().awaitUninterruptibly();
    }

    public boolean awaitUntil(Date date) throws InterruptedException {
        return a().awaitUntil(date);
    }

    public void signal() {
        a().signal();
    }

    public void signalAll() {
        a().signalAll();
    }

    public boolean await(long j2, TimeUnit timeUnit) throws InterruptedException {
        return a().await(j2, timeUnit);
    }
}
