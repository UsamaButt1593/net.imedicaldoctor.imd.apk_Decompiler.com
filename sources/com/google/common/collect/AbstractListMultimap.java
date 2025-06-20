package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements ListMultimap<K, V> {
    private static final long b3 = 6588350623831699109L;

    protected AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> D(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> E(@ParametricNullness K k2, Collection<V> collection) {
        return F(k2, (List) collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public abstract List<V> u();

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public List<V> y() {
        return Collections.emptyList();
    }

    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public Map<K, Collection<V>> g() {
        return super.g();
    }

    @CanIgnoreReturnValue
    public boolean put(@ParametricNullness K k2, @ParametricNullness V v) {
        return super.put(k2, v);
    }

    @CanIgnoreReturnValue
    public List<V> b(@CheckForNull Object obj) {
        return (List) super.b(obj);
    }

    @CanIgnoreReturnValue
    public List<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        return (List) super.c(k2, iterable);
    }

    public List<V> get(@ParametricNullness K k2) {
        return (List) super.get(k2);
    }
}
