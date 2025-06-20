package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class DescendingImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    private final ImmutableSortedSet<E> a3;

    DescendingImmutableSortedSet(ImmutableSortedSet<E> immutableSortedSet) {
        super(Ordering.i(immutableSortedSet.comparator()).E());
        this.a3 = immutableSortedSet;
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> P0(E e2, boolean z, E e3, boolean z2) {
        return this.a3.subSet(e3, z2, e2, z).descendingSet();
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> U0(E e2, boolean z) {
        return this.a3.headSet(e2, z).descendingSet();
    }

    @CheckForNull
    public E ceiling(E e2) {
        return this.a3.floor(e2);
    }

    public boolean contains(@CheckForNull Object obj) {
        return this.a3.contains(obj);
    }

    @CheckForNull
    public E floor(E e2) {
        return this.a3.ceiling(e2);
    }

    @CheckForNull
    public E higher(E e2) {
        return this.a3.lower(e2);
    }

    /* access modifiers changed from: package-private */
    public int indexOf(@CheckForNull Object obj) {
        int indexOf = this.a3.indexOf(obj);
        return indexOf == -1 ? indexOf : (size() - 1) - indexOf;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.a3.j();
    }

    /* renamed from: k */
    public UnmodifiableIterator<E> iterator() {
        return this.a3.descendingIterator();
    }

    @CheckForNull
    public E lower(E e2) {
        return this.a3.higher(e2);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible("NavigableSet")
    public ImmutableSortedSet<E> p0() {
        throw new AssertionError("should never be called");
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: q0 */
    public UnmodifiableIterator<E> descendingIterator() {
        return this.a3.iterator();
    }

    public int size() {
        return this.a3.size();
    }

    @GwtIncompatible("NavigableSet")
    /* renamed from: t0 */
    public ImmutableSortedSet<E> descendingSet() {
        return this.a3;
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedSet<E> y0(E e2, boolean z) {
        return this.a3.tailSet(e2, z).descendingSet();
    }
}
