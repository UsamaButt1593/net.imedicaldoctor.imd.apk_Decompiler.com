package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {

    protected abstract class StandardEntrySet extends Maps.EntrySet<K, V> {
        protected StandardEntrySet() {
        }

        /* access modifiers changed from: package-private */
        public Map<K, V> h() {
            return ForwardingMap.this;
        }
    }

    protected class StandardKeySet extends Maps.KeySet<K, V> {
        public StandardKeySet(ForwardingMap forwardingMap) {
            super(forwardingMap);
        }
    }

    protected class StandardValues extends Maps.Values<K, V> {
        public StandardValues(ForwardingMap forwardingMap) {
            super(forwardingMap);
        }
    }

    protected ForwardingMap() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public abstract Map<K, V> Z0();

    public void clear() {
        Z0().clear();
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return Z0().containsKey(obj);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return Z0().containsValue(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return Z0().entrySet();
    }

    public boolean equals(@CheckForNull Object obj) {
        return obj == this || Z0().equals(obj);
    }

    /* access modifiers changed from: protected */
    public void f1() {
        Iterators.h(entrySet().iterator());
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        return Z0().get(obj);
    }

    public int hashCode() {
        return Z0().hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean i1(@CheckForNull Object obj) {
        return Maps.q(this, obj);
    }

    public boolean isEmpty() {
        return Z0().isEmpty();
    }

    public Set<K> keySet() {
        return Z0().keySet();
    }

    /* access modifiers changed from: protected */
    public boolean m1(@CheckForNull Object obj) {
        return Maps.r(this, obj);
    }

    /* access modifiers changed from: protected */
    public boolean n1(@CheckForNull Object obj) {
        return Maps.w(this, obj);
    }

    /* access modifiers changed from: protected */
    public int o1() {
        return Sets.k(entrySet());
    }

    /* access modifiers changed from: protected */
    public boolean p1() {
        return !entrySet().iterator().hasNext();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@ParametricNullness K k2, @ParametricNullness V v) {
        return Z0().put(k2, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        Z0().putAll(map);
    }

    /* access modifiers changed from: protected */
    public void q1(Map<? extends K, ? extends V> map) {
        Maps.j0(this, map);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        return Z0().remove(obj);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public V s1(@CheckForNull Object obj) {
        Iterator it2 = entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            if (Objects.a(entry.getKey(), obj)) {
                V value = entry.getValue();
                it2.remove();
                return value;
            }
        }
        return null;
    }

    public int size() {
        return Z0().size();
    }

    /* access modifiers changed from: protected */
    public String v1() {
        return Maps.w0(this);
    }

    public Collection<V> values() {
        return Z0().values();
    }
}
