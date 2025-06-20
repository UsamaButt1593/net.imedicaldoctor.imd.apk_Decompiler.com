package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Comparator;
import java.util.NavigableSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements SortedMultiset<E> {
    private static final long Y2 = 0;
    @CheckForNull
    @LazyInit
    private transient UnmodifiableSortedMultiset<E> X2;

    UnmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        super(sortedMultiset);
    }

    public SortedMultiset<E> D1(@ParametricNullness E e2, BoundType boundType) {
        return Multisets.B(a1().D1(e2, boundType));
    }

    public SortedMultiset<E> J2(@ParametricNullness E e2, BoundType boundType, @ParametricNullness E e3, BoundType boundType2) {
        return Multisets.B(a1().J2(e2, boundType, e3, boundType2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: V1 */
    public NavigableSet<E> Q1() {
        return Sets.O(a1().e());
    }

    /* access modifiers changed from: protected */
    /* renamed from: W1 */
    public SortedMultiset<E> a1() {
        return (SortedMultiset) super.a1();
    }

    public SortedMultiset<E> c0() {
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset = this.X2;
        if (unmodifiableSortedMultiset != null) {
            return unmodifiableSortedMultiset;
        }
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset2 = new UnmodifiableSortedMultiset<>(a1().c0());
        unmodifiableSortedMultiset2.X2 = this;
        this.X2 = unmodifiableSortedMultiset2;
        return unmodifiableSortedMultiset2;
    }

    public Comparator<? super E> comparator() {
        return a1().comparator();
    }

    public NavigableSet<E> e() {
        return (NavigableSet) super.e();
    }

    public SortedMultiset<E> e1(@ParametricNullness E e2, BoundType boundType) {
        return Multisets.B(a1().e1(e2, boundType));
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
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    public Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }
}
