package com.google.common.util.concurrent;

import com.google.common.util.concurrent.JdkFutureAdapters;

public final /* synthetic */ class y implements Runnable {
    public final /* synthetic */ JdkFutureAdapters.ListenableFutureAdapter s;

    public /* synthetic */ y(JdkFutureAdapters.ListenableFutureAdapter listenableFutureAdapter) {
        this.s = listenableFutureAdapter;
    }

    public final void run() {
        this.s.i1();
    }
}
