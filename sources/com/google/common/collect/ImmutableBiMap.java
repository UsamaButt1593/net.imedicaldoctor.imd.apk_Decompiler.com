package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public Builder() {
        }

        /* renamed from: n */
        public ImmutableBiMap<K, V> a() {
            return d();
        }

        @DoNotCall
        @Deprecated
        /* renamed from: o */
        public ImmutableBiMap<K, V> c() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        /* renamed from: p */
        public ImmutableBiMap<K, V> d() {
            int i2 = this.f22392c;
            if (i2 == 0) {
                return ImmutableBiMap.Q();
            }
            if (this.f22390a != null) {
                if (this.f22393d) {
                    this.f22391b = Arrays.copyOf(this.f22391b, i2 * 2);
                }
                ImmutableMap.Builder.m(this.f22391b, this.f22392c, this.f22390a);
            }
            this.f22393d = true;
            return new RegularImmutableBiMap(this.f22391b, this.f22392c);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        /* renamed from: q */
        public Builder<K, V> e(ImmutableMap.Builder<K, V> builder) {
            super.e(builder);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: r */
        public Builder<K, V> h(Comparator<? super V> comparator) {
            super.h(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: s */
        public Builder<K, V> i(K k2, V v) {
            super.i(k2, v);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: t */
        public Builder<K, V> j(Map.Entry<? extends K, ? extends V> entry) {
            super.j(entry);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: u */
        public Builder<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.k(iterable);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: v */
        public Builder<K, V> l(Map<? extends K, ? extends V> map) {
            super.l(map);
            return this;
        }

        Builder(int i2) {
            super(i2);
        }
    }

    @J2ktIncompatible
    private static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long X2 = 0;

        SerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            super(immutableBiMap);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public Builder<K, V> b(int i2) {
            return new Builder<>(i2);
        }
    }

    ImmutableBiMap() {
    }

    @J2ktIncompatible
    private void F(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <K, V> Builder<K, V> J() {
        return new Builder<>();
    }

    public static <K, V> Builder<K, V> K(int i2) {
        CollectPreconditions.b(i2, "expectedSize");
        return new Builder<>(i2);
    }

    public static <K, V> ImmutableBiMap<K, V> M(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4).k(iterable).a();
    }

    public static <K, V> ImmutableBiMap<K, V> N(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.n()) {
                return immutableBiMap;
            }
        }
        return M(map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> Q() {
        return RegularImmutableBiMap.d3;
    }

    public static <K, V> ImmutableBiMap<K, V> R(K k2, V v) {
        CollectPreconditions.a(k2, v);
        return new RegularImmutableBiMap(new Object[]{k2, v}, 1);
    }

    public static <K, V> ImmutableBiMap<K, V> S(K k2, V v, K k3, V v2) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        return new RegularImmutableBiMap(new Object[]{k2, v, k3, v2}, 2);
    }

    public static <K, V> ImmutableBiMap<K, V> T(K k2, V v, K k3, V v2, K k4, V v3) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        return new RegularImmutableBiMap(new Object[]{k2, v, k3, v2, k4, v3}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> U(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        return new RegularImmutableBiMap(new Object[]{k2, v, k3, v2, k4, v3, k5, v4}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> V(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        return new RegularImmutableBiMap(new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5}, 5);
    }

    public static <K, V> ImmutableBiMap<K, V> W(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        return new RegularImmutableBiMap(new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5, k7, v6}, 6);
    }

    public static <K, V> ImmutableBiMap<K, V> X(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        return new RegularImmutableBiMap(new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5, k7, v6, k8, v7}, 7);
    }

    public static <K, V> ImmutableBiMap<K, V> Y(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        return new RegularImmutableBiMap(new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8}, 8);
    }

    public static <K, V> ImmutableBiMap<K, V> Z(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        return new RegularImmutableBiMap(new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9}, 9);
    }

    public static <K, V> ImmutableBiMap<K, V> a0(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9, K k11, V v10) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        CollectPreconditions.a(k11, v10);
        return new RegularImmutableBiMap(new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9, k11, v10}, 10);
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> b0(Map.Entry<? extends K, ? extends V>... entryArr) {
        return M(Arrays.asList(entryArr));
    }

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object I() {
        return new SerializedForm(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: O */
    public final ImmutableSet<V> j() {
        throw new AssertionError("should never be called");
    }

    /* renamed from: P */
    public abstract ImmutableBiMap<V, K> q2();

    /* renamed from: c0 */
    public ImmutableSet<V> values() {
        return q2().keySet();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final V k0(K k2, V v) {
        throw new UnsupportedOperationException();
    }
}
