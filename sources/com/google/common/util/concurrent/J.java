package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

public final /* synthetic */ class J implements Runnable {
    public final /* synthetic */ Callable s;

    public /* synthetic */ J(Callable callable) {
        this.s = callable;
    }

    public final void run() {
        WrappingExecutorService.b(this.s);
    }
}
