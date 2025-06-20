package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Tables {

    /* renamed from: a  reason: collision with root package name */
    private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> f22497a = new Function<Map<Object, Object>, Map<Object, Object>>() {
        /* renamed from: a */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    };

    static abstract class AbstractCell<R, C, V> implements Table.Cell<R, C, V> {
        AbstractCell() {
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            return Objects.a(b(), cell.b()) && Objects.a(a(), cell.a()) && Objects.a(getValue(), cell.getValue());
        }

        public int hashCode() {
            return Objects.b(b(), a(), getValue());
        }

        public String toString() {
            return "(" + b() + "," + a() + ")=" + getValue();
        }
    }

    static final class ImmutableCell<R, C, V> extends AbstractCell<R, C, V> implements Serializable {
        private static final long Z = 0;
        @ParametricNullness
        private final C X;
        @ParametricNullness
        private final V Y;
        @ParametricNullness
        private final R s;

        ImmutableCell(@ParametricNullness R r, @ParametricNullness C c2, @ParametricNullness V v) {
            this.s = r;
            this.X = c2;
            this.Y = v;
        }

        @ParametricNullness
        public C a() {
            return this.X;
        }

        @ParametricNullness
        public R b() {
            return this.s;
        }

        @ParametricNullness
        public V getValue() {
            return this.Y;
        }
    }

    private static class TransformedTable<R, C, V1, V2> extends AbstractTable<R, C, V2> {
        final Table<R, C, V1> Y;
        final Function<? super V1, V2> Z;

        TransformedTable(Table<R, C, V1> table, Function<? super V1, V2> function) {
            this.Y = (Table) Preconditions.E(table);
            this.Z = (Function) Preconditions.E(function);
        }

        public void B0(Table<? extends R, ? extends C, ? extends V2> table) {
            throw new UnsupportedOperationException();
        }

        public Map<R, V2> E(@ParametricNullness C c2) {
            return Maps.B0(this.Y.E(c2), this.Z);
        }

        public boolean I0(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.Y.I0(obj, obj2);
        }

        public Map<C, Map<R, V2>> J0() {
            return Maps.B0(this.Y.J0(), new Function<Map<R, V1>, Map<R, V2>>() {
                /* renamed from: a */
                public Map<R, V2> apply(Map<R, V1> map) {
                    return Maps.B0(map, TransformedTable.this.Z);
                }
            });
        }

        @CheckForNull
        public V2 N(@ParametricNullness R r, @ParametricNullness C c2, @ParametricNullness V2 v2) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V2> P0(@ParametricNullness R r) {
            return Maps.B0(this.Y.P0(r), this.Z);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Table.Cell<R, C, V2>> a() {
            return Iterators.c0(this.Y.I().iterator(), e());
        }

        /* access modifiers changed from: package-private */
        public Collection<V2> c() {
            return Collections2.m(this.Y.values(), this.Z);
        }

        public void clear() {
            this.Y.clear();
        }

        /* access modifiers changed from: package-private */
        public Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> e() {
            return new Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>>() {
                /* renamed from: a */
                public Table.Cell<R, C, V2> apply(Table.Cell<R, C, V1> cell) {
                    return Tables.c(cell.b(), cell.a(), TransformedTable.this.Z.apply(cell.getValue()));
                }
            };
        }

        public Set<C> j0() {
            return this.Y.j0();
        }

        public Map<R, Map<C, V2>> m() {
            return Maps.B0(this.Y.m(), new Function<Map<C, V1>, Map<C, V2>>() {
                /* renamed from: a */
                public Map<C, V2> apply(Map<C, V1> map) {
                    return Maps.B0(map, TransformedTable.this.Z);
                }
            });
        }

        public Set<R> n() {
            return this.Y.n();
        }

        @CheckForNull
        public V2 remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            if (I0(obj, obj2)) {
                return this.Z.apply(NullnessCasts.a(this.Y.remove(obj, obj2)));
            }
            return null;
        }

        public int size() {
            return this.Y.size();
        }

        @CheckForNull
        public V2 z(@CheckForNull Object obj, @CheckForNull Object obj2) {
            if (I0(obj, obj2)) {
                return this.Z.apply(NullnessCasts.a(this.Y.z(obj, obj2)));
            }
            return null;
        }
    }

    private static class TransposeTable<C, R, V> extends AbstractTable<C, R, V> {
        private static final Function Z = new Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>>() {
            /* renamed from: a */
            public Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> cell) {
                return Tables.c(cell.a(), cell.b(), cell.getValue());
            }
        };
        final Table<R, C, V> Y;

        TransposeTable(Table<R, C, V> table) {
            this.Y = (Table) Preconditions.E(table);
        }

        public void B0(Table<? extends C, ? extends R, ? extends V> table) {
            this.Y.B0(Tables.g(table));
        }

        public boolean D(@CheckForNull Object obj) {
            return this.Y.m0(obj);
        }

        public Map<C, V> E(@ParametricNullness R r) {
            return this.Y.P0(r);
        }

        public boolean I0(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.Y.I0(obj2, obj);
        }

        public Map<R, Map<C, V>> J0() {
            return this.Y.m();
        }

        @CheckForNull
        public V N(@ParametricNullness C c2, @ParametricNullness R r, @ParametricNullness V v) {
            return this.Y.N(r, c2, v);
        }

        public Map<R, V> P0(@ParametricNullness C c2) {
            return this.Y.E(c2);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Table.Cell<C, R, V>> a() {
            return Iterators.c0(this.Y.I().iterator(), Z);
        }

        public void clear() {
            this.Y.clear();
        }

        public boolean containsValue(@CheckForNull Object obj) {
            return this.Y.containsValue(obj);
        }

        public Set<R> j0() {
            return this.Y.n();
        }

        public Map<C, Map<R, V>> m() {
            return this.Y.J0();
        }

        public boolean m0(@CheckForNull Object obj) {
            return this.Y.D(obj);
        }

        public Set<C> n() {
            return this.Y.j0();
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.Y.remove(obj2, obj);
        }

        public int size() {
            return this.Y.size();
        }

        public Collection<V> values() {
            return this.Y.values();
        }

        @CheckForNull
        public V z(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.Y.z(obj2, obj);
        }
    }

    static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements RowSortedTable<R, C, V> {
        private static final long Y = 0;

        public UnmodifiableRowSortedMap(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
            super(rowSortedTable);
        }

        /* access modifiers changed from: protected */
        /* renamed from: f1 */
        public RowSortedTable<R, C, V> a1() {
            return (RowSortedTable) super.Z0();
        }

        public SortedMap<R, Map<C, V>> m() {
            return Collections.unmodifiableSortedMap(Maps.D0(a1().m(), Tables.j()));
        }

        public SortedSet<R> n() {
            return Collections.unmodifiableSortedSet(a1().n());
        }
    }

    private static class UnmodifiableTable<R, C, V> extends ForwardingTable<R, C, V> implements Serializable {
        private static final long X = 0;
        final Table<? extends R, ? extends C, ? extends V> s;

        UnmodifiableTable(Table<? extends R, ? extends C, ? extends V> table) {
            this.s = (Table) Preconditions.E(table);
        }

        public void B0(Table<? extends R, ? extends C, ? extends V> table) {
            throw new UnsupportedOperationException();
        }

        public Map<R, V> E(@ParametricNullness C c2) {
            return Collections.unmodifiableMap(super.E(c2));
        }

        public Set<Table.Cell<R, C, V>> I() {
            return Collections.unmodifiableSet(super.I());
        }

        public Map<C, Map<R, V>> J0() {
            return Collections.unmodifiableMap(Maps.B0(super.J0(), Tables.j()));
        }

        @CheckForNull
        public V N(@ParametricNullness R r, @ParametricNullness C c2, @ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V> P0(@ParametricNullness R r) {
            return Collections.unmodifiableMap(super.P0(r));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Table<R, C, V> Z0() {
            return this.s;
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<C> j0() {
            return Collections.unmodifiableSet(super.j0());
        }

        public Map<R, Map<C, V>> m() {
            return Collections.unmodifiableMap(Maps.B0(super.m(), Tables.j()));
        }

        public Set<R> n() {
            return Collections.unmodifiableSet(super.n());
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            throw new UnsupportedOperationException();
        }

        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }
    }

    private Tables() {
    }

    static boolean b(Table<?, ?, ?> table, @CheckForNull Object obj) {
        if (obj == table) {
            return true;
        }
        if (obj instanceof Table) {
            return table.I().equals(((Table) obj).I());
        }
        return false;
    }

    public static <R, C, V> Table.Cell<R, C, V> c(@ParametricNullness R r, @ParametricNullness C c2, @ParametricNullness V v) {
        return new ImmutableCell(r, c2, v);
    }

    public static <R, C, V> Table<R, C, V> d(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        Preconditions.d(map.isEmpty());
        Preconditions.E(supplier);
        return new StandardTable(map, supplier);
    }

    public static <R, C, V> Table<R, C, V> e(Table<R, C, V> table) {
        return Synchronized.z(table, (Object) null);
    }

    public static <R, C, V1, V2> Table<R, C, V2> f(Table<R, C, V1> table, Function<? super V1, V2> function) {
        return new TransformedTable(table, function);
    }

    public static <R, C, V> Table<C, R, V> g(Table<R, C, V> table) {
        return table instanceof TransposeTable ? ((TransposeTable) table).Y : new TransposeTable(table);
    }

    public static <R, C, V> RowSortedTable<R, C, V> h(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
        return new UnmodifiableRowSortedMap(rowSortedTable);
    }

    public static <R, C, V> Table<R, C, V> i(Table<? extends R, ? extends C, ? extends V> table) {
        return new UnmodifiableTable(table);
    }

    /* access modifiers changed from: private */
    public static <K, V> Function<Map<K, V>, Map<K, V>> j() {
        return f22497a;
    }
}
