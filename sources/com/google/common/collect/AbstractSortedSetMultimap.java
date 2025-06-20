package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractSortedSetMultimap<K, V> extends AbstractSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    private static final long c3 = 430848587173315748L;

    protected AbstractSortedSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> E(@ParametricNullness K k2, Collection<V> collection) {
        return collection instanceof NavigableSet ? new AbstractMapBasedMultimap.WrappedNavigableSet(k2, (NavigableSet) collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null) : new AbstractMapBasedMultimap.WrappedSortedSet(k2, (SortedSet) collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public abstract SortedSet<V> u();

    /* access modifiers changed from: package-private */
    /* renamed from: K */
    public SortedSet<V> y() {
        return D(u());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: L */
    public <E> SortedSet<E> D(Collection<E> collection) {
        return collection instanceof NavigableSet ? Sets.O((NavigableSet) collection) : Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    public Map<K, Collection<V>> g() {
        return super.g();
    }

    public Collection<V> values() {
        return super.values();
    }

    @CanIgnoreReturnValue
    public SortedSet<V> b(@CheckForNull Object obj) {
        return (SortedSet) super.b(obj);
    }

    @CanIgnoreReturnValue
    public SortedSet<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        return (SortedSet) super.c((Object) k2, (Iterable) iterable);
    }

    public SortedSet<V> get(@ParametricNullness K k2) {
        return (SortedSet) super.get((Object) k2);
    }
}
