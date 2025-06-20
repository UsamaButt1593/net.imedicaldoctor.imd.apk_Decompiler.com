package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ DelegatingScheduledFuture.Completer X;
    public final /* synthetic */ Runnable s;

    public /* synthetic */ m(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.s = runnable;
        this.X = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.t(this.s, this.X);
    }
}
