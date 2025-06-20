package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final DoubleArrayList X2;
    private double[] Y;
    private int Z;

    static {
        DoubleArrayList doubleArrayList = new DoubleArrayList(new double[0], 0);
        X2 = doubleArrayList;
        doubleArrayList.S();
    }

    DoubleArrayList() {
        this(new double[10], 0);
    }

    private void g(int i2, double d2) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.Z)) {
            throw new IndexOutOfBoundsException(m(i2));
        }
        double[] dArr = this.Y;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[(((i3 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.Y, i2, dArr2, i2 + 1, this.Z - i2);
            this.Y = dArr2;
        }
        this.Y[i2] = d2;
        this.Z++;
        this.modCount++;
    }

    public static DoubleArrayList h() {
        return X2;
    }

    private void j(int i2) {
        if (i2 < 0 || i2 >= this.Z) {
            throw new IndexOutOfBoundsException(m(i2));
        }
    }

    private String m(int i2) {
        return "Index:" + i2 + ", Size:" + this.Z;
    }

    public boolean addAll(Collection<? extends Double> collection) {
        b();
        Internal.d(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i2 = doubleArrayList.Z;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.Z;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.Y;
            if (i4 > dArr.length) {
                this.Y = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(doubleArrayList.Y, 0, this.Y, this.Z, doubleArrayList.Z);
            this.Z = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: c */
    public void add(int i2, Double d2) {
        g(i2, d2.doubleValue());
    }

    /* renamed from: d */
    public boolean add(Double d2) {
        k1(d2.doubleValue());
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.Z != doubleArrayList.Z) {
            return false;
        }
        double[] dArr = doubleArrayList.Y;
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (Double.doubleToLongBits(this.Y[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public Internal.DoubleList f(int i2) {
        if (i2 >= this.Z) {
            return new DoubleArrayList(Arrays.copyOf(this.Y, i2), this.Z);
        }
        throw new IllegalArgumentException();
    }

    public double getDouble(int i2) {
        j(i2);
        return this.Y[i2];
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.Z; i3++) {
            i2 = (i2 * 31) + Internal.s(Double.doubleToLongBits(this.Y[i3]));
        }
        return i2;
    }

    /* renamed from: k */
    public Double get(int i2) {
        return Double.valueOf(getDouble(i2));
    }

    public void k1(double d2) {
        b();
        int i2 = this.Z;
        double[] dArr = this.Y;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.Y = dArr2;
        }
        double[] dArr3 = this.Y;
        int i3 = this.Z;
        this.Z = i3 + 1;
        dArr3[i3] = d2;
    }

    /* renamed from: n */
    public Double remove(int i2) {
        b();
        j(i2);
        double[] dArr = this.Y;
        double d2 = dArr[i2];
        int i3 = this.Z;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.Z--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    /* renamed from: o */
    public Double set(int i2, Double d2) {
        return Double.valueOf(p(i2, d2.doubleValue()));
    }

    public double p(int i2, double d2) {
        b();
        j(i2);
        double[] dArr = this.Y;
        double d3 = dArr[i2];
        dArr[i2] = d2;
        return d3;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i2, int i3) {
        b();
        if (i3 >= i2) {
            double[] dArr = this.Y;
            System.arraycopy(dArr, i3, dArr, i2, this.Z - i3);
            this.Z -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int size() {
        return this.Z;
    }

    private DoubleArrayList(double[] dArr, int i2) {
        this.Y = dArr;
        this.Z = i2;
    }

    public boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (obj.equals(Double.valueOf(this.Y[i2]))) {
                double[] dArr = this.Y;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.Z - i2) - 1);
                this.Z--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
