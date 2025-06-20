package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class p implements Function {
    public final /* synthetic */ Object X;
    public final /* synthetic */ ValueGraph s;

    public /* synthetic */ p(ValueGraph valueGraph, Object obj) {
        this.s = valueGraph;
        this.X = obj;
    }

    public final Object apply(Object obj) {
        return ImmutableValueGraph.d0(this.s, this.X, obj);
    }
}
