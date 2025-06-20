package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@CheckReturnValue
@J2ktIncompatible
public abstract class AbstractListeningExecutorService extends AbstractExecutorService implements ListeningExecutorService {
    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, @ParametricNullness T t) {
        return TrustedListenableFutureTask.O(runnable, t);
    }

    @CanIgnoreReturnValue
    public ListenableFuture<?> submit(Runnable runnable) {
        return (ListenableFuture) super.submit(runnable);
    }

    /* access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return TrustedListenableFutureTask.P(callable);
    }

    @CanIgnoreReturnValue
    public <T> ListenableFuture<T> submit(Runnable runnable, @ParametricNullness T t) {
        return (ListenableFuture) super.submit(runnable, t);
    }

    @CanIgnoreReturnValue
    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        return (ListenableFuture) super.submit(callable);
    }
}
