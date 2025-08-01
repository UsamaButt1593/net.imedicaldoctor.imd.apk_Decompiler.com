package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@ElementTypesAreNonnullByDefault
@DoNotMock("Use the methods in Futures (like immediateFuture) or SettableFuture")
public interface ListenableFuture<V> extends Future<V> {
    void a0(Runnable runnable, Executor executor);
}
