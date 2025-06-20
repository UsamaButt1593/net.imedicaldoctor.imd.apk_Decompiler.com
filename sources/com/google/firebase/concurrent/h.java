package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ DelegatingScheduledFuture.Completer X;
    public final /* synthetic */ Runnable s;

    public /* synthetic */ h(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.s = runnable;
        this.X = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.n(this.s, this.X);
    }
}
