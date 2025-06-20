package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final IntArrayList X2;
    private int[] Y;
    private int Z;

    static {
        IntArrayList intArrayList = new IntArrayList(new int[0], 0);
        X2 = intArrayList;
        intArrayList.S();
    }

    IntArrayList() {
        this(new int[10], 0);
    }

    private void g(int i2, int i3) {
        int i4;
        b();
        if (i2 < 0 || i2 > (i4 = this.Z)) {
            throw new IndexOutOfBoundsException(m(i2));
        }
        int[] iArr = this.Y;
        if (i4 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i4 - i2);
        } else {
            int[] iArr2 = new int[(((i4 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.Y, i2, iArr2, i2 + 1, this.Z - i2);
            this.Y = iArr2;
        }
        this.Y[i2] = i3;
        this.Z++;
        this.modCount++;
    }

    public static IntArrayList h() {
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

    public boolean addAll(Collection<? extends Integer> collection) {
        b();
        Internal.d(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i2 = intArrayList.Z;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.Z;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.Y;
            if (i4 > iArr.length) {
                this.Y = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(intArrayList.Y, 0, this.Y, this.Z, intArrayList.Z);
            this.Z = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: c */
    public void add(int i2, Integer num) {
        g(i2, num.intValue());
    }

    /* renamed from: d */
    public boolean add(Integer num) {
        h0(num.intValue());
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.Z != intArrayList.Z) {
            return false;
        }
        int[] iArr = intArrayList.Y;
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (this.Y[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public Internal.IntList f(int i2) {
        if (i2 >= this.Z) {
            return new IntArrayList(Arrays.copyOf(this.Y, i2), this.Z);
        }
        throw new IllegalArgumentException();
    }

    public int getInt(int i2) {
        j(i2);
        return this.Y[i2];
    }

    public void h0(int i2) {
        b();
        int i3 = this.Z;
        int[] iArr = this.Y;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.Y = iArr2;
        }
        int[] iArr3 = this.Y;
        int i4 = this.Z;
        this.Z = i4 + 1;
        iArr3[i4] = i2;
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.Z; i3++) {
            i2 = (i2 * 31) + this.Y[i3];
        }
        return i2;
    }

    /* renamed from: k */
    public Integer get(int i2) {
        return Integer.valueOf(getInt(i2));
    }

    /* renamed from: n */
    public Integer remove(int i2) {
        b();
        j(i2);
        int[] iArr = this.Y;
        int i3 = iArr[i2];
        int i4 = this.Z;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.Z--;
        this.modCount++;
        return Integer.valueOf(i3);
    }

    /* renamed from: o */
    public Integer set(int i2, Integer num) {
        return Integer.valueOf(s(i2, num.intValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i2, int i3) {
        b();
        if (i3 >= i2) {
            int[] iArr = this.Y;
            System.arraycopy(iArr, i3, iArr, i2, this.Z - i3);
            this.Z -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int s(int i2, int i3) {
        b();
        j(i2);
        int[] iArr = this.Y;
        int i4 = iArr[i2];
        iArr[i2] = i3;
        return i4;
    }

    public int size() {
        return this.Z;
    }

    private IntArrayList(int[] iArr, int i2) {
        this.Y = iArr;
        this.Z = i2;
    }

    public boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (obj.equals(Integer.valueOf(this.Y[i2]))) {
                int[] iArr = this.Y;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.Z - i2) - 1);
                this.Z--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
