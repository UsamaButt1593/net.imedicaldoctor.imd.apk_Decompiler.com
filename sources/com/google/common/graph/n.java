package com.google.common.graph;

import com.google.common.base.Function;

public final /* synthetic */ class n implements Function {
    public final /* synthetic */ Object X;
    public final /* synthetic */ Network s;

    public /* synthetic */ n(Network network, Object obj) {
        this.s = network;
        this.X = obj;
    }

    public final Object apply(Object obj) {
        return this.s.B(obj).b(this.X);
    }
}
