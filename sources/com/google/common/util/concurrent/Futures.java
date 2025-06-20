package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.Partially;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Futures extends GwtFuturesCatchingSpecialization {

    private static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> X;
        final Future<V> s;

        CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.s = future;
            this.X = futureCallback;
        }

        public void run() {
            Throwable a2;
            Future<V> future = this.s;
            if (!(future instanceof InternalFutureFailureAccess) || (a2 = InternalFutures.a((InternalFutureFailureAccess) future)) == null) {
                try {
                    this.X.a(Futures.j(this.s));
                } catch (ExecutionException e2) {
                    this.X.b(e2.getCause());
                } catch (Error | RuntimeException e3) {
                    this.X.b(e3);
                }
            } else {
                this.X.b(a2);
            }
        }

        public String toString() {
            return MoreObjects.c(this).s(this.X).toString();
        }
    }

    @GwtCompatible
    public static final class FutureCombiner<V> {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f23179a;

        /* renamed from: b  reason: collision with root package name */
        private final ImmutableList<ListenableFuture<? extends V>> f23180b;

        private FutureCombiner(boolean z, ImmutableList<ListenableFuture<? extends V>> immutableList) {
            this.f23179a = z;
            this.f23180b = immutableList;
        }

        public <C> ListenableFuture<C> a(Callable<C> callable, Executor executor) {
            return new CombinedFuture((ImmutableCollection<? extends ListenableFuture<?>>) this.f23180b, this.f23179a, executor, callable);
        }

        public <C> ListenableFuture<C> b(AsyncCallable<C> asyncCallable, Executor executor) {
            return new CombinedFuture((ImmutableCollection<? extends ListenableFuture<?>>) this.f23180b, this.f23179a, executor, asyncCallable);
        }

        public ListenableFuture<?> c(final Runnable runnable, Executor executor) {
            return a(new Callable<Void>(this) {
                @CheckForNull
                /* renamed from: a */
                public Void call() throws Exception {
                    runnable.run();
                    return null;
                }
            }, executor);
        }
    }

    private static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {
        @CheckForNull
        private InCompletionOrderState<T> b3;

        private InCompletionOrderFuture(InCompletionOrderState<T> inCompletionOrderState) {
            this.b3 = inCompletionOrderState;
        }

        public boolean cancel(boolean z) {
            InCompletionOrderState<T> inCompletionOrderState = this.b3;
            if (!super.cancel(z)) {
                return false;
            }
            Objects.requireNonNull(inCompletionOrderState);
            inCompletionOrderState.g(z);
            return true;
        }

        /* access modifiers changed from: protected */
        public void m() {
            this.b3 = null;
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public String y() {
            InCompletionOrderState<T> inCompletionOrderState = this.b3;
            if (inCompletionOrderState == null) {
                return null;
            }
            return "inputCount=[" + inCompletionOrderState.f23184d.length + "], remaining=[" + inCompletionOrderState.f23183c.get() + "]";
        }
    }

    private static final class InCompletionOrderState<T> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f23181a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f23182b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f23183c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final ListenableFuture<? extends T>[] f23184d;

        /* renamed from: e  reason: collision with root package name */
        private volatile int f23185e;

        private InCompletionOrderState(ListenableFuture<? extends T>[] listenableFutureArr) {
            this.f23181a = false;
            this.f23182b = true;
            this.f23185e = 0;
            this.f23184d = listenableFutureArr;
            this.f23183c = new AtomicInteger(listenableFutureArr.length);
        }

        private void e() {
            if (this.f23183c.decrementAndGet() == 0 && this.f23181a) {
                for (ListenableFuture<? extends T> listenableFuture : this.f23184d) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.f23182b);
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void f(ImmutableList<AbstractFuture<T>> immutableList, int i2) {
            ListenableFuture<? extends T> listenableFuture = this.f23184d[i2];
            Objects.requireNonNull(listenableFuture);
            ListenableFuture listenableFuture2 = listenableFuture;
            this.f23184d[i2] = null;
            for (int i3 = this.f23185e; i3 < immutableList.size(); i3++) {
                if (immutableList.get(i3).D(listenableFuture2)) {
                    e();
                    this.f23185e = i3 + 1;
                    return;
                }
            }
            this.f23185e = immutableList.size();
        }

        /* access modifiers changed from: private */
        public void g(boolean z) {
            this.f23181a = true;
            if (!z) {
                this.f23182b = false;
            }
            e();
        }
    }

    private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {
        @CheckForNull
        private ListenableFuture<V> b3;

        NonCancellationPropagatingFuture(ListenableFuture<V> listenableFuture) {
            this.b3 = listenableFuture;
        }

        /* access modifiers changed from: protected */
        public void m() {
            this.b3 = null;
        }

        public void run() {
            ListenableFuture<V> listenableFuture = this.b3;
            if (listenableFuture != null) {
                D(listenableFuture);
            }
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public String y() {
            ListenableFuture<V> listenableFuture = this.b3;
            if (listenableFuture == null) {
                return null;
            }
            return "delegate=[" + listenableFuture + "]";
        }
    }

    private Futures() {
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> A(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(ImmutableList.D(listenableFutureArr), false);
    }

    public static <I, O> ListenableFuture<O> B(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.N(listenableFuture, function, executor);
    }

    public static <I, O> ListenableFuture<O> C(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        return AbstractTransformFuture.O(listenableFuture, asyncFunction, executor);
    }

    public static <V> FutureCombiner<V> D(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(false, ImmutableList.z(iterable));
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> E(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(false, ImmutableList.D(listenableFutureArr));
    }

    public static <V> FutureCombiner<V> F(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(true, ImmutableList.z(iterable));
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> G(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(true, ImmutableList.D(listenableFutureArr));
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <V> ListenableFuture<V> H(ListenableFuture<V> listenableFuture, long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : TimeoutFuture.Q(listenableFuture, j2, timeUnit, scheduledExecutorService);
    }

    private static void I(Throwable th) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        throw new UncheckedExecutionException(th);
    }

    public static <V> void c(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.E(futureCallback);
        listenableFuture.a0(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    public static <V> ListenableFuture<List<V>> d(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(ImmutableList.z(iterable), true);
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> e(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.ListFuture(ImmutableList.D(listenableFutureArr), true);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @J2ktIncompatible
    public static <V, X extends Throwable> ListenableFuture<V> f(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return AbstractCatchingFuture.N(listenableFuture, cls, function, executor);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @J2ktIncompatible
    public static <V, X extends Throwable> ListenableFuture<V> g(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return AbstractCatchingFuture.O(listenableFuture, cls, asyncFunction, executor);
    }

    @J2ktIncompatible
    @GwtIncompatible
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V, X extends Exception> V h(Future<V> future, Class<X> cls) throws Exception {
        return FuturesGetChecked.g(future, cls);
    }

    @J2ktIncompatible
    @GwtIncompatible
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V, X extends Exception> V i(Future<V> future, Class<X> cls, long j2, TimeUnit timeUnit) throws Exception {
        return FuturesGetChecked.h(future, cls, j2, timeUnit);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V> V j(Future<V> future) throws ExecutionException {
        Preconditions.x0(future.isDone(), "Future was expected to be done: %s", future);
        return Uninterruptibles.f(future);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V> V k(Future<V> future) {
        Preconditions.E(future);
        try {
            return Uninterruptibles.f(future);
        } catch (ExecutionException e2) {
            I(e2.getCause());
            throw new AssertionError();
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends T>>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.google.common.util.concurrent.ListenableFuture<? extends T>[] l(java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends T>> r1) {
        /*
            boolean r0 = r1 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0007
            java.util.Collection r1 = (java.util.Collection) r1
            goto L_0x000b
        L_0x0007:
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.z(r1)
        L_0x000b:
            r0 = 0
            com.google.common.util.concurrent.ListenableFuture[] r0 = new com.google.common.util.concurrent.ListenableFuture[r0]
            java.lang.Object[] r1 = r1.toArray(r0)
            com.google.common.util.concurrent.ListenableFuture[] r1 = (com.google.common.util.concurrent.ListenableFuture[]) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Futures.l(java.lang.Iterable):com.google.common.util.concurrent.ListenableFuture[]");
    }

    public static <V> ListenableFuture<V> m() {
        ImmediateFuture.ImmediateCancelledFuture<Object> immediateCancelledFuture = ImmediateFuture.ImmediateCancelledFuture.b3;
        return immediateCancelledFuture != null ? immediateCancelledFuture : new ImmediateFuture.ImmediateCancelledFuture();
    }

    public static <V> ListenableFuture<V> n(Throwable th) {
        Preconditions.E(th);
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    public static <V> ListenableFuture<V> o(@ParametricNullness V v) {
        return v == null ? ImmediateFuture.X : new ImmediateFuture(v);
    }

    public static ListenableFuture<Void> p() {
        return ImmediateFuture.X;
    }

    public static <T> ImmutableList<ListenableFuture<T>> q(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        ListenableFuture[] l2 = l(iterable);
        InCompletionOrderState inCompletionOrderState = new InCompletionOrderState(l2);
        ImmutableList.Builder t = ImmutableList.t(l2.length);
        for (int i2 = 0; i2 < l2.length; i2++) {
            t.g(new InCompletionOrderFuture(inCompletionOrderState));
        }
        ImmutableList<ListenableFuture<T>> n2 = t.e();
        for (int i3 = 0; i3 < l2.length; i3++) {
            l2[i3].a0(new t(inCompletionOrderState, n2, i3), MoreExecutors.c());
        }
        return n2;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <I, O> Future<O> t(final Future<I> future, final Function<? super I, ? extends O> function) {
        Preconditions.E(future);
        Preconditions.E(function);
        return new Future<O>() {
            private O a(I i2) throws ExecutionException {
                try {
                    return function.apply(i2);
                } catch (Error | RuntimeException e2) {
                    throw new ExecutionException(e2);
                }
            }

            public boolean cancel(boolean z) {
                return future.cancel(z);
            }

            public O get() throws InterruptedException, ExecutionException {
                return a(future.get());
            }

            public boolean isCancelled() {
                return future.isCancelled();
            }

            public boolean isDone() {
                return future.isDone();
            }

            public O get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                return a(future.get(j2, timeUnit));
            }
        };
    }

    public static <V> ListenableFuture<V> u(ListenableFuture<V> listenableFuture) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        NonCancellationPropagatingFuture nonCancellationPropagatingFuture = new NonCancellationPropagatingFuture(listenableFuture);
        listenableFuture.a0(nonCancellationPropagatingFuture, MoreExecutors.c());
        return nonCancellationPropagatingFuture;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <O> ListenableFuture<O> v(AsyncCallable<O> asyncCallable, long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TrustedListenableFutureTask<O> N = TrustedListenableFutureTask.N(asyncCallable);
        N.a0(new u(scheduledExecutorService.schedule(N, j2, timeUnit)), MoreExecutors.c());
        return N;
    }

    public static ListenableFuture<Void> w(Runnable runnable, Executor executor) {
        TrustedListenableFutureTask O = TrustedListenableFutureTask.O(runnable, null);
        executor.execute(O);
        return O;
    }

    public static <O> ListenableFuture<O> x(Callable<O> callable, Executor executor) {
        TrustedListenableFutureTask<O> P = TrustedListenableFutureTask.P(callable);
        executor.execute(P);
        return P;
    }

    public static <O> ListenableFuture<O> y(AsyncCallable<O> asyncCallable, Executor executor) {
        TrustedListenableFutureTask<O> N = TrustedListenableFutureTask.N(asyncCallable);
        executor.execute(N);
        return N;
    }

    public static <V> ListenableFuture<List<V>> z(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.ListFuture(ImmutableList.z(iterable), false);
    }
}
