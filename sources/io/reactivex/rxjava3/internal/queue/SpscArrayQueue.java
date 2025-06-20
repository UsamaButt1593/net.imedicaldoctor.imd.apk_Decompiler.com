package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    private static final long Y2 = -1296597691183856449L;
    private static final Integer Z2 = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong X = new AtomicLong();
    final int X2;
    long Y;
    final AtomicLong Z = new AtomicLong();
    final int s = (length() - 1);

    public SpscArrayQueue(int i2) {
        super(Pow2.b(i2));
        this.X2 = Math.min(i2 / 4, Z2.intValue());
    }

    /* access modifiers changed from: package-private */
    public int a(long j2) {
        return this.s & ((int) j2);
    }

    /* access modifiers changed from: package-private */
    public int b(long j2, int i2) {
        return ((int) j2) & i2;
    }

    /* access modifiers changed from: package-private */
    public E c(int i2) {
        return get(i2);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(long j2) {
        this.Z.lazySet(j2);
    }

    /* access modifiers changed from: package-private */
    public void e(int i2, E e2) {
        lazySet(i2, e2);
    }

    /* access modifiers changed from: package-private */
    public void f(long j2) {
        this.X.lazySet(j2);
    }

    public boolean isEmpty() {
        return this.X.get() == this.Z.get();
    }

    public boolean offer(E e2) {
        if (e2 != null) {
            int i2 = this.s;
            long j2 = this.X.get();
            int b2 = b(j2, i2);
            if (j2 >= this.Y) {
                long j3 = ((long) this.X2) + j2;
                if (c(b(j3, i2)) == null) {
                    this.Y = j3;
                } else if (c(b2) != null) {
                    return false;
                }
            }
            e(b2, e2);
            f(j2 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Nullable
    public E poll() {
        long j2 = this.Z.get();
        int a2 = a(j2);
        E c2 = c(a2);
        if (c2 == null) {
            return null;
        }
        d(j2 + 1);
        e(a2, (Object) null);
        return c2;
    }

    public boolean q(E e2, E e3) {
        return offer(e2) && offer(e3);
    }
}
