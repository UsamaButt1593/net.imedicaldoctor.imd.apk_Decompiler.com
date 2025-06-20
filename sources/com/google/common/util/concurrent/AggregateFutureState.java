package com.google.common.util.concurrent;

import androidx.concurrent.futures.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
@ElementTypesAreNonnullByDefault
abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final AtomicHelper d3;
    private static final Logger e3;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Set<Throwable> b3 = null;
    private volatile int c3;

    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        /* access modifiers changed from: package-private */
        public abstract void a(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2);

        /* access modifiers changed from: package-private */
        public abstract int b(AggregateFutureState<?> aggregateFutureState);
    }

    private static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AggregateFutureState<?>, Set<Throwable>> f23097a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicIntegerFieldUpdater<AggregateFutureState<?>> f23098b;

        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f23097a = atomicReferenceFieldUpdater;
            this.f23098b = atomicIntegerFieldUpdater;
        }

        /* access modifiers changed from: package-private */
        public void a(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            a.a(this.f23097a, aggregateFutureState, set, set2);
        }

        /* access modifiers changed from: package-private */
        public int b(AggregateFutureState<?> aggregateFutureState) {
            return this.f23098b.decrementAndGet(aggregateFutureState);
        }
    }

    private static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        /* access modifiers changed from: package-private */
        public void a(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                try {
                    if (aggregateFutureState.b3 == set) {
                        Set unused = aggregateFutureState.b3 = set2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int b(AggregateFutureState<?> aggregateFutureState) {
            int H;
            synchronized (aggregateFutureState) {
                H = AggregateFutureState.H(aggregateFutureState);
            }
            return H;
        }
    }

    static {
        AtomicHelper atomicHelper;
        Class<AggregateFutureState> cls = AggregateFutureState.class;
        e3 = Logger.getLogger(cls.getName());
        Throwable th = null;
        try {
            atomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(cls, Set.class, "b3"), AtomicIntegerFieldUpdater.newUpdater(cls, "c3"));
        } catch (Error | RuntimeException e2) {
            atomicHelper = new SynchronizedAtomicHelper();
            th = e2;
        }
        d3 = atomicHelper;
        if (th != null) {
            e3.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    AggregateFutureState(int i2) {
        this.c3 = i2;
    }

    static /* synthetic */ int H(AggregateFutureState aggregateFutureState) {
        int i2 = aggregateFutureState.c3 - 1;
        aggregateFutureState.c3 = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public abstract void I(Set<Throwable> set);

    /* access modifiers changed from: package-private */
    public final void J() {
        this.b3 = null;
    }

    /* access modifiers changed from: package-private */
    public final int K() {
        return d3.b(this);
    }

    /* access modifiers changed from: package-private */
    public final Set<Throwable> L() {
        Set<Throwable> set = this.b3;
        if (set != null) {
            return set;
        }
        Set p = Sets.p();
        I(p);
        d3.a(this, (Set<Throwable>) null, p);
        Set<Throwable> set2 = this.b3;
        Objects.requireNonNull(set2);
        return set2;
    }
}
