package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class Striped<L> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f23238a = 1024;

    /* renamed from: b  reason: collision with root package name */
    private static final int f23239b = -1;

    private static class CompactStriped<L> extends PowerOfTwoStriped<L> {

        /* renamed from: d  reason: collision with root package name */
        private final Object[] f23240d;

        private CompactStriped(int i2, Supplier<L> supplier) {
            super(i2);
            int i3 = 0;
            Preconditions.e(i2 <= 1073741824, "Stripes must be <= 2^30)");
            this.f23240d = new Object[(this.f23244c + 1)];
            while (true) {
                Object[] objArr = this.f23240d;
                if (i3 < objArr.length) {
                    objArr[i3] = supplier.get();
                    i3++;
                } else {
                    return;
                }
            }
        }

        public L j(int i2) {
            return this.f23240d[i2];
        }

        public int v() {
            return this.f23240d.length;
        }
    }

    @VisibleForTesting
    static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {

        /* renamed from: d  reason: collision with root package name */
        final ConcurrentMap<Integer, L> f23241d;

        /* renamed from: e  reason: collision with root package name */
        final Supplier<L> f23242e;

        /* renamed from: f  reason: collision with root package name */
        final int f23243f;

        LargeLazyStriped(int i2, Supplier<L> supplier) {
            super(i2);
            int i3 = this.f23244c;
            this.f23243f = i3 == -1 ? Integer.MAX_VALUE : i3 + 1;
            this.f23242e = supplier;
            this.f23241d = new MapMaker().m().i();
        }

        public L j(int i2) {
            if (this.f23243f != Integer.MAX_VALUE) {
                Preconditions.C(i2, v());
            }
            L l2 = this.f23241d.get(Integer.valueOf(i2));
            if (l2 != null) {
                return l2;
            }
            L l3 = this.f23242e.get();
            return MoreObjects.a(this.f23241d.putIfAbsent(Integer.valueOf(i2), l3), l3);
        }

        public int v() {
            return this.f23243f;
        }
    }

    private static class PaddedLock extends ReentrantLock {
        long X;
        long Y;
        long s;

        PaddedLock() {
            super(false);
        }
    }

    private static class PaddedSemaphore extends Semaphore {
        long X;
        long Y;
        long s;

        PaddedSemaphore(int i2) {
            super(i2, false);
        }
    }

    private static abstract class PowerOfTwoStriped<L> extends Striped<L> {

        /* renamed from: c  reason: collision with root package name */
        final int f23244c;

        PowerOfTwoStriped(int i2) {
            super();
            Preconditions.e(i2 > 0, "Stripes must be positive");
            this.f23244c = i2 > 1073741824 ? -1 : Striped.g(i2) - 1;
        }

        public final L i(Object obj) {
            return j(k(obj));
        }

        /* access modifiers changed from: package-private */
        public final int k(Object obj) {
            return Striped.w(obj.hashCode()) & this.f23244c;
        }
    }

    @VisibleForTesting
    static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceArray<ArrayReference<? extends L>> f23245d;

        /* renamed from: e  reason: collision with root package name */
        final Supplier<L> f23246e;

        /* renamed from: f  reason: collision with root package name */
        final int f23247f;

        /* renamed from: g  reason: collision with root package name */
        final ReferenceQueue<L> f23248g = new ReferenceQueue<>();

        private static final class ArrayReference<L> extends WeakReference<L> {

            /* renamed from: a  reason: collision with root package name */
            final int f23249a;

            ArrayReference(L l2, int i2, ReferenceQueue<L> referenceQueue) {
                super(l2, referenceQueue);
                this.f23249a = i2;
            }
        }

        SmallLazyStriped(int i2, Supplier<L> supplier) {
            super(i2);
            int i3 = this.f23244c;
            int i4 = i3 == -1 ? Integer.MAX_VALUE : i3 + 1;
            this.f23247f = i4;
            this.f23245d = new AtomicReferenceArray<>(i4);
            this.f23246e = supplier;
        }

        private void x() {
            while (true) {
                Reference<? extends L> poll = this.f23248g.poll();
                if (poll != null) {
                    ArrayReference arrayReference = (ArrayReference) poll;
                    I.a(this.f23245d, arrayReference.f23249a, arrayReference, (Object) null);
                } else {
                    return;
                }
            }
        }

        public L j(int i2) {
            L l2;
            if (this.f23247f != Integer.MAX_VALUE) {
                Preconditions.C(i2, v());
            }
            ArrayReference arrayReference = this.f23245d.get(i2);
            L l3 = arrayReference == null ? null : arrayReference.get();
            if (l3 != null) {
                return l3;
            }
            L l4 = this.f23246e.get();
            ArrayReference arrayReference2 = new ArrayReference(l4, i2, this.f23248g);
            while (!I.a(this.f23245d, i2, arrayReference, arrayReference2)) {
                arrayReference = this.f23245d.get(i2);
                if (arrayReference == null) {
                    l2 = null;
                    continue;
                } else {
                    l2 = arrayReference.get();
                    continue;
                }
                if (l2 != null) {
                    return l2;
                }
            }
            x();
            return l4;
        }

        public int v() {
            return this.f23247f;
        }
    }

    private static final class WeakSafeCondition extends ForwardingCondition {

        /* renamed from: a  reason: collision with root package name */
        private final Condition f23250a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakSafeReadWriteLock f23251b;

        WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.f23250a = condition;
            this.f23251b = weakSafeReadWriteLock;
        }

        /* access modifiers changed from: package-private */
        public Condition a() {
            return this.f23250a;
        }
    }

    private static final class WeakSafeLock extends ForwardingLock {
        private final WeakSafeReadWriteLock X;
        private final Lock s;

        WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.s = lock;
            this.X = weakSafeReadWriteLock;
        }

        /* access modifiers changed from: package-private */
        public Lock a() {
            return this.s;
        }

        public Condition newCondition() {
            return new WeakSafeCondition(this.s.newCondition(), this.X);
        }
    }

    private static final class WeakSafeReadWriteLock implements ReadWriteLock {
        private final ReadWriteLock s = new ReentrantReadWriteLock();

        WeakSafeReadWriteLock() {
        }

        public Lock readLock() {
            return new WeakSafeLock(this.s.readLock(), this);
        }

        public Lock writeLock() {
            return new WeakSafeLock(this.s.writeLock(), this);
        }
    }

    private Striped() {
    }

    /* access modifiers changed from: private */
    public static int g(int i2) {
        return 1 << IntMath.p(i2, RoundingMode.CEILING);
    }

    static <L> Striped<L> h(int i2, Supplier<L> supplier) {
        return new CompactStriped(i2, supplier);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Lock l() {
        return new ReentrantLock(false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Semaphore m(int i2) {
        return new Semaphore(i2, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Semaphore n(int i2) {
        return new PaddedSemaphore(i2);
    }

    private static <L> Striped<L> o(int i2, Supplier<L> supplier) {
        return i2 < 1024 ? new SmallLazyStriped(i2, supplier) : new LargeLazyStriped(i2, supplier);
    }

    public static Striped<Lock> p(int i2) {
        return o(i2, new G());
    }

    public static Striped<ReadWriteLock> q(int i2) {
        return o(i2, new C());
    }

    public static Striped<Semaphore> r(int i2, int i3) {
        return o(i2, new F(i3));
    }

    public static Striped<Lock> s(int i2) {
        return h(i2, new D());
    }

    public static Striped<ReadWriteLock> t(int i2) {
        return h(i2, new H());
    }

    public static Striped<Semaphore> u(int i2, int i3) {
        return h(i2, new E(i3));
    }

    /* access modifiers changed from: private */
    public static int w(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    public Iterable<L> f(Iterable<? extends Object> iterable) {
        ArrayList<E> r = Lists.r(iterable);
        if (r.isEmpty()) {
            return ImmutableList.I();
        }
        int[] iArr = new int[r.size()];
        for (int i2 = 0; i2 < r.size(); i2++) {
            iArr[i2] = k(r.get(i2));
        }
        Arrays.sort(iArr);
        int i3 = iArr[0];
        r.set(0, j(i3));
        for (int i4 = 1; i4 < r.size(); i4++) {
            int i5 = iArr[i4];
            if (i5 == i3) {
                r.set(i4, r.get(i4 - 1));
            } else {
                r.set(i4, j(i5));
                i3 = i5;
            }
        }
        return Collections.unmodifiableList(r);
    }

    public abstract L i(Object obj);

    public abstract L j(int i2);

    /* access modifiers changed from: package-private */
    public abstract int k(Object obj);

    public abstract int v();
}
