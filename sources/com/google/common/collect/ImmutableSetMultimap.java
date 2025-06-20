package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Serialization;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long e3 = 0;
    private final transient ImmutableSet<V> b3;
    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableSetMultimap<V, K> c3;
    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<Map.Entry<K, V>> d3;

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        /* access modifiers changed from: package-private */
        public Collection<V> c() {
            return Platform.h();
        }

        /* renamed from: l */
        public ImmutableSetMultimap<K, V> a() {
            Collection entrySet = this.f22398a.entrySet();
            Comparator comparator = this.f22399b;
            if (comparator != null) {
                entrySet = Ordering.i(comparator).C().l(entrySet);
            }
            return ImmutableSetMultimap.R(entrySet, this.f22400c);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        /* renamed from: m */
        public Builder<K, V> b(ImmutableMultimap.Builder<K, V> builder) {
            super.b(builder);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: n */
        public Builder<K, V> d(Comparator<? super K> comparator) {
            super.d(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: o */
        public Builder<K, V> e(Comparator<? super V> comparator) {
            super.e(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: p */
        public Builder<K, V> f(K k2, V v) {
            super.f(k2, v);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: q */
        public Builder<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            super.g(entry);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: r */
        public Builder<K, V> h(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry next : multimap.g().entrySet()) {
                j(next.getKey(), (Iterable) next.getValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: s */
        public Builder<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.i(iterable);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: t */
        public Builder<K, V> j(K k2, Iterable<? extends V> iterable) {
            super.j(k2, iterable);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: u */
        public Builder<K, V> k(K k2, V... vArr) {
            return j(k2, Arrays.asList(vArr));
        }
    }

    private static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        @Weak
        private final transient ImmutableSetMultimap<K, V> Y2;

        EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.Y2 = immutableSetMultimap;
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.Y2.N0(entry.getKey(), entry.getValue());
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return false;
        }

        /* renamed from: k */
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.Y2.i();
        }

        public int size() {
            return this.Y2.size();
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static final class SetFieldSettersHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Serialization.FieldSetter<ImmutableSetMultimap> f22410a = Serialization.a(ImmutableSetMultimap.class, "emptySet");

        private SetFieldSettersHolder() {
        }
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i2, @CheckForNull Comparator<? super V> comparator) {
        super(immutableMap, i2);
        this.b3 = P(comparator);
    }

    public static <K, V> Builder<K, V> L() {
        return new Builder<>();
    }

    public static <K, V> ImmutableSetMultimap<K, V> M(Multimap<? extends K, ? extends V> multimap) {
        return N(multimap, (Comparator) null);
    }

    private static <K, V> ImmutableSetMultimap<K, V> N(Multimap<? extends K, ? extends V> multimap, @CheckForNull Comparator<? super V> comparator) {
        Preconditions.E(multimap);
        if (multimap.isEmpty() && comparator == null) {
            return V();
        }
        if (multimap instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) multimap;
            if (!immutableSetMultimap.x()) {
                return immutableSetMultimap;
            }
        }
        return R(multimap.g().entrySet(), comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> O(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder().i(iterable).a();
    }

    private static <V> ImmutableSet<V> P(@CheckForNull Comparator<? super V> comparator) {
        return comparator == null ? ImmutableSet.K() : ImmutableSortedSet.u0(comparator);
    }

    static <K, V> ImmutableSetMultimap<K, V> R(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @CheckForNull Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return V();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        int i2 = 0;
        for (Map.Entry entry : collection) {
            Object key = entry.getKey();
            ImmutableSet<V> j0 = j0(comparator, (Collection) entry.getValue());
            if (!j0.isEmpty()) {
                builder.i(key, j0);
                i2 += j0.size();
            }
        }
        return new ImmutableSetMultimap<>(builder.d(), i2, comparator);
    }

    private ImmutableSetMultimap<V, K> U() {
        Builder L = L();
        UnmodifiableIterator k2 = t().iterator();
        while (k2.hasNext()) {
            Map.Entry entry = (Map.Entry) k2.next();
            L.f(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> l2 = L.a();
        l2.c3 = this;
        return l2;
    }

    public static <K, V> ImmutableSetMultimap<K, V> V() {
        return EmptyImmutableSetMultimap.f3;
    }

    public static <K, V> ImmutableSetMultimap<K, V> X(K k2, V v) {
        Builder L = L();
        L.f(k2, v);
        return L.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> Y(K k2, V v, K k3, V v2) {
        Builder L = L();
        L.f(k2, v);
        L.f(k3, v2);
        return L.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> a0(K k2, V v, K k3, V v2, K k4, V v3) {
        Builder L = L();
        L.f(k2, v);
        L.f(k3, v2);
        L.f(k4, v3);
        return L.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> b0(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4) {
        Builder L = L();
        L.f(k2, v);
        L.f(k3, v2);
        L.f(k4, v3);
        L.f(k5, v4);
        return L.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> c0(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5) {
        Builder L = L();
        L.f(k2, v);
        L.f(k3, v2);
        L.f(k4, v3);
        L.f(k5, v4);
        L.f(k6, v5);
        return L.a();
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void e0(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.Builder b2 = ImmutableMap.b();
            int i2 = 0;
            int i3 = 0;
            while (i2 < readInt) {
                Object readObject = objectInputStream.readObject();
                Objects.requireNonNull(readObject);
                int readInt2 = objectInputStream.readInt();
                if (readInt2 > 0) {
                    ImmutableSet.Builder k0 = k0(comparator);
                    for (int i4 = 0; i4 < readInt2; i4++) {
                        Object readObject2 = objectInputStream.readObject();
                        Objects.requireNonNull(readObject2);
                        k0.g(readObject2);
                    }
                    ImmutableSet o = k0.e();
                    if (o.size() == readInt2) {
                        b2.i(readObject, o);
                        i3 += readInt2;
                        i2++;
                    } else {
                        throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
                    }
                } else {
                    throw new InvalidObjectException("Invalid value count " + readInt2);
                }
            }
            try {
                ImmutableMultimap.FieldSettersHolder.f22401a.b(this, b2.d());
                ImmutableMultimap.FieldSettersHolder.f22402b.a(this, i3);
                SetFieldSettersHolder.f22410a.b(this, P(comparator));
            } catch (IllegalArgumentException e2) {
                throw ((InvalidObjectException) new InvalidObjectException(e2.getMessage()).initCause(e2));
            }
        } else {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
    }

    private static <V> ImmutableSet<V> j0(@CheckForNull Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? ImmutableSet.C(collection) : ImmutableSortedSet.k0(comparator, collection);
    }

    private static <V> ImmutableSet.Builder<V> k0(@CheckForNull Comparator<? super V> comparator) {
        return comparator == null ? new ImmutableSet.Builder<>() : new ImmutableSortedSet.Builder(comparator);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void l0(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(i0());
        Serialization.j(this, objectOutputStream);
    }

    /* renamed from: Q */
    public ImmutableSet<Map.Entry<K, V>> t() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.d3;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.d3 = entrySet;
        return entrySet;
    }

    /* renamed from: S */
    public ImmutableSet<V> v(K k2) {
        return (ImmutableSet) MoreObjects.a((ImmutableSet) this.Y2.get(k2), this.b3);
    }

    /* renamed from: T */
    public ImmutableSetMultimap<V, K> w() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.c3;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<V, K> U = U();
        this.c3 = U;
        return U;
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    /* renamed from: f0 */
    public final ImmutableSet<V> b(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    /* renamed from: h0 */
    public final ImmutableSet<V> c(K k2, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public Comparator<? super V> i0() {
        ImmutableSet<V> immutableSet = this.b3;
        if (immutableSet instanceof ImmutableSortedSet) {
            return ((ImmutableSortedSet) immutableSet).comparator();
        }
        return null;
    }
}
