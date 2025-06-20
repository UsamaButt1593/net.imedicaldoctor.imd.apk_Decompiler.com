package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class LongAdder extends Striped64 implements Serializable, LongAddable {
    private static final long c3 = 7249069246863182397L;

    private void l(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.Y = 0;
        this.s = null;
        this.X = objectInputStream.readLong();
    }

    private void o(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(c());
    }

    public void a(long j2) {
        int length;
        Striped64.Cell cell;
        Striped64.Cell[] cellArr = this.s;
        if (cellArr == null) {
            long j3 = this.X;
            if (e(j3, j3 + j2)) {
                return;
            }
        }
        int[] iArr = Striped64.Z.get();
        boolean z = true;
        if (!(iArr == null || cellArr == null || (length = cellArr.length) < 1 || (cell = cellArr[(length - 1) & iArr[0]]) == null)) {
            long j4 = cell.f22355h;
            z = cell.a(j4, j4 + j2);
            if (z) {
                return;
            }
        }
        j(j2, iArr, z);
    }

    public void b() {
        a(1);
    }

    public long c() {
        long j2 = this.X;
        Striped64.Cell[] cellArr = this.s;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j2 += cell.f22355h;
                }
            }
        }
        return j2;
    }

    public double doubleValue() {
        return (double) c();
    }

    public float floatValue() {
        return (float) c();
    }

    /* access modifiers changed from: package-private */
    public final long g(long j2, long j3) {
        return j2 + j3;
    }

    public int intValue() {
        return (int) c();
    }

    public void k() {
        a(-1);
    }

    public long longValue() {
        return c();
    }

    public void m() {
        i(0);
    }

    public long n() {
        long j2 = this.X;
        Striped64.Cell[] cellArr = this.s;
        this.X = 0;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j2 += cell.f22355h;
                    cell.f22355h = 0;
                }
            }
        }
        return j2;
    }

    public String toString() {
        return Long.toString(c());
    }
}
