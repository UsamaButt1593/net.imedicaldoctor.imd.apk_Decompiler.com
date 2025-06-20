package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;

public final /* synthetic */ class h implements Function {
    public final /* synthetic */ Multimaps.AsMap.EntrySet s;

    public /* synthetic */ h(Multimaps.AsMap.EntrySet entrySet) {
        this.s = entrySet;
    }

    public final Object apply(Object obj) {
        return this.s.k(obj);
    }
}
