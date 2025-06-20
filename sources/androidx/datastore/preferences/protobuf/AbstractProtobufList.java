package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class AbstractProtobufList<E> extends AbstractList<E> implements Internal.ProtobufList<E> {
    protected static final int X = 10;
    private boolean s = true;

    AbstractProtobufList() {
    }

    public boolean P2() {
        return this.s;
    }

    public final void S() {
        this.s = false;
    }

    public void add(int i2, E e2) {
        b();
        super.add(i2, e2);
    }

    public boolean addAll(int i2, Collection<? extends E> collection) {
        b();
        return super.addAll(i2, collection);
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (!this.s) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        b();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!get(i2).equals(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = (i2 * 31) + get(i3).hashCode();
        }
        return i2;
    }

    public E remove(int i2) {
        b();
        return super.remove(i2);
    }

    public boolean removeAll(Collection<?> collection) {
        b();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        b();
        return super.retainAll(collection);
    }

    public E set(int i2, E e2) {
        b();
        return super.set(i2, e2);
    }

    public boolean add(E e2) {
        b();
        return super.add(e2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        b();
        return super.addAll(collection);
    }

    public boolean remove(Object obj) {
        b();
        return super.remove(obj);
    }
}
