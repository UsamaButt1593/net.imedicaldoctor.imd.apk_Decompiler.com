package com.google.common.util.concurrent;

import androidx.lifecycle.g;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Functions;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Closeable;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@DoNotMock("Use ClosingFuture.from(Futures.immediate*Future)")
public final class ClosingFuture<V> {

    /* renamed from: d  reason: collision with root package name */
    private static final Logger f23099d = Logger.getLogger(ClosingFuture.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<State> f23100a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final CloseableList f23101b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final FluentFuture<V> f23102c;

    /* renamed from: com.google.common.util.concurrent.ClosingFuture$11  reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23105a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.common.util.concurrent.ClosingFuture$State[] r0 = com.google.common.util.concurrent.ClosingFuture.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23105a = r0
                com.google.common.util.concurrent.ClosingFuture$State r1 = com.google.common.util.concurrent.ClosingFuture.State.SUBSUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23105a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.util.concurrent.ClosingFuture$State r1 = com.google.common.util.concurrent.ClosingFuture.State.WILL_CREATE_VALUE_AND_CLOSER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23105a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.common.util.concurrent.ClosingFuture$State r1 = com.google.common.util.concurrent.ClosingFuture.State.WILL_CLOSE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23105a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.common.util.concurrent.ClosingFuture$State r1 = com.google.common.util.concurrent.ClosingFuture.State.CLOSING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f23105a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.common.util.concurrent.ClosingFuture$State r1 = com.google.common.util.concurrent.ClosingFuture.State.CLOSED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f23105a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.common.util.concurrent.ClosingFuture$State r1 = com.google.common.util.concurrent.ClosingFuture.State.OPEN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ClosingFuture.AnonymousClass11.<clinit>():void");
        }
    }

    public interface AsyncClosingCallable<V> {
        ClosingFuture<V> a(DeferredCloser deferredCloser) throws Exception;
    }

    public interface AsyncClosingFunction<T, U> {
        ClosingFuture<U> a(DeferredCloser deferredCloser, @ParametricNullness T t) throws Exception;
    }

    private static final class CloseableList extends IdentityHashMap<Closeable, Executor> implements Closeable {
        private volatile boolean X;
        @CheckForNull
        private volatile CountDownLatch Y;
        /* access modifiers changed from: private */
        public final DeferredCloser s;

        private CloseableList() {
            this.s = new DeferredCloser(this);
        }

        /* access modifiers changed from: package-private */
        public void c(@CheckForNull Closeable closeable, Executor executor) {
            Preconditions.E(executor);
            if (closeable != null) {
                synchronized (this) {
                    try {
                        if (!this.X) {
                            put(closeable, executor);
                        } else {
                            ClosingFuture.q(closeable, executor);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0012, code lost:
            r0 = entrySet().iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
            if (r0.hasNext() == false) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
            r1 = (java.util.Map.Entry) r0.next();
            com.google.common.util.concurrent.ClosingFuture.h((java.io.Closeable) r1.getKey(), (java.util.concurrent.Executor) r1.getValue());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
            clear();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
            if (r3.Y == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
            r3.Y.countDown();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r3 = this;
                boolean r0 = r3.X
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r3)
                boolean r0 = r3.X     // Catch:{ all -> 0x000c }
                if (r0 == 0) goto L_0x000e
                monitor-exit(r3)     // Catch:{ all -> 0x000c }
                return
            L_0x000c:
                r0 = move-exception
                goto L_0x0043
            L_0x000e:
                r0 = 1
                r3.X = r0     // Catch:{ all -> 0x000c }
                monitor-exit(r3)     // Catch:{ all -> 0x000c }
                java.util.Set r0 = r3.entrySet()
                java.util.Iterator r0 = r0.iterator()
            L_0x001a:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0036
                java.lang.Object r1 = r0.next()
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                java.lang.Object r2 = r1.getKey()
                java.io.Closeable r2 = (java.io.Closeable) r2
                java.lang.Object r1 = r1.getValue()
                java.util.concurrent.Executor r1 = (java.util.concurrent.Executor) r1
                com.google.common.util.concurrent.ClosingFuture.q(r2, r1)
                goto L_0x001a
            L_0x0036:
                r3.clear()
                java.util.concurrent.CountDownLatch r0 = r3.Y
                if (r0 == 0) goto L_0x0042
                java.util.concurrent.CountDownLatch r0 = r3.Y
                r0.countDown()
            L_0x0042:
                return
            L_0x0043:
                monitor-exit(r3)     // Catch:{ all -> 0x000c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ClosingFuture.CloseableList.close():void");
        }

        /* access modifiers changed from: package-private */
        public <V, U> FluentFuture<U> d(AsyncClosingFunction<V, U> asyncClosingFunction, @ParametricNullness V v) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                ClosingFuture<U> a2 = asyncClosingFunction.a(closeableList.s, v);
                a2.i(closeableList);
                return a2.f23102c;
            } finally {
                c(closeableList, MoreExecutors.c());
            }
        }

        /* access modifiers changed from: package-private */
        public <V, U> ListenableFuture<U> e(ClosingFunction<? super V, U> closingFunction, @ParametricNullness V v) throws Exception {
            CloseableList closeableList = new CloseableList();
            try {
                return Futures.o(closingFunction.a(closeableList.s, v));
            } finally {
                c(closeableList, MoreExecutors.c());
            }
        }

        /* access modifiers changed from: package-private */
        public CountDownLatch f() {
            boolean z = false;
            if (this.X) {
                return new CountDownLatch(0);
            }
            synchronized (this) {
                try {
                    if (this.X) {
                        CountDownLatch countDownLatch = new CountDownLatch(0);
                        return countDownLatch;
                    }
                    if (this.Y == null) {
                        z = true;
                    }
                    Preconditions.g0(z);
                    CountDownLatch countDownLatch2 = new CountDownLatch(1);
                    this.Y = countDownLatch2;
                    return countDownLatch2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public interface ClosingCallable<V> {
        @ParametricNullness
        V a(DeferredCloser deferredCloser) throws Exception;
    }

    public interface ClosingFunction<T, U> {
        @ParametricNullness
        U a(DeferredCloser deferredCloser, @ParametricNullness T t) throws Exception;
    }

    @DoNotMock("Use ClosingFuture.whenAllSucceed() or .whenAllComplete() instead.")
    public static class Combiner {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final CloseableList f23117a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f23118b;

        /* renamed from: c  reason: collision with root package name */
        protected final ImmutableList<ClosingFuture<?>> f23119c;

        public interface AsyncCombiningCallable<V> {
            ClosingFuture<V> a(DeferredCloser deferredCloser, Peeker peeker) throws Exception;
        }

        public interface CombiningCallable<V> {
            @ParametricNullness
            V a(DeferredCloser deferredCloser, Peeker peeker) throws Exception;
        }

        private Combiner(boolean z, Iterable<? extends ClosingFuture<?>> iterable) {
            this.f23117a = new CloseableList();
            this.f23118b = z;
            this.f23119c = ImmutableList.z(iterable);
            for (ClosingFuture d2 : iterable) {
                d2.i(this.f23117a);
            }
        }

        private Futures.FutureCombiner<Object> e() {
            return this.f23118b ? Futures.F(f()) : Futures.D(f());
        }

        private ImmutableList<FluentFuture<?>> f() {
            return FluentIterable.D(this.f23119c).Y(new r()).R();
        }

        public <V> ClosingFuture<V> c(final CombiningCallable<V> combiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>((ListenableFuture) e().a(new Callable<V>() {
                @ParametricNullness
                public V call() throws Exception {
                    return new Peeker(Combiner.this.f23119c).c(combiningCallable, Combiner.this.f23117a);
                }

                public String toString() {
                    return combiningCallable.toString();
                }
            }, executor));
            closingFuture.f23101b.c(this.f23117a, MoreExecutors.c());
            return closingFuture;
        }

        public <V> ClosingFuture<V> d(final AsyncCombiningCallable<V> asyncCombiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>((ListenableFuture) e().b(new AsyncCallable<V>() {
                public ListenableFuture<V> call() throws Exception {
                    return new Peeker(Combiner.this.f23119c).d(asyncCombiningCallable, Combiner.this.f23117a);
                }

                public String toString() {
                    return asyncCombiningCallable.toString();
                }
            }, executor));
            closingFuture.f23101b.c(this.f23117a, MoreExecutors.c());
            return closingFuture;
        }
    }

    public static final class Combiner2<V1, V2> extends Combiner {
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final ClosingFuture<V1> f23122d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final ClosingFuture<V2> f23123e;

        public interface AsyncClosingFunction2<V1, V2, U> {
            ClosingFuture<U> a(DeferredCloser deferredCloser, @ParametricNullness V1 v1, @ParametricNullness V2 v2) throws Exception;
        }

        public interface ClosingFunction2<V1, V2, U> {
            @ParametricNullness
            U a(DeferredCloser deferredCloser, @ParametricNullness V1 v1, @ParametricNullness V2 v2) throws Exception;
        }

        private Combiner2(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
            super(true, ImmutableList.L(closingFuture, closingFuture2));
            this.f23122d = closingFuture;
            this.f23123e = closingFuture2;
        }

        public <U> ClosingFuture<U> j(final ClosingFunction2<V1, V2, U> closingFunction2, Executor executor) {
            return c(new Combiner.CombiningCallable<U>() {
                @ParametricNullness
                public U a(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return closingFunction2.a(deferredCloser, peeker.e(Combiner2.this.f23122d), peeker.e(Combiner2.this.f23123e));
                }

                public String toString() {
                    return closingFunction2.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> k(final AsyncClosingFunction2<V1, V2, U> asyncClosingFunction2, Executor executor) {
            return d(new Combiner.AsyncCombiningCallable<U>() {
                public ClosingFuture<U> a(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction2.a(deferredCloser, peeker.e(Combiner2.this.f23122d), peeker.e(Combiner2.this.f23123e));
                }

                public String toString() {
                    return asyncClosingFunction2.toString();
                }
            }, executor);
        }
    }

    public static final class Combiner3<V1, V2, V3> extends Combiner {
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final ClosingFuture<V1> f23128d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final ClosingFuture<V2> f23129e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final ClosingFuture<V3> f23130f;

        public interface AsyncClosingFunction3<V1, V2, V3, U> {
            ClosingFuture<U> a(DeferredCloser deferredCloser, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3) throws Exception;
        }

        public interface ClosingFunction3<V1, V2, V3, U> {
            @ParametricNullness
            U a(DeferredCloser deferredCloser, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3) throws Exception;
        }

        private Combiner3(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
            super(true, ImmutableList.M(closingFuture, closingFuture2, closingFuture3));
            this.f23128d = closingFuture;
            this.f23129e = closingFuture2;
            this.f23130f = closingFuture3;
        }

        public <U> ClosingFuture<U> k(final ClosingFunction3<V1, V2, V3, U> closingFunction3, Executor executor) {
            return c(new Combiner.CombiningCallable<U>() {
                @ParametricNullness
                public U a(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return closingFunction3.a(deferredCloser, peeker.e(Combiner3.this.f23128d), peeker.e(Combiner3.this.f23129e), peeker.e(Combiner3.this.f23130f));
                }

                public String toString() {
                    return closingFunction3.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> l(final AsyncClosingFunction3<V1, V2, V3, U> asyncClosingFunction3, Executor executor) {
            return d(new Combiner.AsyncCombiningCallable<U>() {
                public ClosingFuture<U> a(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction3.a(deferredCloser, peeker.e(Combiner3.this.f23128d), peeker.e(Combiner3.this.f23129e), peeker.e(Combiner3.this.f23130f));
                }

                public String toString() {
                    return asyncClosingFunction3.toString();
                }
            }, executor);
        }
    }

    public static final class Combiner4<V1, V2, V3, V4> extends Combiner {
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final ClosingFuture<V1> f23135d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final ClosingFuture<V2> f23136e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final ClosingFuture<V3> f23137f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final ClosingFuture<V4> f23138g;

        public interface AsyncClosingFunction4<V1, V2, V3, V4, U> {
            ClosingFuture<U> a(DeferredCloser deferredCloser, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3, @ParametricNullness V4 v4) throws Exception;
        }

        public interface ClosingFunction4<V1, V2, V3, V4, U> {
            @ParametricNullness
            U a(DeferredCloser deferredCloser, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3, @ParametricNullness V4 v4) throws Exception;
        }

        private Combiner4(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
            super(true, ImmutableList.N(closingFuture, closingFuture2, closingFuture3, closingFuture4));
            this.f23135d = closingFuture;
            this.f23136e = closingFuture2;
            this.f23137f = closingFuture3;
            this.f23138g = closingFuture4;
        }

        public <U> ClosingFuture<U> l(final ClosingFunction4<V1, V2, V3, V4, U> closingFunction4, Executor executor) {
            return c(new Combiner.CombiningCallable<U>() {
                @ParametricNullness
                public U a(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return closingFunction4.a(deferredCloser, peeker.e(Combiner4.this.f23135d), peeker.e(Combiner4.this.f23136e), peeker.e(Combiner4.this.f23137f), peeker.e(Combiner4.this.f23138g));
                }

                public String toString() {
                    return closingFunction4.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> m(final AsyncClosingFunction4<V1, V2, V3, V4, U> asyncClosingFunction4, Executor executor) {
            return d(new Combiner.AsyncCombiningCallable<U>() {
                public ClosingFuture<U> a(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction4.a(deferredCloser, peeker.e(Combiner4.this.f23135d), peeker.e(Combiner4.this.f23136e), peeker.e(Combiner4.this.f23137f), peeker.e(Combiner4.this.f23138g));
                }

                public String toString() {
                    return asyncClosingFunction4.toString();
                }
            }, executor);
        }
    }

    public static final class Combiner5<V1, V2, V3, V4, V5> extends Combiner {
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final ClosingFuture<V1> f23143d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final ClosingFuture<V2> f23144e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final ClosingFuture<V3> f23145f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final ClosingFuture<V4> f23146g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public final ClosingFuture<V5> f23147h;

        public interface AsyncClosingFunction5<V1, V2, V3, V4, V5, U> {
            ClosingFuture<U> a(DeferredCloser deferredCloser, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3, @ParametricNullness V4 v4, @ParametricNullness V5 v5) throws Exception;
        }

        public interface ClosingFunction5<V1, V2, V3, V4, V5, U> {
            @ParametricNullness
            U a(DeferredCloser deferredCloser, @ParametricNullness V1 v1, @ParametricNullness V2 v2, @ParametricNullness V3 v3, @ParametricNullness V4 v4, @ParametricNullness V5 v5) throws Exception;
        }

        private Combiner5(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
            super(true, ImmutableList.O(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5));
            this.f23143d = closingFuture;
            this.f23144e = closingFuture2;
            this.f23145f = closingFuture3;
            this.f23146g = closingFuture4;
            this.f23147h = closingFuture5;
        }

        public <U> ClosingFuture<U> m(final ClosingFunction5<V1, V2, V3, V4, V5, U> closingFunction5, Executor executor) {
            return c(new Combiner.CombiningCallable<U>() {
                @ParametricNullness
                public U a(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return closingFunction5.a(deferredCloser, peeker.e(Combiner5.this.f23143d), peeker.e(Combiner5.this.f23144e), peeker.e(Combiner5.this.f23145f), peeker.e(Combiner5.this.f23146g), peeker.e(Combiner5.this.f23147h));
                }

                public String toString() {
                    return closingFunction5.toString();
                }
            }, executor);
        }

        public <U> ClosingFuture<U> n(final AsyncClosingFunction5<V1, V2, V3, V4, V5, U> asyncClosingFunction5, Executor executor) {
            return d(new Combiner.AsyncCombiningCallable<U>() {
                public ClosingFuture<U> a(DeferredCloser deferredCloser, Peeker peeker) throws Exception {
                    return asyncClosingFunction5.a(deferredCloser, peeker.e(Combiner5.this.f23143d), peeker.e(Combiner5.this.f23144e), peeker.e(Combiner5.this.f23145f), peeker.e(Combiner5.this.f23146g), peeker.e(Combiner5.this.f23147h));
                }

                public String toString() {
                    return asyncClosingFunction5.toString();
                }
            }, executor);
        }
    }

    public static final class DeferredCloser {
        @RetainedWith

        /* renamed from: a  reason: collision with root package name */
        private final CloseableList f23152a;

        DeferredCloser(CloseableList closeableList) {
            this.f23152a = closeableList;
        }

        @CanIgnoreReturnValue
        @ParametricNullness
        public <C extends Closeable> C a(@ParametricNullness C c2, Executor executor) {
            Preconditions.E(executor);
            if (c2 != null) {
                this.f23152a.c((Closeable) c2, executor);
            }
            return c2;
        }
    }

    public static final class Peeker {

        /* renamed from: a  reason: collision with root package name */
        private final ImmutableList<ClosingFuture<?>> f23153a;

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f23154b;

        private Peeker(ImmutableList<ClosingFuture<?>> immutableList) {
            this.f23153a = (ImmutableList) Preconditions.E(immutableList);
        }

        /* access modifiers changed from: private */
        @ParametricNullness
        public <V> V c(Combiner.CombiningCallable<V> combiningCallable, CloseableList closeableList) throws Exception {
            this.f23154b = true;
            CloseableList closeableList2 = new CloseableList();
            try {
                return combiningCallable.a(closeableList2.s, this);
            } finally {
                closeableList.c(closeableList2, MoreExecutors.c());
                this.f23154b = false;
            }
        }

        /* access modifiers changed from: private */
        public <V> FluentFuture<V> d(Combiner.AsyncCombiningCallable<V> asyncCombiningCallable, CloseableList closeableList) throws Exception {
            this.f23154b = true;
            CloseableList closeableList2 = new CloseableList();
            try {
                ClosingFuture<V> a2 = asyncCombiningCallable.a(closeableList2.s, this);
                a2.i(closeableList);
                return a2.f23102c;
            } finally {
                closeableList.c(closeableList2, MoreExecutors.c());
                this.f23154b = false;
            }
        }

        @ParametricNullness
        public final <D> D e(ClosingFuture<D> closingFuture) throws ExecutionException {
            Preconditions.g0(this.f23154b);
            Preconditions.d(this.f23153a.contains(closingFuture));
            return Futures.j(closingFuture.f23102c);
        }
    }

    enum State {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    public static final class ValueAndCloser<V> {

        /* renamed from: a  reason: collision with root package name */
        private final ClosingFuture<? extends V> f23155a;

        ValueAndCloser(ClosingFuture<? extends V> closingFuture) {
            this.f23155a = (ClosingFuture) Preconditions.E(closingFuture);
        }

        public void a() {
            this.f23155a.p();
        }

        @ParametricNullness
        public V b() throws ExecutionException {
            return Futures.j(this.f23155a.f23102c);
        }
    }

    public interface ValueAndCloserConsumer<V> {
        void a(ValueAndCloser<V> valueAndCloser);
    }

    private ClosingFuture(final AsyncClosingCallable<V> asyncClosingCallable, Executor executor) {
        this.f23100a = new AtomicReference<>(State.OPEN);
        this.f23101b = new CloseableList();
        Preconditions.E(asyncClosingCallable);
        TrustedListenableFutureTask N = TrustedListenableFutureTask.N(new AsyncCallable<V>() {
            public ListenableFuture<V> call() throws Exception {
                CloseableList closeableList = new CloseableList();
                try {
                    ClosingFuture a2 = asyncClosingCallable.a(closeableList.s);
                    a2.i(ClosingFuture.this.f23101b);
                    return a2.f23102c;
                } finally {
                    ClosingFuture.this.f23101b.c(closeableList, MoreExecutors.c());
                }
            }

            public String toString() {
                return asyncClosingCallable.toString();
            }
        });
        executor.execute(N);
        this.f23102c = N;
    }

    public static <V> ClosingFuture<V> A(ClosingCallable<V> closingCallable, Executor executor) {
        return new ClosingFuture<>(closingCallable, executor);
    }

    public static <V> ClosingFuture<V> B(AsyncClosingCallable<V> asyncClosingCallable, Executor executor) {
        return new ClosingFuture<>(asyncClosingCallable, executor);
    }

    public static Combiner E(ClosingFuture<?> closingFuture, ClosingFuture<?>... closingFutureArr) {
        return F(Lists.c(closingFuture, closingFutureArr));
    }

    public static Combiner F(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(false, iterable);
    }

    public static <V1, V2> Combiner2<V1, V2> G(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
        return new Combiner2<>(closingFuture2);
    }

    public static <V1, V2, V3> Combiner3<V1, V2, V3> H(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
        return new Combiner3<>(closingFuture2, closingFuture3);
    }

    public static <V1, V2, V3, V4> Combiner4<V1, V2, V3, V4> I(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
        return new Combiner4(closingFuture2, closingFuture3, closingFuture4);
    }

    public static <V1, V2, V3, V4, V5> Combiner5<V1, V2, V3, V4, V5> J(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
        return new Combiner5(closingFuture2, closingFuture3, closingFuture4, closingFuture5);
    }

    public static Combiner K(ClosingFuture<?> closingFuture, ClosingFuture<?> closingFuture2, ClosingFuture<?> closingFuture3, ClosingFuture<?> closingFuture4, ClosingFuture<?> closingFuture5, ClosingFuture<?> closingFuture6, ClosingFuture<?>... closingFutureArr) {
        return L(FluentIterable.N(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5, closingFuture6).g(closingFutureArr));
    }

    public static Combiner L(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(true, iterable);
    }

    public static <V, U> AsyncClosingFunction<V, U> N(final AsyncFunction<V, U> asyncFunction) {
        Preconditions.E(asyncFunction);
        return new AsyncClosingFunction<V, U>() {
            public ClosingFuture<U> a(DeferredCloser deferredCloser, V v) throws Exception {
                return ClosingFuture.w(AsyncFunction.this.apply(v));
            }
        };
    }

    /* access modifiers changed from: private */
    public void i(CloseableList closeableList) {
        o(State.OPEN, State.SUBSUMED);
        closeableList.c(this.f23101b, MoreExecutors.c());
    }

    private <X extends Throwable, W extends V> ClosingFuture<V> m(Class<X> cls, final AsyncClosingFunction<? super X, W> asyncClosingFunction, Executor executor) {
        Preconditions.E(asyncClosingFunction);
        return s(this.f23102c.H(cls, new AsyncFunction<X, W>() {
            /* renamed from: a */
            public ListenableFuture<W> apply(X x) throws Exception {
                return ClosingFuture.this.f23101b.d(asyncClosingFunction, x);
            }

            public String toString() {
                return asyncClosingFunction.toString();
            }
        }, executor));
    }

    private <X extends Throwable, W extends V> ClosingFuture<V> n(Class<X> cls, final ClosingFunction<? super X, W> closingFunction, Executor executor) {
        Preconditions.E(closingFunction);
        return s(this.f23102c.H(cls, new AsyncFunction<X, W>() {
            /* renamed from: a */
            public ListenableFuture<W> apply(X x) throws Exception {
                return ClosingFuture.this.f23101b.e(closingFunction, x);
            }

            public String toString() {
                return closingFunction.toString();
            }
        }, executor));
    }

    /* access modifiers changed from: private */
    public void o(State state, State state2) {
        Preconditions.B0(r(state, state2), "Expected state to be %s, but it was %s", state, state2);
    }

    /* access modifiers changed from: private */
    public void p() {
        f23099d.log(Level.FINER, "closing {0}", this);
        this.f23101b.close();
    }

    /* access modifiers changed from: private */
    public static void q(@CheckForNull Closeable closeable, Executor executor) {
        if (closeable != null) {
            try {
                executor.execute(new q(closeable));
            } catch (RejectedExecutionException e2) {
                Logger logger = f23099d;
                Level level = Level.WARNING;
                if (logger.isLoggable(level)) {
                    logger.log(level, String.format("while submitting close to %s; will close inline", new Object[]{executor}), e2);
                }
                q(closeable, MoreExecutors.c());
            }
        }
    }

    private boolean r(State state, State state2) {
        return g.a(this.f23100a, state, state2);
    }

    private <U> ClosingFuture<U> s(FluentFuture<U> fluentFuture) {
        ClosingFuture<U> closingFuture = new ClosingFuture<>(fluentFuture);
        i(closingFuture.f23101b);
        return closingFuture;
    }

    @Deprecated
    public static <C extends Closeable> ClosingFuture<C> t(ListenableFuture<C> listenableFuture, final Executor executor) {
        Preconditions.E(executor);
        ClosingFuture<C> closingFuture = new ClosingFuture<>(Futures.u(listenableFuture));
        Futures.c(listenableFuture, new FutureCallback<Closeable>() {
            public void b(Throwable th) {
            }

            /* renamed from: c */
            public void a(@CheckForNull Closeable closeable) {
                ClosingFuture.this.f23101b.s.a(closeable, executor);
            }
        }, MoreExecutors.c());
        return closingFuture;
    }

    public static <V> ClosingFuture<V> w(ListenableFuture<V> listenableFuture) {
        return new ClosingFuture<>(listenableFuture);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void x(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException | RuntimeException e2) {
            f23099d.log(Level.WARNING, "thrown by close()", e2);
        }
    }

    /* access modifiers changed from: private */
    public static <C, V extends C> void y(ValueAndCloserConsumer<C> valueAndCloserConsumer, ClosingFuture<V> closingFuture) {
        valueAndCloserConsumer.a(new ValueAndCloser(closingFuture));
    }

    public <U> ClosingFuture<U> C(final ClosingFunction<? super V, U> closingFunction, Executor executor) {
        Preconditions.E(closingFunction);
        return s(this.f23102c.L(new AsyncFunction<V, U>() {
            public ListenableFuture<U> apply(V v) throws Exception {
                return ClosingFuture.this.f23101b.e(closingFunction, v);
            }

            public String toString() {
                return closingFunction.toString();
            }
        }, executor));
    }

    public <U> ClosingFuture<U> D(final AsyncClosingFunction<? super V, U> asyncClosingFunction, Executor executor) {
        Preconditions.E(asyncClosingFunction);
        return s(this.f23102c.L(new AsyncFunction<V, U>() {
            public ListenableFuture<U> apply(V v) throws Exception {
                return ClosingFuture.this.f23101b.d(asyncClosingFunction, v);
            }

            public String toString() {
                return asyncClosingFunction.toString();
            }
        }, executor));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public CountDownLatch M() {
        return this.f23101b.f();
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.f23100a.get().equals(State.OPEN)) {
            f23099d.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            u();
        }
    }

    @CanIgnoreReturnValue
    public boolean j(boolean z) {
        f23099d.log(Level.FINER, "cancelling {0}", this);
        boolean cancel = this.f23102c.cancel(z);
        if (cancel) {
            p();
        }
        return cancel;
    }

    public <X extends Throwable> ClosingFuture<V> k(Class<X> cls, ClosingFunction<? super X, ? extends V> closingFunction, Executor executor) {
        return n(cls, closingFunction, executor);
    }

    public <X extends Throwable> ClosingFuture<V> l(Class<X> cls, AsyncClosingFunction<? super X, ? extends V> asyncClosingFunction, Executor executor) {
        return m(cls, asyncClosingFunction, executor);
    }

    public String toString() {
        return MoreObjects.c(this).f("state", this.f23100a.get()).s(this.f23102c).toString();
    }

    public FluentFuture<V> u() {
        if (r(State.OPEN, State.WILL_CLOSE)) {
            f23099d.log(Level.FINER, "will close {0}", this);
            this.f23102c.a0(new Runnable() {
                public void run() {
                    ClosingFuture closingFuture = ClosingFuture.this;
                    State state = State.WILL_CLOSE;
                    State state2 = State.CLOSING;
                    closingFuture.o(state, state2);
                    ClosingFuture.this.p();
                    ClosingFuture.this.o(state2, State.CLOSED);
                }
            }, MoreExecutors.c());
        } else {
            switch (AnonymousClass11.f23105a[this.f23100a.get().ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
                case 2:
                    throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
                case 3:
                case 4:
                case 5:
                    throw new IllegalStateException("Cannot call finishToFuture() twice");
                case 6:
                    throw new AssertionError();
            }
        }
        return this.f23102c;
    }

    public void v(final ValueAndCloserConsumer<? super V> valueAndCloserConsumer, Executor executor) {
        Preconditions.E(valueAndCloserConsumer);
        if (!r(State.OPEN, State.WILL_CREATE_VALUE_AND_CLOSER)) {
            int i2 = AnonymousClass11.f23105a[this.f23100a.get().ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
            } else if (i2 == 2) {
                throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
            } else if (i2 == 3 || i2 == 4 || i2 == 5) {
                throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
            } else {
                throw new AssertionError(this.f23100a);
            }
        } else {
            this.f23102c.a0(new Runnable() {
                public void run() {
                    ClosingFuture.y(valueAndCloserConsumer, ClosingFuture.this);
                }
            }, executor);
        }
    }

    public ListenableFuture<?> z() {
        return Futures.u(this.f23102c.K(Functions.b(null), MoreExecutors.c()));
    }

    private ClosingFuture(final ClosingCallable<V> closingCallable, Executor executor) {
        this.f23100a = new AtomicReference<>(State.OPEN);
        this.f23101b = new CloseableList();
        Preconditions.E(closingCallable);
        TrustedListenableFutureTask P = TrustedListenableFutureTask.P(new Callable<V>() {
            @ParametricNullness
            public V call() throws Exception {
                return closingCallable.a(ClosingFuture.this.f23101b.s);
            }

            public String toString() {
                return closingCallable.toString();
            }
        });
        executor.execute(P);
        this.f23102c = P;
    }

    private ClosingFuture(ListenableFuture<V> listenableFuture) {
        this.f23100a = new AtomicReference<>(State.OPEN);
        this.f23101b = new CloseableList();
        this.f23102c = FluentFuture.J(listenableFuture);
    }
}
