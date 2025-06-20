package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
class ImmediateFuture<V> implements ListenableFuture<V> {
    static final ListenableFuture<?> X = new ImmediateFuture((Object) null);
    private static final Logger Y = Logger.getLogger(ImmediateFuture.class.getName());
    @ParametricNullness
    private final V s;

    static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {
        @CheckForNull
        static final ImmediateCancelledFuture<Object> b3 = (AbstractFuture.Z ? null : new ImmediateCancelledFuture<>());

        ImmediateCancelledFuture() {
            cancel(false);
        }
    }

    static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
        ImmediateFailedFuture(Throwable th) {
            C(th);
        }
    }

    ImmediateFuture(@ParametricNullness V v) {
        this.s = v;
    }

    public void a0(Runnable runnable, Executor executor) {
        Preconditions.F(runnable, "Runnable was null.");
        Preconditions.F(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = Y;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    public boolean cancel(boolean z) {
        return false;
    }

    @ParametricNullness
    public V get() {
        return this.s;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + this.s + "]]";
    }

    @ParametricNullness
    public V get(long j2, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.E(timeUnit);
        return get();
    }
}
