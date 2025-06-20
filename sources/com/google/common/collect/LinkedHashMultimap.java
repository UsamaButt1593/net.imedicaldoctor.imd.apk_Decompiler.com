package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    private static final int e3 = 16;
    private static final int f3 = 2;
    @VisibleForTesting
    static final double g3 = 1.0d;
    @GwtIncompatible
    @J2ktIncompatible
    private static final long h3 = 1;
    @VisibleForTesting
    transient int c3 = 2;
    /* access modifiers changed from: private */
    public transient ValueEntry<K, V> d3;

    @VisibleForTesting
    static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements ValueSetLink<K, V> {
        @CheckForNull
        ValueEntry<K, V> X2;
        @CheckForNull
        ValueSetLink<K, V> Y2;
        final int Z;
        @CheckForNull
        ValueSetLink<K, V> Z2;
        @CheckForNull
        ValueEntry<K, V> a3;
        @CheckForNull
        ValueEntry<K, V> b3;

        ValueEntry(@ParametricNullness K k2, @ParametricNullness V v, int i2, @CheckForNull ValueEntry<K, V> valueEntry) {
            super(k2, v);
            this.Z = i2;
            this.X2 = valueEntry;
        }

        static <K, V> ValueEntry<K, V> h() {
            return new ValueEntry<>((Object) null, (Object) null, 0, (ValueEntry) null);
        }

        public ValueEntry<K, V> a() {
            ValueEntry<K, V> valueEntry = this.a3;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        public void b(ValueSetLink<K, V> valueSetLink) {
            this.Z2 = valueSetLink;
        }

        public ValueSetLink<K, V> c() {
            ValueSetLink<K, V> valueSetLink = this.Y2;
            Objects.requireNonNull(valueSetLink);
            return valueSetLink;
        }

        public ValueSetLink<K, V> d() {
            ValueSetLink<K, V> valueSetLink = this.Z2;
            Objects.requireNonNull(valueSetLink);
            return valueSetLink;
        }

        public ValueEntry<K, V> e() {
            ValueEntry<K, V> valueEntry = this.b3;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        /* access modifiers changed from: package-private */
        public boolean f(@CheckForNull Object obj, int i2) {
            return this.Z == i2 && com.google.common.base.Objects.a(getValue(), obj);
        }

        public void g(ValueSetLink<K, V> valueSetLink) {
            this.Y2 = valueSetLink;
        }

        public void i(ValueEntry<K, V> valueEntry) {
            this.a3 = valueEntry;
        }

        public void j(ValueEntry<K, V> valueEntry) {
            this.b3 = valueEntry;
        }
    }

    @VisibleForTesting
    final class ValueSet extends Sets.ImprovedAbstractSet<V> implements ValueSetLink<K, V> {
        @VisibleForTesting
        ValueEntry<K, V>[] X;
        /* access modifiers changed from: private */
        public ValueSetLink<K, V> X2;
        private int Y = 0;
        private ValueSetLink<K, V> Y2;
        /* access modifiers changed from: private */
        public int Z = 0;
        @ParametricNullness
        private final K s;

        ValueSet(@ParametricNullness K k2, int i2) {
            this.s = k2;
            this.X2 = this;
            this.Y2 = this;
            this.X = new ValueEntry[Hashing.a(i2, 1.0d)];
        }

        private int k() {
            return this.X.length - 1;
        }

        private void m() {
            if (Hashing.b(this.Y, this.X.length, 1.0d)) {
                int length = this.X.length * 2;
                ValueEntry<K, V>[] valueEntryArr = new ValueEntry[length];
                this.X = valueEntryArr;
                int i2 = length - 1;
                for (ValueSetLink valueSetLink = this.X2; valueSetLink != this; valueSetLink = valueSetLink.d()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) valueSetLink;
                    int i3 = valueEntry.Z & i2;
                    valueEntry.X2 = valueEntryArr[i3];
                    valueEntryArr[i3] = valueEntry;
                }
            }
        }

        public boolean add(@ParametricNullness V v) {
            int d2 = Hashing.d(v);
            int k2 = k() & d2;
            ValueEntry<K, V> valueEntry = this.X[k2];
            for (ValueEntry<K, V> valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.X2) {
                if (valueEntry2.f(v, d2)) {
                    return false;
                }
            }
            ValueEntry<K, V> valueEntry3 = new ValueEntry<>(this.s, v, d2, valueEntry);
            LinkedHashMultimap.V(this.Y2, valueEntry3);
            LinkedHashMultimap.V(valueEntry3, this);
            LinkedHashMultimap.U(LinkedHashMultimap.this.d3.a(), valueEntry3);
            LinkedHashMultimap.U(valueEntry3, LinkedHashMultimap.this.d3);
            this.X[k2] = valueEntry3;
            this.Y++;
            this.Z++;
            m();
            return true;
        }

        public void b(ValueSetLink<K, V> valueSetLink) {
            this.X2 = valueSetLink;
        }

        public ValueSetLink<K, V> c() {
            return this.Y2;
        }

        public void clear() {
            Arrays.fill(this.X, (Object) null);
            this.Y = 0;
            for (ValueSetLink<K, V> valueSetLink = this.X2; valueSetLink != this; valueSetLink = valueSetLink.d()) {
                LinkedHashMultimap.R((ValueEntry) valueSetLink);
            }
            LinkedHashMultimap.V(this, this);
            this.Z++;
        }

        public boolean contains(@CheckForNull Object obj) {
            int d2 = Hashing.d(obj);
            for (ValueEntry<K, V> valueEntry = this.X[k() & d2]; valueEntry != null; valueEntry = valueEntry.X2) {
                if (valueEntry.f(obj, d2)) {
                    return true;
                }
            }
            return false;
        }

        public ValueSetLink<K, V> d() {
            return this.X2;
        }

        public void g(ValueSetLink<K, V> valueSetLink) {
            this.Y2 = valueSetLink;
        }

        public Iterator<V> iterator() {
            return new Iterator<V>() {
                @CheckForNull
                ValueEntry<K, V> X;
                int Y;
                ValueSetLink<K, V> s;

                {
                    this.s = ValueSet.this.X2;
                    this.Y = ValueSet.this.Z;
                }

                private void a() {
                    if (ValueSet.this.Z != this.Y) {
                        throw new ConcurrentModificationException();
                    }
                }

                public boolean hasNext() {
                    a();
                    return this.s != ValueSet.this;
                }

                @ParametricNullness
                public V next() {
                    if (hasNext()) {
                        ValueEntry<K, V> valueEntry = (ValueEntry) this.s;
                        V value = valueEntry.getValue();
                        this.X = valueEntry;
                        this.s = valueEntry.d();
                        return value;
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    a();
                    Preconditions.h0(this.X != null, "no calls to next() since the last call to remove()");
                    ValueSet.this.remove(this.X.getValue());
                    this.Y = ValueSet.this.Z;
                    this.X = null;
                }
            };
        }

        @CanIgnoreReturnValue
        public boolean remove(@CheckForNull Object obj) {
            int d2 = Hashing.d(obj);
            int k2 = k() & d2;
            ValueEntry<K, V> valueEntry = null;
            for (ValueEntry<K, V> valueEntry2 = this.X[k2]; valueEntry2 != null; valueEntry2 = valueEntry2.X2) {
                if (valueEntry2.f(obj, d2)) {
                    if (valueEntry == null) {
                        this.X[k2] = valueEntry2.X2;
                    } else {
                        valueEntry.X2 = valueEntry2.X2;
                    }
                    LinkedHashMultimap.S(valueEntry2);
                    LinkedHashMultimap.R(valueEntry2);
                    this.Y--;
                    this.Z++;
                    return true;
                }
                valueEntry = valueEntry2;
            }
            return false;
        }

        public int size() {
            return this.Y;
        }
    }

    private interface ValueSetLink<K, V> {
        void b(ValueSetLink<K, V> valueSetLink);

        ValueSetLink<K, V> c();

        ValueSetLink<K, V> d();

        void g(ValueSetLink<K, V> valueSetLink);
    }

    private LinkedHashMultimap(int i2, int i3) {
        super(Platform.f(i2));
        CollectPreconditions.b(i3, "expectedValuesPerKey");
        this.c3 = i3;
        ValueEntry<K, V> h2 = ValueEntry.h();
        this.d3 = h2;
        U(h2, h2);
    }

    public static <K, V> LinkedHashMultimap<K, V> O() {
        return new LinkedHashMultimap<>(16, 2);
    }

    public static <K, V> LinkedHashMultimap<K, V> P(int i2, int i3) {
        return new LinkedHashMultimap<>(Maps.o(i2), Maps.o(i3));
    }

    public static <K, V> LinkedHashMultimap<K, V> Q(Multimap<? extends K, ? extends V> multimap) {
        LinkedHashMultimap<K, V> P = P(multimap.keySet().size(), 2);
        P.Z(multimap);
        return P;
    }

    /* access modifiers changed from: private */
    public static <K, V> void R(ValueEntry<K, V> valueEntry) {
        U(valueEntry.a(), valueEntry.e());
    }

    /* access modifiers changed from: private */
    public static <K, V> void S(ValueSetLink<K, V> valueSetLink) {
        V(valueSetLink.c(), valueSetLink.d());
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void T(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        ValueEntry<K, V> h2 = ValueEntry.h();
        this.d3 = h2;
        U(h2, h2);
        this.c3 = 2;
        int readInt = objectInputStream.readInt();
        Map f2 = Platform.f(12);
        for (int i2 = 0; i2 < readInt; i2++) {
            Object readObject = objectInputStream.readObject();
            f2.put(readObject, v(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i3 = 0; i3 < readInt2; i3++) {
            Object readObject2 = objectInputStream.readObject();
            Object readObject3 = objectInputStream.readObject();
            Collection collection = (Collection) f2.get(readObject2);
            Objects.requireNonNull(collection);
            collection.add(readObject3);
        }
        C(f2);
    }

    /* access modifiers changed from: private */
    public static <K, V> void U(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        valueEntry.j(valueEntry2);
        valueEntry2.i(valueEntry);
    }

    /* access modifiers changed from: private */
    public static <K, V> void V(ValueSetLink<K, V> valueSetLink, ValueSetLink<K, V> valueSetLink2) {
        valueSetLink.b(valueSetLink2);
        valueSetLink2.g(valueSetLink);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void X(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        for (Object writeObject : keySet()) {
            objectOutputStream.writeObject(writeObject);
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry entry : j()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: H */
    public Set<V> u() {
        return Platform.g(this.c3);
    }

    public /* bridge */ /* synthetic */ boolean N0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.N0(obj, obj2);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean T0(@ParametricNullness Object obj, Iterable iterable) {
        return super.T0(obj, iterable);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean Z(Multimap multimap) {
        return super.Z(multimap);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Set b(@CheckForNull Object obj) {
        return super.b(obj);
    }

    public void clear() {
        super.clear();
        ValueEntry<K, V> valueEntry = this.d3;
        U(valueEntry, valueEntry);
    }

    public /* bridge */ /* synthetic */ boolean containsKey(@CheckForNull Object obj) {
        return super.containsKey(obj);
    }

    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    public /* bridge */ /* synthetic */ Multiset d0() {
        return super.d0();
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ Map g() {
        return super.g();
    }

    public /* bridge */ /* synthetic */ Set get(@ParametricNullness Object obj) {
        return super.get(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> i() {
        return new Iterator<Map.Entry<K, V>>() {
            @CheckForNull
            ValueEntry<K, V> X;
            ValueEntry<K, V> s;

            {
                this.s = LinkedHashMultimap.this.d3.e();
            }

            /* renamed from: a */
            public Map.Entry<K, V> next() {
                if (hasNext()) {
                    ValueEntry<K, V> valueEntry = this.s;
                    this.X = valueEntry;
                    this.s = valueEntry.e();
                    return valueEntry;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                return this.s != LinkedHashMultimap.this.d3;
            }

            public void remove() {
                Preconditions.h0(this.X != null, "no calls to next() since the last call to remove()");
                LinkedHashMultimap.this.remove(this.X.getKey(), this.X.getValue());
                this.X = null;
            }
        };
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public Set<K> keySet() {
        return super.keySet();
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> l() {
        return Maps.P0(i());
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean put(@ParametricNullness Object obj, @ParametricNullness Object obj2) {
        return super.put(obj, obj2);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* access modifiers changed from: package-private */
    public Collection<V> v(@ParametricNullness K k2) {
        return new ValueSet(k2, this.c3);
    }

    public Collection<V> values() {
        return super.values();
    }

    @CanIgnoreReturnValue
    public Set<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        return super.c((Object) k2, (Iterable) iterable);
    }

    public Set<Map.Entry<K, V>> j() {
        return super.j();
    }
}
