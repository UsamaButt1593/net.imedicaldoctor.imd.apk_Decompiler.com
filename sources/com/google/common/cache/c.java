package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ Object X;
    public final /* synthetic */ ListenableFuture X2;
    public final /* synthetic */ int Y;
    public final /* synthetic */ LocalCache.LoadingValueReference Z;
    public final /* synthetic */ LocalCache.Segment s;

    public /* synthetic */ c(LocalCache.Segment segment, Object obj, int i2, LocalCache.LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) {
        this.s = segment;
        this.X = obj;
        this.Y = i2;
        this.Z = loadingValueReference;
        this.X2 = listenableFuture;
    }

    public final void run() {
        this.s.B(this.X, this.Y, this.Z, this.X2);
    }
}
