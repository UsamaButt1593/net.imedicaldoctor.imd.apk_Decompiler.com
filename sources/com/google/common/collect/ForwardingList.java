package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    protected ForwardingList() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: E1 */
    public abstract List<E> a1();

    /* access modifiers changed from: protected */
    public boolean G1(@ParametricNullness E e2) {
        add(size(), e2);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean I1(int i2, Iterable<? extends E> iterable) {
        return Lists.a(this, i2, iterable);
    }

    /* access modifiers changed from: protected */
    public boolean J1(@CheckForNull Object obj) {
        return Lists.j(this, obj);
    }

    /* access modifiers changed from: protected */
    public int K1() {
        return Lists.k(this);
    }

    /* access modifiers changed from: protected */
    public int L1(@CheckForNull Object obj) {
        return Lists.l(this, obj);
    }

    /* access modifiers changed from: protected */
    public Iterator<E> M1() {
        return listIterator();
    }

    /* access modifiers changed from: protected */
    public int N1(@CheckForNull Object obj) {
        return Lists.n(this, obj);
    }

    /* access modifiers changed from: protected */
    public ListIterator<E> P1() {
        return listIterator(0);
    }

    /* access modifiers changed from: protected */
    public ListIterator<E> Q1(int i2) {
        return Lists.p(this, i2);
    }

    /* access modifiers changed from: protected */
    public List<E> V1(int i2, int i3) {
        return Lists.C(this, i2, i3);
    }

    public void add(int i2, @ParametricNullness E e2) {
        a1().add(i2, e2);
    }

    @CanIgnoreReturnValue
    public boolean addAll(int i2, Collection<? extends E> collection) {
        return a1().addAll(i2, collection);
    }

    public boolean equals(@CheckForNull Object obj) {
        return obj == this || a1().equals(obj);
    }

    @ParametricNullness
    public E get(int i2) {
        return a1().get(i2);
    }

    public int hashCode() {
        return a1().hashCode();
    }

    public int indexOf(@CheckForNull Object obj) {
        return a1().indexOf(obj);
    }

    public int lastIndexOf(@CheckForNull Object obj) {
        return a1().lastIndexOf(obj);
    }

    public ListIterator<E> listIterator() {
        return a1().listIterator();
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E remove(int i2) {
        return a1().remove(i2);
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E set(int i2, @ParametricNullness E e2) {
        return a1().set(i2, e2);
    }

    public List<E> subList(int i2, int i3) {
        return a1().subList(i2, i3);
    }

    public ListIterator<E> listIterator(int i2) {
        return a1().listIterator(i2);
    }
}
