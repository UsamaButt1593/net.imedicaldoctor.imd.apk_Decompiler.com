package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {
    @CheckForNull
    @LazyInit
    private transient Set<Multiset.Entry<E>> X;
    @CheckForNull
    @LazyInit
    private transient Set<E> s;

    class ElementSet extends Multisets.ElementSet<E> {
        ElementSet() {
        }

        /* access modifiers changed from: package-private */
        public Multiset<E> h() {
            return AbstractMultiset.this;
        }

        public Iterator<E> iterator() {
            return AbstractMultiset.this.g();
        }
    }

    class EntrySet extends Multisets.EntrySet<E> {
        EntrySet() {
        }

        /* access modifiers changed from: package-private */
        public Multiset<E> h() {
            return AbstractMultiset.this;
        }

        public Iterator<Multiset.Entry<E>> iterator() {
            return AbstractMultiset.this.h();
        }

        public int size() {
            return AbstractMultiset.this.d();
        }
    }

    AbstractMultiset() {
    }

    @CanIgnoreReturnValue
    public boolean D0(@ParametricNullness E e2, int i2, int i3) {
        return Multisets.w(this, e2, i2, i3);
    }

    @CanIgnoreReturnValue
    public int F(@CheckForNull Object obj, int i2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public int Q(@ParametricNullness E e2, int i2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public final boolean add(@ParametricNullness E e2) {
        Q(e2, 1);
        return true;
    }

    @CanIgnoreReturnValue
    public final boolean addAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    /* access modifiers changed from: package-private */
    public Set<E> b() {
        return new ElementSet();
    }

    /* access modifiers changed from: package-private */
    public Set<Multiset.Entry<E>> c() {
        return new EntrySet();
    }

    public abstract void clear();

    public boolean contains(@CheckForNull Object obj) {
        return l1(obj) > 0;
    }

    /* access modifiers changed from: package-private */
    public abstract int d();

    public Set<E> e() {
        Set<E> set = this.s;
        if (set != null) {
            return set;
        }
        Set<E> b2 = b();
        this.s = b2;
        return b2;
    }

    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.X;
        if (set != null) {
            return set;
        }
        Set<Multiset.Entry<E>> c2 = c();
        this.X = c2;
        return c2;
    }

    public final boolean equals(@CheckForNull Object obj) {
        return Multisets.i(this, obj);
    }

    /* access modifiers changed from: package-private */
    public abstract Iterator<E> g();

    /* access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> h();

    public final int hashCode() {
        return entrySet().hashCode();
    }

    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @CanIgnoreReturnValue
    public int r0(@ParametricNullness E e2, int i2) {
        return Multisets.v(this, e2, i2);
    }

    @CanIgnoreReturnValue
    public final boolean remove(@CheckForNull Object obj) {
        return F(obj, 1) > 0;
    }

    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> collection) {
        return Multisets.p(this, collection);
    }

    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> collection) {
        return Multisets.s(this, collection);
    }

    public final String toString() {
        return entrySet().toString();
    }
}
