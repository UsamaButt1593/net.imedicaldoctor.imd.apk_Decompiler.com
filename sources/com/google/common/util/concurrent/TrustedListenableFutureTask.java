package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {
    @CheckForNull
    private volatile InterruptibleTask<?> b3;

    private final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> Z;

        TrustedFutureInterruptibleAsyncTask(AsyncCallable<V> asyncCallable) {
            this.Z = (AsyncCallable) Preconditions.E(asyncCallable);
        }

        /* access modifiers changed from: package-private */
        public void a(Throwable th) {
            TrustedListenableFutureTask.this.C(th);
        }

        /* access modifiers changed from: package-private */
        public final boolean d() {
            return TrustedListenableFutureTask.this.isDone();
        }

        /* access modifiers changed from: package-private */
        public String f() {
            return this.Z.toString();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public void b(ListenableFuture<V> listenableFuture) {
            TrustedListenableFutureTask.this.D(listenableFuture);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public ListenableFuture<V> e() throws Exception {
            return (ListenableFuture) Preconditions.V(this.Z.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.Z);
        }
    }

    private final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> Z;

        TrustedFutureInterruptibleTask(Callable<V> callable) {
            this.Z = (Callable) Preconditions.E(callable);
        }

        /* access modifiers changed from: package-private */
        public void a(Throwable th) {
            TrustedListenableFutureTask.this.C(th);
        }

        /* access modifiers changed from: package-private */
        public void b(@ParametricNullness V v) {
            TrustedListenableFutureTask.this.B(v);
        }

        /* access modifiers changed from: package-private */
        public final boolean d() {
            return TrustedListenableFutureTask.this.isDone();
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public V e() throws Exception {
            return this.Z.call();
        }

        /* access modifiers changed from: package-private */
        public String f() {
            return this.Z.toString();
        }
    }

    TrustedListenableFutureTask(AsyncCallable<V> asyncCallable) {
        this.b3 = new TrustedFutureInterruptibleAsyncTask(asyncCallable);
    }

    static <V> TrustedListenableFutureTask<V> N(AsyncCallable<V> asyncCallable) {
        return new TrustedListenableFutureTask<>(asyncCallable);
    }

    static <V> TrustedListenableFutureTask<V> O(Runnable runnable, @ParametricNullness V v) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, v));
    }

    static <V> TrustedListenableFutureTask<V> P(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    /* access modifiers changed from: protected */
    public void m() {
        InterruptibleTask<?> interruptibleTask;
        super.m();
        if (E() && (interruptibleTask = this.b3) != null) {
            interruptibleTask.c();
        }
        this.b3 = null;
    }

    public void run() {
        InterruptibleTask<?> interruptibleTask = this.b3;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.b3 = null;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public String y() {
        InterruptibleTask<?> interruptibleTask = this.b3;
        if (interruptibleTask == null) {
            return super.y();
        }
        return "task=[" + interruptibleTask + "]";
    }

    TrustedListenableFutureTask(Callable<V> callable) {
        this.b3 = new TrustedFutureInterruptibleTask(callable);
    }
}
