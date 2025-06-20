package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {

    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {
        private final ListenableFuture<V> s;

        protected SimpleForwardingListenableFuture(ListenableFuture<V> listenableFuture) {
            this.s = (ListenableFuture) Preconditions.E(listenableFuture);
        }

        /* access modifiers changed from: protected */
        /* renamed from: f1 */
        public final ListenableFuture<V> a1() {
            return this.s;
        }
    }

    protected ForwardingListenableFuture() {
    }

    public void a0(Runnable runnable, Executor executor) {
        a1().a0(runnable, executor);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f1 */
    public abstract ListenableFuture<? extends V> a1();
}
