package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class CombinedFuture<V> extends AggregateFuture<Object, V> {
    /* access modifiers changed from: private */
    @CheckForNull
    public CombinedFuture<V>.CombinedFutureInterruptibleTask<?> j3;

    private final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> Y2;

        AsyncCallableInterruptibleTask(AsyncCallable<V> asyncCallable, Executor executor) {
            super(executor);
            this.Y2 = (AsyncCallable) Preconditions.E(asyncCallable);
        }

        /* access modifiers changed from: package-private */
        public String f() {
            return this.Y2.toString();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public ListenableFuture<V> e() throws Exception {
            return (ListenableFuture) Preconditions.V(this.Y2.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.Y2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void i(ListenableFuture<V> listenableFuture) {
            CombinedFuture.this.D(listenableFuture);
        }
    }

    private final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> Y2;

        CallableInterruptibleTask(Callable<V> callable, Executor executor) {
            super(executor);
            this.Y2 = (Callable) Preconditions.E(callable);
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public V e() throws Exception {
            return this.Y2.call();
        }

        /* access modifiers changed from: package-private */
        public String f() {
            return this.Y2.toString();
        }

        /* access modifiers changed from: package-private */
        public void i(@ParametricNullness V v) {
            CombinedFuture.this.B(v);
        }
    }

    private abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor Z;

        CombinedFutureInterruptibleTask(Executor executor) {
            this.Z = (Executor) Preconditions.E(executor);
        }

        /* access modifiers changed from: package-private */
        public final void a(Throwable th) {
            CombinedFuture combinedFuture;
            CombinedFutureInterruptibleTask unused = CombinedFuture.this.j3 = null;
            if (th instanceof ExecutionException) {
                combinedFuture = CombinedFuture.this;
                th = ((ExecutionException) th).getCause();
            } else if (th instanceof CancellationException) {
                CombinedFuture.this.cancel(false);
                return;
            } else {
                combinedFuture = CombinedFuture.this;
            }
            combinedFuture.C(th);
        }

        /* access modifiers changed from: package-private */
        public final void b(@ParametricNullness T t) {
            CombinedFutureInterruptibleTask unused = CombinedFuture.this.j3 = null;
            i(t);
        }

        /* access modifiers changed from: package-private */
        public final boolean d() {
            return CombinedFuture.this.isDone();
        }

        /* access modifiers changed from: package-private */
        public final void h() {
            try {
                this.Z.execute(this);
            } catch (RejectedExecutionException e2) {
                CombinedFuture.this.C(e2);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void i(@ParametricNullness T t);
    }

    CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z, Executor executor, AsyncCallable<V> asyncCallable) {
        super(immutableCollection, z, false);
        this.j3 = new AsyncCallableInterruptibleTask(asyncCallable, executor);
        U();
    }

    /* access modifiers changed from: package-private */
    public void P(int i2, @CheckForNull Object obj) {
    }

    /* access modifiers changed from: package-private */
    public void S() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.j3;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.h();
        }
    }

    /* access modifiers changed from: package-private */
    public void Z(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.Z(releaseResourcesReason);
        if (releaseResourcesReason == AggregateFuture.ReleaseResourcesReason.OUTPUT_FUTURE_DONE) {
            this.j3 = null;
        }
    }

    /* access modifiers changed from: protected */
    public void w() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.j3;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.c();
        }
    }

    CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z, Executor executor, Callable<V> callable) {
        super(immutableCollection, z, false);
        this.j3 = new CallableInterruptibleTask(callable, executor);
        U();
    }
}
