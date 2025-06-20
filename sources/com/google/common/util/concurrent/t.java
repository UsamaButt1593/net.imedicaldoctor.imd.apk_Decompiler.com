package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;

public final /* synthetic */ class t implements Runnable {
    public final /* synthetic */ ImmutableList X;
    public final /* synthetic */ int Y;
    public final /* synthetic */ Futures.InCompletionOrderState s;

    public /* synthetic */ t(Futures.InCompletionOrderState inCompletionOrderState, ImmutableList immutableList, int i2) {
        this.s = inCompletionOrderState;
        this.X = immutableList;
        this.Y = i2;
    }

    public final void run() {
        this.s.f(this.X, this.Y);
    }
}
