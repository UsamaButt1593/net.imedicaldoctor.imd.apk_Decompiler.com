package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"R", "C", "V"})
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    /* access modifiers changed from: private */
    public final ImmutableMap<C, Integer> X2;
    private final ImmutableMap<R, ImmutableMap<C, V>> Y2;
    /* access modifiers changed from: private */
    public final ImmutableMap<R, Integer> Z;
    private final ImmutableMap<C, ImmutableMap<R, V>> Z2;
    /* access modifiers changed from: private */
    public final int[] a3;
    /* access modifiers changed from: private */
    public final int[] b3;
    /* access modifiers changed from: private */
    public final V[][] c3;
    private final int[] d3;
    private final int[] e3;

    private final class Column extends ImmutableArrayMap<R, V> {
        private final int Z2;

        Column(int i2) {
            super(DenseImmutableTable.this.b3[i2]);
            this.Z2 = i2;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V M(int i2) {
            return DenseImmutableTable.this.c3[i2][this.Z2];
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<R, Integer> O() {
            return DenseImmutableTable.this.Z;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return true;
        }
    }

    private final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        private ColumnMap() {
            super(DenseImmutableTable.this.b3.length);
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<C, Integer> O() {
            return DenseImmutableTable.this.X2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: P */
        public ImmutableMap<R, V> M(int i2) {
            return new Column(i2);
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return false;
        }
    }

    private static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        private final int Y2;

        ImmutableArrayMap(int i2) {
            this.Y2 = i2;
        }

        private boolean N() {
            return this.Y2 == O().size();
        }

        /* access modifiers changed from: package-private */
        public UnmodifiableIterator<Map.Entry<K, V>> J() {
            return new AbstractIterator<Map.Entry<K, V>>() {
                private int Y = -1;
                private final int Z;

                {
                    this.Z = ImmutableArrayMap.this.O().size();
                }

                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<K, V> a() {
                    int i2 = this.Y;
                    while (true) {
                        this.Y = i2 + 1;
                        int i3 = this.Y;
                        if (i3 >= this.Z) {
                            return (Map.Entry) b();
                        }
                        Object M = ImmutableArrayMap.this.M(i3);
                        if (M != null) {
                            return Maps.O(ImmutableArrayMap.this.K(this.Y), M);
                        }
                        i2 = this.Y;
                    }
                }
            };
        }

        /* access modifiers changed from: package-private */
        public K K(int i2) {
            return O().keySet().b().get(i2);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public abstract V M(int i2);

        /* access modifiers changed from: package-private */
        public abstract ImmutableMap<K, Integer> O();

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            Integer num = (Integer) O().get(obj);
            if (num == null) {
                return null;
            }
            return M(num.intValue());
        }

        /* access modifiers changed from: package-private */
        public ImmutableSet<K> i() {
            return N() ? O().keySet() : super.i();
        }

        public int size() {
            return this.Y2;
        }
    }

    private final class Row extends ImmutableArrayMap<C, V> {
        private final int Z2;

        Row(int i2) {
            super(DenseImmutableTable.this.a3[i2]);
            this.Z2 = i2;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V M(int i2) {
            return DenseImmutableTable.this.c3[this.Z2][i2];
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<C, Integer> O() {
            return DenseImmutableTable.this.X2;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return true;
        }
    }

    private final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        private RowMap() {
            super(DenseImmutableTable.this.a3.length);
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<R, Integer> O() {
            return DenseImmutableTable.this.Z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: P */
        public ImmutableMap<C, V> M(int i2) {
            return new Row(i2);
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return false;
        }
    }

    DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        int size = immutableSet.size();
        int[] iArr = new int[2];
        iArr[1] = immutableSet2.size();
        iArr[0] = size;
        this.c3 = (Object[][]) Array.newInstance(Object.class, iArr);
        ImmutableMap<R, Integer> Q = Maps.Q(immutableSet);
        this.Z = Q;
        ImmutableMap<C, Integer> Q2 = Maps.Q(immutableSet2);
        this.X2 = Q2;
        this.a3 = new int[Q.size()];
        this.b3 = new int[Q2.size()];
        int[] iArr2 = new int[immutableList.size()];
        int[] iArr3 = new int[immutableList.size()];
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            Table.Cell cell = immutableList.get(i2);
            Object b2 = cell.b();
            Object a2 = cell.a();
            Integer num = this.Z.get(b2);
            Objects.requireNonNull(num);
            int intValue = num.intValue();
            Integer num2 = this.X2.get(a2);
            Objects.requireNonNull(num2);
            int intValue2 = num2.intValue();
            C(b2, a2, this.c3[intValue][intValue2], cell.getValue());
            this.c3[intValue][intValue2] = cell.getValue();
            int[] iArr4 = this.a3;
            iArr4[intValue] = iArr4[intValue] + 1;
            int[] iArr5 = this.b3;
            iArr5[intValue2] = iArr5[intValue2] + 1;
            iArr2[i2] = intValue;
            iArr3[i2] = intValue2;
        }
        this.d3 = iArr2;
        this.e3 = iArr3;
        this.Y2 = new RowMap();
        this.Z2 = new ColumnMap();
    }

    /* access modifiers changed from: package-private */
    public Table.Cell<R, C, V> L(int i2) {
        int i3 = this.d3[i2];
        int i4 = this.e3[i2];
        Object obj = n().b().get(i3);
        Object obj2 = j0().b().get(i4);
        V v = this.c3[i3][i4];
        Objects.requireNonNull(v);
        return ImmutableTable.g(obj, obj2, v);
    }

    /* access modifiers changed from: package-private */
    public V M(int i2) {
        V v = this.c3[this.d3[i2]][this.e3[i2]];
        Objects.requireNonNull(v);
        return v;
    }

    /* renamed from: k */
    public ImmutableMap<C, Map<R, V>> J0() {
        return ImmutableMap.g(this.Z2);
    }

    /* access modifiers changed from: package-private */
    public ImmutableTable.SerializedForm q() {
        return ImmutableTable.SerializedForm.a(this, this.d3, this.e3);
    }

    public int size() {
        return this.d3.length;
    }

    /* renamed from: x */
    public ImmutableMap<R, Map<C, V>> m() {
        return ImmutableMap.g(this.Y2);
    }

    @CheckForNull
    public V z(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.Z.get(obj);
        Integer num2 = this.X2.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.c3[num.intValue()][num2.intValue()];
    }
}
