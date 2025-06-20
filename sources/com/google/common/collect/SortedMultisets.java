package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class SortedMultisets {

    static class ElementSet<E> extends Multisets.ElementSet<E> implements SortedSet<E> {
        @Weak
        private final SortedMultiset<E> s;

        ElementSet(SortedMultiset<E> sortedMultiset) {
            this.s = sortedMultiset;
        }

        public Comparator<? super E> comparator() {
            return h().comparator();
        }

        @ParametricNullness
        public E first() {
            return SortedMultisets.d(h().firstEntry());
        }

        public SortedSet<E> headSet(@ParametricNullness E e2) {
            return h().e1(e2, BoundType.OPEN).e();
        }

        public Iterator<E> iterator() {
            return Multisets.h(h().entrySet().iterator());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public final SortedMultiset<E> h() {
            return this.s;
        }

        @ParametricNullness
        public E last() {
            return SortedMultisets.d(h().lastEntry());
        }

        public SortedSet<E> subSet(@ParametricNullness E e2, @ParametricNullness E e3) {
            return h().J2(e2, BoundType.CLOSED, e3, BoundType.OPEN).e();
        }

        public SortedSet<E> tailSet(@ParametricNullness E e2) {
            return h().D1(e2, BoundType.CLOSED).e();
        }
    }

    @GwtIncompatible
    static class NavigableElementSet<E> extends ElementSet<E> implements NavigableSet<E> {
        NavigableElementSet(SortedMultiset<E> sortedMultiset) {
            super(sortedMultiset);
        }

        @CheckForNull
        public E ceiling(@ParametricNullness E e2) {
            return SortedMultisets.c(h().D1(e2, BoundType.CLOSED).firstEntry());
        }

        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<E> descendingSet() {
            return new NavigableElementSet(h().c0());
        }

        @CheckForNull
        public E floor(@ParametricNullness E e2) {
            return SortedMultisets.c(h().e1(e2, BoundType.CLOSED).lastEntry());
        }

        public NavigableSet<E> headSet(@ParametricNullness E e2, boolean z) {
            return new NavigableElementSet(h().e1(e2, BoundType.b(z)));
        }

        @CheckForNull
        public E higher(@ParametricNullness E e2) {
            return SortedMultisets.c(h().D1(e2, BoundType.OPEN).firstEntry());
        }

        @CheckForNull
        public E lower(@ParametricNullness E e2) {
            return SortedMultisets.c(h().e1(e2, BoundType.OPEN).lastEntry());
        }

        @CheckForNull
        public E pollFirst() {
            return SortedMultisets.c(h().pollFirstEntry());
        }

        @CheckForNull
        public E pollLast() {
            return SortedMultisets.c(h().pollLastEntry());
        }

        public NavigableSet<E> subSet(@ParametricNullness E e2, boolean z, @ParametricNullness E e3, boolean z2) {
            return new NavigableElementSet(h().J2(e2, BoundType.b(z), e3, BoundType.b(z2)));
        }

        public NavigableSet<E> tailSet(@ParametricNullness E e2, boolean z) {
            return new NavigableElementSet(h().D1(e2, BoundType.b(z)));
        }
    }

    private SortedMultisets() {
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public static <E> E c(@CheckForNull Multiset.Entry<E> entry) {
        if (entry == null) {
            return null;
        }
        return entry.a();
    }

    /* access modifiers changed from: private */
    public static <E> E d(@CheckForNull Multiset.Entry<E> entry) {
        if (entry != null) {
            return entry.a();
        }
        throw new NoSuchElementException();
    }
}
