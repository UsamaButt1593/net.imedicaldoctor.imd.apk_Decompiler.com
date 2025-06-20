package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long d3 = 0;
    private final Comparator<? super C> c3;

    private static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
        private static final long X = 0;
        final Comparator<? super C> s;

        Factory(Comparator<? super C> comparator) {
            this.s = comparator;
        }

        /* renamed from: a */
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.s);
        }
    }

    private class TreeRow extends StandardTable<R, C, V>.Row implements SortedMap<C, V> {
        @CheckForNull
        final C X2;
        @CheckForNull
        transient SortedMap<C, V> Y2;
        @CheckForNull
        final C Z;

        TreeRow(TreeBasedTable treeBasedTable, R r) {
            this(r, (Object) null, (Object) null);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            j();
            SortedMap<C, V> sortedMap = this.Y2;
            if (sortedMap != null && sortedMap.isEmpty()) {
                TreeBasedTable.this.Y.remove(this.s);
                this.Y2 = null;
                this.X = null;
            }
        }

        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.t();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return i(obj) && super.containsKey(obj);
        }

        /* access modifiers changed from: package-private */
        public int f(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        public C firstKey() {
            d();
            Map<C, V> map = this.X;
            if (map != null) {
                return ((SortedMap) map).firstKey();
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        /* renamed from: g */
        public SortedMap<C, V> b() {
            j();
            SortedMap<C, V> sortedMap = this.Y2;
            if (sortedMap == null) {
                return null;
            }
            C c2 = this.Z;
            if (c2 != null) {
                sortedMap = sortedMap.tailMap(c2);
            }
            C c3 = this.X2;
            return c3 != null ? sortedMap.headMap(c3) : sortedMap;
        }

        /* renamed from: h */
        public SortedSet<C> keySet() {
            return new Maps.SortedKeySet(this);
        }

        public SortedMap<C, V> headMap(C c2) {
            Preconditions.d(i(Preconditions.E(c2)));
            return new TreeRow(this.s, this.Z, c2);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            r0 = r1.Z;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
            r0 = r1.X2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean i(@javax.annotation.CheckForNull java.lang.Object r2) {
            /*
                r1 = this;
                if (r2 == 0) goto L_0x0018
                C r0 = r1.Z
                if (r0 == 0) goto L_0x000c
                int r0 = r1.f(r0, r2)
                if (r0 > 0) goto L_0x0018
            L_0x000c:
                C r0 = r1.X2
                if (r0 == 0) goto L_0x0016
                int r2 = r1.f(r0, r2)
                if (r2 <= 0) goto L_0x0018
            L_0x0016:
                r2 = 1
                goto L_0x0019
            L_0x0018:
                r2 = 0
            L_0x0019:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeBasedTable.TreeRow.i(java.lang.Object):boolean");
        }

        /* access modifiers changed from: package-private */
        public void j() {
            SortedMap<C, V> sortedMap = this.Y2;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.Y.containsKey(this.s))) {
                this.Y2 = (SortedMap) TreeBasedTable.this.Y.get(this.s);
            }
        }

        public C lastKey() {
            d();
            Map<C, V> map = this.X;
            if (map != null) {
                return ((SortedMap) map).lastKey();
            }
            throw new NoSuchElementException();
        }

        @CheckForNull
        public V put(C c2, V v) {
            Preconditions.d(i(Preconditions.E(c2)));
            return super.put(c2, v);
        }

        public SortedMap<C, V> subMap(C c2, C c3) {
            Preconditions.d(i(Preconditions.E(c2)) && i(Preconditions.E(c3)));
            return new TreeRow(this.s, c2, c3);
        }

        public SortedMap<C, V> tailMap(C c2) {
            Preconditions.d(i(Preconditions.E(c2)));
            return new TreeRow(this.s, c2, this.X2);
        }

        TreeRow(R r, @CheckForNull C c2, @CheckForNull C c3) {
            super(r);
            this.Z = c2;
            this.X2 = c3;
            Preconditions.d(c2 == null || c3 == null || f(c2, c3) <= 0);
        }
    }

    TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.c3 = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> u() {
        return new TreeBasedTable<>(Ordering.z(), Ordering.z());
    }

    public static <R, C, V> TreeBasedTable<R, C, V> v(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.A(), treeBasedTable.t());
        treeBasedTable2.B0(treeBasedTable);
        return treeBasedTable2;
    }

    public static <R, C, V> TreeBasedTable<R, C, V> w(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        Preconditions.E(comparator);
        Preconditions.E(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Deprecated
    public Comparator<? super R> A() {
        Comparator<? super R> comparator = n().comparator();
        Objects.requireNonNull(comparator);
        return comparator;
    }

    public /* bridge */ /* synthetic */ void B0(Table table) {
        super.B0(table);
    }

    public /* bridge */ /* synthetic */ boolean D(@CheckForNull Object obj) {
        return super.D(obj);
    }

    public /* bridge */ /* synthetic */ Map E(Object obj) {
        return super.E(obj);
    }

    public /* bridge */ /* synthetic */ Set I() {
        return super.I();
    }

    public /* bridge */ /* synthetic */ boolean I0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.I0(obj, obj2);
    }

    public /* bridge */ /* synthetic */ Map J0() {
        return super.J0();
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object N(Object obj, Object obj2, Object obj3) {
        return super.N(obj, obj2, obj3);
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public Iterator<C> i() {
        final Comparator t = t();
        final UnmodifiableIterator<T> O = Iterators.O(Iterables.T(this.Y.values(), new F()), t);
        return new AbstractIterator<C>(this) {
            @CheckForNull
            C Y;

            /* access modifiers changed from: protected */
            /* JADX WARNING: Removed duplicated region for block: B:2:0x0008  */
            @javax.annotation.CheckForNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public C a() {
                /*
                    r3 = this;
                L_0x0000:
                    java.util.Iterator r0 = r1
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L_0x001e
                    java.util.Iterator r0 = r1
                    java.lang.Object r0 = r0.next()
                    C r1 = r3.Y
                    if (r1 == 0) goto L_0x001b
                    java.util.Comparator r2 = r0
                    int r1 = r2.compare(r0, r1)
                    if (r1 != 0) goto L_0x001b
                    goto L_0x0000
                L_0x001b:
                    r3.Y = r0
                    return r0
                L_0x001e:
                    r0 = 0
                    r3.Y = r0
                    java.lang.Object r0 = r3.b()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeBasedTable.AnonymousClass1.a():java.lang.Object");
            }
        };
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ Set j0() {
        return super.j0();
    }

    public /* bridge */ /* synthetic */ boolean m0(@CheckForNull Object obj) {
        return super.m0(obj);
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Deprecated
    public Comparator<? super C> t() {
        return this.c3;
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    /* renamed from: y */
    public SortedMap<C, V> P0(R r) {
        return new TreeRow(this, r);
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Object z(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.z(obj, obj2);
    }

    public SortedMap<R, Map<C, V>> m() {
        return super.m();
    }

    public SortedSet<R> n() {
        return super.n();
    }
}
