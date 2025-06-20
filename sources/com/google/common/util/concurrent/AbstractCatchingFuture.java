package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.lang.Throwable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
    @CheckForNull
    ListenableFuture<? extends V> b3;
    @CheckForNull
    Class<X> c3;
    @CheckForNull
    F d3;

    private static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: R */
        public ListenableFuture<? extends V> P(AsyncFunction<? super X, ? extends V> asyncFunction, X x) throws Exception {
            ListenableFuture<? extends V> apply = asyncFunction.apply(x);
            Preconditions.V(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return apply;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: S */
        public void Q(ListenableFuture<? extends V> listenableFuture) {
            D(listenableFuture);
        }
    }

    private static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        /* access modifiers changed from: package-private */
        public void Q(@ParametricNullness V v) {
            B(v);
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        /* renamed from: R */
        public V P(Function<? super X, ? extends V> function, X x) throws Exception {
            return function.apply(x);
        }
    }

    AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f2) {
        this.b3 = (ListenableFuture) Preconditions.E(listenableFuture);
        this.c3 = (Class) Preconditions.E(cls);
        this.d3 = Preconditions.E(f2);
    }

    static <V, X extends Throwable> ListenableFuture<V> N(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, function);
        listenableFuture.a0(catchingFuture, MoreExecutors.p(executor, catchingFuture));
        return catchingFuture;
    }

    static <X extends Throwable, V> ListenableFuture<V> O(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.a0(asyncCatchingFuture, MoreExecutors.p(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    /* access modifiers changed from: package-private */
    @ForOverride
    @ParametricNullness
    public abstract T P(F f2, X x) throws Exception;

    /* access modifiers changed from: package-private */
    @ForOverride
    public abstract void Q(@ParametricNullness T t);

    /* access modifiers changed from: protected */
    public final void m() {
        x(this.b3);
        this.b3 = null;
        this.c3 = null;
        this.d3 = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r8.b3
            java.lang.Class<X> r1 = r8.c3
            F r2 = r8.d3
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L_0x000c
            r5 = 1
            goto L_0x000d
        L_0x000c:
            r5 = 0
        L_0x000d:
            if (r1 != 0) goto L_0x0011
            r6 = 1
            goto L_0x0012
        L_0x0011:
            r6 = 0
        L_0x0012:
            r5 = r5 | r6
            if (r2 != 0) goto L_0x0016
            r3 = 1
        L_0x0016:
            r3 = r3 | r5
            if (r3 != 0) goto L_0x00a5
            boolean r3 = r8.isCancelled()
            if (r3 == 0) goto L_0x0021
            goto L_0x00a5
        L_0x0021:
            r3 = 0
            r8.b3 = r3
            boolean r4 = r0 instanceof com.google.common.util.concurrent.internal.InternalFutureFailureAccess     // Catch:{ ExecutionException -> 0x0034, RuntimeException -> 0x0032, Error -> 0x0030 }
            if (r4 == 0) goto L_0x0036
            r4 = r0
            com.google.common.util.concurrent.internal.InternalFutureFailureAccess r4 = (com.google.common.util.concurrent.internal.InternalFutureFailureAccess) r4     // Catch:{ ExecutionException -> 0x0034, RuntimeException -> 0x0032, Error -> 0x0030 }
            java.lang.Throwable r4 = com.google.common.util.concurrent.internal.InternalFutures.a(r4)     // Catch:{ ExecutionException -> 0x0034, RuntimeException -> 0x0032, Error -> 0x0030 }
            goto L_0x0037
        L_0x0030:
            r4 = move-exception
            goto L_0x003e
        L_0x0032:
            r4 = move-exception
            goto L_0x003e
        L_0x0034:
            r4 = move-exception
            goto L_0x0040
        L_0x0036:
            r4 = r3
        L_0x0037:
            if (r4 != 0) goto L_0x003e
            java.lang.Object r5 = com.google.common.util.concurrent.Futures.j(r0)     // Catch:{ ExecutionException -> 0x0034, RuntimeException -> 0x0032, Error -> 0x0030 }
            goto L_0x0073
        L_0x003e:
            r5 = r3
            goto L_0x0073
        L_0x0040:
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L_0x0071
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Future type "
            r6.append(r7)
            java.lang.Class r7 = r0.getClass()
            r6.append(r7)
            java.lang.String r7 = " threw "
            r6.append(r7)
            java.lang.Class r4 = r4.getClass()
            r6.append(r4)
            java.lang.String r4 = " without a cause"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
        L_0x0071:
            r4 = r5
            goto L_0x003e
        L_0x0073:
            if (r4 != 0) goto L_0x007d
            java.lang.Object r0 = com.google.common.util.concurrent.NullnessCasts.a(r5)
            r8.B(r0)
            return
        L_0x007d:
            boolean r1 = com.google.common.util.concurrent.Platform.a(r4, r1)
            if (r1 != 0) goto L_0x0087
            r8.D(r0)
            return
        L_0x0087:
            java.lang.Object r0 = r8.P(r2, r4)     // Catch:{ all -> 0x0093 }
            r8.c3 = r3
            r8.d3 = r3
            r8.Q(r0)
            return
        L_0x0093:
            r0 = move-exception
            com.google.common.util.concurrent.Platform.b(r0)     // Catch:{ all -> 0x009f }
            r8.C(r0)     // Catch:{ all -> 0x009f }
            r8.c3 = r3
            r8.d3 = r3
            return
        L_0x009f:
            r0 = move-exception
            r8.c3 = r3
            r8.d3 = r3
            throw r0
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractCatchingFuture.run():void");
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public String y() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.b3;
        Class<X> cls = this.c3;
        F f2 = this.d3;
        String y = super.y();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls != null && f2 != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + f2 + "]";
        } else if (y == null) {
            return null;
        } else {
            return str + y;
        }
    }
}
