package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class f implements Function {
    public final /* synthetic */ ValueGraph s;

    public /* synthetic */ f(ValueGraph valueGraph) {
        this.s = valueGraph;
    }

    public final Object apply(Object obj) {
        return AbstractValueGraph.S(this.s, (EndpointPair) obj);
    }
}
