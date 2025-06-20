package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SortedMultisets;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class DescendingMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {
    @CheckForNull
    @LazyInit
    private transient NavigableSet<E> X;
    @CheckForNull
    @LazyInit
    private transient Set<Multiset.Entry<E>> Y;
    @CheckForNull
    @LazyInit
    private transient Comparator<? super E> s;

    DescendingMultiset() {
    }

    public SortedMultiset<E> D1(@ParametricNullness E e2, BoundType boundType) {
        return W1().e1(e2, boundType).c0();
    }

    /* access modifiers changed from: protected */
    /* renamed from: E1 */
    public Multiset<E> a1() {
        return W1();
    }

    public SortedMultiset<E> J2(@ParametricNullness E e2, BoundType boundType, @ParametricNullness E e3, BoundType boundType2) {
        return W1().J2(e3, boundType2, e2, boundType).c0();
    }

    /* access modifiers changed from: package-private */
    public Set<Multiset.Entry<E>> Q1() {
        return new Multisets.EntrySet<E>() {
            /* access modifiers changed from: package-private */
            public Multiset<E> h() {
                return DescendingMultiset.this;
            }

            public Iterator<Multiset.Entry<E>> iterator() {
                return DescendingMultiset.this.V1();
            }

            public int size() {
                return DescendingMultiset.this.W1().entrySet().size();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> V1();

    /* access modifiers changed from: package-private */
    public abstract SortedMultiset<E> W1();

    public SortedMultiset<E> c0() {
        return W1();
    }

    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.s;
        if (comparator != null) {
            return comparator;
        }
        Ordering E = Ordering.i(W1().comparator()).E();
        this.s = E;
        return E;
    }

    public NavigableSet<E> e() {
        NavigableSet<E> navigableSet = this.X;
        if (navigableSet != null) {
            return navigableSet;
        }
        SortedMultisets.NavigableElementSet navigableElementSet = new SortedMultisets.NavigableElementSet(this);
        this.X = navigableElementSet;
        return navigableElementSet;
    }

    public SortedMultiset<E> e1(@ParametricNullness E e2, BoundType boundType) {
        return W1().D1(e2, boundType).c0();
    }

    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.Y;
        if (set != null) {
            return set;
        }
        Set<Multiset.Entry<E>> Q1 = Q1();
        this.Y = Q1;
        return Q1;
    }

    @CheckForNull
    public Multiset.Entry<E> firstEntry() {
        return W1().lastEntry();
    }

    public Iterator<E> iterator() {
        return Multisets.n(this);
    }

    @CheckForNull
    public Multiset.Entry<E> lastEntry() {
        return W1().firstEntry();
    }

    @CheckForNull
    public Multiset.Entry<E> pollFirstEntry() {
        return W1().pollLastEntry();
    }

    @CheckForNull
    public Multiset.Entry<E> pollLastEntry() {
        return W1().pollFirstEntry();
    }

    public Object[] toArray() {
        return v1();
    }

    public String toString() {
        return entrySet().toString();
    }

    public <T> T[] toArray(T[] tArr) {
        return x1(tArr);
    }
}
