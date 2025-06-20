package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public interface SortedMultiset<E> extends SortedMultisetBridge<E>, SortedIterable<E> {
    SortedMultiset<E> D1(@ParametricNullness E e2, BoundType boundType);

    SortedMultiset<E> J2(@ParametricNullness E e2, BoundType boundType, @ParametricNullness E e3, BoundType boundType2);

    SortedMultiset<E> c0();

    Comparator<? super E> comparator();

    NavigableSet<E> e();

    /* bridge */ /* synthetic */ Set e();

    /* bridge */ /* synthetic */ SortedSet e();

    SortedMultiset<E> e1(@ParametricNullness E e2, BoundType boundType);

    Set<Multiset.Entry<E>> entrySet();

    @CheckForNull
    Multiset.Entry<E> firstEntry();

    Iterator<E> iterator();

    @CheckForNull
    Multiset.Entry<E> lastEntry();

    @CheckForNull
    Multiset.Entry<E> pollFirstEntry();

    @CheckForNull
    Multiset.Entry<E> pollLastEntry();
}
