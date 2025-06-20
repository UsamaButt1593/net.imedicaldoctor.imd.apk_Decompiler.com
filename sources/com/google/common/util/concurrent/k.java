package com.google.common.util.concurrent;

public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ ListenableFuture X;
    public final /* synthetic */ int Y;
    public final /* synthetic */ AggregateFuture s;

    public /* synthetic */ k(AggregateFuture aggregateFuture, ListenableFuture listenableFuture, int i2) {
        this.s = aggregateFuture;
        this.X = listenableFuture;
        this.Y = i2;
    }

    public final void run() {
        this.s.V(this.X, this.Y);
    }
}
