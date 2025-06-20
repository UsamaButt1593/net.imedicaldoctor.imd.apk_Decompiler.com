package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    protected class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet(ForwardingNavigableSet forwardingNavigableSet) {
            super(forwardingNavigableSet);
        }
    }

    protected ForwardingNavigableSet() {
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> K1(@ParametricNullness E e2, @ParametricNullness E e3) {
        return subSet(e2, true, e3, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: L1 */
    public abstract NavigableSet<E> a1();

    /* access modifiers changed from: protected */
    @CheckForNull
    public E M1(@ParametricNullness E e2) {
        return Iterators.J(tailSet(e2, true).iterator(), null);
    }

    /* access modifiers changed from: protected */
    @ParametricNullness
    public E N1() {
        return iterator().next();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E P1(@ParametricNullness E e2) {
        return Iterators.J(headSet(e2, true).descendingIterator(), null);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> Q1(@ParametricNullness E e2) {
        return headSet(e2, false);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E V1(@ParametricNullness E e2) {
        return Iterators.J(tailSet(e2, false).iterator(), null);
    }

    /* access modifiers changed from: protected */
    @ParametricNullness
    public E W1() {
        return descendingIterator().next();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E X1(@ParametricNullness E e2) {
        return Iterators.J(headSet(e2, false).descendingIterator(), null);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E Y1() {
        return Iterators.U(iterator());
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E Z1() {
        return Iterators.U(descendingIterator());
    }

    /* access modifiers changed from: protected */
    public NavigableSet<E> c2(@ParametricNullness E e2, boolean z, @ParametricNullness E e3, boolean z2) {
        return tailSet(e2, z).headSet(e3, z2);
    }

    @CheckForNull
    public E ceiling(@ParametricNullness E e2) {
        return a1().ceiling(e2);
    }

    public Iterator<E> descendingIterator() {
        return a1().descendingIterator();
    }

    public NavigableSet<E> descendingSet() {
        return a1().descendingSet();
    }

    @CheckForNull
    public E floor(@ParametricNullness E e2) {
        return a1().floor(e2);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> h2(@ParametricNullness E e2) {
        return tailSet(e2, true);
    }

    public NavigableSet<E> headSet(@ParametricNullness E e2, boolean z) {
        return a1().headSet(e2, z);
    }

    @CheckForNull
    public E higher(@ParametricNullness E e2) {
        return a1().higher(e2);
    }

    @CheckForNull
    public E lower(@ParametricNullness E e2) {
        return a1().lower(e2);
    }

    @CheckForNull
    public E pollFirst() {
        return a1().pollFirst();
    }

    @CheckForNull
    public E pollLast() {
        return a1().pollLast();
    }

    public NavigableSet<E> subSet(@ParametricNullness E e2, boolean z, @ParametricNullness E e3, boolean z2) {
        return a1().subSet(e2, z, e3, z2);
    }

    public NavigableSet<E> tailSet(@ParametricNullness E e2, boolean z) {
        return a1().tailSet(e2, z);
    }
}
