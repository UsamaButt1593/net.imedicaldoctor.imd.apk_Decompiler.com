package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractTable<R, C, V> implements Table<R, C, V> {
    @CheckForNull
    @LazyInit
    private transient Collection<V> X;
    @CheckForNull
    @LazyInit
    private transient Set<Table.Cell<R, C, V>> s;

    class CellSet extends AbstractSet<Table.Cell<R, C, V>> {
        CellSet() {
        }

        public void clear() {
            AbstractTable.this.clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Map map = (Map) Maps.p0(AbstractTable.this.m(), cell.b());
            return map != null && Collections2.j(map.entrySet(), Maps.O(cell.a(), cell.getValue()));
        }

        public Iterator<Table.Cell<R, C, V>> iterator() {
            return AbstractTable.this.a();
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Map map = (Map) Maps.p0(AbstractTable.this.m(), cell.b());
            return map != null && Collections2.k(map.entrySet(), Maps.O(cell.a(), cell.getValue()));
        }

        public int size() {
            return AbstractTable.this.size();
        }
    }

    class Values extends AbstractCollection<V> {
        Values() {
        }

        public void clear() {
            AbstractTable.this.clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            return AbstractTable.this.containsValue(obj);
        }

        public Iterator<V> iterator() {
            return AbstractTable.this.d();
        }

        public int size() {
            return AbstractTable.this.size();
        }
    }

    AbstractTable() {
    }

    public void B0(Table<? extends R, ? extends C, ? extends V> table) {
        for (Table.Cell next : table.I()) {
            N(next.b(), next.a(), next.getValue());
        }
    }

    public boolean D(@CheckForNull Object obj) {
        return Maps.o0(J0(), obj);
    }

    public Set<Table.Cell<R, C, V>> I() {
        Set<Table.Cell<R, C, V>> set = this.s;
        if (set != null) {
            return set;
        }
        Set<Table.Cell<R, C, V>> b2 = b();
        this.s = b2;
        return b2;
    }

    public boolean I0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Map map = (Map) Maps.p0(m(), obj);
        return map != null && Maps.o0(map, obj2);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V N(@ParametricNullness R r, @ParametricNullness C c2, @ParametricNullness V v) {
        return P0(r).put(c2, v);
    }

    /* access modifiers changed from: package-private */
    public abstract Iterator<Table.Cell<R, C, V>> a();

    /* access modifiers changed from: package-private */
    public Set<Table.Cell<R, C, V>> b() {
        return new CellSet();
    }

    /* access modifiers changed from: package-private */
    public Collection<V> c() {
        return new Values();
    }

    public void clear() {
        Iterators.h(I().iterator());
    }

    public boolean containsValue(@CheckForNull Object obj) {
        for (Map containsValue : m().values()) {
            if (containsValue.containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> d() {
        return new TransformedIterator<Table.Cell<R, C, V>, V>(this, I().iterator()) {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            /* renamed from: b */
            public V a(Table.Cell<R, C, V> cell) {
                return cell.getValue();
            }
        };
    }

    public boolean equals(@CheckForNull Object obj) {
        return Tables.b(this, obj);
    }

    public int hashCode() {
        return I().hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set<C> j0() {
        return J0().keySet();
    }

    public boolean m0(@CheckForNull Object obj) {
        return Maps.o0(m(), obj);
    }

    public Set<R> n() {
        return m().keySet();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Map map = (Map) Maps.p0(m(), obj);
        if (map == null) {
            return null;
        }
        return Maps.q0(map, obj2);
    }

    public String toString() {
        return m().toString();
    }

    public Collection<V> values() {
        Collection<V> collection = this.X;
        if (collection != null) {
            return collection;
        }
        Collection<V> c2 = c();
        this.X = c2;
        return c2;
    }

    @CheckForNull
    public V z(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Map map = (Map) Maps.p0(m(), obj);
        if (map == null) {
            return null;
        }
        return Maps.p0(map, obj2);
    }
}
