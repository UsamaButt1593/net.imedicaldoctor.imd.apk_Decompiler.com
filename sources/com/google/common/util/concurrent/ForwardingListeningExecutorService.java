package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.concurrent.Callable;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public abstract class ForwardingListeningExecutorService extends ForwardingExecutorService implements ListeningExecutorService {
    protected ForwardingListeningExecutorService() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: f1 */
    public abstract ListeningExecutorService a1();

    public ListenableFuture<?> submit(Runnable runnable) {
        return a1().submit(runnable);
    }

    public <T> ListenableFuture<T> submit(Runnable runnable, @ParametricNullness T t) {
        return a1().submit(runnable, t);
    }

    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        return a1().submit(callable);
    }
}
