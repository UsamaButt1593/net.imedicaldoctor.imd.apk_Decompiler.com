package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    final C X2;
    final V Y2;
    final R Z;

    SingletonImmutableTable(Table.Cell<R, C, V> cell) {
        this(cell.b(), cell.a(), cell.getValue());
    }

    /* renamed from: i */
    public ImmutableMap<R, V> E(C c2) {
        Preconditions.E(c2);
        return D(c2) ? ImmutableMap.t(this.Z, this.Y2) : ImmutableMap.s();
    }

    /* renamed from: k */
    public ImmutableMap<C, Map<R, V>> J0() {
        return ImmutableMap.t(this.X2, ImmutableMap.t(this.Z, this.Y2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public ImmutableSet<Table.Cell<R, C, V>> b() {
        return ImmutableSet.L(ImmutableTable.g(this.Z, this.X2, this.Y2));
    }

    /* access modifiers changed from: package-private */
    public ImmutableTable.SerializedForm q() {
        return ImmutableTable.SerializedForm.a(this, new int[]{0}, new int[]{0});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public ImmutableCollection<V> c() {
        return ImmutableSet.L(this.Y2);
    }

    public int size() {
        return 1;
    }

    /* renamed from: x */
    public ImmutableMap<R, Map<C, V>> m() {
        return ImmutableMap.t(this.Z, ImmutableMap.t(this.X2, this.Y2));
    }

    SingletonImmutableTable(R r, C c2, V v) {
        this.Z = Preconditions.E(r);
        this.X2 = Preconditions.E(c2);
        this.Y2 = Preconditions.E(v);
    }
}
