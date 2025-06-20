package com.google.common.util.concurrent;

import java.util.concurrent.Future;

public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ Future s;

    public /* synthetic */ u(Future future) {
        this.s = future;
    }

    public final void run() {
        this.s.cancel(false);
    }
}
