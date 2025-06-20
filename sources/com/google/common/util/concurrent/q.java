package com.google.common.util.concurrent;

import java.io.Closeable;

public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ Closeable s;

    public /* synthetic */ q(Closeable closeable) {
        this.s = closeable;
    }

    public final void run() {
        ClosingFuture.x(this.s);
    }
}
