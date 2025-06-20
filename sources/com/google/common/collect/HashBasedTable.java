package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
public class HashBasedTable<R, C, V> extends StandardTable<R, C, V> {
    private static final long b3 = 0;

    private static class Factory<C, V> implements Supplier<Map<C, V>>, Serializable {
        private static final long X = 0;
        final int s;

        Factory(int i2) {
            this.s = i2;
        }

        /* renamed from: a */
        public Map<C, V> get() {
            return Maps.e0(this.s);
        }
    }

    HashBasedTable(Map<R, Map<C, V>> map, Factory<C, V> factory) {
        super(map, factory);
    }

    public static <R, C, V> HashBasedTable<R, C, V> p() {
        return new HashBasedTable<>(new LinkedHashMap(), new Factory(0));
    }

    public static <R, C, V> HashBasedTable<R, C, V> q(int i2, int i3) {
        CollectPreconditions.b(i3, "expectedCellsPerRow");
        return new HashBasedTable<>(Maps.e0(i2), new Factory(i3));
    }

    public static <R, C, V> HashBasedTable<R, C, V> r(Table<? extends R, ? extends C, ? extends V> table) {
        HashBasedTable<R, C, V> p = p();
        p.B0(table);
        return p;
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

    public /* bridge */ /* synthetic */ Map P0(Object obj) {
        return super.P0(obj);
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

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ Set j0() {
        return super.j0();
    }

    public /* bridge */ /* synthetic */ Map m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ boolean m0(@CheckForNull Object obj) {
        return super.m0(obj);
    }

    public /* bridge */ /* synthetic */ Set n() {
        return super.n();
    }

    @CheckForNull
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Object z(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.z(obj, obj2);
    }
}
