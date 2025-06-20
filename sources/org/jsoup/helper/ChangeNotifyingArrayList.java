package org.jsoup.helper;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ChangeNotifyingArrayList<E> extends ArrayList<E> {
    public ChangeNotifyingArrayList(int i2) {
        super(i2);
    }

    public void add(int i2, E e2) {
        b();
        super.add(i2, e2);
    }

    public boolean addAll(int i2, Collection<? extends E> collection) {
        b();
        return super.addAll(i2, collection);
    }

    public abstract void b();

    public void clear() {
        b();
        super.clear();
    }

    public E remove(int i2) {
        b();
        return super.remove(i2);
    }

    public boolean removeAll(Collection<?> collection) {
        b();
        return super.removeAll(collection);
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i2, int i3) {
        b();
        super.removeRange(i2, i3);
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
