package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    private SettableFuture() {
    }

    public static <V> SettableFuture<V> F() {
        return new SettableFuture<>();
    }

    @CanIgnoreReturnValue
    public boolean B(@ParametricNullness V v) {
        return super.B(v);
    }

    @CanIgnoreReturnValue
    public boolean C(Throwable th) {
        return super.C(th);
    }

    @CanIgnoreReturnValue
    public boolean D(ListenableFuture<? extends V> listenableFuture) {
        return super.D(listenableFuture);
    }
}
