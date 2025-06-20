package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    private final class CellSet extends IndexedImmutableSet<Table.Cell<R, C, V>> {
        private CellSet() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: U */
        public Table.Cell<R, C, V> get(int i2) {
            return RegularImmutableTable.this.L(i2);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Object z = RegularImmutableTable.this.z(cell.b(), cell.a());
            return z != null && z.equals(cell.getValue());
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return false;
        }

        public int size() {
            return RegularImmutableTable.this.size();
        }
    }

    private final class Values extends ImmutableList<V> {
        private Values() {
        }

        public V get(int i2) {
            return RegularImmutableTable.this.M(i2);
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return true;
        }

        public int size() {
            return RegularImmutableTable.this.size();
        }
    }

    RegularImmutableTable() {
    }

    static <R, C, V> RegularImmutableTable<R, C, V> F(Iterable<Table.Cell<R, C, V>> iterable) {
        return J(iterable, (Comparator) null, (Comparator) null);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> H(List<Table.Cell<R, C, V>> list, @CheckForNull Comparator<? super R> comparator, @CheckForNull Comparator<? super C> comparator2) {
        Preconditions.E(list);
        if (!(comparator == null && comparator2 == null)) {
            Collections.sort(list, new k(comparator, comparator2));
        }
        return J(list, comparator, comparator2);
    }

    private static <R, C, V> RegularImmutableTable<R, C, V> J(Iterable<Table.Cell<R, C, V>> iterable, @CheckForNull Comparator<? super R> comparator, @CheckForNull Comparator<? super C> comparator2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList<E> z = ImmutableList.z(iterable);
        for (Table.Cell next : iterable) {
            linkedHashSet.add(next.b());
            linkedHashSet2.add(next.a());
        }
        return K(z, comparator == null ? ImmutableSet.C(linkedHashSet) : ImmutableSet.C(ImmutableList.a0(comparator, linkedHashSet)), comparator2 == null ? ImmutableSet.C(linkedHashSet2) : ImmutableSet.C(ImmutableList.a0(comparator2, linkedHashSet2)));
    }

    static <R, C, V> RegularImmutableTable<R, C, V> K(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int O(Comparator comparator, Comparator comparator2, Table.Cell cell, Table.Cell cell2) {
        int compare = comparator == null ? 0 : comparator.compare(cell.b(), cell2.b());
        if (compare != 0) {
            return compare;
        }
        if (comparator2 == null) {
            return 0;
        }
        return comparator2.compare(cell.a(), cell2.a());
    }

    /* access modifiers changed from: package-private */
    public final void C(R r, C c2, @CheckForNull V v, V v2) {
        Preconditions.A(v == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", r, c2, v2, v);
    }

    /* access modifiers changed from: package-private */
    public abstract Table.Cell<R, C, V> L(int i2);

    /* access modifiers changed from: package-private */
    public abstract V M(int i2);

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final ImmutableSet<Table.Cell<R, C, V>> b() {
        return isEmpty() ? ImmutableSet.K() : new CellSet();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public final ImmutableCollection<V> c() {
        return isEmpty() ? ImmutableList.I() : new Values();
    }
}
