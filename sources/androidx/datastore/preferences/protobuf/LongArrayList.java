package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final LongArrayList X2;
    private long[] Y;
    private int Z;

    static {
        LongArrayList longArrayList = new LongArrayList(new long[0], 0);
        X2 = longArrayList;
        longArrayList.S();
    }

    LongArrayList() {
        this(new long[10], 0);
    }

    private void g(int i2, long j2) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.Z)) {
            throw new IndexOutOfBoundsException(m(i2));
        }
        long[] jArr = this.Y;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[(((i3 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.Y, i2, jArr2, i2 + 1, this.Z - i2);
            this.Y = jArr2;
        }
        this.Y[i2] = j2;
        this.Z++;
        this.modCount++;
    }

    public static LongArrayList h() {
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

    public void S0(long j2) {
        b();
        int i2 = this.Z;
        long[] jArr = this.Y;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.Y = jArr2;
        }
        long[] jArr3 = this.Y;
        int i3 = this.Z;
        this.Z = i3 + 1;
        jArr3[i3] = j2;
    }

    public boolean addAll(Collection<? extends Long> collection) {
        b();
        Internal.d(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i2 = longArrayList.Z;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.Z;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.Y;
            if (i4 > jArr.length) {
                this.Y = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(longArrayList.Y, 0, this.Y, this.Z, longArrayList.Z);
            this.Z = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: c */
    public void add(int i2, Long l2) {
        g(i2, l2.longValue());
    }

    /* renamed from: d */
    public boolean add(Long l2) {
        S0(l2.longValue());
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.Z != longArrayList.Z) {
            return false;
        }
        long[] jArr = longArrayList.Y;
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (this.Y[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public Internal.LongList f(int i2) {
        if (i2 >= this.Z) {
            return new LongArrayList(Arrays.copyOf(this.Y, i2), this.Z);
        }
        throw new IllegalArgumentException();
    }

    public long getLong(int i2) {
        j(i2);
        return this.Y[i2];
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.Z; i3++) {
            i2 = (i2 * 31) + Internal.s(this.Y[i3]);
        }
        return i2;
    }

    /* renamed from: k */
    public Long get(int i2) {
        return Long.valueOf(getLong(i2));
    }

    /* renamed from: n */
    public Long remove(int i2) {
        b();
        j(i2);
        long[] jArr = this.Y;
        long j2 = jArr[i2];
        int i3 = this.Z;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.Z--;
        this.modCount++;
        return Long.valueOf(j2);
    }

    /* renamed from: o */
    public Long set(int i2, Long l2) {
        return Long.valueOf(y(i2, l2.longValue()));
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i2, int i3) {
        b();
        if (i3 >= i2) {
            long[] jArr = this.Y;
            System.arraycopy(jArr, i3, jArr, i2, this.Z - i3);
            this.Z -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int size() {
        return this.Z;
    }

    public long y(int i2, long j2) {
        b();
        j(i2);
        long[] jArr = this.Y;
        long j3 = jArr[i2];
        jArr[i2] = j2;
        return j3;
    }

    private LongArrayList(long[] jArr, int i2) {
        this.Y = jArr;
        this.Z = i2;
    }

    public boolean remove(Object obj) {
        b();
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (obj.equals(Long.valueOf(this.Y[i2]))) {
                long[] jArr = this.Y;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.Z - i2) - 1);
                this.Z--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
