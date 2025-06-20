package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;

public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ ImmutableCollection X;
    public final /* synthetic */ AggregateFuture s;

    public /* synthetic */ l(AggregateFuture aggregateFuture, ImmutableCollection immutableCollection) {
        this.s = aggregateFuture;
        this.X = immutableCollection;
    }

    public final void run() {
        this.s.W(this.X);
    }
}
