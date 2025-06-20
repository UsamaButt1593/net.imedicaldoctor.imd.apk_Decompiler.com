package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class RemovalListeners {
    private RemovalListeners() {
    }

    public static <K, V> RemovalListener<K, V> c(RemovalListener<K, V> removalListener, Executor executor) {
        Preconditions.E(removalListener);
        Preconditions.E(executor);
        return new e(executor, removalListener);
    }
}
