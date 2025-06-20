package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    protected class StandardKeySet extends Maps.SortedKeySet<K, V> {
        public StandardKeySet(ForwardingSortedMap forwardingSortedMap) {
            super(forwardingSortedMap);
        }
    }

    protected ForwardingSortedMap() {
    }

    static int E1(@CheckForNull Comparator<?> comparator, @CheckForNull Object obj, @CheckForNull Object obj2) {
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> B1(K k2, K k3) {
        Preconditions.e(E1(comparator(), k2, k3) <= 0, "fromKey must be <= toKey");
        return tailMap(k2).headMap(k3);
    }

    @CheckForNull
    public Comparator<? super K> comparator() {
        return a1().comparator();
    }

    @ParametricNullness
    public K firstKey() {
        return a1().firstKey();
    }

    public SortedMap<K, V> headMap(@ParametricNullness K k2) {
        return a1().headMap(k2);
    }

    /* access modifiers changed from: protected */
    public boolean i1(@CheckForNull Object obj) {
        try {
            return E1(comparator(), tailMap(obj).firstKey(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    @ParametricNullness
    public K lastKey() {
        return a1().lastKey();
    }

    public SortedMap<K, V> subMap(@ParametricNullness K k2, @ParametricNullness K k3) {
        return a1().subMap(k2, k3);
    }

    public SortedMap<K, V> tailMap(@ParametricNullness K k2) {
        return a1().tailMap(k2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x1 */
    public abstract SortedMap<K, V> a1();
}
