package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ Runnable X;
    public final /* synthetic */ Supplier s;

    public /* synthetic */ p(Supplier supplier, Runnable runnable) {
        this.s = supplier;
        this.X = runnable;
    }

    public final void run() {
        Callables.i(this.s, this.X);
    }
}
