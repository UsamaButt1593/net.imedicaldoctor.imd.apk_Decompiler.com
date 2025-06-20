package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class JdkFutureAdapters {

    private static class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
        private static final ThreadFactory X2;
        private static final Executor Y2;
        private final ExecutionList X;
        private final AtomicBoolean Y;
        private final Future<V> Z;
        private final Executor s;

        static {
            ThreadFactory b2 = new ThreadFactoryBuilder().e(true).f("ListenableFutureAdapter-thread-%d").b();
            X2 = b2;
            Y2 = Executors.newCachedThreadPool(b2);
        }

        ListenableFutureAdapter(Future<V> future) {
            this(future, Y2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i1() {
            try {
                Uninterruptibles.f(this.Z);
            } catch (Error | RuntimeException | ExecutionException unused) {
            }
            this.X.b();
        }

        public void a0(Runnable runnable, Executor executor) {
            this.X.a(runnable, executor);
            if (!this.Y.compareAndSet(false, true)) {
                return;
            }
            if (this.Z.isDone()) {
                this.X.b();
            } else {
                this.s.execute(new y(this));
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Future<V> Z0() {
            return this.Z;
        }

        ListenableFutureAdapter(Future<V> future, Executor executor) {
            this.X = new ExecutionList();
            this.Y = new AtomicBoolean(false);
            this.Z = (Future) Preconditions.E(future);
            this.s = (Executor) Preconditions.E(executor);
        }
    }

    private JdkFutureAdapters() {
    }

    public static <V> ListenableFuture<V> a(Future<V> future) {
        return future instanceof ListenableFuture ? (ListenableFuture) future : new ListenableFutureAdapter(future);
    }

    public static <V> ListenableFuture<V> b(Future<V> future, Executor executor) {
        Preconditions.E(executor);
        return future instanceof ListenableFuture ? (ListenableFuture) future : new ListenableFutureAdapter(future, executor);
    }
}
