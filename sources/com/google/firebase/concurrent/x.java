package com.google.firebase.concurrent;

public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ Runnable X;
    public final /* synthetic */ LimitedConcurrencyExecutor s;

    public /* synthetic */ x(LimitedConcurrencyExecutor limitedConcurrencyExecutor, Runnable runnable) {
        this.s = limitedConcurrencyExecutor;
        this.X = runnable;
    }

    public final void run() {
        this.s.c(this.X);
    }
}
