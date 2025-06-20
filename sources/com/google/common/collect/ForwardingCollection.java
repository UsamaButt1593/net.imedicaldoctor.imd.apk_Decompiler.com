package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    protected ForwardingCollection() {
    }

    /* access modifiers changed from: protected */
    public String B1() {
        return Collections2.l(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public abstract Collection<E> Z0();

    @CanIgnoreReturnValue
    public boolean add(@ParametricNullness E e2) {
        return Z0().add(e2);
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        return Z0().addAll(collection);
    }

    public void clear() {
        Z0().clear();
    }

    public boolean contains(@CheckForNull Object obj) {
        return Z0().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return Z0().containsAll(collection);
    }

    /* access modifiers changed from: protected */
    public boolean f1(Collection<? extends E> collection) {
        return Iterators.a(this, collection.iterator());
    }

    /* access modifiers changed from: protected */
    public void i1() {
        Iterators.h(iterator());
    }

    public boolean isEmpty() {
        return Z0().isEmpty();
    }

    public Iterator<E> iterator() {
        return Z0().iterator();
    }

    /* access modifiers changed from: protected */
    public boolean m1(@CheckForNull Object obj) {
        return Iterators.q(iterator(), obj);
    }

    /* access modifiers changed from: protected */
    public boolean n1(Collection<?> collection) {
        return Collections2.b(this, collection);
    }

    /* access modifiers changed from: protected */
    public boolean o1() {
        return !iterator().hasNext();
    }

    /* access modifiers changed from: protected */
    public boolean p1(@CheckForNull Object obj) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            if (Objects.a(it2.next(), obj)) {
                it2.remove();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean q1(Collection<?> collection) {
        return Iterators.V(iterator(), collection);
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj) {
        return Z0().remove(obj);
    }

    @CanIgnoreReturnValue
    public boolean removeAll(Collection<?> collection) {
        return Z0().removeAll(collection);
    }

    @CanIgnoreReturnValue
    public boolean retainAll(Collection<?> collection) {
        return Z0().retainAll(collection);
    }

    /* access modifiers changed from: protected */
    public boolean s1(Collection<?> collection) {
        return Iterators.X(iterator(), collection);
    }

    public int size() {
        return Z0().size();
    }

    public Object[] toArray() {
        return Z0().toArray();
    }

    /* access modifiers changed from: protected */
    public Object[] v1() {
        return toArray(new Object[size()]);
    }

    /* access modifiers changed from: protected */
    public <T> T[] x1(T[] tArr) {
        return ObjectArrays.m(this, tArr);
    }

    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return Z0().toArray(tArr);
    }
}
