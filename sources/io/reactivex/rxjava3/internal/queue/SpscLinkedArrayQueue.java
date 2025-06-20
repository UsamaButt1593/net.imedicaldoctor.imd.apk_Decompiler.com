package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    static final int b3 = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object c3 = new Object();
    int X;
    AtomicReferenceArray<Object> X2;
    long Y;
    final int Y2;
    final int Z;
    AtomicReferenceArray<Object> Z2;
    final AtomicLong a3 = new AtomicLong();
    final AtomicLong s = new AtomicLong();

    public SpscLinkedArrayQueue(int i2) {
        int b2 = Pow2.b(Math.max(8, i2));
        int i3 = b2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(b2 + 1);
        this.X2 = atomicReferenceArray;
        this.Z = i3;
        a(b2);
        this.Z2 = atomicReferenceArray;
        this.Y2 = i3;
        this.Y = (long) (b2 - 2);
        v(0);
    }

    private void a(int i2) {
        this.X = Math.min(i2 / 4, b3);
    }

    private static int b(int i2) {
        return i2;
    }

    private static int c(long j2, int i2) {
        return b(((int) j2) & i2);
    }

    private long d() {
        return this.a3.get();
    }

    private long e() {
        return this.s.get();
    }

    private long f() {
        return this.a3.get();
    }

    private static Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int b2 = b(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, b2);
        t(atomicReferenceArray, b2, (Object) null);
        return atomicReferenceArray2;
    }

    private long i() {
        return this.s.get();
    }

    private T l(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.Z2 = atomicReferenceArray;
        return g(atomicReferenceArray, c(j2, i2));
    }

    private T m(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.Z2 = atomicReferenceArray;
        int c2 = c(j2, i2);
        T g2 = g(atomicReferenceArray, c2);
        if (g2 != null) {
            t(atomicReferenceArray, c2, (Object) null);
            s(j2 + 1);
        }
        return g2;
    }

    private void o(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.X2 = atomicReferenceArray2;
        this.Y = (j3 + j2) - 1;
        t(atomicReferenceArray2, i2, t);
        u(atomicReferenceArray, atomicReferenceArray2);
        t(atomicReferenceArray, i2, c3);
        v(j2 + 1);
    }

    private void s(long j2) {
        this.a3.lazySet(j2);
    }

    private static void t(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void u(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        t(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void v(long j2) {
        this.s.lazySet(j2);
    }

    private boolean w(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        t(atomicReferenceArray, i2, t);
        v(j2 + 1);
        return true;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return i() == f();
    }

    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.X2;
            long e2 = e();
            int i2 = this.Z;
            int c2 = c(e2, i2);
            if (e2 < this.Y) {
                return w(atomicReferenceArray, t, e2, c2);
            }
            long j2 = ((long) this.X) + e2;
            if (g(atomicReferenceArray, c(j2, i2)) == null) {
                this.Y = j2 - 1;
                return w(atomicReferenceArray, t, e2, c2);
            } else if (g(atomicReferenceArray, c(1 + e2, i2)) == null) {
                return w(atomicReferenceArray, t, e2, c2);
            } else {
                o(atomicReferenceArray, e2, c2, t, (long) i2);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    public int p() {
        long f2 = f();
        while (true) {
            long i2 = i();
            long f3 = f();
            if (f2 == f3) {
                return (int) (i2 - f3);
            }
            f2 = f3;
        }
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.Z2;
        long d2 = d();
        int i2 = this.Y2;
        T g2 = g(atomicReferenceArray, c(d2, i2));
        return g2 == c3 ? l(h(atomicReferenceArray, i2 + 1), d2, i2) : g2;
    }

    @Nullable
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.Z2;
        long d2 = d();
        int i2 = this.Y2;
        int c2 = c(d2, i2);
        T g2 = g(atomicReferenceArray, c2);
        boolean z = g2 == c3;
        if (g2 != null && !z) {
            t(atomicReferenceArray, c2, (Object) null);
            s(d2 + 1);
            return g2;
        } else if (z) {
            return m(h(atomicReferenceArray, i2 + 1), d2, i2);
        } else {
            return null;
        }
    }

    public boolean q(T t, T t2) {
        int c2;
        AtomicReferenceArray<Object> atomicReferenceArray = this.X2;
        long i2 = i();
        int i3 = this.Z;
        long j2 = 2 + i2;
        if (g(atomicReferenceArray, c(j2, i3)) == null) {
            c2 = c(i2, i3);
            t(atomicReferenceArray, c2 + 1, t2);
        } else {
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.X2 = atomicReferenceArray2;
            c2 = c(i2, i3);
            t(atomicReferenceArray2, c2 + 1, t2);
            t(atomicReferenceArray2, c2, t);
            u(atomicReferenceArray, atomicReferenceArray2);
            t = c3;
        }
        t(atomicReferenceArray, c2, t);
        v(j2);
        return true;
    }
}
