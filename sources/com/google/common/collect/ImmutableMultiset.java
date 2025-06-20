package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {
    @CheckForNull
    @LazyInit
    private transient ImmutableList<E> X;
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<Multiset.Entry<E>> Y;

    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        ObjectCountHashMap<E> f22403b;

        /* renamed from: c  reason: collision with root package name */
        boolean f22404c;

        /* renamed from: d  reason: collision with root package name */
        boolean f22405d;

        public Builder() {
            this(4);
        }

        @CheckForNull
        static <T> ObjectCountHashMap<T> n(Iterable<T> iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return ((RegularImmutableMultiset) iterable).Z;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return ((AbstractMapBasedMultiset) iterable).Y;
            }
            return null;
        }

        @CanIgnoreReturnValue
        /* renamed from: g */
        public Builder<E> a(E e2) {
            return k(e2, 1);
        }

        @CanIgnoreReturnValue
        /* renamed from: h */
        public Builder<E> b(E... eArr) {
            super.b(eArr);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: i */
        public Builder<E> c(Iterable<? extends E> iterable) {
            Objects.requireNonNull(this.f22403b);
            if (iterable instanceof Multiset) {
                Multiset<? extends E> d2 = Multisets.d(iterable);
                ObjectCountHashMap<T> n2 = n(d2);
                if (n2 != null) {
                    ObjectCountHashMap<E> objectCountHashMap = this.f22403b;
                    objectCountHashMap.e(Math.max(objectCountHashMap.D(), n2.D()));
                    for (int f2 = n2.f(); f2 >= 0; f2 = n2.t(f2)) {
                        k(n2.j(f2), n2.l(f2));
                    }
                } else {
                    Set<Multiset.Entry<? extends E>> entrySet = d2.entrySet();
                    ObjectCountHashMap<E> objectCountHashMap2 = this.f22403b;
                    objectCountHashMap2.e(Math.max(objectCountHashMap2.D(), entrySet.size()));
                    for (Multiset.Entry next : d2.entrySet()) {
                        k(next.a(), next.getCount());
                    }
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: j */
        public Builder<E> d(Iterator<? extends E> it2) {
            super.d(it2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> k(E e2, int i2) {
            Objects.requireNonNull(this.f22403b);
            if (i2 == 0) {
                return this;
            }
            if (this.f22404c) {
                this.f22403b = new ObjectCountHashMap<>(this.f22403b);
                this.f22405d = false;
            }
            this.f22404c = false;
            Preconditions.E(e2);
            ObjectCountHashMap<E> objectCountHashMap = this.f22403b;
            objectCountHashMap.v(e2, i2 + objectCountHashMap.g(e2));
            return this;
        }

        /* renamed from: l */
        public ImmutableMultiset<E> e() {
            Objects.requireNonNull(this.f22403b);
            if (this.f22403b.D() == 0) {
                return ImmutableMultiset.H();
            }
            if (this.f22405d) {
                this.f22403b = new ObjectCountHashMap<>(this.f22403b);
                this.f22405d = false;
            }
            this.f22404c = true;
            return new RegularImmutableMultiset(this.f22403b);
        }

        @CanIgnoreReturnValue
        public Builder<E> m(E e2, int i2) {
            Objects.requireNonNull(this.f22403b);
            if (i2 == 0 && !this.f22405d) {
                this.f22403b = new ObjectCountLinkedHashMap(this.f22403b);
                this.f22405d = true;
            } else if (this.f22404c) {
                this.f22403b = new ObjectCountHashMap<>(this.f22403b);
                this.f22405d = false;
            }
            this.f22404c = false;
            Preconditions.E(e2);
            if (i2 == 0) {
                this.f22403b.w(e2);
            } else {
                this.f22403b.v(Preconditions.E(e2), i2);
            }
            return this;
        }

        Builder(int i2) {
            this.f22404c = false;
            this.f22405d = false;
            this.f22403b = ObjectCountHashMap.d(i2);
        }

        Builder(boolean z) {
            this.f22404c = false;
            this.f22405d = false;
            this.f22403b = null;
        }
    }

    private final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        @J2ktIncompatible
        private static final long Z2 = 0;

        private EntrySet() {
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use EntrySetSerializedForm");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: U */
        public Multiset.Entry<E> get(int i2) {
            return ImmutableMultiset.this.E(i2);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return entry.getCount() > 0 && ImmutableMultiset.this.l1(entry.a()) == entry.getCount();
        }

        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return ImmutableMultiset.this.j();
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public Object n() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }

        public int size() {
            return ImmutableMultiset.this.e().size();
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> s;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.s = immutableMultiset;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.s.entrySet();
        }
    }

    ImmutableMultiset() {
    }

    private ImmutableSet<Multiset.Entry<E>> B() {
        return isEmpty() ? ImmutableSet.K() : new EntrySet();
    }

    public static <E> ImmutableMultiset<E> H() {
        return RegularImmutableMultiset.Z2;
    }

    public static <E> ImmutableMultiset<E> I(E e2) {
        return q(e2);
    }

    public static <E> ImmutableMultiset<E> K(E e2, E e3) {
        return q(e2, e3);
    }

    public static <E> ImmutableMultiset<E> L(E e2, E e3, E e4) {
        return q(e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> M(E e2, E e3, E e4, E e5) {
        return q(e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> N(E e2, E e3, E e4, E e5, E e6) {
        return q(e2, e3, e4, e5, e6);
    }

    public static <E> ImmutableMultiset<E> O(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        return new Builder().a(e2).a(e3).a(e4).a(e5).a(e6).a(e7).b(eArr).e();
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> Builder<E> o() {
        return new Builder<>();
    }

    private static <E> ImmutableMultiset<E> q(E... eArr) {
        return new Builder().b(eArr).e();
    }

    static <E> ImmutableMultiset<E> r(Collection<? extends Multiset.Entry<? extends E>> collection) {
        Builder builder = new Builder(collection.size());
        for (Multiset.Entry entry : collection) {
            builder.k(entry.a(), entry.getCount());
        }
        return builder.e();
    }

    public static <E> ImmutableMultiset<E> t(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.j()) {
                return immutableMultiset;
            }
        }
        Builder builder = new Builder(Multisets.l(iterable));
        builder.c(iterable);
        return builder.e();
    }

    public static <E> ImmutableMultiset<E> x(Iterator<? extends E> it2) {
        return new Builder().d(it2).e();
    }

    public static <E> ImmutableMultiset<E> z(E[] eArr) {
        return q(eArr);
    }

    /* renamed from: C */
    public abstract ImmutableSet<E> e();

    /* renamed from: D */
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> immutableSet = this.Y;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Multiset.Entry<E>> B = B();
        this.Y = B;
        return B;
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean D0(E e2, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public abstract Multiset.Entry<E> E(int i2);

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int F(@CheckForNull Object obj, int i2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int Q(E e2, int i2) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> b() {
        ImmutableList<E> immutableList = this.X;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> b2 = super.b();
        this.X = b2;
        return b2;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public int c(Object[] objArr, int i2) {
        UnmodifiableIterator k2 = entrySet().iterator();
        while (k2.hasNext()) {
            Multiset.Entry entry = (Multiset.Entry) k2.next();
            Arrays.fill(objArr, i2, entry.getCount() + i2, entry.a());
            i2 += entry.getCount();
        }
        return i2;
    }

    public boolean contains(@CheckForNull Object obj) {
        return l1(obj) > 0;
    }

    public boolean equals(@CheckForNull Object obj) {
        return Multisets.i(this, obj);
    }

    public int hashCode() {
        return Sets.k(entrySet());
    }

    /* renamed from: k */
    public UnmodifiableIterator<E> iterator() {
        final UnmodifiableIterator k2 = entrySet().iterator();
        return new UnmodifiableIterator<E>(this) {
            @CheckForNull
            E X;
            int s;

            public boolean hasNext() {
                return this.s > 0 || k2.hasNext();
            }

            public E next() {
                if (this.s <= 0) {
                    Multiset.Entry entry = (Multiset.Entry) k2.next();
                    this.X = entry.a();
                    this.s = entry.getCount();
                }
                this.s--;
                E e2 = this.X;
                Objects.requireNonNull(e2);
                return e2;
            }
        };
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @J2ktIncompatible
    public abstract Object n();

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final int r0(E e2, int i2) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return entrySet().toString();
    }
}
