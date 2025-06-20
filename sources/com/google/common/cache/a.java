package com.google.common.cache;

import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {
    public final /* synthetic */ Object X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ CacheLoader s;

    public /* synthetic */ a(CacheLoader cacheLoader, Object obj, Object obj2) {
        this.s = cacheLoader;
        this.X = obj;
        this.Y = obj2;
    }

    public final Object call() {
        return this.s.f(this.X, this.Y).get();
    }
}
