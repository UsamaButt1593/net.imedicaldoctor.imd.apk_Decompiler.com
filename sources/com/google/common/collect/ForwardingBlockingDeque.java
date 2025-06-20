package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Deprecated
@J2ktIncompatible
public abstract class ForwardingBlockingDeque<E> extends ForwardingDeque<E> implements BlockingDeque<E> {
    protected ForwardingBlockingDeque() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: L1 */
    public abstract BlockingDeque<E> a1();

    public int drainTo(Collection<? super E> collection) {
        return a1().drainTo(collection);
    }

    public boolean offer(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        return a1().offer(e2, j2, timeUnit);
    }

    public boolean offerFirst(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        return a1().offerFirst(e2, j2, timeUnit);
    }

    public boolean offerLast(E e2, long j2, TimeUnit timeUnit) throws InterruptedException {
        return a1().offerLast(e2, j2, timeUnit);
    }

    @CheckForNull
    public E poll(long j2, TimeUnit timeUnit) throws InterruptedException {
        return a1().poll(j2, timeUnit);
    }

    @CheckForNull
    public E pollFirst(long j2, TimeUnit timeUnit) throws InterruptedException {
        return a1().pollFirst(j2, timeUnit);
    }

    @CheckForNull
    public E pollLast(long j2, TimeUnit timeUnit) throws InterruptedException {
        return a1().pollLast(j2, timeUnit);
    }

    public void put(E e2) throws InterruptedException {
        a1().put(e2);
    }

    public void putFirst(E e2) throws InterruptedException {
        a1().putFirst(e2);
    }

    public void putLast(E e2) throws InterruptedException {
        a1().putLast(e2);
    }

    public int remainingCapacity() {
        return a1().remainingCapacity();
    }

    public E take() throws InterruptedException {
        return a1().take();
    }

    public E takeFirst() throws InterruptedException {
        return a1().takeFirst();
    }

    public E takeLast() throws InterruptedException {
        return a1().takeLast();
    }

    public int drainTo(Collection<? super E> collection, int i2) {
        return a1().drainTo(collection, i2);
    }
}
