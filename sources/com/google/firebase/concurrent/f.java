package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ Runnable X;
    public final /* synthetic */ DelegatingScheduledFuture.Completer Y;
    public final /* synthetic */ DelegatingScheduledExecutorService s;

    public /* synthetic */ f(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.s = delegatingScheduledExecutorService;
        this.X = runnable;
        this.Y = completer;
    }

    public final void run() {
        this.s.o(this.X, this.Y);
    }
}
