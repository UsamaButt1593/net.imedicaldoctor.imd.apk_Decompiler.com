package com.google.common.util.concurrent;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.primitives.ImmutableLongArray;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.itextpdf.xmp.XMPConst;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public class AtomicDoubleArray implements Serializable {
    private static final long X = 0;
    private transient AtomicLongArray s;

    public AtomicDoubleArray(int i2) {
        this.s = new AtomicLongArray(i2);
    }

    private void h(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        ImmutableLongArray.Builder e2 = ImmutableLongArray.e();
        for (int i2 = 0; i2 < readInt; i2++) {
            e2.a(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.s = new AtomicLongArray(e2.f().A());
    }

    private void k(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int g2 = g();
        objectOutputStream.writeInt(g2);
        for (int i2 = 0; i2 < g2; i2++) {
            objectOutputStream.writeDouble(c(i2));
        }
    }

    @CanIgnoreReturnValue
    public double a(int i2, double d2) {
        long j2;
        double longBitsToDouble;
        do {
            j2 = this.s.get(i2);
            longBitsToDouble = Double.longBitsToDouble(j2) + d2;
        } while (!this.s.compareAndSet(i2, j2, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean b(int i2, double d2, double d3) {
        return this.s.compareAndSet(i2, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public final double c(int i2) {
        return Double.longBitsToDouble(this.s.get(i2));
    }

    @CanIgnoreReturnValue
    public final double d(int i2, double d2) {
        long j2;
        double longBitsToDouble;
        do {
            j2 = this.s.get(i2);
            longBitsToDouble = Double.longBitsToDouble(j2);
        } while (!this.s.compareAndSet(i2, j2, Double.doubleToRawLongBits(longBitsToDouble + d2)));
        return longBitsToDouble;
    }

    public final double e(int i2, double d2) {
        return Double.longBitsToDouble(this.s.getAndSet(i2, Double.doubleToRawLongBits(d2)));
    }

    public final void f(int i2, double d2) {
        this.s.lazySet(i2, Double.doubleToRawLongBits(d2));
    }

    public final int g() {
        return this.s.length();
    }

    public final void i(int i2, double d2) {
        this.s.set(i2, Double.doubleToRawLongBits(d2));
    }

    public final boolean j(int i2, double d2, double d3) {
        return this.s.weakCompareAndSet(i2, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public String toString() {
        int g2 = g();
        int i2 = g2 - 1;
        if (i2 == -1) {
            return XMPConst.o2;
        }
        StringBuilder sb = new StringBuilder(g2 * 19);
        sb.append('[');
        int i3 = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.s.get(i3)));
            if (i3 == i2) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(ASCIIPropertyListParser.f18651i);
            sb.append(' ');
            i3++;
        }
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            jArr[i2] = Double.doubleToRawLongBits(dArr[i2]);
        }
        this.s = new AtomicLongArray(jArr);
    }
}
