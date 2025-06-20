package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.DirectedGraphConnections;

public final /* synthetic */ class j implements Function {
    public final /* synthetic */ Object s;

    public /* synthetic */ j(Object obj) {
        this.s = obj;
    }

    public final Object apply(Object obj) {
        return DirectedGraphConnections.w(this.s, (DirectedGraphConnections.NodeConnection) obj);
    }
}
