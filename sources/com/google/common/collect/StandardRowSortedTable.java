package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
class StandardRowSortedTable<R, C, V> extends StandardTable<R, C, V> implements RowSortedTable<R, C, V> {
    private static final long b3 = 0;

    private class RowSortedMap extends StandardTable<R, C, V>.RowMap implements SortedMap<R, Map<C, V>> {
        private RowSortedMap() {
            super();
        }

        @CheckForNull
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.this.r().comparator();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public SortedSet<R> b() {
            return new Maps.SortedKeySet(this);
        }

        public R firstKey() {
            return StandardRowSortedTable.this.r().firstKey();
        }

        /* renamed from: g */
        public SortedSet<R> keySet() {
            return (SortedSet) super.keySet();
        }

        public SortedMap<R, Map<C, V>> headMap(R r) {
            Preconditions.E(r);
            return new StandardRowSortedTable(StandardRowSortedTable.this.r().headMap(r), StandardRowSortedTable.this.Z).m();
        }

        public R lastKey() {
            return StandardRowSortedTable.this.r().lastKey();
        }

        public SortedMap<R, Map<C, V>> subMap(R r, R r2) {
            Preconditions.E(r);
            Preconditions.E(r2);
            return new StandardRowSortedTable(StandardRowSortedTable.this.r().subMap(r, r2), StandardRowSortedTable.this.Z).m();
        }

        public SortedMap<R, Map<C, V>> tailMap(R r) {
            Preconditions.E(r);
            return new StandardRowSortedTable(StandardRowSortedTable.this.r().tailMap(r), StandardRowSortedTable.this.Z).m();
        }
    }

    StandardRowSortedTable(SortedMap<R, Map<C, V>> sortedMap, Supplier<? extends Map<C, V>> supplier) {
        super(sortedMap, supplier);
    }

    /* access modifiers changed from: private */
    public SortedMap<R, Map<C, V>> r() {
        return (SortedMap) this.Y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public SortedMap<R, Map<C, V>> j() {
        return new RowSortedMap();
    }

    public SortedMap<R, Map<C, V>> m() {
        return (SortedMap) super.m();
    }

    public SortedSet<R> n() {
        return (SortedSet) m().keySet();
    }
}
