package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.annotations.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long X = 3972397474470203923L;
    final ArrayList<T> s;

    public VolatileSizeArrayList() {
        this.s = new ArrayList<>();
    }

    public void add(int i2, T t) {
        this.s.add(i2, t);
        lazySet(this.s.size());
    }

    public boolean addAll(int i2, @NonNull Collection<? extends T> collection) {
        boolean addAll = this.s.addAll(i2, collection);
        lazySet(this.s.size());
        return addAll;
    }

    public void clear() {
        this.s.clear();
        lazySet(0);
    }

    public boolean contains(Object obj) {
        return this.s.contains(obj);
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.s.containsAll(collection);
    }

    public boolean equals(Object obj) {
        ArrayList<T> arrayList;
        if (obj instanceof VolatileSizeArrayList) {
            arrayList = this.s;
            obj = ((VolatileSizeArrayList) obj).s;
        } else {
            arrayList = this.s;
        }
        return arrayList.equals(obj);
    }

    public T get(int i2) {
        return this.s.get(i2);
    }

    public int hashCode() {
        return this.s.hashCode();
    }

    public int indexOf(Object obj) {
        return this.s.indexOf(obj);
    }

    public boolean isEmpty() {
        return get() == 0;
    }

    public Iterator<T> iterator() {
        return this.s.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.s.lastIndexOf(obj);
    }

    public ListIterator<T> listIterator() {
        return this.s.listIterator();
    }

    public T remove(int i2) {
        T remove = this.s.remove(i2);
        lazySet(this.s.size());
        return remove;
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        boolean removeAll = this.s.removeAll(collection);
        lazySet(this.s.size());
        return removeAll;
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean retainAll = this.s.retainAll(collection);
        lazySet(this.s.size());
        return retainAll;
    }

    public T set(int i2, T t) {
        return this.s.set(i2, t);
    }

    public int size() {
        return get();
    }

    public List<T> subList(int i2, int i3) {
        return this.s.subList(i2, i3);
    }

    public Object[] toArray() {
        return this.s.toArray();
    }

    public String toString() {
        return this.s.toString();
    }

    public VolatileSizeArrayList(int i2) {
        this.s = new ArrayList<>(i2);
    }

    public boolean add(T t) {
        boolean add = this.s.add(t);
        lazySet(this.s.size());
        return add;
    }

    public boolean addAll(@NonNull Collection<? extends T> collection) {
        boolean addAll = this.s.addAll(collection);
        lazySet(this.s.size());
        return addAll;
    }

    public ListIterator<T> listIterator(int i2) {
        return this.s.listIterator(i2);
    }

    public boolean remove(Object obj) {
        boolean remove = this.s.remove(obj);
        lazySet(this.s.size());
        return remove;
    }

    public <E> E[] toArray(@NonNull E[] eArr) {
        return this.s.toArray(eArr);
    }
}
