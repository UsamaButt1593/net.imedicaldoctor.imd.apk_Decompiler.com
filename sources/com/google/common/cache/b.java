package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.cache.LocalCache;

public final /* synthetic */ class b implements Function {
    public final /* synthetic */ LocalCache.LoadingValueReference s;

    public /* synthetic */ b(LocalCache.LoadingValueReference loadingValueReference) {
        this.s = loadingValueReference;
    }

    public final Object apply(Object obj) {
        return this.s.l(obj);
    }
}
