package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int X2 = 751619276;
    static final int Y = 1073741824;
    private static final double Z = 0.7d;
    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableList<E> X;

    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        @CheckForNull
        @VisibleForTesting

        /* renamed from: e  reason: collision with root package name */
        Object[] f22408e;

        /* renamed from: f  reason: collision with root package name */
        private int f22409f;

        public Builder() {
            super(4);
        }

        private void n(E e2) {
            Objects.requireNonNull(this.f22408e);
            int length = this.f22408e.length - 1;
            int hashCode = e2.hashCode();
            int c2 = Hashing.c(hashCode);
            while (true) {
                int i2 = c2 & length;
                Object[] objArr = this.f22408e;
                Object obj = objArr[i2];
                if (obj == null) {
                    objArr[i2] = e2;
                    this.f22409f += hashCode;
                    super.a(e2);
                    return;
                } else if (!obj.equals(e2)) {
                    c2 = i2 + 1;
                } else {
                    return;
                }
            }
        }

        @CanIgnoreReturnValue
        /* renamed from: j */
        public Builder<E> g(E e2) {
            Preconditions.E(e2);
            if (this.f22408e == null || ImmutableSet.x(this.f22387c) > this.f22408e.length) {
                this.f22408e = null;
                super.a(e2);
                return this;
            }
            n(e2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: k */
        public Builder<E> b(E... eArr) {
            if (this.f22408e != null) {
                for (E j2 : eArr) {
                    g(j2);
                }
            } else {
                super.b(eArr);
            }
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: l */
        public Builder<E> c(Iterable<? extends E> iterable) {
            Preconditions.E(iterable);
            if (this.f22408e != null) {
                for (Object j2 : iterable) {
                    g(j2);
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: m */
        public Builder<E> d(Iterator<? extends E> it2) {
            Preconditions.E(it2);
            while (it2.hasNext()) {
                g(it2.next());
            }
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.common.collect.RegularImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.google.common.collect.ImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.common.collect.RegularImmutableSet} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.common.collect.RegularImmutableSet} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: o */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.common.collect.ImmutableSet<E> e() {
            /*
                r8 = this;
                int r0 = r8.f22387c
                if (r0 == 0) goto L_0x005d
                r1 = 1
                if (r0 == r1) goto L_0x0050
                java.lang.Object[] r2 = r8.f22408e
                if (r2 == 0) goto L_0x003c
                int r0 = com.google.common.collect.ImmutableSet.x(r0)
                java.lang.Object[] r2 = r8.f22408e
                int r2 = r2.length
                if (r0 != r2) goto L_0x003c
                int r0 = r8.f22387c
                java.lang.Object[] r2 = r8.f22386b
                int r2 = r2.length
                boolean r0 = com.google.common.collect.ImmutableSet.T(r0, r2)
                if (r0 == 0) goto L_0x0029
                java.lang.Object[] r0 = r8.f22386b
                int r2 = r8.f22387c
                java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
            L_0x0027:
                r3 = r0
                goto L_0x002c
            L_0x0029:
                java.lang.Object[] r0 = r8.f22386b
                goto L_0x0027
            L_0x002c:
                com.google.common.collect.RegularImmutableSet r0 = new com.google.common.collect.RegularImmutableSet
                int r4 = r8.f22409f
                java.lang.Object[] r5 = r8.f22408e
                int r2 = r5.length
                int r6 = r2 + -1
                int r7 = r8.f22387c
                r2 = r0
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x004a
            L_0x003c:
                int r0 = r8.f22387c
                java.lang.Object[] r2 = r8.f22386b
                com.google.common.collect.ImmutableSet r0 = com.google.common.collect.ImmutableSet.z(r0, r2)
                int r2 = r0.size()
                r8.f22387c = r2
            L_0x004a:
                r8.f22388d = r1
                r1 = 0
                r8.f22408e = r1
                return r0
            L_0x0050:
                java.lang.Object[] r0 = r8.f22386b
                r1 = 0
                r0 = r0[r1]
                java.util.Objects.requireNonNull(r0)
                com.google.common.collect.ImmutableSet r0 = com.google.common.collect.ImmutableSet.L(r0)
                return r0
            L_0x005d:
                com.google.common.collect.ImmutableSet r0 = com.google.common.collect.ImmutableSet.K()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSet.Builder.e():com.google.common.collect.ImmutableSet");
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public Builder<E> p(Builder<E> builder) {
            if (this.f22408e != null) {
                for (int i2 = 0; i2 < builder.f22387c; i2++) {
                    Object obj = builder.f22386b[i2];
                    Objects.requireNonNull(obj);
                    g(obj);
                }
            } else {
                h(builder.f22386b, builder.f22387c);
            }
            return this;
        }

        Builder(int i2) {
            super(i2);
            this.f22408e = new Object[ImmutableSet.x(i2)];
        }
    }

    @J2ktIncompatible
    private static class SerializedForm implements Serializable {
        private static final long X = 0;
        final Object[] s;

        SerializedForm(Object[] objArr) {
            this.s = objArr;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return ImmutableSet.E(this.s);
        }
    }

    ImmutableSet() {
    }

    public static <E> ImmutableSet<E> B(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? C((Collection) iterable) : D(iterable.iterator());
    }

    public static <E> ImmutableSet<E> C(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.j()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return z(array.length, array);
    }

    public static <E> ImmutableSet<E> D(Iterator<? extends E> it2) {
        if (!it2.hasNext()) {
            return K();
        }
        Object next = it2.next();
        return !it2.hasNext() ? L(next) : new Builder().g(next).d(it2).e();
    }

    public static <E> ImmutableSet<E> E(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            return length != 1 ? z(eArr.length, (Object[]) eArr.clone()) : L(eArr[0]);
        }
        return K();
    }

    public static <E> ImmutableSet<E> K() {
        return RegularImmutableSet.e3;
    }

    public static <E> ImmutableSet<E> L(E e2) {
        return new SingletonImmutableSet(e2);
    }

    public static <E> ImmutableSet<E> M(E e2, E e3) {
        return z(2, e2, e3);
    }

    public static <E> ImmutableSet<E> N(E e2, E e3, E e4) {
        return z(3, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> O(E e2, E e3, E e4, E e5) {
        return z(4, e2, e3, e4, e5);
    }

    public static <E> ImmutableSet<E> P(E e2, E e3, E e4, E e5, E e6) {
        return z(5, e2, e3, e4, e5, e6);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> R(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        Preconditions.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return z(length, objArr);
    }

    /* access modifiers changed from: private */
    public static boolean T(int i2, int i3) {
        return i2 < (i3 >> 1) + (i3 >> 2);
    }

    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> Builder<E> r() {
        return new Builder<>();
    }

    public static <E> Builder<E> t(int i2) {
        CollectPreconditions.b(i2, "expectedSize");
        return new Builder<>(i2);
    }

    @VisibleForTesting
    static int x(int i2) {
        int max = Math.max(i2, 2);
        boolean z = true;
        if (max < X2) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * Z < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        Preconditions.e(z, "collection too large");
        return 1073741824;
    }

    /* access modifiers changed from: private */
    public static <E> ImmutableSet<E> z(int i2, Object... objArr) {
        if (i2 == 0) {
            return K();
        }
        if (i2 != 1) {
            int x = x(i2);
            Object[] objArr2 = new Object[x];
            int i3 = x - 1;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                Object a2 = ObjectArrays.a(objArr[i6], i6);
                int hashCode = a2.hashCode();
                int c2 = Hashing.c(hashCode);
                while (true) {
                    int i7 = c2 & i3;
                    Object obj = objArr2[i7];
                    if (obj == null) {
                        objArr[i5] = a2;
                        objArr2[i7] = a2;
                        i4 += hashCode;
                        i5++;
                        break;
                    } else if (obj.equals(a2)) {
                        break;
                    } else {
                        c2++;
                    }
                }
            }
            Arrays.fill(objArr, i5, i2, (Object) null);
            if (i5 == 1) {
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                return new SingletonImmutableSet(obj2);
            } else if (x(i5) < x / 2) {
                return z(i5, objArr);
            } else {
                if (T(i5, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i5);
                }
                return new RegularImmutableSet(objArr, i4, objArr2, i3, i5);
            }
        } else {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return L(obj3);
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> H() {
        return ImmutableList.o(toArray());
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        return false;
    }

    public ImmutableList<E> b() {
        ImmutableList<E> immutableList = this.X;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> H = H();
        this.X = H;
        return H;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableSet) || !I() || !((ImmutableSet) obj).I() || hashCode() == obj.hashCode()) {
            return Sets.g(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return Sets.k(this);
    }

    /* renamed from: k */
    public abstract UnmodifiableIterator<E> iterator();

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object n() {
        return new SerializedForm(toArray());
    }
}
