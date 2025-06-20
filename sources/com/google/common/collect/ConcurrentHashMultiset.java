package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long Z = 1;
    /* access modifiers changed from: private */
    public final transient ConcurrentMap<E, AtomicInteger> Y;

    private class EntrySet extends AbstractMultiset<E>.EntrySet {
        private EntrySet() {
            super();
        }

        private List<Multiset.Entry<E>> k() {
            ArrayList v = Lists.v(size());
            Iterators.a(v, iterator());
            return v;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public ConcurrentHashMultiset<E> h() {
            return ConcurrentHashMultiset.this;
        }

        public Object[] toArray() {
            return k().toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return k().toArray(tArr);
        }
    }

    private static class FieldSettersHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Serialization.FieldSetter<ConcurrentHashMultiset> f22379a = Serialization.a(ConcurrentHashMultiset.class, "countMap");

        private FieldSettersHolder() {
        }
    }

    @VisibleForTesting
    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        Preconditions.u(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.Y = concurrentMap;
    }

    public static <E> ConcurrentHashMultiset<E> k() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    public static <E> ConcurrentHashMultiset<E> m(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> k2 = k();
        Iterables.a(k2, iterable);
        return k2;
    }

    public static <E> ConcurrentHashMultiset<E> n(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @J2ktIncompatible
    private void o(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        Objects.requireNonNull(readObject);
        FieldSettersHolder.f22379a.b(this, (ConcurrentMap) readObject);
    }

    private List<E> r() {
        ArrayList v = Lists.v(size());
        for (Multiset.Entry entry : entrySet()) {
            Object a2 = entry.a();
            for (int count = entry.getCount(); count > 0; count--) {
                v.add(a2);
            }
        }
        return v;
    }

    private void t(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.Y);
    }

    @CanIgnoreReturnValue
    public boolean D0(E e2, int i2, int i3) {
        Preconditions.E(e2);
        CollectPreconditions.b(i2, "oldCount");
        CollectPreconditions.b(i3, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.p0(this.Y, e2);
        if (atomicInteger != null) {
            int i4 = atomicInteger.get();
            if (i4 == i2) {
                if (i4 == 0) {
                    if (i3 == 0) {
                        this.Y.remove(e2, atomicInteger);
                        return true;
                    }
                    AtomicInteger atomicInteger2 = new AtomicInteger(i3);
                    return this.Y.putIfAbsent(e2, atomicInteger2) == null || this.Y.replace(e2, atomicInteger, atomicInteger2);
                } else if (atomicInteger.compareAndSet(i4, i3)) {
                    if (i3 == 0) {
                        this.Y.remove(e2, atomicInteger);
                    }
                    return true;
                }
            }
            return false;
        } else if (i2 != 0) {
            return false;
        } else {
            return i3 == 0 || this.Y.putIfAbsent(e2, new AtomicInteger(i3)) == null;
        }
    }

    @CanIgnoreReturnValue
    public int F(@CheckForNull Object obj, int i2) {
        int i3;
        int max;
        if (i2 == 0) {
            return l1(obj);
        }
        CollectPreconditions.d(i2, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.p0(this.Y, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i3 = atomicInteger.get();
            if (i3 == 0) {
                return 0;
            }
            max = Math.max(0, i3 - i2);
        } while (!atomicInteger.compareAndSet(i3, max));
        if (max == 0) {
            this.Y.remove(obj, atomicInteger);
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r4.Y.putIfAbsent(r5, r2) == null) goto L_0x006f;
     */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int Q(E r5, int r6) {
        /*
            r4 = this;
            com.google.common.base.Preconditions.E(r5)
            if (r6 != 0) goto L_0x000a
            int r5 = r4.l1(r5)
            return r5
        L_0x000a:
            java.lang.String r0 = "occurrences"
            com.google.common.collect.CollectPreconditions.d(r6, r0)
        L_0x000f:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.Y
            java.lang.Object r0 = com.google.common.collect.Maps.p0(r0, r5)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r1 = 0
            if (r0 != 0) goto L_0x002a
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.Y
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.lang.Object r0 = r0.putIfAbsent(r5, r2)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            if (r0 != 0) goto L_0x002a
            return r1
        L_0x002a:
            int r2 = r0.get()
            if (r2 == 0) goto L_0x005a
            int r3 = com.google.common.math.IntMath.c(r2, r6)     // Catch:{ ArithmeticException -> 0x003b }
            boolean r3 = r0.compareAndSet(r2, r3)     // Catch:{ ArithmeticException -> 0x003b }
            if (r3 == 0) goto L_0x002a
            return r2
        L_0x003b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Overflow adding "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = " occurrences to a count of "
            r0.append(r6)
            r0.append(r2)
            java.lang.String r6 = r0.toString()
            r5.<init>(r6)
            throw r5
        L_0x005a:
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.Y
            java.lang.Object r3 = r3.putIfAbsent(r5, r2)
            if (r3 == 0) goto L_0x006f
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.Y
            boolean r0 = r3.replace(r5, r0, r2)
            if (r0 == 0) goto L_0x000f
        L_0x006f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.Q(java.lang.Object, int):int");
    }

    /* access modifiers changed from: package-private */
    public Set<E> b() {
        final Set<E> keySet = this.Y.keySet();
        return new ForwardingSet<E>(this) {
            /* access modifiers changed from: protected */
            /* renamed from: E1 */
            public Set<E> a1() {
                return keySet;
            }

            public boolean contains(@CheckForNull Object obj) {
                return obj != null && Collections2.j(keySet, obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return n1(collection);
            }

            public boolean remove(@CheckForNull Object obj) {
                return obj != null && Collections2.k(keySet, obj);
            }

            public boolean removeAll(Collection<?> collection) {
                return q1(collection);
            }
        };
    }

    @Deprecated
    public Set<Multiset.Entry<E>> c() {
        return new EntrySet();
    }

    public void clear() {
        this.Y.clear();
    }

    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.Y.size();
    }

    public /* bridge */ /* synthetic */ Set e() {
        return super.e();
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    /* access modifiers changed from: package-private */
    public Iterator<E> g() {
        throw new AssertionError("should never be called");
    }

    /* access modifiers changed from: package-private */
    public Iterator<Multiset.Entry<E>> h() {
        final AnonymousClass2 r0 = new AbstractIterator<Multiset.Entry<E>>() {
            private final Iterator<Map.Entry<E, AtomicInteger>> Y;

            {
                this.Y = ConcurrentHashMultiset.this.Y.entrySet().iterator();
            }

            /* access modifiers changed from: protected */
            @CheckForNull
            /* renamed from: d */
            public Multiset.Entry<E> a() {
                while (this.Y.hasNext()) {
                    Map.Entry next = this.Y.next();
                    int i2 = ((AtomicInteger) next.getValue()).get();
                    if (i2 != 0) {
                        return Multisets.k(next.getKey(), i2);
                    }
                }
                return (Multiset.Entry) b();
            }
        };
        return new ForwardingIterator<Multiset.Entry<E>>() {
            @CheckForNull
            private Multiset.Entry<E> s;

            /* access modifiers changed from: protected */
            /* renamed from: a1 */
            public Iterator<Multiset.Entry<E>> Z0() {
                return r0;
            }

            /* renamed from: f1 */
            public Multiset.Entry<E> next() {
                Multiset.Entry<E> entry = (Multiset.Entry) super.next();
                this.s = entry;
                return entry;
            }

            public void remove() {
                Preconditions.h0(this.s != null, "no calls to next() since the last call to remove()");
                ConcurrentHashMultiset.this.r0(this.s.a(), 0);
                this.s = null;
            }
        };
    }

    public boolean isEmpty() {
        return this.Y.isEmpty();
    }

    public Iterator<E> iterator() {
        return Multisets.n(this);
    }

    public int l1(@CheckForNull Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.p0(this.Y, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @CanIgnoreReturnValue
    public boolean q(@CheckForNull Object obj, int i2) {
        int i3;
        int i4;
        if (i2 == 0) {
            return true;
        }
        CollectPreconditions.d(i2, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.p0(this.Y, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i3 = atomicInteger.get();
            if (i3 < i2) {
                return false;
            }
            i4 = i3 - i2;
        } while (!atomicInteger.compareAndSet(i3, i4));
        if (i4 == 0) {
            this.Y.remove(obj, atomicInteger);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r6 != 0) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r4.Y.putIfAbsent(r5, r2) == null) goto L_0x0044;
     */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int r0(E r5, int r6) {
        /*
            r4 = this;
            com.google.common.base.Preconditions.E(r5)
            java.lang.String r0 = "count"
            com.google.common.collect.CollectPreconditions.b(r6, r0)
        L_0x0008:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.Y
            java.lang.Object r0 = com.google.common.collect.Maps.p0(r0, r5)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            r1 = 0
            if (r0 != 0) goto L_0x0026
            if (r6 != 0) goto L_0x0016
            return r1
        L_0x0016:
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r0 = r4.Y
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.lang.Object r0 = r0.putIfAbsent(r5, r2)
            java.util.concurrent.atomic.AtomicInteger r0 = (java.util.concurrent.atomic.AtomicInteger) r0
            if (r0 != 0) goto L_0x0026
            return r1
        L_0x0026:
            int r2 = r0.get()
            if (r2 != 0) goto L_0x0045
            if (r6 != 0) goto L_0x002f
            return r1
        L_0x002f:
            java.util.concurrent.atomic.AtomicInteger r2 = new java.util.concurrent.atomic.AtomicInteger
            r2.<init>(r6)
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.Y
            java.lang.Object r3 = r3.putIfAbsent(r5, r2)
            if (r3 == 0) goto L_0x0044
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r3 = r4.Y
            boolean r0 = r3.replace(r5, r0, r2)
            if (r0 == 0) goto L_0x0008
        L_0x0044:
            return r1
        L_0x0045:
            boolean r3 = r0.compareAndSet(r2, r6)
            if (r3 == 0) goto L_0x0026
            if (r6 != 0) goto L_0x0052
            java.util.concurrent.ConcurrentMap<E, java.util.concurrent.atomic.AtomicInteger> r6 = r4.Y
            r6.remove(r5, r0)
        L_0x0052:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ConcurrentHashMultiset.r0(java.lang.Object, int):int");
    }

    public int size() {
        long j2 = 0;
        for (AtomicInteger atomicInteger : this.Y.values()) {
            j2 += (long) atomicInteger.get();
        }
        return Ints.z(j2);
    }

    public Object[] toArray() {
        return r().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return r().toArray(tArr);
    }
}
