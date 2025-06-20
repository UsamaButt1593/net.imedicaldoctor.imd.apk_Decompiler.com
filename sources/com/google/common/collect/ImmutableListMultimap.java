package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long c3 = 0;
    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableListMultimap<V, K> b3;

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        /* renamed from: l */
        public ImmutableListMultimap<K, V> a() {
            return (ImmutableListMultimap) super.a();
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
            super.h(multimap);
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
            super.k(k2, vArr);
            return this;
        }
    }

    ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i2) {
        super(immutableMap, i2);
    }

    public static <K, V> Builder<K, V> L() {
        return new Builder<>();
    }

    public static <K, V> ImmutableListMultimap<K, V> M(Multimap<? extends K, ? extends V> multimap) {
        if (multimap.isEmpty()) {
            return S();
        }
        if (multimap instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) multimap;
            if (!immutableListMultimap.x()) {
                return immutableListMultimap;
            }
        }
        return O(multimap.g().entrySet(), (Comparator) null);
    }

    public static <K, V> ImmutableListMultimap<K, V> N(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder().i(iterable).a();
    }

    static <K, V> ImmutableListMultimap<K, V> O(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @CheckForNull Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return S();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        int i2 = 0;
        for (Map.Entry entry : collection) {
            Object key = entry.getKey();
            Collection collection2 = (Collection) entry.getValue();
            ImmutableList<E> B = comparator == null ? ImmutableList.B(collection2) : ImmutableList.a0(comparator, collection2);
            if (!B.isEmpty()) {
                builder.i(key, B);
                i2 += B.size();
            }
        }
        return new ImmutableListMultimap<>(builder.d(), i2);
    }

    private ImmutableListMultimap<V, K> R() {
        Builder L = L();
        UnmodifiableIterator k2 = j().iterator();
        while (k2.hasNext()) {
            Map.Entry entry = (Map.Entry) k2.next();
            L.f(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> l2 = L.a();
        l2.b3 = this;
        return l2;
    }

    public static <K, V> ImmutableListMultimap<K, V> S() {
        return EmptyImmutableListMultimap.d3;
    }

    public static <K, V> ImmutableListMultimap<K, V> T(K k2, V v) {
        Builder L = L();
        L.f(k2, v);
        return L.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> U(K k2, V v, K k3, V v2) {
        Builder L = L();
        L.f(k2, v);
        L.f(k3, v2);
        return L.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> V(K k2, V v, K k3, V v2, K k4, V v3) {
        Builder L = L();
        L.f(k2, v);
        L.f(k3, v2);
        L.f(k4, v3);
        return L.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> X(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4) {
        Builder L = L();
        L.f(k2, v);
        L.f(k3, v2);
        L.f(k4, v3);
        L.f(k5, v4);
        return L.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> Y(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5) {
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
    private void a0(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
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
                    ImmutableList.Builder r = ImmutableList.r();
                    for (int i4 = 0; i4 < readInt2; i4++) {
                        Object readObject2 = objectInputStream.readObject();
                        Objects.requireNonNull(readObject2);
                        r.g(readObject2);
                    }
                    b2.i(readObject, r.e());
                    i3 += readInt2;
                    i2++;
                } else {
                    throw new InvalidObjectException("Invalid value count " + readInt2);
                }
            }
            try {
                ImmutableMultimap.FieldSettersHolder.f22401a.b(this, b2.d());
                ImmutableMultimap.FieldSettersHolder.f22402b.a(this, i3);
            } catch (IllegalArgumentException e2) {
                throw ((InvalidObjectException) new InvalidObjectException(e2.getMessage()).initCause(e2));
            }
        } else {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void e0(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.j(this, objectOutputStream);
    }

    /* renamed from: P */
    public ImmutableList<V> v(K k2) {
        ImmutableList<V> immutableList = (ImmutableList) this.Y2.get(k2);
        return immutableList == null ? ImmutableList.I() : immutableList;
    }

    /* renamed from: Q */
    public ImmutableListMultimap<V, K> w() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.b3;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        ImmutableListMultimap<V, K> R = R();
        this.b3 = R;
        return R;
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    /* renamed from: b0 */
    public final ImmutableList<V> b(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    /* renamed from: c0 */
    public final ImmutableList<V> c(K k2, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }
}
