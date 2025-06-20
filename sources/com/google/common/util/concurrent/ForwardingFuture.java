package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingFuture<V> extends ForwardingObject implements Future<V> {

    public static abstract class SimpleForwardingFuture<V> extends ForwardingFuture<V> {
        private final Future<V> s;

        protected SimpleForwardingFuture(Future<V> future) {
            this.s = (Future) Preconditions.E(future);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public final Future<V> Z0() {
            return this.s;
        }
    }

    protected ForwardingFuture() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public abstract Future<? extends V> Z0();

    @CanIgnoreReturnValue
    public boolean cancel(boolean z) {
        return Z0().cancel(z);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public V get() throws InterruptedException, ExecutionException {
        return Z0().get();
    }

    public boolean isCancelled() {
        return Z0().isCancelled();
    }

    public boolean isDone() {
        return Z0().isDone();
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return Z0().get(j2, timeUnit);
    }
}
