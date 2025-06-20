package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.RegularImmutableMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> d3 = new RegularImmutableBiMap<>();
    @CheckForNull
    private final transient Object Y2;
    @VisibleForTesting
    final transient Object[] Z2;
    private final transient int a3;
    private final transient int b3;
    private final transient RegularImmutableBiMap<V, K> c3;

    private RegularImmutableBiMap() {
        this.Y2 = null;
        this.Z2 = new Object[0];
        this.a3 = 0;
        this.b3 = 0;
        this.c3 = this;
    }

    /* renamed from: P */
    public ImmutableBiMap<V, K> q2() {
        return this.c3;
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        V O = RegularImmutableMap.O(this.Y2, this.Z2, this.b3, this.a3, obj);
        if (O == null) {
            return null;
        }
        return O;
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<Map.Entry<K, V>> h() {
        return new RegularImmutableMap.EntrySet(this, this.Z2, this.a3, this.b3);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<K> i() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.Z2, this.a3, this.b3));
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return false;
    }

    public int size() {
        return this.b3;
    }

    private RegularImmutableBiMap(@CheckForNull Object obj, Object[] objArr, int i2, RegularImmutableBiMap<V, K> regularImmutableBiMap) {
        this.Y2 = obj;
        this.Z2 = objArr;
        this.a3 = 1;
        this.b3 = i2;
        this.c3 = regularImmutableBiMap;
    }

    RegularImmutableBiMap(Object[] objArr, int i2) {
        this.Z2 = objArr;
        this.b3 = i2;
        this.a3 = 0;
        int x = i2 >= 2 ? ImmutableSet.x(i2) : 0;
        this.Y2 = RegularImmutableMap.N(objArr, i2, x, 0);
        this.c3 = new RegularImmutableBiMap<>(RegularImmutableMap.N(objArr, i2, x, 1), objArr, i2, this);
    }
}
