package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements SetMultimap<K, V> {
    private static final long b3 = 7431625294878419160L;

    protected AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> D(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> E(@ParametricNullness K k2, Collection<V> collection) {
        return new AbstractMapBasedMultimap.WrappedSet(k2, (Set) collection);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public abstract Set<V> u();

    /* access modifiers changed from: package-private */
    /* renamed from: I */
    public Set<V> y() {
        return Collections.emptySet();
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
    public Set<V> b(@CheckForNull Object obj) {
        return (Set) super.b(obj);
    }

    @CanIgnoreReturnValue
    public Set<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        return (Set) super.c(k2, iterable);
    }

    public Set<V> get(@ParametricNullness K k2) {
        return (Set) super.get(k2);
    }

    public Set<Map.Entry<K, V>> j() {
        return (Set) super.j();
    }
}
