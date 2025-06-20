package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final BooleanArrayList X2;
    private boolean[] Y;
    private int Z;

    static {
        BooleanArrayList booleanArrayList = new BooleanArrayList(new boolean[0], 0);
        X2 = booleanArrayList;
        booleanArrayList.S();
    }

    BooleanArrayList() {
        this(new boolean[10], 0);
    }

    private void g(int i2, boolean z) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.Z)) {
            throw new IndexOutOfBoundsException(m(i2));
        }
        boolean[] zArr = this.Y;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[(((i3 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.Y, i2, zArr2, i2 + 1, this.Z - i2);
            this.Y = zArr2;
        }
        this.Y[i2] = z;
        this.Z++;
        this.modCount++;
    }

    public static BooleanArrayList h() {
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

    public boolean A(int i2, boolean z) {
        b();
        j(i2);
        boolean[] zArr = this.Y;
        boolean z2 = zArr[i2];
        zArr[i2] = z;
        return z2;
    }

    public boolean addAll(Collection<? extends Boolean> collection) {
        b();
        Internal.d(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i2 = booleanArrayList.Z;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.Z;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.Y;
            if (i4 > zArr.length) {
                this.Y = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(booleanArrayList.Y, 0, this.Y, this.Z, booleanArrayList.Z);
            this.Z = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: c */
    public void add(int i2, Boolean bool) {
        g(i2, bool.booleanValue());
    }

    public void c1(boolean z) {
        b();
        int i2 = this.Z;
        boolean[] zArr = this.Y;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.Y = zArr2;
        }
        boolean[] zArr3 = this.Y;
        int i3 = this.Z;
        this.Z = i3 + 1;
        zArr3[i3] = z;
    }

    /* renamed from: d */
    public boolean add(Boolean bool) {
        c1(bool.booleanValue());
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.Z != booleanArrayList.Z) {
            return false;
        }
        boolean[] zArr = booleanArrayList.Y;
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (this.Y[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public Internal.BooleanList f(int i2) {
        if (i2 >= this.Z) {
            return new BooleanArrayList(Arrays.copyOf(this.Y, i2), this.Z);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.Z; i3++) {
            i2 = (i2 * 31) + Internal.k(this.Y[i3]);
        }
        return i2;
    }

    /* renamed from: k */
    public Boolean get(int i2) {
        return Boolean.valueOf(v(i2));
    }

    /* renamed from: n */
    public Boolean remove(int i2) {
        b();
        j(i2);
        boolean[] zArr = this.Y;
        boolean z = zArr[i2];
        int i3 = this.Z;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.Z--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    /* renamed from: o */
    public Boolean set(int i2, Boolean bool) {
        return Boolean.valueOf(A(i2, bool.booleanValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i2, int i3) {
        b();
        if (i3 >= i2) {
            boolean[] zArr = this.Y;
            System.arraycopy(zArr, i3, zArr, i2, this.Z - i3);
            this.Z -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int size() {
        return this.Z;
    }

    public boolean v(int i2) {
        j(i2);
        return this.Y[i2];
    }

    private BooleanArrayList(boolean[] zArr, int i2) {
        this.Y = zArr;
        this.Z = i2;
    }

    public boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (obj.equals(Boolean.valueOf(this.Y[i2]))) {
                boolean[] zArr = this.Y;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.Z - i2) - 1);
                this.Z--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
