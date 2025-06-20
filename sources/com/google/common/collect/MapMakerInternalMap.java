package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.CheckForNull;

@GwtIncompatible
@J2ktIncompatible
class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    static final int c3 = 1073741824;
    static final int d3 = 65536;
    static final int e3 = 3;
    static final int f3 = 63;
    static final int g3 = 16;
    static final WeakValueReference<Object, Object, DummyInternalEntry> h3 = new WeakValueReference<Object, Object, DummyInternalEntry>() {
        /* renamed from: c */
        public WeakValueReference<Object, Object, DummyInternalEntry> b(ReferenceQueue<Object> referenceQueue, DummyInternalEntry dummyInternalEntry) {
            return this;
        }

        public void clear() {
        }

        @CheckForNull
        /* renamed from: d */
        public DummyInternalEntry a() {
            return null;
        }

        @CheckForNull
        public Object get() {
            return null;
        }
    };
    private static final long i3 = 5;
    final transient int X;
    final Equivalence<Object> X2;
    final transient Segment<K, V, E, S>[] Y;
    final transient InternalEntryHelper<K, V, E, S> Y2;
    final int Z;
    @CheckForNull
    @LazyInit
    transient Set<K> Z2;
    @CheckForNull
    @LazyInit
    transient Collection<V> a3;
    @CheckForNull
    @LazyInit
    transient Set<Map.Entry<K, V>> b3;
    final transient int s;

    static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long Z2 = 3;
        final Strength X;
        final int X2;
        final Equivalence<Object> Y;
        transient ConcurrentMap<K, V> Y2;
        final Equivalence<Object> Z;
        final Strength s;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i2, ConcurrentMap<K, V> concurrentMap) {
            this.s = strength;
            this.X = strength2;
            this.Y = equivalence;
            this.Z = equivalence2;
            this.X2 = i2;
            this.Y2 = concurrentMap;
        }

        /* access modifiers changed from: package-private */
        @J2ktIncompatible
        public void B1(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            while (true) {
                Object readObject = objectInputStream.readObject();
                if (readObject != null) {
                    this.Y2.put(readObject, objectInputStream.readObject());
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @J2ktIncompatible
        public MapMaker E1(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().g(objectInputStream.readInt()).j(this.s).k(this.X).h(this.Y).a(this.X2);
        }

        /* access modifiers changed from: package-private */
        public void G1(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.Y2.size());
            for (Map.Entry next : this.Y2.entrySet()) {
                objectOutputStream.writeObject(next.getKey());
                objectOutputStream.writeObject(next.getValue());
            }
            objectOutputStream.writeObject((Object) null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: x1 */
        public ConcurrentMap<K, V> a1() {
            return this.Y2;
        }
    }

    static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {
        final int X;
        final K s;

        AbstractStrongKeyEntry(K k2, int i2) {
            this.s = k2;
            this.X = i2;
        }

        @CheckForNull
        public E a() {
            return null;
        }

        public final int c() {
            return this.X;
        }

        public final K getKey() {
            return this.s;
        }
    }

    static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {
        final int s;

        AbstractWeakKeyEntry(ReferenceQueue<K> referenceQueue, K k2, int i2) {
            super(k2, referenceQueue);
            this.s = i2;
        }

        @CheckForNull
        public E a() {
            return null;
        }

        public final int c() {
            return this.s;
        }

        public final K getKey() {
            return get();
        }
    }

    static final class CleanupMapTask implements Runnable {
        final WeakReference<MapMakerInternalMap<?, ?, ?, ?>> s;

        public CleanupMapTask(MapMakerInternalMap<?, ?, ?, ?> mapMakerInternalMap) {
            this.s = new WeakReference<>(mapMakerInternalMap);
        }

        public void run() {
            MapMakerInternalMap mapMakerInternalMap = this.s.get();
            if (mapMakerInternalMap != null) {
                for (Segment<K, V, E, S> P : mapMakerInternalMap.Y) {
                    P.P();
                }
                return;
            }
            throw new CancellationException();
        }
    }

    static final class DummyInternalEntry implements InternalEntry<Object, Object, DummyInternalEntry> {
        private DummyInternalEntry() {
            throw new AssertionError();
        }

        public int c() {
            throw new AssertionError();
        }

        /* renamed from: d */
        public DummyInternalEntry a() {
            throw new AssertionError();
        }

        public Object getKey() {
            throw new AssertionError();
        }

        public Object getValue() {
            throw new AssertionError();
        }
    }

    final class EntryIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<Map.Entry<K, V>> {
        EntryIterator(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    final class EntrySet extends SafeToArraySet<Map.Entry<K, V>> {
        EntrySet() {
            super();
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
            r0 = r3.s.get((r0 = r4.getKey()));
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean contains(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x000f
                return r1
            L_0x000f:
                com.google.common.collect.MapMakerInternalMap r2 = com.google.common.collect.MapMakerInternalMap.this
                java.lang.Object r0 = r2.get(r0)
                if (r0 == 0) goto L_0x0028
                com.google.common.collect.MapMakerInternalMap r2 = com.google.common.collect.MapMakerInternalMap.this
                com.google.common.base.Equivalence r2 = r2.u()
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r2.d(r4, r0)
                if (r4 == 0) goto L_0x0028
                r1 = 1
            L_0x0028:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.EntrySet.contains(java.lang.Object):boolean");
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(MapMakerInternalMap.this);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
            r4 = (java.util.Map.Entry) r4;
            r0 = r4.getKey();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean remove(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r0 = r4.getKey()
                if (r0 == 0) goto L_0x001b
                com.google.common.collect.MapMakerInternalMap r2 = com.google.common.collect.MapMakerInternalMap.this
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r2.remove(r0, r4)
                if (r4 == 0) goto L_0x001b
                r1 = 1
            L_0x001b:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.EntrySet.remove(java.lang.Object):boolean");
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    abstract class HashIterator<T> implements Iterator<T> {
        int X = -1;
        @CheckForNull
        E X2;
        @CheckForNull
        Segment<K, V, E, S> Y;
        @CheckForNull
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry Y2;
        @CheckForNull
        AtomicReferenceArray<E> Z;
        @CheckForNull
        MapMakerInternalMap<K, V, E, S>.WriteThroughEntry Z2;
        int s;

        HashIterator() {
            this.s = MapMakerInternalMap.this.Y.length - 1;
            a();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.Y2 = null;
            if (!d() && !e()) {
                while (true) {
                    int i2 = this.s;
                    if (i2 >= 0) {
                        Segment<K, V, E, S>[] segmentArr = MapMakerInternalMap.this.Y;
                        this.s = i2 - 1;
                        Segment<K, V, E, S> segment = segmentArr[i2];
                        this.Y = segment;
                        if (segment.X != 0) {
                            AtomicReferenceArray<E> atomicReferenceArray = this.Y.X2;
                            this.Z = atomicReferenceArray;
                            this.X = atomicReferenceArray.length() - 1;
                            if (e()) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public boolean b(E e2) {
            try {
                Object key = e2.getKey();
                Object g2 = MapMakerInternalMap.this.g(e2);
                if (g2 != null) {
                    this.Y2 = new WriteThroughEntry(key, g2);
                    this.Y.B();
                    return true;
                }
                this.Y.B();
                return false;
            } catch (Throwable th) {
                this.Y.B();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public MapMakerInternalMap<K, V, E, S>.WriteThroughEntry c() {
            MapMakerInternalMap<K, V, E, S>.WriteThroughEntry writeThroughEntry = this.Y2;
            if (writeThroughEntry != null) {
                this.Z2 = writeThroughEntry;
                a();
                return this.Z2;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            E e2 = this.X2;
            if (e2 == null) {
                return false;
            }
            while (true) {
                this.X2 = e2.a();
                E e3 = this.X2;
                if (e3 == null) {
                    return false;
                }
                if (b(e3)) {
                    return true;
                }
                e2 = this.X2;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            while (true) {
                int i2 = this.X;
                if (i2 < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.Z;
                this.X = i2 - 1;
                E e2 = (InternalEntry) atomicReferenceArray.get(i2);
                this.X2 = e2;
                if (e2 != null && (b(e2) || d())) {
                    return true;
                }
            }
        }

        public boolean hasNext() {
            return this.Y2 != null;
        }

        public abstract T next();

        public void remove() {
            CollectPreconditions.e(this.Z2 != null);
            MapMakerInternalMap.this.remove(this.Z2.getKey());
            this.Z2 = null;
        }
    }

    interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        E a();

        int c();

        K getKey();

        V getValue();
    }

    interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        S a(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i2);

        E b(S s, E e2, @CheckForNull E e3);

        Strength c();

        Strength d();

        void e(S s, E e2, V v);

        E f(S s, K k2, int i2, @CheckForNull E e2);
    }

    final class KeyIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<K> {
        KeyIterator(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        public K next() {
            return c().getKey();
        }
    }

    final class KeySet extends SafeToArraySet<K> {
        KeySet() {
            super();
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public Iterator<K> iterator() {
            return new KeyIterator(MapMakerInternalMap.this);
        }

        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    private static abstract class SafeToArraySet<E> extends AbstractSet<E> {
        private SafeToArraySet() {
        }

        public Object[] toArray() {
            return MapMakerInternalMap.s(this).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return MapMakerInternalMap.s(this).toArray(tArr);
        }
    }

    static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {
        volatile int X;
        @CheckForNull
        volatile AtomicReferenceArray<E> X2;
        int Y;
        final AtomicInteger Y2 = new AtomicInteger();
        int Z;
        @Weak
        final MapMakerInternalMap<K, V, E, S> s;

        Segment(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i2) {
            this.s = mapMakerInternalMap;
            u(y(i2));
        }

        static <K, V, E extends InternalEntry<K, V, E>> boolean v(E e2) {
            return e2.getValue() == null;
        }

        /* access modifiers changed from: package-private */
        public WeakValueReference<K, V, E> A(InternalEntry<K, V, ?> internalEntry, V v) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void B() {
            if ((this.Y2.incrementAndGet() & 63) == 0) {
                P();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void C() {
            Q();
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V D(K k2, int i2, V v, boolean z) {
            lock();
            try {
                C();
                int i3 = this.X + 1;
                if (i3 > this.Z) {
                    k();
                    i3 = this.X + 1;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.X2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.c() != i2 || key == null || !this.s.X2.d(k2, key)) {
                        internalEntry2 = internalEntry2.a();
                    } else {
                        V value = internalEntry2.getValue();
                        if (value == null) {
                            this.Y++;
                            T(internalEntry2, v);
                            this.X = this.X;
                            unlock();
                            return null;
                        } else if (z) {
                            unlock();
                            return value;
                        } else {
                            this.Y++;
                            T(internalEntry2, v);
                            unlock();
                            return value;
                        }
                    }
                }
                this.Y++;
                E f2 = this.s.Y2.f(R(), k2, i2, internalEntry);
                T(f2, v);
                atomicReferenceArray.set(length, f2);
                this.X = i3;
                unlock();
                return null;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public boolean E(E e2, int i2) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.X2;
                int length = i2 & (atomicReferenceArray.length() - 1);
                E e3 = (InternalEntry) atomicReferenceArray.get(length);
                for (E e4 = e3; e4 != null; e4 = e4.a()) {
                    if (e4 == e2) {
                        this.Y++;
                        atomicReferenceArray.set(length, K(e3, e4));
                        this.X--;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public boolean F(K k2, int i2, WeakValueReference<K, V, E> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.X2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.c() != i2 || key == null || !this.s.X2.d(k2, key)) {
                        internalEntry2 = internalEntry2.a();
                    } else if (((WeakValueEntry) internalEntry2).b() == weakValueReference) {
                        this.Y++;
                        atomicReferenceArray.set(length, K(internalEntry, internalEntry2));
                        this.X--;
                        return true;
                    } else {
                        unlock();
                        return false;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        @CheckForNull
        public V H(Object obj, int i2) {
            lock();
            try {
                C();
                AtomicReferenceArray<E> atomicReferenceArray = this.X2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.c() != i2 || key == null || !this.s.X2.d(obj, key)) {
                        internalEntry2 = internalEntry2.a();
                    } else {
                        V value = internalEntry2.getValue();
                        if (value == null) {
                            if (!v(internalEntry2)) {
                                unlock();
                                return null;
                            }
                        }
                        this.Y++;
                        atomicReferenceArray.set(length, K(internalEntry, internalEntry2));
                        this.X--;
                        return value;
                    }
                }
                unlock();
                return null;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean I(Object obj, int i2, Object obj2) {
            lock();
            try {
                C();
                AtomicReferenceArray<E> atomicReferenceArray = this.X2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (true) {
                    boolean z = false;
                    if (internalEntry2 != null) {
                        Object key = internalEntry2.getKey();
                        if (internalEntry2.c() != i2 || key == null || !this.s.X2.d(obj, key)) {
                            internalEntry2 = internalEntry2.a();
                        } else {
                            if (this.s.u().d(obj2, internalEntry2.getValue())) {
                                z = true;
                            } else if (!v(internalEntry2)) {
                                unlock();
                                return false;
                            }
                            this.Y++;
                            atomicReferenceArray.set(length, K(internalEntry, internalEntry2));
                            this.X--;
                            return z;
                        }
                    } else {
                        unlock();
                        return false;
                    }
                }
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public boolean J(E e2) {
            int c2 = e2.c();
            AtomicReferenceArray<E> atomicReferenceArray = this.X2;
            int length = c2 & (atomicReferenceArray.length() - 1);
            E e3 = (InternalEntry) atomicReferenceArray.get(length);
            for (E e4 = e3; e4 != null; e4 = e4.a()) {
                if (e4 == e2) {
                    this.Y++;
                    atomicReferenceArray.set(length, K(e3, e4));
                    this.X--;
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        @GuardedBy("this")
        public E K(E e2, E e3) {
            int i2 = this.X;
            E a2 = e3.a();
            while (e2 != e3) {
                E g2 = g(e2, a2);
                if (g2 != null) {
                    a2 = g2;
                } else {
                    i2--;
                }
                e2 = e2.a();
            }
            this.X = i2;
            return a2;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [com.google.common.collect.MapMakerInternalMap$InternalEntry, com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, ?>] */
        /* JADX WARNING: type inference failed for: r2v0, types: [com.google.common.collect.MapMakerInternalMap$InternalEntry, com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, ?>] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 2 */
        @javax.annotation.CheckForNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public E L(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> r1, com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> r2) {
            /*
                r0 = this;
                com.google.common.collect.MapMakerInternalMap$InternalEntry r1 = r0.a(r1)
                com.google.common.collect.MapMakerInternalMap$InternalEntry r2 = r0.a(r2)
                com.google.common.collect.MapMakerInternalMap$InternalEntry r1 = r0.K(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.L(com.google.common.collect.MapMakerInternalMap$InternalEntry, com.google.common.collect.MapMakerInternalMap$InternalEntry):com.google.common.collect.MapMakerInternalMap$InternalEntry");
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [com.google.common.collect.MapMakerInternalMap$InternalEntry, com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, ?>] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean M(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> r1) {
            /*
                r0 = this;
                com.google.common.collect.MapMakerInternalMap$InternalEntry r1 = r0.a(r1)
                boolean r1 = r0.J(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.M(com.google.common.collect.MapMakerInternalMap$InternalEntry):boolean");
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V N(K k2, int i2, V v) {
            lock();
            try {
                C();
                AtomicReferenceArray<E> atomicReferenceArray = this.X2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.c() != i2 || key == null || !this.s.X2.d(k2, key)) {
                        internalEntry2 = internalEntry2.a();
                    } else {
                        V value = internalEntry2.getValue();
                        if (value == null) {
                            if (v(internalEntry2)) {
                                this.Y++;
                                atomicReferenceArray.set(length, K(internalEntry, internalEntry2));
                                this.X--;
                            }
                            return null;
                        }
                        this.Y++;
                        T(internalEntry2, v);
                        unlock();
                        return value;
                    }
                }
                unlock();
                return null;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean O(K k2, int i2, V v, V v2) {
            lock();
            try {
                C();
                AtomicReferenceArray<E> atomicReferenceArray = this.X2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.c() != i2 || key == null || !this.s.X2.d(k2, key)) {
                        internalEntry2 = internalEntry2.a();
                    } else {
                        Object value = internalEntry2.getValue();
                        if (value == null) {
                            if (v(internalEntry2)) {
                                this.Y++;
                                atomicReferenceArray.set(length, K(internalEntry, internalEntry2));
                                this.X--;
                            }
                            return false;
                        } else if (this.s.u().d(v, value)) {
                            this.Y++;
                            T(internalEntry2, v2);
                            unlock();
                            return true;
                        } else {
                            unlock();
                            return false;
                        }
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public void P() {
            Q();
        }

        /* access modifiers changed from: package-private */
        public void Q() {
            if (tryLock()) {
                try {
                    x();
                    this.Y2.set(0);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract S R();

        /* access modifiers changed from: package-private */
        public void S(int i2, InternalEntry<K, V, ?> internalEntry) {
            this.X2.set(i2, a(internalEntry));
        }

        /* access modifiers changed from: package-private */
        public void T(E e2, V v) {
            this.s.Y2.e(R(), e2, v);
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [com.google.common.collect.MapMakerInternalMap$InternalEntry, com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, ?>] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void U(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> r3, V r4) {
            /*
                r2 = this;
                com.google.common.collect.MapMakerInternalMap<K, V, E, S> r0 = r2.s
                com.google.common.collect.MapMakerInternalMap$InternalEntryHelper<K, V, E, S> r0 = r0.Y2
                com.google.common.collect.MapMakerInternalMap$Segment r1 = r2.R()
                com.google.common.collect.MapMakerInternalMap$InternalEntry r3 = r2.a(r3)
                r0.e(r1, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.U(com.google.common.collect.MapMakerInternalMap$InternalEntry, java.lang.Object):void");
        }

        /* access modifiers changed from: package-private */
        public void V(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void W() {
            if (tryLock()) {
                try {
                    x();
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract E a(InternalEntry<K, V, ?> internalEntry);

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.X != 0) {
                lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = this.X2;
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, (Object) null);
                    }
                    w();
                    this.Y2.set(0);
                    this.Y++;
                    this.X = 0;
                    unlock();
                } catch (Throwable th) {
                    unlock();
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public <T> void c(ReferenceQueue<T> referenceQueue) {
            do {
            } while (referenceQueue.poll() != null);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public boolean d(K k2, int i2, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = this.X2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                InternalEntry internalEntry2 = internalEntry;
                while (internalEntry2 != null) {
                    Object key = internalEntry2.getKey();
                    if (internalEntry2.c() != i2 || key == null || !this.s.X2.d(k2, key)) {
                        internalEntry2 = internalEntry2.a();
                    } else if (((WeakValueEntry) internalEntry2).b() == weakValueReference) {
                        atomicReferenceArray.set(length, K(internalEntry, internalEntry2));
                        return true;
                    } else {
                        unlock();
                        return false;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean e(Object obj, int i2) {
            try {
                boolean z = false;
                if (this.X != 0) {
                    InternalEntry p = p(obj, i2);
                    if (!(p == null || p.getValue() == null)) {
                        z = true;
                    }
                    return z;
                }
                B();
                return false;
            } finally {
                B();
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public boolean f(Object obj) {
            try {
                if (this.X != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.X2;
                    int length = atomicReferenceArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        for (InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(i2); internalEntry != null; internalEntry = internalEntry.a()) {
                            Object q = q(internalEntry);
                            if (q != null) {
                                if (this.s.u().d(obj, q)) {
                                    B();
                                    return true;
                                }
                            }
                        }
                    }
                }
                B();
                return false;
            } catch (Throwable th) {
                B();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public E g(E e2, E e3) {
            return this.s.Y2.b(R(), e2, e3);
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [com.google.common.collect.MapMakerInternalMap$InternalEntry, com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, ?>] */
        /* JADX WARNING: type inference failed for: r4v0, types: [com.google.common.collect.MapMakerInternalMap$InternalEntry, com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, ?>] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public E h(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> r3, @javax.annotation.CheckForNull com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> r4) {
            /*
                r2 = this;
                com.google.common.collect.MapMakerInternalMap<K, V, E, S> r0 = r2.s
                com.google.common.collect.MapMakerInternalMap$InternalEntryHelper<K, V, E, S> r0 = r0.Y2
                com.google.common.collect.MapMakerInternalMap$Segment r1 = r2.R()
                com.google.common.collect.MapMakerInternalMap$InternalEntry r3 = r2.a(r3)
                com.google.common.collect.MapMakerInternalMap$InternalEntry r4 = r2.a(r4)
                com.google.common.collect.MapMakerInternalMap$InternalEntry r3 = r0.b(r1, r3, r4)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.h(com.google.common.collect.MapMakerInternalMap$InternalEntry, com.google.common.collect.MapMakerInternalMap$InternalEntry):com.google.common.collect.MapMakerInternalMap$InternalEntry");
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void i(ReferenceQueue<K> referenceQueue) {
            int i2 = 0;
            do {
                Reference<? extends K> poll = referenceQueue.poll();
                if (poll != null) {
                    this.s.m((InternalEntry) poll);
                    i2++;
                } else {
                    return;
                }
            } while (i2 != 16);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void j(ReferenceQueue<V> referenceQueue) {
            int i2 = 0;
            do {
                Reference<? extends V> poll = referenceQueue.poll();
                if (poll != null) {
                    this.s.n((WeakValueReference) poll);
                    i2++;
                } else {
                    return;
                }
            } while (i2 != 16);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void k() {
            AtomicReferenceArray<E> atomicReferenceArray = this.X2;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i2 = this.X;
                AtomicReferenceArray<E> y = y(length << 1);
                this.Z = (y.length() * 3) / 4;
                int length2 = y.length() - 1;
                for (int i3 = 0; i3 < length; i3++) {
                    InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(i3);
                    if (internalEntry != null) {
                        InternalEntry a2 = internalEntry.a();
                        int c2 = internalEntry.c() & length2;
                        if (a2 == null) {
                            y.set(c2, internalEntry);
                        } else {
                            InternalEntry internalEntry2 = internalEntry;
                            while (a2 != null) {
                                int c3 = a2.c() & length2;
                                if (c3 != c2) {
                                    internalEntry2 = a2;
                                    c2 = c3;
                                }
                                a2 = a2.a();
                            }
                            y.set(c2, internalEntry2);
                            while (internalEntry != internalEntry2) {
                                int c4 = internalEntry.c() & length2;
                                InternalEntry g2 = g(internalEntry, (InternalEntry) y.get(c4));
                                if (g2 != null) {
                                    y.set(c4, g2);
                                } else {
                                    i2--;
                                }
                                internalEntry = internalEntry.a();
                            }
                        }
                    }
                }
                this.X2 = y;
                this.X = i2;
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        @CheckForNull
        public V l(Object obj, int i2) {
            try {
                InternalEntry p = p(obj, i2);
                if (p == null) {
                    B();
                    return null;
                }
                V value = p.getValue();
                if (value == null) {
                    W();
                }
                B();
                return value;
            } catch (Throwable th) {
                B();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public E m(Object obj, int i2) {
            if (this.X == 0) {
                return null;
            }
            for (E n2 = n(i2); n2 != null; n2 = n2.a()) {
                if (n2.c() == i2) {
                    Object key = n2.getKey();
                    if (key == null) {
                        W();
                    } else if (this.s.X2.d(obj, key)) {
                        return n2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public E n(int i2) {
            AtomicReferenceArray<E> atomicReferenceArray = this.X2;
            return (InternalEntry) atomicReferenceArray.get(i2 & (atomicReferenceArray.length() - 1));
        }

        /* access modifiers changed from: package-private */
        public ReferenceQueue<K> o() {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public E p(Object obj, int i2) {
            return m(obj, i2);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V q(E e2) {
            if (e2.getKey() == null) {
                W();
                return null;
            }
            V value = e2.getValue();
            if (value != null) {
                return value;
            }
            W();
            return null;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [com.google.common.collect.MapMakerInternalMap$InternalEntry, com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, ?>] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        @javax.annotation.CheckForNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V r(com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> r1) {
            /*
                r0 = this;
                com.google.common.collect.MapMakerInternalMap$InternalEntry r1 = r0.a(r1)
                java.lang.Object r1 = r0.q(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.r(com.google.common.collect.MapMakerInternalMap$InternalEntry):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        public ReferenceQueue<V> s() {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public WeakValueReference<K, V, E> t(InternalEntry<K, V, ?> internalEntry) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void u(AtomicReferenceArray<E> atomicReferenceArray) {
            this.Z = (atomicReferenceArray.length() * 3) / 4;
            this.X2 = atomicReferenceArray;
        }

        /* access modifiers changed from: package-private */
        public void w() {
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void x() {
        }

        /* access modifiers changed from: package-private */
        public AtomicReferenceArray<E> y(int i2) {
            return new AtomicReferenceArray<>(i2);
        }

        /* JADX WARNING: type inference failed for: r5v0, types: [com.google.common.collect.MapMakerInternalMap$InternalEntry, com.google.common.collect.MapMakerInternalMap$InternalEntry<K, V, ?>] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public E z(K r3, int r4, @javax.annotation.CheckForNull com.google.common.collect.MapMakerInternalMap.InternalEntry<K, V, ?> r5) {
            /*
                r2 = this;
                com.google.common.collect.MapMakerInternalMap<K, V, E, S> r0 = r2.s
                com.google.common.collect.MapMakerInternalMap$InternalEntryHelper<K, V, E, S> r0 = r0.Y2
                com.google.common.collect.MapMakerInternalMap$Segment r1 = r2.R()
                com.google.common.collect.MapMakerInternalMap$InternalEntry r5 = r2.a(r5)
                com.google.common.collect.MapMakerInternalMap$InternalEntry r3 = r0.f(r1, r3, r4, r5)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.z(java.lang.Object, int, com.google.common.collect.MapMakerInternalMap$InternalEntry):com.google.common.collect.MapMakerInternalMap$InternalEntry");
        }
    }

    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long a3 = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i2, ConcurrentMap<K, V> concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i2, concurrentMap);
        }

        @J2ktIncompatible
        private void I1(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.Y2 = E1(objectInputStream).i();
            B1(objectInputStream);
        }

        private Object J1() {
            return this.Y2;
        }

        private void K1(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            G1(objectOutputStream);
        }
    }

    enum Strength {
        STRONG {
            /* access modifiers changed from: package-private */
            public Equivalence<Object> b() {
                return Equivalence.c();
            }
        },
        WEAK {
            /* access modifiers changed from: package-private */
            public Equivalence<Object> b() {
                return Equivalence.g();
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Equivalence<Object> b();
    }

    static class StrongKeyDummyValueEntry<K> extends AbstractStrongKeyEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> {

        static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?> f22439a = new Helper<>();

            Helper() {
            }

            static <K> Helper<K> h() {
                return f22439a;
            }

            public Strength c() {
                return Strength.STRONG;
            }

            public Strength d() {
                return Strength.STRONG;
            }

            /* renamed from: g */
            public StrongKeyDummyValueEntry<K> b(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry, @CheckForNull StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry2) {
                return f(strongKeyDummyValueSegment, strongKeyDummyValueEntry.s, strongKeyDummyValueEntry.X, strongKeyDummyValueEntry2);
            }

            /* renamed from: i */
            public StrongKeyDummyValueEntry<K> f(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, K k2, int i2, @CheckForNull StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry) {
                return strongKeyDummyValueEntry == null ? new StrongKeyDummyValueEntry<>(k2, i2) : new LinkedStrongKeyDummyValueEntry(k2, i2, strongKeyDummyValueEntry);
            }

            /* renamed from: j */
            public StrongKeyDummyValueSegment<K> a(MapMakerInternalMap<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i2) {
                return new StrongKeyDummyValueSegment<>(mapMakerInternalMap, i2);
            }

            /* renamed from: k */
            public void e(StrongKeyDummyValueSegment<K> strongKeyDummyValueSegment, StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry, MapMaker.Dummy dummy) {
            }
        }

        private static final class LinkedStrongKeyDummyValueEntry<K> extends StrongKeyDummyValueEntry<K> {
            private final StrongKeyDummyValueEntry<K> Y;

            LinkedStrongKeyDummyValueEntry(K k2, int i2, StrongKeyDummyValueEntry<K> strongKeyDummyValueEntry) {
                super(k2, i2);
                this.Y = strongKeyDummyValueEntry;
            }

            /* renamed from: e */
            public StrongKeyDummyValueEntry<K> a() {
                return this.Y;
            }

            public /* bridge */ /* synthetic */ Object getValue() {
                return super.getValue();
            }
        }

        private StrongKeyDummyValueEntry(K k2, int i2) {
            super(k2, i2);
        }

        /* renamed from: d */
        public final MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
        StrongKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
        }

        /* renamed from: X */
        public StrongKeyDummyValueEntry<K> a(InternalEntry<K, MapMaker.Dummy, ?> internalEntry) {
            return (StrongKeyDummyValueEntry) internalEntry;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: Y */
        public StrongKeyDummyValueSegment<K> R() {
            return this;
        }
    }

    static class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, StrongKeyStrongValueEntry<K, V>> {
        /* access modifiers changed from: private */
        @CheckForNull
        public volatile V Y;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f22440a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> h() {
                return f22440a;
            }

            public Strength c() {
                return Strength.STRONG;
            }

            public Strength d() {
                return Strength.STRONG;
            }

            /* renamed from: g */
            public StrongKeyStrongValueEntry<K, V> b(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry, @CheckForNull StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry2) {
                StrongKeyStrongValueEntry<K, V> i2 = f(strongKeyStrongValueSegment, strongKeyStrongValueEntry.s, strongKeyStrongValueEntry.X, strongKeyStrongValueEntry2);
                Object unused = i2.Y = strongKeyStrongValueEntry.Y;
                return i2;
            }

            /* renamed from: i */
            public StrongKeyStrongValueEntry<K, V> f(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, K k2, int i2, @CheckForNull StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
                return strongKeyStrongValueEntry == null ? new StrongKeyStrongValueEntry<>(k2, i2) : new LinkedStrongKeyStrongValueEntry(k2, i2, strongKeyStrongValueEntry);
            }

            /* renamed from: j */
            public StrongKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2) {
                return new StrongKeyStrongValueSegment<>(mapMakerInternalMap, i2);
            }

            /* renamed from: k */
            public void e(StrongKeyStrongValueSegment<K, V> strongKeyStrongValueSegment, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry, V v) {
                Object unused = strongKeyStrongValueEntry.Y = v;
            }
        }

        private static final class LinkedStrongKeyStrongValueEntry<K, V> extends StrongKeyStrongValueEntry<K, V> {
            private final StrongKeyStrongValueEntry<K, V> Z;

            LinkedStrongKeyStrongValueEntry(K k2, int i2, StrongKeyStrongValueEntry<K, V> strongKeyStrongValueEntry) {
                super(k2, i2);
                this.Z = strongKeyStrongValueEntry;
            }

            /* renamed from: f */
            public StrongKeyStrongValueEntry<K, V> a() {
                return this.Z;
            }
        }

        private StrongKeyStrongValueEntry(K k2, int i2) {
            super(k2, i2);
            this.Y = null;
        }

        @CheckForNull
        public final V getValue() {
            return this.Y;
        }
    }

    static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
        StrongKeyStrongValueSegment(MapMakerInternalMap<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
        }

        @CheckForNull
        /* renamed from: X */
        public StrongKeyStrongValueEntry<K, V> a(@CheckForNull InternalEntry<K, V, ?> internalEntry) {
            return (StrongKeyStrongValueEntry) internalEntry;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: Y */
        public StrongKeyStrongValueSegment<K, V> R() {
            return this;
        }
    }

    static class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {
        /* access modifiers changed from: private */
        public volatile WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> Y;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f22441a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> h() {
                return f22441a;
            }

            public Strength c() {
                return Strength.STRONG;
            }

            public Strength d() {
                return Strength.WEAK;
            }

            @CheckForNull
            /* renamed from: g */
            public StrongKeyWeakValueEntry<K, V> b(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry, @CheckForNull StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry2) {
                if (Segment.v(strongKeyWeakValueEntry)) {
                    return null;
                }
                StrongKeyWeakValueEntry<K, V> i2 = f(strongKeyWeakValueSegment, strongKeyWeakValueEntry.s, strongKeyWeakValueEntry.X, strongKeyWeakValueEntry2);
                WeakValueReference unused = i2.Y = strongKeyWeakValueEntry.Y.b(strongKeyWeakValueSegment.Z2, i2);
                return i2;
            }

            /* renamed from: i */
            public StrongKeyWeakValueEntry<K, V> f(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, K k2, int i2, @CheckForNull StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
                return strongKeyWeakValueEntry == null ? new StrongKeyWeakValueEntry<>(k2, i2) : new LinkedStrongKeyWeakValueEntry(k2, i2, strongKeyWeakValueEntry);
            }

            /* renamed from: j */
            public StrongKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2) {
                return new StrongKeyWeakValueSegment<>(mapMakerInternalMap, i2);
            }

            /* renamed from: k */
            public void e(StrongKeyWeakValueSegment<K, V> strongKeyWeakValueSegment, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry, V v) {
                WeakValueReference d2 = strongKeyWeakValueEntry.Y;
                WeakValueReference unused = strongKeyWeakValueEntry.Y = new WeakValueReferenceImpl(strongKeyWeakValueSegment.Z2, v, strongKeyWeakValueEntry);
                d2.clear();
            }
        }

        private static final class LinkedStrongKeyWeakValueEntry<K, V> extends StrongKeyWeakValueEntry<K, V> {
            private final StrongKeyWeakValueEntry<K, V> Z;

            LinkedStrongKeyWeakValueEntry(K k2, int i2, StrongKeyWeakValueEntry<K, V> strongKeyWeakValueEntry) {
                super(k2, i2);
                this.Z = strongKeyWeakValueEntry;
            }

            /* renamed from: f */
            public StrongKeyWeakValueEntry<K, V> a() {
                return this.Z;
            }
        }

        private StrongKeyWeakValueEntry(K k2, int i2) {
            super(k2, i2);
            this.Y = MapMakerInternalMap.t();
        }

        public final WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> b() {
            return this.Y;
        }

        @CheckForNull
        public final V getValue() {
            return this.Y.get();
        }
    }

    static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {
        /* access modifiers changed from: private */
        public final ReferenceQueue<V> Z2 = new ReferenceQueue<>();

        StrongKeyWeakValueSegment(MapMakerInternalMap<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
        }

        public WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> A(InternalEntry<K, V, ?> internalEntry, V v) {
            return new WeakValueReferenceImpl(this.Z2, v, a(internalEntry));
        }

        public void V(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            StrongKeyWeakValueEntry<K, V> Y = a(internalEntry);
            WeakValueReference d2 = Y.Y;
            WeakValueReference unused = Y.Y = weakValueReference;
            d2.clear();
        }

        @CheckForNull
        /* renamed from: Y */
        public StrongKeyWeakValueEntry<K, V> a(@CheckForNull InternalEntry<K, V, ?> internalEntry) {
            return (StrongKeyWeakValueEntry) internalEntry;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: Z */
        public StrongKeyWeakValueSegment<K, V> R() {
            return this;
        }

        /* access modifiers changed from: package-private */
        public ReferenceQueue<V> s() {
            return this.Z2;
        }

        public WeakValueReference<K, V, StrongKeyWeakValueEntry<K, V>> t(InternalEntry<K, V, ?> internalEntry) {
            return a(internalEntry).b();
        }

        /* access modifiers changed from: package-private */
        public void w() {
            c(this.Z2);
        }

        /* access modifiers changed from: package-private */
        public void x() {
            j(this.Z2);
        }
    }

    interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    }

    final class ValueIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<V> {
        ValueIterator(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        public V next() {
            return c().getValue();
        }
    }

    final class Values extends AbstractCollection<V> {
        Values() {
        }

        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        public Iterator<V> iterator() {
            return new ValueIterator(MapMakerInternalMap.this);
        }

        public int size() {
            return MapMakerInternalMap.this.size();
        }

        public Object[] toArray() {
            return MapMakerInternalMap.s(this).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return MapMakerInternalMap.s(this).toArray(tArr);
        }
    }

    static class WeakKeyDummyValueEntry<K> extends AbstractWeakKeyEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> {

        static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?> f22442a = new Helper<>();

            Helper() {
            }

            static <K> Helper<K> h() {
                return f22442a;
            }

            public Strength c() {
                return Strength.WEAK;
            }

            public Strength d() {
                return Strength.STRONG;
            }

            @CheckForNull
            /* renamed from: g */
            public WeakKeyDummyValueEntry<K> b(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry, @CheckForNull WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry2) {
                K key = weakKeyDummyValueEntry.getKey();
                if (key == null) {
                    return null;
                }
                return f(weakKeyDummyValueSegment, key, weakKeyDummyValueEntry.s, weakKeyDummyValueEntry2);
            }

            /* renamed from: i */
            public WeakKeyDummyValueEntry<K> f(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, K k2, int i2, @CheckForNull WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry) {
                return weakKeyDummyValueEntry == null ? new WeakKeyDummyValueEntry<>(weakKeyDummyValueSegment.Z2, k2, i2) : new LinkedWeakKeyDummyValueEntry(weakKeyDummyValueSegment.Z2, k2, i2, weakKeyDummyValueEntry);
            }

            /* renamed from: j */
            public WeakKeyDummyValueSegment<K> a(MapMakerInternalMap<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i2) {
                return new WeakKeyDummyValueSegment<>(mapMakerInternalMap, i2);
            }

            /* renamed from: k */
            public void e(WeakKeyDummyValueSegment<K> weakKeyDummyValueSegment, WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry, MapMaker.Dummy dummy) {
            }
        }

        private static final class LinkedWeakKeyDummyValueEntry<K> extends WeakKeyDummyValueEntry<K> {
            private final WeakKeyDummyValueEntry<K> X;

            private LinkedWeakKeyDummyValueEntry(ReferenceQueue<K> referenceQueue, K k2, int i2, WeakKeyDummyValueEntry<K> weakKeyDummyValueEntry) {
                super(referenceQueue, k2, i2);
                this.X = weakKeyDummyValueEntry;
            }

            /* renamed from: e */
            public WeakKeyDummyValueEntry<K> a() {
                return this.X;
            }

            public /* bridge */ /* synthetic */ Object getValue() {
                return super.getValue();
            }
        }

        private WeakKeyDummyValueEntry(ReferenceQueue<K> referenceQueue, K k2, int i2) {
            super(referenceQueue, k2, i2);
        }

        /* renamed from: d */
        public final MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }
    }

    static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {
        /* access modifiers changed from: private */
        public final ReferenceQueue<K> Z2 = new ReferenceQueue<>();

        WeakKeyDummyValueSegment(MapMakerInternalMap<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
        }

        /* renamed from: Y */
        public WeakKeyDummyValueEntry<K> a(InternalEntry<K, MapMaker.Dummy, ?> internalEntry) {
            return (WeakKeyDummyValueEntry) internalEntry;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: Z */
        public WeakKeyDummyValueSegment<K> R() {
            return this;
        }

        /* access modifiers changed from: package-private */
        public ReferenceQueue<K> o() {
            return this.Z2;
        }

        /* access modifiers changed from: package-private */
        public void w() {
            c(this.Z2);
        }

        /* access modifiers changed from: package-private */
        public void x() {
            i(this.Z2);
        }
    }

    static class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, WeakKeyStrongValueEntry<K, V>> {
        /* access modifiers changed from: private */
        @CheckForNull
        public volatile V X;

        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f22443a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> h() {
                return f22443a;
            }

            public Strength c() {
                return Strength.WEAK;
            }

            public Strength d() {
                return Strength.STRONG;
            }

            @CheckForNull
            /* renamed from: g */
            public WeakKeyStrongValueEntry<K, V> b(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry, @CheckForNull WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry2) {
                K key = weakKeyStrongValueEntry.getKey();
                if (key == null) {
                    return null;
                }
                WeakKeyStrongValueEntry<K, V> i2 = f(weakKeyStrongValueSegment, key, weakKeyStrongValueEntry.s, weakKeyStrongValueEntry2);
                Object unused = i2.X = weakKeyStrongValueEntry.X;
                return i2;
            }

            /* renamed from: i */
            public WeakKeyStrongValueEntry<K, V> f(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, K k2, int i2, @CheckForNull WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
                return weakKeyStrongValueEntry == null ? new WeakKeyStrongValueEntry<>(weakKeyStrongValueSegment.Z2, k2, i2) : new LinkedWeakKeyStrongValueEntry(weakKeyStrongValueSegment.Z2, k2, i2, weakKeyStrongValueEntry);
            }

            /* renamed from: j */
            public WeakKeyStrongValueSegment<K, V> a(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2) {
                return new WeakKeyStrongValueSegment<>(mapMakerInternalMap, i2);
            }

            /* renamed from: k */
            public void e(WeakKeyStrongValueSegment<K, V> weakKeyStrongValueSegment, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry, V v) {
                Object unused = weakKeyStrongValueEntry.X = v;
            }
        }

        private static final class LinkedWeakKeyStrongValueEntry<K, V> extends WeakKeyStrongValueEntry<K, V> {
            private final WeakKeyStrongValueEntry<K, V> Y;

            private LinkedWeakKeyStrongValueEntry(ReferenceQueue<K> referenceQueue, K k2, int i2, WeakKeyStrongValueEntry<K, V> weakKeyStrongValueEntry) {
                super(referenceQueue, k2, i2);
                this.Y = weakKeyStrongValueEntry;
            }

            /* renamed from: f */
            public WeakKeyStrongValueEntry<K, V> a() {
                return this.Y;
            }
        }

        private WeakKeyStrongValueEntry(ReferenceQueue<K> referenceQueue, K k2, int i2) {
            super(referenceQueue, k2, i2);
            this.X = null;
        }

        @CheckForNull
        public final V getValue() {
            return this.X;
        }
    }

    static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {
        /* access modifiers changed from: private */
        public final ReferenceQueue<K> Z2 = new ReferenceQueue<>();

        WeakKeyStrongValueSegment(MapMakerInternalMap<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
        }

        /* renamed from: Y */
        public WeakKeyStrongValueEntry<K, V> a(InternalEntry<K, V, ?> internalEntry) {
            return (WeakKeyStrongValueEntry) internalEntry;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: Z */
        public WeakKeyStrongValueSegment<K, V> R() {
            return this;
        }

        /* access modifiers changed from: package-private */
        public ReferenceQueue<K> o() {
            return this.Z2;
        }

        /* access modifiers changed from: package-private */
        public void w() {
            c(this.Z2);
        }

        /* access modifiers changed from: package-private */
        public void x() {
            i(this.Z2);
        }
    }

    static class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {
        /* access modifiers changed from: private */
        public volatile WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> X = MapMakerInternalMap.t();

        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* renamed from: a  reason: collision with root package name */
            private static final Helper<?, ?> f22444a = new Helper<>();

            Helper() {
            }

            static <K, V> Helper<K, V> h() {
                return f22444a;
            }

            public Strength c() {
                return Strength.WEAK;
            }

            public Strength d() {
                return Strength.WEAK;
            }

            @CheckForNull
            /* renamed from: g */
            public WeakKeyWeakValueEntry<K, V> b(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry, @CheckForNull WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry2) {
                K key = weakKeyWeakValueEntry.getKey();
                if (key == null || Segment.v(weakKeyWeakValueEntry)) {
                    return null;
                }
                WeakKeyWeakValueEntry<K, V> i2 = f(weakKeyWeakValueSegment, key, weakKeyWeakValueEntry.s, weakKeyWeakValueEntry2);
                WeakValueReference unused = i2.X = weakKeyWeakValueEntry.X.b(weakKeyWeakValueSegment.a3, i2);
                return i2;
            }

            /* renamed from: i */
            public WeakKeyWeakValueEntry<K, V> f(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, K k2, int i2, @CheckForNull WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
                return weakKeyWeakValueEntry == null ? new WeakKeyWeakValueEntry<>(weakKeyWeakValueSegment.Z2, k2, i2) : new LinkedWeakKeyWeakValueEntry(weakKeyWeakValueSegment.Z2, k2, i2, weakKeyWeakValueEntry);
            }

            /* renamed from: j */
            public WeakKeyWeakValueSegment<K, V> a(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2) {
                return new WeakKeyWeakValueSegment<>(mapMakerInternalMap, i2);
            }

            /* renamed from: k */
            public void e(WeakKeyWeakValueSegment<K, V> weakKeyWeakValueSegment, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry, V v) {
                WeakValueReference d2 = weakKeyWeakValueEntry.X;
                WeakValueReference unused = weakKeyWeakValueEntry.X = new WeakValueReferenceImpl(weakKeyWeakValueSegment.a3, v, weakKeyWeakValueEntry);
                d2.clear();
            }
        }

        private static final class LinkedWeakKeyWeakValueEntry<K, V> extends WeakKeyWeakValueEntry<K, V> {
            private final WeakKeyWeakValueEntry<K, V> Y;

            LinkedWeakKeyWeakValueEntry(ReferenceQueue<K> referenceQueue, K k2, int i2, WeakKeyWeakValueEntry<K, V> weakKeyWeakValueEntry) {
                super(referenceQueue, k2, i2);
                this.Y = weakKeyWeakValueEntry;
            }

            /* renamed from: f */
            public WeakKeyWeakValueEntry<K, V> a() {
                return this.Y;
            }
        }

        WeakKeyWeakValueEntry(ReferenceQueue<K> referenceQueue, K k2, int i2) {
            super(referenceQueue, k2, i2);
        }

        public final WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> b() {
            return this.X;
        }

        public final V getValue() {
            return this.X.get();
        }
    }

    static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {
        /* access modifiers changed from: private */
        public final ReferenceQueue<K> Z2 = new ReferenceQueue<>();
        /* access modifiers changed from: private */
        public final ReferenceQueue<V> a3 = new ReferenceQueue<>();

        WeakKeyWeakValueSegment(MapMakerInternalMap<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> mapMakerInternalMap, int i2) {
            super(mapMakerInternalMap, i2);
        }

        public WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> A(InternalEntry<K, V, ?> internalEntry, V v) {
            return new WeakValueReferenceImpl(this.a3, v, a(internalEntry));
        }

        public void V(InternalEntry<K, V, ?> internalEntry, WeakValueReference<K, V, ? extends InternalEntry<K, V, ?>> weakValueReference) {
            WeakKeyWeakValueEntry<K, V> Z = a(internalEntry);
            WeakValueReference d2 = Z.X;
            WeakValueReference unused = Z.X = weakValueReference;
            d2.clear();
        }

        @CheckForNull
        /* renamed from: Z */
        public WeakKeyWeakValueEntry<K, V> a(@CheckForNull InternalEntry<K, V, ?> internalEntry) {
            return (WeakKeyWeakValueEntry) internalEntry;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a0 */
        public WeakKeyWeakValueSegment<K, V> R() {
            return this;
        }

        /* access modifiers changed from: package-private */
        public ReferenceQueue<K> o() {
            return this.Z2;
        }

        /* access modifiers changed from: package-private */
        public ReferenceQueue<V> s() {
            return this.a3;
        }

        public WeakValueReference<K, V, WeakKeyWeakValueEntry<K, V>> t(InternalEntry<K, V, ?> internalEntry) {
            return a(internalEntry).b();
        }

        /* access modifiers changed from: package-private */
        public void w() {
            c(this.Z2);
        }

        /* access modifiers changed from: package-private */
        public void x() {
            i(this.Z2);
            j(this.a3);
        }
    }

    interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        WeakValueReference<K, V, E> b();
    }

    interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        E a();

        WeakValueReference<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2);

        void clear();

        @CheckForNull
        V get();
    }

    static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {
        @Weak
        final E s;

        WeakValueReferenceImpl(ReferenceQueue<V> referenceQueue, V v, E e2) {
            super(v, referenceQueue);
            this.s = e2;
        }

        public E a() {
            return this.s;
        }

        public WeakValueReference<K, V, E> b(ReferenceQueue<V> referenceQueue, E e2) {
            return new WeakValueReferenceImpl(referenceQueue, get(), e2);
        }
    }

    final class WriteThroughEntry extends AbstractMapEntry<K, V> {
        V X;
        final K s;

        WriteThroughEntry(K k2, V v) {
            this.s = k2;
            this.X = v;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.s.equals(entry.getKey()) && this.X.equals(entry.getValue());
        }

        public K getKey() {
            return this.s;
        }

        public V getValue() {
            return this.X;
        }

        public int hashCode() {
            return this.s.hashCode() ^ this.X.hashCode();
        }

        public V setValue(V v) {
            V put = MapMakerInternalMap.this.put(this.s, v);
            this.X = v;
            return put;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, InternalEntryHelper<K, V, E, S> internalEntryHelper) {
        this.Z = Math.min(mapMaker.b(), 65536);
        this.X2 = mapMaker.d();
        this.Y2 = internalEntryHelper;
        int min = Math.min(mapMaker.c(), 1073741824);
        int i2 = 0;
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        while (i5 < this.Z) {
            i6++;
            i5 <<= 1;
        }
        this.X = 32 - i6;
        this.s = i5 - 1;
        this.Y = k(i5);
        int i7 = min / i5;
        while (i4 < (i5 * i7 < min ? i7 + 1 : i7)) {
            i4 <<= 1;
        }
        while (true) {
            Segment<K, V, E, S>[] segmentArr = this.Y;
            if (i2 < segmentArr.length) {
                segmentArr[i2] = d(i4);
                i2++;
            } else {
                return;
            }
        }
    }

    static <K, V> MapMakerInternalMap<K, V, ? extends InternalEntry<K, V, ?>, ?> c(MapMaker mapMaker) {
        Strength e2 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e2 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, StrongKeyStrongValueEntry.Helper.h());
        }
        if (mapMaker.e() == strength && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap<>(mapMaker, StrongKeyWeakValueEntry.Helper.h());
        }
        Strength e4 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e4 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, WeakKeyStrongValueEntry.Helper.h());
        }
        if (mapMaker.e() == strength2 && mapMaker.f() == strength2) {
            return new MapMakerInternalMap<>(mapMaker, WeakKeyWeakValueEntry.Helper.h());
        }
        throw new AssertionError();
    }

    static <K> MapMakerInternalMap<K, MapMaker.Dummy, ? extends InternalEntry<K, MapMaker.Dummy, ?>, ?> e(MapMaker mapMaker) {
        Strength e2 = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (e2 == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, StrongKeyDummyValueEntry.Helper.h());
        }
        Strength e4 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (e4 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap<>(mapMaker, WeakKeyDummyValueEntry.Helper.h());
        }
        if (mapMaker.f() == strength2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    @J2ktIncompatible
    private void l(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    static int o(int i2) {
        int i4 = i2 + ((i2 << 15) ^ -12931);
        int i5 = i4 ^ (i4 >>> 10);
        int i6 = i5 + (i5 << 3);
        int i7 = i6 ^ (i6 >>> 6);
        int i8 = i7 + (i7 << 2) + (i7 << 14);
        return i8 ^ (i8 >>> 16);
    }

    /* access modifiers changed from: private */
    public static <E> ArrayList<E> s(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V, E extends InternalEntry<K, V, E>> WeakValueReference<K, V, E> t() {
        return h3;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public E b(E e2, E e4) {
        return p(e2.c()).g(e2, e4);
    }

    public void clear() {
        for (Segment<K, V, E, S> b2 : this.Y) {
            b2.b();
        }
    }

    public boolean containsKey(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        int h2 = h(obj);
        return p(h2).e(obj, h2);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        Object obj2 = obj;
        if (obj2 == null) {
            return false;
        }
        Segment<K, V, E, S>[] segmentArr = this.Y;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            for (Segment<K, V, E, S> segment : segmentArr) {
                int i4 = segment.X;
                AtomicReferenceArray<E> atomicReferenceArray = segment.X2;
                for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                    for (InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(i5); internalEntry != null; internalEntry = internalEntry.a()) {
                        V q = segment.q(internalEntry);
                        if (q != null && u().d(obj2, q)) {
                            return true;
                        }
                    }
                }
                j3 += (long) segment.Y;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V, E, S> d(int i2) {
        return this.Y2.a(this, i2);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.b3;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.b3 = entrySet;
        return entrySet;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public E f(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int h2 = h(obj);
        return p(h2).m(obj, h2);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V g(E e2) {
        if (e2.getKey() == null) {
            return null;
        }
        return e2.getValue();
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int h2 = h(obj);
        return p(h2).l(obj, h2);
    }

    /* access modifiers changed from: package-private */
    public int h(Object obj) {
        return o(this.X2.f(obj));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean i(InternalEntry<K, V, ?> internalEntry) {
        return p(internalEntry.c()).r(internalEntry) != null;
    }

    public boolean isEmpty() {
        Segment<K, V, E, S>[] segmentArr = this.Y;
        long j2 = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].X != 0) {
                return false;
            }
            j2 += (long) segmentArr[i2].Y;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i4 = 0; i4 < segmentArr.length; i4++) {
            if (segmentArr[i4].X != 0) {
                return false;
            }
            j2 -= (long) segmentArr[i4].Y;
        }
        return j2 == 0;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Strength j() {
        return this.Y2.c();
    }

    /* access modifiers changed from: package-private */
    public final Segment<K, V, E, S>[] k(int i2) {
        return new Segment[i2];
    }

    public Set<K> keySet() {
        Set<K> set = this.Z2;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.Z2 = keySet;
        return keySet;
    }

    /* access modifiers changed from: package-private */
    public void m(E e2) {
        int c2 = e2.c();
        p(c2).E(e2, c2);
    }

    /* access modifiers changed from: package-private */
    public void n(WeakValueReference<K, V, E> weakValueReference) {
        E a2 = weakValueReference.a();
        int c2 = a2.c();
        p(c2).F(a2.getKey(), c2, weakValueReference);
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V, E, S> p(int i2) {
        return this.Y[(i2 >>> this.X) & this.s];
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V put(K k2, V v) {
        Preconditions.E(k2);
        Preconditions.E(v);
        int h2 = h(k2);
        return p(h2).D(k2, h2, v, false);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V putIfAbsent(K k2, V v) {
        Preconditions.E(k2);
        Preconditions.E(v);
        int h2 = h(k2);
        return p(h2).D(k2, h2, v, true);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int h2 = h(obj);
        return p(h2).H(obj, h2);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V replace(K k2, V v) {
        Preconditions.E(k2);
        Preconditions.E(v);
        int h2 = h(k2);
        return p(h2).N(k2, h2, v);
    }

    public int size() {
        Segment<K, V, E, S>[] segmentArr = this.Y;
        long j2 = 0;
        for (Segment<K, V, E, S> segment : segmentArr) {
            j2 += (long) segment.X;
        }
        return Ints.z(j2);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Equivalence<Object> u() {
        return this.Y2.d().b();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Strength v() {
        return this.Y2.d();
    }

    public Collection<V> values() {
        Collection<V> collection = this.a3;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.a3 = values;
        return values;
    }

    /* access modifiers changed from: package-private */
    public Object w() {
        return new SerializationProxy(this.Y2.c(), this.Y2.d(), this.X2, this.Y2.d().b(), this.Z, this);
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int h2 = h(obj);
        return p(h2).I(obj, h2, obj2);
    }

    @CanIgnoreReturnValue
    public boolean replace(K k2, @CheckForNull V v, V v2) {
        Preconditions.E(k2);
        Preconditions.E(v2);
        if (v == null) {
            return false;
        }
        int h2 = h(k2);
        return p(h2).O(k2, h2, v, v2);
    }
}
