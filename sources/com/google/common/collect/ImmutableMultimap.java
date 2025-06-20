package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import com.google.j2objc.annotations.Weak;
import com.itextpdf.tool.xml.html.HTML;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {
    @J2ktIncompatible
    private static final long a3 = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> Y2;
    final transient int Z2;

    @DoNotMock
    public static class Builder<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final Map<K, Collection<V>> f22398a = Platform.i();
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        Comparator<? super K> f22399b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Comparator<? super V> f22400c;

        public ImmutableMultimap<K, V> a() {
            Collection entrySet = this.f22398a.entrySet();
            Comparator comparator = this.f22399b;
            if (comparator != null) {
                entrySet = Ordering.i(comparator).C().l(entrySet);
            }
            return ImmutableListMultimap.O(entrySet, this.f22400c);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public Builder<K, V> b(Builder<K, V> builder) {
            for (Map.Entry next : builder.f22398a.entrySet()) {
                j(next.getKey(), (Iterable) next.getValue());
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public Collection<V> c() {
            return new ArrayList();
        }

        @CanIgnoreReturnValue
        public Builder<K, V> d(Comparator<? super K> comparator) {
            this.f22399b = (Comparator) Preconditions.E(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> e(Comparator<? super V> comparator) {
            this.f22400c = (Comparator) Preconditions.E(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> f(K k2, V v) {
            CollectPreconditions.a(k2, v);
            Collection collection = this.f22398a.get(k2);
            if (collection == null) {
                Map<K, Collection<V>> map = this.f22398a;
                Collection c2 = c();
                map.put(k2, c2);
                collection = c2;
            }
            collection.add(v);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        public Builder<K, V> h(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry next : multimap.g().entrySet()) {
                j(next.getKey(), (Iterable) next.getValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            for (Map.Entry g2 : iterable) {
                g(g2);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> j(K k2, Iterable<? extends V> iterable) {
            if (k2 != null) {
                Collection collection = this.f22398a.get(k2);
                Iterator<? extends V> it2 = iterable.iterator();
                if (collection != null) {
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        CollectPreconditions.a(k2, next);
                        collection.add(next);
                    }
                    return this;
                } else if (!it2.hasNext()) {
                    return this;
                } else {
                    Collection c2 = c();
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        CollectPreconditions.a(k2, next2);
                        c2.add(next2);
                    }
                    this.f22398a.put(k2, c2);
                    return this;
                }
            } else {
                throw new NullPointerException("null key in entry: null=" + Iterables.S(iterable));
            }
        }

        @CanIgnoreReturnValue
        public Builder<K, V> k(K k2, V... vArr) {
            return j(k2, Arrays.asList(vArr));
        }
    }

    private static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long Y = 0;
        @Weak
        final ImmutableMultimap<K, V> X;

        EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.X = immutableMultimap;
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.X.N0(entry.getKey(), entry.getValue());
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.X.x();
        }

        /* renamed from: k */
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.X.i();
        }

        public int size() {
            return this.X.size();
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    static class FieldSettersHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Serialization.FieldSetter<ImmutableMultimap> f22401a;

        /* renamed from: b  reason: collision with root package name */
        static final Serialization.FieldSetter<ImmutableMultimap> f22402b;

        static {
            Class<ImmutableMultimap> cls = ImmutableMultimap.class;
            f22401a = Serialization.a(cls, HTML.Tag.t0);
            f22402b = Serialization.a(cls, "size");
        }

        FieldSettersHolder() {
        }
    }

    class Keys extends ImmutableMultiset<K> {
        Keys() {
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use KeysSerializedForm");
        }

        /* renamed from: C */
        public ImmutableSet<K> e() {
            return ImmutableMultimap.this.keySet();
        }

        /* access modifiers changed from: package-private */
        public Multiset.Entry<K> E(int i2) {
            Map.Entry entry = ImmutableMultimap.this.Y2.entrySet().b().get(i2);
            return Multisets.k(entry.getKey(), ((Collection) entry.getValue()).size());
        }

        public boolean contains(@CheckForNull Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return true;
        }

        public int l1(@CheckForNull Object obj) {
            Collection collection = (Collection) ImmutableMultimap.this.Y2.get(obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public Object n() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }

        public int size() {
            return ImmutableMultimap.this.size();
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> s;

        KeysSerializedForm(ImmutableMultimap<?, ?> immutableMultimap) {
            this.s = immutableMultimap;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.s.d0();
        }
    }

    private static final class Values<K, V> extends ImmutableCollection<V> {
        @J2ktIncompatible
        private static final long Y = 0;
        @Weak
        private final transient ImmutableMultimap<K, V> X;

        Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.X = immutableMultimap;
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        public int c(Object[] objArr, int i2) {
            UnmodifiableIterator<? extends ImmutableCollection<V>> k2 = this.X.Y2.values().iterator();
            while (k2.hasNext()) {
                i2 = ((ImmutableCollection) k2.next()).c(objArr, i2);
            }
            return i2;
        }

        public boolean contains(@CheckForNull Object obj) {
            return this.X.containsValue(obj);
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return true;
        }

        /* renamed from: k */
        public UnmodifiableIterator<V> iterator() {
            return this.X.l();
        }

        public int size() {
            return this.X.size();
        }
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i2) {
        this.Y2 = immutableMap;
        this.Z2 = i2;
    }

    public static <K, V> ImmutableMultimap<K, V> A() {
        return ImmutableListMultimap.S();
    }

    public static <K, V> ImmutableMultimap<K, V> B(K k2, V v) {
        return ImmutableListMultimap.T(k2, v);
    }

    public static <K, V> ImmutableMultimap<K, V> C(K k2, V v, K k3, V v2) {
        return ImmutableListMultimap.U(k2, v, k3, v2);
    }

    public static <K, V> ImmutableMultimap<K, V> D(K k2, V v, K k3, V v2, K k4, V v3) {
        return ImmutableListMultimap.V(k2, v, k3, v2, k4, v3);
    }

    public static <K, V> ImmutableMultimap<K, V> E(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4) {
        return ImmutableListMultimap.X(k2, v, k3, v2, k4, v3, k5, v4);
    }

    public static <K, V> ImmutableMultimap<K, V> F(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5) {
        return ImmutableListMultimap.Y(k2, v, k3, v2, k4, v3, k5, v4, k6, v5);
    }

    public static <K, V> Builder<K, V> n() {
        return new Builder<>();
    }

    public static <K, V> ImmutableMultimap<K, V> o(Multimap<? extends K, ? extends V> multimap) {
        if (multimap instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) multimap;
            if (!immutableMultimap.x()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.M(multimap);
    }

    public static <K, V> ImmutableMultimap<K, V> p(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.N(iterable);
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    /* renamed from: H */
    public ImmutableCollection<V> b(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    /* renamed from: I */
    public ImmutableCollection<V> c(K k2, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public UnmodifiableIterator<V> l() {
        return new UnmodifiableIterator<V>() {
            Iterator<V> X = Iterators.u();
            Iterator<? extends ImmutableCollection<V>> s;

            {
                this.s = ImmutableMultimap.this.Y2.values().iterator();
            }

            public boolean hasNext() {
                return this.X.hasNext() || this.s.hasNext();
            }

            public V next() {
                if (!this.X.hasNext()) {
                    this.X = ((ImmutableCollection) this.s.next()).iterator();
                }
                return this.X.next();
            }
        };
    }

    /* renamed from: K */
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public /* bridge */ /* synthetic */ boolean N0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.N0(obj, obj2);
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean T0(K k2, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean Z(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> a() {
        throw new AssertionError("should never be called");
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return this.Y2.containsKey(obj);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return obj != null && super.containsValue(obj);
    }

    /* access modifiers changed from: package-private */
    public Set<K> e() {
        throw new AssertionError("unreachable");
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

    /* renamed from: m */
    public ImmutableMap<K, Collection<V>> g() {
        return this.Y2;
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean put(K k2, V v) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public ImmutableCollection<Map.Entry<K, V>> d() {
        return new EntryCollection(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public ImmutableMultiset<K> f() {
        return new Keys();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public ImmutableCollection<V> h() {
        return new Values(this);
    }

    public int size() {
        return this.Z2;
    }

    /* renamed from: t */
    public ImmutableCollection<Map.Entry<K, V>> j() {
        return (ImmutableCollection) super.j();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public UnmodifiableIterator<Map.Entry<K, V>> i() {
        return new UnmodifiableIterator<Map.Entry<K, V>>() {
            @CheckForNull
            K X = null;
            Iterator<V> Y = Iterators.u();
            final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> s;

            {
                this.s = ImmutableMultimap.this.Y2.entrySet().iterator();
            }

            /* renamed from: a */
            public Map.Entry<K, V> next() {
                if (!this.Y.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.s.next();
                    this.X = entry.getKey();
                    this.Y = ((ImmutableCollection) entry.getValue()).iterator();
                }
                K k2 = this.X;
                Objects.requireNonNull(k2);
                return Maps.O(k2, this.Y.next());
            }

            public boolean hasNext() {
                return this.Y.hasNext() || this.s.hasNext();
            }
        };
    }

    /* renamed from: v */
    public abstract ImmutableCollection<V> get(K k2);

    public abstract ImmutableMultimap<V, K> w();

    /* access modifiers changed from: package-private */
    public boolean x() {
        return this.Y2.n();
    }

    /* renamed from: y */
    public ImmutableSet<K> keySet() {
        return this.Y2.keySet();
    }

    /* renamed from: z */
    public ImmutableMultiset<K> d0() {
        return (ImmutableMultiset) super.d0();
    }
}
