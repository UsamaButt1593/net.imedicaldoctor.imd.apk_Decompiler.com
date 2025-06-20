package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final int p3 = 1073741824;
    static final int q3 = 65536;
    static final int r3 = 3;
    static final int s3 = 63;
    static final int t3 = 16;
    static final Logger u3 = Logger.getLogger(LocalCache.class.getName());
    static final ValueReference<Object, Object> v3 = new ValueReference<Object, Object>() {
        @CheckForNull
        public ReferenceEntry<Object, Object> a() {
            return null;
        }

        public boolean b() {
            return false;
        }

        public boolean c() {
            return false;
        }

        public void d(Object obj) {
        }

        public int e() {
            return 0;
        }

        @CheckForNull
        public Object f() {
            return null;
        }

        public ValueReference<Object, Object> g(ReferenceQueue<Object> referenceQueue, @CheckForNull Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        @CheckForNull
        public Object get() {
            return null;
        }
    };
    static final Queue<?> w3 = new AbstractQueue<Object>() {
        public Iterator<Object> iterator() {
            return ImmutableSet.K().iterator();
        }

        public boolean offer(Object obj) {
            return true;
        }

        @CheckForNull
        public Object peek() {
            return null;
        }

        @CheckForNull
        public Object poll() {
            return null;
        }

        public int size() {
            return 0;
        }
    };
    final int X;
    final Equivalence<Object> X2;
    final Segment<K, V>[] Y;
    final Equivalence<Object> Y2;
    final int Z;
    final Strength Z2;
    final Strength a3;
    final long b3;
    final Weigher<K, V> c3;
    final long d3;
    final long e3;
    final long f3;
    final Queue<RemovalNotification<K, V>> g3;
    final RemovalListener<K, V> h3;
    final Ticker i3;
    final EntryFactory j3;
    final AbstractCache.StatsCounter k3;
    @CheckForNull
    final CacheLoader<? super K, V> l3;
    @RetainedWith
    @CheckForNull
    @LazyInit
    Set<K> m3;
    @RetainedWith
    @CheckForNull
    @LazyInit
    Collection<V> n3;
    @RetainedWith
    @CheckForNull
    @LazyInit
    Set<Map.Entry<K, V>> o3;
    final int s;

    abstract class AbstractCacheSet<T> extends AbstractSet<T> {
        AbstractCacheSet() {
        }

        public void clear() {
            LocalCache.this.clear();
        }

        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        public int size() {
            return LocalCache.this.size();
        }

        public Object[] toArray() {
            return LocalCache.T(this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return LocalCache.T(this).toArray(eArr);
        }
    }

    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        public ReferenceEntry<K, V> a() {
            throw new UnsupportedOperationException();
        }

        public ValueReference<K, V> b() {
            throw new UnsupportedOperationException();
        }

        public int c() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> e() {
            throw new UnsupportedOperationException();
        }

        public void f(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        public long g() {
            throw new UnsupportedOperationException();
        }

        public K getKey() {
            throw new UnsupportedOperationException();
        }

        public void h(long j2) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> i() {
            throw new UnsupportedOperationException();
        }

        public long j() {
            throw new UnsupportedOperationException();
        }

        public void k(long j2) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> l() {
            throw new UnsupportedOperationException();
        }

        public void m(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void n(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void o(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void p(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> q() {
            throw new UnsupportedOperationException();
        }
    }

    static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> s = new AbstractReferenceEntry<K, V>(this) {
            @Weak
            ReferenceEntry<K, V> X = this;
            @Weak
            ReferenceEntry<K, V> s = this;

            public ReferenceEntry<K, V> e() {
                return this.X;
            }

            public void h(long j2) {
            }

            public long j() {
                return Long.MAX_VALUE;
            }

            public ReferenceEntry<K, V> l() {
                return this.s;
            }

            public void m(ReferenceEntry<K, V> referenceEntry) {
                this.s = referenceEntry;
            }

            public void p(ReferenceEntry<K, V> referenceEntry) {
                this.X = referenceEntry;
            }
        };

        AccessQueue() {
        }

        /* renamed from: b */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.c(referenceEntry.e(), referenceEntry.l());
            LocalCache.c(this.s.e(), referenceEntry);
            LocalCache.c(referenceEntry, this.s);
            return true;
        }

        @CheckForNull
        /* renamed from: c */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> l2 = this.s.l();
            if (l2 == this.s) {
                return null;
            }
            return l2;
        }

        public void clear() {
            ReferenceEntry<K, V> l2 = this.s.l();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.s;
                if (l2 != referenceEntry) {
                    ReferenceEntry<K, V> l3 = l2.l();
                    LocalCache.G(l2);
                    l2 = l3;
                } else {
                    referenceEntry.m(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.s;
                    referenceEntry2.p(referenceEntry2);
                    return;
                }
            }
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).l() != NullEntry.INSTANCE;
        }

        @CheckForNull
        /* renamed from: d */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> l2 = this.s.l();
            if (l2 == this.s) {
                return null;
            }
            remove(l2);
            return l2;
        }

        public boolean isEmpty() {
            return this.s.l() == this.s;
        }

        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) {
                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: b */
                public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> l2 = referenceEntry.l();
                    if (l2 == AccessQueue.this.s) {
                        return null;
                    }
                    return l2;
                }
            };
        }

        @CanIgnoreReturnValue
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry e2 = referenceEntry.e();
            ReferenceEntry l2 = referenceEntry.l();
            LocalCache.c(e2, l2);
            LocalCache.G(referenceEntry);
            return l2 != NullEntry.INSTANCE;
        }

        public int size() {
            int i2 = 0;
            for (ReferenceEntry<K, V> l2 = this.s.l(); l2 != this.s; l2 = l2.l()) {
                i2++;
            }
            return i2;
        }
    }

    enum EntryFactory {
        STRONG {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongEntry(k2, i2, referenceEntry);
            }
        },
        STRONG_ACCESS {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k2) {
                ReferenceEntry<K, V> c2 = super.c(segment, referenceEntry, referenceEntry2, k2);
                b(referenceEntry, c2);
                return c2;
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessEntry(k2, i2, referenceEntry);
            }
        },
        STRONG_WRITE {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k2) {
                ReferenceEntry<K, V> c2 = super.c(segment, referenceEntry, referenceEntry2, k2);
                e(referenceEntry, c2);
                return c2;
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongWriteEntry(k2, i2, referenceEntry);
            }
        },
        STRONG_ACCESS_WRITE {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k2) {
                ReferenceEntry<K, V> c2 = super.c(segment, referenceEntry, referenceEntry2, k2);
                b(referenceEntry, c2);
                e(referenceEntry, c2);
                return c2;
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessWriteEntry(k2, i2, referenceEntry);
            }
        },
        WEAK {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakEntry(segment.a3, k2, i2, referenceEntry);
            }
        },
        WEAK_ACCESS {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k2) {
                ReferenceEntry<K, V> c2 = super.c(segment, referenceEntry, referenceEntry2, k2);
                b(referenceEntry, c2);
                return c2;
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessEntry(segment.a3, k2, i2, referenceEntry);
            }
        },
        WEAK_WRITE {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k2) {
                ReferenceEntry<K, V> c2 = super.c(segment, referenceEntry, referenceEntry2, k2);
                e(referenceEntry, c2);
                return c2;
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakWriteEntry(segment.a3, k2, i2, referenceEntry);
            }
        },
        WEAK_ACCESS_WRITE {
            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k2) {
                ReferenceEntry<K, V> c2 = super.c(segment, referenceEntry, referenceEntry2, k2);
                b(referenceEntry, c2);
                e(referenceEntry, c2);
                return c2;
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessWriteEntry(segment.a3, k2, i2, referenceEntry);
            }
        };
        
        static final int b3 = 1;
        static final int c3 = 2;
        static final int d3 = 4;
        static final EntryFactory[] e3 = null;

        static {
            AnonymousClass1 r0;
            AnonymousClass2 r1;
            AnonymousClass3 r3;
            AnonymousClass4 r5;
            AnonymousClass5 r7;
            AnonymousClass6 r9;
            AnonymousClass7 r11;
            AnonymousClass8 r13;
            e3 = new EntryFactory[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        static EntryFactory f(Strength strength, boolean z, boolean z2) {
            char c2 = 0;
            boolean z3 = (strength == Strength.WEAK ? (char) 4 : 0) | z;
            if (z2) {
                c2 = 2;
            }
            return e3[z3 | c2];
        }

        /* access modifiers changed from: package-private */
        public <K, V> void b(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.h(referenceEntry.j());
            LocalCache.c(referenceEntry.e(), referenceEntry2);
            LocalCache.c(referenceEntry2, referenceEntry.l());
            LocalCache.G(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public <K, V> ReferenceEntry<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k2) {
            return g(segment, k2, referenceEntry.c(), referenceEntry2);
        }

        /* access modifiers changed from: package-private */
        public <K, V> void e(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.k(referenceEntry.g());
            LocalCache.d(referenceEntry.q(), referenceEntry2);
            LocalCache.d(referenceEntry2, referenceEntry.i());
            LocalCache.H(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public abstract <K, V> ReferenceEntry<K, V> g(Segment<K, V> segment, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry);
    }

    final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        EntryIterator(LocalCache localCache) {
            super();
        }

        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        EntrySet() {
            super();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
            r0 = r3.X.get((r0 = r4.getKey()));
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
                com.google.common.cache.LocalCache r2 = com.google.common.cache.LocalCache.this
                java.lang.Object r0 = r2.get(r0)
                if (r0 == 0) goto L_0x0026
                com.google.common.cache.LocalCache r2 = com.google.common.cache.LocalCache.this
                com.google.common.base.Equivalence<java.lang.Object> r2 = r2.Y2
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r2.d(r4, r0)
                if (r4 == 0) goto L_0x0026
                r1 = 1
            L_0x0026:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.EntrySet.contains(java.lang.Object):boolean");
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(LocalCache.this);
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
                com.google.common.cache.LocalCache r2 = com.google.common.cache.LocalCache.this
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r2.remove(r0, r4)
                if (r4 == 0) goto L_0x001b
                r1 = 1
            L_0x001b:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.EntrySet.remove(java.lang.Object):boolean");
        }
    }

    abstract class HashIterator<T> implements Iterator<T> {
        int X = -1;
        @CheckForNull
        ReferenceEntry<K, V> X2;
        @CheckForNull
        Segment<K, V> Y;
        @CheckForNull
        LocalCache<K, V>.WriteThroughEntry Y2;
        @CheckForNull
        AtomicReferenceArray<ReferenceEntry<K, V>> Z;
        @CheckForNull
        LocalCache<K, V>.WriteThroughEntry Z2;
        int s;

        HashIterator() {
            this.s = LocalCache.this.Y.length - 1;
            a();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.Y2 = null;
            if (!d() && !e()) {
                while (true) {
                    int i2 = this.s;
                    if (i2 >= 0) {
                        Segment<K, V>[] segmentArr = LocalCache.this.Y;
                        this.s = i2 - 1;
                        Segment<K, V> segment = segmentArr[i2];
                        this.Y = segment;
                        if (segment.X != 0) {
                            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y.Y2;
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
        public boolean b(ReferenceEntry<K, V> referenceEntry) {
            try {
                long a2 = LocalCache.this.i3.a();
                K key = referenceEntry.getKey();
                V t = LocalCache.this.t(referenceEntry, a2);
                if (t != null) {
                    this.Y2 = new WriteThroughEntry(key, t);
                    this.Y.I();
                    return true;
                }
                this.Y.I();
                return false;
            } catch (Throwable th) {
                this.Y.I();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public LocalCache<K, V>.WriteThroughEntry c() {
            LocalCache<K, V>.WriteThroughEntry writeThroughEntry = this.Y2;
            if (writeThroughEntry != null) {
                this.Z2 = writeThroughEntry;
                a();
                return this.Z2;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            ReferenceEntry<K, V> referenceEntry = this.X2;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.X2 = referenceEntry.a();
                ReferenceEntry<K, V> referenceEntry2 = this.X2;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (b(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.X2;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            while (true) {
                int i2 = this.X;
                if (i2 < 0) {
                    return false;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Z;
                this.X = i2 - 1;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i2);
                this.X2 = referenceEntry;
                if (referenceEntry != null && (b(referenceEntry) || d())) {
                    return true;
                }
            }
        }

        public boolean hasNext() {
            return this.Y2 != null;
        }

        public abstract T next();

        public void remove() {
            Preconditions.g0(this.Z2 != null);
            LocalCache.this.remove(this.Z2.getKey());
            this.Z2 = null;
        }
    }

    final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        KeyIterator(LocalCache localCache) {
            super();
        }

        public K next() {
            return c().getKey();
        }
    }

    final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        KeySet() {
            super();
        }

        public boolean contains(Object obj) {
            return LocalCache.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new KeyIterator(LocalCache.this);
        }

        public boolean remove(Object obj) {
            return LocalCache.this.remove(obj) != null;
        }
    }

    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
        private static final long i3 = 1;
        @CheckForNull
        transient LoadingCache<K, V> h3;

        LoadingSerializationProxy(LocalCache<K, V> localCache) {
            super(localCache);
        }

        private void f1(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.h3 = m1().b(this.e3);
        }

        private Object i1() {
            return this.h3;
        }

        public V H(K k2) {
            return this.h3.H(k2);
        }

        public V apply(K k2) {
            return this.h3.apply(k2);
        }

        public ImmutableMap<K, V> e0(Iterable<? extends K> iterable) throws ExecutionException {
            return this.h3.e0(iterable);
        }

        public V get(K k2) throws ExecutionException {
            return this.h3.get(k2);
        }

        public void x0(K k2) {
            this.h3.x0(k2);
        }
    }

    static class LoadingValueReference<K, V> implements ValueReference<K, V> {
        final SettableFuture<V> X;
        final Stopwatch Y;
        volatile ValueReference<K, V> s;

        public LoadingValueReference() {
            this(LocalCache.U());
        }

        private ListenableFuture<V> j(Throwable th) {
            return Futures.n(th);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object l(Object obj) {
            n(obj);
            return obj;
        }

        public ReferenceEntry<K, V> a() {
            return null;
        }

        public boolean b() {
            return this.s.b();
        }

        public boolean c() {
            return true;
        }

        public void d(@CheckForNull V v) {
            if (v != null) {
                n(v);
            } else {
                this.s = LocalCache.U();
            }
        }

        public int e() {
            return this.s.e();
        }

        public V f() throws ExecutionException {
            return Uninterruptibles.f(this.X);
        }

        public ValueReference<K, V> g(ReferenceQueue<V> referenceQueue, @CheckForNull V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public V get() {
            return this.s.get();
        }

        public long i() {
            return this.Y.g(TimeUnit.NANOSECONDS);
        }

        public ValueReference<K, V> k() {
            return this.s;
        }

        public ListenableFuture<V> m(K k2, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.Y.k();
                V v = this.s.get();
                if (v == null) {
                    V d2 = cacheLoader.d(k2);
                    return n(d2) ? this.X : Futures.o(d2);
                }
                ListenableFuture<V> f2 = cacheLoader.f(k2, v);
                return f2 == null ? Futures.o(null) : Futures.B(f2, new b(this), MoreExecutors.c());
            } catch (Throwable th) {
                ListenableFuture<V> j2 = o(th) ? this.X : j(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return j2;
            }
        }

        @CanIgnoreReturnValue
        public boolean n(@CheckForNull V v) {
            return this.X.B(v);
        }

        @CanIgnoreReturnValue
        public boolean o(Throwable th) {
            return this.X.C(th);
        }

        public LoadingValueReference(ValueReference<K, V> valueReference) {
            this.X = SettableFuture.F();
            this.Y = Stopwatch.e();
            this.s = valueReference;
        }
    }

    static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long Y = 1;

        LocalLoadingCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
            super();
        }

        private void a(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use LoadingSerializationProxy");
        }

        @CanIgnoreReturnValue
        public V H(K k2) {
            try {
                return get(k2);
            } catch (ExecutionException e2) {
                throw new UncheckedExecutionException(e2.getCause());
            }
        }

        public final V apply(K k2) {
            return H(k2);
        }

        /* access modifiers changed from: package-private */
        public Object b() {
            return new LoadingSerializationProxy(this.s);
        }

        public ImmutableMap<K, V> e0(Iterable<? extends K> iterable) throws ExecutionException {
            return this.s.n(iterable);
        }

        public V get(K k2) throws ExecutionException {
            return this.s.u(k2);
        }

        public void x0(K k2) {
            this.s.P(k2);
        }
    }

    static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long X = 1;
        final LocalCache<K, V> s;

        LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, (CacheLoader) null));
        }

        private void a(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use ManualSerializationProxy");
        }

        @CheckForNull
        public V O(Object obj) {
            return this.s.s(obj);
        }

        public ImmutableMap<K, V> Q0(Iterable<?> iterable) {
            return this.s.o(iterable);
        }

        public V R(K k2, final Callable<? extends V> callable) throws ExecutionException {
            Preconditions.E(callable);
            return this.s.m(k2, new CacheLoader<Object, V>(this) {
                public V d(Object obj) throws Exception {
                    return callable.call();
                }
            });
        }

        public void T(Iterable<?> iterable) {
            this.s.w(iterable);
        }

        public void U0(Object obj) {
            Preconditions.E(obj);
            this.s.remove(obj);
        }

        public CacheStats V0() {
            AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.g(this.s.k3);
            for (Segment<K, V> segment : this.s.Y) {
                simpleStatsCounter.g(segment.g3);
            }
            return simpleStatsCounter.f();
        }

        public void X0() {
            this.s.clear();
        }

        /* access modifiers changed from: package-private */
        public Object b() {
            return new ManualSerializationProxy(this.s);
        }

        public ConcurrentMap<K, V> g() {
            return this.s;
        }

        public void o() {
            this.s.b();
        }

        public void put(K k2, V v) {
            this.s.put(k2, v);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            this.s.putAll(map);
        }

        public long size() {
            return this.s.B();
        }

        private LocalManualCache(LocalCache<K, V> localCache) {
            this.s = localCache;
        }
    }

    static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long g3 = 1;
        final Strength X;
        final long X2;
        final Equivalence<Object> Y;
        final long Y2;
        final Equivalence<Object> Z;
        final long Z2;
        final Weigher<K, V> a3;
        final int b3;
        final RemovalListener<? super K, ? super V> c3;
        @CheckForNull
        final Ticker d3;
        final CacheLoader<? super K, V> e3;
        @CheckForNull
        transient Cache<K, V> f3;
        final Strength s;

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j2, long j3, long j4, Weigher<K, V> weigher, int i2, RemovalListener<? super K, ? super V> removalListener, Ticker ticker, CacheLoader<? super K, V> cacheLoader) {
            this.s = strength;
            this.X = strength2;
            this.Y = equivalence;
            this.Z = equivalence2;
            this.X2 = j2;
            this.Y2 = j3;
            this.Z2 = j4;
            this.a3 = weigher;
            this.b3 = i2;
            this.c3 = removalListener;
            this.d3 = (ticker == Ticker.b() || ticker == CacheBuilder.x) ? null : ticker;
            this.e3 = cacheLoader;
        }

        private void f1(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f3 = m1().a();
        }

        private Object i1() {
            return this.f3;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Cache<K, V> Z0() {
            return this.f3;
        }

        /* access modifiers changed from: package-private */
        public CacheBuilder<K, V> m1() {
            CacheBuilder<K1, V1> G = CacheBuilder.D().H(this.s).I(this.X).z(this.Y).L(this.Z).e(this.b3).G(this.c3);
            G.f22309a = false;
            long j2 = this.X2;
            if (j2 > 0) {
                G.g(j2, TimeUnit.NANOSECONDS);
            }
            long j3 = this.Y2;
            if (j3 > 0) {
                G.f(j3, TimeUnit.NANOSECONDS);
            }
            Weigher<K, V> weigher = this.a3;
            if (weigher != CacheBuilder.OneWeigher.INSTANCE) {
                G.O(weigher);
                long j4 = this.Z2;
                if (j4 != -1) {
                    G.C(j4);
                }
            } else {
                long j5 = this.Z2;
                if (j5 != -1) {
                    G.B(j5);
                }
            }
            Ticker ticker = this.d3;
            if (ticker != null) {
                G.K(ticker);
            }
            return G;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ManualSerializationProxy(com.google.common.cache.LocalCache<K, V> r17) {
            /*
                r16 = this;
                r0 = r17
                com.google.common.cache.LocalCache$Strength r1 = r0.Z2
                com.google.common.cache.LocalCache$Strength r2 = r0.a3
                com.google.common.base.Equivalence<java.lang.Object> r3 = r0.X2
                com.google.common.base.Equivalence<java.lang.Object> r4 = r0.Y2
                long r5 = r0.e3
                long r7 = r0.d3
                long r9 = r0.b3
                com.google.common.cache.Weigher<K, V> r11 = r0.c3
                int r12 = r0.Z
                com.google.common.cache.RemovalListener<K, V> r13 = r0.h3
                com.google.common.base.Ticker r14 = r0.i3
                com.google.common.cache.CacheLoader<? super K, V> r15 = r0.l3
                r0 = r16
                r0.<init>(r1, r2, r3, r4, r5, r7, r9, r11, r12, r13, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.ManualSerializationProxy.<init>(com.google.common.cache.LocalCache):void");
        }
    }

    private enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        @CheckForNull
        public ReferenceEntry<Object, Object> a() {
            return null;
        }

        @CheckForNull
        public ValueReference<Object, Object> b() {
            return null;
        }

        public int c() {
            return 0;
        }

        public ReferenceEntry<Object, Object> e() {
            return this;
        }

        public void f(ValueReference<Object, Object> valueReference) {
        }

        public long g() {
            return 0;
        }

        @CheckForNull
        public Object getKey() {
            return null;
        }

        public void h(long j2) {
        }

        public ReferenceEntry<Object, Object> i() {
            return this;
        }

        public long j() {
            return 0;
        }

        public void k(long j2) {
        }

        public ReferenceEntry<Object, Object> l() {
            return this;
        }

        public void m(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void n(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void o(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void p(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public ReferenceEntry<Object, Object> q() {
            return this;
        }
    }

    static class Segment<K, V> extends ReentrantLock {
        volatile int X;
        int X2;
        @GuardedBy("this")
        long Y;
        @CheckForNull
        volatile AtomicReferenceArray<ReferenceEntry<K, V>> Y2;
        int Z;
        final long Z2;
        @CheckForNull
        final ReferenceQueue<K> a3;
        @CheckForNull
        final ReferenceQueue<V> b3;
        final Queue<ReferenceEntry<K, V>> c3;
        final AtomicInteger d3 = new AtomicInteger();
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> e3;
        @GuardedBy("this")
        final Queue<ReferenceEntry<K, V>> f3;
        final AbstractCache.StatsCounter g3;
        @Weak
        final LocalCache<K, V> s;

        Segment(LocalCache<K, V> localCache, int i2, long j2, AbstractCache.StatsCounter statsCounter) {
            this.s = localCache;
            this.Z2 = j2;
            this.g3 = (AbstractCache.StatsCounter) Preconditions.E(statsCounter);
            z(H(i2));
            ReferenceQueue<V> referenceQueue = null;
            this.a3 = localCache.X() ? new ReferenceQueue<>() : null;
            this.b3 = localCache.Y() ? new ReferenceQueue<>() : referenceQueue;
            this.c3 = localCache.W() ? new ConcurrentLinkedQueue<>() : LocalCache.h();
            this.e3 = localCache.a0() ? new WriteQueue<>() : LocalCache.h();
            this.f3 = localCache.W() ? new AccessQueue<>() : LocalCache.h();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void B(Object obj, int i2, LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) {
            try {
                t(obj, i2, loadingValueReference, listenableFuture);
            } catch (Throwable th) {
                LocalCache.u3.log(Level.WARNING, "Exception thrown during refresh", th);
                loadingValueReference.o(th);
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        @CheckForNull
        public LoadingValueReference<K, V> A(K k2, int i2, boolean z) {
            lock();
            try {
                long a2 = this.s.i3.a();
                K(a2);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.c() != i2 || key == null || !this.s.X2.d(k2, key)) {
                        referenceEntry2 = referenceEntry2.a();
                    } else {
                        ValueReference b2 = referenceEntry2.b();
                        if (!b2.c()) {
                            if (!z || a2 - referenceEntry2.g() >= this.s.f3) {
                                this.Z++;
                                LoadingValueReference<K, V> loadingValueReference = new LoadingValueReference<>(b2);
                                referenceEntry2.f(loadingValueReference);
                                unlock();
                                J();
                                return loadingValueReference;
                            }
                        }
                        unlock();
                        J();
                        return null;
                    }
                }
                this.Z++;
                LoadingValueReference<K, V> loadingValueReference2 = new LoadingValueReference<>();
                ReferenceEntry F = F(k2, i2, referenceEntry);
                F.f(loadingValueReference2);
                atomicReferenceArray.set(length, F);
                unlock();
                J();
                return loadingValueReference2;
            } catch (Throwable th) {
                unlock();
                J();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public ListenableFuture<V> C(K k2, int i2, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) {
            ListenableFuture<V> m2 = loadingValueReference.m(k2, cacheLoader);
            m2.a0(new c(this, k2, i2, loadingValueReference, m2), MoreExecutors.c());
            return m2;
        }

        /* access modifiers changed from: package-private */
        public V D(K k2, int i2, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            return t(k2, i2, loadingValueReference, loadingValueReference.m(k2, cacheLoader));
        }

        /* access modifiers changed from: package-private */
        public V E(K k2, int i2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            LoadingValueReference loadingValueReference;
            ValueReference valueReference;
            boolean z;
            V D;
            int e2;
            RemovalCause removalCause;
            K k3 = k2;
            int i3 = i2;
            lock();
            try {
                long a2 = this.s.i3.a();
                K(a2);
                int i4 = this.X - 1;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
                int length = i3 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    loadingValueReference = null;
                    if (referenceEntry2 == null) {
                        valueReference = null;
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.c() != i3 || key == null || !this.s.X2.d(k3, key)) {
                        referenceEntry2 = referenceEntry2.a();
                    } else {
                        ValueReference b2 = referenceEntry2.b();
                        if (b2.c()) {
                            z = false;
                            valueReference = b2;
                        } else {
                            V v = b2.get();
                            if (v == null) {
                                e2 = b2.e();
                                removalCause = RemovalCause.COLLECTED;
                            } else if (this.s.y(referenceEntry2, a2)) {
                                e2 = b2.e();
                                removalCause = RemovalCause.EXPIRED;
                            } else {
                                O(referenceEntry2, a2);
                                this.g3.b(1);
                                unlock();
                                J();
                                return v;
                            }
                            n(key, i2, v, e2, removalCause);
                            this.e3.remove(referenceEntry2);
                            this.f3.remove(referenceEntry2);
                            this.X = i4;
                            valueReference = b2;
                        }
                    }
                }
                z = true;
                if (z) {
                    loadingValueReference = new LoadingValueReference();
                    if (referenceEntry2 == null) {
                        referenceEntry2 = F(k3, i3, referenceEntry);
                        referenceEntry2.f(loadingValueReference);
                        atomicReferenceArray.set(length, referenceEntry2);
                    } else {
                        referenceEntry2.f(loadingValueReference);
                    }
                }
                if (!z) {
                    return j0(referenceEntry2, k3, valueReference);
                }
                try {
                    synchronized (referenceEntry2) {
                        D = D(k3, i3, loadingValueReference, cacheLoader);
                    }
                    this.g3.c(1);
                    return D;
                } catch (Throwable th) {
                    this.g3.c(1);
                    throw th;
                }
            } finally {
                unlock();
                J();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public ReferenceEntry<K, V> F(K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            return this.s.j3.g(this, Preconditions.E(k2), i2, referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public AtomicReferenceArray<ReferenceEntry<K, V>> H(int i2) {
            return new AtomicReferenceArray<>(i2);
        }

        /* access modifiers changed from: package-private */
        public void I() {
            if ((this.d3.incrementAndGet() & 63) == 0) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void J() {
            c0();
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void K(long j2) {
            b0(j2);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
            r1 = r12.b();
            r10 = r1.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
            if (r10 != null) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
            r7.Z++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
            if (r1.b() == false) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
            n(r15, r16, r10, r1.e(), com.google.common.cache.RemovalCause.COLLECTED);
            e0(r12, r15, r17, r8);
            r0 = r7.X;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
            e0(r12, r15, r17, r8);
            r0 = r7.X + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0088, code lost:
            r7.X = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0094, code lost:
            if (r18 == false) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            O(r12, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x009f, code lost:
            return r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r7.Z++;
            n(r15, r16, r10, r1.e(), com.google.common.cache.RemovalCause.REPLACED);
            e0(r12, r15, r17, r8);
            o(r12);
         */
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        @javax.annotation.CheckForNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V L(K r15, int r16, V r17, boolean r18) {
            /*
                r14 = this;
                r7 = r14
                r0 = r15
                r3 = r16
                r14.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r7.s     // Catch:{ all -> 0x001e }
                com.google.common.base.Ticker r1 = r1.i3     // Catch:{ all -> 0x001e }
                long r8 = r1.a()     // Catch:{ all -> 0x001e }
                r14.K(r8)     // Catch:{ all -> 0x001e }
                int r1 = r7.X     // Catch:{ all -> 0x001e }
                int r1 = r1 + 1
                int r2 = r7.X2     // Catch:{ all -> 0x001e }
                if (r1 <= r2) goto L_0x0021
                r14.p()     // Catch:{ all -> 0x001e }
                goto L_0x0021
            L_0x001e:
                r0 = move-exception
                goto L_0x00e4
            L_0x0021:
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r10 = r7.Y2     // Catch:{ all -> 0x001e }
                int r1 = r10.length()     // Catch:{ all -> 0x001e }
                int r1 = r1 + -1
                r11 = r3 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch:{ all -> 0x001e }
                com.google.common.cache.ReferenceEntry r1 = (com.google.common.cache.ReferenceEntry) r1     // Catch:{ all -> 0x001e }
                r12 = r1
            L_0x0032:
                r13 = 0
                if (r12 == 0) goto L_0x00c7
                java.lang.Object r2 = r12.getKey()     // Catch:{ all -> 0x001e }
                int r4 = r12.c()     // Catch:{ all -> 0x001e }
                if (r4 != r3) goto L_0x00c1
                if (r2 == 0) goto L_0x00c1
                com.google.common.cache.LocalCache<K, V> r4 = r7.s     // Catch:{ all -> 0x001e }
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.X2     // Catch:{ all -> 0x001e }
                boolean r2 = r4.d(r15, r2)     // Catch:{ all -> 0x001e }
                if (r2 == 0) goto L_0x00c1
                com.google.common.cache.LocalCache$ValueReference r1 = r12.b()     // Catch:{ all -> 0x001e }
                java.lang.Object r10 = r1.get()     // Catch:{ all -> 0x001e }
                if (r10 != 0) goto L_0x0094
                int r2 = r7.Z     // Catch:{ all -> 0x001e }
                int r2 = r2 + 1
                r7.Z = r2     // Catch:{ all -> 0x001e }
                boolean r2 = r1.b()     // Catch:{ all -> 0x001e }
                if (r2 == 0) goto L_0x007b
                int r5 = r1.e()     // Catch:{ all -> 0x001e }
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x001e }
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r10
                r1.n(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x001e }
                r1 = r14
                r2 = r12
                r3 = r15
                r4 = r17
                r5 = r8
                r1.e0(r2, r3, r4, r5)     // Catch:{ all -> 0x001e }
                int r0 = r7.X     // Catch:{ all -> 0x001e }
                goto L_0x0088
            L_0x007b:
                r1 = r14
                r2 = r12
                r3 = r15
                r4 = r17
                r5 = r8
                r1.e0(r2, r3, r4, r5)     // Catch:{ all -> 0x001e }
                int r0 = r7.X     // Catch:{ all -> 0x001e }
                int r0 = r0 + 1
            L_0x0088:
                r7.X = r0     // Catch:{ all -> 0x001e }
            L_0x008a:
                r14.o(r12)     // Catch:{ all -> 0x001e }
                r14.unlock()
                r14.J()
                return r13
            L_0x0094:
                if (r18 == 0) goto L_0x00a0
                r14.O(r12, r8)     // Catch:{ all -> 0x001e }
            L_0x0099:
                r14.unlock()
                r14.J()
                return r10
            L_0x00a0:
                int r2 = r7.Z     // Catch:{ all -> 0x001e }
                int r2 = r2 + 1
                r7.Z = r2     // Catch:{ all -> 0x001e }
                int r5 = r1.e()     // Catch:{ all -> 0x001e }
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x001e }
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r10
                r1.n(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x001e }
                r1 = r14
                r2 = r12
                r3 = r15
                r4 = r17
                r5 = r8
                r1.e0(r2, r3, r4, r5)     // Catch:{ all -> 0x001e }
                r14.o(r12)     // Catch:{ all -> 0x001e }
                goto L_0x0099
            L_0x00c1:
                com.google.common.cache.ReferenceEntry r12 = r12.a()     // Catch:{ all -> 0x001e }
                goto L_0x0032
            L_0x00c7:
                int r2 = r7.Z     // Catch:{ all -> 0x001e }
                int r2 = r2 + 1
                r7.Z = r2     // Catch:{ all -> 0x001e }
                com.google.common.cache.ReferenceEntry r12 = r14.F(r15, r3, r1)     // Catch:{ all -> 0x001e }
                r1 = r14
                r2 = r12
                r3 = r15
                r4 = r17
                r5 = r8
                r1.e0(r2, r3, r4, r5)     // Catch:{ all -> 0x001e }
                r10.set(r11, r12)     // Catch:{ all -> 0x001e }
                int r0 = r7.X     // Catch:{ all -> 0x001e }
                int r0 = r0 + 1
                r7.X = r0     // Catch:{ all -> 0x001e }
                goto L_0x008a
            L_0x00e4:
                r14.unlock()
                r14.J()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.L(java.lang.Object, int, java.lang.Object, boolean):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public boolean M(ReferenceEntry<K, V> referenceEntry, int i2) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.a()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.Z++;
                        atomicReferenceArray.set(length, Y(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i2, referenceEntry3.b().get(), referenceEntry3.b(), RemovalCause.COLLECTED));
                        this.X--;
                        return true;
                    }
                }
                unlock();
                J();
                return false;
            } finally {
                unlock();
                J();
            }
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public boolean N(K k2, int i2, ValueReference<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.c() != i2 || key == null || !this.s.X2.d(k2, key)) {
                        referenceEntry2 = referenceEntry2.a();
                    } else if (referenceEntry2.b() == valueReference) {
                        this.Z++;
                        atomicReferenceArray.set(length, Y(referenceEntry, referenceEntry2, key, i2, valueReference.get(), valueReference, RemovalCause.COLLECTED));
                        this.X--;
                        return true;
                    } else {
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            J();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    J();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    J();
                }
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void O(ReferenceEntry<K, V> referenceEntry, long j2) {
            if (this.s.M()) {
                referenceEntry.h(j2);
            }
            this.f3.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        public void P(ReferenceEntry<K, V> referenceEntry, long j2) {
            if (this.s.M()) {
                referenceEntry.h(j2);
            }
            this.c3.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void Q(ReferenceEntry<K, V> referenceEntry, int i2, long j2) {
            k();
            this.Y += (long) i2;
            if (this.s.M()) {
                referenceEntry.h(j2);
            }
            if (this.s.O()) {
                referenceEntry.k(j2);
            }
            this.f3.add(referenceEntry);
            this.e3.add(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        @CheckForNull
        public V R(K k2, int i2, CacheLoader<? super K, V> cacheLoader, boolean z) {
            LoadingValueReference A = A(k2, i2, z);
            if (A == null) {
                return null;
            }
            ListenableFuture<V> C = C(k2, i2, A, cacheLoader);
            if (C.isDone()) {
                try {
                    return Uninterruptibles.f(C);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V S(Object obj, int i2) {
            RemovalCause removalCause;
            lock();
            try {
                K(this.s.i3.a());
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.c() != i2 || key == null || !this.s.X2.d(obj, key)) {
                        referenceEntry2 = referenceEntry2.a();
                    } else {
                        ValueReference b2 = referenceEntry2.b();
                        V v = b2.get();
                        if (v != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (b2.b()) {
                            removalCause = RemovalCause.COLLECTED;
                        }
                        RemovalCause removalCause2 = removalCause;
                        this.Z++;
                        atomicReferenceArray.set(length, Y(referenceEntry, referenceEntry2, key, i2, v, b2, removalCause2));
                        this.X--;
                        unlock();
                        J();
                        return v;
                    }
                }
                unlock();
                J();
                return null;
            } catch (Throwable th) {
                unlock();
                J();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean T(Object obj, int i2, Object obj2) {
            RemovalCause removalCause;
            lock();
            try {
                K(this.s.i3.a());
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
                boolean z = true;
                int length = (atomicReferenceArray.length() - 1) & i2;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.c() != i2 || key == null || !this.s.X2.d(obj, key)) {
                        referenceEntry2 = referenceEntry2.a();
                    } else {
                        ValueReference b2 = referenceEntry2.b();
                        Object obj3 = b2.get();
                        if (this.s.Y2.d(obj2, obj3)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (obj3 == null && b2.b()) {
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.Z++;
                        atomicReferenceArray.set(length, Y(referenceEntry, referenceEntry2, key, i2, obj3, b2, removalCause));
                        this.X--;
                        if (removalCause != RemovalCause.EXPLICIT) {
                            z = false;
                        }
                        unlock();
                        J();
                        return z;
                    }
                }
                unlock();
                J();
                return false;
            } catch (Throwable th) {
                unlock();
                J();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void U(ReferenceEntry<K, V> referenceEntry) {
            n(referenceEntry.getKey(), referenceEntry.c(), referenceEntry.b().get(), referenceEntry.b().e(), RemovalCause.COLLECTED);
            this.e3.remove(referenceEntry);
            this.f3.remove(referenceEntry);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        @VisibleForTesting
        @GuardedBy("this")
        public boolean V(ReferenceEntry<K, V> referenceEntry, int i2, RemovalCause removalCause) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
            int length = (atomicReferenceArray.length() - 1) & i2;
            ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.a()) {
                if (referenceEntry3 == referenceEntry) {
                    this.Z++;
                    atomicReferenceArray.set(length, Y(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i2, referenceEntry3.b().get(), referenceEntry3.b(), removalCause));
                    this.X--;
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        @GuardedBy("this")
        public ReferenceEntry<K, V> W(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i2 = this.X;
            ReferenceEntry<K, V> a2 = referenceEntry2.a();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry<K, V> i3 = i(referenceEntry, a2);
                if (i3 != null) {
                    a2 = i3;
                } else {
                    U(referenceEntry);
                    i2--;
                }
                referenceEntry = referenceEntry.a();
            }
            this.X = i2;
            return a2;
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public boolean X(K k2, int i2, LoadingValueReference<K, V> loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
                int length = (atomicReferenceArray.length() - 1) & i2;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.c() != i2 || key == null || !this.s.X2.d(k2, key)) {
                        referenceEntry2 = referenceEntry2.a();
                    } else if (referenceEntry2.b() == loadingValueReference) {
                        if (loadingValueReference.b()) {
                            referenceEntry2.f(loadingValueReference.k());
                        } else {
                            atomicReferenceArray.set(length, W(referenceEntry, referenceEntry2));
                        }
                        return true;
                    }
                }
                unlock();
                J();
                return false;
            } finally {
                unlock();
                J();
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        @GuardedBy("this")
        public ReferenceEntry<K, V> Y(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, @CheckForNull K k2, int i2, V v, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            n(k2, i2, v, valueReference.e(), removalCause);
            this.e3.remove(referenceEntry2);
            this.f3.remove(referenceEntry2);
            if (!valueReference.c()) {
                return W(referenceEntry, referenceEntry2);
            }
            valueReference.d(null);
            return referenceEntry;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
            r15 = r12.b();
            r16 = r15.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
            if (r16 != null) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
            if (r15.b() == false) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
            r9.Z++;
            r10.set(r11, Y(r2, r12, r4, r19, r16, r15, com.google.common.cache.RemovalCause.COLLECTED));
            r9.X--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r9.Z++;
            n(r18, r19, r16, r15.e(), com.google.common.cache.RemovalCause.REPLACED);
            e0(r12, r18, r20, r7);
            o(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x009b, code lost:
            unlock();
            J();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a1, code lost:
            return r16;
         */
        @javax.annotation.CheckForNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V Z(K r18, int r19, V r20) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.s     // Catch:{ all -> 0x006d }
                com.google.common.base.Ticker r1 = r1.i3     // Catch:{ all -> 0x006d }
                long r7 = r1.a()     // Catch:{ all -> 0x006d }
                r9.K(r7)     // Catch:{ all -> 0x006d }
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r10 = r9.Y2     // Catch:{ all -> 0x006d }
                int r1 = r10.length()     // Catch:{ all -> 0x006d }
                int r1 = r1 + -1
                r11 = r0 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch:{ all -> 0x006d }
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch:{ all -> 0x006d }
                r12 = r2
            L_0x0024:
                r13 = 0
                if (r12 == 0) goto L_0x006f
                java.lang.Object r4 = r12.getKey()     // Catch:{ all -> 0x006d }
                int r1 = r12.c()     // Catch:{ all -> 0x006d }
                if (r1 != r0) goto L_0x00a2
                if (r4 == 0) goto L_0x00a2
                com.google.common.cache.LocalCache<K, V> r1 = r9.s     // Catch:{ all -> 0x006d }
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.X2     // Catch:{ all -> 0x006d }
                r14 = r18
                boolean r1 = r1.d(r14, r4)     // Catch:{ all -> 0x006d }
                if (r1 == 0) goto L_0x00a4
                com.google.common.cache.LocalCache$ValueReference r15 = r12.b()     // Catch:{ all -> 0x006d }
                java.lang.Object r16 = r15.get()     // Catch:{ all -> 0x006d }
                if (r16 != 0) goto L_0x0076
                boolean r1 = r15.b()     // Catch:{ all -> 0x006d }
                if (r1 == 0) goto L_0x006f
                int r1 = r9.Z     // Catch:{ all -> 0x006d }
                int r1 = r1 + 1
                r9.Z = r1     // Catch:{ all -> 0x006d }
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x006d }
                r1 = r17
                r3 = r12
                r5 = r19
                r6 = r16
                r7 = r15
                com.google.common.cache.ReferenceEntry r0 = r1.Y(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x006d }
                int r1 = r9.X     // Catch:{ all -> 0x006d }
                int r1 = r1 + -1
                r10.set(r11, r0)     // Catch:{ all -> 0x006d }
                r9.X = r1     // Catch:{ all -> 0x006d }
                goto L_0x006f
            L_0x006d:
                r0 = move-exception
                goto L_0x00aa
            L_0x006f:
                r17.unlock()
                r17.J()
                return r13
            L_0x0076:
                int r1 = r9.Z     // Catch:{ all -> 0x006d }
                int r1 = r1 + 1
                r9.Z = r1     // Catch:{ all -> 0x006d }
                int r5 = r15.e()     // Catch:{ all -> 0x006d }
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x006d }
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r16
                r1.n(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x006d }
                r1 = r17
                r2 = r12
                r3 = r18
                r4 = r20
                r5 = r7
                r1.e0(r2, r3, r4, r5)     // Catch:{ all -> 0x006d }
                r9.o(r12)     // Catch:{ all -> 0x006d }
                r17.unlock()
                r17.J()
                return r16
            L_0x00a2:
                r14 = r18
            L_0x00a4:
                com.google.common.cache.ReferenceEntry r12 = r12.a()     // Catch:{ all -> 0x006d }
                goto L_0x0024
            L_0x00aa:
                r17.unlock()
                r17.J()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.Z(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
            r16 = r13.b();
            r6 = r16.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
            if (r6 != null) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
            if (r16.b() == false) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
            r9.Z++;
            r10.set(r12, Y(r2, r13, r4, r19, r6, r16, com.google.common.cache.RemovalCause.COLLECTED));
            r9.X--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
            if (r9.s.Y2.d(r20, r6) == false) goto L_0x00aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x007f, code lost:
            r9.Z++;
            n(r18, r19, r6, r16.e(), com.google.common.cache.RemovalCause.REPLACED);
            e0(r13, r18, r21, r7);
            o(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a3, code lost:
            unlock();
            J();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a9, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            O(r13, r7);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a0(K r18, int r19, V r20, V r21) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r9.s     // Catch:{ all -> 0x006a }
                com.google.common.base.Ticker r1 = r1.i3     // Catch:{ all -> 0x006a }
                long r7 = r1.a()     // Catch:{ all -> 0x006a }
                r9.K(r7)     // Catch:{ all -> 0x006a }
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r10 = r9.Y2     // Catch:{ all -> 0x006a }
                int r1 = r10.length()     // Catch:{ all -> 0x006a }
                r11 = 1
                int r1 = r1 - r11
                r12 = r0 & r1
                java.lang.Object r1 = r10.get(r12)     // Catch:{ all -> 0x006a }
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch:{ all -> 0x006a }
                r13 = r2
            L_0x0024:
                r14 = 0
                if (r13 == 0) goto L_0x006c
                java.lang.Object r4 = r13.getKey()     // Catch:{ all -> 0x006a }
                int r1 = r13.c()     // Catch:{ all -> 0x006a }
                if (r1 != r0) goto L_0x00b1
                if (r4 == 0) goto L_0x00b1
                com.google.common.cache.LocalCache<K, V> r1 = r9.s     // Catch:{ all -> 0x006a }
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.X2     // Catch:{ all -> 0x006a }
                r15 = r18
                boolean r1 = r1.d(r15, r4)     // Catch:{ all -> 0x006a }
                if (r1 == 0) goto L_0x00ae
                com.google.common.cache.LocalCache$ValueReference r16 = r13.b()     // Catch:{ all -> 0x006a }
                java.lang.Object r6 = r16.get()     // Catch:{ all -> 0x006a }
                if (r6 != 0) goto L_0x0073
                boolean r1 = r16.b()     // Catch:{ all -> 0x006a }
                if (r1 == 0) goto L_0x006c
                int r1 = r9.Z     // Catch:{ all -> 0x006a }
                int r1 = r1 + r11
                r9.Z = r1     // Catch:{ all -> 0x006a }
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x006a }
                r1 = r17
                r3 = r13
                r5 = r19
                r7 = r16
                com.google.common.cache.ReferenceEntry r0 = r1.Y(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x006a }
                int r1 = r9.X     // Catch:{ all -> 0x006a }
                int r1 = r1 - r11
                r10.set(r12, r0)     // Catch:{ all -> 0x006a }
                r9.X = r1     // Catch:{ all -> 0x006a }
                goto L_0x006c
            L_0x006a:
                r0 = move-exception
                goto L_0x00ba
            L_0x006c:
                r17.unlock()
                r17.J()
                return r14
            L_0x0073:
                com.google.common.cache.LocalCache<K, V> r1 = r9.s     // Catch:{ all -> 0x006a }
                com.google.common.base.Equivalence<java.lang.Object> r1 = r1.Y2     // Catch:{ all -> 0x006a }
                r3 = r20
                boolean r1 = r1.d(r3, r6)     // Catch:{ all -> 0x006a }
                if (r1 == 0) goto L_0x00aa
                int r1 = r9.Z     // Catch:{ all -> 0x006a }
                int r1 = r1 + r11
                r9.Z = r1     // Catch:{ all -> 0x006a }
                int r5 = r16.e()     // Catch:{ all -> 0x006a }
                com.google.common.cache.RemovalCause r10 = com.google.common.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x006a }
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r6
                r6 = r10
                r1.n(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x006a }
                r1 = r17
                r2 = r13
                r3 = r18
                r4 = r21
                r5 = r7
                r1.e0(r2, r3, r4, r5)     // Catch:{ all -> 0x006a }
                r9.o(r13)     // Catch:{ all -> 0x006a }
                r17.unlock()
                r17.J()
                return r11
            L_0x00aa:
                r9.O(r13, r7)     // Catch:{ all -> 0x006a }
                goto L_0x006c
            L_0x00ae:
                r3 = r20
                goto L_0x00b4
            L_0x00b1:
                r15 = r18
                goto L_0x00ae
            L_0x00b4:
                com.google.common.cache.ReferenceEntry r13 = r13.a()     // Catch:{ all -> 0x006a }
                goto L_0x0024
            L_0x00ba:
                r17.unlock()
                r17.J()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.a0(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        /* access modifiers changed from: package-private */
        public void b() {
            b0(this.s.i3.a());
            c0();
        }

        /* access modifiers changed from: package-private */
        public void b0(long j2) {
            if (tryLock()) {
                try {
                    l();
                    q(j2);
                    this.d3.set(0);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            RemovalCause removalCause;
            if (this.X != 0) {
                lock();
                try {
                    K(this.s.i3.a());
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        for (ReferenceEntry referenceEntry = atomicReferenceArray.get(i2); referenceEntry != null; referenceEntry = referenceEntry.a()) {
                            if (referenceEntry.b().b()) {
                                Object key = referenceEntry.getKey();
                                Object obj = referenceEntry.b().get();
                                if (key != null) {
                                    if (obj != null) {
                                        removalCause = RemovalCause.EXPLICIT;
                                        n(key, referenceEntry.c(), obj, referenceEntry.b().e(), removalCause);
                                    }
                                }
                                removalCause = RemovalCause.COLLECTED;
                                n(key, referenceEntry.c(), obj, referenceEntry.b().e(), removalCause);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                        atomicReferenceArray.set(i3, (Object) null);
                    }
                    e();
                    this.e3.clear();
                    this.f3.clear();
                    this.d3.set(0);
                    this.Z++;
                    this.X = 0;
                    unlock();
                    J();
                } catch (Throwable th) {
                    unlock();
                    J();
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c0() {
            if (!isHeldByCurrentThread()) {
                this.s.I();
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            do {
            } while (this.a3.poll() != null);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
            r4 = R(r5, r6, r10, true);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V d0(com.google.common.cache.ReferenceEntry<K, V> r4, K r5, int r6, V r7, long r8, com.google.common.cache.CacheLoader<? super K, V> r10) {
            /*
                r3 = this;
                com.google.common.cache.LocalCache<K, V> r0 = r3.s
                boolean r0 = r0.Q()
                if (r0 == 0) goto L_0x0027
                long r0 = r4.g()
                long r8 = r8 - r0
                com.google.common.cache.LocalCache<K, V> r0 = r3.s
                long r0 = r0.f3
                int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r2 <= 0) goto L_0x0027
                com.google.common.cache.LocalCache$ValueReference r4 = r4.b()
                boolean r4 = r4.c()
                if (r4 != 0) goto L_0x0027
                r4 = 1
                java.lang.Object r4 = r3.R(r5, r6, r10, r4)
                if (r4 == 0) goto L_0x0027
                return r4
            L_0x0027:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.d0(com.google.common.cache.ReferenceEntry, java.lang.Object, int, java.lang.Object, long, com.google.common.cache.CacheLoader):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (this.s.X()) {
                d();
            }
            if (this.s.Y()) {
                f();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void e0(ReferenceEntry<K, V> referenceEntry, K k2, V v, long j2) {
            ValueReference<K, V> b2 = referenceEntry.b();
            int a2 = this.s.c3.a(k2, v);
            Preconditions.h0(a2 >= 0, "Weights must be non-negative");
            referenceEntry.f(this.s.a3.c(this, referenceEntry, v, a2));
            Q(referenceEntry, a2, j2);
            b2.d(v);
        }

        /* access modifiers changed from: package-private */
        public void f() {
            do {
            } while (this.b3.poll() != null);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
            r1 = r14.b();
            r4 = r1.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
            if (r18 == r1) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
            if (r4 != null) goto L_0x0061;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
            if (r1 == com.google.common.cache.LocalCache.v3) goto L_0x0061;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
            n(r16, r17, r19, 0, com.google.common.cache.RemovalCause.REPLACED);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
            unlock();
            J();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r7.Z++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
            if (r18.b() == false) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0081, code lost:
            if (r4 != null) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
            r1 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
            r1 = com.google.common.cache.RemovalCause.REPLACED;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
            n(r16, r17, r4, r18.e(), r1);
            r11 = r11 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
            e0(r14, r16, r19, r8);
            r7.X = r11;
         */
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean f0(K r16, int r17, com.google.common.cache.LocalCache.LoadingValueReference<K, V> r18, V r19) {
            /*
                r15 = this;
                r7 = r15
                r0 = r16
                r3 = r17
                r15.lock()
                com.google.common.cache.LocalCache<K, V> r1 = r7.s     // Catch:{ all -> 0x0023 }
                com.google.common.base.Ticker r1 = r1.i3     // Catch:{ all -> 0x0023 }
                long r8 = r1.a()     // Catch:{ all -> 0x0023 }
                r15.K(r8)     // Catch:{ all -> 0x0023 }
                int r1 = r7.X     // Catch:{ all -> 0x0023 }
                r10 = 1
                int r1 = r1 + r10
                int r2 = r7.X2     // Catch:{ all -> 0x0023 }
                if (r1 <= r2) goto L_0x0021
                r15.p()     // Catch:{ all -> 0x0023 }
                int r1 = r7.X     // Catch:{ all -> 0x0023 }
                int r1 = r1 + r10
            L_0x0021:
                r11 = r1
                goto L_0x0026
            L_0x0023:
                r0 = move-exception
                goto L_0x00ce
            L_0x0026:
                java.util.concurrent.atomic.AtomicReferenceArray<com.google.common.cache.ReferenceEntry<K, V>> r12 = r7.Y2     // Catch:{ all -> 0x0023 }
                int r1 = r12.length()     // Catch:{ all -> 0x0023 }
                int r1 = r1 - r10
                r13 = r3 & r1
                java.lang.Object r1 = r12.get(r13)     // Catch:{ all -> 0x0023 }
                com.google.common.cache.ReferenceEntry r1 = (com.google.common.cache.ReferenceEntry) r1     // Catch:{ all -> 0x0023 }
                r14 = r1
            L_0x0036:
                if (r14 == 0) goto L_0x00b5
                java.lang.Object r2 = r14.getKey()     // Catch:{ all -> 0x0023 }
                int r4 = r14.c()     // Catch:{ all -> 0x0023 }
                if (r4 != r3) goto L_0x00ae
                if (r2 == 0) goto L_0x00ae
                com.google.common.cache.LocalCache<K, V> r4 = r7.s     // Catch:{ all -> 0x0023 }
                com.google.common.base.Equivalence<java.lang.Object> r4 = r4.X2     // Catch:{ all -> 0x0023 }
                boolean r2 = r4.d(r0, r2)     // Catch:{ all -> 0x0023 }
                if (r2 == 0) goto L_0x00ae
                com.google.common.cache.LocalCache$ValueReference r1 = r14.b()     // Catch:{ all -> 0x0023 }
                java.lang.Object r4 = r1.get()     // Catch:{ all -> 0x0023 }
                r2 = r18
                if (r2 == r1) goto L_0x0076
                if (r4 != 0) goto L_0x0061
                com.google.common.cache.LocalCache$ValueReference<java.lang.Object, java.lang.Object> r5 = com.google.common.cache.LocalCache.v3     // Catch:{ all -> 0x0023 }
                if (r1 == r5) goto L_0x0061
                goto L_0x0076
            L_0x0061:
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x0023 }
                r5 = 0
                r1 = r15
                r2 = r16
                r3 = r17
                r4 = r19
                r1.n(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0023 }
                r15.unlock()
                r15.J()
                r0 = 0
                return r0
            L_0x0076:
                int r1 = r7.Z     // Catch:{ all -> 0x0023 }
                int r1 = r1 + r10
                r7.Z = r1     // Catch:{ all -> 0x0023 }
                boolean r1 = r18.b()     // Catch:{ all -> 0x0023 }
                if (r1 == 0) goto L_0x0098
                if (r4 != 0) goto L_0x0087
                com.google.common.cache.RemovalCause r1 = com.google.common.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x0023 }
            L_0x0085:
                r6 = r1
                goto L_0x008a
            L_0x0087:
                com.google.common.cache.RemovalCause r1 = com.google.common.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x0023 }
                goto L_0x0085
            L_0x008a:
                int r5 = r18.e()     // Catch:{ all -> 0x0023 }
                r1 = r15
                r2 = r16
                r3 = r17
                r1.n(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0023 }
                int r11 = r11 + -1
            L_0x0098:
                r1 = r15
                r2 = r14
                r3 = r16
                r4 = r19
                r5 = r8
                r1.e0(r2, r3, r4, r5)     // Catch:{ all -> 0x0023 }
                r7.X = r11     // Catch:{ all -> 0x0023 }
            L_0x00a4:
                r15.o(r14)     // Catch:{ all -> 0x0023 }
                r15.unlock()
                r15.J()
                return r10
            L_0x00ae:
                r2 = r18
                com.google.common.cache.ReferenceEntry r14 = r14.a()     // Catch:{ all -> 0x0023 }
                goto L_0x0036
            L_0x00b5:
                int r2 = r7.Z     // Catch:{ all -> 0x0023 }
                int r2 = r2 + r10
                r7.Z = r2     // Catch:{ all -> 0x0023 }
                com.google.common.cache.ReferenceEntry r14 = r15.F(r0, r3, r1)     // Catch:{ all -> 0x0023 }
                r1 = r15
                r2 = r14
                r3 = r16
                r4 = r19
                r5 = r8
                r1.e0(r2, r3, r4, r5)     // Catch:{ all -> 0x0023 }
                r12.set(r13, r14)     // Catch:{ all -> 0x0023 }
                r7.X = r11     // Catch:{ all -> 0x0023 }
                goto L_0x00a4
            L_0x00ce:
                r15.unlock()
                r15.J()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.f0(java.lang.Object, int, com.google.common.cache.LocalCache$LoadingValueReference, java.lang.Object):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean g(Object obj, int i2) {
            try {
                boolean z = false;
                if (this.X != 0) {
                    ReferenceEntry w = w(obj, i2, this.s.i3.a());
                    if (w == null) {
                        return false;
                    }
                    if (w.b().get() != null) {
                        z = true;
                    }
                    I();
                    return z;
                }
                I();
                return false;
            } finally {
                I();
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public boolean h(Object obj) {
            try {
                if (this.X != 0) {
                    long a2 = this.s.i3.a();
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
                    int length = atomicReferenceArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        for (ReferenceEntry referenceEntry = atomicReferenceArray.get(i2); referenceEntry != null; referenceEntry = referenceEntry.a()) {
                            Object x = x(referenceEntry, a2);
                            if (x != null) {
                                if (this.s.Y2.d(obj, x)) {
                                    I();
                                    return true;
                                }
                            }
                        }
                    }
                }
                I();
                return false;
            } catch (Throwable th) {
                I();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public void h0() {
            if (tryLock()) {
                try {
                    l();
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        @GuardedBy("this")
        public ReferenceEntry<K, V> i(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            K key = referenceEntry.getKey();
            if (key == null) {
                return null;
            }
            ValueReference<K, V> b2 = referenceEntry.b();
            V v = b2.get();
            if (v == null && b2.b()) {
                return null;
            }
            ReferenceEntry<K, V> c2 = this.s.j3.c(this, referenceEntry, referenceEntry2, key);
            c2.f(b2.g(this.b3, v, c2));
            return c2;
        }

        /* access modifiers changed from: package-private */
        public void i0(long j2) {
            if (tryLock()) {
                try {
                    q(j2);
                } finally {
                    unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void j() {
            int i2 = 0;
            do {
                Reference<? extends K> poll = this.a3.poll();
                if (poll != null) {
                    this.s.J((ReferenceEntry) poll);
                    i2++;
                } else {
                    return;
                }
            } while (i2 != 16);
        }

        /* access modifiers changed from: package-private */
        public V j0(ReferenceEntry<K, V> referenceEntry, K k2, ValueReference<K, V> valueReference) throws ExecutionException {
            if (valueReference.c()) {
                Preconditions.x0(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", k2);
                try {
                    V f2 = valueReference.f();
                    if (f2 != null) {
                        P(referenceEntry, this.s.i3.a());
                        return f2;
                    }
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + k2 + ".");
                } finally {
                    this.g3.c(1);
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void k() {
            while (true) {
                ReferenceEntry poll = this.c3.poll();
                if (poll == null) {
                    return;
                }
                if (this.f3.contains(poll)) {
                    this.f3.add(poll);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void l() {
            if (this.s.X()) {
                j();
            }
            if (this.s.Y()) {
                m();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void m() {
            int i2 = 0;
            do {
                Reference<? extends V> poll = this.b3.poll();
                if (poll != null) {
                    this.s.K((ValueReference) poll);
                    i2++;
                } else {
                    return;
                }
            } while (i2 != 16);
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void n(@CheckForNull K k2, int i2, @CheckForNull V v, int i3, RemovalCause removalCause) {
            this.Y -= (long) i3;
            if (removalCause.b()) {
                this.g3.a();
            }
            if (this.s.g3 != LocalCache.w3) {
                this.s.g3.offer(RemovalNotification.a(k2, v, removalCause));
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void o(ReferenceEntry<K, V> referenceEntry) {
            if (this.s.i()) {
                k();
                if (((long) referenceEntry.b().e()) <= this.Z2 || V(referenceEntry, referenceEntry.c(), RemovalCause.SIZE)) {
                    while (this.Y > this.Z2) {
                        ReferenceEntry y = y();
                        if (!V(y, y.c(), RemovalCause.SIZE)) {
                            throw new AssertionError();
                        }
                    }
                    return;
                }
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void p() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i2 = this.X;
                AtomicReferenceArray<ReferenceEntry<K, V>> H = H(length << 1);
                this.X2 = (H.length() * 3) / 4;
                int length2 = H.length() - 1;
                for (int i3 = 0; i3 < length; i3++) {
                    ReferenceEntry referenceEntry = atomicReferenceArray.get(i3);
                    if (referenceEntry != null) {
                        ReferenceEntry a2 = referenceEntry.a();
                        int c2 = referenceEntry.c() & length2;
                        if (a2 == null) {
                            H.set(c2, referenceEntry);
                        } else {
                            ReferenceEntry referenceEntry2 = referenceEntry;
                            while (a2 != null) {
                                int c4 = a2.c() & length2;
                                if (c4 != c2) {
                                    referenceEntry2 = a2;
                                    c2 = c4;
                                }
                                a2 = a2.a();
                            }
                            H.set(c2, referenceEntry2);
                            while (referenceEntry != referenceEntry2) {
                                int c5 = referenceEntry.c() & length2;
                                ReferenceEntry i4 = i(referenceEntry, H.get(c5));
                                if (i4 != null) {
                                    H.set(c5, i4);
                                } else {
                                    U(referenceEntry);
                                    i2--;
                                }
                                referenceEntry = referenceEntry.a();
                            }
                        }
                    }
                }
                this.Y2 = H;
                this.X = i2;
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public void q(long j2) {
            ReferenceEntry peek;
            ReferenceEntry peek2;
            k();
            do {
                peek = this.e3.peek();
                if (peek == null || !this.s.y(peek, j2)) {
                    do {
                        peek2 = this.f3.peek();
                        if (peek2 == null || !this.s.y(peek2, j2)) {
                            return;
                        }
                    } while (V(peek2, peek2.c(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (V(peek, peek.c(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V r(Object obj, int i2) {
            try {
                if (this.X != 0) {
                    long a2 = this.s.i3.a();
                    ReferenceEntry w = w(obj, i2, a2);
                    if (w == null) {
                        return null;
                    }
                    Object obj2 = w.b().get();
                    if (obj2 != null) {
                        P(w, a2);
                        V d0 = d0(w, w.getKey(), i2, obj2, a2, this.s.l3);
                        I();
                        return d0;
                    }
                    h0();
                }
                I();
                return null;
            } finally {
                I();
            }
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public V s(K k2, int i2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
            ReferenceEntry u;
            Preconditions.E(k2);
            Preconditions.E(cacheLoader);
            try {
                if (!(this.X == 0 || (u = u(k2, i2)) == null)) {
                    long a2 = this.s.i3.a();
                    Object x = x(u, a2);
                    if (x != null) {
                        P(u, a2);
                        this.g3.b(1);
                        V d0 = d0(u, k2, i2, x, a2, cacheLoader);
                        I();
                        return d0;
                    }
                    ValueReference b2 = u.b();
                    if (b2.c()) {
                        V j0 = j0(u, k2, b2);
                        I();
                        return j0;
                    }
                }
                V E = E(k2, i2, cacheLoader);
                I();
                return E;
            } catch (ExecutionException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof Error) {
                    throw new ExecutionError((Error) cause);
                } else if (cause instanceof RuntimeException) {
                    throw new UncheckedExecutionException(cause);
                } else {
                    throw e2;
                }
            } catch (Throwable th) {
                I();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
        @com.google.errorprone.annotations.CanIgnoreReturnValue
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V t(K r4, int r5, com.google.common.cache.LocalCache.LoadingValueReference<K, V> r6, com.google.common.util.concurrent.ListenableFuture<V> r7) throws java.util.concurrent.ExecutionException {
            /*
                r3 = this;
                java.lang.Object r7 = com.google.common.util.concurrent.Uninterruptibles.f(r7)     // Catch:{ all -> 0x0031 }
                if (r7 == 0) goto L_0x0015
                com.google.common.cache.AbstractCache$StatsCounter r0 = r3.g3     // Catch:{ all -> 0x0013 }
                long r1 = r6.i()     // Catch:{ all -> 0x0013 }
                r0.e(r1)     // Catch:{ all -> 0x0013 }
                r3.f0(r4, r5, r6, r7)     // Catch:{ all -> 0x0013 }
                return r7
            L_0x0013:
                r0 = move-exception
                goto L_0x0033
            L_0x0015:
                com.google.common.cache.CacheLoader$InvalidCacheLoadException r0 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException     // Catch:{ all -> 0x0013 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0013 }
                r1.<init>()     // Catch:{ all -> 0x0013 }
                java.lang.String r2 = "CacheLoader returned null for key "
                r1.append(r2)     // Catch:{ all -> 0x0013 }
                r1.append(r4)     // Catch:{ all -> 0x0013 }
                java.lang.String r2 = "."
                r1.append(r2)     // Catch:{ all -> 0x0013 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0013 }
                r0.<init>(r1)     // Catch:{ all -> 0x0013 }
                throw r0     // Catch:{ all -> 0x0013 }
            L_0x0031:
                r0 = move-exception
                r7 = 0
            L_0x0033:
                if (r7 != 0) goto L_0x0041
                com.google.common.cache.AbstractCache$StatsCounter r7 = r3.g3
                long r1 = r6.i()
                r7.d(r1)
                r3.X(r4, r5, r6)
            L_0x0041:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.t(java.lang.Object, int, com.google.common.cache.LocalCache$LoadingValueReference, com.google.common.util.concurrent.ListenableFuture):java.lang.Object");
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public ReferenceEntry<K, V> u(Object obj, int i2) {
            for (ReferenceEntry<K, V> v = v(i2); v != null; v = v.a()) {
                if (v.c() == i2) {
                    K key = v.getKey();
                    if (key == null) {
                        h0();
                    } else if (this.s.X2.d(obj, key)) {
                        return v;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public ReferenceEntry<K, V> v(int i2) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.Y2;
            return atomicReferenceArray.get(i2 & (atomicReferenceArray.length() - 1));
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public ReferenceEntry<K, V> w(Object obj, int i2, long j2) {
            ReferenceEntry<K, V> u = u(obj, i2);
            if (u == null) {
                return null;
            }
            if (!this.s.y(u, j2)) {
                return u;
            }
            i0(j2);
            return null;
        }

        /* access modifiers changed from: package-private */
        public V x(ReferenceEntry<K, V> referenceEntry, long j2) {
            if (referenceEntry.getKey() == null) {
                h0();
                return null;
            }
            V v = referenceEntry.b().get();
            if (v == null) {
                h0();
                return null;
            } else if (!this.s.y(referenceEntry, j2)) {
                return v;
            } else {
                i0(j2);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("this")
        public ReferenceEntry<K, V> y() {
            for (ReferenceEntry<K, V> next : this.f3) {
                if (next.b().e() > 0) {
                    return next;
                }
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void z(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.X2 = (atomicReferenceArray.length() * 3) / 4;
            if (!this.s.g()) {
                int i2 = this.X2;
                if (((long) i2) == this.Z2) {
                    this.X2 = i2 + 1;
                }
            }
            this.Y2 = atomicReferenceArray;
        }
    }

    static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> s;

        SoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.s = referenceEntry;
        }

        public ReferenceEntry<K, V> a() {
            return this.s;
        }

        public boolean b() {
            return true;
        }

        public boolean c() {
            return false;
        }

        public void d(V v) {
        }

        public int e() {
            return 1;
        }

        public V f() {
            return get();
        }

        public ValueReference<K, V> g(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new SoftValueReference(referenceQueue, v, referenceEntry);
        }
    }

    enum Strength {
        STRONG {
            /* access modifiers changed from: package-private */
            public Equivalence<Object> b() {
                return Equivalence.c();
            }

            /* access modifiers changed from: package-private */
            public <K, V> ValueReference<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i2) {
                return i2 == 1 ? new StrongValueReference(v) : new WeightedStrongValueReference(v, i2);
            }
        },
        SOFT {
            /* access modifiers changed from: package-private */
            public Equivalence<Object> b() {
                return Equivalence.g();
            }

            /* access modifiers changed from: package-private */
            public <K, V> ValueReference<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i2) {
                return i2 == 1 ? new SoftValueReference(segment.b3, v, referenceEntry) : new WeightedSoftValueReference(segment.b3, v, referenceEntry, i2);
            }
        },
        WEAK {
            /* access modifiers changed from: package-private */
            public Equivalence<Object> b() {
                return Equivalence.g();
            }

            /* access modifiers changed from: package-private */
            public <K, V> ValueReference<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i2) {
                return i2 == 1 ? new WeakValueReference(segment.b3, v, referenceEntry) : new WeightedWeakValueReference(segment.b3, v, referenceEntry, i2);
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Equivalence<Object> b();

        /* access modifiers changed from: package-private */
        public abstract <K, V> ValueReference<K, V> c(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v, int i2);
    }

    static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
        volatile long X2 = Long.MAX_VALUE;
        @Weak
        ReferenceEntry<K, V> Y2 = LocalCache.F();
        @Weak
        ReferenceEntry<K, V> Z2 = LocalCache.F();

        StrongAccessEntry(K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k2, i2, referenceEntry);
        }

        public ReferenceEntry<K, V> e() {
            return this.Z2;
        }

        public void h(long j2) {
            this.X2 = j2;
        }

        public long j() {
            return this.X2;
        }

        public ReferenceEntry<K, V> l() {
            return this.Y2;
        }

        public void m(ReferenceEntry<K, V> referenceEntry) {
            this.Y2 = referenceEntry;
        }

        public void p(ReferenceEntry<K, V> referenceEntry) {
            this.Z2 = referenceEntry;
        }
    }

    static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long X2 = Long.MAX_VALUE;
        @Weak
        ReferenceEntry<K, V> Y2 = LocalCache.F();
        @Weak
        ReferenceEntry<K, V> Z2 = LocalCache.F();
        volatile long a3 = Long.MAX_VALUE;
        @Weak
        ReferenceEntry<K, V> b3 = LocalCache.F();
        @Weak
        ReferenceEntry<K, V> c3 = LocalCache.F();

        StrongAccessWriteEntry(K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k2, i2, referenceEntry);
        }

        public ReferenceEntry<K, V> e() {
            return this.Z2;
        }

        public long g() {
            return this.a3;
        }

        public void h(long j2) {
            this.X2 = j2;
        }

        public ReferenceEntry<K, V> i() {
            return this.b3;
        }

        public long j() {
            return this.X2;
        }

        public void k(long j2) {
            this.a3 = j2;
        }

        public ReferenceEntry<K, V> l() {
            return this.Y2;
        }

        public void m(ReferenceEntry<K, V> referenceEntry) {
            this.Y2 = referenceEntry;
        }

        public void n(ReferenceEntry<K, V> referenceEntry) {
            this.b3 = referenceEntry;
        }

        public void o(ReferenceEntry<K, V> referenceEntry) {
            this.c3 = referenceEntry;
        }

        public void p(ReferenceEntry<K, V> referenceEntry) {
            this.Z2 = referenceEntry;
        }

        public ReferenceEntry<K, V> q() {
            return this.c3;
        }
    }

    static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
        final int X;
        @CheckForNull
        final ReferenceEntry<K, V> Y;
        volatile ValueReference<K, V> Z = LocalCache.U();
        final K s;

        StrongEntry(K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            this.s = k2;
            this.X = i2;
            this.Y = referenceEntry;
        }

        public ReferenceEntry<K, V> a() {
            return this.Y;
        }

        public ValueReference<K, V> b() {
            return this.Z;
        }

        public int c() {
            return this.X;
        }

        public void f(ValueReference<K, V> valueReference) {
            this.Z = valueReference;
        }

        public K getKey() {
            return this.s;
        }
    }

    static class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V s;

        StrongValueReference(V v) {
            this.s = v;
        }

        public ReferenceEntry<K, V> a() {
            return null;
        }

        public boolean b() {
            return true;
        }

        public boolean c() {
            return false;
        }

        public void d(V v) {
        }

        public int e() {
            return 1;
        }

        public V f() {
            return get();
        }

        public ValueReference<K, V> g(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public V get() {
            return this.s;
        }
    }

    static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
        volatile long X2 = Long.MAX_VALUE;
        @Weak
        ReferenceEntry<K, V> Y2 = LocalCache.F();
        @Weak
        ReferenceEntry<K, V> Z2 = LocalCache.F();

        StrongWriteEntry(K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k2, i2, referenceEntry);
        }

        public long g() {
            return this.X2;
        }

        public ReferenceEntry<K, V> i() {
            return this.Y2;
        }

        public void k(long j2) {
            this.X2 = j2;
        }

        public void n(ReferenceEntry<K, V> referenceEntry) {
            this.Y2 = referenceEntry;
        }

        public void o(ReferenceEntry<K, V> referenceEntry) {
            this.Z2 = referenceEntry;
        }

        public ReferenceEntry<K, V> q() {
            return this.Z2;
        }
    }

    final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        ValueIterator(LocalCache localCache) {
            super();
        }

        public V next() {
            return c().getValue();
        }
    }

    interface ValueReference<K, V> {
        @CheckForNull
        ReferenceEntry<K, V> a();

        boolean b();

        boolean c();

        void d(@CheckForNull V v);

        int e();

        V f() throws ExecutionException;

        ValueReference<K, V> g(ReferenceQueue<V> referenceQueue, @CheckForNull V v, ReferenceEntry<K, V> referenceEntry);

        @CheckForNull
        V get();
    }

    final class Values extends AbstractCollection<V> {
        Values() {
        }

        public void clear() {
            LocalCache.this.clear();
        }

        public boolean contains(Object obj) {
            return LocalCache.this.containsValue(obj);
        }

        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        public Iterator<V> iterator() {
            return new ValueIterator(LocalCache.this);
        }

        public int size() {
            return LocalCache.this.size();
        }

        public Object[] toArray() {
            return LocalCache.T(this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return LocalCache.T(this).toArray(eArr);
        }
    }

    static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
        @Weak
        ReferenceEntry<K, V> X2 = LocalCache.F();
        @Weak
        ReferenceEntry<K, V> Y2 = LocalCache.F();
        volatile long Z = Long.MAX_VALUE;

        WeakAccessEntry(ReferenceQueue<K> referenceQueue, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k2, i2, referenceEntry);
        }

        public ReferenceEntry<K, V> e() {
            return this.Y2;
        }

        public void h(long j2) {
            this.Z = j2;
        }

        public long j() {
            return this.Z;
        }

        public ReferenceEntry<K, V> l() {
            return this.X2;
        }

        public void m(ReferenceEntry<K, V> referenceEntry) {
            this.X2 = referenceEntry;
        }

        public void p(ReferenceEntry<K, V> referenceEntry) {
            this.Y2 = referenceEntry;
        }
    }

    static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
        @Weak
        ReferenceEntry<K, V> X2 = LocalCache.F();
        @Weak
        ReferenceEntry<K, V> Y2 = LocalCache.F();
        volatile long Z = Long.MAX_VALUE;
        volatile long Z2 = Long.MAX_VALUE;
        @Weak
        ReferenceEntry<K, V> a3 = LocalCache.F();
        @Weak
        ReferenceEntry<K, V> b3 = LocalCache.F();

        WeakAccessWriteEntry(ReferenceQueue<K> referenceQueue, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k2, i2, referenceEntry);
        }

        public ReferenceEntry<K, V> e() {
            return this.Y2;
        }

        public long g() {
            return this.Z2;
        }

        public void h(long j2) {
            this.Z = j2;
        }

        public ReferenceEntry<K, V> i() {
            return this.a3;
        }

        public long j() {
            return this.Z;
        }

        public void k(long j2) {
            this.Z2 = j2;
        }

        public ReferenceEntry<K, V> l() {
            return this.X2;
        }

        public void m(ReferenceEntry<K, V> referenceEntry) {
            this.X2 = referenceEntry;
        }

        public void n(ReferenceEntry<K, V> referenceEntry) {
            this.a3 = referenceEntry;
        }

        public void o(ReferenceEntry<K, V> referenceEntry) {
            this.b3 = referenceEntry;
        }

        public void p(ReferenceEntry<K, V> referenceEntry) {
            this.Y2 = referenceEntry;
        }

        public ReferenceEntry<K, V> q() {
            return this.b3;
        }
    }

    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        @CheckForNull
        final ReferenceEntry<K, V> X;
        volatile ValueReference<K, V> Y = LocalCache.U();
        final int s;

        WeakEntry(ReferenceQueue<K> referenceQueue, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(k2, referenceQueue);
            this.s = i2;
            this.X = referenceEntry;
        }

        public ReferenceEntry<K, V> a() {
            return this.X;
        }

        public ValueReference<K, V> b() {
            return this.Y;
        }

        public int c() {
            return this.s;
        }

        public ReferenceEntry<K, V> e() {
            throw new UnsupportedOperationException();
        }

        public void f(ValueReference<K, V> valueReference) {
            this.Y = valueReference;
        }

        public long g() {
            throw new UnsupportedOperationException();
        }

        public K getKey() {
            return get();
        }

        public void h(long j2) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> i() {
            throw new UnsupportedOperationException();
        }

        public long j() {
            throw new UnsupportedOperationException();
        }

        public void k(long j2) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> l() {
            throw new UnsupportedOperationException();
        }

        public void m(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void n(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void o(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void p(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> q() {
            throw new UnsupportedOperationException();
        }
    }

    static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> s;

        WeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, referenceQueue);
            this.s = referenceEntry;
        }

        public ReferenceEntry<K, V> a() {
            return this.s;
        }

        public boolean b() {
            return true;
        }

        public boolean c() {
            return false;
        }

        public void d(V v) {
        }

        public int e() {
            return 1;
        }

        public V f() {
            return get();
        }

        public ValueReference<K, V> g(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference(referenceQueue, v, referenceEntry);
        }
    }

    static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
        @Weak
        ReferenceEntry<K, V> X2 = LocalCache.F();
        @Weak
        ReferenceEntry<K, V> Y2 = LocalCache.F();
        volatile long Z = Long.MAX_VALUE;

        WeakWriteEntry(ReferenceQueue<K> referenceQueue, K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k2, i2, referenceEntry);
        }

        public long g() {
            return this.Z;
        }

        public ReferenceEntry<K, V> i() {
            return this.X2;
        }

        public void k(long j2) {
            this.Z = j2;
        }

        public void n(ReferenceEntry<K, V> referenceEntry) {
            this.X2 = referenceEntry;
        }

        public void o(ReferenceEntry<K, V> referenceEntry) {
            this.Y2 = referenceEntry;
        }

        public ReferenceEntry<K, V> q() {
            return this.Y2;
        }
    }

    static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
        final int X;

        WeightedSoftValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i2) {
            super(referenceQueue, v, referenceEntry);
            this.X = i2;
        }

        public int e() {
            return this.X;
        }

        public ValueReference<K, V> g(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedSoftValueReference(referenceQueue, v, referenceEntry, this.X);
        }
    }

    static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
        final int X;

        WeightedStrongValueReference(V v, int i2) {
            super(v);
            this.X = i2;
        }

        public int e() {
            return this.X;
        }
    }

    static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
        final int X;

        WeightedWeakValueReference(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry, int i2) {
            super(referenceQueue, v, referenceEntry);
            this.X = i2;
        }

        public int e() {
            return this.X;
        }

        public ValueReference<K, V> g(ReferenceQueue<V> referenceQueue, V v, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedWeakValueReference(referenceQueue, v, referenceEntry, this.X);
        }
    }

    static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry<K, V> s = new AbstractReferenceEntry<K, V>(this) {
            @Weak
            ReferenceEntry<K, V> X = this;
            @Weak
            ReferenceEntry<K, V> s = this;

            public long g() {
                return Long.MAX_VALUE;
            }

            public ReferenceEntry<K, V> i() {
                return this.s;
            }

            public void k(long j2) {
            }

            public void n(ReferenceEntry<K, V> referenceEntry) {
                this.s = referenceEntry;
            }

            public void o(ReferenceEntry<K, V> referenceEntry) {
                this.X = referenceEntry;
            }

            public ReferenceEntry<K, V> q() {
                return this.X;
            }
        };

        WriteQueue() {
        }

        /* renamed from: b */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.d(referenceEntry.q(), referenceEntry.i());
            LocalCache.d(this.s.q(), referenceEntry);
            LocalCache.d(referenceEntry, this.s);
            return true;
        }

        @CheckForNull
        /* renamed from: c */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> i2 = this.s.i();
            if (i2 == this.s) {
                return null;
            }
            return i2;
        }

        public void clear() {
            ReferenceEntry<K, V> i2 = this.s.i();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.s;
                if (i2 != referenceEntry) {
                    ReferenceEntry<K, V> i3 = i2.i();
                    LocalCache.H(i2);
                    i2 = i3;
                } else {
                    referenceEntry.n(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.s;
                    referenceEntry2.o(referenceEntry2);
                    return;
                }
            }
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).i() != NullEntry.INSTANCE;
        }

        @CheckForNull
        /* renamed from: d */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> i2 = this.s.i();
            if (i2 == this.s) {
                return null;
            }
            remove(i2);
            return i2;
        }

        public boolean isEmpty() {
            return this.s.i() == this.s;
        }

        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) {
                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: b */
                public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> i2 = referenceEntry.i();
                    if (i2 == WriteQueue.this.s) {
                        return null;
                    }
                    return i2;
                }
            };
        }

        @CanIgnoreReturnValue
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry q = referenceEntry.q();
            ReferenceEntry i2 = referenceEntry.i();
            LocalCache.d(q, i2);
            LocalCache.H(referenceEntry);
            return i2 != NullEntry.INSTANCE;
        }

        public int size() {
            int i2 = 0;
            for (ReferenceEntry<K, V> i3 = this.s.i(); i3 != this.s; i3 = i3.i()) {
                i2++;
            }
            return i2;
        }
    }

    final class WriteThroughEntry implements Map.Entry<K, V> {
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
            V put = LocalCache.this.put(this.s, v);
            this.X = v;
            return put;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, @CheckForNull CacheLoader<? super K, V> cacheLoader) {
        this.Z = Math.min(cacheBuilder.j(), 65536);
        Strength o = cacheBuilder.o();
        this.Z2 = o;
        this.a3 = cacheBuilder.v();
        this.X2 = cacheBuilder.n();
        this.Y2 = cacheBuilder.u();
        long p = cacheBuilder.p();
        this.b3 = p;
        this.c3 = cacheBuilder.w();
        this.d3 = cacheBuilder.k();
        this.e3 = cacheBuilder.l();
        this.f3 = cacheBuilder.q();
        RemovalListener<K1, V1> r = cacheBuilder.r();
        this.h3 = r;
        this.g3 = r == CacheBuilder.NullListener.INSTANCE ? h() : new ConcurrentLinkedQueue<>();
        this.i3 = cacheBuilder.t(N());
        this.j3 = EntryFactory.f(o, V(), Z());
        this.k3 = (AbstractCache.StatsCounter) cacheBuilder.s().get();
        this.l3 = cacheLoader;
        int min = Math.min(cacheBuilder.m(), 1073741824);
        if (i() && !g()) {
            min = (int) Math.min((long) min, p);
        }
        int i2 = 0;
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        while (i5 < this.Z && (!i() || ((long) i5) * 20 <= this.b3)) {
            i6++;
            i5 <<= 1;
        }
        this.X = 32 - i6;
        this.s = i5 - 1;
        this.Y = D(i5);
        int i7 = min / i5;
        while (i4 < (i7 * i5 < min ? i7 + 1 : i7)) {
            i4 <<= 1;
        }
        if (i()) {
            long j2 = this.b3;
            long j4 = (long) i5;
            long j5 = (j2 / j4) + 1;
            long j6 = j2 % j4;
            while (true) {
                Segment<K, V>[] segmentArr = this.Y;
                if (i2 < segmentArr.length) {
                    if (((long) i2) == j6) {
                        j5--;
                    }
                    segmentArr[i2] = f(i4, j5, (AbstractCache.StatsCounter) cacheBuilder.s().get());
                    i2++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.Y;
                if (i2 < segmentArr2.length) {
                    segmentArr2[i2] = f(i4, -1, (AbstractCache.StatsCounter) cacheBuilder.s().get());
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    static <K, V> ReferenceEntry<K, V> F() {
        return NullEntry.INSTANCE;
    }

    static <K, V> void G(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry F = F();
        referenceEntry.m(F);
        referenceEntry.p(F);
    }

    static <K, V> void H(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry F = F();
        referenceEntry.n(F);
        referenceEntry.o(F);
    }

    static int R(int i2) {
        int i4 = i2 + ((i2 << 15) ^ -12931);
        int i5 = i4 ^ (i4 >>> 10);
        int i6 = i5 + (i5 << 3);
        int i7 = i6 ^ (i6 >>> 6);
        int i8 = i7 + (i7 << 2) + (i7 << 14);
        return i8 ^ (i8 >>> 16);
    }

    /* access modifiers changed from: private */
    public static <E> ArrayList<E> T(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    static <K, V> ValueReference<K, V> U() {
        return v3;
    }

    static <K, V> void c(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.m(referenceEntry2);
        referenceEntry2.p(referenceEntry);
    }

    static <K, V> void d(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.n(referenceEntry2);
        referenceEntry2.o(referenceEntry);
    }

    static <E> Queue<E> h() {
        return w3;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public Map<K, V> A(Set<? extends K> set, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        Preconditions.E(cacheLoader);
        Preconditions.E(set);
        Stopwatch c2 = Stopwatch.c();
        boolean z = true;
        boolean z2 = false;
        try {
            Map<? super K, V> e2 = cacheLoader.e(set);
            if (e2 != null) {
                c2.l();
                for (Map.Entry next : e2.entrySet()) {
                    Object key = next.getKey();
                    Object value = next.getValue();
                    if (key == null || value == null) {
                        z2 = true;
                    } else {
                        put(key, value);
                    }
                }
                if (!z2) {
                    this.k3.e(c2.g(TimeUnit.NANOSECONDS));
                    return e2;
                }
                this.k3.d(c2.g(TimeUnit.NANOSECONDS));
                throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null keys or values from loadAll");
            }
            this.k3.d(c2.g(TimeUnit.NANOSECONDS));
            throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null map from loadAll");
        } catch (CacheLoader.UnsupportedLoadingOperationException e4) {
            throw e4;
        } catch (InterruptedException e5) {
            Thread.currentThread().interrupt();
            throw new ExecutionException(e5);
        } catch (RuntimeException e6) {
            throw new UncheckedExecutionException((Throwable) e6);
        } catch (Exception e7) {
            throw new ExecutionException(e7);
        } catch (Error e8) {
            throw new ExecutionError(e8);
        } catch (Throwable th) {
            th = th;
        }
        if (!z) {
            this.k3.d(c2.g(TimeUnit.NANOSECONDS));
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    public long B() {
        long j2 = 0;
        for (Segment<K, V> segment : this.Y) {
            j2 += (long) Math.max(0, segment.X);
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ReferenceEntry<K, V> C(K k2, int i2, @CheckForNull ReferenceEntry<K, V> referenceEntry) {
        Segment S = S(i2);
        S.lock();
        try {
            return S.F(k2, i2, referenceEntry);
        } finally {
            S.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final Segment<K, V>[] D(int i2) {
        return new Segment[i2];
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ValueReference<K, V> E(ReferenceEntry<K, V> referenceEntry, V v, int i2) {
        return this.a3.c(S(referenceEntry.c()), referenceEntry, Preconditions.E(v), i2);
    }

    /* access modifiers changed from: package-private */
    public void I() {
        while (true) {
            RemovalNotification poll = this.g3.poll();
            if (poll != null) {
                try {
                    this.h3.a(poll);
                } catch (Throwable th) {
                    u3.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void J(ReferenceEntry<K, V> referenceEntry) {
        int c2 = referenceEntry.c();
        S(c2).M(referenceEntry, c2);
    }

    /* access modifiers changed from: package-private */
    public void K(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> a2 = valueReference.a();
        int c2 = a2.c();
        S(c2).N(a2.getKey(), c2, valueReference);
    }

    /* access modifiers changed from: package-private */
    public boolean M() {
        return k();
    }

    /* access modifiers changed from: package-private */
    public boolean N() {
        return O() || M();
    }

    /* access modifiers changed from: package-private */
    public boolean O() {
        return l() || Q();
    }

    /* access modifiers changed from: package-private */
    public void P(K k2) {
        int v = v(Preconditions.E(k2));
        S(v).R(k2, v, this.l3, false);
    }

    /* access modifiers changed from: package-private */
    public boolean Q() {
        return this.f3 > 0;
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V> S(int i2) {
        return this.Y[(i2 >>> this.X) & this.s];
    }

    /* access modifiers changed from: package-private */
    public boolean V() {
        return W() || M();
    }

    /* access modifiers changed from: package-private */
    public boolean W() {
        return k() || i();
    }

    /* access modifiers changed from: package-private */
    public boolean X() {
        return this.Z2 != Strength.STRONG;
    }

    /* access modifiers changed from: package-private */
    public boolean Y() {
        return this.a3 != Strength.STRONG;
    }

    /* access modifiers changed from: package-private */
    public boolean Z() {
        return a0() || O();
    }

    /* access modifiers changed from: package-private */
    public boolean a0() {
        return l();
    }

    public void b() {
        for (Segment<K, V> b2 : this.Y) {
            b2.b();
        }
    }

    public void clear() {
        for (Segment<K, V> c2 : this.Y) {
            c2.c();
        }
    }

    public boolean containsKey(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        int v = v(obj);
        return S(v).g(obj, v);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        Object obj2 = obj;
        if (obj2 == null) {
            return false;
        }
        long a2 = this.i3.a();
        Segment<K, V>[] segmentArr = this.Y;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            int length = segmentArr.length;
            long j4 = 0;
            int i4 = 0;
            while (i4 < length) {
                Segment<K, V> segment = segmentArr[i4];
                int i5 = segment.X;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.Y2;
                for (int i6 = 0; i6 < atomicReferenceArray.length(); i6++) {
                    ReferenceEntry referenceEntry = atomicReferenceArray.get(i6);
                    while (referenceEntry != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V x = segment.x(referenceEntry, a2);
                        long j5 = a2;
                        if (x != null && this.Y2.d(obj2, x)) {
                            return true;
                        }
                        referenceEntry = referenceEntry.a();
                        segmentArr = segmentArr2;
                        a2 = j5;
                    }
                    long j6 = a2;
                    Segment<K, V>[] segmentArr3 = segmentArr;
                }
                Segment<K, V>[] segmentArr4 = segmentArr;
                j4 += (long) segment.Z;
                i4++;
                a2 = a2;
            }
            long j7 = a2;
            Segment<K, V>[] segmentArr5 = segmentArr;
            if (j4 == j2) {
                return false;
            }
            i2++;
            j2 = j4;
            segmentArr = segmentArr5;
            a2 = j7;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public ReferenceEntry<K, V> e(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        return S(referenceEntry.c()).i(referenceEntry, referenceEntry2);
    }

    @GwtIncompatible
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.o3;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.o3 = entrySet;
        return entrySet;
    }

    /* access modifiers changed from: package-private */
    public Segment<K, V> f(int i2, long j2, AbstractCache.StatsCounter statsCounter) {
        return new Segment(this, i2, j2, statsCounter);
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.c3 != CacheBuilder.OneWeigher.INSTANCE;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int v = v(obj);
        return S(v).r(obj, v);
    }

    @CheckForNull
    public V getOrDefault(@CheckForNull Object obj, @CheckForNull V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.b3 >= 0;
    }

    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.Y;
        long j2 = 0;
        for (Segment<K, V> segment : segmentArr) {
            if (segment.X != 0) {
                return false;
            }
            j2 += (long) segment.Z;
        }
        if (j2 == 0) {
            return true;
        }
        for (Segment<K, V> segment2 : segmentArr) {
            if (segment2.X != 0) {
                return false;
            }
            j2 -= (long) segment2.Z;
        }
        return j2 == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return l() || k();
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.d3 > 0;
    }

    public Set<K> keySet() {
        Set<K> set = this.m3;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.m3 = keySet;
        return keySet;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.e3 > 0;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public V m(K k2, CacheLoader<? super K, V> cacheLoader) throws ExecutionException {
        int v = v(Preconditions.E(k2));
        return S(v).s(k2, v, cacheLoader);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:23|24|(2:27|25)|39) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r8 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0079, code lost:
        if (r8.hasNext() != false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007b, code lost:
        r1 = r8.next();
        r3 = r3 - 1;
        r0.put(r1, m(r1, r7.l3));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0071 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.collect.ImmutableMap<K, V> n(java.lang.Iterable<? extends K> r8) throws java.util.concurrent.ExecutionException {
        /*
            r7 = this;
            java.util.LinkedHashMap r0 = com.google.common.collect.Maps.c0()
            java.util.LinkedHashSet r1 = com.google.common.collect.Sets.A()
            java.util.Iterator r8 = r8.iterator()
            r2 = 0
            r3 = 0
        L_0x000e:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0030
            java.lang.Object r4 = r8.next()
            java.lang.Object r5 = r7.get(r4)
            boolean r6 = r0.containsKey(r4)
            if (r6 != 0) goto L_0x000e
            r0.put(r4, r5)
            if (r5 != 0) goto L_0x002d
            int r3 = r3 + 1
            r1.add(r4)
            goto L_0x000e
        L_0x002d:
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0030:
            boolean r8 = r1.isEmpty()     // Catch:{ all -> 0x0058 }
            if (r8 != 0) goto L_0x008b
            java.util.Set r8 = java.util.Collections.unmodifiableSet(r1)     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            com.google.common.cache.CacheLoader<? super K, V> r4 = r7.l3     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            java.util.Map r8 = r7.A(r8, r4)     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            java.util.Iterator r4 = r1.iterator()     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
        L_0x0044:
            boolean r5 = r4.hasNext()     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            if (r5 == 0) goto L_0x008b
            java.lang.Object r5 = r4.next()     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            java.lang.Object r6 = r8.get(r5)     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            if (r6 == 0) goto L_0x005a
            r0.put(r5, r6)     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            goto L_0x0044
        L_0x0058:
            r8 = move-exception
            goto L_0x009a
        L_0x005a:
            com.google.common.cache.CacheLoader$InvalidCacheLoadException r8 = new com.google.common.cache.CacheLoader$InvalidCacheLoadException     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            r4.<init>()     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            java.lang.String r6 = "loadAll failed to return a value for "
            r4.append(r6)     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            r4.append(r5)     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            java.lang.String r4 = r4.toString()     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            r8.<init>(r4)     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
            throw r8     // Catch:{ UnsupportedLoadingOperationException -> 0x0071 }
        L_0x0071:
            java.util.Iterator r8 = r1.iterator()     // Catch:{ all -> 0x0058 }
        L_0x0075:
            boolean r1 = r8.hasNext()     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x008b
            java.lang.Object r1 = r8.next()     // Catch:{ all -> 0x0058 }
            int r3 = r3 + -1
            com.google.common.cache.CacheLoader<? super K, V> r4 = r7.l3     // Catch:{ all -> 0x0058 }
            java.lang.Object r4 = r7.m(r1, r4)     // Catch:{ all -> 0x0058 }
            r0.put(r1, r4)     // Catch:{ all -> 0x0058 }
            goto L_0x0075
        L_0x008b:
            com.google.common.collect.ImmutableMap r8 = com.google.common.collect.ImmutableMap.g(r0)     // Catch:{ all -> 0x0058 }
            com.google.common.cache.AbstractCache$StatsCounter r0 = r7.k3
            r0.b(r2)
            com.google.common.cache.AbstractCache$StatsCounter r0 = r7.k3
            r0.c(r3)
            return r8
        L_0x009a:
            com.google.common.cache.AbstractCache$StatsCounter r0 = r7.k3
            r0.b(r2)
            com.google.common.cache.AbstractCache$StatsCounter r0 = r7.k3
            r0.c(r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.n(java.lang.Iterable):com.google.common.collect.ImmutableMap");
    }

    /* access modifiers changed from: package-private */
    public ImmutableMap<K, V> o(Iterable<?> iterable) {
        ImmutableMap.Builder b2 = ImmutableMap.b();
        int i2 = 0;
        int i4 = 0;
        for (Object next : iterable) {
            Object obj = get(next);
            if (obj == null) {
                i4++;
            } else {
                b2.i(next, obj);
                i2++;
            }
        }
        this.k3.b(i2);
        this.k3.c(i4);
        return b2.c();
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public ReferenceEntry<K, V> p(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int v = v(obj);
        return S(v).u(obj, v);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V put(K k2, V v) {
        Preconditions.E(k2);
        Preconditions.E(v);
        int v2 = v(k2);
        return S(v2).L(k2, v2, v, false);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    @CheckForNull
    public V putIfAbsent(K k2, V v) {
        Preconditions.E(k2);
        Preconditions.E(v);
        int v2 = v(k2);
        return S(v2).L(k2, v2, v, true);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        if (obj == null) {
            return null;
        }
        int v = v(obj);
        return S(v).S(obj, v);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V replace(K k2, V v) {
        Preconditions.E(k2);
        Preconditions.E(v);
        int v2 = v(k2);
        return S(v2).Z(k2, v2, v);
    }

    @CheckForNull
    public V s(Object obj) {
        int v = v(Preconditions.E(obj));
        V r = S(v).r(obj, v);
        AbstractCache.StatsCounter statsCounter = this.k3;
        if (r == null) {
            statsCounter.c(1);
        } else {
            statsCounter.b(1);
        }
        return r;
    }

    public int size() {
        return Ints.z(B());
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V t(ReferenceEntry<K, V> referenceEntry, long j2) {
        V v;
        if (referenceEntry.getKey() == null || (v = referenceEntry.b().get()) == null || y(referenceEntry, j2)) {
            return null;
        }
        return v;
    }

    /* access modifiers changed from: package-private */
    public V u(K k2) throws ExecutionException {
        return m(k2, this.l3);
    }

    /* access modifiers changed from: package-private */
    public int v(@CheckForNull Object obj) {
        return R(this.X2.f(obj));
    }

    public Collection<V> values() {
        Collection<V> collection = this.n3;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.n3 = values;
        return values;
    }

    /* access modifiers changed from: package-private */
    public void w(Iterable<?> iterable) {
        for (Object remove : iterable) {
            remove(remove);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean y(ReferenceEntry<K, V> referenceEntry, long j2) {
        Preconditions.E(referenceEntry);
        if (!k() || j2 - referenceEntry.j() < this.d3) {
            return l() && j2 - referenceEntry.g() >= this.e3;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean z(ReferenceEntry<K, V> referenceEntry, long j2) {
        return S(referenceEntry.c()).x(referenceEntry, j2) != null;
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int v = v(obj);
        return S(v).T(obj, v, obj2);
    }

    @CanIgnoreReturnValue
    public boolean replace(K k2, @CheckForNull V v, V v2) {
        Preconditions.E(k2);
        Preconditions.E(v2);
        if (v == null) {
            return false;
        }
        int v4 = v(k2);
        return S(v4).a0(k2, v4, v, v2);
    }
}
