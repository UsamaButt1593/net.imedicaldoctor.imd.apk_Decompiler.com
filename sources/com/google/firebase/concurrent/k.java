package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ DelegatingScheduledFuture.Completer X;
    public final /* synthetic */ Callable s;

    public /* synthetic */ k(Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.s = callable;
        this.X = completer;
    }

    public final void run() {
        DelegatingScheduledExecutorService.q(this.s, this.X);
    }
}
