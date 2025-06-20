package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

    protected abstract class StandardDescendingMultiset extends DescendingMultiset<E> {
        public StandardDescendingMultiset() {
        }

        /* access modifiers changed from: package-private */
        public SortedMultiset<E> W1() {
            return ForwardingSortedMultiset.this;
        }
    }

    protected class StandardElementSet extends SortedMultisets.NavigableElementSet<E> {
        public StandardElementSet(ForwardingSortedMultiset forwardingSortedMultiset) {
            super(forwardingSortedMultiset);
        }
    }

    protected ForwardingSortedMultiset() {
    }

    public SortedMultiset<E> D1(@ParametricNullness E e2, BoundType boundType) {
        return a1().D1(e2, boundType);
    }

    public SortedMultiset<E> J2(@ParametricNullness E e2, BoundType boundType, @ParametricNullness E e3, BoundType boundType2) {
        return a1().J2(e2, boundType, e3, boundType2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: Q1 */
    public abstract SortedMultiset<E> a1();

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> V1() {
        Iterator it2 = entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it2.next();
        return Multisets.k(entry.a(), entry.getCount());
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> W1() {
        Iterator it2 = c0().entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it2.next();
        return Multisets.k(entry.a(), entry.getCount());
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> X1() {
        Iterator it2 = entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it2.next();
        Multiset.Entry<E> k2 = Multisets.k(entry.a(), entry.getCount());
        it2.remove();
        return k2;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Multiset.Entry<E> Y1() {
        Iterator it2 = c0().entrySet().iterator();
        if (!it2.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it2.next();
        Multiset.Entry<E> k2 = Multisets.k(entry.a(), entry.getCount());
        it2.remove();
        return k2;
    }

    /* access modifiers changed from: protected */
    public SortedMultiset<E> Z1(@ParametricNullness E e2, BoundType boundType, @ParametricNullness E e3, BoundType boundType2) {
        return D1(e2, boundType).e1(e3, boundType2);
    }

    public SortedMultiset<E> c0() {
        return a1().c0();
    }

    public Comparator<? super E> comparator() {
        return a1().comparator();
    }

    public NavigableSet<E> e() {
        return a1().e();
    }

    public SortedMultiset<E> e1(@ParametricNullness E e2, BoundType boundType) {
        return a1().e1(e2, boundType);
    }

    @CheckForNull
    public Multiset.Entry<E> firstEntry() {
        return a1().firstEntry();
    }

    @CheckForNull
    public Multiset.Entry<E> lastEntry() {
        return a1().lastEntry();
    }

    @CheckForNull
    public Multiset.Entry<E> pollFirstEntry() {
        return a1().pollFirstEntry();
    }

    @CheckForNull
    public Multiset.Entry<E> pollLastEntry() {
        return a1().pollLastEntry();
    }
}
