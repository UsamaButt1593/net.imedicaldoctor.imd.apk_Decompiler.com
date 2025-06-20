package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class l implements Callable {
    public final /* synthetic */ Callable X;
    public final /* synthetic */ DelegatingScheduledFuture.Completer Y;
    public final /* synthetic */ DelegatingScheduledExecutorService s;

    public /* synthetic */ l(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.s = delegatingScheduledExecutorService;
        this.X = callable;
        this.Y = completer;
    }

    public final Object call() {
        return this.s.r(this.X, this.Y);
    }
}
