package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> X2;
    private E[] Y;
    private int Z;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(new Object[0], 0);
        X2 = protobufArrayList;
        protobufArrayList.S();
    }

    ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private static <E> E[] c(int i2) {
        return new Object[i2];
    }

    public static <E> ProtobufArrayList<E> d() {
        return X2;
    }

    private void g(int i2) {
        if (i2 < 0 || i2 >= this.Z) {
            throw new IndexOutOfBoundsException(h(i2));
        }
    }

    private String h(int i2) {
        return "Index:" + i2 + ", Size:" + this.Z;
    }

    public void add(int i2, E e2) {
        int i3;
        b();
        if (i2 < 0 || i2 > (i3 = this.Z)) {
            throw new IndexOutOfBoundsException(h(i2));
        }
        E[] eArr = this.Y;
        if (i3 < eArr.length) {
            System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
        } else {
            E[] c2 = c(((i3 * 3) / 2) + 1);
            System.arraycopy(this.Y, 0, c2, 0, i2);
            System.arraycopy(this.Y, i2, c2, i2 + 1, this.Z - i2);
            this.Y = c2;
        }
        this.Y[i2] = e2;
        this.Z++;
        this.modCount++;
    }

    public E get(int i2) {
        g(i2);
        return this.Y[i2];
    }

    /* renamed from: j */
    public ProtobufArrayList<E> f(int i2) {
        if (i2 >= this.Z) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.Y, i2), this.Z);
        }
        throw new IllegalArgumentException();
    }

    public E remove(int i2) {
        b();
        g(i2);
        E[] eArr = this.Y;
        E e2 = eArr[i2];
        int i3 = this.Z;
        if (i2 < i3 - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.Z--;
        this.modCount++;
        return e2;
    }

    public E set(int i2, E e2) {
        b();
        g(i2);
        E[] eArr = this.Y;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        this.modCount++;
        return e3;
    }

    public int size() {
        return this.Z;
    }

    private ProtobufArrayList(E[] eArr, int i2) {
        this.Y = eArr;
        this.Z = i2;
    }

    public boolean add(E e2) {
        b();
        int i2 = this.Z;
        E[] eArr = this.Y;
        if (i2 == eArr.length) {
            this.Y = Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.Y;
        int i3 = this.Z;
        this.Z = i3 + 1;
        eArr2[i3] = e2;
        this.modCount++;
        return true;
    }
}
