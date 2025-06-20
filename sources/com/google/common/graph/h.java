package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class h implements Function {
    public final /* synthetic */ Object s;

    public /* synthetic */ h(Object obj) {
        this.s = obj;
    }

    public final Object apply(Object obj) {
        return EndpointPair.m(obj, this.s);
    }
}
