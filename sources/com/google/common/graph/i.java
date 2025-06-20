package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class i implements Function {
    public final /* synthetic */ Object s;

    public /* synthetic */ i(Object obj) {
        this.s = obj;
    }

    public final Object apply(Object obj) {
        return EndpointPair.m(this.s, obj);
    }
}
