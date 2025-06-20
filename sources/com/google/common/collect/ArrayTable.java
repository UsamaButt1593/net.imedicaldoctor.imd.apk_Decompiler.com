package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import org.apache.commons.lang3.StringUtils;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long c3 = 0;
    /* access modifiers changed from: private */
    public final ImmutableMap<R, Integer> X2;
    /* access modifiers changed from: private */
    public final ImmutableList<R> Y;
    /* access modifiers changed from: private */
    public final ImmutableMap<C, Integer> Y2;
    /* access modifiers changed from: private */
    public final ImmutableList<C> Z;
    private final V[][] Z2;
    @CheckForNull
    @LazyInit
    private transient ArrayTable<R, C, V>.ColumnMap a3;
    @CheckForNull
    @LazyInit
    private transient ArrayTable<R, C, V>.RowMap b3;

    private static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {
        private final ImmutableMap<K, Integer> s;

        private ArrayMap(ImmutableMap<K, Integer> immutableMap) {
            this.s = immutableMap;
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> a() {
            return new AbstractIndexedListIterator<Map.Entry<K, V>>(size()) {
                /* access modifiers changed from: protected */
                /* renamed from: b */
                public Map.Entry<K, V> a(int i2) {
                    return ArrayMap.this.b(i2);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, V> b(final int i2) {
            Preconditions.C(i2, size());
            return new AbstractMapEntry<K, V>() {
                public K getKey() {
                    return ArrayMap.this.c(i2);
                }

                @ParametricNullness
                public V getValue() {
                    return ArrayMap.this.e(i2);
                }

                @ParametricNullness
                public V setValue(@ParametricNullness V v) {
                    return ArrayMap.this.f(i2, v);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public K c(int i2) {
            return this.s.keySet().b().get(i2);
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.s.containsKey(obj);
        }

        /* access modifiers changed from: package-private */
        public abstract String d();

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public abstract V e(int i2);

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public abstract V f(int i2, @ParametricNullness V v);

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            Integer num = this.s.get(obj);
            if (num == null) {
                return null;
            }
            return e(num.intValue());
        }

        public boolean isEmpty() {
            return this.s.isEmpty();
        }

        public Set<K> keySet() {
            return this.s.keySet();
        }

        @CheckForNull
        public V put(K k2, @ParametricNullness V v) {
            Integer num = this.s.get(k2);
            if (num != null) {
                return f(num.intValue(), v);
            }
            throw new IllegalArgumentException(d() + StringUtils.SPACE + k2 + " not in " + this.s.keySet());
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.s.size();
        }
    }

    private class Column extends ArrayMap<R, V> {
        final int X;

        Column(int i2) {
            super(ArrayTable.this.X2);
            this.X = i2;
        }

        /* access modifiers changed from: package-private */
        public String d() {
            return "Row";
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V e(int i2) {
            return ArrayTable.this.k(i2, this.X);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V f(int i2, @CheckForNull V v) {
            return ArrayTable.this.x(i2, this.X, v);
        }
    }

    private class ColumnMap extends ArrayMap<C, Map<R, V>> {
        private ColumnMap() {
            super(ArrayTable.this.Y2);
        }

        /* access modifiers changed from: package-private */
        public String d() {
            return "Column";
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public Map<R, V> e(int i2) {
            return new Column(i2);
        }

        @CheckForNull
        /* renamed from: h */
        public Map<R, V> put(C c2, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Map<R, V> f(int i2, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    private class Row extends ArrayMap<C, V> {
        final int X;

        Row(int i2) {
            super(ArrayTable.this.Y2);
            this.X = i2;
        }

        /* access modifiers changed from: package-private */
        public String d() {
            return "Column";
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V e(int i2) {
            return ArrayTable.this.k(this.X, i2);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V f(int i2, @CheckForNull V v) {
            return ArrayTable.this.x(this.X, i2, v);
        }
    }

    private class RowMap extends ArrayMap<R, Map<C, V>> {
        private RowMap() {
            super(ArrayTable.this.X2);
        }

        /* access modifiers changed from: package-private */
        public String d() {
            return "Row";
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public Map<C, V> e(int i2) {
            return new Row(i2);
        }

        @CheckForNull
        /* renamed from: h */
        public Map<C, V> put(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Map<C, V> f(int i2, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.Y;
        this.Y = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.Z;
        this.Z = immutableList2;
        this.X2 = arrayTable.X2;
        this.Y2 = arrayTable.Y2;
        int size = immutableList.size();
        int[] iArr = new int[2];
        iArr[1] = immutableList2.size();
        iArr[0] = size;
        V[][] vArr = (Object[][]) Array.newInstance(Object.class, iArr);
        this.Z2 = vArr;
        for (int i2 = 0; i2 < this.Y.size(); i2++) {
            V[] vArr2 = arrayTable.Z2[i2];
            System.arraycopy(vArr2, 0, vArr[i2], 0, vArr2.length);
        }
    }

    public static <R, C, V> ArrayTable<R, C, V> p(Table<R, C, ? extends V> table) {
        return table instanceof ArrayTable ? new ArrayTable<>((ArrayTable) table) : new ArrayTable<>(table);
    }

    public static <R, C, V> ArrayTable<R, C, V> q(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* access modifiers changed from: private */
    public Table.Cell<R, C, V> t(int i2) {
        return new Tables.AbstractCell<R, C, V>(i2) {
            final int X;
            final /* synthetic */ int Y;
            final int s;

            {
                this.Y = r3;
                this.s = r3 / ArrayTable.this.Z.size();
                this.X = r3 % ArrayTable.this.Z.size();
            }

            public C a() {
                return ArrayTable.this.Z.get(this.X);
            }

            public R b() {
                return ArrayTable.this.Y.get(this.s);
            }

            @CheckForNull
            public V getValue() {
                return ArrayTable.this.k(this.s, this.X);
            }
        };
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public V u(int i2) {
        return k(i2 / this.Z.size(), i2 % this.Z.size());
    }

    public void B0(Table<? extends R, ? extends C, ? extends V> table) {
        super.B0(table);
    }

    public boolean D(@CheckForNull Object obj) {
        return this.Y2.containsKey(obj);
    }

    public Map<R, V> E(C c2) {
        Preconditions.E(c2);
        Integer num = this.Y2.get(c2);
        return num == null ? Collections.emptyMap() : new Column(num.intValue());
    }

    public Set<Table.Cell<R, C, V>> I() {
        return super.I();
    }

    public boolean I0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return m0(obj) && D(obj2);
    }

    public Map<C, Map<R, V>> J0() {
        ArrayTable<R, C, V>.ColumnMap columnMap = this.a3;
        if (columnMap != null) {
            return columnMap;
        }
        ArrayTable<R, C, V>.ColumnMap columnMap2 = new ColumnMap();
        this.a3 = columnMap2;
        return columnMap2;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V N(R r, C c2, @CheckForNull V v) {
        Preconditions.E(r);
        Preconditions.E(c2);
        Integer num = this.X2.get(r);
        boolean z = false;
        Preconditions.y(num != null, "Row %s not in %s", r, this.Y);
        Integer num2 = this.Y2.get(c2);
        if (num2 != null) {
            z = true;
        }
        Preconditions.y(z, "Column %s not in %s", c2, this.Z);
        return x(num.intValue(), num2.intValue(), v);
    }

    public Map<C, V> P0(R r) {
        Preconditions.E(r);
        Integer num = this.X2.get(r);
        return num == null ? Collections.emptyMap() : new Row(num.intValue());
    }

    /* access modifiers changed from: package-private */
    public Iterator<Table.Cell<R, C, V>> a() {
        return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(size()) {
            /* access modifiers changed from: protected */
            /* renamed from: b */
            public Table.Cell<R, C, V> a(int i2) {
                return ArrayTable.this.t(i2);
            }
        };
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsValue(@CheckForNull Object obj) {
        for (V[] vArr : this.Z2) {
            for (V a2 : r0[r3]) {
                if (Objects.a(obj, a2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> d() {
        return new AbstractIndexedListIterator<V>(size()) {
            /* access modifiers changed from: protected */
            @CheckForNull
            public V a(int i2) {
                return ArrayTable.this.u(i2);
            }
        };
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public boolean isEmpty() {
        return this.Y.isEmpty() || this.Z.isEmpty();
    }

    @CheckForNull
    public V k(int i2, int i3) {
        Preconditions.C(i2, this.Y.size());
        Preconditions.C(i3, this.Z.size());
        return this.Z2[i2][i3];
    }

    public ImmutableList<C> l() {
        return this.Z;
    }

    public Map<R, Map<C, V>> m() {
        ArrayTable<R, C, V>.RowMap rowMap = this.b3;
        if (rowMap != null) {
            return rowMap;
        }
        ArrayTable<R, C, V>.RowMap rowMap2 = new RowMap();
        this.b3 = rowMap2;
        return rowMap2;
    }

    public boolean m0(@CheckForNull Object obj) {
        return this.X2.containsKey(obj);
    }

    /* renamed from: o */
    public ImmutableSet<C> j0() {
        return this.Y2.keySet();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V r(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.X2.get(obj);
        Integer num2 = this.Y2.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return x(num.intValue(), num2.intValue(), (Object) null);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    public void s() {
        for (V[] fill : this.Z2) {
            Arrays.fill(fill, (Object) null);
        }
    }

    public int size() {
        return this.Y.size() * this.Z.size();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public ImmutableList<R> v() {
        return this.Y;
    }

    public Collection<V> values() {
        return super.values();
    }

    /* renamed from: w */
    public ImmutableSet<R> n() {
        return this.X2.keySet();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V x(int i2, int i3, @CheckForNull V v) {
        Preconditions.C(i2, this.Y.size());
        Preconditions.C(i3, this.Z.size());
        V[] vArr = this.Z2[i2];
        V v2 = vArr[i3];
        vArr[i3] = v;
        return v2;
    }

    @GwtIncompatible
    public V[][] y(Class<V> cls) {
        V[][] vArr = (Object[][]) Array.newInstance(cls, new int[]{this.Y.size(), this.Z.size()});
        for (int i2 = 0; i2 < this.Y.size(); i2++) {
            V[] vArr2 = this.Z2[i2];
            System.arraycopy(vArr2, 0, vArr[i2], 0, vArr2.length);
        }
        return vArr;
    }

    @CheckForNull
    public V z(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.X2.get(obj);
        Integer num2 = this.Y2.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return k(num.intValue(), num2.intValue());
    }

    private ArrayTable(Table<R, C, ? extends V> table) {
        this(table.n(), table.j0());
        B0(table);
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> z = ImmutableList.z(iterable);
        this.Y = z;
        ImmutableList<C> z2 = ImmutableList.z(iterable2);
        this.Z = z2;
        Preconditions.d(z.isEmpty() == z2.isEmpty());
        this.X2 = Maps.Q(z);
        this.Y2 = Maps.Q(z2);
        int size = z.size();
        int[] iArr = new int[2];
        iArr[1] = z2.size();
        iArr[0] = size;
        this.Z2 = (Object[][]) Array.newInstance(Object.class, iArr);
        s();
    }
}
