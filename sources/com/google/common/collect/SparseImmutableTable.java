package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"R", "C", "V"})
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    static final ImmutableTable<Object, Object, Object> a3 = new SparseImmutableTable(ImmutableList.I(), ImmutableSet.K(), ImmutableSet.K());
    private final ImmutableMap<C, ImmutableMap<R, V>> X2;
    private final int[] Y2;
    private final ImmutableMap<R, ImmutableMap<C, V>> Z;
    private final int[] Z2;

    SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap<R, Integer> Q = Maps.Q(immutableSet);
        LinkedHashMap c0 = Maps.c0();
        UnmodifiableIterator<R> k2 = immutableSet.iterator();
        while (k2.hasNext()) {
            c0.put(k2.next(), new LinkedHashMap());
        }
        LinkedHashMap c02 = Maps.c0();
        UnmodifiableIterator<C> k3 = immutableSet2.iterator();
        while (k3.hasNext()) {
            c02.put(k3.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i2 = 0; i2 < immutableList.size(); i2++) {
            Table.Cell cell = immutableList.get(i2);
            Object b2 = cell.b();
            Object a2 = cell.a();
            Object value = cell.getValue();
            Integer num = Q.get(b2);
            Objects.requireNonNull(num);
            iArr[i2] = num.intValue();
            Map map = (Map) c0.get(b2);
            Objects.requireNonNull(map);
            Map map2 = map;
            iArr2[i2] = map2.size();
            C(b2, a2, map2.put(a2, value), value);
            Map map3 = (Map) c02.get(a2);
            Objects.requireNonNull(map3);
            map3.put(b2, value);
        }
        this.Y2 = iArr;
        this.Z2 = iArr2;
        ImmutableMap.Builder builder = new ImmutableMap.Builder(c0.size());
        for (Map.Entry entry : c0.entrySet()) {
            builder.i(entry.getKey(), ImmutableMap.g((Map) entry.getValue()));
        }
        this.Z = builder.d();
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder(c02.size());
        for (Map.Entry entry2 : c02.entrySet()) {
            builder2.i(entry2.getKey(), ImmutableMap.g((Map) entry2.getValue()));
        }
        this.X2 = builder2.d();
    }

    /* access modifiers changed from: package-private */
    public Table.Cell<R, C, V> L(int i2) {
        Map.Entry entry = this.Z.entrySet().b().get(this.Y2[i2]);
        Map.Entry entry2 = (Map.Entry) ((ImmutableMap) entry.getValue()).entrySet().b().get(this.Z2[i2]);
        return ImmutableTable.g(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    /* access modifiers changed from: package-private */
    public V M(int i2) {
        int i3 = this.Y2[i2];
        return this.Z.values().b().get(i3).values().b().get(this.Z2[i2]);
    }

    /* renamed from: k */
    public ImmutableMap<C, Map<R, V>> J0() {
        return ImmutableMap.g(this.X2);
    }

    /* access modifiers changed from: package-private */
    public ImmutableTable.SerializedForm q() {
        ImmutableMap Q = Maps.Q(j0());
        int[] iArr = new int[I().size()];
        UnmodifiableIterator k2 = I().iterator();
        int i2 = 0;
        while (k2.hasNext()) {
            Integer num = (Integer) Q.get(((Table.Cell) k2.next()).a());
            Objects.requireNonNull(num);
            iArr[i2] = num.intValue();
            i2++;
        }
        return ImmutableTable.SerializedForm.a(this, this.Y2, iArr);
    }

    public int size() {
        return this.Y2.length;
    }

    /* renamed from: x */
    public ImmutableMap<R, Map<C, V>> m() {
        return ImmutableMap.g(this.Z);
    }
}
