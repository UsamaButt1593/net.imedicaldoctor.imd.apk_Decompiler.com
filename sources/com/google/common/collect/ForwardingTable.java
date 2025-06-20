package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    protected ForwardingTable() {
    }

    public void B0(Table<? extends R, ? extends C, ? extends V> table) {
        Z0().B0(table);
    }

    public boolean D(@CheckForNull Object obj) {
        return Z0().D(obj);
    }

    public Map<R, V> E(@ParametricNullness C c2) {
        return Z0().E(c2);
    }

    public Set<Table.Cell<R, C, V>> I() {
        return Z0().I();
    }

    public boolean I0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return Z0().I0(obj, obj2);
    }

    public Map<C, Map<R, V>> J0() {
        return Z0().J0();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V N(@ParametricNullness R r, @ParametricNullness C c2, @ParametricNullness V v) {
        return Z0().N(r, c2, v);
    }

    public Map<C, V> P0(@ParametricNullness R r) {
        return Z0().P0(r);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public abstract Table<R, C, V> Z0();

    public void clear() {
        Z0().clear();
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return Z0().containsValue(obj);
    }

    public boolean equals(@CheckForNull Object obj) {
        return obj == this || Z0().equals(obj);
    }

    public int hashCode() {
        return Z0().hashCode();
    }

    public boolean isEmpty() {
        return Z0().isEmpty();
    }

    public Set<C> j0() {
        return Z0().j0();
    }

    public Map<R, Map<C, V>> m() {
        return Z0().m();
    }

    public boolean m0(@CheckForNull Object obj) {
        return Z0().m0(obj);
    }

    public Set<R> n() {
        return Z0().n();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return Z0().remove(obj, obj2);
    }

    public int size() {
        return Z0().size();
    }

    public Collection<V> values() {
        return Z0().values();
    }

    @CheckForNull
    public V z(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return Z0().z(obj, obj2);
    }
}
