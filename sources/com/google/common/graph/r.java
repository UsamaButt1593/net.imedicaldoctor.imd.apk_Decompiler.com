package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class r implements Function {
    public final /* synthetic */ Object s;

    public /* synthetic */ r(Object obj) {
        this.s = obj;
    }

    public final Object apply(Object obj) {
        return EndpointPair.q(this.s, obj);
    }
}
