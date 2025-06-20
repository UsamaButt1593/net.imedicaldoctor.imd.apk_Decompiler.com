package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.Graphs;

public final /* synthetic */ class l implements Function {
    public final /* synthetic */ Graphs.TransposedGraph.AnonymousClass1 s;

    public /* synthetic */ l(Graphs.TransposedGraph.AnonymousClass1 r1) {
        this.s = r1;
    }

    public final Object apply(Object obj) {
        return this.s.c((EndpointPair) obj);
    }
}
