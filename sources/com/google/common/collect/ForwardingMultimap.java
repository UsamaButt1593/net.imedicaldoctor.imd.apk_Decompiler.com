package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMultimap<K, V> extends ForwardingObject implements Multimap<K, V> {
    protected ForwardingMultimap() {
    }

    public boolean N0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return Z0().N0(obj, obj2);
    }

    @CanIgnoreReturnValue
    public boolean T0(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        return Z0().T0(k2, iterable);
    }

    @CanIgnoreReturnValue
    public boolean Z(Multimap<? extends K, ? extends V> multimap) {
        return Z0().Z(multimap);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public abstract Multimap<K, V> Z0();

    @CanIgnoreReturnValue
    public Collection<V> b(@CheckForNull Object obj) {
        return Z0().b(obj);
    }

    @CanIgnoreReturnValue
    public Collection<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        return Z0().c(k2, iterable);
    }

    public void clear() {
        Z0().clear();
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return Z0().containsKey(obj);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return Z0().containsValue(obj);
    }

    public Multiset<K> d0() {
        return Z0().d0();
    }

    public boolean equals(@CheckForNull Object obj) {
        return obj == this || Z0().equals(obj);
    }

    public Map<K, Collection<V>> g() {
        return Z0().g();
    }

    public Collection<V> get(@ParametricNullness K k2) {
        return Z0().get(k2);
    }

    public int hashCode() {
        return Z0().hashCode();
    }

    public boolean isEmpty() {
        return Z0().isEmpty();
    }

    public Collection<Map.Entry<K, V>> j() {
        return Z0().j();
    }

    public Set<K> keySet() {
        return Z0().keySet();
    }

    @CanIgnoreReturnValue
    public boolean put(@ParametricNullness K k2, @ParametricNullness V v) {
        return Z0().put(k2, v);
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return Z0().remove(obj, obj2);
    }

    public int size() {
        return Z0().size();
    }

    public Collection<V> values() {
        return Z0().values();
    }
}
