package com.google.common.util.concurrent;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@ElementTypesAreNonnullByDefault
public class AtomicDouble extends Number implements Serializable {
    private static final long X = 0;
    private transient AtomicLong s;

    public AtomicDouble() {
        this(0.0d);
    }

    private void g(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.s = new AtomicLong();
        h(objectInputStream.readDouble());
    }

    private void j(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(c());
    }

    @CanIgnoreReturnValue
    public final double a(double d2) {
        long j2;
        double longBitsToDouble;
        do {
            j2 = this.s.get();
            longBitsToDouble = Double.longBitsToDouble(j2) + d2;
        } while (!this.s.compareAndSet(j2, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean b(double d2, double d3) {
        return this.s.compareAndSet(Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public final double c() {
        return Double.longBitsToDouble(this.s.get());
    }

    @CanIgnoreReturnValue
    public final double d(double d2) {
        long j2;
        double longBitsToDouble;
        do {
            j2 = this.s.get();
            longBitsToDouble = Double.longBitsToDouble(j2);
        } while (!this.s.compareAndSet(j2, Double.doubleToRawLongBits(longBitsToDouble + d2)));
        return longBitsToDouble;
    }

    public double doubleValue() {
        return c();
    }

    public final double e(double d2) {
        return Double.longBitsToDouble(this.s.getAndSet(Double.doubleToRawLongBits(d2)));
    }

    public final void f(double d2) {
        this.s.lazySet(Double.doubleToRawLongBits(d2));
    }

    public float floatValue() {
        return (float) c();
    }

    public final void h(double d2) {
        this.s.set(Double.doubleToRawLongBits(d2));
    }

    public final boolean i(double d2, double d3) {
        return this.s.weakCompareAndSet(Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public int intValue() {
        return (int) c();
    }

    public long longValue() {
        return (long) c();
    }

    public String toString() {
        return Double.toString(c());
    }

    public AtomicDouble(double d2) {
        this.s = new AtomicLong(Double.doubleToRawLongBits(d2));
    }
}
