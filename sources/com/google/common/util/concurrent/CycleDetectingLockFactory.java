package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.Weak;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public class CycleDetectingLockFactory {

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, LockGraphNode>> f23157b = new MapMaker().l().i();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f23158c = Logger.getLogger(CycleDetectingLockFactory.class.getName());

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<LockGraphNode>> f23159d = new ThreadLocal<ArrayList<LockGraphNode>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<LockGraphNode> initialValue() {
            return Lists.u(3);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final Policy f23160a;

    private interface CycleDetectingLock {
        LockGraphNode a();

        boolean b();
    }

    final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {
        private final LockGraphNode s;

        private CycleDetectingReentrantLock(LockGraphNode lockGraphNode, boolean z) {
            super(z);
            this.s = (LockGraphNode) Preconditions.E(lockGraphNode);
        }

        public LockGraphNode a() {
            return this.s;
        }

        public boolean b() {
            return isHeldByCurrentThread();
        }

        public void lock() {
            CycleDetectingLockFactory.this.a(this);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }

        public boolean tryLock(long j2, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this);
            try {
                return super.tryLock(j2, timeUnit);
            } finally {
                CycleDetectingLockFactory.h(this);
            }
        }
    }

    private class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
        @Weak
        final CycleDetectingReentrantReadWriteLock s;

        CycleDetectingReentrantReadLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.s = cycleDetectingReentrantReadWriteLock;
        }

        public void lock() {
            CycleDetectingLockFactory.this.a(this.s);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.h(this.s);
            }
        }

        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.s);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.h(this.s);
            }
        }

        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this.s);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.h(this.s);
            }
        }

        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.h(this.s);
            }
        }

        public boolean tryLock(long j2, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.s);
            try {
                return super.tryLock(j2, timeUnit);
            } finally {
                CycleDetectingLockFactory.h(this.s);
            }
        }
    }

    final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {
        private final CycleDetectingReentrantWriteLock X;
        private final LockGraphNode Y;
        private final CycleDetectingReentrantReadLock s;

        private CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory cycleDetectingLockFactory, LockGraphNode lockGraphNode, boolean z) {
            super(z);
            this.s = new CycleDetectingReentrantReadLock(this);
            this.X = new CycleDetectingReentrantWriteLock(this);
            this.Y = (LockGraphNode) Preconditions.E(lockGraphNode);
        }

        public LockGraphNode a() {
            return this.Y;
        }

        public boolean b() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.s;
        }

        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.X;
        }
    }

    private class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
        @Weak
        final CycleDetectingReentrantReadWriteLock s;

        CycleDetectingReentrantWriteLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.s = cycleDetectingReentrantReadWriteLock;
        }

        public void lock() {
            CycleDetectingLockFactory.this.a(this.s);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.h(this.s);
            }
        }

        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.s);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.h(this.s);
            }
        }

        public boolean tryLock() {
            CycleDetectingLockFactory.this.a(this.s);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.h(this.s);
            }
        }

        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.h(this.s);
            }
        }

        public boolean tryLock(long j2, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.a(this.s);
            try {
                return super.tryLock(j2, timeUnit);
            } finally {
                CycleDetectingLockFactory.h(this.s);
            }
        }
    }

    private static class ExampleStackTrace extends IllegalStateException {
        static final ImmutableSet<String> X = ImmutableSet.N(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());
        static final StackTraceElement[] s = new StackTraceElement[0];

        ExampleStackTrace(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2) {
            super(lockGraphNode.d() + " -> " + lockGraphNode2.d());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            while (i2 < length) {
                if (WithExplicitOrdering.class.getName().equals(stackTrace[i2].getClassName())) {
                    setStackTrace(s);
                    return;
                } else if (!X.contains(stackTrace[i2].getClassName())) {
                    setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2, length));
                    return;
                } else {
                    i2++;
                }
            }
        }
    }

    private static class LockGraphNode {

        /* renamed from: a  reason: collision with root package name */
        final Map<LockGraphNode, ExampleStackTrace> f23161a = new MapMaker().l().i();

        /* renamed from: b  reason: collision with root package name */
        final Map<LockGraphNode, PotentialDeadlockException> f23162b = new MapMaker().l().i();

        /* renamed from: c  reason: collision with root package name */
        final String f23163c;

        LockGraphNode(String str) {
            this.f23163c = (String) Preconditions.E(str);
        }

        @CheckForNull
        private ExampleStackTrace c(LockGraphNode lockGraphNode, Set<LockGraphNode> set) {
            if (!set.add(this)) {
                return null;
            }
            ExampleStackTrace exampleStackTrace = this.f23161a.get(lockGraphNode);
            if (exampleStackTrace != null) {
                return exampleStackTrace;
            }
            for (Map.Entry next : this.f23161a.entrySet()) {
                LockGraphNode lockGraphNode2 = (LockGraphNode) next.getKey();
                ExampleStackTrace c2 = lockGraphNode2.c(lockGraphNode, set);
                if (c2 != null) {
                    ExampleStackTrace exampleStackTrace2 = new ExampleStackTrace(lockGraphNode2, this);
                    exampleStackTrace2.setStackTrace(((ExampleStackTrace) next.getValue()).getStackTrace());
                    exampleStackTrace2.initCause(c2);
                    return exampleStackTrace2;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void a(Policy policy, LockGraphNode lockGraphNode) {
            Preconditions.x0(this != lockGraphNode, "Attempted to acquire multiple locks with the same rank %s", lockGraphNode.d());
            if (!this.f23161a.containsKey(lockGraphNode)) {
                PotentialDeadlockException potentialDeadlockException = this.f23162b.get(lockGraphNode);
                if (potentialDeadlockException != null) {
                    policy.a(new PotentialDeadlockException(lockGraphNode, this, potentialDeadlockException.a()));
                    return;
                }
                ExampleStackTrace c2 = lockGraphNode.c(this, Sets.z());
                if (c2 == null) {
                    this.f23161a.put(lockGraphNode, new ExampleStackTrace(lockGraphNode, this));
                    return;
                }
                PotentialDeadlockException potentialDeadlockException2 = new PotentialDeadlockException(lockGraphNode, this, c2);
                this.f23162b.put(lockGraphNode, potentialDeadlockException2);
                policy.a(potentialDeadlockException2);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Policy policy, List<LockGraphNode> list) {
            for (LockGraphNode a2 : list) {
                a(policy, a2);
            }
        }

        /* access modifiers changed from: package-private */
        public String d() {
            return this.f23163c;
        }
    }

    public enum Policies implements Policy {
        THROW {
            public void a(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN {
            public void a(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f23158c.log(Level.SEVERE, "Detected potential deadlock", potentialDeadlockException);
            }
        },
        DISABLED {
            public void a(PotentialDeadlockException potentialDeadlockException) {
            }
        }
    }

    public interface Policy {
        void a(PotentialDeadlockException potentialDeadlockException);
    }

    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace Y;

        private PotentialDeadlockException(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2, ExampleStackTrace exampleStackTrace) {
            super(lockGraphNode, lockGraphNode2);
            this.Y = exampleStackTrace;
            initCause(exampleStackTrace);
        }

        public ExampleStackTrace a() {
            return this.Y;
        }

        public String getMessage() {
            String message = super.getMessage();
            Objects.requireNonNull(message);
            StringBuilder sb = new StringBuilder(message);
            for (Throwable th = this.Y; th != null; th = th.getCause()) {
                sb.append(", ");
                sb.append(th.getMessage());
            }
            return sb.toString();
        }
    }

    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {

        /* renamed from: e  reason: collision with root package name */
        private final Map<E, LockGraphNode> f23164e;

        @VisibleForTesting
        WithExplicitOrdering(Policy policy, Map<E, LockGraphNode> map) {
            super(policy);
            this.f23164e = map;
        }

        public ReentrantLock o(E e2) {
            return p(e2, false);
        }

        public ReentrantLock p(E e2, boolean z) {
            if (this.f23160a == Policies.DISABLED) {
                return new ReentrantLock(z);
            }
            LockGraphNode lockGraphNode = this.f23164e.get(e2);
            Objects.requireNonNull(lockGraphNode);
            return new CycleDetectingReentrantLock(lockGraphNode, z);
        }

        public ReentrantReadWriteLock q(E e2) {
            return r(e2, false);
        }

        public ReentrantReadWriteLock r(E e2, boolean z) {
            if (this.f23160a == Policies.DISABLED) {
                return new ReentrantReadWriteLock(z);
            }
            LockGraphNode lockGraphNode = this.f23164e.get(e2);
            Objects.requireNonNull(lockGraphNode);
            return new CycleDetectingReentrantReadWriteLock(lockGraphNode, z);
        }
    }

    private CycleDetectingLockFactory(Policy policy) {
        this.f23160a = (Policy) Preconditions.E(policy);
    }

    /* access modifiers changed from: private */
    public void a(CycleDetectingLock cycleDetectingLock) {
        if (!cycleDetectingLock.b()) {
            ArrayList arrayList = f23159d.get();
            LockGraphNode a2 = cycleDetectingLock.a();
            a2.b(this.f23160a, arrayList);
            arrayList.add(a2);
        }
    }

    @VisibleForTesting
    static <E extends Enum<E>> Map<E, LockGraphNode> e(Class<E> cls) {
        EnumMap<K, V> W = Maps.W(cls);
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        int length = enumArr.length;
        ArrayList u = Lists.u(length);
        int i2 = 0;
        for (Enum enumR : enumArr) {
            LockGraphNode lockGraphNode = new LockGraphNode(f(enumR));
            u.add(lockGraphNode);
            W.put(enumR, lockGraphNode);
        }
        for (int i3 = 1; i3 < length; i3++) {
            ((LockGraphNode) u.get(i3)).b(Policies.THROW, u.subList(0, i3));
        }
        while (i2 < length - 1) {
            i2++;
            ((LockGraphNode) u.get(i2)).b(Policies.DISABLED, u.subList(i2, length));
        }
        return Collections.unmodifiableMap(W);
    }

    private static String f(Enum<?> enumR) {
        return enumR.getDeclaringClass().getSimpleName() + "." + enumR.name();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, java.lang.Class, java.lang.Class<E>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <E extends java.lang.Enum<E>> java.util.Map<? extends E, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> g(java.lang.Class<E> r2) {
        /*
            java.util.concurrent.ConcurrentMap<java.lang.Class<? extends java.lang.Enum<?>>, java.util.Map<? extends java.lang.Enum<?>, com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode>> r0 = f23157b
            java.lang.Object r1 = r0.get(r2)
            java.util.Map r1 = (java.util.Map) r1
            if (r1 == 0) goto L_0x000b
            return r1
        L_0x000b:
            java.util.Map r1 = e(r2)
            java.lang.Object r2 = r0.putIfAbsent(r2, r1)
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r2 = com.google.common.base.MoreObjects.a(r2, r1)
            java.util.Map r2 = (java.util.Map) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.CycleDetectingLockFactory.g(java.lang.Class):java.util.Map");
    }

    /* access modifiers changed from: private */
    public static void h(CycleDetectingLock cycleDetectingLock) {
        if (!cycleDetectingLock.b()) {
            ArrayList arrayList = f23159d.get();
            LockGraphNode a2 = cycleDetectingLock.a();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size) == a2) {
                    arrayList.remove(size);
                    return;
                }
            }
        }
    }

    public static CycleDetectingLockFactory i(Policy policy) {
        return new CycleDetectingLockFactory(policy);
    }

    public static <E extends Enum<E>> WithExplicitOrdering<E> j(Class<E> cls, Policy policy) {
        Preconditions.E(cls);
        Preconditions.E(policy);
        return new WithExplicitOrdering<>(policy, g(cls));
    }

    public ReentrantLock k(String str) {
        return l(str, false);
    }

    public ReentrantLock l(String str, boolean z) {
        return this.f23160a == Policies.DISABLED ? new ReentrantLock(z) : new CycleDetectingReentrantLock(new LockGraphNode(str), z);
    }

    public ReentrantReadWriteLock m(String str) {
        return n(str, false);
    }

    public ReentrantReadWriteLock n(String str, boolean z) {
        return this.f23160a == Policies.DISABLED ? new ReentrantReadWriteLock(z) : new CycleDetectingReentrantReadWriteLock(new LockGraphNode(str), z);
    }
}
