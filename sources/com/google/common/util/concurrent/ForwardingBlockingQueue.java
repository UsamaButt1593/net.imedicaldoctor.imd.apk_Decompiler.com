package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ForwardingQueue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    protected ForwardingBlockingQueue() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: K1 */
    public abstract BlockingQueue<E> a1();

    @CanIgnoreReturnValue
    public int drainTo(Collection<? super E> collection) {
        return a1().drainTo(collection);
    }

    @CanIgnoreReturnValue
    public boolean offer(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        return a1().offer(e2, j2, timeUnit);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public E poll(long j2, TimeUnit timeUnit) throws InterruptedException {
        return a1().poll(j2, timeUnit);
    }

    public void put(E e2) throws InterruptedException {
        a1().put(e2);
    }

    public int remainingCapacity() {
        return a1().remainingCapacity();
    }

    @CanIgnoreReturnValue
    public E take() throws InterruptedException {
        return a1().take();
    }

    @CanIgnoreReturnValue
    public int drainTo(Collection<? super E> collection, int i2) {
        return a1().drainTo(collection, i2);
    }
}
