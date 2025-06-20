package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultisets;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class AbstractSortedMultiset<E> extends AbstractMultiset<E> implements SortedMultiset<E> {
    @GwtTransient
    final Comparator<? super E> Y;
    @CheckForNull
    @LazyInit
    private transient SortedMultiset<E> Z;

    AbstractSortedMultiset() {
        this(Ordering.z());
    }

    public SortedMultiset<E> J2(@ParametricNullness E e2, BoundType boundType, @ParametricNullness E e3, BoundType boundType2) {
        Preconditions.E(boundType);
        Preconditions.E(boundType2);
        return D1(e2, boundType).e1(e3, boundType2);
    }

    public SortedMultiset<E> c0() {
        SortedMultiset<E> sortedMultiset = this.Z;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        SortedMultiset<E> j2 = j();
        this.Z = j2;
        return j2;
    }

    public Comparator<? super E> comparator() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    public Iterator<E> descendingIterator() {
        return Multisets.n(c0());
    }

    public NavigableSet<E> e() {
        return (NavigableSet) super.e();
    }

    @CheckForNull
    public Multiset.Entry<E> firstEntry() {
        Iterator h2 = h();
        if (h2.hasNext()) {
            return (Multiset.Entry) h2.next();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public SortedMultiset<E> j() {
        return new DescendingMultiset<E>() {
            /* access modifiers changed from: package-private */
            public Iterator<Multiset.Entry<E>> V1() {
                return AbstractSortedMultiset.this.m();
            }

            /* access modifiers changed from: package-private */
            public SortedMultiset<E> W1() {
                return AbstractSortedMultiset.this;
            }

            public Iterator<E> iterator() {
                return AbstractSortedMultiset.this.descendingIterator();
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public NavigableSet<E> b() {
        return new SortedMultisets.NavigableElementSet(this);
    }

    @CheckForNull
    public Multiset.Entry<E> lastEntry() {
        Iterator m2 = m();
        if (m2.hasNext()) {
            return (Multiset.Entry) m2.next();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> m();

    @CheckForNull
    public Multiset.Entry<E> pollFirstEntry() {
        Iterator h2 = h();
        if (!h2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) h2.next();
        Multiset.Entry<E> k2 = Multisets.k(entry.a(), entry.getCount());
        h2.remove();
        return k2;
    }

    @CheckForNull
    public Multiset.Entry<E> pollLastEntry() {
        Iterator m2 = m();
        if (!m2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) m2.next();
        Multiset.Entry<E> k2 = Multisets.k(entry.a(), entry.getCount());
        m2.remove();
        return k2;
    }

    AbstractSortedMultiset(Comparator<? super E> comparator) {
        this.Y = (Comparator) Preconditions.E(comparator);
    }
}
