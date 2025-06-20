package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
class StandardTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long a3 = 0;
    @CheckForNull
    @LazyInit
    private transient Set<C> X2;
    @GwtTransient
    final Map<R, Map<C, V>> Y;
    @CheckForNull
    @LazyInit
    private transient Map<R, Map<C, V>> Y2;
    @GwtTransient
    final Supplier<? extends Map<C, V>> Z;
    @CheckForNull
    @LazyInit
    private transient StandardTable<R, C, V>.ColumnMap Z2;

    private class CellIterator implements Iterator<Table.Cell<R, C, V>> {
        @CheckForNull
        Map.Entry<R, Map<C, V>> X;
        Iterator<Map.Entry<C, V>> Y;
        final Iterator<Map.Entry<R, Map<C, V>>> s;

        private CellIterator() {
            this.s = StandardTable.this.Y.entrySet().iterator();
            this.Y = Iterators.w();
        }

        /* renamed from: a */
        public Table.Cell<R, C, V> next() {
            if (!this.Y.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.s.next();
                this.X = next;
                this.Y = next.getValue().entrySet().iterator();
            }
            Objects.requireNonNull(this.X);
            Map.Entry next2 = this.Y.next();
            return Tables.c(this.X.getKey(), next2.getKey(), next2.getValue());
        }

        public boolean hasNext() {
            return this.s.hasNext() || this.Y.hasNext();
        }

        public void remove() {
            this.Y.remove();
            Map.Entry<R, Map<C, V>> entry = this.X;
            Objects.requireNonNull(entry);
            if (((Map) entry.getValue()).isEmpty()) {
                this.s.remove();
                this.X = null;
            }
        }
    }

    private class Column extends Maps.ViewCachingAbstractMap<R, V> {
        final C Z;

        private class EntrySet extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
            private EntrySet() {
            }

            public void clear() {
                Column.this.d(Predicates.c());
            }

            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.h(entry.getKey(), Column.this.Z, entry.getValue());
            }

            public boolean isEmpty() {
                Column column = Column.this;
                return !StandardTable.this.D(column.Z);
            }

            public Iterator<Map.Entry<R, V>> iterator() {
                return new EntrySetIterator();
            }

            public boolean remove(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.o(entry.getKey(), Column.this.Z, entry.getValue());
            }

            public boolean retainAll(Collection<?> collection) {
                return Column.this.d(Predicates.q(Predicates.n(collection)));
            }

            public int size() {
                int i2 = 0;
                for (Map<C, V> containsKey : StandardTable.this.Y.values()) {
                    if (containsKey.containsKey(Column.this.Z)) {
                        i2++;
                    }
                }
                return i2;
            }
        }

        private class EntrySetIterator extends AbstractIterator<Map.Entry<R, V>> {
            final Iterator<Map.Entry<R, Map<C, V>>> Y;

            private EntrySetIterator() {
                this.Y = StandardTable.this.Y.entrySet().iterator();
            }

            /* access modifiers changed from: protected */
            @CheckForNull
            /* renamed from: d */
            public Map.Entry<R, V> a() {
                while (this.Y.hasNext()) {
                    final Map.Entry next = this.Y.next();
                    if (((Map) next.getValue()).containsKey(Column.this.Z)) {
                        return new AbstractMapEntry<R, V>() {
                            public R getKey() {
                                return next.getKey();
                            }

                            public V getValue() {
                                return ((Map) next.getValue()).get(Column.this.Z);
                            }

                            public V setValue(V v) {
                                return NullnessCasts.a(((Map) next.getValue()).put(Column.this.Z, Preconditions.E(v)));
                            }
                        };
                    }
                }
                return (Map.Entry) b();
            }
        }

        private class KeySet extends Maps.KeySet<R, V> {
            KeySet() {
                super(Column.this);
            }

            public boolean contains(@CheckForNull Object obj) {
                Column column = Column.this;
                return StandardTable.this.I0(obj, column.Z);
            }

            public boolean remove(@CheckForNull Object obj) {
                Column column = Column.this;
                return StandardTable.this.remove(obj, column.Z) != null;
            }

            public boolean retainAll(Collection<?> collection) {
                return Column.this.d(Maps.U(Predicates.q(Predicates.n(collection))));
            }
        }

        private class Values extends Maps.Values<R, V> {
            Values() {
                super(Column.this);
            }

            public boolean remove(@CheckForNull Object obj) {
                return obj != null && Column.this.d(Maps.R0(Predicates.m(obj)));
            }

            public boolean removeAll(Collection<?> collection) {
                return Column.this.d(Maps.R0(Predicates.n(collection)));
            }

            public boolean retainAll(Collection<?> collection) {
                return Column.this.d(Maps.R0(Predicates.q(Predicates.n(collection))));
            }
        }

        Column(C c2) {
            this.Z = Preconditions.E(c2);
        }

        /* access modifiers changed from: package-private */
        public Set<Map.Entry<R, V>> a() {
            return new EntrySet();
        }

        /* access modifiers changed from: package-private */
        public Set<R> b() {
            return new KeySet();
        }

        /* access modifiers changed from: package-private */
        public Collection<V> c() {
            return new Values();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.I0(obj, this.Z);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public boolean d(Predicate<? super Map.Entry<R, V>> predicate) {
            Iterator<Map.Entry<R, Map<C, V>>> it2 = StandardTable.this.Y.entrySet().iterator();
            boolean z = false;
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                Map map = (Map) next.getValue();
                Object obj = map.get(this.Z);
                if (obj != null && predicate.apply(Maps.O(next.getKey(), obj))) {
                    map.remove(this.Z);
                    if (map.isEmpty()) {
                        it2.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            return StandardTable.this.z(obj, this.Z);
        }

        @CheckForNull
        public V put(R r, V v) {
            return StandardTable.this.N(r, this.Z, v);
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            return StandardTable.this.remove(obj, this.Z);
        }
    }

    private class ColumnKeyIterator extends AbstractIterator<C> {
        Iterator<Map.Entry<C, V>> X2;
        final Map<C, V> Y;
        final Iterator<Map<C, V>> Z;

        private ColumnKeyIterator() {
            this.Y = (Map) StandardTable.this.Z.get();
            this.Z = StandardTable.this.Y.values().iterator();
            this.X2 = Iterators.u();
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public C a() {
            while (true) {
                if (this.X2.hasNext()) {
                    Map.Entry next = this.X2.next();
                    if (!this.Y.containsKey(next.getKey())) {
                        this.Y.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (!this.Z.hasNext()) {
                    return b();
                } else {
                    this.X2 = this.Z.next().entrySet().iterator();
                }
            }
        }
    }

    private class ColumnKeySet extends StandardTable<R, C, V>.TableSet<C> {
        private ColumnKeySet() {
            super();
        }

        public boolean contains(@CheckForNull Object obj) {
            return StandardTable.this.D(obj);
        }

        public Iterator<C> iterator() {
            return StandardTable.this.i();
        }

        public boolean remove(@CheckForNull Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it2 = StandardTable.this.Y.values().iterator();
            while (it2.hasNext()) {
                Map next = it2.next();
                if (next.keySet().remove(obj)) {
                    if (next.isEmpty()) {
                        it2.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        public boolean removeAll(Collection<?> collection) {
            Preconditions.E(collection);
            Iterator<Map<C, V>> it2 = StandardTable.this.Y.values().iterator();
            boolean z = false;
            while (it2.hasNext()) {
                Map next = it2.next();
                if (Iterators.V(next.keySet().iterator(), collection)) {
                    if (next.isEmpty()) {
                        it2.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            Preconditions.E(collection);
            Iterator<Map<C, V>> it2 = StandardTable.this.Y.values().iterator();
            boolean z = false;
            while (it2.hasNext()) {
                Map next = it2.next();
                if (next.keySet().retainAll(collection)) {
                    if (next.isEmpty()) {
                        it2.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        public int size() {
            return Iterators.Z(iterator());
        }
    }

    private class ColumnMap extends Maps.ViewCachingAbstractMap<C, Map<R, V>> {

        class ColumnMapEntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>> {
            ColumnMapEntrySet() {
                super();
            }

            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!StandardTable.this.D(entry.getKey())) {
                    return false;
                }
                Map d2 = ColumnMap.this.get(entry.getKey());
                Objects.requireNonNull(d2);
                return d2.equals(entry.getValue());
            }

            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.m(StandardTable.this.j0(), new Function<C, Map<R, V>>() {
                    /* renamed from: a */
                    public Map<R, V> apply(C c2) {
                        return StandardTable.this.E(c2);
                    }
                });
            }

            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj) || !(obj instanceof Map.Entry)) {
                    return false;
                }
                Map unused = StandardTable.this.l(((Map.Entry) obj).getKey());
                return true;
            }

            public boolean removeAll(Collection<?> collection) {
                Preconditions.E(collection);
                return Sets.J(this, collection.iterator());
            }

            public boolean retainAll(Collection<?> collection) {
                Preconditions.E(collection);
                Iterator it2 = Lists.s(StandardTable.this.j0().iterator()).iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (!collection.contains(Maps.O(next, StandardTable.this.E(next)))) {
                        Map unused = StandardTable.this.l(next);
                        z = true;
                    }
                }
                return z;
            }

            public int size() {
                return StandardTable.this.j0().size();
            }
        }

        private class ColumnMapValues extends Maps.Values<C, Map<R, V>> {
            ColumnMapValues() {
                super(ColumnMap.this);
            }

            public boolean remove(@CheckForNull Object obj) {
                for (Map.Entry entry : ColumnMap.this.entrySet()) {
                    if (((Map) entry.getValue()).equals(obj)) {
                        Map unused = StandardTable.this.l(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            public boolean removeAll(Collection<?> collection) {
                Preconditions.E(collection);
                Iterator it2 = Lists.s(StandardTable.this.j0().iterator()).iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (collection.contains(StandardTable.this.E(next))) {
                        Map unused = StandardTable.this.l(next);
                        z = true;
                    }
                }
                return z;
            }

            public boolean retainAll(Collection<?> collection) {
                Preconditions.E(collection);
                Iterator it2 = Lists.s(StandardTable.this.j0().iterator()).iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (!collection.contains(StandardTable.this.E(next))) {
                        Map unused = StandardTable.this.l(next);
                        z = true;
                    }
                }
                return z;
            }
        }

        private ColumnMap() {
        }

        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new ColumnMapEntrySet();
        }

        /* access modifiers changed from: package-private */
        public Collection<Map<R, V>> c() {
            return new ColumnMapValues();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.D(obj);
        }

        @CheckForNull
        /* renamed from: d */
        public Map<R, V> get(@CheckForNull Object obj) {
            if (!StandardTable.this.D(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.E(obj);
        }

        @CheckForNull
        /* renamed from: e */
        public Map<R, V> remove(@CheckForNull Object obj) {
            if (StandardTable.this.D(obj)) {
                return StandardTable.this.l(obj);
            }
            return null;
        }

        public Set<C> keySet() {
            return StandardTable.this.j0();
        }
    }

    class Row extends Maps.IteratorBasedAbstractMap<C, V> {
        @CheckForNull
        Map<C, V> X;
        final R s;

        Row(R r) {
            this.s = Preconditions.E(r);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<C, V>> a() {
            d();
            Map<C, V> map = this.X;
            if (map == null) {
                return Iterators.w();
            }
            final Iterator<Map.Entry<C, V>> it2 = map.entrySet().iterator();
            return new Iterator<Map.Entry<C, V>>() {
                /* renamed from: a */
                public Map.Entry<C, V> next() {
                    return Row.this.e((Map.Entry) it2.next());
                }

                public boolean hasNext() {
                    return it2.hasNext();
                }

                public void remove() {
                    it2.remove();
                    Row.this.c();
                }
            };
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public Map<C, V> b() {
            return StandardTable.this.Y.get(this.s);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            d();
            Map<C, V> map = this.X;
            if (map != null && map.isEmpty()) {
                StandardTable.this.Y.remove(this.s);
                this.X = null;
            }
        }

        public void clear() {
            d();
            Map<C, V> map = this.X;
            if (map != null) {
                map.clear();
            }
            c();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
            r0 = r1.X;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean containsKey(@javax.annotation.CheckForNull java.lang.Object r2) {
            /*
                r1 = this;
                r1.d()
                if (r2 == 0) goto L_0x0011
                java.util.Map<C, V> r0 = r1.X
                if (r0 == 0) goto L_0x0011
                boolean r2 = com.google.common.collect.Maps.o0(r0, r2)
                if (r2 == 0) goto L_0x0011
                r2 = 1
                goto L_0x0012
            L_0x0011:
                r2 = 0
            L_0x0012:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.StandardTable.Row.containsKey(java.lang.Object):boolean");
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            Map<C, V> map = this.X;
            if (map == null || (map.isEmpty() && StandardTable.this.Y.containsKey(this.s))) {
                this.X = b();
            }
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<C, V> e(final Map.Entry<C, V> entry) {
            return new ForwardingMapEntry<C, V>(this) {
                /* access modifiers changed from: protected */
                /* renamed from: a1 */
                public Map.Entry<C, V> Z0() {
                    return entry;
                }

                public boolean equals(@CheckForNull Object obj) {
                    return f1(obj);
                }

                public V setValue(V v) {
                    return super.setValue(Preconditions.E(v));
                }
            };
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            Map<C, V> map;
            d();
            if (obj == null || (map = this.X) == null) {
                return null;
            }
            return Maps.p0(map, obj);
        }

        @CheckForNull
        public V put(C c2, V v) {
            Preconditions.E(c2);
            Preconditions.E(v);
            Map<C, V> map = this.X;
            return (map == null || map.isEmpty()) ? StandardTable.this.N(this.s, c2, v) : this.X.put(c2, v);
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            d();
            Map<C, V> map = this.X;
            if (map == null) {
                return null;
            }
            V q0 = Maps.q0(map, obj);
            c();
            return q0;
        }

        public int size() {
            d();
            Map<C, V> map = this.X;
            if (map == null) {
                return 0;
            }
            return map.size();
        }
    }

    class RowMap extends Maps.ViewCachingAbstractMap<R, Map<C, V>> {

        class EntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>> {
            EntrySet() {
                super();
            }

            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && Collections2.j(StandardTable.this.Y.entrySet(), entry);
            }

            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.m(StandardTable.this.Y.keySet(), new Function<R, Map<C, V>>() {
                    /* renamed from: a */
                    public Map<C, V> apply(R r) {
                        return StandardTable.this.P0(r);
                    }
                });
            }

            public boolean remove(@CheckForNull Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && StandardTable.this.Y.entrySet().remove(entry);
            }

            public int size() {
                return StandardTable.this.Y.size();
            }
        }

        RowMap() {
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<R, Map<C, V>>> a() {
            return new EntrySet();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return StandardTable.this.m0(obj);
        }

        @CheckForNull
        /* renamed from: d */
        public Map<C, V> get(@CheckForNull Object obj) {
            if (!StandardTable.this.m0(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.P0(obj);
        }

        @CheckForNull
        /* renamed from: e */
        public Map<C, V> remove(@CheckForNull Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.Y.remove(obj);
        }
    }

    private abstract class TableSet<T> extends Sets.ImprovedAbstractSet<T> {
        private TableSet() {
        }

        public void clear() {
            StandardTable.this.Y.clear();
        }

        public boolean isEmpty() {
            return StandardTable.this.Y.isEmpty();
        }
    }

    StandardTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        this.Y = map;
        this.Z = supplier;
    }

    /* access modifiers changed from: private */
    public boolean h(@CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        return obj3 != null && obj3.equals(z(obj, obj2));
    }

    private Map<C, V> k(R r) {
        Map<C, V> map = this.Y.get(r);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = (Map) this.Z.get();
        this.Y.put(r, map2);
        return map2;
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Map<R, V> l(@CheckForNull Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it2 = this.Y.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            Object remove = ((Map) next.getValue()).remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (((Map) next.getValue()).isEmpty()) {
                    it2.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    public boolean o(@CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!h(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    public boolean D(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        for (Map<C, V> o0 : this.Y.values()) {
            if (Maps.o0(o0, obj)) {
                return true;
            }
        }
        return false;
    }

    public Map<R, V> E(C c2) {
        return new Column(c2);
    }

    public Set<Table.Cell<R, C, V>> I() {
        return super.I();
    }

    public boolean I0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return (obj == null || obj2 == null || !super.I0(obj, obj2)) ? false : true;
    }

    public Map<C, Map<R, V>> J0() {
        StandardTable<R, C, V>.ColumnMap columnMap = this.Z2;
        if (columnMap != null) {
            return columnMap;
        }
        StandardTable<R, C, V>.ColumnMap columnMap2 = new ColumnMap();
        this.Z2 = columnMap2;
        return columnMap2;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V N(R r, C c2, V v) {
        Preconditions.E(r);
        Preconditions.E(c2);
        Preconditions.E(v);
        return k(r).put(c2, v);
    }

    public Map<C, V> P0(R r) {
        return new Row(r);
    }

    /* access modifiers changed from: package-private */
    public Iterator<Table.Cell<R, C, V>> a() {
        return new CellIterator();
    }

    public void clear() {
        this.Y.clear();
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return obj != null && super.containsValue(obj);
    }

    /* access modifiers changed from: package-private */
    public Iterator<C> i() {
        return new ColumnKeyIterator();
    }

    public boolean isEmpty() {
        return this.Y.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public Map<R, Map<C, V>> j() {
        return new RowMap();
    }

    public Set<C> j0() {
        Set<C> set = this.X2;
        if (set != null) {
            return set;
        }
        ColumnKeySet columnKeySet = new ColumnKeySet();
        this.X2 = columnKeySet;
        return columnKeySet;
    }

    public Map<R, Map<C, V>> m() {
        Map<R, Map<C, V>> map = this.Y2;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> j2 = j();
        this.Y2 = j2;
        return j2;
    }

    public boolean m0(@CheckForNull Object obj) {
        return obj != null && Maps.o0(this.Y, obj);
    }

    public Set<R> n() {
        return m().keySet();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.p0(this.Y, obj)) == null) {
            return null;
        }
        V remove = map.remove(obj2);
        if (map.isEmpty()) {
            this.Y.remove(obj);
        }
        return remove;
    }

    public int size() {
        int i2 = 0;
        for (Map<C, V> size : this.Y.values()) {
            i2 += size.size();
        }
        return i2;
    }

    public Collection<V> values() {
        return super.values();
    }

    @CheckForNull
    public V z(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return super.z(obj, obj2);
    }
}
