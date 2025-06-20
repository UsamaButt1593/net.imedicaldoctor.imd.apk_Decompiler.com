package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class y implements Callable {
    public final /* synthetic */ Runnable s;

    public /* synthetic */ y(Runnable runnable) {
        this.s = runnable;
    }

    public final Object call() {
        return this.s.run();
    }
}
