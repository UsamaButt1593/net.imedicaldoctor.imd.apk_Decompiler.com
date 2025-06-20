package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final Map<TypeToken<? extends B>, B> s = Maps.Y();

    private static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> s;

        private UnmodifiableEntry(Map.Entry<K, V> entry) {
            this.s = (Map.Entry) Preconditions.E(entry);
        }

        public static /* synthetic */ UnmodifiableEntry n1(Map.Entry entry) {
            return new UnmodifiableEntry(entry);
        }

        /* access modifiers changed from: private */
        public static <K, V> Iterator<Map.Entry<K, V>> p1(Iterator<Map.Entry<K, V>> it2) {
            return Iterators.c0(it2, new b());
        }

        static <K, V> Set<Map.Entry<K, V>> q1(final Set<Map.Entry<K, V>> set) {
            return new ForwardingSet<Map.Entry<K, V>>() {
                /* access modifiers changed from: protected */
                /* renamed from: E1 */
                public Set<Map.Entry<K, V>> a1() {
                    return set;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return UnmodifiableEntry.p1(super.iterator());
                }

                public Object[] toArray() {
                    return v1();
                }

                public <T> T[] toArray(T[] tArr) {
                    return x1(tArr);
                }
            };
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Map.Entry<K, V> Z0() {
            return this.s;
        }

        @ParametricNullness
        public V setValue(@ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }
    }

    @CheckForNull
    private <T extends B> T B1(TypeToken<T> typeToken) {
        return this.s.get(typeToken);
    }

    @CheckForNull
    private <T extends B> T E1(TypeToken<T> typeToken, @ParametricNullness T t) {
        return this.s.put(typeToken, t);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public <T extends B> T G0(TypeToken<T> typeToken, @ParametricNullness T t) {
        return E1(typeToken.V(), t);
    }

    @CheckForNull
    public <T extends B> T L(TypeToken<T> typeToken) {
        return B1(typeToken.V());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public Map<TypeToken<? extends B>, B> Z0() {
        return this.s;
    }

    public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return UnmodifiableEntry.q1(super.entrySet());
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public <T extends B> T q(Class<T> cls, @ParametricNullness T t) {
        return E1(TypeToken.T(cls), t);
    }

    @CheckForNull
    public <T extends B> T r(Class<T> cls) {
        return B1(TypeToken.T(cls));
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    /* renamed from: x1 */
    public B put(TypeToken<? extends B> typeToken, @ParametricNullness B b2) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }
}
