package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class EvictingQueue<E> extends ForwardingQueue<E> implements Serializable {
    private static final long Y = 0;
    @VisibleForTesting
    final int X;
    private final Queue<E> s;

    private EvictingQueue(int i2) {
        Preconditions.k(i2 >= 0, "maxSize (%s) must >= 0", i2);
        this.s = new ArrayDeque(i2);
        this.X = i2;
    }

    public static <E> EvictingQueue<E> K1(int i2) {
        return new EvictingQueue<>(i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: E1 */
    public Queue<E> a1() {
        return this.s;
    }

    @CanIgnoreReturnValue
    public boolean add(E e2) {
        Preconditions.E(e2);
        if (this.X == 0) {
            return true;
        }
        if (size() == this.X) {
            this.s.remove();
        }
        this.s.add(e2);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.X) {
            return f1(collection);
        }
        clear();
        return Iterables.a(this, Iterables.N(collection, size - this.X));
    }

    @CanIgnoreReturnValue
    public boolean offer(E e2) {
        return add(e2);
    }

    public int remainingCapacity() {
        return this.X - size();
    }

    @J2ktIncompatible
    public Object[] toArray() {
        return super.toArray();
    }
}
